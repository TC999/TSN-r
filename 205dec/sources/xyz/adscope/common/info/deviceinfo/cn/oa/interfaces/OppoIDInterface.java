package xyz.adscope.common.info.deviceinfo.cn.oa.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface OppoIDInterface extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class up extends Binder implements OppoIDInterface {

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public static class down implements OppoIDInterface {
            public IBinder iBinder;

            public down(IBinder iBinder) {
                this.iBinder = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.iBinder;
            }

            public String getSerID(String str, String str2, String str3) {
                String str4;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.iBinder.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        str4 = obtain2.readString();
                    } catch (Exception e4) {
                        LogUtil.e(CommonConstants.TAG, "e : " + e4);
                        str4 = null;
                    }
                    return str4;
                } finally {
                    obtain.recycle();
                    obtain2.recycle();
                }
            }
        }

        public static OppoIDInterface genInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof OppoIDInterface)) ? new down(iBinder) : (OppoIDInterface) queryLocalInterface;
        }
    }
}
