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
	private String clientIpAddress;
	private String description;
	private UpdateType updateType;
	private Date activityDate;

	public ConfigLog() {
		System.out.println("ConfigLogDTO");
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
	
	@Column(name = "client_ip_address", nullable = false, length = 15)
    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    public void setDescription(String description) {
        this.description = description;
    }


	@Column(name = "description", unique = false, nullable = false, length = 260)
	public String getDescription() {
		return description;
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
	@Column(name = "activity_date", unique = false, nullable = false)
	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
