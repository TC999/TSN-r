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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Protocol.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class f {

    /* renamed from: g  reason: collision with root package name */
    private static final int f50629g = 110;

    /* renamed from: h  reason: collision with root package name */
    private static final String f50630h = "\r\n";

    /* renamed from: i  reason: collision with root package name */
    private static char[] f50631i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a  reason: collision with root package name */
    private Socket f50632a;

    /* renamed from: b  reason: collision with root package name */
    private DataInputStream f50633b;

    /* renamed from: c  reason: collision with root package name */
    private PrintWriter f50634c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f50635d;

    /* renamed from: e  reason: collision with root package name */
    private PrintStream f50636e;

    /* renamed from: f  reason: collision with root package name */
    private String f50637f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str, int i4, boolean z3, PrintStream printStream, Properties properties, String str2, boolean z4) throws IOException {
        this.f50637f = null;
        this.f50635d = z3;
        this.f50636e = printStream;
        String property = properties.getProperty(String.valueOf(str2) + ".apop.enable");
        boolean z5 = property != null && property.equalsIgnoreCase("true");
        i4 = i4 == -1 ? 110 : i4;
        if (z3) {
            try {
                printStream.println("DEBUG POP3: connecting to host \"" + str + "\", port " + i4 + ", isSSL " + z4);
            } catch (IOException e4) {
                try {
                    this.f50632a.close();
                } catch (Throwable unused) {
                }
                throw e4;
            }
        }
        this.f50632a = SocketFetcher.getSocket(str, i4, properties, str2, z4);
        this.f50633b = new DataInputStream(new BufferedInputStream(this.f50632a.getInputStream()));
        this.f50634c = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.f50632a.getOutputStream(), "iso-8859-1")));
        g k4 = k(null);
        if (!k4.f50638a) {
            try {
                this.f50632a.close();
            } catch (Throwable unused2) {
            }
            throw new IOException("Connect failed");
        } else if (z5) {
            int indexOf = k4.f50639b.indexOf(60);
            int indexOf2 = k4.f50639b.indexOf(62, indexOf);
            if (indexOf != -1 && indexOf2 != -1) {
                this.f50637f = k4.f50639b.substring(indexOf, indexOf2 + 1);
            }
            if (z3) {
                printStream.println("DEBUG POP3: APOP challenge: " + this.f50637f);
            }
        }
    }

    private String b(String str) {
        try {
            return m(MessageDigest.getInstance("MD5").digest((String.valueOf(this.f50637f) + str).getBytes("iso-8859-1")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private g f(String str, int i4) throws IOException {
        int read;
        g k4 = k(str);
        if (k4.f50638a) {
            h hVar = new h(i4);
            int i5 = 10;
            while (true) {
                read = this.f50633b.read();
                if (read < 0) {
                    break;
                }
                if (i5 == 10 && read == 46) {
                    if (this.f50635d) {
                        this.f50636e.write(read);
                    }
                    i5 = this.f50633b.read();
                    if (i5 == 13) {
                        if (this.f50635d) {
                            this.f50636e.write(i5);
                        }
                        read = this.f50633b.read();
                        if (this.f50635d) {
                            this.f50636e.write(read);
                        }
                    }
                } else {
                    i5 = read;
                }
                hVar.write(i5);
                if (this.f50635d) {
                    this.f50636e.write(i5);
                }
            }
            if (read >= 0) {
                k4.f50640c = hVar.a();
                return k4;
            }
            throw new EOFException("EOF on socket");
        }
        return k4;
    }

    private g k(String str) throws IOException {
        if (this.f50632a != null) {
            if (str != null) {
                if (this.f50635d) {
                    PrintStream printStream = this.f50636e;
                    printStream.println("C: " + str);
                }
                this.f50634c.print(str + "\r\n");
                this.f50634c.flush();
            }
            String readLine = this.f50633b.readLine();
            if (readLine == null) {
                if (this.f50635d) {
                    this.f50636e.println("S: EOF");
                }
                throw new EOFException("EOF on socket");
            }
            if (this.f50635d) {
                PrintStream printStream2 = this.f50636e;
                printStream2.println("S: " + readLine);
            }
            g gVar = new g();
            if (readLine.startsWith("+OK")) {
                gVar.f50638a = true;
            } else if (readLine.startsWith("-ERR")) {
                gVar.f50638a = false;
            } else {
                throw new IOException("Unexpected response: " + readLine);
            }
            int indexOf = readLine.indexOf(32);
            if (indexOf >= 0) {
                gVar.f50639b = readLine.substring(indexOf + 1);
            }
            return gVar;
        }
        throw new IOException("Folder is closed");
    }

    private static String m(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = b4 & 255;
            int i6 = i4 + 1;
            char[] cArr2 = f50631i;
            cArr[i4] = cArr2[i5 >> 4];
            i4 = i6 + 1;
            cArr[i6] = cArr2[i5 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean a(int i4) throws IOException {
        return k("DELE " + i4).f50638a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int c(int i4) throws IOException {
        int i5;
        g k4 = k("LIST " + i4);
        i5 = -1;
        if (k4.f50638a && k4.f50639b != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(k4.f50639b);
                stringTokenizer.nextToken();
                i5 = Integer.parseInt(stringTokenizer.nextToken());
            } catch (Exception unused) {
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized InputStream d() throws IOException {
        return f("LIST", 128).f50640c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String e(String str, String str2) throws IOException {
        g k4;
        String b4 = this.f50637f != null ? b(str2) : null;
        if (this.f50637f != null && b4 != null) {
            k4 = k("APOP " + str + " " + b4);
        } else {
            g k5 = k("USER " + str);
            if (!k5.f50638a) {
                String str3 = k5.f50639b;
                if (str3 == null) {
                    str3 = "USER command failed";
                }
                return str3;
            }
            k4 = k("PASS " + str2);
        }
        if (k4.f50638a) {
            return null;
        }
        String str4 = k4.f50639b;
        if (str4 == null) {
            str4 = "login failed";
        }
        return str4;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.f50632a != null) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean g() throws IOException {
        return k("NOOP").f50638a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean h() throws IOException {
        boolean z3;
        z3 = k("QUIT").f50638a;
        this.f50632a.close();
        this.f50632a = null;
        this.f50633b = null;
        this.f50634c = null;
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized InputStream i(int i4, int i5) throws IOException {
        return f("RETR " + i4, i5).f50640c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean j() throws IOException {
        return k("RSET").f50638a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized i l() throws IOException {
        i iVar;
        g k4 = k("STAT");
        iVar = new i();
        if (k4.f50638a && k4.f50639b != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(k4.f50639b);
                iVar.f50641a = Integer.parseInt(stringTokenizer.nextToken());
                iVar.f50642b = Integer.parseInt(stringTokenizer.nextToken());
            } catch (Exception unused) {
            }
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized InputStream n(int i4, int i5) throws IOException {
        return f("TOP " + i4 + " " + i5, 0).f50640c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String o(int i4) throws IOException {
        g k4 = k("UIDL " + i4);
        if (k4.f50638a) {
            int indexOf = k4.f50639b.indexOf(32);
            if (indexOf > 0) {
                return k4.f50639b.substring(indexOf + 1);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean p(String[] strArr) throws IOException {
        int parseInt;
        g f4 = f("UIDL", strArr.length * 15);
        if (!f4.f50638a) {
            return false;
        }
        LineInputStream lineInputStream = new LineInputStream(f4.f50640c);
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
