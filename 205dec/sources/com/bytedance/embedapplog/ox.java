package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ox extends up {

    /* renamed from: a  reason: collision with root package name */
    long f26780a;
    long bk;

    /* renamed from: t  reason: collision with root package name */
    String f26781t;
    public int ys = 0;

    @Override // com.bytedance.embedapplog.up
    public int c(@NonNull Cursor cursor) {
        be.w((Throwable) null);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public List<String> c() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public String ev() {
        return String.valueOf(this.f26780a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.up
    @NonNull
    public String sr() {
        return "terminate";
    }

    @Override // com.bytedance.embedapplog.up
    protected JSONObject w() {
        bm bmVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f26814w);
        jSONObject.put("tea_event_index", this.xv);
        jSONObject.put("session_id", this.sr);
        jSONObject.put("stop_timestamp", this.bk / 1000);
        jSONObject.put("duration", this.f26780a / 1000);
        jSONObject.put("datetime", this.f26811k);
        long j4 = this.ux;
        if (j4 > 0) {
            jSONObject.put("user_id", j4);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f26810f) ? JSONObject.NULL : this.f26810f);
        if (!TextUtils.isEmpty(this.f26813r)) {
            jSONObject.put("ssid", this.f26813r);
        }
        if (!TextUtils.isEmpty(this.ev)) {
            jSONObject.put("ab_sdk_version", this.ev);
        }
        if (!TextUtils.isEmpty(this.f26781t)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.f26781t, this.sr)) {
                jSONObject.put("original_session_id", this.f26781t);
            }
        }
        if (this.ys == 0 && (bmVar = (bm) mt.f26767w.get("launch")) != null && !bmVar.f26710u) {
            this.ys = 6;
        }
        jSONObject.put("launch_from", this.ys);
        Log.d("xgc_apm", "terminate:" + this.ys);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull ContentValues contentValues) {
        be.w((Throwable) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull JSONObject jSONObject) {
        be.w((Throwable) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public up w(@NonNull JSONObject jSONObject) {
        be.w((Throwable) null);
        return this;
    }
}
