package com.sun.activation.registries;

import java.util.NoSuchElementException;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: MimeTypeFile.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class a {

    /* renamed from: e  reason: collision with root package name */
    private static final String f50233e = "=";

    /* renamed from: b  reason: collision with root package name */
    private int f50235b;

    /* renamed from: c  reason: collision with root package name */
    private String f50236c;

    /* renamed from: d  reason: collision with root package name */
    private Vector f50237d = new Vector();

    /* renamed from: a  reason: collision with root package name */
    private int f50234a = 0;

    public a(String str) {
        this.f50236c = str;
        this.f50235b = str.length();
    }

    private void d() {
        while (true) {
            int i4 = this.f50234a;
            if (i4 >= this.f50235b || !Character.isWhitespace(this.f50236c.charAt(i4))) {
                return;
            }
            this.f50234a++;
        }
    }

    public boolean a() {
        if (this.f50237d.size() > 0) {
            return true;
        }
        d();
        return this.f50234a < this.f50235b;
    }

    public String b() {
        int size = this.f50237d.size();
        if (size > 0) {
            int i4 = size - 1;
            String str = (String) this.f50237d.elementAt(i4);
            this.f50237d.removeElementAt(i4);
            return str;
        }
        d();
        int i5 = this.f50234a;
        if (i5 < this.f50235b) {
            char charAt = this.f50236c.charAt(i5);
            if (charAt == '\"') {
                this.f50234a++;
                boolean z3 = false;
                while (true) {
                    int i6 = this.f50234a;
                    if (i6 >= this.f50235b) {
                        break;
                    }
                    String str2 = this.f50236c;
                    this.f50234a = i6 + 1;
                    char charAt2 = str2.charAt(i6);
                    if (charAt2 == '\\') {
                        this.f50234a++;
                        z3 = true;
                    } else if (charAt2 == '\"') {
                        if (z3) {
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i7 = i5 + 1; i7 < this.f50234a - 1; i7++) {
                                char charAt3 = this.f50236c.charAt(i7);
                                if (charAt3 != '\\') {
                                    stringBuffer.append(charAt3);
                                }
                            }
                            return stringBuffer.toString();
                        }
                        return this.f50236c.substring(i5 + 1, this.f50234a - 1);
                    }
                }
            } else if ("=".indexOf(charAt) < 0) {
                while (true) {
                    int i8 = this.f50234a;
                    if (i8 >= this.f50235b || "=".indexOf(this.f50236c.charAt(i8)) >= 0 || Character.isWhitespace(this.f50236c.charAt(this.f50234a))) {
                        break;
                    }
                    this.f50234a++;
                }
            } else {
                this.f50234a++;
            }
            return this.f50236c.substring(i5, this.f50234a);
        }
        throw new NoSuchElementException();
    }

    public void c(String str) {
        this.f50237d.addElement(str);
    }
}
