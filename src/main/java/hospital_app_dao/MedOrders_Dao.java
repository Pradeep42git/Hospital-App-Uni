package hospital_app_dao;

import java.util.ArrayList;
import java.util.List;

import hospital_app_dto.Encounter;
import hospital_app_dto.Item;
import hospital_app_dto.MedOrders;

public class MedOrders_Dao {
	public MedOrders saveMedorders() {
		MedOrders medOrders=null;
		Item_Dao item=new Item_Dao();
		System.out.println("Enter the Encounter ID you want to save MedOrder info");
		Encounter encounter= Hospital_Dao.entityManager.find(Encounter.class,Hospital_Dao.scanner.nextInt() );
		if(!(encounter==null)) {
		medOrders= new MedOrders();
		System.out.println("ENter the ID");
		medOrders.setId( Hospital_Dao.scanner.nextInt());
		System.out.println("Enter the Bill");
		medOrders.setBill(Hospital_Dao.scanner.nextDouble());
		List<MedOrders>list=encounter.getMedOrders();
		list.add(medOrders);
		encounter.setMedOrders(list);
		Hospital_Dao.entityTransaction.begin();
		Hospital_Dao.entityManager.persist(medOrders);
		Hospital_Dao.entityManager.merge(encounter);
		Hospital_Dao.entityTransaction.commit();
		System.out.println("Orders saved Successfully");
		}else {
			System.out.println("No Encounter Id is present");
		}
		return medOrders;
	}
	public void updateOrders() {
		System.out.println("Enter the MedOrder ID");
		MedOrders medOrders= Hospital_Dao.entityManager.find(MedOrders.class,Hospital_Dao.scanner.nextInt() );
		if(!(medOrders==null)) {
			System.out.println("Enter Your New Bill ");
			medOrders.setBill(Hospital_Dao.scanner.nextDouble());
			Hospital_Dao.entityTransaction.begin();
			Hospital_Dao.entityManager.merge(medOrders);
			Hospital_Dao.entityTransaction.commit();
			System.out.println("Updated successfully");
		}else {
			System.out.println("No ID found");
		}
		
	}

}
