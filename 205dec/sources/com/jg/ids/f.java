package com.jg.ids;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public abstract class f implements i {

    /* renamed from: b  reason: collision with root package name */
    private static String f37819b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f37820c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f37821d = "";

    /* renamed from: a  reason: collision with root package name */
    protected Context f37822a;

    public f(Context context) {
        this.f37822a = null;
        this.f37822a = context;
        try {
            f37819b = k.a().b();
            f37820c = k.a().c();
            f37821d = k.a().d();
        } catch (Throwable th) {
        }
    }

    public final void a(String str) {
        try {
            f37819b = str;
            k.a().a(f37819b);
        } catch (Throwable th) {
        }
    }

    public final void b(String str) {
        try {
            f37820c = str;
            k.a().b(f37820c);
        } catch (Throwable th) {
        }
    }

    public final void c(String str) {
        try {
            f37821d = str;
            k.a().c(f37821d);
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.i
    public String a(Context context) {
        return f37820c;
    }

    @Override // com.jg.ids.i
    public String b(Context context) {
        return f37821d;
    }

    @Override // com.jg.ids.i
    public String c(Context context) {
        return f37819b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c() {
        return TextUtils.isEmpty(f37819b) || TextUtils.isEmpty(f37820c) || TextUtils.isEmpty(f37821d);
    }

    @Override // com.jg.ids.i
    public boolean d() {
        return true;
    }
}
