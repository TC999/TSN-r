package com.kwad.sdk.core.p399f.p401b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* renamed from: com.kwad.sdk.core.f.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC10363a extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10364a implements InterfaceC10363a {
        private final IBinder axi;

        public C10364a(IBinder iBinder) {
            this.axi = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.axi;
        }

        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                this.axi.transact(3, obtain, obtain2, 0);
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
}
