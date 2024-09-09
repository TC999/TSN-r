package retrofit2;

import d2.l;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.e;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: KotlinExtensions.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086\b\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0007\u001a)\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00060\u000bj\u0002`\fH\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"T", "Lretrofit2/Retrofit;", "create", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "", "Lretrofit2/Call;", "await", "(Lretrofit2/Call;Lkotlin/coroutines/c;)Ljava/lang/Object;", "awaitNullable", "Lretrofit2/Response;", "awaitResponse", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "suspendAndThrow", "(Ljava/lang/Exception;Lkotlin/coroutines/c;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "KotlinExtensions")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class KotlinExtensions {
    @Nullable
    public static final <T> Object await(@NotNull final Call<T> call, @NotNull kotlin.coroutines.c<? super T> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        final p pVar = new p(d4, 1);
        pVar.B(new l<Throwable, f1>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
                invoke2(th);
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                Call.this.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(@NotNull Call<T> call2, @NotNull Throwable t3) {
                f0.q(call2, "call");
                f0.q(t3, "t");
                o oVar = o.this;
                Result.a aVar = Result.Companion;
                oVar.resumeWith(Result.m119constructorimpl(d0.a(t3)));
            }

            @Override // retrofit2.Callback
            public void onResponse(@NotNull Call<T> call2, @NotNull Response<T> response) {
                f0.q(call2, "call");
                f0.q(response, "response");
                if (response.isSuccessful()) {
                    T body = response.body();
                    if (body == null) {
                        Object tag = call2.request().tag(Invocation.class);
                        if (tag == null) {
                            f0.L();
                        }
                        f0.h(tag, "call.request().tag(Invocation::class.java)!!");
                        Method method = ((Invocation) tag).method();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Response from ");
                        f0.h(method, "method");
                        Class<?> declaringClass = method.getDeclaringClass();
                        f0.h(declaringClass, "method.declaringClass");
                        sb.append(declaringClass.getName());
                        sb.append('.');
                        sb.append(method.getName());
                        sb.append(" was null but response body type was declared as non-null");
                        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                        o oVar = o.this;
                        Result.a aVar = Result.Companion;
                        oVar.resumeWith(Result.m119constructorimpl(d0.a(kotlinNullPointerException)));
                        return;
                    }
                    o oVar2 = o.this;
                    Result.a aVar2 = Result.Companion;
                    oVar2.resumeWith(Result.m119constructorimpl(body));
                    return;
                }
                o oVar3 = o.this;
                HttpException httpException = new HttpException(response);
                Result.a aVar3 = Result.Companion;
                oVar3.resumeWith(Result.m119constructorimpl(d0.a(httpException)));
            }
        });
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            e.c(cVar);
        }
        return y3;
    }

    @JvmName(name = "awaitNullable")
    @Nullable
    public static final <T> Object awaitNullable(@NotNull final Call<T> call, @NotNull kotlin.coroutines.c<? super T> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        final p pVar = new p(d4, 1);
        pVar.B(new l<Throwable, f1>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
                invoke2(th);
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                Call.this.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(@NotNull Call<T> call2, @NotNull Throwable t3) {
                f0.q(call2, "call");
                f0.q(t3, "t");
                o oVar = o.this;
                Result.a aVar = Result.Companion;
                oVar.resumeWith(Result.m119constructorimpl(d0.a(t3)));
            }

            @Override // retrofit2.Callback
            public void onResponse(@NotNull Call<T> call2, @NotNull Response<T> response) {
                f0.q(call2, "call");
                f0.q(response, "response");
                if (response.isSuccessful()) {
                    o oVar = o.this;
                    T body = response.body();
                    Result.a aVar = Result.Companion;
                    oVar.resumeWith(Result.m119constructorimpl(body));
                    return;
                }
                o oVar2 = o.this;
                HttpException httpException = new HttpException(response);
                Result.a aVar2 = Result.Companion;
                oVar2.resumeWith(Result.m119constructorimpl(d0.a(httpException)));
            }
        });
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            e.c(cVar);
        }
        return y3;
    }

    @Nullable
    public static final <T> Object awaitResponse(@NotNull final Call<T> call, @NotNull kotlin.coroutines.c<? super Response<T>> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        final p pVar = new p(d4, 1);
        pVar.B(new l<Throwable, f1>() { // from class: retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
                invoke2(th);
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                Call.this.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(@NotNull Call<T> call2, @NotNull Throwable t3) {
                f0.q(call2, "call");
                f0.q(t3, "t");
                o oVar = o.this;
                Result.a aVar = Result.Companion;
                oVar.resumeWith(Result.m119constructorimpl(d0.a(t3)));
            }

            @Override // retrofit2.Callback
            public void onResponse(@NotNull Call<T> call2, @NotNull Response<T> response) {
                f0.q(call2, "call");
                f0.q(response, "response");
                o oVar = o.this;
                Result.a aVar = Result.Companion;
                oVar.resumeWith(Result.m119constructorimpl(response));
            }
        });
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            e.c(cVar);
        }
        return y3;
    }

    public static final /* synthetic */ <T> T create(@NotNull Retrofit create) {
        f0.q(create, "$this$create");
        f0.y(4, "T");
        return (T) create.create(Object.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object suspendAndThrow(@org.jetbrains.annotations.NotNull final java.lang.Exception r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            kotlin.d0.n(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.d0.n(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.l0 r5 = kotlinx.coroutines.f1.a()
            kotlin.coroutines.f r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>()
            r5.dispatch(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.a.h()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.a.h()
            if (r4 != r5) goto L59
            kotlin.coroutines.jvm.internal.e.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            kotlin.f1 r4 = kotlin.f1.f55527a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Exception, kotlin.coroutines.c):java.lang.Object");
    }
}
