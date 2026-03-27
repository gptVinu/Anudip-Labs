package assignments;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String username;
	    
	    // Added CascadeType.ALL to automatically save tasks when a user is saved
	    @OneToMany(mappedBy = "user", cascade = javax.persistence.CascadeType.ALL)
	    private List<Task> tasks = new java.util.ArrayList<>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public List<Task> getTasks() {
			return tasks;
		}

		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}

		// Helper method to keep both sides of the bidirectional relationship in sync safely
		public void addTask(Task task) {
			this.tasks.add(task);
			task.setUser(this);
		}

		@Override
		public String toString() {
			// Removed 'tasks' from toString to prevent potential infinite recursion
			return "User [id=" + id + ", username=" + username + "]";
		}
	    
	    
}
