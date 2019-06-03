package nl.qien.motorbike.mockitoannotations.captor;

import java.util.List;

public class Garage {

    private List<String> list;


    public void add(String c) {
        this.list.add(c);
    }

}
