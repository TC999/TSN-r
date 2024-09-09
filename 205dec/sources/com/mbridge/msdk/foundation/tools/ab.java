package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.NativeListener;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: SameSDKTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ab extends g {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39746b;

    /* renamed from: c  reason: collision with root package name */
    public static char[] f39747c = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};

    /* compiled from: SameSDKTool.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private static Intent a(Context context) {
            return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.package.name"));
        }

        private static List<ResolveInfo> b(Context context) {
            try {
                return context.getPackageManager().queryIntentActivities(a(context), 0);
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }

        private static boolean c(String str) {
            Uri parse;
            try {
                if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getHost())) {
                    return false;
                }
                if (!parse.getHost().equals("play.google.com")) {
                    if (!parse.getHost().equals("market.android.com")) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                x.d("SDKUtil", Log.getStackTraceString(th));
            }
            return false;
        }

        public static boolean a(String str) {
            return b(str) || c(str);
        }

        public static boolean a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
            try {
                List<ResolveInfo> b4 = b(context);
                if (b4 != null && b4.size() > 0) {
                    if (!b(str)) {
                        if (c(str)) {
                            str = "market://" + str.substring(str.indexOf("details?id="));
                        } else {
                            str = null;
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    Intent a4 = a(context);
                    a4.setData(Uri.parse(str));
                    a4.addFlags(268435456);
                    Iterator<ResolveInfo> it = b4.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                            a4.setPackage("com.android.vending");
                            break;
                        }
                    }
                    context.startActivity(a4);
                    ab.a(nativeTrackingListener);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                x.d("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }

        public static boolean b(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return Uri.parse(str).getScheme().equals("market");
            } catch (Throwable th) {
                x.d("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }
    }

    public static void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        if (nativeTrackingListener instanceof NativeListener.TrackingExListener) {
            ((NativeListener.TrackingExListener) nativeTrackingListener).onLeaveApp();
        }
    }

    public static void b(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
        if (str == null || context == null) {
            return;
        }
        try {
            if (a.b(str)) {
                str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null) {
                ActivityInfo activityInfo = resolveActivity.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
            }
            context.startActivity(intent);
            a(nativeTrackingListener);
        } catch (Exception e4) {
            e4.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268468224);
                context.startActivity(intent2);
                a(nativeTrackingListener);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            boolean z3 = queryIntentActivities.size() > 0;
            if (!str.startsWith("market://")) {
                if (str.startsWith("https://play.google.com/")) {
                    String replace = str.replace("https://play.google.com/store/apps/details?id=", "");
                    a(context, "market://details?id=" + replace, nativeTrackingListener);
                }
            } else if (!z3) {
                String replace2 = str.replace("market://details?id=", "");
                b(context, "https://play.google.com/store/apps/details?id=" + replace2, nativeTrackingListener);
            } else {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo.activityInfo.packageName.equals("com.android.vending")) {
                        intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
                        break;
                    }
                }
                try {
                    context.startActivity(intent);
                    a(nativeTrackingListener);
                } catch (Exception unused) {
                    String replace3 = str.replace("market://details?id=", "");
                    b(context, "https://play.google.com/store/apps/details?id=" + replace3, nativeTrackingListener);
                }
            }
        } catch (Exception e4) {
            x.d("SDKUtil", e4.getMessage());
        }
    }

    public static void a(Context context, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener) {
        if (context == null) {
            return;
        }
        if (f39746b) {
            b(context, str, nativeTrackingListener);
            return;
        }
        try {
            Class.forName("com.mbridge.msdk.activity.MBCommonActivity");
            Intent intent = new Intent(context, Class.forName("com.mbridge.msdk.activity.MBCommonActivity"));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (a.b(str)) {
                str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
            }
            intent.putExtra("url", str);
            x.b("url", "webview url = " + str);
            intent.setFlags(268435456);
            intent.putExtra("mvcommon", campaignEx);
            context.startActivity(intent);
        } catch (Exception unused) {
            b(context, str, nativeTrackingListener);
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File a4 = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_IMG);
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            if (str.lastIndexOf(TTPathConst.sSeparator) == -1) {
                str2 = str.hashCode() + "";
            } else {
                str2 = (str.hashCode() + str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1).hashCode()) + "";
            }
        }
        return new File(a4, str2).getAbsolutePath();
    }
}
