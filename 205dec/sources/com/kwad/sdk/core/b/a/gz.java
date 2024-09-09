package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class gz implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.avQ = jSONObject.optLong("request_prepare_cost");
        jVar.avR = jSONObject.optLong("request_add_params_cost");
        jVar.avS = jSONObject.optLong("request_create_cost");
        jVar.avT = jSONObject.optInt("keep_alive");
        jVar.avU = jSONObject.optLong("dns_start");
        jVar.avV = jSONObject.optLong("dns_cost");
        jVar.avW = jSONObject.optLong("connect_establish_start");
        jVar.avX = jSONObject.optLong("connect_establish_cost");
        jVar.avY = jSONObject.optLong("request_start");
        jVar.avZ = jSONObject.optLong("request_cost");
        jVar.awa = jSONObject.optLong("request_size");
        jVar.awb = jSONObject.optLong("response_start");
        jVar.awc = jSONObject.optLong("response_cost");
        jVar.awd = jSONObject.optLong("response_parse_cost");
        jVar.awe = jSONObject.optLong("response_size");
        jVar.awf = jSONObject.optLong("waiting_response_cost");
        jVar.awg = jSONObject.optLong("total_cost");
        jVar.awh = jSONObject.optInt("proxy_used");
        jVar.awi = jSONObject.optString(ConstantAd.KEY_CACHE_AD);
        if (JSONObject.NULL.toString().equals(jVar.awi)) {
            jVar.awi = "";
        }
        jVar.awj = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt("result");
        jVar.awk = jSONObject.optLong("response_done_cost");
        jVar.awl = jSONObject.optString("host_ip");
        if (JSONObject.NULL.toString().equals(jVar.awl)) {
            jVar.awl = "";
        }
        jVar.awm = jSONObject.optInt("ip_type");
        jVar.awn = jSONObject.optInt("recommend_ping_time");
        jVar.awo = jSONObject.optInt("backup_ping_time");
        jVar.awp = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = jVar.avQ;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_prepare_cost", j4);
        }
        long j5 = jVar.avR;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_add_params_cost", j5);
        }
        long j6 = jVar.avS;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_create_cost", j6);
        }
        int i4 = jVar.avT;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "keep_alive", i4);
        }
        long j7 = jVar.avU;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dns_start", j7);
        }
        long j8 = jVar.avV;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dns_cost", j8);
        }
        long j9 = jVar.avW;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connect_establish_start", j9);
        }
        long j10 = jVar.avX;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connect_establish_cost", j10);
        }
        long j11 = jVar.avY;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_start", j11);
        }
        long j12 = jVar.avZ;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_cost", j12);
        }
        long j13 = jVar.awa;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_size", j13);
        }
        long j14 = jVar.awb;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_start", j14);
        }
        long j15 = jVar.awc;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_cost", j15);
        }
        long j16 = jVar.awd;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_parse_cost", j16);
        }
        long j17 = jVar.awe;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_size", j17);
        }
        long j18 = jVar.awf;
        if (j18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "waiting_response_cost", j18);
        }
        long j19 = jVar.awg;
        if (j19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_cost", j19);
        }
        int i5 = jVar.awh;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "proxy_used", i5);
        }
        String str = jVar.awi;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ConstantAd.KEY_CACHE_AD, jVar.awi);
        }
        int i6 = jVar.awj;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "has_data_v2", i6);
        }
        int i7 = jVar.result;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "result", i7);
        }
        long j20 = jVar.awk;
        if (j20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_done_cost", j20);
        }
        String str2 = jVar.awl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "host_ip", jVar.awl);
        }
        int i8 = jVar.awm;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ip_type", i8);
        }
        int i9 = jVar.awn;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "recommend_ping_time", i9);
        }
        int i10 = jVar.awo;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "backup_ping_time", i10);
        }
        int i11 = jVar.awp;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "other_ping_time", i11);
        }
        return jSONObject;
    }
}
