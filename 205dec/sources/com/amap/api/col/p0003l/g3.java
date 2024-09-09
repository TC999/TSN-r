package com.amap.api.col.p0003l;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: OverlayerStrategy.java */
/* renamed from: com.amap.api.col.3l.g3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g3 implements e3 {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, a> f7803a = new ConcurrentHashMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: OverlayerStrategy.java */
    /* renamed from: com.amap.api.col.3l.g3$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class a {

        /* renamed from: a  reason: collision with root package name */
        String f7804a;

        /* renamed from: b  reason: collision with root package name */
        String f7805b;

        /* renamed from: c  reason: collision with root package name */
        int f7806c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f7807d = new AtomicInteger(0);

        public a(int i4, String str, String str2) {
            this.f7804a = str;
            this.f7805b = str2;
            this.f7806c = i4;
        }

        public final int a() {
            return this.f7807d.incrementAndGet();
        }
    }

    private static void b(int i4, String str, String str2, int i5) {
        if (i4 == 0) {
            b5 c4 = b5.c(a3.s());
            c4.h(a5.b(str, str2 + " counter " + i5));
        } else {
            b5 c5 = b5.c(a3.s());
            c5.h(a5.b(str, str2 + " counter " + i5));
        }
        if (b3.f7205b) {
            d(i4, str, str2 + " counter " + i5);
        }
    }

    private static String c(int i4, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    private static void d(int i4, String str, String str2) {
        if (i4 == 0) {
            Log.i("linklog", str + " " + str2);
            return;
        }
        Log.e("linklog", str + " " + str2);
    }

    @Override // com.amap.api.col.p0003l.e3
    public final void a(int i4, String str, String str2) {
        try {
            String c4 = c(i4, str, str2);
            a aVar = f7803a.get(c4);
            if (aVar == null) {
                aVar = new a(i4, str, str2);
                f7803a.put(c4, aVar);
            }
            if (aVar.a() > 100) {
                b(aVar.f7806c, aVar.f7804a, aVar.f7805b, aVar.f7807d.get());
                f7803a.remove(c4);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0003l.e3
    public final void a() {
        try {
            for (Map.Entry<String, a> entry : f7803a.entrySet()) {
                a value = entry.getValue();
                if (value != null) {
                    b(value.f7806c, value.f7804a, value.f7805b, value.f7807d.get());
                }
            }
            f7803a.clear();
            b5.c(a3.s()).e();
        } catch (Throwable unused) {
        }
    }
}
