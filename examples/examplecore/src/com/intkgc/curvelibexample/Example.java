package com.intkgc.curvelibexample;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.intkgc.curve.CurveGDX;
import com.intkgc.curve.config.Settings;
import com.intkgc.curve.utils.FileDownloader;
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

        CurveGDX.fileDownloader.download(
                "https://github.com/JVMFrog/curve-gdx/raw/master/README.md",
                Gdx.files.external("CurveGDXExamples/README.md"),
                new FileDownloader.ProgressListener() {
                    @Override
                    public void update(int progress) {
                        Gdx.app.log("FileDownloader", "File downloading: " + progress + "%");
                    }

                    @Override
                    public void done() {
                        Gdx.app.log("FileDownloader", "File downloaded");
                    }

                    @Override
                    public void failed(Throwable throwable) {
                        Gdx.app.error("Error", "failed", throwable);
                    }
                }
        );

        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                Gdx.app.postRunnable(() -> Gdx.input.setOnscreenKeyboardVisible(true));
            }
        }, 1000).run();
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        Gdx.app.log("Keyboard size", String.valueOf(CurveGDX.keyboard.getKeyboardSize()));
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
