package com.beizi.ad.internal.view;

import android.graphics.Canvas;
import com.beizi.ad.internal.view.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdWebView.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class g extends AdWebView {

    /* renamed from: d  reason: collision with root package name */
    f f14328d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AdViewImpl adViewImpl, f fVar) {
        super(adViewImpl);
        this.f14194b = f.f14291a[f.b.STARTING_EXPANDED.ordinal()];
        this.f14328d = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.beizi.ad.internal.view.AdWebView
    public void e() {
        super.e();
        this.f14328d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.ad.internal.view.AdWebView, android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
