package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class aa implements e.b {
    private static boolean a(List<a.InterfaceC0666a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.tV() == -3) {
            for (a.InterfaceC0666a interfaceC0666a : list) {
                if (interfaceC0666a.ue().c(messageSnapshot)) {
                    return true;
                }
            }
        }
        for (a.InterfaceC0666a interfaceC0666a2 : list) {
            if (interfaceC0666a2.ue().b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.tV()) {
            for (a.InterfaceC0666a interfaceC0666a3 : list) {
                if (interfaceC0666a3.ue().d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() == 1) {
            return list.get(0).ue().a(messageSnapshot);
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            List<a.InterfaceC0666a> ba = h.uB().ba(messageSnapshot.getId());
            if (ba.size() > 0) {
                a ud = ba.get(0).ud();
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(ud.tV()), Byte.valueOf(messageSnapshot.tV()), Integer.valueOf(ba.size()));
                }
                if (!a(ba, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.tV()) + " task-count:" + ba.size());
                    for (a.InterfaceC0666a interfaceC0666a : ba) {
                        sb.append(" | ");
                        sb.append((int) interfaceC0666a.ud().tV());
                    }
                    com.kwad.framework.filedownloader.f.d.b(this, sb.toString(), new Object[0]);
                }
            } else {
                com.kwad.framework.filedownloader.f.d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.tV()));
            }
        }
    }
}
