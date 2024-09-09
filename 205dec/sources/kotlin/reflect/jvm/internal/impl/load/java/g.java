package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.f0;

/* compiled from: BuiltinSpecialProperties.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.c c(kotlin.reflect.jvm.internal.impl.name.c cVar, String str) {
        kotlin.reflect.jvm.internal.impl.name.c c4 = cVar.c(kotlin.reflect.jvm.internal.impl.name.f.f(str));
        f0.o(c4, "child(Name.identifier(name))");
        return c4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.c d(kotlin.reflect.jvm.internal.impl.name.d dVar, String str) {
        kotlin.reflect.jvm.internal.impl.name.c l4 = dVar.c(kotlin.reflect.jvm.internal.impl.name.f.f(str)).l();
        f0.o(l4, "child(Name.identifier(name)).toSafe()");
        return l4;
    }
}
