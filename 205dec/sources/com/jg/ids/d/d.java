package com.jg.ids.d;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f37815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(IBinder iBinder) {
        this.f37815a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f37815a;
    }

    @Override // com.jg.ids.d.b
    public final boolean a() {
        boolean z3;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f37815a.transact(1, obtain, obtain2, 0) && c.d() != null) {
                z3 = c.d().a();
            } else {
                obtain2.readException();
                z3 = obtain2.readInt() != 0;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.d.b
    public final String a(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            obtain.writeString(str);
            if (!this.f37815a.transact(2, obtain, obtain2, 0) && c.d() != null) {
                readString = c.d().a(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.d.b
    public final String b() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f37815a.transact(3, obtain, obtain2, 0) && c.d() != null) {
                readString = c.d().b();
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.d.b
    public final String c() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f37815a.transact(4, obtain, obtain2, 0) && c.d() != null) {
                readString = c.d().c();
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.d.b
    public final String b(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            obtain.writeString(str);
            if (!this.f37815a.transact(5, obtain, obtain2, 0) && c.d() != null) {
                readString = c.d().b(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
