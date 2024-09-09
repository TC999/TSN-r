package xyz.adscope.ad.control.action.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.action.webview.WebViewActivity;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class PageJumpUtil {
    private static Intent getSchemeIntent(String str) {
        return getSchemeIntent(str, null);
    }

    private static boolean handleNormalJump(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return isIntentAvailable(context, getSchemeIntent(str));
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static void launchDeepLink(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Uri parse = Uri.parse(str);
            Context context = AdScopeSDK.getContext();
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e4) {
            String str2 = Constants.TAG;
            LogUtil.i(str2, "e : " + e4);
        }
    }

    public static void startAdScopeDeepLink(Context context, Uri uri) {
        if (context == null || uri == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        String queryParameter = uri.getQueryParameter("flags");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                    intent.setFlags(Integer.parseInt(queryParameter));
                }
                intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        intent.setComponent(new ComponentName(uri.getHost(), uri.getPathSegments().get(0)));
        String queryParameter2 = uri.getQueryParameter("rect");
        if (!TextUtils.isEmpty(queryParameter2)) {
            try {
                String[] split = queryParameter2.split(":");
                if (split.length == 4) {
                    Rect rect = new Rect();
                    rect.set(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                    intent.setSourceBounds(rect);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        context.startActivity(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c A[Catch: Exception -> 0x0071, TRY_LEAVE, TryCatch #0 {Exception -> 0x0071, blocks: (B:3:0x0001, B:5:0x000b, B:6:0x000e, B:9:0x0016, B:12:0x001f, B:14:0x0026, B:16:0x0034, B:18:0x003a, B:21:0x0041, B:23:0x0047, B:25:0x004f, B:28:0x0057, B:31:0x006c, B:29:0x005b, B:11:0x001c), top: B:38:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean startDeepLink(android.content.Context r5, xyz.adscope.ad.model.http.response.ad.NativeModel r6, xyz.adscope.ad.control.track.inter.ITrackEventStatus r7) {
        /*
            r0 = 0
            xyz.adscope.ad.model.http.response.ad.LinkModel r6 = r6.getLink()     // Catch: java.lang.Exception -> L71
            java.lang.String r6 = r6.getUrlfb()     // Catch: java.lang.Exception -> L71
            if (r7 == 0) goto Le
            r7.startInvoke()     // Catch: java.lang.Exception -> L71
        Le:
            boolean r1 = handleNormalJump(r5, r6)     // Catch: java.lang.Exception -> L71
            if (r1 == 0) goto L1a
            if (r7 == 0) goto L1f
            r7.installedApp()     // Catch: java.lang.Exception -> L71
            goto L1f
        L1a:
            if (r7 == 0) goto L1f
            r7.notInstall()     // Catch: java.lang.Exception -> L71
        L1f:
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch: java.lang.Exception -> L71
            r1 = 0
            if (r6 == 0) goto L3f
            java.lang.String r1 = r6.getScheme()     // Catch: java.lang.Exception -> L71
            java.lang.String r2 = r6.getHost()     // Catch: java.lang.Exception -> L71
            java.util.List r3 = r6.getPathSegments()     // Catch: java.lang.Exception -> L71
            if (r3 == 0) goto L40
            int r4 = r3.size()     // Catch: java.lang.Exception -> L71
            if (r4 <= 0) goto L40
            int r3 = r3.size()     // Catch: java.lang.Exception -> L71
            goto L41
        L3f:
            r2 = r1
        L40:
            r3 = 0
        L41:
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L71
            if (r4 != 0) goto L5b
            java.lang.String r4 = "bzopen"
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Exception -> L71
            if (r1 == 0) goto L5b
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L71
            if (r1 != 0) goto L5b
            if (r3 <= 0) goto L5b
            startAdScopeDeepLink(r5, r6)     // Catch: java.lang.Exception -> L71
            goto L6a
        L5b:
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L71
            java.lang.String r2 = "android.intent.action.VIEW"
            r1.<init>(r2, r6)     // Catch: java.lang.Exception -> L71
            r6 = 268435456(0x10000000, float:2.524355E-29)
            r1.setFlags(r6)     // Catch: java.lang.Exception -> L71
            r5.startActivity(r1)     // Catch: java.lang.Exception -> L71
        L6a:
            if (r7 == 0) goto L6f
            r7.invokeSuccess()     // Catch: java.lang.Exception -> L71
        L6f:
            r5 = 1
            return r5
        L71:
            if (r7 == 0) goto L77
            r7.invokeFail()
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.control.action.util.PageJumpUtil.startDeepLink(android.content.Context, xyz.adscope.ad.model.http.response.ad.NativeModel, xyz.adscope.ad.control.track.inter.ITrackEventStatus):boolean");
    }

    public static void startLandPage(Context context, NativeModel nativeModel) {
        try {
            if (TextUtils.isEmpty(nativeModel.getLink().getUrl())) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("url", nativeModel.getLink().getUrl());
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            intent.setClass(context, WebViewActivity.class);
            context.startActivity(intent);
        } catch (Exception e4) {
            String str = Constants.TAG;
            LogUtil.i(str, "e : " + e4);
        }
    }

    public static void startUrlPage(String str) {
        Context context = AdScopeSDK.getContext();
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("url", str);
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                intent.setClass(context, WebViewActivity.class);
                context.startActivity(intent);
            } catch (Exception e4) {
                String str2 = Constants.TAG;
                LogUtil.i(str2, "e : " + e4);
            }
        }
    }

    private static Intent getSchemeIntent(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        intent.setFlags(268435456);
        return intent;
    }
}
