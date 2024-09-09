package javax.mail;

import java.util.Vector;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.MailEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class Service {
    protected boolean debug;

    /* renamed from: q  reason: collision with root package name */
    private EventQueue f55220q;
    protected Session session;
    protected URLName url;
    private boolean connected = false;
    private Vector connectionListeners = null;
    private Object qLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class TerminatorEvent extends MailEvent {
        private static final long serialVersionUID = 5542172141759168416L;

        TerminatorEvent() {
            super(new Object());
        }

        @Override // javax.mail.event.MailEvent
        public void dispatch(Object obj) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Service(Session session, URLName uRLName) {
        this.debug = false;
        this.session = session;
        this.url = uRLName;
        this.debug = session.getDebug();
    }

    private void terminateQueue() {
        synchronized (this.qLock) {
            if (this.f55220q != null) {
                Vector vector = new Vector();
                vector.setSize(1);
                this.f55220q.enqueue(new TerminatorEvent(), vector);
                this.f55220q = null;
            }
        }
    }

    public synchronized void addConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners == null) {
            this.connectionListeners = new Vector();
        }
        this.connectionListeners.addElement(connectionListener);
    }

    public synchronized void close() throws MessagingException {
        setConnected(false);
        notifyConnectionListeners(3);
    }

    public void connect() throws MessagingException {
        connect(null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        terminateQueue();
    }

    public synchronized URLName getURLName() {
        URLName uRLName = this.url;
        if (uRLName != null && (uRLName.getPassword() != null || this.url.getFile() != null)) {
            return new URLName(this.url.getProtocol(), this.url.getHost(), this.url.getPort(), null, this.url.getUsername(), null);
        }
        return this.url;
    }

    public synchronized boolean isConnected() {
        return this.connected;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void notifyConnectionListeners(int i4) {
        if (this.connectionListeners != null) {
            queueEvent(new ConnectionEvent(this, i4), this.connectionListeners);
        }
        if (i4 == 3) {
            terminateQueue();
        }
    }

    protected boolean protocolConnect(String str, int i4, String str2, String str3) throws MessagingException {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void queueEvent(MailEvent mailEvent, Vector vector) {
        synchronized (this.qLock) {
            if (this.f55220q == null) {
                this.f55220q = new EventQueue();
            }
        }
        this.f55220q.enqueue(mailEvent, (Vector) vector.clone());
    }

    public synchronized void removeConnectionListener(ConnectionListener connectionListener) {
        Vector vector = this.connectionListeners;
        if (vector != null) {
            vector.removeElement(connectionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void setConnected(boolean z3) {
        this.connected = z3;
    }

    protected synchronized void setURLName(URLName uRLName) {
        this.url = uRLName;
    }

    public String toString() {
        URLName uRLName = getURLName();
        if (uRLName != null) {
            return uRLName.toString();
        }
        return super.toString();
    }

    public void connect(String str, String str2, String str3) throws MessagingException {
        connect(str, -1, str2, str3);
    }

    public void connect(String str, String str2) throws MessagingException {
        connect(null, str, str2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:6|(7:8|(1:10)(1:85)|11|(1:13)(1:84)|(4:15|(2:17|18)|79|18)(3:(2:83|18)|79|18)|89|90)(1:86)|(2:(1:21)|(1:23))|(1:25)|(1:27)|28|(2:72|73)|30|(1:71)(2:34|(1:(1:37)(2:67|(1:69)))(7:70|39|40|41|(5:56|57|58|59|(1:61))|43|(1:(1:46)(2:48|49))(4:50|(1:52)|53|54)))|38|39|40|41|(0)|43|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011d, code lost:
        r16 = r0;
        r0 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014d A[Catch: all -> 0x017d, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0015, B:14:0x0023, B:17:0x002d, B:19:0x0035, B:25:0x0053, B:29:0x006b, B:31:0x0086, B:33:0x00a1, B:35:0x00ab, B:38:0x00b6, B:46:0x00cf, B:48:0x00d3, B:51:0x00f5, B:59:0x0115, B:64:0x0122, B:67:0x0129, B:69:0x0135, B:73:0x0146, B:74:0x0147, B:75:0x014c, B:76:0x014d, B:78:0x015f, B:79:0x016d, B:52:0x00fe, B:54:0x0108, B:41:0x00be, B:43:0x00c2, B:21:0x003e, B:23:0x004a, B:82:0x0175, B:83:0x017c), top: B:93:0x0005, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void connect(java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Service.connect(java.lang.String, int, java.lang.String, java.lang.String):void");
    }
}
