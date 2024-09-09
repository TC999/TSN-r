package xyz.adscope.amps.adapter.gdt.data;

import android.view.View;
import com.qq.e.ads.nativ.NativeExpressADView;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.gdt.GDTNativeAdapter;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class GDTNativeAd implements AMPSNativeAdExpressInfo {
    public GDTNativeAdapter adapter;
    public NativeExpressADView gdtNativeExpressAd;

    public GDTNativeAd(NativeExpressADView nativeExpressADView, GDTNativeAdapter gDTNativeAdapter) {
        this.gdtNativeExpressAd = nativeExpressADView;
        this.adapter = gDTNativeAdapter;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void destroy() {
        try {
            NativeExpressADView nativeExpressADView = this.gdtNativeExpressAd;
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
                this.gdtNativeExpressAd = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public View getNativeExpressAdView() {
        NativeExpressADView nativeExpressADView = this.gdtNativeExpressAd;
        if (nativeExpressADView != null) {
            return nativeExpressADView;
        }
        return null;
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void render() {
        GDTNativeAdapter gDTNativeAdapter = this.adapter;
        if (gDTNativeAdapter != null) {
            gDTNativeAdapter.onRender();
        }
        NativeExpressADView nativeExpressADView = this.gdtNativeExpressAd;
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo
    public void setAMPSNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        GDTNativeAdapter gDTNativeAdapter = this.adapter;
        if (gDTNativeAdapter != null) {
            gDTNativeAdapter.setAMPSNativeAdExpressListener(this.gdtNativeExpressAd, aMPSNativeAdExpressListener);
        }
    }
}
