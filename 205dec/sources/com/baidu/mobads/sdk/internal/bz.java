package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class bz implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12576a = "MD5";

    /* renamed from: b  reason: collision with root package name */
    public static final Parcelable.Creator<bz> f12577b = new ca();

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f12578c;

    /* renamed from: d  reason: collision with root package name */
    private double f12579d;

    /* renamed from: e  reason: collision with root package name */
    private String f12580e;

    /* renamed from: f  reason: collision with root package name */
    private String f12581f;

    /* renamed from: g  reason: collision with root package name */
    private String f12582g;

    /* renamed from: h  reason: collision with root package name */
    private int f12583h;

    /* renamed from: i  reason: collision with root package name */
    private int f12584i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bz(Parcel parcel, ca caVar) {
        this(parcel);
    }

    public Boolean a() {
        return Boolean.valueOf(this.f12584i == 1);
    }

    public double b() {
        return this.f12579d;
    }

    public String c() {
        return cs.a().c(this.f12580e);
    }

    public String d() {
        return this.f12581f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f12582g;
    }

    public Boolean f() {
        return Boolean.valueOf(this.f12583h == 1);
    }

    public String toString() {
        return this.f12578c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f12581f);
        parcel.writeInt(this.f12584i);
        parcel.writeString(this.f12580e);
        parcel.writeDouble(this.f12579d);
        parcel.writeString(this.f12582g);
        parcel.writeInt(this.f12583h);
    }

    public bz(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f12578c = jSONObject;
            this.f12579d = jSONObject.getDouble("version");
            this.f12580e = this.f12578c.getString("url");
            this.f12581f = this.f12578c.getString("sign");
            this.f12584i = 1;
            this.f12582g = "";
            this.f12583h = 0;
        } catch (JSONException unused) {
            this.f12584i = 0;
        }
        this.f12584i = c() == null ? 0 : 1;
    }

    public bz(bz bzVar, String str, Boolean bool) {
        this.f12579d = bzVar.b();
        this.f12580e = bzVar.c();
        this.f12581f = bzVar.d();
        this.f12584i = bzVar.a().booleanValue() ? 1 : 0;
        this.f12582g = str;
        this.f12583h = bool.booleanValue() ? 1 : 0;
    }

    private bz(Parcel parcel) {
        this.f12581f = parcel.readString();
        this.f12584i = parcel.readInt();
        this.f12580e = parcel.readString();
        this.f12579d = parcel.readDouble();
        this.f12582g = parcel.readString();
        this.f12583h = parcel.readInt();
    }
}
