package com.qq.e.comm.plugin.apkmanager;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.qq.e.comm.plugin.apkmanager.q;
import com.qq.e.comm.plugin.util.d1;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k {

    /* renamed from: h  reason: collision with root package name */
    private static final k f41793h = new k();

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.apkmanager.w.c f41795b;

    /* renamed from: d  reason: collision with root package name */
    private q f41797d;

    /* renamed from: e  reason: collision with root package name */
    private BroadcastReceiver f41798e;

    /* renamed from: f  reason: collision with root package name */
    private ServiceConnection f41799f;

    /* renamed from: g  reason: collision with root package name */
    private final j f41800g;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41796c = false;

    /* renamed from: a  reason: collision with root package name */
    private final Context f41794a = com.qq.e.comm.plugin.d0.a.d().a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            k.this.f41797d = q.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            k.this.f41797d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final com.qq.e.comm.plugin.apkmanager.w.c f41802a;

        c(com.qq.e.comm.plugin.apkmanager.w.c cVar) {
            this.f41802a = cVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                this.f41802a.a(intent.getStringExtra("package"), intent.getIntExtra("status", 0), intent.getIntExtra("progress", 0), intent.getLongExtra("totalSize", 0L));
            } catch (Throwable th) {
                d1.a("StatusBroadCastReceiver.onReceive\u53d1\u751f\u5f02\u5e38", th);
            }
        }
    }

    private k() {
        if (MultiProcessFlag.isMultiProcess()) {
            f();
            com.qq.e.comm.plugin.apkmanager.x.d.a(1, com.qq.e.comm.plugin.d0.a.d().b().e());
        }
        this.f41800g = new j(this.f41794a);
    }

    public static k e() {
        return f41793h;
    }

    private void f() {
        this.f41796c = true;
        try {
            Intent a4 = i.a(this.f41794a);
            b bVar = new b();
            this.f41799f = bVar;
            this.f41794a.bindService(a4, bVar, 1);
        } catch (Throwable unused) {
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.f41794a.getPackageName() + ".gdtdownload");
        this.f41795b = new com.qq.e.comm.plugin.apkmanager.w.c();
        c cVar = new c(this.f41795b);
        this.f41798e = cVar;
        this.f41794a.registerReceiver(cVar, intentFilter);
    }

    public int b(String str) {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.d(str);
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke getStatus in another process", e4);
                    return 0;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return 0;
        }
        return com.qq.e.comm.plugin.apkmanager.w.b.a().d(this.f41794a, str);
    }

    public void c(ApkDownloadTask apkDownloadTask) {
        try {
            com.qq.e.comm.plugin.n0.w.b.a(apkDownloadTask.r()).f41952h = 2;
            if (this.f41794a.startService(i.a(this.f41794a, apkDownloadTask)) == null) {
                com.qq.e.comm.plugin.apkmanager.x.d.a(1100914, (Integer) 1, apkDownloadTask);
            }
            com.qq.e.comm.plugin.apkmanager.x.d.a(1100901, apkDownloadTask);
        } catch (Throwable unused) {
            com.qq.e.comm.plugin.apkmanager.x.d.a(1100914, (Integer) 2, apkDownloadTask);
        }
    }

    public List<ApkDownloadTask> d() {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.d();
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke getDownloadingOrPausedTasks in another process", e4);
                    return null;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return null;
        }
        return this.f41800g.c();
    }

    protected void finalize() throws Throwable {
        a();
        super.finalize();
    }

    public void g() {
        if (com.qq.e.comm.plugin.apkmanager.x.c.h()) {
            try {
                this.f41794a.startService(i.b(this.f41794a));
            } catch (Throwable unused) {
            }
        }
    }

    public void h() {
        try {
            this.f41794a.startService(i.c(this.f41794a));
        } catch (Throwable unused) {
        }
    }

    private void a() {
        if (this.f41796c) {
            this.f41796c = false;
            try {
                this.f41794a.unbindService(this.f41799f);
                this.f41794a.unregisterReceiver(this.f41798e);
            } catch (Throwable unused) {
            }
        }
    }

    public int a(String str) {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.a(str);
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke getStatus in another process", e4);
                    return 0;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return 0;
        }
        return com.qq.e.comm.plugin.apkmanager.w.b.a().c(this.f41794a, str);
    }

    public List<ApkDownloadTask> c() {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.c();
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke getDownloadedTask in another process", e4);
                    return null;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return null;
        }
        return this.f41800g.b();
    }

    public void b(com.qq.e.comm.plugin.apkmanager.w.a aVar) {
        if (this.f41796c) {
            this.f41795b.b(aVar);
        } else {
            com.qq.e.comm.plugin.apkmanager.w.b.a().b(aVar);
        }
    }

    public int d(ApkDownloadTask apkDownloadTask) {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.a(apkDownloadTask);
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke updateTask in another process", e4);
                    return 0;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return 0;
        }
        return this.f41800g.c(apkDownloadTask);
    }

    public void b(String str, com.qq.e.comm.plugin.apkmanager.w.a aVar) {
        if (this.f41796c) {
            this.f41795b.b(str, aVar);
        } else {
            com.qq.e.comm.plugin.apkmanager.w.b.a().b(str, aVar);
        }
    }

    public void a(String str, com.qq.e.comm.plugin.apkmanager.w.a aVar) {
        if (this.f41796c) {
            this.f41795b.a(str, aVar);
        } else {
            com.qq.e.comm.plugin.apkmanager.w.b.a().a(str, aVar);
        }
    }

    public List<ApkDownloadTask> b() {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.b();
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke getDownloadedOrInstalledTasks in another process", e4);
                    return null;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return null;
        }
        return this.f41800g.a();
    }

    public ApkDownloadTask c(String str) {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.c(str);
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke getTask in another process", e4);
                    return null;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return null;
        }
        return this.f41800g.a(str);
    }

    public void a(com.qq.e.comm.plugin.apkmanager.w.a aVar) {
        if (this.f41796c) {
            this.f41795b.a(aVar);
        } else {
            com.qq.e.comm.plugin.apkmanager.w.b.a().a(aVar);
        }
    }

    public ApkDownloadTask a(int i4) {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.g(i4);
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke getTask in another process", e4);
                    return null;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return null;
        }
        return this.f41800g.a(i4);
    }

    public boolean b(ApkDownloadTask apkDownloadTask) {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.b(apkDownloadTask);
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke resumeTask in another process", e4);
                    return false;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return false;
        }
        return this.f41800g.b(apkDownloadTask);
    }

    public int a(String str, int i4) {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.b(str, i4);
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke updateTaskStatus in another process", e4);
                    return 0;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return 0;
        }
        return this.f41800g.b(str, i4);
    }

    public boolean a(ApkDownloadTask apkDownloadTask) {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.c(apkDownloadTask);
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke pauseTask in another process", e4);
                    return false;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return false;
        }
        return this.f41800g.a(apkDownloadTask, 1);
    }

    public boolean a(ApkDownloadTask apkDownloadTask, boolean z3) {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.a(apkDownloadTask, z3);
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke rmTask in another process", e4);
                    return false;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return false;
        }
        return this.f41800g.a(apkDownloadTask, z3);
    }

    public boolean a(int i4, int i5, long j4) {
        if (this.f41796c) {
            q qVar = this.f41797d;
            if (qVar != null) {
                try {
                    return qVar.a(i4, i5, j4);
                } catch (RemoteException e4) {
                    d1.a("Exception while invoke updateProgress in another process", e4);
                    return false;
                }
            }
            d1.a("MultiProcess Required,But RemoteService is NULL", new Object[0]);
            return false;
        }
        return this.f41800g.a(i4, i5, j4);
    }
}
