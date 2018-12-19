
package cn.jx.pxc.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
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
public class ItemsController2 implements HttpRequestHandler {

	/* (non-Javadoc)
	 * @see org.springframework.web.HttpRequestHandler#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				//设置模型数据
				request.setAttribute("itemList", itemsList);
				//设置转发的视图
				request.getRequestDispatcher("/WEB-INF/jsp/items/itemList.jsp").forward(request, response);
		
				//使用此方法可以通过修改response,设置想要的数据格式，比如响应json数据
//				response.setCharacterEncoding("utf-8");
//				response.setContentType("application/json;characterset=utf-8");
//				response.getWriter().write("json串");
	}

}
