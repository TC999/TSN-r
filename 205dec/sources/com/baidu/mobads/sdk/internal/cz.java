package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cz implements u {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f12732a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f12733b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f12734c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ cv f12735d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cv cvVar, int i4, int i5, String str) {
        this.f12735d = cvVar;
        this.f12732a = i4;
        this.f12733b = i5;
        this.f12734c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f12735d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f12732a));
        hashMap.put("channelId", Integer.valueOf(this.f12733b));
        hashMap.put("novel_id", this.f12734c);
        this.f12735d.a("notify_impression", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z3) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f12735d.f());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f12735d.g()));
        hashMap.put("entry", Integer.valueOf(this.f12732a));
        hashMap.put("channelId", Integer.valueOf(this.f12733b));
        hashMap.put("novel_id", this.f12734c);
        hashMap.put("novel_info", jSONObject);
        this.f12735d.a("request_banner_ad_view", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f12735d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f12735d.g()));
        hashMap.put("entry", Integer.valueOf(this.f12732a));
        hashMap.put("channelId", Integer.valueOf(this.f12733b));
        hashMap.put("novel_id", this.f12734c);
        hashMap.put("novel_info", jSONObject);
        this.f12735d.a("request_int_ad_view", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f12732a));
        hashMap.put("channelId", Integer.valueOf(this.f12733b));
        hashMap.put("novel_id", this.f12734c);
        this.f12735d.a("request_shelf_ad_view", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f12735d.f());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f12735d.g()));
        hashMap.put("entry", Integer.valueOf(this.f12732a));
        hashMap.put("channelId", Integer.valueOf(this.f12733b));
        hashMap.put("novel_id", this.f12734c);
        hashMap.put("backgroundColor", Integer.valueOf(i4));
        this.f12735d.a("reader_background_status_change", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i4 = this.f12735d.i("get_cuid");
        String i5 = this.f12735d.i("get_imei");
        String i6 = this.f12735d.i("get_oaid");
        try {
            jSONObject.put("cuid", i4);
            jSONObject.put("imei", i5);
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, i6);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(long j4) {
        bv bvVar = this.f12735d.f12482i;
        bvVar.a("\u5355\u6b21\u9605\u8bfb\u5668\u6253\u5f00\u65f6\u957f = " + j4);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, int i4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f12735d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f12735d.g()));
        hashMap.put("entry", Integer.valueOf(this.f12732a));
        hashMap.put("channelId", Integer.valueOf(this.f12733b));
        hashMap.put("novel_id", this.f12734c);
        hashMap.put("count_down", Integer.valueOf(i4));
        this.f12735d.a("pre_chapter_adstart_countdown", hashMap);
    }
}
