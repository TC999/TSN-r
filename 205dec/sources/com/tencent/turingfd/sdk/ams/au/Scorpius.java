package com.tencent.turingfd.sdk.ams.au;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Scorpius {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f52170a = new ArrayList();

    public static synchronized List<String> a(ITuringPkgProvider iTuringPkgProvider) {
        List<String> list;
        List<String> a4;
        synchronized (Scorpius.class) {
            list = f52170a;
            ArrayList arrayList = (ArrayList) list;
            if (arrayList.isEmpty() && iTuringPkgProvider != null && (a4 = iTuringPkgProvider.a()) != null && !a4.isEmpty()) {
                arrayList.addAll(a4);
            }
        }
        return list;
    }

    public static String a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        try {
            for (String str : set) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(str);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
