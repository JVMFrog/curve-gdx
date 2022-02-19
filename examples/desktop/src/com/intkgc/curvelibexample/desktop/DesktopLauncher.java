package com.intkgc.curvelibexample.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.intkgc.curve.CurveGDX;
import com.intkgc.curvegdx.backends.DesktopBackend;
import com.intkgc.curvelibexample.Example;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        CurveGDX.init(new DesktopBackend());
        new LwjglApplication(new Example(), config);
    }
}
