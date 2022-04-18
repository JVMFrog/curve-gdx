package com.jvmfrog.curve.config.backends;

import com.badlogic.gdx.files.FileHandle;
import com.jvmfrog.curve.config.SaveBackend;
import org.json.JSONObject;

public class JSONBackend implements SaveBackend {
    private JSONObject settings = new JSONObject();

    @Override
    public void put(String key, Object object) {
        settings.put(key, object);
    }

    @Override
    public Object get(String key) {
        return settings.get(key);
    }

    @Override
    public boolean has(String key) {
        return settings.has(key);
    }

    @Override
    public void save(FileHandle file) {
        file.writeString(settings.toString(), false);
        settings.clear();
    }

    @Override
    public void load(FileHandle file) {
        settings = new JSONObject(file.readString());
    }
}
