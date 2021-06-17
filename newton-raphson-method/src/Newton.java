package src;

public class Newton {
	public static void initialize(NewtonData data) {

		data.setHaveRoot(false);
		data.setHaveXneg(false);
		data.setHaveXpos(false);

		data.setXpos(Double.NaN);
		data.setXneg(Double.NaN);
		data.setRoot(Double.NaN);

		data.setYpos(Double.NaN);
		data.setYneg(Double.NaN);

		data.setXmin(-1e10);
		data.setXmax(+1e10);
		data.setPrecision(1e-10);
	}

	/**
	 * Seek a goal (root) using Newton's iterative method.
	 *
	 * The supplied function must (should) be continously differentiable in the
	 * supplied interval. If NULL is used for `df', this function will estimate the
	 * derivative.
	 *
	 * This method will find a root rapidly provided the initial guess, x0, is
	 * sufficiently close to the root. (The number of significant digits
	 * (asympotically) goes like i^2 unless the root is a multiple root in which
	 * case it is only like c*i.)
	 */
	/*
	 * derivative : 도함수
	 */
	public static NewtonStatus newtonRaphsonMethod(NewtonFunction curFunction, NewtonFunction derivative, NewtonData data,
			Object userData, double x0) {
		int iterations = 0;
		double precision = data.getPrecision() / 2;

		if (data.isHaveRoot()) {
			return new NewtonStatus(NewtonStatus.GOAL_SEEK_OK, data.getRoot());
		}

		if (Util.DEBUG_GOAL_SEEK) {
			Util.log(">>>>>>>>>>>>>> newtonRapsonMethod start <<<<<<<<<<<<");
		}

		for (iterations = 0; iterations < 20; iterations++) {
			double x1;
			double y0;
			double df0;
			double stepSize;
			NewtonStatus status;

			if (Util.DEBUG_GOAL_SEEK) {
				Util.log("x0 is guess rates");
				Util.log("goalSeekNewton - x0 = " + x0 + ", (iterations = " + iterations + " )");
			}

			if (x0 < data.getXmin() || x0 > data.getXmax()) {
				return new NewtonStatus(NewtonStatus.GOAL_SEEK_ERROR, null);
			}

			if (Util.DEBUG_GOAL_SEEK) {
				Util.log("userData : " + userData);
			}

			status = curFunction.xnpv(x0, userData);
			if (Util.DEBUG_GOAL_SEEK) {
				Util.log("x0 is guess rates");
				Util.log("status = f.f(x0, userData ) : " + status);
			}

			if (status.getSeekStatus() != NewtonStatus.GOAL_SEEK_OK) {
				return status;
			}

			y0 = ((Double) status.getReturnData()).doubleValue();

			if (Util.DEBUG_GOAL_SEEK) {
				Util.log("   y0(XNPV value) = " + y0);
			}

			if (derivative != null) {
				status = derivative.xnpv(x0, userData); // 도함수에 다시 xnpv
			} else {
				double xStep;
				// 1 * 0.000,000,000,1
				if (Math.abs(x0) < 1e-10) {
					if (data.isHaveXneg() && data.isHaveXpos()) {
						xStep = Math.abs(data.getXpos() - data.getXneg()) / 1e6; // 1,000,000
					} else {
						xStep = (data.getXmax() - data.getXmin()) / 1e6;
					}
				} else {
					xStep = Math.abs(x0) / 1e6;
				}

				status = makeDerivative(curFunction, x0, xStep, data, userData);
				if (Util.DEBUG_GOAL_SEEK) {
					Util.log(">>>>>>>>>>>>>>>>>>>> xStep : " + xStep); // // 3.0E-7 -> 3.0 * 10 ^ -7
					Util.log(">>>>>>>>>>>>>>>>> fake_df status: " + status);
				}
			}

			if (status.getSeekStatus() != NewtonStatus.GOAL_SEEK_OK) {
				return status;
			}

			df0 = ((Double) status.getReturnData()).doubleValue();
			if (df0 == 0) {
				return new NewtonStatus(NewtonStatus.GOAL_SEEK_ERROR, null);
			}

			/*
			 * Overshoot slightly to prevent us from staying on just one side of the root.
			 */
			x1 = x0 - 1.000001 * y0 / df0;
			stepSize = Math.abs(x1 - x0) / (Math.abs(x0) + Math.abs(x1));

			if (Util.DEBUG_GOAL_SEEK) {
				Util.log(">>>>>>>>>> x1 = " + x1 + " >>>>>>>>>>> x0 = " + x0 + " >>>>>>>>>>> y0 = " + y0);
				Util.log(">>>>>>>>>> df0 = " + df0);
				Util.log(">>>>>>>>>> stepsize = " + stepSize);
				Util.log(">>>>>>>>>> precision = " + precision);
			}

			x0 = x1;
			if (stepSize < precision) {
				data.setRoot(x0);
				data.setHaveRoot(true);
				return new NewtonStatus(NewtonStatus.GOAL_SEEK_OK, data.getRoot());
			}
		}
		return new NewtonStatus(NewtonStatus.GOAL_SEEK_ERROR, null);
	}

	public static NewtonStatus makeDerivative(NewtonFunction curFunction, double x, double xStep, NewtonData data,
			Object userData) {
		double xl;
		double xr;
		double yl;
		double yr;
		double dfx;
		NewtonStatus status;

		if (Util.DEBUG_GOAL_SEEK) {
			Util.log("fake_df (x = " + x + ", xstep = " + xStep + ")");
		}

		xl = x - xStep;
		if (xl < data.getXmin())
			xl = x;

		xr = x + xStep;
		if (xr > data.getXmax())
			xr = x;

		if (xl == xr) {
			if (Util.DEBUG_GOAL_SEEK) {
				Util.log("==> xl == xr");
			}
			return new NewtonStatus(NewtonStatus.GOAL_SEEK_ERROR, null);
		}

		if (Util.DEBUG_GOAL_SEEK) {
			Util.log("==> xl = " + xl + " ; xr =" + xr);
		}
		status = curFunction.xnpv(xl, userData);
		if (status.getSeekStatus() != NewtonStatus.GOAL_SEEK_OK) {
			if (Util.DEBUG_GOAL_SEEK) {
				Util.log("==> failure at xl\n");
			}
			return status;
		}

		yl = ((Double) status.getReturnData()).doubleValue();

		status = curFunction.xnpv(xr, userData);
		if (status.getSeekStatus() != NewtonStatus.GOAL_SEEK_OK) {
			if (Util.DEBUG_GOAL_SEEK) {
				Util.log("==> failure at xr");
			}
			return status;
		}

		yr = ((Double) status.getReturnData()).doubleValue();
		if (Util.DEBUG_GOAL_SEEK) {
			Util.log("==> yl = " + yl + " ; yr = " + yr);
		}

		dfx = (yr - yl) / (xr - xl);
		if (Util.DEBUG_GOAL_SEEK) {
			Util.log("inclination ==> " + dfx);
		}

		return Double.isInfinite(dfx) ? new NewtonStatus(NewtonStatus.GOAL_SEEK_ERROR, null)
				: new NewtonStatus(NewtonStatus.GOAL_SEEK_OK, dfx);
	}

	public static boolean updateData(double x, double y, NewtonData data) {
		if (y > 0) {
			if (data.isHaveXpos()) {
				if (data.isHaveXneg()) {
					/*
					 * When we have pos and neg, prefer the new point only if it makes the pos-neg
					 * x-internal smaller.
					 */
					if (Math.abs(x - data.getXneg()) < Math.abs(data.getXpos() - data.getXneg())) {
						data.setXpos(x);
						data.setYpos(y);
					}
				} else if (y < data.getYpos()) {
					data.setXpos(x);
					data.setYpos(y);
				}
			} else {
				data.setXpos(x);
				data.setYpos(y);
				data.setHaveXpos(true);
			}
			return false;
		} else if (y < 0) {
			if (data.isHaveXneg()) {
				if (data.isHaveXpos()) {
					if (Math.abs(x - data.getXpos()) < Math.abs(data.getXpos() - data.getXneg())) {
						data.setXneg(x);
						data.setYneg(y);
					}
				} else if (-y < -(data.getYneg())) {
					data.setXneg(x);
					data.setYneg(y);
				}
			} else {
				data.setXneg(x);
				data.setYneg(y);
				data.setHaveXneg(true);
			}
			return false;
		} else {
			data.setHaveRoot(true);
			data.setRoot(x);
			return true;
		}
	}
}
