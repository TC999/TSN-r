package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.C12828ap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i) {
            return new StrategyBean[i];
        }
    };

    /* renamed from: a */
    public static String f36291a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b */
    public static String f36292b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c */
    public static String f36293c;

    /* renamed from: d */
    public long f36294d;

    /* renamed from: e */
    public long f36295e;

    /* renamed from: f */
    public boolean f36296f;

    /* renamed from: g */
    public boolean f36297g;

    /* renamed from: h */
    public boolean f36298h;

    /* renamed from: i */
    public boolean f36299i;

    /* renamed from: j */
    public boolean f36300j;

    /* renamed from: k */
    public boolean f36301k;

    /* renamed from: l */
    public boolean f36302l;

    /* renamed from: m */
    public boolean f36303m;

    /* renamed from: n */
    public boolean f36304n;

    /* renamed from: o */
    public long f36305o;

    /* renamed from: p */
    public long f36306p;

    /* renamed from: q */
    public String f36307q;

    /* renamed from: r */
    public String f36308r;

    /* renamed from: s */
    public String f36309s;

    /* renamed from: t */
    public Map<String, String> f36310t;

    /* renamed from: u */
    public int f36311u;

    /* renamed from: v */
    public long f36312v;

    /* renamed from: w */
    public long f36313w;

    public StrategyBean() {
        this.f36294d = -1L;
        this.f36295e = -1L;
        this.f36296f = true;
        this.f36297g = true;
        this.f36298h = true;
        this.f36299i = true;
        this.f36300j = false;
        this.f36301k = true;
        this.f36302l = true;
        this.f36303m = true;
        this.f36304n = true;
        this.f36306p = 30000L;
        this.f36307q = f36291a;
        this.f36308r = f36292b;
        this.f36311u = 10;
        this.f36312v = 300000L;
        this.f36313w = -1L;
        this.f36295e = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L@)");
        f36293c = sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K@!");
        this.f36309s = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f36295e);
        parcel.writeByte(this.f36296f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f36297g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f36298h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f36307q);
        parcel.writeString(this.f36308r);
        parcel.writeString(this.f36309s);
        C12828ap.m15819b(parcel, this.f36310t);
        parcel.writeByte(this.f36299i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f36300j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f36303m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f36304n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f36306p);
        parcel.writeByte(this.f36301k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f36302l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f36305o);
        parcel.writeInt(this.f36311u);
        parcel.writeLong(this.f36312v);
        parcel.writeLong(this.f36313w);
    }

    public StrategyBean(Parcel parcel) {
        this.f36294d = -1L;
        this.f36295e = -1L;
        boolean z = true;
        this.f36296f = true;
        this.f36297g = true;
        this.f36298h = true;
        this.f36299i = true;
        this.f36300j = false;
        this.f36301k = true;
        this.f36302l = true;
        this.f36303m = true;
        this.f36304n = true;
        this.f36306p = 30000L;
        this.f36307q = f36291a;
        this.f36308r = f36292b;
        this.f36311u = 10;
        this.f36312v = 300000L;
        this.f36313w = -1L;
        try {
            f36293c = "S(@L@L@)";
            this.f36295e = parcel.readLong();
            this.f36296f = parcel.readByte() == 1;
            this.f36297g = parcel.readByte() == 1;
            this.f36298h = parcel.readByte() == 1;
            this.f36307q = parcel.readString();
            this.f36308r = parcel.readString();
            this.f36309s = parcel.readString();
            this.f36310t = C12828ap.m15820b(parcel);
            this.f36299i = parcel.readByte() == 1;
            this.f36300j = parcel.readByte() == 1;
            this.f36303m = parcel.readByte() == 1;
            this.f36304n = parcel.readByte() == 1;
            this.f36306p = parcel.readLong();
            this.f36301k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f36302l = z;
            this.f36305o = parcel.readLong();
            this.f36311u = parcel.readInt();
            this.f36312v = parcel.readLong();
            this.f36313w = parcel.readLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
