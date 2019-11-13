package fr.yomoni.shopshop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="LISTE_DE_COURSE")
public class ListeCourses implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2859487699987108943L;

	@Id
	@Column(name="id")
	@ColumnDefault("random_uuid()")
	private UUID id;
	
	@Column(name="label")
	private String label;
	
	@Column(name="status")
	private String status;
	
	@Column(name="creation_Date")
	private Date dateCreation;
	

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "listCourses")
    private Set<Article> article = new HashSet<>();
	
	

	public ListeCourses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListeCourses(UUID id ,String label,String status , Date dateCreation) {
		super();
		this.id = id;
		this.label = label;
		this.status = status;
		this.dateCreation = dateCreation;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Set<Article> getArticle() {
		return article;
	}

	public void setArticle(Set<Article> article) {
		this.article = article;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	



}
