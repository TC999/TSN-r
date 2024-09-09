package defpackage;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SharedMemory;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: F0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class F0 implements Parcelable {
    public static final Parcelable.Creator CREATOR = new t0(1);

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f18a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f19b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f20c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21d;

    public static int a(Object obj) {
        int i4 = 0;
        if (obj == null) {
            return 0;
        }
        if (!(obj instanceof Collection)) {
            if (obj instanceof Parcelable) {
                return ((Parcelable) obj).describeContents();
            }
            return 0;
        }
        for (Object obj2 : (Collection) obj) {
            i4 |= a(obj2);
        }
        return i4;
    }

    public final void b(Parcel parcel) {
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        try {
            if (readInt < 4) {
                throw new BadParcelableException("Parcelable too small");
            }
            if (parcel.dataPosition() - dataPosition < readInt) {
                this.f18a = parcel.createTypedArrayList(SharedMemory.CREATOR);
                if (parcel.dataPosition() - dataPosition < readInt) {
                    this.f19b = parcel.createStringArrayList();
                    if (parcel.dataPosition() - dataPosition < readInt) {
                        this.f20c = parcel.createStringArrayList();
                        if (parcel.dataPosition() - dataPosition < readInt) {
                            this.f21d = parcel.readInt() != 0;
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
        return a(this.f18a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(0);
        AbstractC1457e.n(parcel, this.f18a, i4);
        parcel.writeStringList(this.f19b);
        parcel.writeStringList(this.f20c);
        parcel.writeInt(this.f21d ? 1 : 0);
        int dataPosition2 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition2 - dataPosition);
        parcel.setDataPosition(dataPosition2);
    }
}
