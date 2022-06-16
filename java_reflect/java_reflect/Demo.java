package java_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] args) {

        // System.out.println(new UserBean().getClass());
        try {
//			getConstructor1();
//			RunConstructor();
//			getField1();
//			setField1();
//			getMethod1();
            runMethod1();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void getConstructor1() throws ClassNotFoundException {
        Class class1 = Class.forName("java_reflect.UserBean");

        System.out.println("===========获取所有公有构造方法=============");
        Constructor[] constructor = class1.getConstructors();
        for (Constructor obj : constructor) {
            System.out.println(obj);
        }

        System.out.println("==========所有的构造方法(包括：私有、受保护、默认、公有)==============");
        Constructor[] constructor2 = class1.getDeclaredConstructors();
        for (Constructor obj : constructor2) {
            System.out.println(obj);
        }
    }

    private static void RunConstructor() throws Exception {
        Class class1 = Class.forName("java_reflect.UserBean");

        System.out.println("===========运行公有无参构造方法=============");
        Constructor constructor = class1.getConstructor(null);//因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        constructor.newInstance();

        System.out.println("===========运行公有有参构造方法=============");
        Constructor constructor2 = class1.getConstructor(String.class);
        constructor2.newInstance("jerry");

        System.out.println("===========运行公有多参构造方法=============");
        Constructor constructor3 = class1.getConstructor(int.class, String.class);
        constructor3.newInstance(1, "jerry");

        System.out.println("===========运行私有有参构造方法=============");
        Constructor constructor4 = class1.getDeclaredConstructor(int.class);
        constructor4.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        constructor4.newInstance(2);
    }

    private static void getField1() throws Exception {
        Class class1 = Class.forName("java_reflect.UserBean");

        System.out.println("==========所有的公有成员变量==============");
        Field[] fields = class1.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("==========所有成员变量(包括：私有、受保护、默认、公有)==============");
        Field[] fields2 = class1.getDeclaredFields();
        for (Field f : fields2) {
            System.out.println(f);
        }
    }

    private static void setField1() throws Exception {
        Class class1 = Class.forName("java_reflect.UserBean");

        System.out.println("==========获取公有成员变量并赋值==============");
        Field field1 = class1.getField("aString");
        Object object = class1.newInstance();//生产对象
        field1.set(object, "aaa");//将aaa赋值给成员变量aString
        UserBean userBean = (UserBean) object;
        System.out.println(userBean.aString);//验证

        System.out.println("==========获取私有成员变量并赋值==============");
        Field field2 = class1.getDeclaredField("username");
        Object object2 = class1.newInstance();
        field2.setAccessible(true);//暴力反射，解除私有限定
        field2.set(object2, "jerry");
        UserBean userBean2 = (UserBean) object2;
        System.out.println(userBean2.getUsername());//验证
    }

    private static void getMethod1() throws Exception {
        Class class1 = Class.forName("java_reflect.UserBean");

        System.out.println("==========获取所有公有方法(包含了父类的方法也包含Object类)==============");
        Method[] methods = class1.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("==========获取所有方法，包括私有的(不包括继承的)==============");
        Method[] methods1 = class1.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }

    }

    private static void runMethod1() throws Exception {
        Class class1 = Class.forName("java_reflect.UserBean");

        System.out.println("==========获取公有方法，并运行拿到返回值==============");
        Method method = class1.getMethod("getResult", null);
        Object obj = class1.newInstance();//生产对象
        Object result = method.invoke(obj, null);//调用方法
        System.out.println("返回值=" + result);//验证方法返回值

        System.out.println("==========获取公有方法，传值并运行拿到返回值==============");
        Method method2 = class1.getMethod("setUsername", String.class);
        Object obj2 = class1.newInstance();//生产对象
        Object result2 = method2.invoke(obj2, "jerry");//调用方法
        System.out.println("返回值=" + result2);//验证方法返回值(void返回值为null)

        System.out.println("==========获取私有方法，并运行拿到返回值==============");
        Method method3 = class1.getDeclaredMethod("testMethod", String.class);
        method3.setAccessible(true);
        Object obj3 = class1.newInstance();//生产对象
        Object result3 = method3.invoke(obj3, "参数信息");//调用方法
        System.out.println("返回值=" + result3);//验证方法返回值

    }

}
