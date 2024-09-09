package com.tencent.gatherer.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {
    public static String a(Context context, b bVar) {
        boolean a4;
        PackageInfo packageInfo;
        String str;
        boolean z3 = true;
        if (bVar != null) {
            try {
                z3 = bVar.b();
                a4 = bVar.a();
            } catch (Throwable th) {
                d.a("WebViewFactory failed!", th);
            }
        } else {
            a4 = true;
        }
        d.a("getChromeInfoVersion visitSystem = " + z3 + " visitDexOrODex = " + a4);
        if (z3) {
            long currentTimeMillis = System.currentTimeMillis();
            String a5 = a();
            d.a("getPackageInfo, package name: " + a5);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(a5, 1152);
                str = packageInfo.versionName;
                d.a("getPackageInfo, ver: " + str);
            } catch (PackageManager.NameNotFoundException e4) {
                d.a("get webview application info failed! ", e4);
            }
            if (a5.equals("com.google.android.webview")) {
                d.a("getPackageInfo, chrome ver: " + str + "web cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return str;
            } else if (a5.equals("com.android.webview") && !TextUtils.isEmpty(str) && (str.contains("-arm64") || packageInfo.versionName.indexOf(".") < 0)) {
                String str2 = str.substring(0, 2) + ".0.0.0";
                d.a("getPackageInfo, chrom ver: " + str2);
                return str2;
            } else if (a5.equals("com.android.webview") && com.tencent.gatherer.a.a.a.g.c.a(packageInfo.versionName)) {
                d.a("16TH chrom ver: " + packageInfo.versionName);
                return packageInfo.versionName;
            } else if (a4) {
                if (packageInfo.applicationInfo != null) {
                    d.a("sourceDire: " + packageInfo.applicationInfo.sourceDir);
                    String str3 = packageInfo.applicationInfo.sourceDir;
                    if (!TextUtils.isEmpty(str3)) {
                        ByteBuffer a6 = a(str3);
                        if (a6 != null) {
                            d.a("readDexFile cost:" + (System.currentTimeMillis() - currentTimeMillis));
                            String a7 = new com.tencent.gatherer.a.a.a.g.c(a6).a();
                            d.a("web ver:" + a7 + "DexParser cost:" + (System.currentTimeMillis() - currentTimeMillis));
                            return a7;
                        }
                        String a8 = a(b(str3));
                        d.a("odex web ver:" + a8 + " web cost:" + (System.currentTimeMillis() - currentTimeMillis));
                        return a8;
                    }
                } else {
                    d.a("applicationInfo is null ");
                }
                return "unknow";
            } else {
                return "unknow";
            }
        }
        return "unknow";
    }

    private static String b() {
        try {
            d.a("getWebViewPackageName4Lollipop ");
            return (String) f.a("android.webkit.WebViewFactory", "getWebViewPackageName", null, new Object[0]);
        } catch (Throwable th) {
            d.a("getWebViewPackageName4Lollipop failed!", th);
            return "com.google.android.webview";
        }
    }

    private static String c() {
        try {
            d.a("getWebViewPackageName4More ");
            return ((Context) f.a("android.webkit.WebViewFactory", "getWebViewContextAndSetProvider", null, new Object[0])).getApplicationInfo().packageName;
        } catch (Throwable th) {
            d.a("getWebViewPackageName4N failed!", th);
            return "com.google.android.webview";
        }
    }

    public static byte[] b(String str) {
        File[] listFiles;
        for (File file : new File(new File(str).getParent() + "/oat/arm").listFiles()) {
            if (file.isFile() && file.getName().endsWith(".odex")) {
                String absolutePath = file.getAbsolutePath();
                byte[] c4 = c(absolutePath);
                if (c4 != null) {
                    d.a("find odex file:" + absolutePath + ", odexData-len:" + c4.length);
                    byte[] a4 = com.tencent.gatherer.a.a.a.h.a.a(c4).a().a();
                    StringBuilder sb = new StringBuilder();
                    sb.append("rodata-len ");
                    sb.append(a4.length);
                    d.a(sb.toString());
                    return a4;
                }
                d.a("read " + absolutePath + " failed!");
            }
        }
        return null;
    }

    private static byte[] c(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            if (fileInputStream.available() > 10485760) {
                fileInputStream.close();
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(fileInputStream.available());
            byte[] bArr = new byte[4096];
            int i4 = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    allocate.put(bArr, 0, read);
                    i4 += read;
                } else {
                    fileInputStream.close();
                    d.a("read " + str + " ret:" + i4);
                    return allocate.array();
                }
            }
        } catch (Throwable th) {
            d.a("readDexFile got Exception:", th);
            return null;
        }
    }

    private static String a() {
        int a4 = a.a();
        if (a4 <= 20) {
            d.a("sdk  = " + a4);
            return "com.google.android.webview";
        }
        switch (a4) {
            case 21:
            case 22:
            case 23:
                return b();
            default:
                return c();
        }
    }

    public static ByteBuffer a(String str) {
        ZipFile zipFile;
        InputStream inputStream;
        int available;
        d.a("apkpath: " + str);
        ByteBuffer byteBuffer = null;
        try {
            zipFile = new ZipFile(str);
            ZipEntry entry = zipFile.getEntry("classes.dex");
            if (entry == null) {
                d.a("zip not found classes.dex ");
            }
            d.a("zip entry: " + entry.toString());
            inputStream = zipFile.getInputStream(entry);
            available = inputStream.available();
        } catch (Throwable th) {
            d.a("readDexFile got Throwable:", th);
        }
        if (available > 10485760) {
            inputStream.close();
            zipFile.close();
            return null;
        }
        byteBuffer = ByteBuffer.allocate(available);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteBuffer.put(bArr, 0, read);
        }
        inputStream.close();
        zipFile.close();
        return byteBuffer;
    }

    private static String a(byte[] bArr) {
        String str;
        Throwable th;
        String str2 = "";
        if (bArr == null) {
            return "";
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < bArr.length; i6++) {
            if (i4 > 50000) {
                d.b("findVersionFromData strCount > 20000");
                return str2;
            }
            if (bArr[i6] == 0) {
                int i7 = i6 - i5;
                if (i7 < 8 || i7 > 20) {
                    i5 = i6 + 1;
                } else {
                    try {
                        byte[] bArr2 = new byte[i7];
                        System.arraycopy(bArr, i5, bArr2, 0, i7);
                        i5 = i6 + 1;
                        int i8 = i7 - 1;
                        if ((bArr2[0] & 255) == i8) {
                            byte[] bArr3 = new byte[i8];
                            System.arraycopy(bArr2, 1, bArr3, 0, i8);
                            bArr2 = bArr3;
                        }
                        if (com.tencent.gatherer.a.a.a.g.c.a(bArr2)) {
                            str = new String(bArr2, "UTF-8");
                            try {
                                d.a(str + ", strcount:" + i4);
                                return str;
                            } catch (Throwable th2) {
                                th = th2;
                                d.a("findVersionFromData got Exception:", th);
                                str2 = str;
                            }
                        } else {
                            i4++;
                        }
                    } catch (Throwable th3) {
                        str = str2;
                        th = th3;
                    }
                }
            }
        }
        return str2;
    }
}
