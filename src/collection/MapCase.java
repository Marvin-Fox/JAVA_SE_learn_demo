package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapCase {

    public static void main(String[] args) {
        Map m = setValue();


        showMap(0, m);


    }

    private static Map setValue() {
        Map map = new HashMap();
        for (int i = 0; i < 1000; i++) {
            map.put(i, "a" + i);
        }
        return map;
    }

    /**
     * 遍历Map集合
     */
    private static void showMap(int num, final Map M) {
        if (num == 1) {
            long startTime = System.currentTimeMillis();
            showMap1(M);
            long endTime = System.currentTimeMillis();
            System.out.println("runTime:" + (endTime - startTime));
        } else if (num == 2) {
            long startTime = System.currentTimeMillis();
            showMap2(M);
            long endTime = System.currentTimeMillis();
            System.out.println("runTime:" + (endTime - startTime));
        } else {
            long startTime = System.currentTimeMillis();
            showMap1(M);
            long endTime = System.currentTimeMillis();


            long startTime2 = System.currentTimeMillis();
            showMap2(M);
            long endTime2 = System.currentTimeMillis();

            System.out.println("showMap1()_runTime:" + (endTime - startTime));
            System.out.println("showMap2()_runTime:" + (endTime2 - startTime2));

        }
    }

    private static void showMap1(Map<Object, Object> map) {
//		Set set=map.entrySet();
//		Iterator iterator=set.iterator();
//		while (iterator.hasNext()) {
//			Map.Entry entry=(Map.Entry<String, String>)iterator.next();
//			System.out.println(entry.getKey()+"~~"+entry.getValue());
//		}
        for (Entry<Object, Object> entry : map.entrySet()) {
//		     Object key = entry.getKey();
//		     Object value = entry.getValue();
            System.out.println(entry.getKey() + "~~" + entry.getValue());
        }
    }

    private static void showMap2(Map map) {
        for (Object object : map.keySet()) {
            System.out.println(object + "--" + map.get(object));
        }
    }

}
