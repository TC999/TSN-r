package com.ss.android.socialbase.downloader.impls;

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
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class td implements Handler.Callback, ok.InterfaceC1022ok {
    private static volatile td ok;

    /* renamed from: q  reason: collision with root package name */
    private static a f49805q;
    private long kf;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f49808n;

    /* renamed from: p  reason: collision with root package name */
    private ConnectivityManager f49809p;
    private final Handler bl = new Handler(Looper.getMainLooper(), this);

    /* renamed from: s  reason: collision with root package name */
    private final SparseArray<ok> f49810s = new SparseArray<>();

    /* renamed from: h  reason: collision with root package name */
    private int f49807h = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Context f49806a = com.ss.android.socialbase.downloader.downloader.bl.l();

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void ok(DownloadInfo downloadInfo, long j4, boolean z3, int i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        final int f49813a;
        final int bl;

        /* renamed from: h  reason: collision with root package name */
        final int[] f49814h;

        /* renamed from: j  reason: collision with root package name */
        private boolean f49815j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f49816k;
        final boolean kf;

        /* renamed from: n  reason: collision with root package name */
        final int f49817n;
        final int ok;

        /* renamed from: p  reason: collision with root package name */
        private int f49818p;

        /* renamed from: q  reason: collision with root package name */
        private int f49819q;

        /* renamed from: r  reason: collision with root package name */
        private long f49820r;

        /* renamed from: s  reason: collision with root package name */
        final int f49821s;

        ok(int i4, int i5, int i6, int i7, int i8, boolean z3, int[] iArr) {
            i7 = i7 < 3000 ? 3000 : i7;
            i8 = i8 < 5000 ? 5000 : i8;
            this.ok = i4;
            this.f49813a = i5;
            this.bl = i6;
            this.f49821s = i7;
            this.f49817n = i8;
            this.kf = z3;
            this.f49814h = iArr;
            this.f49818p = i7;
        }

        void bl() {
            this.f49818p = this.f49821s;
        }

        int s() {
            return this.f49818p;
        }

        synchronized void a() {
            this.f49819q++;
        }

        boolean ok(long j4, int i4, int i5, boolean z3) {
            if (!this.f49815j) {
                com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.f49813a >= i4 && this.f49819q < this.bl) {
                if (!this.f49816k || i5 == 2) {
                    return z3 || j4 - this.f49820r >= ((long) this.f49821s);
                }
                return false;
            } else {
                return false;
            }
        }

        synchronized void ok() {
            this.f49818p += this.f49817n;
        }

        synchronized void ok(long j4) {
            this.f49820r = j4;
        }
    }

    private td() {
        kf();
        this.f49808n = com.ss.android.socialbase.downloader.q.kf.bl();
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
        try {
            if (this.f49809p == null) {
                this.f49809p = (ConnectivityManager) StubApp.getOrigApplicationContext(this.f49806a.getApplicationContext()).getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.f49809p.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private void kf() {
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.td.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (td.this.f49806a == null || Build.VERSION.SDK_INT < 21) {
                        return;
                    }
                    td tdVar = td.this;
                    tdVar.f49809p = (ConnectivityManager) StubApp.getOrigApplicationContext(tdVar.f49806a.getApplicationContext()).getSystemService("connectivity");
                    td.this.f49809p.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.td.1.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            com.ss.android.socialbase.downloader.bl.ok.a("RetryScheduler", "network onAvailable: ");
                            td.this.ok(1, true);
                        }
                    });
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            a(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            ok(message.what);
        }
        return true;
    }

    private void a(final int i4, final boolean z3) {
        com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.td.2
            @Override // java.lang.Runnable
            public void run() {
                int h4;
                try {
                    if (td.this.f49807h > 0 && (h4 = td.this.h()) != 0) {
                        com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + td.this.f49807h);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<ok> arrayList = new ArrayList();
                        synchronized (td.this.f49810s) {
                            for (int i5 = 0; i5 < td.this.f49810s.size(); i5++) {
                                ok okVar = (ok) td.this.f49810s.valueAt(i5);
                                if (okVar != null && okVar.ok(currentTimeMillis, i4, h4, z3)) {
                                    if (z3) {
                                        okVar.bl();
                                    }
                                    arrayList.add(okVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            for (ok okVar2 : arrayList) {
                                td.this.ok(okVar2.ok, h4, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private void bl(int i4) {
        synchronized (this.f49810s) {
            this.f49810s.remove(i4);
        }
    }

    private ok s(int i4) {
        int[] iArr;
        int i5;
        int i6;
        boolean z3;
        com.ss.android.socialbase.downloader.h.ok ok2 = com.ss.android.socialbase.downloader.h.ok.ok(i4);
        boolean z4 = false;
        int ok3 = ok2.ok("retry_schedule", 0);
        JSONObject s3 = ok2.s("retry_schedule_config");
        int i7 = 60;
        if (s3 != null) {
            int optInt = s3.optInt("max_count", 60);
            int optInt2 = s3.optInt("interval_sec", 60);
            int optInt3 = s3.optInt("interval_sec_acceleration", 60);
            if (Build.VERSION.SDK_INT >= 21 && f49805q != null && s3.optInt("use_job_scheduler", 0) == 1) {
                z4 = true;
            }
            iArr = ok(s3.optString("allow_error_code"));
            i5 = optInt3;
            z3 = z4;
            i6 = optInt;
            i7 = optInt2;
        } else {
            iArr = null;
            i5 = 60;
            i6 = 60;
            z3 = false;
        }
        return new ok(i4, ok3, i6, i7 * 1000, i5 * 1000, z3, iArr);
    }

    public void n() {
        ok(5, false);
    }

    private ok a(int i4) {
        ok okVar = this.f49810s.get(i4);
        if (okVar == null) {
            synchronized (this.f49810s) {
                okVar = this.f49810s.get(i4);
                if (okVar == null) {
                    okVar = s(i4);
                }
                this.f49810s.put(i4, okVar);
            }
        }
        return okVar;
    }

    public static td ok() {
        if (ok == null) {
            synchronized (td.class) {
                if (ok == null) {
                    ok = new td();
                }
            }
        }
        return ok;
    }

    @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
    public void bl() {
        ok(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
    public void a() {
        ok(4, false);
    }

    public static void ok(a aVar) {
        f49805q = aVar;
    }

    public void ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.n.ok) || !com.ss.android.socialbase.downloader.constants.n.ok.equals(downloadInfo.getMimeType())) {
            return;
        }
        ok(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), h());
    }

    public void s() {
        ok(2, true);
    }

    private void ok(DownloadInfo downloadInfo, boolean z3, int i4) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        ok a4 = a(downloadInfo.getId());
        if (a4.f49819q > a4.bl) {
            com.ss.android.socialbase.downloader.bl.ok.s("RetryScheduler", "tryStartScheduleRetry, id = " + a4.ok + ", mRetryCount = " + a4.f49819q + ", maxCount = " + a4.bl);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.ss.android.socialbase.downloader.q.kf.p(failedException) && !com.ss.android.socialbase.downloader.q.kf.q(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!ok(a4, errorCode)) {
                return;
            }
            com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "allow error code, id = " + a4.ok + ", error code = " + errorCode);
        }
        a4.f49816k = z3;
        synchronized (this.f49810s) {
            if (!a4.f49815j) {
                a4.f49815j = true;
                this.f49807h++;
            }
        }
        int s3 = a4.s();
        com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "tryStartScheduleRetry: id = " + a4.ok + ", delayTimeMills = " + s3 + ", mWaitingRetryTasks = " + this.f49807h);
        if (!a4.kf) {
            if (z3) {
                return;
            }
            this.bl.removeMessages(downloadInfo.getId());
            this.bl.sendEmptyMessageDelayed(downloadInfo.getId(), s3);
            return;
        }
        if (i4 == 0) {
            a4.bl();
        }
        a aVar = f49805q;
        if (aVar != null) {
            aVar.ok(downloadInfo, s3, z3, i4);
        }
        if (this.f49808n) {
            a4.ok(System.currentTimeMillis());
            a4.a();
            a4.ok();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, boolean z3) {
        if (this.f49807h <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z3) {
                if (currentTimeMillis - this.kf < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    return;
                }
            }
            this.kf = currentTimeMillis;
            com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "scheduleAllTaskRetry, level = [" + i4 + "], force = [" + z3 + "]");
            if (z3) {
                this.bl.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i4;
            obtain.arg2 = z3 ? 1 : 0;
            this.bl.sendMessageDelayed(obtain, 2000L);
        }
    }

    public void ok(final int i4) {
        com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.td.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    td tdVar = td.this;
                    tdVar.ok(i4, tdVar.h(), true);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, int i5, boolean z3) {
        com.ss.android.socialbase.downloader.downloader.td reserveWifiStatusListener;
        boolean z4;
        Context context = this.f49806a;
        if (context == null) {
            return;
        }
        synchronized (this.f49810s) {
            ok okVar = this.f49810s.get(i4);
            if (okVar == null) {
                return;
            }
            boolean z5 = true;
            if (okVar.f49815j) {
                okVar.f49815j = false;
                int i6 = this.f49807h - 1;
                this.f49807h = i6;
                if (i6 < 0) {
                    this.f49807h = 0;
                }
            }
            com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i4 + ", retryCount = " + okVar.f49819q + ", mWaitingRetryTasksCount = " + this.f49807h);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i4);
            if (downloadInfo == null) {
                bl(i4);
                return;
            }
            com.ss.android.socialbase.downloader.bl.ok.n("RetryScheduler", "doSchedulerRetryInSubThread\uff0cid:" + i4);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getReserveWifiStatusListener()) != null) {
                        reserveWifiStatusListener.ok(downloadInfo, 4, 3);
                    }
                    com.ss.android.socialbase.downloader.downloader.j y3 = com.ss.android.socialbase.downloader.downloader.bl.y();
                    if (y3 != null) {
                        y3.ok(Collections.singletonList(downloadInfo), 3);
                    }
                    bl(i4);
                    return;
                } else if (realStatus != -1) {
                    return;
                } else {
                    if (i5 != 0) {
                        z4 = true;
                    } else if (!okVar.kf) {
                        return;
                    } else {
                        z4 = false;
                    }
                    BaseException failedException = downloadInfo.getFailedException();
                    if (z4 && com.ss.android.socialbase.downloader.q.kf.p(failedException)) {
                        z4 = ok(downloadInfo, failedException);
                    }
                    okVar.a();
                    if (z4) {
                        com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + okVar.ok);
                        okVar.ok(System.currentTimeMillis());
                        if (z3) {
                            okVar.ok();
                        }
                        downloadInfo.setRetryScheduleCount(okVar.f49819q);
                        if (downloadInfo.getStatus() == -1) {
                            Downloader.getInstance(context).restart(downloadInfo.getId());
                            return;
                        }
                        return;
                    }
                    if (z3) {
                        okVar.ok();
                    }
                    if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                        z5 = false;
                    }
                    ok(downloadInfo, z5, i5);
                    return;
                }
            }
            bl(i4);
        }
    }

    private boolean ok(ok okVar, int i4) {
        int[] iArr = okVar.f49814h;
        if (iArr != null && iArr.length != 0) {
            for (int i5 : iArr) {
                if (i5 == i4) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i4 = 0; i4 < split.length; i4++) {
                iArr[i4] = Integer.parseInt(split[i4]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean ok(DownloadInfo downloadInfo, BaseException baseException) {
        long j4;
        long totalBytes;
        try {
            j4 = com.ss.android.socialbase.downloader.q.kf.s(downloadInfo.getTempPath());
        } catch (BaseException e4) {
            e4.printStackTrace();
            j4 = 0;
        }
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.s) {
            totalBytes = ((com.ss.android.socialbase.downloader.exception.s) baseException).a();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (j4 < totalBytes) {
            com.ss.android.socialbase.downloader.h.ok ok2 = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
            if (ok2.ok("space_fill_part_download", 0) == 1) {
                if (j4 > 0) {
                    int ok3 = ok2.ok("space_fill_min_keep_mb", 100);
                    if (ok3 > 0) {
                        long j5 = j4 - (ok3 * 1048576);
                        com.ss.android.socialbase.downloader.bl.ok.bl("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.q.kf.ok(j4) + "MB, minKeep = " + ok3 + "MB, canDownload = " + com.ss.android.socialbase.downloader.q.kf.ok(j5) + "MB");
                        if (j5 <= 0) {
                            com.ss.android.socialbase.downloader.bl.ok.s("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (ok2.ok("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }
}
