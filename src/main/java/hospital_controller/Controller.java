package hospital_controller;

import hospital_app_dao.Hospital_Dao;
import hospital_app_dto.*;

public class Controller {
	static {
		Hospital hospital=Hospital_Dao.entityManager.find(Hospital.class, 1);
		if(hospital==null) {
			Hospital_Dao.createHospital();
		}
	}
	
	public static void main(String[] args) {
		while(true) {
			switch(Helper.choice()) {
			case 1:{
				Helper.branch_Dao.createBranch();
				break;
			}
			case 2:{
				Helper.branch_Dao.updateBranch();
				break;
			}
			case 3:{
				Helper.address_Dao.updateAddress();
				break;
			}
			case 4:{
				Helper.person_Dao.savePerson();
				break;
			}
			case 5:{
				Helper.person_Dao.updatePerson();
				break;
			}
			case 6:{
				Helper.encounter_Dao.addEncounter();
				break;
			}
			case 7:{
				Helper.medOrders_Dao.saveMedorders();
				break;
			}
			case 8:{
				Helper.medOrders_Dao.updateOrders();
				break;
			}
			case 9:{
				Helper.item_Dao.saveItem();
				break;
			}
			case 10:{
				Helper.item_Dao.updateItem();
				break;
			}
			case 11:{
				Helper.encounter_Dao.updateEncounter();
				break;
			}
			case 12:{return;}
			default:Helper.defaultCase();
			}
		}
	}

}
