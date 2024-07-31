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
import com.umeng.commonsdk.utils.PkgInfoUtil;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AdvertisingId.java */
/* renamed from: com.umeng.commonsdk.statistics.common.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13247a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C13249a {

        /* renamed from: a */
        private final String f38948a;

        /* renamed from: b */
        private final boolean f38949b;

        C13249a(String str, boolean z) {
            this.f38948a = str;
            this.f38949b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public String m13761b() {
            return this.f38948a;
        }

        /* renamed from: a */
        public boolean m13763a() {
            return this.f38949b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class ServiceConnectionC13250b implements ServiceConnection {

        /* renamed from: a */
        boolean f38950a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f38951b;

        private ServiceConnectionC13250b() {
            this.f38950a = false;
            this.f38951b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public IBinder m13760a() throws InterruptedException {
            if (!this.f38950a) {
                this.f38950a = true;
                return this.f38951b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f38951b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: a */
    public static String m13766a(Context context) {
        try {
            C13249a m13764c = m13764c(context);
            if (m13764c != null && !m13764c.m13763a()) {
                return m13764c.m13761b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: b */
    public static String m13765b(Context context) {
        try {
            C13249a m13764c = m13764c(context);
            if (m13764c == null) {
                return null;
            }
            return m13764c.m13761b();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static C13249a m13764c(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            if (PkgInfoUtil.m13466a().m13465a(context, "com.android.vending", 0) == null) {
                return null;
            }
            ServiceConnectionC13250b serviceConnectionC13250b = new ServiceConnectionC13250b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, serviceConnectionC13250b, 1)) {
                    try {
                        C13251c c13251c = new C13251c(serviceConnectionC13250b.m13760a());
                        boolean m13758a = c13251c.m13758a(true);
                        return new C13249a(m13758a ? "" : c13251c.m13759a(), m13758a);
                    } catch (Exception e) {
                        throw e;
                    }
                }
                throw new IOException("Google Play connection failed");
            } finally {
                context.unbindService(serviceConnectionC13250b);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C13251c implements IInterface {

        /* renamed from: a */
        private IBinder f38952a;

        public C13251c(IBinder iBinder) {
            this.f38952a = iBinder;
        }

        /* renamed from: a */
        public String m13759a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f38952a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f38952a;
        }

        /* renamed from: a */
        public boolean m13758a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.f38952a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
