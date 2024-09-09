package com.bxkj.student.v2.vm.face;

import com.bxkj.base.v2.base.BaseViewModel;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import l1.l;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FaceCollectVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\n"}, d2 = {"Lcom/bxkj/student/v2/vm/face/FaceCollectVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Ljava/io/File;", "faceFile", "Lkotlin/Function0;", "Lkotlin/f1;", "result", "t", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class FaceCollectVM extends BaseViewModel {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FaceCollectVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceCollectVM$faceCollect$1", f = "FaceCollectVM.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends SuspendLambda implements l<c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24429a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f24430b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24431c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(File file, l1.a<f1> aVar, c<? super a> cVar) {
            super(1, cVar);
            this.f24430b = file;
            this.f24431c = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final c<f1> create(@NotNull c<?> cVar) {
            return new a(this.f24430b, this.f24431c, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable c<? super f1> cVar) {
            return ((a) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = b.h();
            int i4 = this.f24429a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.face.b bVar = new com.bxkj.student.v2.repository.face.b();
                RequestBody create = RequestBody.Companion.create(MediaType.Companion.parse("image/png"), this.f24430b);
                this.f24429a = 1;
                if (bVar.a(create, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24431c.invoke();
            return f1.f55527a;
        }
    }

    public final void t(@NotNull File faceFile, @NotNull l1.a<f1> result) {
        f0.p(faceFile, "faceFile");
        f0.p(result, "result");
        BaseViewModel.j(this, new a(faceFile, result, null), null, null, null, null, null, null, null, 254, null);
    }
}
