package com.mbridge.msdk.out;

import android.graphics.drawable.Drawable;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface OnImageLoadListener {
    void loadError(String str);

    void loadSuccess(Drawable drawable, int i4);
}
