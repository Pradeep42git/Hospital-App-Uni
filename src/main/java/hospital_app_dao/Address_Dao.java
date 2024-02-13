package hospital_app_dao;

import hospital_app_dto.Branch;
import hospital_app_dto.Item;

public class Address_Dao {
	public void updateAddress() {
		System.out.println("Enter the Branch You want To update");
		Branch branch=Hospital_Dao.entityManager.find(Branch.class, Hospital_Dao.scanner.nextInt());
		if(!(branch==null)) {
			System.out.println("Enter the new phone number");
			branch.getAddress().setContact(Hospital_Dao.scanner.nextLong());
			Hospital_Dao.entityTransaction.begin();
			Hospital_Dao.entityManager.merge(branch);
			Hospital_Dao.entityTransaction.commit();
			
			System.out.println("Updated Successfully");
			
		}
	}
}
