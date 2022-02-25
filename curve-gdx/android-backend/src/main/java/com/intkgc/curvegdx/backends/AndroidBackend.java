package com.intkgc.curvegdx.backends;

import android.app.Activity;
import android.content.Context;
import com.intkgc.curve.backends.Backend;
import com.intkgc.curve.input.Keyboard;
import com.intkgc.curve.utils.APKFileOpener;
import com.intkgc.curve.utils.FileDownloader;

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
