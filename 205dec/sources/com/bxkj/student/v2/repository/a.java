package com.bxkj.student.v2.repository;

import com.bxkj.base.v2.http.result.ApiResult;
import com.bxkj.student.v2.retrofit.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: FloatActionRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0005\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/student/v2/repository/a;", "", "Lcom/bxkj/base/v2/http/result/ApiResult;", "", "", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* compiled from: LoginRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.LoginRepository", f = "LoginRepository.kt", i = {}, l = {24}, m = "loginThirdCheck", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.repository.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class C0297a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23553a;

        /* renamed from: c  reason: collision with root package name */
        int f23555c;

        C0297a(kotlin.coroutines.c<? super C0297a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23553a = obj;
            this.f23555c |= Integer.MIN_VALUE;
            return a.this.d(null, null, this);
        }
    }

    @Nullable
    public final Object a(@NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar) {
        return a.b.g(com.bxkj.student.v2.retrofit.c.f23705a.b(), null, cVar, 1, null);
    }
}
