package com.kwad.sdk.commercial;

import androidx.annotation.NonNull;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    public double aoa = 0.01d;
    public double aob = 1.0d;
    public double aoc = 0.001d;
    public BusinessType aod = BusinessType.OTHER;
    public SubBusinessType aoe = SubBusinessType.OTHER;
    public com.kwai.adclient.kscommerciallogger.model.d aof;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String primaryKey;
    public String tag;

    private c() {
    }

    public static c AJ() {
        return new c();
    }

    public final c N(String str, String str2) {
        this.eventId = str;
        this.primaryKey = str2;
        return this;
    }

    public final c a(BusinessType businessType) {
        this.aod = businessType;
        return this;
    }

    public final c cu(String str) {
        this.category = str;
        return this;
    }

    public final c cv(String str) {
        this.tag = str;
        return this;
    }

    @Deprecated
    public final c h(JSONObject jSONObject) {
        this.msg = jSONObject;
        return this;
    }

    public final c i(double d4) {
        this.aoa = d4;
        return this;
    }

    public final c j(double d4) {
        this.aob = d4;
        return this;
    }

    public final c k(double d4) {
        this.aoc = 0.001d;
        return this;
    }

    @NonNull
    public final String toString() {
        return "ReportItem{category='" + this.category + "', eventId='" + this.eventId + "', bizType='" + this.aod + "', primaryKey='" + this.primaryKey + "', msg=" + this.msg + '}';
    }

    public final c u(com.kwad.sdk.commercial.c.a aVar) {
        this.msg = aVar.toJson();
        return this;
    }

    public final c a(SubBusinessType subBusinessType) {
        this.aoe = subBusinessType;
        return this;
    }

    public final c a(com.kwai.adclient.kscommerciallogger.model.d dVar) {
        this.aof = dVar;
        return this;
    }
}
