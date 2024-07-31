package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_byte12b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IntervalShowControl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdSlotInner;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUtil;
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
import com.bytedance.msdk.base.C6031a;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.TTLoaderUtil;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_byte12b.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTNativeAdImpl implements TTNativeAd, TTVideoListener {

    /* renamed from: a */
    private TTBaseAd f299a;

    /* renamed from: b */
    private AdSlot f300b;

    /* renamed from: c */
    private TTNativeAdListener f301c;

    /* renamed from: d */
    private TTVideoListener f302d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTNativeAdImpl.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_byte12b.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C0943a implements TTNativeExpressAdListener {
        C0943a() {
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeAdListener
        public void onAdClick() {
            if (TTNativeAdImpl.this.f301c != null) {
                TTNativeAdImpl.this.f301c.onAdClick();
            }
            AdEventUtil.m59300d(TTNativeAdImpl.this.f299a, TTNativeAdImpl.this.f300b);
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeAdListener
        public void onAdShow() {
            if (TTNativeAdImpl.this.f301c != null) {
                TTNativeAdImpl.this.f301c.onAdShow();
            }
            if (TTNativeAdImpl.this.f299a != null) {
                IntervalShowControl m59587b = IntervalShowControl.m59587b();
                m59587b.m59589a(TTNativeAdImpl.this.f299a.getRit() + "");
                IntervalShowControl m59587b2 = IntervalShowControl.m59587b();
                m59587b2.m59575j(TTNativeAdImpl.this.f299a.getRit() + "");
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(TTNativeAdImpl.this.f299a.getRit(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + TTNativeAdImpl.this.f299a.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(TTNativeAdImpl.this.f299a.getAdNetworkPlatformId()));
            }
            AdEventUtil.m59298f(TTNativeAdImpl.this.f299a, TTNativeAdImpl.this.f300b);
            TTLoaderUtil.m37308o(TTNativeAdImpl.this.f299a);
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener
        public void onRenderFail(View view, String str, int i) {
            if (TTNativeAdImpl.this.f301c instanceof TTNativeExpressAdListener) {
                ((TTNativeExpressAdListener) TTNativeAdImpl.this.f301c).onRenderFail(view, str, i);
            }
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeExpressAdListener
        public void onRenderSuccess(float f, float f2) {
            if (TTNativeAdImpl.this.f301c instanceof TTNativeExpressAdListener) {
                ((TTNativeExpressAdListener) TTNativeAdImpl.this.f301c).onRenderSuccess(f, f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTNativeAdImpl.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_byte12b.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C0944b implements TTNativeAdListener {
        C0944b() {
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeAdListener
        public void onAdClick() {
            if (TTNativeAdImpl.this.f301c != null) {
                TTNativeAdImpl.this.f301c.onAdClick();
            }
            AdEventUtil.m59300d(TTNativeAdImpl.this.f299a, TTNativeAdImpl.this.f300b);
        }

        @Override // com.bytedance.msdk.api.nativeAd.TTNativeAdListener
        public void onAdShow() {
            if (TTNativeAdImpl.this.f301c != null) {
                TTNativeAdImpl.this.f301c.onAdShow();
            }
            if (TTNativeAdImpl.this.f299a != null) {
                IntervalShowControl m59587b = IntervalShowControl.m59587b();
                m59587b.m59589a(TTNativeAdImpl.this.f299a.getRit() + "");
                IntervalShowControl m59587b2 = IntervalShowControl.m59587b();
                m59587b2.m59575j(TTNativeAdImpl.this.f299a.getRit() + "");
                Logger.m37562d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(TTNativeAdImpl.this.f299a.getRit(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + TTNativeAdImpl.this.f299a.getAdNetworkSlotId() + "，广告类型：" + C6031a.m37434d(TTNativeAdImpl.this.f299a.getAdNetworkPlatformId()));
            }
            AdEventUtil.m59298f(TTNativeAdImpl.this.f299a, TTNativeAdImpl.this.f300b);
            TTLoaderUtil.m37308o(TTNativeAdImpl.this.f299a);
        }
    }

    public TTNativeAdImpl(TTBaseAd tTBaseAd, AdSlot adSlot) {
        this.f299a = tTBaseAd;
        this.f300b = AdSlotInner.getShallowCopy(adSlot);
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void destroy() {
        TTBaseAd tTBaseAd = this.f299a;
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
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getActionText();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getAdImageMode() {
        TTBaseAd tTBaseAd = this.f299a;
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
        if (InternalContainer.m59943f().m59734m()) {
            TTBaseAd tTBaseAd = this.f299a;
            if (tTBaseAd != null) {
                return tTBaseAd.getAdNetworkPlatformId();
            }
            return -2;
        }
        return -3;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getAdNetworkRitId() {
        if (InternalContainer.m59943f().m59734m()) {
            TTBaseAd tTBaseAd = this.f299a;
            return tTBaseAd != null ? tTBaseAd.getAdNetworkSlotId() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getDescription() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdDescription();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getDislikeDialog(activity);
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public View getExpressView() {
        AdEventUtil.m59322a(this.f300b);
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null && tTBaseAd.isExpressAd()) {
            AdEventUtil.m59299e(this.f299a, this.f300b);
            return this.f299a.getAdView();
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.f299a);
        AdEventUtil.m59308a(arrayList, this.f300b);
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getIconUrl() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getIconUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getImageHeight() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageHeight();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public List<String> getImageList() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImages();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getImageUrl() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getImageWidth() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageWidth();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getInteractionType() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getInteractionType();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public TTNativeAdAppInfo getNativeAdAppInfo() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd == null || !tTBaseAd.hasAppInfo()) {
            return null;
        }
        TTNativeAdAppInfo tTNativeAdAppInfo = new TTNativeAdAppInfo();
        tTNativeAdAppInfo.setAppName(this.f299a.getAppName());
        tTNativeAdAppInfo.setAuthorName(this.f299a.getAuthorName());
        tTNativeAdAppInfo.setPackageSizeBytes(this.f299a.getPackageSizeBytes());
        tTNativeAdAppInfo.setPermissionsUrl(this.f299a.getPermissionsUrl());
        tTNativeAdAppInfo.setPrivacyAgreement(this.f299a.getPrivacyAgreement());
        tTNativeAdAppInfo.setVersionName(this.f299a.getVersionName());
        return tTNativeAdAppInfo;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getPackageName() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getPackageName();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getPreEcpm() {
        if (InternalContainer.m59943f().m59734m()) {
            TTBaseAd tTBaseAd = this.f299a;
            return tTBaseAd != null ? tTBaseAd.getNetWorkPlatFormCpm() : NetworkPlatformConst.AD_NETWORK_NO_DATA;
        }
        return NetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public int getSdkNumType() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkPlatformId();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getSource() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getSource();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public double getStarRating() {
        TTBaseAd tTBaseAd = this.f299a;
        return tTBaseAd != null ? tTBaseAd.getStarRating() : Utils.DOUBLE_EPSILON;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public String getTitle() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdTitle();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public boolean hasDislike() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.hasDislike();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public boolean isExpressAd() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.isExpressAd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public boolean isHasShown() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.isHasShown();
        }
        return true;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public boolean isServerBidding() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            return tTBaseAd.isServerBiddingAd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void onPause() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            tTBaseAd.onPause();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTVideoListener
    public void onVideoCompleted() {
        TTVideoListener tTVideoListener = this.f302d;
        if (tTVideoListener != null) {
            tTVideoListener.onVideoCompleted();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTVideoListener
    public void onVideoError(AdError adError) {
        AdEventUtil.m59309a(this.f299a, this.f300b, (AdError) null, 2);
        TTVideoListener tTVideoListener = this.f302d;
        if (tTVideoListener != null) {
            tTVideoListener.onVideoError(adError);
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTVideoListener
    public void onVideoPause() {
        TTVideoListener tTVideoListener = this.f302d;
        if (tTVideoListener != null) {
            tTVideoListener.onVideoPause();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTVideoListener
    public void onVideoResume() {
        TTVideoListener tTVideoListener = this.f302d;
        if (tTVideoListener != null) {
            tTVideoListener.onVideoResume();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTVideoListener
    public void onVideoStart() {
        TTVideoListener tTVideoListener = this.f302d;
        if (tTVideoListener != null) {
            tTVideoListener.onVideoStart();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void registerView(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTViewBinder tTViewBinder) {
        AdEventUtil.m59322a(this.f300b);
        if (this.f299a != null) {
            m59838a();
            this.f299a.registerViewForInteraction(viewGroup, list, list2, tTViewBinder);
            AdEventUtil.m59299e(this.f299a, this.f300b);
            return;
        }
        AdEventUtil.m59308a((List<TTBaseAd>) null, this.f300b);
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void render() {
        if (this.f299a != null) {
            m59838a();
            this.f299a.render();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void resume() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            tTBaseAd.onResume();
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void setDislikeCallback(Activity activity, TTDislikeCallback tTDislikeCallback) {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            tTBaseAd.setDislikeCallback(activity, tTDislikeCallback);
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void setHasShown(boolean z) {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            tTBaseAd.setHasShown(z);
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void setTTAdatperCallback(ITTAdatperCallback iTTAdatperCallback) {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            tTBaseAd.setTTAdatperCallback(iTTAdatperCallback);
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void setTTNativeAdListener(TTNativeAdListener tTNativeAdListener) {
        this.f301c = tTNativeAdListener;
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void setTTVideoListener(TTVideoListener tTVideoListener) {
        this.f302d = tTVideoListener;
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            tTBaseAd.setTTVideoListener(this);
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void unregisterView() {
        TTBaseAd tTBaseAd = this.f299a;
        if (tTBaseAd != null) {
            tTBaseAd.unregisterView();
        }
    }

    /* renamed from: a */
    private void m59838a() {
        if (this.f299a.isExpressAd()) {
            this.f299a.setTTNativeAdListener(new C0943a());
        } else {
            this.f299a.setTTNativeAdListener(new C0944b());
        }
    }

    @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
    public void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTViewBinder tTViewBinder) {
        AdEventUtil.m59322a(this.f300b);
        if (this.f299a != null) {
            m59838a();
            this.f299a.registerViewForInteraction(activity, viewGroup, list, list2, tTViewBinder);
            AdEventUtil.m59299e(this.f299a, this.f300b);
            return;
        }
        AdEventUtil.m59308a((List<TTBaseAd>) null, this.f300b);
    }
}
