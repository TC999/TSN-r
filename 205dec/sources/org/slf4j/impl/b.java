package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AndroidLoggerFactory.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class b implements org.slf4j.a {

    /* renamed from: b  reason: collision with root package name */
    static final String f61765b = "null";

    /* renamed from: c  reason: collision with root package name */
    static final int f61766c = 23;

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentMap<String, org.slf4j.c> f61767a = new ConcurrentHashMap();

    private static String b(String str) {
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            int i4 = lastIndexOf + 1;
            if (length - i4 <= 23) {
                return str.substring(i4);
            }
        }
        return '*' + str.substring((length - 23) + 1);
    }

    static String c(String str) {
        if (str == null) {
            return "null";
        }
        int length = str.length();
        if (length <= 23) {
            return str;
        }
        StringBuilder sb = new StringBuilder(26);
        int i4 = 0;
        int i5 = 0;
        do {
            int indexOf = str.indexOf(46, i4);
            if (indexOf == -1) {
                int i6 = length - i4;
                if (i5 != 0 && i5 + i6 <= 23) {
                    sb.append((CharSequence) str, i4, length);
                    return sb.toString();
                }
                return b(str);
            }
            sb.append(str.charAt(i4));
            if (indexOf - i4 > 1) {
                sb.append('*');
            }
            sb.append('.');
            i4 = indexOf + 1;
            i5 = sb.length();
        } while (i5 <= 23);
        return b(str);
    }

    @Override // org.slf4j.a
    public org.slf4j.c a(String str) {
        String c4 = c(str);
        org.slf4j.c cVar = this.f61767a.get(c4);
        if (cVar == null) {
            a aVar = new a(c4);
            org.slf4j.c putIfAbsent = this.f61767a.putIfAbsent(c4, aVar);
            return putIfAbsent == null ? aVar : putIfAbsent;
        }
        return cVar;
    }
}
