package com.crossover.lanbackup.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.crossover.lanbackup.entity.FolderLocation;

@XmlRootElement(name = "folder")
public class FolderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private int clientId;
    private String path;
    private Date lastUpdateDate;

    private FolderLocation location_type;

    public FolderDTO() {
        System.out.println("FolderDTO");
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public FolderLocation getLocation_type() {
        return location_type;
    }

    public void setLocation_type(FolderLocation location_type) {
        this.location_type = location_type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,
                ToStringStyle.DEFAULT_STYLE);
    }

}
