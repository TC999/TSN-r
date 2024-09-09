package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static volatile r f48900c;

    /* renamed from: f  reason: collision with root package name */
    private long f48901f;
    private final List<com.ss.android.downloadlib.addownload.r> xv = new CopyOnWriteArrayList();
    private final Map<String, com.ss.android.downloadlib.addownload.r> sr = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> ux = new CopyOnWriteArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private final Handler f48902w = new Handler(Looper.getMainLooper());

    private r() {
    }

    private void sr() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.r rVar : this.xv) {
            if (!rVar.w() && currentTimeMillis - rVar.sr() > 300000) {
                rVar.ev();
                arrayList.add(rVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.xv.removeAll(arrayList);
    }

    private synchronized void w(Context context, int i4, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.xv.size() <= 0) {
            xv(context, i4, downloadStatusChangeListener, downloadModel);
        } else {
            com.ss.android.downloadlib.addownload.r remove = this.xv.remove(0);
            remove.w(context).w(i4, downloadStatusChangeListener).w(downloadModel).c();
            this.sr.put(downloadModel.getDownloadUrl(), remove);
        }
    }

    private void xv(Context context, int i4, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.ux uxVar = new com.ss.android.downloadlib.addownload.ux();
        uxVar.w(context).w(i4, downloadStatusChangeListener).w(downloadModel).c();
        this.sr.put(downloadModel.getDownloadUrl(), uxVar);
    }

    public static r c() {
        if (f48900c == null) {
            synchronized (r.class) {
                if (f48900c == null) {
                    f48900c = new r();
                }
            }
        }
        return f48900c;
    }

    private void xv() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f48901f < 300000) {
            return;
        }
        this.f48901f = currentTimeMillis;
        if (this.xv.isEmpty()) {
            return;
        }
        sr();
    }

    public void c(Context context, int i4, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.addownload.r rVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z3 = k.gd().optInt("filter_download_url_key", 0) == 1;
        String c4 = com.ss.android.downloadlib.addownload.f.c().c(downloadModel.getDownloadUrl());
        if (z3 && !TextUtils.isEmpty(c4)) {
            rVar = this.sr.get(c4);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(c4);
                }
            }
        } else {
            rVar = this.sr.get(downloadModel.getDownloadUrl());
        }
        if (rVar != null) {
            rVar.w(context).w(i4, downloadStatusChangeListener).w(downloadModel).c();
        } else if (this.xv.isEmpty()) {
            if (z3) {
                if (!TextUtils.isEmpty(c4)) {
                    w(context, i4, downloadStatusChangeListener, downloadModel, c4);
                    return;
                }
                String c5 = com.ss.android.downloadlib.addownload.f.c().c(downloadModel);
                if (TextUtils.isEmpty(c5)) {
                    xv(context, i4, downloadStatusChangeListener, downloadModel);
                    return;
                }
                w(context, i4, downloadStatusChangeListener, downloadModel, c5);
                if (downloadModel instanceof AdDownloadModel) {
                    AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                    if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                        adDownloadModel2.setTaskKey(c5);
                        return;
                    }
                    return;
                }
                return;
            }
            xv(context, i4, downloadStatusChangeListener, downloadModel);
        } else if (z3) {
            if (!TextUtils.isEmpty(c4)) {
                c(context, i4, downloadStatusChangeListener, downloadModel, c4);
                return;
            }
            String c6 = com.ss.android.downloadlib.addownload.f.c().c(downloadModel);
            if (TextUtils.isEmpty(c6)) {
                w(context, i4, downloadStatusChangeListener, downloadModel);
                return;
            }
            c(context, i4, downloadStatusChangeListener, downloadModel, c6);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(c6);
                }
            }
        } else {
            w(context, i4, downloadStatusChangeListener, downloadModel);
        }
    }

    private void w(Context context, int i4, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.ux uxVar = new com.ss.android.downloadlib.addownload.ux();
        uxVar.w(context).w(i4, downloadStatusChangeListener).w(downloadModel).c(str).c();
        this.sr.put(str, uxVar);
        com.ss.android.downloadlib.addownload.f.c().c(str, downloadModel.getDownloadUrl());
    }

    public void w(final DownloadInfo downloadInfo, final String str) {
        this.f48902w.post(new Runnable() { // from class: com.ss.android.downloadlib.r.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = r.this.ux.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.c.c) {
                        ((com.ss.android.download.api.download.c.c) next).w(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.c.c) {
                            ((com.ss.android.download.api.download.c.c) softReference.get()).w(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler w() {
        return this.f48902w;
    }

    public com.ss.android.downloadlib.addownload.ux c(String str) {
        com.ss.android.downloadlib.addownload.r rVar;
        Map<String, com.ss.android.downloadlib.addownload.r> map = this.sr;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (k.gd().optInt("filter_download_url_key", 0) == 1) {
                rVar = this.sr.get(com.ss.android.downloadlib.addownload.f.c().c(str));
            } else {
                rVar = this.sr.get(str);
            }
            if (rVar instanceof com.ss.android.downloadlib.addownload.ux) {
                return (com.ss.android.downloadlib.addownload.ux) rVar;
            }
        }
        return null;
    }

    private synchronized void c(Context context, int i4, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.xv.size() <= 0) {
            w(context, i4, downloadStatusChangeListener, downloadModel, str);
        } else {
            com.ss.android.downloadlib.addownload.r remove = this.xv.remove(0);
            remove.w(context).w(i4, downloadStatusChangeListener).w(downloadModel).c(str).c();
            this.sr.put(str, remove);
            com.ss.android.downloadlib.addownload.f.c().c(str, downloadModel.getDownloadUrl());
        }
    }

    public void c(String str, int i4) {
        com.ss.android.downloadlib.addownload.r rVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z3 = k.gd().optInt("filter_download_url_key", 0) == 1;
        String c4 = com.ss.android.downloadlib.addownload.f.c().c(str);
        if (z3 && !TextUtils.isEmpty(c4)) {
            rVar = this.sr.get(c4);
        } else {
            rVar = this.sr.get(str);
        }
        if (rVar != null) {
            if (rVar.c(i4)) {
                this.xv.add(rVar);
                if (z3 && !TextUtils.isEmpty(c4)) {
                    this.sr.remove(c4);
                    com.ss.android.downloadlib.addownload.f.c().w(c4);
                } else {
                    this.sr.remove(str);
                }
            }
            xv();
        }
    }

    public void c(String str, boolean z3) {
        com.ss.android.downloadlib.addownload.r rVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z4 = k.gd().optInt("filter_download_url_key", 0) == 1;
        String c4 = com.ss.android.downloadlib.addownload.f.c().c(str);
        if (z4 && !TextUtils.isEmpty(c4)) {
            rVar = this.sr.get(c4);
        } else {
            rVar = this.sr.get(str);
        }
        if (rVar != null) {
            rVar.c(z3);
        }
    }

    public void c(String str, long j4, int i4, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        c(str, j4, i4, downloadEventConfig, downloadController, null, null);
    }

    public void c(String str, long j4, int i4, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        c(str, j4, i4, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void c(String str, long j4, int i4, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.r rVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z3 = k.gd().optInt("filter_download_url_key", 0) == 1;
        String c4 = com.ss.android.downloadlib.addownload.f.c().c(str);
        if (z3 && !TextUtils.isEmpty(c4)) {
            rVar = this.sr.get(c4);
        } else {
            rVar = this.sr.get(str);
        }
        if (rVar != null) {
            rVar.c(j4).w(downloadEventConfig).w(downloadController).c(onItemClickListener).c(iDownloadButtonClickListener).w(i4);
        }
    }

    public void c(com.ss.android.download.api.download.c.c cVar) {
        if (cVar != null) {
            if (com.ss.android.socialbase.downloader.r.c.xv().w("fix_listener_oom", false)) {
                this.ux.add(new SoftReference(cVar));
            } else {
                this.ux.add(cVar);
            }
        }
    }

    public void c(final DownloadModel downloadModel, @Nullable final DownloadController downloadController, @Nullable final DownloadEventConfig downloadEventConfig) {
        this.f48902w.post(new Runnable() { // from class: com.ss.android.downloadlib.r.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = r.this.ux.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.c.c) {
                        ((com.ss.android.download.api.download.c.c) next).c(downloadModel, downloadController, downloadEventConfig);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.c.c) {
                            ((com.ss.android.download.api.download.c.c) softReference.get()).c(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void c(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.f48902w.post(new Runnable() { // from class: com.ss.android.downloadlib.r.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = r.this.ux.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.c.c) {
                        ((com.ss.android.download.api.download.c.c) next).c(downloadInfo, baseException, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.c.c) {
                            ((com.ss.android.download.api.download.c.c) softReference.get()).c(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void c(final DownloadInfo downloadInfo, final String str) {
        this.f48902w.post(new Runnable() { // from class: com.ss.android.downloadlib.r.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = r.this.ux.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.c.c) {
                        ((com.ss.android.download.api.download.c.c) next).c(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.c.c) {
                            ((com.ss.android.download.api.download.c.c) softReference.get()).c(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void c(final DownloadInfo downloadInfo) {
        this.f48902w.post(new Runnable() { // from class: com.ss.android.downloadlib.r.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = r.this.ux.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.c.c) {
                        ((com.ss.android.download.api.download.c.c) next).c(downloadInfo);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.c.c) {
                            ((com.ss.android.download.api.download.c.c) softReference.get()).c(downloadInfo);
                        }
                    }
                }
            }
        });
    }
}
