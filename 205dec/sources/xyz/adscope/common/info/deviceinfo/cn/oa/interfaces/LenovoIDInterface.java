package xyz.adscope.common.info.deviceinfo.cn.oa.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface LenovoIDInterface extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class len_up extends Binder implements LenovoIDInterface {

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public static class len_down implements LenovoIDInterface {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f64714a;

            public len_down(IBinder iBinder) {
                this.f64714a = iBinder;
            }

            @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.LenovoIDInterface
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f64714a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e4) {
                        LogUtil.e(CommonConstants.TAG, "e : " + e4);
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.LenovoIDInterface
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f64714a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e4) {
                        LogUtil.e(CommonConstants.TAG, "e : " + e4);
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

            @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.LenovoIDInterface
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f64714a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e4) {
                        LogUtil.e(CommonConstants.TAG, "e : " + e4);
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.LenovoIDInterface
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                        this.f64714a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e4) {
                        LogUtil.e(CommonConstants.TAG, "e : " + e4);
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.LenovoIDInterface
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f64714a.transact(3, obtain, obtain2, 0);
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
        }

        public static LenovoIDInterface getHelper(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof LenovoIDInterface)) ? new len_down(iBinder) : (LenovoIDInterface) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1598968902) {
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            } else if (i4 == 1) {
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
                return super.onTransact(i4, parcel, parcel2, i5);
            } else {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String b5 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b5);
                return true;
            }
        }
    }

    String a();

    String a(String str);

    String b();

    String b(String str);

    boolean c();
}
