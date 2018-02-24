package com.st.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 订单实体
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_customer_order", catalog = "ssh_crm")
public class CusOrderEntity {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "native") // 自动定义主键生成策略
	private Integer id; // 编号
	private Integer cusId; // 所属客户id
	private String orderNo; // 订单号
	private Date orderDate; // 订购日期
	private String address; // 送货地址
	private Integer state; // 状态 0 未回款 1 已回款

	public CusOrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CusOrderEntity(Integer id, Integer cusId, String orderNo, Date orderDate, String address, int state) {
		super();
		this.id = id;
		this.cusId = cusId;
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.address = address;
		this.state = state;
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
