package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.e;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DefaultFolder.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c extends e {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: DefaultFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements e.u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ String f50312b;

        a(String str) {
            this.f50312b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.k0("", this.f50312b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: DefaultFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class b implements e.u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ String f50314b;

        b(String str) {
            this.f50314b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.o0("", this.f50314b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(k kVar) {
        super("", '\uffff', kVar);
        this.f50327g = true;
        this.f50323c = 2;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Cannot append to Default Folder");
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public boolean delete(boolean z3) throws MessagingException {
        throw new MethodNotSupportedException("Cannot delete Default Folder");
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Cannot expunge Default Folder");
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        return new e(str, '\uffff', (k) this.store);
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public String getName() {
        return this.f50321a;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public Folder getParent() {
        return null;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        com.sun.mail.imap.protocol.m[] mVarArr = (com.sun.mail.imap.protocol.m[]) p(new a(str));
        if (mVarArr == null) {
            return new Folder[0];
        }
        int length = mVarArr.length;
        e[] eVarArr = new e[length];
        for (int i4 = 0; i4 < length; i4++) {
            eVarArr[i4] = new e(mVarArr[i4], (k) this.store);
        }
        return eVarArr;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public Folder[] listSubscribed(String str) throws MessagingException {
        com.sun.mail.imap.protocol.m[] mVarArr = (com.sun.mail.imap.protocol.m[]) p(new b(str));
        if (mVarArr == null) {
            return new Folder[0];
        }
        int length = mVarArr.length;
        e[] eVarArr = new e[length];
        for (int i4 = 0; i4 < length; i4++) {
            eVarArr[i4] = new e(mVarArr[i4], (k) this.store);
        }
        return eVarArr;
    }

    @Override // com.sun.mail.imap.e, javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("Cannot rename Default Folder");
    }
}
