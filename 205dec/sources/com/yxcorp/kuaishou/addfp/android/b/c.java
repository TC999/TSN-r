package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    boolean f54555a;

    /* renamed from: b  reason: collision with root package name */
    int f54556b;

    /* renamed from: c  reason: collision with root package name */
    boolean f54557c;

    /* renamed from: d  reason: collision with root package name */
    String f54558d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.f54555a = true;
        if (TextUtils.isEmpty(str)) {
            this.f54555a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f54556b = jSONObject.optInt("errorCode", 2);
            this.f54557c = jSONObject.optBoolean("userSet", true);
            this.f54558d = jSONObject.optString("value", "KWE_OTHER");
        } catch (JSONException e4) {
            this.f54555a = false;
            e4.printStackTrace();
        }
    }

    public String a(boolean z3) {
        if (this.f54555a) {
            if (z3 != this.f54557c) {
                return "KWE_NPN";
            }
            int i4 = this.f54556b;
            return i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.f54558d) ? this.f54558d : "KWE_N";
        }
        return "KWE_OTHER";
    }
}
