package com.bytedance.sdk.component.xv.w.c.xv;

import com.bytedance.sdk.component.xv.w.ls;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public final ls f30953c;

    /* renamed from: w  reason: collision with root package name */
    public final int f30954w;
    public final String xv;

    public k(ls lsVar, int i4, String str) {
        this.f30953c = lsVar;
        this.f30954w = i4;
        this.xv = str;
    }

    public static k c(String str) throws IOException {
        ls lsVar;
        String str2;
        int i4 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() >= 9 && str.charAt(8) == ' ') {
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    lsVar = ls.HTTP_1_0;
                } else if (charAt == 1) {
                    lsVar = ls.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            lsVar = ls.HTTP_1_0;
            i4 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
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
                return new k(lsVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
        throw new ProtocolException("Unexpected status line: " + str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f30953c == ls.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f30954w);
        if (this.xv != null) {
            sb.append(' ');
            sb.append(this.xv);
        }
        return sb.toString();
    }
}
