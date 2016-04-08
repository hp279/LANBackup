package com.crossover.lanbackup.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "folder")
public class Folder implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private Client client;
	private String path;
	private Date lastUpdateDate;

	private FolderLocation location_type;

	public Folder() {
		System.out.println("Folder");
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "folder_id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false)
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Lob
	@Column(name = "path", unique = false, nullable = false, columnDefinition = "TEXT")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", unique = false, nullable = false)
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "location_type", unique = false, nullable = false, columnDefinition = "enum('SOURCE', 'DESTINATION')")
	public FolderLocation getLocation_type() {
		return location_type;
	}

	public void setLocation_type(FolderLocation location_type) {
		this.location_type = location_type;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
