package com.bxkj.student.p094v2.p103vm.face;

import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.http.exception.ApiException;
import com.bxkj.student.p094v2.repository.face.FaceCheckRepository;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.C14342f0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: FaceCheckVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¨\u0006\u000e"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/face/FaceCheckVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Ljava/io/File;", "faceFile", "Lkotlin/Function1;", "Lcom/bxkj/base/v2/http/exception/ApiException;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/f1;", CommonNetImpl.RESULT, UMCommonContent.f37782aL, "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.face.FaceCheckVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FaceCheckVM extends BaseViewModel {

    /* compiled from: FaceCheckVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.face.FaceCheckVM$faceDetect$1", m8638f = "FaceCheckVM.kt", m8637i = {}, m8636l = {18}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.face.FaceCheckVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5854a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21003a;

        /* renamed from: b */
        final /* synthetic */ File f21004b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l<ApiException, Unit> f21005c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5854a(File file, InterfaceC15280l<? super ApiException, Unit> interfaceC15280l, InterfaceC14268c<? super C5854a> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21004b = file;
            this.f21005c = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5854a(this.f21004b, this.f21005c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5854a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21003a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                FaceCheckRepository faceCheckRepository = new FaceCheckRepository();
                RequestBody create = RequestBody.Companion.create(MediaType.Companion.parse("image/png"), this.f21004b);
                this.f21003a = 1;
                if (faceCheckRepository.m38994a(create, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            this.f21005c.invoke(new ApiException(boxing.m8626f(0), "人脸验证成功"));
            return Unit.f41048a;
        }
    }

    /* compiled from: FaceCheckVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lcom/bxkj/base/v2/http/exception/ApiException;", "it", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.face.FaceCheckVM$faceDetect$2", m8638f = "FaceCheckVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.face.FaceCheckVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5855b extends SuspendLambda implements InterfaceC15284p<ApiException, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        int f21006a;

        /* renamed from: b */
        /* synthetic */ Object f21007b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l<ApiException, Unit> f21008c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5855b(InterfaceC15280l<? super ApiException, Unit> interfaceC15280l, InterfaceC14268c<? super C5855b> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f21008c = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C5855b c5855b = new C5855b(this.f21008c, interfaceC14268c);
            c5855b.f21007b = obj;
            return c5855b;
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull ApiException apiException, @Nullable InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C5855b) create(apiException, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f21006a == 0) {
                C14294d0.m8596n(obj);
                this.f21008c.invoke((ApiException) this.f21007b);
                return boxing.m8631a(true);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: t */
    public final void m38119t(@NotNull File faceFile, @NotNull InterfaceC15280l<? super ApiException, Unit> result) {
        C14342f0.m8184p(faceFile, "faceFile");
        C14342f0.m8184p(result, "result");
        BaseViewModel.m43949j(this, new C5854a(faceFile, result, null), new C5855b(result, null), null, null, null, null, null, null, 252, null);
    }
}
