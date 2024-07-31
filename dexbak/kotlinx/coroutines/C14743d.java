package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Await.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\r\u001a\u00020\f2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0001\"\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\n0\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/x0;", "deferreds", "", "b", "([Lkotlinx/coroutines/x0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "a", "(Ljava/util/Collection;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/e2;", "jobs", "Lkotlin/f1;", "d", "([Lkotlinx/coroutines/e2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "c", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14743d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Await.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/x0;", "deferreds", "Lkotlin/coroutines/c;", "", "continuation", "", "awaitAll"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.AwaitKt", m8638f = "Await.kt", m8637i = {0}, m8636l = {26}, m8635m = "awaitAll", m8634n = {"deferreds"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14744a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42166a;

        /* renamed from: b */
        int f42167b;

        /* renamed from: c */
        Object f42168c;

        C14744a(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42166a = obj;
            this.f42167b |= Integer.MIN_VALUE;
            return C14743d.m5159b(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Await.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/x0;", "Lkotlin/coroutines/c;", "", "continuation", "", "awaitAll"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.AwaitKt", m8638f = "Await.kt", m8637i = {0}, m8636l = {43}, m8635m = "awaitAll", m8634n = {"$this$awaitAll"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.d$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14745b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42169a;

        /* renamed from: b */
        int f42170b;

        /* renamed from: c */
        Object f42171c;

        C14745b(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42169a = obj;
            this.f42170b |= Integer.MIN_VALUE;
            return C14743d.m5160a(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Await.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000\"\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@"}, m12616d2 = {"", "Lkotlinx/coroutines/e2;", "jobs", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "joinAll"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.AwaitKt", m8638f = "Await.kt", m8637i = {0, 0, 0, 0}, m8636l = {55}, m8635m = "joinAll", m8634n = {"jobs", "$this$forEach$iv", "element$iv", "it"}, m8633s = {"L$0", "L$1", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.d$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14746c extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42172a;

        /* renamed from: b */
        int f42173b;

        /* renamed from: c */
        Object f42174c;

        /* renamed from: d */
        Object f42175d;

        /* renamed from: e */
        Object f42176e;

        /* renamed from: f */
        Object f42177f;

        /* renamed from: g */
        Object f42178g;

        /* renamed from: h */
        int f42179h;

        /* renamed from: i */
        int f42180i;

        C14746c(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42172a = obj;
            this.f42173b |= Integer.MIN_VALUE;
            return C14743d.m5157d(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Await.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@"}, m12616d2 = {"", "Lkotlinx/coroutines/e2;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "joinAll"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.AwaitKt", m8638f = "Await.kt", m8637i = {0, 0, 0, 0}, m8636l = {67}, m8635m = "joinAll", m8634n = {"$this$joinAll", "$this$forEach$iv", "element$iv", "it"}, m8633s = {"L$0", "L$1", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.d$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14747d extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42181a;

        /* renamed from: b */
        int f42182b;

        /* renamed from: c */
        Object f42183c;

        /* renamed from: d */
        Object f42184d;

        /* renamed from: e */
        Object f42185e;

        /* renamed from: f */
        Object f42186f;

        /* renamed from: g */
        Object f42187g;

        C14747d(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42181a = obj;
            this.f42182b |= Integer.MIN_VALUE;
            return C14743d.m5158c(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m5160a(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlinx.coroutines.Deferred<? extends T>> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.List<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.C14743d.C14745b
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.d$b r0 = (kotlinx.coroutines.C14743d.C14745b) r0
            int r1 = r0.f42170b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42170b = r1
            goto L18
        L13:
            kotlinx.coroutines.d$b r0 = new kotlinx.coroutines.d$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f42169a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42170b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f42171c
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.C14294d0.m8596n(r5)
            goto L5e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C14294d0.m8596n(r5)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L43
            java.util.List r4 = kotlin.collections.C14233v.m9031E()
            goto L61
        L43:
            kotlinx.coroutines.c r5 = new kotlinx.coroutines.c
            r2 = 0
            kotlinx.coroutines.x0[] r2 = new kotlinx.coroutines.Deferred[r2]
            java.lang.Object[] r2 = r4.toArray(r2)
            if (r2 == 0) goto L62
            kotlinx.coroutines.x0[] r2 = (kotlinx.coroutines.Deferred[]) r2
            r5.<init>(r2)
            r0.f42171c = r4
            r0.f42170b = r3
            java.lang.Object r5 = r5.m5716b(r0)
            if (r5 != r1) goto L5e
            return r1
        L5e:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
        L61:
            return r4
        L62:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T>"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C14743d.m5160a(java.util.Collection, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m5159b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Deferred<? extends T>[] r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.List<? extends T>> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.C14743d.C14744a
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.d$a r0 = (kotlinx.coroutines.C14743d.C14744a) r0
            int r1 = r0.f42167b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42167b = r1
            goto L18
        L13:
            kotlinx.coroutines.d$a r0 = new kotlinx.coroutines.d$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f42166a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42167b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f42168c
            kotlinx.coroutines.x0[] r4 = (kotlinx.coroutines.Deferred[]) r4
            kotlin.C14294d0.m8596n(r5)
            goto L55
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C14294d0.m8596n(r5)
            int r5 = r4.length
            if (r5 != 0) goto L3d
            r5 = 1
            goto L3e
        L3d:
            r5 = 0
        L3e:
            if (r5 == 0) goto L45
            java.util.List r4 = kotlin.collections.C14233v.m9031E()
            goto L58
        L45:
            kotlinx.coroutines.c r5 = new kotlinx.coroutines.c
            r5.<init>(r4)
            r0.f42168c = r4
            r0.f42167b = r3
            java.lang.Object r5 = r5.m5716b(r0)
            if (r5 != r1) goto L55
            return r1
        L55:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
        L58:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C14743d.m5159b(kotlinx.coroutines.x0[], kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m5158c(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlinx.coroutines.Job> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.C14743d.C14747d
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.d$d r0 = (kotlinx.coroutines.C14743d.C14747d) r0
            int r1 = r0.f42182b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42182b = r1
            goto L18
        L13:
            kotlinx.coroutines.d$d r0 = new kotlinx.coroutines.d$d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f42181a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42182b
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r7 = r0.f42187g
            kotlinx.coroutines.e2 r7 = (kotlinx.coroutines.Job) r7
            java.lang.Object r7 = r0.f42185e
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.f42184d
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r4 = r0.f42183c
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.C14294d0.m8596n(r8)
            r8 = r4
            r6 = r1
            r1 = r0
            r0 = r2
            r2 = r6
            goto L52
        L3e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L46:
            kotlin.C14294d0.m8596n(r8)
            java.util.Iterator r8 = r7.iterator()
            r2 = r1
            r1 = r0
            r0 = r7
            r7 = r8
            r8 = r0
        L52:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L72
            java.lang.Object r4 = r7.next()
            r5 = r4
            kotlinx.coroutines.e2 r5 = (kotlinx.coroutines.Job) r5
            r1.f42183c = r8
            r1.f42184d = r0
            r1.f42185e = r7
            r1.f42186f = r4
            r1.f42187g = r5
            r1.f42182b = r3
            java.lang.Object r4 = r5.mo3831E(r1)
            if (r4 != r2) goto L52
            return r2
        L72:
            kotlin.f1 r7 = kotlin.Unit.f41048a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C14743d.m5158c(java.util.Collection, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0073 -> B:19:0x0076). Please submit an issue!!! */
    @org.jetbrains.annotations.Nullable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m5157d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job[] r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.C14743d.C14746c
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.d$c r0 = (kotlinx.coroutines.C14743d.C14746c) r0
            int r1 = r0.f42173b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42173b = r1
            goto L18
        L13:
            kotlinx.coroutines.d$c r0 = new kotlinx.coroutines.d$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f42172a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42173b
            r3 = 1
            if (r2 == 0) goto L4f
            if (r2 != r3) goto L47
            java.lang.Object r7 = r0.f42178g
            kotlinx.coroutines.e2 r7 = (kotlinx.coroutines.Job) r7
            java.lang.Object r7 = r0.f42177f
            kotlinx.coroutines.e2 r7 = (kotlinx.coroutines.Job) r7
            int r7 = r0.f42180i
            int r2 = r0.f42179h
            java.lang.Object r4 = r0.f42176e
            kotlinx.coroutines.e2[] r4 = (kotlinx.coroutines.Job[]) r4
            java.lang.Object r5 = r0.f42175d
            kotlinx.coroutines.e2[] r5 = (kotlinx.coroutines.Job[]) r5
            java.lang.Object r6 = r0.f42174c
            kotlinx.coroutines.e2[] r6 = (kotlinx.coroutines.Job[]) r6
            kotlin.C14294d0.m8596n(r8)
            r8 = r4
            r4 = r1
            r1 = r5
            r5 = r2
            r2 = r0
            r0 = r6
            goto L76
        L47:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L4f:
            kotlin.C14294d0.m8596n(r8)
            int r8 = r7.length
            r2 = 0
            r5 = r8
            r2 = r0
            r4 = r1
            r8 = r7
            r0 = r8
            r1 = r0
            r7 = 0
        L5b:
            if (r7 >= r5) goto L78
            r6 = r8[r7]
            r2.f42174c = r0
            r2.f42175d = r1
            r2.f42176e = r8
            r2.f42179h = r5
            r2.f42180i = r7
            r2.f42177f = r6
            r2.f42178g = r6
            r2.f42173b = r3
            java.lang.Object r6 = r6.mo3831E(r2)
            if (r6 != r4) goto L76
            return r4
        L76:
            int r7 = r7 + r3
            goto L5b
        L78:
            kotlin.f1 r7 = kotlin.Unit.f41048a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C14743d.m5157d(kotlinx.coroutines.e2[], kotlin.coroutines.c):java.lang.Object");
    }
}
