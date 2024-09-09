package cn.jiguang.bv;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashSet<g> f2940a = new LinkedHashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private LinkedHashSet<g> f2941b = new LinkedHashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private List<Boolean> f2942c = new ArrayList();

    private g a(boolean z3, boolean z4) {
        LinkedHashSet<g> linkedHashSet = z3 ? this.f2941b : this.f2940a;
        LinkedHashSet<g> linkedHashSet2 = z4 ? null : z3 ? this.f2940a : this.f2941b;
        return (g) ((linkedHashSet2 == null || linkedHashSet2.isEmpty() || !(linkedHashSet == null || linkedHashSet.isEmpty() || a(z3))) ? a(linkedHashSet) : a(linkedHashSet2));
    }

    private static <T> T a(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        Iterator<T> it = collection.iterator();
        if (it.hasNext()) {
            T next = it.next();
            collection.remove(next);
            return next;
        }
        return null;
    }

    private boolean a(boolean z3) {
        if (this.f2942c.size() < 2) {
            return false;
        }
        for (int size = this.f2942c.size() - 1; size >= this.f2942c.size() - 2; size--) {
            if (this.f2942c.get(size).booleanValue() != z3) {
                return false;
            }
        }
        return true;
    }

    public g a(int i4) {
        List<Boolean> list;
        Boolean bool;
        cn.jiguang.bq.d.c("IpPool", "current ipv4List=" + this.f2940a + " ipv6List=" + this.f2941b);
        g a4 = i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 3 ? null : a(true, false) : a(true, true) : a(false, true) : a(false, false);
        cn.jiguang.bq.d.c("IpPool", "get ipPort=" + a4);
        if (a4 != null) {
            InetAddress inetAddress = a4.f2945c;
            if (inetAddress instanceof Inet4Address) {
                list = this.f2942c;
                bool = Boolean.FALSE;
            } else if (inetAddress instanceof Inet6Address) {
                list = this.f2942c;
                bool = Boolean.TRUE;
            }
            list.add(bool);
        }
        return a4;
    }

    public void a() {
        try {
            this.f2940a.clear();
            this.f2941b.clear();
        } catch (Throwable unused) {
        }
    }

    public boolean a(g gVar) {
        LinkedHashSet<g> linkedHashSet;
        if (gVar == null || !gVar.a()) {
            return false;
        }
        InetAddress inetAddress = gVar.f2945c;
        if (inetAddress instanceof Inet4Address) {
            linkedHashSet = this.f2940a;
        } else if (!(inetAddress instanceof Inet6Address)) {
            return false;
        } else {
            linkedHashSet = this.f2941b;
        }
        return linkedHashSet.add(gVar);
    }
}
