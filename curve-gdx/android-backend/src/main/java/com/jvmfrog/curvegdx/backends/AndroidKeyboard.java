package com.jvmfrog.curvegdx.backends;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.jvmfrog.curve.input.Keyboard;

public class AndroidKeyboard implements Keyboard {
    private int keyboardHeight;

    public AndroidKeyboard(Activity activity) {
        final View root = activity.getWindow().getDecorView().findViewById(android.R.id.content);

        root.getViewTreeObserver().addOnGlobalLayoutListener(() -> {
            Rect visibleDisplayFrame = new Rect();
            root.getWindowVisibleDisplayFrame(visibleDisplayFrame);
            keyboardHeight = root.getHeight() - visibleDisplayFrame.height();
        });
    }


    @Override
    public int getKeyboardSize() {
        return keyboardHeight;
    }
}
