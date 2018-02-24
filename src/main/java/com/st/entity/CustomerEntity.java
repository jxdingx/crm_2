package com.st.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_customer", catalog = "ssh_crm")
public class CustomerEntity {
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "native") // 自动定义主键生成策略
	private Integer id; // 编号
	private String khno; // 客户编号 动态生成
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
	private Integer state; // 客户状态 0 正常 1 客户流失

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(Integer id, String khno, String name, String area, String cusManager, String level,
			String myd, String xyd, String address, String postCode, String phone, String fax, String webSite,
			String yyzzzch, String fr, String zczj, String nyye, String khyh, String khzh, String dsdjh, String gsdjh,
			Integer state) {
		super();
		this.id = id;
		this.khno = khno;
		this.name = name;
		this.area = area;
		this.cusManager = cusManager;
		this.level = level;
		this.myd = myd;
		this.xyd = xyd;
		this.address = address;
		this.postCode = postCode;
		this.phone = phone;
		this.fax = fax;
		this.webSite = webSite;
		this.yyzzzch = yyzzzch;
		this.fr = fr;
		this.zczj = zczj;
		this.nyye = nyye;
		this.khyh = khyh;
		this.khzh = khzh;
		this.dsdjh = dsdjh;
		this.gsdjh = gsdjh;
		this.state = state;
	}

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

}
