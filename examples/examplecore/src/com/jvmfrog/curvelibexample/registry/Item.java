package com.jvmfrog.curvelibexample.registry;

import com.badlogic.gdx.Gdx;
import com.jvmfrog.curve.registry.RegistryObject;

public class Item extends RegistryObject {
    @Override
    public void init() {
        Gdx.app.log("item", "string id: " + stringId + " int id: " + id);
    }
}
