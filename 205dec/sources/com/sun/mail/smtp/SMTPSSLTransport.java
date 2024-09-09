package com.sun.mail.smtp;

import javax.mail.Session;
import javax.mail.URLName;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SMTPSSLTransport extends SMTPTransport {
    public SMTPSSLTransport(Session session, URLName uRLName) {
        super(session, uRLName, "smtps", 465, true);
    }
}
