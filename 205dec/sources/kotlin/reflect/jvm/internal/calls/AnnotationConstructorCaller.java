package kotlin.reflect.jvm.internal.calls;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.y;
import kotlin.collections.z0;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.calls.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002)*BA\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010&\u001a\u00020%\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\f\u00a2\u0006\u0004\b'\u0010(J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\t\u0010\u001aR\u001e\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u001c\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000fR\u0016\u0010!\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010 R\u0014\u0010$\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006+"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/c;", "", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "jClass", "", "", "b", "Ljava/util/List;", "parameterNames", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "c", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "callMode", "Ljava/lang/reflect/Method;", "d", "methods", "Ljava/lang/reflect/Type;", "e", "()Ljava/util/List;", "parameterTypes", "f", "erasedParameterTypes", "g", "defaultValues", "()Ljava/lang/Void;", "member", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", LiveConfigKey.ORIGIN, "<init>", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class AnnotationConstructorCaller implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f55880a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f55881b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final CallMode f55882c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final List<Method> f55883d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final List<Type> f55884e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final List<Class<?>> f55885f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final List<Object> f55886g;

    /* compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    /* compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum Origin {
        JAVA,
        KOTLIN
    }

    public AnnotationConstructorCaller(@NotNull Class<?> jClass, @NotNull List<String> parameterNames, @NotNull CallMode callMode, @NotNull Origin origin, @NotNull List<Method> methods) {
        int Z;
        int Z2;
        int Z3;
        List b4;
        f0.p(jClass, "jClass");
        f0.p(parameterNames, "parameterNames");
        f0.p(callMode, "callMode");
        f0.p(origin, "origin");
        f0.p(methods, "methods");
        this.f55880a = jClass;
        this.f55881b = parameterNames;
        this.f55882c = callMode;
        this.f55883d = methods;
        Z = y.Z(methods, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (Method method : methods) {
            arrayList.add(method.getGenericReturnType());
        }
        this.f55884e = arrayList;
        List<Method> list = this.f55883d;
        Z2 = y.Z(list, 10);
        ArrayList arrayList2 = new ArrayList(Z2);
        for (Method method2 : list) {
            Class<?> it = method2.getReturnType();
            f0.o(it, "it");
            Class<?> g4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.g(it);
            if (g4 != null) {
                it = g4;
            }
            arrayList2.add(it);
        }
        this.f55885f = arrayList2;
        List<Method> list2 = this.f55883d;
        Z3 = y.Z(list2, 10);
        ArrayList arrayList3 = new ArrayList(Z3);
        for (Method method3 : list2) {
            arrayList3.add(method3.getDefaultValue());
        }
        this.f55886g = arrayList3;
        if (this.f55882c == CallMode.POSITIONAL_CALL && origin == Origin.JAVA) {
            b4 = kotlin.collections.f0.b4(this.f55881b, "value");
            if (!b4.isEmpty()) {
                throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @NotNull
    public List<Type> a() {
        return this.f55884e;
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    public /* bridge */ /* synthetic */ Member b() {
        return (Member) d();
    }

    public void c(@NotNull Object[] objArr) {
        c.a.a(this, objArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @Nullable
    public Object call(@NotNull Object[] args) {
        List T5;
        Map B0;
        f0.p(args, "args");
        c(args);
        ArrayList arrayList = new ArrayList(args.length);
        int length = args.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            Object obj = args[i4];
            i4++;
            int i6 = i5 + 1;
            Object l4 = (obj == null && this.f55882c == CallMode.CALL_BY_NAME) ? this.f55886g.get(i5) : a.l(obj, this.f55885f.get(i5));
            if (l4 == null) {
                a.k(i5, this.f55881b.get(i5), this.f55885f.get(i5));
                throw null;
            }
            arrayList.add(l4);
            i5 = i6;
        }
        Class<?> cls = this.f55880a;
        T5 = kotlin.collections.f0.T5(this.f55881b, arrayList);
        B0 = z0.B0(T5);
        return a.f(cls, B0, this.f55883d);
    }

    @Nullable
    public Void d() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @NotNull
    public Type getReturnType() {
        return this.f55880a;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AnnotationConstructorCaller(java.lang.Class r7, java.util.List r8, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode r9, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin r10, java.util.List r11, int r12, kotlin.jvm.internal.u r13) {
        /*
            r6 = this;
            r12 = r12 & 16
            if (r12 == 0) goto L2a
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = kotlin.collections.w.Z(r8, r12)
            r11.<init>(r12)
            java.util.Iterator r12 = r8.iterator()
        L13:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L2a
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            r0 = 0
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.reflect.Method r13 = r7.getDeclaredMethod(r13, r0)
            r11.add(r13)
            goto L13
        L2a:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.<init>(java.lang.Class, java.util.List, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$Origin, java.util.List, int, kotlin.jvm.internal.u):void");
    }
}
