package com.beizi.fusion.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HWIDInterface.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface b extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HWIDInterface.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f14732a;

        public a(IBinder iBinder) {
            this.f14732a = iBinder;
        }

        public String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f14732a.transact(1, obtain, obtain2, 0);
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
            return this.f14732a;
        }

        public boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z3 = false;
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f14732a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z3 = true;
                }
            } catch (Throwable unused) {
                obtain.recycle();
                obtain2.recycle();
            }
            obtain.recycle();
            obtain2.recycle();
            return z3;
        }
    }
}
