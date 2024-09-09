package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f54553a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f54554b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f54553a = sharedPreferences;
            this.f54554b = sharedPreferences.edit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str) {
        this.f54554b.putString("kwtk", str);
        this.f54554b.commit();
    }

    public boolean a() {
        return this.f54553a.getBoolean("xytk", true);
    }

    public String b() {
        return this.f54553a.getString("kwtk", "");
    }
}
