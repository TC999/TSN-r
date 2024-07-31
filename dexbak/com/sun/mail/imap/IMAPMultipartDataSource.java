package com.sun.mail.imap;

import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import java.util.Vector;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.MultipartDataSource;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimePartDataSource;

/* renamed from: com.sun.mail.imap.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPMultipartDataSource extends MimePartDataSource implements MultipartDataSource {

    /* renamed from: a */
    private Vector f36005a;

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPMultipartDataSource(MimePart mimePart, BODYSTRUCTURE[] bodystructureArr, String str, IMAPMessage iMAPMessage) {
        super(mimePart);
        this.f36005a = new Vector(bodystructureArr.length);
        for (int i = 0; i < bodystructureArr.length; i++) {
            this.f36005a.addElement(new IMAPBodyPart(bodystructureArr[i], str == null ? Integer.toString(i + 1) : str + "." + Integer.toString(i + 1), iMAPMessage));
        }
    }

    @Override // javax.mail.MultipartDataSource
    public BodyPart getBodyPart(int i) throws MessagingException {
        return (BodyPart) this.f36005a.elementAt(i);
    }

    @Override // javax.mail.MultipartDataSource
    public int getCount() {
        return this.f36005a.size();
    }
}
