package com.danikula.videocache.file;

import android.text.TextUtils;
import com.danikula.videocache.C6571p;

/* compiled from: Md5FileNameGenerator.java */
/* renamed from: com.danikula.videocache.file.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6552f implements InterfaceC6546c {

    /* renamed from: a */
    private static final int f23078a = 4;

    /* renamed from: a */
    private String m35927a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.danikula.videocache.file.InterfaceC6546c
    public String generate(String str) {
        String m35927a = m35927a(str);
        String m35838d = C6571p.m35838d(str);
        if (TextUtils.isEmpty(m35927a)) {
            return m35838d;
        }
        return m35838d + "." + m35927a;
    }
}
