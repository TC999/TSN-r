package com.sun.mail.imap;

import com.sun.mail.util.CRLFOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.mail.Message;
import javax.mail.MessagingException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPFolder.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class m implements com.sun.mail.iap.e {

    /* renamed from: a  reason: collision with root package name */
    private Message f50464a;

    /* renamed from: b  reason: collision with root package name */
    private int f50465b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f50466c;

    public m(Message message, int i4) throws MessagingException, IOException {
        this.f50465b = -1;
        this.f50464a = message;
        l lVar = new l(i4);
        CRLFOutputStream cRLFOutputStream = new CRLFOutputStream(lVar);
        message.writeTo(cRLFOutputStream);
        cRLFOutputStream.flush();
        this.f50465b = lVar.b();
        this.f50466c = lVar.a();
    }

    @Override // com.sun.mail.iap.e
    public int size() {
        return this.f50465b;
    }

    @Override // com.sun.mail.iap.e
    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = this.f50466c;
            if (bArr != null) {
                outputStream.write(bArr, 0, this.f50465b);
                return;
            }
            this.f50464a.writeTo(new CRLFOutputStream(outputStream));
        } catch (MessagingException e4) {
            throw new IOException("MessagingException while appending message: " + e4);
        }
    }
}
