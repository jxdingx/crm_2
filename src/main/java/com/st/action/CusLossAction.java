package com.st.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.core.utils.FormatEmpty;
import com.core.utils.HtmlUtil;
import com.st.entity.CusLossEntity;
import com.st.service.CusLossService;

@Controller
@Scope("prototype")
public class CusLossAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private CusLossService cusLossService;

	private Integer id; // 编号
	private String cusNo; // 客户编号
	private String cusName; // 客户名称
	private String cusManager; // 客户经理
	private Date lastOrderTime; // 上次下单日期
	private Date confirmLossTime; // 确认流失日期
	private Integer state; // 状态 0 暂缓流失 1 确认流失
	private String lossReason; // 流失原因

	private Integer page = 1;
	private Integer rows = 15;

	public void findallcusLoss() {

		String hql = "  from CusLossEntity  where  1=1 ";
		StringBuffer str = new StringBuffer(hql);
		if (!FormatEmpty.isEmpty(cusName)) {
			str.append(" and cusName " + " like '%" + cusName + "%' ");
		}
		if (!FormatEmpty.isEmpty(cusManager)) {
			str.append(" and cusManager " + " like '%" + cusManager + "%' ");
		}
		if (!FormatEmpty.isEmpty(state)) {
			str.append(" and state=" + state);
		}
		int first = rows * (page - 1);
		int max = rows;
		List<CusLossEntity> LcList = cusLossService.findAllPage(str.toString(), first, max);
		List<CusLossEntity> totalscList = cusLossService.findAll(str.toString());
		Map<String, Object> map = new HashMap<>();
		map.put("total", totalscList.size());
		map.put("rows", LcList);
		HtmlUtil.writerJson(getResponse(), map);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCusNo() {
		return cusNo;
	}

	public void setCusNo(String cusNo) {
		this.cusNo = cusNo;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusManager() {
		return cusManager;
	}

	public void setCusManager(String cusManager) {
		this.cusManager = cusManager;
	}

	public Date getLastOrderTime() {
		return lastOrderTime;
	}

	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}

	public Date getConfirmLossTime() {
		return confirmLossTime;
	}

	public void setConfirmLossTime(Date confirmLossTime) {
		this.confirmLossTime = confirmLossTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getLossReason() {
		return lossReason;
	}

	public void setLossReason(String lossReason) {
		this.lossReason = lossReason;
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

}
