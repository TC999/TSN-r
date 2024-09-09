package j2;

import k2.c;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.f;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: utils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    public static final void a(@NotNull c cVar, @NotNull k2.b from, @NotNull d scopeOwner, @NotNull f name) {
        k2.a location;
        f0.p(cVar, "<this>");
        f0.p(from, "from");
        f0.p(scopeOwner, "scopeOwner");
        f0.p(name, "name");
        if (cVar == c.a.f55236a || (location = from.getLocation()) == null) {
            return;
        }
        Position position = cVar.a() ? location.getPosition() : Position.Companion.a();
        String filePath = location.getFilePath();
        String b4 = kotlin.reflect.jvm.internal.impl.resolve.d.m(scopeOwner).b();
        f0.o(b4, "getFqName(scopeOwner).asString()");
        ScopeKind scopeKind = ScopeKind.CLASSIFIER;
        String b5 = name.b();
        f0.o(b5, "name.asString()");
        cVar.b(filePath, position, b4, scopeKind, b5);
    }

    public static final void b(@NotNull c cVar, @NotNull k2.b from, @NotNull g0 scopeOwner, @NotNull f name) {
        f0.p(cVar, "<this>");
        f0.p(from, "from");
        f0.p(scopeOwner, "scopeOwner");
        f0.p(name, "name");
        String b4 = scopeOwner.e().b();
        f0.o(b4, "scopeOwner.fqName.asString()");
        String b5 = name.b();
        f0.o(b5, "name.asString()");
        c(cVar, from, b4, b5);
    }

    public static final void c(@NotNull c cVar, @NotNull k2.b from, @NotNull String packageFqName, @NotNull String name) {
        k2.a location;
        f0.p(cVar, "<this>");
        f0.p(from, "from");
        f0.p(packageFqName, "packageFqName");
        f0.p(name, "name");
        if (cVar == c.a.f55236a || (location = from.getLocation()) == null) {
            return;
        }
        cVar.b(location.getFilePath(), cVar.a() ? location.getPosition() : Position.Companion.a(), packageFqName, ScopeKind.PACKAGE, name);
    }
}
