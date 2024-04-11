package source.ch08_class.cafe;

import java.util.ArrayList;

public class Cafe {
    private String name;
    private String phone;
    private ArrayList<Menu> menuList;

    public Cafe() {
        menuList = new ArrayList<>();
    }

    public Cafe(String name, String phone, ArrayList<Menu> menuList) {
        this.name = name;
        this.phone = phone;
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", menuList=" + menuList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }
}
