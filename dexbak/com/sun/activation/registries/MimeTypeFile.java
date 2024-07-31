package com.sun.activation.registries;

import java.util.NoSuchElementException;
import java.util.Vector;

/* renamed from: com.sun.activation.registries.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class MimeTypeFile {

    /* renamed from: e */
    private static final String f35812e = "=";

    /* renamed from: b */
    private int f35814b;

    /* renamed from: c */
    private String f35815c;

    /* renamed from: d */
    private Vector f35816d = new Vector();

    /* renamed from: a */
    private int f35813a = 0;

    public MimeTypeFile(String str) {
        this.f35815c = str;
        this.f35814b = str.length();
    }

    /* renamed from: d */
    private void m16478d() {
        while (true) {
            int i = this.f35813a;
            if (i >= this.f35814b || !Character.isWhitespace(this.f35815c.charAt(i))) {
                return;
            }
            this.f35813a++;
        }
    }

    /* renamed from: a */
    public boolean m16481a() {
        if (this.f35816d.size() > 0) {
            return true;
        }
        m16478d();
        return this.f35813a < this.f35814b;
    }

    /* renamed from: b */
    public String m16480b() {
        int size = this.f35816d.size();
        if (size > 0) {
            int i = size - 1;
            String str = (String) this.f35816d.elementAt(i);
            this.f35816d.removeElementAt(i);
            return str;
        }
        m16478d();
        int i2 = this.f35813a;
        if (i2 < this.f35814b) {
            char charAt = this.f35815c.charAt(i2);
            if (charAt == '\"') {
                this.f35813a++;
                boolean z = false;
                while (true) {
                    int i3 = this.f35813a;
                    if (i3 >= this.f35814b) {
                        break;
                    }
                    String str2 = this.f35815c;
                    this.f35813a = i3 + 1;
                    char charAt2 = str2.charAt(i3);
                    if (charAt2 == '\\') {
                        this.f35813a++;
                        z = true;
                    } else if (charAt2 == '\"') {
                        if (z) {
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i4 = i2 + 1; i4 < this.f35813a - 1; i4++) {
                                char charAt3 = this.f35815c.charAt(i4);
                                if (charAt3 != '\\') {
                                    stringBuffer.append(charAt3);
                                }
                            }
                            return stringBuffer.toString();
                        }
                        return this.f35815c.substring(i2 + 1, this.f35813a - 1);
                    }
                }
            } else if (f35812e.indexOf(charAt) < 0) {
                while (true) {
                    int i5 = this.f35813a;
                    if (i5 >= this.f35814b || f35812e.indexOf(this.f35815c.charAt(i5)) >= 0 || Character.isWhitespace(this.f35815c.charAt(this.f35813a))) {
                        break;
                    }
                    this.f35813a++;
                }
            } else {
                this.f35813a++;
            }
            return this.f35815c.substring(i2, this.f35813a);
        }
        throw new NoSuchElementException();
    }

    /* renamed from: c */
    public void m16479c(String str) {
        this.f35816d.addElement(str);
    }
}
