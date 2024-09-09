package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import d2.a;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.f0;
import kotlin.p;
import kotlin.reflect.d;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: NavArgsLazy.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B#\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Landroidx/navigation/NavArgsLazy;", "Landroidx/navigation/NavArgs;", "Args", "Lkotlin/p;", "", "isInitialized", "cached", "Landroidx/navigation/NavArgs;", "Lkotlin/reflect/d;", "navArgsClass", "Lkotlin/reflect/d;", "getValue", "()Landroidx/navigation/NavArgs;", "value", "Lkotlin/Function0;", "Landroid/os/Bundle;", "argumentProducer", "<init>", "(Lkotlin/reflect/d;Ld2/a;)V", "navigation-common-ktx_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class NavArgsLazy<Args extends NavArgs> implements p<Args> {
    private final a<Bundle> argumentProducer;
    private Args cached;
    private final d<Args> navArgsClass;

    public NavArgsLazy(@NotNull d<Args> navArgsClass, @NotNull a<Bundle> argumentProducer) {
        f0.q(navArgsClass, "navArgsClass");
        f0.q(argumentProducer, "argumentProducer");
        this.navArgsClass = navArgsClass;
        this.argumentProducer = argumentProducer;
    }

    @Override // kotlin.p
    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // kotlin.p
    @NotNull
    public Args getValue() {
        Args args = this.cached;
        if (args == null) {
            Bundle invoke = this.argumentProducer.invoke();
            Method method = NavArgsLazyKt.getMethodMap().get(this.navArgsClass);
            if (method == null) {
                Class c4 = c2.a.c(this.navArgsClass);
                Class<Bundle>[] methodSignature = NavArgsLazyKt.getMethodSignature();
                method = c4.getMethod("fromBundle", (Class[]) Arrays.copyOf(methodSignature, methodSignature.length));
                NavArgsLazyKt.getMethodMap().put(this.navArgsClass, method);
                f0.h(method, "navArgsClass.java.getMet\u2026hod\n                    }");
            }
            Object invoke2 = method.invoke(null, invoke);
            if (invoke2 != null) {
                Args args2 = (Args) invoke2;
                this.cached = args2;
                return args2;
            }
            throw new TypeCastException("null cannot be cast to non-null type Args");
        }
        return args;
    }
}
