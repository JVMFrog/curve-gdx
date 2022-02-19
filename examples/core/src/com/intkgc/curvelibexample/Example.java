package com.intkgc.curvelibexample;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.intkgc.curve.config.Settings;
import com.intkgc.curvelibexample.registry.Items;
import com.intkgc.curvelibexample.registry.SomeItem;
import com.intkgc.curvelibexample.registry.SomeItem1;
import com.intkgc.curvelibexample.registry.SomeItem2;

public class Example extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        FileHandle settingsFile = Gdx.files.external("CurveTest/settings.json");
        if (!settingsFile.exists()) settingsFile.writeString("{}", false);
        Settings.load(settingsFile, SettingsExample.class);
        SettingsExample.testBoolean = true;
        Settings.save(settingsFile, SettingsExample.class);

        Items.registry.register(new SomeItem());
        Items.registry.register(new SomeItem1());
        Items.registry.register(new SomeItem2());

        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();


    }
}
