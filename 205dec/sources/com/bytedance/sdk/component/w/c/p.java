package com.bytedance.sdk.component.w.c;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class p {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f30411c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: w  reason: collision with root package name */
    private static final Pattern f30412w = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: f  reason: collision with root package name */
    private final String f30413f;
    private final String sr;
    private final String ux;
    private final String xv;

    public p(String str, String str2, String str3, String str4) {
        this.xv = str;
        this.sr = str2;
        this.ux = str3;
        this.f30413f = str4;
    }

    public static p c(String str) {
        Matcher matcher = f30411c.matcher(str);
        if (matcher.lookingAt()) {
            String group = matcher.group(1);
            Locale locale = Locale.US;
            String lowerCase = group.toLowerCase(locale);
            String lowerCase2 = matcher.group(2).toLowerCase(locale);
            Matcher matcher2 = f30412w.matcher(str);
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
            return new p(str, lowerCase, lowerCase2, str2);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof p) && ((p) obj).xv.equals(this.xv);
    }

    public int hashCode() {
        return this.xv.hashCode();
    }

    public String toString() {
        return this.xv;
    }

    public String w() {
        return this.ux;
    }

    public Charset xv() {
        return c((Charset) null);
    }

    public String c() {
        return this.sr;
    }

    public Charset c(Charset charset) {
        try {
            String str = this.f30413f;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
