package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bm extends up {

    /* renamed from: a  reason: collision with root package name */
    public int f26707a;
    public String bk;
    public int fp;
    public boolean fz;
    public String ia;

    /* renamed from: s  reason: collision with root package name */
    public String f26708s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f26709t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f26710u;
    public String ys;

    public bm(boolean z3) {
        this.f26710u = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public List<String> c() {
        List<String> c4 = super.c();
        ArrayList arrayList = new ArrayList(c4.size());
        arrayList.addAll(c4);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", "integer", "last_session", "varchar", "is_first_time", "integer", "page_title", "varchar", "page_key", "varchar", "resume_from_background", "integer"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public String ev() {
        return this.f26709t ? "bg" : "fg";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.up
    @NonNull
    public String sr() {
        return "launch";
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
        boolean z3 = this.f26709t;
        if (z3) {
            jSONObject.put("is_background", z3);
        }
        jSONObject.put("datetime", this.f26811k);
        if (!TextUtils.isEmpty(this.ev)) {
            jSONObject.put("ab_sdk_version", this.ev);
        }
        if (!TextUtils.isEmpty(this.ys)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.ys);
        }
        if (this.fp == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$resume_from_background", !this.f26710u);
        jSONObject.put("is_background", !this.f26710u);
        Log.d("xgc_apm", "launch:" + this.f26710u);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.up
    public int c(@NonNull Cursor cursor) {
        int c4 = super.c(cursor);
        int i4 = c4 + 1;
        this.bk = cursor.getString(c4);
        int i5 = i4 + 1;
        this.f26707a = cursor.getInt(i4);
        int i6 = i5 + 1;
        this.ys = cursor.getString(i5);
        int i7 = i6 + 1;
        this.fp = cursor.getInt(i6);
        int i8 = i7 + 1;
        this.ia = cursor.getString(i7);
        int i9 = i8 + 1;
        this.f26708s = cursor.getString(i8);
        int i10 = i9 + 1;
        this.fz = cursor.getInt(i9) == 0;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put("ver_name", this.bk);
        contentValues.put("ver_code", Integer.valueOf(this.f26707a));
        contentValues.put("last_session", this.ys);
        contentValues.put("is_first_time", Integer.valueOf(this.fp));
        contentValues.put("page_title", this.ia);
        contentValues.put("page_key", this.f26708s);
        contentValues.put("resume_from_background", Integer.valueOf(this.fz ? 1 : 0));
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
        return null;
    }
}
