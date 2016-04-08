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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "backup_activity_log")
public class BackupActivityLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private Folder folder;
	private String description;
	private Date activityDate;
	private ActivityResult activityResult;
	private Date lastUpdateDate;

	public BackupActivityLog() {
		System.out.println("BackupActivityLog");
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "backup_activity_log_id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "folder_id", nullable = false)
	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	@Column(name = "description", unique = false, nullable = false, length = 260)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "activity_date", unique = false, nullable = false)
	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "activity_result", unique = false, nullable = false, columnDefinition = "enum('SUCCESS', 'FAILURE')")
	public ActivityResult getActivityResult() {
		return activityResult;
	}

	public void setActivityResult(ActivityResult activityResult) {
		this.activityResult = activityResult;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", unique = false, nullable = false)
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
