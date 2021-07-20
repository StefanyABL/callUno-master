package edu.uptc.logicCall;

import java.util.ArrayList;

public class ManagementCall {
	private ArrayList <Call> calls;
	private Call call;
	public ManagementCall(){
		calls = new ArrayList <>();

	}
	public void addCall(float duration , String number, ETypeCall eTypeCall){
		calls.add(new Call (duration, eTypeCall, number));
	}
	public ArrayList<Call> find(String number){
		ArrayList <Call> callNumber = new ArrayList <>();
		for (int i = 0; i < calls.size(); i++) {
			if (number.equals(calls.get(i).getNumber())) {
				callNumber.add(calls.get(i));
			}

		}
		return callNumber;
	}
	public int cont (String number){
		int cont =0;
		for (int i = 0; i < calls.size(); i++) {
			if (number.equals(calls.get(i).getNumber())) {
				cont +=1;

			}
		}
		return cont;
	}
	public float calculateTotally (){
		float totally=0;
		for (int i = 0; i < calls.size(); i++) {
			totally += calls.get(i).calculateCost();
		}
		return totally ;
	}

}
