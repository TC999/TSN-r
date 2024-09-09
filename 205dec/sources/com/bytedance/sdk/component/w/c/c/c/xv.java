package com.bytedance.sdk.component.w.c.c.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.t;
import com.bytedance.sdk.component.w.c.ys;
import com.bytedance.sdk.component.xv.w.ck;
import com.bytedance.sdk.component.xv.w.i;
import com.bytedance.sdk.component.xv.w.j;
import com.bytedance.sdk.component.xv.w.n;
import com.bytedance.sdk.component.xv.w.q;
import com.bytedance.sdk.component.xv.w.sr;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends a {
    j bk;

    /* renamed from: t  reason: collision with root package name */
    com.bytedance.sdk.component.w.c.sr f30388t;

    public xv(j.c cVar) {
        super(cVar);
        j c4 = cVar.c();
        this.bk = c4;
        this.f30388t = new sr(c4);
    }

    private boolean w(ys ysVar) {
        byte[] bArr;
        return ysVar != null && ysVar.f30451f == ys.c.BYTE_ARRAY_TYPE && (bArr = ysVar.ux) != null && bArr.length > 0;
    }

    private boolean xv(ys ysVar) {
        return (ysVar == null || ysVar.f30451f != ys.c.STRING_TYPE || TextUtils.isEmpty(ysVar.sr)) ? false : true;
    }

    @Override // com.bytedance.sdk.component.w.c.a
    public com.bytedance.sdk.component.w.c.sr c() {
        return this.f30388t;
    }

    @Override // com.bytedance.sdk.component.w.c.a
    public com.bytedance.sdk.component.w.c.w c(t tVar) {
        if (tVar == null) {
            return null;
        }
        n.c cVar = new n.c();
        cVar.c(tVar.c());
        if (tVar.w() != null) {
            cVar.c(tVar.w().c());
        }
        if (tVar.f() != null) {
            if (xv(tVar.f())) {
                cVar.c(tVar.xv(), ck.c(i.c(tVar.f().xv.toString()), tVar.f().sr));
            } else if (c(tVar.f())) {
                cVar.c(tVar.xv(), new q.c().c(q.ux).c(tVar.f().w(), tVar.f().c(), ck.c(i.c("multipart/form-data"), tVar.f().ux)).c());
            } else if (w(tVar.f())) {
                cVar.c(tVar.xv(), ck.c(i.c(tVar.f().xv.toString()), tVar.f().ux));
            }
        }
        if (tVar.ux() != null && tVar.ux().f30376c) {
            cVar.c(new sr.c().c().xv());
        }
        if (tVar.sr() != null && tVar.sr().size() > 0) {
            for (Map.Entry<String, List<String>> entry : tVar.sr().entrySet()) {
                for (String str : entry.getValue()) {
                    cVar.c(entry.getKey(), str);
                }
            }
        }
        return new c(this.bk.c(cVar.c()));
    }

    private boolean c(ys ysVar) {
        byte[] bArr;
        return ysVar != null && ysVar.f30451f == ys.c.FILE_TYPE && (bArr = ysVar.ux) != null && bArr.length > 0;
    }

    @Override // com.bytedance.sdk.component.w.c.a
    public boolean c(String str, boolean z3) {
        return this.bk.c(str, z3);
    }
}
