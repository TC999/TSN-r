package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.reward.TTRewardedAdListener;
import com.bytedance.msdk.api.reward.TTRewardedAdLoadCallback;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.e;
import java.util.Map;

/* compiled from: TTInterRewardVideoAdManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e extends com.bytedance.msdk.core.corelogic.e implements ITTAdapterRewardedAdListener {
    private TTRewardedAdLoadCallback O;
    private TTRewardedAdListener P;

    /* compiled from: TTInterRewardVideoAdManager.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class a implements e.c {
        a() {
        }

        @Override // com.bytedance.msdk.core.corelogic.e.c
        public void a() {
            e.this.b(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterRewardVideoAdManager.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdError f292a;

        b(AdError adError) {
            this.f292a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.P != null) {
                e.this.P.onRewardedAdShowFail(this.f292a);
            }
        }
    }

    public e(Context context, String str) {
        super(context, str);
    }

    private void B() {
        TTBaseAd tTBaseAd = this.B;
        if (tTBaseAd == null || tTBaseAd.getAdNetworkPlatformId() == 4) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a().a(this.f27859z, this.f27883f, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdError adError) {
        ThreadHelper.runOnUiThread(new b(adError));
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    public void o() {
        super.o();
        this.O = null;
        this.P = null;
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onRewardClick() {
        TTRewardedAdListener tTRewardedAdListener = this.P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onRewardClick();
        }
        g.d(this.B, this.f27885h);
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onRewardVerify(RewardItem rewardItem) {
        TTRewardedAdListener tTRewardedAdListener = this.P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onRewardVerify(rewardItem);
        }
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onRewardedAdClosed() {
        B();
        TTRewardedAdListener tTRewardedAdListener = this.P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onRewardedAdClosed();
        }
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onRewardedAdShow() {
        TTRewardedAdListener tTRewardedAdListener = this.P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onRewardedAdShow();
        }
        if (this.B != null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f27883f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + this.B.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(this.B.getAdNetworkPlatformId()));
        }
        g.f(this.B, this.f27885h);
        com.bytedance.msdk.core.corelogic.f.o(this.B);
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onRewardedAdShowFail(AdError adError) {
        g.a(this.B, this.f27885h, adError, 1);
        b(adError);
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onSkippedVideo() {
        B();
        TTRewardedAdListener tTRewardedAdListener = this.P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onSkippedVideo();
        }
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onVideoComplete() {
        B();
        TTRewardedAdListener tTRewardedAdListener = this.P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onVideoComplete();
        }
    }

    @Override // com.bytedance.msdk.api.reward.TTRewardedAdListener
    public void onVideoError() {
        g.a(this.B, this.f27885h, (AdError) null, 2);
        TTRewardedAdListener tTRewardedAdListener = this.P;
        if (tTRewardedAdListener != null) {
            tTRewardedAdListener.onVideoError();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void u() {
        TTRewardedAdLoadCallback tTRewardedAdLoadCallback = this.O;
        if (tTRewardedAdLoadCallback != null) {
            tTRewardedAdLoadCallback.onRewardVideoAdLoad();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void v() {
        TTRewardedAdLoadCallback tTRewardedAdLoadCallback = this.O;
        if (tTRewardedAdLoadCallback != null) {
            tTRewardedAdLoadCallback.onRewardVideoCached();
        }
    }

    public void a(AdSlot adSlot, @NonNull TTRewardedAdLoadCallback tTRewardedAdLoadCallback) {
        this.O = tTRewardedAdLoadCallback;
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.b.getShallowCopy(adSlot);
        this.f27885h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(7);
            this.f27885h.setAdCount(1);
            TTVideoOptionUtil.setRewardTTVideoOptionIfNeed(this.f27885h);
        }
        this.A = this;
        x();
    }

    @MainThread
    public void a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, TTRewardedAdListener tTRewardedAdListener) {
        this.P = tTRewardedAdListener;
        super.a(activity, map, new a());
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void a(AdError adError) {
        TTRewardedAdLoadCallback tTRewardedAdLoadCallback = this.O;
        if (tTRewardedAdLoadCallback != null) {
            tTRewardedAdLoadCallback.onRewardVideoLoadFail(adError);
        }
    }
}
