package com.p521ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.p521ss.android.download.api.config.IDownloadButtonClickListener;
import com.p521ss.android.download.api.config.OnItemClickListener;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.download.DownloadStatusChangeListener;
import com.p521ss.android.download.api.download.p524ok.InterfaceC11979ok;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadlib.addownload.C12092kf;
import com.p521ss.android.downloadlib.addownload.C12095n;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.InterfaceC12089h;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.ss.android.downloadlib.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12184h {

    /* renamed from: ok */
    private static volatile C12184h f34443ok;

    /* renamed from: kf */
    private long f34446kf;

    /* renamed from: bl */
    private final List<InterfaceC12089h> f34445bl = new CopyOnWriteArrayList();

    /* renamed from: s */
    private final Map<String, InterfaceC12089h> f34448s = new ConcurrentHashMap();

    /* renamed from: n */
    private final CopyOnWriteArrayList<Object> f34447n = new CopyOnWriteArrayList<>();

    /* renamed from: a */
    private final Handler f34444a = new Handler(Looper.getMainLooper());

    private C12184h() {
    }

    /* renamed from: a */
    private synchronized void m18840a(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.f34445bl.size() <= 0) {
            m18836bl(context, i, downloadStatusChangeListener, downloadModel);
        } else {
            InterfaceC12089h remove = this.f34445bl.remove(0);
            remove.mo19108a(context).mo19109a(i, downloadStatusChangeListener).mo19105a(downloadModel).mo19084ok();
            this.f34448s.put(downloadModel.getDownloadUrl(), remove);
        }
    }

    /* renamed from: bl */
    private void m18836bl(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        C12095n c12095n = new C12095n();
        c12095n.mo19108a(context).mo19109a(i, downloadStatusChangeListener).mo19105a(downloadModel).mo19084ok();
        this.f34448s.put(downloadModel.getDownloadUrl(), c12095n);
    }

    /* renamed from: s */
    private void m18820s() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (InterfaceC12089h interfaceC12089h : this.f34445bl) {
            if (!interfaceC12089h.mo19111a() && currentTimeMillis - interfaceC12089h.mo19058s() > 300000) {
                interfaceC12089h.mo19065p();
                arrayList.add(interfaceC12089h);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f34445bl.removeAll(arrayList);
    }

    /* renamed from: ok */
    public static C12184h m18835ok() {
        if (f34443ok == null) {
            synchronized (C12184h.class) {
                if (f34443ok == null) {
                    f34443ok = new C12184h();
                }
            }
        }
        return f34443ok;
    }

    /* renamed from: bl */
    private void m18837bl() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f34446kf < 300000) {
            return;
        }
        this.f34446kf = currentTimeMillis;
        if (this.f34445bl.isEmpty()) {
            return;
        }
        m18820s();
    }

    /* renamed from: ok */
    public void m18834ok(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        InterfaceC12089h interfaceC12089h;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z = C12128r.m18946q().optInt("filter_download_url_key", 0) == 1;
        String m19114ok = C12092kf.m19116ok().m19114ok(downloadModel.getDownloadUrl());
        if (z && !TextUtils.isEmpty(m19114ok)) {
            interfaceC12089h = this.f34448s.get(m19114ok);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(m19114ok);
                }
            }
        } else {
            interfaceC12089h = this.f34448s.get(downloadModel.getDownloadUrl());
        }
        if (interfaceC12089h != null) {
            interfaceC12089h.mo19108a(context).mo19109a(i, downloadStatusChangeListener).mo19105a(downloadModel).mo19084ok();
        } else if (this.f34445bl.isEmpty()) {
            if (z) {
                if (!TextUtils.isEmpty(m19114ok)) {
                    m18839a(context, i, downloadStatusChangeListener, downloadModel, m19114ok);
                    return;
                }
                String m19115ok = C12092kf.m19116ok().m19115ok(downloadModel);
                if (TextUtils.isEmpty(m19115ok)) {
                    m18836bl(context, i, downloadStatusChangeListener, downloadModel);
                    return;
                }
                m18839a(context, i, downloadStatusChangeListener, downloadModel, m19115ok);
                if (downloadModel instanceof AdDownloadModel) {
                    AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                    if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                        adDownloadModel2.setTaskKey(m19115ok);
                        return;
                    }
                    return;
                }
                return;
            }
            m18836bl(context, i, downloadStatusChangeListener, downloadModel);
        } else if (z) {
            if (!TextUtils.isEmpty(m19114ok)) {
                m18833ok(context, i, downloadStatusChangeListener, downloadModel, m19114ok);
                return;
            }
            String m19115ok2 = C12092kf.m19116ok().m19115ok(downloadModel);
            if (TextUtils.isEmpty(m19115ok2)) {
                m18840a(context, i, downloadStatusChangeListener, downloadModel);
                return;
            }
            m18833ok(context, i, downloadStatusChangeListener, downloadModel, m19115ok2);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(m19115ok2);
                }
            }
        } else {
            m18840a(context, i, downloadStatusChangeListener, downloadModel);
        }
    }

    /* renamed from: a */
    private void m18839a(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        C12095n c12095n = new C12095n();
        c12095n.mo19108a(context).mo19109a(i, downloadStatusChangeListener).mo19105a(downloadModel).mo19068ok(str).mo19084ok();
        this.f34448s.put(str, c12095n);
        C12092kf.m19116ok().m19113ok(str, downloadModel.getDownloadUrl());
    }

    /* renamed from: a */
    public void m18838a(final DownloadInfo downloadInfo, final String str) {
        this.f34444a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = C12184h.this.f34447n.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof InterfaceC11979ok) {
                        ((InterfaceC11979ok) next).mo19615a(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof InterfaceC11979ok) {
                            ((InterfaceC11979ok) softReference.get()).mo19615a(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public Handler m18841a() {
        return this.f34444a;
    }

    /* renamed from: ok */
    public C12095n m18826ok(String str) {
        InterfaceC12089h interfaceC12089h;
        Map<String, InterfaceC12089h> map = this.f34448s;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (C12128r.m18946q().optInt("filter_download_url_key", 0) == 1) {
                interfaceC12089h = this.f34448s.get(C12092kf.m19116ok().m19114ok(str));
            } else {
                interfaceC12089h = this.f34448s.get(str);
            }
            if (interfaceC12089h instanceof C12095n) {
                return (C12095n) interfaceC12089h;
            }
        }
        return null;
    }

    /* renamed from: ok */
    private synchronized void m18833ok(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.f34445bl.size() <= 0) {
            m18839a(context, i, downloadStatusChangeListener, downloadModel, str);
        } else {
            InterfaceC12089h remove = this.f34445bl.remove(0);
            remove.mo19108a(context).mo19109a(i, downloadStatusChangeListener).mo19105a(downloadModel).mo19068ok(str).mo19084ok();
            this.f34448s.put(str, remove);
            C12092kf.m19116ok().m19113ok(str, downloadModel.getDownloadUrl());
        }
    }

    /* renamed from: ok */
    public void m18825ok(String str, int i) {
        InterfaceC12089h interfaceC12089h;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = C12128r.m18946q().optInt("filter_download_url_key", 0) == 1;
        String m19114ok = C12092kf.m19116ok().m19114ok(str);
        if (z && !TextUtils.isEmpty(m19114ok)) {
            interfaceC12089h = this.f34448s.get(m19114ok);
        } else {
            interfaceC12089h = this.f34448s.get(str);
        }
        if (interfaceC12089h != null) {
            if (interfaceC12089h.mo19083ok(i)) {
                this.f34445bl.add(interfaceC12089h);
                if (z && !TextUtils.isEmpty(m19114ok)) {
                    this.f34448s.remove(m19114ok);
                    C12092kf.m19116ok().m19118a(m19114ok);
                } else {
                    this.f34448s.remove(str);
                }
            }
            m18837bl();
        }
    }

    /* renamed from: ok */
    public void m18821ok(String str, boolean z) {
        InterfaceC12089h interfaceC12089h;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = C12128r.m18946q().optInt("filter_download_url_key", 0) == 1;
        String m19114ok = C12092kf.m19116ok().m19114ok(str);
        if (z2 && !TextUtils.isEmpty(m19114ok)) {
            interfaceC12089h = this.f34448s.get(m19114ok);
        } else {
            interfaceC12089h = this.f34448s.get(str);
        }
        if (interfaceC12089h != null) {
            interfaceC12089h.mo19067ok(z);
        }
    }

    /* renamed from: ok */
    public void m18824ok(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        m18822ok(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    /* renamed from: ok */
    public void m18823ok(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        m18822ok(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    /* renamed from: ok */
    public void m18822ok(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        InterfaceC12089h interfaceC12089h;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = C12128r.m18946q().optInt("filter_download_url_key", 0) == 1;
        String m19114ok = C12092kf.m19116ok().m19114ok(str);
        if (z && !TextUtils.isEmpty(m19114ok)) {
            interfaceC12089h = this.f34448s.get(m19114ok);
        } else {
            interfaceC12089h = this.f34448s.get(str);
        }
        if (interfaceC12089h != null) {
            interfaceC12089h.mo19080ok(j).mo19106a(downloadEventConfig).mo19107a(downloadController).mo19077ok(onItemClickListener).mo19078ok(iDownloadButtonClickListener).mo19110a(i);
        }
    }

    /* renamed from: ok */
    public void m18831ok(InterfaceC11979ok interfaceC11979ok) {
        if (interfaceC11979ok != null) {
            if (C12534ok.m17605bl().m17606a("fix_listener_oom", false)) {
                this.f34447n.add(new SoftReference(interfaceC11979ok));
            } else {
                this.f34447n.add(interfaceC11979ok);
            }
        }
    }

    /* renamed from: ok */
    public void m18832ok(final DownloadModel downloadModel, @Nullable final DownloadController downloadController, @Nullable final DownloadEventConfig downloadEventConfig) {
        this.f34444a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = C12184h.this.f34447n.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof InterfaceC11979ok) {
                        ((InterfaceC11979ok) next).mo19614ok(downloadModel, downloadController, downloadEventConfig);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof InterfaceC11979ok) {
                            ((InterfaceC11979ok) softReference.get()).mo19614ok(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: ok */
    public void m18828ok(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.f34444a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = C12184h.this.f34447n.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof InterfaceC11979ok) {
                        ((InterfaceC11979ok) next).mo19612ok(downloadInfo, baseException, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof InterfaceC11979ok) {
                            ((InterfaceC11979ok) softReference.get()).mo19612ok(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: ok */
    public void m18827ok(final DownloadInfo downloadInfo, final String str) {
        this.f34444a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = C12184h.this.f34447n.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof InterfaceC11979ok) {
                        ((InterfaceC11979ok) next).mo19611ok(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof InterfaceC11979ok) {
                            ((InterfaceC11979ok) softReference.get()).mo19611ok(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: ok */
    public void m18829ok(final DownloadInfo downloadInfo) {
        this.f34444a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = C12184h.this.f34447n.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof InterfaceC11979ok) {
                        ((InterfaceC11979ok) next).mo19613ok(downloadInfo);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof InterfaceC11979ok) {
                            ((InterfaceC11979ok) softReference.get()).mo19613ok(downloadInfo);
                        }
                    }
                }
            }
        });
    }
}
