package com.beizi.ad.a.a;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TextureVideoViewOutlineProvider.java */
@RequiresApi(api = 21)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    private float f13244a;

    public f(float f4) {
        this.f13244a = f4;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.f13244a);
    }
}
