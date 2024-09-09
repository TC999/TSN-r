package com.kwad.framework.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    private volatile INTERFACE ahM;
    private final Class<?> ahg;
    private final HashMap<String, Object> ahN = new HashMap<>();
    private final List<Context> ahO = new ArrayList();
    private final ArrayList<Runnable> aeT = new ArrayList<>();
    private final CALLBACK ahL = uR();

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Class<?> cls) {
        this.ahg = cls;
    }

    private void a(Context context, Runnable runnable) {
        if (!com.kwad.framework.filedownloader.f.f.an(context)) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.ahg);
            if (!this.ahO.contains(context)) {
                this.ahO.add(context);
            }
            context.bindService(intent, this, 1);
            context.startService(intent);
            return;
        }
        throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
    }

    private void bg(boolean z3) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "release connect resources %s", this.ahM);
        }
        this.ahM = null;
        com.kwad.framework.filedownloader.f.uz().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.ahg));
    }

    protected abstract void a(INTERFACE r12, CALLBACK callback);

    @Override // com.kwad.framework.filedownloader.u
    public final void ak(Context context) {
        a(context, (Runnable) null);
    }

    protected abstract INTERFACE b(IBinder iBinder);

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return wq() != null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.ahM = b(iBinder);
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.ahM);
        }
        try {
            a((a<CALLBACK, INTERFACE>) this.ahM, (INTERFACE) this.ahL);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
        this.aeT.clear();
        for (Runnable runnable : (List) this.aeT.clone()) {
            runnable.run();
        }
        com.kwad.framework.filedownloader.f.uz().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.ahg));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.ahM);
        }
        bg(true);
    }

    protected abstract CALLBACK uR();

    /* JADX INFO: Access modifiers changed from: protected */
    public final INTERFACE wq() {
        return this.ahM;
    }
}
