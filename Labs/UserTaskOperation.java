package assignments;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserTaskOperation {

	public static void main(String[] args) {
		// Obtain a Hibernate SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		// Open a new session
		Session session = factory.openSession();

		// Begin a transaction
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			// 1. Create a user
			User user = new User();
			user.setUsername("Vinayak Gupta");

			// 2. Create tasks
			Task task1 = new Task();
			task1.setTitle("Complete project A");

			Task task2 = new Task();
			task2.setTitle("Review documentation");

			// 3. Associate tasks with the user using the new clean helper method
			user.addTask(task1);
			user.addTask(task2);

			// 4. Save the user
			session.save(user);

			// 5. Commit the transaction
			transaction.commit();
			System.out.println("User and Tasks successfully saved to database!");

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback(); 
			}
			e.printStackTrace();
		} finally {
			//close the session and connections
			session.close();
			factory.close();
		}
	}

}
