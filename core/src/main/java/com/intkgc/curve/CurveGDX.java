package com.intkgc.curve;

import com.intkgc.curve.backends.Backend;
import com.intkgc.curve.utils.APKFileOpener;
import com.intkgc.curve.utils.FileDownloader;

public class CurveGDX {
    public static FileDownloader fileDownloader;
    /**
     * Only for android
     */
    public static APKFileOpener apkFileOpener;

    public static void init(Backend backend) {
        fileDownloader = backend.fileDownloader();
        apkFileOpener = backend.apkOpener();
    }
}
