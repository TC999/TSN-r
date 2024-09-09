package kotlin.reflect.jvm.internal.impl.utils;

import d2.l;
import d2.p;
import d2.q;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: functions.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final l<Object, Object> f58536a = f.f58547a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final l<Object, Boolean> f58537b = b.f58543a;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final l<Object, Object> f58538c = a.f58542a;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final l<Object, f1> f58539d = c.f58544a;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final p<Object, Object, f1> f58540e = C1190d.f58545a;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final q<Object, Object, Object, f1> f58541f = e.f58546a;

    /* compiled from: functions.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f58542a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final Void invoke(@Nullable Object obj) {
            return null;
        }
    }

    /* compiled from: functions.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements l<Object, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f58543a = new b();

        b() {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d2.l
        @NotNull
        public final Boolean invoke(@Nullable Object obj) {
            return Boolean.TRUE;
        }
    }

    /* compiled from: functions.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements l<Object, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f58544a = new c();

        c() {
            super(1);
        }

        public final void a(@Nullable Object obj) {
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Object obj) {
            a(obj);
            return f1.f55527a;
        }
    }

    /* compiled from: functions.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.utils.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1190d extends Lambda implements p<Object, Object, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final C1190d f58545a = new C1190d();

        C1190d() {
            super(2);
        }

        public final void a(@Nullable Object obj, @Nullable Object obj2) {
        }

        @Override // d2.p
        public /* bridge */ /* synthetic */ f1 invoke(Object obj, Object obj2) {
            a(obj, obj2);
            return f1.f55527a;
        }
    }

    /* compiled from: functions.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e extends Lambda implements q<Object, Object, Object, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f58546a = new e();

        e() {
            super(3);
        }

        public final void a(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        }

        @Override // d2.q
        public /* bridge */ /* synthetic */ f1 invoke(Object obj, Object obj2, Object obj3) {
            a(obj, obj2, obj3);
            return f1.f55527a;
        }
    }

    /* compiled from: functions.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class f extends Lambda implements l<Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f58547a = new f();

        f() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        public final Object invoke(@Nullable Object obj) {
            return obj;
        }
    }

    @NotNull
    public static final <T> l<T, Boolean> a() {
        return (l<T, Boolean>) f58537b;
    }

    @NotNull
    public static final q<Object, Object, Object, f1> b() {
        return f58541f;
    }
}
