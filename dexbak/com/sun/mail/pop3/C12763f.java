package com.sun.mail.pop3;

import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.SocketFetcher;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.StringTokenizer;
import kotlin.UByte;

/* compiled from: Protocol.java */
/* renamed from: com.sun.mail.pop3.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12763f {

    /* renamed from: g */
    private static final int f36219g = 110;

    /* renamed from: h */
    private static final String f36220h = "\r\n";

    /* renamed from: i */
    private static char[] f36221i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    private Socket f36222a;

    /* renamed from: b */
    private DataInputStream f36223b;

    /* renamed from: c */
    private PrintWriter f36224c;

    /* renamed from: d */
    private boolean f36225d;

    /* renamed from: e */
    private PrintStream f36226e;

    /* renamed from: f */
    private String f36227f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C12763f(String str, int i, boolean z, PrintStream printStream, Properties properties, String str2, boolean z2) throws IOException {
        this.f36227f = null;
        this.f36225d = z;
        this.f36226e = printStream;
        String property = properties.getProperty(String.valueOf(str2) + ".apop.enable");
        boolean z3 = property != null && property.equalsIgnoreCase("true");
        i = i == -1 ? 110 : i;
        if (z) {
            try {
                printStream.println("DEBUG POP3: connecting to host \"" + str + "\", port " + i + ", isSSL " + z2);
            } catch (IOException e) {
                try {
                    this.f36222a.close();
                } catch (Throwable unused) {
                }
                throw e;
            }
        }
        this.f36222a = SocketFetcher.getSocket(str, i, properties, str2, z2);
        this.f36223b = new DataInputStream(new BufferedInputStream(this.f36222a.getInputStream()));
        this.f36224c = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.f36222a.getOutputStream(), "iso-8859-1")));
        C12764g m16057k = m16057k(null);
        if (!m16057k.f36228a) {
            try {
                this.f36222a.close();
            } catch (Throwable unused2) {
            }
            throw new IOException("Connect failed");
        } else if (z3) {
            int indexOf = m16057k.f36229b.indexOf(60);
            int indexOf2 = m16057k.f36229b.indexOf(62, indexOf);
            if (indexOf != -1 && indexOf2 != -1) {
                this.f36227f = m16057k.f36229b.substring(indexOf, indexOf2 + 1);
            }
            if (z) {
                printStream.println("DEBUG POP3: APOP challenge: " + this.f36227f);
            }
        }
    }

    /* renamed from: b */
    private String m16066b(String str) {
        try {
            return m16055m(MessageDigest.getInstance("MD5").digest((String.valueOf(this.f36227f) + str).getBytes("iso-8859-1")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: f */
    private C12764g m16062f(String str, int i) throws IOException {
        int read;
        C12764g m16057k = m16057k(str);
        if (m16057k.f36228a) {
            C12765h c12765h = new C12765h(i);
            int i2 = 10;
            while (true) {
                read = this.f36223b.read();
                if (read < 0) {
                    break;
                }
                if (i2 == 10 && read == 46) {
                    if (this.f36225d) {
                        this.f36226e.write(read);
                    }
                    i2 = this.f36223b.read();
                    if (i2 == 13) {
                        if (this.f36225d) {
                            this.f36226e.write(i2);
                        }
                        read = this.f36223b.read();
                        if (this.f36225d) {
                            this.f36226e.write(read);
                        }
                    }
                } else {
                    i2 = read;
                }
                c12765h.write(i2);
                if (this.f36225d) {
                    this.f36226e.write(i2);
                }
            }
            if (read >= 0) {
                m16057k.f36230c = c12765h.m16051a();
                return m16057k;
            }
            throw new EOFException("EOF on socket");
        }
        return m16057k;
    }

    /* renamed from: k */
    private C12764g m16057k(String str) throws IOException {
        if (this.f36222a != null) {
            if (str != null) {
                if (this.f36225d) {
                    PrintStream printStream = this.f36226e;
                    printStream.println("C: " + str);
                }
                this.f36224c.print(str + f36220h);
                this.f36224c.flush();
            }
            String readLine = this.f36223b.readLine();
            if (readLine == null) {
                if (this.f36225d) {
                    this.f36226e.println("S: EOF");
                }
                throw new EOFException("EOF on socket");
            }
            if (this.f36225d) {
                PrintStream printStream2 = this.f36226e;
                printStream2.println("S: " + readLine);
            }
            C12764g c12764g = new C12764g();
            if (readLine.startsWith("+OK")) {
                c12764g.f36228a = true;
            } else if (readLine.startsWith("-ERR")) {
                c12764g.f36228a = false;
            } else {
                throw new IOException("Unexpected response: " + readLine);
            }
            int indexOf = readLine.indexOf(32);
            if (indexOf >= 0) {
                c12764g.f36229b = readLine.substring(indexOf + 1);
            }
            return c12764g;
        }
        throw new IOException("Folder is closed");
    }

    /* renamed from: m */
    private static String m16055m(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & UByte.f41242c;
            int i3 = i + 1;
            char[] cArr2 = f36221i;
            cArr[i] = cArr2[i2 >> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean m16067a(int i) throws IOException {
        return m16057k("DELE " + i).f36228a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized int m16065c(int i) throws IOException {
        int i2;
        C12764g m16057k = m16057k("LIST " + i);
        i2 = -1;
        if (m16057k.f36228a && m16057k.f36229b != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(m16057k.f36229b);
                stringTokenizer.nextToken();
                i2 = Integer.parseInt(stringTokenizer.nextToken());
            } catch (Exception unused) {
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized InputStream m16064d() throws IOException {
        return m16062f("LIST", 128).f36230c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized String m16063e(String str, String str2) throws IOException {
        C12764g m16057k;
        String m16066b = this.f36227f != null ? m16066b(str2) : null;
        if (this.f36227f != null && m16066b != null) {
            m16057k = m16057k("APOP " + str + " " + m16066b);
        } else {
            C12764g m16057k2 = m16057k("USER " + str);
            if (!m16057k2.f36228a) {
                String str3 = m16057k2.f36229b;
                if (str3 == null) {
                    str3 = "USER command failed";
                }
                return str3;
            }
            m16057k = m16057k("PASS " + str2);
        }
        if (m16057k.f36228a) {
            return null;
        }
        String str4 = m16057k.f36229b;
        if (str4 == null) {
            str4 = "login failed";
        }
        return str4;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.f36222a != null) {
            m16060h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public synchronized boolean m16061g() throws IOException {
        return m16057k("NOOP").f36228a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public synchronized boolean m16060h() throws IOException {
        boolean z;
        z = m16057k("QUIT").f36228a;
        this.f36222a.close();
        this.f36222a = null;
        this.f36223b = null;
        this.f36224c = null;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public synchronized InputStream m16059i(int i, int i2) throws IOException {
        return m16062f("RETR " + i, i2).f36230c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public synchronized boolean m16058j() throws IOException {
        return m16057k("RSET").f36228a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public synchronized C12766i m16056l() throws IOException {
        C12766i c12766i;
        C12764g m16057k = m16057k("STAT");
        c12766i = new C12766i();
        if (m16057k.f36228a && m16057k.f36229b != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(m16057k.f36229b);
                c12766i.f36231a = Integer.parseInt(stringTokenizer.nextToken());
                c12766i.f36232b = Integer.parseInt(stringTokenizer.nextToken());
            } catch (Exception unused) {
            }
        }
        return c12766i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public synchronized InputStream m16054n(int i, int i2) throws IOException {
        return m16062f("TOP " + i + " " + i2, 0).f36230c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public synchronized String m16053o(int i) throws IOException {
        C12764g m16057k = m16057k("UIDL " + i);
        if (m16057k.f36228a) {
            int indexOf = m16057k.f36229b.indexOf(32);
            if (indexOf > 0) {
                return m16057k.f36229b.substring(indexOf + 1);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public synchronized boolean m16052p(String[] strArr) throws IOException {
        int parseInt;
        C12764g m16062f = m16062f("UIDL", strArr.length * 15);
        if (!m16062f.f36228a) {
            return false;
        }
        LineInputStream lineInputStream = new LineInputStream(m16062f.f36230c);
        while (true) {
            String readLine = lineInputStream.readLine();
            if (readLine == null) {
                return true;
            }
            int indexOf = readLine.indexOf(32);
            if (indexOf >= 1 && indexOf < readLine.length() && (parseInt = Integer.parseInt(readLine.substring(0, indexOf))) > 0 && parseInt <= strArr.length) {
                strArr[parseInt - 1] = readLine.substring(indexOf + 1);
            }
        }
    }
}
