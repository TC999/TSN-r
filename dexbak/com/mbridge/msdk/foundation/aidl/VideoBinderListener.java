package com.mbridge.msdk.foundation.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface VideoBinderListener extends IInterface {
    void onVideo(String str, long j, String str2, String str3, String str4, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    /* renamed from: com.mbridge.msdk.foundation.aidl.VideoBinderListener$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractBinderC11249a extends Binder implements VideoBinderListener {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.mbridge.msdk.foundation.aidl.VideoBinderListener$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C11250a implements VideoBinderListener {

            /* renamed from: a */
            public static VideoBinderListener f30204a;

            /* renamed from: b */
            private IBinder f30205b;

            C11250a(IBinder iBinder) {
                this.f30205b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f30205b;
            }

            @Override // com.mbridge.msdk.foundation.aidl.VideoBinderListener
            public final void onVideo(String str, long j, String str2, String str3, String str4, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mbridge.msdk.foundation.aidl.VideoBinderListener");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.f30205b.transact(1, obtain, obtain2, 0) && AbstractBinderC11249a.m22941a() != null) {
                        AbstractBinderC11249a.m22941a().onVideo(str, j, str2, str3, str4, parcelFileDescriptor);
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public AbstractBinderC11249a() {
            attachInterface(this, "com.mbridge.msdk.foundation.aidl.VideoBinderListener");
        }

        /* renamed from: a */
        public static VideoBinderListener m22940a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.mbridge.msdk.foundation.aidl.VideoBinderListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof VideoBinderListener)) {
                return (VideoBinderListener) queryLocalInterface;
            }
            return new C11250a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.mbridge.msdk.foundation.aidl.VideoBinderListener");
                return true;
            }
            parcel.enforceInterface("com.mbridge.msdk.foundation.aidl.VideoBinderListener");
            onVideo(parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: a */
        public static VideoBinderListener m22941a() {
            return C11250a.f30204a;
        }
    }
}
