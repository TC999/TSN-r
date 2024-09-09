package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUAggregationManager;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeCPUAggregationData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ak extends bj {

    /* renamed from: a  reason: collision with root package name */
    private CPUAggregationManager.CPUAggregationListener f12352a;

    /* renamed from: q  reason: collision with root package name */
    private String f12353q;

    /* renamed from: r  reason: collision with root package name */
    private int f12354r;

    /* renamed from: s  reason: collision with root package name */
    private int f12355s;

    /* renamed from: t  reason: collision with root package name */
    private int f12356t;

    /* renamed from: u  reason: collision with root package name */
    private int[] f12357u;

    /* renamed from: v  reason: collision with root package name */
    private HashMap<String, Object> f12358v;

    public ak(Context context, String str) {
        super(context);
        this.f12357u = new int[]{1098};
        this.f12353q = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.f12484k == null) {
            this.f12485l = false;
            return;
        }
        this.f12485l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("prod", "cpu_hot");
            this.f12484k.createProdHandler(jSONObject3);
            n();
            jSONObject.put("prod", "cpu_hot");
            jSONObject.put("appsid", this.f12353q);
            jSONObject.put("pageIndex", this.f12355s);
            jSONObject.put("pageSize", this.f12354r);
            jSONObject.put("channels", this.f12357u);
            if (!TextUtils.isEmpty(this.f12353q)) {
                jSONObject.put("appid", this.f12353q);
            }
            jSONObject2.put("timeout", this.f12356t);
            jSONObject2 = k.a(this.f12358v);
            jSONObject2.put("listScene", 503);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f12484k.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
        super.b(str, i4);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f12352a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f12352a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onExitLp();
        }
    }

    public void a(CPUAggregationManager.CPUAggregationListener cPUAggregationListener) {
        this.f12352a = cPUAggregationListener;
    }

    public void a(int i4, int i5, HashMap<String, Object> hashMap) {
        this.f12355s = i4;
        this.f12354r = i5;
        this.f12358v = hashMap;
    }

    public void a(int i4) {
        this.f12356t = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        if (this.f12352a != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Object obj : (List) iOAdEvent.getData().get("cpuHotList")) {
                    arrayList.add(new NativeCPUAggregationData(this.f12481h, obj, this.f12358v));
                }
                this.f12352a.onHotContentLoaded(arrayList);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i4, String str) {
        super.a(i4, str);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f12352a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i4);
        }
    }
}
