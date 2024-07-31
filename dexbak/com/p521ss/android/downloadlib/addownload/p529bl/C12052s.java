package com.p521ss.android.downloadlib.addownload.p529bl;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.ss.android.downloadlib.addownload.bl.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12052s {

    /* renamed from: ok */
    private static volatile C12052s f34115ok;

    /* renamed from: a */
    private long f34116a = 0;

    /* renamed from: bl */
    private ConcurrentHashMap<String, InterfaceC12050n> f34117bl = new ConcurrentHashMap<>();

    /* renamed from: s */
    private HashMap<String, Integer> f34119s = new HashMap<>();

    /* renamed from: n */
    private List<String> f34118n = new CopyOnWriteArrayList();

    /* renamed from: ok */
    public static C12052s m19245ok() {
        if (f34115ok == null) {
            synchronized (C12052s.class) {
                if (f34115ok == null) {
                    f34115ok = new C12052s();
                }
            }
        }
        return f34115ok;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public long m19248a() {
        return this.f34116a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bl */
    public void m19246bl() {
        this.f34116a = System.currentTimeMillis();
    }

    /* renamed from: a */
    public int m19247a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f34119s == null) {
            this.f34119s = new HashMap<>();
        }
        if (this.f34119s.containsKey(str)) {
            return this.f34119s.get(str).intValue();
        }
        return 0;
    }

    /* renamed from: ok */
    public void m19241ok(String str, InterfaceC12050n interfaceC12050n) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f34117bl.put(str, interfaceC12050n);
    }

    /* renamed from: ok */
    public void m19242ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f34117bl.remove(str);
    }

    @WorkerThread
    /* renamed from: ok */
    public static void m19244ok(C11998a c11998a) {
        DownloadInfo downloadInfo;
        if (c11998a == null || c11998a.mo19309a() <= 0 || (downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(c11998a.mo19285zz())) == null) {
            return;
        }
        m19243ok(downloadInfo);
    }

    @WorkerThread
    /* renamed from: ok */
    public static void m19243ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null || C12534ok.m17599ok(downloadInfo.getId()).m17593ok("delete_file_after_install", 0) == 0) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
