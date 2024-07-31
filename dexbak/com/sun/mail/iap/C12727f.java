package com.sun.mail.iap;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Vector;

/* compiled from: Protocol.java */
/* renamed from: com.sun.mail.iap.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12727f {

    /* renamed from: p */
    private static final byte[] f35849p = {13, 10};

    /* renamed from: a */
    protected String f35850a;

    /* renamed from: b */
    private Socket f35851b;

    /* renamed from: c */
    protected boolean f35852c;

    /* renamed from: d */
    protected boolean f35853d;

    /* renamed from: e */
    protected PrintStream f35854e;

    /* renamed from: f */
    protected Properties f35855f;

    /* renamed from: g */
    protected String f35856g;

    /* renamed from: h */
    private boolean f35857h;

    /* renamed from: i */
    private TraceInputStream f35858i;

    /* renamed from: j */
    private volatile ResponseInputStream f35859j;

    /* renamed from: k */
    private TraceOutputStream f35860k;

    /* renamed from: l */
    private volatile DataOutputStream f35861l;

    /* renamed from: m */
    private int f35862m;

    /* renamed from: n */
    private volatile Vector f35863n;

    /* renamed from: o */
    private volatile long f35864o;

    public C12727f(String str, int i, boolean z, PrintStream printStream, Properties properties, String str2, boolean z2) throws IOException, ProtocolException {
        boolean z3 = false;
        this.f35857h = false;
        this.f35862m = 0;
        this.f35863n = null;
        try {
            this.f35850a = str;
            this.f35852c = z;
            this.f35854e = printStream;
            this.f35855f = properties;
            this.f35856g = str2;
            this.f35851b = SocketFetcher.getSocket(str, i, properties, str2, z2);
            String property = properties.getProperty("mail.debug.quote");
            if (property != null && property.equalsIgnoreCase("true")) {
                z3 = true;
            }
            this.f35853d = z3;
            m16415i(printStream);
            mo16150k(mo16148l());
            this.f35864o = System.currentTimeMillis();
            this.f35857h = true;
        } catch (Throwable th) {
            if (!this.f35857h) {
                mo16160c();
            }
            throw th;
        }
    }

    /* renamed from: i */
    private void m16415i(PrintStream printStream) throws IOException {
        TraceInputStream traceInputStream = new TraceInputStream(this.f35851b.getInputStream(), printStream);
        this.f35858i = traceInputStream;
        traceInputStream.setTrace(this.f35852c);
        this.f35858i.setQuote(this.f35853d);
        this.f35859j = new ResponseInputStream(this.f35858i);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.f35851b.getOutputStream(), printStream);
        this.f35860k = traceOutputStream;
        traceOutputStream.setTrace(this.f35852c);
        this.f35860k.setQuote(this.f35853d);
        this.f35861l = new DataOutputStream(new BufferedOutputStream(this.f35860k));
    }

    /* renamed from: a */
    public synchronized void m16421a(ResponseHandler responseHandler) {
        if (this.f35863n == null) {
            this.f35863n = new Vector();
        }
        this.f35863n.addElement(responseHandler);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x001f -> B:12:0x0020). Please submit an issue!!! */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.sun.mail.iap.C12728g[] m16420b(java.lang.String r5, com.sun.mail.iap.C12725b r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Vector r0 = new java.util.Vector     // Catch: java.lang.Throwable -> L5a
            r0.<init>()     // Catch: java.lang.Throwable -> L5a
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r2 = r4.m16410q(r5, r6)     // Catch: java.lang.Exception -> Le com.sun.mail.iap.LiteralException -> L17 java.lang.Throwable -> L5a
            goto L20
        Le:
            r5 = move-exception
            com.sun.mail.iap.g r5 = com.sun.mail.iap.C12728g.m16406a(r5)     // Catch: java.lang.Throwable -> L5a
            r0.addElement(r5)     // Catch: java.lang.Throwable -> L5a
            goto L1f
        L17:
            r5 = move-exception
            com.sun.mail.iap.g r5 = r5.getResponse()     // Catch: java.lang.Throwable -> L5a
            r0.addElement(r5)     // Catch: java.lang.Throwable -> L5a
        L1f:
            r1 = 1
        L20:
            if (r1 == 0) goto L33
            int r5 = r0.size()     // Catch: java.lang.Throwable -> L5a
            com.sun.mail.iap.g[] r5 = new com.sun.mail.iap.C12728g[r5]     // Catch: java.lang.Throwable -> L5a
            r0.copyInto(r5)     // Catch: java.lang.Throwable -> L5a
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5a
            r4.f35864o = r0     // Catch: java.lang.Throwable -> L5a
            monitor-exit(r4)
            return r5
        L33:
            com.sun.mail.iap.g r5 = r4.mo16148l()     // Catch: com.sun.mail.iap.ProtocolException -> L38 java.io.IOException -> L3a java.lang.Throwable -> L5a
            goto L3f
        L38:
            goto L20
        L3a:
            r5 = move-exception
            com.sun.mail.iap.g r5 = com.sun.mail.iap.C12728g.m16406a(r5)     // Catch: java.lang.Throwable -> L5a
        L3f:
            r0.addElement(r5)     // Catch: java.lang.Throwable -> L5a
            boolean r6 = r5.m16402e()     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L49
            r1 = 1
        L49:
            boolean r6 = r5.m16397j()     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L20
            java.lang.String r5 = r5.m16404c()     // Catch: java.lang.Throwable -> L5a
            boolean r5 = r5.equals(r2)     // Catch: java.lang.Throwable -> L5a
            if (r5 == 0) goto L20
            goto L1f
        L5a:
            r5 = move-exception
            monitor-exit(r4)
            goto L5e
        L5d:
            throw r5
        L5e:
            goto L5d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.iap.C12727f.m16420b(java.lang.String, com.sun.mail.iap.b):com.sun.mail.iap.g[]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public synchronized void mo16160c() {
        Socket socket = this.f35851b;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
            this.f35851b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public ResponseInputStream m16419d() {
        return this.f35859j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public OutputStream m16418e() {
        return this.f35861l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public ByteArray mo16156f() {
        return null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        mo16160c();
    }

    /* renamed from: g */
    public long m16417g() {
        return this.f35864o;
    }

    /* renamed from: h */
    public void m16416h(C12728g c12728g) throws ProtocolException {
        if (c12728g.m16399h()) {
            return;
        }
        if (!c12728g.m16400g()) {
            if (!c12728g.m16403d()) {
                if (c12728g.m16402e()) {
                    mo16160c();
                    throw new ConnectionException(this, c12728g);
                }
                return;
            }
            throw new BadCommandException(c12728g);
        }
        throw new CommandFailedException(c12728g);
    }

    /* renamed from: j */
    public void m16414j(C12728g[] c12728gArr) {
        if (this.f35863n == null) {
            return;
        }
        for (C12728g c12728g : c12728gArr) {
            if (c12728g != null) {
                int size = this.f35863n.size();
                if (size == 0) {
                    return;
                }
                Object[] objArr = new Object[size];
                this.f35863n.copyInto(objArr);
                for (int i = 0; i < size; i++) {
                    ((ResponseHandler) objArr[i]).mo16288a(c12728g);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public void mo16150k(C12728g c12728g) throws ProtocolException {
        if (c12728g.m16402e()) {
            throw new ConnectionException(this, c12728g);
        }
    }

    /* renamed from: l */
    public C12728g mo16148l() throws IOException, ProtocolException {
        return new C12728g(this);
    }

    /* renamed from: m */
    public synchronized void m16413m(ResponseHandler responseHandler) {
        if (this.f35863n != null) {
            this.f35863n.removeElement(responseHandler);
        }
    }

    /* renamed from: n */
    public void m16412n(String str, C12725b c12725b) throws ProtocolException {
        C12728g[] m16420b = m16420b(str, c12725b);
        m16414j(m16420b);
        m16416h(m16420b[m16420b.length - 1]);
    }

    /* renamed from: o */
    public synchronized void m16411o(String str) throws IOException, ProtocolException {
        m16412n(str, null);
        this.f35851b = SocketFetcher.startTLS(this.f35851b, this.f35855f, this.f35856g);
        m16415i(this.f35854e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public synchronized boolean mo16143p() {
        return false;
    }

    /* renamed from: q */
    public String m16410q(String str, C12725b c12725b) throws IOException, ProtocolException {
        StringBuilder sb = new StringBuilder(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        int i = this.f35862m;
        this.f35862m = i + 1;
        sb.append(Integer.toString(i, 10));
        String sb2 = sb.toString();
        DataOutputStream dataOutputStream = this.f35861l;
        dataOutputStream.writeBytes(String.valueOf(sb2) + " " + str);
        if (c12725b != null) {
            this.f35861l.write(32);
            c12725b.m16438g(this);
        }
        this.f35861l.write(f35849p);
        this.f35861l.flush();
        return sb2;
    }

    public C12727f(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        this.f35857h = false;
        this.f35862m = 0;
        this.f35863n = null;
        this.f35850a = "localhost";
        this.f35852c = z;
        this.f35853d = false;
        this.f35854e = System.out;
        TraceInputStream traceInputStream = new TraceInputStream(inputStream, System.out);
        this.f35858i = traceInputStream;
        traceInputStream.setTrace(z);
        this.f35858i.setQuote(this.f35853d);
        this.f35859j = new ResponseInputStream(this.f35858i);
        TraceOutputStream traceOutputStream = new TraceOutputStream(outputStream, System.out);
        this.f35860k = traceOutputStream;
        traceOutputStream.setTrace(z);
        this.f35860k.setQuote(this.f35853d);
        this.f35861l = new DataOutputStream(new BufferedOutputStream(this.f35860k));
        this.f35864o = System.currentTimeMillis();
    }
}
