package com.beizi.p051ad;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.RequiresPermission;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.activity.BrowserAdActivity;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.UserEnvInfo;
import com.beizi.p051ad.internal.utilities.WebviewUtil;
import com.beizi.p051ad.lance.p062a.HeaderUtil;
import com.kuaishou.weapon.p205p0.C7282g;
import java.util.Map;

/* renamed from: com.beizi.ad.BeiZi */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZi {

    /* renamed from: a */
    private static BeiZiAdSdkController f9346a;

    /* renamed from: b */
    private static boolean f9347b;

    public static BeiZiAdSdkController getCustomController() {
        return f9346a;
    }

    public static int getLocationDecimalDigits() {
        return UserEnvInfo.getInstance().getLocationDecimalDigits();
    }

    public static boolean getLocationEnabled() {
        return UserEnvInfo.getInstance().locationEnabled;
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return BeiZiImpl.m49492a().m49490a(context);
    }

    @RequiresPermission(C7282g.f24943a)
    public static void init(Context context, String str) {
        BeiZiImpl.m49492a().m49489a(context, str);
    }

    @RequiresPermission(C7282g.f24943a)
    public static void initWithDomain(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            BeiZiImpl.m49492a().m49484a(str2).m49489a(context, str);
        } else {
            BeiZiImpl.m49492a().m49489a(context, str);
        }
    }

    public static boolean isHttpsEnabled() {
        return BeiZiImpl.m49492a().f10134a;
    }

    public static boolean isLimitPersonalAds() {
        return f9347b;
    }

    public static void logTagInfo(String str, boolean z) {
        BeiZiImpl.m49492a().m49483a(str, z);
    }

    public static void setAdRequestUrl(String str) {
        BeiZiImpl.m49492a().m49478b(str);
    }

    public static void setAppMuted(boolean z) {
        BeiZiImpl.m49492a().m49481a(z);
    }

    public static void setAppVolume(float f) {
        BeiZiImpl.m49492a().m49491a(f);
    }

    public static void setIncentiveConfig(Map<String, String> map) {
        BeiZiImpl.m49492a().m49482a(map);
    }

    public static void setLimitPersonalAds(boolean z) {
        f9347b = z;
    }

    public static void setLocationDecimalDigits(int i) {
        UserEnvInfo.getInstance().setLocationDecimalDigits(i);
    }

    public static void setLocationEnabled(boolean z) {
        UserEnvInfo.getInstance().locationEnabled = z;
    }

    public static void startActivity(Context context, String str) {
        Class m50215a = AdActivity.m50215a();
        try {
            WebView webView = new WebView(context);
            WebviewUtil.setWebViewSettings(webView);
            webView.loadUrl(str, HeaderUtil.m49052a());
            BrowserAdActivity.f9980a.add(webView);
            Intent intent = new Intent(context, m50215a);
            intent.setFlags(268435456);
            intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.adactivity_missing, m50215a.getName()));
            BrowserAdActivity.f9980a.remove();
        } catch (Exception e) {
            String str2 = HaoboLog.baseLogTag;
            HaoboLog.m49290e(str2, "Exception initializing the redirect webview: " + e.getMessage());
        }
    }

    public static void useHttps(boolean z) {
        BeiZiImpl.m49492a().f10134a = z;
    }

    @RequiresPermission(C7282g.f24943a)
    public static void init(Context context, String str, BeiZiAdSdkController beiZiAdSdkController) {
        f9346a = beiZiAdSdkController;
        BeiZiImpl.m49492a().m49489a(context, str);
    }
}
