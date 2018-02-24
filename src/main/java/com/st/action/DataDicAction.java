package com.st.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.core.action.BaseAction;
import com.core.utils.HtmlUtil;
import com.st.entity.DataDicEntity;
import com.st.service.DataDicService;

@Controller
@Scope("prototype")
public class DataDicAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private DataDicService dataDicService;

	public void getleveldataDic() {
		String hql = " from DataDicEntity where dataDicName='客户等级' ";
		List<DataDicEntity> dataDicList = dataDicService.findAll(hql);
		HtmlUtil.writerJson(getResponse(), dataDicList);
	}

	public void getserveTypedataDic() {
		String hql = " from DataDicEntity where dataDicName='服务类型' ";
		List<DataDicEntity> dataDicList = dataDicService.findAll(hql);
		HtmlUtil.writerJson(getResponse(), dataDicList);
	}
}
