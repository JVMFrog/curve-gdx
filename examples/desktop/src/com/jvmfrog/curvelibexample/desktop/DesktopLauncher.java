package com.jvmfrog.curvelibexample.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jvmfrog.curve.CurveGDX;
import com.jvmfrog.curvegdx.backends.DesktopBackend;
import com.jvmfrog.curvelibexample.Example;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        CurveGDX.init(new DesktopBackend());
        new LwjglApplication(new Example(), config);
    }
}
