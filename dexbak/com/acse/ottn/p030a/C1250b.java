package com.acse.ottn.p030a;

import android.webkit.JavascriptInterface;
import com.acse.ottn.dsbridge.InterfaceC1539a;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.a.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1250b {

    /* renamed from: a */
    private InterfaceC1251a f2042a;

    /* renamed from: com.acse.ottn.a.b$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1251a {
        /* renamed from: a */
        void m57360a(JSONObject jSONObject, InterfaceC1539a interfaceC1539a);
    }

    /* renamed from: a */
    public void m57361a(InterfaceC1251a interfaceC1251a) {
        this.f2042a = interfaceC1251a;
    }

    @JavascriptInterface
    public void copy(Object obj, InterfaceC1539a interfaceC1539a) {
        this.f2042a.m57360a((JSONObject) obj, interfaceC1539a);
    }
}
