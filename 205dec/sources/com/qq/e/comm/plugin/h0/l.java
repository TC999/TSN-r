package com.qq.e.comm.plugin.h0;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l {

    /* renamed from: b  reason: collision with root package name */
    private static volatile l f44051b;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, k> f44052a = new ConcurrentHashMap();

    private l() {
    }

    public static l a() {
        if (f44051b == null) {
            synchronized (l.class) {
                if (f44051b == null) {
                    f44051b = new l();
                }
            }
        }
        return f44051b;
    }

    public k b(int i4) {
        k kVar = this.f44052a.get(Integer.valueOf(i4));
        if (kVar == null) {
            k kVar2 = new k(i4);
            this.f44052a.put(Integer.valueOf(i4), kVar2);
            return kVar2;
        }
        return kVar;
    }

    public k c(int i4) {
        a(i4);
        return b(i4);
    }

    public void a(int i4) {
        this.f44052a.remove(Integer.valueOf(i4));
    }
}
