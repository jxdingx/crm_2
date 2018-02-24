package com.st.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_salechance", catalog = "ssh_crm")
public class SaleChanceEntity {

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "native") // 自动定义主键生成策略
	private Integer id; // 编号
	private String chanceSource; // 机会来源
	private String customerName; // 客户名称
	private Integer cgjl; // 成功几率
	private String overView; // 概要
	private String linkMan; // 联系人
	private String linkPhone; // 联系电话
	private String description; // 机会描述
	private String createMan; // 创建人
	private String createTime; // 创建时间
	private String assignMan; // 指派人
	private String assignTime; // 指派时间
	private Integer state; // 分配状态 0 未分配 1 已分配
	private Integer devResult; // 客户开发状态 0 未开发 1 开发中 2 开发成功 3 开发失败

	public SaleChanceEntity() {
		super();
	}

	public SaleChanceEntity(Integer id, String customerName, String overView) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.overView = overView;
	}

	public SaleChanceEntity(Integer id, String chanceSource, String customerName, Integer cgjl, String overView,
			String linkMan, String linkPhone, String description, String createMan, String createTime, String assignMan,
			String assignTime, Integer state, Integer devResult) {
		super();
		this.id = id;
		this.chanceSource = chanceSource;
		this.customerName = customerName;
		this.cgjl = cgjl;
		this.overView = overView;
		this.linkMan = linkMan;
		this.linkPhone = linkPhone;
		this.description = description;
		this.createMan = createMan;
		this.createTime = createTime;
		this.assignMan = assignMan;
		this.assignTime = assignTime;
		this.state = state;
		this.devResult = devResult;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChanceSource() {
		return chanceSource;
	}

	public void setChanceSource(String chanceSource) {
		this.chanceSource = chanceSource;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCgjl() {
		return cgjl;
	}

	public void setCgjl(Integer cgjl) {
		this.cgjl = cgjl;
	}

	public String getOverView() {
		return overView;
	}

	public void setOverView(String overView) {
		this.overView = overView;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAssignMan() {
		return assignMan;
	}

	public void setAssignMan(String assignMan) {
		this.assignMan = assignMan;
	}

	public String getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(String assignTime) {
		this.assignTime = assignTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getDevResult() {
		return devResult;
	}

	public void setDevResult(Integer devResult) {
		this.devResult = devResult;
	}

}
