package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.InterfaceC9427a;
import com.kwad.framework.filedownloader.message.C9535f;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.p353f.C9498d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.framework.filedownloader.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9503h {
    private final ArrayList<InterfaceC9427a.InterfaceC9428a> aeA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.framework.filedownloader.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9504a {
        private static final C9503h aeB = new C9503h((byte) 0);
    }

    /* synthetic */ C9503h(byte b) {
        this();
    }

    /* renamed from: uB */
    public static C9503h m28485uB() {
        return C9504a.aeB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m28493a(InterfaceC9427a.InterfaceC9428a interfaceC9428a) {
        return this.aeA.isEmpty() || !this.aeA.contains(interfaceC9428a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aZ */
    public final int m28491aZ(int i) {
        int i2;
        synchronized (this.aeA) {
            Iterator<InterfaceC9427a.InterfaceC9428a> it = this.aeA.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().mo28757aY(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m28490b(InterfaceC9427a.InterfaceC9428a interfaceC9428a) {
        if (!interfaceC9428a.mo28731ud().mo28746tO()) {
            interfaceC9428a.mo28728ug();
        }
        if (interfaceC9428a.mo28730ue().mo28319ut().mo28344uG()) {
            m28487c(interfaceC9428a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ba */
    public final List<InterfaceC9427a.InterfaceC9428a> m28489ba(int i) {
        byte mo28739tV;
        ArrayList arrayList = new ArrayList();
        synchronized (this.aeA) {
            Iterator<InterfaceC9427a.InterfaceC9428a> it = this.aeA.iterator();
            while (it.hasNext()) {
                InterfaceC9427a.InterfaceC9428a next = it.next();
                if (next.mo28757aY(i) && !next.isOver() && (mo28739tV = next.mo28731ud().mo28739tV()) != 0 && mo28739tV != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bb */
    public final List<InterfaceC9427a.InterfaceC9428a> m28488bb(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aeA) {
            Iterator<InterfaceC9427a.InterfaceC9428a> it = this.aeA.iterator();
            while (it.hasNext()) {
                InterfaceC9427a.InterfaceC9428a next = it.next();
                if (next.mo28757aY(i) && !next.isOver()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m28487c(InterfaceC9427a.InterfaceC9428a interfaceC9428a) {
        if (interfaceC9428a.mo28727uh()) {
            return;
        }
        synchronized (this.aeA) {
            if (this.aeA.contains(interfaceC9428a)) {
                C9498d.m28534d(this, "already has %s", interfaceC9428a);
            } else {
                interfaceC9428a.mo28726ui();
                this.aeA.add(interfaceC9428a);
                if (C9498d.ail) {
                    C9498d.m28533e(this, "add list in all %s %d %d", interfaceC9428a, Byte.valueOf(interfaceC9428a.mo28731ud().mo28739tV()), Integer.valueOf(this.aeA.size()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public final void m28486o(List<InterfaceC9427a.InterfaceC9428a> list) {
        synchronized (this.aeA) {
            Iterator<InterfaceC9427a.InterfaceC9428a> it = this.aeA.iterator();
            while (it.hasNext()) {
                InterfaceC9427a.InterfaceC9428a next = it.next();
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

    private C9503h() {
        this.aeA = new ArrayList<>();
    }

    /* renamed from: a */
    public final boolean m28492a(InterfaceC9427a.InterfaceC9428a interfaceC9428a, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte mo28442tV = messageSnapshot.mo28442tV();
        synchronized (this.aeA) {
            remove = this.aeA.remove(interfaceC9428a);
        }
        if (C9498d.ail && this.aeA.size() == 0) {
            C9498d.m28533e(this, "remove %s left %d %d", interfaceC9428a, Byte.valueOf(mo28442tV), Integer.valueOf(this.aeA.size()));
        }
        if (remove) {
            InterfaceC9576t mo28319ut = interfaceC9428a.mo28730ue().mo28319ut();
            if (mo28442tV == -4) {
                mo28319ut.mo28347l(messageSnapshot);
            } else if (mo28442tV == -3) {
                mo28319ut.mo28349j(C9535f.m28456t(messageSnapshot));
            } else if (mo28442tV == -2) {
                mo28319ut.mo28345n(messageSnapshot);
            } else if (mo28442tV == -1) {
                mo28319ut.mo28346m(messageSnapshot);
            }
        } else {
            C9498d.m28538a(this, "remove error, not exist: %s %d", interfaceC9428a, Byte.valueOf(mo28442tV));
        }
        return remove;
    }
}
