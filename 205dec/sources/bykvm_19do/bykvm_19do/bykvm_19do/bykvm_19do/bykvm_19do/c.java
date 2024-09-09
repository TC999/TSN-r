package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener;
import com.bytedance.msdk.api.fullVideo.TTFullVideoAdLoadCallback;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.msdk.core.corelogic.e;
import java.util.Map;

/* compiled from: TTInterFullVideoAdManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c extends com.bytedance.msdk.core.corelogic.e implements ITTAdapterFullVideoAdListener {
    private TTFullVideoAdLoadCallback O;
    private TTFullVideoAdListener P;

    /* compiled from: TTInterFullVideoAdManager.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class a implements e.c {
        a() {
        }

        @Override // com.bytedance.msdk.core.corelogic.e.c
        public void a() {
            c.this.b(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TTInterFullVideoAdManager.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdError f289a;

        b(AdError adError) {
            this.f289a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.P != null) {
                c.this.P.onFullVideoAdShowFail(this.f289a);
            }
        }
    }

    public c(Context context, String str) {
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
        this.P = null;
        this.O = null;
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onFullVideoAdClick() {
        TTFullVideoAdListener tTFullVideoAdListener = this.P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onFullVideoAdClick();
        }
        g.d(this.B, this.f27885h);
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onFullVideoAdClosed() {
        B();
        TTFullVideoAdListener tTFullVideoAdListener = this.P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onFullVideoAdClosed();
        }
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onFullVideoAdShow() {
        TTFullVideoAdListener tTFullVideoAdListener = this.P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onFullVideoAdShow();
        }
        if (this.B != null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f27883f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + this.B.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.base.a.d(this.B.getAdNetworkPlatformId()));
        }
        g.f(this.B, this.f27885h);
        com.bytedance.msdk.core.corelogic.f.o(this.B);
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onFullVideoAdShowFail(AdError adError) {
        g.a(this.B, this.f27885h, adError, 1);
        b(adError);
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onSkippedVideo() {
        B();
        TTFullVideoAdListener tTFullVideoAdListener = this.P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onSkippedVideo();
        }
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onVideoComplete() {
        B();
        TTFullVideoAdListener tTFullVideoAdListener = this.P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onVideoComplete();
        }
    }

    @Override // com.bytedance.msdk.api.fullVideo.TTFullVideoAdListener
    public void onVideoError() {
        g.a(this.B, this.f27885h, (AdError) null, 2);
        TTFullVideoAdListener tTFullVideoAdListener = this.P;
        if (tTFullVideoAdListener != null) {
            tTFullVideoAdListener.onVideoError();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void u() {
        TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback = this.O;
        if (tTFullVideoAdLoadCallback != null) {
            tTFullVideoAdLoadCallback.onFullVideoAdLoad();
        }
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void v() {
        TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback = this.O;
        if (tTFullVideoAdLoadCallback != null) {
            tTFullVideoAdLoadCallback.onFullVideoCached();
        }
    }

    public void a(AdSlot adSlot, @NonNull TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback) {
        this.O = tTFullVideoAdLoadCallback;
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.b.getShallowCopy(adSlot);
        this.f27885h = shallowCopy;
        if (shallowCopy != null) {
            shallowCopy.setAdType(8);
            this.f27885h.setAdCount(1);
            TTVideoOptionUtil.setFullTTVideoOptionIfNeed(this.f27885h);
        }
        this.A = this;
        x();
    }

    @MainThread
    public void a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map, TTFullVideoAdListener tTFullVideoAdListener) {
        this.P = tTFullVideoAdListener;
        super.a(activity, map, new a());
    }

    @Override // com.bytedance.msdk.core.corelogic.TTAdHeaderBidingRequestCore
    protected void a(AdError adError) {
        TTFullVideoAdLoadCallback tTFullVideoAdLoadCallback = this.O;
        if (tTFullVideoAdLoadCallback != null) {
            tTFullVideoAdLoadCallback.onFullVideoLoadFail(adError);
        }
    }
}
