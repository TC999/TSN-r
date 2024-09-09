package com.acse.ottn;

import android.webkit.JavascriptInterface;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    public a f6904a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a(JSONObject jSONObject, k0 k0Var);
    }

    public void a(a aVar) {
        this.f6904a = aVar;
    }

    @JavascriptInterface
    public void copy(Object obj, k0 k0Var) {
        this.f6904a.a((JSONObject) obj, k0Var);
    }
}
