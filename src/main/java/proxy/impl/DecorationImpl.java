package proxy.impl;

import proxy.Decoration;

public class DecorationImpl implements Decoration {

    @Override
    public void decoration() {
        System.out.println("装修");
    }
}
