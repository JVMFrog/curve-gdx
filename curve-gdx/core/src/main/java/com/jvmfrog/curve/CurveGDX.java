package com.jvmfrog.curve;

import com.jvmfrog.curve.backends.Backend;
import com.jvmfrog.curve.input.Keyboard;
import com.jvmfrog.curve.utils.APKFileOpener;
import com.jvmfrog.curve.utils.FileDownloader;

public class CurveGDX {
    public static Keyboard keyboard;
    public static FileDownloader fileDownloader;
    /**
     * Only for android
     */
    public static APKFileOpener apkFileOpener;

    public static void init(Backend backend) {
        fileDownloader = backend.fileDownloader();
        apkFileOpener = backend.apkOpener();
        keyboard = backend.keyboard();
    }
}
