package com.beizi.p051ad.internal;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.nativead.NativeAdRequestImpl;
import com.beizi.p051ad.internal.nativead.NativeAdRequestManagerImpl;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.view.BannerAdViewImpl;
import com.beizi.p051ad.internal.view.InterstitialAdViewImpl;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.beizi.ad.internal.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdFetcher {

    /* renamed from: a */
    private ScheduledExecutorService f10064a;

    /* renamed from: f */
    private final Ad f10069f;

    /* renamed from: g */
    private RequestManager f10070g;

    /* renamed from: b */
    private int f10065b = -1;

    /* renamed from: d */
    private long f10067d = -1;

    /* renamed from: e */
    private long f10068e = -1;

    /* renamed from: h */
    private EnumC2879c f10071h = EnumC2879c.STOPPED;

    /* renamed from: c */
    private final HandlerC2878b f10066c = new HandlerC2878b(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdFetcher.java */
    /* renamed from: com.beizi.ad.internal.d$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C28761 {

        /* renamed from: a */
        static final /* synthetic */ int[] f10072a;

        /* renamed from: b */
        static final /* synthetic */ int[] f10073b;

        static {
            int[] iArr = new int[EnumC2888k.values().length];
            f10073b = iArr;
            try {
                iArr[EnumC2888k.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10073b[EnumC2888k.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10073b[EnumC2888k.SPLASH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10073b[EnumC2888k.NATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10073b[EnumC2888k.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[EnumC2879c.values().length];
            f10072a = iArr2;
            try {
                iArr2[EnumC2879c.STOPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10072a[EnumC2879c.SINGLE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10072a[EnumC2879c.AUTO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdFetcher.java */
    /* renamed from: com.beizi.ad.internal.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC2877a implements Runnable {
        private RunnableC2877a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HaoboLog.m49286v(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.handler_message_pass));
            AdFetcher.this.f10066c.sendEmptyMessage(0);
        }

        /* synthetic */ RunnableC2877a(AdFetcher adFetcher, C28761 c28761) {
            this();
        }
    }

    /* compiled from: AdFetcher.java */
    /* renamed from: com.beizi.ad.internal.d$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class HandlerC2878b extends Handler {

        /* renamed from: a */
        private final AdFetcher f10075a;

        HandlerC2878b(AdFetcher adFetcher) {
            this.f10075a = adFetcher;
        }

        @Override // android.os.Handler
        @SuppressLint({"NewApi"})
        public synchronized void handleMessage(Message message) {
            AdFetcher adFetcher = this.f10075a;
            if (adFetcher != null && adFetcher.f10069f.isReadyToStart()) {
                if (adFetcher.f10067d != -1) {
                    HaoboLog.m49292d(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.new_ad_since, Math.max(0, (int) (System.currentTimeMillis() - adFetcher.f10067d))));
                }
                adFetcher.f10067d = System.currentTimeMillis();
                int i = C28761.f10073b[adFetcher.f10069f.getMediaType().ordinal()];
                if (i == 1) {
                    adFetcher.f10070g = new AdViewRequestManagerImpl((BannerAdViewImpl) adFetcher.f10069f);
                } else if (i == 2) {
                    adFetcher.f10070g = new AdViewRequestManagerImpl((InterstitialAdViewImpl) adFetcher.f10069f);
                } else if (i == 3) {
                    adFetcher.f10070g = new AdViewRequestManagerImpl((BannerAdViewImpl) adFetcher.f10069f);
                } else if (i == 4) {
                    adFetcher.f10070g = new NativeAdRequestManagerImpl((NativeAdRequestImpl) adFetcher.f10069f);
                } else if (i == 5) {
                    adFetcher.f10070g = new PrefetchAdRequestManagerImpl();
                }
                adFetcher.f10070g.mo49374a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdFetcher.java */
    /* renamed from: com.beizi.ad.internal.d$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2879c {
        STOPPED,
        SINGLE_REQUEST,
        AUTO_REFRESH
    }

    public AdFetcher(Ad ad) {
        this.f10069f = ad;
    }

    /* renamed from: e */
    private void m49528e() {
        ScheduledExecutorService scheduledExecutorService = this.f10064a;
        if (scheduledExecutorService == null) {
            return;
        }
        scheduledExecutorService.shutdownNow();
        try {
            this.f10064a.awaitTermination(this.f10065b, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            this.f10064a = null;
            throw th;
        }
        this.f10064a = null;
    }

    /* renamed from: d */
    private void m49530d() {
        if (this.f10064a == null) {
            this.f10064a = Executors.newScheduledThreadPool(4);
        }
    }

    /* renamed from: b */
    public void m49534b() {
        HaoboLog.m49292d(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.start));
        m49530d();
        int i = C28761.f10072a[this.f10071h.ordinal()];
        long j = 0;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            HaoboLog.m49286v(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.fetcher_start_single));
            this.f10064a.schedule(new RunnableC2877a(this, null), 0L, TimeUnit.SECONDS);
        } else if (this.f10065b <= 0) {
            HaoboLog.m49286v(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.fetcher_start_single));
            this.f10064a.schedule(new RunnableC2877a(this, null), 0L, TimeUnit.SECONDS);
            this.f10071h = EnumC2879c.SINGLE_REQUEST;
        } else {
            HaoboLog.m49286v(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.fetcher_start_auto));
            int i2 = this.f10065b;
            long j2 = this.f10068e;
            if (j2 != -1) {
                long j3 = this.f10067d;
                if (j3 != -1) {
                    long j4 = i2;
                    j = Math.min(j4, Math.max(0L, j4 - (j2 - j3)));
                }
            }
            long j5 = j;
            HaoboLog.m49286v(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.request_delayed_by_x_ms, j5));
            this.f10064a.scheduleAtFixedRate(new RunnableC2877a(this, null), j5, i2, TimeUnit.MILLISECONDS);
            this.f10071h = EnumC2879c.AUTO_REFRESH;
        }
    }

    /* renamed from: c */
    public void m49532c() {
        this.f10067d = -1L;
        this.f10068e = -1L;
    }

    /* renamed from: a */
    public void m49538a(int i) {
        boolean z = this.f10065b != i;
        this.f10065b = i;
        if (!z || this.f10071h.equals(EnumC2879c.STOPPED)) {
            return;
        }
        String str = HaoboLog.baseLogTag;
        HaoboLog.m49292d(str, "AdFetcher refresh mPeriod changed to " + this.f10065b);
        HaoboLog.m49292d(HaoboLog.baseLogTag, "Resetting AdFetcher");
        m49539a();
        m49534b();
    }

    /* renamed from: a */
    public void m49539a() {
        RequestManager requestManager = this.f10070g;
        if (requestManager != null) {
            requestManager.mo49368e();
            this.f10070g = null;
        }
        m49528e();
        HaoboLog.m49292d(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.stop));
        this.f10068e = System.currentTimeMillis();
        this.f10071h = EnumC2879c.STOPPED;
    }
}
