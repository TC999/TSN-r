package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.umeng.analytics.pro.az */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class HuaweiDeviceIdSupplier implements IDeviceIdSupplier {

    /* renamed from: a */
    private static final String f37722a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* renamed from: b */
    private static final int f37723b = 1;

    /* renamed from: c */
    private static final int f37724c = 2;

    /* compiled from: HuaweiDeviceIdSupplier.java */
    /* renamed from: com.umeng.analytics.pro.az$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class ServiceConnectionC13117a implements ServiceConnection {

        /* renamed from: a */
        boolean f37725a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f37726b;

        private ServiceConnectionC13117a() {
            this.f37725a = false;
            this.f37726b = new LinkedBlockingQueue<>();
        }

        /* renamed from: a */
        public IBinder m14677a() throws InterruptedException {
            if (!this.f37725a) {
                this.f37725a = true;
                return this.f37726b.poll(5L, TimeUnit.SECONDS);
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f37726b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: HuaweiDeviceIdSupplier.java */
    /* renamed from: com.umeng.analytics.pro.az$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class C13118b implements IInterface {

        /* renamed from: a */
        private IBinder f37727a;

        public C13118b(IBinder iBinder) {
            this.f37727a = iBinder;
        }

        /* renamed from: a */
        public String m14676a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(HuaweiDeviceIdSupplier.f37722a);
                this.f37727a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f37727a;
        }

        /* renamed from: b */
        public boolean m14675b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(HuaweiDeviceIdSupplier.f37722a);
                this.f37727a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    @Override // com.umeng.analytics.pro.IDeviceIdSupplier
    /* renamed from: a */
    public String mo14666a(Context context) {
        ServiceConnectionC13117a serviceConnectionC13117a = new ServiceConnectionC13117a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, serviceConnectionC13117a, 1)) {
            try {
                return new C13118b(serviceConnectionC13117a.m14677a()).m14676a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC13117a);
            }
        }
        return null;
    }
}
