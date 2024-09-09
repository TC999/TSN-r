package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class rh extends com.ss.android.socialbase.downloader.downloader.ok implements ServiceConnection {

    /* renamed from: n  reason: collision with root package name */
    private static final String f49781n = rh.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.rh f49782h;
    private com.ss.android.socialbase.downloader.downloader.q kf;

    /* renamed from: p  reason: collision with root package name */
    private int f49783p = -1;

    private void h() {
        SparseArray<List<DownloadTask>> clone;
        try {
            synchronized (this.ok) {
                clone = this.ok.clone();
                this.ok.clear();
            }
            if (clone == null || clone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.bl.fb() == null) {
                return;
            }
            for (int i4 = 0; i4 < clone.size(); i4++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i4));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        try {
                            this.kf.ok(com.ss.android.socialbase.downloader.q.h.ok(downloadTask));
                        } catch (RemoteException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.bl.ok.a(f49781n, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        String str = f49781n;
        StringBuilder sb = new StringBuilder();
        sb.append("tryDownload aidlService == null:");
        sb.append(this.kf == null);
        com.ss.android.socialbase.downloader.bl.ok.a(str, sb.toString());
        if (this.kf == null) {
            ok(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.bl.l(), this);
            return;
        }
        h();
        try {
            this.kf.ok(com.ss.android.socialbase.downloader.q.h.ok(downloadTask));
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void bl(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.s.ok().ok(downloadTask.getDownloadId(), true);
        ok fb = com.ss.android.socialbase.downloader.downloader.bl.fb();
        if (fb != null) {
            fb.ok(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public IBinder ok(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            Log.w(f49781n, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.h.ok.ok("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.bl.ok.a(f49781n, "onBind IndependentDownloadBinder");
        return new z();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.kf = null;
        com.ss.android.socialbase.downloader.downloader.rh rhVar = this.f49782h;
        if (rhVar != null) {
            rhVar.p();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = f49781n;
        com.ss.android.socialbase.downloader.bl.ok.a(str, "onServiceConnected ");
        this.kf = q.ok.ok(iBinder);
        com.ss.android.socialbase.downloader.downloader.rh rhVar = this.f49782h;
        if (rhVar != null) {
            rhVar.ok(iBinder);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onServiceConnected aidlService!=null");
        sb.append(this.kf != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.ok.size());
        com.ss.android.socialbase.downloader.bl.ok.a(str, sb.toString());
        if (this.kf != null) {
            com.ss.android.socialbase.downloader.downloader.s.ok().a();
            this.f49486a = true;
            this.f49489s = false;
            int i4 = this.f49783p;
            if (i4 != -1) {
                try {
                    this.kf.j(i4);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
            if (this.kf != null) {
                h();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.bl.ok.a(f49781n, "onServiceDisconnected ");
        this.kf = null;
        this.f49486a = false;
        com.ss.android.socialbase.downloader.downloader.rh rhVar = this.f49782h;
        if (rhVar != null) {
            rhVar.p();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.bl.ok.a(f49781n, "bindService");
            Intent intent = new Intent(context, IndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.q.kf.ok()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.bl.ok.a(f49781n, "stopService");
        this.f49486a = false;
        Intent intent = new Intent(context, IndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void ok(com.ss.android.socialbase.downloader.downloader.rh rhVar) {
        this.f49782h = rhVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void ok(int i4) {
        com.ss.android.socialbase.downloader.downloader.q qVar = this.kf;
        if (qVar == null) {
            this.f49783p = i4;
            return;
        }
        try {
            qVar.j(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void startService() {
        if (this.kf == null) {
            startService(com.ss.android.socialbase.downloader.downloader.bl.l(), this);
        }
    }
}
