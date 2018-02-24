package com.st.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_cusdevplan", catalog = "ssh_crm")
public class CusDevPlanEntity {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "native") // 自动定义主键生成策略
	private Integer id; // 编号
	private Integer saleChanceId; // 销售机会
	private String planItem; // 计划项
	private String planDate; // 计划日期
	private String exeAffect; // 执行效果

	public CusDevPlanEntity() {
		super();
	}
	
	public CusDevPlanEntity(Integer saleChanceId, String planItem, String planDate, String exeAffect) {
		super();
		this.saleChanceId = saleChanceId;
		this.planItem = planItem;
		this.planDate = planDate;
		this.exeAffect = exeAffect;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSaleChanceId() {
		return saleChanceId;
	}

	public void setSaleChanceId(Integer saleChanceId) {
		this.saleChanceId = saleChanceId;
	}

	public String getPlanItem() {
		return planItem;
	}

	public void setPlanItem(String planItem) {
		this.planItem = planItem;
	}

	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	public String getExeAffect() {
		return exeAffect;
	}

	public void setExeAffect(String exeAffect) {
		this.exeAffect = exeAffect;
	}

}
