package com.kwad.sdk.core.p399f.p401b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.kwad.sdk.core.f.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC10367c extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10368a implements InterfaceC10367c {
        private IBinder axi;

        public C10368a(IBinder iBinder) {
            this.axi = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.axi;
        }

        @Override // com.kwad.sdk.core.p399f.p401b.InterfaceC10367c
        public final String getOaid() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.axi.transact(1, obtain, obtain2, 0);
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

    String getOaid();
}
