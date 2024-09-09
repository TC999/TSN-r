package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: PkgInfoUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, PackageInfo> f53776a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static Object f53777b = new Object();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: PkgInfoUtil.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f53778a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f53778a;
    }

    private b() {
    }

    public PackageInfo a(Context context, String str, int i4) {
        PackageInfo packageInfo;
        synchronized (f53777b) {
            packageInfo = null;
            if (f53776a.containsKey(str)) {
                UMRTLog.e("MobclickRT", "--->>> pkg\uff1a " + str + ", pkgInfo\u7f13\u5b58\u547d\u4e2d\uff0c\u76f4\u63a5\u8fd4\u56de");
                packageInfo = f53776a.get(str);
            } else {
                try {
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str, i4);
                    UMRTLog.e("MobclickRT", "--->>> pkg\uff1a " + str + ", \u83b7\u53d6pkgInfo\u5e76\u7f13\u5b58");
                    f53776a.put(str, packageInfo2);
                    packageInfo = packageInfo2;
                } catch (PackageManager.NameNotFoundException unused) {
                    f53776a.put(str, null);
                    UMRTLog.e("MobclickRT", "--->>> pkg: " + str + "\uff0c\u76ee\u6807\u5305\u672a\u5b89\u88c5\u3002");
                }
            }
        }
        return packageInfo;
    }
}
