package com.beizi.fusion.p068e.p070b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.beizi.fusion.e.b.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface ZTEIDInterface extends IInterface {

    /* compiled from: ZTEIDInterface.java */
    /* renamed from: com.beizi.fusion.e.b.g$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractBinderC3110a extends Binder implements ZTEIDInterface {

        /* compiled from: ZTEIDInterface.java */
        /* renamed from: com.beizi.fusion.e.b.g$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class C3111a implements ZTEIDInterface {

            /* renamed from: a */
            private IBinder f11219a;

            public C3111a(IBinder iBinder) {
                this.f11219a = iBinder;
            }

            @Override // com.beizi.fusion.p068e.p070b.ZTEIDInterface
            /* renamed from: a */
            public String mo48532a() {
                String str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f11219a.transact(3, obtain, obtain2, 0);
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11219a;
            }
        }
    }

    /* renamed from: a */
    String mo48532a();
}
