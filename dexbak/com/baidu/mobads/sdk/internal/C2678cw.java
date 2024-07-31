package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.cw */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class C2678cw implements InterfaceC2724u {

    /* renamed from: a */
    final /* synthetic */ int f8912a;

    /* renamed from: b */
    final /* synthetic */ int f8913b;

    /* renamed from: c */
    final /* synthetic */ String f8914c;

    /* renamed from: d */
    final /* synthetic */ C2674cs f8915d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2678cw(C2674cs c2674cs, int i, int i2, String str) {
        this.f8915d = c2674cs;
        this.f8912a = i;
        this.f8913b = i2;
        this.f8914c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50325a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8915d.m50579f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f8912a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8913b));
        hashMap.put("novel_id", this.f8914c);
        this.f8915d.m50824a(C2684db.f8929r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50321a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50320a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: b */
    public void mo50318b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8915d.m50579f());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8915d.m50578g()));
        hashMap.put("entry", Integer.valueOf(this.f8912a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8913b));
        hashMap.put("novel_id", this.f8914c);
        hashMap.put("novel_info", jSONObject);
        this.f8915d.m50824a(C2684db.f8931t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: b */
    public void mo50317b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50322a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8915d.m50579f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8915d.m50578g()));
        hashMap.put("entry", Integer.valueOf(this.f8912a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8913b));
        hashMap.put("novel_id", this.f8914c);
        hashMap.put("novel_info", jSONObject);
        this.f8915d.m50824a(C2684db.f8930s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: b */
    public void mo50319b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.f8912a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8913b));
        hashMap.put("novel_id", this.f8914c);
        this.f8915d.m50824a(C2684db.f8933v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50323a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8915d.m50579f());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8915d.m50578g()));
        hashMap.put("entry", Integer.valueOf(this.f8912a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8913b));
        hashMap.put("novel_id", this.f8914c);
        hashMap.put("backgroundColor", Integer.valueOf(i));
        this.f8915d.m50824a(C2684db.f8934w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public JSONObject mo50327a() {
        JSONObject jSONObject = new JSONObject();
        String m50808i = this.f8915d.m50808i("get_cuid");
        String m50808i2 = this.f8915d.m50808i("get_imei");
        String m50808i3 = this.f8915d.m50808i("get_oaid");
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
        C2634bs c2634bs = this.f8915d.f8664i;
        c2634bs.m50742a("单次阅读器打开时长 = " + j);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50324a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8915d.m50579f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8915d.m50578g()));
        hashMap.put("entry", Integer.valueOf(this.f8912a));
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f8913b));
        hashMap.put("novel_id", this.f8914c);
        hashMap.put("count_down", Integer.valueOf(i));
        this.f8915d.m50824a(C2684db.f8935x, hashMap);
    }
}
