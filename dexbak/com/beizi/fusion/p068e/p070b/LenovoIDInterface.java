package com.beizi.fusion.p068e.p070b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.beizi.fusion.e.b.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface LenovoIDInterface extends IInterface {
    /* renamed from: a */
    String mo48542a();

    /* renamed from: a */
    String mo48541a(String str);

    /* renamed from: b */
    String mo48540b();

    /* renamed from: b */
    String mo48539b(String str);

    /* renamed from: c */
    boolean mo48538c();

    /* compiled from: LenovoIDInterface.java */
    /* renamed from: com.beizi.fusion.e.b.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractBinderC3103a extends Binder implements LenovoIDInterface {
        @Override // android.os.Binder
        protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String mo48542a = mo48542a();
                parcel2.writeNoException();
                parcel2.writeString(mo48542a);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String mo48540b = mo48540b();
                parcel2.writeNoException();
                parcel2.writeString(mo48540b);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                boolean mo48538c = mo48538c();
                parcel2.writeNoException();
                parcel2.writeInt(mo48538c ? 1 : 0);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String mo48541a = mo48541a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(mo48541a);
                return true;
            } else if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            } else {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String mo48539b = mo48539b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(mo48539b);
                return true;
            }
        }

        /* compiled from: LenovoIDInterface.java */
        /* renamed from: com.beizi.fusion.e.b.c$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class C3104a implements LenovoIDInterface {

            /* renamed from: a */
            private IBinder f11215a;

            public C3104a(IBinder iBinder) {
                this.f11215a = iBinder;
            }

            @Override // com.beizi.fusion.p068e.p070b.LenovoIDInterface
            /* renamed from: a */
            public String mo48542a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f11215a.transact(1, obtain, obtain2, 0);
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
            public IBinder asBinder() {
                return null;
            }

            @Override // com.beizi.fusion.p068e.p070b.LenovoIDInterface
            /* renamed from: b */
            public String mo48540b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f11215a.transact(2, obtain, obtain2, 0);
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

            @Override // com.beizi.fusion.p068e.p070b.LenovoIDInterface
            /* renamed from: c */
            public boolean mo48538c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f11215a.transact(3, obtain, obtain2, 0);
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

            @Override // com.beizi.fusion.p068e.p070b.LenovoIDInterface
            /* renamed from: a */
            public String mo48541a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f11215a.transact(4, obtain, obtain2, 0);
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

            @Override // com.beizi.fusion.p068e.p070b.LenovoIDInterface
            /* renamed from: b */
            public String mo48539b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f11215a.transact(5, obtain, obtain2, 0);
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
