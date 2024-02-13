package hospital_controller;

import hospital_app_dao.*;

public class Helper {
	
		static Address_Dao address_Dao= new Address_Dao();
		static Branch_Dao branch_Dao= new Branch_Dao();
		static Encounter_Dao encounter_Dao= new Encounter_Dao();
		static Hospital_Dao hospital_Dao= new Hospital_Dao();
		static Item_Dao item_Dao= new Item_Dao();
		static MedOrders_Dao medOrders_Dao= new MedOrders_Dao();
		static Person_Dao person_Dao= new Person_Dao();
	

	public static int choice() {
		System.out.println("Press 1 : Add Branch");
		System.out.println("Press 2 : Update Branch");
		System.out.println("Press 3 : Update Address");
		System.out.println("Press 4 : Add Person");
		System.out.println("Press 5 : Update Person");
		System.out.println("Press 6 : Add Encounter");
		System.out.println("Press 7 : Add MedOrders");
		System.out.println("Press 8 : Update MedOrders");
		System.out.println("Press 9 : Add Items");
		System.out.println("Press 10 : Update Items");
		System.out.println("Press 11 : Update Encounter");
		System.out.println("Press 12 : Exit");
		return Hospital_Dao.scanner.nextInt();
	}

	public static void defaultCase() {
		System.out.println("Invalid Input Try Again");
	}

}
