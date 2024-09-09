package com.qq.e.comm.plugin.b;

import com.qq.e.comm.pi.AdData;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n implements AdData, com.qq.e.comm.plugin.e0.b {

    /* renamed from: c  reason: collision with root package name */
    private final p f42033c;

    /* renamed from: d  reason: collision with root package name */
    private AdData.VideoPlayer f42034d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Object> f42035e;

    public n(p pVar, Map<String, Object> map) {
        this.f42033c = pVar == null ? new o() : pVar;
        this.f42035e = map;
    }

    public void a(AdData.VideoPlayer videoPlayer) {
        this.f42034d = videoPlayer;
    }

    @Override // com.qq.e.comm.pi.AdData
    public boolean equalsAdData(AdData adData) {
        if (this == adData) {
            return true;
        }
        if (adData == null) {
            return false;
        }
        String property = getProperty("ad_id");
        String property2 = adData.getProperty("ad_id");
        if (property != null) {
            return property.equals(property2);
        }
        return property2 == null;
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getAdPatternType() {
        return this.f42033c.b("ad_pattern_type");
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getDesc() {
        return this.f42033c.c("ad_desc");
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getECPM() {
        return this.f42033c.b("ad_ecpm");
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getECPMLevel() {
        return this.f42033c.c("ad_ecpm_level");
    }

    @Override // com.qq.e.comm.pi.AdData
    public Map<String, Object> getExtraInfo() {
        return this.f42035e;
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public int getMediationPrice() {
        return this.f42033c.b("ad_mp");
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getProperty(String str) {
        return this.f42033c.c(str);
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getTitle() {
        return this.f42033c.c("ad_title");
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getVideoDuration() {
        return this.f42033c.b("ad_video_duration");
    }

    @Override // com.qq.e.comm.pi.AdData
    public void setECPMLevel(String str) {
        this.f42033c.a("ad_ecpm_level", str);
    }

    @Override // com.qq.e.comm.plugin.e0.b
    public void setMediationId(String str) {
    }

    public boolean a() {
        return this.f42033c.a("ad_contract_ad");
    }

    @Override // com.qq.e.comm.pi.AdData
    public <T> T getProperty(Class<T> cls) {
        if (cls == AdData.VideoPlayer.class) {
            return (T) this.f42034d;
        }
        if (cls == p.class) {
            return (T) this.f42033c;
        }
        return null;
    }
}
