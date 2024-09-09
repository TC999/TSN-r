package com.qq.e.comm.plugin.apkmanager.x;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.i.u;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.s0;
import java.io.File;
import java.io.FileFilter;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements FileFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f41938a;

        a(File file) {
            this.f41938a = file;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getAbsolutePath().startsWith(this.f41938a.getAbsolutePath());
        }
    }

    public static String a(Context context, String str) {
        return (String) pro.getobjresult(125, 1, context, str);
    }

    public static String a(String str) {
        return str;
    }

    public static boolean a(ApkDownloadTask apkDownloadTask) {
        File[] listFiles;
        try {
            File a4 = b1.a();
            if (a4 != null && (listFiles = a4.listFiles(new a(b(apkDownloadTask)))) != null && listFiles.length != 0) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
            return true;
        } catch (Throwable th) {
            d1.a("gdt_tag_download_apk", "delete apk files error", th);
            return false;
        }
    }

    public static File b(ApkDownloadTask apkDownloadTask) {
        return b1.b(a(apkDownloadTask.r()) + ".apk");
    }

    public static boolean c(ApkDownloadTask apkDownloadTask) {
        File b4 = b1.b(a(apkDownloadTask.r()) + ".apk_0");
        return b4 != null && b4.exists() && b4.length() > 0;
    }

    public static boolean d(ApkDownloadTask apkDownloadTask) {
        File b4 = b(apkDownloadTask);
        return b4 != null && b4.exists();
    }

    public static Pair<Integer, String> b(File file, String str, Context context) {
        if (file != null && file.exists()) {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            if (packageArchiveInfo == null) {
                String str2 = str + "\uff0c" + file.length() + "\uff0c" + s0.a(file);
                if (!b1.c(file)) {
                    d1.a("file is not apk");
                    return new Pair<>(1, "Not Apk\uff1a" + str2);
                }
                d1.a("pk file does not fit current system");
                return new Pair<>(2, "Apk packageInfo is null\uff1a" + str2);
            } else if (!packageArchiveInfo.packageName.equals(str)) {
                return new Pair<>(8, "Package name is not  inconsistent:" + packageArchiveInfo.packageName + "\uff0c" + str);
            } else {
                return new Pair<>(0, "");
            }
        }
        return new Pair<>(4, "Apk file not exist");
    }

    public static boolean a(File file, String str, Context context) {
        return ((Integer) b(file, str, context).first).intValue() == 0;
    }

    public static boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return o.b() ? context.getPackageManager().getPackageInfo(str, 256) != null : u.a(context, str) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
