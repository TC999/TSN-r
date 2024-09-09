package com.bytedance.msdk.adapter.pangle_csjm;

import android.content.Context;
import com.bytedance.msdk.adapter.c;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.sdk.openadsdk.core.wv;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import com.stub.StubApp;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleNativeLoader extends c {
    private void c(wv wvVar, w.c cVar) {
        if (this.xv.t() > 0.0f) {
            cVar.c(this.xv.bk()).w(this.xv.t());
        } else {
            cVar.c(this.xv.bk()).w(0.0f);
        }
        new PangleNativeExpressAd().loadAd(isClientBidding(), wvVar, cVar.c(), this);
    }

    private void w(wv wvVar, w.c cVar) {
        xv.w("TTMediationSDK", "PangleNativeLoader_loadNativeAd_renderControl:" + this.xv.ys());
        cVar.xv(this.xv.ys());
        new PangleNativeAd().loadAd(isClientBidding(), wvVar, cVar.c(), this);
    }

    @Override // com.bytedance.msdk.adapter.c
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.c
    public String getSdkVersion() {
        try {
            return com.bytedance.sdk.gromore.init.c.xv();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.c
    public void loadAd(Context context, Map<String, Object> map) {
        wv pluginCSJLoader;
        if (this.xv == null) {
            notifyAdFailed(new com.bytedance.msdk.api.c("load ad fail adSlot is null"));
        } else if (map == null || (pluginCSJLoader = getPluginCSJLoader(StubApp.getOrigApplicationContext(context.getApplicationContext()))) == null) {
        } else {
            w.c buildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(this.xv, getAdSlotId(), this.f26913c, getClientReqId(), getAdm(), false);
            int q3 = this.xv.q();
            int j4 = this.xv.j();
            if (q3 > 0 && j4 > 0) {
                buildPangleAdSlot.c(PangleAdapterUtils.dp2px(StubApp.getOrigApplicationContext(context.getApplicationContext()), q3)).w(PangleAdapterUtils.dp2px(context, j4));
            }
            Object obj = map.get("tt_ad_origin_type");
            if (obj != null) {
                int intValue = ((Integer) obj).intValue();
                if (intValue == 1) {
                    c(pluginCSJLoader, buildPangleAdSlot);
                } else if (intValue == 2) {
                    w(pluginCSJLoader, buildPangleAdSlot);
                } else if (intValue == 3) {
                    notifyAdFailed(new com.bytedance.msdk.api.c("\u6e32\u67d3\u7c7b\u578b\u9519\u8bef"));
                }
            }
        }
    }
}
