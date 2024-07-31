package com.beizi.fusion.p068e.p070b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.beizi.fusion.e.b.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface HWIDInterface extends IInterface {

    /* compiled from: HWIDInterface.java */
    /* renamed from: com.beizi.fusion.e.b.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3102a implements HWIDInterface {

        /* renamed from: a */
        private IBinder f11214a;

        public C3102a(IBinder iBinder) {
            this.f11214a = iBinder;
        }

        /* renamed from: a */
        public String m48544a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f11214a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                th.printStackTrace();
                str = null;
            }
            obtain.recycle();
            obtain2.recycle();
            return str;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f11214a;
        }

        /* renamed from: b */
        public boolean m48543b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f11214a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = true;
                }
            } catch (Throwable unused) {
                obtain.recycle();
                obtain2.recycle();
            }
            obtain.recycle();
            obtain2.recycle();
            return z;
        }
    }
}
