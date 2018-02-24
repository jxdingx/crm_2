package com.st.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.core.action.BaseAction;
import com.core.utils.HtmlUtil;
import com.st.entity.OrderDetailsEntity;
import com.st.service.OrderDetailsService;

public class OrderDetailsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private OrderDetailsService orderDetailsService;

	private Integer orderId; // 所属订单

	public void findorderDetails() {
		OrderDetailsEntity oEntity = new OrderDetailsEntity();
		oEntity.setOrderId(orderId);
		List<OrderDetailsEntity> oEntityList = orderDetailsService.find(oEntity);
		HtmlUtil.writerJson(getResponse(), oEntityList);
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}
