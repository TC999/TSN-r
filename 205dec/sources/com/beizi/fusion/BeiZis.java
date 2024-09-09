package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.beizi.fusion.g.ak;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BeiZis {

    /* renamed from: a  reason: collision with root package name */
    private static BeiZiCustomController f14396a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f14397b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f14398c = "1.0.25";

    /* renamed from: d  reason: collision with root package name */
    private static boolean f14399d = true;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f14400e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f14401f;

    @RequiresPermission("android.permission.INTERNET")
    public static void asyncInit(Context context, String str) {
        f14399d = false;
        com.beizi.fusion.d.b.a().a(context, str, null, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void asyncInitWithDomain(Context context, String str, String str2) {
        f14399d = false;
        if (!TextUtils.isEmpty(str2)) {
            com.beizi.fusion.d.b.a().a(str2).a(context, str, null, null);
        } else {
            com.beizi.fusion.d.b.a().a(context, str, null, null);
        }
    }

    public static void closeShakeAd() {
        f14401f = true;
    }

    public static BeiZiCustomController getCustomController() {
        return f14396a;
    }

    public static String getOaidVersion() {
        return f14398c;
    }

    public static String getSdkVersion() {
        return "4.90.4.11";
    }

    public static boolean getTransferProtocol() {
        return f14400e;
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void init(Context context, String str) {
        com.beizi.fusion.d.b.a().a(context, str, null, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initWithDomain(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.beizi.fusion.d.b.a().a(str2).a(context, str, null, null);
        } else {
            com.beizi.fusion.d.b.a().a(context, str, null, null);
        }
    }

    public static boolean isCloseShakeAd() {
        return f14401f;
    }

    public static boolean isIsSyncInit() {
        return f14399d;
    }

    public static boolean isLimitPersonalAds() {
        return f14397b;
    }

    public static void setLimitPersonalAds(boolean z3) {
        f14397b = z3;
    }

    public static void setOaidVersion(String str) {
        f14398c = str;
    }

    public static void setSupportPersonalized(boolean z3) {
        ak.a(z3);
    }

    public static void setTransferProtocol(boolean z3) {
        f14400e = z3;
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController) {
        f14396a = beiZiCustomController;
        com.beizi.fusion.d.b.a().a(context, str, null, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController) {
        f14396a = beiZiCustomController;
        f14399d = false;
        com.beizi.fusion.d.b.a().a(context, str, null, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController, String str2) {
        f14396a = beiZiCustomController;
        com.beizi.fusion.d.b.a().a(context, str, str2, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2) {
        f14396a = beiZiCustomController;
        f14399d = false;
        com.beizi.fusion.d.b.a().a(context, str, str2, null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void init(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3) {
        f14396a = beiZiCustomController;
        com.beizi.fusion.d.b.a().a(context, str, str2, str3);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void asyncInit(Context context, String str, BeiZiCustomController beiZiCustomController, String str2, String str3) {
        f14396a = beiZiCustomController;
        f14399d = false;
        com.beizi.fusion.d.b.a().a(context, str, str2, str3);
    }
}
