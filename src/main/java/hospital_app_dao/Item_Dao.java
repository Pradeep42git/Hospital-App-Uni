package hospital_app_dao;

import java.util.ArrayList;
import java.util.List;

import hospital_app_dto.Item;

public class Item_Dao {
	public Item saveItem() {
		Item item=new Item();
		System.out.println("Enter the new Item ID");
		item.setId(Hospital_Dao.scanner.nextInt());
		System.out.println("Enter Medcine1 ");
		item.setItem1(Hospital_Dao.scanner.next());
		System.out.println("Enter Medcine2 ");
		item.setItem2(Hospital_Dao.scanner.next());
		System.out.println("Enter Medcine3 ");
		item.setItem3(Hospital_Dao.scanner.next());
		System.out.println("Enter Medcine4 ");
		item.setItem4(Hospital_Dao.scanner.next());
		
		Hospital_Dao.entityTransaction.begin();
		Hospital_Dao.entityManager.persist(item);
		Hospital_Dao.entityTransaction.commit();
		System.out.println("Orders saved Successfully");
		return item;
		
	}
	public void updateItem() {
		System.out.println("Enter the Item ID you want to Update");
		Item item=Hospital_Dao.entityManager.find(Item.class, Hospital_Dao.scanner.nextInt());
		if(!(item==null)) {
		System.out.println("Enter the new Medicine");
		item.setItem1(Hospital_Dao.scanner.next());
		
		Hospital_Dao.entityTransaction.begin();
		Hospital_Dao.entityManager.merge(item);
		Hospital_Dao.entityTransaction.commit();
		}else {
			System.out.println("No item ID found");
		}
		
	}

}
