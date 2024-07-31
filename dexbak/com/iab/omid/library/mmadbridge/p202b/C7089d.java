package com.iab.omid.library.mmadbridge.p202b;

import android.annotation.SuppressLint;
import android.content.Context;
import com.stub.StubApp;

/* renamed from: com.iab.omid.library.mmadbridge.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7089d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    private static C7089d f24237b = new C7089d();

    /* renamed from: a */
    private Context f24238a;

    private C7089d() {
    }

    /* renamed from: a */
    public static C7089d m34738a() {
        return f24237b;
    }

    /* renamed from: b */
    public void m34737b(Context context) {
        this.f24238a = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
    }

    /* renamed from: c */
    public Context m34736c() {
        return this.f24238a;
    }
}
