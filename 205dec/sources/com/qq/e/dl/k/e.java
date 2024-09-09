package com.qq.e.dl.k;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends c {

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f47011a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        this.f47011a = a(str);
    }

    private Object b(JSONObject jSONObject) {
        Object a4;
        int i4 = 0;
        JSONObject jSONObject2 = jSONObject;
        while (true) {
            int i5 = i4 + 1;
            a4 = this.f47011a.get(i4).a(jSONObject2);
            if (i5 >= this.f47011a.size() || a4 == null) {
                break;
            }
            i4 = i5;
            jSONObject2 = a4;
        }
        return a4;
    }

    @Override // com.qq.e.dl.k.g
    public g a() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qq.e.dl.k.c
    public Object a(JSONObject jSONObject) {
        List<f> list;
        if (jSONObject == null || jSONObject.length() <= 0 || (list = this.f47011a) == null || list.size() <= 0) {
            return null;
        }
        Object b4 = b(jSONObject);
        return b4 == null ? m.a(jSONObject, this.f47011a) : b4;
    }

    private List<f> a(String str) {
        String[] split = str.split("\\.|\\[");
        if (split == null || split.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.endsWith("]")) {
                try {
                    arrayList.add(new f(Integer.parseInt(str2.substring(0, str2.length() - 1))));
                } catch (NumberFormatException unused) {
                    return null;
                }
            } else {
                arrayList.add(new f(str2));
            }
        }
        return arrayList;
    }
}
