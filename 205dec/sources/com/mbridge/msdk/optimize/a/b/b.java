package com.mbridge.msdk.optimize.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: LenovoIDInterface.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface b extends IInterface {
    String a();

    String a(String str);

    String b();

    String b(String str);

    boolean c();

    /* compiled from: LenovoIDInterface.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static abstract class a extends Binder implements b {
        @Override // android.os.Binder
        protected boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 == 1) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String a4 = a();
                parcel2.writeNoException();
                parcel2.writeString(a4);
                return true;
            } else if (i4 == 2) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String b4 = b();
                parcel2.writeNoException();
                parcel2.writeString(b4);
                return true;
            } else if (i4 == 3) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                boolean c4 = c();
                parcel2.writeNoException();
                parcel2.writeInt(c4 ? 1 : 0);
                return true;
            } else if (i4 == 4) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String a5 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a5);
                return true;
            } else if (i4 != 5) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            } else {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String b5 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b5);
                return true;
            }
        }

        /* compiled from: LenovoIDInterface.java */
        /* renamed from: com.mbridge.msdk.optimize.a.b.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public static class C0755a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f40423a;

            public C0755a(IBinder iBinder) {
                this.f40423a = iBinder;
            }

            @Override // com.mbridge.msdk.optimize.a.b.b
            public final String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f40423a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e4) {
                        e4.printStackTrace();
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

            @Override // com.mbridge.msdk.optimize.a.b.b
            public final String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f40423a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mbridge.msdk.optimize.a.b.b
            public final boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f40423a.transact(3, obtain, obtain2, 0);
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

            @Override // com.mbridge.msdk.optimize.a.b.b
            public final String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f40423a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mbridge.msdk.optimize.a.b.b
            public final String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f40423a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e4) {
                        e4.printStackTrace();
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
