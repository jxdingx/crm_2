package com.st.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.core.utils.FormatEmpty;
import com.core.utils.HtmlUtil;
import com.st.entity.CusOrderEntity;
import com.st.service.CusOrderService;

@Controller
@Scope("prototype")
public class CusOrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private CusOrderService cusOrderService;

	private Integer id; // 编号
	private Integer cusId; // 所属客户id
	private String orderNo; // 订单号
	private Date orderDate; // 订购日期
	private String address; // 送货地址
	private Integer state; // 状态 0 未回款 1 已回款

	private String result;

	public void findcusOrder() {
		CusOrderEntity cEntity = new CusOrderEntity();
		cEntity.setCusId(cusId);
		List<CusOrderEntity> cEntityList = cusOrderService.find(cEntity);
		HtmlUtil.writerJson(getResponse(), cEntityList);
	}

	public String updatecusOrdern() {
		CusOrderEntity cEntity = new CusOrderEntity(id, cusId, orderNo, orderDate, address, state);
		if (FormatEmpty.isEmpty(id)) {
			cusOrderService.save(cEntity);
			result = "insert";
		} else {
			cusOrderService.update(cEntity);
			result = "update";
		}
		return INPUT;
	}

	public String deletecusOrder() {
		CusOrderEntity cEntity = new CusOrderEntity();
		cEntity.setId(id);
		cusOrderService.delete(cEntity);
		result = "delete";
		return INPUT;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
