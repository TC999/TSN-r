package com.sun.mail.imap;

import com.sun.mail.imap.protocol.MessageSet;
import com.sun.mail.imap.protocol.UIDSet;
import java.util.Vector;
import javax.mail.Message;

/* compiled from: Utility.java */
/* renamed from: com.sun.mail.imap.o */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12757o {

    /* compiled from: Utility.java */
    /* renamed from: com.sun.mail.imap.o$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12758a {
        /* renamed from: a */
        boolean mo16228a(IMAPMessage iMAPMessage);
    }

    private C12757o() {
    }

    /* renamed from: a */
    public static MessageSet[] m16230a(Message[] messageArr, InterfaceC12758a interfaceC12758a) {
        Vector vector = new Vector(1);
        int i = 0;
        while (i < messageArr.length) {
            IMAPMessage iMAPMessage = (IMAPMessage) messageArr[i];
            if (!iMAPMessage.isExpunged()) {
                int mo16290w = iMAPMessage.mo16290w();
                if (interfaceC12758a == null || interfaceC12758a.mo16228a(iMAPMessage)) {
                    MessageSet messageSet = new MessageSet();
                    messageSet.f36166a = mo16290w;
                    while (true) {
                        i++;
                        if (i >= messageArr.length) {
                            break;
                        }
                        IMAPMessage iMAPMessage2 = (IMAPMessage) messageArr[i];
                        if (!iMAPMessage2.isExpunged()) {
                            int mo16290w2 = iMAPMessage2.mo16290w();
                            if (interfaceC12758a == null || interfaceC12758a.mo16228a(iMAPMessage2)) {
                                if (mo16290w2 != mo16290w + 1) {
                                    i--;
                                    break;
                                }
                                mo16290w = mo16290w2;
                            }
                        }
                    }
                    messageSet.f36167b = mo16290w;
                    vector.addElement(messageSet);
                }
            }
            i++;
        }
        if (vector.isEmpty()) {
            return null;
        }
        MessageSet[] messageSetArr = new MessageSet[vector.size()];
        vector.copyInto(messageSetArr);
        return messageSetArr;
    }

    /* renamed from: b */
    public static UIDSet[] m16229b(Message[] messageArr) {
        Vector vector = new Vector(1);
        int i = 0;
        while (i < messageArr.length) {
            IMAPMessage iMAPMessage = (IMAPMessage) messageArr[i];
            if (!iMAPMessage.isExpunged()) {
                long m16298x = iMAPMessage.m16298x();
                UIDSet uIDSet = new UIDSet();
                uIDSet.f36191a = m16298x;
                while (true) {
                    i++;
                    if (i < messageArr.length) {
                        IMAPMessage iMAPMessage2 = (IMAPMessage) messageArr[i];
                        if (!iMAPMessage2.isExpunged()) {
                            long m16298x2 = iMAPMessage2.m16298x();
                            if (m16298x2 != 1 + m16298x) {
                                i--;
                                break;
                            }
                            m16298x = m16298x2;
                        }
                    } else {
                        break;
                    }
                }
                uIDSet.f36192b = m16298x;
                vector.addElement(uIDSet);
            }
            i++;
        }
        if (vector.isEmpty()) {
            return null;
        }
        UIDSet[] uIDSetArr = new UIDSet[vector.size()];
        vector.copyInto(uIDSetArr);
        return uIDSetArr;
    }
}
