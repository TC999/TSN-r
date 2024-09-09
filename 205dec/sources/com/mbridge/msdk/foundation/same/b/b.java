package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DirectoryContext.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected a f39423a;

    public b(String str) {
        a aVar = new a();
        aVar.a(str);
        aVar.a(c.AD_ROOT);
        List<a> b4 = b();
        if (b4 != null && b4.size() > 0) {
            aVar.a(b4);
        }
        this.f39423a = aVar;
    }

    public final a a() {
        return this.f39423a;
    }

    protected abstract List<a> b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final a a(ArrayList<a> arrayList, c cVar, String str) {
        a aVar = new a();
        aVar.a(cVar);
        aVar.a(str);
        arrayList.add(aVar);
        return aVar;
    }
}
