package com.danikula.videocache.file;

import android.text.TextUtils;
import com.danikula.videocache.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: Md5FileNameGenerator.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f36745a = 4;

    private String a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.danikula.videocache.file.c
    public String generate(String str) {
        String a4 = a(str);
        String d4 = p.d(str);
        if (TextUtils.isEmpty(a4)) {
            return d4;
        }
        return d4 + "." + a4;
    }
}
