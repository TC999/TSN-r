package com.p521ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.constants.EnumC12414kf;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12428er;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12468r;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.impls.C12542j;
import com.p521ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import com.p521ss.android.socialbase.downloader.p557s.C12723ok;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12515s {

    /* renamed from: ok */
    private static volatile C12515s f35175ok;

    /* renamed from: a */
    private volatile SparseArray<Boolean> f35176a = new SparseArray<>();

    /* renamed from: bl */
    private Handler f35177bl = new Handler(Looper.getMainLooper());

    /* renamed from: s */
    private volatile List<InterfaceC12428er> f35178s = new ArrayList();

    /* renamed from: ok */
    public static C12515s m17660ok() {
        if (f35175ok == null) {
            synchronized (C12515s.class) {
                f35175ok = new C12515s();
            }
        }
        return f35175ok;
    }

    /* renamed from: a */
    public void m17679a(InterfaceC12428er interfaceC12428er) {
        if (interfaceC12428er == null) {
            return;
        }
        synchronized (this.f35178s) {
            if (this.f35178s.contains(interfaceC12428er)) {
                this.f35178s.remove(interfaceC12428er);
            }
        }
    }

    /* renamed from: bl */
    public InterfaceC12522z m17672bl(int i) {
        boolean z = true;
        return C12542j.m17583ok((m17659ok(i) != 1 || C12713kf.m16605bl()) ? false : false);
    }

    /* renamed from: h */
    public void m17669h(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return;
        }
        m17672bl.mo17419s(i);
    }

    /* renamed from: i */
    public void m17668i(int i) {
        InterfaceC12522z m17583ok = C12542j.m17583ok(false);
        if (m17583ok != null) {
            m17583ok.mo17422r(i);
        }
        InterfaceC12522z m17583ok2 = C12542j.m17583ok(true);
        if (m17583ok2 != null) {
            m17583ok2.mo17422r(i);
        }
    }

    /* renamed from: j */
    public InterfaceC12427ep m17667j(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return null;
        }
        return m17672bl.mo17415x(i);
    }

    /* renamed from: k */
    public boolean m17666k(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return false;
        }
        return m17672bl.mo17456h(i);
    }

    /* renamed from: kf */
    public void m17664kf(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return;
        }
        m17672bl.mo17461bl(i);
    }

    /* renamed from: n */
    public boolean m17662n(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return false;
        }
        return m17672bl.mo17471a(i);
    }

    /* renamed from: p */
    public long m17645p(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return 0L;
        }
        return m17672bl.mo17449n(i);
    }

    /* renamed from: q */
    public int m17644q(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return 0;
        }
        return m17672bl.mo17451kf(i);
    }

    /* renamed from: r */
    public DownloadInfo m17643r(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return null;
        }
        return m17672bl.mo17424p(i);
    }

    /* renamed from: rh */
    public void m17642rh(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return;
        }
        m17672bl.mo17453k(i);
    }

    /* renamed from: s */
    public void m17640s(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return;
        }
        m17672bl.mo17446ok(i);
    }

    /* renamed from: t */
    public boolean m17637t(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return false;
        }
        return m17672bl.mo17454j(i);
    }

    /* renamed from: td */
    public IDownloadFileUriProvider m17636td(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return null;
        }
        return m17672bl.mo17413zz(i);
    }

    /* renamed from: x */
    public void m17635x(int i) {
        if (i == 0) {
            return;
        }
        m17680a(i, true);
        InterfaceC12522z m17583ok = C12542j.m17583ok(true);
        if (m17583ok == null) {
            return;
        }
        m17583ok.startService();
    }

    /* renamed from: z */
    public InterfaceC12480v m17634z(int i) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return null;
        }
        return m17672bl.mo17416td(i);
    }

    /* renamed from: bl */
    public void m17671bl(int i, boolean z) {
        if (C12713kf.m16575ok()) {
            if (C12717ok.m16510ok(8388608)) {
                InterfaceC12522z m17583ok = C12542j.m17583ok(true);
                if (m17583ok != null) {
                    m17583ok.mo17435ok(i, z);
                }
                InterfaceC12522z m17583ok2 = C12542j.m17583ok(false);
                if (m17583ok2 != null) {
                    m17583ok2.mo17435ok(i, z);
                    return;
                }
                return;
            }
            InterfaceC12522z m17583ok3 = C12542j.m17583ok(false);
            if (m17583ok3 != null) {
                m17583ok3.mo17435ok(i, z);
            }
            InterfaceC12522z m17583ok4 = C12542j.m17583ok(true);
            if (m17583ok4 != null) {
                m17583ok4.mo17435ok(i, z);
                return;
            }
            return;
        }
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl != null) {
            m17672bl.mo17435ok(i, z);
        }
        C12542j.m17583ok(true).mo17445ok(2, i);
    }

    /* renamed from: kf */
    public boolean m17665kf() {
        InterfaceC12522z m17583ok = C12542j.m17583ok(false);
        if (m17583ok != null) {
            return m17583ok.mo17450n();
        }
        return false;
    }

    /* renamed from: n */
    public List<DownloadInfo> m17661n(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        InterfaceC12522z m17583ok = C12542j.m17583ok(false);
        List<DownloadInfo> mo17448n = m17583ok != null ? m17583ok.mo17448n(str) : null;
        InterfaceC12522z m17583ok2 = C12542j.m17583ok(true);
        return m17646ok(mo17448n, m17583ok2 != null ? m17583ok2.mo17448n(str) : null, sparseArray);
    }

    /* renamed from: s */
    public void m17639s(int i, boolean z) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return;
        }
        m17672bl.mo17468a(i, z);
    }

    /* renamed from: a */
    public void m17683a() {
        synchronized (this.f35178s) {
            for (InterfaceC12428er interfaceC12428er : this.f35178s) {
                if (interfaceC12428er != null) {
                    interfaceC12428er.m17882ok();
                }
            }
        }
    }

    /* renamed from: s */
    public boolean m17641s() {
        return C12490bl.m17750wv();
    }

    /* renamed from: ok */
    public void m17653ok(InterfaceC12428er interfaceC12428er) {
        if (interfaceC12428er == null) {
            return;
        }
        if (C12713kf.m16605bl()) {
            interfaceC12428er.m17882ok();
            return;
        }
        if (C12542j.m17583ok(true).mo17457h()) {
            interfaceC12428er.m17882ok();
        }
        synchronized (this.f35178s) {
            if (!this.f35178s.contains(interfaceC12428er)) {
                this.f35178s.add(interfaceC12428er);
            }
        }
    }

    /* renamed from: s */
    public List<DownloadInfo> m17638s(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        InterfaceC12522z m17583ok = C12542j.m17583ok(false);
        List<DownloadInfo> mo17418s = m17583ok != null ? m17583ok.mo17418s(str) : null;
        InterfaceC12522z m17583ok2 = C12542j.m17583ok(true);
        return m17646ok(mo17418s, m17583ok2 != null ? m17583ok2.mo17418s(str) : null, sparseArray);
    }

    /* renamed from: n */
    public List<DownloadInfo> m17663n() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        InterfaceC12522z m17583ok = C12542j.m17583ok(false);
        List<DownloadInfo> mo17420s = m17583ok != null ? m17583ok.mo17420s() : null;
        InterfaceC12522z m17583ok2 = C12542j.m17583ok(true);
        return m17646ok(mo17420s, m17583ok2 != null ? m17583ok2.mo17420s() : null, sparseArray);
    }

    /* renamed from: a */
    public synchronized void m17680a(int i, boolean z) {
        this.f35176a.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    /* renamed from: a */
    public synchronized int m17682a(int i) {
        if (this.f35176a.get(i) == null) {
            return -1;
        }
        return this.f35176a.get(i).booleanValue() ? 1 : 0;
    }

    /* renamed from: ok */
    public void m17654ok(int i, boolean z) {
        m17680a(i, z);
        if (C12490bl.m17764qx() && !C12713kf.m16605bl() && C12542j.m17583ok(true).mo17457h()) {
            C12542j.m17583ok(true).mo17460bl(i, z);
        }
        if (C12490bl.m17830bl() || C12713kf.m16605bl() || C12713kf.m16575ok()) {
            return;
        }
        try {
            Intent intent = new Intent(C12490bl.m17807l(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i);
            C12490bl.m17807l().startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: bl */
    public void m17673bl() {
        InterfaceC12522z m17583ok = C12542j.m17583ok(false);
        if (m17583ok != null) {
            m17583ok.mo17447ok();
        }
        InterfaceC12522z m17583ok2 = C12542j.m17583ok(true);
        if (m17583ok2 != null) {
            m17583ok2.mo17447ok();
        }
    }

    /* renamed from: a */
    private InterfaceC12522z m17677a(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<C12598a> mo17423q;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        downloadInfo.isNeedIndependentProcess();
        boolean z = (C12713kf.m16605bl() || !C12713kf.m16575ok()) ? true : true;
        int m17659ok = m17659ok(downloadInfo.getId());
        if (m17659ok >= 0 && m17659ok != z) {
            try {
                if (m17659ok == 1) {
                    if (C12713kf.m16575ok()) {
                        C12542j.m17583ok(true).mo17446ok(downloadInfo.getId());
                        DownloadInfo mo17424p = C12542j.m17583ok(true).mo17424p(downloadInfo.getId());
                        if (mo17424p != null) {
                            C12542j.m17583ok(false).mo17467a(mo17424p);
                        }
                        if (mo17424p.getChunkCount() > 1 && (mo17423q = C12542j.m17583ok(true).mo17423q(downloadInfo.getId())) != null) {
                            C12542j.m17583ok(false).mo17436ok(downloadInfo.getId(), C12713kf.m16539ok(mo17423q));
                        }
                    }
                } else if (C12713kf.m16575ok()) {
                    C12542j.m17583ok(false).mo17446ok(downloadInfo.getId());
                    List<C12598a> mo17423q2 = C12542j.m17583ok(false).mo17423q(downloadInfo.getId());
                    if (mo17423q2 != null) {
                        C12542j.m17583ok(true).mo17436ok(downloadInfo.getId(), C12713kf.m16539ok(mo17423q2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    C12542j.m17583ok(true).mo17445ok(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        m17654ok(downloadInfo.getId(), z);
        return C12542j.m17583ok(z);
    }

    /* renamed from: bl */
    public List<DownloadInfo> m17670bl(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        InterfaceC12522z m17583ok = C12542j.m17583ok(false);
        List<DownloadInfo> mo17458bl = m17583ok != null ? m17583ok.mo17458bl(str) : null;
        InterfaceC12522z m17583ok2 = C12542j.m17583ok(true);
        return m17646ok(mo17458bl, m17583ok2 != null ? m17583ok2.mo17458bl(str) : null, sparseArray);
    }

    /* renamed from: ok */
    public int m17659ok(int i) {
        if (C12490bl.m17764qx()) {
            if (!C12713kf.m16605bl() && C12542j.m17583ok(true).mo17457h()) {
                return C12542j.m17583ok(true).mo17414z(i);
            }
            return m17682a(i);
        }
        return -1;
    }

    /* renamed from: ok */
    public int m17648ok(String str, String str2) {
        return C12490bl.m17776ok(str, str2);
    }

    /* renamed from: ok */
    public List<DownloadInfo> m17649ok(String str) {
        List<DownloadInfo> mo17429ok = C12542j.m17583ok(false).mo17429ok(str);
        List<DownloadInfo> mo17429ok2 = C12542j.m17583ok(true).mo17429ok(str);
        if (mo17429ok == null && mo17429ok2 == null) {
            return null;
        }
        if (mo17429ok == null || mo17429ok2 == null) {
            return mo17429ok != null ? mo17429ok : mo17429ok2;
        }
        ArrayList arrayList = new ArrayList(mo17429ok);
        arrayList.addAll(mo17429ok2);
        return arrayList;
    }

    /* renamed from: ok */
    public void m17655ok(int i, InterfaceC12427ep interfaceC12427ep) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return;
        }
        m17672bl.mo17437ok(i, interfaceC12427ep);
    }

    /* renamed from: ok */
    private List<DownloadInfo> m17646ok(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public DownloadInfo m17675a(String str, String str2) {
        int m17648ok = m17648ok(str, str2);
        InterfaceC12522z m17672bl = m17672bl(m17648ok);
        if (m17672bl == null) {
            return null;
        }
        return m17672bl.mo17424p(m17648ok);
    }

    /* renamed from: a */
    public List<DownloadInfo> m17676a(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        InterfaceC12522z m17583ok = C12542j.m17583ok(false);
        List<DownloadInfo> mo17465a = m17583ok != null ? m17583ok.mo17465a(str) : null;
        InterfaceC12522z m17583ok2 = C12542j.m17583ok(true);
        return m17646ok(mo17465a, m17583ok2 != null ? m17583ok2.mo17465a(str) : null, sparseArray);
    }

    /* renamed from: ok */
    public void m17647ok(List<String> list) {
        InterfaceC12522z m17583ok = C12542j.m17583ok(false);
        if (m17583ok != null) {
            m17583ok.mo17427ok(list);
        }
        InterfaceC12522z m17583ok2 = C12542j.m17583ok(true);
        if (m17583ok2 != null) {
            m17583ok2.mo17427ok(list);
        }
    }

    /* renamed from: a */
    public void m17674a(List<String> list) {
        InterfaceC12522z m17583ok = C12542j.m17583ok(false);
        if (m17583ok != null) {
            m17583ok.mo17463a(list);
        }
        InterfaceC12522z m17583ok2 = C12542j.m17583ok(true);
        if (m17583ok2 != null) {
            m17583ok2.mo17463a(list);
        }
    }

    /* renamed from: ok */
    public void m17657ok(int i, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return;
        }
        m17672bl.mo17470a(i, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, enumC12414kf, z);
    }

    /* renamed from: a */
    public void m17681a(int i, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return;
        }
        m17672bl.mo17441ok(i, iDownloadListener.hashCode(), iDownloadListener, enumC12414kf, z);
    }

    /* renamed from: ok */
    public void m17656ok(int i, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z, boolean z2) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return;
        }
        m17672bl.mo17440ok(i, iDownloadListener.hashCode(), iDownloadListener, enumC12414kf, z, z2);
    }

    /* renamed from: a */
    public void m17678a(InterfaceC12468r interfaceC12468r) {
        C12490bl.m17839a(interfaceC12468r);
    }

    /* renamed from: ok */
    public boolean m17651ok(DownloadInfo downloadInfo) {
        InterfaceC12522z m17672bl;
        if (downloadInfo == null || (m17672bl = m17672bl(downloadInfo.getId())) == null) {
            return false;
        }
        return m17672bl.mo17432ok(downloadInfo);
    }

    /* renamed from: ok */
    public void m17650ok(final DownloadTask downloadTask) {
        final InterfaceC12522z m17677a = m17677a(downloadTask);
        if (m17677a == null) {
            if (downloadTask != null) {
                C12723ok.m16492ok(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.f35177bl.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.s.1
                @Override // java.lang.Runnable
                public void run() {
                    m17677a.mo17431ok(downloadTask);
                }
            }, 500L);
        } else {
            m17677a.mo17431ok(downloadTask);
        }
    }

    /* renamed from: ok */
    public void m17652ok(InterfaceC12468r interfaceC12468r) {
        C12490bl.m17797ok(interfaceC12468r);
    }

    /* renamed from: ok */
    public void m17658ok(int i, long j) {
        InterfaceC12522z m17672bl = m17672bl(i);
        if (m17672bl == null) {
            return;
        }
        m17672bl.mo17439ok(i, j);
    }
}
