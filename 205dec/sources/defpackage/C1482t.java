package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: t  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1482t implements InterfaceC1484v {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f64371a;

    @Override // defpackage.InterfaceC1484v
    public final ParcelFileDescriptor a(ArrayList arrayList) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPApplicationService");
            this.f64371a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) AbstractC1457e.g(obtain2, ParcelFileDescriptor.CREATOR);
            obtain2.readBinderList(arrayList);
            return parcelFileDescriptor;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f64371a;
    }

    @Override // defpackage.InterfaceC1484v
    public final IBinder b(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPApplicationService");
            obtain.writeString(str);
            this.f64371a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // defpackage.InterfaceC1484v
    public final List c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPApplicationService");
            this.f64371a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.createTypedArrayList(u0.CREATOR);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // defpackage.InterfaceC1484v
    public final List d() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPApplicationService");
            this.f64371a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.createTypedArrayList(u0.CREATOR);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // defpackage.InterfaceC1484v
    public final String e(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPApplicationService");
            obtain.writeString(str);
            this.f64371a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
