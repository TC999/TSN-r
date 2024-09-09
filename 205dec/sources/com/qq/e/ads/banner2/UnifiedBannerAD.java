package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {

    /* renamed from: g  reason: collision with root package name */
    private UnifiedBannerADListener f41452g;

    /* renamed from: h  reason: collision with root package name */
    private AtomicInteger f41453h;

    /* renamed from: i  reason: collision with root package name */
    private int f41454i;

    /* renamed from: j  reason: collision with root package name */
    private LoadAdParams f41455j;

    /* renamed from: k  reason: collision with root package name */
    private UnifiedBannerView f41456k;

    /* renamed from: l  reason: collision with root package name */
    private final ADListenerAdapter f41457l;

    /* renamed from: m  reason: collision with root package name */
    private volatile ServerSideVerificationOptions f41458m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    private UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.f41453h = new AtomicInteger(0);
        this.f41454i = 30;
        this.f41455j = null;
        this.f41452g = unifiedBannerADListener;
        this.f41456k = unifiedBannerView;
        this.f41457l = new ADListenerAdapter(unifiedBannerADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.f41456k, (Activity) context, str, str2, str3, this.f41457l);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i4) {
        UnifiedBannerADListener unifiedBannerADListener = this.f41452g;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i4) {
        this.f41454i = i4;
        Object obj = this.f41434a;
        if (obj != null) {
            ((UBVI) obj).setRefresh(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        Object obj = this.f41434a;
        if (obj != null) {
            ((UBVI) obj).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((UBVI) obj).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f41453h.incrementAndGet();
                return;
            }
            Object obj = this.f41434a;
            if (obj != null) {
                ((UBVI) obj).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onWindowFocusChanged(boolean z3) {
        Object obj = this.f41434a;
        if (obj != null) {
            ((UBVI) obj).onWindowFocusChanged(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f41455j = loadAdParams;
        Object obj = this.f41434a;
        if (obj != null) {
            ((UBVI) obj).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f41457l.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f41457l.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f41458m = serverSideVerificationOptions;
        Object obj = this.f41434a;
        if (obj != null) {
            ((UBVI) obj).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        int i4 = this.f41454i;
        this.f41454i = i4;
        Object obj2 = this.f41434a;
        if (obj2 != null) {
            ((UBVI) obj2).setRefresh(i4);
        }
        LoadAdParams loadAdParams = this.f41455j;
        this.f41455j = loadAdParams;
        Object obj3 = this.f41434a;
        if (obj3 != null) {
            ((UBVI) obj3).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.f41458m);
        while (this.f41453h.getAndDecrement() > 0) {
            loadAD();
        }
    }
}
