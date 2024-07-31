package retrofit2;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Method;
import kotlin.C14294d0;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.InterfaceC15146o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: KotlinExtensions.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0087@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a)\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00060\u000bj\u0002`\fH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/Retrofit;", "create", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "", "Lretrofit2/Call;", "await", "(Lretrofit2/Call;Lkotlin/coroutines/c;)Ljava/lang/Object;", "awaitNullable", "Lretrofit2/Response;", "awaitResponse", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "suspendAndThrow", "(Ljava/lang/Exception;Lkotlin/coroutines/c;)Ljava/lang/Object;", "retrofit"}, m12615k = 2, m12614mv = {1, 4, 0})
@JvmName(name = "KotlinExtensions")
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class KotlinExtensions {
    @Nullable
    public static final <T> Object await(@NotNull final Call<T> call, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        final C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3902e(new InterfaceC15280l<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                Call.this.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(@NotNull Call<T> call2, @NotNull Throwable t) {
                C14342f0.m8183q(call2, "call");
                C14342f0.m8183q(t, "t");
                InterfaceC15146o interfaceC15146o = InterfaceC15146o.this;
                Result.C14124a c14124a = Result.Companion;
                interfaceC15146o.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(t)));
            }

            @Override // retrofit2.Callback
            public void onResponse(@NotNull Call<T> call2, @NotNull Response<T> response) {
                C14342f0.m8183q(call2, "call");
                C14342f0.m8183q(response, "response");
                if (response.isSuccessful()) {
                    T body = response.body();
                    if (body == null) {
                        Object tag = call2.request().tag(Invocation.class);
                        if (tag == null) {
                            C14342f0.m8207L();
                        }
                        C14342f0.m8192h(tag, "call.request().tag(Invocation::class.java)!!");
                        Method method = ((Invocation) tag).method();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Response from ");
                        C14342f0.m8192h(method, "method");
                        Class<?> declaringClass = method.getDeclaringClass();
                        C14342f0.m8192h(declaringClass, "method.declaringClass");
                        sb.append(declaringClass.getName());
                        sb.append('.');
                        sb.append(method.getName());
                        sb.append(" was null but response body type was declared as non-null");
                        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                        InterfaceC15146o interfaceC15146o = InterfaceC15146o.this;
                        Result.C14124a c14124a = Result.Companion;
                        interfaceC15146o.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(kotlinNullPointerException)));
                        return;
                    }
                    InterfaceC15146o interfaceC15146o2 = InterfaceC15146o.this;
                    Result.C14124a c14124a2 = Result.Companion;
                    interfaceC15146o2.resumeWith(Result.m60148constructorimpl(body));
                    return;
                }
                InterfaceC15146o interfaceC15146o3 = InterfaceC15146o.this;
                HttpException httpException = new HttpException(response);
                Result.C14124a c14124a3 = Result.Companion;
                interfaceC15146o3.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(httpException)));
            }
        });
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @JvmName(name = "awaitNullable")
    @Nullable
    public static final <T> Object awaitNullable(@NotNull final Call<T> call, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        final C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3902e(new InterfaceC15280l<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                Call.this.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(@NotNull Call<T> call2, @NotNull Throwable t) {
                C14342f0.m8183q(call2, "call");
                C14342f0.m8183q(t, "t");
                InterfaceC15146o interfaceC15146o = InterfaceC15146o.this;
                Result.C14124a c14124a = Result.Companion;
                interfaceC15146o.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(t)));
            }

            @Override // retrofit2.Callback
            public void onResponse(@NotNull Call<T> call2, @NotNull Response<T> response) {
                C14342f0.m8183q(call2, "call");
                C14342f0.m8183q(response, "response");
                if (response.isSuccessful()) {
                    InterfaceC15146o interfaceC15146o = InterfaceC15146o.this;
                    T body = response.body();
                    Result.C14124a c14124a = Result.Companion;
                    interfaceC15146o.resumeWith(Result.m60148constructorimpl(body));
                    return;
                }
                InterfaceC15146o interfaceC15146o2 = InterfaceC15146o.this;
                HttpException httpException = new HttpException(response);
                Result.C14124a c14124a2 = Result.Companion;
                interfaceC15146o2.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(httpException)));
            }
        });
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @Nullable
    public static final <T> Object awaitResponse(@NotNull final Call<T> call, @NotNull InterfaceC14268c<? super Response<T>> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        final C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3902e(new InterfaceC15280l<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                Call.this.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(@NotNull Call<T> call2, @NotNull Throwable t) {
                C14342f0.m8183q(call2, "call");
                C14342f0.m8183q(t, "t");
                InterfaceC15146o interfaceC15146o = InterfaceC15146o.this;
                Result.C14124a c14124a = Result.Companion;
                interfaceC15146o.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(t)));
            }

            @Override // retrofit2.Callback
            public void onResponse(@NotNull Call<T> call2, @NotNull Response<T> response) {
                C14342f0.m8183q(call2, "call");
                C14342f0.m8183q(response, "response");
                InterfaceC15146o interfaceC15146o = InterfaceC15146o.this;
                Result.C14124a c14124a = Result.Companion;
                interfaceC15146o.resumeWith(Result.m60148constructorimpl(response));
            }
        });
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    public static final /* synthetic */ <T> T create(@NotNull Retrofit create) {
        C14342f0.m8183q(create, "$this$create");
        C14342f0.m8175y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) create.create(Object.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object suspendAndThrow(@org.jetbrains.annotations.NotNull final java.lang.Exception r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<?> r5) {
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
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            kotlin.C14294d0.m8596n(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C14294d0.m8596n(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.l0 r5 = kotlinx.coroutines.Dispatchers.m5038a()
            kotlin.coroutines.f r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>()
            r5.dispatch(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            if (r4 != r5) goto L59
            kotlin.coroutines.jvm.internal.DebugProbes.m8616c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            kotlin.f1 r4 = kotlin.Unit.f41048a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Exception, kotlin.coroutines.c):java.lang.Object");
    }
}
