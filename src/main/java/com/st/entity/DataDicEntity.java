package com.st.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 数据字典实体类
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_datadic", catalog = "ssh_crm")
public class DataDicEntity {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "native") // 自动定义主键生成策略
	private Integer id; // 编号
	private String dataDicName; // 数据字典名
	private String dataDicValue; // 数据字典值

	public DataDicEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataDicName() {
		return dataDicName;
	}

	public void setDataDicName(String dataDicName) {
		this.dataDicName = dataDicName;
	}

	public String getDataDicValue() {
		return dataDicValue;
	}

	public void setDataDicValue(String dataDicValue) {
		this.dataDicValue = dataDicValue;
	}

}
