package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImplicitClassReceiver.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c implements d, g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f57950a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final c f57951b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f57952c;

    public c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @Nullable c cVar) {
        f0.p(classDescriptor, "classDescriptor");
        this.f57950a = classDescriptor;
        this.f57951b = cVar == null ? this : cVar;
        this.f57952c = classDescriptor;
    }

    public boolean equals(@Nullable Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = this.f57950a;
        c cVar = obj instanceof c ? (c) obj : null;
        return f0.g(dVar, cVar != null ? cVar.f57950a : null);
    }

    public int hashCode() {
        return this.f57950a.hashCode();
    }

    @NotNull
    public String toString() {
        return "Class{" + getType() + '}';
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.g
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.d w() {
        return this.f57950a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e
    @NotNull
    public m0 getType() {
        m0 q3 = this.f57950a.q();
        f0.o(q3, "classDescriptor.defaultType");
        return q3;
    }
}
