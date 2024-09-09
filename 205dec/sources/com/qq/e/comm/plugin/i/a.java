package com.qq.e.comm.plugin.i;

import com.qq.e.comm.plugin.util.d1;
import java.util.ArrayList;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class a implements p {

    /* renamed from: a  reason: collision with root package name */
    protected final List<Class<? extends o>> f44053a = new ArrayList();

    @Override // com.qq.e.comm.plugin.i.p
    public void a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        if (this.f44053a.size() <= 0) {
            return;
        }
        com.qq.e.comm.plugin.i.d0.a aVar = new com.qq.e.comm.plugin.i.d0.a(bVar);
        j.a(false, 0, hVar);
        long currentTimeMillis = System.currentTimeMillis();
        for (Class<? extends o> cls : this.f44053a) {
            o a4 = a(cls);
            if (a4 == null) {
                j.a(true, 1, hVar);
                return;
            }
            boolean a5 = a4.a(hVar);
            String simpleName = getClass().getSimpleName();
            d1.a(simpleName, cls.getSimpleName() + ", canAction = " + a5);
            if (a5) {
                boolean a6 = a4.a(hVar, aVar);
                String simpleName2 = getClass().getSimpleName();
                d1.a(simpleName2, cls.getSimpleName() + ", actionFinish = " + a6);
                if (a6) {
                    o a7 = a(a0.class);
                    if (a7 != null && a7.a(hVar)) {
                        a7.a(hVar, aVar);
                    }
                    j.a(2300008, currentTimeMillis, hVar);
                    return;
                }
            }
        }
        if (hVar.f44150w) {
            aVar.b();
        }
        hVar.a();
        j.a(true, 2, hVar);
    }

    private o a(Class<? extends o> cls) {
        try {
            return cls.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }
}
