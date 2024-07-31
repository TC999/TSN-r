package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.ILoggerFactory;
import org.slf4j.InterfaceC15424c;

/* renamed from: org.slf4j.impl.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class AndroidLoggerFactory implements ILoggerFactory {

    /* renamed from: b */
    static final String f44365b = "null";

    /* renamed from: c */
    static final int f44366c = 23;

    /* renamed from: a */
    private final ConcurrentMap<String, InterfaceC15424c> f44367a = new ConcurrentHashMap();

    /* renamed from: b */
    private static String m2556b(String str) {
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            int i = lastIndexOf + 1;
            if (length - i <= 23) {
                return str.substring(i);
            }
        }
        return '*' + str.substring((length - 23) + 1);
    }

    /* renamed from: c */
    static String m2555c(String str) {
        if (str == null) {
            return f44365b;
        }
        int length = str.length();
        if (length <= 23) {
            return str;
        }
        StringBuilder sb = new StringBuilder(26);
        int i = 0;
        int i2 = 0;
        do {
            int indexOf = str.indexOf(46, i);
            if (indexOf == -1) {
                int i3 = length - i;
                if (i2 != 0 && i2 + i3 <= 23) {
                    sb.append((CharSequence) str, i, length);
                    return sb.toString();
                }
                return m2556b(str);
            }
            sb.append(str.charAt(i));
            if (indexOf - i > 1) {
                sb.append('*');
            }
            sb.append('.');
            i = indexOf + 1;
            i2 = sb.length();
        } while (i2 <= 23);
        return m2556b(str);
    }

    @Override // org.slf4j.ILoggerFactory
    /* renamed from: a */
    public InterfaceC15424c mo2557a(String str) {
        String m2555c = m2555c(str);
        InterfaceC15424c interfaceC15424c = this.f44367a.get(m2555c);
        if (interfaceC15424c == null) {
            AndroidLoggerAdapter androidLoggerAdapter = new AndroidLoggerAdapter(m2555c);
            InterfaceC15424c putIfAbsent = this.f44367a.putIfAbsent(m2555c, androidLoggerAdapter);
            return putIfAbsent == null ? androidLoggerAdapter : putIfAbsent;
        }
        return interfaceC15424c;
    }
}
