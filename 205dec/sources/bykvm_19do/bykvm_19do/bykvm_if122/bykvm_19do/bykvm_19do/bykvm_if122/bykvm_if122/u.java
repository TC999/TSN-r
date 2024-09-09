package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MediaType.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class u {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f1375c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f1376d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a  reason: collision with root package name */
    private final String f1377a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1378b;

    private u(String str, String str2, String str3, String str4) {
        this.f1377a = str;
        this.f1378b = str4;
    }

    public static u a(String str) {
        Matcher matcher = f1375c.matcher(str);
        if (matcher.lookingAt()) {
            String group = matcher.group(1);
            Locale locale = Locale.US;
            String lowerCase = group.toLowerCase(locale);
            String lowerCase2 = matcher.group(2).toLowerCase(locale);
            Matcher matcher2 = f1376d.matcher(str);
            String str2 = null;
            for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                matcher2.region(end, str.length());
                if (!matcher2.lookingAt()) {
                    return null;
                }
                String group2 = matcher2.group(1);
                if (group2 != null && group2.equalsIgnoreCase("charset")) {
                    String group3 = matcher2.group(2);
                    if (group3 != null) {
                        if (group3.startsWith("'") && group3.endsWith("'") && group3.length() > 2) {
                            group3 = group3.substring(1, group3.length() - 1);
                        }
                    } else {
                        group3 = matcher2.group(3);
                    }
                    if (str2 != null && !group3.equalsIgnoreCase(str2)) {
                        return null;
                    }
                    str2 = group3;
                }
            }
            return new u(str, lowerCase, lowerCase2, str2);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && ((u) obj).f1377a.equals(this.f1377a);
    }

    public int hashCode() {
        return this.f1377a.hashCode();
    }

    public String toString() {
        return this.f1377a;
    }

    public Charset a() {
        return a((Charset) null);
    }

    public Charset a(Charset charset) {
        try {
            String str = this.f1378b;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
