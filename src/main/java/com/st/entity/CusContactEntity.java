package com.st.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 交往记录
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_customer_contact", catalog = "ssh_crm")
public class CusContactEntity {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "native") // 自动定义主键生成策略
	private Integer id; // 编号
	private Integer cusId; // 所属客户id
	private String contactTime; // 交往时间
	private String address; // 交往地点
	private String overView; // 概要

	public CusContactEntity() {
		super();
	}

	public CusContactEntity(Integer id, Integer cusId, String contactTime, String address, String overView) {
		super();
		this.id = id;
		this.cusId = cusId;
		this.contactTime = contactTime;
		this.address = address;
		this.overView = overView;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getContactTime() {
		return contactTime;
	}

	public void setContactTime(String contactTime) {
		this.contactTime = contactTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOverView() {
		return overView;
	}

	public void setOverView(String overView) {
		this.overView = overView;
	}

}
