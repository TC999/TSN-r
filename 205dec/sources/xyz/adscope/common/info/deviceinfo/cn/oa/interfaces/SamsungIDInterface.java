package xyz.adscope.common.info.deviceinfo.cn.oa.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface SamsungIDInterface extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Proxy implements SamsungIDInterface {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f64715a;

        public Proxy(IBinder iBinder) {
            this.f64715a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f64715a;
        }

        @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.SamsungIDInterface
        public String getID() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.f64715a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                th.printStackTrace();
                str = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return str;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class Stub extends Binder implements SamsungIDInterface {
        public Stub() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public SamsungIDInterface a(IBinder iBinder) {
            if (iBinder == null || iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService") == null) {
                return null;
            }
            return new Proxy(iBinder);
        }
    }

    String getID();
}
