package com.bytedance.msdk.api.sr;

import com.bytedance.msdk.adapter.pangle_csjm.PluginInitConfig;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk {
    public static bk c(final PluginInitConfig pluginInitConfig) {
        return new bk() { // from class: com.bytedance.msdk.api.sr.bk.1
            @Override // com.bytedance.msdk.api.sr.bk
            public boolean c() {
                PluginInitConfig pluginInitConfig2 = PluginInitConfig.this;
                if (pluginInitConfig2 != null) {
                    return pluginInitConfig2.isCanUseLocation();
                }
                return super.c();
            }

            @Override // com.bytedance.msdk.api.sr.bk
            public boolean w() {
                PluginInitConfig pluginInitConfig2 = PluginInitConfig.this;
                if (pluginInitConfig2 != null) {
                    return pluginInitConfig2.isCanUsePhoneState();
                }
                return super.w();
            }

            @Override // com.bytedance.msdk.api.sr.bk
            public boolean xv() {
                PluginInitConfig pluginInitConfig2 = PluginInitConfig.this;
                if (pluginInitConfig2 != null) {
                    return pluginInitConfig2.isCanUseAndroidId();
                }
                return super.xv();
            }
        };
    }

    public boolean c() {
        return true;
    }

    public boolean w() {
        return true;
    }

    public boolean xv() {
        return true;
    }
}
