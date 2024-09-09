package com.qq.e.comm.plugin.m.c;

import android.provider.Settings;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.y;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f44650a = "d";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final String f44651a = d.a();
    }

    static /* synthetic */ String a() {
        return d();
    }

    public static String b() {
        if (GlobalSetting.isAgreePrivacyStrategy() && c()) {
            return a.f44651a;
        }
        return null;
    }

    private static boolean c() {
        return (com.qq.e.comm.plugin.d0.a.d().f().a("adidon", 1) == 1) && (GlobalSetting.isAgreeReadAndroidId() && !y.b("android_id"));
    }

    private static String d() {
        String str;
        try {
            str = Settings.Secure.getString(com.qq.e.comm.plugin.d0.a.d().a().getContentResolver(), "android_id");
        } catch (Throwable th) {
            d1.a(f44650a + "Read AndroidId: " + th.getMessage(), th);
            str = "";
        }
        String str2 = f44650a;
        d1.a(str2, "android id = " + str);
        return str;
    }
}
