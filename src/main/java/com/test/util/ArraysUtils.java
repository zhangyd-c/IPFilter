package com.test.util;

import java.util.ArrayList;
import java.util.List;

public class ArraysUtils {

	private class Group {
		public Integer data;
		public List<String> children;

		// 结果。
		@Override
		public String toString() {
			String str = "组" + data + ": ";
			for (int i = 0; i < children.size(); i++) {
				str += children.get(i) + " ";
			}

			return str;
		}
	}

	/**
	 * @Description 检索有序列表
	 * @author zhangyd
	 * @date 2016年8月8日 下午1:41:46
	 * @param data
	 */
	public void findOrderly(int[] data) {
		// 存储分类好的数据元素。
		List<Group> groups = new ArrayList<Group>();
		int index = 0, j = 0, len = data.length;
		while (index < len) {
			Group group = new Group();
			group.data = data[index];
			int t = group.data;
			List<String> children = new ArrayList<String>();
			for (j = index; j < data.length; j++) {
				int child = data[j];
				if (t == child) {
					// 同时记录该重复出现的元素在原数组中的下标j，便于查验、评估结果。
					children.add(child + "@" + j);
				} else {
					break;
				}
			}
			// 往后推进游标index
			index = j;
			group.children = children;
			groups.add(group);
		}
		for (int i = 0; i < groups.size(); i++) {
			Group g = groups.get(i);
			System.out.println(g);
		}
	}

	/**
	 * @Description 检索无序列表
	 * @author zhangyd
	 * @date 2016年8月8日 下午1:41:46
	 * @param data
	 */
	private void findDisorderly(int[] data) {
		System.out.println("还没实现...");
	}

	public static void main(String[] args) {
		// 测试数据：一个无序的int数组
		int[] disorderlyArrs = { 3, 1, 1, 2, 3, 5, 6, 78, 3, 4, 5 };
		int[] orderlyArrs = { 1, 2, 3, 3, 5, 5, 6, 7, 7, 8 };
 
		ArraysUtils t = new ArraysUtils();
		t.findOrderly(orderlyArrs);
	}

}
