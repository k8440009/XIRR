package src2;

import src2.data.*;

public class XIRR {
	public double calculate(DataSet dataSet){
        NewtonStatus status;
        XNPV xnpv = new XNPV();
        
        status = xnpv.xnpv(0.1, dataSet);
        return (double)status.getReturnData();
		// 뉴턴에 필요한 데이터셋 초기화
	}	
}
