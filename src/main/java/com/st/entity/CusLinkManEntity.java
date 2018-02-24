package com.st.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 联系人实体
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_customer_linkman", catalog = "ssh_crm")
public class CusLinkManEntity {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "native") // 自动定义主键生成策略
	private Integer id; // 编号
	private Integer cusId; // 所属客户id
	private String linkName; // 姓名
	private String sex; // 性别
	private String zhiwei; // 职位
	private String officePhone; // 办公电话
	private String phone; // 手机

	public CusLinkManEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CusLinkManEntity(Integer id, Integer cusId, String linkName, String sex, String zhiwei, String officePhone,
			String phone) {
		super();
		this.id = id;
		this.cusId = cusId;
		this.linkName = linkName;
		this.sex = sex;
		this.zhiwei = zhiwei;
		this.officePhone = officePhone;
		this.phone = phone;
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

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getZhiwei() {
		return zhiwei;
	}

	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
