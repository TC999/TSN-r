package com.kwad.components.core.webview.tachikoma.p335c;

import android.app.Activity;
import com.kwad.components.core.webview.tachikoma.AbstractC9340k;
import com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9291c;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.sdk.components.InterfaceC9870k;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.mvp.AbstractC10868a;
import com.kwad.sdk.widget.InterfaceC11147e;

/* renamed from: com.kwad.components.core.webview.tachikoma.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9267b extends AbstractC10868a {

    /* renamed from: SA */
    public StyleTemplate f29323SA;

    /* renamed from: Sy */
    public InterfaceC9291c f29324Sy;

    /* renamed from: YI */
    public DialogFragmentC9274e f29325YI;
    public InterfaceC9870k aaA;
    public AbstractC9340k aaB;
    public boolean aaC;
    public DialogFragmentC9274e.InterfaceC9276a aaD;
    public InterfaceC11147e aaz;
    public Activity mActivity;
    public AdResultData mAdResultData;

    /* renamed from: xn */
    public String f29326xn;

    /* renamed from: xs */
    public long f29327xs;

    /* renamed from: d */
    public final void m29160d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = C10485c.m25661n(adResultData);
    }

    @Override // com.kwad.sdk.mvp.AbstractC10868a
    public void release() {
        this.f29325YI = null;
        this.mActivity = null;
        this.aaz = null;
    }
}
