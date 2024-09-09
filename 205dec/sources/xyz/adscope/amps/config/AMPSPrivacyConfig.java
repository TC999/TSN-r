package xyz.adscope.amps.config;

import android.content.pm.PackageInfo;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSPrivacyConfig {
    public String getAndroidId() {
        return null;
    }

    public List<PackageInfo> getAppList() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public String getMacAddress() {
        return "";
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseAppList() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseMacAddress() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseShakeAd() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }

    public boolean isSupportPersonalized() {
        return true;
    }
}
