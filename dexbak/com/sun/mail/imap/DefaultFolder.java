package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.ListInfo;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
import kotlin.jvm.internal.C14356p;

/* renamed from: com.sun.mail.imap.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultFolder extends IMAPFolder {

    /* compiled from: DefaultFolder.java */
    /* renamed from: com.sun.mail.imap.c$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12729a implements IMAPFolder.InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ String f35891b;

        C12729a(String str) {
            this.f35891b = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.m16149k0("", this.f35891b);
        }
    }

    /* compiled from: DefaultFolder.java */
    /* renamed from: com.sun.mail.imap.c$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12730b implements IMAPFolder.InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ String f35893b;

        C12730b(String str) {
            this.f35893b = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.m16144o0("", this.f35893b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultFolder(IMAPStore iMAPStore) {
        super("", C14356p.f41165b, iMAPStore);
        this.f35913g = true;
        this.f35909c = 2;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Cannot append to Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean delete(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("Cannot delete Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Cannot expunge Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        return new IMAPFolder(str, C14356p.f41165b, (IMAPStore) this.store);
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public String getName() {
        return this.f35907a;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder getParent() {
        return null;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        ListInfo[] listInfoArr = (ListInfo[]) m16341p(new C12729a(str));
        if (listInfoArr == null) {
            return new Folder[0];
        }
        int length = listInfoArr.length;
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[length];
        for (int i = 0; i < length; i++) {
            iMAPFolderArr[i] = new IMAPFolder(listInfoArr[i], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder[] listSubscribed(String str) throws MessagingException {
        ListInfo[] listInfoArr = (ListInfo[]) m16341p(new C12730b(str));
        if (listInfoArr == null) {
            return new Folder[0];
        }
        int length = listInfoArr.length;
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[length];
        for (int i = 0; i < length; i++) {
            iMAPFolderArr[i] = new IMAPFolder(listInfoArr[i], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("Cannot rename Default Folder");
    }
}
