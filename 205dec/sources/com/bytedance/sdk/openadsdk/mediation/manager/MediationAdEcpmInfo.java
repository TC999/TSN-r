package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationAdEcpmInfo {

    /* renamed from: a  reason: collision with root package name */
    private String f36191a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    private String f36192c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private int f36193f;
    private String gd;

    /* renamed from: k  reason: collision with root package name */
    private String f36194k;

    /* renamed from: p  reason: collision with root package name */
    private String f36195p;

    /* renamed from: r  reason: collision with root package name */
    private String f36196r;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private String f36197t;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f36198w;
    private String xv;
    private Map<String, String> ys;

    public MediationAdEcpmInfo() {
        this.ys = new HashMap();
    }

    public String getAbTestId() {
        return this.bk;
    }

    public String getChannel() {
        return this.f36194k;
    }

    public Map<String, String> getCustomData() {
        return this.ys;
    }

    public String getCustomSdkName() {
        return this.f36198w;
    }

    public String getEcpm() {
        return this.ux;
    }

    public String getErrorMsg() {
        return this.f36196r;
    }

    public String getLevelTag() {
        return this.sr;
    }

    public int getReqBiddingType() {
        return this.f36193f;
    }

    public String getRequestId() {
        return this.ev;
    }

    public String getRitType() {
        return this.gd;
    }

    public String getScenarioId() {
        return this.f36197t;
    }

    public String getSdkName() {
        return this.f36192c;
    }

    public String getSegmentId() {
        return this.f36195p;
    }

    public String getSlotId() {
        return this.xv;
    }

    public String getSubChannel() {
        return this.f36191a;
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i4, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.ys = hashMap;
        this.f36192c = str;
        this.f36198w = str2;
        this.xv = str3;
        this.sr = str4;
        this.ux = str5;
        this.f36193f = i4;
        this.f36196r = str6;
        this.ev = str7;
        this.gd = str8;
        this.f36195p = str9;
        this.f36194k = str10;
        this.f36191a = str11;
        this.bk = str12;
        this.f36197t = str13;
        if (map != null) {
            this.ys = map;
        } else {
            hashMap.clear();
        }
    }
}
