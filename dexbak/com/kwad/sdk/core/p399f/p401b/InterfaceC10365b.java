package com.kwad.sdk.core.p399f.p401b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.kwad.sdk.core.f.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC10365b extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10366a implements InterfaceC10365b {
        private IBinder axi;

        public C10366a(IBinder iBinder) {
            this.axi = iBinder;
        }

        /* renamed from: Ey */
        public final String m26224Ey() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
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

        /* renamed from: Ez */
        public final boolean m26223Ez() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.axi.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = true;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
            obtain.recycle();
            obtain2.recycle();
            return z;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.axi;
        }
    }
}
