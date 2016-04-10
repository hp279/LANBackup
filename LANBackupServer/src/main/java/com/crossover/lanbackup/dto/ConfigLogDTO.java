package com.crossover.lanbackup.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.crossover.lanbackup.entity.UpdateType;

@XmlRootElement(name = "config_log")
public class ConfigLogDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String clientIpAddress;
    private String description;
    private UpdateType updateType;
    private Date activityDate;

    public ConfigLogDTO() {
        System.out.println("ConfigLogDTO");
    };

    @XmlElement(name="id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name="client_ip_address")
    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    } 

    @XmlElement(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name="update_type")
    public UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }

    @XmlElement(name="activity_date")
    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,
                ToStringStyle.DEFAULT_STYLE);
    }

}
