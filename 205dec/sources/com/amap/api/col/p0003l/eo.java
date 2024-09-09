package com.amap.api.col.p0003l;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ContourLineOptions.java */
@JBindingInclude
/* renamed from: com.amap.api.col.3l.eo  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class eo extends BaseOptions implements Parcelable {
    @JBindingExclude
    public static final Parcelable.Creator<eo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private float f7638a;

    /* renamed from: b  reason: collision with root package name */
    private float f7639b;

    /* renamed from: c  reason: collision with root package name */
    private float f7640c;

    /* renamed from: d  reason: collision with root package name */
    private float f7641d;

    /* renamed from: e  reason: collision with root package name */
    private float f7642e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7643f;

    /* renamed from: g  reason: collision with root package name */
    private int f7644g;

    /* renamed from: h  reason: collision with root package name */
    private double f7645h;

    /* renamed from: i  reason: collision with root package name */
    private List<k3> f7646i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: ContourLineOptions.java */
    /* renamed from: com.amap.api.col.3l.eo$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class a implements Parcelable.Creator<eo> {
        a() {
        }

        private static eo a(Parcel parcel) {
            return new eo(parcel);
        }

        private static eo[] b(int i4) {
            return new eo[i4];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ eo createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ eo[] newArray(int i4) {
            return b(i4);
        }
    }

    public eo() {
        this.f7638a = 3.0f;
        this.f7639b = 20.0f;
        this.f7640c = Float.MIN_VALUE;
        this.f7641d = Float.MAX_VALUE;
        this.f7642e = 200.0f;
        this.f7643f = true;
        this.f7644g = -3355444;
        this.f7645h = 3.0d;
        this.f7646i = new ArrayList();
        this.type = "ContourLineOptions";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.f7638a);
        parcel.writeFloat(this.f7639b);
        parcel.writeFloat(this.f7640c);
        parcel.writeFloat(this.f7641d);
        parcel.writeFloat(this.f7642e);
        parcel.writeBooleanArray(new boolean[]{this.f7643f});
        parcel.writeInt(this.f7644g);
        parcel.writeDouble(this.f7645h);
        parcel.writeList(this.f7646i);
    }

    @JBindingExclude
    protected eo(Parcel parcel) {
        this.f7638a = 3.0f;
        this.f7639b = 20.0f;
        this.f7640c = Float.MIN_VALUE;
        this.f7641d = Float.MAX_VALUE;
        this.f7642e = 200.0f;
        this.f7643f = true;
        this.f7644g = -3355444;
        this.f7645h = 3.0d;
        this.f7646i = new ArrayList();
        this.f7638a = parcel.readFloat();
        this.f7639b = parcel.readFloat();
        this.f7640c = parcel.readFloat();
        this.f7641d = parcel.readFloat();
        this.f7642e = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f7643f = zArr[0];
        this.f7644g = parcel.readInt();
        this.f7645h = parcel.readDouble();
        this.f7646i = parcel.readArrayList(k3.class.getClassLoader());
    }
}
