package com.amap.api.col.p0003l;

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
/* renamed from: com.amap.api.col.3l.y4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class y4 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.3l.y4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f9518a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f9519b;

        a(String str, boolean z3) {
            this.f9518a = str;
            this.f9519b = z3;
        }

        public final boolean b() {
            return this.f9519b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.3l.y4$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f9522a;

        public c(IBinder iBinder) {
            this.f9522a = iBinder;
        }

        public final String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f9522a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f9522a;
        }

        public final boolean b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f9522a.transact(2, obtain, obtain2, 0);
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
                return b4.f9518a;
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
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.3l.y4$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f9520a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f9521b;

        private b() {
            this.f9520a = false;
            this.f9521b = new LinkedBlockingQueue<>(1);
        }

        public final IBinder a() throws InterruptedException {
            if (!this.f9520a) {
                this.f9520a = true;
                return this.f9521b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9521b.put(iBinder);
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
