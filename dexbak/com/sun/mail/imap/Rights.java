package com.sun.mail.imap;

import java.util.Vector;

/* renamed from: com.sun.mail.imap.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Rights implements Cloneable {

    /* renamed from: a */
    private boolean[] f36055a;

    /* compiled from: Rights.java */
    /* renamed from: com.sun.mail.imap.n$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C12756a {

        /* renamed from: b */
        private static C12756a[] f36056b = new C12756a[128];

        /* renamed from: c */
        public static final C12756a f36057c = m16231a('l');

        /* renamed from: d */
        public static final C12756a f36058d = m16231a('r');

        /* renamed from: e */
        public static final C12756a f36059e = m16231a('s');

        /* renamed from: f */
        public static final C12756a f36060f = m16231a('w');

        /* renamed from: g */
        public static final C12756a f36061g = m16231a('i');

        /* renamed from: h */
        public static final C12756a f36062h = m16231a('p');

        /* renamed from: i */
        public static final C12756a f36063i = m16231a('c');

        /* renamed from: j */
        public static final C12756a f36064j = m16231a('d');

        /* renamed from: k */
        public static final C12756a f36065k = m16231a('a');

        /* renamed from: a */
        char f36066a;

        private C12756a(char c) {
            if (c < 128) {
                this.f36066a = c;
                return;
            }
            throw new IllegalArgumentException("Right must be ASCII");
        }

        /* renamed from: a */
        public static synchronized C12756a m16231a(char c) {
            C12756a c12756a;
            synchronized (C12756a.class) {
                if (c < 128) {
                    C12756a[] c12756aArr = f36056b;
                    if (c12756aArr[c] == null) {
                        c12756aArr[c] = new C12756a(c);
                    }
                    c12756a = f36056b[c];
                } else {
                    throw new IllegalArgumentException("Right must be ASCII");
                }
            }
            return c12756a;
        }

        public String toString() {
            return String.valueOf(this.f36066a);
        }
    }

    public Rights() {
        this.f36055a = new boolean[128];
    }

    /* renamed from: a */
    public void m16238a(C12756a c12756a) {
        this.f36055a[c12756a.f36066a] = true;
    }

    /* renamed from: b */
    public void m16237b(Rights rights) {
        int i = 0;
        while (true) {
            boolean[] zArr = rights.f36055a;
            if (i >= zArr.length) {
                return;
            }
            if (zArr[i]) {
                this.f36055a[i] = true;
            }
            i++;
        }
    }

    /* renamed from: c */
    public boolean m16236c(C12756a c12756a) {
        return this.f36055a[c12756a.f36066a];
    }

    public Object clone() {
        Rights rights = null;
        try {
            Rights rights2 = (Rights) super.clone();
            try {
                boolean[] zArr = new boolean[128];
                rights2.f36055a = zArr;
                boolean[] zArr2 = this.f36055a;
                System.arraycopy(zArr2, 0, zArr, 0, zArr2.length);
                return rights2;
            } catch (CloneNotSupportedException unused) {
                rights = rights2;
                return rights;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    /* renamed from: d */
    public boolean m16235d(Rights rights) {
        int i = 0;
        while (true) {
            boolean[] zArr = rights.f36055a;
            if (i >= zArr.length) {
                return true;
            }
            if (zArr[i] && !this.f36055a[i]) {
                return false;
            }
            i++;
        }
    }

    /* renamed from: e */
    public C12756a[] m16234e() {
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            boolean[] zArr = this.f36055a;
            if (i >= zArr.length) {
                C12756a[] c12756aArr = new C12756a[vector.size()];
                vector.copyInto(c12756aArr);
                return c12756aArr;
            }
            if (zArr[i]) {
                vector.addElement(C12756a.m16231a((char) i));
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rights)) {
            return false;
        }
        Rights rights = (Rights) obj;
        int i = 0;
        while (true) {
            boolean[] zArr = rights.f36055a;
            if (i >= zArr.length) {
                return true;
            }
            if (zArr[i] != this.f36055a[i]) {
                return false;
            }
            i++;
        }
    }

    /* renamed from: f */
    public void m16233f(C12756a c12756a) {
        this.f36055a[c12756a.f36066a] = false;
    }

    /* renamed from: g */
    public void m16232g(Rights rights) {
        int i = 0;
        while (true) {
            boolean[] zArr = rights.f36055a;
            if (i >= zArr.length) {
                return;
            }
            if (zArr[i]) {
                this.f36055a[i] = false;
            }
            i++;
        }
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.f36055a;
            if (i >= zArr.length) {
                return i2;
            }
            if (zArr[i]) {
                i2++;
            }
            i++;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            boolean[] zArr = this.f36055a;
            if (i >= zArr.length) {
                return stringBuffer.toString();
            }
            if (zArr[i]) {
                stringBuffer.append((char) i);
            }
            i++;
        }
    }

    public Rights(Rights rights) {
        boolean[] zArr = new boolean[128];
        this.f36055a = zArr;
        System.arraycopy(rights.f36055a, 0, zArr, 0, zArr.length);
    }

    public Rights(String str) {
        this.f36055a = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            m16238a(C12756a.m16231a(str.charAt(i)));
        }
    }

    public Rights(C12756a c12756a) {
        boolean[] zArr = new boolean[128];
        this.f36055a = zArr;
        zArr[c12756a.f36066a] = true;
    }
}
