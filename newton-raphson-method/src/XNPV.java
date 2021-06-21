package src;

import java.util.List;

/*
 *  XIRRNPV.java
 *  Copyright (C) 2005 Gautam Satpathy
 *  gautam@satpathy.in
 *  www.satpathy.in
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

public class XNPV implements NewtonFunction{

	public NewtonStatus xnpv(double rate, Object userData){
		DataSet data;
		List<Double> values;
		List<Double> dates;
		double sum;
		int arrSize;
	
		if(Util.DEBUG_GOAL_SEEK){
			Util.log(">>>>>>>>>>>>>>>>>> XNPV START <<<<<<<<<<<<<<<<<<");
			//Util.log()
		}

		data = (DataSet)userData;
		values = data.getValues();
		dates = data.getDates();
		arrSize = data.getArrSize();
		sum = 0;

		for (int i = 0; i < arrSize; i++){
			double diff = dates.get(i) - dates.get(0);
			if ( diff < 0){
				return new NewtonStatus(NewtonStatus.GOAL_SEEK_ERROR, null);
			}
			sum += values.get(i) / Math.pow(1 + rate, diff / 365.0);

			Util.log("dates.get(i) : " + dates.get(i) + " dates.get(0) : " + dates.get(0) + " sum : " + sum);
		}

		if(Util.DEBUG_GOAL_SEEK){
			Util.log(">>>>>>>>>>>>>> XNPV value : " + sum);
			Util.log(">>>>>>>>>>>>>>>>>> XNPV end <<<<<<<<<<<<<<<<<<");
		}
		
		return new NewtonStatus(NewtonStatus.GOAL_SEEK_OK, sum);
	}
}
