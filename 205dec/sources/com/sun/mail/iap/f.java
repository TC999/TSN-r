package com.sun.mail.iap;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Protocol.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f {

    /* renamed from: p  reason: collision with root package name */
    private static final byte[] f50270p = {13, 10};

    /* renamed from: a  reason: collision with root package name */
    protected String f50271a;

    /* renamed from: b  reason: collision with root package name */
    private Socket f50272b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f50273c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f50274d;

    /* renamed from: e  reason: collision with root package name */
    protected PrintStream f50275e;

    /* renamed from: f  reason: collision with root package name */
    protected Properties f50276f;

    /* renamed from: g  reason: collision with root package name */
    protected String f50277g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f50278h;

    /* renamed from: i  reason: collision with root package name */
    private TraceInputStream f50279i;

    /* renamed from: j  reason: collision with root package name */
    private volatile i f50280j;

    /* renamed from: k  reason: collision with root package name */
    private TraceOutputStream f50281k;

    /* renamed from: l  reason: collision with root package name */
    private volatile DataOutputStream f50282l;

    /* renamed from: m  reason: collision with root package name */
    private int f50283m;

    /* renamed from: n  reason: collision with root package name */
    private volatile Vector f50284n;

    /* renamed from: o  reason: collision with root package name */
    private volatile long f50285o;

    public f(String str, int i4, boolean z3, PrintStream printStream, Properties properties, String str2, boolean z4) throws IOException, ProtocolException {
        boolean z5 = false;
        this.f50278h = false;
        this.f50283m = 0;
        this.f50284n = null;
        try {
            this.f50271a = str;
            this.f50273c = z3;
            this.f50275e = printStream;
            this.f50276f = properties;
            this.f50277g = str2;
            this.f50272b = SocketFetcher.getSocket(str, i4, properties, str2, z4);
            String property = properties.getProperty("mail.debug.quote");
            if (property != null && property.equalsIgnoreCase("true")) {
                z5 = true;
            }
            this.f50274d = z5;
            i(printStream);
            k(l());
            this.f50285o = System.currentTimeMillis();
            this.f50278h = true;
        } catch (Throwable th) {
            if (!this.f50278h) {
                c();
            }
            throw th;
        }
    }

    private void i(PrintStream printStream) throws IOException {
        TraceInputStream traceInputStream = new TraceInputStream(this.f50272b.getInputStream(), printStream);
        this.f50279i = traceInputStream;
        traceInputStream.setTrace(this.f50273c);
        this.f50279i.setQuote(this.f50274d);
        this.f50280j = new i(this.f50279i);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.f50272b.getOutputStream(), printStream);
        this.f50281k = traceOutputStream;
        traceOutputStream.setTrace(this.f50273c);
        this.f50281k.setQuote(this.f50274d);
        this.f50282l = new DataOutputStream(new BufferedOutputStream(this.f50281k));
    }

    public synchronized void a(h hVar) {
        if (this.f50284n == null) {
            this.f50284n = new Vector();
        }
        this.f50284n.addElement(hVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x001f -> B:12:0x0020). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.sun.mail.iap.g[] b(java.lang.String r5, com.sun.mail.iap.b r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Vector r0 = new java.util.Vector     // Catch: java.lang.Throwable -> L5a
            r0.<init>()     // Catch: java.lang.Throwable -> L5a
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r2 = r4.q(r5, r6)     // Catch: java.lang.Exception -> Le com.sun.mail.iap.LiteralException -> L17 java.lang.Throwable -> L5a
            goto L20
        Le:
            r5 = move-exception
            com.sun.mail.iap.g r5 = com.sun.mail.iap.g.a(r5)     // Catch: java.lang.Throwable -> L5a
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
            com.sun.mail.iap.g[] r5 = new com.sun.mail.iap.g[r5]     // Catch: java.lang.Throwable -> L5a
            r0.copyInto(r5)     // Catch: java.lang.Throwable -> L5a
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5a
            r4.f50285o = r0     // Catch: java.lang.Throwable -> L5a
            monitor-exit(r4)
            return r5
        L33:
            com.sun.mail.iap.g r5 = r4.l()     // Catch: com.sun.mail.iap.ProtocolException -> L38 java.io.IOException -> L3a java.lang.Throwable -> L5a
            goto L3f
        L38:
            goto L20
        L3a:
            r5 = move-exception
            com.sun.mail.iap.g r5 = com.sun.mail.iap.g.a(r5)     // Catch: java.lang.Throwable -> L5a
        L3f:
            r0.addElement(r5)     // Catch: java.lang.Throwable -> L5a
            boolean r6 = r5.e()     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L49
            r1 = 1
        L49:
            boolean r6 = r5.j()     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L20
            java.lang.String r5 = r5.c()     // Catch: java.lang.Throwable -> L5a
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
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.iap.f.b(java.lang.String, com.sun.mail.iap.b):com.sun.mail.iap.g[]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void c() {
        Socket socket = this.f50272b;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
            this.f50272b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i d() {
        return this.f50280j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OutputStream e() {
        return this.f50282l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d f() {
        return null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        c();
    }

    public long g() {
        return this.f50285o;
    }

    public void h(g gVar) throws ProtocolException {
        if (gVar.h()) {
            return;
        }
        if (!gVar.g()) {
            if (!gVar.d()) {
                if (gVar.e()) {
                    c();
                    throw new ConnectionException(this, gVar);
                }
                return;
            }
            throw new BadCommandException(gVar);
        }
        throw new CommandFailedException(gVar);
    }

    public void j(g[] gVarArr) {
        if (this.f50284n == null) {
            return;
        }
        for (g gVar : gVarArr) {
            if (gVar != null) {
                int size = this.f50284n.size();
                if (size == 0) {
                    return;
                }
                Object[] objArr = new Object[size];
                this.f50284n.copyInto(objArr);
                for (int i4 = 0; i4 < size; i4++) {
                    ((h) objArr[i4]).a(gVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(g gVar) throws ProtocolException {
        if (gVar.e()) {
            throw new ConnectionException(this, gVar);
        }
    }

    public g l() throws IOException, ProtocolException {
        return new g(this);
    }

    public synchronized void m(h hVar) {
        if (this.f50284n != null) {
            this.f50284n.removeElement(hVar);
        }
    }

    public void n(String str, b bVar) throws ProtocolException {
        g[] b4 = b(str, bVar);
        j(b4);
        h(b4[b4.length - 1]);
    }

    public synchronized void o(String str) throws IOException, ProtocolException {
        n(str, null);
        this.f50272b = SocketFetcher.startTLS(this.f50272b, this.f50276f, this.f50277g);
        i(this.f50275e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized boolean p() {
        return false;
    }

    public String q(String str, b bVar) throws IOException, ProtocolException {
        StringBuilder sb = new StringBuilder("A");
        int i4 = this.f50283m;
        this.f50283m = i4 + 1;
        sb.append(Integer.toString(i4, 10));
        String sb2 = sb.toString();
        DataOutputStream dataOutputStream = this.f50282l;
        dataOutputStream.writeBytes(String.valueOf(sb2) + " " + str);
        if (bVar != null) {
            this.f50282l.write(32);
            bVar.g(this);
        }
        this.f50282l.write(f50270p);
        this.f50282l.flush();
        return sb2;
    }

    public f(InputStream inputStream, OutputStream outputStream, boolean z3) throws IOException {
        this.f50278h = false;
        this.f50283m = 0;
        this.f50284n = null;
        this.f50271a = "localhost";
        this.f50273c = z3;
        this.f50274d = false;
        this.f50275e = System.out;
        TraceInputStream traceInputStream = new TraceInputStream(inputStream, System.out);
        this.f50279i = traceInputStream;
        traceInputStream.setTrace(z3);
        this.f50279i.setQuote(this.f50274d);
        this.f50280j = new i(this.f50279i);
        TraceOutputStream traceOutputStream = new TraceOutputStream(outputStream, System.out);
        this.f50281k = traceOutputStream;
        traceOutputStream.setTrace(z3);
        this.f50281k.setQuote(this.f50274d);
        this.f50282l = new DataOutputStream(new BufferedOutputStream(this.f50281k));
        this.f50285o = System.currentTimeMillis();
    }
}
