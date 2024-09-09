package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: StatusLine.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final w f949a;

    /* renamed from: b  reason: collision with root package name */
    public final int f950b;

    /* renamed from: c  reason: collision with root package name */
    public final String f951c;

    public k(w wVar, int i4, String str) {
        this.f949a = wVar;
        this.f950b = i4;
        this.f951c = str;
    }

    public static k a(String str) throws IOException {
        w wVar;
        String str2;
        int i4 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() >= 9 && str.charAt(8) == ' ') {
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    wVar = w.HTTP_1_0;
                } else if (charAt == 1) {
                    wVar = w.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            wVar = w.HTTP_1_0;
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
                return new k(wVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
        throw new ProtocolException("Unexpected status line: " + str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f949a == w.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f950b);
        if (this.f951c != null) {
            sb.append(' ');
            sb.append(this.f951c);
        }
        return sb.toString();
    }
}
