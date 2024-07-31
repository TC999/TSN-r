package com.acse.ottn.activity;

import com.acse.ottn.util.C1694ra;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.activity.I */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1271I implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2114a;

    /* renamed from: b */
    final /* synthetic */ SeedingLoadingActivity f2115b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1271I(SeedingLoadingActivity seedingLoadingActivity, String str) {
        this.f2115b = seedingLoadingActivity;
        this.f2114a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        this.f2115b.f2153o = "";
        try {
            JSONObject jSONObject = new JSONObject(new OkHttpClient().newCall(new Request.Builder().url(this.f2114a).build()).execute().body().string());
            this.f2115b.f2153o = jSONObject.getString("content");
            StringBuilder sb = new StringBuilder();
            sb.append("code = ");
            str = this.f2115b.f2153o;
            sb.append(str);
            C1694ra.m55917a("SeedingLoadingActivity", sb.toString());
        } catch (Exception e) {
            this.f2115b.f2153o = "";
            this.f2115b.m57284e();
            e.printStackTrace();
        }
    }
}
