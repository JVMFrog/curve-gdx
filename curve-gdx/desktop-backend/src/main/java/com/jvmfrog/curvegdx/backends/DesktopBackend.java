package com.jvmfrog.curvegdx.backends;

import com.jvmfrog.curve.backends.Backend;
import com.jvmfrog.curve.input.Keyboard;
import com.jvmfrog.curve.utils.APKFileOpener;
import com.jvmfrog.curve.utils.FileDownloader;

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
