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
public class wo extends up {

    /* renamed from: a  reason: collision with root package name */
    public long f26832a;
    public String bk;
    public String fp;
    public int fz;
    public String ia;

    /* renamed from: s  reason: collision with root package name */
    public String f26833s;

    /* renamed from: t  reason: collision with root package name */
    public String f26834t;

    /* renamed from: u  reason: collision with root package name */
    public String f26835u;
    public String ys;

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.f26834t);
        jSONObject.put("refer_page_key", this.bk);
        jSONObject.put("is_back", this.fz);
        jSONObject.put("duration", this.f26832a);
        jSONObject.put("page_title", this.ys);
        jSONObject.put("refer_page_title", this.fp);
        jSONObject.put("page_path", this.ia);
        jSONObject.put("referrer_page_path", this.f26833s);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public List<String> c() {
        List<String> c4 = super.c();
        ArrayList arrayList = new ArrayList(c4.size());
        arrayList.addAll(c4);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer", "last_session", "varchar", "page_title", "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public String ev() {
        return this.f26834t + ", " + this.f26832a;
    }

    public boolean k() {
        return this.f26834t.contains(":");
    }

    public boolean p() {
        return this.f26832a == -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.up
    @NonNull
    public String sr() {
        return "page";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public up w(@NonNull JSONObject jSONObject) {
        super.w(jSONObject);
        this.f26834t = jSONObject.optString("page_key", null);
        this.bk = jSONObject.optString("refer_page_key", null);
        this.f26832a = jSONObject.optLong("duration", 0L);
        this.fz = jSONObject.optInt("is_back", 0);
        this.ys = jSONObject.optString("page_title", null);
        this.fp = jSONObject.optString("refer_page_title", null);
        this.ia = jSONObject.optString("page_path", null);
        this.f26833s = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.up
    public int c(@NonNull Cursor cursor) {
        int c4 = super.c(cursor);
        int i4 = c4 + 1;
        this.f26834t = cursor.getString(c4);
        int i5 = i4 + 1;
        this.bk = cursor.getString(i4);
        int i6 = i5 + 1;
        this.f26832a = cursor.getLong(i5);
        int i7 = i6 + 1;
        this.fz = cursor.getInt(i6);
        int i8 = i7 + 1;
        this.f26835u = cursor.getString(i7);
        int i9 = i8 + 1;
        this.ys = cursor.getString(i8);
        int i10 = i9 + 1;
        this.fp = cursor.getString(i9);
        int i11 = i10 + 1;
        this.ia = cursor.getString(i10);
        int i12 = i11 + 1;
        this.f26833s = cursor.getString(i11);
        return i12;
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put(EventMonitor.V3_PARAMS, a());
        jSONObject.put("datetime", this.f26811k);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put("page_key", this.f26834t);
        contentValues.put("refer_page_key", this.bk);
        contentValues.put("duration", Long.valueOf(this.f26832a));
        contentValues.put("is_back", Integer.valueOf(this.fz));
        contentValues.put("last_session", this.f26835u);
        contentValues.put("page_title", this.ys);
        contentValues.put("refer_page_title", this.fp);
        contentValues.put("page_path", this.ia);
        contentValues.put("referrer_page_path", this.f26833s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull JSONObject jSONObject) {
        super.c(jSONObject);
        jSONObject.put("page_key", this.f26834t);
        jSONObject.put("refer_page_key", this.bk);
        jSONObject.put("duration", this.f26832a);
        jSONObject.put("is_back", this.fz);
        jSONObject.put("page_title", this.ys);
        jSONObject.put("refer_page_title", this.fp);
        jSONObject.put("page_path", this.ia);
        jSONObject.put("referrer_page_path", this.f26833s);
    }
}
