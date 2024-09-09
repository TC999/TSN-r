package com.qq.e.dl.i;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, b> f46971a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final d f46972b = new d();

    public b a(String str, String str2) {
        g a4;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (a4 = this.f46972b.a(str2)) == null) {
            return null;
        }
        b bVar = new b(str, a4);
        this.f46971a.put(bVar.f46932a, bVar);
        return bVar;
    }

    public b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f46971a.get(str);
    }

    public int a() {
        return this.f46972b.f46956a;
    }
}
