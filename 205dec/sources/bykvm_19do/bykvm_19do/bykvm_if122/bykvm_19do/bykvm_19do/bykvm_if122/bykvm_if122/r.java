package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Headers.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f1350a;

    r(a aVar) {
        List<String> list = aVar.f1351a;
        this.f1350a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(String str) {
        return a(this.f1350a, str);
    }

    public int b() {
        return this.f1350a.length / 2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && Arrays.equals(((r) obj).f1350a, this.f1350a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f1350a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b4 = b();
        for (int i4 = 0; i4 < b4; i4++) {
            sb.append(a(i4));
            sb.append(": ");
            sb.append(b(i4));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* compiled from: Headers.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f1351a = new ArrayList(20);

        private void d(String str, String str2) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        char charAt = str.charAt(i4);
                        if (charAt <= ' ' || charAt >= '\u007f') {
                            throw new IllegalArgumentException(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i4), str));
                        }
                    }
                    if (str2 != null) {
                        int length2 = str2.length();
                        for (int i5 = 0; i5 < length2; i5++) {
                            char charAt2 = str2.charAt(i5);
                            if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= '\u007f') {
                                throw new IllegalArgumentException(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i5), str, str2));
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
        public a a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return b("", str.substring(1));
            }
            return b("", str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a b(String str, String str2) {
            this.f1351a.add(str);
            this.f1351a.add(str2.trim());
            return this;
        }

        public a c(String str, String str2) {
            try {
                d(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            char charAt = str2.charAt(i4);
                            if ((charAt <= 31 && charAt != '\t') || charAt >= '\u007f') {
                                sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                            } else {
                                sb.append(charAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e4) {
                        e4.printStackTrace();
                        return this;
                    }
                }
                return this;
            }
            b(str);
            b(str, str2);
            return this;
        }

        public a b(String str) {
            int i4 = 0;
            while (i4 < this.f1351a.size()) {
                if (str.equalsIgnoreCase(this.f1351a.get(i4))) {
                    this.f1351a.remove(i4);
                    this.f1351a.remove(i4);
                    i4 -= 2;
                }
                i4 += 2;
            }
            return this;
        }

        public a a(String str, String str2) {
            try {
                d(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            char charAt = str2.charAt(i4);
                            if ((charAt <= 31 && charAt != '\t') || charAt >= '\u007f') {
                                sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                            } else {
                                sb.append(charAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e4) {
                        e4.printStackTrace();
                        return this;
                    }
                }
                return this;
            }
            return b(str, str2);
        }

        public r a() {
            return new r(this);
        }
    }

    public String a(int i4) {
        return this.f1350a[i4 * 2];
    }

    public String b(int i4) {
        return this.f1350a[(i4 * 2) + 1];
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f1351a, this.f1350a);
        return aVar;
    }

    public List<String> b(String str) {
        int b4 = b();
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < b4; i4++) {
            if (str.equalsIgnoreCase(a(i4))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i4));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }
}
