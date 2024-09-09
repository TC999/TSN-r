package com.umeng.commonsdk.statistics.common;

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
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: AdvertisingId.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class C1060a {

        /* renamed from: a  reason: collision with root package name */
        private final String f53583a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f53584b;

        C1060a(String str, boolean z3) {
            this.f53583a = str;
            this.f53584b = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f53583a;
        }

        public boolean a() {
            return this.f53584b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: AdvertisingId.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f53585a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f53586b;

        private b() {
            this.f53585a = false;
            this.f53586b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (!this.f53585a) {
                this.f53585a = true;
                return this.f53586b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f53586b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String a(Context context) {
        try {
            C1060a c4 = c(context);
            if (c4 != null && !c4.a()) {
                return c4.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C1060a c4 = c(context);
            if (c4 == null) {
                return null;
            }
            return c4.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C1060a c(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            if (com.umeng.commonsdk.utils.b.a().a(context, "com.android.vending", 0) == null) {
                return null;
            }
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        c cVar = new c(bVar.a());
                        boolean a4 = cVar.a(true);
                        return new C1060a(a4 ? "" : cVar.a(), a4);
                    } catch (Exception e4) {
                        throw e4;
                    }
                }
                throw new IOException("Google Play connection failed");
            } finally {
                context.unbindService(bVar);
            }
        } catch (Exception e5) {
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: AdvertisingId.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f53587a;

        public c(IBinder iBinder) {
            this.f53587a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f53587a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f53587a;
        }

        public boolean a(boolean z3) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z3 ? 1 : 0);
                this.f53587a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
