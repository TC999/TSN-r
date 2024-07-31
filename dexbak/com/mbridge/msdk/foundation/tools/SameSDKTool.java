package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.out.NativeListener;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.tools.ab */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SameSDKTool extends DomainSameSDKTool {

    /* renamed from: b */
    public static boolean f30973b;

    /* renamed from: c */
    public static char[] f30974c = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};

    /* compiled from: SameSDKTool.java */
    /* renamed from: com.mbridge.msdk.foundation.tools.ab$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11399a {
        /* renamed from: a */
        private static Intent m22028a(Context context) {
            return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.package.name"));
        }

        /* renamed from: b */
        private static List<ResolveInfo> m22025b(Context context) {
            try {
                return context.getPackageManager().queryIntentActivities(m22028a(context), 0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* renamed from: c */
        private static boolean m22023c(String str) {
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
                SameLogTool.m21733d("SDKUtil", Log.getStackTraceString(th));
            }
            return false;
        }

        /* renamed from: a */
        public static boolean m22026a(String str) {
            return m22024b(str) || m22023c(str);
        }

        /* renamed from: a */
        public static boolean m22027a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
            try {
                List<ResolveInfo> m22025b = m22025b(context);
                if (m22025b != null && m22025b.size() > 0) {
                    if (!m22024b(str)) {
                        if (m22023c(str)) {
                            str = "market://" + str.substring(str.indexOf("details?id="));
                        } else {
                            str = null;
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    Intent m22028a = m22028a(context);
                    m22028a.setData(Uri.parse(str));
                    m22028a.addFlags(268435456);
                    Iterator<ResolveInfo> it = m22025b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                            m22028a.setPackage("com.android.vending");
                            break;
                        }
                    }
                    context.startActivity(m22028a);
                    SameSDKTool.m22031a(nativeTrackingListener);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                SameLogTool.m21733d("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }

        /* renamed from: b */
        public static boolean m22024b(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return Uri.parse(str).getScheme().equals("market");
            } catch (Throwable th) {
                SameLogTool.m21733d("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }
    }

    /* renamed from: a */
    public static void m22031a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        if (nativeTrackingListener instanceof NativeListener.TrackingExListener) {
            ((NativeListener.TrackingExListener) nativeTrackingListener).onLeaveApp();
        }
    }

    /* renamed from: b */
    public static void m22029b(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
        if (str == null || context == null) {
            return;
        }
        try {
            if (C11399a.m22024b(str)) {
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
            m22031a(nativeTrackingListener);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268468224);
                context.startActivity(intent2);
                m22031a(nativeTrackingListener);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m22032a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            boolean z = queryIntentActivities.size() > 0;
            if (!str.startsWith("market://")) {
                if (str.startsWith("https://play.google.com/")) {
                    String replace = str.replace("https://play.google.com/store/apps/details?id=", "");
                    m22032a(context, "market://details?id=" + replace, nativeTrackingListener);
                }
            } else if (!z) {
                String replace2 = str.replace("market://details?id=", "");
                m22029b(context, "https://play.google.com/store/apps/details?id=" + replace2, nativeTrackingListener);
            } else {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo.activityInfo.packageName.equals("com.android.vending")) {
                        intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
                        break;
                    }
                }
                try {
                    context.startActivity(intent);
                    m22031a(nativeTrackingListener);
                } catch (Exception unused) {
                    String replace3 = str.replace("market://details?id=", "");
                    m22029b(context, "https://play.google.com/store/apps/details?id=" + replace3, nativeTrackingListener);
                }
            }
        } catch (Exception e) {
            SameLogTool.m21733d("SDKUtil", e.getMessage());
        }
    }

    /* renamed from: a */
    public static void m22033a(Context context, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener) {
        if (context == null) {
            return;
        }
        if (f30973b) {
            m22029b(context, str, nativeTrackingListener);
            return;
        }
        try {
            Class.forName("com.mbridge.msdk.activity.MBCommonActivity");
            Intent intent = new Intent(context, Class.forName("com.mbridge.msdk.activity.MBCommonActivity"));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (C11399a.m22024b(str)) {
                str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
            }
            intent.putExtra("url", str);
            SameLogTool.m21736b("url", "webview url = " + str);
            intent.setFlags(268435456);
            intent.putExtra("mvcommon", campaignEx);
            context.startActivity(intent);
        } catch (Exception unused) {
            m22029b(context, str, nativeTrackingListener);
        }
    }

    /* renamed from: a */
    public static String m22030a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File m22349a = MBridgeDirManager.m22349a(MBridgeDir.MBRIDGE_700_IMG);
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            if (str.lastIndexOf("/") == -1) {
                str2 = str.hashCode() + "";
            } else {
                str2 = (str.hashCode() + str.substring(str.lastIndexOf("/") + 1).hashCode()) + "";
            }
        }
        return new File(m22349a, str2).getAbsolutePath();
    }
}
