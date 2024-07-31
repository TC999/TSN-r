package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* renamed from: com.umeng.commonsdk.utils.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PkgInfoUtil {

    /* renamed from: a */
    private static HashMap<String, PackageInfo> f39141a = new HashMap<>();

    /* renamed from: b */
    private static Object f39142b = new Object();

    /* compiled from: PkgInfoUtil.java */
    /* renamed from: com.umeng.commonsdk.utils.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13299a {

        /* renamed from: a */
        private static final PkgInfoUtil f39143a = new PkgInfoUtil();

        private C13299a() {
        }
    }

    /* renamed from: a */
    public static PkgInfoUtil m13466a() {
        return C13299a.f39143a;
    }

    private PkgInfoUtil() {
    }

    /* renamed from: a */
    public PackageInfo m13465a(Context context, String str, int i) {
        PackageInfo packageInfo;
        synchronized (f39142b) {
            packageInfo = null;
            if (f39141a.containsKey(str)) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                packageInfo = f39141a.get(str);
            } else {
                try {
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str, i);
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                    f39141a.put(str, packageInfo2);
                    packageInfo = packageInfo2;
                } catch (PackageManager.NameNotFoundException unused) {
                    f39141a.put(str, null);
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                }
            }
        }
        return packageInfo;
    }
}
