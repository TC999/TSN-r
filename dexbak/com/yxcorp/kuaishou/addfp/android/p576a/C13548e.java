package com.yxcorp.kuaishou.addfp.android.p576a;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.yxcorp.kuaishou.addfp.android.a.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13548e {

    /* renamed from: a */
    private SharedPreferences f40046a;

    /* renamed from: b */
    private SharedPreferences.Editor f40047b;

    public C13548e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f40046a = sharedPreferences;
            this.f40047b = sharedPreferences.edit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m12889a(String str) {
        this.f40047b.putString("kwtk", str);
        this.f40047b.commit();
    }

    /* renamed from: a */
    public boolean m12890a() {
        return this.f40046a.getBoolean("xytk", true);
    }

    /* renamed from: b */
    public String m12888b() {
        return this.f40046a.getString("kwtk", "");
    }
}
