package org.repackage.p630a.p631a.p632a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: org.repackage.a.a.a.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface IOpenID extends IInterface {

    /* compiled from: IOpenID.java */
    /* renamed from: org.repackage.a.a.a.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractBinderC15407a extends Binder implements IOpenID {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IOpenID.java */
        /* renamed from: org.repackage.a.a.a.a$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static class C15408a implements IOpenID {

            /* renamed from: a */
            public IBinder f44168a;

            public C15408a(IBinder iBinder) {
                this.f44168a = iBinder;
            }

            /* renamed from: a */
            public String m2793a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f44168a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f44168a;
            }
        }

        /* renamed from: a */
        public static IOpenID m2794a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOpenID)) {
                return (IOpenID) queryLocalInterface;
            }
            return new C15408a(iBinder);
        }
    }
}
