package com.beizi.fusion.model;

import android.content.Context;
import android.os.Debug;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.DeviceUtil;
import com.beizi.fusion.p072g.EmulatorCheckUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class EnvInfo {
    private String developerMode;
    private String isDebugApk;
    private String isLockScreen;
    private String isSimulator;
    private String isUsb;
    private String isWifiProxy;
    private String isp;

    /* renamed from: net  reason: collision with root package name */
    private String f47183net;
    private String userAgent;
    private String isDebugConnected = String.valueOf(Debug.isDebuggerConnected());
    private String isVpn = String.valueOf(C3138av.m48300b());

    public EnvInfo(Context context) {
        this.userAgent = C3137at.m48316a(context, TTDownloadField.TT_USERAGENT);
        this.f47183net = String.valueOf(DeviceUtil.m48216b(context));
        this.isp = String.valueOf(DeviceUtil.m48218a(context));
        this.developerMode = String.valueOf(C3138av.m48290h(context));
        this.isDebugApk = String.valueOf(C3138av.m48291g(context));
        this.isWifiProxy = String.valueOf(C3138av.m48289i(context));
        this.isSimulator = String.valueOf(EmulatorCheckUtil.m48200a().m48199a(context));
    }

    public String getIsp() {
        return this.isp;
    }

    public String getNet() {
        return this.f47183net;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String isDeveloperMode() {
        return this.developerMode;
    }

    public String isIsDebugApk() {
        return this.isDebugApk;
    }

    public String isIsDebugConnected() {
        return this.isDebugConnected;
    }

    public String isIsLockScreen() {
        return this.isLockScreen;
    }

    public String isIsSimulator() {
        return this.isSimulator;
    }

    public String isIsUsb() {
        return this.isUsb;
    }

    public String isIsVpn() {
        return this.isVpn;
    }

    public String isIsWifiProxy() {
        return this.isWifiProxy;
    }

    public void setDeveloperMode(String str) {
        this.developerMode = str;
    }

    public void setIsDebugApk(String str) {
        this.isDebugApk = str;
    }

    public void setIsDebugConnected(String str) {
        this.isDebugConnected = str;
    }

    public void setIsLockScreen(String str) {
        this.isLockScreen = str;
    }

    public void setIsSimulator(String str) {
        this.isSimulator = str;
    }

    public void setIsUsb(String str) {
        this.isUsb = str;
    }

    public void setIsVpn(String str) {
        this.isVpn = str;
    }

    public void setIsWifiProxy(String str) {
        this.isWifiProxy = str;
    }

    public void setIsp(String str) {
        this.isp = str;
    }

    public void setNet(String str) {
        this.f47183net = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }
}
