package com.p521ss.android.downloadlib.addownload.p529bl;

import android.content.Context;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.kuaishou.weapon.p205p0.C7193bi;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.io.File;
import java.util.List;

/* renamed from: com.ss.android.downloadlib.addownload.bl.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12049bl {
    /* renamed from: a */
    public static void m19258a() {
        DownloadInfo downloadInfo;
        List successedDownloadInfosWithMimeType = Downloader.getInstance(C12128r.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i = 0; i < successedDownloadInfosWithMimeType.size(); i++) {
            if (((DownloadInfo) successedDownloadInfosWithMimeType.get(i)) != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long m17593ok = C12534ok.m17599ok(downloadInfo.getId()).m17593ok("download_complete_file_expire_hours", 0) * C7193bi.f24584s;
                    if (m17593ok <= 0) {
                        m17593ok = C2624bk.f8680d;
                    }
                    boolean z = true;
                    if (currentTimeMillis < m17593ok && !C12197j.m18797kf(C12128r.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        m19255ok(file);
                    }
                }
            }
        }
    }

    /* renamed from: ok */
    public static void m19257ok() {
        List<DownloadInfo> m18064ok = C12361s.m18068k().m18064ok(C12128r.getContext());
        if (m18064ok == null || m18064ok.size() <= 0) {
            return;
        }
        for (int i = 0; i < m18064ok.size(); i++) {
            DownloadInfo downloadInfo = m18064ok.get(i);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long lastModified = file.lastModified();
            long m17593ok = C12534ok.m17599ok(downloadInfo.getId()).m17593ok("download_file_expire_hours", 0) * C7193bi.f24584s;
            if (m17593ok <= 0) {
                m17593ok = C2624bk.f8680d;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= m17593ok) {
                m19255ok(file);
                Downloader.getInstance(C12128r.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    /* renamed from: ok */
    public static void m19256ok(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            m19254ok(externalCacheDir.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m19255ok(java.io.File r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.downloadlib.addownload.p529bl.C12049bl.m19255ok(java.io.File):void");
    }

    /* renamed from: ok */
    private static void m19254ok(String str) {
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
                        m19254ok(str4);
                    }
                }
            }
            file.delete();
        }
    }
}
