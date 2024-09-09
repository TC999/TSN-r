package com.tencent.open.log;

import com.tencent.connect.common.Constants;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f51778a = 60;

    /* renamed from: b  reason: collision with root package name */
    public static int f51779b = 60;

    /* renamed from: c  reason: collision with root package name */
    public static String f51780c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d  reason: collision with root package name */
    public static String f51781d;

    /* renamed from: e  reason: collision with root package name */
    public static String f51782e;

    /* renamed from: f  reason: collision with root package name */
    public static long f51783f;

    /* renamed from: g  reason: collision with root package name */
    public static int f51784g;

    /* renamed from: h  reason: collision with root package name */
    public static int f51785h;

    /* renamed from: i  reason: collision with root package name */
    public static int f51786i;

    /* renamed from: j  reason: collision with root package name */
    public static String f51787j;

    /* renamed from: k  reason: collision with root package name */
    public static String f51788k;

    /* renamed from: l  reason: collision with root package name */
    public static String f51789l;

    /* renamed from: m  reason: collision with root package name */
    public static int f51790m;

    /* renamed from: n  reason: collision with root package name */
    public static long f51791n;

    /* renamed from: o  reason: collision with root package name */
    public static String f51792o;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Tencent");
        String str = File.separator;
        sb.append(str);
        sb.append("msflogs");
        sb.append(str);
        sb.append("com");
        sb.append(str);
        sb.append("tencent");
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        f51781d = sb.toString();
        f51782e = ".log";
        f51783f = 8388608L;
        f51784g = 262144;
        f51785h = 1024;
        f51786i = 10000;
        f51787j = "debug.file.blockcount";
        f51788k = "debug.file.keepperiod";
        f51789l = "debug.file.tracelevel";
        f51790m = 24;
        f51791n = 604800000L;
        f51792o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
