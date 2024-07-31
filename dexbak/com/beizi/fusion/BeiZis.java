package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p072g.PersonalizedUtil;
import com.kuaishou.weapon.p205p0.C7282g;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZis {

    /* renamed from: a */
    private static BeiZiCustomController f10831a = null;

    /* renamed from: b */
    private static boolean f10832b = false;

    /* renamed from: c */
    private static String f10833c = "1.0.25";

    /* renamed from: d */
    private static boolean f10834d = true;

    /* renamed from: e */
    private static boolean f10835e;

    /* renamed from: f */
    private static boolean f10836f;

    @RequiresPermission(C7282g.f24943a)
    public static void asyncInit(Context context, String str) {
        f10834d = false;
        AdManager.m48786a().m48785a(context, str, null, null);
    }

    @RequiresPermission(C7282g.f24943a)
    public static void asyncInitWithDomain(Context context, String str, String str2) {
        f10834d = false;
        if (!TextUtils.isEmpty(str2)) {
            AdManager.m48786a().m48783a(str2).m48785a(context, str, null, null);
        } else {
            AdManager.m48786a().m48785a(context, str, null, null);
        }
    }

    public static void closeShakeAd() {
        f10836f = true;
    }

    public static BeiZiCustomController getCustomController() {
        return f10831a;
    }

    public static String getOaidVersion() {
        return f10833c;
    }

    public static String getSdkVersion() {
        return "4.90.4.5";
    }

    public static boolean getTransferProtocol() {
        return f10835e;
    }

    @RequiresPermission(C7282g.f24943a)
    public static void init(Context context, String str) {
        AdManager.m48786a().m48785a(context, str, null, null);
    }

    @RequiresPermission(C7282g.f24943a)
    public static void initWithDomain(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            AdManager.m48786a().m48783a(str2).m48785a(context, str, null, null);
        } else {
            AdManager.m48786a().m48785a(context, str, null, null);
        }
    }

    public static boolean isCloseShakeAd() {
        return f10836f;
    }

    public static boolean isIsSyncInit() {
        return f10834d;
    }

    public static boolean isLimitPersonalAds() {
        return f10832b;
    }

    public static void setLimitPersonalAds(boolean z) {
        f10832b = z;
    }

    public static void setOaidVersion(String str) {
        f10833c = str;
    }

    public static void setSupportPersonalized(boolean z) {
        PersonalizedUtil.m48443a(z);
    }

    public static void setTransferProtocol(boolean z) {
        f10835e = z;
    }

    @RequiresPermission(C7282g.f24943a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController) {
        f10831a = beiZiCustomController;
        AdManager.m48786a().m48785a(context, str, null, null);
    }

    @RequiresPermission(C7282g.f24943a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController) {
        f10831a = beiZiCustomController;
        f10834d = false;
        AdManager.m48786a().m48785a(context, str, null, null);
    }

    @RequiresPermission(C7282g.f24943a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController, String str2) {
        f10831a = beiZiCustomController;
        AdManager.m48786a().m48785a(context, str, str2, null);
    }

    @RequiresPermission(C7282g.f24943a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2) {
        f10831a = beiZiCustomController;
        f10834d = false;
        AdManager.m48786a().m48785a(context, str, str2, null);
    }

    @RequiresPermission(C7282g.f24943a)
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3) {
        f10831a = beiZiCustomController;
        AdManager.m48786a().m48785a(context, str, str2, str3);
    }

    @RequiresPermission(C7282g.f24943a)
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3) {
        f10831a = beiZiCustomController;
        f10834d = false;
        AdManager.m48786a().m48785a(context, str, str2, str3);
    }
}
