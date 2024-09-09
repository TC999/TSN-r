package com.trello.rxlifecycle2;

import io.reactivex.Completable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.CancellationException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Functions.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    static final Function<Throwable, Boolean> f52368a = new C1049a();

    /* renamed from: b  reason: collision with root package name */
    static final Predicate<Boolean> f52369b = new b();

    /* renamed from: c  reason: collision with root package name */
    static final Function<Object, Completable> f52370c = new c();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Functions.java */
    /* renamed from: com.trello.rxlifecycle2.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class C1049a implements Function<Throwable, Boolean> {
        C1049a() {
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class b implements Predicate<Boolean> {
        b() {
        }

        @Override // io.reactivex.functions.Predicate
        /* renamed from: a */
        public boolean test(Boolean bool) throws Exception {
            return bool.booleanValue();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Functions.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class c implements Function<Object, Completable> {
        c() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Completable apply(Object obj) throws Exception {
            return Completable.error(new CancellationException());
        }
    }

    private a() {
        throw new AssertionError("No instances!");
    }
}
