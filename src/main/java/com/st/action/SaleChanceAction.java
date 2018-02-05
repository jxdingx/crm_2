package com.st.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.core.utils.HtmlUtil;
import com.st.entity.SaleChanceEntity;
import com.st.service.SaleChanceService;

@Controller
@Scope("prototype")
public class SaleChanceAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SaleChanceService saleChanceService;

	private Integer id; // 编号
	private String customerName; // 客户名称
	private String overView; // 概要
	private String createMan; // 创建人
	private Integer state; // 分配状态 0 未分配 1 已分配

	private Integer page = 1;
	private Integer rows = 15;

	public void findallsaleChance() {

		String hql = "  from SaleChanceEntity  where  1=1 ";
		StringBuffer str = new StringBuffer(hql);
		if (customerName != null && !"".equals(customerName)) {
			str.append(" and customerName " + " like '%" + customerName + "%' ");
		}
		if (overView != null && !"".equals(overView)) {
			str.append(" and overView " + " like '%" + overView + "%' ");
		}
		if (createMan != null && !"".equals(createMan)) {
			str.append(" and createMan " + " like '%" + createMan + "%' ");
		}
		if (state != null) {
			str.append(" and state= " + state);
		}
		System.out.println(customerName + "--" + overView + "--" + state);
		int first = rows * (page - 1);
		int max = rows;
		List<SaleChanceEntity> scList = saleChanceService.findAllPage(str.toString(), first, max);
		List<SaleChanceEntity> totalscList = saleChanceService.findAll(str.toString());
		Map<String, Object> map = new HashMap<>();
		map.put("total", totalscList.size());
		map.put("rows", scList);
		HtmlUtil.writerJson(getResponse(), map);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOverView() {
		return overView;
	}

	public void setOverView(String overView) {
		this.overView = overView;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
