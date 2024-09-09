package com.ss.android.downloadlib.addownload.bl;

import android.content.Context;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl {
    public static void a() {
        DownloadInfo downloadInfo;
        List successedDownloadInfosWithMimeType = Downloader.getInstance(r.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i4 = 0; i4 < successedDownloadInfosWithMimeType.size(); i4++) {
            if (((DownloadInfo) successedDownloadInfosWithMimeType.get(i4)) != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long ok = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("download_complete_file_expire_hours", 0) * 3600000;
                    if (ok <= 0) {
                        ok = 604800000;
                    }
                    boolean z3 = true;
                    if (currentTimeMillis < ok && !j.kf(r.getContext(), str)) {
                        z3 = false;
                    }
                    if (z3) {
                        ok(file);
                    }
                }
            }
        }
    }

    public static void ok() {
        List<DownloadInfo> ok = com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext());
        if (ok == null || ok.size() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < ok.size(); i4++) {
            DownloadInfo downloadInfo = ok.get(i4);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long lastModified = file.lastModified();
            long ok2 = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("download_file_expire_hours", 0) * 3600000;
            if (ok2 <= 0) {
                ok2 = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= ok2) {
                ok(file);
                Downloader.getInstance(r.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void ok(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            ok(externalCacheDir.getPath());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void ok(java.io.File r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.bl.bl.ok(java.io.File):void");
    }

    private static void ok(String str) {
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
                        ok(str4);
                    }
                }
            }
            file.delete();
        }
    }
}
