package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {

    /* renamed from: g  reason: collision with root package name */
    private volatile ViewGroup f41574g;

    /* renamed from: h  reason: collision with root package name */
    private volatile SplashADListener f41575h;

    /* renamed from: i  reason: collision with root package name */
    private volatile ADRewardListener f41576i;

    /* renamed from: j  reason: collision with root package name */
    private volatile LoadAdParams f41577j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f41578k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f41579l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f41580m;

    /* renamed from: n  reason: collision with root package name */
    private volatile int f41581n;

    /* renamed from: o  reason: collision with root package name */
    private volatile byte[] f41582o;

    /* renamed from: p  reason: collision with root package name */
    private volatile ServerSideVerificationOptions f41583p;

    /* renamed from: q  reason: collision with root package name */
    private int f41584q;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f41575h == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            if (type == 112) {
                Long l4 = (Long) aDEvent.getParam(Long.class);
                if (l4 != null) {
                    SplashAD.this.f41575h.onADTick(l4.longValue());
                    return;
                }
                return;
            }
            switch (type) {
                case 100:
                    Long l5 = (Long) aDEvent.getParam(Long.class);
                    if (l5 != null) {
                        SplashAD.this.f41575h.onADLoaded(l5.longValue());
                        return;
                    }
                    return;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.f41575h.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                case 102:
                    SplashAD.this.f41575h.onADPresent();
                    return;
                case 103:
                    SplashAD.this.f41575h.onADExposure();
                    return;
                case 104:
                    if (SplashAD.this.f41576i == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    SplashAD.this.f41576i.onReward(hashMap);
                    return;
                case 105:
                    SplashAD.this.f41575h.onADClicked();
                    return;
                case 106:
                    SplashAD.this.f41575h.onADDismissed();
                    return;
                default:
                    return;
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i4) {
        this.f41578k = false;
        this.f41575h = splashADListener;
        this.f41584q = i4;
        a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i4, String str2) {
        this.f41578k = false;
        this.f41575h = splashADListener;
        this.f41584q = i4;
        a(context, str, str2);
    }

    private void a(ViewGroup viewGroup, boolean z3) {
        if (viewGroup == null) {
            GDTLogger.e("\u4f20\u5165\u53c2\u6570\u6709\u8bef\uff1a\u4f20\u5165container\u53c2\u6570\u4e3a\u7a7a");
            a(4001);
            return;
        }
        Object obj = this.f41434a;
        if (obj == null) {
            this.f41580m = z3;
            this.f41574g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) obj;
        if (z3) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    private void a(boolean z3) {
        if (a()) {
            if (!b()) {
                this.f41580m = z3;
                this.f41579l = true;
                return;
            }
            Object obj = this.f41434a;
            if (obj == null) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) obj;
            if (z3) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z3) {
        if (viewGroup == null) {
            GDTLogger.e("\u4f20\u5165\u53c2\u6570\u9519\u8bef\uff0ccontainer\u53c2\u6570\u4e3a\u7a7a");
            a(4001);
            return;
        }
        Object obj = this.f41434a;
        if (obj == null) {
            this.f41574g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) obj;
        if (z3) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i4) {
        if (this.f41575h != null) {
            this.f41575h.onNoAD(AdErrorConvertor.formatErrorCode(i4));
        }
    }

    public void fetchAdOnly() {
        a(false);
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, false);
    }

    public void fetchFullScreenAdOnly() {
        a(true);
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, true);
    }

    public String getAdNetWorkName() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((NSPVI) obj).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    @Deprecated
    public Bitmap getZoomOutBitmap() {
        GDTLogger.e("\u6ce8\u610f\uff01\u5f00\u5c4fV+\u529f\u80fd\u5df2\u5e9f\u5f03\uff0c\u8c03\u7528\u4e0d\u751f\u6548");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.f41578k = true;
                return;
            }
            Object obj = this.f41434a;
            if (obj != null) {
                ((NSPVI) obj).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i4, int i5) {
    }

    public void setDeveloperLogo(int i4) {
        Object obj = this.f41434a;
        if (obj == null) {
            this.f41581n = i4;
        } else {
            ((NSPVI) obj).setDeveloperLogo(i4);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        Object obj = this.f41434a;
        if (obj == null) {
            this.f41582o = bArr;
        } else {
            ((NSPVI) obj).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        Object obj = this.f41434a;
        if (obj != null) {
            ((NSPVI) obj).setLoadAdParams(loadAdParams);
        } else {
            this.f41577j = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f41576i = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f41583p = serverSideVerificationOptions;
        Object obj = this.f41434a;
        if (obj != null) {
            ((NSPVI) obj).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        b(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        b(viewGroup, true);
    }

    @Deprecated
    public void zoomOutAnimationFinish() {
        GDTLogger.e("\u6ce8\u610f\uff01\u5f00\u5c4fV+\u529f\u80fd\u5df2\u5e9f\u5f03\uff0c\u8c03\u7528\u4e0d\u751f\u6548");
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.f41577j != null) {
            nspvi.setLoadAdParams(this.f41577j);
        }
        if (this.f41581n != 0) {
            nspvi.setDeveloperLogo(this.f41581n);
        }
        if (this.f41582o != null) {
            nspvi.setDeveloperLogo(this.f41582o);
        }
        nspvi.setFetchDelay(this.f41584q);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.f41583p);
        if (this.f41574g != null) {
            if (this.f41580m) {
                fetchFullScreenAndShowIn(this.f41574g);
            } else {
                fetchAndShowIn(this.f41574g);
            }
        }
        if (this.f41578k) {
            nspvi.preload();
            this.f41578k = false;
        }
        if (this.f41579l) {
            if (this.f41580m) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.f41579l = false;
        }
    }
}
