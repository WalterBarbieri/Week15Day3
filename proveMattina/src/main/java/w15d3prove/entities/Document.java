package w15d3prove.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
//@Getter
//@Setter
//@ToString

public class Document {
	@Id
	@GeneratedValue
	private long id;
	private String code;
	private LocalDate issueDate;
	@Column(length = 2)
	private String country;
	@OneToOne(mappedBy = "document")
	private User user;

	public Document() {

	}

	public Document(String code, LocalDate issueDate, String country) {

		this.code = code;
		this.issueDate = issueDate;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", code=" + code + ", issueDate=" + issueDate + ", country=" + country + "]";
	}

}
