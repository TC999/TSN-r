package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.message.C9532e;
import com.kwad.framework.filedownloader.p353f.C9490b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.kwad.framework.filedownloader.message.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9536g {
    private final C9532e.InterfaceC9534b aht;
    private final List<C9537a> ahv = new ArrayList();

    /* renamed from: com.kwad.framework.filedownloader.message.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C9537a {
        private final List<Integer> ahw = new ArrayList();
        private final Executor ahx;

        public C9537a(int i) {
            this.ahx = C9490b.m28551o(1, "Flow-" + i);
        }

        /* renamed from: bB */
        public final void m28452bB(int i) {
            this.ahw.add(Integer.valueOf(i));
        }

        /* renamed from: u */
        public final void m28451u(final MessageSnapshot messageSnapshot) {
            this.ahx.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    C9536g.this.aht.mo28390r(messageSnapshot);
                    try {
                        C9537a.this.ahw.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9536g(int i, C9532e.InterfaceC9534b interfaceC9534b) {
        this.aht = interfaceC9534b;
        for (int i2 = 0; i2 < 5; i2++) {
            this.ahv.add(new C9537a(i2));
        }
    }

    /* renamed from: u */
    public final void m28454u(MessageSnapshot messageSnapshot) {
        C9537a c9537a = null;
        try {
            synchronized (this.ahv) {
                int id = messageSnapshot.getId();
                Iterator<C9537a> it = this.ahv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C9537a next = it.next();
                    if (next.ahw.contains(Integer.valueOf(id))) {
                        c9537a = next;
                        break;
                    }
                }
                if (c9537a == null) {
                    int i = 0;
                    Iterator<C9537a> it2 = this.ahv.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        C9537a next2 = it2.next();
                        if (next2.ahw.size() <= 0) {
                            c9537a = next2;
                            break;
                        } else if (i == 0 || next2.ahw.size() < i) {
                            i = next2.ahw.size();
                            c9537a = next2;
                        }
                    }
                }
                if (c9537a != null) {
                    c9537a.m28452bB(id);
                }
            }
        } finally {
            if (c9537a != null) {
                c9537a.m28451u(messageSnapshot);
            }
        }
    }
}
