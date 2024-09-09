package com.sun.mail.imap;

import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Rights.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private boolean[] f50467a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Rights.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        private static a[] f50468b = new a[128];

        /* renamed from: c  reason: collision with root package name */
        public static final a f50469c = a('l');

        /* renamed from: d  reason: collision with root package name */
        public static final a f50470d = a('r');

        /* renamed from: e  reason: collision with root package name */
        public static final a f50471e = a('s');

        /* renamed from: f  reason: collision with root package name */
        public static final a f50472f = a('w');

        /* renamed from: g  reason: collision with root package name */
        public static final a f50473g = a('i');

        /* renamed from: h  reason: collision with root package name */
        public static final a f50474h = a('p');

        /* renamed from: i  reason: collision with root package name */
        public static final a f50475i = a('c');

        /* renamed from: j  reason: collision with root package name */
        public static final a f50476j = a('d');

        /* renamed from: k  reason: collision with root package name */
        public static final a f50477k = a('a');

        /* renamed from: a  reason: collision with root package name */
        char f50478a;

        private a(char c4) {
            if (c4 < '\u0080') {
                this.f50478a = c4;
                return;
            }
            throw new IllegalArgumentException("Right must be ASCII");
        }

        public static synchronized a a(char c4) {
            a aVar;
            synchronized (a.class) {
                if (c4 < '\u0080') {
                    a[] aVarArr = f50468b;
                    if (aVarArr[c4] == null) {
                        aVarArr[c4] = new a(c4);
                    }
                    aVar = f50468b[c4];
                } else {
                    throw new IllegalArgumentException("Right must be ASCII");
                }
            }
            return aVar;
        }

        public String toString() {
            return String.valueOf(this.f50478a);
        }
    }

    public n() {
        this.f50467a = new boolean[128];
    }

    public void a(a aVar) {
        this.f50467a[aVar.f50478a] = true;
    }

    public void b(n nVar) {
        int i4 = 0;
        while (true) {
            boolean[] zArr = nVar.f50467a;
            if (i4 >= zArr.length) {
                return;
            }
            if (zArr[i4]) {
                this.f50467a[i4] = true;
            }
            i4++;
        }
    }

    public boolean c(a aVar) {
        return this.f50467a[aVar.f50478a];
    }

    public Object clone() {
        n nVar = null;
        try {
            n nVar2 = (n) super.clone();
            try {
                boolean[] zArr = new boolean[128];
                nVar2.f50467a = zArr;
                boolean[] zArr2 = this.f50467a;
                System.arraycopy(zArr2, 0, zArr, 0, zArr2.length);
                return nVar2;
            } catch (CloneNotSupportedException unused) {
                nVar = nVar2;
                return nVar;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public boolean d(n nVar) {
        int i4 = 0;
        while (true) {
            boolean[] zArr = nVar.f50467a;
            if (i4 >= zArr.length) {
                return true;
            }
            if (zArr[i4] && !this.f50467a[i4]) {
                return false;
            }
            i4++;
        }
    }

    public a[] e() {
        Vector vector = new Vector();
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.f50467a;
            if (i4 >= zArr.length) {
                a[] aVarArr = new a[vector.size()];
                vector.copyInto(aVarArr);
                return aVarArr;
            }
            if (zArr[i4]) {
                vector.addElement(a.a((char) i4));
            }
            i4++;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        int i4 = 0;
        while (true) {
            boolean[] zArr = nVar.f50467a;
            if (i4 >= zArr.length) {
                return true;
            }
            if (zArr[i4] != this.f50467a[i4]) {
                return false;
            }
            i4++;
        }
    }

    public void f(a aVar) {
        this.f50467a[aVar.f50478a] = false;
    }

    public void g(n nVar) {
        int i4 = 0;
        while (true) {
            boolean[] zArr = nVar.f50467a;
            if (i4 >= zArr.length) {
                return;
            }
            if (zArr[i4]) {
                this.f50467a[i4] = false;
            }
            i4++;
        }
    }

    public int hashCode() {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean[] zArr = this.f50467a;
            if (i4 >= zArr.length) {
                return i5;
            }
            if (zArr[i4]) {
                i5++;
            }
            i4++;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.f50467a;
            if (i4 >= zArr.length) {
                return stringBuffer.toString();
            }
            if (zArr[i4]) {
                stringBuffer.append((char) i4);
            }
            i4++;
        }
    }

    public n(n nVar) {
        boolean[] zArr = new boolean[128];
        this.f50467a = zArr;
        System.arraycopy(nVar.f50467a, 0, zArr, 0, zArr.length);
    }

    public n(String str) {
        this.f50467a = new boolean[128];
        for (int i4 = 0; i4 < str.length(); i4++) {
            a(a.a(str.charAt(i4)));
        }
    }

    public n(a aVar) {
        boolean[] zArr = new boolean[128];
        this.f50467a = zArr;
        zArr[aVar.f50478a] = true;
    }
}
