package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.aj */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2590aj implements InterfaceC2724u {

    /* renamed from: a */
    final /* synthetic */ C2585ae f8558a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2590aj(C2585ae c2585ae) {
        this.f8558a = c2585ae;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50325a(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8558a.m51030g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f8558a.f8544t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        this.f8558a.m50824a(C2684db.f8929r, hashMap);
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
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8558a.m51030g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8558a.m51029h()));
        hashMap.put("entry", 2);
        iArr = this.f8558a.f8544t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f8558a.m50824a(C2684db.f8931t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: b */
    public void mo50317b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50322a(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8558a.m51030g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8558a.m51029h()));
        hashMap.put("entry", 2);
        iArr = this.f8558a.f8544t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.f8558a.m50824a(C2684db.f8930s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: b */
    public void mo50319b(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.f8558a.f8544t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        this.f8558a.m50824a(C2684db.f8933v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50323a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8558a.m51030g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8558a.m51029h()));
        hashMap.put("entry", 2);
        iArr = this.f8558a.f8544t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("backgroundColor", Integer.valueOf(i));
        this.f8558a.m50824a(C2684db.f8934w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public JSONObject mo50327a() {
        JSONObject jSONObject = new JSONObject();
        String m50808i = this.f8558a.m50808i("get_cuid");
        String m50808i2 = this.f8558a.m50808i("get_imei");
        String m50808i3 = this.f8558a.m50808i("get_oaid");
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
        C2634bs c2634bs = this.f8558a.f8664i;
        c2634bs.m50742a("单次阅读器打开时长 = " + j);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2724u
    /* renamed from: a */
    public void mo50324a(ViewGroup viewGroup, int i) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f8558a.m51030g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f8558a.m51029h()));
        hashMap.put("entry", 2);
        iArr = this.f8558a.f8544t;
        hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("count_down", Integer.valueOf(i));
        this.f8558a.m50824a(C2684db.f8935x, hashMap);
    }
}
