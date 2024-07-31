package com.bytedance.sdk.openadsdk.live.core;

import com.bytedance.android.live.base.api.IHostPermission;
import com.bytedance.android.live.base.api.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTHostPermissionInner implements IHostPermission {

    /* renamed from: ok */
    private TTCustomController f22600ok;

    public TTHostPermissionInner(TTCustomController tTCustomController) {
        if (tTCustomController == null) {
            this.f22600ok = new TTCustomController() { // from class: com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner.1
            };
        } else {
            this.f22600ok = tTCustomController;
        }
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.alist();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getAndroidID() {
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getAndroidId();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevImei() {
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getDevImei();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevOaid() {
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getDevOaid();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getMacAddress() {
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getMacAddress();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public LocationProvider getTTLocation() {
        final com.bytedance.sdk.openadsdk.LocationProvider tTLocation;
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null || (tTLocation = tTCustomController.getTTLocation()) == null) {
            return null;
        }
        return new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner.2
            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLatitude() {
                return tTLocation.getLatitude();
            }

            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLongitude() {
                return tTLocation.getLongitude();
            }
        };
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanGetAndUseAndroidID() {
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseAndroidId();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null) {
            return true;
        }
        return tTCustomController.isCanUseLocation();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUsePhoneState();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseWifiState();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        TTCustomController tTCustomController = this.f22600ok;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseWriteExternal();
    }
}
