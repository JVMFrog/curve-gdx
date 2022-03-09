package com.jvmfrog.curve.bluesgui.elements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jvmfrog.curve.bluesgui.ElementSkin;
import com.jvmfrog.curve.bluesgui.Skins;
import com.jvmfrog.curve.utils.Camera2D;

public class TextView extends AbstractTextView {
    private ElementSkin background;

    public TextView() {
        setStandardBackground(0);
    }

    public void setBackground(ElementSkin background) {
        this.background = background;
    }

    public void setStandardBackground(int i) {
        setBackground(Skins.getSkin("text_view_background_" + i));
    }

    @Override
    public void preRender(SpriteBatch batch, Camera2D cam) {
        if (background != null) background.draw(cam.X + x, cam.Y + y, width, height);
    }

    @Override
    protected void tick(Camera2D cam) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void onClick(boolean onElement) {
    }
}