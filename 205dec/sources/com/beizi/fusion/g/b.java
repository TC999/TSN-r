package com.beizi.fusion.g;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdvertisingIdClient.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdvertisingIdClient.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f14906a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f14907b;

        a(String str, boolean z3) {
            this.f14906a = str;
            this.f14907b = z3;
        }

        public String a() {
            return this.f14906a;
        }

        public boolean b() {
            return this.f14907b;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdvertisingIdClient.java */
    /* renamed from: com.beizi.fusion.g.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static final class ServiceConnectionC0142b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f14908a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f14909b;

        private ServiceConnectionC0142b() {
            this.f14908a = false;
            this.f14909b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (!this.f14908a) {
                this.f14908a = true;
                return this.f14909b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f14909b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static a a(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                ServiceConnectionC0142b serviceConnectionC0142b = new ServiceConnectionC0142b();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, serviceConnectionC0142b, 1)) {
                    try {
                        try {
                            c cVar = new c(serviceConnectionC0142b.a());
                            return new a(cVar.a(), cVar.a(true));
                        } catch (Exception e4) {
                            throw e4;
                        }
                    } finally {
                        context.unbindService(serviceConnectionC0142b);
                    }
                }
                throw new IOException("Google Play connection failed");
            } catch (Exception e5) {
                throw e5;
            }
        }
        throw new IllegalStateException("Cannot be called from the main thread");
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdvertisingIdClient.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f14910a;

        public c(IBinder iBinder) {
            this.f14910a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f14910a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f14910a;
        }

        public boolean a(boolean z3) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z3 ? 1 : 0);
                this.f14910a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
