package com.intkgc.curve.bluesgui;

public interface InterfaceController {
    void init();

    void tick();

    void onOpen();

    void onClose();

    void preRender();

    void postRender();
}