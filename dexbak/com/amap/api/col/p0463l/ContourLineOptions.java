package com.amap.api.col.p0463l;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

@JBindingInclude
/* renamed from: com.amap.api.col.3l.eo */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ContourLineOptions extends BaseOptions implements Parcelable {
    @JBindingExclude
    public static final Parcelable.Creator<ContourLineOptions> CREATOR = new C1798a();

    /* renamed from: a */
    private float f4060a;

    /* renamed from: b */
    private float f4061b;

    /* renamed from: c */
    private float f4062c;

    /* renamed from: d */
    private float f4063d;

    /* renamed from: e */
    private float f4064e;

    /* renamed from: f */
    private boolean f4065f;

    /* renamed from: g */
    private int f4066g;

    /* renamed from: h */
    private double f4067h;

    /* renamed from: i */
    private List<AltitudeLatLng> f4068i;

    /* compiled from: ContourLineOptions.java */
    /* renamed from: com.amap.api.col.3l.eo$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1798a implements Parcelable.Creator<ContourLineOptions> {
        C1798a() {
        }

        /* renamed from: a */
        private static ContourLineOptions m55110a(Parcel parcel) {
            return new ContourLineOptions(parcel);
        }

        /* renamed from: b */
        private static ContourLineOptions[] m55109b(int i) {
            return new ContourLineOptions[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ContourLineOptions createFromParcel(Parcel parcel) {
            return m55110a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ContourLineOptions[] newArray(int i) {
            return m55109b(i);
        }
    }

    public ContourLineOptions() {
        this.f4060a = 3.0f;
        this.f4061b = 20.0f;
        this.f4062c = Float.MIN_VALUE;
        this.f4063d = Float.MAX_VALUE;
        this.f4064e = 200.0f;
        this.f4065f = true;
        this.f4066g = -3355444;
        this.f4067h = 3.0d;
        this.f4068i = new ArrayList();
        this.type = "ContourLineOptions";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f4060a);
        parcel.writeFloat(this.f4061b);
        parcel.writeFloat(this.f4062c);
        parcel.writeFloat(this.f4063d);
        parcel.writeFloat(this.f4064e);
        parcel.writeBooleanArray(new boolean[]{this.f4065f});
        parcel.writeInt(this.f4066g);
        parcel.writeDouble(this.f4067h);
        parcel.writeList(this.f4068i);
    }

    @JBindingExclude
    protected ContourLineOptions(Parcel parcel) {
        this.f4060a = 3.0f;
        this.f4061b = 20.0f;
        this.f4062c = Float.MIN_VALUE;
        this.f4063d = Float.MAX_VALUE;
        this.f4064e = 200.0f;
        this.f4065f = true;
        this.f4066g = -3355444;
        this.f4067h = 3.0d;
        this.f4068i = new ArrayList();
        this.f4060a = parcel.readFloat();
        this.f4061b = parcel.readFloat();
        this.f4062c = parcel.readFloat();
        this.f4063d = parcel.readFloat();
        this.f4064e = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f4065f = zArr[0];
        this.f4066g = parcel.readInt();
        this.f4067h = parcel.readDouble();
        this.f4068i = parcel.readArrayList(AltitudeLatLng.class.getClassLoader());
    }
}
