package com.kwad.framework.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.C9487f;
import com.kwad.framework.filedownloader.InterfaceC9577u;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.kwad.framework.filedownloader.services.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractServiceConnectionC9564a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, InterfaceC9577u {
    private volatile INTERFACE ahM;
    private final Class<?> ahg;
    private final HashMap<String, Object> ahN = new HashMap<>();
    private final List<Context> ahO = new ArrayList();
    private final ArrayList<Runnable> aeT = new ArrayList<>();
    private final CALLBACK ahL = mo28408uR();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractServiceConnectionC9564a(Class<?> cls) {
        this.ahg = cls;
    }

    /* renamed from: a */
    private void m28412a(Context context, Runnable runnable) {
        if (!C9501f.m28520an(context)) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "bindStartByContext %s", context.getClass().getSimpleName());
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

    /* renamed from: bg */
    private void m28409bg(boolean z) {
        if (C9498d.ail) {
            C9498d.m28535c(this, "release connect resources %s", this.ahM);
        }
        this.ahM = null;
        C9487f.m28560uz().m28562c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.ahg));
    }

    /* renamed from: a */
    protected abstract void mo28411a(INTERFACE r1, CALLBACK callback);

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    /* renamed from: ak */
    public final void mo28338ak(Context context) {
        m28412a(context, (Runnable) null);
    }

    /* renamed from: b */
    protected abstract INTERFACE mo28410b(IBinder iBinder);

    @Override // com.kwad.framework.filedownloader.InterfaceC9577u
    public final boolean isConnected() {
        return m28407wq() != null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.ahM = mo28410b(iBinder);
        if (C9498d.ail) {
            C9498d.m28535c(this, "onServiceConnected %s %s", componentName, this.ahM);
        }
        try {
            mo28411a((AbstractServiceConnectionC9564a<CALLBACK, INTERFACE>) this.ahM, (INTERFACE) this.ahL);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.aeT.clear();
        for (Runnable runnable : (List) this.aeT.clone()) {
            runnable.run();
        }
        C9487f.m28560uz().m28562c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.ahg));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (C9498d.ail) {
            C9498d.m28535c(this, "onServiceDisconnected %s %s", componentName, this.ahM);
        }
        m28409bg(true);
    }

    /* renamed from: uR */
    protected abstract CALLBACK mo28408uR();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: wq */
    public final INTERFACE m28407wq() {
        return this.ahM;
    }
}
