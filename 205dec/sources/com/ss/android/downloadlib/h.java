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
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {
    private static volatile h ok;
    private long kf;
    private final List<com.ss.android.downloadlib.addownload.h> bl = new CopyOnWriteArrayList();

    /* renamed from: s  reason: collision with root package name */
    private final Map<String, com.ss.android.downloadlib.addownload.h> f48828s = new ConcurrentHashMap();

    /* renamed from: n  reason: collision with root package name */
    private final CopyOnWriteArrayList<Object> f48827n = new CopyOnWriteArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private final Handler f48826a = new Handler(Looper.getMainLooper());

    private h() {
    }

    private synchronized void a(Context context, int i4, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.bl.size() <= 0) {
            bl(context, i4, downloadStatusChangeListener, downloadModel);
        } else {
            com.ss.android.downloadlib.addownload.h remove = this.bl.remove(0);
            remove.a(context).a(i4, downloadStatusChangeListener).a(downloadModel).ok();
            this.f48828s.put(downloadModel.getDownloadUrl(), remove);
        }
    }

    private void bl(Context context, int i4, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.n nVar = new com.ss.android.downloadlib.addownload.n();
        nVar.a(context).a(i4, downloadStatusChangeListener).a(downloadModel).ok();
        this.f48828s.put(downloadModel.getDownloadUrl(), nVar);
    }

    private void s() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.h hVar : this.bl) {
            if (!hVar.a() && currentTimeMillis - hVar.s() > 300000) {
                hVar.p();
                arrayList.add(hVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.bl.removeAll(arrayList);
    }

    public static h ok() {
        if (ok == null) {
            synchronized (h.class) {
                if (ok == null) {
                    ok = new h();
                }
            }
        }
        return ok;
    }

    private void bl() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.kf < 300000) {
            return;
        }
        this.kf = currentTimeMillis;
        if (this.bl.isEmpty()) {
            return;
        }
        s();
    }

    public void ok(Context context, int i4, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z3 = com.ss.android.downloadlib.addownload.r.q().optInt("filter_download_url_key", 0) == 1;
        String ok2 = com.ss.android.downloadlib.addownload.kf.ok().ok(downloadModel.getDownloadUrl());
        if (z3 && !TextUtils.isEmpty(ok2)) {
            hVar = this.f48828s.get(ok2);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(ok2);
                }
            }
        } else {
            hVar = this.f48828s.get(downloadModel.getDownloadUrl());
        }
        if (hVar != null) {
            hVar.a(context).a(i4, downloadStatusChangeListener).a(downloadModel).ok();
        } else if (this.bl.isEmpty()) {
            if (z3) {
                if (!TextUtils.isEmpty(ok2)) {
                    a(context, i4, downloadStatusChangeListener, downloadModel, ok2);
                    return;
                }
                String ok3 = com.ss.android.downloadlib.addownload.kf.ok().ok(downloadModel);
                if (TextUtils.isEmpty(ok3)) {
                    bl(context, i4, downloadStatusChangeListener, downloadModel);
                    return;
                }
                a(context, i4, downloadStatusChangeListener, downloadModel, ok3);
                if (downloadModel instanceof AdDownloadModel) {
                    AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                    if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                        adDownloadModel2.setTaskKey(ok3);
                        return;
                    }
                    return;
                }
                return;
            }
            bl(context, i4, downloadStatusChangeListener, downloadModel);
        } else if (z3) {
            if (!TextUtils.isEmpty(ok2)) {
                ok(context, i4, downloadStatusChangeListener, downloadModel, ok2);
                return;
            }
            String ok4 = com.ss.android.downloadlib.addownload.kf.ok().ok(downloadModel);
            if (TextUtils.isEmpty(ok4)) {
                a(context, i4, downloadStatusChangeListener, downloadModel);
                return;
            }
            ok(context, i4, downloadStatusChangeListener, downloadModel, ok4);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(ok4);
                }
            }
        } else {
            a(context, i4, downloadStatusChangeListener, downloadModel);
        }
    }

    private void a(Context context, int i4, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.n nVar = new com.ss.android.downloadlib.addownload.n();
        nVar.a(context).a(i4, downloadStatusChangeListener).a(downloadModel).ok(str).ok();
        this.f48828s.put(str, nVar);
        com.ss.android.downloadlib.addownload.kf.ok().ok(str, downloadModel.getDownloadUrl());
    }

    public void a(final DownloadInfo downloadInfo, final String str) {
        this.f48826a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.f48827n.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.ok.ok) {
                        ((com.ss.android.download.api.download.ok.ok) next).a(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok.ok) {
                            ((com.ss.android.download.api.download.ok.ok) softReference.get()).a(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler a() {
        return this.f48826a;
    }

    public com.ss.android.downloadlib.addownload.n ok(String str) {
        com.ss.android.downloadlib.addownload.h hVar;
        Map<String, com.ss.android.downloadlib.addownload.h> map = this.f48828s;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (com.ss.android.downloadlib.addownload.r.q().optInt("filter_download_url_key", 0) == 1) {
                hVar = this.f48828s.get(com.ss.android.downloadlib.addownload.kf.ok().ok(str));
            } else {
                hVar = this.f48828s.get(str);
            }
            if (hVar instanceof com.ss.android.downloadlib.addownload.n) {
                return (com.ss.android.downloadlib.addownload.n) hVar;
            }
        }
        return null;
    }

    private synchronized void ok(Context context, int i4, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.bl.size() <= 0) {
            a(context, i4, downloadStatusChangeListener, downloadModel, str);
        } else {
            com.ss.android.downloadlib.addownload.h remove = this.bl.remove(0);
            remove.a(context).a(i4, downloadStatusChangeListener).a(downloadModel).ok(str).ok();
            this.f48828s.put(str, remove);
            com.ss.android.downloadlib.addownload.kf.ok().ok(str, downloadModel.getDownloadUrl());
        }
    }

    public void ok(String str, int i4) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z3 = com.ss.android.downloadlib.addownload.r.q().optInt("filter_download_url_key", 0) == 1;
        String ok2 = com.ss.android.downloadlib.addownload.kf.ok().ok(str);
        if (z3 && !TextUtils.isEmpty(ok2)) {
            hVar = this.f48828s.get(ok2);
        } else {
            hVar = this.f48828s.get(str);
        }
        if (hVar != null) {
            if (hVar.ok(i4)) {
                this.bl.add(hVar);
                if (z3 && !TextUtils.isEmpty(ok2)) {
                    this.f48828s.remove(ok2);
                    com.ss.android.downloadlib.addownload.kf.ok().a(ok2);
                } else {
                    this.f48828s.remove(str);
                }
            }
            bl();
        }
    }

    public void ok(String str, boolean z3) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z4 = com.ss.android.downloadlib.addownload.r.q().optInt("filter_download_url_key", 0) == 1;
        String ok2 = com.ss.android.downloadlib.addownload.kf.ok().ok(str);
        if (z4 && !TextUtils.isEmpty(ok2)) {
            hVar = this.f48828s.get(ok2);
        } else {
            hVar = this.f48828s.get(str);
        }
        if (hVar != null) {
            hVar.ok(z3);
        }
    }

    public void ok(String str, long j4, int i4, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        ok(str, j4, i4, downloadEventConfig, downloadController, null, null);
    }

    public void ok(String str, long j4, int i4, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        ok(str, j4, i4, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void ok(String str, long j4, int i4, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z3 = com.ss.android.downloadlib.addownload.r.q().optInt("filter_download_url_key", 0) == 1;
        String ok2 = com.ss.android.downloadlib.addownload.kf.ok().ok(str);
        if (z3 && !TextUtils.isEmpty(ok2)) {
            hVar = this.f48828s.get(ok2);
        } else {
            hVar = this.f48828s.get(str);
        }
        if (hVar != null) {
            hVar.ok(j4).a(downloadEventConfig).a(downloadController).ok(onItemClickListener).ok(iDownloadButtonClickListener).a(i4);
        }
    }

    public void ok(com.ss.android.download.api.download.ok.ok okVar) {
        if (okVar != null) {
            if (com.ss.android.socialbase.downloader.h.ok.bl().a("fix_listener_oom", false)) {
                this.f48827n.add(new SoftReference(okVar));
            } else {
                this.f48827n.add(okVar);
            }
        }
    }

    public void ok(final DownloadModel downloadModel, @Nullable final DownloadController downloadController, @Nullable final DownloadEventConfig downloadEventConfig) {
        this.f48826a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.f48827n.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.ok.ok) {
                        ((com.ss.android.download.api.download.ok.ok) next).ok(downloadModel, downloadController, downloadEventConfig);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok.ok) {
                            ((com.ss.android.download.api.download.ok.ok) softReference.get()).ok(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void ok(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.f48826a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.f48827n.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.ok.ok) {
                        ((com.ss.android.download.api.download.ok.ok) next).ok(downloadInfo, baseException, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok.ok) {
                            ((com.ss.android.download.api.download.ok.ok) softReference.get()).ok(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void ok(final DownloadInfo downloadInfo, final String str) {
        this.f48826a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.f48827n.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.ok.ok) {
                        ((com.ss.android.download.api.download.ok.ok) next).ok(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok.ok) {
                            ((com.ss.android.download.api.download.ok.ok) softReference.get()).ok(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void ok(final DownloadInfo downloadInfo) {
        this.f48826a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = h.this.f48827n.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.ok.ok) {
                        ((com.ss.android.download.api.download.ok.ok) next).ok(downloadInfo);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok.ok) {
                            ((com.ss.android.download.api.download.ok.ok) softReference.get()).ok(downloadInfo);
                        }
                    }
                }
            }
        });
    }
}
