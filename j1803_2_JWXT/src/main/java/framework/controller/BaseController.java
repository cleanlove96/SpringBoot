/**
 * 
 */
package framework.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @Author QinPeng
 *
 * @Date 2018年5月19日
 */
public class BaseController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@InitBinder
	/**
	 * <p>
	 * 时间属性的编辑器
	 * </p>
	 * 
	 * @param servletRequestDataBinder
	 */
	public void initBinder(ServletRequestDataBinder servletRequestDataBinder) {
		servletRequestDataBinder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

	}
}
