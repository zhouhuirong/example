package observer.impl;

import observer.Fan;
import observer.IDol;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements IDol {

    private List<Fan> fans = new ArrayList<>();
    @Override
    public void addFan(Fan fan) {
        fans.add(fan);
    }

    @Override
    public void delFan(Fan fan) {
        fans.remove(fan);
    }

    @Override
    public void notify(String message) {
        for (Fan f :fans) {
            f.update(message);
        }
    }
}
