package com.qq.e.comm.plugin.apkmanager;

import java.io.File;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41785a = "f";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file) {
        pro.getVresult(137, 1, file);
    }

    private static final void a(File file, long j4, String str) {
        pro.getVresult(138, 1, file, Long.valueOf(j4), str);
    }

    private static boolean a() {
        return pro.getZresult(139, 1, new Object[0]);
    }

    private static boolean a(ApkDownloadTask apkDownloadTask, long j4, File file, int i4) {
        return pro.getZresult(140, 1, apkDownloadTask, Long.valueOf(j4), file, Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ApkDownloadTask apkDownloadTask, com.qq.e.comm.plugin.p.f fVar, File file) {
        return pro.getZresult(141, 1, apkDownloadTask, fVar, file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ApkDownloadTask apkDownloadTask, File file) {
        return pro.getZresult(142, 1, apkDownloadTask, file);
    }

    private static File b(File file) {
        return (File) pro.getobjresult(143, 1, file);
    }
}
