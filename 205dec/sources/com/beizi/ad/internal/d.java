package com.beizi.ad.internal;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.beizi.ad.R;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.view.BannerAdViewImpl;
import com.beizi.ad.internal.view.InterstitialAdViewImpl;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdFetcher.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private ScheduledExecutorService f13741a;

    /* renamed from: f  reason: collision with root package name */
    private final com.beizi.ad.internal.a f13746f;

    /* renamed from: g  reason: collision with root package name */
    private m f13747g;

    /* renamed from: b  reason: collision with root package name */
    private int f13742b = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f13744d = -1;

    /* renamed from: e  reason: collision with root package name */
    private long f13745e = -1;

    /* renamed from: h  reason: collision with root package name */
    private c f13748h = c.STOPPED;

    /* renamed from: c  reason: collision with root package name */
    private final b f13743c = new b(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdFetcher.java */
    /* renamed from: com.beizi.ad.internal.d$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13749a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f13750b;

        static {
            int[] iArr = new int[k.values().length];
            f13750b = iArr;
            try {
                iArr[k.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13750b[k.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13750b[k.SPLASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13750b[k.NATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13750b[k.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[c.values().length];
            f13749a = iArr2;
            try {
                iArr2[c.STOPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13749a[c.SINGLE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13749a[c.AUTO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdFetcher.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.handler_message_pass));
            d.this.f13743c.sendEmptyMessage(0);
        }

        /* synthetic */ a(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdFetcher.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final d f13752a;

        b(d dVar) {
            this.f13752a = dVar;
        }

        @Override // android.os.Handler
        @SuppressLint({"NewApi"})
        public synchronized void handleMessage(Message message) {
            d dVar = this.f13752a;
            if (dVar != null && dVar.f13746f.isReadyToStart()) {
                if (dVar.f13744d != -1) {
                    HaoboLog.d(HaoboLog.baseLogTag, HaoboLog.getString(R.string.new_ad_since, Math.max(0, (int) (System.currentTimeMillis() - dVar.f13744d))));
                }
                dVar.f13744d = System.currentTimeMillis();
                int i4 = AnonymousClass1.f13750b[dVar.f13746f.getMediaType().ordinal()];
                if (i4 == 1) {
                    dVar.f13747g = new g((BannerAdViewImpl) dVar.f13746f);
                } else if (i4 == 2) {
                    dVar.f13747g = new g((InterstitialAdViewImpl) dVar.f13746f);
                } else if (i4 == 3) {
                    dVar.f13747g = new g((BannerAdViewImpl) dVar.f13746f);
                } else if (i4 == 4) {
                    dVar.f13747g = new com.beizi.ad.internal.nativead.c((com.beizi.ad.internal.nativead.b) dVar.f13746f);
                } else if (i4 == 5) {
                    dVar.f13747g = new l();
                }
                dVar.f13747g.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdFetcher.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum c {
        STOPPED,
        SINGLE_REQUEST,
        AUTO_REFRESH
    }

    public d(com.beizi.ad.internal.a aVar) {
        this.f13746f = aVar;
    }

    private void e() {
        ScheduledExecutorService scheduledExecutorService = this.f13741a;
        if (scheduledExecutorService == null) {
            return;
        }
        scheduledExecutorService.shutdownNow();
        try {
            this.f13741a.awaitTermination(this.f13742b, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            this.f13741a = null;
            throw th;
        }
        this.f13741a = null;
    }

    private void d() {
        if (this.f13741a == null) {
            this.f13741a = Executors.newScheduledThreadPool(4);
        }
    }

    public void b() {
        HaoboLog.d(HaoboLog.baseLogTag, HaoboLog.getString(R.string.start));
        d();
        int i4 = AnonymousClass1.f13749a[this.f13748h.ordinal()];
        long j4 = 0;
        if (i4 != 1) {
            if (i4 != 2) {
                return;
            }
            HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.fetcher_start_single));
            this.f13741a.schedule(new a(this, null), 0L, TimeUnit.SECONDS);
        } else if (this.f13742b <= 0) {
            HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.fetcher_start_single));
            this.f13741a.schedule(new a(this, null), 0L, TimeUnit.SECONDS);
            this.f13748h = c.SINGLE_REQUEST;
        } else {
            HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.fetcher_start_auto));
            int i5 = this.f13742b;
            long j5 = this.f13745e;
            if (j5 != -1) {
                long j6 = this.f13744d;
                if (j6 != -1) {
                    long j7 = i5;
                    j4 = Math.min(j7, Math.max(0L, j7 - (j5 - j6)));
                }
            }
            long j8 = j4;
            HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.request_delayed_by_x_ms, j8));
            this.f13741a.scheduleAtFixedRate(new a(this, null), j8, i5, TimeUnit.MILLISECONDS);
            this.f13748h = c.AUTO_REFRESH;
        }
    }

    public void c() {
        this.f13744d = -1L;
        this.f13745e = -1L;
    }

    public void a(int i4) {
        boolean z3 = this.f13742b != i4;
        this.f13742b = i4;
        if (!z3 || this.f13748h.equals(c.STOPPED)) {
            return;
        }
        String str = HaoboLog.baseLogTag;
        HaoboLog.d(str, "AdFetcher refresh mPeriod changed to " + this.f13742b);
        HaoboLog.d(HaoboLog.baseLogTag, "Resetting AdFetcher");
        a();
        b();
    }

    public void a() {
        m mVar = this.f13747g;
        if (mVar != null) {
            mVar.e();
            this.f13747g = null;
        }
        e();
        HaoboLog.d(HaoboLog.baseLogTag, HaoboLog.getString(R.string.stop));
        this.f13745e = System.currentTimeMillis();
        this.f13748h = c.STOPPED;
    }
}
