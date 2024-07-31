package com.amap.api.col.p047s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AdvertisingId.java */
/* renamed from: com.amap.api.col.s.q1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2120q1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.s.q1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C2121a {

        /* renamed from: a */
        private final String f6399a;

        /* renamed from: b */
        private final boolean f6400b;

        C2121a(String str, boolean z) {
            this.f6399a = str;
            this.f6400b = z;
        }

        /* renamed from: b */
        public final boolean m52650b() {
            return this.f6400b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.s.q1$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C2123c implements IInterface {

        /* renamed from: a */
        private IBinder f6403a;

        public C2123c(IBinder iBinder) {
            this.f6403a = iBinder;
        }

        /* renamed from: a */
        public final String m52648a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f6403a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f6403a;
        }

        /* renamed from: b */
        public final boolean m52647b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f6403a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: a */
    public static String m52653a(Context context) {
        try {
            C2121a m52652b = m52652b(context);
            if (m52652b != null && !m52652b.m52650b()) {
                return m52652b.f6399a;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: b */
    private static C2121a m52652b(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnectionC2122b serviceConnectionC2122b = new ServiceConnectionC2122b((byte) 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, serviceConnectionC2122b, 1)) {
                try {
                    try {
                        C2123c c2123c = new C2123c(serviceConnectionC2122b.m52649a());
                        boolean m52647b = c2123c.m52647b();
                        return new C2121a(m52647b ? "" : c2123c.m52648a(), m52647b);
                    } finally {
                        context.unbindService(serviceConnectionC2122b);
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.s.q1$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class ServiceConnectionC2122b implements ServiceConnection {

        /* renamed from: a */
        boolean f6401a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f6402b;

        private ServiceConnectionC2122b() {
            this.f6401a = false;
            this.f6402b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public final IBinder m52649a() throws InterruptedException {
            if (!this.f6401a) {
                this.f6401a = true;
                return this.f6402b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f6402b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        /* synthetic */ ServiceConnectionC2122b(byte b) {
            this();
        }
    }
}
