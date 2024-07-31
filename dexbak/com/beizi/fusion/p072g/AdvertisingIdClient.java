package com.beizi.fusion.p072g;

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

/* renamed from: com.beizi.fusion.g.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AdvertisingIdClient {

    /* compiled from: AdvertisingIdClient.java */
    /* renamed from: com.beizi.fusion.g.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3140a {

        /* renamed from: a */
        private final String f11351a;

        /* renamed from: b */
        private final boolean f11352b;

        C3140a(String str, boolean z) {
            this.f11351a = str;
            this.f11352b = z;
        }

        /* renamed from: a */
        public String m48277a() {
            return this.f11351a;
        }

        /* renamed from: b */
        public boolean m48276b() {
            return this.f11352b;
        }
    }

    /* compiled from: AdvertisingIdClient.java */
    /* renamed from: com.beizi.fusion.g.b$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class ServiceConnectionC3141b implements ServiceConnection {

        /* renamed from: a */
        boolean f11353a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f11354b;

        private ServiceConnectionC3141b() {
            this.f11353a = false;
            this.f11354b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public IBinder m48275a() throws InterruptedException {
            if (!this.f11353a) {
                this.f11353a = true;
                return this.f11354b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f11354b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: a */
    public static C3140a m48278a(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                ServiceConnectionC3141b serviceConnectionC3141b = new ServiceConnectionC3141b();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, serviceConnectionC3141b, 1)) {
                    try {
                        try {
                            C3142c c3142c = new C3142c(serviceConnectionC3141b.m48275a());
                            return new C3140a(c3142c.m48274a(), c3142c.m48273a(true));
                        } catch (Exception e) {
                            throw e;
                        }
                    } finally {
                        context.unbindService(serviceConnectionC3141b);
                    }
                }
                throw new IOException("Google Play connection failed");
            } catch (Exception e2) {
                throw e2;
            }
        }
        throw new IllegalStateException("Cannot be called from the main thread");
    }

    /* compiled from: AdvertisingIdClient.java */
    /* renamed from: com.beizi.fusion.g.b$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3142c implements IInterface {

        /* renamed from: a */
        private IBinder f11355a;

        public C3142c(IBinder iBinder) {
            this.f11355a = iBinder;
        }

        /* renamed from: a */
        public String m48274a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f11355a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f11355a;
        }

        /* renamed from: a */
        public boolean m48273a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.f11355a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
