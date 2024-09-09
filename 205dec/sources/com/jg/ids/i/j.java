package com.jg.ids.i;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public class j implements com.jg.ids.i {

    /* renamed from: a  reason: collision with root package name */
    private Context f37842a;

    /* renamed from: b  reason: collision with root package name */
    private com.jg.ids.m.a f37843b;

    /* renamed from: c  reason: collision with root package name */
    private com.jg.ids.m.a f37844c;

    /* renamed from: d  reason: collision with root package name */
    private com.jg.ids.m.a f37845d = null;

    public static boolean d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.oplus.stdid", 0) != null;
        } catch (PackageManager.NameNotFoundException e4) {
            return false;
        }
    }

    public j(Context context) {
        this.f37842a = context;
        this.f37843b = new com.jg.ids.j(context);
        this.f37844c = new g(context);
    }

    @Override // com.jg.ids.i
    public String a(Context context) {
        return null;
    }

    @Override // com.jg.ids.i
    public String b(Context context) {
        return this.f37845d.b();
    }

    @Override // com.jg.ids.i
    public String c(Context context) {
        return null;
    }

    @Override // com.jg.ids.i
    public boolean d() {
        if (this.f37842a == null) {
            return false;
        }
        if (this.f37843b.a()) {
            this.f37845d = this.f37843b;
        }
        if (this.f37844c.a()) {
            this.f37845d = this.f37844c;
        }
        return this.f37845d != null;
    }
}
