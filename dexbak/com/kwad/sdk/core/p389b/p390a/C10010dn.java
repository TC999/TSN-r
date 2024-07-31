package com.kwad.sdk.core.p389b.p390a;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.crash.model.C10691b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dn */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10010dn implements InterfaceC10273d<C10691b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10691b c10691b, JSONObject jSONObject) {
        m27062a(c10691b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10691b c10691b, JSONObject jSONObject) {
        return m27061b(c10691b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27062a(C10691b c10691b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10691b.aGf = jSONObject.optInt("funcSwitch");
        c10691b.aGg = jSONObject.optString("minSdkVersion");
        if (JSONObject.NULL.toString().equals(c10691b.aGg)) {
            c10691b.aGg = "";
        }
        c10691b.sdkType = jSONObject.optInt("sdkType");
        c10691b.aGh = jSONObject.optString("md5V7");
        if (JSONObject.NULL.toString().equals(c10691b.aGh)) {
            c10691b.aGh = "";
        }
        c10691b.aGi = jSONObject.optString("md5V8");
        if (JSONObject.NULL.toString().equals(c10691b.aGi)) {
            c10691b.aGi = "";
        }
        c10691b.version = jSONObject.optString(ConstantHelper.LOG_VS);
        if (JSONObject.NULL.toString().equals(c10691b.version)) {
            c10691b.version = "";
        }
        c10691b.aGj = jSONObject.optString("v7Url");
        if (JSONObject.NULL.toString().equals(c10691b.aGj)) {
            c10691b.aGj = "";
        }
        c10691b.aGk = jSONObject.optString("v8Url");
        if (JSONObject.NULL.toString().equals(c10691b.aGk)) {
            c10691b.aGk = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27061b(C10691b c10691b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c10691b.aGf;
        if (i != 0) {
            C11126t.putValue(jSONObject, "funcSwitch", i);
        }
        String str = c10691b.aGg;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "minSdkVersion", c10691b.aGg);
        }
        int i2 = c10691b.sdkType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "sdkType", i2);
        }
        String str2 = c10691b.aGh;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "md5V7", c10691b.aGh);
        }
        String str3 = c10691b.aGi;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "md5V8", c10691b.aGi);
        }
        String str4 = c10691b.version;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, ConstantHelper.LOG_VS, c10691b.version);
        }
        String str5 = c10691b.aGj;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "v7Url", c10691b.aGj);
        }
        String str6 = c10691b.aGk;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "v8Url", c10691b.aGk);
        }
        return jSONObject;
    }
}
