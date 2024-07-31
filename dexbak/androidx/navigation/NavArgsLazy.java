package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C14342f0;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import p612k1.JvmClassMapping;
import p617l1.InterfaceC15269a;

/* compiled from: NavArgsLazy.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B#\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, m12616d2 = {"Landroidx/navigation/NavArgsLazy;", "Landroidx/navigation/NavArgs;", "Args", "Lkotlin/o;", "", "isInitialized", "cached", "Landroidx/navigation/NavArgs;", "Lkotlin/reflect/d;", "navArgsClass", "Lkotlin/reflect/d;", "getValue", "()Landroidx/navigation/NavArgs;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/Function0;", "Landroid/os/Bundle;", "argumentProducer", "<init>", "(Lkotlin/reflect/d;Ll1/a;)V", "navigation-common-ktx_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class NavArgsLazy<Args extends NavArgs> implements InterfaceC14378o<Args> {
    private final InterfaceC15269a<Bundle> argumentProducer;
    private Args cached;
    private final KClass<Args> navArgsClass;

    public NavArgsLazy(@NotNull KClass<Args> navArgsClass, @NotNull InterfaceC15269a<Bundle> argumentProducer) {
        C14342f0.m8183q(navArgsClass, "navArgsClass");
        C14342f0.m8183q(argumentProducer, "argumentProducer");
        this.navArgsClass = navArgsClass;
        this.argumentProducer = argumentProducer;
    }

    @Override // kotlin.InterfaceC14378o
    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // kotlin.InterfaceC14378o
    @NotNull
    public Args getValue() {
        Args args = this.cached;
        if (args == null) {
            Bundle invoke = this.argumentProducer.invoke();
            Method method = NavArgsLazyKt.getMethodMap().get(this.navArgsClass);
            if (method == null) {
                Class m12626c = JvmClassMapping.m12626c(this.navArgsClass);
                Class<Bundle>[] methodSignature = NavArgsLazyKt.getMethodSignature();
                method = m12626c.getMethod("fromBundle", (Class[]) Arrays.copyOf(methodSignature, methodSignature.length));
                NavArgsLazyKt.getMethodMap().put(this.navArgsClass, method);
                C14342f0.m8192h(method, "navArgsClass.java.getMet…hod\n                    }");
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
