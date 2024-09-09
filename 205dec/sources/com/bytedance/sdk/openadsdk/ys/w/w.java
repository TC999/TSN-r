package com.bytedance.sdk.openadsdk.ys.w;

import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig;
import com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class w implements ITTLiveConfig {
    private static final TTCustomController c(final com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar) {
        return new TTCustomController() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.1
            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean alist() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.w();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getAndroidId() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.a();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevImei() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.gd();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevOaid() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.k();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getMacAddress() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.p();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public LocationProvider getTTLocation() {
                final com.bytedance.sdk.openadsdk.ys.w.xv.xv ev = com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.ev();
                return new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.1.1
                    @Override // com.bytedance.sdk.openadsdk.LocationProvider
                    public double getLatitude() {
                        com.bytedance.sdk.openadsdk.ys.w.xv.xv xvVar = ev;
                        if (xvVar != null) {
                            return xvVar.c();
                        }
                        return 0.0d;
                    }

                    @Override // com.bytedance.sdk.openadsdk.LocationProvider
                    public double getLongitude() {
                        com.bytedance.sdk.openadsdk.ys.w.xv.xv xvVar = ev;
                        if (xvVar != null) {
                            return xvVar.w();
                        }
                        return 0.0d;
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.f();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.c();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePermissionRecordAudio() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.r();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.xv();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.sr();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                return com.bytedance.sdk.openadsdk.ys.w.xv.sr.this.ux();
            }
        };
    }

    public abstract com.bytedance.sdk.openadsdk.ys.w.xv.sr c();

    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveConfig
    public TTHostPermissionInner getHostPermission() {
        return new TTHostPermissionInner(c(c()));
    }
}
