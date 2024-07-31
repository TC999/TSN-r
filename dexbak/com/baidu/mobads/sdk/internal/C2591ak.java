package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUAggregationManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeCPUAggregationData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.ak */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2591ak extends AbstractC2619bg {

    /* renamed from: a */
    private CPUAggregationManager.CPUAggregationListener f8559a;

    /* renamed from: q */
    private String f8560q;

    /* renamed from: r */
    private int f8561r;

    /* renamed from: s */
    private int f8562s;

    /* renamed from: t */
    private int f8563t;

    /* renamed from: u */
    private int[] f8564u;

    /* renamed from: v */
    private HashMap<String, Object> f8565v;

    public C2591ak(Context context, String str) {
        super(context);
        this.f8564u = new int[]{1098};
        this.f8560q = str;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50356a() {
        if (this.f8666k == null) {
            this.f8667l = false;
            return;
        }
        this.f8667l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
            this.f8666k.createProdHandler(jSONObject3);
            m50805n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
            jSONObject.put("appsid", this.f8560q);
            jSONObject.put("pageIndex", this.f8562s);
            jSONObject.put("pageSize", this.f8561r);
            jSONObject.put("channels", this.f8564u);
            if (!TextUtils.isEmpty(this.f8560q)) {
                jSONObject.put("appid", this.f8560q);
            }
            jSONObject2.put("timeout", this.f8563t);
            jSONObject2 = C2714k.m50367a(this.f8565v);
            jSONObject2.put("listScene", 503);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f8666k.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        super.mo50442b(str, i);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f8559a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: d */
    public void mo50436d() {
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f8559a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onExitLp();
        }
    }

    /* renamed from: a */
    public void m51024a(CPUAggregationManager.CPUAggregationListener cPUAggregationListener) {
        this.f8559a = cPUAggregationListener;
    }

    /* renamed from: a */
    public void m51025a(int i, int i2, HashMap<String, Object> hashMap) {
        this.f8562s = i;
        this.f8561r = i2;
        this.f8565v = hashMap;
    }

    /* renamed from: a */
    public void m51026a(int i) {
        this.f8563t = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50455a(IOAdEvent iOAdEvent) {
        if (this.f8559a != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Object obj : (List) iOAdEvent.getData().get("cpuHotList")) {
                    arrayList.add(new NativeCPUAggregationData(this.f8663h, obj, this.f8565v));
                }
                this.f8559a.onHotContentLoaded(arrayList);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50459a(int i, String str) {
        super.mo50459a(i, str);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f8559a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i);
        }
    }
}
