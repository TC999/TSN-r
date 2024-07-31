package com.kwad.sdk.core.p399f.p401b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.kwad.sdk.core.f.b.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC10371e extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10372a implements InterfaceC10371e {
        private IBinder axj;

        public C10372a(IBinder iBinder) {
            this.axj = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.axj;
        }

        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.axj.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Exception unused) {
                obtain2.recycle();
                obtain.recycle();
                return null;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
    }
}
