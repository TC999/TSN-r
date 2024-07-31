package com.kwad.sdk.components;

import android.view.View;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10631g;
import java.util.Map;

/* renamed from: com.kwad.sdk.components.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC9876q {
    /* renamed from: a */
    void mo27485a(InterfaceC9869j interfaceC9869j);

    /* renamed from: a */
    void mo27484a(InterfaceC9874o interfaceC9874o);

    /* renamed from: a */
    void mo27483a(String str, String str2, InterfaceC9875p interfaceC9875p);

    /* renamed from: aY */
    InterfaceC9872m mo27482aY(String str);

    /* renamed from: b */
    void mo27481b(InterfaceC10631g interfaceC10631g);

    /* renamed from: c */
    void mo27480c(InterfaceC10625a interfaceC10625a);

    Object execute(String str);

    int getUniqId();

    View getView();

    void onDestroy();

    void setCustomEnv(Map<String, Object> map);
}
