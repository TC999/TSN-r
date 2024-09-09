package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import d2.l;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.resolve.constants.v;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: annotationUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.f f56235a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.f f56236b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.f f56237c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.f f56238d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.f f56239e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: annotationUtil.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements l<d0, e0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.builtins.h f56240a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.builtins.h hVar) {
            super(1);
            this.f56240a = hVar;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final e0 invoke(@NotNull d0 module) {
            f0.p(module, "module");
            m0 l4 = module.k().l(Variance.INVARIANT, this.f56240a.W());
            f0.o(l4, "module.builtIns.getArray\u2026ce.INVARIANT, stringType)");
            return l4;
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f("message");
        f0.o(f4, "identifier(\"message\")");
        f56235a = f4;
        kotlin.reflect.jvm.internal.impl.name.f f5 = kotlin.reflect.jvm.internal.impl.name.f.f("replaceWith");
        f0.o(f5, "identifier(\"replaceWith\")");
        f56236b = f5;
        kotlin.reflect.jvm.internal.impl.name.f f6 = kotlin.reflect.jvm.internal.impl.name.f.f("level");
        f0.o(f6, "identifier(\"level\")");
        f56237c = f6;
        kotlin.reflect.jvm.internal.impl.name.f f7 = kotlin.reflect.jvm.internal.impl.name.f.f("expression");
        f0.o(f7, "identifier(\"expression\")");
        f56238d = f7;
        kotlin.reflect.jvm.internal.impl.name.f f8 = kotlin.reflect.jvm.internal.impl.name.f.f("imports");
        f0.o(f8, "identifier(\"imports\")");
        f56239e = f8;
    }

    @NotNull
    public static final c a(@NotNull kotlin.reflect.jvm.internal.impl.builtins.h hVar, @NotNull String message, @NotNull String replaceWith, @NotNull String level) {
        List F;
        Map W;
        Map W2;
        f0.p(hVar, "<this>");
        f0.p(message, "message");
        f0.p(replaceWith, "replaceWith");
        f0.p(level, "level");
        kotlin.reflect.jvm.internal.impl.name.c cVar = j.a.B;
        kotlin.reflect.jvm.internal.impl.name.f fVar = f56239e;
        F = CollectionsKt__CollectionsKt.F();
        W = z0.W(l0.a(f56238d, new v(replaceWith)), l0.a(fVar, new kotlin.reflect.jvm.internal.impl.resolve.constants.b(F, new a(hVar))));
        i iVar = new i(hVar, cVar, W);
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = j.a.f56139y;
        kotlin.reflect.jvm.internal.impl.name.f fVar2 = f56237c;
        kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.A);
        f0.o(m4, "topLevel(StandardNames.FqNames.deprecationLevel)");
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(level);
        f0.o(f4, "identifier(level)");
        W2 = z0.W(l0.a(f56235a, new v(message)), l0.a(f56236b, new kotlin.reflect.jvm.internal.impl.resolve.constants.a(iVar)), l0.a(fVar2, new kotlin.reflect.jvm.internal.impl.resolve.constants.j(m4, f4)));
        return new i(hVar, cVar2, W2);
    }

    public static /* synthetic */ c b(kotlin.reflect.jvm.internal.impl.builtins.h hVar, String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = "";
        }
        if ((i4 & 4) != 0) {
            str3 = "WARNING";
        }
        return a(hVar, str, str2, str3);
    }
}
