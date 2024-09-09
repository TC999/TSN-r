package com.amap.api.col.s;

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
/* compiled from: AdvertisingId.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class q1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdvertisingId.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f10127a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f10128b;

        a(String str, boolean z3) {
            this.f10127a = str;
            this.f10128b = z3;
        }

        public final boolean b() {
            return this.f10128b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdvertisingId.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f10131a;

        public c(IBinder iBinder) {
            this.f10131a = iBinder;
        }

        public final String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f10131a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f10131a;
        }

        public final boolean b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f10131a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static String a(Context context) {
        try {
            a b4 = b(context);
            if (b4 != null && !b4.b()) {
                return b4.f10127a;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static a b(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b((byte) 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, bVar, 1)) {
                try {
                    try {
                        c cVar = new c(bVar.a());
                        boolean b4 = cVar.b();
                        return new a(b4 ? "" : cVar.a(), b4);
                    } finally {
                        context.unbindService(bVar);
                    }
                } catch (Exception e4) {
                    throw e4;
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Exception e5) {
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdvertisingId.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f10129a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f10130b;

        private b() {
            this.f10129a = false;
            this.f10130b = new LinkedBlockingQueue<>(1);
        }

        public final IBinder a() throws InterruptedException {
            if (!this.f10129a) {
                this.f10129a = true;
                return this.f10130b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f10130b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }
}
