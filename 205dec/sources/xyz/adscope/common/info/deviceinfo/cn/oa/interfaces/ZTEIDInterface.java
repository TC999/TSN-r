package xyz.adscope.common.info.deviceinfo.cn.oa.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface ZTEIDInterface extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class up extends Binder implements ZTEIDInterface {

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public static class down implements ZTEIDInterface {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f64716a;

            public down(IBinder iBinder) {
                this.f64716a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f64716a;
            }

            @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.ZTEIDInterface
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f64716a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        obtain2.recycle();
                        obtain.recycle();
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    th.printStackTrace();
                    return false;
                }
            }

            @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.ZTEIDInterface
            public String getOAID() {
                String str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f64716a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                    str = null;
                }
                obtain2.recycle();
                obtain.recycle();
                return str;
            }

            @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.ZTEIDInterface
            public boolean isSupported() {
                return false;
            }

            @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.ZTEIDInterface
            public void shutDown() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f64716a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                }
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    boolean c();

    String getOAID();

    boolean isSupported();

    void shutDown();
}
