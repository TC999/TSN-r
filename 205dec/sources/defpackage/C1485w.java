package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* renamed from: w  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1485w implements InterfaceC1487y {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f64431a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f64431a;
    }

    public final int f() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPInjectedModuleService");
            this.f64431a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String[] g() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPInjectedModuleService");
            this.f64431a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.createStringArray();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final ParcelFileDescriptor h(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPInjectedModuleService");
            obtain.writeString(str);
            this.f64431a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return (ParcelFileDescriptor) AbstractC1457e.h(obtain2, ParcelFileDescriptor.CREATOR);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final Bundle i(String str, BinderC1342b0 binderC1342b0) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("org.lsposed.lspd.service.ILSPInjectedModuleService");
            obtain.writeString(str);
            obtain.writeStrongInterface(binderC1342b0);
            this.f64431a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return (Bundle) AbstractC1457e.h(obtain2, Bundle.CREATOR);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
