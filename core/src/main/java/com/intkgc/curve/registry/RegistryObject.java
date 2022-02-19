package com.intkgc.curve.registry;

public abstract class RegistryObject {
    protected int id;
    protected String stringId;

    public int getId() {
        return id;
    }

    public String getStringId() {
        return stringId;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected void setStringId(String stringId) {
        this.stringId = stringId;
    }

    /**
     * The method is called after the object is registered
     * */
    public abstract void init();
}
