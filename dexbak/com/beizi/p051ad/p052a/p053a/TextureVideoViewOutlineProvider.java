package com.beizi.p051ad.p052a.p053a;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 21)
/* renamed from: com.beizi.ad.a.a.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TextureVideoViewOutlineProvider extends ViewOutlineProvider {

    /* renamed from: a */
    private float f9549a;

    public TextureVideoViewOutlineProvider(float f) {
        this.f9549a = f;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.f9549a);
    }
}
