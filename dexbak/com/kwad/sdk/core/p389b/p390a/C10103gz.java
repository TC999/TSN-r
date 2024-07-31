package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.network.C10434j;
import com.kwad.sdk.utils.C11126t;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gz */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10103gz implements InterfaceC10273d<C10434j> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10434j c10434j, JSONObject jSONObject) {
        m26882a(c10434j, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10434j c10434j, JSONObject jSONObject) {
        return m26881b(c10434j, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26882a(C10434j c10434j, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10434j.avQ = jSONObject.optLong("request_prepare_cost");
        c10434j.avR = jSONObject.optLong("request_add_params_cost");
        c10434j.avS = jSONObject.optLong("request_create_cost");
        c10434j.avT = jSONObject.optInt("keep_alive");
        c10434j.avU = jSONObject.optLong("dns_start");
        c10434j.avV = jSONObject.optLong("dns_cost");
        c10434j.avW = jSONObject.optLong("connect_establish_start");
        c10434j.avX = jSONObject.optLong("connect_establish_cost");
        c10434j.avY = jSONObject.optLong("request_start");
        c10434j.avZ = jSONObject.optLong("request_cost");
        c10434j.awa = jSONObject.optLong("request_size");
        c10434j.awb = jSONObject.optLong("response_start");
        c10434j.awc = jSONObject.optLong("response_cost");
        c10434j.awd = jSONObject.optLong("response_parse_cost");
        c10434j.awe = jSONObject.optLong("response_size");
        c10434j.awf = jSONObject.optLong("waiting_response_cost");
        c10434j.awg = jSONObject.optLong("total_cost");
        c10434j.awh = jSONObject.optInt("proxy_used");
        c10434j.awi = jSONObject.optString("request_id");
        if (JSONObject.NULL.toString().equals(c10434j.awi)) {
            c10434j.awi = "";
        }
        c10434j.awj = jSONObject.optInt("has_data_v2");
        c10434j.result = jSONObject.optInt(CommonNetImpl.RESULT);
        c10434j.awk = jSONObject.optLong("response_done_cost");
        c10434j.awl = jSONObject.optString("host_ip");
        if (JSONObject.NULL.toString().equals(c10434j.awl)) {
            c10434j.awl = "";
        }
        c10434j.awm = jSONObject.optInt("ip_type");
        c10434j.awn = jSONObject.optInt("recommend_ping_time");
        c10434j.awo = jSONObject.optInt("backup_ping_time");
        c10434j.awp = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26881b(C10434j c10434j, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c10434j.avQ;
        if (j != 0) {
            C11126t.putValue(jSONObject, "request_prepare_cost", j);
        }
        long j2 = c10434j.avR;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "request_add_params_cost", j2);
        }
        long j3 = c10434j.avS;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "request_create_cost", j3);
        }
        int i = c10434j.avT;
        if (i != 0) {
            C11126t.putValue(jSONObject, "keep_alive", i);
        }
        long j4 = c10434j.avU;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "dns_start", j4);
        }
        long j5 = c10434j.avV;
        if (j5 != 0) {
            C11126t.putValue(jSONObject, "dns_cost", j5);
        }
        long j6 = c10434j.avW;
        if (j6 != 0) {
            C11126t.putValue(jSONObject, "connect_establish_start", j6);
        }
        long j7 = c10434j.avX;
        if (j7 != 0) {
            C11126t.putValue(jSONObject, "connect_establish_cost", j7);
        }
        long j8 = c10434j.avY;
        if (j8 != 0) {
            C11126t.putValue(jSONObject, "request_start", j8);
        }
        long j9 = c10434j.avZ;
        if (j9 != 0) {
            C11126t.putValue(jSONObject, "request_cost", j9);
        }
        long j10 = c10434j.awa;
        if (j10 != 0) {
            C11126t.putValue(jSONObject, "request_size", j10);
        }
        long j11 = c10434j.awb;
        if (j11 != 0) {
            C11126t.putValue(jSONObject, "response_start", j11);
        }
        long j12 = c10434j.awc;
        if (j12 != 0) {
            C11126t.putValue(jSONObject, "response_cost", j12);
        }
        long j13 = c10434j.awd;
        if (j13 != 0) {
            C11126t.putValue(jSONObject, "response_parse_cost", j13);
        }
        long j14 = c10434j.awe;
        if (j14 != 0) {
            C11126t.putValue(jSONObject, "response_size", j14);
        }
        long j15 = c10434j.awf;
        if (j15 != 0) {
            C11126t.putValue(jSONObject, "waiting_response_cost", j15);
        }
        long j16 = c10434j.awg;
        if (j16 != 0) {
            C11126t.putValue(jSONObject, "total_cost", j16);
        }
        int i2 = c10434j.awh;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "proxy_used", i2);
        }
        String str = c10434j.awi;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "request_id", c10434j.awi);
        }
        int i3 = c10434j.awj;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "has_data_v2", i3);
        }
        int i4 = c10434j.result;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, CommonNetImpl.RESULT, i4);
        }
        long j17 = c10434j.awk;
        if (j17 != 0) {
            C11126t.putValue(jSONObject, "response_done_cost", j17);
        }
        String str2 = c10434j.awl;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "host_ip", c10434j.awl);
        }
        int i5 = c10434j.awm;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "ip_type", i5);
        }
        int i6 = c10434j.awn;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "recommend_ping_time", i6);
        }
        int i7 = c10434j.awo;
        if (i7 != 0) {
            C11126t.putValue(jSONObject, "backup_ping_time", i7);
        }
        int i8 = c10434j.awp;
        if (i8 != 0) {
            C11126t.putValue(jSONObject, "other_ping_time", i8);
        }
        return jSONObject;
    }
}
