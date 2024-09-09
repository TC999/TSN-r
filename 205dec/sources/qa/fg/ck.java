package qa.fg;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.qq.e.mediation.interfaces.BaseBannerAd;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import com.qq.e.mediation.interfaces.BaseSplashAd;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class ck {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f62015a = new Handler(Looper.getMainLooper());

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseBannerAd f62016c;

        a(BaseBannerAd baseBannerAd) {
            this.f62016c = baseBannerAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f62016c.loadAD();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseNativeUnifiedAd f62017c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f62018d;

        b(BaseNativeUnifiedAd baseNativeUnifiedAd, int i4) {
            this.f62017c = baseNativeUnifiedAd;
            this.f62018d = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f62017c.loadData(this.f62018d);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseRewardAd f62019c;

        c(BaseRewardAd baseRewardAd) {
            this.f62019c = baseRewardAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f62019c.loadAD();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f62020c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BaseRewardAd f62021d;

        d(Activity activity, BaseRewardAd baseRewardAd) {
            this.f62020c = activity;
            this.f62021d = baseRewardAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity = this.f62020c;
            if (activity != null) {
                this.f62021d.showAD(activity);
            } else {
                this.f62021d.showAD();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseInterstitialAd f62022c;

        e(BaseInterstitialAd baseInterstitialAd) {
            this.f62022c = baseInterstitialAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f62022c.loadAd();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class f implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f62023c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BaseInterstitialAd f62024d;

        f(Activity activity, BaseInterstitialAd baseInterstitialAd) {
            this.f62023c = activity;
            this.f62024d = baseInterstitialAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity = this.f62023c;
            if (activity != null) {
                this.f62024d.show(activity);
            } else {
                this.f62024d.show();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class g implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseInterstitialAd f62025c;

        g(BaseInterstitialAd baseInterstitialAd) {
            this.f62025c = baseInterstitialAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f62025c.loadFullScreenAD();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class h implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseInterstitialAd f62026c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Activity f62027d;

        h(BaseInterstitialAd baseInterstitialAd, Activity activity) {
            this.f62026c = baseInterstitialAd;
            this.f62027d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f62026c.showFullScreenAD(this.f62027d);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class i implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseSplashAd f62028c;

        i(BaseSplashAd baseSplashAd) {
            this.f62028c = baseSplashAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f62028c.fetchAdOnly();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class j implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseSplashAd f62029c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ViewGroup f62030d;

        j(BaseSplashAd baseSplashAd, ViewGroup viewGroup) {
            this.f62029c = baseSplashAd;
            this.f62030d = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f62029c.showAd(this.f62030d);
        }
    }

    public static void a(BaseNativeUnifiedAd baseNativeUnifiedAd, int i4) {
        f62015a.postAtFrontOfQueue(new b(baseNativeUnifiedAd, i4));
    }

    public static void b(BaseInterstitialAd baseInterstitialAd) {
        f62015a.postAtFrontOfQueue(new e(baseInterstitialAd));
    }

    public static void a(BaseRewardAd baseRewardAd) {
        f62015a.postAtFrontOfQueue(new c(baseRewardAd));
    }

    public static void b(BaseInterstitialAd baseInterstitialAd, Activity activity) {
        f62015a.postAtFrontOfQueue(new f(activity, baseInterstitialAd));
    }

    public static void a(BaseRewardAd baseRewardAd, Activity activity) {
        f62015a.postAtFrontOfQueue(new d(activity, baseRewardAd));
    }

    public static void a(BaseInterstitialAd baseInterstitialAd) {
        f62015a.postAtFrontOfQueue(new g(baseInterstitialAd));
    }

    public static void a(BaseInterstitialAd baseInterstitialAd, Activity activity) {
        f62015a.postAtFrontOfQueue(new h(baseInterstitialAd, activity));
    }

    public static void a(BaseSplashAd baseSplashAd) {
        f62015a.postAtFrontOfQueue(new i(baseSplashAd));
    }

    public static void a(BaseSplashAd baseSplashAd, ViewGroup viewGroup) {
        f62015a.postAtFrontOfQueue(new j(baseSplashAd, viewGroup));
    }

    public static void a(BaseBannerAd baseBannerAd) {
        f62015a.postAtFrontOfQueue(new a(baseBannerAd));
    }
}
