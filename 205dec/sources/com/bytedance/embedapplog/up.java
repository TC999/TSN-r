package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class up implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f26808a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    long f26809c;
    public String ev;

    /* renamed from: f  reason: collision with root package name */
    public String f26810f;
    public int gd;

    /* renamed from: k  reason: collision with root package name */
    String f26811k;

    /* renamed from: p  reason: collision with root package name */
    public int f26812p;

    /* renamed from: r  reason: collision with root package name */
    public String f26813r;
    public String sr;
    public long ux;

    /* renamed from: w  reason: collision with root package name */
    public long f26814w;
    public long xv;

    public up() {
        c(0L);
    }

    public static String w(long j4) {
        return f26808a.format(new Date(j4));
    }

    public void c(long j4) {
        if (j4 == 0) {
            j4 = System.currentTimeMillis();
        }
        this.f26814w = j4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String ev() {
        return "sid:" + this.sr;
    }

    @NonNull
    public final JSONObject f() {
        try {
            this.f26811k = w(this.f26814w);
            return w();
        } catch (JSONException e4) {
            be.w(e4);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String gd() {
        return null;
    }

    /* renamed from: r */
    public up clone() {
        try {
            return (up) super.clone();
        } catch (CloneNotSupportedException e4) {
            be.w(e4);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public abstract String sr();

    @NonNull
    public String toString() {
        String sr = sr();
        if (!getClass().getSimpleName().equalsIgnoreCase(sr)) {
            sr = sr + ", " + getClass().getSimpleName();
        }
        String str = this.sr;
        String str2 = "-";
        if (str != null) {
            int indexOf = str.indexOf("-");
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            str2 = str;
        }
        return "{" + sr + ", " + ev() + ", " + str2 + ", " + this.f26814w + "}";
    }

    @NonNull
    public final JSONObject ux() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", sr());
            c(jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
        return jSONObject;
    }

    protected abstract JSONObject w();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String xv() {
        List<String> c4 = c();
        if (c4 != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("create table if not exists ");
            sb.append(sr());
            sb.append("(");
            for (int i4 = 0; i4 < c4.size(); i4 += 2) {
                sb.append(c4.get(i4));
                sb.append(" ");
                sb.append(c4.get(i4 + 1));
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append(")");
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public up w(@NonNull JSONObject jSONObject) {
        this.f26814w = jSONObject.optLong("local_time_ms", 0L);
        this.f26809c = 0L;
        this.xv = 0L;
        this.gd = 0;
        this.ux = 0L;
        this.sr = null;
        this.f26810f = null;
        this.f26813r = null;
        this.ev = null;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> c() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", "integer", "tea_event_index", "integer", "nt", "integer", "user_id", "integer", "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", "event_type", "integer");
    }

    public int c(@NonNull Cursor cursor) {
        this.f26809c = cursor.getLong(0);
        this.f26814w = cursor.getLong(1);
        this.xv = cursor.getLong(2);
        this.gd = cursor.getInt(3);
        this.ux = cursor.getLong(4);
        this.sr = cursor.getString(5);
        this.f26810f = cursor.getString(6);
        this.f26813r = cursor.getString(7);
        this.ev = cursor.getString(8);
        this.f26812p = cursor.getInt(9);
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ContentValues w(@Nullable ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        c(contentValues);
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f26814w));
        contentValues.put("tea_event_index", Long.valueOf(this.xv));
        contentValues.put("nt", Integer.valueOf(this.gd));
        contentValues.put("user_id", Long.valueOf(this.ux));
        contentValues.put("session_id", this.sr);
        contentValues.put("user_unique_id", this.f26810f);
        contentValues.put("ssid", this.f26813r);
        contentValues.put("ab_sdk_version", this.ev);
        contentValues.put("event_type", Integer.valueOf(this.f26812p));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f26814w);
    }

    public static up c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return mt.f26767w.get(jSONObject.optString("k_cls", "")).clone().w(jSONObject);
        } catch (Throwable th) {
            be.w(th);
            return null;
        }
    }
}
