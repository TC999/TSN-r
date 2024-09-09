package com.beizi.fusion.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ASUSIDInterface.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface a extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ASUSIDInterface.java */
    /* renamed from: com.beizi.fusion.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0137a implements a {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f14731a;

        public C0137a(IBinder iBinder) {
            this.f14731a = iBinder;
        }

        public String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                this.f14731a.transact(3, obtain, obtain2, 0);
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
            return this.f14731a;
        }
    }
}
