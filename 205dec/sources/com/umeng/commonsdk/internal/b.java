package com.umeng.commonsdk.internal;

import android.content.Context;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMInternalData.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f53451b;

    /* renamed from: a  reason: collision with root package name */
    private Context f53452a;

    /* renamed from: c  reason: collision with root package name */
    private c f53453c;

    private b(Context context) {
        this.f53452a = context;
        this.f53453c = new c(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f53451b == null) {
                f53451b = new b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            bVar = f53451b;
        }
        return bVar;
    }

    public c a() {
        return this.f53453c;
    }
}
