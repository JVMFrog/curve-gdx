package com.jvmfrog.curve.config;

import com.badlogic.gdx.files.FileHandle;

public interface SaveBackend {
    void put(String key, Object object);

    Object get(String key);

    boolean has(String key);

    void save(FileHandle file);

    void load(FileHandle file);
}
