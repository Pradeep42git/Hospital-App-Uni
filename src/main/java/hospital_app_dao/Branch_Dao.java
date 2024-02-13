package hospital_app_dao;

import java.util.ArrayList;
import java.util.List;

import hospital_app_dto.Address;
import hospital_app_dto.Branch;
import hospital_app_dto.Encounter;
import hospital_app_dto.Hospital;

public class Branch_Dao {

	public Branch createBranch() {
		Branch branch = new Branch();
		Hospital hospital1 = Hospital_Dao.entityManager.find(Hospital.class, 1);
		if (!(hospital1 == null)) {
			System.out.println("Enter the Branch ID");
			branch.setId(Hospital_Dao.scanner.nextInt());
			System.out.println("Enter the specialty");
			branch.setSpecialty(Hospital_Dao.scanner.next());
			System.out.println("Enter the Branch head");
			branch.setBranch_head(Hospital_Dao.scanner.next());
			List<Encounter>encounters= new ArrayList<Encounter>();
			branch.setEncounter(encounters);
			

			Address address = new Address();
			System.out.println("Enter the Address ID");
			address.setId(Hospital_Dao.scanner.nextInt());
			System.out.println("Enter the Area");
			address.setArea(Hospital_Dao.scanner.next());
			System.out.println("Enter the City");
			address.setCity(Hospital_Dao.scanner.next());
			System.out.println("Enter the phone number");
			address.setContact(Hospital_Dao.scanner.nextLong());
			branch.setAddress(address);
			
			List<Branch>branches= new ArrayList<Branch>();
			hospital1.setBranch(branches);
			
			List<Branch> branch1=hospital1.getBranch();
			branch1.add(branch);
			hospital1.setBranch(branch1);
			

			Hospital_Dao.entityTransaction.begin();
			Hospital_Dao.entityManager.persist(branch);
			Hospital_Dao.entityManager.persist(address);
			Hospital_Dao.entityTransaction.commit();

			System.out.println("New Branch And Address Saved Successfully");
		} else {
			System.out.println("No Hospital ID found");
		}
		return branch;
	}

	public Branch updateBranch() {
		Hospital hospital = Hospital_Dao.entityManager.find(Hospital.class, 1);
		Branch branch = null;
		if (!(hospital == null)) {
			System.out.println("Enter the Branch Id you want to Update");
			branch = Hospital_Dao.entityManager.find(Branch.class, Hospital_Dao.scanner.nextInt());
			if (!(branch == null)) {
				System.out.println("Enter your choice");
				System.out.println("Press 1 : To Update Specialty");
				System.out.println("Press 2 : To Update branch Head");
				int choice = Hospital_Dao.scanner.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("Enter the new specaility");
					branch.setSpecialty(Hospital_Dao.scanner.next());
					Hospital_Dao.entityTransaction.begin();
					Hospital_Dao.entityManager.merge(branch);
					Hospital_Dao.entityTransaction.commit();
					return branch;
				}
				case 2: {
					System.out.println("Enter the new Branch head name");
					branch.setBranch_head(Hospital_Dao.scanner.next());
					Hospital_Dao.entityTransaction.begin();
					Hospital_Dao.entityManager.merge(branch);
					Hospital_Dao.entityTransaction.commit();
					return branch;
				}
				}
			} else {
				System.out.println("No Branch Found");
			}
		}
		return branch;
	}

}
