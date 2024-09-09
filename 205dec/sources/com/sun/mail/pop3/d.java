package com.sun.mail.pop3;

import javax.mail.Session;
import javax.mail.URLName;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: POP3SSLStore.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d extends e {
    public d(Session session, URLName uRLName) {
        super(session, uRLName, "pop3s", 995, true);
    }
}
