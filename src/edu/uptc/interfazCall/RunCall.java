package edu.uptc.interfazCall;

import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import edu.uptc.logicCall.Call;
import edu.uptc.logicCall.ETypeCall;
import edu.uptc.logicCall.ManagementCall;

public class RunCall {
	static ManagementCall managementCall = new ManagementCall ();
	static RunCall rc = new RunCall ();

	public static void  main (String [] args){
		rc.mainMenu();
	}
	//		Call callOne = new Call  ((float)5.0,(float)100.0, ETypeCall.NATIONAL);
	//		System.out.println("el costo es:"+callOne.calculateCost());

private void mainMenu () {
	char  option =0;
	String menu = "MENU \n1. ADICIONAR LLAMADA \n2.BUSCAR LLAMADA \n3.CONTAR LLAMADA\n4. CALCULAR TOTAL LLAMADA";
	while (option !=5) {
		String o = JOptionPane.showInputDialog(null, menu);
		option  = o.charAt(0);
		switch (option ) {
		case '1': 
			rc.addCall();
			break;
		case '2':
			rc.find();
			break;
		case '3':
			rc.cont();
			break;
		case '4':
			rc.calculateTotally();
			break;
			
		}
		
	}
	
}

//	private  void mainMenu (){
//		String menu="";
//		int option;
//        do{
//            menu="";
//            menu+="****** Menú ******\n";
//            menu+="1.- ADICIONAR LLAMADA  \n";
//            menu+="2.- BUSCAR LLAMADA  \n";
//            menu+="3.- CONTAR LLAMADA \n";
//            menu+="4.- CALCULAT TOTAL LLAMADA \n";
//            option=Integer.parseInt(JOptionPane.showInputDialog(menu));
//        }while(option!=4);
//        switch (option) {
//		case 1:
//			rc.addCall();
//			break;
//		case 2:
//			rc.find();
//			break;
//		case 3:
//			rc.cont();
//			break;
//		case 4 :
//			rc.calculateTotally();
//			break;
//        }
//	}

private void addCall () {
	float duration = Float.parseFloat(JOptionPane.showInputDialog(null, "duracion de la llamada"));
	String number = JOptionPane.showInputDialog(null, "numero");
	int typeCall = Integer.parseInt(JOptionPane.showInputDialog(null, "TIPO DE LLAMADA\n1.NACIONAL\n2.INTERNACIONAL\n3.LOCAL \n4.MOVIL"));
	ETypeCall eTypeCall = null;
	switch (typeCall) {
	case 1:
		eTypeCall=ETypeCall.NATIONAL;
		break;
	case 2:
		eTypeCall = ETypeCall.INTERNATIONAL;
		break;
	case 3:
		eTypeCall = ETypeCall.LOCAL;
		break;
	case 4: 
		eTypeCall = ETypeCall.MOVIL;
	}
	managementCall.addCall(duration, number, eTypeCall);
}
private void find () {
	String number = JOptionPane.showInputDialog(null,"numero");
	managementCall.find(number);
	for (int i = 0; i < managementCall.find(number).size(); i++) {
		JOptionPane.showConfirmDialog(null, "duracion: "+managementCall.find(number).get(i).getDuration()+"\n TIPO LLAMADA "+ managementCall.find(number).get(i).geteTypeCall());

	}

}
private void cont () {
	float cost =0;
	String number= JOptionPane.showInputDialog(null, "numero");
	for (int i = 0; i < managementCall.find(number).size(); i++) {
		cost +=managementCall.find(number).get(i).calculateCost();


	}
	JOptionPane.showConfirmDialog(null,"al numero"+ number + "le han marcado "+ managementCall.cont(number)+"veces \n valor");
}
private void calculateTotally () {
	JOptionPane.showConfirmDialog(null, "el valor total de todas las llamadas es: "+managementCall.calculateTotally());
}

}


