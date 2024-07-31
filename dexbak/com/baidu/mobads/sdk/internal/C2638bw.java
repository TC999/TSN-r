package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.idl.face.platform.common.ConstantHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.bw */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2638bw implements Parcelable {

    /* renamed from: a */
    public static final String f8754a = "MD5";

    /* renamed from: b */
    public static final Parcelable.Creator<C2638bw> f8755b = new C2639bx();

    /* renamed from: c */
    private JSONObject f8756c;

    /* renamed from: d */
    private double f8757d;

    /* renamed from: e */
    private String f8758e;

    /* renamed from: f */
    private String f8759f;

    /* renamed from: g */
    private String f8760g;

    /* renamed from: h */
    private int f8761h;

    /* renamed from: i */
    private int f8762i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2638bw(Parcel parcel, C2639bx c2639bx) {
        this(parcel);
    }

    /* renamed from: a */
    public Boolean m50714a() {
        return Boolean.valueOf(this.f8762i == 1);
    }

    /* renamed from: b */
    public double m50713b() {
        return this.f8757d;
    }

    /* renamed from: c */
    public String m50712c() {
        return C2670cp.m50608a().m50598c(this.f8758e);
    }

    /* renamed from: d */
    public String m50711d() {
        return this.f8759f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String m50710e() {
        return this.f8760g;
    }

    /* renamed from: f */
    public Boolean m50709f() {
        return Boolean.valueOf(this.f8761h == 1);
    }

    public String toString() {
        return this.f8756c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8759f);
        parcel.writeInt(this.f8762i);
        parcel.writeString(this.f8758e);
        parcel.writeDouble(this.f8757d);
        parcel.writeString(this.f8760g);
        parcel.writeInt(this.f8761h);
    }

    public C2638bw(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f8756c = jSONObject;
            this.f8757d = jSONObject.getDouble(ConstantHelper.LOG_VS);
            this.f8758e = this.f8756c.getString("url");
            this.f8759f = this.f8756c.getString("sign");
            this.f8762i = 1;
            this.f8760g = "";
            this.f8761h = 0;
        } catch (JSONException unused) {
            this.f8762i = 0;
        }
        this.f8762i = m50712c() == null ? 0 : 1;
    }

    public C2638bw(C2638bw c2638bw, String str, Boolean bool) {
        this.f8757d = c2638bw.m50713b();
        this.f8758e = c2638bw.m50712c();
        this.f8759f = c2638bw.m50711d();
        this.f8762i = c2638bw.m50714a().booleanValue() ? 1 : 0;
        this.f8760g = str;
        this.f8761h = bool.booleanValue() ? 1 : 0;
    }

    private C2638bw(Parcel parcel) {
        this.f8759f = parcel.readString();
        this.f8762i = parcel.readInt();
        this.f8758e = parcel.readString();
        this.f8757d = parcel.readDouble();
        this.f8760g = parcel.readString();
        this.f8761h = parcel.readInt();
    }
}
