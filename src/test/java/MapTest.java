import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

public class MapTest {

//	private static final HashMap<String, String> map = new HashMap<String, String>();
	private static final Hashtable<String, String> table = new Hashtable<String,String>();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					table.put(String.valueOf(i), String.valueOf(i));
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				for (int i = 1000; i < 2000; i++) {
					table.put(String.valueOf(i), String.valueOf(i));
				}
			}
		};

		t1.start();
		t2.start();

		System.out.println(table.size() + "-" + table.keySet().size());
		for (int l = 0; l < 2000; l++) {
			// 如果key和value不同，说明在两个线程put的过程中出现异常。
			if (!String.valueOf(l).equals(table.get(String.valueOf(l)))) {
				System.err.println(String.valueOf(l) + ":" + table.get(String.valueOf(l)));
			}
		}
	}

	public static void testMap() {
		Integer a = 1;
		long start = 0;
		long end = 0;
		// 先垃圾回收
		System.gc();
		start = Runtime.getRuntime().freeMemory();
		HashMap map = new HashMap();
		for (int i = 0; i < 10000000; i++) {
			map.put(i, a);
		}
		// 快要计算的时,再清理一次
		System.gc();
		end = Runtime.getRuntime().freeMemory();
		System.out.println("一个HashMap对象占内存:" + (end - start));
	}

	/**
	 * 2013-4-2
	 * 
	 * @param <E>
	 * @张亚东 （3）打印当前虚拟机的所有环境属性的变量和值
	 */
	public static <E> void printJVMProperty() {
		Properties sp = System.getProperties();
		Enumeration<?> e = sp.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			System.out.println(key + "=" + sp.getProperty(key));
		}
	}

}
