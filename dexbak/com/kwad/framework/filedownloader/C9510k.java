package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.InterfaceC9427a;
import com.kwad.framework.filedownloader.InterfaceC9580x;
import com.kwad.framework.filedownloader.message.InterfaceC9517a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.p351d.C9466d;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kwad.framework.filedownloader.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9510k implements InterfaceC9576t {
    private InterfaceC9427a.InterfaceC9428a aeL;
    private InterfaceC9427a.InterfaceC9430c aeM;
    private Queue<MessageSnapshot> aeN;
    private boolean aeO = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9510k(InterfaceC9427a.InterfaceC9428a interfaceC9428a, InterfaceC9427a.InterfaceC9430c interfaceC9430c) {
        m28474a(interfaceC9428a, interfaceC9430c);
    }

    /* renamed from: a */
    private void m28474a(InterfaceC9427a.InterfaceC9428a interfaceC9428a, InterfaceC9427a.InterfaceC9430c interfaceC9430c) {
        this.aeL = interfaceC9428a;
        this.aeM = interfaceC9430c;
        this.aeN = new LinkedBlockingQueue();
    }

    /* renamed from: bc */
    private void m28473bc(int i) {
        if (C9466d.m28676bF(i)) {
            if (!this.aeN.isEmpty()) {
                MessageSnapshot peek = this.aeN.peek();
                C9498d.m28534d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.getId()), Integer.valueOf(this.aeN.size()), Byte.valueOf(peek.mo28442tV()));
            }
            this.aeL = null;
        }
    }

    /* renamed from: o */
    private void m28472o(MessageSnapshot messageSnapshot) {
        if (C9498d.ail) {
            C9498d.m28535c(this, "notify completed %s", this.aeL);
        }
        this.aeM.mo28713um();
        m28471p(messageSnapshot);
    }

    /* renamed from: p */
    private void m28471p(MessageSnapshot messageSnapshot) {
        InterfaceC9427a.InterfaceC9428a interfaceC9428a = this.aeL;
        if (interfaceC9428a == null) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.mo28442tV()));
            }
        } else if (!this.aeO && interfaceC9428a.mo28731ud().mo28742tS() != null) {
            this.aeN.offer(messageSnapshot);
            C9506j.m28478uD().m28482a(this);
        } else {
            if ((C9511l.isValid() || this.aeL.mo28724uk()) && messageSnapshot.mo28442tV() == 4) {
                this.aeM.mo28713um();
            }
            m28473bc(messageSnapshot.mo28442tV());
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: b */
    public final void mo28354b(InterfaceC9427a.InterfaceC9428a interfaceC9428a, InterfaceC9427a.InterfaceC9430c interfaceC9430c) {
        if (this.aeL == null) {
            m28474a(interfaceC9428a, interfaceC9430c);
            return;
        }
        throw new IllegalStateException(C9501f.m28515b("the messenger is working, can't re-appointment for %s", interfaceC9428a));
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: f */
    public final void mo28353f(MessageSnapshot messageSnapshot) {
        if (C9498d.ail) {
            C9498d.m28535c(this, "notify pending %s", this.aeL);
        }
        m28471p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: g */
    public final void mo28352g(MessageSnapshot messageSnapshot) {
        if (C9498d.ail) {
            C9498d.m28535c(this, "notify started %s", this.aeL);
        }
        m28471p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: h */
    public final void mo28351h(MessageSnapshot messageSnapshot) {
        if (C9498d.ail) {
            C9498d.m28535c(this, "notify connected %s", this.aeL);
        }
        m28471p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: i */
    public final void mo28350i(MessageSnapshot messageSnapshot) {
        InterfaceC9427a mo28731ud = this.aeL.mo28731ud();
        if (C9498d.ail) {
            C9498d.m28535c(this, "notify progress %s %d %d", mo28731ud, Long.valueOf(mo28731ud.mo28741tT()), Long.valueOf(mo28731ud.mo28740tU()));
        }
        if (mo28731ud.mo28745tP() <= 0) {
            if (C9498d.ail) {
                C9498d.m28535c(this, "notify progress but client not request notify %s", this.aeL);
                return;
            }
            return;
        }
        m28471p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: j */
    public final void mo28349j(MessageSnapshot messageSnapshot) {
        if (C9498d.ail) {
            C9498d.m28535c(this, "notify block completed %s %s", this.aeL, Thread.currentThread().getName());
        }
        m28471p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: k */
    public final void mo28348k(MessageSnapshot messageSnapshot) {
        if (C9498d.ail) {
            InterfaceC9427a mo28731ud = this.aeL.mo28731ud();
            C9498d.m28535c(this, "notify retry %s %d %d %s", this.aeL, Integer.valueOf(mo28731ud.mo28736tY()), Integer.valueOf(mo28731ud.mo28735tZ()), mo28731ud.mo28737tX());
        }
        m28471p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: l */
    public final void mo28347l(MessageSnapshot messageSnapshot) {
        if (C9498d.ail) {
            C9498d.m28535c(this, "notify warn %s", this.aeL);
        }
        this.aeM.mo28713um();
        m28471p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: m */
    public final void mo28346m(MessageSnapshot messageSnapshot) {
        if (C9498d.ail) {
            InterfaceC9427a.InterfaceC9428a interfaceC9428a = this.aeL;
            C9498d.m28535c(this, "notify error %s %s", interfaceC9428a, interfaceC9428a.mo28731ud().mo28737tX());
        }
        this.aeM.mo28713um();
        m28471p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: n */
    public final void mo28345n(MessageSnapshot messageSnapshot) {
        if (C9498d.ail) {
            C9498d.m28535c(this, "notify paused %s", this.aeL);
        }
        this.aeM.mo28713um();
        m28471p(messageSnapshot);
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        InterfaceC9427a.InterfaceC9428a interfaceC9428a = this.aeL;
        objArr[0] = Integer.valueOf(interfaceC9428a == null ? -1 : interfaceC9428a.mo28731ud().getId());
        objArr[1] = super.toString();
        return C9501f.m28515b("%d:%s", objArr);
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: uG */
    public final boolean mo28344uG() {
        if (C9498d.ail) {
            C9498d.m28535c(this, "notify begin %s", this.aeL);
        }
        if (this.aeL == null) {
            C9498d.m28534d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.aeN.size()));
            return false;
        }
        this.aeM.onBegin();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: uH */
    public final void mo28343uH() {
        if (this.aeO) {
            return;
        }
        MessageSnapshot poll = this.aeN.poll();
        byte mo28442tV = poll.mo28442tV();
        InterfaceC9427a.InterfaceC9428a interfaceC9428a = this.aeL;
        if (interfaceC9428a == null) {
            return;
        }
        InterfaceC9427a mo28731ud = interfaceC9428a.mo28731ud();
        AbstractC9505i mo28742tS = mo28731ud.mo28742tS();
        InterfaceC9580x.InterfaceC9581a mo28730ue = interfaceC9428a.mo28730ue();
        m28473bc(mo28442tV);
        if (mo28742tS == null) {
            return;
        }
        if (mo28442tV == 4) {
            try {
                mo28742tS.mo28098b(mo28731ud);
                m28472o(((InterfaceC9517a) poll).mo28466vX());
                return;
            } catch (Throwable th) {
                mo28346m(mo28730ue.mo28320g(th));
                return;
            }
        }
        AbstractC9502g abstractC9502g = mo28742tS instanceof AbstractC9502g ? (AbstractC9502g) mo28742tS : null;
        if (mo28442tV == -4) {
            mo28742tS.mo28095d(mo28731ud);
        } else if (mo28442tV == -3) {
            mo28742tS.mo25282c(mo28731ud);
        } else if (mo28442tV == -2) {
            if (abstractC9502g != null) {
                poll.mo28449wc();
                poll.mo28450wa();
                return;
            }
            mo28742tS.mo28096c(mo28731ud, poll.mo28444vY(), poll.mo28445vZ());
        } else if (mo28442tV == -1) {
            mo28742tS.mo25283a(mo28731ud, poll.mo28446wd());
        } else if (mo28442tV == 1) {
            if (abstractC9502g != null) {
                poll.mo28449wc();
                poll.mo28450wa();
                return;
            }
            mo28742tS.mo28100a(mo28731ud, poll.mo28444vY(), poll.mo28445vZ());
        } else if (mo28442tV == 2) {
            if (abstractC9502g != null) {
                poll.getEtag();
                poll.mo28447vQ();
                poll.mo28450wa();
                return;
            }
            mo28742tS.mo28099a(mo28731ud, poll.getEtag(), poll.mo28447vQ(), mo28731ud.getSmallFileSoFarBytes(), poll.mo28445vZ());
        } else if (mo28442tV == 3) {
            if (abstractC9502g != null) {
                poll.mo28449wc();
            } else {
                mo28742tS.mo28097b(mo28731ud, poll.mo28444vY(), mo28731ud.getSmallFileTotalBytes());
            }
        } else if (mo28442tV != 5) {
            if (mo28442tV != 6) {
                return;
            }
            mo28742tS.mo28101a(mo28731ud);
        } else if (abstractC9502g != null) {
            poll.mo28446wd();
            poll.mo28443tZ();
            poll.mo28449wc();
        } else {
            poll.mo28446wd();
            poll.mo28443tZ();
            poll.mo28444vY();
        }
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: uI */
    public final boolean mo28342uI() {
        return this.aeL.mo28731ud().mo28734ua();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: uJ */
    public final boolean mo28341uJ() {
        return this.aeN.peek().mo28442tV() == 4;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9576t
    /* renamed from: uK */
    public final void mo28340uK() {
        this.aeO = true;
    }
}
