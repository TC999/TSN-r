package com.beizi.p051ad.internal.p058b.p059a;

import android.text.TextUtils;
import com.beizi.p051ad.internal.p058b.ProxyCacheUtils;

/* renamed from: com.beizi.ad.internal.b.a.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Md5FileNameGenerator implements FileNameGenerator {
    /* renamed from: b */
    private String m49630b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.beizi.p051ad.internal.p058b.p059a.FileNameGenerator
    /* renamed from: a */
    public String mo49631a(String str) {
        String m49630b = m49630b(str);
        String m49546d = ProxyCacheUtils.m49546d(str);
        if (TextUtils.isEmpty(m49630b)) {
            return m49546d;
        }
        return m49546d + "." + m49630b;
    }
}
