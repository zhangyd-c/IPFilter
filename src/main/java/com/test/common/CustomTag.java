package com.test.common;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author (作者) zhangyd-c 2015年7月31日 下午5:58:49
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
public class CustomTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void doTag() throws JspException, IOException {
		// 是TagSupport类中定义的一个属性，它是javax.servlet.jsp.PageContext的对象
		// HttpServletRequest request = (HttpServletRequest)
		// pageContext.getRequest();
		// WebApplicationContext watx =
		// WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		JspWriter out = pageContext.getOut();

		String name = "";
		if (type != null && value != null) {
			name = type + " is " + value;
		}
		out.print(name);
	}
}
