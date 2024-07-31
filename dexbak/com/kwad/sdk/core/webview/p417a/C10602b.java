package com.kwad.sdk.core.webview.p417a;

import android.graphics.Bitmap;
import android.webkit.WebChromeClient;
import androidx.annotation.Nullable;

/* renamed from: com.kwad.sdk.core.webview.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10602b extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    @Nullable
    public final Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
            createBitmap.eraseColor(0);
            return createBitmap;
        }
        return defaultVideoPoster;
    }
}
