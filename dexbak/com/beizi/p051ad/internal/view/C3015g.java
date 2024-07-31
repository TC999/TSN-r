package com.beizi.p051ad.internal.view;

import android.graphics.Canvas;
import com.beizi.p051ad.internal.view.MRAIDImplementation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdWebView.java */
/* renamed from: com.beizi.ad.internal.view.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3015g extends AdWebView {

    /* renamed from: d */
    MRAIDImplementation f10763d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3015g(AdViewImpl adViewImpl, MRAIDImplementation mRAIDImplementation) {
        super(adViewImpl);
        this.f10627b = MRAIDImplementation.f10726a[MRAIDImplementation.EnumC3014b.STARTING_EXPANDED.ordinal()];
        this.f10763d = mRAIDImplementation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.beizi.p051ad.internal.view.AdWebView
    /* renamed from: e */
    public void mo49095e() {
        super.mo49095e();
        this.f10763d.m49123a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.p051ad.internal.view.AdWebView, android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
