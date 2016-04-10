package com.crossover.lanbackup.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "client")
public class Client implements Serializable {

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

	private Set<Folder> folders = new HashSet<Folder>();

	public Client() {
		System.out.println("ClientDTO");
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ip_address", unique = true, nullable = false)
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "src_login", unique = false, nullable = false)
	public String getSrcLogin() {
		return srcLogin;
	}

	public void setSrcLogin(String srcLogin) {
		this.srcLogin = srcLogin;
	}

	@Column(name = "src_password", unique = false, nullable = false)
	public String getSrcPassword() {
		return srcPassword;
	}

	public void setSrcPassword(String srcPassword) {
		this.srcPassword = srcPassword;
	}

	@Column(name = "dst_login", unique = false, nullable = false)
	public String getDstLogin() {
		return dstLogin;
	}

	public void setDstLogin(String dstLogin) {
		this.dstLogin = dstLogin;
	}

	@Column(name = "dst_password", unique = false, nullable = false)
	public String getDstPassword() {
		return dstPassword;
	}

	public void setDstPassword(String dstPassword) {
		this.dstPassword = dstPassword;
	}

	@Column(name = "enabled", unique = false, nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "client")
	public Set<Folder> getFolders() {
		return folders;
	}

	public void setFolders(Set<Folder> folders) {
		this.folders = folders;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", unique = false, nullable = false)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
