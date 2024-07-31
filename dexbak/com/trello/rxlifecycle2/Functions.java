package com.trello.rxlifecycle2;

import io.reactivex.Completable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.CancellationException;

/* renamed from: com.trello.rxlifecycle2.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class Functions {

    /* renamed from: a */
    static final Function<Throwable, Boolean> f37470a = new C13079a();

    /* renamed from: b */
    static final Predicate<Boolean> f37471b = new C13080b();

    /* renamed from: c */
    static final Function<Object, Completable> f37472c = new C13081c();

    /* compiled from: Functions.java */
    /* renamed from: com.trello.rxlifecycle2.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C13079a implements Function<Throwable, Boolean> {
        C13079a() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Boolean apply(Throwable th) throws Exception {
            if (th instanceof OutsideLifecycleException) {
                return Boolean.TRUE;
            }
            Exceptions.propagate(th);
            return Boolean.FALSE;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: com.trello.rxlifecycle2.a$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C13080b implements Predicate<Boolean> {
        C13080b() {
        }

        @Override // io.reactivex.functions.Predicate
        /* renamed from: a */
        public boolean test(Boolean bool) throws Exception {
            return bool.booleanValue();
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: com.trello.rxlifecycle2.a$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C13081c implements Function<Object, Completable> {
        C13081c() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Completable apply(Object obj) throws Exception {
            return Completable.error(new CancellationException());
        }
    }

    private Functions() {
        throw new AssertionError("No instances!");
    }
}
