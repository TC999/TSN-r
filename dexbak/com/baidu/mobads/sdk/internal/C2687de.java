package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.kwad.sdk.core.scene.URLPackage;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.de */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2687de implements InterfaceC2724u {

    /* renamed from: a */
    final /* synthetic */ C2684db f8948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2687de(C2684db c2684db) {
        this.f8948a = c2684db;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50325a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8948a.m50559g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f8948a.f8940D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8948a.f8941E));
        hashMap.put("novel_id", this.f8948a.f8942F);
        this.f8948a.m50824a(C2684db.f8929r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50321a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: b */
    public void mo50318b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8948a.m50559g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8948a.m50558h()));
        hashMap.put("entry", Integer.valueOf(this.f8948a.f8940D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8948a.f8941E));
        hashMap.put("novel_id", this.f8948a.f8942F);
        hashMap.put("novel_info", jSONObject);
        this.f8948a.m50824a(C2684db.f8931t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: b */
    public void mo50317b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50322a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8948a.m50559g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8948a.m50558h()));
        hashMap.put("entry", Integer.valueOf(this.f8948a.f8940D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8948a.f8941E));
        hashMap.put("novel_id", this.f8948a.f8942F);
        hashMap.put("novel_info", jSONObject);
        this.f8948a.m50824a(C2684db.f8930s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: b */
    public void mo50319b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f8948a.f8940D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8948a.f8941E));
        hashMap.put("novel_id", this.f8948a.f8942F);
        hashMap.put("isnight", Boolean.valueOf(this.f8948a.m50556x()));
        this.f8948a.m50824a(C2684db.f8933v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50323a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8948a.m50559g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8948a.m50558h()));
        hashMap.put("entry", Integer.valueOf(this.f8948a.f8940D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8948a.f8941E));
        hashMap.put("novel_id", this.f8948a.f8942F);
        hashMap.put("backgroundColor", Integer.valueOf(i));
        this.f8948a.m50824a(C2684db.f8934w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public JSONObject mo50327a() {
        JSONObject jSONObject = new JSONObject();
        String m50808i = this.f8948a.m50808i("get_cuid");
        String m50808i2 = this.f8948a.m50808i("get_imei");
        String m50808i3 = this.f8948a.m50808i("get_oaid");
        try {
            jSONObject.put("cuid", m50808i);
            jSONObject.put("imei", m50808i2);
            jSONObject.put("oaid", m50808i3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50326a(long j) {
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        CPUNovelAd.CpuNovelListener cpuNovelListener2;
        cpuNovelListener = this.f8948a.f8943H;
        if (cpuNovelListener != null) {
            cpuNovelListener2 = this.f8948a.f8943H;
            cpuNovelListener2.onReadTime(j);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50324a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8948a.m50559g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8948a.m50558h()));
        hashMap.put("entry", Integer.valueOf(this.f8948a.f8940D));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8948a.f8941E));
        hashMap.put("novel_id", this.f8948a.f8942F);
        hashMap.put("count_down", Integer.valueOf(i));
        this.f8948a.m50824a(C2684db.f8935x, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50320a(boolean z) {
        SoftReference softReference;
        SoftReference softReference2;
        softReference = this.f8948a.f8944I;
        if (softReference != null) {
            softReference2 = this.f8948a.f8944I;
            RelativeLayout relativeLayout = (RelativeLayout) softReference2.get();
            if (relativeLayout != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("novel_activity", (Activity) this.f8948a.f8663h);
                hashMap.put("interstitial_container", null);
                hashMap.put("banner_container", relativeLayout);
                hashMap.put("entry", Integer.valueOf(this.f8948a.f8940D));
                hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8948a.f8941E));
                hashMap.put("novel_id", this.f8948a.f8942F);
                hashMap.put("isnight", Boolean.valueOf(this.f8948a.m50556x()));
                this.f8948a.m50824a(C2684db.f8934w, hashMap);
            }
        }
    }
}
