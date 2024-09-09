package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.reflect.i;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.f;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: KCallablesJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\",\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lkotlin/reflect/c;", "", "value", "a", "(Lkotlin/reflect/c;)Z", "b", "(Lkotlin/reflect/c;Z)V", "isAccessible", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "KCallablesJvm")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    public static final boolean a(@NotNull kotlin.reflect.c<?> cVar) {
        kotlin.reflect.jvm.internal.calls.c<?> H;
        f0.p(cVar, "<this>");
        if (cVar instanceof j) {
            n nVar = (n) cVar;
            Field c4 = d.c(nVar);
            if (!(c4 == null ? true : c4.isAccessible())) {
                return false;
            }
            Method d4 = d.d(nVar);
            if (!(d4 == null ? true : d4.isAccessible())) {
                return false;
            }
            Method f4 = d.f((j) cVar);
            if (!(f4 == null ? true : f4.isAccessible())) {
                return false;
            }
        } else if (cVar instanceof n) {
            n nVar2 = (n) cVar;
            Field c5 = d.c(nVar2);
            if (!(c5 == null ? true : c5.isAccessible())) {
                return false;
            }
            Method d5 = d.d(nVar2);
            if (!(d5 == null ? true : d5.isAccessible())) {
                return false;
            }
        } else if (cVar instanceof n.c) {
            Field c6 = d.c(((n.c) cVar).d());
            if (!(c6 == null ? true : c6.isAccessible())) {
                return false;
            }
            Method e4 = d.e((i) cVar);
            if (!(e4 == null ? true : e4.isAccessible())) {
                return false;
            }
        } else if (cVar instanceof j.a) {
            Field c7 = d.c(((j.a) cVar).d());
            if (!(c7 == null ? true : c7.isAccessible())) {
                return false;
            }
            Method e5 = d.e((i) cVar);
            if (!(e5 == null ? true : e5.isAccessible())) {
                return false;
            }
        } else if (cVar instanceof i) {
            i iVar = (i) cVar;
            Method e6 = d.e(iVar);
            if (!(e6 == null ? true : e6.isAccessible())) {
                return false;
            }
            f<?> b4 = kotlin.reflect.jvm.internal.f0.b(cVar);
            Object b5 = (b4 == null || (H = b4.H()) == null) ? null : H.b();
            AccessibleObject accessibleObject = b5 instanceof AccessibleObject ? (AccessibleObject) b5 : null;
            if (!(accessibleObject == null ? true : accessibleObject.isAccessible())) {
                return false;
            }
            Constructor a4 = d.a(iVar);
            if (!(a4 == null ? true : a4.isAccessible())) {
                return false;
            }
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
        }
        return true;
    }

    public static final void b(@NotNull kotlin.reflect.c<?> cVar, boolean z3) {
        kotlin.reflect.jvm.internal.calls.c<?> H;
        f0.p(cVar, "<this>");
        if (cVar instanceof j) {
            n nVar = (n) cVar;
            Field c4 = d.c(nVar);
            if (c4 != null) {
                c4.setAccessible(z3);
            }
            Method d4 = d.d(nVar);
            if (d4 != null) {
                d4.setAccessible(z3);
            }
            Method f4 = d.f((j) cVar);
            if (f4 == null) {
                return;
            }
            f4.setAccessible(z3);
        } else if (cVar instanceof n) {
            n nVar2 = (n) cVar;
            Field c5 = d.c(nVar2);
            if (c5 != null) {
                c5.setAccessible(z3);
            }
            Method d5 = d.d(nVar2);
            if (d5 == null) {
                return;
            }
            d5.setAccessible(z3);
        } else if (cVar instanceof n.c) {
            Field c6 = d.c(((n.c) cVar).d());
            if (c6 != null) {
                c6.setAccessible(z3);
            }
            Method e4 = d.e((i) cVar);
            if (e4 == null) {
                return;
            }
            e4.setAccessible(z3);
        } else if (cVar instanceof j.a) {
            Field c7 = d.c(((j.a) cVar).d());
            if (c7 != null) {
                c7.setAccessible(z3);
            }
            Method e5 = d.e((i) cVar);
            if (e5 == null) {
                return;
            }
            e5.setAccessible(z3);
        } else if (cVar instanceof i) {
            i iVar = (i) cVar;
            Method e6 = d.e(iVar);
            if (e6 != null) {
                e6.setAccessible(z3);
            }
            f<?> b4 = kotlin.reflect.jvm.internal.f0.b(cVar);
            Object b5 = (b4 == null || (H = b4.H()) == null) ? null : H.b();
            AccessibleObject accessibleObject = b5 instanceof AccessibleObject ? (AccessibleObject) b5 : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(true);
            }
            Constructor a4 = d.a(iVar);
            if (a4 == null) {
                return;
            }
            a4.setAccessible(z3);
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
        }
    }
}
