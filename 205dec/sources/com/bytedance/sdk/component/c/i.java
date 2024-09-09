package com.bytedance.sdk.component.c;

import android.net.Uri;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.sdk.component.c.j;
import com.bytedance.sdk.component.c.k;
import com.bytedance.sdk.component.c.q;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f29664c;
    private final q sr;
    private k.w ux;

    /* renamed from: w  reason: collision with root package name */
    private final Set<String> f29665w;
    private final j xv = s.f29708c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(q qVar, Set<String> set, Set<String> set2) {
        this.sr = qVar;
        if (set != null && !set.isEmpty()) {
            this.f29664c = new LinkedHashSet(set);
        } else {
            this.f29664c = new LinkedHashSet();
        }
        if (set2 != null && !set2.isEmpty()) {
            this.f29665w = new LinkedHashSet(set2);
        } else {
            this.f29665w = new LinkedHashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainThread
    public final synchronized ls c(boolean z3, String str, w wVar) throws q.c {
        ls w3;
        k.w wVar2;
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host == null) {
            return null;
        }
        ls lsVar = this.f29665w.contains(wVar.c()) ? ls.PUBLIC : null;
        for (String str2 : this.f29664c) {
            if (!parse.getHost().equals(str2)) {
                if (host.endsWith("." + str2)) {
                }
            }
            lsVar = ls.PRIVATE;
        }
        if (lsVar == null && (wVar2 = this.ux) != null && wVar2.c(str)) {
            if (this.ux.c(str, wVar.c())) {
                return null;
            }
            lsVar = ls.PRIVATE;
        }
        if (z3) {
            w3 = c(str, wVar);
        } else {
            w3 = w(str, wVar);
        }
        return w3 != null ? w3 : lsVar;
    }

    final synchronized ls w(String str, w wVar) {
        return c(str, wVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(j.c cVar) {
        j jVar = this.xv;
        if (jVar != null) {
            jVar.w(cVar);
        }
    }

    @MainThread
    final synchronized ls c(String str, w wVar) throws q.c {
        return c(str, wVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(k.w wVar) {
        this.ux = wVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(j.c cVar) {
        j jVar = this.xv;
        if (jVar != null) {
            jVar.c(cVar);
        }
    }

    private ls c(String str, w wVar, boolean z3) {
        q qVar;
        if (!z3 || (qVar = this.sr) == null) {
            return null;
        }
        q.xv c4 = qVar.c(str, this.f29664c);
        if (c4.xv.contains(wVar.c())) {
            return null;
        }
        if (c4.f29696w.contains(wVar.c())) {
            return ls.PRIVATE;
        }
        if (c4.f29695c.compareTo(wVar.w()) < 0) {
            return null;
        }
        return c4.f29695c;
    }
}
