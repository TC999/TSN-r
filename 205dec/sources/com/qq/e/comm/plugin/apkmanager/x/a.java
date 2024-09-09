package com.qq.e.comm.plugin.apkmanager.x;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {
    private static String a(int i4, ApkDownloadTask apkDownloadTask) {
        return (String) pro.getobjresult(126, 1, Integer.valueOf(i4), apkDownloadTask);
    }

    private static String a(int i4, ApkDownloadTask apkDownloadTask, com.qq.e.comm.plugin.g0.e eVar) {
        return (String) pro.getobjresult(127, 1, Integer.valueOf(i4), apkDownloadTask, eVar);
    }

    private static String a(int i4, ApkDownloadTask apkDownloadTask, boolean z3, int i5) {
        return (String) pro.getobjresult(128, 1, Integer.valueOf(i4), apkDownloadTask, Boolean.valueOf(z3), Integer.valueOf(i5));
    }

    public static JSONObject a(ApkDownloadTask apkDownloadTask, com.qq.e.comm.plugin.g0.e eVar) {
        return (JSONObject) pro.getobjresult(129, 1, apkDownloadTask, eVar);
    }

    public static void a(ApkDownloadTask apkDownloadTask) {
        pro.getVresult(130, 1, apkDownloadTask);
    }

    public static void a(ApkDownloadTask apkDownloadTask, boolean z3) {
        pro.getVresult(131, 1, apkDownloadTask, Boolean.valueOf(z3));
    }

    public static String b(ApkDownloadTask apkDownloadTask) {
        return (String) pro.getobjresult(132, 1, apkDownloadTask);
    }

    public static void b(ApkDownloadTask apkDownloadTask, com.qq.e.comm.plugin.g0.e eVar) {
        pro.getVresult(133, 1, apkDownloadTask, eVar);
    }

    public static void c(ApkDownloadTask apkDownloadTask) {
        pro.getVresult(134, 1, apkDownloadTask);
    }

    public static void c(ApkDownloadTask apkDownloadTask, com.qq.e.comm.plugin.g0.e eVar) {
        pro.getVresult(135, 1, apkDownloadTask, eVar);
    }

    private static boolean d(ApkDownloadTask apkDownloadTask) {
        return pro.getZresult(136, 1, apkDownloadTask);
    }
}
