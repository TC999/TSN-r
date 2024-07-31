package com.kwad.sdk.core.p399f.p401b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.kwad.sdk.core.f.b.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC10373f extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10374a implements InterfaceC10373f {
        private IBinder axi;

        public C10374a(IBinder iBinder) {
            this.axi = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.axi;
        }

        @Override // com.kwad.sdk.core.p399f.p401b.InterfaceC10373f
        public final String getOAID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
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

    String getOAID();
}
