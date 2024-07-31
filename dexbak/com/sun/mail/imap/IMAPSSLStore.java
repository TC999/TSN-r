package com.sun.mail.imap;

import javax.mail.Session;
import javax.mail.URLName;

/* renamed from: com.sun.mail.imap.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPSSLStore extends IMAPStore {
    public IMAPSSLStore(Session session, URLName uRLName) {
        super(session, uRLName, "imaps", 993, true);
    }
}
