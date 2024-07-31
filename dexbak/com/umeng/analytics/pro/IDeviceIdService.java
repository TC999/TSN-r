package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.umeng.analytics.pro.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface IDeviceIdService extends IInterface {

    /* compiled from: IDeviceIdService.java */
    /* renamed from: com.umeng.analytics.pro.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13119a implements IDeviceIdService {
        @Override // com.umeng.analytics.pro.IDeviceIdService
        /* renamed from: a */
        public String mo14671a() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.IDeviceIdService
        /* renamed from: a */
        public String mo14670a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.IDeviceIdService
        /* renamed from: b */
        public String mo14668b(String str) throws RemoteException {
            return null;
        }
    }

    /* renamed from: a */
    String mo14671a() throws RemoteException;

    /* renamed from: a */
    String mo14670a(String str) throws RemoteException;

    /* renamed from: b */
    String mo14668b(String str) throws RemoteException;

    /* compiled from: IDeviceIdService.java */
    /* renamed from: com.umeng.analytics.pro.b$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC13120b extends Binder implements IDeviceIdService {

        /* renamed from: a */
        static final int f37728a = 1;

        /* renamed from: b */
        static final int f37729b = 2;

        /* renamed from: c */
        static final int f37730c = 3;

        /* renamed from: d */
        private static final String f37731d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public AbstractBinderC13120b() {
            attachInterface(this, f37731d);
        }

        /* renamed from: a */
        public static IDeviceIdService m14674a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f37731d);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDeviceIdService)) {
                return (IDeviceIdService) queryLocalInterface;
            }
            return new C13121a(iBinder);
        }

        /* renamed from: b */
        public static IDeviceIdService m14672b() {
            return C13121a.f37732a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(f37731d);
                String mo14671a = mo14671a();
                parcel2.writeNoException();
                parcel2.writeString(mo14671a);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(f37731d);
                String mo14670a = mo14670a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(mo14670a);
                return true;
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(f37731d);
                return true;
            } else {
                parcel.enforceInterface(f37731d);
                String mo14668b = mo14668b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(mo14668b);
                return true;
            }
        }

        /* renamed from: a */
        public static boolean m14673a(IDeviceIdService iDeviceIdService) {
            if (C13121a.f37732a != null || iDeviceIdService == null) {
                return false;
            }
            C13121a.f37732a = iDeviceIdService;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IDeviceIdService.java */
        /* renamed from: com.umeng.analytics.pro.b$b$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C13121a implements IDeviceIdService {

            /* renamed from: a */
            public static IDeviceIdService f37732a;

            /* renamed from: b */
            private IBinder f37733b;

            C13121a(IBinder iBinder) {
                this.f37733b = iBinder;
            }

            @Override // com.umeng.analytics.pro.IDeviceIdService
            /* renamed from: a */
            public String mo14671a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC13120b.f37731d);
                    if (!this.f37733b.transact(1, obtain, obtain2, 0) && AbstractBinderC13120b.m14672b() != null) {
                        return AbstractBinderC13120b.m14672b().mo14671a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f37733b;
            }

            /* renamed from: b */
            public String m14669b() {
                return AbstractBinderC13120b.f37731d;
            }

            @Override // com.umeng.analytics.pro.IDeviceIdService
            /* renamed from: b */
            public String mo14668b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC13120b.f37731d);
                    obtain.writeString(str);
                    if (!this.f37733b.transact(3, obtain, obtain2, 0) && AbstractBinderC13120b.m14672b() != null) {
                        return AbstractBinderC13120b.m14672b().mo14668b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.IDeviceIdService
            /* renamed from: a */
            public String mo14670a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC13120b.f37731d);
                    obtain.writeString(str);
                    if (!this.f37733b.transact(2, obtain, obtain2, 0) && AbstractBinderC13120b.m14672b() != null) {
                        return AbstractBinderC13120b.m14672b().mo14670a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
