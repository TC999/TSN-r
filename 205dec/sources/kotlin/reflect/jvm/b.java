package kotlin.reflect.jvm;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.h;
import org.jetbrains.annotations.NotNull;

/* compiled from: KClassesJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0019\u0010\u0004\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lkotlin/reflect/d;", "", "a", "(Lkotlin/reflect/d;)Ljava/lang/String;", "jvmName", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "KClassesJvm")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {
    @NotNull
    public static final String a(@NotNull kotlin.reflect.d<?> dVar) {
        f0.p(dVar, "<this>");
        String name = ((h) dVar).d().getName();
        f0.o(name, "this as KClassImpl).jClass.name");
        return name;
    }
}
