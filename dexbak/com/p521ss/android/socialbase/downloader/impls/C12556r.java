package com.p521ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.constants.DownloadStatus;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p551kf.C12584q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.impls.r */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12556r implements InterfaceC12501k {

    /* renamed from: ok */
    private final SparseArray<DownloadInfo> f35254ok = new SparseArray<>();

    /* renamed from: a */
    private final SparseArray<List<C12598a>> f35252a = new SparseArray<>();

    /* renamed from: bl */
    private final SparseArray<Map<Long, C12584q>> f35253bl = new SparseArray<>();

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public synchronized DownloadInfo mo17520a(int i) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.f35254ok.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public void mo17518a(int i, List<C12598a> list) {
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public void mo17515a(C12598a c12598a) {
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public synchronized List<DownloadInfo> mo17509bl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f35254ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f35254ok.size(); i++) {
            DownloadInfo downloadInfo = this.f35254ok.get(this.f35254ok.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: h */
    public DownloadInfo mo17507h(int i) {
        DownloadInfo mo17520a = mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setStatus(2);
        }
        return mo17520a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: j */
    public synchronized Map<Long, C12584q> mo17506j(int i) {
        return this.f35253bl.get(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: k */
    public DownloadInfo mo17504k(int i) {
        DownloadInfo mo17520a = mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setStatus(-7);
        }
        return mo17520a;
    }

    /* renamed from: kf */
    public SparseArray<List<C12598a>> m17529kf() {
        return this.f35252a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: n */
    public boolean mo17501n() {
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: n */
    public synchronized boolean mo17500n(int i) {
        this.f35254ok.remove(i);
        return true;
    }

    /* renamed from: ok */
    public SparseArray<DownloadInfo> m17528ok() {
        return this.f35254ok;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17497ok(int i, int i2, int i3, int i4) {
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: p */
    public DownloadInfo mo17483p(int i) {
        DownloadInfo mo17520a = mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setStatus(5);
            mo17520a.setFirstDownload(false);
        }
        return mo17520a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: q */
    public DownloadInfo mo17481q(int i) {
        DownloadInfo mo17520a = mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setStatus(1);
        }
        return mo17520a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: rh */
    public synchronized List<C12584q> mo17480rh(int i) {
        Map<Long, C12584q> map = this.f35253bl.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public synchronized List<DownloadInfo> mo17476s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f35254ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f35254ok.size(); i++) {
            DownloadInfo downloadInfo = this.f35254ok.get(this.f35254ok.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public boolean mo17479s() {
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: z */
    public synchronized void mo17475z(int i) {
        this.f35253bl.remove(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: kf */
    public boolean mo17502kf(int i) {
        mo17500n(i);
        mo17478s(i);
        mo17475z(i);
        return true;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public synchronized List<DownloadInfo> mo17485ok(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.f35254ok.size();
            for (int i = 0; i < size; i++) {
                DownloadInfo valueAt = this.f35254ok.valueAt(i);
                if (str != null && str.equals(valueAt.getUrl())) {
                    arrayList.add(valueAt);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public synchronized List<DownloadInfo> mo17514a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f35254ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f35254ok.size(); i++) {
            DownloadInfo downloadInfo = this.f35254ok.get(this.f35254ok.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17486ok(C12598a c12598a) {
        int m17026r = c12598a.m17026r();
        List<C12598a> list = this.f35252a.get(m17026r);
        if (list == null) {
            list = new ArrayList<>();
            this.f35252a.put(m17026r, list);
        }
        list.add(c12598a);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public synchronized List<C12598a> mo17512bl(int i) {
        return this.f35252a.get(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        r0.m17048a(r5);
     */
    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void mo17495ok(int r3, int r4, long r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.mo17512bl(r3)     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L26
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L24
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L26
            com.ss.android.socialbase.downloader.model.a r0 = (com.p521ss.android.socialbase.downloader.model.C12598a) r0     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto Ld
            int r1 = r0.m17019zz()     // Catch: java.lang.Throwable -> L26
            if (r1 != r4) goto Ld
            r0.m17048a(r5)     // Catch: java.lang.Throwable -> L26
        L24:
            monitor-exit(r2)
            return
        L26:
            r3 = move-exception
            monitor-exit(r2)
            goto L2a
        L29:
            throw r3
        L2a:
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.impls.C12556r.mo17495ok(int, int, long):void");
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public synchronized void mo17478s(int i) {
        this.f35252a.remove(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public synchronized void mo17513bl() {
        this.f35254ok.clear();
        this.f35252a.clear();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public DownloadInfo mo17477s(int i, long j) {
        DownloadInfo mo17520a = mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setCurBytes(j, false);
            mo17520a.setStatus(-2);
        }
        return mo17520a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public synchronized List<DownloadInfo> mo17521a() {
        if (this.f35254ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f35254ok.size());
        for (int i = 0; i < this.f35254ok.size(); i++) {
            DownloadInfo valueAt = this.f35254ok.valueAt(i);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public DownloadInfo mo17511bl(int i, long j) {
        DownloadInfo mo17520a = mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setCurBytes(j, false);
            mo17520a.setStatus(-3);
            mo17520a.setFirstDownload(false);
            mo17520a.setFirstSuccess(false);
        }
        return mo17520a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        if (r0.m17043h() != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        r3 = r0.m17043h().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r3.hasNext() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
        if (r5 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r5.m17019zz() != r4) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        r5.m17048a(r6);
     */
    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void mo17496ok(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.mo17512bl(r3)     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4f
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L4d
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.a r0 = (com.p521ss.android.socialbase.downloader.model.C12598a) r0     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto Ld
            int r1 = r0.m17019zz()     // Catch: java.lang.Throwable -> L4f
            if (r1 != r5) goto Ld
            boolean r1 = r0.m17039kf()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.m17043h()     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L2e
            goto L4d
        L2e:
            java.util.List r3 = r0.m17043h()     // Catch: java.lang.Throwable -> L4f
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4f
        L36:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.a r5 = (com.p521ss.android.socialbase.downloader.model.C12598a) r5     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L36
            int r0 = r5.m17019zz()     // Catch: java.lang.Throwable -> L4f
            if (r0 != r4) goto L36
            r5.m17048a(r6)     // Catch: java.lang.Throwable -> L4f
        L4d:
            monitor-exit(r2)
            return
        L4f:
            r3 = move-exception
            monitor-exit(r2)
            goto L53
        L52:
            throw r3
        L53:
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.impls.C12556r.mo17496ok(int, int, int, long):void");
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public DownloadInfo mo17519a(int i, long j) {
        DownloadInfo mo17520a = mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setCurBytes(j, false);
            mo17520a.setStatus(-1);
            mo17520a.setFirstDownload(false);
        }
        return mo17520a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public void mo17516a(DownloadInfo downloadInfo) {
        mo17488ok(downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public synchronized DownloadInfo mo17498ok(int i, int i2) {
        DownloadInfo mo17520a;
        mo17520a = mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setChunkCount(i2);
        }
        return mo17520a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public synchronized boolean mo17488ok(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.f35254ok.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.f35254ok.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public DownloadInfo mo17493ok(int i, long j, String str, String str2) {
        DownloadInfo mo17520a = mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setTotalBytes(j);
            mo17520a.seteTag(str);
            if (TextUtils.isEmpty(mo17520a.getName()) && !TextUtils.isEmpty(str2)) {
                mo17520a.setName(str2);
            }
            mo17520a.setStatus(3);
        }
        return mo17520a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public DownloadInfo mo17494ok(int i, long j) {
        DownloadInfo mo17520a = mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setCurBytes(j, false);
            if (mo17520a.getStatus() != -3 && mo17520a.getStatus() != -2 && !DownloadStatus.isFailedStatus(mo17520a.getStatus()) && mo17520a.getStatus() != -4) {
                mo17520a.setStatus(4);
            }
        }
        return mo17520a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public synchronized void mo17492ok(int i, List<C12598a> list) {
        if (list == null) {
            return;
        }
        mo17478s(i);
        for (C12598a c12598a : list) {
            if (c12598a != null) {
                mo17486ok(c12598a);
                if (c12598a.m17039kf()) {
                    for (C12598a c12598a2 : c12598a.m17043h()) {
                        mo17486ok(c12598a2);
                    }
                }
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public synchronized boolean mo17491ok(int i, Map<Long, C12584q> map) {
        this.f35253bl.put(i, map);
        return false;
    }
}
