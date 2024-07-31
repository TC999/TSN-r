package com.sun.mail.pop3;

import com.tencent.connect.common.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
import javax.mail.UIDFolder;

/* renamed from: com.sun.mail.pop3.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class POP3Folder extends Folder {

    /* renamed from: a */
    private String f36193a;

    /* renamed from: b */
    private C12763f f36194b;

    /* renamed from: c */
    private int f36195c;

    /* renamed from: d */
    private int f36196d;

    /* renamed from: e */
    private boolean f36197e;

    /* renamed from: f */
    private boolean f36198f;

    /* renamed from: g */
    private Vector f36199g;

    /* renamed from: h */
    private boolean f36200h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public POP3Folder(POP3Store pOP3Store, String str) {
        super(pOP3Store);
        this.f36197e = false;
        this.f36198f = false;
        this.f36200h = false;
        this.f36193a = str;
        if (str.equalsIgnoreCase("INBOX")) {
            this.f36197e = true;
        }
    }

    @Override // javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    /* renamed from: b */
    void m16082b() throws IllegalStateException {
        if (this.f36198f) {
            throw new IllegalStateException("Folder is Open");
        }
    }

    /* renamed from: c */
    void m16081c() throws IllegalStateException {
        if (!this.f36198f) {
            throw new IllegalStateException("Folder is not Open");
        }
    }

    @Override // javax.mail.Folder
    public synchronized void close(boolean z) throws MessagingException {
        m16081c();
        try {
            if (((POP3Store) this.store).f36215j) {
                this.f36194b.m16058j();
            }
            if (z && this.mode == 2) {
                for (int i = 0; i < this.f36199g.size(); i++) {
                    POP3Message pOP3Message = (POP3Message) this.f36199g.elementAt(i);
                    if (pOP3Message != null && pOP3Message.isSet(Flags.Flag.DELETED)) {
                        try {
                            this.f36194b.m16067a(i + 1);
                        } catch (IOException e) {
                            throw new MessagingException("Exception deleting messages during close", e);
                        }
                    }
                }
            }
            this.f36194b.m16060h();
            this.f36194b = null;
            ((POP3Store) this.store).m16069b(this);
            this.f36199g = null;
            this.f36198f = false;
        } catch (IOException unused) {
            this.f36194b = null;
            ((POP3Store) this.store).m16069b(this);
            this.f36199g = null;
            this.f36198f = false;
        }
        notifyConnectionListeners(3);
    }

    @Override // javax.mail.Folder
    public boolean create(int i) throws MessagingException {
        return false;
    }

    /* renamed from: d */
    void m16080d() throws IllegalStateException {
        int i;
        if (!this.f36198f || ((i = this.mode) != 1 && i != 2)) {
            throw new IllegalStateException("Folder is not Readable");
        }
    }

    @Override // javax.mail.Folder
    public boolean delete(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("delete");
    }

    /* renamed from: e */
    void m16079e() throws IllegalStateException {
        if (!this.f36198f || this.mode != 2) {
            throw new IllegalStateException("Folder is not Writable");
        }
    }

    @Override // javax.mail.Folder
    public boolean exists() {
        return this.f36197e;
    }

    @Override // javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Expunge not supported");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.sun.mail.pop3.POP3Message m16078f(javax.mail.Folder r4, int r5) throws javax.mail.MessagingException {
        /*
            r3 = this;
            javax.mail.Store r4 = r3.store
            com.sun.mail.pop3.e r4 = (com.sun.mail.pop3.POP3Store) r4
            java.lang.reflect.Constructor r4 = r4.f36218m
            if (r4 == 0) goto L1d
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L1d
            r1 = 0
            r0[r1] = r3     // Catch: java.lang.Exception -> L1d
            r1 = 1
            java.lang.Integer r2 = new java.lang.Integer     // Catch: java.lang.Exception -> L1d
            r2.<init>(r5)     // Catch: java.lang.Exception -> L1d
            r0[r1] = r2     // Catch: java.lang.Exception -> L1d
            java.lang.Object r4 = r4.newInstance(r0)     // Catch: java.lang.Exception -> L1d
            com.sun.mail.pop3.c r4 = (com.sun.mail.pop3.POP3Message) r4     // Catch: java.lang.Exception -> L1d
            goto L1e
        L1d:
            r4 = 0
        L1e:
            if (r4 != 0) goto L25
            com.sun.mail.pop3.c r4 = new com.sun.mail.pop3.c
            r4.<init>(r3, r5)
        L25:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Folder.m16078f(javax.mail.Folder, int):com.sun.mail.pop3.c");
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        m16080d();
        if (!this.f36200h && fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
            int size = this.f36199g.size();
            String[] strArr = new String[size];
            try {
                try {
                    if (!this.f36194b.m16052p(strArr)) {
                        return;
                    }
                    for (int i = 0; i < size; i++) {
                        if (strArr[i] != null) {
                            ((POP3Message) getMessage(i + 1)).f36205d = strArr[i];
                        }
                    }
                    this.f36200h = true;
                } catch (IOException e) {
                    throw new MessagingException("error getting UIDL", e);
                }
            } catch (EOFException e2) {
                close(false);
                throw new FolderClosedException(this, e2.toString());
            }
        }
        if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
            for (Message message : messageArr) {
                try {
                    POP3Message pOP3Message = (POP3Message) message;
                    pOP3Message.getHeader("");
                    pOP3Message.getSize();
                } catch (MessageRemovedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Folder
    public void finalize() throws Throwable {
        super.finalize();
        close(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public C12763f m16077g() throws MessagingException {
        m16081c();
        return this.f36194b;
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    @Override // javax.mail.Folder
    public String getFullName() {
        return this.f36193a;
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i) throws MessagingException {
        POP3Message pOP3Message;
        m16081c();
        int i2 = i - 1;
        pOP3Message = (POP3Message) this.f36199g.elementAt(i2);
        if (pOP3Message == null) {
            pOP3Message = m16078f(this, i);
            this.f36199g.setElementAt(pOP3Message, i2);
        }
        return pOP3Message;
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        if (this.f36198f) {
            m16080d();
            return this.f36195c;
        }
        return -1;
    }

    @Override // javax.mail.Folder
    public String getName() {
        return this.f36193a;
    }

    @Override // javax.mail.Folder
    public Folder getParent() {
        return new C12762a((POP3Store) this.store);
    }

    @Override // javax.mail.Folder
    public Flags getPermanentFlags() {
        return new Flags();
    }

    @Override // javax.mail.Folder
    public char getSeparator() {
        return (char) 0;
    }

    @Override // javax.mail.Folder
    public int getType() {
        return 1;
    }

    /* renamed from: h */
    public synchronized int m16076h() throws MessagingException {
        m16081c();
        return this.f36196d;
    }

    @Override // javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0063, code lost:
        if (r2 == null) goto L30;
     */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int[] m16075i() throws javax.mail.MessagingException {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.m16081c()     // Catch: java.lang.Throwable -> L68
            int r0 = r6.f36195c     // Catch: java.lang.Throwable -> L68
            int[] r0 = new int[r0]     // Catch: java.lang.Throwable -> L68
            r1 = 0
            com.sun.mail.pop3.f r2 = r6.f36194b     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L5b
            java.io.InputStream r2 = r2.m16064d()     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L5b
            com.sun.mail.util.LineInputStream r3 = new com.sun.mail.util.LineInputStream     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L5c
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L5c
        L14:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            if (r1 != 0) goto L25
            r3.close()     // Catch: java.io.IOException -> L1e java.lang.Throwable -> L68
            goto L1f
        L1e:
        L1f:
            if (r2 == 0) goto L66
        L21:
            r2.close()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L68
            goto L66
        L25:
            java.util.StringTokenizer r4 = new java.util.StringTokenizer     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L45
            r4.<init>(r1)     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L45
            java.lang.String r1 = r4.nextToken()     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L45
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L45
            java.lang.String r4 = r4.nextToken()     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L45
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L45
            if (r1 <= 0) goto L14
            int r5 = r6.f36195c     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L45
            if (r1 > r5) goto L14
            int r1 = r1 + (-1)
            r0[r1] = r4     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L45
            goto L14
        L45:
            r0 = move-exception
            r1 = r3
            goto L4e
        L48:
            r1 = r3
            goto L5c
        L4a:
            r0 = move-exception
            goto L4e
        L4c:
            r0 = move-exception
            r2 = r1
        L4e:
            if (r1 == 0) goto L55
            r1.close()     // Catch: java.io.IOException -> L54 java.lang.Throwable -> L68
            goto L55
        L54:
        L55:
            if (r2 == 0) goto L5a
            r2.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L68
        L5a:
            throw r0     // Catch: java.lang.Throwable -> L68
        L5b:
            r2 = r1
        L5c:
            if (r1 == 0) goto L63
            r1.close()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L68
            goto L63
        L62:
        L63:
            if (r2 == 0) goto L66
            goto L21
        L66:
            monitor-exit(r6)
            return r0
        L68:
            r0 = move-exception
            monitor-exit(r6)
            goto L6c
        L6b:
            throw r0
        L6c:
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Folder.m16075i():int[]");
    }

    @Override // javax.mail.Folder
    public boolean isOpen() {
        if (this.f36198f) {
            if (this.store.isConnected()) {
                return true;
            }
            try {
                close(false);
            } catch (MessagingException unused) {
            }
            return false;
        }
        return false;
    }

    /* renamed from: j */
    public synchronized String m16074j(Message message) throws MessagingException {
        POP3Message pOP3Message;
        m16081c();
        pOP3Message = (POP3Message) message;
        try {
            try {
                if (pOP3Message.f36205d == Constants.APP_VERSION_UNKNOWN) {
                    pOP3Message.f36205d = this.f36194b.m16053o(pOP3Message.getMessageNumber());
                }
            } catch (IOException e) {
                throw new MessagingException("error getting UIDL", e);
            }
        } catch (EOFException e2) {
            close(false);
            throw new FolderClosedException(this, e2.toString());
        }
        return pOP3Message.f36205d;
    }

    /* renamed from: k */
    public synchronized InputStream m16073k() throws MessagingException, IOException {
        m16081c();
        return this.f36194b.m16064d();
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Folder
    public void notifyMessageChangedListeners(int i, Message message) {
        super.notifyMessageChangedListeners(i, message);
    }

    @Override // javax.mail.Folder
    public synchronized void open(int i) throws MessagingException {
        POP3Store pOP3Store;
        m16082b();
        if (this.f36197e) {
            try {
                C12763f m16068c = ((POP3Store) this.store).m16068c(this);
                this.f36194b = m16068c;
                C12766i m16056l = m16068c.m16056l();
                this.f36195c = m16056l.f36231a;
                this.f36196d = m16056l.f36232b;
                this.mode = i;
                this.f36198f = true;
                Vector vector = new Vector(this.f36195c);
                this.f36199g = vector;
                vector.setSize(this.f36195c);
                this.f36200h = false;
                notifyConnectionListeners(1);
            } catch (IOException e) {
                try {
                    C12763f c12763f = this.f36194b;
                    if (c12763f != null) {
                        c12763f.m16060h();
                    }
                    this.f36194b = null;
                    pOP3Store = (POP3Store) this.store;
                } catch (IOException unused) {
                    this.f36194b = null;
                    pOP3Store = (POP3Store) this.store;
                } catch (Throwable th) {
                    this.f36194b = null;
                    ((POP3Store) this.store).m16069b(this);
                    throw th;
                }
                pOP3Store.m16069b(this);
                throw new MessagingException("Open failed", e);
            }
        } else {
            throw new FolderNotFoundException(this, "folder is not INBOX");
        }
    }

    @Override // javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("renameTo");
    }
}
