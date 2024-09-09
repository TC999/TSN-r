package com.jg.ids;

import android.content.Context;
import android.content.pm.PackageManager;
import com.acse.ottn.f3;
import java.lang.reflect.Constructor;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public class j implements com.jg.ids.m.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f37846a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f37847b;

    /* renamed from: c  reason: collision with root package name */
    private Object f37848c;

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e4) {
            str3 = null;
        }
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    public static boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception e4) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.coloros.mcs", 0) != null;
        } catch (PackageManager.NameNotFoundException e4) {
            return false;
        }
    }

    public j(Context context) {
        this.f37846a = context;
        try {
            this.f37847b = Class.forName("android.app.ZteDeviceIdentifyManager");
            Constructor<?> declaredConstructor = this.f37847b.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            this.f37848c = declaredConstructor.newInstance(context);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.jg.ids.m.a
    public boolean a() {
        return this.f37848c != null;
    }

    @Override // com.jg.ids.m.a
    public String b() {
        if (this.f37846a == null || this.f37847b == null || this.f37848c == null) {
            return "";
        }
        try {
            String str = (String) this.f37847b.getMethod("getOAID", Context.class).invoke(this.f37848c, this.f37846a);
            if (str != null) {
                if (str.length() != 0) {
                    return str;
                }
            }
            return "";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }
}
