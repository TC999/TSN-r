package com.kwad.framework.filedownloader.p350c;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.framework.filedownloader.p350c.InterfaceC9453a;
import com.kwad.framework.filedownloader.p351d.C9462b;

/* renamed from: com.kwad.framework.filedownloader.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC9456b extends IInterface {
    /* renamed from: a */
    void mo28388a(InterfaceC9453a interfaceC9453a);

    /* renamed from: b */
    void mo28387b(InterfaceC9453a interfaceC9453a);

    /* renamed from: b */
    void mo28386b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C9462b c9462b, boolean z3);

    /* renamed from: bd */
    boolean mo28385bd(int i);

    /* renamed from: be */
    byte mo28384be(int i);

    /* renamed from: bf */
    boolean mo28383bf(int i);

    /* renamed from: bx */
    boolean mo28382bx(int i);

    /* renamed from: by */
    long mo28381by(int i);

    /* renamed from: bz */
    long mo28380bz(int i);

    boolean isIdle();

    void pauseAllTasks();

    void startForeground(int i, Notification notification);

    void stopForeground(boolean z);

    /* renamed from: u */
    boolean mo28379u(String str, String str2);

    /* renamed from: vV */
    void mo28378vV();

    /* renamed from: com.kwad.framework.filedownloader.c.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractBinderC9457a extends Binder implements InterfaceC9456b {
        public AbstractBinderC9457a() {
            attachInterface(this, "com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
        }

        /* renamed from: a */
        public static InterfaceC9456b m28717a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC9456b)) {
                return (InterfaceC9456b) queryLocalInterface;
            }
            return new C9458a(iBinder);
        }

        /* renamed from: vW */
        public static InterfaceC9456b m28716vW() {
            return C9458a.ahk;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        mo28388a(InterfaceC9453a.AbstractBinderC9454a.m28719c(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        mo28387b(InterfaceC9453a.AbstractBinderC9454a.m28719c(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        boolean mo28379u = mo28379u(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo28379u ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        mo28386b(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? C9462b.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        boolean mo28385bd = mo28385bd(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo28385bd ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        pauseAllTasks();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        boolean mo28382bx = mo28382bx(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo28382bx ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        long mo28381by = mo28381by(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(mo28381by);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        long mo28380bz = mo28380bz(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(mo28380bz);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        byte mo28384be = mo28384be(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeByte(mo28384be);
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
                        boolean mo28383bf = mo28383bf(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo28383bf ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                        mo28378vV();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kwad.framework.filedownloader.c.b$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C9458a implements InterfaceC9456b {
            public static InterfaceC9456b ahk;
            private IBinder mRemote;

            C9458a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: a */
            public final void mo28388a(InterfaceC9453a interfaceC9453a) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(interfaceC9453a != null ? interfaceC9453a.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, null, 1) || AbstractBinderC9457a.m28716vW() == null) {
                        return;
                    }
                    AbstractBinderC9457a.m28716vW().mo28388a(interfaceC9453a);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: b */
            public final void mo28387b(InterfaceC9453a interfaceC9453a) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(interfaceC9453a != null ? interfaceC9453a.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, null, 1) || AbstractBinderC9457a.m28716vW() == null) {
                        return;
                    }
                    AbstractBinderC9457a.m28716vW().mo28387b(interfaceC9453a);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: bd */
            public final boolean mo28385bd(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                        return AbstractBinderC9457a.m28716vW().mo28385bd(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: be */
            public final byte mo28384be(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                        return AbstractBinderC9457a.m28716vW().mo28384be(i);
                    }
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: bf */
            public final boolean mo28383bf(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                        return AbstractBinderC9457a.m28716vW().mo28383bf(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: bx */
            public final boolean mo28382bx(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                        return AbstractBinderC9457a.m28716vW().mo28382bx(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: by */
            public final long mo28381by(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                        return AbstractBinderC9457a.m28716vW().mo28381by(i);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: bz */
            public final long mo28380bz(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                        return AbstractBinderC9457a.m28716vW().mo28380bz(i);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            public final boolean isIdle() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                        return AbstractBinderC9457a.m28716vW().isIdle();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            public final void pauseAllTasks() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                        AbstractBinderC9457a.m28716vW().pauseAllTasks();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            public final void startForeground(int i, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, obtain, null, 1) || AbstractBinderC9457a.m28716vW() == null) {
                        return;
                    }
                    AbstractBinderC9457a.m28716vW().startForeground(i, notification);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            public final void stopForeground(boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(13, obtain, null, 1) || AbstractBinderC9457a.m28716vW() == null) {
                        return;
                    }
                    AbstractBinderC9457a.m28716vW().stopForeground(z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: u */
            public final boolean mo28379u(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                        return AbstractBinderC9457a.m28716vW().mo28379u(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: vV */
            public final void mo28378vV() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                        AbstractBinderC9457a.m28716vW().mo28378vV();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.kwad.framework.filedownloader.p350c.InterfaceC9456b
            /* renamed from: b */
            public final void mo28386b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C9462b c9462b, boolean z3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwad.framework.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i4 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (c9462b != null) {
                        obtain.writeInt(1);
                        c9462b.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z3) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    try {
                        if (!this.mRemote.transact(4, obtain, obtain2, 0) && AbstractBinderC9457a.m28716vW() != null) {
                            AbstractBinderC9457a.m28716vW().mo28386b(str, str2, z, i, i2, i3, z2, c9462b, z3);
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
