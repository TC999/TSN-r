package com.jg.ids;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final k f37850a = new k();

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f37851b = null;

    private k() {
    }

    public final void a(Context context) {
        if (this.f37851b == null) {
            this.f37851b = context.getSharedPreferences("jg_ids", 0);
        }
    }

    public static k a() {
        return f37850a;
    }

    public final String b() {
        return this.f37851b.getString("jg_aaid", "");
    }

    public final void a(String str) {
        SharedPreferences.Editor edit = this.f37851b.edit();
        edit.putString("jg_aaid", str);
        edit.commit();
    }

    public final String c() {
        return this.f37851b.getString("jg_vaid", "");
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = this.f37851b.edit();
        edit.putString("jg_vaid", str);
        edit.commit();
    }

    public final String d() {
        return this.f37851b.getString("jg_oaid", "");
    }

    public final void c(String str) {
        SharedPreferences.Editor edit = this.f37851b.edit();
        edit.putString("jg_oaid", str);
        edit.commit();
    }
}
