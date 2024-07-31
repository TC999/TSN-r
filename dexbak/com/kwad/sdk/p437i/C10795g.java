package com.kwad.sdk.p437i;

import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.i.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10795g {
    private JSONObject aJd;
    private boolean aJe;
    private Map<String, String> afK;
    private String appId;
    private JSONObject apq;
    private String atm;
    private String atn;
    private String ays;
    private String azo;
    private String azp;
    private String sdkVersion;

    private C10795g() {
    }

    /* renamed from: IX */
    public static C10795g m24860IX() {
        return new C10795g();
    }

    /* renamed from: IY */
    public final JSONObject m24859IY() {
        return this.aJd;
    }

    /* renamed from: IZ */
    public final boolean m24858IZ() {
        return this.aJe;
    }

    /* renamed from: Ja */
    public final String m24857Ja() {
        return this.ays;
    }

    /* renamed from: Jb */
    public final JSONObject m24856Jb() {
        return this.apq;
    }

    /* renamed from: bE */
    public final C10795g m24855bE(boolean z) {
        this.aJe = z;
        return this;
    }

    /* renamed from: fN */
    public final C10795g m24854fN(String str) {
        this.appId = str;
        return this;
    }

    /* renamed from: fO */
    public final C10795g m24853fO(String str) {
        this.sdkVersion = str;
        return this;
    }

    /* renamed from: fP */
    public final C10795g m24852fP(String str) {
        this.atn = str;
        return this;
    }

    /* renamed from: fQ */
    public final C10795g m24851fQ(String str) {
        this.azp = str;
        return this;
    }

    /* renamed from: fR */
    public final C10795g m24850fR(String str) {
        this.azo = str;
        return this;
    }

    /* renamed from: fS */
    public final C10795g m24849fS(String str) {
        this.atm = str;
        return this;
    }

    /* renamed from: fT */
    public final C10795g m24848fT(String str) {
        this.ays = str;
        return this;
    }

    /* renamed from: g */
    public final C10795g m24847g(Map<String, String> map) {
        this.afK = map;
        return this;
    }

    public final String getAndroidId() {
        return this.azo;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.azp;
    }

    public final String getImei() {
        return this.atm;
    }

    public final String getOaid() {
        return this.atn;
    }

    public final Map<String, String> getRequestHeader() {
        return this.afK;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    /* renamed from: m */
    public final C10795g m24846m(JSONObject jSONObject) {
        this.aJd = jSONObject;
        return this;
    }

    /* renamed from: n */
    public final C10795g m24845n(JSONObject jSONObject) {
        this.apq = jSONObject;
        return this;
    }
}
