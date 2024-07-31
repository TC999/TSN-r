package com.bytedance.pangle.p121f.p122a;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.C6251g;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.bytedance.pangle.f.a.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6117d {
    /* renamed from: a */
    public static C6118e m37148a(File file) {
        ZipFile zipFile;
        C6114a c6114a;
        int m37163b;
        int i;
        try {
            if (!file.exists()) {
                ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                C6251g.m36894a((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    C6251g.m36894a(zipFile2);
                    return null;
                }
                c6114a = new C6114a();
                try {
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    c6114a.m37165a();
                    if (inputStream != null) {
                        c6114a.f21987b = new C6115b(inputStream);
                    }
                    do {
                        m37163b = c6114a.m37163b();
                        if (m37163b == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                c6114a.m37165a();
                            } catch (Throwable unused) {
                            }
                            C6251g.m36894a(zipFile2);
                            return null;
                        }
                    } while (m37163b != 2);
                    int length = c6114a.f21986a != 2 ? -1 : c6114a.f21988c.length / 5;
                    String str = null;
                    String str2 = null;
                    for (int i2 = 0; i2 != length; i2++) {
                        if (TTDownloadField.TT_VERSION_CODE.equals(c6114a.m37164a(i2))) {
                            str = m37149a(c6114a, i2);
                        } else if ("package".equals(c6114a.m37164a(i2))) {
                            str2 = m37149a(c6114a, i2);
                        }
                    }
                    try {
                        i = Integer.parseInt(str);
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(str)));
                        try {
                            c6114a.m37165a();
                        } catch (Throwable unused3) {
                        }
                        C6251g.m36894a(zipFile2);
                        return null;
                    }
                    C6118e c6118e = new C6118e(str2, i);
                    try {
                        c6114a.m37165a();
                    } catch (Throwable unused4) {
                    }
                    C6251g.m36894a(zipFile2);
                    return c6118e;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            return null;
                        }
                        C6118e c6118e2 = new C6118e(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (c6114a != null) {
                            try {
                                c6114a.m37165a();
                            } catch (Throwable unused5) {
                            }
                        }
                        C6251g.m36894a(zipFile);
                        return c6118e2;
                    } finally {
                        if (c6114a != null) {
                            try {
                                c6114a.m37165a();
                            } catch (Throwable unused6) {
                            }
                        }
                        C6251g.m36894a(zipFile);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                c6114a = null;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            c6114a = null;
        }
    }

    /* renamed from: a */
    private static String m37150a(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    /* renamed from: a */
    private static String m37149a(C6114a c6114a, int i) {
        int m37162b = c6114a.m37162b(i);
        int m37160c = c6114a.m37160c(i);
        if (m37162b == 3) {
            return c6114a.m37159d(i);
        }
        return m37162b == 2 ? String.format("?%s%08X", m37150a(m37160c), Integer.valueOf(m37160c)) : (m37162b < 16 || m37162b > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(m37160c), Integer.valueOf(m37162b)) : String.valueOf(m37160c);
    }
}
