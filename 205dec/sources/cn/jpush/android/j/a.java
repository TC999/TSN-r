package cn.jpush.android.j;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.i.b;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f4226a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f4227b = "";

    /* renamed from: c  reason: collision with root package name */
    private static final String f4228c = "".toLowerCase();

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i4;
        ComponentInfo[] componentInfoArr;
        if (context == null || TextUtils.isEmpty(str)) {
            b.d("AndroidUtils", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            int i5 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i5);
            componentInfoArr = i5 != 1 ? i5 != 2 ? i5 != 4 ? i5 != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
        } catch (Throwable th) {
            b.e("AndroidUtils", "hasComponent error:" + th);
        }
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name))) {
                return componentInfo;
            }
        }
        return null;
    }

    public static boolean a(Context context) {
        String str;
        if (context == null) {
            str = "context was null";
        } else {
            String str2 = null;
            try {
                str2 = Build.MANUFACTURER;
                b.a("AndroidUtils", "MANUFACTURER:" + str2);
            } catch (Throwable th) {
                b.e("AndroidUtils", "get MANUFACTURER failed - error:" + th);
            }
            if (!TextUtils.isEmpty(str2)) {
                String str3 = f4228c;
                return TextUtils.isEmpty(str3) || TextUtils.equals(str3, str2.toLowerCase());
            }
            str = "MANUFACTURER was empty";
        }
        b.e("AndroidUtils", str);
        return false;
    }
}
