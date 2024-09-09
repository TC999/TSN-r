package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.try  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Ctry {

    /* renamed from: a  reason: collision with root package name */
    public static Context f52366a;

    public static synchronized boolean a(Context context) {
        synchronized (Ctry.class) {
            if (f52366a != null) {
                return true;
            }
            if (context == null) {
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return false;
            }
            f52366a = applicationContext;
            return true;
        }
    }

    public static synchronized Context a() {
        Context context;
        synchronized (Ctry.class) {
            context = f52366a;
        }
        return context;
    }
}
