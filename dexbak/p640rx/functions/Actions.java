package p640rx.functions;

import p640rx.exceptions.OnErrorNotImplementedException;

/* renamed from: rx.functions.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Actions {

    /* renamed from: a */
    private static final C15604m f44804a = new C15604m();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T7, T8, T9, T1, T2, T3] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15592a<R, T1, T2, T3, T4, T5, T6, T7, T8, T9> implements Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {

        /* renamed from: a */
        final /* synthetic */ Action9 f44805a;

        /* renamed from: b */
        final /* synthetic */ Object f44806b;

        C15592a(Action9 action9, Object obj) {
            this.f44805a = action9;
            this.f44806b = obj;
        }

        @Override // p640rx.functions.Func9
        public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
            this.f44805a.call(t1, t2, t3, t4, t5, t6, t7, t8, t9);
            return (R) this.f44806b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15593b<R> implements FuncN<R> {

        /* renamed from: a */
        final /* synthetic */ ActionN f44807a;

        /* renamed from: b */
        final /* synthetic */ Object f44808b;

        C15593b(ActionN actionN, Object obj) {
            this.f44807a = actionN;
            this.f44808b = obj;
        }

        @Override // p640rx.functions.FuncN
        public R call(Object... objArr) {
            this.f44807a.call(objArr);
            return (R) this.f44808b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15594c<R> implements Func0<R> {

        /* renamed from: a */
        final /* synthetic */ Action0 f44809a;

        /* renamed from: b */
        final /* synthetic */ Object f44810b;

        C15594c(Action0 action0, Object obj) {
            this.f44809a = action0;
            this.f44810b = obj;
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public R call() {
            this.f44809a.call();
            return (R) this.f44810b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R, T1] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15595d<R, T1> implements Func1<T1, R> {

        /* renamed from: a */
        final /* synthetic */ Action1 f44811a;

        /* renamed from: b */
        final /* synthetic */ Object f44812b;

        C15595d(Action1 action1, Object obj) {
            this.f44811a = action1;
            this.f44812b = obj;
        }

        @Override // p640rx.functions.Func1
        public R call(T1 t1) {
            this.f44811a.call(t1);
            return (R) this.f44812b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R, T1, T2] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15596e<R, T1, T2> implements Func2<T1, T2, R> {

        /* renamed from: a */
        final /* synthetic */ Action2 f44813a;

        /* renamed from: b */
        final /* synthetic */ Object f44814b;

        C15596e(Action2 action2, Object obj) {
            this.f44813a = action2;
            this.f44814b = obj;
        }

        @Override // p640rx.functions.Func2
        public R call(T1 t1, T2 t2) {
            this.f44813a.call(t1, t2);
            return (R) this.f44814b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R, T1, T2, T3] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15597f<R, T1, T2, T3> implements Func3<T1, T2, T3, R> {

        /* renamed from: a */
        final /* synthetic */ Action3 f44815a;

        /* renamed from: b */
        final /* synthetic */ Object f44816b;

        C15597f(Action3 action3, Object obj) {
            this.f44815a = action3;
            this.f44816b = obj;
        }

        @Override // p640rx.functions.Func3
        public R call(T1 t1, T2 t2, T3 t3) {
            this.f44815a.call(t1, t2, t3);
            return (R) this.f44816b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, R, T1, T2, T3] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15598g<R, T1, T2, T3, T4> implements Func4<T1, T2, T3, T4, R> {

        /* renamed from: a */
        final /* synthetic */ Action4 f44817a;

        /* renamed from: b */
        final /* synthetic */ Object f44818b;

        C15598g(Action4 action4, Object obj) {
            this.f44817a = action4;
            this.f44818b = obj;
        }

        @Override // p640rx.functions.Func4
        public R call(T1 t1, T2 t2, T3 t3, T4 t4) {
            this.f44817a.call(t1, t2, t3, t4);
            return (R) this.f44818b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, T5, R, T1, T2, T3] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15599h<R, T1, T2, T3, T4, T5> implements Func5<T1, T2, T3, T4, T5, R> {

        /* renamed from: a */
        final /* synthetic */ Action5 f44819a;

        /* renamed from: b */
        final /* synthetic */ Object f44820b;

        C15599h(Action5 action5, Object obj) {
            this.f44819a = action5;
            this.f44820b = obj;
        }

        @Override // p640rx.functions.Func5
        public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
            this.f44819a.call(t1, t2, t3, t4, t5);
            return (R) this.f44820b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T1, T2, T3] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15600i<R, T1, T2, T3, T4, T5, T6> implements Func6<T1, T2, T3, T4, T5, T6, R> {

        /* renamed from: a */
        final /* synthetic */ Action6 f44821a;

        /* renamed from: b */
        final /* synthetic */ Object f44822b;

        C15600i(Action6 action6, Object obj) {
            this.f44821a = action6;
            this.f44822b = obj;
        }

        @Override // p640rx.functions.Func6
        public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
            this.f44821a.call(t1, t2, t3, t4, t5, t6);
            return (R) this.f44822b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T7, T1, T2, T3] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15601j<R, T1, T2, T3, T4, T5, T6, T7> implements Func7<T1, T2, T3, T4, T5, T6, T7, R> {

        /* renamed from: a */
        final /* synthetic */ Action7 f44823a;

        /* renamed from: b */
        final /* synthetic */ Object f44824b;

        C15601j(Action7 action7, Object obj) {
            this.f44823a = action7;
            this.f44824b = obj;
        }

        @Override // p640rx.functions.Func7
        public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
            this.f44823a.call(t1, t2, t3, t4, t5, t6, t7);
            return (R) this.f44824b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T7, T8, T1, T2, T3] */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$k */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15602k<R, T1, T2, T3, T4, T5, T6, T7, T8> implements Func8<T1, T2, T3, T4, T5, T6, T7, T8, R> {

        /* renamed from: a */
        final /* synthetic */ Action8 f44825a;

        /* renamed from: b */
        final /* synthetic */ Object f44826b;

        C15602k(Action8 action8, Object obj) {
            this.f44825a = action8;
            this.f44826b = obj;
        }

        @Override // p640rx.functions.Func8
        public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
            this.f44825a.call(t1, t2, t3, t4, t5, t6, t7, t8);
            return (R) this.f44826b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$l */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15603l<T> implements Action1<T> {

        /* renamed from: a */
        final Action0 f44827a;

        public C15603l(Action0 action0) {
            this.f44827a = action0;
        }

        @Override // p640rx.functions.Action1
        public void call(T t) {
            this.f44827a.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$m */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15604m<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements Action0, Action1<T0>, Action2<T0, T1>, Action3<T0, T1, T2>, Action4<T0, T1, T2, T3>, Action5<T0, T1, T2, T3, T4>, Action6<T0, T1, T2, T3, T4, T5>, Action7<T0, T1, T2, T3, T4, T5, T6>, Action8<T0, T1, T2, T3, T4, T5, T6, T7>, Action9<T0, T1, T2, T3, T4, T5, T6, T7, T8>, ActionN {
        C15604m() {
        }

        @Override // p640rx.functions.Action0
        public void call() {
        }

        @Override // p640rx.functions.Action1
        public void call(T0 t0) {
        }

        @Override // p640rx.functions.Action2
        public void call(T0 t0, T1 t1) {
        }

        @Override // p640rx.functions.Action3
        public void call(T0 t0, T1 t1, T2 t2) {
        }

        @Override // p640rx.functions.Action4
        public void call(T0 t0, T1 t1, T2 t2, T3 t3) {
        }

        @Override // p640rx.functions.Action5
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4) {
        }

        @Override // p640rx.functions.Action6
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        }

        @Override // p640rx.functions.Action7
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        }

        @Override // p640rx.functions.Action8
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        }

        @Override // p640rx.functions.Action9
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        }

        @Override // p640rx.functions.ActionN
        public void call(Object... objArr) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Actions.java */
    /* renamed from: rx.functions.m$n */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public enum EnumC15605n implements Action1<Throwable> {
        INSTANCE;

        @Override // p640rx.functions.Action1
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    private Actions() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> C15604m<T0, T1, T2, T3, T4, T5, T6, T7, T8> m1455a() {
        return f44804a;
    }

    /* renamed from: b */
    public static Action1<Throwable> m1454b() {
        return EnumC15605n.INSTANCE;
    }

    /* renamed from: c */
    public static <T> Action1<T> m1453c(Action0 action0) {
        return new C15603l(action0);
    }

    /* renamed from: d */
    public static Func0<Void> m1452d(Action0 action0) {
        return m1451e(action0, null);
    }

    /* renamed from: e */
    public static <R> Func0<R> m1451e(Action0 action0, R r) {
        return new C15594c(action0, r);
    }

    /* renamed from: f */
    public static <T1> Func1<T1, Void> m1450f(Action1<T1> action1) {
        return m1449g(action1, null);
    }

    /* renamed from: g */
    public static <T1, R> Func1<T1, R> m1449g(Action1<T1> action1, R r) {
        return new C15595d(action1, r);
    }

    /* renamed from: h */
    public static <T1, T2> Func2<T1, T2, Void> m1448h(Action2<T1, T2> action2) {
        return m1447i(action2, null);
    }

    /* renamed from: i */
    public static <T1, T2, R> Func2<T1, T2, R> m1447i(Action2<T1, T2> action2, R r) {
        return new C15596e(action2, r);
    }

    /* renamed from: j */
    public static <T1, T2, T3> Func3<T1, T2, T3, Void> m1446j(Action3<T1, T2, T3> action3) {
        return m1445k(action3, null);
    }

    /* renamed from: k */
    public static <T1, T2, T3, R> Func3<T1, T2, T3, R> m1445k(Action3<T1, T2, T3> action3, R r) {
        return new C15597f(action3, r);
    }

    /* renamed from: l */
    public static <T1, T2, T3, T4> Func4<T1, T2, T3, T4, Void> m1444l(Action4<T1, T2, T3, T4> action4) {
        return m1443m(action4, null);
    }

    /* renamed from: m */
    public static <T1, T2, T3, T4, R> Func4<T1, T2, T3, T4, R> m1443m(Action4<T1, T2, T3, T4> action4, R r) {
        return new C15598g(action4, r);
    }

    /* renamed from: n */
    public static <T1, T2, T3, T4, T5> Func5<T1, T2, T3, T4, T5, Void> m1442n(Action5<T1, T2, T3, T4, T5> action5) {
        return m1441o(action5, null);
    }

    /* renamed from: o */
    public static <T1, T2, T3, T4, T5, R> Func5<T1, T2, T3, T4, T5, R> m1441o(Action5<T1, T2, T3, T4, T5> action5, R r) {
        return new C15599h(action5, r);
    }

    /* renamed from: p */
    public static <T1, T2, T3, T4, T5, T6> Func6<T1, T2, T3, T4, T5, T6, Void> m1440p(Action6<T1, T2, T3, T4, T5, T6> action6) {
        return m1439q(action6, null);
    }

    /* renamed from: q */
    public static <T1, T2, T3, T4, T5, T6, R> Func6<T1, T2, T3, T4, T5, T6, R> m1439q(Action6<T1, T2, T3, T4, T5, T6> action6, R r) {
        return new C15600i(action6, r);
    }

    /* renamed from: r */
    public static <T1, T2, T3, T4, T5, T6, T7> Func7<T1, T2, T3, T4, T5, T6, T7, Void> m1438r(Action7<T1, T2, T3, T4, T5, T6, T7> action7) {
        return m1437s(action7, null);
    }

    /* renamed from: s */
    public static <T1, T2, T3, T4, T5, T6, T7, R> Func7<T1, T2, T3, T4, T5, T6, T7, R> m1437s(Action7<T1, T2, T3, T4, T5, T6, T7> action7, R r) {
        return new C15601j(action7, r);
    }

    /* renamed from: t */
    public static <T1, T2, T3, T4, T5, T6, T7, T8> Func8<T1, T2, T3, T4, T5, T6, T7, T8, Void> m1436t(Action8<T1, T2, T3, T4, T5, T6, T7, T8> action8) {
        return m1435u(action8, null);
    }

    /* renamed from: u */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Func8<T1, T2, T3, T4, T5, T6, T7, T8, R> m1435u(Action8<T1, T2, T3, T4, T5, T6, T7, T8> action8, R r) {
        return new C15602k(action8, r);
    }

    /* renamed from: v */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Void> m1434v(Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> action9) {
        return m1433w(action9, null);
    }

    /* renamed from: w */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> m1433w(Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> action9, R r) {
        return new C15592a(action9, r);
    }

    /* renamed from: x */
    public static FuncN<Void> m1432x(ActionN actionN) {
        return m1431y(actionN, null);
    }

    /* renamed from: y */
    public static <R> FuncN<R> m1431y(ActionN actionN, R r) {
        return new C15593b(actionN, r);
    }
}
