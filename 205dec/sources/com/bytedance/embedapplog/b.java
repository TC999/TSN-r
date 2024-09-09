package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.bytedance.embedapplog.mt;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b extends up {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f26693a;
    int bk;
    long fp;
    bm fz;

    /* renamed from: i  reason: collision with root package name */
    long f26694i;
    JSONArray ia;

    /* renamed from: j  reason: collision with root package name */
    private ox f26695j;
    private JSONObject ls;

    /* renamed from: q  reason: collision with root package name */
    private JSONArray f26696q;

    /* renamed from: s  reason: collision with root package name */
    long f26697s;

    /* renamed from: t  reason: collision with root package name */
    public int f26698t;

    /* renamed from: u  reason: collision with root package name */
    JSONArray f26699u;
    JSONArray ys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(JSONObject jSONObject, bm bmVar, ox oxVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, int i4) {
        c(0L);
        this.ls = jSONObject;
        this.fz = bmVar;
        this.f26695j = oxVar;
        this.f26696q = jSONArray;
        this.ys = jSONArrayArr[0];
        this.fp = jArr[0];
        this.ia = jSONArrayArr[1];
        this.f26697s = jArr[1];
        this.f26699u = jSONArrayArr[2];
        this.f26694i = jArr[2];
        this.f26812p = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public String ev() {
        return String.valueOf(this.f26809c);
    }

    public byte[] p() {
        this.f26693a = null;
        try {
            byte[] c4 = ok.c(f().toString());
            this.f26693a = c4;
            return c4;
        } catch (OutOfMemoryError e4) {
            StringBuilder sb = new StringBuilder();
            int i4 = 0;
            while (true) {
                mt.w[] wVarArr = mt.xv;
                if (i4 >= wVarArr.length) {
                    break;
                }
                if (wVarArr[i4] != null) {
                    sb.append(wVarArr[i4].toString());
                    sb.append(";");
                }
                i4++;
            }
            throw new RuntimeException(sb.toString(), e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.embedapplog.up
    @NonNull
    public String sr() {
        return "pack";
    }

    @Override // com.bytedance.embedapplog.up
    protected JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.ls);
        jSONObject.put("time_sync", gw.f26743c);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.fz != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.fz.f());
            jSONObject.put("launch", jSONArray);
        }
        ox oxVar = this.f26695j;
        int i4 = 0;
        if (oxVar != null) {
            JSONObject f4 = oxVar.f();
            JSONArray jSONArray2 = this.f26696q;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i5 = 0;
            long j4 = 0;
            while (i5 < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.f26696q.optString(i5));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString(EventMonitor.V3_PARAMS));
                jSONArray4.put(i4, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt("duration", i4) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                int i6 = length;
                long optLong = jSONObject2.optLong("local_time_ms", 0L);
                if (optLong > j4) {
                    f4.put("$page_title", jSONObject3.optString("page_title", ""));
                    f4.put("$page_key", jSONObject3.optString("page_key", ""));
                    j4 = optLong;
                }
                i5++;
                length = i6;
                i4 = 0;
            }
            if (length > 0) {
                f4.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(f4);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.ys;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.ys);
        }
        JSONArray jSONArray7 = this.f26696q;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.ia;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.ia);
        }
        JSONArray jSONArray9 = this.f26699u;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.f26699u);
        }
        StringBuilder sb = new StringBuilder("pack {");
        sb.append("ts:");
        sb.append(this.f26814w);
        sb.append(", la:");
        bm bmVar = this.fz;
        if (bmVar == null) {
            bmVar = "0";
        }
        sb.append(bmVar);
        sb.append(", te:");
        ox oxVar2 = this.f26695j;
        sb.append(oxVar2 != null ? oxVar2 : "0");
        sb.append(", p:");
        sb.append(length3);
        sb.append(", v1:");
        sb.append(length2);
        sb.append(", v3:");
        sb.append(length4);
        sb.append(", m:");
        sb.append(length5);
        be.c(sb.toString());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public List<String> c() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", "integer", "_data", "blob", "_fail", "integer", "event_type", "integer");
    }

    @Override // com.bytedance.embedapplog.up
    public int c(@NonNull Cursor cursor) {
        this.f26809c = cursor.getLong(0);
        this.f26814w = cursor.getLong(1);
        this.f26693a = cursor.getBlob(2);
        this.bk = cursor.getInt(3);
        this.f26812p = cursor.getInt(4);
        this.sr = "";
        this.ls = null;
        this.fz = null;
        this.f26695j = null;
        this.f26696q = null;
        this.ys = null;
        this.ia = null;
        this.f26699u = null;
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.up
    public void c(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f26814w));
        contentValues.put("_data", p());
        contentValues.put("event_type", Integer.valueOf(this.f26812p));
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
