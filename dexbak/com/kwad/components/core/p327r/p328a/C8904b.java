package com.kwad.components.core.p327r.p328a;

import com.kwad.components.core.p301l.C8688a;
import com.kwad.components.core.webview.tachikoma.AbstractC9340k;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.sdk.components.InterfaceC9871l;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* renamed from: com.kwad.components.core.r.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8904b extends C8688a {

    /* renamed from: SA */
    public StyleTemplate f28780SA;

    /* renamed from: SD */
    public InterfaceC9871l f28781SD;

    /* renamed from: SE */
    public AbstractC9340k f28782SE;
    public AdResultData mAdResultData;
    public AdBaseFrameLayout mRootContainer;

    public C8904b(C8902a c8902a) {
        super(c8902a);
    }

    /* renamed from: d */
    public final void m29632d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = C10485c.m25661n(adResultData);
    }
}
