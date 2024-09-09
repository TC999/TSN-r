package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.reflect.KParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KCallables.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\u001a\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a;\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a9\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\"$\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\"$\u0010\u0015\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000f\"(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lkotlin/reflect/c;", "", "name", "Lkotlin/reflect/KParameter;", "c", "R", "", "", "args", "a", "(Lkotlin/reflect/c;[Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "b", "(Lkotlin/reflect/c;Ljava/util/Map;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "(Lkotlin/reflect/c;)Lkotlin/reflect/KParameter;", "getInstanceParameter$annotations", "(Lkotlin/reflect/c;)V", "instanceParameter", "d", "getExtensionReceiverParameter$annotations", "extensionReceiverParameter", "", "h", "(Lkotlin/reflect/c;)Ljava/util/List;", "getValueParameters$annotations", "valueParameters", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "KCallables")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KCallables.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0}, l = {56}, m = "callSuspend", n = {"$this$callSuspend", "args"}, s = {"L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<R> extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        Object f55842a;

        /* renamed from: b  reason: collision with root package name */
        Object f55843b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f55844c;

        /* renamed from: d  reason: collision with root package name */
        int f55845d;

        a(kotlin.coroutines.c<? super a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f55844c = obj;
            this.f55845d |= Integer.MIN_VALUE;
            return c.a(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KCallables.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0, 0}, l = {74}, m = "callSuspendBy", n = {"$this$callSuspendBy", "args", "kCallable"}, s = {"L$0", "L$1", "L$2"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<R> extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        Object f55846a;

        /* renamed from: b  reason: collision with root package name */
        Object f55847b;

        /* renamed from: c  reason: collision with root package name */
        Object f55848c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f55849d;

        /* renamed from: e  reason: collision with root package name */
        int f55850e;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f55849d = obj;
            this.f55850e |= Integer.MIN_VALUE;
            return c.b(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.reflect.c<? extends R> r4, @org.jetbrains.annotations.NotNull java.lang.Object[] r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super R> r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.c.a
            if (r0 == 0) goto L13
            r0 = r6
            kotlin.reflect.full.c$a r0 = (kotlin.reflect.full.c.a) r0
            int r1 = r0.f55845d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f55845d = r1
            goto L18
        L13:
            kotlin.reflect.full.c$a r0 = new kotlin.reflect.full.c$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f55844c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f55845d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.f55843b
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r4 = r0.f55842a
            kotlin.reflect.c r4 = (kotlin.reflect.c) r4
            kotlin.d0.n(r6)
            goto L7c
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.d0.n(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L4c
            int r6 = r5.length
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6)
            java.lang.Object r4 = r4.call(r5)
            return r4
        L4c:
            boolean r6 = r4 instanceof kotlin.reflect.i
            if (r6 == 0) goto L9e
            r0.f55842a = r4
            r0.f55843b = r5
            r0.f55845d = r3
            kotlin.jvm.internal.r0 r6 = new kotlin.jvm.internal.r0
            r2 = 2
            r6.<init>(r2)
            r6.b(r5)
            r6.a(r0)
            int r5 = r6.c()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Object[] r5 = r6.d(r5)
            java.lang.Object r6 = r4.call(r5)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.a.h()
            if (r6 != r5) goto L79
            kotlin.coroutines.jvm.internal.e.c(r0)
        L79:
            if (r6 != r1) goto L7c
            return r1
        L7c:
            kotlin.reflect.r r5 = r4.getReturnType()
            kotlin.reflect.g r5 = r5.a()
            java.lang.Class<kotlin.f1> r0 = kotlin.f1.class
            kotlin.reflect.d r0 = kotlin.jvm.internal.n0.d(r0)
            boolean r5 = kotlin.jvm.internal.f0.g(r5, r0)
            if (r5 == 0) goto L9d
            kotlin.reflect.r r4 = r4.getReturnType()
            boolean r4 = r4.b()
            if (r4 != 0) goto L9d
            kotlin.f1 r4 = kotlin.f1.f55527a
            return r4
        L9d:
            return r6
        L9e:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Cannot callSuspend on a property "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.c.a(kotlin.reflect.c, java.lang.Object[], kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.reflect.c<? extends R> r4, @org.jetbrains.annotations.NotNull java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super R> r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.c.b
            if (r0 == 0) goto L13
            r0 = r6
            kotlin.reflect.full.c$b r0 = (kotlin.reflect.full.c.b) r0
            int r1 = r0.f55850e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f55850e = r1
            goto L18
        L13:
            kotlin.reflect.full.c$b r0 = new kotlin.reflect.full.c$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f55849d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f55850e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.f55848c
            kotlin.reflect.jvm.internal.f r4 = (kotlin.reflect.jvm.internal.f) r4
            java.lang.Object r4 = r0.f55847b
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r4 = r0.f55846a
            kotlin.reflect.c r4 = (kotlin.reflect.c) r4
            kotlin.d0.n(r6)
            goto L6d
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.d0.n(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L4b
            java.lang.Object r4 = r4.callBy(r5)
            return r4
        L4b:
            boolean r6 = r4 instanceof kotlin.reflect.i
            if (r6 == 0) goto L9b
            kotlin.reflect.jvm.internal.f r6 = kotlin.reflect.jvm.internal.f0.b(r4)
            if (r6 == 0) goto L8f
            r0.f55846a = r4
            r0.f55847b = r5
            r0.f55848c = r6
            r0.f55850e = r3
            java.lang.Object r6 = r6.l(r5, r0)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.a.h()
            if (r6 != r5) goto L6a
            kotlin.coroutines.jvm.internal.e.c(r0)
        L6a:
            if (r6 != r1) goto L6d
            return r1
        L6d:
            kotlin.reflect.r r5 = r4.getReturnType()
            kotlin.reflect.g r5 = r5.a()
            java.lang.Class<kotlin.f1> r0 = kotlin.f1.class
            kotlin.reflect.d r0 = kotlin.jvm.internal.n0.d(r0)
            boolean r5 = kotlin.jvm.internal.f0.g(r5, r0)
            if (r5 == 0) goto L8e
            kotlin.reflect.r r4 = r4.getReturnType()
            boolean r4 = r4.b()
            if (r4 != 0) goto L8e
            kotlin.f1 r4 = kotlin.f1.f55527a
            return r4
        L8e:
            return r6
        L8f:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r5 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.String r6 = "This callable does not support a default call: "
            java.lang.String r4 = kotlin.jvm.internal.f0.C(r6, r4)
            r5.<init>(r4)
            throw r5
        L9b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Cannot callSuspendBy on a property "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.c.b(kotlin.reflect.c, java.util.Map, kotlin.coroutines.c):java.lang.Object");
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final KParameter c(@NotNull kotlin.reflect.c<?> cVar, @NotNull String name) {
        f0.p(cVar, "<this>");
        f0.p(name, "name");
        Iterator<T> it = cVar.getParameters().iterator();
        Object obj = null;
        boolean z3 = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (f0.g(((KParameter) next).getName(), name)) {
                    if (z3) {
                        break;
                    }
                    z3 = true;
                    obj2 = next;
                }
            } else if (z3) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @Nullable
    public static final KParameter d(@NotNull kotlin.reflect.c<?> cVar) {
        f0.p(cVar, "<this>");
        Iterator<T> it = cVar.getParameters().iterator();
        Object obj = null;
        Object obj2 = null;
        boolean z3 = false;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).i() == KParameter.Kind.EXTENSION_RECEIVER) {
                    if (z3) {
                        break;
                    }
                    obj2 = next;
                    z3 = true;
                }
            } else if (z3) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void e(kotlin.reflect.c cVar) {
    }

    @Nullable
    public static final KParameter f(@NotNull kotlin.reflect.c<?> cVar) {
        f0.p(cVar, "<this>");
        Iterator<T> it = cVar.getParameters().iterator();
        Object obj = null;
        Object obj2 = null;
        boolean z3 = false;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).i() == KParameter.Kind.INSTANCE) {
                    if (z3) {
                        break;
                    }
                    obj2 = next;
                    z3 = true;
                }
            } else if (z3) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void g(kotlin.reflect.c cVar) {
    }

    @NotNull
    public static final List<KParameter> h(@NotNull kotlin.reflect.c<?> cVar) {
        f0.p(cVar, "<this>");
        List<KParameter> parameters = cVar.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).i() == KParameter.Kind.VALUE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void i(kotlin.reflect.c cVar) {
    }
}
