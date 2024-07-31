package com.p518qq.p519e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.p518qq.p519e.ads.LiteAbstractAD;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.constants.LoadAdParams;
import com.p518qq.p519e.comm.listeners.ADRewardListener;
import com.p518qq.p519e.comm.listeners.NegativeFeedbackListener;
import com.p518qq.p519e.comm.p520pi.IReward;
import com.p518qq.p519e.comm.p520pi.NFBI;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.p520pi.UBVI;
import com.p518qq.p519e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.qq.e.ads.banner2.UnifiedBannerAD */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {

    /* renamed from: g */
    private UnifiedBannerADListener f32737g;

    /* renamed from: h */
    private AtomicInteger f32738h;

    /* renamed from: i */
    private int f32739i;

    /* renamed from: j */
    private LoadAdParams f32740j;

    /* renamed from: k */
    private UnifiedBannerView f32741k;

    /* renamed from: l */
    private final ADListenerAdapter f32742l;

    /* renamed from: m */
    private volatile ServerSideVerificationOptions f32743m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        m20414a(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        m20413a(activity, str, str2);
    }

    private UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.f32738h = new AtomicInteger(0);
        this.f32739i = 30;
        this.f32740j = null;
        this.f32737g = unifiedBannerADListener;
        this.f32741k = unifiedBannerView;
        this.f32742l = new ADListenerAdapter(unifiedBannerADListener);
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected Object mo20371a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.f32741k, (Activity) context, str, str2, str3, this.f32742l);
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: b */
    protected void mo20366b(int i) {
        UnifiedBannerADListener unifiedBannerADListener = this.f32737g;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m20407c(int i) {
        this.f32739i = i;
        T t = this.f32719a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        T t = this.f32719a;
        if (t != 0) {
            ((UBVI) t).destroy();
        } else {
            m20410a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.f32719a;
        if (t != 0) {
            return ((UBVI) t).getAdNetWorkName();
        }
        m20410a("getAdNetWorkName");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadAD() {
        if (m20416a()) {
            if (!m20409b()) {
                this.f32738h.incrementAndGet();
                return;
            }
            T t = this.f32719a;
            if (t != 0) {
                ((UBVI) t).fetchAd();
            } else {
                m20410a("loadAD");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onWindowFocusChanged(boolean z) {
        T t = this.f32719a;
        if (t != 0) {
            ((UBVI) t).onWindowFocusChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f32740j = loadAdParams;
        T t = this.f32719a;
        if (t != 0) {
            ((UBVI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.p518qq.p519e.comm.p520pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f32742l.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f32742l.setAdRewardListener(aDRewardListener);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f32743m = serverSideVerificationOptions;
        T t = this.f32719a;
        if (t != 0) {
            ((UBVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected void mo20368a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        int i = this.f32739i;
        this.f32739i = i;
        T t = this.f32719a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i);
        }
        LoadAdParams loadAdParams = this.f32740j;
        this.f32740j = loadAdParams;
        T t2 = this.f32719a;
        if (t2 != 0) {
            ((UBVI) t2).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.f32743m);
        while (this.f32738h.getAndDecrement() > 0) {
            loadAD();
        }
    }
}
