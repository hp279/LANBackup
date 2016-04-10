package com.crossover.lanbackup.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
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

    @XmlElement(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name="ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @XmlElement(name="src_login")
    public String getSrcLogin() {
        return srcLogin;
    }

    public void setSrcLogin(String srcLogin) {
        this.srcLogin = srcLogin;
    }

    @XmlElement(name="src_password")
    public String getSrcPassword() {
        return srcPassword;
    }

    public void setSrcPassword(String srcPassword) {
        this.srcPassword = srcPassword;
    }

    @XmlElement(name="dst_login")
    public String getDstLogin() {
        return dstLogin;
    }

    public void setDstLogin(String dstLogin) {
        this.dstLogin = dstLogin;
    }

    @XmlElement(name="dst_password")
    public String getDstPassword() {
        return dstPassword;
    }

    public void setDstPassword(String dstPassword) {
        this.dstPassword = dstPassword;
    }

    @XmlElement(name="enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @XmlElement(name="create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @XmlElement(name="last_update_date")
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
