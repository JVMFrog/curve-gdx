package com.jvmfrog.curve.bluesgui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public class ElementSkin {
    NinePatchDrawable drawable = null;
    Texture texture = null;
    private final Color color = new Color(1, 1, 1, 1);

    public ElementSkin() {
    }

    public ElementSkin(Texture texture, int outlineSize) {
        drawable = createDrawableFromTexture(texture, outlineSize);
    }

    public ElementSkin(Texture texture) {
        this.texture = texture;
    }

    public void setColor(int rgba) {
        color.set(rgba);
    }

    public void draw(float x, float y, float w, float h) {
        Color batchColor = new Color(Graphic.BATCH.getColor());
        Graphic.BATCH.setColor(color);
        if (drawable != null)
            drawable.draw(Graphic.BATCH, x, y, w, h);
        if (texture != null)
            Graphic.BATCH.draw(texture, x, y, w, h);
        Graphic.BATCH.setColor(batchColor);
    }

    public static NinePatchDrawable createDrawableFromTexture(Texture texture, int outlineSize) {
        NinePatch ninePatch = new NinePatch(texture, outlineSize, outlineSize, outlineSize, outlineSize);
        return new NinePatchDrawable(ninePatch);
    }
}