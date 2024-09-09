package com.sun.mail.imap;

import java.util.Vector;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.MultipartDataSource;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimePartDataSource;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPMultipartDataSource.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h extends MimePartDataSource implements MultipartDataSource {

    /* renamed from: a  reason: collision with root package name */
    private Vector f50419a;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(MimePart mimePart, com.sun.mail.imap.protocol.d[] dVarArr, String str, g gVar) {
        super(mimePart);
        this.f50419a = new Vector(dVarArr.length);
        for (int i4 = 0; i4 < dVarArr.length; i4++) {
            this.f50419a.addElement(new d(dVarArr[i4], str == null ? Integer.toString(i4 + 1) : str + "." + Integer.toString(i4 + 1), gVar));
        }
    }

    @Override // javax.mail.MultipartDataSource
    public BodyPart getBodyPart(int i4) throws MessagingException {
        return (BodyPart) this.f50419a.elementAt(i4);
    }

    @Override // javax.mail.MultipartDataSource
    public int getCount() {
        return this.f50419a.size();
    }
}
