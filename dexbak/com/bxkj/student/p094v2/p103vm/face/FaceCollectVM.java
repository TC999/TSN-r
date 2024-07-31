package com.bxkj.student.p094v2.p103vm.face;

import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.student.p094v2.repository.face.FaceCollectRepository;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.File;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: FaceCollectVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/face/FaceCollectVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Ljava/io/File;", "faceFile", "Lkotlin/Function0;", "Lkotlin/f1;", CommonNetImpl.RESULT, UMCommonContent.f37782aL, "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.face.FaceCollectVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FaceCollectVM extends BaseViewModel {

    /* compiled from: FaceCollectVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.face.FaceCollectVM$faceCollect$1", m8638f = "FaceCollectVM.kt", m8637i = {}, m8636l = {17}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.face.FaceCollectVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5856a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21009a;

        /* renamed from: b */
        final /* synthetic */ File f21010b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15269a<Unit> f21011c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5856a(File file, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5856a> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21010b = file;
            this.f21011c = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5856a(this.f21010b, this.f21011c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5856a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21009a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                FaceCollectRepository faceCollectRepository = new FaceCollectRepository();
                RequestBody create = RequestBody.Companion.create(MediaType.Companion.parse("image/png"), this.f21010b);
                this.f21009a = 1;
                if (faceCollectRepository.m38993a(create, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            this.f21011c.invoke();
            return Unit.f41048a;
        }
    }

    /* renamed from: t */
    public final void m38116t(@NotNull File faceFile, @NotNull InterfaceC15269a<Unit> result) {
        C14342f0.m8184p(faceFile, "faceFile");
        C14342f0.m8184p(result, "result");
        BaseViewModel.m43949j(this, new C5856a(faceFile, result, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }
}
