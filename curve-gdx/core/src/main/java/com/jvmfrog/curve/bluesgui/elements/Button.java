package com.jvmfrog.curve.bluesgui.elements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jvmfrog.curve.bluesgui.ElementSkin;
import com.jvmfrog.curve.bluesgui.Skins;
import com.jvmfrog.curve.utils.Camera2D;

public class Button extends AbstractTextView {
    private Texture icon;

    ElementSkin buttonUpSkin;
    ElementSkin buttonDownSkin;

    public boolean generatedTextures;
    private boolean locked = false;

    public Button(String ID, float X, float Y, float w, float h, ElementSkin BT, ElementSkin BP) {
        generatedTextures = false;
        createButton(ID, X, Y, w, h, BT, BP);
    }

    public Button(String ID, float X, float Y, float w, float h) {
        generatedTextures = true;
        createButton(ID, X, Y, w, h);
    }

    private void createButton(String ID, float X, float Y, float w, float h, ElementSkin BT, ElementSkin BP) {
        setPosition(X, Y);
        setSize(w, h);
        setSkin(BT, BP);
        setId(ID);
        setTextColor(Color.BLACK);
    }

    private void createButton(String ID, float X, float Y, float w, float h) {
        createButton(ID, X, Y, w, h, Skins.getSkin("button_up"), Skins.getSkin("button_down"));
    }

    public void setSkin(ElementSkin elementSkin0, ElementSkin elementSkin1) {
        this.buttonUpSkin = elementSkin0;
        this.buttonDownSkin = elementSkin1;
    }

    public void setIcon(Texture icon) {
        this.icon = icon;
    }

    public void lock(boolean b) {
        locked = b;
    }

    @Override
    public void preRender(SpriteBatch batch, Camera2D cam) {
    }

    @Override
    protected void tick(Camera2D cam) {
    }

    @Override
    public void renderTick(SpriteBatch b, Camera2D cam) {
        if (!locked)
            (isTouched() ? buttonDownSkin : buttonUpSkin).draw(cam.X + x, cam.Y + y, width, height);
        else buttonDownSkin.draw(cam.X + x, cam.Y + y, width, height);

        if (icon != null) {
            b.draw(icon, cam.X + x, cam.Y + y, width, height);
        }
        if (!text.equals("")) super.renderTick(b, cam);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void onClick(boolean onElement) {
    }
}
