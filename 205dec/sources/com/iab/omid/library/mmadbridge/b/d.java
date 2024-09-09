package com.iab.omid.library.mmadbridge.b;

import android.annotation.SuppressLint;
import android.content.Context;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static d f37719b = new d();

    /* renamed from: a  reason: collision with root package name */
    private Context f37720a;

    private d() {
    }

    public static d a() {
        return f37719b;
    }

    public void b(Context context) {
        this.f37720a = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
    }

    public Context c() {
        return this.f37720a;
    }
}
