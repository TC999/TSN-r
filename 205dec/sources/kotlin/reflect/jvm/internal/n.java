package kotlin.reflect.jvm.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KPackageImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u00012B\u001f\u0012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0013\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b0\u00101J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001e\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR*\u0010\"\u001a\u0018\u0012\u0014\u0012\u0012 \u001f*\b\u0018\u00010\u001eR\u00020\u00000\u001eR\u00020\u00000\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00138TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0016R\u001e\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010/\u001a\u00020,8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lkotlin/reflect/jvm/internal/n;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/jvm/internal/impl/name/f;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "N", "Lkotlin/reflect/jvm/internal/impl/descriptors/w;", "J", "", "index", "K", "", "other", "", "equals", "hashCode", "", "toString", "Ljava/lang/Class;", "d", "Ljava/lang/Class;", "()Ljava/lang/Class;", "jClass", "e", "Ljava/lang/String;", "getUsageModuleName", "()Ljava/lang/String;", "usageModuleName", "Lkotlin/reflect/jvm/internal/y$b;", "Lkotlin/reflect/jvm/internal/n$a;", "kotlin.jvm.PlatformType", "f", "Lkotlin/reflect/jvm/internal/y$b;", "data", "M", "methodOwner", "Lkotlin/reflect/c;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/Collection;", "members", "Lkotlin/reflect/jvm/internal/impl/descriptors/j;", "I", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "a", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n extends KDeclarationContainerImpl {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f58580d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f58581e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final y.b<a> f58582f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KPackageImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001f\u0010 R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR!\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R/\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\n\u0010\u0018R%\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u0004\u0010\u001d\u00a8\u0006!"}, d2 = {"Lkotlin/reflect/jvm/internal/n$a;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$b;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/f;", "d", "Lkotlin/reflect/jvm/internal/y$a;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;", "e", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "Ljava/lang/Class;", "f", "Lkotlin/reflect/jvm/internal/y$b;", "()Ljava/lang/Class;", "multifileFacade", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/f;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/e;", "g", "()Lkotlin/Triple;", "metadata", "", "Lkotlin/reflect/jvm/internal/f;", "h", "()Ljava/util/Collection;", "members", "<init>", "(Lkotlin/reflect/jvm/internal/n;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a extends KDeclarationContainerImpl.b {

        /* renamed from: j  reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f58583j = {n0.u(new PropertyReference1Impl(n0.d(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), n0.u(new PropertyReference1Impl(n0.d(a.class), "members", "getMembers()Ljava/util/Collection;"))};
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final y.a f58584d;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final y.a f58585e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final y.b f58586f;
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        private final y.b f58587g;
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final y.a f58588h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ n f58589i;

        /* compiled from: KPackageImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/f;", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/f;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: kotlin.reflect.jvm.internal.n$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1191a extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f58590a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1191a(n nVar) {
                super(0);
                this.f58590a = nVar;
            }

            @Override // d2.a
            @Nullable
            /* renamed from: a */
            public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f invoke() {
                return kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f.f56550c.a(this.f58590a.d());
            }
        }

        /* compiled from: KPackageImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001 \u0002*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlin/reflect/jvm/internal/f;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Collection;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class b extends Lambda implements d2.a<Collection<? extends f<?>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f58591a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f58592b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(n nVar, a aVar) {
                super(0);
                this.f58591a = nVar;
                this.f58592b = aVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public final Collection<f<?>> invoke() {
                return this.f58591a.L(this.f58592b.g(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
            }
        }

        /* compiled from: KPackageImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/f;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/e;", "a", "()Lkotlin/Triple;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class c extends Lambda implements d2.a<Triple<? extends kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f, ? extends ProtoBuf.Package, ? extends kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e>> {
            c() {
                super(0);
            }

            @Override // d2.a
            @Nullable
            /* renamed from: a */
            public final Triple<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f, ProtoBuf.Package, kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e> invoke() {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f c4 = a.this.c();
                if (c4 == null) {
                    return null;
                }
                KotlinClassHeader e4 = c4.e();
                String[] a4 = e4.a();
                String[] g4 = e4.g();
                if (a4 == null || g4 == null) {
                    return null;
                }
                Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f, ProtoBuf.Package> m4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.m(a4, g4);
                return new Triple<>(m4.component1(), m4.component2(), e4.d());
            }
        }

        /* compiled from: KPackageImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/Class;", "a", "()Ljava/lang/Class;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class d extends Lambda implements d2.a<Class<?>> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ n f58595b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(n nVar) {
                super(0);
                this.f58595b = nVar;
            }

            @Override // d2.a
            @Nullable
            /* renamed from: a */
            public final Class<?> invoke() {
                String j22;
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f c4 = a.this.c();
                String e4 = c4 == null ? null : c4.e().e();
                if (e4 != null) {
                    if (e4.length() > 0) {
                        ClassLoader classLoader = this.f58595b.d().getClassLoader();
                        j22 = kotlin.text.w.j2(e4, '/', '.', false, 4, null);
                        return classLoader.loadClass(j22);
                    }
                    return null;
                }
                return null;
            }
        }

        /* compiled from: KPackageImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class e extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {
            e() {
                super(0);
            }

            @Override // d2.a
            /* renamed from: a */
            public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f c4 = a.this.c();
                if (c4 != null) {
                    return a.this.a().c().a(c4);
                }
                return h.c.f57931b;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n this$0) {
            super(this$0);
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            this.f58589i = this$0;
            this.f58584d = y.c(new C1191a(this$0));
            this.f58585e = y.c(new e());
            this.f58586f = y.b(new d(this$0));
            this.f58587g = y.b(new c());
            this.f58588h = y.c(new b(this$0, this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f c() {
            return (kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f) this.f58584d.b(this, f58583j[0]);
        }

        @NotNull
        public final Collection<f<?>> d() {
            Object b4 = this.f58588h.b(this, f58583j[4]);
            kotlin.jvm.internal.f0.o(b4, "<get-members>(...)");
            return (Collection) b4;
        }

        @Nullable
        public final Triple<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f, ProtoBuf.Package, kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e> e() {
            return (Triple) this.f58587g.b(this, f58583j[3]);
        }

        @Nullable
        public final Class<?> f() {
            return (Class) this.f58586f.b(this, f58583j[2]);
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h g() {
            Object b4 = this.f58585e.b(this, f58583j[1]);
            kotlin.jvm.internal.f0.o(b4, "<get-scope>(...)");
            return (kotlin.reflect.jvm.internal.impl.resolve.scopes.h) b4;
        }
    }

    /* compiled from: KPackageImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0012 \u0002*\b\u0018\u00010\u0000R\u00020\u00010\u0000R\u00020\u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/jvm/internal/n$a;", "Lkotlin/reflect/jvm/internal/n;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/n$a;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<a> {
        b() {
            super(0);
        }

        @Override // d2.a
        /* renamed from: a */
        public final a invoke() {
            return new a(n.this);
        }
    }

    /* compiled from: KPackageImpl.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    /* synthetic */ class c extends FunctionReference implements d2.p<kotlin.reflect.jvm.internal.impl.serialization.deserialization.u, ProtoBuf.Property, p0> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f58598a = new c();

        c() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: d */
        public final p0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.u p02, @NotNull ProtoBuf.Property p12) {
            kotlin.jvm.internal.f0.p(p02, "p0");
            kotlin.jvm.internal.f0.p(p12, "p1");
            return p02.l(p12);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "loadProperty";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(kotlin.reflect.jvm.internal.impl.serialization.deserialization.u.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }
    }

    public /* synthetic */ n(Class cls, String str, int i4, kotlin.jvm.internal.u uVar) {
        this(cls, (i4 & 2) != 0 ? null : str);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h U() {
        return this.f58582f.invoke().g();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> I() {
        List F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.w> J(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.f0.p(name, "name");
        return U().a(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @Nullable
    public p0 K(int i4) {
        Triple<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f, ProtoBuf.Package, kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e> e4 = this.f58582f.invoke().e();
        if (e4 == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f component1 = e4.component1();
        ProtoBuf.Package component2 = e4.component2();
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e component3 = e4.component3();
        GeneratedMessageLite.f<ProtoBuf.Package, List<ProtoBuf.Property>> packageLocalVariable = JvmProtoBuf.f57500n;
        kotlin.jvm.internal.f0.o(packageLocalVariable, "packageLocalVariable");
        ProtoBuf.Property property = (ProtoBuf.Property) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.b(component2, packageLocalVariable, i4);
        if (property == null) {
            return null;
        }
        Class<?> d4 = d();
        ProtoBuf.TypeTable typeTable = component2.getTypeTable();
        kotlin.jvm.internal.f0.o(typeTable, "packageProto.typeTable");
        return (p0) f0.h(d4, property, component1, new kotlin.reflect.jvm.internal.impl.metadata.deserialization.g(typeTable), component3, c.f58598a);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    protected Class<?> M() {
        Class<?> f4 = this.f58582f.invoke().f();
        return f4 == null ? d() : f4;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<p0> N(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.f0.p(name, "name");
        return U().c(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.jvm.internal.r
    @NotNull
    public Class<?> d() {
        return this.f58580d;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof n) && kotlin.jvm.internal.f0.g(d(), ((n) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // kotlin.reflect.h
    @NotNull
    public Collection<kotlin.reflect.c<?>> q() {
        return this.f58582f.invoke().d();
    }

    @NotNull
    public String toString() {
        return kotlin.jvm.internal.f0.C("file class ", kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(d()).b());
    }

    public n(@NotNull Class<?> jClass, @Nullable String str) {
        kotlin.jvm.internal.f0.p(jClass, "jClass");
        this.f58580d = jClass;
        this.f58581e = str;
        y.b<a> b4 = y.b(new b());
        kotlin.jvm.internal.f0.o(b4, "lazy { Data() }");
        this.f58582f = b4;
    }
}
