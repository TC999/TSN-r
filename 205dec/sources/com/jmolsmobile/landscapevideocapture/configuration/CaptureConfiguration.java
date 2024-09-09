package com.jmolsmobile.landscapevideocapture.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class CaptureConfiguration implements Parcelable {
    public static final Parcelable.Creator<CaptureConfiguration> CREATOR = new a();

    /* renamed from: n  reason: collision with root package name */
    public static final int f37913n = 1048576;

    /* renamed from: o  reason: collision with root package name */
    public static final int f37914o = 1000;

    /* renamed from: p  reason: collision with root package name */
    public static final int f37915p = -1;

    /* renamed from: q  reason: collision with root package name */
    public static final int f37916q = -1;

    /* renamed from: a  reason: collision with root package name */
    private int f37917a;

    /* renamed from: b  reason: collision with root package name */
    private int f37918b;

    /* renamed from: c  reason: collision with root package name */
    private int f37919c;

    /* renamed from: d  reason: collision with root package name */
    private int f37920d;

    /* renamed from: e  reason: collision with root package name */
    private int f37921e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37922f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f37923g;

    /* renamed from: h  reason: collision with root package name */
    private int f37924h;

    /* renamed from: i  reason: collision with root package name */
    private int f37925i;

    /* renamed from: j  reason: collision with root package name */
    private int f37926j;

    /* renamed from: k  reason: collision with root package name */
    private int f37927k;

    /* renamed from: l  reason: collision with root package name */
    private int f37928l;

    /* renamed from: m  reason: collision with root package name */
    private int f37929m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a implements Parcelable.Creator<CaptureConfiguration> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CaptureConfiguration createFromParcel(Parcel parcel) {
            return new CaptureConfiguration(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CaptureConfiguration[] newArray(int i4) {
            return new CaptureConfiguration[i4];
        }
    }

    /* synthetic */ CaptureConfiguration(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static CaptureConfiguration l() {
        return new CaptureConfiguration();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean i() {
        return this.f37923g;
    }

    public int j() {
        return this.f37927k;
    }

    public int k() {
        return this.f37926j;
    }

    public int m() {
        return this.f37920d;
    }

    public int n() {
        return this.f37921e;
    }

    public int o() {
        return this.f37925i;
    }

    public boolean p() {
        return this.f37922f;
    }

    public int q() {
        return this.f37919c;
    }

    public int r() {
        return this.f37929m;
    }

    public int s() {
        return this.f37924h;
    }

    public int t() {
        return this.f37918b;
    }

    public int u() {
        return this.f37928l;
    }

    public int v() {
        return this.f37917a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f37917a);
        parcel.writeInt(this.f37918b);
        parcel.writeInt(this.f37919c);
        parcel.writeInt(this.f37920d);
        parcel.writeInt(this.f37921e);
        parcel.writeInt(this.f37924h);
        parcel.writeByte(this.f37922f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f37923g ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f37925i);
        parcel.writeInt(this.f37926j);
        parcel.writeInt(this.f37927k);
        parcel.writeInt(this.f37928l);
        parcel.writeInt(this.f37929m);
    }

    /* synthetic */ CaptureConfiguration(a aVar) {
        this();
    }

    private CaptureConfiguration() {
        this.f37917a = 1280;
        this.f37918b = 720;
        this.f37919c = 5000000;
        this.f37920d = -1;
        this.f37921e = -1;
        this.f37922f = false;
        this.f37923g = true;
        this.f37924h = 30;
        this.f37925i = 2;
        this.f37926j = 0;
        this.f37927k = 3;
        this.f37928l = 1;
        this.f37929m = 2;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final CaptureConfiguration f37930a;

        public b(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality) {
            CaptureConfiguration captureConfiguration = new CaptureConfiguration((a) null);
            this.f37930a = captureConfiguration;
            captureConfiguration.f37917a = captureResolution.width;
            captureConfiguration.f37918b = captureResolution.height;
            captureConfiguration.f37919c = captureResolution.getBitrate(captureQuality);
        }

        public CaptureConfiguration a() {
            return this.f37930a;
        }

        public b b(int i4) {
            this.f37930a.f37924h = i4;
            return this;
        }

        public b c(int i4) {
            this.f37930a.f37920d = i4 * 1000;
            return this;
        }

        public b d(int i4) {
            this.f37930a.f37921e = i4 * 1048576;
            return this;
        }

        public b e() {
            this.f37930a.f37923g = false;
            return this;
        }

        public b f() {
            this.f37930a.f37922f = true;
            return this;
        }

        public b(int i4, int i5, int i6) {
            CaptureConfiguration captureConfiguration = new CaptureConfiguration((a) null);
            this.f37930a = captureConfiguration;
            captureConfiguration.f37917a = i4;
            captureConfiguration.f37918b = i5;
            captureConfiguration.f37919c = i6;
        }
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality) {
        this.f37917a = 1280;
        this.f37918b = 720;
        this.f37919c = 5000000;
        this.f37920d = -1;
        this.f37921e = -1;
        this.f37922f = false;
        this.f37923g = true;
        this.f37924h = 30;
        this.f37925i = 2;
        this.f37926j = 0;
        this.f37927k = 3;
        this.f37928l = 1;
        this.f37929m = 2;
        this.f37917a = captureResolution.width;
        this.f37918b = captureResolution.height;
        this.f37919c = captureResolution.getBitrate(captureQuality);
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i4, int i5, boolean z3) {
        this(captureResolution, captureQuality, i4, i5, z3, false);
        this.f37922f = z3;
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i4, int i5, boolean z3, boolean z4) {
        this(captureResolution, captureQuality, i4, i5);
        this.f37922f = z3;
        this.f37923g = z4;
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i4, int i5, boolean z3, boolean z4, int i6) {
        this(captureResolution, captureQuality, i4, i5, z3, z4);
        this.f37924h = i6;
    }

    @Deprecated
    public CaptureConfiguration(PredefinedCaptureConfigurations.CaptureResolution captureResolution, PredefinedCaptureConfigurations.CaptureQuality captureQuality, int i4, int i5) {
        this(captureResolution, captureQuality);
        this.f37920d = i4 * 1000;
        this.f37921e = i5 * 1048576;
    }

    @Deprecated
    public CaptureConfiguration(int i4, int i5, int i6) {
        this.f37920d = -1;
        this.f37921e = -1;
        this.f37922f = false;
        this.f37923g = true;
        this.f37924h = 30;
        this.f37925i = 2;
        this.f37926j = 0;
        this.f37927k = 3;
        this.f37928l = 1;
        this.f37929m = 2;
        this.f37917a = i4;
        this.f37918b = i5;
        this.f37919c = i6;
    }

    @Deprecated
    public CaptureConfiguration(int i4, int i5, int i6, int i7, int i8) {
        this(i4, i5, i6);
        this.f37920d = i7 * 1000;
        this.f37921e = i8 * 1048576;
    }

    private CaptureConfiguration(Parcel parcel) {
        this.f37917a = 1280;
        this.f37918b = 720;
        this.f37919c = 5000000;
        this.f37920d = -1;
        this.f37921e = -1;
        this.f37922f = false;
        this.f37923g = true;
        this.f37924h = 30;
        this.f37925i = 2;
        this.f37926j = 0;
        this.f37927k = 3;
        this.f37928l = 1;
        this.f37929m = 2;
        this.f37917a = parcel.readInt();
        this.f37918b = parcel.readInt();
        this.f37919c = parcel.readInt();
        this.f37920d = parcel.readInt();
        this.f37921e = parcel.readInt();
        this.f37924h = parcel.readInt();
        this.f37922f = parcel.readByte() != 0;
        this.f37923g = parcel.readByte() != 0;
        this.f37925i = parcel.readInt();
        this.f37926j = parcel.readInt();
        this.f37927k = parcel.readInt();
        this.f37928l = parcel.readInt();
        this.f37929m = parcel.readInt();
    }
}
