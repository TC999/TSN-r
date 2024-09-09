package defpackage;

import android.content.pm.ApplicationInfo;
import android.os.BadParcelableException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: u0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class u0 implements Parcelable {
    public static final Parcelable.Creator CREATOR = new t0(0);

    /* renamed from: a  reason: collision with root package name */
    public String f64416a;

    /* renamed from: b  reason: collision with root package name */
    public int f64417b;

    /* renamed from: c  reason: collision with root package name */
    public String f64418c;

    /* renamed from: d  reason: collision with root package name */
    public F0 f64419d;

    /* renamed from: e  reason: collision with root package name */
    public ApplicationInfo f64420e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1487y f64421f;

    /* JADX WARN: Type inference failed for: r5v4, types: [w, java.lang.Object] */
    public final void a(Parcel parcel) {
        InterfaceC1487y interfaceC1487y;
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        try {
            if (readInt < 4) {
                throw new BadParcelableException("Parcelable too small");
            }
            if (parcel.dataPosition() - dataPosition < readInt) {
                this.f64416a = parcel.readString();
                if (parcel.dataPosition() - dataPosition < readInt) {
                    this.f64417b = parcel.readInt();
                    if (parcel.dataPosition() - dataPosition < readInt) {
                        this.f64418c = parcel.readString();
                        if (parcel.dataPosition() - dataPosition < readInt) {
                            this.f64419d = (F0) AbstractC1457e.f(parcel, F0.CREATOR);
                            if (parcel.dataPosition() - dataPosition < readInt) {
                                this.f64420e = (ApplicationInfo) AbstractC1457e.f(parcel, ApplicationInfo.CREATOR);
                                if (parcel.dataPosition() - dataPosition < readInt) {
                                    IBinder readStrongBinder = parcel.readStrongBinder();
                                    int i4 = AbstractBinderC1486x.f64434a;
                                    if (readStrongBinder == null) {
                                        interfaceC1487y = null;
                                    } else {
                                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("org.lsposed.lspd.service.ILSPInjectedModuleService");
                                        if (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1487y)) {
                                            ?? obj = new Object();
                                            obj.f64431a = readStrongBinder;
                                            interfaceC1487y = obj;
                                        } else {
                                            interfaceC1487y = (InterfaceC1487y) queryLocalInterface;
                                        }
                                    }
                                    this.f64421f = interfaceC1487y;
                                    if (dataPosition > Integer.MAX_VALUE - readInt) {
                                        throw new BadParcelableException("Overflow in the size of parcelable");
                                    }
                                    parcel.setDataPosition(dataPosition + readInt);
                                    return;
                                } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                                    throw new BadParcelableException("Overflow in the size of parcelable");
                                }
                            } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                                throw new BadParcelableException("Overflow in the size of parcelable");
                            }
                        } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                            throw new BadParcelableException("Overflow in the size of parcelable");
                        }
                    } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                        throw new BadParcelableException("Overflow in the size of parcelable");
                    }
                } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                    throw new BadParcelableException("Overflow in the size of parcelable");
                }
            } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                throw new BadParcelableException("Overflow in the size of parcelable");
            }
            parcel.setDataPosition(dataPosition + readInt);
        } catch (Throwable th) {
            if (dataPosition > Integer.MAX_VALUE - readInt) {
                throw new BadParcelableException("Overflow in the size of parcelable");
            }
            parcel.setDataPosition(dataPosition + readInt);
            throw th;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        F0 f02 = this.f64419d;
        int i4 = 0;
        int describeContents = f02 == null ? 0 : f02.describeContents();
        ApplicationInfo applicationInfo = this.f64420e;
        if (applicationInfo != null && (applicationInfo instanceof Parcelable)) {
            i4 = applicationInfo.describeContents();
        }
        return describeContents | i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(0);
        parcel.writeString(this.f64416a);
        parcel.writeInt(this.f64417b);
        parcel.writeString(this.f64418c);
        AbstractC1457e.p(parcel, this.f64419d, i4);
        AbstractC1457e.p(parcel, this.f64420e, i4);
        parcel.writeStrongInterface(this.f64421f);
        int dataPosition2 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition2 - dataPosition);
        parcel.setDataPosition(dataPosition2);
    }
}
