package edu.uptc.logicCall;

public class Call {
	private float duration;
	//	private float valueMinute 
	public float VALUE_MINUTE= (float)100.0;
	private ETypeCall eTypeCall;
	private String  number; 




	public Call(float duration, ETypeCall eTypeCall, String number) {

		this.duration = duration;
		this.eTypeCall = eTypeCall;
		this.number = number;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	//	public float getValueMinute() {
	//		return valueMinute;
	//	}
	//	public void setValueMinute(float valueMinute) {
	//		this.valueMinute = valueMinute;
	//	}
	//	
	public ETypeCall geteTypeCall() {
		return eTypeCall;
	}

	public void seteTypeCall(ETypeCall eTypeCall) {
		this.eTypeCall = eTypeCall;
	}

	public float calculateCost (){
		//		float cost = duration * valueMinute ;
		float cost =  duration* VALUE_MINUTE;
		switch (eTypeCall){
		case NATIONAL:
			cost = (float) (cost+(cost*0.15));
			break;
		case INTERNATIONAL : 
			cost = (float) (cost+(cost*0.30));
			break;
		case LOCAL:
			cost = (float) (cost+(cost*0.10));
			break;

		case MOVIL:
			cost = (float) (cost+(cost*0.05));
			break;
		}
		return cost;

	}


}
