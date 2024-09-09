package com.umeng.socialize.shareboard.widgets;

import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class MotionEventCompat {
    static final int ACTION_MASK = 255;
    static final int ACTION_POINTER_DOWN = 5;
    static final int ACTION_POINTER_INDEX_MASK = 65280;
    static final int ACTION_POINTER_INDEX_SHIFT = 8;
    static final int ACTION_POINTER_UP = 6;

    MotionEventCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getActionIndex(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }
}
