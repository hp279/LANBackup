package com.crossover.lanbackup.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.crossover.lanbackup.entity.ActivityResult;

@XmlRootElement(name = "config_log")
public class BackupActivityLogDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private long folderId;
    private String description;
    private Date activityDate;
    private ActivityResult activityResult;
    private Date lastUpdateDate;

    public BackupActivityLogDTO() {
        System.out.println("BackupActivityLogDTO");
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFolderId() {
        return folderId;
    }

    public void setFolderId(long folderId) {
        this.folderId = folderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public ActivityResult getActivityResult() {
        return activityResult;
    }

    public void setActivityResult(ActivityResult activityResult) {
        this.activityResult = activityResult;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,
                ToStringStyle.DEFAULT_STYLE);
    }

}
