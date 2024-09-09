package com.mbridge.msdk.foundation.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface VideoBinderListener extends IInterface {
    void onVideo(String str, long j4, String str2, String str3, String str4, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static abstract class a extends Binder implements VideoBinderListener {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.mbridge.msdk.foundation.aidl.VideoBinderListener$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public static class C0734a implements VideoBinderListener {

            /* renamed from: a  reason: collision with root package name */
            public static VideoBinderListener f39031a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f39032b;

            C0734a(IBinder iBinder) {
                this.f39032b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f39032b;
            }

            @Override // com.mbridge.msdk.foundation.aidl.VideoBinderListener
            public final void onVideo(String str, long j4, String str2, String str3, String str4, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.mbridge.msdk.foundation.aidl.VideoBinderListener");
                    obtain.writeString(str);
                    obtain.writeLong(j4);
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
                    if (!this.f39032b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        a.a().onVideo(str, j4, str2, str3, str4, parcelFileDescriptor);
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

        public a() {
            attachInterface(this, "com.mbridge.msdk.foundation.aidl.VideoBinderListener");
        }

        public static VideoBinderListener a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.mbridge.msdk.foundation.aidl.VideoBinderListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof VideoBinderListener)) {
                return (VideoBinderListener) queryLocalInterface;
            }
            return new C0734a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.mbridge.msdk.foundation.aidl.VideoBinderListener");
                return true;
            }
            parcel.enforceInterface("com.mbridge.msdk.foundation.aidl.VideoBinderListener");
            onVideo(parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        public static VideoBinderListener a() {
            return C0734a.f39031a;
        }
    }
}
