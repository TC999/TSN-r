package com.kwad.framework.filedownloader.p350c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* renamed from: com.kwad.framework.filedownloader.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC9453a extends IInterface {

    /* renamed from: com.kwad.framework.filedownloader.c.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractBinderC9454a extends Binder implements InterfaceC9453a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kwad.framework.filedownloader.c.a$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C9455a implements InterfaceC9453a {
            public static InterfaceC9453a ahj;
            private IBinder mRemote;

            C9455a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9453a
            /* renamed from: q */
            public final void mo28432q(MessageSnapshot messageSnapshot) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
                    if (messageSnapshot != null) {
                        obtain.writeInt(1);
                        messageSnapshot.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || AbstractBinderC9454a.m28718vU() == null) {
                        return;
                    }
                    AbstractBinderC9454a.m28718vU().mo28432q(messageSnapshot);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC9454a() {
            attachInterface(this, "com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
        }

        /* renamed from: c */
        public static InterfaceC9453a m28719c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC9453a)) {
                return (InterfaceC9453a) queryLocalInterface;
            }
            return new C9455a(iBinder);
        }

        /* renamed from: vU */
        public static InterfaceC9453a m28718vU() {
            return C9455a.ahj;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
                mo28432q(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.kwad.framework.filedownloader.i.IFileDownloadIPCCallback");
                return true;
            }
        }
    }

    /* renamed from: q */
    void mo28432q(MessageSnapshot messageSnapshot);
}
