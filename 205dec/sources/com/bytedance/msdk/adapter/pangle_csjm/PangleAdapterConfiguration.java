package com.bytedance.msdk.adapter.pangle_csjm;

import android.content.Context;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.c.sr;
import com.bytedance.msdk.core.w;
import com.bytedance.sdk.gromore.init.c;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleAdapterConfiguration extends PluginInitAdapterConfiguration {
    private void c(ValueSet valueSet) {
        if (valueSet != null) {
            xv();
        }
    }

    private String w() {
        return c.sr();
    }

    private void xv() {
        PangleAdapterUtils.setPangleData(PangleAdapterUtils.updateJsonArrayStr(PangleAdapterUtils.getPangleData(), "personal_ads_type", this.f27201c.isLimitPersonalAds() ? "0" : "1"));
    }

    @Override // com.bytedance.msdk.adapter.pangle_csjm.PluginInitAdapterConfiguration
    public <T> T callFunction(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8101) {
            return (T) String.valueOf(c() + ".0");
        } else if (i4 == 8104) {
            try {
                return (T) c();
            } catch (Exception unused) {
                return "0.0";
            }
        } else if (i4 == 8105) {
            return (T) this.f27201c.getGromoreVersion();
        } else {
            if (i4 == 8124) {
                ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8517, ValueSet.class);
                this.f27201c.setMediationCustomControllerValueSet(valueSet2);
                c(valueSet2);
            } else if (i4 == 8102) {
                Context context = (Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
                Map<String, Object> map = (Map) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, Map.class);
                if (context != null && map != null) {
                    return (T) getBiddingToken(context, map);
                }
            } else if (i4 == 8244) {
                return (T) w();
            } else {
                if (i4 == 8242) {
                    c((Map) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, Map.class));
                }
            }
            return (T) com.bytedance.msdk.core.s.c.c(cls);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        if (r4 == 2) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
        r2 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
        if (r4 == 7) goto L93;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getBiddingToken(android.content.Context r18, java.util.Map<java.lang.String, java.lang.Object> r19) {
        /*
            Method dump skipped, instructions count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterConfiguration.getBiddingToken(android.content.Context, java.util.Map):java.lang.String");
    }

    @Override // com.bytedance.msdk.adapter.pangle_csjm.PluginInitAdapterConfiguration
    public void realInitAdn(Context context, PluginInitConfig pluginInitConfig) {
        this.f27201c = w.k().w();
        xv();
        c(pluginInitConfig);
    }

    private String c() {
        return c.xv();
    }

    private void c(PluginInitConfig pluginInitConfig) {
        Bridge initCallback;
        if (pluginInitConfig == null || (initCallback = pluginInitConfig.getInitCallback()) == null) {
            return;
        }
        b a4 = b.a();
        a4.h(AVMDLDataLoader.KeyIsLiveContainerString, this);
        initCallback.call(8122, a4.l(), Void.class);
    }

    private void c(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Object obj = map.get(sr.ux);
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (intValue == 0 || intValue == 1) {
            c.c(intValue);
        }
    }
}
