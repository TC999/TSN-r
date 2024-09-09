package com.bytedance.sdk.openadsdk.core.eq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.pr;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.ok;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class wv {

    /* renamed from: a  reason: collision with root package name */
    private static int f33341a = 0;
    private static int bk = 0;

    /* renamed from: c  reason: collision with root package name */
    public static volatile int f33342c = 0;
    public static volatile int ev = -1;

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f33343f = 0;
    private static volatile boolean fp = false;
    private static volatile String fz = null;
    public static String gd = null;
    private static volatile String ia = "";

    /* renamed from: k  reason: collision with root package name */
    private static String f33344k = "upload_init";

    /* renamed from: p  reason: collision with root package name */
    private static volatile String f33345p = "";

    /* renamed from: r  reason: collision with root package name */
    public static volatile long f33346r = 0;

    /* renamed from: s  reason: collision with root package name */
    private static volatile String f33347s = null;
    public static volatile String sr = null;

    /* renamed from: t  reason: collision with root package name */
    private static long f33348t = -1;

    /* renamed from: u  reason: collision with root package name */
    private static volatile String f33349u;
    public static volatile long ux;

    /* renamed from: w  reason: collision with root package name */
    public static volatile int f33350w;
    public static volatile int xv;
    private static boolean ys;

    /* renamed from: com.bytedance.sdk.openadsdk.core.eq.wv$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = wv.ia = wv.t(new SSWebView(com.bytedance.sdk.openadsdk.core.ls.getContext()).getUserAgentString());
                com.bytedance.sdk.openadsdk.core.xv.ux.c().ux("sdk_local_web_ua", wv.ia);
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.eq.wv$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class AnonymousClass4 implements FilenameFilter {

        /* renamed from: c  reason: collision with root package name */
        private Pattern f33351c = Pattern.compile("^cpu[0-9]+$");

        AnonymousClass4() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f33351c.matcher(str).matches();
        }
    }

    public static String c(int i4) {
        switch (i4) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad_landingpage";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static boolean c(Context context, String str) {
        Intent w3;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (!f(context)) {
                    Intent w4 = w(context, str);
                    if (w4 == null) {
                        return false;
                    }
                    w4.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(w4);
                    return true;
                } else if (!xv(context, str) || (w3 = w(context, str)) == null) {
                    return false;
                } else {
                    w3.putExtra("START_ONLY_FOR_ANDROID", true);
                    com.bytedance.sdk.component.utils.w.c(context, w3, null);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static String eq() {
        String str;
        try {
            String sr2 = com.bytedance.sdk.openadsdk.core.xv.ux.c().sr("sdk_local_web_ua", "");
            long j4 = 0;
            if (TextUtils.isEmpty(sr2)) {
                str = null;
            } else {
                JSONObject jSONObject = new JSONObject(sr2);
                str = jSONObject.getString("value");
                j4 = jSONObject.getLong("time");
                ia = str;
            }
            if (TextUtils.isEmpty(str)) {
                me();
            } else if (System.currentTimeMillis() - j4 > 259200000) {
                com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("tt-webua") { // from class: com.bytedance.sdk.openadsdk.core.eq.wv.2
                    @Override // java.lang.Runnable
                    public void run() {
                        wv.me();
                    }
                });
            }
        } catch (Throwable unused) {
        }
        return ia;
    }

    public static int ev(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        JSONObject wt = meVar.wt();
        if (wt != null) {
            return wt.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    public static boolean f(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        return (meVar == null || meVar.qu() == null || TextUtils.isEmpty(meVar.qu().c())) ? false : true;
    }

    public static String fp(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (TextUtils.isEmpty(meVar.ny())) {
            return !TextUtils.isEmpty(meVar.ju()) ? meVar.ju() : "";
        }
        return meVar.ny();
    }

    public static String fz() {
        return me.w(Uri.parse(String.format("https://%s", com.bytedance.sdk.openadsdk.core.ls.w().a())).buildUpon().appendQueryParameter("datetime", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(new Long(System.currentTimeMillis()).longValue()))).toString());
    }

    public static void gb() {
        if (fp) {
            return;
        }
        fp = true;
        com.bytedance.sdk.component.p.r.c c4 = com.bytedance.sdk.component.p.r.c.c();
        c4.c("open_sass_live", new com.bytedance.sdk.openadsdk.core.ev.c.w.gd());
        c4.c("open_miniapp", new com.bytedance.sdk.openadsdk.core.ev.c.w.p());
        c4.c("open_landing_page", new com.bytedance.sdk.openadsdk.core.ev.c.w.ev());
        c4.c("download", new com.bytedance.sdk.openadsdk.core.ev.c.w.k());
        c4.c("open_scheme", new com.bytedance.sdk.openadsdk.core.ev.c.w.a());
        c4.c("open_policy", new com.bytedance.sdk.openadsdk.core.ev.c.w.bk());
        c4.c("report_event_uchain", new com.bytedance.sdk.openadsdk.core.ev.c.w.t());
        c4.c("report_stats_uchain", new com.bytedance.sdk.openadsdk.core.ev.c.w.ys());
        c4.c("end_card", new com.bytedance.sdk.openadsdk.core.ev.c.w.r());
        c4.c("common_popup", new com.bytedance.sdk.openadsdk.core.ev.c.w.c());
        c4.c("desc_popup", new com.bytedance.sdk.openadsdk.core.ev.c.w.w());
        c4.c("permission_popup", new com.bytedance.sdk.openadsdk.core.ev.c.w.xv());
        c4.c("privacy_popup", new com.bytedance.sdk.openadsdk.core.ev.c.w.sr());
        c4.c("dislike_popup", new com.bytedance.sdk.openadsdk.core.ev.c.w.ux());
        c4.c("download_popup", new com.bytedance.sdk.openadsdk.core.ev.c.w.f());
        c4.c("reward_again", new com.bytedance.sdk.openadsdk.core.ev.c.w.ia());
        c4.c("reward_continue", new com.bytedance.sdk.openadsdk.core.ev.c.w.ia());
        c4.c("close_reward", new com.bytedance.sdk.openadsdk.core.ev.c.w.fp());
    }

    public static int gd(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        JSONObject wt = meVar.wt();
        if (wt != null) {
            return wt.optInt("rit", 0);
        }
        return 0;
    }

    public static int i() {
        try {
            double maxMemory = Runtime.getRuntime().maxMemory();
            Double.isNaN(maxMemory);
            return (int) ((maxMemory * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static long ia() {
        try {
            if (wv()) {
                StatFs statFs = new StatFs(com.bytedance.sdk.openadsdk.api.plugin.w.c(com.bytedance.sdk.openadsdk.core.ls.getContext(), null).getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            }
            return 0L;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.f("ToolUtils", th.getMessage());
            return 0L;
        }
    }

    public static int j() {
        try {
            double d4 = Runtime.getRuntime().totalMemory();
            Double.isNaN(d4);
            return (int) ((d4 * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static double k(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        return xv(meVar.wt());
    }

    public static String ls() {
        return ev() + ".openadsdk.permission.TT_PANGOLIN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void me() {
        try {
            ia = t(WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.ls.getContext()));
            com.bytedance.sdk.openadsdk.core.xv.ux.c().ux("sdk_local_web_ua", ia);
        } catch (Throwable unused) {
        }
    }

    public static void n() {
        String ab = com.bytedance.sdk.openadsdk.core.ls.w().ab();
        try {
            Matcher matcher = Pattern.compile("\\|\\|([a-zA-Z0-9.-]+)\\^").matcher(ab);
            while (matcher.find()) {
                String group = matcher.group(1);
                if (!TextUtils.isEmpty(group)) {
                    com.bytedance.sdk.openadsdk.core.u.n.f34773c.add(group);
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(ab)) {
            return;
        }
        Set<String> set = com.bytedance.sdk.openadsdk.core.u.n.f34773c;
        if (set.isEmpty()) {
            set.add("empty");
        }
    }

    public static String p(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        JSONObject wt = meVar.wt();
        return wt != null ? wt.optString("customer_id", "") : "";
    }

    public static int q() {
        try {
            double freeMemory = Runtime.getRuntime().freeMemory();
            Double.isNaN(freeMemory);
            return (int) ((freeMemory * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String r(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        return f(meVar) ? "deeplink_fail" : "installed";
    }

    public static boolean s() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean sr() {
        return (com.bytedance.sdk.openadsdk.core.k.sr() == null || com.bytedance.sdk.openadsdk.core.k.sr().c()) ? false : true;
    }

    public static String t(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.u.sr ix = meVar.ix();
        String w3 = ix != null ? ix.w() : null;
        return TextUtils.isEmpty(w3) ? meVar.ux() : w3;
    }

    public static String u() {
        return me.w(String.format("https://%s", "applog.bytedance.net/service/2/app_log_test/"));
    }

    public static int ux(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                return (i4 == 3 || i4 == 4 || i4 == 7 || i4 == 8) ? 5 : 3;
            }
            return 4;
        }
        return 2;
    }

    public static boolean ux(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        JSONObject wt;
        if (meVar == null || (wt = meVar.wt()) == null) {
            return false;
        }
        try {
            int optInt = new JSONObject(wt.optString("compliance_data")).optJSONObject("ad").optInt("pricing_type");
            return optInt == 3 || optInt == 6;
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.f("ToolUtils", "error:" + e4.getMessage());
            return false;
        }
    }

    public static Intent w(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33 && !launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static String w(int i4) {
        switch (i4) {
            case 1:
                return "banner_ad";
            case 2:
                return "interaction";
            case 3:
            case 4:
                return "splash_ad";
            case 5:
            default:
                return "embeded_ad";
            case 6:
                return "stream";
            case 7:
                return "rewarded_video";
            case 8:
                return "fullscreen_interstitial_ad";
            case 9:
                return "draw_ad";
        }
    }

    private static boolean wv() {
        try {
            return "mounted".equals(com.bytedance.sdk.openadsdk.n.xv.c());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean xv(Context context, String str) {
        if (context == null || !f(context) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y() {
        List<String> kn;
        com.bytedance.sdk.openadsdk.core.z.r w3 = com.bytedance.sdk.openadsdk.core.ls.w();
        if (com.bytedance.sdk.openadsdk.core.k.sr().eq()) {
            com.bytedance.sdk.openadsdk.core.k.sr().gd(false);
        } else if (!w3.g() && (kn = w3.kn()) != null) {
            int bs = w3.bs();
            for (int i4 = 0; i4 < bs && i4 < kn.size(); i4++) {
                Uri parse = Uri.parse(kn.get(i4));
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                c(com.bytedance.sdk.openadsdk.core.ls.getContext(), intent, true);
            }
        }
    }

    public static String ys(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar.ix() != null && !TextUtils.isEmpty(meVar.ix().xv())) {
            return meVar.ix().xv();
        }
        if (TextUtils.isEmpty(meVar.yh())) {
            return !TextUtils.isEmpty(meVar.ny()) ? meVar.ny() : "";
        }
        return meVar.yh();
    }

    public static String a(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        JSONObject wt = meVar.wt();
        return wt != null ? wt.optString("req_id", "") : "";
    }

    public static int bk(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        JSONObject wt = meVar.wt();
        if (wt != null) {
            return wt.optInt("pricing", 0);
        }
        return 0;
    }

    public static String k() {
        if (!TextUtils.isEmpty(sr) && !sr.equals("0")) {
            return sr;
        }
        sr = com.bytedance.sdk.openadsdk.core.xv.ux.c().sr("total_memory", "0");
        return sr;
    }

    public static String r() {
        return UUID.randomUUID().toString();
    }

    public static boolean s(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return true;
        }
        int r3 = com.bytedance.sdk.openadsdk.core.ls.w().r(gd(meVar));
        if (r3 != 1) {
            if (r3 == 2) {
                return com.bytedance.sdk.component.utils.ys.ux(com.bytedance.sdk.openadsdk.core.ls.getContext()) || com.bytedance.sdk.component.utils.ys.sr(com.bytedance.sdk.openadsdk.core.ls.getContext()) || com.bytedance.sdk.component.utils.ys.f(com.bytedance.sdk.openadsdk.core.ls.getContext());
            } else if (r3 != 3) {
                return r3 != 5 || com.bytedance.sdk.component.utils.ys.sr(com.bytedance.sdk.openadsdk.core.ls.getContext()) || com.bytedance.sdk.component.utils.ys.f(com.bytedance.sdk.openadsdk.core.ls.getContext());
            } else {
                return false;
            }
        }
        return com.bytedance.sdk.component.utils.ys.sr(com.bytedance.sdk.openadsdk.core.ls.getContext());
    }

    public static boolean sr(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                com.bytedance.sdk.component.utils.w.c(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @HungeonFlag
    public static String ev() {
        if (!TextUtils.isEmpty(f33349u)) {
            return f33349u;
        }
        if (com.bytedance.sdk.openadsdk.core.ls.getContext() != null) {
            try {
                f33349u = com.bytedance.sdk.openadsdk.core.ls.getContext().getPackageName();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.xv("ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return f33349u;
    }

    public static String f() {
        if (!TextUtils.isEmpty(ia)) {
            return ia;
        }
        return eq();
    }

    public static String gd() {
        if (TextUtils.isEmpty(f33347s) && com.bytedance.sdk.openadsdk.core.ls.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.ls.getContext().getPackageManager().getPackageInfo(ev(), 0);
                f33347s = String.valueOf(packageInfo.versionCode);
                fz = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.xv("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return f33347s;
    }

    public static String p() {
        if (TextUtils.isEmpty(fz) && com.bytedance.sdk.openadsdk.core.ls.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.ls.getContext().getPackageManager().getPackageInfo(ev(), 0);
                f33347s = String.valueOf(packageInfo.versionCode);
                fz = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.xv("ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return fz;
    }

    public static String r(String str) {
        return c(str, false, 0);
    }

    public static int a() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    public static int bk() {
        if (f33342c > 0) {
            return f33342c;
        }
        f33342c = com.bytedance.sdk.openadsdk.core.xv.ux.c().w("cpu_cnt", 0);
        return f33342c;
    }

    public static long r(Context context) {
        int i4 = -1;
        try {
            i4 = context.getApplicationInfo().targetSdkVersion;
            com.bytedance.sdk.component.utils.a.w("ToolUtils", "targetSdkVersion = ", Integer.valueOf(i4));
        } catch (Throwable unused) {
        }
        return i4;
    }

    public static void xv() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.utils.ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.wv.1
                @Override // java.lang.Runnable
                public void run() {
                    wv.y();
                }
            });
        } else {
            y();
        }
    }

    public static long fp() {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockCount * blockSize;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String t(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt <= 31 || charAt >= '\u007f') {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static boolean f(String str) {
        try {
            return Pattern.compile("[\u4e00-\u9fa5]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int[] k(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] split = str.split(",");
        int[] iArr = new int[split.length];
        for (int i4 = 0; i4 < split.length; i4++) {
            try {
                iArr[i4] = Integer.parseInt(split[i4]);
            } catch (Exception unused) {
            }
        }
        return iArr;
    }

    public static boolean ia(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null || com.bytedance.sdk.openadsdk.core.u.fp.sr(meVar)) {
            return false;
        }
        int r3 = meVar.r();
        return r3 == 5 || r3 == 4;
    }

    public static double ux(String str) {
        return xv(w(str));
    }

    private static boolean w(Context context, Intent intent, boolean z3) {
        Boolean c4;
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String uri = data.toString();
        if (z3 && (c4 = gb.c(uri, 86400000L)) != null) {
            return c4.booleanValue();
        }
        boolean w3 = w(context, intent);
        gb.c(uri, Boolean.valueOf(w3));
        return w3;
    }

    public static boolean xv(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar != null) {
            int ev2 = ev(meVar);
            return ev2 == 5 || ev2 == 1 || ev2 == 2;
        }
        return false;
    }

    public static int ys() {
        if (xv > 0) {
            return xv;
        }
        xv = com.bytedance.sdk.openadsdk.core.xv.ux.c().w("cpu_min_freq", 0);
        return xv;
    }

    public static boolean sr(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar != null) {
            int ev2 = ev(meVar);
            return ev2 == 3 || ev2 == 4;
        }
        return false;
    }

    public static long xv(String str) {
        return c(w(str));
    }

    public static String ev(String str) {
        return c(str, false, 1);
    }

    public static boolean f(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.ls.getContext();
        }
        boolean z3 = false;
        if (context == null) {
            com.bytedance.sdk.component.utils.a.xv("params context is null");
            return false;
        }
        if (context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0) {
            z3 = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("can query all package = ");
        sb.append(!z3);
        com.bytedance.sdk.component.utils.a.xv("ToolUtils", sb.toString());
        return !z3;
    }

    public static int sr(String str) {
        return w(w(str));
    }

    public static long ux() {
        return f33348t;
    }

    public static boolean c(Context context, Intent intent, boolean z3) {
        if (intent == null || context == null || !f(context)) {
            return false;
        }
        return w(context, intent, z3);
    }

    public static long ev(Context context) {
        int i4 = -1;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                i4 = context.getApplicationInfo().minSdkVersion;
                com.bytedance.sdk.component.utils.a.w("ToolUtils", "minSdkVersion = ", Integer.valueOf(i4));
            }
        } catch (Throwable unused) {
        }
        return i4;
    }

    public static String ux(Context context, String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused4) {
                                }
                            }
                            throw th2;
                        }
                    }
                } while (!readLine.contains(str));
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused5) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused6) {
                    }
                    return null;
                }
                String[] split = readLine.split("\\s+");
                com.bytedance.sdk.component.utils.a.w("ToolUtils", "getTotalMemory = " + split[1]);
                String str2 = split[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused7) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused8) {
                }
                return str2;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            bufferedReader = null;
        }
    }

    private static double xv(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static int sr(int i4) {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        int i5 = 0;
        while (true) {
            i4--;
            if (i4 < 0) {
                return i5;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i4 + "/cpufreq/cpuinfo_min_freq");
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int parseInt = Integer.parseInt(bufferedReader3.readLine());
                        if (parseInt < i5 || i5 == 0) {
                            i5 = parseInt;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.bytedance.sdk.component.utils.a.f("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                            }
                            bufferedReader2 = bufferedReader;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th3;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th4) {
                bufferedReader = bufferedReader2;
                th = th4;
            }
        }
    }

    public static int xv(int i4) {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        int i5 = 0;
        while (true) {
            i4--;
            if (i4 < 0) {
                return i5;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i4 + "/cpufreq/cpuinfo_max_freq");
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int parseInt = Integer.parseInt(bufferedReader3.readLine());
                        if (parseInt > i5) {
                            i5 = parseInt;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.bytedance.sdk.component.utils.a.f("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                            }
                            bufferedReader2 = bufferedReader;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th3;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th4) {
                bufferedReader = bufferedReader2;
                th = th4;
            }
        }
    }

    private static String ys(String str) {
        if (TextUtils.isEmpty(str)) {
            gd = "empty";
            return "api-access.pangolin-sdk-toutiao1.com";
        } else if (str.contains("api-access")) {
            return str;
        } else {
            gd = str;
            return "api-access.pangolin-sdk-toutiao1.com";
        }
    }

    public static boolean c(Context context, Intent intent) {
        if (intent == null || context == null || !f(context)) {
            return false;
        }
        return w(context, intent, false);
    }

    private static String fp(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", gd()).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String gd(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", BaseConstants.ROM_OPPO_UPPER_CONSTANT);
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageManager packageManager = com.bytedance.sdk.openadsdk.core.ls.getContext().getPackageManager();
            return packageManager.getLaunchIntentForPackage(str).resolveActivity(packageManager).getClassName();
        } catch (Exception unused) {
            return "";
        }
    }

    public static int t() {
        if (f33350w > 0) {
            return f33350w;
        }
        f33350w = com.bytedance.sdk.openadsdk.core.xv.ux.c().w("cpu_max_freq", 0);
        return f33350w;
    }

    public static boolean w() {
        try {
            PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.ls.getContext().getPackageManager().getPackageInfo(com.bytedance.sdk.openadsdk.core.ls.getContext().getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ROOT);
            return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).compareTo(simpleDateFormat.format(Long.valueOf(packageInfo.firstInstallTime))) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static List<String> c() {
        ArrayList arrayList = new ArrayList();
        if (com.bytedance.sdk.openadsdk.core.ls.w().lf() && com.bytedance.sdk.openadsdk.core.k.sr().ux().w()) {
            Intent intent = new Intent("android.intent.action.MAIN");
            PackageManager packageManager = com.bytedance.sdk.openadsdk.core.ls.getContext().getPackageManager();
            if (Build.VERSION.SDK_INT >= 23) {
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 131072)) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null) {
                        String str = activityInfo.packageName;
                        if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static Class f(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return TTWebPageActivity.class;
                    }
                    return TTVideoScrollWebPageActivity.class;
                }
                return TTVideoWebPageActivity.class;
            }
            return TTNativePageActivity.class;
        }
        return TTPlayableWebPageActivity.class;
    }

    public static String gd(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean w(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                return queryIntentActivities.size() > 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int sr(Context context) {
        if (ev >= 0) {
            return ev;
        }
        ev = com.bytedance.sdk.openadsdk.core.xv.ux.c().w("is_root", -1);
        return ev;
    }

    public static JSONObject w(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static long xv(Context context) {
        if (f33346r > 0) {
            return f33346r;
        }
        f33346r = com.bytedance.sdk.openadsdk.core.xv.ux.c().w("sdcard_storage", 0L);
        return f33346r;
    }

    public static boolean w(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        return meVar != null && ev(meVar) == 9;
    }

    public static int c(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c4 = 1;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c4 = 2;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c4 = 3;
                    break;
                }
                break;
            case 564365438:
                if (str.equals("cache_splash_ad")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 2;
            case 1:
                return 7;
            case 2:
                return 5;
            case 3:
            case 4:
                return 4;
            case 5:
                return 3;
            case 6:
                return 6;
            default:
                return 1;
        }
    }

    public static String ux(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.f("ToolUtils", e4.toString());
            return "";
        }
    }

    private static int w(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static String c(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return null;
        }
        try {
            return w(ev(meVar));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long w(Context context) {
        if (f33343f > 0) {
            return f33343f;
        }
        f33343f = com.bytedance.sdk.openadsdk.core.xv.ux.c().w("free_storage", 0L);
        return f33343f;
    }

    private static long c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    public static String c(com.bytedance.sdk.openadsdk.core.u.me meVar, String str) {
        JSONObject wt = meVar.wt();
        return wt != null ? wt.optString("rit", str) : str;
    }

    public static Map<String, Object> w(boolean z3, com.bytedance.sdk.openadsdk.core.u.me meVar, long j4, long j5, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(CampaignEx.JSON_KEY_CREATIVE_ID, meVar.jr());
        hashMap.put("load_time", Long.valueOf(j4));
        if (!z3) {
            hashMap.put("error_code", Long.valueOf(j5));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static long c(Context context) {
        if (ux > 0) {
            return ux;
        }
        ux = com.bytedance.sdk.openadsdk.core.xv.ux.c().w("internal_storage", 0L);
        return ux;
    }

    public static Map<String, Object> c(long j4, com.bytedance.sdk.openadsdk.core.u.me meVar, com.bykv.vk.openvk.component.video.api.c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_start_duration", Long.valueOf(j4));
        if (meVar != null) {
            if (!TextUtils.isEmpty(meVar.jr())) {
                hashMap.put(CampaignEx.JSON_KEY_CREATIVE_ID, meVar.jr());
            }
            com.bykv.vk.openvk.component.video.api.xv.xv bk2 = ng.bk(meVar);
            if (bk2 != null) {
                hashMap.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, bk2.gd());
                hashMap.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(bk2.ux()));
            }
        }
        c(hashMap, cVar);
        return hashMap;
    }

    public static String w(long j4, long j5) {
        return String.valueOf(((int) (Math.abs(j5 - j4) / 86400000)) + 1);
    }

    public static String w(com.bytedance.sdk.openadsdk.core.u.me meVar, String str) {
        ok si;
        if (meVar == null || (si = meVar.si()) == null || si.w() != 1 || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") != -1) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("open_method=");
        if (!com.bytedance.sdk.openadsdk.core.w.c.w.ev.xv().c()) {
            sb.append(2);
            return sb.toString();
        }
        sb.append(si.f());
        return sb.toString();
    }

    public static Map<String, Object> c(boolean z3, com.bytedance.sdk.openadsdk.core.u.me meVar, long j4, long j5, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(CampaignEx.JSON_KEY_CREATIVE_ID, meVar.jr());
        hashMap.put("load_time", Long.valueOf(j4));
        com.bykv.vk.openvk.component.video.api.xv.xv bk2 = ng.bk(meVar);
        if (bk2 != null) {
            hashMap.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(bk2.ux()));
            hashMap.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, bk2.gd());
            hashMap.put("video_preload_size", Long.valueOf(Build.VERSION.SDK_INT >= 23 ? bk2.fp() : bk2.ux()));
        }
        if (!z3) {
            hashMap.put("error_code", Long.valueOf(j5));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static void w(Intent intent) {
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            intent.addFlags(268435456);
        } else if (com.bytedance.sdk.openadsdk.core.ls.w().u(data.getScheme())) {
            intent.addFlags(805339136);
        } else {
            intent.addFlags(268435456);
        }
    }

    public static Map<String, Object> c(com.bytedance.sdk.openadsdk.core.u.me meVar, long j4, com.bykv.vk.openvk.component.video.api.c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(CampaignEx.JSON_KEY_CREATIVE_ID, meVar.jr());
        hashMap.put("buffers_time", Long.valueOf(j4));
        com.bykv.vk.openvk.component.video.api.xv.xv bk2 = ng.bk(meVar);
        if (bk2 != null) {
            hashMap.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(bk2.ux()));
            hashMap.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, bk2.gd());
        }
        c(hashMap, cVar);
        return hashMap;
    }

    private static void c(Map<String, Object> map, com.bykv.vk.openvk.component.video.api.c cVar) {
        if (map.containsKey(CampaignEx.JSON_KEY_VIDEO_RESOLUTION) || cVar == null) {
            return;
        }
        try {
            map.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, String.format(Locale.getDefault(), "%d\u00d7%d", Integer.valueOf(cVar.k()), Integer.valueOf(cVar.a())));
        } catch (Throwable unused) {
        }
    }

    public static boolean c(boolean z3, boolean z4, com.bytedance.sdk.openadsdk.core.u.me meVar, String str) {
        if (meVar == null) {
            return false;
        }
        if (!meVar.ds() || z3 || z4) {
            return false;
        }
        String pu = meVar.pu();
        if (TextUtils.isEmpty(pu) && meVar.qu() != null && meVar.qu().xv() == 1 && !TextUtils.isEmpty(meVar.qu().w())) {
            pu = meVar.qu().w();
        }
        String str2 = pu;
        if (!TextUtils.isEmpty(str2)) {
            pr.c(com.bytedance.sdk.openadsdk.core.ls.getContext(), str2, meVar, c(str), str, (Map<String, Object>) null);
            return true;
        }
        return false;
    }

    public static String c(String str, boolean z3) {
        return c(str, z3, 0);
    }

    private static String c(String str, boolean z3, int i4) {
        String format = String.format("https://%s%s", i4 == 0 ? com.bytedance.sdk.openadsdk.core.ls.w().r() : ys(com.bytedance.sdk.openadsdk.core.ls.w().gd()), str);
        if (me.c()) {
            if (!z3) {
                format = me.w(format);
            }
            String c4 = me.c("testIp.txt");
            if (c4 != null) {
                format = me.c(format, c4);
            }
        }
        return z3 ? fp(format) : format;
    }

    public static boolean c(long j4, long j5) {
        long j6 = j5 - j4;
        return j6 < 86400000 && j6 > -86400000 && c(j4) == c(j5);
    }

    public static long c(long j4) {
        return (j4 + TimeZone.getDefault().getOffset(j4)) / 86400000;
    }

    public static int c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        if (wVar == null) {
            return 0;
        }
        try {
            return Integer.parseInt(wVar.f());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static Bundle c(int i4, Bundle bundle) {
        int i5 = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i6 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        float f4 = bundle.getFloat("callback_extra_key_reward_propose");
        boolean z3 = bundle.getBoolean("callback_extra_key_video_complete_reward");
        boolean z4 = bundle.getBoolean("callback_extra_key_is_server_verify");
        Bundle bundle2 = new Bundle();
        bundle2.putInt("reward_extra_key_error_code", i6);
        bundle2.putString("reward_extra_key_error_msg", string2);
        bundle2.putString("reward_extra_key_reward_name", string);
        bundle2.putInt("reward_extra_key_reward_amount", i5);
        bundle2.putFloat("reward_extra_key_reward_propose", f4);
        bundle2.putBoolean("reward_extra_key_is_server_verify", z4);
        if (i4 == 0) {
            bundle2.putBoolean("reward_extra_key_has_video_complete_reward", z3);
        }
        return bundle2;
    }

    public static String c(int[] iArr) {
        if (iArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (i4 < iArr.length - 1) {
                sb.append(iArr[i4] + ",");
            } else {
                sb.append(iArr[i4]);
            }
        }
        return sb.toString();
    }

    public static void c(final Context context, final com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (ys) {
            return;
        }
        ys = true;
        com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("check_hardware_permission_info") { // from class: com.bytedance.sdk.openadsdk.core.eq.wv.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (Build.VERSION.SDK_INT < 23) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    StringBuilder sb3 = new StringBuilder();
                    if (com.bytedance.sdk.openadsdk.bk.ux.c(context, com.bytedance.sdk.openadsdk.bk.ux.f31622a)) {
                        sb.append("Microphone_");
                        sb2.append("1");
                        if (com.bytedance.sdk.openadsdk.bk.ux.w(context, "android.permission.RECORD_AUDIO")) {
                            sb3.append("1");
                        } else {
                            sb3.append("0");
                        }
                    } else {
                        sb2.append("0");
                        sb3.append("0");
                    }
                    if (com.bytedance.sdk.openadsdk.bk.ux.c(context, com.bytedance.sdk.openadsdk.bk.ux.f31625k)) {
                        sb.append("Magetometer_");
                        sb2.append("1");
                        sb3.append("1");
                    } else {
                        sb2.append("0");
                        sb3.append("0");
                    }
                    if (com.bytedance.sdk.openadsdk.bk.ux.c(context, com.bytedance.sdk.openadsdk.bk.ux.f31626p)) {
                        sb.append("Accelerometer_");
                        sb2.append("1");
                        sb3.append("1");
                    } else {
                        sb2.append("0");
                        sb3.append("0");
                    }
                    if (com.bytedance.sdk.openadsdk.bk.ux.c(context, com.bytedance.sdk.openadsdk.bk.ux.gd)) {
                        sb.append("Gyro_");
                        sb2.append("1");
                        sb3.append("1");
                    } else {
                        sb2.append("0");
                        sb3.append("0");
                    }
                    if (com.bytedance.sdk.openadsdk.bk.ux.c(context, com.bytedance.sdk.openadsdk.bk.ux.ev)) {
                        sb.append("Camera_");
                        sb2.append("1");
                        if (com.bytedance.sdk.openadsdk.bk.ux.w(context, "android.permission.CAMERA")) {
                            sb3.append("1");
                        } else {
                            sb3.append("0");
                        }
                    } else {
                        sb2.append("0");
                        sb3.append("0");
                    }
                    if (com.bytedance.sdk.openadsdk.bk.ux.c(context, com.bytedance.sdk.openadsdk.bk.ux.f31627r)) {
                        sb.append("Photo");
                        sb2.append("1");
                        if (com.bytedance.sdk.openadsdk.bk.ux.c(context)) {
                            sb3.append("1");
                        } else {
                            sb3.append("0");
                        }
                    } else {
                        sb2.append("0");
                        sb3.append("0");
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("playable_available_hardware_name", sb.toString());
                    jSONObject.put("playable_available_hardware_code", sb2.toString());
                    jSONObject.put("playable_available_hardware_auth_code", sb3.toString());
                    jSONObject.put("playable_event", "PL_sdk_hardware_detect");
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(meVar, "embeded_ad", "playable_track", jSONObject);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void c(Intent intent, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.ls.w().ky()) {
            intent.putExtra("multi_process_materialmeta", meVar.mo().toString());
            return;
        }
        String str = meVar.hashCode() + meVar.xq();
        intent.putExtra("multi_process_materialmeta_key", str);
        ba.c("sp_meta").c(str, com.bytedance.sdk.component.utils.c.w(meVar.mo().toString()));
    }

    public static int c(Class cls) {
        if (TTWebPageActivity.class.equals(cls)) {
            return 0;
        }
        if (TTNativePageActivity.class.equals(cls)) {
            return 2;
        }
        if (TTVideoWebPageActivity.class.equals(cls)) {
            return 3;
        }
        if (TTVideoScrollWebPageActivity.class.equals(cls)) {
            return 4;
        }
        return TTPlayableWebPageActivity.class.equals(cls) ? 1 : 0;
    }

    public static void c(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null || map == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.ls.w().ky()) {
            map.put("multi_process_materialmeta", meVar.mo().toString());
            return;
        }
        String str = meVar.hashCode() + meVar.xq();
        map.put("multi_process_materialmeta_key", str);
        ba.c("sp_meta").c(str, com.bytedance.sdk.component.utils.c.w(meVar.mo().toString()));
    }

    public static com.bytedance.sdk.openadsdk.core.u.me c(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("multi_process_materialmeta");
            if (!TextUtils.isEmpty(stringExtra)) {
                com.bytedance.sdk.openadsdk.core.u.me c4 = com.bytedance.sdk.openadsdk.core.w.c(new JSONObject(stringExtra));
                if (c4 != null) {
                    return c4;
                }
            }
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.xv("ToolUtils", "getMaterialMeta from intent failed", e4);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_materialmeta_key");
        com.bytedance.sdk.component.f.c c5 = ba.c("sp_meta");
        String xv2 = com.bytedance.sdk.component.utils.c.xv(c5.w(stringExtra2, ""));
        try {
            if (TextUtils.isEmpty(xv2)) {
                com.bytedance.sdk.component.utils.a.f("ToolUtils", "getMaterialMeta from keva failed , md5" + stringExtra2);
                return null;
            }
            return com.bytedance.sdk.openadsdk.core.w.c(new JSONObject(xv2));
        } catch (Exception e5) {
            e5.printStackTrace();
            com.bytedance.sdk.component.utils.a.xv("ToolUtils", "getMaterialMeta from keva failed", e5);
            return null;
        } finally {
            c5.c(stringExtra2);
        }
    }

    public static boolean c(String str, AtomicInteger atomicInteger) {
        if (TextUtils.isEmpty(str) || atomicInteger == null) {
            return true;
        }
        if (atomicInteger.get() == 1) {
            return false;
        }
        if (str.startsWith("bytedance") || str.startsWith("nativeapp")) {
            return true;
        }
        if (str.startsWith("https") || str.startsWith("http")) {
            Set<String> set = com.bytedance.sdk.openadsdk.core.u.n.f34773c;
            if (set.isEmpty()) {
                n();
            }
            String host = Uri.parse(str).getHost();
            if (TextUtils.isEmpty(host) || set.isEmpty()) {
                return true;
            }
            for (String str2 : set) {
                if (!TextUtils.isEmpty(str2) && host.contains(str2)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
