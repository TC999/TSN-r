package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.f.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements c.d {
    @Override // com.kwad.framework.filedownloader.f.c.d
    public final int f(String str, String str2, boolean z3) {
        return g(str, str2, z3);
    }

    @Override // com.kwad.framework.filedownloader.f.c.d
    public final int g(String str, String str2, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (z3) {
                return com.kwad.framework.filedownloader.f.f.bu(com.kwad.framework.filedownloader.f.f.b("%sp%s@dir", str, str2)).hashCode();
            }
            return com.kwad.framework.filedownloader.f.f.bu(com.kwad.framework.filedownloader.f.f.b("%sp%s", str, str2)).hashCode();
        } catch (Throwable unused) {
            return str.hashCode();
        }
    }
}
