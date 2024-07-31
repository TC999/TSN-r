package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformRandom.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0007¨\u0006\u000b"}, m12616d2 = {"Lkotlin/random/b;", "Lkotlin/random/a;", "kotlin/random/b$a", "a", "Lkotlin/random/b$a;", "implStorage", "Ljava/util/Random;", "()Ljava/util/Random;", "impl", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.random.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14393b extends PlatformRandom {

    /* renamed from: a */
    private final C14394a f41270a = new C14394a();

    /* compiled from: PlatformRandom.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, m12616d2 = {"kotlin/random/b$a", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", "a", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.random.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14394a extends ThreadLocal<java.util.Random> {
        C14394a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NotNull
        /* renamed from: a */
        public java.util.Random initialValue() {
            return new java.util.Random();
        }
    }

    @Override // kotlin.random.PlatformRandom
    @NotNull
    /* renamed from: a */
    public java.util.Random mo2810a() {
        java.util.Random random = this.f41270a.get();
        C14342f0.m8185o(random, "implStorage.get()");
        return random;
    }
}
