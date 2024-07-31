package p640rx.plugins;

import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
import p640rx.Completable;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Single;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Func0;
import p640rx.functions.Func1;
import p640rx.functions.Func2;
import p640rx.internal.operators.OnSubscribeOnAssembly;
import p640rx.internal.operators.OnSubscribeOnAssemblyCompletable;
import p640rx.internal.operators.OnSubscribeOnAssemblySingle;
import p640rx.internal.operators.SingleFromObservable;
import p640rx.internal.operators.SingleToObservable;

/* renamed from: rx.plugins.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class RxJavaHooks {

    /* renamed from: a */
    static volatile boolean f46936a;

    /* renamed from: b */
    static volatile Action1<Throwable> f46937b;

    /* renamed from: c */
    static volatile Func1<Observable.InterfaceC15567a, Observable.InterfaceC15567a> f46938c;

    /* renamed from: d */
    static volatile Func1<Single.InterfaceC15633t, Single.InterfaceC15633t> f46939d;

    /* renamed from: e */
    static volatile Func1<Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> f46940e;

    /* renamed from: f */
    static volatile Func2<Observable, Observable.InterfaceC15567a, Observable.InterfaceC15567a> f46941f;

    /* renamed from: g */
    static volatile Func2<Single, Single.InterfaceC15633t, Single.InterfaceC15633t> f46942g;

    /* renamed from: h */
    static volatile Func2<Completable, Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> f46943h;

    /* renamed from: i */
    static volatile Func1<Scheduler, Scheduler> f46944i;

    /* renamed from: j */
    static volatile Func1<Scheduler, Scheduler> f46945j;

    /* renamed from: k */
    static volatile Func1<Scheduler, Scheduler> f46946k;

    /* renamed from: l */
    static volatile Func1<Action0, Action0> f46947l;

    /* renamed from: m */
    static volatile Func1<Subscription, Subscription> f46948m;

    /* renamed from: n */
    static volatile Func1<Subscription, Subscription> f46949n;

    /* renamed from: o */
    static volatile Func0<? extends ScheduledExecutorService> f46950o;

    /* renamed from: p */
    static volatile Func1<Throwable, Throwable> f46951p;

    /* renamed from: q */
    static volatile Func1<Throwable, Throwable> f46952q;

    /* renamed from: r */
    static volatile Func1<Throwable, Throwable> f46953r;

    /* renamed from: s */
    static volatile Func1<Observable.InterfaceC15568b, Observable.InterfaceC15568b> f46954s;

    /* renamed from: t */
    static volatile Func1<Observable.InterfaceC15568b, Observable.InterfaceC15568b> f46955t;

    /* renamed from: u */
    static volatile Func1<Completable.InterfaceC15542k0, Completable.InterfaceC15542k0> f46956u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16137a implements Func1<Throwable, Throwable> {
        C16137a() {
        }

        @Override // p640rx.functions.Func1
        public Throwable call(Throwable th) {
            return RxJavaPlugins.m507c().m503g().m483c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16138b implements Func1<Observable.InterfaceC15568b, Observable.InterfaceC15568b> {
        C16138b() {
        }

        @Override // p640rx.functions.Func1
        public Observable.InterfaceC15568b call(Observable.InterfaceC15568b interfaceC15568b) {
            return RxJavaPlugins.m507c().m503g().m484b(interfaceC15568b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16139c implements Func1<Throwable, Throwable> {
        C16139c() {
        }

        @Override // p640rx.functions.Func1
        public Throwable call(Throwable th) {
            return RxJavaPlugins.m507c().m509a().m589c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16140d implements Func1<Completable.InterfaceC15542k0, Completable.InterfaceC15542k0> {
        C16140d() {
        }

        @Override // p640rx.functions.Func1
        public Completable.InterfaceC15542k0 call(Completable.InterfaceC15542k0 interfaceC15542k0) {
            return RxJavaPlugins.m507c().m509a().m590b(interfaceC15542k0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16141e implements Func1<Observable.InterfaceC15567a, Observable.InterfaceC15567a> {
        C16141e() {
        }

        @Override // p640rx.functions.Func1
        public Observable.InterfaceC15567a call(Observable.InterfaceC15567a interfaceC15567a) {
            return RxJavaPlugins.m507c().m506d().m515a(interfaceC15567a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16142f implements Func1<Single.InterfaceC15633t, Single.InterfaceC15633t> {
        C16142f() {
        }

        @Override // p640rx.functions.Func1
        public Single.InterfaceC15633t call(Single.InterfaceC15633t interfaceC15633t) {
            return RxJavaPlugins.m507c().m503g().m485a(interfaceC15633t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16143g implements Func1<Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> {
        C16143g() {
        }

        @Override // p640rx.functions.Func1
        public Completable.InterfaceC15540j0 call(Completable.InterfaceC15540j0 interfaceC15540j0) {
            return RxJavaPlugins.m507c().m509a().m591a(interfaceC15540j0);
        }
    }

    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16144h implements Func1<Observable.InterfaceC15567a, Observable.InterfaceC15567a> {
        C16144h() {
        }

        @Override // p640rx.functions.Func1
        public Observable.InterfaceC15567a call(Observable.InterfaceC15567a interfaceC15567a) {
            return new OnSubscribeOnAssembly(interfaceC15567a);
        }
    }

    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16145i implements Func1<Single.InterfaceC15633t, Single.InterfaceC15633t> {
        C16145i() {
        }

        @Override // p640rx.functions.Func1
        public Single.InterfaceC15633t call(Single.InterfaceC15633t interfaceC15633t) {
            return new OnSubscribeOnAssemblySingle(interfaceC15633t);
        }
    }

    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16146j implements Func1<Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> {
        C16146j() {
        }

        @Override // p640rx.functions.Func1
        public Completable.InterfaceC15540j0 call(Completable.InterfaceC15540j0 interfaceC15540j0) {
            return new OnSubscribeOnAssemblyCompletable(interfaceC15540j0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$k */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16147k implements Action1<Throwable> {
        C16147k() {
        }

        @Override // p640rx.functions.Action1
        public void call(Throwable th) {
            RxJavaPlugins.m507c().m508b().m587a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$l */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16148l implements Func2<Observable, Observable.InterfaceC15567a, Observable.InterfaceC15567a> {
        C16148l() {
        }

        @Override // p640rx.functions.Func2
        public Observable.InterfaceC15567a call(Observable observable, Observable.InterfaceC15567a interfaceC15567a) {
            return RxJavaPlugins.m507c().m506d().m511e(observable, interfaceC15567a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$m */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16149m implements Func1<Subscription, Subscription> {
        C16149m() {
        }

        @Override // p640rx.functions.Func1
        public Subscription call(Subscription subscription) {
            return RxJavaPlugins.m507c().m506d().m512d(subscription);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$n */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16150n implements Func2<Single, Single.InterfaceC15633t, Single.InterfaceC15633t> {
        C16150n() {
        }

        @Override // p640rx.functions.Func2
        public Single.InterfaceC15633t call(Single single, Single.InterfaceC15633t interfaceC15633t) {
            RxJavaSingleExecutionHook m503g = RxJavaPlugins.m507c().m503g();
            return m503g == RxJavaSingleExecutionHookDefault.m480f() ? interfaceC15633t : new SingleFromObservable(m503g.m481e(single, new SingleToObservable(interfaceC15633t)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$o */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16151o implements Func1<Subscription, Subscription> {
        C16151o() {
        }

        @Override // p640rx.functions.Func1
        public Subscription call(Subscription subscription) {
            return RxJavaPlugins.m507c().m503g().m482d(subscription);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$p */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16152p implements Func2<Completable, Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> {
        C16152p() {
        }

        @Override // p640rx.functions.Func2
        public Completable.InterfaceC15540j0 call(Completable completable, Completable.InterfaceC15540j0 interfaceC15540j0) {
            return RxJavaPlugins.m507c().m509a().m588d(completable, interfaceC15540j0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$q */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16153q implements Func1<Action0, Action0> {
        C16153q() {
        }

        @Override // p640rx.functions.Func1
        public Action0 call(Action0 action0) {
            return RxJavaPlugins.m507c().m504f().m486k(action0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$r */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16154r implements Func1<Throwable, Throwable> {
        C16154r() {
        }

        @Override // p640rx.functions.Func1
        public Throwable call(Throwable th) {
            return RxJavaPlugins.m507c().m506d().m513c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxJavaHooks.java */
    /* renamed from: rx.plugins.c$s */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C16155s implements Func1<Observable.InterfaceC15568b, Observable.InterfaceC15568b> {
        C16155s() {
        }

        @Override // p640rx.functions.Func1
        public Observable.InterfaceC15568b call(Observable.InterfaceC15568b interfaceC15568b) {
            return RxJavaPlugins.m507c().m506d().m514b(interfaceC15568b);
        }
    }

    static {
        m518x();
    }

    private RxJavaHooks() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: A */
    public static void m584A() {
        f46936a = true;
    }

    /* renamed from: B */
    public static Throwable m583B(Throwable th) {
        Func1<Throwable, Throwable> func1 = f46953r;
        return func1 != null ? func1.call(th) : th;
    }

    /* renamed from: C */
    public static <T, R> Completable.InterfaceC15542k0 m582C(Completable.InterfaceC15542k0 interfaceC15542k0) {
        Func1<Completable.InterfaceC15542k0, Completable.InterfaceC15542k0> func1 = f46956u;
        return func1 != null ? func1.call(interfaceC15542k0) : interfaceC15542k0;
    }

    /* renamed from: D */
    public static <T> Completable.InterfaceC15540j0 m581D(Completable completable, Completable.InterfaceC15540j0 interfaceC15540j0) {
        Func2<Completable, Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> func2 = f46943h;
        return func2 != null ? func2.call(completable, interfaceC15540j0) : interfaceC15540j0;
    }

    /* renamed from: E */
    public static Scheduler m580E(Scheduler scheduler) {
        Func1<Scheduler, Scheduler> func1 = f46944i;
        return func1 != null ? func1.call(scheduler) : scheduler;
    }

    /* renamed from: F */
    public static Completable.InterfaceC15540j0 m579F(Completable.InterfaceC15540j0 interfaceC15540j0) {
        Func1<Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> func1 = f46940e;
        return func1 != null ? func1.call(interfaceC15540j0) : interfaceC15540j0;
    }

    /* renamed from: G */
    public static <T> Observable.InterfaceC15567a<T> m578G(Observable.InterfaceC15567a<T> interfaceC15567a) {
        Func1<Observable.InterfaceC15567a, Observable.InterfaceC15567a> func1 = f46938c;
        return func1 != null ? func1.call(interfaceC15567a) : interfaceC15567a;
    }

    /* renamed from: H */
    public static <T> Single.InterfaceC15633t<T> m577H(Single.InterfaceC15633t<T> interfaceC15633t) {
        Func1<Single.InterfaceC15633t, Single.InterfaceC15633t> func1 = f46939d;
        return func1 != null ? func1.call(interfaceC15633t) : interfaceC15633t;
    }

    /* renamed from: I */
    public static void m576I(Throwable th) {
        Action1<Throwable> action1 = f46937b;
        if (action1 != null) {
            try {
                action1.call(th);
                return;
            } catch (Throwable th2) {
                PrintStream printStream = System.err;
                printStream.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                m525q0(th2);
            }
        }
        m525q0(th);
    }

    /* renamed from: J */
    public static Scheduler m575J(Scheduler scheduler) {
        Func1<Scheduler, Scheduler> func1 = f46945j;
        return func1 != null ? func1.call(scheduler) : scheduler;
    }

    /* renamed from: K */
    public static Scheduler m574K(Scheduler scheduler) {
        Func1<Scheduler, Scheduler> func1 = f46946k;
        return func1 != null ? func1.call(scheduler) : scheduler;
    }

    /* renamed from: L */
    public static Throwable m573L(Throwable th) {
        Func1<Throwable, Throwable> func1 = f46951p;
        return func1 != null ? func1.call(th) : th;
    }

    /* renamed from: M */
    public static <T, R> Observable.InterfaceC15568b<R, T> m572M(Observable.InterfaceC15568b<R, T> interfaceC15568b) {
        Func1<Observable.InterfaceC15568b, Observable.InterfaceC15568b> func1 = f46954s;
        return func1 != null ? func1.call(interfaceC15568b) : interfaceC15568b;
    }

    /* renamed from: N */
    public static Subscription m571N(Subscription subscription) {
        Func1<Subscription, Subscription> func1 = f46948m;
        return func1 != null ? func1.call(subscription) : subscription;
    }

    /* renamed from: O */
    public static <T> Observable.InterfaceC15567a<T> m570O(Observable<T> observable, Observable.InterfaceC15567a<T> interfaceC15567a) {
        Func2<Observable, Observable.InterfaceC15567a, Observable.InterfaceC15567a> func2 = f46941f;
        return func2 != null ? func2.call(observable, interfaceC15567a) : interfaceC15567a;
    }

    /* renamed from: P */
    public static Action0 m569P(Action0 action0) {
        Func1<Action0, Action0> func1 = f46947l;
        return func1 != null ? func1.call(action0) : action0;
    }

    /* renamed from: Q */
    public static Throwable m568Q(Throwable th) {
        Func1<Throwable, Throwable> func1 = f46952q;
        return func1 != null ? func1.call(th) : th;
    }

    /* renamed from: R */
    public static <T, R> Observable.InterfaceC15568b<R, T> m567R(Observable.InterfaceC15568b<R, T> interfaceC15568b) {
        Func1<Observable.InterfaceC15568b, Observable.InterfaceC15568b> func1 = f46955t;
        return func1 != null ? func1.call(interfaceC15568b) : interfaceC15568b;
    }

    /* renamed from: S */
    public static Subscription m566S(Subscription subscription) {
        Func1<Subscription, Subscription> func1 = f46949n;
        return func1 != null ? func1.call(subscription) : subscription;
    }

    /* renamed from: T */
    public static <T> Single.InterfaceC15633t<T> m565T(Single<T> single, Single.InterfaceC15633t<T> interfaceC15633t) {
        Func2<Single, Single.InterfaceC15633t, Single.InterfaceC15633t> func2 = f46942g;
        return func2 != null ? func2.call(single, interfaceC15633t) : interfaceC15633t;
    }

    /* renamed from: U */
    public static void m564U() {
        if (f46936a) {
            return;
        }
        m518x();
        f46944i = null;
        f46945j = null;
        f46946k = null;
        f46950o = null;
    }

    /* renamed from: V */
    public static void m563V() {
        if (f46936a) {
            return;
        }
        m517y();
    }

    /* renamed from: W */
    public static void m562W(Func1<Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> func1) {
        if (f46936a) {
            return;
        }
        f46940e = func1;
    }

    /* renamed from: X */
    public static void m561X(Func1<Completable.InterfaceC15542k0, Completable.InterfaceC15542k0> func1) {
        if (f46936a) {
            return;
        }
        f46956u = func1;
    }

    /* renamed from: Y */
    public static void m560Y(Func2<Completable, Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> func2) {
        if (f46936a) {
            return;
        }
        f46943h = func2;
    }

    /* renamed from: Z */
    public static void m559Z(Func1<Throwable, Throwable> func1) {
        if (f46936a) {
            return;
        }
        f46953r = func1;
    }

    /* renamed from: a */
    public static void m558a() {
        if (f46936a) {
            return;
        }
        f46937b = null;
        f46938c = null;
        f46941f = null;
        f46948m = null;
        f46951p = null;
        f46954s = null;
        f46939d = null;
        f46942g = null;
        f46949n = null;
        f46952q = null;
        f46955t = null;
        f46940e = null;
        f46943h = null;
        f46953r = null;
        f46956u = null;
        f46944i = null;
        f46945j = null;
        f46946k = null;
        f46947l = null;
        f46950o = null;
    }

    /* renamed from: a0 */
    public static void m557a0(Func1<Scheduler, Scheduler> func1) {
        if (f46936a) {
            return;
        }
        f46944i = func1;
    }

    /* renamed from: b */
    public static void m556b() {
        if (f46936a) {
            return;
        }
        f46938c = null;
        f46939d = null;
        f46940e = null;
    }

    /* renamed from: b0 */
    public static void m555b0(Action1<Throwable> action1) {
        if (f46936a) {
            return;
        }
        f46937b = action1;
    }

    /* renamed from: c */
    public static void m554c() {
        if (f46936a) {
            return;
        }
        f46938c = new C16144h();
        f46939d = new C16145i();
        f46940e = new C16146j();
    }

    /* renamed from: c0 */
    public static void m553c0(Func0<? extends ScheduledExecutorService> func0) {
        if (f46936a) {
            return;
        }
        f46950o = func0;
    }

    /* renamed from: d */
    public static Func1<Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> m552d() {
        return f46940e;
    }

    /* renamed from: d0 */
    public static void m551d0(Func1<Scheduler, Scheduler> func1) {
        if (f46936a) {
            return;
        }
        f46945j = func1;
    }

    /* renamed from: e */
    public static Func1<Completable.InterfaceC15542k0, Completable.InterfaceC15542k0> m550e() {
        return f46956u;
    }

    /* renamed from: e0 */
    public static void m549e0(Func1<Scheduler, Scheduler> func1) {
        if (f46936a) {
            return;
        }
        f46946k = func1;
    }

    /* renamed from: f */
    public static Func2<Completable, Completable.InterfaceC15540j0, Completable.InterfaceC15540j0> m548f() {
        return f46943h;
    }

    /* renamed from: f0 */
    public static void m547f0(Func1<Observable.InterfaceC15567a, Observable.InterfaceC15567a> func1) {
        if (f46936a) {
            return;
        }
        f46938c = func1;
    }

    /* renamed from: g */
    public static Func1<Throwable, Throwable> m546g() {
        return f46953r;
    }

    /* renamed from: g0 */
    public static void m545g0(Func1<Observable.InterfaceC15568b, Observable.InterfaceC15568b> func1) {
        if (f46936a) {
            return;
        }
        f46954s = func1;
    }

    /* renamed from: h */
    public static Func1<Scheduler, Scheduler> m544h() {
        return f46944i;
    }

    /* renamed from: h0 */
    public static void m543h0(Func1<Subscription, Subscription> func1) {
        if (f46936a) {
            return;
        }
        f46948m = func1;
    }

    /* renamed from: i */
    public static Action1<Throwable> m542i() {
        return f46937b;
    }

    /* renamed from: i0 */
    public static void m541i0(Func2<Observable, Observable.InterfaceC15567a, Observable.InterfaceC15567a> func2) {
        if (f46936a) {
            return;
        }
        f46941f = func2;
    }

    /* renamed from: j */
    public static Func0<? extends ScheduledExecutorService> m540j() {
        return f46950o;
    }

    /* renamed from: j0 */
    public static void m539j0(Func1<Throwable, Throwable> func1) {
        if (f46936a) {
            return;
        }
        f46951p = func1;
    }

    /* renamed from: k */
    public static Func1<Scheduler, Scheduler> m538k() {
        return f46945j;
    }

    /* renamed from: k0 */
    public static void m537k0(Func1<Action0, Action0> func1) {
        if (f46936a) {
            return;
        }
        f46947l = func1;
    }

    /* renamed from: l */
    public static Func1<Scheduler, Scheduler> m536l() {
        return f46946k;
    }

    /* renamed from: l0 */
    public static void m535l0(Func1<Single.InterfaceC15633t, Single.InterfaceC15633t> func1) {
        if (f46936a) {
            return;
        }
        f46939d = func1;
    }

    /* renamed from: m */
    public static Func1<Observable.InterfaceC15567a, Observable.InterfaceC15567a> m534m() {
        return f46938c;
    }

    /* renamed from: m0 */
    public static void m533m0(Func1<Observable.InterfaceC15568b, Observable.InterfaceC15568b> func1) {
        if (f46936a) {
            return;
        }
        f46955t = func1;
    }

    /* renamed from: n */
    public static Func1<Observable.InterfaceC15568b, Observable.InterfaceC15568b> m532n() {
        return f46954s;
    }

    /* renamed from: n0 */
    public static void m531n0(Func1<Subscription, Subscription> func1) {
        if (f46936a) {
            return;
        }
        f46949n = func1;
    }

    /* renamed from: o */
    public static Func1<Subscription, Subscription> m530o() {
        return f46948m;
    }

    /* renamed from: o0 */
    public static void m529o0(Func2<Single, Single.InterfaceC15633t, Single.InterfaceC15633t> func2) {
        if (f46936a) {
            return;
        }
        f46942g = func2;
    }

    /* renamed from: p */
    public static Func2<Observable, Observable.InterfaceC15567a, Observable.InterfaceC15567a> m528p() {
        return f46941f;
    }

    /* renamed from: p0 */
    public static void m527p0(Func1<Throwable, Throwable> func1) {
        if (f46936a) {
            return;
        }
        f46952q = func1;
    }

    /* renamed from: q */
    public static Func1<Throwable, Throwable> m526q() {
        return f46951p;
    }

    /* renamed from: q0 */
    static void m525q0(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    /* renamed from: r */
    public static Func1<Action0, Action0> m524r() {
        return f46947l;
    }

    /* renamed from: s */
    public static Func1<Single.InterfaceC15633t, Single.InterfaceC15633t> m523s() {
        return f46939d;
    }

    /* renamed from: t */
    public static Func1<Observable.InterfaceC15568b, Observable.InterfaceC15568b> m522t() {
        return f46955t;
    }

    /* renamed from: u */
    public static Func1<Subscription, Subscription> m521u() {
        return f46949n;
    }

    /* renamed from: v */
    public static Func2<Single, Single.InterfaceC15633t, Single.InterfaceC15633t> m520v() {
        return f46942g;
    }

    /* renamed from: w */
    public static Func1<Throwable, Throwable> m519w() {
        return f46952q;
    }

    /* renamed from: x */
    static void m518x() {
        f46937b = new C16147k();
        f46941f = new C16148l();
        f46948m = new C16149m();
        f46942g = new C16150n();
        f46949n = new C16151o();
        f46943h = new C16152p();
        f46947l = new C16153q();
        f46951p = new C16154r();
        f46954s = new C16155s();
        f46952q = new C16137a();
        f46955t = new C16138b();
        f46953r = new C16139c();
        f46956u = new C16140d();
        m517y();
    }

    /* renamed from: y */
    static void m517y() {
        f46938c = new C16141e();
        f46939d = new C16142f();
        f46940e = new C16143g();
    }

    /* renamed from: z */
    public static boolean m516z() {
        return f46936a;
    }
}
