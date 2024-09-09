package com.jg.ids.i;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public class g implements com.jg.ids.m.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f37837a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f37838b;

    /* renamed from: c  reason: collision with root package name */
    private Object f37839c;

    public static boolean a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e4) {
            return false;
        }
    }

    public g(Context context) {
        this.f37837a = context;
        try {
            this.f37838b = Class.forName("android.app.ZteDeviceIdentifyManager");
            this.f37839c = this.f37838b.newInstance();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.jg.ids.m.a
    public boolean a() {
        return this.f37839c != null;
    }

    @Override // com.jg.ids.m.a
    public String b() {
        if (this.f37837a == null || this.f37838b == null || this.f37839c == null) {
            return "";
        }
        try {
            String str = (String) this.f37838b.getMethod("getOAID", Context.class).invoke(this.f37839c, this.f37837a);
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
