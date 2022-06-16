package java_reflect;


import java.io.Serializable;

public class UserBean implements Serializable {

    public UserBean() {
        System.out.println("无参构造");
    }

    public UserBean(String username) {
        System.out.println("有参构造（username）=" + username);
    }

    private UserBean(int id) {
        System.out.println("private有参构造（id）=" + id);
    }

    public UserBean(int id, String username) {
        System.out.println("有参构造（id,username）=" + id + "~" + username);
    }

    public String aString;
    private int id;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println("username=" + username);
    }

    public String getResult() {
        return "结果";
    }

    private void testMethod(String message) {
        System.out.println("testMethod(String)");
    }


}
