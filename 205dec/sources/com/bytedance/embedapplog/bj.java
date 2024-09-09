package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bj extends up {

    /* renamed from: a  reason: collision with root package name */
    protected String f26703a;
    protected String bk;

    /* renamed from: t  reason: collision with root package name */
    private boolean f26704t;

    public bj(String str, boolean z3, String str2) {
        this.bk = str;
        this.f26704t = z3;
        this.f26703a = str2;
        this.f26812p = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public List<String> c() {
        List<String> c4 = super.c();
        ArrayList arrayList = new ArrayList(c4.size());
        arrayList.addAll(c4);
        arrayList.addAll(Arrays.asList("event", "varchar", EventMonitor.V3_PARAMS, "varchar", "is_bav", "integer"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public String ev() {
        return this.bk;
    }

    @Override // com.bytedance.embedapplog.up
    public String gd() {
        return this.f26703a;
    }

    protected void p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.up
    @NonNull
    public String sr() {
        return "eventv3";
    }

    @Override // com.bytedance.embedapplog.up
    protected JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f26814w);
        jSONObject.put("tea_event_index", this.xv);
        jSONObject.put("session_id", this.sr);
        long j4 = this.ux;
        if (j4 > 0) {
            jSONObject.put("user_id", j4);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f26810f) ? JSONObject.NULL : this.f26810f);
        if (!TextUtils.isEmpty(this.f26813r)) {
            jSONObject.put("ssid", this.f26813r);
        }
        jSONObject.put("event", this.bk);
        if (this.f26704t) {
            jSONObject.put("is_bav", 1);
        }
        if (this.f26704t && this.f26703a == null) {
            p();
        }
        if (!TextUtils.isEmpty(this.f26703a)) {
            jSONObject.put(EventMonitor.V3_PARAMS, new JSONObject(this.f26703a));
        }
        jSONObject.put("datetime", this.f26811k);
        if (!TextUtils.isEmpty(this.ev)) {
            jSONObject.put("ab_sdk_version", this.ev);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.up
    public int c(@NonNull Cursor cursor) {
        int c4 = super.c(cursor);
        int i4 = c4 + 1;
        this.bk = cursor.getString(c4);
        int i5 = i4 + 1;
        this.f26703a = cursor.getString(i4);
        int i6 = i5 + 1;
        this.f26704t = cursor.getInt(i5) == 1;
        return i6;
    }

    public bj(String str, boolean z3, String str2, int i4) {
        this.bk = str;
        this.f26704t = z3;
        this.f26703a = str2;
        this.f26812p = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put("event", this.bk);
        if (this.f26704t && this.f26703a == null) {
            try {
                p();
            } catch (JSONException e4) {
                be.w(e4);
            }
        }
        contentValues.put(EventMonitor.V3_PARAMS, this.f26703a);
        contentValues.put("is_bav", Integer.valueOf(this.f26704t ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull JSONObject jSONObject) {
        super.c(jSONObject);
        jSONObject.put("event", this.bk);
        if (this.f26704t && this.f26703a == null) {
            p();
        }
        jSONObject.put(EventMonitor.V3_PARAMS, this.f26703a);
        jSONObject.put("is_bav", this.f26704t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public up w(@NonNull JSONObject jSONObject) {
        super.w(jSONObject);
        this.bk = jSONObject.optString("event", null);
        this.f26703a = jSONObject.optString(EventMonitor.V3_PARAMS, null);
        this.f26704t = jSONObject.optBoolean("is_bav", false);
        return this;
    }
}
