package lib.algo.sort;

import java.util.*;

public class CollectionSort {
    public void sorting(List<ThisClassObj> param) {

        System.out.println(">>>>>>>>>> BEFORE >>>>>>>>>>>");
        System.out.println(param);
        Collections.sort(param, new Comparator<ThisClassObj>() {

            @Override
            public int compare(ThisClassObj o1, ThisClassObj o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>> AFTER >>>>>>>>>>>");
        System.out.println(param);
    }

    public static void main(String[] args) {
        List<ThisClassObj> list = new ArrayList<>();
        for(int i=0; i<100; i++) {
            double d = Math.random()* 100;
            int rand = (int) d;
            ThisClassObj obj = new ThisClassObj(rand, "name" + i,"" + rand % 7);
            list.add(obj);
        }

        new CollectionSort().sorting(list);
    }

}


class ThisClassObj{
    Integer id;
    String name;
    String address;

    public Integer getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    ThisClassObj(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString(){
        return "\nid: " + id + "   , name: " + name + "   , address:" + address;
    }
}