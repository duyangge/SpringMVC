
package cn.jx.pxc.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.jx.pxc.ssm.pojo.Items;

/**
 *<p> Title:  ItemsController.java</p>
 *<p> Description:  Handler</p>
 * @package   cn.jx.pxc.ssm.controller
 * @author    黄信胜
 * @date      2018年12月18日下午5:47:54
 * @version 1.0
 */
//使用controller标识他是一个控制器
@Controller
public class ItemsController3 {
	
	
	/**商品查询
	 *  这个@RequestMapping实现对queryItemsAll方法和url进行映射，一个方法对应一个rul
	 *  一般建议将url和方法写成一样的
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryItemsAll")
	public ModelAndView queryItemsAll() throws Exception{
		
		//调用service查找数据库，查询商品列表，这里使用静态数据模拟
				List<Items> itemsList = new ArrayList<Items>();
				Items i1 = new Items();
				i1.setName("华硕笔记本");
				i1.setPrice(8000.56);
				i1.setDetail("外观精美");
				Items i2 = new Items();
				i2.setName("联想笔记本");
				i2.setPrice(4000.56);
				i2.setDetail("性能不太好，价格不便宜");
				itemsList.add(i1);
				itemsList.add(i2);
				
				//返回ModelAndView
				ModelAndView modelAndView = new ModelAndView();
				
				//相当于request的setAttribute,在jsp页面中通过ItemsList获取数据
				modelAndView.addObject("itemList", itemsList);
				//指定视图
				//modelAndView.setViewName("/WEB-INF/jsp/items/itemList.jsp");
				
				//在springmvc.xml中的视图解析器中配置jsp的前缀和后缀后，简写为
				modelAndView.setViewName("items/itemList");
				return modelAndView;
	}
	

	

}
