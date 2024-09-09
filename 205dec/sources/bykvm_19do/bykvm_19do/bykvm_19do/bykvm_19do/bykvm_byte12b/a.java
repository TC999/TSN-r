package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_byte12b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.NetworkPlatformConst;
import com.bytedance.msdk.api.TTAdDislike;
import com.bytedance.msdk.api.TTDislikeCallback;
import com.bytedance.msdk.api.nativeAd.TTNativeAd;
import com.bytedance.msdk.api.nativeAd.TTNativeAdAppInfo;
import com.bytedance.msdk.api.nativeAd.TTNativeAdListener;
import com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener;
import com.bytedance.msdk.api.nativeAd.TTVideoListener;
import com.bytedance.msdk.api.nativeAd.TTViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TTNativeAdImpl.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a implements TTNativeAd, TTVideoListener {

    /* renamed from: a  reason: collision with root package name */
    private TTBaseAd f296a;

    /* renamed from: b  reason: collision with root package name */
    private AdSlot f297b;

    /* renamed from: c  reason: collision with root package name */
    private TTNativeAdListener f298c;

    /* renamed from: d  reason: collision with root package name */
    private TTVideoListener f299d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTNativeAdImpl.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_byte12b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class C0018a implements TTNativeExpressAdListener {
        C0018a() {
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeAdListener
        public void onAdClick() {
            if (a.this.f298c != null) {
                a.this.f298c.onAdClick();
            }
            g.d(a.this.f296a, a.this.f297b);
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeAdListener
        public void onAdShow() {
            if (a.this.f298c != null) {
                a.this.f298c.onAdShow();
            }
            if (a.this.f296a != null) {
                i b4 = i.b();
                b4.a(a.this.f296a.getRit() + "");
                i b5 = i.b();
                b5.j(a.this.f296a.getRit() + "");
                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(a.this.f296a.getRit(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + a.this.f296a.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(a.this.f296a.getAdNetworkPlatformId()));
            }
            g.f(a.this.f296a, a.this.f297b);
            f.o(a.this.f296a);
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener
        public void onRenderFail(View view, String str, int i4) {
            if (a.this.f298c instanceof TTNativeExpressAdListener) {
                ((TTNativeExpressAdListener) a.this.f298c).onRenderFail(view, str, i4);
            }
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener
        public void onRenderSuccess(float f4, float f5) {
            if (a.this.f298c instanceof TTNativeExpressAdListener) {
                ((TTNativeExpressAdListener) a.this.f298c).onRenderSuccess(f4, f5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTNativeAdImpl.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b implements TTNativeAdListener {
        b() {
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeAdListener
        public void onAdClick() {
            if (a.this.f298c != null) {
                a.this.f298c.onAdClick();
            }
            g.d(a.this.f296a, a.this.f297b);
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeAdListener
        public void onAdShow() {
            if (a.this.f298c != null) {
                a.this.f298c.onAdShow();
            }
            if (a.this.f296a != null) {
                i b4 = i.b();
                b4.a(a.this.f296a.getRit() + "");
                i b5 = i.b();
                b5.j(a.this.f296a.getRit() + "");
                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(a.this.f296a.getRit(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + a.this.f296a.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(a.this.f296a.getAdNetworkPlatformId()));
            }
            g.f(a.this.f296a, a.this.f297b);
            f.o(a.this.f296a);
        }
    }

    public a(TTBaseAd tTBaseAd, AdSlot adSlot) {
        this.f296a = tTBaseAd;
        this.f297b = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.b.getShallowCopy(adSlot);
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void destroy() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            try {
                tTBaseAd.onDestroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getActionText() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getActionText();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getAdImageMode() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageMode();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public View getAdLogoView() {
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getAdNetworkPlatformId() {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().m()) {
            TTBaseAd tTBaseAd = this.f296a;
            if (tTBaseAd != null) {
                return tTBaseAd.getAdNetworkPlatformId();
            }
            return -2;
        }
        return -3;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getAdNetworkRitId() {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().m()) {
            TTBaseAd tTBaseAd = this.f296a;
            return tTBaseAd != null ? tTBaseAd.getAdNetworkSlotId() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getDescription() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdDescription();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getDislikeDialog(activity);
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public View getExpressView() {
        g.a(this.f297b);
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null && tTBaseAd.isExpressAd()) {
            g.e(this.f296a, this.f297b);
            return this.f296a.getAdView();
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.f296a);
        g.a(arrayList, this.f297b);
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getIconUrl() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getIconUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getImageHeight() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageHeight();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public List<String> getImageList() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImages();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getImageUrl() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getImageWidth() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageWidth();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getInteractionType() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getInteractionType();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public TTNativeAdAppInfo getNativeAdAppInfo() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd == null || !tTBaseAd.hasAppInfo()) {
            return null;
        }
        TTNativeAdAppInfo tTNativeAdAppInfo = new TTNativeAdAppInfo();
        tTNativeAdAppInfo.setAppName(this.f296a.getAppName());
        tTNativeAdAppInfo.setAuthorName(this.f296a.getAuthorName());
        tTNativeAdAppInfo.setPackageSizeBytes(this.f296a.getPackageSizeBytes());
        tTNativeAdAppInfo.setPermissionsUrl(this.f296a.getPermissionsUrl());
        tTNativeAdAppInfo.setPrivacyAgreement(this.f296a.getPrivacyAgreement());
        tTNativeAdAppInfo.setVersionName(this.f296a.getVersionName());
        return tTNativeAdAppInfo;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getPackageName() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getPackageName();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getPreEcpm() {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().m()) {
            TTBaseAd tTBaseAd = this.f296a;
            return tTBaseAd != null ? tTBaseAd.getNetWorkPlatFormCpm() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getSdkNumType() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkPlatformId();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getSource() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getSource();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public double getStarRating() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getStarRating();
        }
        return 0.0d;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getTitle() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdTitle();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public boolean hasDislike() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.hasDislike();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public boolean isExpressAd() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.isExpressAd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public boolean isHasShown() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.isHasShown();
        }
        return true;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public boolean isServerBidding() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            return tTBaseAd.isServerBiddingAd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void onPause() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            tTBaseAd.onPause();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTVideoListener
    public void onVideoCompleted() {
        TTVideoListener tTVideoListener = this.f299d;
        if (tTVideoListener != null) {
            tTVideoListener.onVideoCompleted();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTVideoListener
    public void onVideoError(AdError adError) {
        g.a(this.f296a, this.f297b, (AdError) null, 2);
        TTVideoListener tTVideoListener = this.f299d;
        if (tTVideoListener != null) {
            tTVideoListener.onVideoError(adError);
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTVideoListener
    public void onVideoPause() {
        TTVideoListener tTVideoListener = this.f299d;
        if (tTVideoListener != null) {
            tTVideoListener.onVideoPause();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTVideoListener
    public void onVideoResume() {
        TTVideoListener tTVideoListener = this.f299d;
        if (tTVideoListener != null) {
            tTVideoListener.onVideoResume();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTVideoListener
    public void onVideoStart() {
        TTVideoListener tTVideoListener = this.f299d;
        if (tTVideoListener != null) {
            tTVideoListener.onVideoStart();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void registerView(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTViewBinder tTViewBinder) {
        g.a(this.f297b);
        if (this.f296a != null) {
            a();
            this.f296a.registerViewForInteraction(viewGroup, list, list2, tTViewBinder);
            g.e(this.f296a, this.f297b);
            return;
        }
        g.a((List<TTBaseAd>) null, this.f297b);
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void render() {
        if (this.f296a != null) {
            a();
            this.f296a.render();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void resume() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            tTBaseAd.onResume();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void setDislikeCallback(Activity activity, TTDislikeCallback tTDislikeCallback) {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            tTBaseAd.setDislikeCallback(activity, tTDislikeCallback);
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void setHasShown(boolean z3) {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            tTBaseAd.setHasShown(z3);
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void setTTAdatperCallback(ITTAdatperCallback iTTAdatperCallback) {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            tTBaseAd.setTTAdatperCallback(iTTAdatperCallback);
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void setTTNativeAdListener(TTNativeAdListener tTNativeAdListener) {
        this.f298c = tTNativeAdListener;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void setTTVideoListener(TTVideoListener tTVideoListener) {
        this.f299d = tTVideoListener;
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            tTBaseAd.setTTVideoListener(this);
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void unregisterView() {
        TTBaseAd tTBaseAd = this.f296a;
        if (tTBaseAd != null) {
            tTBaseAd.unregisterView();
        }
    }

    private void a() {
        if (this.f296a.isExpressAd()) {
            this.f296a.setTTNativeAdListener(new C0018a());
        } else {
            this.f296a.setTTNativeAdListener(new b());
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTViewBinder tTViewBinder) {
        g.a(this.f297b);
        if (this.f296a != null) {
            a();
            this.f296a.registerViewForInteraction(activity, viewGroup, list, list2, tTViewBinder);
            g.e(this.f296a, this.f297b);
            return;
        }
        g.a((List<TTBaseAd>) null, this.f297b);
    }
}
