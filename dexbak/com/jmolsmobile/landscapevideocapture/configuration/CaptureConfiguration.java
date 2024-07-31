package com.jmolsmobile.landscapevideocapture.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CaptureConfiguration implements Parcelable {
    public static final Parcelable.Creator<CaptureConfiguration> CREATOR = new C7138a();

    /* renamed from: n */
    public static final int f24365n = 1048576;

    /* renamed from: o */
    public static final int f24366o = 1000;

    /* renamed from: p */
    public static final int f24367p = -1;

    /* renamed from: q */
    public static final int f24368q = -1;

    /* renamed from: a */
    private int f24369a;

    /* renamed from: b */
    private int f24370b;

    /* renamed from: c */
    private int f24371c;

    /* renamed from: d */
    private int f24372d;

    /* renamed from: e */
    private int f24373e;

    /* renamed from: f */
    private boolean f24374f;

    /* renamed from: g */
    private boolean f24375g;

    /* renamed from: h */
    private int f24376h;

    /* renamed from: i */
    private int f24377i;

    /* renamed from: j */
    private int f24378j;

    /* renamed from: k */
    private int f24379k;

    /* renamed from: l */
    private int f24380l;

    /* renamed from: m */
    private int f24381m;

    /* renamed from: com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C7138a implements Parcelable.Creator<CaptureConfiguration> {
        C7138a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CaptureConfiguration createFromParcel(Parcel parcel) {
            return new CaptureConfiguration(parcel, (C7138a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CaptureConfiguration[] newArray(int i) {
            return new CaptureConfiguration[i];
        }
    }

    /* synthetic */ CaptureConfiguration(Parcel parcel, C7138a c7138a) {
        this(parcel);
    }

    /* renamed from: l */
    public static CaptureConfiguration m34503l() {
        return new CaptureConfiguration();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: i */
    public boolean m34506i() {
        return this.f24375g;
    }

    /* renamed from: j */
    public int m34505j() {
        return this.f24379k;
    }

    /* renamed from: k */
    public int m34504k() {
        return this.f24378j;
    }

    /* renamed from: m */
    public int m34502m() {
        return this.f24372d;
    }

    /* renamed from: n */
    public int m34501n() {
        return this.f24373e;
    }

    /* renamed from: o */
    public int m34500o() {
        return this.f24377i;
    }

    /* renamed from: p */
    public boolean m34499p() {
        return this.f24374f;
    }

    /* renamed from: q */
    public int m34498q() {
        return this.f24371c;
    }

    /* renamed from: r */
    public int m34497r() {
        return this.f24381m;
    }

    /* renamed from: s */
    public int m34496s() {
        return this.f24376h;
    }

    /* renamed from: t */
    public int m34495t() {
        return this.f24370b;
    }

    /* renamed from: u */
    public int m34494u() {
        return this.f24380l;
    }

    /* renamed from: v */
    public int m34493v() {
        return this.f24369a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f24369a);
        parcel.writeInt(this.f24370b);
        parcel.writeInt(this.f24371c);
        parcel.writeInt(this.f24372d);
        parcel.writeInt(this.f24373e);
        parcel.writeInt(this.f24376h);
        parcel.writeByte(this.f24374f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f24375g ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f24377i);
        parcel.writeInt(this.f24378j);
        parcel.writeInt(this.f24379k);
        parcel.writeInt(this.f24380l);
        parcel.writeInt(this.f24381m);
    }

    /* synthetic */ CaptureConfiguration(C7138a c7138a) {
        this();
    }

    private CaptureConfiguration() {
        this.f24369a = PredefinedCaptureConfigurations.f24405o;
        this.f24370b = PredefinedCaptureConfigurations.f24404n;
        this.f24371c = PredefinedCaptureConfigurations.f24403m;
        this.f24372d = -1;
        this.f24373e = -1;
        this.f24374f = false;
        this.f24375g = true;
        this.f24376h = 30;
        this.f24377i = 2;
        this.f24378j = 0;
        this.f24379k = 3;
        this.f24380l = 1;
        this.f24381m = 2;
    }

    /* renamed from: com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7139b {

        /* renamed from: a */
        private final CaptureConfiguration f24382a;

        public C7139b(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality) {
            CaptureConfiguration captureConfiguration = new CaptureConfiguration((C7138a) null);
            this.f24382a = captureConfiguration;
            captureConfiguration.f24369a = captureResolution.width;
            captureConfiguration.f24370b = captureResolution.height;
            captureConfiguration.f24371c = captureResolution.getBitrate(captureQuality);
        }

        /* renamed from: a */
        public CaptureConfiguration m34490a() {
            return this.f24382a;
        }

        /* renamed from: b */
        public C7139b m34489b(int i) {
            this.f24382a.f24376h = i;
            return this;
        }

        /* renamed from: c */
        public C7139b m34488c(int i) {
            this.f24382a.f24372d = i * 1000;
            return this;
        }

        /* renamed from: d */
        public C7139b m34487d(int i) {
            this.f24382a.f24373e = i * 1048576;
            return this;
        }

        /* renamed from: e */
        public C7139b m34486e() {
            this.f24382a.f24375g = false;
            return this;
        }

        /* renamed from: f */
        public C7139b m34485f() {
            this.f24382a.f24374f = true;
            return this;
        }

        public C7139b(int i, int i2, int i3) {
            CaptureConfiguration captureConfiguration = new CaptureConfiguration((C7138a) null);
            this.f24382a = captureConfiguration;
            captureConfiguration.f24369a = i;
            captureConfiguration.f24370b = i2;
            captureConfiguration.f24371c = i3;
        }
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality) {
        this.f24369a = PredefinedCaptureConfigurations.f24405o;
        this.f24370b = PredefinedCaptureConfigurations.f24404n;
        this.f24371c = PredefinedCaptureConfigurations.f24403m;
        this.f24372d = -1;
        this.f24373e = -1;
        this.f24374f = false;
        this.f24375g = true;
        this.f24376h = 30;
        this.f24377i = 2;
        this.f24378j = 0;
        this.f24379k = 3;
        this.f24380l = 1;
        this.f24381m = 2;
        this.f24369a = captureResolution.width;
        this.f24370b = captureResolution.height;
        this.f24371c = captureResolution.getBitrate(captureQuality);
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i, int i2, boolean z) {
        this(captureResolution, captureQuality, i, i2, z, false);
        this.f24374f = z;
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i, int i2, boolean z, boolean z2) {
        this(captureResolution, captureQuality, i, i2);
        this.f24374f = z;
        this.f24375g = z2;
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i, int i2, boolean z, boolean z2, int i3) {
        this(captureResolution, captureQuality, i, i2, z, z2);
        this.f24376h = i3;
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i, int i2) {
        this(captureResolution, captureQuality);
        this.f24372d = i * 1000;
        this.f24373e = i2 * 1048576;
    }

    @Deprecated
    public CaptureConfiguration(int i, int i2, int i3) {
        this.f24372d = -1;
        this.f24373e = -1;
        this.f24374f = false;
        this.f24375g = true;
        this.f24376h = 30;
        this.f24377i = 2;
        this.f24378j = 0;
        this.f24379k = 3;
        this.f24380l = 1;
        this.f24381m = 2;
        this.f24369a = i;
        this.f24370b = i2;
        this.f24371c = i3;
    }

    @Deprecated
    public CaptureConfiguration(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3);
        this.f24372d = i4 * 1000;
        this.f24373e = i5 * 1048576;
    }

    private CaptureConfiguration(Parcel parcel) {
        this.f24369a = PredefinedCaptureConfigurations.f24405o;
        this.f24370b = PredefinedCaptureConfigurations.f24404n;
        this.f24371c = PredefinedCaptureConfigurations.f24403m;
        this.f24372d = -1;
        this.f24373e = -1;
        this.f24374f = false;
        this.f24375g = true;
        this.f24376h = 30;
        this.f24377i = 2;
        this.f24378j = 0;
        this.f24379k = 3;
        this.f24380l = 1;
        this.f24381m = 2;
        this.f24369a = parcel.readInt();
        this.f24370b = parcel.readInt();
        this.f24371c = parcel.readInt();
        this.f24372d = parcel.readInt();
        this.f24373e = parcel.readInt();
        this.f24376h = parcel.readInt();
        this.f24374f = parcel.readByte() != 0;
        this.f24375g = parcel.readByte() != 0;
        this.f24377i = parcel.readInt();
        this.f24378j = parcel.readInt();
        this.f24379k = parcel.readInt();
        this.f24380l = parcel.readInt();
        this.f24381m = parcel.readInt();
    }
}
