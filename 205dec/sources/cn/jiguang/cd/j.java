package cn.jiguang.cd;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final k f3312a;

    public j(k kVar) {
        this.f3312a = kVar;
    }

    private cn.jiguang.ce.c a(Throwable th, cn.jiguang.ce.b bVar, Thread thread, boolean z3) {
        Package r02 = th.getClass().getPackage();
        String name = th.getClass().getName();
        cn.jiguang.ce.c cVar = new cn.jiguang.ce.c();
        String message = th.getMessage();
        if (r02 != null) {
            name = name.replace(r02.getName() + ".", "");
        }
        String name2 = r02 != null ? r02.getName() : null;
        List<cn.jiguang.ce.e> a4 = this.f3312a.a(th.getStackTrace());
        if (a4 != null && !a4.isEmpty()) {
            if (!a(thread) && !a(a4)) {
                return null;
            }
            cn.jiguang.ce.f fVar = new cn.jiguang.ce.f(a4);
            if (z3) {
                fVar.a(Boolean.TRUE);
            }
            cVar.a(fVar);
        }
        if (thread != null) {
            cVar.a(Long.valueOf(thread.getId()));
        }
        cVar.a(name);
        cVar.a(bVar);
        cVar.c(name2);
        cVar.b(message);
        return cVar;
    }

    private List<cn.jiguang.ce.c> a(Deque<cn.jiguang.ce.c> deque) {
        return new ArrayList(deque);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<cn.jiguang.ce.c> a(Throwable th) {
        return a(b(th));
    }

    boolean a(Thread thread) {
        if (thread.getName() != null) {
            return thread.getName().contains("jg");
        }
        return false;
    }

    boolean a(List<cn.jiguang.ce.e> list) {
        boolean z3 = false;
        for (cn.jiguang.ce.e eVar : list) {
            if (z3 || eVar.h().booleanValue()) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                break;
            }
        }
        return z3;
    }

    Deque<cn.jiguang.ce.c> b(Throwable th) {
        Thread currentThread;
        cn.jiguang.ce.b bVar;
        boolean z3;
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (th != null && hashSet.add(th)) {
            if (th instanceof c) {
                c cVar = (c) th;
                bVar = cVar.a();
                Throwable b4 = cVar.b();
                currentThread = cVar.c();
                z3 = cVar.d();
                th = b4;
            } else {
                currentThread = Thread.currentThread();
                bVar = null;
                z3 = false;
            }
            arrayDeque.addFirst(a(th, bVar, currentThread, z3));
            th = th.getCause();
        }
        return arrayDeque;
    }
}
