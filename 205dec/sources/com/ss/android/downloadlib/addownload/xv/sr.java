package com.ss.android.downloadlib.addownload.xv;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static volatile sr f48737c;

    /* renamed from: w  reason: collision with root package name */
    private long f48738w = 0;
    private ConcurrentHashMap<String, ux> xv = new ConcurrentHashMap<>();
    private HashMap<String, Integer> sr = new HashMap<>();
    private List<String> ux = new CopyOnWriteArrayList();

    public static sr c() {
        if (f48737c == null) {
            synchronized (sr.class) {
                if (f48737c == null) {
                    f48737c = new sr();
                }
            }
        }
        return f48737c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long w() {
        return this.f48738w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xv() {
        this.f48738w = System.currentTimeMillis();
    }

    public int w(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.sr == null) {
            this.sr = new HashMap<>();
        }
        if (this.sr.containsKey(str)) {
            return this.sr.get(str).intValue();
        }
        return 0;
    }

    public void c(String str, ux uxVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.xv.put(str, uxVar);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.xv.remove(str);
    }

    @WorkerThread
    public static void c(com.ss.android.downloadad.api.c.w wVar) {
        DownloadInfo downloadInfo;
        if (wVar == null || wVar.w() <= 0 || (downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(wVar.fz())) == null) {
            return;
        }
        c(downloadInfo);
    }

    @WorkerThread
    public static void c(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
