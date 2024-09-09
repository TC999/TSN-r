package com.acse.ottn.a;

import android.webkit.JavascriptInterface;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private a f4576a;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void a(JSONObject jSONObject, com.acse.ottn.dsbridge.a aVar);
    }

    public void a(a aVar) {
        this.f4576a = aVar;
    }

    @JavascriptInterface
    public void copy(Object obj, com.acse.ottn.dsbridge.a aVar) {
        this.f4576a.a((JSONObject) obj, aVar);
    }
}
