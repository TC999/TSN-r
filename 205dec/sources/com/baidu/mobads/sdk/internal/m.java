package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class m extends ae {

    /* renamed from: q  reason: collision with root package name */
    private CpuChannelListManager.CpuChannelListListener f12883q;

    /* renamed from: r  reason: collision with root package name */
    private String f12884r;

    /* renamed from: s  reason: collision with root package name */
    private int f12885s;

    public m(Context context) {
        super(context);
    }

    public void a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.f12883q = cpuChannelListListener;
    }

    public void a(String str, int i4) {
        this.f12884r = str;
        this.f12885s = i4;
    }

    @Override // com.baidu.mobads.sdk.internal.ae, com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.f12484k == null) {
            this.f12485l = false;
            return;
        }
        this.f12485l = true;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("prod", "cpu");
            this.f12484k.createProdHandler(jSONObject2);
            n nVar = new n(this);
            this.f12484k.addEventListener(x.aq, nVar);
            this.f12484k.addEventListener(x.ar, nVar);
            jSONObject.put("appsid", this.f12884r);
            jSONObject.put("subChannelId", this.f12885s);
            jSONObject.put("event_type", "cpu_channelIds");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        a(jSONObject);
    }
}
