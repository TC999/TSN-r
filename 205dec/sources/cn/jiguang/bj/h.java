package cn.jiguang.bj;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f2682a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f2683b;

    public static String a(Context context) {
        Bundle bundle;
        if (TextUtils.isEmpty(f2682a)) {
            f2682a = f.c();
        }
        if (TextUtils.isEmpty(f2682a)) {
            try {
                if (context != null) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String a4 = a(bundle, "JPUSH_APPKEY");
                        f2682a = a4;
                        if (!TextUtils.isEmpty(a4)) {
                            f2682a = f2682a.toLowerCase(Locale.getDefault());
                        }
                    }
                } else {
                    cn.jiguang.bi.b.b("MetaInfoFetcher", "[getAppKey] context is null");
                }
            } catch (Throwable unused) {
            }
        }
        return f2682a;
    }

    public static String a(Bundle bundle, String str) {
        Object obj;
        if (bundle == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static String b(Context context) {
        StringBuilder sb;
        Bundle bundle;
        if (f2683b == null && context != null) {
            try {
                String d4 = f.d(context);
                f2683b = d4;
                if (d4 != null) {
                    sb = new StringBuilder();
                    sb.append("get option channel - ");
                    sb.append(f2683b);
                } else {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        String a4 = a(bundle, "JPUSH_CHANNEL");
                        f2683b = a4;
                        if (!TextUtils.isEmpty(a4)) {
                            f2683b = j.b(f2683b);
                        }
                    }
                    sb = new StringBuilder();
                    sb.append("manifest:channel - ");
                    sb.append(f2683b);
                }
                cn.jiguang.bi.b.c("MetaInfoFetcher", sb.toString());
            } catch (Throwable unused) {
            }
        }
        return f2683b;
    }
}
