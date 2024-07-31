package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2716m extends C2585ae {

    /* renamed from: q */
    private CpuChannelListManager.CpuChannelListListener f9097q;

    /* renamed from: r */
    private String f9098r;

    /* renamed from: s */
    private int f9099s;

    public C2716m(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void m50355a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.f9097q = cpuChannelListListener;
    }

    /* renamed from: a */
    public void m50353a(String str, int i) {
        this.f9098r = str;
        this.f9099s = i;
    }

    @Override // com.baidu.mobads.sdk.internal.C2585ae, com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50356a() {
        if (this.f8666k == null) {
            this.f8667l = false;
            return;
        }
        this.f8667l = true;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.f8666k.createProdHandler(jSONObject2);
            C2717n c2717n = new C2717n(this);
            this.f8666k.addEventListener(C2736x.f9293ap, c2717n);
            this.f8666k.addEventListener(C2736x.f9294aq, c2717n);
            jSONObject.put("appsid", this.f9098r);
            jSONObject.put("subChannelId", this.f9099s);
            jSONObject.put("event_type", "cpu_channelIds");
        } catch (Exception e) {
            e.printStackTrace();
        }
        m50819a(jSONObject);
    }
}
