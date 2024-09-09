package com.beizi.fusion.e.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ZTEIDInterface.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface g extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ZTEIDInterface.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class a extends Binder implements g {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: ZTEIDInterface.java */
        /* renamed from: com.beizi.fusion.e.b.g$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class C0141a implements g {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f14737a;

            public C0141a(IBinder iBinder) {
                this.f14737a = iBinder;
            }

            @Override // com.beizi.fusion.e.b.g
            public String a() {
                String str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f14737a.transact(3, obtain, obtain2, 0);
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
                return this.f14737a;
            }
        }
    }

    String a();
}
