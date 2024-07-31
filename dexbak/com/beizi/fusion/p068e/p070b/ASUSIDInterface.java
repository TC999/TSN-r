package com.beizi.fusion.p068e.p070b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* renamed from: com.beizi.fusion.e.b.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface ASUSIDInterface extends IInterface {

    /* compiled from: ASUSIDInterface.java */
    /* renamed from: com.beizi.fusion.e.b.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3101a implements ASUSIDInterface {

        /* renamed from: a */
        private IBinder f11213a;

        public C3101a(IBinder iBinder) {
            this.f11213a = iBinder;
        }

        /* renamed from: a */
        public String m48545a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                this.f11213a.transact(3, obtain, obtain2, 0);
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
            return this.f11213a;
        }
    }
}
