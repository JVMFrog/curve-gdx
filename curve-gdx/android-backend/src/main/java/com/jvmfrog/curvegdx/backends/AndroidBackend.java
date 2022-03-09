package com.jvmfrog.curvegdx.backends;

import android.app.Activity;
import com.jvmfrog.curve.backends.Backend;
import com.jvmfrog.curve.input.Keyboard;
import com.jvmfrog.curve.utils.APKFileOpener;
import com.jvmfrog.curve.utils.FileDownloader;

public class AndroidBackend implements Backend {
    private final FileDownloader fileDownloader;
    private final APKFileOpener apkFileOpener;
    private final Keyboard keyboard;

    public AndroidBackend(Activity activity) {
        fileDownloader = new AndroidFileDownloader(activity);
        apkFileOpener = new APKOpener(activity);
        keyboard = new AndroidKeyboard(activity);
    }

    @Override
    public FileDownloader fileDownloader() {
        return fileDownloader;
    }

    @Override
    public APKFileOpener apkOpener() {
        return apkFileOpener;
    }

    @Override
    public Keyboard keyboard() {
        return keyboard;
    }
}
