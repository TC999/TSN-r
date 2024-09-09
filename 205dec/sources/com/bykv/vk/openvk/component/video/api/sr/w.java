package com.bykv.vk.openvk.component.video.api.sr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface w<T> extends com.bykv.vk.openvk.component.video.api.w.c {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    void c();

    void c(int i4);

    void c(Drawable drawable);

    void c(T t3, WeakReference<Context> weakReference, boolean z3);

    void c(boolean z3);

    void w();

    View xv();
}
