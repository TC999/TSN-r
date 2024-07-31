package com.p521ss.android.socialbase.downloader.p555p;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.kuaishou.weapon.p205p0.C7282g;
import com.p521ss.android.socialbase.downloader.constants.EnumC12411a;
import com.p521ss.android.socialbase.downloader.constants.EnumC12417p;
import com.p521ss.android.socialbase.downloader.depend.AbstractC12419a;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12460o;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12475td;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12482x;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12483y;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12502kf;
import com.p521ss.android.socialbase.downloader.downloader.C12505n;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12496h;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12509p;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12523zz;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.exception.C12526bl;
import com.p521ss.android.socialbase.downloader.exception.C12528kf;
import com.p521ss.android.socialbase.downloader.exception.C12529n;
import com.p521ss.android.socialbase.downloader.exception.C12530ok;
import com.p521ss.android.socialbase.downloader.exception.C12532q;
import com.p521ss.android.socialbase.downloader.exception.C12533s;
import com.p521ss.android.socialbase.downloader.exception.EnumC12531p;
import com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok;
import com.p521ss.android.socialbase.downloader.impls.C12546n;
import com.p521ss.android.socialbase.downloader.impls.C12565td;
import com.p521ss.android.socialbase.downloader.impls.C12572x;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.model.C12603n;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.network.AbstractC12625ok;
import com.p521ss.android.socialbase.downloader.network.C12612a;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12620h;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;
import com.p521ss.android.socialbase.downloader.network.p553ok.C12629bl;
import com.p521ss.android.socialbase.downloader.network.p553ok.C12630ok;
import com.p521ss.android.socialbase.downloader.network.p553ok.C12633s;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p551kf.C12584q;
import com.p521ss.android.socialbase.downloader.p551kf.C12586r;
import com.p521ss.android.socialbase.downloader.p551kf.C12589rh;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import com.p521ss.android.socialbase.downloader.p556q.C12720s;
import com.p521ss.android.socialbase.downloader.p557s.C12723ok;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.p.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RunnableC12652bl implements InterfaceC12658kf, Runnable {

    /* renamed from: ok */
    private static final String f35675ok = RunnableC12652bl.class.getSimpleName();

    /* renamed from: a */
    private Future f35676a;

    /* renamed from: bl */
    private final DownloadTask f35677bl;

    /* renamed from: e */
    private long f35678e;

    /* renamed from: ep */
    private InterfaceC12460o f35680ep;

    /* renamed from: fd */
    private final C12534ok f35683fd;

    /* renamed from: fl */
    private long f35684fl;

    /* renamed from: g */
    private String f35685g;

    /* renamed from: h */
    private volatile C12505n f35686h;

    /* renamed from: i */
    private DownloadInfo f35687i;

    /* renamed from: io */
    private InterfaceC12523zz f35688io;

    /* renamed from: j */
    private boolean f35689j;

    /* renamed from: k */
    private boolean f35690k;

    /* renamed from: m */
    private InterfaceC12620h f35693m;

    /* renamed from: n */
    private AtomicInteger f35694n;

    /* renamed from: o */
    private volatile BaseException f35695o;

    /* renamed from: p */
    private boolean f35696p;

    /* renamed from: q */
    private boolean f35697q;

    /* renamed from: r */
    private boolean f35698r;

    /* renamed from: t */
    private final InterfaceC12501k f35702t;

    /* renamed from: td */
    private final InterfaceC12509p f35703td;

    /* renamed from: u */
    private final InterfaceC12496h f35704u;

    /* renamed from: ul */
    private final C12502kf f35705ul;

    /* renamed from: vz */
    private InterfaceC12475td f35707vz;

    /* renamed from: x */
    private InterfaceC12509p f35708x;

    /* renamed from: y */
    private InterfaceC12635q f35709y;

    /* renamed from: z */
    private final AtomicBoolean f35710z;

    /* renamed from: zz */
    private InterfaceC12496h f35711zz;

    /* renamed from: s */
    private volatile boolean f35700s = false;

    /* renamed from: kf */
    private final ArrayList<RunnableC12651a> f35691kf = new ArrayList<>();

    /* renamed from: rh */
    private volatile EnumC12417p f35699rh = EnumC12417p.RUN_STATUS_NONE;

    /* renamed from: kz */
    private volatile int f35692kz = 5;

    /* renamed from: er */
    private boolean f35681er = false;

    /* renamed from: fb */
    private boolean f35682fb = false;

    /* renamed from: v */
    private boolean f35706v = false;

    /* renamed from: em */
    private int f35679em = 0;

    /* renamed from: sg */
    private volatile C12586r f35701sg = null;

    public RunnableC12652bl(DownloadTask downloadTask, Handler handler) {
        this.f35677bl = downloadTask;
        if (downloadTask != null) {
            this.f35687i = downloadTask.getDownloadInfo();
            this.f35708x = downloadTask.getChunkStrategy();
            this.f35711zz = downloadTask.getChunkAdjustCalculator();
            this.f35680ep = downloadTask.getForbiddenHandler();
            this.f35707vz = downloadTask.getDiskSpaceHandler();
            this.f35688io = m16798ok(downloadTask);
            this.f35683fd = C12534ok.m17599ok(this.f35687i.getId());
        } else {
            this.f35683fd = C12534ok.m17605bl();
        }
        m16786p();
        this.f35702t = C12490bl.m17806m();
        this.f35703td = C12490bl.m17823em();
        this.f35704u = C12490bl.m17765qu();
        this.f35705ul = new C12502kf(downloadTask, handler);
        this.f35710z = new AtomicBoolean(true);
    }

    /* renamed from: e */
    private void m16822e() {
        String str = f35675ok;
        C12409ok.m17894s(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.f35702t.mo17478s(this.f35687i.getId());
            this.f35702t.mo17475z(this.f35687i.getId());
            C12713kf.m16563ok(this.f35687i);
            this.f35697q = false;
            this.f35687i.resetDataForEtagEndure("");
            this.f35702t.mo17488ok(this.f35687i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: em */
    public void m16821em() {
        AbstractC12547ok m17820fb;
        if (m16776ul() || (m17820fb = C12490bl.m17820fb()) == null) {
            return;
        }
        m17820fb.m17564j(this.f35687i.getId());
    }

    /* renamed from: ep */
    private void m16820ep() {
        this.f35699rh = EnumC12417p.RUN_STATUS_NONE;
    }

    /* renamed from: er */
    private boolean m16819er() {
        DownloadInfo downloadInfo = this.f35687i;
        if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
            return false;
        }
        return (!this.f35697q || this.f35687i.getChunkCount() > 1) && !this.f35687i.isChunkDowngradeRetryUsed() && this.f35690k && !this.f35689j;
    }

    /* renamed from: fb */
    private void m16818fb() throws BaseException {
        long j;
        int m17593ok;
        try {
            j = C12713kf.m16518s(this.f35687i.getTempPath());
        } catch (BaseException unused) {
            j = 0;
        }
        String str = f35675ok;
        C12409ok.m17901bl(str, "checkSpaceOverflowInProgress: available = " + C12713kf.m16570ok(j) + "MB");
        if (j > 0) {
            long totalBytes = this.f35687i.getTotalBytes() - this.f35687i.getCurBytes();
            if (j < totalBytes && (m17593ok = C12534ok.m17599ok(this.f35687i.getId()).m17593ok("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = j - (m17593ok * 1048576);
                C12409ok.m17901bl(str, "checkSpaceOverflowInProgress: minKeep  = " + m17593ok + "MB, canDownload = " + C12713kf.m16570ok(j2) + "MB");
                if (j2 > 0) {
                    this.f35684fl = this.f35687i.getCurBytes() + j2 + 1048576;
                    return;
                } else {
                    this.f35684fl = 0L;
                    throw new C12533s(j, totalBytes);
                }
            }
        }
        this.f35684fl = 0L;
    }

    /* renamed from: fd */
    private void m16817fd() {
        try {
            Iterator it = ((ArrayList) this.f35691kf.clone()).iterator();
            while (it.hasNext()) {
                RunnableC12651a runnableC12651a = (RunnableC12651a) it.next();
                if (runnableC12651a != null) {
                    runnableC12651a.m16834a();
                }
            }
        } catch (Throwable th) {
            String str = f35675ok;
            C12409ok.m17901bl(str, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* renamed from: fl */
    private void m16816fl() {
        long m16585kf = C12713kf.m16585kf(this.f35687i);
        long curBytes = this.f35687i.getCurBytes();
        if (m16585kf != curBytes) {
            String str = f35675ok;
            C12409ok.m17894s(str, "checkTaskCanResume: offset = " + m16585kf + ", curBytes = " + curBytes);
        }
        this.f35687i.setCurBytes(m16585kf);
        boolean z = m16585kf > 0;
        this.f35697q = z;
        if (z || this.f35706v) {
            return;
        }
        C12409ok.m17901bl(f35675ok, "checkTaskCanResume: deleteAllDownloadFiles");
        this.f35702t.mo17478s(this.f35687i.getId());
        this.f35702t.mo17475z(this.f35687i.getId());
        C12713kf.m16563ok(this.f35687i);
    }

    /* renamed from: g */
    private void m16815g() throws C12528kf {
        if (this.f35687i.isOnlyWifi() && !C12713kf.m16568ok(C12490bl.m17807l(), C7282g.f24944b)) {
            throw new C12528kf(PointerIconCompat.TYPE_ZOOM_OUT, String.format("download task need permission:%s", C7282g.f24944b));
        }
        if (this.f35687i.isDownloadWithWifiValid()) {
            if (!this.f35687i.isPauseReserveWithWifiValid()) {
                throw new C12529n();
            }
            return;
        }
        throw new C12526bl();
    }

    /* renamed from: i */
    private void m16813i() {
        boolean z;
        boolean z2;
        String str = f35675ok;
        C12409ok.m17904a(str, "endDownloadRunnable::runStatus=" + this.f35699rh);
        boolean z3 = (this.f35699rh == EnumC12417p.RUN_STATUS_PAUSE || this.f35699rh == EnumC12417p.RUN_STATUS_CANCELED) ? false : true;
        try {
            z = m16805o();
            z2 = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.f35705ul.m17714ok((BaseException) e);
            } else {
                this.f35705ul.m17714ok(new BaseException(1046, e));
            }
            z = true;
            z2 = true;
        }
        if (!z && !z2) {
            this.f35681er = true;
            C12409ok.m17904a(f35675ok, "jump to restart");
            return;
        }
        this.f35710z.set(false);
        if (z3) {
            try {
                AbstractC12547ok m17820fb = C12490bl.m17820fb();
                if (m17820fb != null) {
                    m17820fb.mo17543ok(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                InterfaceC12483y monitorDepend = this.f35677bl.getMonitorDepend();
                DownloadInfo downloadInfo = this.f35687i;
                BaseException baseException = new BaseException((int) PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, C12713kf.m16608a(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.f35687i;
                C12723ok.m16492ok(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    /* renamed from: io */
    private boolean m16812io() {
        return this.f35699rh == EnumC12417p.RUN_STATUS_CANCELED || this.f35699rh == EnumC12417p.RUN_STATUS_PAUSE;
    }

    /* renamed from: j */
    private void m16811j() {
        boolean z;
        List<C12598a> mo17512bl;
        try {
            this.f35699rh = EnumC12417p.RUN_STATUS_NONE;
            this.f35687i.updateStartDownloadTime();
            this.f35687i.resetRealStartDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            this.f35687i.setFirstSpeedTime(-1L);
            try {
                m16810k();
                z = false;
            } catch (C12530ok e) {
                String str = f35675ok;
                C12409ok.m17904a(str, "file exist " + e.m17614ok());
                this.f35685g = e.m17614ok();
                z = true;
            }
            if (!this.f35681er) {
                this.f35705ul.m17735a();
            }
            this.f35681er = false;
            if (m16776ul()) {
                return;
            }
            if (!TextUtils.isEmpty(this.f35685g) && z) {
                if (this.f35687i.isExpiredRedownload()) {
                    this.f35706v = C12713kf.m16519s(this.f35687i);
                }
                if (!this.f35706v) {
                    m16771z();
                    return;
                }
            }
            while (!m16776ul()) {
                try {
                    try {
                        try {
                            m16775v();
                            m16808kz();
                            m16815g();
                            mo17512bl = this.f35702t.mo17512bl(this.f35687i.getId());
                            m16816fl();
                        } catch (C12532q e2) {
                            String str2 = f35675ok;
                            C12409ok.m17894s(str2, "downloadInner: retry throwable for " + e2.m17613ok());
                            if (this.f35699rh != EnumC12417p.RUN_STATUS_PAUSE) {
                                AtomicInteger atomicInteger = this.f35694n;
                                if (atomicInteger != null && atomicInteger.get() > 0) {
                                    this.f35687i.updateCurRetryTime(this.f35694n.decrementAndGet());
                                    this.f35687i.setStatus(5);
                                } else if (this.f35694n != null) {
                                    if (this.f35687i.trySwitchToNextBackupUrl()) {
                                        this.f35687i.setStatus(5);
                                        this.f35694n.set(this.f35687i.getRetryCount());
                                        this.f35687i.updateCurRetryTime(this.f35694n.get());
                                    } else {
                                        mo16760a(new BaseException((int) PointerIconCompat.TYPE_ZOOM_IN, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.f35687i.getRetryCount()), e2.m17613ok())));
                                    }
                                } else {
                                    mo16760a(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e2.m17613ok()));
                                }
                                m16770zz();
                            }
                        }
                    } catch (BaseException e3) {
                        String str3 = f35675ok;
                        C12409ok.m17894s(str3, "downloadInner: baseException = " + e3);
                        if (this.f35699rh != EnumC12417p.RUN_STATUS_PAUSE) {
                            if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                                if (mo16756ok(e3)) {
                                    if (C12713kf.m16565ok(e3)) {
                                        m16822e();
                                    }
                                    if (mo16755ok(e3, 0L) != EnumC12531p.RETURN) {
                                        m16770zz();
                                    } else {
                                        m16770zz();
                                        return;
                                    }
                                } else {
                                    mo16760a(e3);
                                }
                            }
                            this.f35699rh = EnumC12417p.RUN_STATUS_END_RIGHT_NOW;
                            m16770zz();
                            return;
                        }
                    }
                } catch (C12530ok unused) {
                    m16771z();
                }
                if (m16783rh()) {
                    C12409ok.m17901bl(f35675ok, "downloadSegments return");
                    m16770zz();
                    return;
                }
                String connectionUrl = this.f35687i.getConnectionUrl();
                if (m16776ul()) {
                    m16770zz();
                    return;
                }
                long m16579n = this.f35697q ? C12713kf.m16579n(this.f35687i) : 0L;
                C12598a m16799ok = m16799ok(this.f35687i, m16579n);
                List<C12601bl> m16797ok = m16797ok(m16799ok);
                C12713kf.m16538ok(m16797ok, this.f35687i);
                C12713kf.m16606a(m16797ok, this.f35687i);
                this.f35687i.setPreconnectLevel(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    m16790ok(connectionUrl, m16797ok, m16579n);
                    this.f35687i.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                    if (m16776ul()) {
                        m16770zz();
                        return;
                    }
                    long totalBytes = this.f35687i.getTotalBytes();
                    mo16757ok(totalBytes);
                    int m16800ok = m16800ok(totalBytes, mo17512bl);
                    if (m16776ul()) {
                        m16770zz();
                        return;
                    } else if (m16800ok > 0) {
                        boolean z2 = m16800ok == 1;
                        this.f35696p = z2;
                        if (z2) {
                            if (this.f35709y == null) {
                                try {
                                    currentTimeMillis2 = System.currentTimeMillis();
                                    m16791ok(connectionUrl, m16797ok);
                                    this.f35687i.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                                } finally {
                                }
                            }
                            if (m16776ul()) {
                                m16770zz();
                                return;
                            }
                            this.f35687i.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            m16779t();
                            m16795ok(m16799ok, connectionUrl, this.f35709y);
                        } else {
                            if (!this.f35687i.isNeedReuseFirstConnection()) {
                                m16778td();
                            }
                            if (m16776ul()) {
                                m16770zz();
                                return;
                            }
                            m16779t();
                            this.f35687i.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            if (this.f35697q) {
                                m16802ok(m16800ok, mo17512bl);
                            } else {
                                m16801ok(totalBytes, m16800ok);
                            }
                        }
                        m16770zz();
                        return;
                    } else {
                        throw new BaseException(1032, "chunkCount is 0");
                    }
                } finally {
                }
            }
        } finally {
            m16813i();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f3, code lost:
        if (r9.f35683fd.m17595ok("fix_file_exist_update_download_info") != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[Catch: all -> 0x00e8, TryCatch #5 {all -> 0x00e8, blocks: (B:56:0x00a7, B:58:0x00ab, B:60:0x00af, B:73:0x00e7), top: B:84:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cd  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m16810k() throws com.p521ss.android.socialbase.downloader.exception.C12530ok {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl.m16810k():void");
    }

    /* renamed from: kz */
    private void m16808kz() throws C12532q, BaseException {
        AbstractC12547ok m17820fb;
        int id = this.f35687i.getId();
        int m17785ok = C12490bl.m17785ok(this.f35687i);
        if (this.f35687i.isDownloaded() && !this.f35687i.isExpiredRedownload() && !this.f35706v) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo mo17520a = this.f35702t.mo17520a(m17785ok);
        if (mo17520a == null || (m17820fb = C12490bl.m17820fb()) == null || mo17520a.getId() == id || !mo17520a.equalsTask(this.f35687i)) {
            return;
        }
        if (!m17820fb.mo17558ok(mo17520a.getId())) {
            List<C12598a> mo17512bl = this.f35702t.mo17512bl(m17785ok);
            C12713kf.m16563ok(this.f35687i);
            this.f35702t.mo17502kf(m17785ok);
            if (mo17520a.isBreakpointAvailable()) {
                this.f35687i.copyFromCacheData(mo17520a, false);
                this.f35702t.mo17488ok(this.f35687i);
                if (mo17512bl != null) {
                    for (C12598a c12598a : mo17512bl) {
                        c12598a.m17049a(id);
                        this.f35702t.mo17486ok(c12598a);
                    }
                }
                throw new C12532q("retry task because id generator changed");
            }
            return;
        }
        this.f35702t.mo17502kf(id);
        throw new BaseException(1025, "another same task is downloading");
    }

    /* renamed from: m */
    private boolean m16807m() {
        if (this.f35687i.isChunked()) {
            DownloadInfo downloadInfo = this.f35687i;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        String str = f35675ok;
        C12409ok.m17901bl(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.f35687i.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.f35687i.getTotalBytes());
        if (this.f35687i.getCurBytes() > 0) {
            if (this.f35687i.isIgnoreDataVerify()) {
                return true;
            }
            if (this.f35687i.getTotalBytes() > 0 && this.f35687i.getCurBytes() == this.f35687i.getTotalBytes()) {
                return true;
            }
        }
        this.f35687i.setByteInvalidRetryStatus(EnumC12411a.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.f35687i.reset();
        this.f35702t.mo17488ok(this.f35687i);
        this.f35702t.mo17478s(this.f35687i.getId());
        this.f35702t.mo17475z(this.f35687i.getId());
        C12713kf.m16563ok(this.f35687i);
        return false;
    }

    /* renamed from: o */
    private boolean m16805o() {
        if (this.f35699rh == EnumC12417p.RUN_STATUS_ERROR) {
            this.f35705ul.m17714ok(this.f35695o);
        } else if (this.f35699rh == EnumC12417p.RUN_STATUS_CANCELED) {
            this.f35705ul.m17730bl();
        } else if (this.f35699rh == EnumC12417p.RUN_STATUS_PAUSE) {
            this.f35705ul.m17707s();
        } else if (this.f35699rh == EnumC12417p.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.f35705ul.m17727h();
            } catch (BaseException e) {
                this.f35705ul.m17714ok(e);
            }
        } else if (this.f35699rh == EnumC12417p.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.f35705ul.m17711ok(this.f35685g);
            } catch (BaseException e2) {
                this.f35705ul.m17714ok(e2);
            }
        } else if (this.f35699rh == EnumC12417p.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.f35705ul.m17713ok(this.f35695o, false);
            return false;
        } else if (this.f35699rh == EnumC12417p.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            return true;
        } else {
            EnumC12417p enumC12417p = this.f35699rh;
            EnumC12417p enumC12417p2 = EnumC12417p.RUN_STATUS_RETRY_DELAY;
            if (enumC12417p == enumC12417p2 && !m16772y()) {
                C12409ok.m17904a(f35675ok, "doTaskStatusHandle retryDelay");
                m16820ep();
                return this.f35699rh == enumC12417p2;
            }
            try {
                if (!m16807m()) {
                    return false;
                }
                this.f35705ul.m17724kf();
                C12565td.m17403ok().m17389s();
            } catch (Throwable th) {
                mo16760a(new BaseException(1008, C12713kf.m16608a(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    /* renamed from: p */
    private void m16786p() {
        DownloadInfo downloadInfo = this.f35687i;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.f35687i.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.f35694n;
        if (atomicInteger == null) {
            this.f35694n = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    /* renamed from: q */
    private boolean m16785q() {
        int status = this.f35687i.getStatus();
        if (status == 1 || this.f35687i.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        mo16760a(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058 A[LOOP:0: B:24:0x0058->B:57:0x0058, LOOP_START] */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m16784r() {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl.m16784r():void");
    }

    /* renamed from: rh */
    private boolean m16783rh() throws BaseException, InterruptedException {
        if (!this.f35687i.isExpiredRedownload() && this.f35687i.getChunkCount() == 1 && this.f35687i.getThrottleNetSpeed() <= 0) {
            JSONObject m17588s = C12534ok.m17599ok(this.f35687i.getId()).m17588s("segment_config");
            List<C12584q> mo17480rh = this.f35702t.mo17480rh(this.f35687i.getId());
            if (this.f35687i.getCurBytes() > 0) {
                if (mo17480rh == null || mo17480rh.isEmpty()) {
                    return false;
                }
                if (m17588s == null) {
                    m17588s = new JSONObject();
                }
            }
            if (m17588s == null) {
                return false;
            }
            this.f35701sg = new C12586r(this.f35687i, C12589rh.m17203ok(m17588s), this);
            if (m16776ul()) {
                C12409ok.m17901bl(f35675ok, "downloadSegments: is stopped by user");
                if (this.f35699rh == EnumC12417p.RUN_STATUS_CANCELED) {
                    this.f35701sg.m17251ok();
                } else {
                    this.f35701sg.m17277a();
                }
                return true;
            }
            return this.f35701sg.m17231ok(mo17480rh);
        }
        return false;
    }

    /* renamed from: sg */
    private boolean m16780sg() {
        return false;
    }

    /* renamed from: t */
    private void m16779t() {
        if (C12534ok.m17599ok(this.f35687i.getId()).m17593ok("reset_retain_retry_times", 0) != 1 || this.f35679em >= 3) {
            return;
        }
        this.f35694n.set(this.f35687i.isBackUpUrlUsed() ? this.f35687i.getBackUpUrlRetryCount() : this.f35687i.getRetryCount());
        this.f35679em++;
    }

    /* renamed from: td */
    private void m16778td() {
        InterfaceC12635q interfaceC12635q = this.f35709y;
        if (interfaceC12635q != null) {
            interfaceC12635q.mo16908s();
            this.f35709y = null;
        }
    }

    /* renamed from: u */
    private void m16777u() throws BaseException {
        if (this.f35686h != null) {
            if (this.f35699rh == EnumC12417p.RUN_STATUS_CANCELED) {
                this.f35687i.setStatus(-4);
                this.f35686h.m17701bl();
            } else if (this.f35699rh == EnumC12417p.RUN_STATUS_PAUSE) {
                this.f35687i.setStatus(-2);
                this.f35686h.m17703a();
            } else {
                this.f35686h.m17689s();
            }
        }
    }

    /* renamed from: ul */
    private boolean m16776ul() {
        if (m16812io() || this.f35687i.getStatus() == -2) {
            if (m16812io()) {
                return true;
            }
            if (this.f35687i.getStatus() == -2) {
                this.f35699rh = EnumC12417p.RUN_STATUS_PAUSE;
                return true;
            } else if (this.f35687i.getStatus() == -4) {
                this.f35699rh = EnumC12417p.RUN_STATUS_CANCELED;
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    /* renamed from: v */
    private void m16775v() throws BaseException {
        if (!TextUtils.isEmpty(this.f35687i.getSavePath())) {
            if (!TextUtils.isEmpty(this.f35687i.getName())) {
                File file = new File(this.f35687i.getSavePath());
                if (!file.exists()) {
                    boolean mkdirs = file.mkdirs();
                    if (mkdirs || file.exists()) {
                        return;
                    }
                    int i = 0;
                    if (C12534ok.m17599ok(this.f35687i.getId()).m17593ok("opt_mkdir_failed", 0) == 1) {
                        while (!mkdirs) {
                            int i2 = i + 1;
                            if (i >= 3) {
                                break;
                            }
                            try {
                                Thread.sleep(10L);
                                mkdirs = file.mkdirs();
                                i = i2;
                            } catch (InterruptedException unused) {
                            }
                        }
                        if (mkdirs || file.exists()) {
                            return;
                        }
                        if (C12713kf.m16518s(this.f35687i.getSavePath()) < 16384) {
                            throw new BaseException(1006, "download savePath directory can not created:" + this.f35687i.getSavePath());
                        }
                        throw new BaseException((int) GLMapStaticValue.MAP_PARAMETERNAME_SCENIC, "download savePath directory can not created:" + this.f35687i.getSavePath());
                    }
                    throw new BaseException((int) GLMapStaticValue.MAP_PARAMETERNAME_SCENIC, "download savePath directory can not created:" + this.f35687i.getSavePath());
                } else if (file.isDirectory()) {
                    return;
                } else {
                    if (C12720s.m16498a(this.f35687i)) {
                        file.delete();
                        if (file.mkdirs() || file.exists()) {
                            return;
                        }
                        throw new BaseException(1031, "download savePath is not directory:path=" + this.f35687i.getSavePath());
                    }
                    throw new BaseException(1031, "download savePath is not a directory:" + this.f35687i.getSavePath());
                }
            }
            throw new BaseException(1029, "download name can not be empty");
        }
        throw new BaseException(1028, "download savePath can not be empty");
    }

    /* renamed from: vz */
    private long m16774vz() {
        return this.f35688io.mo16651ok(this.f35687i.getCurRetryTimeInTotal(), this.f35687i.getTotalRetryCount());
    }

    /* renamed from: x */
    private void m16773x() {
        InterfaceC12620h interfaceC12620h = this.f35693m;
        if (interfaceC12620h != null) {
            interfaceC12620h.mo16917bl();
            this.f35693m = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m16772y() {
        /*
            r7 = this;
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.f35687i
            int r0 = r0.getChunkCount()
            r1 = 0
            r2 = 1
            if (r0 > r2) goto L28
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.f35687i
            long r3 = r0.getCurBytes()
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L27
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.f35687i
            long r3 = r0.getCurBytes()
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.f35687i
            long r5 = r0.getTotalBytes()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L27
            return r2
        L27:
            return r1
        L28:
            com.ss.android.socialbase.downloader.downloader.k r0 = r7.f35702t
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r7.f35687i
            int r3 = r3.getId()
            java.util.List r0 = r0.mo17512bl(r3)
            if (r0 == 0) goto L57
            int r3 = r0.size()
            if (r3 > r2) goto L3d
            goto L57
        L3d:
            java.util.Iterator r0 = r0.iterator()
        L41:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L56
            java.lang.Object r3 = r0.next()
            com.ss.android.socialbase.downloader.model.a r3 = (com.p521ss.android.socialbase.downloader.model.C12598a) r3
            if (r3 == 0) goto L55
            boolean r3 = r3.m17027q()
            if (r3 != 0) goto L41
        L55:
            return r1
        L56:
            return r2
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl.m16772y():boolean");
    }

    /* renamed from: z */
    private void m16771z() {
        C12409ok.m17904a(f35675ok, "finishWithFileExist");
        if (C12534ok.m17605bl().m17606a("fix_end_for_file_exist_error", true)) {
            if (this.f35685g.equals(this.f35687i.getName())) {
                this.f35699rh = EnumC12417p.RUN_STATUS_END_RIGHT_NOW;
            } else {
                this.f35699rh = EnumC12417p.RUN_STATUS_END_FOR_FILE_EXIST;
            }
        } else if (this.f35685g.equals(this.f35687i.getTargetFilePath())) {
            this.f35699rh = EnumC12417p.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.f35699rh = EnumC12417p.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    /* renamed from: zz */
    private void m16770zz() {
        m16773x();
        m16778td();
    }

    /* renamed from: a */
    public void m16826a() {
        EnumC12417p enumC12417p = EnumC12417p.RUN_STATUS_CANCELED;
        this.f35699rh = enumC12417p;
        if (this.f35701sg != null) {
            this.f35701sg.m17251ok();
        }
        if (this.f35686h != null) {
            this.f35686h.m17701bl();
        }
        if (this.f35701sg == null && this.f35686h == null) {
            m16770zz();
            this.f35699rh = enumC12417p;
            m16813i();
        }
        m16817fd();
    }

    /* renamed from: bl */
    public DownloadTask m16824bl() {
        return this.f35677bl;
    }

    /* renamed from: h */
    public Future m16814h() {
        return this.f35676a;
    }

    /* renamed from: kf */
    public void m16809kf() {
        this.f35678e = System.currentTimeMillis();
        this.f35705ul.m17722ok();
    }

    /* renamed from: n */
    public int m16806n() {
        DownloadInfo downloadInfo = this.f35687i;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        C12490bl.m17784ok(this.f35677bl, 3);
        try {
            C12612a.m16957ok().m16962a();
            m16784r();
            C12612a.m16957ok().m16961bl();
            C12490bl.m17837a(this.f35677bl, 3);
        } catch (Throwable th) {
            C12612a.m16957ok().m16961bl();
            throw th;
        }
    }

    /* renamed from: s */
    public boolean m16782s() {
        return this.f35710z.get();
    }

    /* renamed from: s */
    private boolean m16781s(BaseException baseException) {
        AtomicInteger atomicInteger = this.f35694n;
        boolean z = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.f35687i.trySwitchToNextBackupUrl()) {
                    this.f35694n.set(this.f35687i.getBackUpUrlRetryCount());
                    this.f35687i.updateCurRetryTime(this.f35694n.get());
                } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.f35687i.canReplaceHttpForRetry())) {
                    this.f35694n.set(this.f35687i.getRetryCount());
                    this.f35687i.updateCurRetryTime(this.f35694n.get());
                    this.f35687i.setHttpsToHttpRetryUsed(true);
                } else {
                    mo16760a(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.f35694n), String.valueOf(this.f35687i.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                z = false;
            }
            if (this.f35699rh != EnumC12417p.RUN_STATUS_RETRY_DELAY && z) {
                this.f35687i.updateCurRetryTime(this.f35694n.decrementAndGet());
            }
            return false;
        }
        mo16760a(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: bl */
    public void mo16759bl(BaseException baseException) {
        DownloadInfo downloadInfo = this.f35687i;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        mo16754ok(baseException, false);
    }

    /* renamed from: ok */
    public void m16804ok() {
        EnumC12417p enumC12417p = EnumC12417p.RUN_STATUS_PAUSE;
        this.f35699rh = enumC12417p;
        if (this.f35701sg != null) {
            this.f35701sg.m17277a();
        }
        if (this.f35686h != null) {
            this.f35686h.m17703a();
        }
        if (this.f35701sg == null && this.f35686h == null) {
            m16770zz();
            this.f35699rh = enumC12417p;
            m16813i();
        }
        try {
            Iterator it = ((ArrayList) this.f35691kf.clone()).iterator();
            while (it.hasNext()) {
                RunnableC12651a runnableC12651a = (RunnableC12651a) it.next();
                if (runnableC12651a != null) {
                    runnableC12651a.m16831ok();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: bl */
    public void m16823bl(long j) {
        InterfaceC12635q interfaceC12635q = this.f35709y;
        if (interfaceC12635q != null && (interfaceC12635q instanceof AbstractC12625ok)) {
            try {
                ((AbstractC12625ok) interfaceC12635q).m16942ok(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m16825a(String str, List<C12601bl> list, long j) throws BaseException, C12532q {
        C12629bl m16920ok;
        boolean z = true;
        if (this.f35687i.getChunkCount() == 1 && (m16920ok = C12630ok.m16924ok().m16920ok(str, list)) != null) {
            this.f35693m = m16920ok;
            this.f35687i.setPreconnectLevel(1);
        }
        if (this.f35693m == null && !this.f35682fb && this.f35687i.isHeadConnectionAvailable()) {
            try {
                int m17607a = this.f35683fd.m17607a("net_lib_strategy");
                if (this.f35683fd.m17593ok("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.f35693m = C12490bl.m17774ok(str, list, m17607a, z, this.f35687i);
            } catch (Throwable th) {
                this.f35687i.setHeadConnectionException(C12713kf.m16587k(th));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r9 <= 0) goto L22;
     */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m16800ok(long r7, java.util.List<com.p521ss.android.socialbase.downloader.model.C12598a> r9) {
        /*
            r6 = this;
            boolean r0 = r6.m16819er()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            boolean r0 = r6.f35697q
            if (r0 == 0) goto L1a
            if (r9 == 0) goto L13
            int r9 = r9.size()
            goto L5c
        L13:
            com.ss.android.socialbase.downloader.model.DownloadInfo r9 = r6.f35687i
            int r9 = r9.getChunkCount()
            goto L5c
        L1a:
            com.ss.android.socialbase.downloader.downloader.p r9 = r6.f35708x
            if (r9 == 0) goto L23
            int r9 = r9.mo16677ok(r7)
            goto L29
        L23:
            com.ss.android.socialbase.downloader.downloader.p r9 = r6.f35703td
            int r9 = r9.mo16677ok(r7)
        L29:
            com.ss.android.socialbase.downloader.network.r r0 = com.p521ss.android.socialbase.downloader.network.C12636r.m16905ok()
            com.ss.android.socialbase.downloader.network.j r0 = r0.m16907a()
            java.lang.String r3 = com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl.f35675ok
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r0.name()
            r4[r1] = r5
            java.lang.String r5 = "NetworkQuality is : %s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17904a(r3, r4)
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r6.f35687i
            java.lang.String r4 = r0.name()
            r3.setNetworkQuality(r4)
            com.ss.android.socialbase.downloader.downloader.h r3 = r6.f35711zz
            if (r3 == 0) goto L56
            int r9 = r3.mo17586ok(r9, r0)
            goto L5c
        L56:
            com.ss.android.socialbase.downloader.downloader.h r3 = r6.f35704u
            int r9 = r3.mo17586ok(r9, r0)
        L5c:
            if (r9 > 0) goto L5f
        L5e:
            r9 = 1
        L5f:
            boolean r0 = com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17899ok()
            if (r0 == 0) goto L88
            java.lang.String r0 = com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl.f35675ok
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = java.lang.String.valueOf(r9)
            r3[r1] = r4
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r6.f35687i
            java.lang.String r1 = r1.getName()
            r3[r2] = r1
            r1 = 2
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3[r1] = r7
            java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r7 = java.lang.String.format(r7, r3)
            com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17904a(r0, r7)
        L88:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl.m16800ok(long, java.util.List):int");
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: a */
    public boolean mo16761a(long j) throws BaseException {
        if (this.f35684fl > 0 && this.f35687i.getCurBytes() > this.f35684fl) {
            m16818fb();
        }
        return this.f35705ul.m17719ok(j);
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: a */
    public void mo16760a(BaseException baseException) {
        String str = f35675ok;
        C12409ok.m17904a(str, "onError:" + baseException.getMessage());
        this.f35699rh = EnumC12417p.RUN_STATUS_ERROR;
        this.f35695o = baseException;
        m16817fd();
    }

    /* renamed from: ok */
    private void m16790ok(String str, List<C12601bl> list, long j) throws BaseException, C12532q {
        m16825a(str, list, j);
        InterfaceC12620h interfaceC12620h = this.f35693m;
        if (interfaceC12620h != null) {
            try {
                mo16750ok(str, interfaceC12620h, j);
            } catch (Throwable unused) {
                this.f35682fb = true;
            }
        }
        if (this.f35693m == null || this.f35682fb) {
            m16791ok(str, list);
            mo16750ok(str, this.f35709y, j);
        }
    }

    /* renamed from: ok */
    private void m16791ok(String str, List<C12601bl> list) throws BaseException, C12532q {
        InterfaceC12635q interfaceC12635q;
        if (this.f35709y != null) {
            return;
        }
        C12633s m16925a = this.f35687i.getChunkCount() == 1 ? C12630ok.m16924ok().m16925a(str, list) : null;
        try {
            if (m16925a != null) {
                mo16752ok(this.f35709y);
                this.f35687i.setPreconnectLevel(2);
                this.f35709y = m16925a;
            } else {
                try {
                    interfaceC12635q = C12490bl.m17770ok(this.f35687i.isNeedDefaultHttpServiceBackUp(), this.f35687i.getMaxBytes(), str, null, list, this.f35683fd.m17607a("net_lib_strategy"), this.f35683fd.m17593ok("monitor_download_connect", 0) > 0, this.f35687i);
                    this.f35709y = interfaceC12635q;
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    if (this.f35687i.isExpiredRedownload() && C12713kf.m16590h(th) && C12713kf.m16593bl(list)) {
                        C12409ok.m17904a(f35675ok, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.f35687i.getCacheControl());
                        long m16526q = C12713kf.m16526q(this.f35687i.getCacheControl());
                        if (m16526q <= 0) {
                            m16526q = C12534ok.m17599ok(this.f35687i.getId()).m17593ok("default_304_max_age", 300);
                        }
                        this.f35687i.setCacheExpiredTime(System.currentTimeMillis() + (m16526q * 1000));
                        throw new C12530ok(this.f35685g);
                    }
                    if (C12713kf.m16583kf(th)) {
                        m16792ok("", "http code 416");
                    } else if (C12713kf.m16576n(th)) {
                        m16792ok("", "http code 412");
                    } else {
                        C12713kf.m16540ok(th, "CreateFirstConnection");
                    }
                    interfaceC12635q = this.f35709y;
                }
                mo16752ok(interfaceC12635q);
            }
            if (this.f35709y == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            mo16752ok(this.f35709y);
            throw th2;
        }
    }

    /* renamed from: ok */
    public static C12598a m16799ok(DownloadInfo downloadInfo, long j) {
        return new C12598a.C12600ok(downloadInfo.getId()).m17007ok(-1).m17006ok(0L).m17010n(j).m17016a(j).m17014bl(0L).m17002s(downloadInfo.getTotalBytes() - j).m17008ok();
    }

    /* renamed from: ok */
    private List<C12601bl> m16797ok(C12598a c12598a) {
        List<C12601bl> m16536ok = C12713kf.m16536ok(this.f35687i.getExtraHeaders(), this.f35687i.geteTag(), c12598a);
        if (this.f35687i.isExpiredRedownload() && this.f35706v && this.f35687i.getLastModified() != null) {
            m16536ok.add(new C12601bl("if-modified-since", this.f35687i.getLastModified()));
            m16536ok.add(new C12601bl("download-tc21-1-15", "download-tc21-1-15"));
            String str = f35675ok;
            C12409ok.m17904a(str, "dcache::add head IF_MODIFIED_SINCE=" + this.f35687i.getLastModified());
        }
        return m16536ok;
    }

    /* renamed from: ok */
    private void m16802ok(int i, List<C12598a> list) throws BaseException {
        if (list.size() == i) {
            m16788ok(list, this.f35687i.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    /* renamed from: ok */
    private void m16801ok(long j, int i) throws BaseException {
        long j2 = j / i;
        int id = this.f35687i.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            C12598a m17008ok = new C12598a.C12600ok(id).m17007ok(i2).m17006ok(j3).m17010n(j3).m17016a(j3).m17014bl(i2 == i + (-1) ? 0L : (j3 + j2) - 1).m17008ok();
            arrayList.add(m17008ok);
            this.f35702t.mo17486ok(m17008ok);
            j3 += j2;
            i2++;
        }
        this.f35687i.setChunkCount(i);
        this.f35702t.mo17498ok(id, i);
        m16788ok(arrayList, j);
    }

    /* renamed from: ok */
    private void m16788ok(List<C12598a> list, long j) throws BaseException {
        long m17042i;
        for (C12598a c12598a : list) {
            if (c12598a != null) {
                if (c12598a.m17042i() == 0) {
                    m17042i = j - c12598a.m17025rh();
                } else {
                    m17042i = (c12598a.m17042i() - c12598a.m17025rh()) + 1;
                }
                if (m17042i > 0) {
                    c12598a.m17034ok(m17042i);
                    if (this.f35687i.isNeedReuseFirstConnection() && this.f35709y != null && (!this.f35687i.isHeadConnectionAvailable() || this.f35682fb)) {
                        if (c12598a.m17019zz() == 0) {
                            this.f35691kf.add(new RunnableC12651a(c12598a, this.f35677bl, this.f35709y, this));
                        } else if (c12598a.m17019zz() > 0) {
                            this.f35691kf.add(new RunnableC12651a(c12598a, this.f35677bl, this));
                        }
                    } else {
                        this.f35691kf.add(new RunnableC12651a(c12598a, this.f35677bl, this));
                    }
                }
            }
        }
        if (C12717ok.m16510ok(64)) {
            ArrayList arrayList = new ArrayList(this.f35691kf.size());
            Iterator<RunnableC12651a> it = this.f35691kf.iterator();
            while (it.hasNext()) {
                RunnableC12651a next = it.next();
                if (this.f35699rh == EnumC12417p.RUN_STATUS_CANCELED) {
                    next.m16834a();
                } else if (this.f35699rh == EnumC12417p.RUN_STATUS_PAUSE) {
                    next.m16831ok();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> m17580s = C12546n.m17580s(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = C12546n.m17581n(m17580s)) {
                    if (m16776ul()) {
                        return;
                    }
                    runnable.run();
                }
                if (m17580s == null || m17580s.isEmpty()) {
                    return;
                }
                for (Future future : m17580s) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f35691kf.size());
        Iterator<RunnableC12651a> it2 = this.f35691kf.iterator();
        while (it2.hasNext()) {
            RunnableC12651a next2 = it2.next();
            if (this.f35699rh == EnumC12417p.RUN_STATUS_CANCELED) {
                next2.m16834a();
            } else if (this.f35699rh == EnumC12417p.RUN_STATUS_PAUSE) {
                next2.m16831ok();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (m16776ul()) {
            return;
        }
        try {
            C12546n.m17582bl(arrayList2);
        } catch (InterruptedException e) {
            throw new BaseException((int) PointerIconCompat.TYPE_GRAB, e);
        }
    }

    /* renamed from: ok */
    private void m16795ok(C12598a c12598a, String str, InterfaceC12635q interfaceC12635q) throws BaseException {
        c12598a.m17034ok(this.f35687i.getTotalBytes() - c12598a.m17025rh());
        this.f35687i.setChunkCount(1);
        this.f35702t.mo17498ok(this.f35687i.getId(), 1);
        this.f35686h = new C12505n(this.f35687i, str, interfaceC12635q, c12598a, this);
        m16777u();
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: ok */
    public void mo16757ok(long j) throws BaseException {
        long j2;
        String tempPath = this.f35687i.getTempPath();
        String tempName = this.f35687i.getTempName();
        if (C12713kf.m16621a(j)) {
            return;
        }
        C12603n m16560ok = C12713kf.m16560ok(this.f35687i, tempPath, tempName, -1);
        try {
            long length = new File(tempPath, tempName).length();
            long j3 = j - length;
            long m16518s = C12713kf.m16518s(tempPath);
            C12534ok m17599ok = C12534ok.m17599ok(this.f35687i.getId());
            if (m17599ok.m17593ok("space_fill_part_download", 0) == 1) {
                this.f35684fl = 0L;
                if (j3 <= 0) {
                    j3 = this.f35687i.getTotalBytes() - this.f35687i.getCurBytes();
                }
                if (m16518s < j3) {
                    String str = f35675ok;
                    C12409ok.m17894s(str, "checkSpaceOverflow: contentLength = " + C12713kf.m16570ok(j) + "MB, downloaded = " + C12713kf.m16570ok(length) + "MB, required = " + C12713kf.m16570ok(j3) + "MB, available = " + C12713kf.m16570ok(m16518s) + "MB");
                    if (m16518s > 0) {
                        int m17593ok = m17599ok.m17593ok("space_fill_min_keep_mb", 100);
                        if (m17593ok > 0) {
                            long j4 = m16518s - (m17593ok * 1048576);
                            C12409ok.m17894s(str, "checkSpaceOverflow: minKeep = " + m17593ok + "MB, canDownload = " + C12713kf.m16570ok(j4) + "MB");
                            if (j4 > 0) {
                                this.f35684fl = this.f35687i.getCurBytes() + j4;
                                j2 = j4;
                            } else {
                                throw new C12533s(m16518s, j3);
                            }
                        } else {
                            j2 = m16518s;
                        }
                        if (length < j) {
                            if (j2 + length > j) {
                            }
                            m16560ok.m16995a(j);
                            C12713kf.m16531ok(m16560ok);
                        }
                    } else if (m17599ok.m17593ok("download_when_space_negative", 0) != 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("availableSpace ");
                        sb.append(m16518s == 0 ? "=" : "<");
                        sb.append(" 0");
                        throw new BaseException(1052, sb.toString());
                    } else {
                        m16560ok.m16995a(j);
                        C12713kf.m16531ok(m16560ok);
                    }
                }
            } else if (m16518s <= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("availableSpace ");
                sb2.append(m16518s == 0 ? "=" : "<");
                sb2.append(" 0");
                throw new BaseException(1052, sb2.toString());
            } else if (m16518s < j3) {
                throw new C12533s(m16518s, j3);
            }
            m16560ok.m16995a(j);
            C12713kf.m16531ok(m16560ok);
        } catch (Throwable th) {
            C12713kf.m16531ok(m16560ok);
            throw th;
        }
    }

    /* renamed from: ok */
    private boolean m16803ok(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.f35698r || this.f35690k)) {
            return (i == 201 || i == 416) && this.f35687i.getCurBytes() > 0;
        }
        return true;
    }

    /* renamed from: ok */
    private void m16792ok(String str, String str2) throws C12532q {
        this.f35702t.mo17478s(this.f35687i.getId());
        this.f35702t.mo17475z(this.f35687i.getId());
        C12713kf.m16563ok(this.f35687i);
        this.f35697q = false;
        this.f35687i.resetDataForEtagEndure(str);
        this.f35702t.mo17488ok(this.f35687i);
        throw new C12532q(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0253, code lost:
        r8 = com.p521ss.android.socialbase.downloader.p556q.C12713kf.m16615a(r10, io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_RANGE);
        com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17901bl(r14, "firstConnection: contentRange = " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0271, code lost:
        if (android.text.TextUtils.isEmpty(r8) != false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x027c, code lost:
        if (r19.f35683fd.m17606a("fix_get_total_bytes", true) == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x027e, code lost:
        r3 = com.p521ss.android.socialbase.downloader.p556q.C12713kf.m16612a(r8);
        com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17901bl(r14, "firstConnection: 1 totalLength = " + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0297, code lost:
        r11 = r22 + r3;
        com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17900n(r14, "firstConnection: 2 totalLength = " + r11 + ", contentLength = " + r3);
        r3 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013a, code lost:
        com.p521ss.android.socialbase.downloader.p556q.C12713kf.m16563ok(r19.f35687i);
     */
    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo16750ok(java.lang.String r20, com.p521ss.android.socialbase.downloader.network.InterfaceC12620h r21, long r22) throws com.p521ss.android.socialbase.downloader.exception.BaseException, com.p521ss.android.socialbase.downloader.exception.C12532q {
        /*
            Method dump skipped, instructions count: 855
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl.mo16750ok(java.lang.String, com.ss.android.socialbase.downloader.network.h, long):void");
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: ok */
    public void mo16751ok(RunnableC12651a runnableC12651a) {
        if (this.f35696p) {
            return;
        }
        synchronized (this) {
            this.f35691kf.remove(runnableC12651a);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: ok */
    public boolean mo16756ok(BaseException baseException) {
        if (this.f35701sg == null || !C12713kf.m16525q(baseException) || this.f35694n.get() >= this.f35687i.getRetryCount()) {
            if (C12713kf.m16619a(baseException)) {
                if (this.f35696p && !this.f35700s) {
                    C12713kf.m16563ok(this.f35687i);
                    this.f35700s = true;
                }
                return true;
            }
            AtomicInteger atomicInteger = this.f35694n;
            if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.f35687i.hasNextBackupUrl()) {
                if (baseException == null) {
                    return false;
                }
                if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.f35687i.canReplaceHttpForRetry()) {
                    return false;
                }
            }
            return !(baseException instanceof C12528kf);
        }
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: ok */
    public void mo16754ok(BaseException baseException, boolean z) {
        C12409ok.m17904a(f35675ok, "onAllChunkRetryWithReset");
        this.f35699rh = EnumC12417p.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.f35695o = baseException;
        m16817fd();
        if (z ? m16781s(baseException) : false) {
            return;
        }
        m16822e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m16789ok(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f35687i.setForbiddenBackupUrls(list, this.f35699rh == EnumC12417p.RUN_STATUS_WAITING_ASYNC_HANDLER);
        AbstractC12547ok m17820fb = C12490bl.m17820fb();
        if (m17820fb != null) {
            m17820fb.m17564j(this.f35687i.getId());
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: ok */
    public EnumC12531p mo16753ok(C12598a c12598a, BaseException baseException, long j) {
        if (m16812io()) {
            return EnumC12531p.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || C12713kf.m16528p(baseException))) {
            return mo16755ok(baseException, j);
        }
        this.f35695o = baseException;
        this.f35687i.increaseCurBytes(-j);
        this.f35702t.mo17488ok(this.f35687i);
        if (m16781s(baseException)) {
            return EnumC12531p.RETURN;
        }
        C12502kf c12502kf = this.f35705ul;
        EnumC12417p enumC12417p = this.f35699rh;
        EnumC12417p enumC12417p2 = EnumC12417p.RUN_STATUS_RETRY_DELAY;
        c12502kf.m17712ok(c12598a, baseException, enumC12417p == enumC12417p2);
        if (this.f35699rh != enumC12417p2 && this.f35687i.isNeedRetryDelay()) {
            long m16774vz = m16774vz();
            if (m16774vz > 0) {
                String str = f35675ok;
                C12409ok.m17901bl(str, "onSingleChunkRetry with delay time " + m16774vz);
                try {
                    Thread.sleep(m16774vz);
                } catch (Throwable th) {
                    String str2 = f35675ok;
                    C12409ok.m17894s(str2, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return EnumC12531p.CONTINUE;
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: ok */
    public EnumC12531p mo16755ok(BaseException baseException, long j) {
        long totalBytes;
        long j2;
        boolean z;
        this.f35695o = baseException;
        this.f35687i.increaseCurBytes(-j);
        this.f35702t.mo17488ok(this.f35687i);
        if (m16812io()) {
            return EnumC12531p.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.f35680ep != null && !this.f35687i.isForbiddenRetryed()) {
                AbstractC12419a abstractC12419a = new AbstractC12419a() { // from class: com.ss.android.socialbase.downloader.p.bl.1
                    @Override // com.p521ss.android.socialbase.downloader.depend.AbstractC12419a, com.p521ss.android.socialbase.downloader.depend.InterfaceC12479ul
                    /* renamed from: ok */
                    public void mo16638ok(List<String> list) {
                        super.mo16638ok(list);
                        RunnableC12652bl.this.m16789ok(list);
                    }
                };
                boolean mo16659ok = this.f35680ep.mo16659ok(abstractC12419a);
                this.f35687i.setForbiddenRetryed();
                if (mo16659ok) {
                    if (!abstractC12419a.mo16639ok()) {
                        m16817fd();
                        this.f35705ul.m17710p();
                        this.f35699rh = EnumC12417p.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return EnumC12531p.RETURN;
                    }
                    z = true;
                }
            } else if (m16781s(baseException)) {
                return EnumC12531p.RETURN;
            }
            z = false;
        } else if (C12713kf.m16528p(baseException)) {
            if (this.f35707vz == null) {
                mo16760a(baseException);
                return EnumC12531p.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            InterfaceC12482x interfaceC12482x = new InterfaceC12482x() { // from class: com.ss.android.socialbase.downloader.p.bl.2
                @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12482x
                /* renamed from: ok */
                public void mo16653ok() {
                    synchronized (RunnableC12652bl.this) {
                        atomicBoolean.set(true);
                        RunnableC12652bl.this.m16821em();
                    }
                }
            };
            if (baseException instanceof C12533s) {
                C12533s c12533s = (C12533s) baseException;
                j2 = c12533s.m17611ok();
                totalBytes = c12533s.m17612a();
            } else {
                totalBytes = this.f35687i.getTotalBytes();
                j2 = -1;
            }
            synchronized (this) {
                if (this.f35707vz.mo16654ok(j2, totalBytes, interfaceC12482x)) {
                    if (!C12534ok.m17599ok(this.f35687i.getId()).m17606a("not_delete_when_clean_space", false)) {
                        m16807m();
                    }
                    if (!atomicBoolean.get()) {
                        EnumC12417p enumC12417p = this.f35699rh;
                        EnumC12417p enumC12417p2 = EnumC12417p.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        if (enumC12417p != enumC12417p2) {
                            this.f35699rh = enumC12417p2;
                            m16817fd();
                            this.f35705ul.m17710p();
                        }
                        return EnumC12531p.RETURN;
                    }
                    if (m16781s(baseException)) {
                        return EnumC12531p.RETURN;
                    }
                    z = true;
                } else if (this.f35699rh == EnumC12417p.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                    return EnumC12531p.RETURN;
                } else {
                    mo16760a(baseException);
                    return EnumC12531p.RETURN;
                }
            }
        } else {
            if (m16781s(baseException)) {
                return EnumC12531p.RETURN;
            }
            z = false;
        }
        if (!z && m16780sg()) {
            m16817fd();
        }
        C12502kf c12502kf = this.f35705ul;
        EnumC12417p enumC12417p3 = this.f35699rh;
        EnumC12417p enumC12417p4 = EnumC12417p.RUN_STATUS_RETRY_DELAY;
        c12502kf.m17713ok(baseException, enumC12417p3 == enumC12417p4);
        return this.f35699rh == enumC12417p4 ? EnumC12531p.RETURN : EnumC12531p.CONTINUE;
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: ok */
    public synchronized C12598a mo16758ok(int i) {
        C12598a m16796ok;
        if (this.f35687i.getChunkCount() < 2) {
            return null;
        }
        List<C12598a> mo17512bl = this.f35702t.mo17512bl(this.f35687i.getId());
        if (mo17512bl != null && !mo17512bl.isEmpty()) {
            for (int i2 = 0; i2 < mo17512bl.size(); i2++) {
                C12598a c12598a = mo17512bl.get(i2);
                if (c12598a != null && (m16796ok = m16796ok(c12598a, i)) != null) {
                    return m16796ok;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    @Override // com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo16752ok(com.p521ss.android.socialbase.downloader.network.InterfaceC12620h r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1a
            int r2 = r2.mo16918a()     // Catch: java.lang.Throwable -> L16
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r1.f35687i     // Catch: java.lang.Throwable -> L16
            r0.setHttpStatusCode(r2)     // Catch: java.lang.Throwable -> L16
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r1.f35687i     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = com.p521ss.android.socialbase.downloader.p556q.C12666a.m16733ok(r2)     // Catch: java.lang.Throwable -> L16
            r0.setHttpStatusMessage(r2)     // Catch: java.lang.Throwable -> L16
            r2 = 1
            goto L1b
        L16:
            r2 = move-exception
            r2.printStackTrace()
        L1a:
            r2 = 0
        L1b:
            if (r2 != 0) goto L2a
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r1.f35687i
            r0 = -1
            r2.setHttpStatusCode(r0)
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r1.f35687i
            java.lang.String r0 = ""
            r2.setHttpStatusMessage(r0)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl.mo16752ok(com.ss.android.socialbase.downloader.network.h):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r9.m17039kf() != false) goto L18;
     */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.p521ss.android.socialbase.downloader.model.C12598a m16796ok(com.p521ss.android.socialbase.downloader.model.C12598a r9, int r10) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl.m16796ok(com.ss.android.socialbase.downloader.model.a, int):com.ss.android.socialbase.downloader.model.a");
    }

    /* renamed from: ok */
    private InterfaceC12523zz m16798ok(DownloadTask downloadTask) {
        InterfaceC12523zz retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new C12572x(retryDelayTimeArray);
            }
        }
        return C12490bl.m17748xy();
    }

    /* renamed from: ok */
    public void m16787ok(Future future) {
        this.f35676a = future;
    }
}
