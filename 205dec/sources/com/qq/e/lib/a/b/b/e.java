package com.qq.e.lib.a.b.b;

import android.text.TextUtils;
import java.io.IOException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    int f47284a;

    /* renamed from: b  reason: collision with root package name */
    int f47285b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & '\u00ff') << 24) | (str.charAt(0) & '\u00ff') | ((str.charAt(1) & '\u00ff') << 8) | ((str.charAt(2) & '\u00ff') << 16);
    }

    void a(com.qq.e.lib.a.b.c.a aVar) throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.qq.e.lib.a.b.c.a aVar) throws IOException {
        int available = aVar.available();
        a(aVar);
        int available2 = available - aVar.available();
        int i4 = this.f47284a;
        if (available2 > i4) {
            throw new IOException("Out of chunk area");
        }
        if (available2 < i4) {
            aVar.skip(i4 - available2);
        }
    }
}
