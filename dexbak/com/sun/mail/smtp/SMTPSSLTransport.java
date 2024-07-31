package com.sun.mail.smtp;

import javax.mail.Session;
import javax.mail.URLName;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SMTPSSLTransport extends SMTPTransport {
    public SMTPSSLTransport(Session session, URLName uRLName) {
        super(session, uRLName, "smtps", 465, true);
    }
}
