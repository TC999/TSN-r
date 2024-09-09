package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g {
    private final e.b aht;
    private final List<a> ahv = new ArrayList();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class a {
        private final List<Integer> ahw = new ArrayList();
        private final Executor ahx;

        public a(int i4) {
            this.ahx = com.kwad.framework.filedownloader.f.b.o(1, "Flow-" + i4);
        }

        public final void bB(int i4) {
            this.ahw.add(Integer.valueOf(i4));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.ahx.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.aht.r(messageSnapshot);
                    try {
                        a.this.ahw.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i4, e.b bVar) {
        this.aht = bVar;
        for (int i5 = 0; i5 < 5; i5++) {
            this.ahv.add(new a(i5));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.ahv) {
                int id = messageSnapshot.getId();
                Iterator<a> it = this.ahv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.ahw.contains(Integer.valueOf(id))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int i4 = 0;
                    Iterator<a> it2 = this.ahv.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.ahw.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (i4 == 0 || next2.ahw.size() < i4) {
                            i4 = next2.ahw.size();
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    aVar.bB(id);
                }
            }
        } finally {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        }
    }
}
