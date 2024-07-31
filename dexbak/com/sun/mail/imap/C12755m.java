package com.sun.mail.imap;

import com.sun.mail.iap.Literal;
import com.sun.mail.util.CRLFOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.mail.Message;
import javax.mail.MessagingException;

/* compiled from: IMAPFolder.java */
/* renamed from: com.sun.mail.imap.m */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12755m implements Literal {

    /* renamed from: a */
    private Message f36052a;

    /* renamed from: b */
    private int f36053b;

    /* renamed from: c */
    private byte[] f36054c;

    public C12755m(Message message, int i) throws MessagingException, IOException {
        this.f36053b = -1;
        this.f36052a = message;
        C12754l c12754l = new C12754l(i);
        CRLFOutputStream cRLFOutputStream = new CRLFOutputStream(c12754l);
        message.writeTo(cRLFOutputStream);
        cRLFOutputStream.flush();
        this.f36053b = c12754l.m16239b();
        this.f36054c = c12754l.m16240a();
    }

    @Override // com.sun.mail.iap.Literal
    public int size() {
        return this.f36053b;
    }

    @Override // com.sun.mail.iap.Literal
    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = this.f36054c;
            if (bArr != null) {
                outputStream.write(bArr, 0, this.f36053b);
                return;
            }
            this.f36052a.writeTo(new CRLFOutputStream(outputStream));
        } catch (MessagingException e) {
            throw new IOException("MessagingException while appending message: " + e);
        }
    }
}
