package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class oo extends up {

    /* renamed from: a  reason: collision with root package name */
    public String f26778a;
    public String bk;
    public long fp;
    long ia;

    /* renamed from: t  reason: collision with root package name */
    public String f26779t;
    public String ys;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public List<String> c() {
        List<String> c4 = super.c();
        ArrayList arrayList = new ArrayList(c4.size());
        arrayList.addAll(c4);
        arrayList.addAll(Arrays.asList("category", "varchar", "tag", "varchar", "value", "integer", "ext_value", "integer", EventMonitor.V3_PARAMS, "varchar", "label", "varchar"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public String ev() {
        return "" + this.bk + ", " + this.f26779t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public String gd() {
        return this.ys;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.up
    @NonNull
    public String sr() {
        return "event";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public up w(@NonNull JSONObject jSONObject) {
        super.w(jSONObject);
        this.xv = jSONObject.optLong("tea_event_index", 0L);
        this.f26778a = jSONObject.optString("category", null);
        this.bk = jSONObject.optString("tag", null);
        this.fp = jSONObject.optLong("value", 0L);
        this.ia = jSONObject.optLong("ext_value", 0L);
        this.ys = jSONObject.optString(EventMonitor.V3_PARAMS, null);
        this.f26779t = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.up
    public int c(@NonNull Cursor cursor) {
        int c4 = super.c(cursor);
        int i4 = c4 + 1;
        this.f26778a = cursor.getString(c4);
        int i5 = i4 + 1;
        this.bk = cursor.getString(i4);
        int i6 = i5 + 1;
        this.fp = cursor.getLong(i5);
        int i7 = i6 + 1;
        this.ia = cursor.getLong(i6);
        int i8 = i7 + 1;
        this.ys = cursor.getString(i7);
        int i9 = i8 + 1;
        this.f26779t = cursor.getString(i8);
        return i9;
    }

    @Override // com.bytedance.embedapplog.up
    protected JSONObject w() {
        JSONObject jSONObject = !TextUtils.isEmpty(this.ys) ? new JSONObject(this.ys) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
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
        jSONObject.put("category", this.f26778a);
        jSONObject.put("tag", this.bk);
        jSONObject.put("value", this.fp);
        jSONObject.put("ext_value", this.ia);
        jSONObject.put("label", this.f26779t);
        jSONObject.put("datetime", this.f26811k);
        if (!TextUtils.isEmpty(this.ev)) {
            jSONObject.put("ab_sdk_version", this.ev);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put("category", this.f26778a);
        contentValues.put("tag", this.bk);
        contentValues.put("value", Long.valueOf(this.fp));
        contentValues.put("ext_value", Long.valueOf(this.ia));
        contentValues.put(EventMonitor.V3_PARAMS, this.ys);
        contentValues.put("label", this.f26779t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull JSONObject jSONObject) {
        super.c(jSONObject);
        jSONObject.put("tea_event_index", this.xv);
        jSONObject.put("category", this.f26778a);
        jSONObject.put("tag", this.bk);
        jSONObject.put("value", this.fp);
        jSONObject.put("ext_value", this.ia);
        jSONObject.put(EventMonitor.V3_PARAMS, this.ys);
        jSONObject.put("label", this.f26779t);
    }
}
