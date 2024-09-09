package com.tencent.turingfd.sdk.ams.au;

import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.protected  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cprotected {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f52344a = new LinkedHashSet();

    public static int a() {
        Set<String> set = f52344a;
        if (set.isEmpty()) {
            set.add(Cextends.a(Cextends.T0));
            set.add(Cextends.a(Cextends.U0));
            set.add(Cextends.a(Cextends.V0));
            set.add(Cextends.a(Cextends.W0));
            set.add(Cextends.a(Cextends.X0));
            set.add(Cextends.a(Cextends.Y0));
        }
        int i4 = 0;
        int i5 = 0;
        for (String str : set) {
            try {
                Class.forName(str);
                i4 |= 1 << i5;
            } catch (Throwable unused) {
            }
            i5++;
        }
        return i4;
    }
}
