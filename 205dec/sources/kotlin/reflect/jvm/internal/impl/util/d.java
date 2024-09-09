package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.util.c;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: modifierChecks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.f f58467a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Regex f58468b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Collection<kotlin.reflect.jvm.internal.impl.name.f> f58469c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final d2.l<w, String> f58470d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.util.b[] f58471e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f58472a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final Void invoke(@NotNull w wVar) {
            f0.p(wVar, "$this$null");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f58473a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final Void invoke(@NotNull w wVar) {
            f0.p(wVar, "$this$null");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f58474a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final Void invoke(@NotNull w wVar) {
            f0.p(wVar, "$this$null");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d(kotlin.reflect.jvm.internal.impl.name.f fVar, Regex regex, Collection<kotlin.reflect.jvm.internal.impl.name.f> collection, d2.l<? super w, String> lVar, kotlin.reflect.jvm.internal.impl.util.b... bVarArr) {
        this.f58467a = fVar;
        this.f58468b = regex;
        this.f58469c = collection;
        this.f58470d = lVar;
        this.f58471e = bVarArr;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.util.c a(@NotNull w functionDescriptor) {
        f0.p(functionDescriptor, "functionDescriptor");
        kotlin.reflect.jvm.internal.impl.util.b[] bVarArr = this.f58471e;
        int length = bVarArr.length;
        int i4 = 0;
        while (i4 < length) {
            kotlin.reflect.jvm.internal.impl.util.b bVar = bVarArr[i4];
            i4++;
            String a4 = bVar.a(functionDescriptor);
            if (a4 != null) {
                return new c.b(a4);
            }
        }
        String invoke = this.f58470d.invoke(functionDescriptor);
        if (invoke != null) {
            return new c.b(invoke);
        }
        return c.C1187c.f58466b;
    }

    public final boolean b(@NotNull w functionDescriptor) {
        f0.p(functionDescriptor, "functionDescriptor");
        if (this.f58467a == null || f0.g(functionDescriptor.getName(), this.f58467a)) {
            if (this.f58468b != null) {
                String b4 = functionDescriptor.getName().b();
                f0.o(b4, "functionDescriptor.name.asString()");
                if (!this.f58468b.matches(b4)) {
                    return false;
                }
            }
            Collection<kotlin.reflect.jvm.internal.impl.name.f> collection = this.f58469c;
            return collection == null || collection.contains(functionDescriptor.getName());
        }
        return false;
    }

    public /* synthetic */ d(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.util.b[] bVarArr, d2.l lVar, int i4, u uVar) {
        this(fVar, bVarArr, (i4 & 4) != 0 ? a.f58472a : lVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.util.b[] checks, @NotNull d2.l<? super w, String> additionalChecks) {
        this(name, (Regex) null, (Collection<kotlin.reflect.jvm.internal.impl.name.f>) null, additionalChecks, (kotlin.reflect.jvm.internal.impl.util.b[]) Arrays.copyOf(checks, checks.length));
        f0.p(name, "name");
        f0.p(checks, "checks");
        f0.p(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ d(Regex regex, kotlin.reflect.jvm.internal.impl.util.b[] bVarArr, d2.l lVar, int i4, u uVar) {
        this(regex, bVarArr, (i4 & 4) != 0 ? b.f58473a : lVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Regex regex, @NotNull kotlin.reflect.jvm.internal.impl.util.b[] checks, @NotNull d2.l<? super w, String> additionalChecks) {
        this((kotlin.reflect.jvm.internal.impl.name.f) null, regex, (Collection<kotlin.reflect.jvm.internal.impl.name.f>) null, additionalChecks, (kotlin.reflect.jvm.internal.impl.util.b[]) Arrays.copyOf(checks, checks.length));
        f0.p(regex, "regex");
        f0.p(checks, "checks");
        f0.p(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ d(Collection collection, kotlin.reflect.jvm.internal.impl.util.b[] bVarArr, d2.l lVar, int i4, u uVar) {
        this(collection, bVarArr, (i4 & 4) != 0 ? c.f58474a : lVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Collection<kotlin.reflect.jvm.internal.impl.name.f> nameList, @NotNull kotlin.reflect.jvm.internal.impl.util.b[] checks, @NotNull d2.l<? super w, String> additionalChecks) {
        this((kotlin.reflect.jvm.internal.impl.name.f) null, (Regex) null, nameList, additionalChecks, (kotlin.reflect.jvm.internal.impl.util.b[]) Arrays.copyOf(checks, checks.length));
        f0.p(nameList, "nameList");
        f0.p(checks, "checks");
        f0.p(additionalChecks, "additionalChecks");
    }
}
