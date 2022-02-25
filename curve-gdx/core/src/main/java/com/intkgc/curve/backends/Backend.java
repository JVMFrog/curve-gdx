package com.intkgc.curve.backends;

import com.intkgc.curve.input.Keyboard;
import com.intkgc.curve.utils.APKFileOpener;
import com.intkgc.curve.utils.FileDownloader;

public interface Backend {
    FileDownloader fileDownloader();

    APKFileOpener apkOpener();

    Keyboard keyboard();
}
