package com.ss.android.downloadlib.addownload.bl;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {
    private static volatile s ok;

    /* renamed from: a  reason: collision with root package name */
    private long f48396a = 0;
    private ConcurrentHashMap<String, n> bl = new ConcurrentHashMap<>();

    /* renamed from: s  reason: collision with root package name */
    private HashMap<String, Integer> f48398s = new HashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private List<String> f48397n = new CopyOnWriteArrayList();

    public static s ok() {
        if (ok == null) {
            synchronized (s.class) {
                if (ok == null) {
                    ok = new s();
                }
            }
        }
        return ok;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a() {
        return this.f48396a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bl() {
        this.f48396a = System.currentTimeMillis();
    }

    public int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f48398s == null) {
            this.f48398s = new HashMap<>();
        }
        if (this.f48398s.containsKey(str)) {
            return this.f48398s.get(str).intValue();
        }
        return 0;
    }

    public void ok(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.bl.put(str, nVar);
    }

    public void ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.bl.remove(str);
    }

    @WorkerThread
    public static void ok(com.ss.android.downloadad.api.ok.a aVar) {
        DownloadInfo downloadInfo;
        if (aVar == null || aVar.a() <= 0 || (downloadInfo = Downloader.getInstance(r.getContext()).getDownloadInfo(aVar.zz())) == null) {
            return;
        }
        ok(downloadInfo);
    }

    @WorkerThread
    public static void ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("delete_file_after_install", 0) == 0) {
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
