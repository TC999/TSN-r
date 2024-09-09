package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f49329a = "";
    public static volatile String bl = "";

    /* renamed from: h  reason: collision with root package name */
    public static long f49330h = 31457280;
    public static long kf = 5242880;

    /* renamed from: n  reason: collision with root package name */
    public static long f49331n = 50;
    public static volatile String ok = "";

    /* renamed from: p  reason: collision with root package name */
    public static long f49332p = 10485760;

    /* renamed from: q  reason: collision with root package name */
    public static final JSONObject f49333q = new JSONObject();

    /* renamed from: s  reason: collision with root package name */
    public static long f49334s = 512000;

    public static void ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ok = str;
    }
}
