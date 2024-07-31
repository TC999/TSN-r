package com.amap.api.col.p0463l;

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

/* renamed from: com.amap.api.col.3l.x4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AdvertisingId {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.3l.x4$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C1983a {

        /* renamed from: a */
        private final String f5676a;

        /* renamed from: b */
        private final boolean f5677b;

        C1983a(String str, boolean z) {
            this.f5676a = str;
            this.f5677b = z;
        }

        /* renamed from: b */
        public final boolean m53529b() {
            return this.f5677b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.3l.x4$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C1985c implements IInterface {

        /* renamed from: a */
        private IBinder f5680a;

        public C1985c(IBinder iBinder) {
            this.f5680a = iBinder;
        }

        /* renamed from: a */
        public final String m53527a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f5680a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f5680a;
        }

        /* renamed from: b */
        public final boolean m53526b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f5680a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: a */
    public static String m53532a(Context context) {
        try {
            C1983a m53531b = m53531b(context);
            if (m53531b != null && !m53531b.m53529b()) {
                return m53531b.f5676a;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: b */
    private static C1983a m53531b(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnectionC1984b serviceConnectionC1984b = new ServiceConnectionC1984b((byte) 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, serviceConnectionC1984b, 1)) {
                try {
                    try {
                        C1985c c1985c = new C1985c(serviceConnectionC1984b.m53528a());
                        boolean m53526b = c1985c.m53526b();
                        return new C1983a(m53526b ? "" : c1985c.m53527a(), m53526b);
                    } finally {
                        context.unbindService(serviceConnectionC1984b);
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
    /* renamed from: com.amap.api.col.3l.x4$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class ServiceConnectionC1984b implements ServiceConnection {

        /* renamed from: a */
        boolean f5678a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f5679b;

        private ServiceConnectionC1984b() {
            this.f5678a = false;
            this.f5679b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public final IBinder m53528a() throws InterruptedException {
            if (!this.f5678a) {
                this.f5678a = true;
                return this.f5679b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f5679b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        /* synthetic */ ServiceConnectionC1984b(byte b) {
            this();
        }
    }
}
