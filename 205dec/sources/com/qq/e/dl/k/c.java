package com.qq.e.dl.k;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class c extends a {
    @Override // com.qq.e.dl.k.g
    public int a(JSONObject... jSONObjectArr) {
        i f4 = f(jSONObjectArr);
        if (f4 == null) {
            return 0;
        }
        return f4.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object a(JSONObject jSONObject);

    @Override // com.qq.e.dl.k.g
    public int b(JSONObject... jSONObjectArr) {
        Object a4;
        Integer b4;
        if (jSONObjectArr == null || jSONObjectArr.length <= 0 || (a4 = a(jSONObjectArr[0])) == null || (b4 = super.b(a4)) == null) {
            return 0;
        }
        return b4.intValue();
    }

    @Override // com.qq.e.dl.k.g
    public Object c(JSONObject... jSONObjectArr) {
        if (jSONObjectArr == null || jSONObjectArr.length <= 0) {
            return null;
        }
        return a(jSONObjectArr[0]);
    }

    @Override // com.qq.e.dl.k.g
    public float d(JSONObject... jSONObjectArr) {
        Object a4;
        Float a5;
        if (jSONObjectArr == null || jSONObjectArr.length <= 0 || (a4 = a(jSONObjectArr[0])) == null || (a5 = super.a(a4)) == null) {
            return 0.0f;
        }
        return a5.floatValue();
    }

    @Override // com.qq.e.dl.k.g
    public String e(JSONObject... jSONObjectArr) {
        if (jSONObjectArr == null || jSONObjectArr.length <= 0) {
            return null;
        }
        return super.d(a(jSONObjectArr[0]));
    }

    @Override // com.qq.e.dl.k.g
    public i f(JSONObject... jSONObjectArr) {
        Object a4;
        i c4;
        return (jSONObjectArr == null || jSONObjectArr.length <= 0 || (a4 = a(jSONObjectArr[0])) == null || (c4 = super.c(a4)) == null) ? new i(0) : c4;
    }

    public String toString() {
        return null;
    }
}
