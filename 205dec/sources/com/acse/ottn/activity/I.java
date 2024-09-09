package com.acse.ottn.activity;

import com.acse.ottn.util.ra;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class I implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4667a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SeedingLoadingActivity f4668b;

    I(SeedingLoadingActivity seedingLoadingActivity, String str) {
        this.f4668b = seedingLoadingActivity;
        this.f4667a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        SeedingLoadingActivity.a(this.f4668b, "");
        try {
            JSONObject jSONObject = new JSONObject(new OkHttpClient().newCall(new Request.Builder().url(this.f4667a).build()).execute().body().string());
            SeedingLoadingActivity.a(this.f4668b, jSONObject.getString("content"));
            StringBuilder sb = new StringBuilder();
            sb.append("code = ");
            sb.append(SeedingLoadingActivity.i(this.f4668b));
            ra.a("SeedingLoadingActivity", sb.toString());
        } catch (Exception e4) {
            SeedingLoadingActivity.a(this.f4668b, "");
            SeedingLoadingActivity.j(this.f4668b);
            e4.printStackTrace();
        }
    }
}
