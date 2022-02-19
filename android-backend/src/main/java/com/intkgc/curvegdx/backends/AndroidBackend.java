package com.intkgc.curvegdx.backends;

import android.content.Context;
import com.intkgc.curve.backends.Backend;
import com.intkgc.curve.utils.APKFileOpener;
import com.intkgc.curve.utils.FileDownloader;

public class AndroidBackend implements Backend {
    private final FileDownloader fileDownloader;
    private final APKFileOpener apkFileOpener;

    public AndroidBackend(Context context) {
        fileDownloader = new AndroidFileDownloader(context);
        apkFileOpener = new APKOpener(context);
    }

    @Override
    public FileDownloader fileDownloader() {
        return fileDownloader;
    }

    @Override
    public APKFileOpener apkOpener() {
        return apkFileOpener;
    }
}
