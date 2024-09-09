package com.sun.mail.smtp;

import javax.mail.Address;
import javax.mail.SendFailedException;
import javax.mail.internet.InternetAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SMTPSendFailedException extends SendFailedException {
    private static final long serialVersionUID = 8049122628728932894L;
    protected InternetAddress addr;
    protected String cmd;
    protected int rc;

    public SMTPSendFailedException(String str, int i4, String str2, Exception exc, Address[] addressArr, Address[] addressArr2, Address[] addressArr3) {
        super(str2, exc, addressArr, addressArr2, addressArr3);
        this.cmd = str;
        this.rc = i4;
    }

    public String getCommand() {
        return this.cmd;
    }

    public int getReturnCode() {
        return this.rc;
    }
}
