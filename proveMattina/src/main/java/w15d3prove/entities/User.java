package w15d3prove.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "students", schema = "public")
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mysequence")
	@SequenceGenerator(name = "mysequence", sequenceName = "mysequence", allocationSize = 50)

	private long id;
	private String firstName;
	private String lastName;
	@OneToOne
	private Document document;
	@OneToMany(mappedBy = "user")
	private Set<Blogpost> blogs;

	public User() {

	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Set<Blogpost> getBlogs() {
		return blogs;
	}

	public void setBlogs(Set<Blogpost> blogs) {
		this.blogs = blogs;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", document=" + document
				+ "]";
	}

}
