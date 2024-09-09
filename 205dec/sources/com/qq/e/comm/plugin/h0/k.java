package com.qq.e.comm.plugin.h0;

import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private static final String f44048c = "k";

    /* renamed from: a  reason: collision with root package name */
    private long f44049a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Long> f44050b = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i4) {
    }

    public void a() {
        this.f44050b.clear();
        this.f44049a = System.currentTimeMillis();
    }

    public void b(String str, int i4, com.qq.e.comm.plugin.n0.c cVar) {
        if (this.f44050b.containsKey(str)) {
            d1.a(f44048c, "recodingTimeTag, %s has recorded", str);
        } else if (this.f44049a <= 0) {
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.f44049a;
            this.f44050b.put(str, Long.valueOf(currentTimeMillis));
            com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(i4);
            hVar.b(currentTimeMillis).a(cVar);
            v.a(hVar);
        }
    }

    public void a(String str, int i4, com.qq.e.comm.plugin.n0.c cVar) {
        b(str, i4, cVar);
    }
}
