package src;

public class NewtonStatus {
	public static final int GOAL_SEEK_OK = 1;
	public static final int GOAL_SEEK_ERROR = 0;

	private int seekStatus;
	private Object returnData;

	public NewtonStatus(int status, Object result){
		this.seekStatus = status;
		this.returnData = result;
	}

	public int getSeekStatus() {
		return this.seekStatus;
	}

	public void setSeekStatus(int seekStatus) {
		this.seekStatus = seekStatus;
	}

	public Object getReturnData() {
		return this.returnData;
	}

	public void setReturnData(Object returnData) {
		this.returnData = returnData;
	}

	public String toString() {
		return "Status - " + this.seekStatus + ", Return Data - " + this.returnData ;
	}
}
