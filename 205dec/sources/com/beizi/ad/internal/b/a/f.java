package com.beizi.ad.internal.b.a;

import android.text.TextUtils;
import com.beizi.ad.internal.b.n;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Md5FileNameGenerator.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f implements c {
    private String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.beizi.ad.internal.b.a.c
    public String a(String str) {
        String b4 = b(str);
        String d4 = n.d(str);
        if (TextUtils.isEmpty(b4)) {
            return d4;
        }
        return d4 + "." + b4;
    }
}
