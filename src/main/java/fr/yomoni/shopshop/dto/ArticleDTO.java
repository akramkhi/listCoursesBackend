package fr.yomoni.shopshop.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.yomoni.shopshop.model.ListeCourses;

public class ArticleDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6962342397247225326L;

	
private UUID id;
	
	private String label;
	
	private String status;
	
	private Integer nbItems;
	
	private Timestamp updateTimestamp;
	
	private ListeCourses listCourses;

	
	
	public ArticleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleDTO(UUID id, String label, String status, Integer nbItems, Timestamp updateTimestamp, ListeCourses listCourses) {
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
