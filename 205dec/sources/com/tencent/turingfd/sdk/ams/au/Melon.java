package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Melon {
    public static boolean a(Context context) {
        Context context2;
        PackageInfo packageInfo;
        if (context.getPackageManager() == null) {
            return false;
        }
        String a4 = Cextends.a(Cextends.f52281l);
        try {
            if (TextUtils.isEmpty(a4)) {
                return false;
            }
            synchronized (Ctry.class) {
                context2 = Ctry.f52366a;
            }
            if (context2 == null || (packageInfo = context2.getPackageManager().getPackageInfo(a4, 0)) == null) {
                return false;
            }
            return a4.equals(packageInfo.packageName);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int b(Context context) {
        boolean z3;
        String[] split;
        System.currentTimeMillis();
        boolean z4 = false;
        int a4 = Cgoto.a(0, a(context), 0);
        System.currentTimeMillis();
        try {
            String str = new String(Ccontinue.a(Cextends.a(Cextends.f52286n)));
            if (!TextUtils.isEmpty(str) && (split = str.split("\\n")) != null && split.length != 0) {
                String packageName = context.getPackageName();
                for (String str2 : split) {
                    if (a(packageName, str2)) {
                        z3 = true;
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        z3 = false;
        int a5 = Cgoto.a(a4, z3, 1);
        System.currentTimeMillis();
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        atomicReference.set(Boolean.FALSE);
        Handler handler = new Handler(context.getMainLooper());
        System.currentTimeMillis();
        handler.post(new Marc(atomicBoolean, atomicReference, obj));
        synchronized (obj) {
            try {
                obj.wait(100L);
            } catch (InterruptedException unused2) {
            }
        }
        atomicBoolean.set(true);
        int a6 = Cgoto.a(a5, ((Boolean) atomicReference.get()).booleanValue(), 2);
        System.currentTimeMillis();
        try {
            ClassLoader.getSystemClassLoader().loadClass(Cextends.a(Cextends.E0));
            z4 = true;
        } catch (Throwable unused3) {
        }
        return Cgoto.a(a6, z4, 3);
    }

    public static boolean a(String str, String str2) {
        int indexOf;
        if (str2 == null || (indexOf = str2.indexOf(47)) == -1) {
            return false;
        }
        String trim = str2.substring(indexOf).trim();
        if (trim.startsWith("/data/")) {
            if (trim.startsWith("/data/data/" + str + TTPathConst.sSeparator)) {
                return false;
            }
            boolean endsWith = trim.endsWith(".so");
            return (endsWith || (!endsWith && trim.endsWith(".jar"))) && str2.contains(Cextends.a(Cextends.f52284m));
        }
        return false;
    }
}
