package com.amap.api.col.p0003l;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: MarkInfoManager.java */
/* renamed from: com.amap.api.col.3l.d7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d7 {

    /* renamed from: a  reason: collision with root package name */
    static WeakReference<b7> f7436a;

    /* compiled from: MarkInfoManager.java */
    /* renamed from: com.amap.api.col.3l.d7$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7437a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f7438b;

        a(String str, Context context) {
            this.f7437a = str;
            this.f7438b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (d7.class) {
                try {
                    String b4 = m4.b(q4.o(this.f7437a));
                    b7 a4 = i7.a(d7.f7436a);
                    i7.f(this.f7438b, a4, r5.f8901j, 50, 102400, "10");
                    if (a4.f7268e == null) {
                        a4.f7268e = new i6(new l6(new k6()));
                    }
                    String c4 = q4.c(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss");
                    c7.c(b4, q4.o(" \"timestamp\":\"" + c4 + "\",\"details\":" + this.f7437a), a4);
                }
            }
        }
    }

    public static void a(String str, Context context) {
        u5.r().submit(new a(str, context));
    }
}
