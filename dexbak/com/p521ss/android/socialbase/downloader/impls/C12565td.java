package com.p521ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.constants.C12415n;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12500j;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12518td;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.exception.C12533s;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.impls.td */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12565td implements Handler.Callback, C12646ok.InterfaceC12650ok {

    /* renamed from: ok */
    private static volatile C12565td f35276ok;

    /* renamed from: q */
    private static InterfaceC12570a f35277q;

    /* renamed from: kf */
    private long f35281kf;

    /* renamed from: n */
    private final boolean f35282n;

    /* renamed from: p */
    private ConnectivityManager f35283p;

    /* renamed from: bl */
    private final Handler f35279bl = new Handler(Looper.getMainLooper(), this);

    /* renamed from: s */
    private final SparseArray<C12571ok> f35284s = new SparseArray<>();

    /* renamed from: h */
    private int f35280h = 0;

    /* renamed from: a */
    private final Context f35278a = C12490bl.m17807l();

    /* renamed from: com.ss.android.socialbase.downloader.impls.td$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12570a {
        /* renamed from: ok */
        void mo17386ok(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.downloader.impls.td$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12571ok {

        /* renamed from: a */
        final int f35292a;

        /* renamed from: bl */
        final int f35293bl;

        /* renamed from: h */
        final int[] f35294h;

        /* renamed from: j */
        private boolean f35295j;

        /* renamed from: k */
        private boolean f35296k;

        /* renamed from: kf */
        final boolean f35297kf;

        /* renamed from: n */
        final int f35298n;

        /* renamed from: ok */
        final int f35299ok;

        /* renamed from: p */
        private int f35300p;

        /* renamed from: q */
        private int f35301q;

        /* renamed from: r */
        private long f35302r;

        /* renamed from: s */
        final int f35303s;

        C12571ok(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.f35299ok = i;
            this.f35292a = i2;
            this.f35293bl = i3;
            this.f35303s = i4;
            this.f35298n = i5;
            this.f35297kf = z;
            this.f35294h = iArr;
            this.f35300p = i4;
        }

        /* renamed from: bl */
        void m17382bl() {
            this.f35300p = this.f35303s;
        }

        /* renamed from: s */
        int m17376s() {
            return this.f35300p;
        }

        /* renamed from: a */
        synchronized void m17385a() {
            this.f35301q++;
        }

        /* renamed from: ok */
        boolean m17379ok(long j, int i, int i2, boolean z) {
            if (!this.f35295j) {
                C12409ok.m17901bl("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.f35292a >= i && this.f35301q < this.f35293bl) {
                if (!this.f35296k || i2 == 2) {
                    return z || j - this.f35302r >= ((long) this.f35303s);
                }
                return false;
            } else {
                return false;
            }
        }

        /* renamed from: ok */
        synchronized void m17381ok() {
            this.f35300p += this.f35298n;
        }

        /* renamed from: ok */
        synchronized void m17380ok(long j) {
            this.f35302r = j;
        }
    }

    private C12565td() {
        m17406kf();
        this.f35282n = C12713kf.m16605bl();
        C12646ok.m16846ok().m16843ok(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public int m17407h() {
        try {
            if (this.f35283p == null) {
                this.f35283p = (ConnectivityManager) StubApp.getOrigApplicationContext(this.f35278a.getApplicationContext()).getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.f35283p.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    /* renamed from: kf */
    private void m17406kf() {
        if (C12534ok.m17605bl().m17593ok("use_network_callback", 0) != 1) {
            return;
        }
        C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.td.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (C12565td.this.f35278a == null || Build.VERSION.SDK_INT < 21) {
                        return;
                    }
                    C12565td c12565td = C12565td.this;
                    c12565td.f35283p = (ConnectivityManager) StubApp.getOrigApplicationContext(c12565td.f35278a.getApplicationContext()).getSystemService("connectivity");
                    C12565td.this.f35283p.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.td.1.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            C12409ok.m17904a("RetryScheduler", "network onAvailable: ");
                            C12565td.this.m17400ok(1, true);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            m17411a(message.arg1, message.arg2 == 1);
        } else {
            C12409ok.m17901bl("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            m17402ok(message.what);
        }
        return true;
    }

    /* renamed from: a */
    private void m17411a(final int i, final boolean z) {
        C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.td.2
            @Override // java.lang.Runnable
            public void run() {
                int m17407h;
                try {
                    if (C12565td.this.f35280h > 0 && (m17407h = C12565td.this.m17407h()) != 0) {
                        C12409ok.m17901bl("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + C12565td.this.f35280h);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<C12571ok> arrayList = new ArrayList();
                        synchronized (C12565td.this.f35284s) {
                            for (int i2 = 0; i2 < C12565td.this.f35284s.size(); i2++) {
                                C12571ok c12571ok = (C12571ok) C12565td.this.f35284s.valueAt(i2);
                                if (c12571ok != null && c12571ok.m17379ok(currentTimeMillis, i, m17407h, z)) {
                                    if (z) {
                                        c12571ok.m17382bl();
                                    }
                                    arrayList.add(c12571ok);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            for (C12571ok c12571ok2 : arrayList) {
                                C12565td.this.m17401ok(c12571ok2.f35299ok, m17407h, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* renamed from: bl */
    private void m17409bl(int i) {
        synchronized (this.f35284s) {
            this.f35284s.remove(i);
        }
    }

    /* renamed from: s */
    private C12571ok m17388s(int i) {
        int[] iArr;
        int i2;
        int i3;
        boolean z;
        C12534ok m17599ok = C12534ok.m17599ok(i);
        boolean z2 = false;
        int m17593ok = m17599ok.m17593ok("retry_schedule", 0);
        JSONObject m17588s = m17599ok.m17588s("retry_schedule_config");
        int i4 = 60;
        if (m17588s != null) {
            int optInt = m17588s.optInt("max_count", 60);
            int optInt2 = m17588s.optInt("interval_sec", 60);
            int optInt3 = m17588s.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT >= 21 && f35277q != null && m17588s.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArr = m17390ok(m17588s.optString("allow_error_code"));
            i2 = optInt3;
            z = z2;
            i3 = optInt;
            i4 = optInt2;
        } else {
            iArr = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new C12571ok(i, m17593ok, i3, i4 * 1000, i2 * 1000, z, iArr);
    }

    /* renamed from: n */
    public void m17405n() {
        m17400ok(5, false);
    }

    /* renamed from: a */
    private C12571ok m17412a(int i) {
        C12571ok c12571ok = this.f35284s.get(i);
        if (c12571ok == null) {
            synchronized (this.f35284s) {
                c12571ok = this.f35284s.get(i);
                if (c12571ok == null) {
                    c12571ok = m17388s(i);
                }
                this.f35284s.put(i, c12571ok);
            }
        }
        return c12571ok;
    }

    /* renamed from: ok */
    public static C12565td m17403ok() {
        if (f35276ok == null) {
            synchronized (C12565td.class) {
                if (f35276ok == null) {
                    f35276ok = new C12565td();
                }
            }
        }
        return f35276ok;
    }

    @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
    /* renamed from: bl */
    public void mo16835bl() {
        m17400ok(3, false);
    }

    @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
    /* renamed from: a */
    public void mo16836a() {
        m17400ok(4, false);
    }

    /* renamed from: ok */
    public static void m17399ok(InterfaceC12570a interfaceC12570a) {
        f35277q = interfaceC12570a;
    }

    /* renamed from: ok */
    public void m17393ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(C12415n.f34990ok) || !C12415n.f34990ok.equals(downloadInfo.getMimeType())) {
            return;
        }
        m17391ok(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), m17407h());
    }

    /* renamed from: s */
    public void m17389s() {
        m17400ok(2, true);
    }

    /* renamed from: ok */
    private void m17391ok(DownloadInfo downloadInfo, boolean z, int i) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        C12571ok m17412a = m17412a(downloadInfo.getId());
        if (m17412a.f35301q > m17412a.f35293bl) {
            C12409ok.m17894s("RetryScheduler", "tryStartScheduleRetry, id = " + m17412a.f35299ok + ", mRetryCount = " + m17412a.f35301q + ", maxCount = " + m17412a.f35293bl);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!C12713kf.m16528p(failedException) && !C12713kf.m16525q(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!m17398ok(m17412a, errorCode)) {
                return;
            }
            C12409ok.m17901bl("RetryScheduler", "allow error code, id = " + m17412a.f35299ok + ", error code = " + errorCode);
        }
        m17412a.f35296k = z;
        synchronized (this.f35284s) {
            if (!m17412a.f35295j) {
                m17412a.f35295j = true;
                this.f35280h++;
            }
        }
        int m17376s = m17412a.m17376s();
        C12409ok.m17901bl("RetryScheduler", "tryStartScheduleRetry: id = " + m17412a.f35299ok + ", delayTimeMills = " + m17376s + ", mWaitingRetryTasks = " + this.f35280h);
        if (!m17412a.f35297kf) {
            if (z) {
                return;
            }
            this.f35279bl.removeMessages(downloadInfo.getId());
            this.f35279bl.sendEmptyMessageDelayed(downloadInfo.getId(), m17376s);
            return;
        }
        if (i == 0) {
            m17412a.m17382bl();
        }
        InterfaceC12570a interfaceC12570a = f35277q;
        if (interfaceC12570a != null) {
            interfaceC12570a.mo17386ok(downloadInfo, m17376s, z, i);
        }
        if (this.f35282n) {
            m17412a.m17380ok(System.currentTimeMillis());
            m17412a.m17385a();
            m17412a.m17381ok();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17400ok(int i, boolean z) {
        if (this.f35280h <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.f35281kf < 10000) {
                    return;
                }
            }
            this.f35281kf = currentTimeMillis;
            C12409ok.m17901bl("RetryScheduler", "scheduleAllTaskRetry, level = [" + i + "], force = [" + z + "]");
            if (z) {
                this.f35279bl.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i;
            obtain.arg2 = z ? 1 : 0;
            this.f35279bl.sendMessageDelayed(obtain, 2000L);
        }
    }

    /* renamed from: ok */
    public void m17402ok(final int i) {
        C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.td.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C12565td c12565td = C12565td.this;
                    c12565td.m17401ok(i, c12565td.m17407h(), true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17401ok(int i, int i2, boolean z) {
        InterfaceC12518td reserveWifiStatusListener;
        boolean z2;
        Context context = this.f35278a;
        if (context == null) {
            return;
        }
        synchronized (this.f35284s) {
            C12571ok c12571ok = this.f35284s.get(i);
            if (c12571ok == null) {
                return;
            }
            boolean z3 = true;
            if (c12571ok.f35295j) {
                c12571ok.f35295j = false;
                int i3 = this.f35280h - 1;
                this.f35280h = i3;
                if (i3 < 0) {
                    this.f35280h = 0;
                }
            }
            C12409ok.m17901bl("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + c12571ok.f35301q + ", mWaitingRetryTasksCount = " + this.f35280h);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            if (downloadInfo == null) {
                m17409bl(i);
                return;
            }
            C12409ok.m17900n("RetryScheduler", "doSchedulerRetryInSubThread，id:" + i);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(C12490bl.m17807l()).getReserveWifiStatusListener()) != null) {
                        reserveWifiStatusListener.mo17627ok(downloadInfo, 4, 3);
                    }
                    InterfaceC12500j m17747y = C12490bl.m17747y();
                    if (m17747y != null) {
                        m17747y.mo17736ok(Collections.singletonList(downloadInfo), 3);
                    }
                    m17409bl(i);
                    return;
                } else if (realStatus != -1) {
                    return;
                } else {
                    if (i2 != 0) {
                        z2 = true;
                    } else if (!c12571ok.f35297kf) {
                        return;
                    } else {
                        z2 = false;
                    }
                    BaseException failedException = downloadInfo.getFailedException();
                    if (z2 && C12713kf.m16528p(failedException)) {
                        z2 = m17392ok(downloadInfo, failedException);
                    }
                    c12571ok.m17385a();
                    if (z2) {
                        C12409ok.m17901bl("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + c12571ok.f35299ok);
                        c12571ok.m17380ok(System.currentTimeMillis());
                        if (z) {
                            c12571ok.m17381ok();
                        }
                        downloadInfo.setRetryScheduleCount(c12571ok.f35301q);
                        if (downloadInfo.getStatus() == -1) {
                            Downloader.getInstance(context).restart(downloadInfo.getId());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        c12571ok.m17381ok();
                    }
                    if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                        z3 = false;
                    }
                    m17391ok(downloadInfo, z3, i2);
                    return;
                }
            }
            m17409bl(i);
        }
    }

    /* renamed from: ok */
    private boolean m17398ok(C12571ok c12571ok, int i) {
        int[] iArr = c12571ok.f35294h;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ok */
    private int[] m17390ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                iArr[i] = Integer.parseInt(split[i]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: ok */
    private boolean m17392ok(DownloadInfo downloadInfo, BaseException baseException) {
        long j;
        long totalBytes;
        try {
            j = C12713kf.m16518s(downloadInfo.getTempPath());
        } catch (BaseException e) {
            e.printStackTrace();
            j = 0;
        }
        if (baseException instanceof C12533s) {
            totalBytes = ((C12533s) baseException).m17612a();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (j < totalBytes) {
            C12534ok m17599ok = C12534ok.m17599ok(downloadInfo.getId());
            if (m17599ok.m17593ok("space_fill_part_download", 0) == 1) {
                if (j > 0) {
                    int m17593ok = m17599ok.m17593ok("space_fill_min_keep_mb", 100);
                    if (m17593ok > 0) {
                        long j2 = j - (m17593ok * 1048576);
                        C12409ok.m17901bl("RetryScheduler", "retry schedule: available = " + C12713kf.m16570ok(j) + "MB, minKeep = " + m17593ok + "MB, canDownload = " + C12713kf.m16570ok(j2) + "MB");
                        if (j2 <= 0) {
                            C12409ok.m17894s("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (m17599ok.m17593ok("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }
}
