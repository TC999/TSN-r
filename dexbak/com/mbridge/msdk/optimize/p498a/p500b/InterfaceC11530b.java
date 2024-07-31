package com.mbridge.msdk.optimize.p498a.p500b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: LenovoIDInterface.java */
/* renamed from: com.mbridge.msdk.optimize.a.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC11530b extends IInterface {
    /* renamed from: a */
    String mo21348a();

    /* renamed from: a */
    String mo21347a(String str);

    /* renamed from: b */
    String mo21346b();

    /* renamed from: b */
    String mo21345b(String str);

    /* renamed from: c */
    boolean mo21344c();

    /* compiled from: LenovoIDInterface.java */
    /* renamed from: com.mbridge.msdk.optimize.a.b.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractBinderC11531a extends Binder implements InterfaceC11530b {
        @Override // android.os.Binder
        protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String mo21348a = mo21348a();
                parcel2.writeNoException();
                parcel2.writeString(mo21348a);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String mo21346b = mo21346b();
                parcel2.writeNoException();
                parcel2.writeString(mo21346b);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                boolean mo21344c = mo21344c();
                parcel2.writeNoException();
                parcel2.writeInt(mo21344c ? 1 : 0);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String mo21347a = mo21347a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(mo21347a);
                return true;
            } else if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            } else {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String mo21345b = mo21345b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(mo21345b);
                return true;
            }
        }

        /* compiled from: LenovoIDInterface.java */
        /* renamed from: com.mbridge.msdk.optimize.a.b.b$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C11532a implements InterfaceC11530b {

            /* renamed from: a */
            private IBinder f31650a;

            public C11532a(IBinder iBinder) {
                this.f31650a = iBinder;
            }

            @Override // com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11530b
            /* renamed from: a */
            public final String mo21348a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f31650a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return null;
            }

            @Override // com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11530b
            /* renamed from: b */
            public final String mo21346b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f31650a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11530b
            /* renamed from: c */
            public final boolean mo21344c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f31650a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    r2 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                }
                return r2;
            }

            @Override // com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11530b
            /* renamed from: a */
            public final String mo21347a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f31650a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11530b
            /* renamed from: b */
            public final String mo21345b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f31650a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
