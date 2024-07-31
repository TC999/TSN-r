package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.InterfaceC9427a;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.p353f.C9492c;
import com.kwad.framework.filedownloader.p353f.C9498d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.framework.filedownloader.z */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9584z extends AbstractC9479e implements InterfaceC9578v {
    private final ArrayList<InterfaceC9427a.InterfaceC9428a> afg = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.InterfaceC9578v
    /* renamed from: d */
    public final boolean mo28316d(InterfaceC9427a.InterfaceC9428a interfaceC9428a) {
        return !this.afg.isEmpty() && this.afg.contains(interfaceC9428a);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9578v
    /* renamed from: e */
    public final void mo28315e(InterfaceC9427a.InterfaceC9428a interfaceC9428a) {
        if (this.afg.isEmpty()) {
            return;
        }
        synchronized (this.afg) {
            this.afg.remove(interfaceC9428a);
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9578v
    /* renamed from: f */
    public final boolean mo28314f(InterfaceC9427a.InterfaceC9428a interfaceC9428a) {
        C9559r.m28419uU();
        if (!C9559r.m28417uW()) {
            synchronized (this.afg) {
                C9559r.m28419uU();
                if (!C9559r.m28417uW()) {
                    if (C9498d.ail) {
                        C9498d.m28535c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC9428a.mo28731ud().getId()));
                    }
                    C9550n.m28440uM().mo28338ak(C9492c.m28544wL());
                    if (!this.afg.contains(interfaceC9428a)) {
                        interfaceC9428a.free();
                        this.afg.add(interfaceC9428a);
                    }
                    return true;
                }
            }
        }
        mo28315e(interfaceC9428a);
        return false;
    }

    @Override // com.kwad.framework.filedownloader.AbstractC9479e
    /* renamed from: uw */
    public final void mo28313uw() {
        InterfaceC9579w m28416uX = C9559r.m28419uU().m28416uX();
        if (C9498d.ail) {
            C9498d.m28535c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.afg) {
            this.afg.clear();
            ArrayList arrayList = new ArrayList(m28416uX.mo28331vb());
            for (InterfaceC9427a.InterfaceC9428a interfaceC9428a : (List) this.afg.clone()) {
                int mo28729uf = interfaceC9428a.mo28729uf();
                if (m28416uX.mo28334bh(mo28729uf)) {
                    interfaceC9428a.mo28731ud().mo28748tM().mo28720ul();
                    if (!arrayList.contains(Integer.valueOf(mo28729uf))) {
                        arrayList.add(Integer.valueOf(mo28729uf));
                    }
                } else {
                    interfaceC9428a.mo28725uj();
                }
            }
            m28416uX.mo28333p(arrayList);
        }
    }

    @Override // com.kwad.framework.filedownloader.AbstractC9479e
    /* renamed from: ux */
    public final void mo28312ux() {
        if (m28568uy() == DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            InterfaceC9579w m28416uX = C9559r.m28419uU().m28416uX();
            if (C9498d.ail) {
                C9498d.m28535c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(C9503h.m28485uB().size()));
            }
            if (C9503h.m28485uB().size() > 0) {
                synchronized (this.afg) {
                    C9503h.m28485uB().m28486o(this.afg);
                    Iterator<InterfaceC9427a.InterfaceC9428a> it = this.afg.iterator();
                    while (it.hasNext()) {
                        it.next().free();
                    }
                    m28416uX.mo28332va();
                }
                C9559r.m28419uU().m28418uV();
            }
        } else if (C9503h.m28485uB().size() > 0) {
            C9498d.m28534d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(C9503h.m28485uB().size()));
        }
    }
}
