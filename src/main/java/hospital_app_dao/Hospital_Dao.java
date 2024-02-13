package hospital_app_dao;

import java.util.Scanner;

import hospital_app_dto.Hospital;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Hospital_Dao {
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction = entityManager.getTransaction();
	public static Scanner scanner = new Scanner(System.in);

	public void updateHospital() {

		Hospital hospital = entityManager.find(Hospital.class, 1);
		if (!(hospital == null)) {
			System.out.println("Enter the new Name");
			hospital.setName(scanner.next());

			entityTransaction.begin();
			entityManager.persist(hospital);
			entityTransaction.commit();

			System.out.println("Updated Succesfully");
		} else {
			System.out.println("hospital Id not found");
		}
	}
	public static Hospital createHospital() {
		Hospital hospital= new Hospital();
		hospital.setId(1);
		hospital.setName("RPK Advanced Care");
		hospital.setchairMan("Pradeep");
		
//		hospital.setBranch(null);
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		return hospital;	
	}

}
