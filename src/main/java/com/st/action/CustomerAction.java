package com.st.action;

import java.util.ArrayList;
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
import com.st.entity.CustomerEntity;
import com.st.service.CustomerService;

@Controller
@Scope("prototype")
public class CustomerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CustomerService customerService;

	private Integer id; // 编号
	private String khno = "KH" + new Date().getTime(); // 客户编号 动态生成
	private String name; // 客户名称
	private String area; // 客户地区
	private String cusManager; // 客户经理
	private String level; // 客户等级
	private String myd; // 客户满意度
	private String xyd; // 客户信用度
	private String address; // 客户地址
	private String postCode; // 邮政编码
	private String phone; // 联系电话
	private String fax; // 传真
	private String webSite; // 网址
	private String yyzzzch; // 营业执照注册号
	private String fr; // 法人
	private String zczj; // 注册资金(万元)
	private String nyye; // 年营业额
	private String khyh; // 开户银行
	private String khzh; // 开户帐号
	private String dsdjh; // 地税登记号
	private String gsdjh; // 国税登记号
	private Integer state = 0; // 客户状态 0 正常 1 客户流失

	private Integer page = 1;
	private Integer rows = 15;
	private String result;

	public void findallcustomer() {
		String hql = "  from CustomerEntity  where  1=1 ";
		StringBuffer str = new StringBuffer(hql);
		if (!FormatEmpty.isEmpty(khno)) {
			str.append(" and khno ='" + khno + "'");
		}
		if (!FormatEmpty.isEmpty(name)) {
			str.append(" and name " + " like '%" + name + "%' ");
		}
		int first = rows * (page - 1);
		int max = rows;
		List<CustomerEntity> cList = customerService.findAllPage(str.toString(), first, max);
		List<CustomerEntity> totalcList = customerService.findAll(str.toString());
		Map<String, Object> map = new HashMap<>();
		map.put("total", totalcList.size());
		map.put("rows", cList);
		HtmlUtil.writerJson(getResponse(), map);

	}

	public String updatecustomer() {
		CustomerEntity cEntity = new CustomerEntity(id, khno, name, area, cusManager, level, myd, xyd, address,
				postCode, phone, fax, webSite, yyzzzch, fr, zczj, nyye, khyh, khzh, dsdjh, gsdjh, state);
		if (FormatEmpty.isEmpty(id)) {
			customerService.save(cEntity);
			result = "insert";
		} else {
			customerService.update(cEntity);
			result = "update";
		}
		return INPUT;
	}

	public void findcustomer() {
		CustomerEntity cEntity = customerService.get(id);
		HtmlUtil.writerJson(getResponse(), cEntity);
	}

	// /**
	// * 查询客户构成
	// * @param response
	// * @return
	// * @throws Exception
	// */findCutomerGccustomer
	public void findCustomerGccustomer() {
		CustomerEntity cEntity1 = new CustomerEntity();
		CustomerEntity cEntity2 = new CustomerEntity();
		CustomerEntity cEntity3 = new CustomerEntity();
		CustomerEntity cEntity4 = new CustomerEntity();
		CustomerEntity cEntity5 = new CustomerEntity();
		List<CustomerEntity> cEntityList = customerService.find(cEntity1);
		cEntity1.setLevel("战略合作伙伴");
		cEntity1.setState(0);
		cEntity2.setLevel("大客户");
		cEntity2.setState(0);
		cEntity3.setLevel("重点开发客户");
		cEntity3.setState(0);
		cEntity4.setLevel("合作伙伴");
		cEntity4.setState(0);
		cEntity5.setLevel("普通客户");
		cEntity5.setState(0);
		for (CustomerEntity c : cEntityList) {
			switch (c.getLevel()) {
			case "战略合作伙伴":
				Integer num1 = cEntity1.getState();
				num1 += 1;
				cEntity1.setState(num1);
				break;
			case "大客户":
				Integer num2 = cEntity2.getState();
				num2 += 1;
				cEntity2.setState(num2);
				break;
			case "重点开发客户":
				Integer num3 = cEntity3.getState();
				num3 += 1;
				cEntity3.setState(num3);
				break;
			case "合作伙伴":
				Integer num4 = cEntity4.getState();
				num4 += 1;
				cEntity4.setState(num4);
				break;
			case "普通客户":
				Integer num5 = cEntity5.getState();
				num5 += 1;
				cEntity5.setState(num5);
				break;

			default:
				break;
			}
		}
		List<CustomerEntity> list = new ArrayList<>();
		list.add(cEntity1);
		list.add(cEntity2);
		list.add(cEntity3);
		list.add(cEntity4);
		list.add(cEntity5);
		HtmlUtil.writerJson(getResponse(), list);
	}

	//
	// /**
	// * 查询客户服务
	// * @param response
	// * @return
	// * @throws Exception
	// */findCustomerFwcustomer

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKhno() {
		return khno;
	}

	public void setKhno(String khno) {
		this.khno = khno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCusManager() {
		return cusManager;
	}

	public void setCusManager(String cusManager) {
		this.cusManager = cusManager;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMyd() {
		return myd;
	}

	public void setMyd(String myd) {
		this.myd = myd;
	}

	public String getXyd() {
		return xyd;
	}

	public void setXyd(String xyd) {
		this.xyd = xyd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getYyzzzch() {
		return yyzzzch;
	}

	public void setYyzzzch(String yyzzzch) {
		this.yyzzzch = yyzzzch;
	}

	public String getFr() {
		return fr;
	}

	public void setFr(String fr) {
		this.fr = fr;
	}

	public String getZczj() {
		return zczj;
	}

	public void setZczj(String zczj) {
		this.zczj = zczj;
	}

	public String getNyye() {
		return nyye;
	}

	public void setNyye(String nyye) {
		this.nyye = nyye;
	}

	public String getKhyh() {
		return khyh;
	}

	public void setKhyh(String khyh) {
		this.khyh = khyh;
	}

	public String getKhzh() {
		return khzh;
	}

	public void setKhzh(String khzh) {
		this.khzh = khzh;
	}

	public String getDsdjh() {
		return dsdjh;
	}

	public void setDsdjh(String dsdjh) {
		this.dsdjh = dsdjh;
	}

	public String getGsdjh() {
		return gsdjh;
	}

	public void setGsdjh(String gsdjh) {
		this.gsdjh = gsdjh;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
