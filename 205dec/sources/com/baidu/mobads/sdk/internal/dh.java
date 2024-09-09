package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class dh implements u {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ de f12759a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(de deVar) {
        this.f12759a = deVar;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f12759a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f12759a.D));
        hashMap.put("channelId", Integer.valueOf(this.f12759a.E));
        hashMap.put("novel_id", this.f12759a.F);
        this.f12759a.a("notify_impression", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f12759a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f12759a.h()));
        hashMap.put("entry", Integer.valueOf(this.f12759a.D));
        hashMap.put("channelId", Integer.valueOf(this.f12759a.E));
        hashMap.put("novel_id", this.f12759a.F);
        hashMap.put("novel_info", jSONObject);
        this.f12759a.a("request_banner_ad_view", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f12759a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f12759a.h()));
        hashMap.put("entry", Integer.valueOf(this.f12759a.D));
        hashMap.put("channelId", Integer.valueOf(this.f12759a.E));
        hashMap.put("novel_id", this.f12759a.F);
        hashMap.put("novel_info", jSONObject);
        this.f12759a.a("request_int_ad_view", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f12759a.D));
        hashMap.put("channelId", Integer.valueOf(this.f12759a.E));
        hashMap.put("novel_id", this.f12759a.F);
        hashMap.put("isnight", Boolean.valueOf(this.f12759a.x()));
        this.f12759a.a("request_shelf_ad_view", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f12759a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f12759a.h()));
        hashMap.put("entry", Integer.valueOf(this.f12759a.D));
        hashMap.put("channelId", Integer.valueOf(this.f12759a.E));
        hashMap.put("novel_id", this.f12759a.F);
        hashMap.put("backgroundColor", Integer.valueOf(i4));
        this.f12759a.a("reader_background_status_change", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String i4 = this.f12759a.i("get_cuid");
        String i5 = this.f12759a.i("get_imei");
        String i6 = this.f12759a.i("get_oaid");
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
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        CPUNovelAd.CpuNovelListener cpuNovelListener2;
        cpuNovelListener = this.f12759a.H;
        if (cpuNovelListener != null) {
            cpuNovelListener2 = this.f12759a.H;
            cpuNovelListener2.onReadTime(j4);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(ViewGroup viewGroup, int i4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f12759a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f12759a.h()));
        hashMap.put("entry", Integer.valueOf(this.f12759a.D));
        hashMap.put("channelId", Integer.valueOf(this.f12759a.E));
        hashMap.put("novel_id", this.f12759a.F);
        hashMap.put("count_down", Integer.valueOf(i4));
        this.f12759a.a("pre_chapter_adstart_countdown", hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z3) {
        SoftReference softReference;
        SoftReference softReference2;
        softReference = this.f12759a.I;
        if (softReference != null) {
            softReference2 = this.f12759a.I;
            RelativeLayout relativeLayout = (RelativeLayout) softReference2.get();
            if (relativeLayout != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("novel_activity", (Activity) this.f12759a.f12481h);
                hashMap.put("interstitial_container", null);
                hashMap.put("banner_container", relativeLayout);
                hashMap.put("entry", Integer.valueOf(this.f12759a.D));
                hashMap.put("channelId", Integer.valueOf(this.f12759a.E));
                hashMap.put("novel_id", this.f12759a.F);
                hashMap.put("isnight", Boolean.valueOf(this.f12759a.x()));
                this.f12759a.a("reader_background_status_change", hashMap);
            }
        }
    }
}
