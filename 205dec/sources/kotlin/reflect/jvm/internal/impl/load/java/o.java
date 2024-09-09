package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavaClassesTracker.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface o {

    /* compiled from: JavaClassesTracker.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements o {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f56973a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.o
        public void a(@NotNull kotlin.reflect.jvm.internal.impl.load.java.descriptors.c classDescriptor) {
            f0.p(classDescriptor, "classDescriptor");
        }
    }

    void a(@NotNull kotlin.reflect.jvm.internal.impl.load.java.descriptors.c cVar);
}
