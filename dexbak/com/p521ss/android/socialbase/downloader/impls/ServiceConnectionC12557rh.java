package com.p521ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12515s;
import com.p521ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12514rh;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12668h;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.impls.rh */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ServiceConnectionC12557rh extends AbstractC12507ok implements ServiceConnection {

    /* renamed from: n */
    private static final String f35255n = ServiceConnectionC12557rh.class.getSimpleName();

    /* renamed from: h */
    private InterfaceC12514rh f35256h;

    /* renamed from: kf */
    private InterfaceC12510q f35257kf;

    /* renamed from: p */
    private int f35258p = -1;

    /* renamed from: h */
    private void m17525h() {
        SparseArray<List<DownloadTask>> clone;
        try {
            synchronized (this.f35169ok) {
                clone = this.f35169ok.clone();
                this.f35169ok.clear();
            }
            if (clone == null || clone.size() <= 0 || C12490bl.m17820fb() == null) {
                return;
            }
            for (int i = 0; i < clone.size(); i++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        try {
                            this.f35257kf.mo17336ok(C12668h.m16700ok(downloadTask));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C12409ok.m17903a(f35255n, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok, com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: a */
    public void mo17527a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        String str = f35255n;
        StringBuilder sb = new StringBuilder();
        sb.append("tryDownload aidlService == null:");
        sb.append(this.f35257kf == null);
        C12409ok.m17904a(str, sb.toString());
        if (this.f35257kf == null) {
            m17686ok(downloadTask);
            startService(C12490bl.m17807l(), this);
            return;
        }
        m17525h();
        try {
            this.f35257kf.mo17336ok(C12668h.m16700ok(downloadTask));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok, com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: bl */
    public void mo17526bl(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        C12515s.m17660ok().m17654ok(downloadTask.getDownloadId(), true);
        AbstractC12547ok m17820fb = C12490bl.m17820fb();
        if (m17820fb != null) {
            m17820fb.m17545ok(downloadTask);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok, com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public IBinder mo17523ok(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            Log.w(f35255n, "downloader process sync database on main process!");
            C12534ok.m17590ok("fix_sigbus_downloader_db", true);
        }
        C12409ok.m17904a(f35255n, "onBind IndependentDownloadBinder");
        return new BinderC12573z();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.f35257kf = null;
        InterfaceC12514rh interfaceC12514rh = this.f35256h;
        if (interfaceC12514rh != null) {
            interfaceC12514rh.mo17425p();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = f35255n;
        C12409ok.m17904a(str, "onServiceConnected ");
        this.f35257kf = InterfaceC12510q.AbstractBinderC12511ok.m17684ok(iBinder);
        InterfaceC12514rh interfaceC12514rh = this.f35256h;
        if (interfaceC12514rh != null) {
            interfaceC12514rh.mo17434ok(iBinder);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onServiceConnected aidlService!=null");
        sb.append(this.f35257kf != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.f35169ok.size());
        C12409ok.m17904a(str, sb.toString());
        if (this.f35257kf != null) {
            C12515s.m17660ok().m17683a();
            this.f35165a = true;
            this.f35171s = false;
            int i = this.f35258p;
            if (i != -1) {
                try {
                    this.f35257kf.mo17359j(i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            if (this.f35257kf != null) {
                m17525h();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        C12409ok.m17904a(f35255n, "onServiceDisconnected ");
        this.f35257kf = null;
        this.f35165a = false;
        InterfaceC12514rh interfaceC12514rh = this.f35256h;
        if (interfaceC12514rh != null) {
            interfaceC12514rh.mo17425p();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            C12409ok.m17904a(f35255n, "bindService");
            Intent intent = new Intent(context, IndependentProcessDownloadService.class);
            if (C12713kf.m16575ok()) {
                intent.putExtra("fix_downloader_db_sigbus", C12534ok.m17605bl().m17595ok("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok
    public void stopService(Context context, ServiceConnection serviceConnection) {
        C12409ok.m17904a(f35255n, "stopService");
        this.f35165a = false;
        Intent intent = new Intent(context, IndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok, com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public void mo17522ok(InterfaceC12514rh interfaceC12514rh) {
        this.f35256h = interfaceC12514rh;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok, com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public void mo17524ok(int i) {
        InterfaceC12510q interfaceC12510q = this.f35257kf;
        if (interfaceC12510q == null) {
            this.f35258p = i;
            return;
        }
        try {
            interfaceC12510q.mo17359j(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok, com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    public void startService() {
        if (this.f35257kf == null) {
            startService(C12490bl.m17807l(), this);
        }
    }
}
