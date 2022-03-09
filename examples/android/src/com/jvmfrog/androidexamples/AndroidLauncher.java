package com.jvmfrog.androidexamples;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.jvmfrog.curve.CurveGDX;
import com.jvmfrog.curvegdx.backends.AndroidBackend;
import com.jvmfrog.curvelibexample.Example;

public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        CurveGDX.init(new AndroidBackend(this));
        initialize(new Example(), config);
    }
}
