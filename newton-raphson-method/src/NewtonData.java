package src;


public class NewtonData {
	private double xmin;
	private double xmax;
	private double precision;

	private boolean haveXpos;
	private double xpos;
	private double ypos;
	
	private boolean haveXneg;
	private double xneg;
	private double yneg;
	
	private boolean haveRoot;
	private double root;
	
	public double getXmin() {
		return this.xmin;
	}
	
	public void setXmin(double xmin) {
		this.xmin = xmin;
	}
	
	public double getXmax() {
		return this.xmax;
	}
	
	public void setXmax(double xmax) {
		this.xmax = xmax;
	}
	
	public double getPrecision() {
		return this.precision;
	}
	
	public void setPrecision(double precision) {
		this.precision = precision;
	}
	
	public boolean isHaveXpos() {
		return this.haveXpos;
	}

	public void setHaveXpos(boolean haveXpos) {
		this.haveXpos = haveXpos;
	}
	
	public double getXpos() {
		return this.xpos;
	}

	public void setXpos(double xpos) {
		this.xpos = xpos;
	}

	public double getYpos() {
		return this.ypos;
	}

	public void setYpos(double ypos) {
		this.ypos = ypos;
	}

	public boolean isHaveXneg() {
		return this.haveXneg;
	}

	public void setHaveXneg(boolean haveXneg) {
		this.haveXneg = haveXneg;
	}

	public double getXneg() {
		return this.xneg;
	}

	public void setXneg(double xneg) {
		this.xneg = xneg;
	}

	public double getYneg() {
		return this.yneg;
	}

	public void setYneg(double yneg) {
		this.yneg = yneg;
	}

	public boolean isHaveRoot() {
		return this.haveRoot;
	}

	public void setHaveRoot(boolean haveRoot) {
		this.haveRoot = haveRoot;
	}
	
	public double getRoot() {
		return this.root;
	}

	public void setRoot(double root) {
		this.root = root;
	}
}
