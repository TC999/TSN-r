package com.kwad.components.core.webview.tachikoma;

import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.widget.InterfaceC11147e;

/* renamed from: com.kwad.components.core.webview.tachikoma.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC9339j {
    /* renamed from: a */
    void mo28991a(C9031a.C9033a c9033a);

    /* renamed from: a */
    void mo28990a(C9109aw c9109aw);

    /* renamed from: a */
    void mo28989a(TKRenderFailReason tKRenderFailReason);

    /* renamed from: a */
    void mo28988a(C9216o c9216o);

    /* renamed from: a */
    void mo28987a(C9218p c9218p);

    /* renamed from: a */
    void mo28986a(C9252m c9252m);

    /* renamed from: a */
    void mo28985a(C9259t c9259t);

    /* renamed from: a */
    void mo28984a(WebCloseStatus webCloseStatus);

    /* renamed from: a */
    void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b);

    /* renamed from: a */
    void mo28982a(@Nullable C10640a c10640a);

    /* renamed from: b */
    void mo28981b(C9043ac.C9044a c9044a);

    @MainThread
    /* renamed from: bF */
    void mo28980bF();

    /* renamed from: bG */
    void mo28979bG();

    FrameLayout getTKContainer();

    String getTKReaderScene();

    String getTkTemplateId();

    InterfaceC11147e getTouchCoordsView();
}
