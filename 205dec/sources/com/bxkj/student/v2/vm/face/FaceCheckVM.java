package com.bxkj.student.v2.vm.face;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.http.exception.ApiException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import l1.l;
import l1.p;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FaceCheckVM.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ1\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/bxkj/student/v2/vm/face/FaceCheckVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Ljava/io/File;", "faceFile", "Lkotlin/Function1;", "Lcom/bxkj/base/v2/http/exception/ApiException;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/f1;", "result", "t", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class FaceCheckVM extends BaseViewModel {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FaceCheckVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceCheckVM$faceDetect$1", f = "FaceCheckVM.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends SuspendLambda implements l<c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24423a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f24424b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<ApiException, f1> f24425c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(File file, l<? super ApiException, f1> lVar, c<? super a> cVar) {
            super(1, cVar);
            this.f24424b = file;
            this.f24425c = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final c<f1> create(@NotNull c<?> cVar) {
            return new a(this.f24424b, this.f24425c, cVar);
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
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24423a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.face.a aVar = new com.bxkj.student.v2.repository.face.a();
                RequestBody create = RequestBody.Companion.create(MediaType.Companion.parse("image/png"), this.f24424b);
                this.f24423a = 1;
                if (aVar.a(create, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24425c.invoke(new ApiException(kotlin.coroutines.jvm.internal.a.f(0), "\u4eba\u8138\u9a8c\u8bc1\u6210\u529f"));
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FaceCheckVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/bxkj/base/v2/http/exception/ApiException;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceCheckVM$faceDetect$2", f = "FaceCheckVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class b extends SuspendLambda implements p<ApiException, c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24426a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24427b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<ApiException, f1> f24428c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(l<? super ApiException, f1> lVar, c<? super b> cVar) {
            super(2, cVar);
            this.f24428c = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final c<f1> create(@Nullable Object obj, @NotNull c<?> cVar) {
            b bVar = new b(this.f24428c, cVar);
            bVar.f24427b = obj;
            return bVar;
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull ApiException apiException, @Nullable c<? super Boolean> cVar) {
            return ((b) create(apiException, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24426a == 0) {
                d0.n(obj);
                this.f24428c.invoke((ApiException) this.f24427b);
                return kotlin.coroutines.jvm.internal.a.a(true);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void t(@NotNull File faceFile, @NotNull l<? super ApiException, f1> result) {
        f0.p(faceFile, "faceFile");
        f0.p(result, "result");
        BaseViewModel.j(this, new a(faceFile, result, null), new b(result, null), null, null, null, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, null);
    }
}
