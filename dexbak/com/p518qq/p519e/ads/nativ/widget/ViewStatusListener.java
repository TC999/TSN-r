package com.p518qq.p519e.ads.nativ.widget;

import android.view.MotionEvent;

/* renamed from: com.qq.e.ads.nativ.widget.ViewStatusListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ViewStatusListener {
    void onAttachToWindow();

    void onDetachFromWindow();

    void onDispatchTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z);

    void onWindowVisibilityChanged(int i);
}
