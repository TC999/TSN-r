package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i4) {
            return new StrategyBean[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static String f50741a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b  reason: collision with root package name */
    public static String f50742b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c  reason: collision with root package name */
    public static String f50743c;

    /* renamed from: d  reason: collision with root package name */
    public long f50744d;

    /* renamed from: e  reason: collision with root package name */
    public long f50745e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50746f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50747g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50748h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50749i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f50750j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f50751k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f50752l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f50753m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f50754n;

    /* renamed from: o  reason: collision with root package name */
    public long f50755o;

    /* renamed from: p  reason: collision with root package name */
    public long f50756p;

    /* renamed from: q  reason: collision with root package name */
    public String f50757q;

    /* renamed from: r  reason: collision with root package name */
    public String f50758r;

    /* renamed from: s  reason: collision with root package name */
    public String f50759s;

    /* renamed from: t  reason: collision with root package name */
    public Map<String, String> f50760t;

    /* renamed from: u  reason: collision with root package name */
    public int f50761u;

    /* renamed from: v  reason: collision with root package name */
    public long f50762v;

    /* renamed from: w  reason: collision with root package name */
    public long f50763w;

    public StrategyBean() {
        this.f50744d = -1L;
        this.f50745e = -1L;
        this.f50746f = true;
        this.f50747g = true;
        this.f50748h = true;
        this.f50749i = true;
        this.f50750j = false;
        this.f50751k = true;
        this.f50752l = true;
        this.f50753m = true;
        this.f50754n = true;
        this.f50756p = PolicyConfig.mServerBusyRetryBaseInternal;
        this.f50757q = f50741a;
        this.f50758r = f50742b;
        this.f50761u = 10;
        this.f50762v = 300000L;
        this.f50763w = -1L;
        this.f50745e = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L@)");
        f50743c = sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K@!");
        this.f50759s = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.f50745e);
        parcel.writeByte(this.f50746f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f50747g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f50748h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f50757q);
        parcel.writeString(this.f50758r);
        parcel.writeString(this.f50759s);
        ap.b(parcel, this.f50760t);
        parcel.writeByte(this.f50749i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f50750j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f50753m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f50754n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f50756p);
        parcel.writeByte(this.f50751k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f50752l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f50755o);
        parcel.writeInt(this.f50761u);
        parcel.writeLong(this.f50762v);
        parcel.writeLong(this.f50763w);
    }

    public StrategyBean(Parcel parcel) {
        this.f50744d = -1L;
        this.f50745e = -1L;
        boolean z3 = true;
        this.f50746f = true;
        this.f50747g = true;
        this.f50748h = true;
        this.f50749i = true;
        this.f50750j = false;
        this.f50751k = true;
        this.f50752l = true;
        this.f50753m = true;
        this.f50754n = true;
        this.f50756p = PolicyConfig.mServerBusyRetryBaseInternal;
        this.f50757q = f50741a;
        this.f50758r = f50742b;
        this.f50761u = 10;
        this.f50762v = 300000L;
        this.f50763w = -1L;
        try {
            f50743c = "S(@L@L@)";
            this.f50745e = parcel.readLong();
            this.f50746f = parcel.readByte() == 1;
            this.f50747g = parcel.readByte() == 1;
            this.f50748h = parcel.readByte() == 1;
            this.f50757q = parcel.readString();
            this.f50758r = parcel.readString();
            this.f50759s = parcel.readString();
            this.f50760t = ap.b(parcel);
            this.f50749i = parcel.readByte() == 1;
            this.f50750j = parcel.readByte() == 1;
            this.f50753m = parcel.readByte() == 1;
            this.f50754n = parcel.readByte() == 1;
            this.f50756p = parcel.readLong();
            this.f50751k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z3 = false;
            }
            this.f50752l = z3;
            this.f50755o = parcel.readLong();
            this.f50761u = parcel.readInt();
            this.f50762v = parcel.readLong();
            this.f50763w = parcel.readLong();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
