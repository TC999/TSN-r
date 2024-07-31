package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.InterfaceC9427a;
import com.kwad.framework.filedownloader.message.C9532e;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.p353f.C9498d;
import java.util.List;

/* renamed from: com.kwad.framework.filedownloader.aa */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9437aa implements C9532e.InterfaceC9534b {
    /* renamed from: a */
    private static boolean m28807a(List<InterfaceC9427a.InterfaceC9428a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.mo28442tV() == -3) {
            for (InterfaceC9427a.InterfaceC9428a interfaceC9428a : list) {
                if (interfaceC9428a.mo28730ue().mo28322c(messageSnapshot)) {
                    return true;
                }
            }
        }
        for (InterfaceC9427a.InterfaceC9428a interfaceC9428a2 : list) {
            if (interfaceC9428a2.mo28730ue().mo28323b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.mo28442tV()) {
            for (InterfaceC9427a.InterfaceC9428a interfaceC9428a3 : list) {
                if (interfaceC9428a3.mo28730ue().mo28321d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() == 1) {
            return list.get(0).mo28730ue().mo28324a(messageSnapshot);
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.message.C9532e.InterfaceC9534b
    /* renamed from: r */
    public final void mo28390r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            List<InterfaceC9427a.InterfaceC9428a> m28489ba = C9503h.m28485uB().m28489ba(messageSnapshot.getId());
            if (m28489ba.size() > 0) {
                InterfaceC9427a mo28731ud = m28489ba.get(0).mo28731ud();
                if (C9498d.ail) {
                    C9498d.m28535c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(mo28731ud.mo28739tV()), Byte.valueOf(messageSnapshot.mo28442tV()), Integer.valueOf(m28489ba.size()));
                }
                if (!m28807a(m28489ba, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.mo28442tV()) + " task-count:" + m28489ba.size());
                    for (InterfaceC9427a.InterfaceC9428a interfaceC9428a : m28489ba) {
                        sb.append(" | ");
                        sb.append((int) interfaceC9428a.mo28731ud().mo28739tV());
                    }
                    C9498d.m28536b(this, sb.toString(), new Object[0]);
                }
            } else {
                C9498d.m28536b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.mo28442tV()));
            }
        }
    }
}
