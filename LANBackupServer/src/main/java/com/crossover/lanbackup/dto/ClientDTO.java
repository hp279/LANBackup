package com.crossover.lanbackup.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlRootElement(name = "client")
public class ClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String ipAddress;

    private String srcLogin;
    private String srcPassword;

    private String dstLogin;
    private String dstPassword;

    private boolean enabled;

    private Date createDate;
    private Date lastUpdateDate;


    public ClientDTO() {
        System.out.println("ClientDTO");
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSrcLogin() {
        return srcLogin;
    }

    public void setSrcLogin(String srcLogin) {
        this.srcLogin = srcLogin;
    }

    public String getSrcPassword() {
        return srcPassword;
    }

    public void setSrcPassword(String srcPassword) {
        this.srcPassword = srcPassword;
    }

    public String getDstLogin() {
        return dstLogin;
    }

    public void setDstLogin(String dstLogin) {
        this.dstLogin = dstLogin;
    }

    public String getDstPassword() {
        return dstPassword;
    }

    public void setDstPassword(String dstPassword) {
        this.dstPassword = dstPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this,
                ToStringStyle.DEFAULT_STYLE);
    }

}
