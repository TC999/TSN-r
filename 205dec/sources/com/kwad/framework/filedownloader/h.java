package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h {
    private final ArrayList<a.InterfaceC0666a> aeA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {
        private static final h aeB = new h((byte) 0);
    }

    /* synthetic */ h(byte b4) {
        this();
    }

    public static h uB() {
        return a.aeB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(a.InterfaceC0666a interfaceC0666a) {
        return this.aeA.isEmpty() || !this.aeA.contains(interfaceC0666a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int aZ(int i4) {
        int i5;
        synchronized (this.aeA) {
            Iterator<a.InterfaceC0666a> it = this.aeA.iterator();
            i5 = 0;
            while (it.hasNext()) {
                if (it.next().aY(i4)) {
                    i5++;
                }
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(a.InterfaceC0666a interfaceC0666a) {
        if (!interfaceC0666a.ud().tO()) {
            interfaceC0666a.ug();
        }
        if (interfaceC0666a.ue().ut().uG()) {
            c(interfaceC0666a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<a.InterfaceC0666a> ba(int i4) {
        byte tV;
        ArrayList arrayList = new ArrayList();
        synchronized (this.aeA) {
            Iterator<a.InterfaceC0666a> it = this.aeA.iterator();
            while (it.hasNext()) {
                a.InterfaceC0666a next = it.next();
                if (next.aY(i4) && !next.isOver() && (tV = next.ud().tV()) != 0 && tV != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<a.InterfaceC0666a> bb(int i4) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aeA) {
            Iterator<a.InterfaceC0666a> it = this.aeA.iterator();
            while (it.hasNext()) {
                a.InterfaceC0666a next = it.next();
                if (next.aY(i4) && !next.isOver()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(a.InterfaceC0666a interfaceC0666a) {
        if (interfaceC0666a.uh()) {
            return;
        }
        synchronized (this.aeA) {
            if (this.aeA.contains(interfaceC0666a)) {
                com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0666a);
            } else {
                interfaceC0666a.ui();
                this.aeA.add(interfaceC0666a);
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0666a, Byte.valueOf(interfaceC0666a.ud().tV()), Integer.valueOf(this.aeA.size()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o(List<a.InterfaceC0666a> list) {
        synchronized (this.aeA) {
            Iterator<a.InterfaceC0666a> it = this.aeA.iterator();
            while (it.hasNext()) {
                a.InterfaceC0666a next = it.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.aeA.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int size() {
        return this.aeA.size();
    }

    private h() {
        this.aeA = new ArrayList<>();
    }

    public final boolean a(a.InterfaceC0666a interfaceC0666a, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte tV = messageSnapshot.tV();
        synchronized (this.aeA) {
            remove = this.aeA.remove(interfaceC0666a);
        }
        if (com.kwad.framework.filedownloader.f.d.ail && this.aeA.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0666a, Byte.valueOf(tV), Integer.valueOf(this.aeA.size()));
        }
        if (remove) {
            t ut = interfaceC0666a.ue().ut();
            if (tV == -4) {
                ut.l(messageSnapshot);
            } else if (tV == -3) {
                ut.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            } else if (tV == -2) {
                ut.n(messageSnapshot);
            } else if (tV == -1) {
                ut.m(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0666a, Byte.valueOf(tV));
        }
        return remove;
    }
}
