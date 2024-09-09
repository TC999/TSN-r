package com.kwad.framework.filedownloader.c;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.framework.filedownloader.c.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface b extends IInterface {
    void a(com.kwad.framework.filedownloader.c.a aVar);

    void b(com.kwad.framework.filedownloader.c.a aVar);

    void b(String str, String str2, boolean z3, int i4, int i5, int i6, boolean z4, com.kwad.framework.filedownloader.d.b bVar, boolean z5);

    boolean bd(int i4);

    byte be(int i4);

    boolean bf(int i4);

    boolean bx(int i4);

    long by(int i4);

    long bz(int i4);

    boolean isIdle();

    void pauseAllTasks();

    void startForeground(int i4, Notification notification);

    void stopForeground(boolean z3);

    boolean u(String str, String str2);

    void vV();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0671a(iBinder);
        }

        public static b vW() {
            return C0671a.ahk;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 != 1598968902) {
                switch (i4) {
                    case 1:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        a(a.AbstractBinderC0669a.c(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        b(a.AbstractBinderC0669a.c(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        boolean u3 = u(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(u3 ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        b(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? com.kwad.framework.filedownloader.d.b.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        boolean bd = bd(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(bd ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        pauseAllTasks();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        boolean bx = bx(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(bx ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        long by = by(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(by);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        long bz = bz(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(bz);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        byte be = be(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeByte(be);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        boolean isIdle = isIdle();
                        parcel2.writeNoException();
                        parcel2.writeInt(isIdle ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        startForeground(parcel.readInt(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        stopForeground(parcel.readInt() != 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        boolean bf = bf(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(bf ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        vV();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
        /* renamed from: com.kwad.framework.filedownloader.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public static class C0671a implements b {
            public static b ahk;
            private IBinder mRemote;

            C0671a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void a(com.kwad.framework.filedownloader.c.a aVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, null, 1) || a.vW() == null) {
                        return;
                    }
                    a.vW().a(aVar);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void b(com.kwad.framework.filedownloader.c.a aVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, null, 1) || a.vW() == null) {
                        return;
                    }
                    a.vW().b(aVar);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final boolean bd(int i4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && a.vW() != null) {
                        return a.vW().bd(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final byte be(int i4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && a.vW() != null) {
                        return a.vW().be(i4);
                    }
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final boolean bf(int i4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && a.vW() != null) {
                        return a.vW().bf(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final boolean bx(int i4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && a.vW() != null) {
                        return a.vW().bx(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final long by(int i4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && a.vW() != null) {
                        return a.vW().by(i4);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final long bz(int i4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && a.vW() != null) {
                        return a.vW().bz(i4);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final boolean isIdle() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && a.vW() != null) {
                        return a.vW().isIdle();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void pauseAllTasks() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && a.vW() != null) {
                        a.vW().pauseAllTasks();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void startForeground(int i4, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i4);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, obtain, null, 1) || a.vW() == null) {
                        return;
                    }
                    a.vW().startForeground(i4, notification);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void stopForeground(boolean z3) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(z3 ? 1 : 0);
                    if (this.mRemote.transact(13, obtain, null, 1) || a.vW() == null) {
                        return;
                    }
                    a.vW().stopForeground(z3);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final boolean u(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && a.vW() != null) {
                        return a.vW().u(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void vV() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && a.vW() != null) {
                        a.vW().vV();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.c.b
            public final void b(String str, String str2, boolean z3, int i4, int i5, int i6, boolean z4, com.kwad.framework.filedownloader.d.b bVar, boolean z5) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i7 = 1;
                    obtain.writeInt(z3 ? 1 : 0);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(z4 ? 1 : 0);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z5) {
                        i7 = 0;
                    }
                    obtain.writeInt(i7);
                    try {
                        if (!this.mRemote.transact(4, obtain, obtain2, 0) && a.vW() != null) {
                            a.vW().b(str, str2, z3, i4, i5, i6, z4, bVar, z5);
                        } else {
                            obtain2.readException();
                        }
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }
}
