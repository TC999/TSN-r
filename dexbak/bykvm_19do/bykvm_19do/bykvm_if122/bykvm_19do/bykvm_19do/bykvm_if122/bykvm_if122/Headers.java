package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Headers {

    /* renamed from: a */
    private final String[] f1357a;

    Headers(C1076a c1076a) {
        List<String> list = c1076a.f1358a;
        this.f1357a = (String[]) list.toArray(new String[list.size()]);
    }

    /* renamed from: a */
    public String m58340a(String str) {
        return m58339a(this.f1357a, str);
    }

    /* renamed from: b */
    public int m58338b() {
        return this.f1357a.length / 2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).f1357a, this.f1357a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f1357a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int m58338b = m58338b();
        for (int i = 0; i < m58338b; i++) {
            sb.append(m58341a(i));
            sb.append(": ");
            sb.append(m58337b(i));
            sb.append(ShellAdbUtils.f33810d);
        }
        return sb.toString();
    }

    /* compiled from: Headers.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1076a {

        /* renamed from: a */
        final List<String> f1358a = new ArrayList(20);

        /* renamed from: d */
        private void m58329d(String str, String str2) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i = 0; i < length; i++) {
                        char charAt = str.charAt(i);
                        if (charAt <= ' ' || charAt >= 127) {
                            throw new IllegalArgumentException(C1061c.m58464a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                        }
                    }
                    if (str2 != null) {
                        int length2 = str2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            char charAt2 = str2.charAt(i2);
                            if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                                throw new IllegalArgumentException(C1061c.m58464a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                            }
                        }
                        return;
                    }
                    throw new NullPointerException("value for name " + str + " == null");
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new NullPointerException("name == null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public C1076a m58334a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return m58331b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return m58331b("", str.substring(1));
            }
            return m58331b("", str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public C1076a m58331b(String str, String str2) {
            this.f1358a.add(str);
            this.f1358a.add(str2.trim());
            return this;
        }

        /* renamed from: c */
        public C1076a m58330c(String str, String str2) {
            try {
                m58329d(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char charAt = str2.charAt(i);
                            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                            } else {
                                sb.append(charAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return this;
                    }
                }
                return this;
            }
            m58332b(str);
            m58331b(str, str2);
            return this;
        }

        /* renamed from: b */
        public C1076a m58332b(String str) {
            int i = 0;
            while (i < this.f1358a.size()) {
                if (str.equalsIgnoreCase(this.f1358a.get(i))) {
                    this.f1358a.remove(i);
                    this.f1358a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: a */
        public C1076a m58333a(String str, String str2) {
            try {
                m58329d(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char charAt = str2.charAt(i);
                            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                            } else {
                                sb.append(charAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return this;
                    }
                }
                return this;
            }
            return m58331b(str, str2);
        }

        /* renamed from: a */
        public Headers m58335a() {
            return new Headers(this);
        }
    }

    /* renamed from: a */
    public String m58341a(int i) {
        return this.f1357a[i * 2];
    }

    /* renamed from: b */
    public String m58337b(int i) {
        return this.f1357a[(i * 2) + 1];
    }

    /* renamed from: a */
    public C1076a m58342a() {
        C1076a c1076a = new C1076a();
        Collections.addAll(c1076a.f1358a, this.f1357a);
        return c1076a;
    }

    /* renamed from: b */
    public List<String> m58336b(String str) {
        int m58338b = m58338b();
        ArrayList arrayList = null;
        for (int i = 0; i < m58338b; i++) {
            if (str.equalsIgnoreCase(m58341a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m58337b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: a */
    private static String m58339a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }
}
