package com.volcengine.mobsecBiz.metasec.ml;

import java.util.Map;
import ms.bz.bd.c.Pgl.m0;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class c implements m0.pgla {

    /* renamed from: a  reason: collision with root package name */
    private final m0.pgla f54240a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(m0.pgla pglaVar) {
        this.f54240a = pglaVar;
    }

    @Override // ms.bz.bd.c.Pgl.m0.pgla
    public Map<String, String> c(String str, byte[] bArr) {
        return this.f54240a.c(str, bArr);
    }

    @Override // ms.bz.bd.c.Pgl.m0.pgla
    public void c(String str) {
        this.f54240a.c(str);
    }

    @Override // ms.bz.bd.c.Pgl.m0.pgla
    public void w(String str) {
        this.f54240a.w(str);
    }
}
