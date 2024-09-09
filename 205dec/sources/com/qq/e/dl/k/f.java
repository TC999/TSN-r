package com.qq.e.dl.k;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f47012a;

    /* renamed from: b  reason: collision with root package name */
    private final int f47013b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        this.f47012a = str;
        this.f47013b = -1;
    }

    public String a() {
        return this.f47012a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(Object obj) {
        int i4;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) && (i4 = this.f47013b) >= 0) {
            return ((JSONArray) obj).opt(i4);
        }
        if (!(obj instanceof JSONObject) || TextUtils.isEmpty(this.f47012a)) {
            return null;
        }
        return ((JSONObject) obj).opt(this.f47012a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i4) {
        this.f47012a = null;
        this.f47013b = i4;
    }
}
