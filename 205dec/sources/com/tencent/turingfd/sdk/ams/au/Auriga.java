package com.tencent.turingfd.sdk.ams.au;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface Auriga extends IInterface {
    int a() throws RemoteException;

    int a(int i4) throws RemoteException;

    int b(int i4) throws RemoteException;

    boolean c(int i4) throws RemoteException;

    Cantaloupe e(int i4) throws RemoteException;

    /* renamed from: com.tencent.turingfd.sdk.ams.au.Auriga$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static abstract class Cdo extends Binder implements Auriga {

        /* renamed from: a  reason: collision with root package name */
        public static final String f51892a = Cextends.a(Cextends.L0);

        /* renamed from: com.tencent.turingfd.sdk.ams.au.Auriga$do$do  reason: invalid class name and collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public static class C1046do implements Auriga {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f51893a;

            public C1046do(IBinder iBinder) {
                this.f51893a = iBinder;
            }

            @Override // com.tencent.turingfd.sdk.ams.au.Auriga
            public int a(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Cdo.f51892a);
                    obtain.writeInt(i4);
                    if (!this.f51893a.transact(7, obtain, obtain2, 0)) {
                        String str = Cdo.f51892a;
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f51893a;
            }

            @Override // com.tencent.turingfd.sdk.ams.au.Auriga
            public int b(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Cdo.f51892a);
                    obtain.writeInt(i4);
                    if (!this.f51893a.transact(1, obtain, obtain2, 0)) {
                        String str = Cdo.f51892a;
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.turingfd.sdk.ams.au.Auriga
            public boolean c(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Cdo.f51892a);
                    obtain.writeInt(i4);
                    if (!this.f51893a.transact(3, obtain, obtain2, 0)) {
                        String str = Cdo.f51892a;
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.turingfd.sdk.ams.au.Auriga
            public Cantaloupe e(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Cdo.f51892a);
                    obtain.writeInt(i4);
                    if (!this.f51893a.transact(2, obtain, obtain2, 0)) {
                        String str = Cdo.f51892a;
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? new Cantaloupe(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.turingfd.sdk.ams.au.Auriga
            public int a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Cdo.f51892a);
                    if (!this.f51893a.transact(12, obtain, obtain2, 0)) {
                        String str = Cdo.f51892a;
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
