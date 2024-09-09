package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class k implements t {
    private a.InterfaceC0666a aeL;
    private a.c aeM;
    private Queue<MessageSnapshot> aeN;
    private boolean aeO = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a.InterfaceC0666a interfaceC0666a, a.c cVar) {
        a(interfaceC0666a, cVar);
    }

    private void a(a.InterfaceC0666a interfaceC0666a, a.c cVar) {
        this.aeL = interfaceC0666a;
        this.aeM = cVar;
        this.aeN = new LinkedBlockingQueue();
    }

    private void bc(int i4) {
        if (com.kwad.framework.filedownloader.d.d.bF(i4)) {
            if (!this.aeN.isEmpty()) {
                MessageSnapshot peek = this.aeN.peek();
                com.kwad.framework.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.getId()), Integer.valueOf(this.aeN.size()), Byte.valueOf(peek.tV()));
            }
            this.aeL = null;
        }
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify completed %s", this.aeL);
        }
        this.aeM.um();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0666a interfaceC0666a = this.aeL;
        if (interfaceC0666a == null) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.tV()));
            }
        } else if (!this.aeO && interfaceC0666a.ud().tS() != null) {
            this.aeN.offer(messageSnapshot);
            j.uD().a(this);
        } else {
            if ((l.isValid() || this.aeL.uk()) && messageSnapshot.tV() == 4) {
                this.aeM.um();
            }
            bc(messageSnapshot.tV());
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void b(a.InterfaceC0666a interfaceC0666a, a.c cVar) {
        if (this.aeL == null) {
            a(interfaceC0666a, cVar);
            return;
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("the messenger is working, can't re-appointment for %s", interfaceC0666a));
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify pending %s", this.aeL);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify started %s", this.aeL);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify connected %s", this.aeL);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a ud = this.aeL.ud();
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress %s %d %d", ud, Long.valueOf(ud.tT()), Long.valueOf(ud.tU()));
        }
        if (ud.tP() <= 0) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.aeL);
                return;
            }
            return;
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify block completed %s %s", this.aeL, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            a ud = this.aeL.ud();
            com.kwad.framework.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.aeL, Integer.valueOf(ud.tY()), Integer.valueOf(ud.tZ()), ud.tX());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify warn %s", this.aeL);
        }
        this.aeM.um();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            a.InterfaceC0666a interfaceC0666a = this.aeL;
            com.kwad.framework.filedownloader.f.d.c(this, "notify error %s %s", interfaceC0666a, interfaceC0666a.ud().tX());
        }
        this.aeM.um();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify paused %s", this.aeL);
        }
        this.aeM.um();
        p(messageSnapshot);
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        a.InterfaceC0666a interfaceC0666a = this.aeL;
        objArr[0] = Integer.valueOf(interfaceC0666a == null ? -1 : interfaceC0666a.ud().getId());
        objArr[1] = super.toString();
        return com.kwad.framework.filedownloader.f.f.b("%d:%s", objArr);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean uG() {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify begin %s", this.aeL);
        }
        if (this.aeL == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.aeN.size()));
            return false;
        }
        this.aeM.onBegin();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void uH() {
        if (this.aeO) {
            return;
        }
        MessageSnapshot poll = this.aeN.poll();
        byte tV = poll.tV();
        a.InterfaceC0666a interfaceC0666a = this.aeL;
        if (interfaceC0666a == null) {
            return;
        }
        a ud = interfaceC0666a.ud();
        i tS = ud.tS();
        x.a ue = interfaceC0666a.ue();
        bc(tV);
        if (tS == null) {
            return;
        }
        if (tV == 4) {
            try {
                tS.b(ud);
                o(((com.kwad.framework.filedownloader.message.a) poll).vX());
                return;
            } catch (Throwable th) {
                m(ue.g(th));
                return;
            }
        }
        g gVar = tS instanceof g ? (g) tS : null;
        if (tV == -4) {
            tS.d(ud);
        } else if (tV == -3) {
            tS.c(ud);
        } else if (tV == -2) {
            if (gVar != null) {
                poll.wc();
                poll.wa();
                return;
            }
            tS.c(ud, poll.vY(), poll.vZ());
        } else if (tV == -1) {
            tS.a(ud, poll.wd());
        } else if (tV == 1) {
            if (gVar != null) {
                poll.wc();
                poll.wa();
                return;
            }
            tS.a(ud, poll.vY(), poll.vZ());
        } else if (tV == 2) {
            if (gVar != null) {
                poll.getEtag();
                poll.vQ();
                poll.wa();
                return;
            }
            tS.a(ud, poll.getEtag(), poll.vQ(), ud.getSmallFileSoFarBytes(), poll.vZ());
        } else if (tV == 3) {
            if (gVar != null) {
                poll.wc();
            } else {
                tS.b(ud, poll.vY(), ud.getSmallFileTotalBytes());
            }
        } else if (tV != 5) {
            if (tV != 6) {
                return;
            }
            tS.a(ud);
        } else if (gVar != null) {
            poll.wd();
            poll.tZ();
            poll.wc();
        } else {
            poll.wd();
            poll.tZ();
            poll.vY();
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean uI() {
        return this.aeL.ud().ua();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean uJ() {
        return this.aeN.peek().tV() == 4;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void uK() {
        this.aeO = true;
    }
}
