package com.kwad.sdk.commercial;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.C11164d;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.commercial.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9821c {
    public double aoa = 0.01d;
    public double aob = 1.0d;
    public double aoc = 0.001d;
    public BusinessType aod = BusinessType.OTHER;
    public SubBusinessType aoe = SubBusinessType.OTHER;
    public C11164d aof;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String primaryKey;
    public String tag;

    private C9821c() {
    }

    /* renamed from: AJ */
    public static C9821c m27636AJ() {
        return new C9821c();
    }

    /* renamed from: N */
    public final C9821c m27635N(String str, String str2) {
        this.eventId = str;
        this.primaryKey = str2;
        return this;
    }

    /* renamed from: a */
    public final C9821c m27634a(BusinessType businessType) {
        this.aod = businessType;
        return this;
    }

    /* renamed from: cu */
    public final C9821c m27631cu(String str) {
        this.category = str;
        return this;
    }

    /* renamed from: cv */
    public final C9821c m27630cv(String str) {
        this.tag = str;
        return this;
    }

    @Deprecated
    /* renamed from: h */
    public final C9821c m27629h(JSONObject jSONObject) {
        this.msg = jSONObject;
        return this;
    }

    /* renamed from: i */
    public final C9821c m27628i(double d) {
        this.aoa = d;
        return this;
    }

    /* renamed from: j */
    public final C9821c m27627j(double d) {
        this.aob = d;
        return this;
    }

    /* renamed from: k */
    public final C9821c m27626k(double d) {
        this.aoc = 0.001d;
        return this;
    }

    @NonNull
    public final String toString() {
        return "ReportItem{category='" + this.category + "', eventId='" + this.eventId + "', bizType='" + this.aod + "', primaryKey='" + this.primaryKey + "', msg=" + this.msg + '}';
    }

    /* renamed from: u */
    public final C9821c m27625u(AbstractC9822a abstractC9822a) {
        this.msg = abstractC9822a.toJson();
        return this;
    }

    /* renamed from: a */
    public final C9821c m27633a(SubBusinessType subBusinessType) {
        this.aoe = subBusinessType;
        return this;
    }

    /* renamed from: a */
    public final C9821c m27632a(C11164d c11164d) {
        this.aof = c11164d;
        return this;
    }
}
