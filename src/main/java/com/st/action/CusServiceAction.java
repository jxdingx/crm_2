package com.st.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.core.action.BaseAction;
import com.core.utils.FormatEmpty;
import com.core.utils.HtmlUtil;
import com.st.entity.CusServiceEntity;
import com.st.service.CusServiceService;

public class CusServiceAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private CusServiceService cusServiceService;

	private Integer id; // 编号
	private String serveType; // 服务类型 1,咨询 2，建议 3，投诉
	private String overview; // 概要
	private String customer; // 客户
	private String state = "新创建"; // 1，新创建 2，已分配 3，已处理 4，已归档
	private String servicerequest; // 服务请求
	private String createPeople; // 创建人
	private Date createTime; // 创建日期
	private String assigner; // 分配人
	private Date assignTime; // 分配日期
	private String serviceProce; // 服务处理
	private String serviceProcePeople; // 服务处理人
	private Date serviceProceTime; // 服务处理日期
	private String serviceProceResult; // 服务处理结果
	private String myd; // 客户满意度

	private Integer page = 1;
	private Integer rows = 15;
	private String result;

	public String updatecusService() {
		CusServiceEntity cEntity = new CusServiceEntity(id, serveType, overview, customer, state, servicerequest,
				createPeople, createTime, assigner, assignTime, serviceProce, serviceProcePeople, serviceProceTime,
				serviceProceResult, myd);
		if (FormatEmpty.isEmpty(id)) {
			cusServiceService.save(cEntity);
			result = "insert";
		} else {
			cusServiceService.update(cEntity);
			result = "update";
		}
		return INPUT;
	}

	public String findcusService() {
		String hql = "  from CusServiceEntity  where  1=1 ";
		StringBuffer str = new StringBuffer(hql);
		if (!FormatEmpty.isEmpty(state)) {
			str.append(" and state ='" + state + "'");
		}
		// if (!FormatEmpty.isEmpty(name)) {
		// str.append(" and name " + " like '%" + name + "%' ");
		// }
		int first = rows * (page - 1);
		int max = rows;
		List<CusServiceEntity> cList = cusServiceService.findAllPage(str.toString(), first, max);
		List<CusServiceEntity> totalcList = cusServiceService.findAll(str.toString());
		Map<String, Object> map = new HashMap<>();
		map.put("total", totalcList.size());
		map.put("rows", cList);
		HtmlUtil.writerJson(getResponse(), map);
		return INPUT;
	}

	public String updatestatecusService() {
		CusServiceEntity cEntity = cusServiceService.get(id);
		cEntity.setAssigner(assigner);
		cEntity.setAssignTime(assignTime);
		cEntity.setState("已分配");
		cusServiceService.update(cEntity);
		return INPUT;
	}

	public String deletecusService() {
		CusServiceEntity cEntity = new CusServiceEntity();
		cEntity.setId(id);
		cusServiceService.delete(cEntity);
		return INPUT;
	}

	public String updateprocecusService() {
		CusServiceEntity cEntity = cusServiceService.get(id);
		cEntity.setServiceProce(serviceProce);
		cEntity.setServiceProcePeople(serviceProcePeople);
		cEntity.setServiceProceTime(serviceProceTime);
		cEntity.setState("已处理");
		cusServiceService.update(cEntity);
		return INPUT;
	}

	public String updatefeedbackcusService() {
		CusServiceEntity cEntity = cusServiceService.get(id);
		cEntity.setMyd(myd);
		cEntity.setServiceProceResult(serviceProceResult);
		cEntity.setState("已归档");
		cusServiceService.update(cEntity);
		return INPUT;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServeType() {
		return serveType;
	}

	public void setServeType(String serveType) {
		this.serveType = serveType;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getServicerequest() {
		return servicerequest;
	}

	public void setServicerequest(String servicerequest) {
		this.servicerequest = servicerequest;
	}

	public String getCreatePeople() {
		return createPeople;
	}

	public void setCreatePeople(String createPeople) {
		this.createPeople = createPeople;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAssigner() {
		return assigner;
	}

	public void setAssigner(String assigner) {
		this.assigner = assigner;
	}

	public Date getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}

	public String getServiceProce() {
		return serviceProce;
	}

	public void setServiceProce(String serviceProce) {
		this.serviceProce = serviceProce;
	}

	public String getServiceProcePeople() {
		return serviceProcePeople;
	}

	public void setServiceProcePeople(String serviceProcePeople) {
		this.serviceProcePeople = serviceProcePeople;
	}

	public Date getServiceProceTime() {
		return serviceProceTime;
	}

	public void setServiceProceTime(Date serviceProceTime) {
		this.serviceProceTime = serviceProceTime;
	}

	public String getServiceProceResult() {
		return serviceProceResult;
	}

	public void setServiceProceResult(String serviceProceResult) {
		this.serviceProceResult = serviceProceResult;
	}

	public String getMyd() {
		return myd;
	}

	public void setMyd(String myd) {
		this.myd = myd;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
