package com.bytedance.pangle.f.a;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class d {
    public static e a(File file) {
        ZipFile zipFile;
        a aVar;
        int b4;
        int i4;
        try {
            if (!file.exists()) {
                ZeusLogger.w("Zeus/install_pangle", file.getAbsolutePath() + " not exists!");
                g.a((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport("Zeus/install_pangle", "\u6ca1\u6709\u627e\u5230AndroidManifest.xml entry");
                    g.a(zipFile2);
                    return null;
                }
                aVar = new a();
                try {
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    aVar.a();
                    if (inputStream != null) {
                        aVar.f28748b = new b(inputStream);
                    }
                    do {
                        b4 = aVar.b();
                        if (b4 == 1) {
                            ZeusLogger.errReport("Zeus/install_pangle", "\u5df2\u8fbe\u5230END_DOCUMENT");
                            try {
                                aVar.a();
                            } catch (Throwable unused) {
                            }
                            g.a(zipFile2);
                            return null;
                        }
                    } while (b4 != 2);
                    int length = aVar.f28747a != 2 ? -1 : aVar.f28749c.length / 5;
                    String str = null;
                    String str2 = null;
                    for (int i5 = 0; i5 != length; i5++) {
                        if ("versionCode".equals(aVar.a(i5))) {
                            str = a(aVar, i5);
                        } else if ("package".equals(aVar.a(i5))) {
                            str2 = a(aVar, i5);
                        }
                    }
                    try {
                        i4 = Integer.parseInt(str);
                    } catch (Throwable unused2) {
                        i4 = -1;
                    }
                    if (i4 == -1) {
                        ZeusLogger.errReport("Zeus/install_pangle", "versionCode\u83b7\u53d6\u5931\u8d25:".concat(String.valueOf(str)));
                        try {
                            aVar.a();
                        } catch (Throwable unused3) {
                        }
                        g.a(zipFile2);
                        return null;
                    }
                    e eVar = new e(str2, i4);
                    try {
                        aVar.a();
                    } catch (Throwable unused4) {
                    }
                    g.a(zipFile2);
                    return eVar;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport("Zeus/install_pangle", "packageArchiveInfo == null", th);
                            return null;
                        }
                        e eVar2 = new e(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable unused5) {
                            }
                        }
                        g.a(zipFile);
                        return eVar2;
                    } finally {
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable unused6) {
                            }
                        }
                        g.a(zipFile);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = null;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            aVar = null;
        }
    }

    private static String a(int i4) {
        return (i4 >>> 24) == 1 ? "android:" : "";
    }

    private static String a(a aVar, int i4) {
        int b4 = aVar.b(i4);
        int c4 = aVar.c(i4);
        if (b4 == 3) {
            return aVar.d(i4);
        }
        return b4 == 2 ? String.format("?%s%08X", a(c4), Integer.valueOf(c4)) : (b4 < 16 || b4 > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(c4), Integer.valueOf(b4)) : String.valueOf(c4);
    }
}
