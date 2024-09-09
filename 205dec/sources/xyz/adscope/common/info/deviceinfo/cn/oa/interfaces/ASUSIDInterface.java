package xyz.adscope.common.info.deviceinfo.cn.oa.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface ASUSIDInterface extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static final class ASUSID implements ASUSIDInterface {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f64712a;

        public ASUSID(IBinder iBinder) {
            this.f64712a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f64712a;
        }

        @Override // xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.ASUSIDInterface
        public String getID() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                this.f64712a.transact(3, obtain, obtain2, 0);
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

    String getID();
}
