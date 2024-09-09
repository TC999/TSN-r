package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: t0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class t0 implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f64375a;

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, u0] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, F0] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f64375a) {
            case 0:
                ?? obj = new Object();
                obj.f64417b = 0;
                obj.a(parcel);
                return obj;
            default:
                ?? obj2 = new Object();
                obj2.f21d = false;
                obj2.b(parcel);
                return obj2;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f64375a) {
            case 0:
                return new u0[i4];
            default:
                return new F0[i4];
        }
    }
}
