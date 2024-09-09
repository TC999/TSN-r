package com.sun.mail.pop3;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: POP3Folder.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b extends Folder {

    /* renamed from: a  reason: collision with root package name */
    private String f50603a;

    /* renamed from: b  reason: collision with root package name */
    private f f50604b;

    /* renamed from: c  reason: collision with root package name */
    private int f50605c;

    /* renamed from: d  reason: collision with root package name */
    private int f50606d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f50607e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f50608f;

    /* renamed from: g  reason: collision with root package name */
    private Vector f50609g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f50610h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e eVar, String str) {
        super(eVar);
        this.f50607e = false;
        this.f50608f = false;
        this.f50610h = false;
        this.f50603a = str;
        if (str.equalsIgnoreCase("INBOX")) {
            this.f50607e = true;
        }
    }

    @Override // javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    void b() throws IllegalStateException {
        if (this.f50608f) {
            throw new IllegalStateException("Folder is Open");
        }
    }

    void c() throws IllegalStateException {
        if (!this.f50608f) {
            throw new IllegalStateException("Folder is not Open");
        }
    }

    @Override // javax.mail.Folder
    public synchronized void close(boolean z3) throws MessagingException {
        c();
        try {
            if (((e) this.store).f50625j) {
                this.f50604b.j();
            }
            if (z3 && this.mode == 2) {
                for (int i4 = 0; i4 < this.f50609g.size(); i4++) {
                    c cVar = (c) this.f50609g.elementAt(i4);
                    if (cVar != null && cVar.isSet(Flags.Flag.DELETED)) {
                        try {
                            this.f50604b.a(i4 + 1);
                        } catch (IOException e4) {
                            throw new MessagingException("Exception deleting messages during close", e4);
                        }
                    }
                }
            }
            this.f50604b.h();
            this.f50604b = null;
            ((e) this.store).b(this);
            this.f50609g = null;
            this.f50608f = false;
        } catch (IOException unused) {
            this.f50604b = null;
            ((e) this.store).b(this);
            this.f50609g = null;
            this.f50608f = false;
        }
        notifyConnectionListeners(3);
    }

    @Override // javax.mail.Folder
    public boolean create(int i4) throws MessagingException {
        return false;
    }

    void d() throws IllegalStateException {
        int i4;
        if (!this.f50608f || ((i4 = this.mode) != 1 && i4 != 2)) {
            throw new IllegalStateException("Folder is not Readable");
        }
    }

    @Override // javax.mail.Folder
    public boolean delete(boolean z3) throws MessagingException {
        throw new MethodNotSupportedException("delete");
    }

    void e() throws IllegalStateException {
        if (!this.f50608f || this.mode != 2) {
            throw new IllegalStateException("Folder is not Writable");
        }
    }

    @Override // javax.mail.Folder
    public boolean exists() {
        return this.f50607e;
    }

    @Override // javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Expunge not supported");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.sun.mail.pop3.c f(javax.mail.Folder r4, int r5) throws javax.mail.MessagingException {
        /*
            r3 = this;
            javax.mail.Store r4 = r3.store
            com.sun.mail.pop3.e r4 = (com.sun.mail.pop3.e) r4
            java.lang.reflect.Constructor r4 = r4.f50628m
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
            com.sun.mail.pop3.c r4 = (com.sun.mail.pop3.c) r4     // Catch: java.lang.Exception -> L1d
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
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.b.f(javax.mail.Folder, int):com.sun.mail.pop3.c");
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        d();
        if (!this.f50610h && fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
            int size = this.f50609g.size();
            String[] strArr = new String[size];
            try {
                try {
                    if (!this.f50604b.p(strArr)) {
                        return;
                    }
                    for (int i4 = 0; i4 < size; i4++) {
                        if (strArr[i4] != null) {
                            ((c) getMessage(i4 + 1)).f50615d = strArr[i4];
                        }
                    }
                    this.f50610h = true;
                } catch (IOException e4) {
                    throw new MessagingException("error getting UIDL", e4);
                }
            } catch (EOFException e5) {
                close(false);
                throw new FolderClosedException(this, e5.toString());
            }
        }
        if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
            for (Message message : messageArr) {
                try {
                    c cVar = (c) message;
                    cVar.getHeader("");
                    cVar.getSize();
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
    public f g() throws MessagingException {
        c();
        return this.f50604b;
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    @Override // javax.mail.Folder
    public String getFullName() {
        return this.f50603a;
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i4) throws MessagingException {
        c cVar;
        c();
        int i5 = i4 - 1;
        cVar = (c) this.f50609g.elementAt(i5);
        if (cVar == null) {
            cVar = f(this, i4);
            this.f50609g.setElementAt(cVar, i5);
        }
        return cVar;
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        if (this.f50608f) {
            d();
            return this.f50605c;
        }
        return -1;
    }

    @Override // javax.mail.Folder
    public String getName() {
        return this.f50603a;
    }

    @Override // javax.mail.Folder
    public Folder getParent() {
        return new a((e) this.store);
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

    public synchronized int h() throws MessagingException {
        c();
        return this.f50606d;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int[] i() throws javax.mail.MessagingException {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.c()     // Catch: java.lang.Throwable -> L68
            int r0 = r6.f50605c     // Catch: java.lang.Throwable -> L68
            int[] r0 = new int[r0]     // Catch: java.lang.Throwable -> L68
            r1 = 0
            com.sun.mail.pop3.f r2 = r6.f50604b     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L5b
            java.io.InputStream r2 = r2.d()     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L5b
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
            int r5 = r6.f50605c     // Catch: java.lang.Exception -> L14 java.lang.Throwable -> L45
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
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.b.i():int[]");
    }

    @Override // javax.mail.Folder
    public boolean isOpen() {
        if (this.f50608f) {
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

    public synchronized String j(Message message) throws MessagingException {
        c cVar;
        c();
        cVar = (c) message;
        try {
            try {
                if (cVar.f50615d == "UNKNOWN") {
                    cVar.f50615d = this.f50604b.o(cVar.getMessageNumber());
                }
            } catch (IOException e4) {
                throw new MessagingException("error getting UIDL", e4);
            }
        } catch (EOFException e5) {
            close(false);
            throw new FolderClosedException(this, e5.toString());
        }
        return cVar.f50615d;
    }

    public synchronized InputStream k() throws MessagingException, IOException {
        c();
        return this.f50604b.d();
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Folder
    public void notifyMessageChangedListeners(int i4, Message message) {
        super.notifyMessageChangedListeners(i4, message);
    }

    @Override // javax.mail.Folder
    public synchronized void open(int i4) throws MessagingException {
        e eVar;
        b();
        if (this.f50607e) {
            try {
                f c4 = ((e) this.store).c(this);
                this.f50604b = c4;
                i l4 = c4.l();
                this.f50605c = l4.f50641a;
                this.f50606d = l4.f50642b;
                this.mode = i4;
                this.f50608f = true;
                Vector vector = new Vector(this.f50605c);
                this.f50609g = vector;
                vector.setSize(this.f50605c);
                this.f50610h = false;
                notifyConnectionListeners(1);
            } catch (IOException e4) {
                try {
                    f fVar = this.f50604b;
                    if (fVar != null) {
                        fVar.h();
                    }
                    this.f50604b = null;
                    eVar = (e) this.store;
                } catch (IOException unused) {
                    this.f50604b = null;
                    eVar = (e) this.store;
                } catch (Throwable th) {
                    this.f50604b = null;
                    ((e) this.store).b(this);
                    throw th;
                }
                eVar.b(this);
                throw new MessagingException("Open failed", e4);
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
