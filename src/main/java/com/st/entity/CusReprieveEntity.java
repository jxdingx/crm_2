package com.st.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 客户流失暂缓措施实体类
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_customer_reprieve", catalog = "ssh_crm")
public class CusReprieveEntity {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "native") // 自动定义主键生成策略
	private Integer id; // 编号
	private Integer lossId; // 客户流失id
	private String measure; // 暂缓措施

	public CusReprieveEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLossId() {
		return lossId;
	}

	public void setLossId(Integer lossId) {
		this.lossId = lossId;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

}
