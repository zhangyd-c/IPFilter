package com.test.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import com.test.dao.page.PageParameter;

/**
 * 分页tag
 */
public class PageTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object pageSize;// 每页显示的记录数

	private Object currentPage;// 当前页

	private Object totalPage;// 总页数
	// private Object hrefActionName;//要链接到的action

	private Object totalCount;// 总记录数
	// private Object list;//页数编号

	private List<Integer> pageSizeList;

	private Integer defaultPageSize = PageParameter.DEFAULT_PAGE_SIZE;

	private String clickMethod = "search";

	public int doStartTag() throws JspException {
		// 是TagSupport类中定义的一个属性，它是javax.servlet.jsp.PageContext的对象
		// HttpServletRequest request = (HttpServletRequest)
		// pageContext.getRequest();
		JspWriter out = pageContext.getOut();
		StringBuffer sbOut = new StringBuffer();
		sbOut.append("<ul class='pager'>");
		sbOut.append("<font size='2'>共" + getTotalPage() + "页&nbsp;&nbsp;第" + getCurrentPage() + "页</font>&nbsp;");
		if (getTotalPage().toString().equals("0") || getTotalPage().toString().equals("1")) {// 总共只有一页
			sbOut.append("<li><a href='javascript:void(0)'>首页</a></li>&nbsp;"
					+ "<li><a href='javascript:void(0)'>上一页</a></li>&nbsp;"
					+ "<li><a href='javascript:void(0)'>下一页</a></li>&nbsp;"
					+ "<li><a href='javascript:void(0)'>尾页</a></li>&nbsp;");
		} else if (getCurrentPage().toString().equals("1")) {// 当前页为第一页
			sbOut.append("<li><a href='javascript:void(0)'>首页</a></li>&nbsp;"
					+ "<li><a href='javascript:void(0)'>上一页</a></li>&nbsp;"
					+ "<li><a href='javascript:" + getClickMethod() + "(" 
						+ (Integer.parseInt(getCurrentPage().toString()) + 1) + ")'>下一页</a></li>&nbsp;"
					+ "<li><a href='javascript:" + getClickMethod() + "("
						+ getTotalPage().toString() + ")'>尾页</a></li>&nbsp;");
		} else if (getCurrentPage().toString().equals(getTotalPage().toString())) {// 当关页为最后一页
			sbOut.append(
					"<li><a href='javascript:" + getClickMethod() + "(1)'>首页</a></li>&nbsp;"
					+ "<li><a href='javascript:" + getClickMethod() + "("
					+ (Integer.parseInt(getCurrentPage().toString()) - 1) + ")'>上一页</a>" + "</li>&nbsp;"
					+ "<li><a href='javascript:void(0)'>下一页</a></li>&nbsp;"
					+ "<li><a href='javascript:void(0)'>尾页</a></li>&nbsp;");
		} else {// 显示所有链接（首页，上一页，下一页，尾页）
			sbOut.append(
					"<li><a href='javascript:" + getClickMethod() + "(1)'>首页</a></li>&nbsp;"
							+ "<li><a href='javascript:" + getClickMethod() + "(" + (Integer.parseInt(getCurrentPage().toString()) - 1) + ")'>上一页</a>" + "</li>&nbsp;"
							+ "<li><a href='javascript:" + getClickMethod() + "("
								+ (Integer.parseInt(getCurrentPage().toString()) + 1) + ")'>下一页</a></li>&nbsp;"
							+ "<li><a href='javascript:" + getClickMethod() + "(" + getTotalPage().toString() + ")'>尾页</a></li>&nbsp;");
		}
		sbOut.append("<li>共 " + getTotalCount() + " 条记录</li>&nbsp;<li>转到 <select  name='cu_pa' >");
		for (int i = 1; i < (Integer.parseInt(getTotalPage().toString()) + 1); i++) {
			if ((Integer.parseInt(getCurrentPage().toString())) == i) {
				sbOut.append("<option selected value='" + i + "'>" + i + "</option>");
			} else {
				sbOut.append("<option  value='" + i + "'>" + i + "</option>");
			}
		}

		sbOut.append("</select>页</li>&nbsp;&nbsp;");

		sbOut.append("<li>每页显示<select name='pageSize'>");
		// for(int i=1;i<5;i++){
		// if((Integer.parseInt(getPageSize().toString()))==(i*10)){
		// sbOut.append("<option selected
		// value='"+(i*10)+"'>"+(i*10)+"</option>");
		// }else{
		// sbOut.append("<option value='"+(i*10)+"'>"+(i*10)+"</option>");
		// }
		// }
		int tempPageSize = Integer.parseInt(getPageSize().toString());

		if (pageSizeList != null && pageSizeList.size() > 0) {
			for (Integer ps : pageSizeList) {
				sbOut.append("<option " + ((tempPageSize == ps.intValue()) ? "selected" : "") + " value='"
						+ ps.intValue() + "'>" + ps.intValue() + "</option>");
			}
		} else {
			sbOut.append("<option " + ((tempPageSize == 20) ? "selected" : "") + " value='20'>20</option>");
			sbOut.append("<option " + ((tempPageSize == 50) ? "selected" : "") + " value='50'>50</option>");
			sbOut.append("<option " + ((tempPageSize == 80) ? "selected" : "") + " value='80'>80</option>");
			sbOut.append("<option " + ((tempPageSize == 100) ? "selected" : "") + " value='100'>100</option>");
		}

		sbOut.append("</select>条</li>");
		sbOut.append("</ul>");
		try {
			out.print(sbOut.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// doStartTag() 方法返回 SKIP_BODY 。当然其原因是我们的简单日期标记没有正文。
		return Tag.SKIP_BODY;
	}

	// ExpressionEvaluatorManager.evaluate( "pageSize", pageSize.toString(),
	// Object.class, this, pageContext);
	public Object getPageSize() {
		return pageSize;
	}

	public void setPageSize(Object pageSize) {
		try {
			this.pageSize = (Object) ExpressionEvaluatorManager.evaluate("pageSize", pageSize.toString(), Object.class,
					this, pageContext);
		} catch (JspException e) {
			e.printStackTrace();
		}
	}

	public Object getCurrentPage() {
		if (Integer.parseInt(currentPage.toString()) > Integer.parseInt(totalPage.toString())) {
			this.currentPage = totalPage;
		}
		return this.currentPage;
	}

	public void setCurrentPage(Object currentPage) {
		try {
			this.currentPage = (Object) ExpressionEvaluatorManager.evaluate("currentIndex", currentPage.toString(),
					Object.class, this, pageContext);
		} catch (JspException e) {
			e.printStackTrace();
		}
	}

	public Object getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Object totalPage) {
		try {
			this.totalPage = ExpressionEvaluatorManager.evaluate("maxPage", totalPage.toString(), Object.class, this,
					pageContext);
		} catch (JspException e) {
			e.printStackTrace();
		}
	}

	// public Object getHrefActionName() {
	// return hrefActionName;
	// }
	// public void setHrefActionName(Object hrefActionName) {
	// try {
	// this.hrefActionName = (Object)
	// ExpressionEvaluatorManager.evaluate("hrefActionName",
	// hrefActionName.toString(), Object.class, this,
	// pageContext);
	// } catch (JspException e) {
	// e.printStackTrace();
	// };
	// }
	public Object getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Object totalCount) {
		try {
			this.totalCount = (Object) ExpressionEvaluatorManager.evaluate("maxCount", totalCount.toString(),
					Object.class, this, pageContext);
		} catch (JspException e) {
			e.printStackTrace();
		}
	}

	// public Object getList() {
	// return list;
	// }
	// public void setList(Object list) {
	// try {
	// this.list = (Object) ExpressionEvaluatorManager.evaluate("list",
	// list.toString(), Object.class, this, pageContext);
	// } catch (JspException e) {
	// e.printStackTrace();
	// };
	// }
	//

	public String getClickMethod() {
		return clickMethod;
	}

	public void setClickMethod(String clickMethod) {
		this.clickMethod = clickMethod;
	}

	@SuppressWarnings("rawtypes")
	public List getPageSizeList() {
		return pageSizeList;
	}

	@SuppressWarnings("unchecked")
	public void setPageSizeList(@SuppressWarnings("rawtypes") List pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

	public Integer getDefaultPageSize() {
		return defaultPageSize;
	}

	public void setDefaultPageSize(Integer defaultPageSize) {
		this.defaultPageSize = defaultPageSize;
	}

}
