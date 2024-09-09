package com.ss.android.downloadlib.addownload.w;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f48707c;
    private final ConcurrentHashMap<Long, DownloadController> sr;
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.c.w> ux;

    /* renamed from: w  reason: collision with root package name */
    private final ConcurrentHashMap<Long, DownloadModel> f48708w;
    private final ConcurrentHashMap<Long, DownloadEventConfig> xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private static f f48710c = new f();
    }

    public void f(long j4) {
        this.f48708w.remove(Long.valueOf(j4));
        this.xv.remove(Long.valueOf(j4));
        this.sr.remove(Long.valueOf(j4));
    }

    public com.ss.android.downloadad.api.c.w sr(long j4) {
        return this.ux.get(Long.valueOf(j4));
    }

    @NonNull
    public ux ux(long j4) {
        ux uxVar = new ux();
        uxVar.f48722c = j4;
        uxVar.f48723w = c(j4);
        DownloadEventConfig w3 = w(j4);
        uxVar.xv = w3;
        if (w3 == null) {
            uxVar.xv = new com.ss.android.download.api.download.xv();
        }
        DownloadController xv = xv(j4);
        uxVar.sr = xv;
        if (xv == null) {
            uxVar.sr = new com.ss.android.download.api.download.w();
        }
        return uxVar;
    }

    public DownloadController xv(long j4) {
        return this.sr.get(Long.valueOf(j4));
    }

    private f() {
        this.f48707c = false;
        this.f48708w = new ConcurrentHashMap<>();
        this.xv = new ConcurrentHashMap<>();
        this.sr = new ConcurrentHashMap<>();
        this.ux = new ConcurrentHashMap<>();
    }

    public void w() {
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.addownload.w.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.f48707c) {
                    return;
                }
                synchronized (f.class) {
                    if (!f.this.f48707c) {
                        f.this.ux.putAll(gd.c().w());
                        f.this.f48707c = true;
                    }
                }
            }
        }, true);
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.c.w> xv() {
        return this.ux;
    }

    public static f c() {
        return c.f48710c;
    }

    public DownloadEventConfig w(long j4) {
        return this.xv.get(Long.valueOf(j4));
    }

    public void c(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.f48708w.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public com.ss.android.downloadad.api.c.w w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.c.w wVar : this.ux.values()) {
            if (wVar != null && str.equals(wVar.c())) {
                return wVar;
            }
        }
        return null;
    }

    public void w(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.f48708w.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void c(long j4, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.xv.put(Long.valueOf(j4), downloadEventConfig);
        }
    }

    public void c(long j4, DownloadController downloadController) {
        if (downloadController != null) {
            this.sr.put(Long.valueOf(j4), downloadController);
        }
    }

    public synchronized void c(com.ss.android.downloadad.api.c.w wVar) {
        if (wVar == null) {
            return;
        }
        this.ux.put(Long.valueOf(wVar.w()), wVar);
        gd.c().c(wVar);
    }

    public DownloadModel c(long j4) {
        return this.f48708w.get(Long.valueOf(j4));
    }

    public com.ss.android.downloadad.api.c.w c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.c.w wVar : this.ux.values()) {
            if (wVar != null && str.equals(wVar.ux())) {
                return wVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.c.w c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.c.w wVar : this.ux.values()) {
            if (wVar != null && wVar.fz() == downloadInfo.getId()) {
                return wVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long c4 = a.c(new JSONObject(downloadInfo.getExtra()), "extra");
                if (c4 != 0) {
                    for (com.ss.android.downloadad.api.c.w wVar2 : this.ux.values()) {
                        if (wVar2 != null && wVar2.w() == c4) {
                            return wVar2;
                        }
                    }
                    com.ss.android.downloadlib.ux.xv.c().c("getNativeModelByInfo");
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.c.w wVar3 : this.ux.values()) {
            if (wVar3 != null && TextUtils.equals(wVar3.c(), downloadInfo.getUrl())) {
                return wVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.c.w c(int i4) {
        for (com.ss.android.downloadad.api.c.w wVar : this.ux.values()) {
            if (wVar != null && wVar.fz() == i4) {
                return wVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.c.w> c(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.c.w wVar : this.ux.values()) {
                if (wVar != null && TextUtils.equals(wVar.c(), str)) {
                    wVar.w(str2);
                    hashMap.put(Long.valueOf(wVar.w()), wVar);
                }
            }
        }
        return hashMap;
    }

    public synchronized void c(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        for (Long l4 : list) {
            long longValue = l4.longValue();
            arrayList.add(String.valueOf(longValue));
            this.ux.remove(Long.valueOf(longValue));
        }
        gd.c().c((List<String>) arrayList);
    }
}
