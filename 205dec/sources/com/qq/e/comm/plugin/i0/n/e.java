package com.qq.e.comm.plugin.i0.n;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.t2;
import com.qq.e.comm.plugin.util.v0;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f44402a;

    /* renamed from: b  reason: collision with root package name */
    private c f44403b;

    /* renamed from: c  reason: collision with root package name */
    public b f44404c;

    /* renamed from: d  reason: collision with root package name */
    private ByteArrayOutputStream f44405d;

    /* renamed from: e  reason: collision with root package name */
    private ByteArrayInputStream f44406e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f44407f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f44408g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f44410a;

        /* renamed from: b  reason: collision with root package name */
        public final int f44411b;

        /* renamed from: c  reason: collision with root package name */
        public final String f44412c;

        public c(String str, int i4, String str2) {
            this.f44410a = str;
            this.f44411b = i4;
            this.f44412c = str2;
        }

        public static c a(String str) throws IOException {
            String str2;
            String str3 = "HTTP/1.0";
            int i4 = 9;
            if (str.startsWith("HTTP/1.")) {
                if (str.length() >= 9 && str.charAt(8) == ' ') {
                    int charAt = str.charAt(7) - '0';
                    if (charAt != 0) {
                        if (charAt != 1) {
                            throw new ProtocolException("Unexpected status line: " + str);
                        }
                        str3 = "HTTP/1.1";
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                i4 = 4;
            }
            int i5 = i4 + 3;
            if (str.length() >= i5) {
                try {
                    int parseInt = Integer.parseInt(str.substring(i4, i5));
                    if (str.length() <= i5) {
                        str2 = "";
                    } else if (str.charAt(i5) == ' ') {
                        str2 = str.substring(i4 + 4);
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    return new c(str3, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            }
            throw new ProtocolException("Unexpected status line: " + str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f44410a);
            sb.append(' ');
            sb.append(this.f44411b);
            if (this.f44412c != null) {
                sb.append(' ');
                sb.append(this.f44412c);
            }
            return sb.toString();
        }
    }

    public e() {
        this.f44408g = true;
    }

    @Override // com.qq.e.comm.plugin.i0.n.g
    public InputStream a() throws IllegalStateException, IOException {
        return this.f44406e;
    }

    @Override // com.qq.e.comm.plugin.i0.n.g
    public String b() throws IllegalStateException, IOException {
        byte[] c4 = c();
        if (c4 == null) {
            return null;
        }
        return c4.length == 0 ? "" : new String(c4, com.qq.e.comm.plugin.k.a.f44515a);
    }

    public byte[] c() throws IllegalStateException, IOException {
        byte[] bArr = this.f44407f;
        return (bArr == null || bArr.length <= 0) ? new byte[0] : bArr;
    }

    @Override // com.qq.e.comm.plugin.i0.n.g
    public void close() throws IllegalStateException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.f44405d;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.close();
        }
        ByteArrayInputStream byteArrayInputStream = this.f44406e;
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
        }
    }

    public boolean d() {
        if (getStatusCode() != 204) {
            if (this.f44408g || !v0.a(getStatusCode())) {
                if ((!this.f44408g || !v0.a(getStatusCode())) && this.f44405d != null) {
                    String a4 = a("Content-Encoding");
                    if (!TextUtils.isEmpty(a4) && a4.contains("gzip")) {
                        byte[] b4 = t2.b(this.f44405d.toByteArray());
                        if (b4 != null) {
                            this.f44407f = b4;
                            this.f44406e = new ByteArrayInputStream(this.f44407f);
                            return true;
                        }
                    } else {
                        this.f44407f = this.f44405d.toByteArray();
                        this.f44406e = new ByteArrayInputStream(this.f44407f);
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean e() {
        return this.f44402a;
    }

    @Override // com.qq.e.comm.plugin.i0.n.g
    public int getStatusCode() {
        c cVar = this.f44403b;
        if (cVar != null) {
            return cVar.f44411b;
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.i0.n.g
    public String a(String str) {
        b bVar;
        if (!this.f44402a || (bVar = this.f44404c) == null) {
            return null;
        }
        return bVar.b(str);
    }

    public e(boolean z3) {
        this.f44408g = true;
        this.f44408g = z3;
    }

    public void a(byte[] bArr) throws IOException {
        if (!this.f44402a) {
            if (b(bArr)) {
                this.f44402a = true;
                return;
            }
            throw new IllegalArgumentException("http header parse error");
        }
        if (this.f44405d == null) {
            this.f44405d = new ByteArrayOutputStream();
        }
        this.f44405d.write(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f44409a;

        private b() {
            this.f44409a = new ArrayList(20);
        }

        b a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return a(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return a("", str.substring(1));
            }
            return a("", str);
        }

        public String b(String str) {
            for (int size = this.f44409a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f44409a.get(size))) {
                    return this.f44409a.get(size + 1);
                }
            }
            return null;
        }

        b a(String str, String str2) {
            this.f44409a.add(str);
            this.f44409a.add(str2.trim());
            return this;
        }
    }

    private boolean b(byte[] bArr) {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), com.qq.e.comm.plugin.k.a.f44515a));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (this.f44403b == null) {
                                this.f44403b = c.a(readLine);
                            } else {
                                if (this.f44404c == null) {
                                    this.f44404c = new b();
                                }
                                if (!TextUtils.equals("", readLine)) {
                                    this.f44404c.a(readLine);
                                }
                            }
                        } else {
                            try {
                                bufferedReader2.close();
                                return true;
                            } catch (IOException unused) {
                                return true;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        bufferedReader = bufferedReader2;
                        d1.a("gdt_tag_tquic", "\u89e3\u6790header\u5931\u8d25\uff0c\u539f\u56e0\uff1a%s", e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }
}
