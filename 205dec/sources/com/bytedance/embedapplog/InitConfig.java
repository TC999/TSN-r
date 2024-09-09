package com.bytedance.embedapplog;

import androidx.annotation.NonNull;
import com.bytedance.embedapplog.util.UriConfig;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class InitConfig {

    /* renamed from: a  reason: collision with root package name */
    private UriConfig f26675a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    private String f26676c;
    private String eq;
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private String f26677f;
    private int fp;
    private String fz;

    /* renamed from: i  reason: collision with root package name */
    private String f26678i;
    private int ia;

    /* renamed from: j  reason: collision with root package name */
    private String f26679j;

    /* renamed from: k  reason: collision with root package name */
    private String f26680k;
    private String ls;
    private ISensitiveInfoProvider me;

    /* renamed from: p  reason: collision with root package name */
    private String f26682p;

    /* renamed from: q  reason: collision with root package name */
    private String f26683q;

    /* renamed from: r  reason: collision with root package name */
    private IPicker f26684r;

    /* renamed from: s  reason: collision with root package name */
    private String f26685s;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private String f26686t;

    /* renamed from: u  reason: collision with root package name */
    private String f26687u;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f26688w;
    private String xv;

    /* renamed from: y  reason: collision with root package name */
    private String f26689y;
    private int ys;
    private int gd = 0;
    private boolean gb = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f26681n = true;
    private boolean ck = true;

    /* renamed from: z  reason: collision with root package name */
    private String f26690z = null;
    private boolean ba = true;

    public InitConfig(@NonNull String str, @NonNull String str2) {
        this.f26676c = str;
        this.f26688w = str2;
    }

    public String geCustomerAndroidId() {
        return this.f26690z;
    }

    public String getAbClient() {
        return this.fz;
    }

    public String getAbFeature() {
        return this.f26683q;
    }

    public String getAbGroup() {
        return this.f26678i;
    }

    public String getAbVersion() {
        return this.f26687u;
    }

    public String getAid() {
        return this.f26676c;
    }

    public String getAliyunUdid() {
        return this.f26677f;
    }

    public String getAppBuildSerial() {
        return this.eq;
    }

    public String getAppImei() {
        return this.f26689y;
    }

    public String getAppName() {
        return this.f26680k;
    }

    public String getChannel() {
        return this.f26688w;
    }

    public String getGoogleAid() {
        return this.xv;
    }

    public String getLanguage() {
        return this.sr;
    }

    public String getManifestVersion() {
        return this.f26685s;
    }

    public int getManifestVersionCode() {
        return this.ia;
    }

    public IPicker getPicker() {
        return this.f26684r;
    }

    public int getProcess() {
        return this.gd;
    }

    public String getRegion() {
        return this.ux;
    }

    public String getReleaseBuild() {
        return this.f26682p;
    }

    public ISensitiveInfoProvider getSensitiveInfoProvider() {
        return this.me;
    }

    public String getTweakedChannel() {
        return this.f26686t;
    }

    public int getUpdateVersionCode() {
        return this.fp;
    }

    public UriConfig getUriConfig() {
        return this.f26675a;
    }

    public String getVersion() {
        return this.bk;
    }

    public int getVersionCode() {
        return this.ys;
    }

    public String getVersionMinor() {
        return this.f26679j;
    }

    public String getZiJieCloudPkg() {
        return this.ls;
    }

    public boolean isAndroidIdEnable() {
        return this.ck;
    }

    public boolean isCanUseUploadPv() {
        return this.ba;
    }

    public boolean isImeiEnable() {
        return this.f26681n;
    }

    public boolean isMacEnable() {
        return this.gb;
    }

    public boolean isPlayEnable() {
        return this.ev;
    }

    public InitConfig setAbClient(String str) {
        this.fz = str;
        return this;
    }

    public InitConfig setAbFeature(String str) {
        this.f26683q = str;
        return this;
    }

    public InitConfig setAbGroup(String str) {
        this.f26678i = str;
        return this;
    }

    public InitConfig setAbVersion(String str) {
        this.f26687u = str;
        return this;
    }

    public InitConfig setAliyunUdid(String str) {
        this.f26677f = str;
        return this;
    }

    public void setAndroidIdEnable(boolean z3) {
        this.ck = z3;
    }

    public void setAppBuildSerial(String str) {
        this.eq = str;
    }

    public void setAppImei(String str) {
        this.f26689y = str;
    }

    public InitConfig setAppName(String str) {
        this.f26680k = str;
        return this;
    }

    public void setCanUseUploadPv(boolean z3) {
        this.ba = z3;
    }

    public void setCustomerAndroidId(String str) {
        this.f26690z = str;
    }

    @NonNull
    public InitConfig setEnablePlay(boolean z3) {
        this.ev = z3;
        return this;
    }

    @NonNull
    public InitConfig setGoogleAid(String str) {
        this.xv = str;
        return this;
    }

    public void setImeiEnable(boolean z3) {
        this.f26681n = z3;
    }

    @NonNull
    public InitConfig setLanguage(String str) {
        this.sr = str;
        return this;
    }

    public void setMacEnable(boolean z3) {
        this.gb = z3;
    }

    public InitConfig setManifestVersion(String str) {
        this.f26685s = str;
        return this;
    }

    public InitConfig setManifestVersionCode(int i4) {
        this.ia = i4;
        return this;
    }

    @NonNull
    public InitConfig setPicker(IPicker iPicker) {
        this.f26684r = iPicker;
        return this;
    }

    @NonNull
    public InitConfig setProcess(int i4) {
        this.gd = i4;
        return this;
    }

    @NonNull
    public InitConfig setRegion(String str) {
        this.ux = str;
        return this;
    }

    @NonNull
    public InitConfig setReleaseBuild(String str) {
        this.f26682p = str;
        return this;
    }

    public void setSensitiveInfoProvider(ISensitiveInfoProvider iSensitiveInfoProvider) {
        this.me = iSensitiveInfoProvider;
    }

    public InitConfig setTweakedChannel(String str) {
        this.f26686t = str;
        return this;
    }

    public InitConfig setUpdateVersionCode(int i4) {
        this.fp = i4;
        return this;
    }

    public InitConfig setUriConfig(int i4) {
        this.f26675a = UriConfig.createUriConfig(i4);
        return this;
    }

    public InitConfig setVersion(String str) {
        this.bk = str;
        return this;
    }

    public InitConfig setVersionCode(int i4) {
        this.ys = i4;
        return this;
    }

    public InitConfig setVersionMinor(String str) {
        this.f26679j = str;
        return this;
    }

    public InitConfig setZiJieCloudPkg(String str) {
        this.ls = str;
        return this;
    }

    public InitConfig setUriConfig(UriConfig uriConfig) {
        this.f26675a = uriConfig;
        return this;
    }
}
