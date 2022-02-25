package com.intkgc.curvegdx.backends;

import com.intkgc.curve.backends.Backend;
import com.intkgc.curve.input.Keyboard;
import com.intkgc.curve.utils.APKFileOpener;
import com.intkgc.curve.utils.FileDownloader;

public class DesktopBackend implements Backend {
    private final FileDownloader fileDownloader;

    public DesktopBackend() {
        fileDownloader = new DesktopFileDownloader();
    }

    @Override
    public FileDownloader fileDownloader() {
        return fileDownloader;
    }

    @Override
    public APKFileOpener apkOpener() {
        return null;
    }

    @Override
    public Keyboard keyboard() {
        return new DesktopKeyboard();
    }
}
