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
@Table(name = "config_log")
public class ConfigLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private Client client;
	private String description;
	private UpdateType updateType;
	private Date lastUpdateDate;

	public ConfigLog() {
		System.out.println("ConfigLog");
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "config_log_id", unique = true, nullable = false)
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

	@Column(name = "description", unique = false, nullable = false, length = 260)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "update_type", unique = false, nullable = false, columnDefinition = "enum('CREATE', 'DELETE', 'UPDATE', 'ENABLE', 'DISABLE')")
	public UpdateType getUpdateType() {
		return updateType;
	}

	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
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
