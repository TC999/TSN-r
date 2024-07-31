package com.p521ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.impls.C12542j;
import com.p521ss.android.socialbase.downloader.impls.C12556r;
import com.p521ss.android.socialbase.downloader.impls.C12558s;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.C12603n;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;
import com.p521ss.android.socialbase.downloader.p548a.BinderC12395n;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p552n.C12609bl;
import com.p521ss.android.socialbase.downloader.p552n.C12610ok;
import com.p521ss.android.socialbase.downloader.p552n.InterfaceC12608a;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;
import com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* renamed from: com.ss.android.socialbase.downloader.downloader.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12505n {

    /* renamed from: a */
    private static String f35131a = "ResponseHandler";

    /* renamed from: bl */
    private final DownloadInfo f35132bl;

    /* renamed from: ep */
    private boolean f35133ep;

    /* renamed from: er */
    private long f35134er;

    /* renamed from: fb */
    private long f35135fb;

    /* renamed from: h */
    private InterfaceC12501k f35137h;

    /* renamed from: i */
    private long f35138i;

    /* renamed from: io */
    private final C12646ok f35139io;

    /* renamed from: j */
    private volatile boolean f35140j;

    /* renamed from: k */
    private C12603n f35141k;

    /* renamed from: kf */
    private final InterfaceC12635q f35142kf;

    /* renamed from: kz */
    private long f35143kz;

    /* renamed from: m */
    private final boolean f35144m;

    /* renamed from: n */
    private final C12598a f35145n;

    /* renamed from: o */
    private final long f35146o;

    /* renamed from: p */
    private C12556r f35148p;

    /* renamed from: q */
    private InterfaceC12519u f35149q;

    /* renamed from: r */
    private BaseException f35150r;

    /* renamed from: rh */
    private final InterfaceC12658kf f35151rh;

    /* renamed from: s */
    private final String f35152s;

    /* renamed from: t */
    private long f35153t;

    /* renamed from: td */
    private volatile long f35154td;

    /* renamed from: u */
    private final C12534ok f35155u;

    /* renamed from: ul */
    private final boolean f35156ul;

    /* renamed from: vz */
    private long f35158vz;

    /* renamed from: x */
    private volatile long f35159x;

    /* renamed from: y */
    private final long f35160y;

    /* renamed from: z */
    private volatile boolean f35161z;

    /* renamed from: zz */
    private final boolean f35162zz;

    /* renamed from: ok */
    boolean f35147ok = false;

    /* renamed from: g */
    private volatile long f35136g = 0;

    /* renamed from: v */
    private volatile long f35157v = 0;

    public C12505n(DownloadInfo downloadInfo, String str, InterfaceC12635q interfaceC12635q, C12598a c12598a, InterfaceC12658kf interfaceC12658kf) {
        this.f35132bl = downloadInfo;
        this.f35152s = str;
        InterfaceC12501k m17806m = C12490bl.m17806m();
        this.f35137h = m17806m;
        if (m17806m instanceof C12558s) {
            C12558s c12558s = (C12558s) m17806m;
            this.f35148p = c12558s.m17499ok();
            this.f35149q = c12558s.m17503kf();
        }
        this.f35142kf = interfaceC12635q;
        this.f35145n = c12598a;
        this.f35151rh = interfaceC12658kf;
        long m17025rh = c12598a.m17025rh();
        this.f35153t = m17025rh;
        this.f35138i = m17025rh;
        if (c12598a.m17024s()) {
            this.f35154td = c12598a.m17021x();
        } else {
            this.f35154td = c12598a.m17044bl(false);
        }
        this.f35159x = c12598a.m17042i();
        this.f35139io = C12646ok.m16846ok();
        C12534ok m17599ok = C12534ok.m17599ok(downloadInfo.getId());
        this.f35155u = m17599ok;
        boolean z = m17599ok.m17593ok("sync_strategy", 0) == 1;
        this.f35156ul = z;
        if (z) {
            this.f35146o = Math.max(m17599ok.m17593ok("sync_interval_ms_fg", 5000), 500L);
            this.f35160y = Math.max(m17599ok.m17593ok("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.f35146o = 0L;
            this.f35160y = 0L;
        }
        this.f35144m = m17599ok.m17607a("monitor_rw") == 1;
        this.f35162zz = C12717ok.m16510ok(65536);
    }

    /* renamed from: a */
    private boolean m17702a(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    /* renamed from: h */
    private void m17700h() {
        ExecutorService m17812j;
        if (this.f35142kf == null || (m17812j = C12490bl.m17812j()) == null) {
            return;
        }
        m17812j.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.n.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C12505n.this.f35142kf.mo16908s();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* renamed from: kf */
    private boolean m17699kf() {
        return this.f35140j || this.f35161z;
    }

    /* renamed from: p */
    private void m17690p() {
        boolean z;
        long nanoTime = this.f35144m ? System.nanoTime() : 0L;
        try {
            this.f35141k.m16993ok();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.f35132bl.updateRealDownloadTime(true);
            boolean z2 = this.f35132bl.getChunkCount() > 1;
            InterfaceC12522z m17583ok = C12542j.m17583ok(C12713kf.m16623a());
            if (z2) {
                m17694ok(this.f35149q);
                if (m17583ok != null) {
                    m17583ok.mo17459bl(this.f35132bl);
                } else {
                    this.f35149q.mo17494ok(this.f35132bl.getId(), this.f35132bl.getCurBytes());
                }
            } else if (m17583ok != null) {
                m17583ok.mo17459bl(this.f35132bl);
            } else {
                this.f35149q.mo17494ok(this.f35145n.m17026r(), this.f35153t);
            }
            this.f35136g = this.f35153t;
        }
        if (this.f35144m) {
            this.f35134er += System.nanoTime() - nanoTime;
        }
    }

    /* renamed from: a */
    public void m17703a() {
        if (this.f35140j) {
            return;
        }
        this.f35140j = true;
        m17700h();
    }

    /* renamed from: bl */
    public void m17701bl() {
        if (this.f35161z) {
            return;
        }
        synchronized (this.f35151rh) {
            this.f35161z = true;
        }
        m17700h();
    }

    /* renamed from: n */
    public long m17698n() {
        return this.f35136g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02e1 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0361 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x047f A[Catch: all -> 0x04db, TRY_LEAVE, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04d5 A[Catch: all -> 0x04db, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m17689s() throws com.p521ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.downloader.C12505n.m17689s():void");
    }

    /* renamed from: ok */
    public long m17697ok() {
        return this.f35153t;
    }

    /* renamed from: ok */
    public void m17695ok(long j, long j2, long j3) {
        this.f35153t = j;
        this.f35138i = j;
        this.f35159x = j2;
        this.f35154td = j3;
    }

    /* renamed from: ok */
    public void m17696ok(long j, long j2) {
        this.f35159x = j;
        this.f35154td = j2;
    }

    /* renamed from: ok */
    private InterfaceC12608a m17692ok(InputStream inputStream) {
        int m17819fd = C12490bl.m17819fd();
        if (this.f35155u.m17593ok("rw_concurrent", 0) == 1 && this.f35132bl.getChunkCount() == 1 && this.f35132bl.getTotalBytes() > 20971520) {
            try {
                C12610ok c12610ok = new C12610ok(inputStream, m17819fd, this.f35155u.m17593ok("rw_concurrent_max_buffer_count", 4));
                this.f35133ep = true;
                return c12610ok;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        C12609bl c12609bl = new C12609bl(inputStream, m17819fd);
        this.f35133ep = false;
        return c12609bl;
    }

    /* renamed from: ok */
    private void m17691ok(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.f35157v;
        if (this.f35156ul) {
            if (j > (this.f35139io.m16854a() ? this.f35146o : this.f35160y)) {
                m17690p();
                this.f35157v = uptimeMillis;
                return;
            }
            return;
        }
        long j2 = this.f35153t - this.f35136g;
        if (z || m17702a(j2, j)) {
            m17690p();
            this.f35157v = uptimeMillis;
        }
    }

    /* renamed from: ok */
    private void m17694ok(InterfaceC12501k interfaceC12501k) {
        C12598a c12598a;
        C12598a c12598a2;
        if (interfaceC12501k == null) {
            return;
        }
        InterfaceC12522z interfaceC12522z = null;
        boolean z = interfaceC12501k instanceof BinderC12395n;
        if (z && (interfaceC12522z = C12542j.m17583ok(C12713kf.m16623a())) == null) {
            return;
        }
        InterfaceC12522z interfaceC12522z2 = interfaceC12522z;
        if (this.f35145n.m17024s()) {
            c12598a = this.f35145n.m17038n();
        } else {
            c12598a = this.f35145n;
        }
        C12598a c12598a3 = c12598a;
        if (c12598a3 != null) {
            c12598a3.m17048a(this.f35153t);
            if (z && interfaceC12522z2 != null) {
                interfaceC12522z2.mo17443ok(c12598a3.m17026r(), c12598a3.m17019zz(), c12598a3.m17050a(), this.f35153t);
                c12598a2 = c12598a3;
            } else {
                c12598a2 = c12598a3;
                interfaceC12501k.mo17496ok(c12598a3.m17026r(), c12598a3.m17019zz(), c12598a3.m17050a(), this.f35153t);
            }
            if (c12598a2.m17028p()) {
                boolean z2 = false;
                if (c12598a2.m17027q()) {
                    long m17040k = c12598a2.m17040k();
                    if (m17040k > this.f35153t) {
                        if (z && interfaceC12522z2 != null) {
                            interfaceC12522z2.mo17442ok(c12598a2.m17026r(), c12598a2.m17050a(), m17040k);
                        } else {
                            interfaceC12501k.mo17495ok(c12598a2.m17026r(), c12598a2.m17050a(), m17040k);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (z && interfaceC12522z2 != null) {
                    interfaceC12522z2.mo17442ok(c12598a2.m17026r(), c12598a2.m17050a(), this.f35153t);
                } else {
                    interfaceC12501k.mo17495ok(c12598a2.m17026r(), c12598a2.m17050a(), this.f35153t);
                }
            }
        } else if (this.f35145n.m17024s()) {
            if (z && interfaceC12522z2 != null) {
                interfaceC12522z2.mo17442ok(this.f35145n.m17026r(), this.f35145n.m17019zz(), this.f35153t);
            } else {
                interfaceC12501k.mo17495ok(this.f35145n.m17026r(), this.f35145n.m17019zz(), this.f35153t);
            }
        }
    }
}
