package hospital_app_dao;

import java.util.ArrayList;
import java.util.List;

import hospital_app_dto.Encounter;
import hospital_app_dto.Person;

public class Person_Dao {

	public Person savePerson() {
		Person person = new Person();
		System.out.println("Enter the id");
		person.setId(Hospital_Dao.scanner.nextInt());
		System.out.println("Enter the Name");
		person.setName(Hospital_Dao.scanner.next());
		System.out.println("Enter the Sex");
		person.setSex(Hospital_Dao.scanner.next());
		System.out.println("Enter the Blood Group");
		person.setBloodGroup(Hospital_Dao.scanner.next());
		System.out.println("Enter the Location");
		person.setLocation(Hospital_Dao.scanner.next());
		

		Hospital_Dao.entityTransaction.begin();
		Hospital_Dao.entityManager.persist(person);
		Hospital_Dao.entityTransaction.commit();

		return person;
	}

	public void updatePerson() {
		System.out.println("Enter the Person Id You want to Update");
		Person person = Hospital_Dao.entityManager.find(Person.class, Hospital_Dao.scanner.nextInt());
		if (!(person == null)) {
			System.out.println("Enter your choice");
			System.out.println("Press 1 : For Location");
			System.out.println("Press 2 : For Name");
			int choice = Hospital_Dao.scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the new Location");
				person.setLocation(Hospital_Dao.scanner.next());
				Hospital_Dao.entityTransaction.begin();
				Hospital_Dao.entityManager.merge(person);
				Hospital_Dao.entityTransaction.commit();
				break;
			}
			case 2:{
				System.out.println("Enter the new Name");
				person.setName(Hospital_Dao.scanner.next());
				Hospital_Dao.entityTransaction.begin();
				Hospital_Dao.entityManager.merge(person);
				Hospital_Dao.entityTransaction.commit();
				break;	
			}
			}

		} else {
			System.out.println("No Person ID Found");
		}

	}

}
