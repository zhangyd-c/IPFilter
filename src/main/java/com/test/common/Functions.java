package com.test.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.test.entity.Dictionary;
import com.test.entity.Location;

/**
 * @author (作者) zhangyd-c 2015年7月31日 下午5:04:50
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
public class Functions {

	public static Map<String, List<Dictionary>> map;

	public static Map<String, List<String>> resourceMap;

	public static Long sysTimes;

	public static Map<String, List<Location>> locationsMap;

	static {
		sysTimes = System.currentTimeMillis() / (1000 * 60 * 5);
	}

	/**
	 * 
	 * 描述该方法的作用：根据类型编码获取对应的字典列表
	 *
	 * @param typeCode
	 * @return map中的key为：code，value为：name
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Map<String, String>> getDicValues(String typeCode) {
		List<Dictionary> list = map.get(typeCode);
		return list == null ? new ArrayList() : list;
	}

	/**
	 * 根据地区类型获取地区集合
	 * 
	 * @param locationType
	 *            注：locationType取值有： 1.allAreas List<String> 2.allProvinces List
	 *            <Location> 3.allCitys List<Location>
	 * @return
	 * @date 2015年3月11日 下午2:40:13
	 */
	public static List<Location> getLocationByType(String locationType) {

		if (locationType == null || "".equals(locationType) || locationsMap == null) {
			return null;
		}
		return (List<Location>) locationsMap.get(locationType);
	}

	/**
	 * 
	 * 描述该方法的作用：根据类型编码,编码获取对应的字典名称
	 *
	 * @param typeCode
	 * @param code
	 * @return
	 */
	public static String getDicName(String typeCode, String code) {
		if (StringUtils.isBlank(typeCode) || StringUtils.isBlank(code)) {
			return "";
		}
		Dictionary dictionary = new Dictionary();
		dictionary.setTypeCode(typeCode);
		dictionary.setCode(code);
		List<Dictionary> list = map.get(typeCode);
		if (list == null || list.size() < 1) {
			return "";
		}
		int index = list.indexOf(dictionary);
		if (index < 0) {
			return "";
		}
		dictionary = list.get(index);// dictionaryService.getDictionaryByTypeCode(dictionary);
		return dictionary == null ? "" : dictionary.getName();
	}

	/**
	 * 
	 * 根据类型编码,编码获取对应的字典
	 * 
	 * @param typeCode
	 * @param code
	 * @return
	 */
	public static Dictionary getDic(String typeCode, String code) {
		if (StringUtils.isBlank(typeCode) || StringUtils.isBlank(code)) {
			return null;
		}
		Dictionary dictionary = new Dictionary();
		dictionary.setTypeCode(typeCode);
		dictionary.setCode(code);
		List<Dictionary> list = map.get(typeCode);
		if (list == null || list.size() < 1) {
			return null;
		}
		int index = list.indexOf(dictionary);
		if (index < 0) {
			return null;
		}
		dictionary = list.get(index);// dictionaryService.getDictionaryByTypeCode(dictionary);
		return dictionary;
	}

	// 获取分页信息
	public static String getStaticPage(Object pageSize, Object currentPage, Object totalPage, Object totalCount,
			String clickMethod, Integer[] pageSizeList) {
		StringBuffer sbOut = new StringBuffer();
		sbOut.append("<font size='2'>共" + totalPage + "页&nbsp;&nbsp;第" + currentPage + "页</font>&nbsp;");
		if (totalPage.toString().equals("0") || totalPage.toString().equals("1")) {// 总共只有一页
			sbOut.append("<li><a href='javascript:void(0)'>首页</a></li>&nbsp;"
					+ "<li><a href='javascript:void(0)'>上一页</a></li>&nbsp;<li><a href='javascript:void(0)'>下一页</a>"
					+ "</li>&nbsp;<li><a href='javascript:void(0)'>尾页</a></li>&nbsp;");
		} else if (currentPage.toString().equals("1")) {// 当前页为第一页
			sbOut.append(
					"<li><a href='javascript:void(0)'>首页</a></li>&nbsp;<li><a href='javascript:void(0)'>上一页</a></li>&nbsp;<li><a href='javascript:"
							+ clickMethod + "(" + (Integer.parseInt(currentPage.toString()) + 1)
							+ ")'>下一页</a></li>&nbsp;<li><a href='javascript:" + clickMethod + "(" + totalPage.toString()
							+ ")'>尾页</a></li>&nbsp;");
		} else if (currentPage.toString().equals(totalPage.toString())) {// 当关页为最后一页
			sbOut.append("<li><a href='javascript:" + clickMethod + "(1)'>首页</a></li>&nbsp;<li><a href='javascript:"
					+ clickMethod + "(" + (Integer.parseInt(currentPage.toString()) - 1)
					+ ")'>上一页</a></li>&nbsp;<li><a href='javascript:void(0)'>下一页</a></li>&nbsp;<li><a href='javascript:void(0)'>尾页</a></li>&nbsp;");
		} else {// 显示所有链接（首页，上一页，下一页，尾页）
			sbOut.append("<li><a href='javascript:" + clickMethod + "(1)'>首页</a></li>&nbsp;<li><a href='javascript:"
					+ clickMethod + "(" + (Integer.parseInt(currentPage.toString()) - 1)
					+ ")'>上一页</a></li>&nbsp;<li><a href='javascript:" + clickMethod + "("
					+ (Integer.parseInt(currentPage.toString()) + 1) + ")'>下一页</a></li>&nbsp;<li><a href='javascript:"
					+ clickMethod + "(" + totalPage.toString() + ")'>尾页</a></li>&nbsp;");
		}
		sbOut.append("<li>共 " + totalCount + " 条</li>&nbsp;<li>转到 <select  name='cu_pa' >");
		for (int i = 1; i < (Integer.parseInt(totalPage.toString()) + 1); i++) {
			if ((Integer.parseInt(currentPage.toString())) == i) {
				sbOut.append("<option selected value='" + i + "'>" + i + "</option>");
			} else {
				sbOut.append("<option  value='" + i + "'>" + i + "</option>");
			}
		}
		sbOut.append("</select>页</li>&nbsp;&nbsp;");

		sbOut.append("<li>每页显示<select name='pageSize'>");

		int tempPageSize = Integer.parseInt(pageSize.toString());

		if (pageSizeList != null && pageSizeList.length > 0) {
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

		return sbOut.toString();
	}

	public static Map<String, List<Dictionary>> getMap() {
		return map;
	}

}
