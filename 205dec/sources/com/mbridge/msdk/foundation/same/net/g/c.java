package com.mbridge.msdk.foundation.same.net.g;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import org.json.JSONObject;

/* compiled from: CommonMBListener.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class c extends com.mbridge.msdk.foundation.same.net.f<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39593a = "c";

    private void b(k<JSONObject> kVar) {
        JSONObject jSONObject = kVar.f39628a;
        if (jSONObject == null) {
            a("response result is null");
            return;
        }
        int optInt = jSONObject.optInt("status", -9999);
        if (optInt == -9999) {
            a(kVar.f39628a);
        } else if (optInt != 1 && optInt != 200) {
            String optString = kVar.f39628a.optString("msg");
            if (TextUtils.isEmpty(optString)) {
                optString = "error message is null";
            }
            a(optString);
        } else {
            a(kVar.f39628a.optJSONObject("data"));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(k<JSONObject> kVar) {
        if (kVar == null) {
            a("response is null");
            return;
        }
        com.mbridge.msdk.foundation.same.net.e.c cVar = kVar.f39630c;
        if (cVar == null) {
            b(kVar);
        } else if (cVar.f39545a == 204) {
            a(new JSONObject());
        } else {
            b(kVar);
        }
    }

    public abstract void a(String str);

    public abstract void a(JSONObject jSONObject);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        String str = f39593a;
        x.d(str, "errorCode = " + aVar.f39484a);
        a(com.mbridge.msdk.foundation.same.net.f.a.a(aVar));
    }
}
