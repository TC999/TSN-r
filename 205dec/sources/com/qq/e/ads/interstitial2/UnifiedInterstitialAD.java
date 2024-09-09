package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {

    /* renamed from: g  reason: collision with root package name */
    private AtomicInteger f41511g;

    /* renamed from: h  reason: collision with root package name */
    private AtomicInteger f41512h;

    /* renamed from: i  reason: collision with root package name */
    private volatile VideoOption f41513i;

    /* renamed from: j  reason: collision with root package name */
    private volatile int f41514j;

    /* renamed from: k  reason: collision with root package name */
    private volatile int f41515k;

    /* renamed from: l  reason: collision with root package name */
    private volatile LoadAdParams f41516l;

    /* renamed from: m  reason: collision with root package name */
    private UnifiedInterstitialADListener f41517m;

    /* renamed from: n  reason: collision with root package name */
    private ServerSideVerificationOptions f41518n;

    /* renamed from: o  reason: collision with root package name */
    private final ADListenerAdapter f41519o;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f41511g = new AtomicInteger(0);
        this.f41512h = new AtomicInteger(0);
        this.f41517m = unifiedInterstitialADListener;
        this.f41519o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.f41511g = new AtomicInteger(0);
        this.f41512h = new AtomicInteger(0);
        this.f41517m = unifiedInterstitialADListener;
        this.f41519o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.f41519o);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ void a(Object obj) {
        UIADI uiadi = (UIADI) obj;
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i4) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.f41517m;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i4));
        }
    }

    protected void c() {
        setVideoOption(this.f41513i);
        setMinVideoDuration(this.f41514j);
        setMaxVideoDuration(this.f41515k);
        setLoadAdParams(this.f41516l);
        setServerSideVerificationOptions(this.f41518n);
        while (this.f41511g.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f41512h.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void close() {
        Object obj = this.f41434a;
        if (obj != null) {
            ((UIADI) obj).close();
        }
    }

    public void destroy() {
        Object obj = this.f41434a;
        if (obj != null) {
            ((UIADI) obj).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((UIADI) obj).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((UIADI) obj).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((UIADI) obj).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f41511g.incrementAndGet();
                return;
            }
            Object obj = this.f41434a;
            if (obj != null) {
                ((UIADI) obj).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.f41512h.incrementAndGet();
                return;
            }
            Object obj = this.f41434a;
            if (obj != null) {
                ((UIADI) obj).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f41516l = loadAdParams;
        Object obj = this.f41434a;
        if (obj != null) {
            ((UIADI) obj).setLoadAdParams(this.f41516l);
        }
    }

    public void setMaxVideoDuration(int i4) {
        this.f41515k = i4;
        if (this.f41515k > 0 && this.f41514j > this.f41515k) {
            GDTLogger.e("maxVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5c0f\u4e8eminVideoDuration");
        }
        Object obj = this.f41434a;
        if (obj != null) {
            ((UIADI) obj).setMaxVideoDuration(i4);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f41519o.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i4) {
        this.f41514j = i4;
        if (this.f41515k > 0 && this.f41514j > this.f41515k) {
            GDTLogger.e("minVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5927\u4e8emaxVideoDuration");
        }
        Object obj = this.f41434a;
        if (obj != null) {
            ((UIADI) obj).setMinVideoDuration(i4);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f41519o.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f41519o.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f41518n = serverSideVerificationOptions;
        Object obj = this.f41434a;
        if (obj != null) {
            ((UIADI) obj).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f41513i = videoOption;
        Object obj = this.f41434a;
        if (obj != null) {
            ((UIADI) obj).setVideoOption(videoOption);
        }
    }

    public void show() {
        Object obj = this.f41434a;
        if (obj != null) {
            ((UIADI) obj).show();
        } else {
            a("show");
        }
    }

    public void show(Activity activity) {
        Object obj = this.f41434a;
        if (obj != null) {
            ((UIADI) obj).show(activity);
        } else {
            a("show");
        }
    }

    public void showFullScreenAD(Activity activity) {
        Object obj = this.f41434a;
        if (obj != null) {
            ((UIADI) obj).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }
}
