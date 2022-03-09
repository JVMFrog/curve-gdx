package com.jvmfrog.curve.backends;

import com.jvmfrog.curve.input.Keyboard;
import com.jvmfrog.curve.utils.APKFileOpener;
import com.jvmfrog.curve.utils.FileDownloader;

public interface Backend {
    FileDownloader fileDownloader();

    APKFileOpener apkOpener();

    Keyboard keyboard();
}
