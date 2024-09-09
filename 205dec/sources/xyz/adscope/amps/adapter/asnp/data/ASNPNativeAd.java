package xyz.adscope.amps.adapter.asnp.data;

import android.view.View;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdView;
import xyz.adscope.ad.advertisings.nativead.listener.INativeDislikeListener;
import xyz.adscope.ad.advertisings.nativead.listener.INativeExpressAdListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ASNPNativeAd implements AMPSNativeAdExpressInfo {
    private AMPSNativeAdapter adapter;
    public INativeAdView asnpNativeExpressAd;

    public ASNPNativeAd(INativeAdView iNativeAdView, AMPSNativeAdapter aMPSNativeAdapter) {
        this.asnpNativeExpressAd = iNativeAdView;
        this.adapter = aMPSNativeAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAMPSNativeAdExpressListener$0(AMPSNativeAdExpressListener aMPSNativeAdExpressListener, View view) {
        if (aMPSNativeAdExpressListener != null) {
            try {
                AMPSNativeAdapter aMPSNativeAdapter = this.adapter;
                if (aMPSNativeAdapter != null) {
                    aMPSNativeAdapter.onAdDismiss();
                }
                aMPSNativeAdExpressListener.onAdClosed(getNativeExpressAdView());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void destroy() {
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public View getNativeExpressAdView() {
        INativeAdView iNativeAdView = this.asnpNativeExpressAd;
        if (iNativeAdView != null) {
            return iNativeAdView.getExpressAdView();
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void render() {
        AMPSNativeAdapter aMPSNativeAdapter = this.adapter;
        if (aMPSNativeAdapter != null) {
            aMPSNativeAdapter.onRender();
        }
        INativeAdView iNativeAdView = this.asnpNativeExpressAd;
        if (iNativeAdView != null) {
            iNativeAdView.render();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void setAMPSNativeAdExpressListener(final AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        INativeAdView iNativeAdView = this.asnpNativeExpressAd;
        if (iNativeAdView != null) {
            iNativeAdView.setINativeExpressAdListener(new INativeExpressAdListener() { // from class: xyz.adscope.amps.adapter.asnp.data.ASNPNativeAd.1
                @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeExpressAdListener
                public void onAdClicked(View view, int i4) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onAdClicked");
                    if (ASNPNativeAd.this.adapter != null) {
                        ASNPNativeAd.this.adapter.onAdClicked();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdClicked();
                    }
                }

                @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeExpressAdListener
                public void onAdClose(View view) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onAdClose");
                    try {
                        if (ASNPNativeAd.this.adapter != null) {
                            ASNPNativeAd.this.adapter.onAdDismiss();
                        }
                        AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                        if (aMPSNativeAdExpressListener2 != null) {
                            aMPSNativeAdExpressListener2.onAdClosed(ASNPNativeAd.this.getNativeExpressAdView());
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }

                @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeExpressAdListener
                public void onAdExposure(View view, int i4) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onAdExposure()");
                    if (ASNPNativeAd.this.adapter != null) {
                        ASNPNativeAd.this.adapter.onAdShow();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onAdShow();
                    }
                }

                @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeExpressAdListener
                public void onAdShow(View view, int i4) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onAdShow");
                }

                @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeExpressAdListener
                public void onRenderFail(View view, String str, int i4) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onRenderFail() code : " + i4 + " , msg : " + str);
                    if (ASNPNativeAd.this.adapter != null) {
                        ASNPNativeAd.this.adapter.onAdShowFailed(String.valueOf(i4), str);
                        AMPSNativeAdapter aMPSNativeAdapter = ASNPNativeAd.this.adapter;
                        aMPSNativeAdapter.onRenderFail(new AMPSError(i4 + "", str));
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onRenderFail(view, str, i4);
                    }
                }

                @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeExpressAdListener
                public void onRenderSuccess(View view, float f4, float f5) {
                    AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd  onRenderSuccess");
                    if (ASNPNativeAd.this.adapter != null) {
                        ASNPNativeAd.this.adapter.onRenderSuccess();
                    }
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener2 = aMPSNativeAdExpressListener;
                    if (aMPSNativeAdExpressListener2 != null) {
                        aMPSNativeAdExpressListener2.onRenderSuccess(view, f4, f5);
                    }
                }
            });
            this.asnpNativeExpressAd.setINativeDislikeListener(new INativeDislikeListener() { // from class: xyz.adscope.amps.adapter.asnp.data.a
                @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeDislikeListener
                public final void onAdCloseButtonClick(View view) {
                    ASNPNativeAd.this.lambda$setAMPSNativeAdExpressListener$0(aMPSNativeAdExpressListener, view);
                }
            });
        }
    }
}
