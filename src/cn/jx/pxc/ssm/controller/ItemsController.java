
package cn.jx.pxc.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.jx.pxc.ssm.pojo.Items;

/**
 *<p> Title:  ItemsController.java</p>
 *<p> Description:  Handler</p>
 * @package   cn.jx.pxc.ssm.controller
 * @author    黄信胜
 * @date      2018年12月18日下午5:47:54
 * @version 版本号
 */
public class ItemsController implements Controller {

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<Items> itemsList = new ArrayList<Items>();
		Items i1 = new Items();
		i1.setName("笔记本");
		i1.setPrice(7000.56);
		i1.setDetail("物美价廉");
		Items i2 = new Items();
		i2.setName("台式笔记本");
		i2.setPrice(4000.56);
		i2.setDetail("精美");
		itemsList.add(i1);
		itemsList.add(i2);
		//返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		//相当于request的setAttribute,在jsp页面中通过ItemsList获取数据
		modelAndView.addObject("itemList", itemsList);
		//指定视图
		modelAndView.setViewName("/WEB-INF/jsp/items/itemList.jsp");
		return modelAndView;
	}
	

}
