package com.beizi.ad;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.RequiresPermission;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.UserEnvInfo;
import com.beizi.ad.internal.utilities.WebviewUtil;
import com.beizi.ad.lance.a.i;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BeiZi {

    /* renamed from: a  reason: collision with root package name */
    private static BeiZiAdSdkController f13063a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f13064b;

    public static BeiZiAdSdkController getCustomController() {
        return f13063a;
    }

    public static int getLocationDecimalDigits() {
        return UserEnvInfo.getInstance().getLocationDecimalDigits();
    }

    public static boolean getLocationEnabled() {
        return UserEnvInfo.getInstance().locationEnabled;
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return h.a().a(context);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void init(Context context, String str) {
        h.a().a(context, str);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initWithDomain(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            h.a().a(str2).a(context, str);
        } else {
            h.a().a(context, str);
        }
    }

    public static boolean isHttpsEnabled() {
        return h.a().f13802a;
    }

    public static boolean isLimitPersonalAds() {
        return f13064b;
    }

    public static void logTagInfo(String str, boolean z3) {
        h.a().a(str, z3);
    }

    public static void setAdRequestUrl(String str) {
        h.a().b(str);
    }

    public static void setAppMuted(boolean z3) {
        h.a().a(z3);
    }

    public static void setAppVolume(float f4) {
        h.a().a(f4);
    }

    public static void setH5RedirectBlackList(List<String> list) {
        h.a().a(list);
    }

    public static void setLimitPersonalAds(boolean z3) {
        f13064b = z3;
    }

    public static void setLocationDecimalDigits(int i4) {
        UserEnvInfo.getInstance().setLocationDecimalDigits(i4);
    }

    public static void setLocationEnabled(boolean z3) {
        UserEnvInfo.getInstance().locationEnabled = z3;
    }

    public static void startActivity(Context context, String str) {
        Class a4 = AdActivity.a();
        try {
            WebView webView = new WebView(context);
            WebviewUtil.setWebViewSettings(webView);
            webView.loadUrl(str, i.a());
            com.beizi.ad.internal.activity.a.f13657a.add(webView);
            Intent intent = new Intent(context, a4);
            intent.setFlags(268435456);
            intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(R.string.adactivity_missing, a4.getName()));
            com.beizi.ad.internal.activity.a.f13657a.remove();
        } catch (Exception e4) {
            String str2 = HaoboLog.baseLogTag;
            HaoboLog.e(str2, "Exception initializing the redirect webview: " + e4.getMessage());
        }
    }

    public static void useHttps(boolean z3) {
        h.a().f13802a = z3;
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void init(Context context, String str, BeiZiAdSdkController beiZiAdSdkController) {
        f13063a = beiZiAdSdkController;
        h.a().a(context, str);
    }
}
