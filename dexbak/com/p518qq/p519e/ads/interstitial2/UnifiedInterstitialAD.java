package com.p518qq.p519e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.p518qq.p519e.ads.LiteAbstractAD;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.constants.LoadAdParams;
import com.p518qq.p519e.comm.listeners.ADRewardListener;
import com.p518qq.p519e.comm.listeners.NegativeFeedbackListener;
import com.p518qq.p519e.comm.p520pi.IReward;
import com.p518qq.p519e.comm.p520pi.NFBI;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.p520pi.UIADI;
import com.p518qq.p519e.comm.util.AdErrorConvertor;
import com.p518qq.p519e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qq.e.ads.interstitial2.UnifiedInterstitialAD */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {

    /* renamed from: g */
    private AtomicInteger f32796g;

    /* renamed from: h */
    private AtomicInteger f32797h;

    /* renamed from: i */
    private volatile VideoOption f32798i;

    /* renamed from: j */
    private volatile int f32799j;

    /* renamed from: k */
    private volatile int f32800k;

    /* renamed from: l */
    private volatile LoadAdParams f32801l;

    /* renamed from: m */
    private UnifiedInterstitialADListener f32802m;

    /* renamed from: n */
    private ServerSideVerificationOptions f32803n;

    /* renamed from: o */
    private final ADListenerAdapter f32804o;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f32796g = new AtomicInteger(0);
        this.f32797h = new AtomicInteger(0);
        this.f32802m = unifiedInterstitialADListener;
        this.f32804o = new ADListenerAdapter(unifiedInterstitialADListener);
        m20414a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.f32796g = new AtomicInteger(0);
        this.f32797h = new AtomicInteger(0);
        this.f32802m = unifiedInterstitialADListener;
        this.f32804o = new ADListenerAdapter(unifiedInterstitialADListener);
        m20413a(activity, str, str2);
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected Object mo20371a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.f32804o);
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected /* bridge */ /* synthetic */ void mo20368a(Object obj) {
        UIADI uiadi = (UIADI) obj;
        m20384c();
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: b */
    protected void mo20366b(int i) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.f32802m;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    /* renamed from: c */
    protected void m20384c() {
        setVideoOption(this.f32798i);
        setMinVideoDuration(this.f32799j);
        setMaxVideoDuration(this.f32800k);
        setLoadAdParams(this.f32801l);
        setServerSideVerificationOptions(this.f32803n);
        while (this.f32796g.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f32797h.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void close() {
        T t = this.f32719a;
        if (t != 0) {
            ((UIADI) t).close();
        }
    }

    public void destroy() {
        T t = this.f32719a;
        if (t != 0) {
            ((UIADI) t).destroy();
        } else {
            m20410a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.f32719a;
        if (t != 0) {
            return ((UIADI) t).getAdNetWorkName();
        }
        m20410a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t = this.f32719a;
        if (t != 0) {
            return ((UIADI) t).getAdPatternType();
        }
        m20410a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.f32719a;
        if (t != 0) {
            return ((UIADI) t).getVideoDuration();
        }
        m20410a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (m20416a()) {
            if (!m20409b()) {
                this.f32796g.incrementAndGet();
                return;
            }
            T t = this.f32719a;
            if (t != 0) {
                ((UIADI) t).loadAd();
            } else {
                m20410a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (m20416a()) {
            if (!m20409b()) {
                this.f32797h.incrementAndGet();
                return;
            }
            T t = this.f32719a;
            if (t != 0) {
                ((UIADI) t).loadFullScreenAD();
            } else {
                m20410a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f32801l = loadAdParams;
        T t = this.f32719a;
        if (t != 0) {
            ((UIADI) t).setLoadAdParams(this.f32801l);
        }
    }

    public void setMaxVideoDuration(int i) {
        this.f32800k = i;
        if (this.f32800k > 0 && this.f32799j > this.f32800k) {
            GDTLogger.m20307e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f32719a;
        if (t != 0) {
            ((UIADI) t).setMaxVideoDuration(i);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f32804o.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i) {
        this.f32799j = i;
        if (this.f32800k > 0 && this.f32799j > this.f32800k) {
            GDTLogger.m20307e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f32719a;
        if (t != 0) {
            ((UIADI) t).setMinVideoDuration(i);
        }
    }

    @Override // com.p518qq.p519e.comm.p520pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f32804o.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f32804o.setAdRewardListener(aDRewardListener);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f32803n = serverSideVerificationOptions;
        T t = this.f32719a;
        if (t != 0) {
            ((UIADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f32798i = videoOption;
        T t = this.f32719a;
        if (t != 0) {
            ((UIADI) t).setVideoOption(videoOption);
        }
    }

    public void show() {
        T t = this.f32719a;
        if (t != 0) {
            ((UIADI) t).show();
        } else {
            m20410a(TTLogUtil.TAG_EVENT_SHOW);
        }
    }

    public void show(Activity activity) {
        T t = this.f32719a;
        if (t != 0) {
            ((UIADI) t).show(activity);
        } else {
            m20410a(TTLogUtil.TAG_EVENT_SHOW);
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t = this.f32719a;
        if (t != 0) {
            ((UIADI) t).showFullScreenAD(activity);
        } else {
            m20410a("showFullScreenAD");
        }
    }
}
