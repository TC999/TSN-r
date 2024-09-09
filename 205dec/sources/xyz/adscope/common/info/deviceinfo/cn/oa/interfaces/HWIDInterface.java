package xyz.adscope.common.info.deviceinfo.cn.oa.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface HWIDInterface extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static final class HWID implements HWIDInterface {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f64713a;

        public HWID(IBinder iBinder) {
            this.f64713a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f64713a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
            if (r1.readInt() == 0) goto L6;
         */
        @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.HWIDInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean getBoos() {
            /*
                r5 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                r2 = 1
                r3 = 0
                java.lang.String r4 = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService"
                r0.writeInterfaceToken(r4)     // Catch: java.lang.Throwable -> L1e
                android.os.IBinder r4 = r5.f64713a     // Catch: java.lang.Throwable -> L1e
                r4.transact(r2, r0, r1, r3)     // Catch: java.lang.Throwable -> L1e
                r1.readException()     // Catch: java.lang.Throwable -> L1e
                int r4 = r1.readInt()     // Catch: java.lang.Throwable -> L1e
                if (r4 != 0) goto L24
                goto L25
            L1e:
                r0.recycle()
                r1.recycle()
            L24:
                r2 = 0
            L25:
                r0.recycle()
                r1.recycle()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.HWIDInterface.HWID.getBoos():boolean");
        }

        @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.HWIDInterface
        public String getIDs() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f64713a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                LogUtil.e(CommonConstants.TAG, "e : " + th);
                str = null;
            }
            obtain.recycle();
            obtain2.recycle();
            return str;
        }
    }

    boolean getBoos();

    String getIDs();
}
