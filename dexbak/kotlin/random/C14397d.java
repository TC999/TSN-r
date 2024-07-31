package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformRandom.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u000b2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0005B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\b\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\f"}, m12616d2 = {"Lkotlin/random/d;", "Lkotlin/random/a;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/Random;", "a", "Ljava/util/Random;", "()Ljava/util/Random;", "impl", "<init>", "(Ljava/util/Random;)V", "b", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.random.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14397d extends PlatformRandom implements Serializable {
    @NotNull

    /* renamed from: b */
    private static final C14398a f41274b = new C14398a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    @NotNull

    /* renamed from: a */
    private final java.util.Random f41275a;

    /* compiled from: PlatformRandom.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m12616d2 = {"Lkotlin/random/d$a;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.random.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C14398a {
        private C14398a() {
        }

        public /* synthetic */ C14398a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public C14397d(@NotNull java.util.Random impl) {
        C14342f0.m8184p(impl, "impl");
        this.f41275a = impl;
    }

    @Override // kotlin.random.PlatformRandom
    @NotNull
    /* renamed from: a */
    public java.util.Random mo2810a() {
        return this.f41275a;
    }
}
