import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

//	private static final Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
//	private static final Map<String, String> map = new HashMap<String, String>();
	private static final Map<String, String> map = new ConcurrentHashMap<String, String>();
	
	private static final Hashtable<String, String> table = new Hashtable<String,String>();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					map.put(String.valueOf(i), String.valueOf(i));
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				for (int i = 10; i < 2000; i++) {
					map.put(String.valueOf(i), String.valueOf(i));
				}
			}
		};

		t1.start();
		t2.start();
		Thread.sleep(1000);
		int loopIndex = 0;
		for(int i = 0 ; i < 2000 ; i ++){
			if(!String.valueOf(i).equals(map.get(String.valueOf(i)))){
				System.out.println(String.valueOf(i) + " != " + map.get(String.valueOf(i)));
				loopIndex++;
			}
		}
		System.err.println(loopIndex+"个不一样的");
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
	 * @param <E>
	 * 打印当前虚拟机的所有环境属性的变量和值
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
