package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class au extends up {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private String f26692a;
    @NonNull
    private String bk;

    public au(@NonNull String str, @NonNull JSONObject jSONObject) {
        this.bk = str;
        this.f26692a = jSONObject.toString();
        this.f26812p = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public List<String> c() {
        List<String> c4 = super.c();
        ArrayList arrayList = new ArrayList(c4.size());
        arrayList.addAll(c4);
        arrayList.addAll(Arrays.asList(EventMonitor.V3_PARAMS, "varchar", "log_type", "varchar"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public String ev() {
        return "param:" + this.f26692a + " logType:" + this.bk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public String gd() {
        return this.f26692a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.up
    @NonNull
    public String sr() {
        return "event_misc";
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
        jSONObject.put("log_type", this.bk);
        try {
            JSONObject jSONObject2 = new JSONObject(this.f26692a);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    be.w("misc\u4e8b\u4ef6\u5b58\u5728\u91cd\u590d\u7684key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e4) {
            be.xv("\u89e3\u6790 event misc \u5931\u8d25", e4);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.up
    public int c(@NonNull Cursor cursor) {
        int c4 = super.c(cursor);
        int i4 = c4 + 1;
        this.f26692a = cursor.getString(c4);
        int i5 = i4 + 1;
        this.bk = cursor.getString(i4);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put(EventMonitor.V3_PARAMS, this.f26692a);
        contentValues.put("log_type", this.bk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull JSONObject jSONObject) {
        super.c(jSONObject);
        jSONObject.put(EventMonitor.V3_PARAMS, this.f26692a);
        jSONObject.put("log_type", this.bk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public up w(@NonNull JSONObject jSONObject) {
        super.w(jSONObject);
        this.f26692a = jSONObject.optString(EventMonitor.V3_PARAMS, null);
        this.bk = jSONObject.optString("log_type", null);
        return this;
    }
}
