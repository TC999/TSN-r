package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class r implements com.ss.android.socialbase.downloader.downloader.k {
    private final SparseArray<DownloadInfo> ok = new SparseArray<>();

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<List<com.ss.android.socialbase.downloader.model.a>> f49776a = new SparseArray<>();
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.kf.q>> bl = new SparseArray<>();

    /* renamed from: com.ss.android.socialbase.downloader.impls.r$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    class AnonymousClass1 extends com.ss.android.socialbase.downloader.network.ux {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InputStream f49777c;
        final /* synthetic */ ResponseBody sr;

        /* renamed from: w  reason: collision with root package name */
        final /* synthetic */ Response f49778w;
        final /* synthetic */ Call xv;

        AnonymousClass1(InputStream inputStream, Response response, Call call, ResponseBody responseBody) {
            this.f49777c = inputStream;
            this.f49778w = response;
            this.xv = call;
            this.sr = responseBody;
        }

        @Override // com.ss.android.socialbase.downloader.network.gd
        public InputStream c() throws IOException {
            return this.f49777c;
        }

        @Override // com.ss.android.socialbase.downloader.network.gd
        public void sr() {
            try {
                ResponseBody responseBody = this.sr;
                if (responseBody != null) {
                    responseBody.close();
                }
                Call call = this.xv;
                if (call == null || call.isCanceled()) {
                    return;
                }
                this.xv.cancel();
            } catch (Throwable unused) {
            }
        }

        @Override // com.ss.android.socialbase.downloader.network.c
        public String ux() {
            return "";
        }

        public int w() throws IOException {
            return this.f49778w.code();
        }

        public void xv() {
            Call call = this.xv;
            if (call == null || call.isCanceled()) {
                return;
            }
            this.xv.cancel();
        }

        public String c(String str) {
            return this.f49778w.header(str);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.impls.r$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    class AnonymousClass2 implements Dns {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f49779c;

        /* renamed from: w  reason: collision with root package name */
        final /* synthetic */ String f49780w;

        AnonymousClass2(String str, String str2) {
            this.f49779c = str;
            this.f49780w = str2;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized DownloadInfo a(int i4) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.ok.get(i4);
        } catch (Exception e4) {
            e4.printStackTrace();
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.model.a aVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<DownloadInfo> bl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.ok.size(); i4++) {
            DownloadInfo downloadInfo = this.ok.get(this.ok.keyAt(i4));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo h(int i4) {
        DownloadInfo a4 = a(i4);
        if (a4 != null) {
            a4.setStatus(2);
        }
        return a4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized Map<Long, com.ss.android.socialbase.downloader.kf.q> j(int i4) {
        return this.bl.get(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo k(int i4) {
        DownloadInfo a4 = a(i4);
        if (a4 != null) {
            a4.setStatus(-7);
        }
        return a4;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.a>> kf() {
        return this.f49776a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean n() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized boolean n(int i4) {
        this.ok.remove(i4);
        return true;
    }

    public SparseArray<DownloadInfo> ok() {
        return this.ok;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i4, int i5, int i6, int i7) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo p(int i4) {
        DownloadInfo a4 = a(i4);
        if (a4 != null) {
            a4.setStatus(5);
            a4.setFirstDownload(false);
        }
        return a4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo q(int i4) {
        DownloadInfo a4 = a(i4);
        if (a4 != null) {
            a4.setStatus(1);
        }
        return a4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<com.ss.android.socialbase.downloader.kf.q> rh(int i4) {
        Map<Long, com.ss.android.socialbase.downloader.kf.q> map = this.bl.get(i4);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<DownloadInfo> s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.ok.size(); i4++) {
            DownloadInfo downloadInfo = this.ok.get(this.ok.keyAt(i4));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean s() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized void z(int i4) {
        this.bl.remove(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean kf(int i4) {
        n(i4);
        s(i4);
        z(i4);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<DownloadInfo> ok(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.ok.size();
            for (int i4 = 0; i4 < size; i4++) {
                DownloadInfo valueAt = this.ok.valueAt(i4);
                if (str != null && str.equals(valueAt.getUrl())) {
                    arrayList.add(valueAt);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<DownloadInfo> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.ok.size(); i4++) {
            DownloadInfo downloadInfo = this.ok.get(this.ok.keyAt(i4));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) {
        int r3 = aVar.r();
        List<com.ss.android.socialbase.downloader.model.a> list = this.f49776a.get(r3);
        if (list == null) {
            list = new ArrayList<>();
            this.f49776a.put(r3, list);
        }
        list.add(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<com.ss.android.socialbase.downloader.model.a> bl(int i4) {
        return this.f49776a.get(i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        r0.a(r5);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void ok(int r3, int r4, long r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.bl(r3)     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L26
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L24
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L26
            com.ss.android.socialbase.downloader.model.a r0 = (com.ss.android.socialbase.downloader.model.a) r0     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto Ld
            int r1 = r0.zz()     // Catch: java.lang.Throwable -> L26
            if (r1 != r4) goto Ld
            r0.a(r5)     // Catch: java.lang.Throwable -> L26
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.r.ok(int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized void s(int i4) {
        this.f49776a.remove(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized void bl() {
        this.ok.clear();
        this.f49776a.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo s(int i4, long j4) {
        DownloadInfo a4 = a(i4);
        if (a4 != null) {
            a4.setCurBytes(j4, false);
            a4.setStatus(-2);
        }
        return a4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized List<DownloadInfo> a() {
        if (this.ok.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.ok.size());
        for (int i4 = 0; i4 < this.ok.size(); i4++) {
            DownloadInfo valueAt = this.ok.valueAt(i4);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo bl(int i4, long j4) {
        DownloadInfo a4 = a(i4);
        if (a4 != null) {
            a4.setCurBytes(j4, false);
            a4.setStatus(-3);
            a4.setFirstDownload(false);
            a4.setFirstSuccess(false);
        }
        return a4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        if (r0.h() != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        r3 = r0.h().iterator();
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
        if (r5.zz() != r4) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        r5.a(r6);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void ok(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.bl(r3)     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4f
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L4d
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.a r0 = (com.ss.android.socialbase.downloader.model.a) r0     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto Ld
            int r1 = r0.zz()     // Catch: java.lang.Throwable -> L4f
            if (r1 != r5) goto Ld
            boolean r1 = r0.kf()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.h()     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L2e
            goto L4d
        L2e:
            java.util.List r3 = r0.h()     // Catch: java.lang.Throwable -> L4f
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4f
        L36:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.a r5 = (com.ss.android.socialbase.downloader.model.a) r5     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L36
            int r0 = r5.zz()     // Catch: java.lang.Throwable -> L4f
            if (r0 != r4) goto L36
            r5.a(r6)     // Catch: java.lang.Throwable -> L4f
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.r.ok(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo a(int i4, long j4) {
        DownloadInfo a4 = a(i4);
        if (a4 != null) {
            a4.setCurBytes(j4, false);
            a4.setStatus(-1);
            a4.setFirstDownload(false);
        }
        return a4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(DownloadInfo downloadInfo) {
        ok(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized DownloadInfo ok(int i4, int i5) {
        DownloadInfo a4;
        a4 = a(i4);
        if (a4 != null) {
            a4.setChunkCount(i5);
        }
        return a4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized boolean ok(DownloadInfo downloadInfo) {
        boolean z3 = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.ok.get(downloadInfo.getId()) == null) {
            z3 = false;
        }
        this.ok.put(downloadInfo.getId(), downloadInfo);
        return z3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i4, long j4, String str, String str2) {
        DownloadInfo a4 = a(i4);
        if (a4 != null) {
            a4.setTotalBytes(j4);
            a4.seteTag(str);
            if (TextUtils.isEmpty(a4.getName()) && !TextUtils.isEmpty(str2)) {
                a4.setName(str2);
            }
            a4.setStatus(3);
        }
        return a4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i4, long j4) {
        DownloadInfo a4 = a(i4);
        if (a4 != null) {
            a4.setCurBytes(j4, false);
            if (a4.getStatus() != -3 && a4.getStatus() != -2 && !DownloadStatus.isFailedStatus(a4.getStatus()) && a4.getStatus() != -4) {
                a4.setStatus(4);
            }
        }
        return a4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
        if (list == null) {
            return;
        }
        s(i4);
        for (com.ss.android.socialbase.downloader.model.a aVar : list) {
            if (aVar != null) {
                ok(aVar);
                if (aVar.kf()) {
                    for (com.ss.android.socialbase.downloader.model.a aVar2 : aVar.h()) {
                        ok(aVar2);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public synchronized boolean ok(int i4, Map<Long, com.ss.android.socialbase.downloader.kf.q> map) {
        this.bl.put(i4, map);
        return false;
    }
}
