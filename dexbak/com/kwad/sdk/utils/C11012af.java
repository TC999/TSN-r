package com.kwad.sdk.utils;

import com.kwad.sdk.core.webview.InterfaceC10600a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import java.util.Map;

/* renamed from: com.kwad.sdk.utils.af */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11012af {
    private Map<String, InterfaceC10600a> aPr;
    private Map<String, InterfaceC10627c> aPs;

    /* renamed from: a */
    public final void m24137a(String str, InterfaceC10600a interfaceC10600a) {
        this.aPr.put(str, interfaceC10600a);
    }

    /* renamed from: b */
    public final void m24136b(String str, InterfaceC10627c interfaceC10627c) {
        this.aPs.put(str, interfaceC10627c);
    }

    /* renamed from: gA */
    public final InterfaceC10600a m24135gA(String str) {
        return this.aPr.get(str);
    }

    /* renamed from: gB */
    public final InterfaceC10627c m24134gB(String str) {
        return this.aPs.get(str);
    }

    public final void release() {
        for (InterfaceC10600a interfaceC10600a : this.aPr.values()) {
            interfaceC10600a.mo25351ok();
        }
        this.aPr.clear();
        this.aPs.clear();
    }
}
