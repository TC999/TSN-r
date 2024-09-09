package com.qq.e.comm.plugin.q0.u.l;

import android.util.Pair;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.q0.u.i;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends i {

    /* renamed from: a  reason: collision with root package name */
    private final String f45634a;

    /* renamed from: b  reason: collision with root package name */
    private final int f45635b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f45636c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, int i4, com.qq.e.comm.plugin.n0.c cVar) {
        this.f45634a = str;
        this.f45635b = i4;
        this.f45636c = cVar;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "launchMiniProgram";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        v.a(1142010, this.f45636c, Integer.valueOf(this.f45635b));
        JSONObject d4 = dVar.d();
        if (d4 == null) {
            return;
        }
        Pair<Integer, Boolean> a4 = com.qq.e.comm.plugin.s0.b.a(a(d4));
        int intValue = ((Integer) a4.first).intValue();
        v.a(1142011, this.f45636c, Integer.valueOf(this.f45635b), Integer.valueOf(intValue), null);
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(intValue == 0);
        objArr[1] = Integer.valueOf(intValue);
        objArr[2] = a4.second;
        d1.a("MiniProgram \u6253\u5f00\u5c0f\u7a0b\u5e8f\u662f\u5426\u6210\u529f: %s, code = %s, \u662f\u5426\u9884\u4e0b\u8f7d\u4e86\u5c0f\u7a0b\u5e8f\u4ee3\u7801\u5305: %s", objArr);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("code", Integer.valueOf(intValue));
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
        hVar.c().a(new e(dVar, e.a.f45548c, jSONObject));
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("ad_trace_data", jSONObject.optString("ad_trace_data"));
            jSONObject2.putOpt("wx_appid", this.f45634a);
            jSONObject2.putOpt("username", jSONObject.optString("username"));
            jSONObject2.putOpt("path", jSONObject.optString("path"));
        } catch (JSONException unused) {
            d1.a("getLaunchInfo error");
        }
        return jSONObject2;
    }
}
