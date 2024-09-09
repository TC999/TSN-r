package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ModuleVisibilityHelper.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface g {

    /* compiled from: ModuleVisibilityHelper.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements g {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f58480a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.g
        public boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k what, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k from) {
            f0.p(what, "what");
            f0.p(from, "from");
            return true;
        }
    }

    boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar2);
}
