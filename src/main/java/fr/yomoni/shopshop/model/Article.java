package fr.yomoni.shopshop.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ARTICLE")
public class Article  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8723234912265661083L;

	@Id
	@Column(name="id")
	private UUID id;
	
	@Column(name="label")
	private String label;
	
	@Column(name="status")
	private String status;
	
	@Column(name="nb_Items")
	private Integer nbItems;
	
	@Column(name="update_Timestamp")
	private Timestamp updateTimestamp;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LISTE_DE_COURSE_ID", nullable = false)
	 @JsonIgnore
	private ListeCourses listCourses;

	
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(UUID id, String label, String status, Integer nbItems, Timestamp updateTimestamp, ListeCourses listCourses) {
		super();
		this.id = id;
		this.label = label;
		this.status = status;
		this.nbItems = nbItems;
		this.updateTimestamp = updateTimestamp;
		this.listCourses = listCourses;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNbItems() {
		return nbItems;
	}

	public void setNbItems(Integer nbItems) {
		this.nbItems = nbItems;
	}

	public Timestamp getUpdateTimestamp() {
		return updateTimestamp;
	}

	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public ListeCourses getListCourses() {
		return listCourses;
	}

	public void setListCourses(ListeCourses listCourses) {
		this.listCourses = listCourses;
	}
	
	
	
	
	

}
