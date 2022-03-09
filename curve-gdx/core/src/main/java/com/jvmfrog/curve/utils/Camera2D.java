package com.jvmfrog.curve.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Camera2D extends OrthographicCamera {
    public int SIZE;
    public float X, Y;

    public void update(SpriteBatch b) {
        this.update();
        b.setProjectionMatrix(this.combined);
    }

    private void configure(int size) {
        int w = Gdx.graphics.getWidth(),
                h = Gdx.graphics.getHeight();

        if (h < w) {
            this.setToOrtho(false, size, size * h / w);
        } else {
            this.setToOrtho(false, size * w / h, size);
        }

        this.translate(X, Y);
    }

    public Camera2D(int size) {
        configure(size);
        SIZE = size;
    }

    public Camera2D() {
        this(Math.max(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
    }

    public void lookAt(float x, float y, boolean smooth) {
        if (!smooth) {
            this.translate(-X + x, -Y + y);
            X = x;
            Y = y;
        } else {
            float camX = MathUtils.lerp(X, x, 0.06f);
            float camY = MathUtils.lerp(Y, y, 0.06f);
            lookAt(camX, camY, false);
            X = camX;
            Y = camY;
        }
    }

    public void reconfigure(int size) {
        SIZE = size;
        configure(size);
    }

    public void reconfigure() {
        configure(SIZE);
    }
}
