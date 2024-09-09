package com.ss.android.downloadlib.addownload.xv;

import android.content.Context;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv {
    public static void c() {
        List<DownloadInfo> c4 = com.ss.android.socialbase.appdownloader.sr.p().c(k.getContext());
        if (c4 == null || c4.size() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < c4.size(); i4++) {
            DownloadInfo downloadInfo = c4.get(i4);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long lastModified = file.lastModified();
            long c5 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("download_file_expire_hours", 0) * 3600000;
            if (c5 <= 0) {
                c5 = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= c5) {
                c(file);
                Downloader.getInstance(k.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void w() {
        DownloadInfo downloadInfo;
        List successedDownloadInfosWithMimeType = Downloader.getInstance(k.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i4 = 0; i4 < successedDownloadInfosWithMimeType.size(); i4++) {
            if (((DownloadInfo) successedDownloadInfosWithMimeType.get(i4)) != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("download_complete_file_expire_hours", 0) * 3600000;
                    if (c4 <= 0) {
                        c4 = 604800000;
                    }
                    boolean z3 = true;
                    if (currentTimeMillis < c4 && !a.f(k.getContext(), str)) {
                        z3 = false;
                    }
                    if (z3) {
                        c(file);
                    }
                }
            }
        }
    }

    public static void c(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            c(externalCacheDir.getPath());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(java.io.File r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            java.lang.String r0 = "1"
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            r1.write(r0)     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            r1.close()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2c
            goto L28
        L13:
            r0 = move-exception
            goto L1b
        L15:
            r3 = move-exception
            goto L2e
        L17:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L1b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L28
            r1.close()     // Catch: java.lang.Exception -> L24
            goto L28
        L24:
            r0 = move-exception
            r0.printStackTrace()
        L28:
            r3.delete()
            return
        L2c:
            r3 = move-exception
            r0 = r1
        L2e:
            if (r0 == 0) goto L38
            r0.close()     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r0 = move-exception
            r0.printStackTrace()
        L38:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.xv.xv.c(java.io.File):void");
    }

    private static void c(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str2 : list) {
                if (str2 != null) {
                    String str3 = File.separator;
                    String str4 = str.endsWith(str3) ? str + str2 : str + str3 + str2;
                    File file2 = new File(str4);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        c(str4);
                    }
                }
            }
            file.delete();
        }
    }
}
