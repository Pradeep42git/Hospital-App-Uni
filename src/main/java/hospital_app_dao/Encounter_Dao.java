package hospital_app_dao;

import java.util.ArrayList;
import java.util.List;

import hospital_app_dto.Branch;
import hospital_app_dto.Encounter;
import hospital_app_dto.MedOrders;
import hospital_app_dto.Person;

public class Encounter_Dao {
	public Encounter addEncounter() {
		Encounter encounter = new Encounter();
		System.out.println("Enter which Branch id you want to Save");
		Branch branch = Hospital_Dao.entityManager.find(Branch.class, Hospital_Dao.scanner.nextInt());
		if (!(branch == null)) {
			System.out.println("Enter the Person Id you want to add the Encounter");
			 Person person = Hospital_Dao.entityManager.find(Person.class, Hospital_Dao.scanner.nextInt());
			if (!(person == null)) {
				System.out.println("Enter the ID");
				encounter.setId(Hospital_Dao.scanner.nextInt());
				System.out.println("Enter the weight");
				encounter.setWeight(Hospital_Dao.scanner.nextInt());
				System.out.println("Enter the Blood Pressure");
				encounter.setBloodPressure(Hospital_Dao.scanner.next());
				System.out.println("Enter the Complaint");
				encounter.setComplaint(Hospital_Dao.scanner.next());
				List<MedOrders>medOrders=new ArrayList<MedOrders>();
				encounter.setMedOrders(medOrders);
				List<Encounter>encounters= branch.getEncounter();
				encounters.add(encounter);
				branch.setEncounter(encounters);
				encounter.setPerson(person);
				Hospital_Dao.entityTransaction.begin();
				Hospital_Dao.entityManager.persist(encounter);
				Hospital_Dao.entityManager.merge(branch);
				Hospital_Dao.entityManager.merge(person);
				Hospital_Dao.entityTransaction.commit();
				
			} else {
				System.out.println("No Person ID Found");
			}

		} else {
			System.out.println("No Branch Found");
		}
		return encounter;
	}
	public void updateEncounter() {
		
		System.out.println("Enter the Encounter ID you want to update ");
		Encounter encounter =  Hospital_Dao.entityManager.find(Encounter.class,Hospital_Dao.scanner.nextInt() );
		if(!(encounter==null)) {
			System.out.println("Press 1 : For Blood Pressure");
			System.out.println("Press 2 : For weight");
			System.out.println("Enter Your Choice");
			int choice= Hospital_Dao.scanner.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter the New Blood Pressure ");
				encounter.setBloodPressure(Hospital_Dao.scanner.next());
				Hospital_Dao.entityTransaction.begin();
				Hospital_Dao.entityManager.merge(encounter);
				Hospital_Dao.entityTransaction.commit();
				System.out.println("Updated Successfully");
				break;
			}
			case 2 :{
				System.out.println("Enter the new weight");
				encounter.setWeight(Hospital_Dao.scanner.nextInt());
				Hospital_Dao.entityTransaction.begin();
				Hospital_Dao.entityManager.merge(encounter);
				Hospital_Dao.entityTransaction.commit();
				System.out.println("Updated Successfully");
				break;
			}
			}
		}else {
			System.out.println("No Encounter Found ");
		}
		
	}

}
