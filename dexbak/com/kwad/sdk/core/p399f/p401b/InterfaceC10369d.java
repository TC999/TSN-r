package com.kwad.sdk.core.p399f.p401b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.kwad.sdk.core.f.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC10369d extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10370a implements InterfaceC10369d {
        private IBinder axi;

        public C10370a(IBinder iBinder) {
            this.axi = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.axi;
        }

        @Override // com.kwad.sdk.core.p399f.p401b.InterfaceC10369d
        public final String getSerID(String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                this.axi.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return readString;
            } catch (Exception unused) {
                obtain.recycle();
                obtain2.recycle();
                return null;
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }
    }

    String getSerID(String str, String str2, String str3);
}
