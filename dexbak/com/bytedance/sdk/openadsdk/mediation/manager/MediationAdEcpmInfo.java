package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationAdEcpmInfo {

    /* renamed from: a */
    private String f22817a;

    /* renamed from: bl */
    private String f22818bl;

    /* renamed from: h */
    private String f22819h;

    /* renamed from: j */
    private String f22820j;

    /* renamed from: k */
    private String f22821k;

    /* renamed from: kf */
    private int f22822kf;

    /* renamed from: n */
    private String f22823n;

    /* renamed from: ok */
    private String f22824ok;

    /* renamed from: p */
    private String f22825p;

    /* renamed from: q */
    private String f22826q;

    /* renamed from: r */
    private String f22827r;

    /* renamed from: rh */
    private String f22828rh;

    /* renamed from: s */
    private String f22829s;

    /* renamed from: t */
    private Map<String, String> f22830t;

    /* renamed from: z */
    private String f22831z;

    public MediationAdEcpmInfo() {
        this.f22830t = new HashMap();
    }

    public String getAbTestId() {
        return this.f22831z;
    }

    public String getChannel() {
        return this.f22827r;
    }

    public Map<String, String> getCustomData() {
        return this.f22830t;
    }

    public String getCustomSdkName() {
        return this.f22817a;
    }

    public String getEcpm() {
        return this.f22823n;
    }

    public String getErrorMsg() {
        return this.f22819h;
    }

    public String getLevelTag() {
        return this.f22829s;
    }

    public int getReqBiddingType() {
        return this.f22822kf;
    }

    public String getRequestId() {
        return this.f22825p;
    }

    public String getRitType() {
        return this.f22826q;
    }

    public String getScenarioId() {
        return this.f22828rh;
    }

    public String getSdkName() {
        return this.f22824ok;
    }

    public String getSegmentId() {
        return this.f22821k;
    }

    public String getSlotId() {
        return this.f22818bl;
    }

    public String getSubChannel() {
        return this.f22820j;
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.f22830t = hashMap;
        this.f22824ok = str;
        this.f22817a = str2;
        this.f22818bl = str3;
        this.f22829s = str4;
        this.f22823n = str5;
        this.f22822kf = i;
        this.f22819h = str6;
        this.f22825p = str7;
        this.f22826q = str8;
        this.f22821k = str9;
        this.f22827r = str10;
        this.f22820j = str11;
        this.f22831z = str12;
        this.f22828rh = str13;
        if (map != null) {
            this.f22830t = map;
        } else {
            hashMap.clear();
        }
    }
}
