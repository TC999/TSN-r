package com.p518qq.p519e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.p518qq.p519e.ads.LiteAbstractAD;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.adevent.ADEvent;
import com.p518qq.p519e.comm.adevent.ADListener;
import com.p518qq.p519e.comm.constants.LoadAdParams;
import com.p518qq.p519e.comm.listeners.ADRewardListener;
import com.p518qq.p519e.comm.p520pi.IReward;
import com.p518qq.p519e.comm.p520pi.NSPVI;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.util.AdErrorConvertor;
import com.p518qq.p519e.comm.util.GDTLogger;
import java.util.HashMap;

/* renamed from: com.qq.e.ads.splash.SplashAD */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {

    /* renamed from: g */
    private volatile ViewGroup f32859g;

    /* renamed from: h */
    private volatile SplashADListener f32860h;

    /* renamed from: i */
    private volatile ADRewardListener f32861i;

    /* renamed from: j */
    private volatile LoadAdParams f32862j;

    /* renamed from: k */
    private volatile boolean f32863k;

    /* renamed from: l */
    private volatile boolean f32864l;

    /* renamed from: m */
    private volatile boolean f32865m;

    /* renamed from: n */
    private volatile int f32866n;

    /* renamed from: o */
    private volatile byte[] f32867o;

    /* renamed from: p */
    private volatile ServerSideVerificationOptions f32868p;

    /* renamed from: q */
    private int f32869q;

    /* renamed from: com.qq.e.ads.splash.SplashAD$ADListenerAdapter */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        @Override // com.p518qq.p519e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f32860h == null) {
                GDTLogger.m20308d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            if (type == 112) {
                Long l = (Long) aDEvent.getParam(Long.class);
                if (l != null) {
                    SplashAD.this.f32860h.onADTick(l.longValue());
                    return;
                }
                return;
            }
            switch (type) {
                case 100:
                    Long l2 = (Long) aDEvent.getParam(Long.class);
                    if (l2 != null) {
                        SplashAD.this.f32860h.onADLoaded(l2.longValue());
                        return;
                    }
                    return;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.f32860h.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                case 102:
                    SplashAD.this.f32860h.onADPresent();
                    return;
                case 103:
                    SplashAD.this.f32860h.onADExposure();
                    return;
                case 104:
                    if (SplashAD.this.f32861i == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    SplashAD.this.f32861i.onReward(hashMap);
                    return;
                case 105:
                    SplashAD.this.f32860h.onADClicked();
                    return;
                case 106:
                    SplashAD.this.f32860h.onADDismissed();
                    return;
                default:
                    return;
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i) {
        this.f32863k = false;
        this.f32860h = splashADListener;
        this.f32869q = i;
        m20414a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i, String str2) {
        this.f32863k = false;
        this.f32860h = splashADListener;
        this.f32869q = i;
        m20413a(context, str, str2);
    }

    /* renamed from: a */
    private void m20370a(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.m20307e("传入参数有误：传入container参数为空");
            m20415a(4001);
            return;
        }
        T t = this.f32719a;
        if (t == 0) {
            this.f32865m = z;
            this.f32859g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    /* renamed from: a */
    private void m20367a(boolean z) {
        if (m20416a()) {
            if (!m20409b()) {
                this.f32865m = z;
                this.f32864l = true;
                return;
            }
            T t = this.f32719a;
            if (t == 0) {
                m20410a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    /* renamed from: b */
    private void m20365b(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.m20307e("传入参数错误，container参数为空");
            m20415a(4001);
            return;
        }
        T t = this.f32719a;
        if (t == 0) {
            this.f32859g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected Object mo20371a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: b */
    protected void mo20366b(int i) {
        if (this.f32860h != null) {
            this.f32860h.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void fetchAdOnly() {
        m20367a(false);
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        m20370a(viewGroup, false);
    }

    public void fetchFullScreenAdOnly() {
        m20367a(true);
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        m20370a(viewGroup, true);
    }

    public String getAdNetWorkName() {
        T t = this.f32719a;
        if (t != 0) {
            return ((NSPVI) t).getAdNetWorkName();
        }
        m20410a("getAdNetWorkName");
        return null;
    }

    @Deprecated
    public Bitmap getZoomOutBitmap() {
        GDTLogger.m20307e("注意！开屏V+功能已废弃，调用不生效");
        return null;
    }

    public void preLoad() {
        if (m20416a()) {
            if (!m20409b()) {
                this.f32863k = true;
                return;
            }
            T t = this.f32719a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                m20410a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i, int i2) {
    }

    public void setDeveloperLogo(int i) {
        T t = this.f32719a;
        if (t == 0) {
            this.f32866n = i;
        } else {
            ((NSPVI) t).setDeveloperLogo(i);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.f32719a;
        if (t == 0) {
            this.f32867o = bArr;
        } else {
            ((NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t = this.f32719a;
        if (t != 0) {
            ((NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.f32862j = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.p518qq.p519e.comm.p520pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f32861i = aDRewardListener;
    }

    @Override // com.p518qq.p519e.comm.p520pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f32868p = serverSideVerificationOptions;
        T t = this.f32719a;
        if (t != 0) {
            ((NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        m20365b(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        m20365b(viewGroup, true);
    }

    @Deprecated
    public void zoomOutAnimationFinish() {
        GDTLogger.m20307e("注意！开屏V+功能已废弃，调用不生效");
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected void mo20368a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.f32862j != null) {
            nspvi.setLoadAdParams(this.f32862j);
        }
        if (this.f32866n != 0) {
            nspvi.setDeveloperLogo(this.f32866n);
        }
        if (this.f32867o != null) {
            nspvi.setDeveloperLogo(this.f32867o);
        }
        nspvi.setFetchDelay(this.f32869q);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.f32868p);
        if (this.f32859g != null) {
            if (this.f32865m) {
                fetchFullScreenAndShowIn(this.f32859g);
            } else {
                fetchAndShowIn(this.f32859g);
            }
        }
        if (this.f32863k) {
            nspvi.preload();
            this.f32863k = false;
        }
        if (this.f32864l) {
            if (this.f32865m) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.f32864l = false;
        }
    }
}
