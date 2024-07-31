package com.bxkj.student.p094v2.p103vm.face;

import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.ext.ExceptionExt;
import com.bxkj.student.p094v2.common.p095db.AppDatabase;
import com.bxkj.student.p094v2.common.p095db.dao.FaceDao;
import com.bxkj.student.p094v2.repository.face.FaceDetectRepository;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.http.HttpHeaders;
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
import p027c0.FaceDb;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: FaceDetectVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015JS\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\u0010\u0010\u001a!\u0012\u0017\u0012\u00150\u000bj\u0002`\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\nJ4\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\u0016"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/face/FaceDetectVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "identify", "type", "Ljava/io/File;", "faceFile", "Lkotlin/Function0;", "Lkotlin/f1;", CommonNetImpl.RESULT, "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "failure", UMCommonContent.f37782aL, "runType", "u", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.face.FaceDetectVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FaceDetectVM extends BaseViewModel {

    /* compiled from: FaceDetectVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3$1", m8638f = "FaceDetectVM.kt", m8637i = {}, m8636l = {28}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.face.FaceDetectVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5857a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21012a;

        /* renamed from: b */
        final /* synthetic */ String f21013b;

        /* renamed from: c */
        final /* synthetic */ String f21014c;

        /* renamed from: d */
        final /* synthetic */ File f21015d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC15269a<Unit> f21016e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5857a(String str, String str2, File file, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5857a> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21013b = str;
            this.f21014c = str2;
            this.f21015d = file;
            this.f21016e = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5857a(this.f21013b, this.f21014c, this.f21015d, this.f21016e, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5857a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21012a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                FaceDetectRepository faceDetectRepository = new FaceDetectRepository();
                RequestBody.Companion companion = RequestBody.Companion;
                MediaType.Companion companion2 = MediaType.Companion;
                RequestBody create = companion.create(companion2.parse(HttpHeaders.Values.MULTIPART_FORM_DATA), this.f21013b);
                RequestBody create2 = companion.create(companion2.parse(HttpHeaders.Values.MULTIPART_FORM_DATA), this.f21014c);
                RequestBody create3 = companion.create(companion2.parse("image/png"), this.f21015d);
                this.f21012a = 1;
                if (faceDetectRepository.m38992a(create, create2, create3, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            this.f21016e.invoke();
            return Unit.f41048a;
        }
    }

    /* compiled from: FaceDetectVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a\u00020\u00062\u0019\u0010\u0005\u001a\u00150\u0000j\u0011`\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, m12616d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3$2", m8638f = "FaceDetectVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.face.FaceDetectVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5858b extends SuspendLambda implements InterfaceC15284p<Exception, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21017a;

        /* renamed from: b */
        /* synthetic */ Object f21018b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l<Exception, Unit> f21019c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5858b(InterfaceC15280l<? super Exception, Unit> interfaceC15280l, InterfaceC14268c<? super C5858b> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f21019c = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C5858b c5858b = new C5858b(this.f21019c, interfaceC14268c);
            c5858b.f21018b = obj;
            return c5858b;
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5858b) create(exc, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f21017a == 0) {
                C14294d0.m8596n(obj);
                this.f21019c.invoke((Exception) this.f21018b);
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: FaceDetectVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3_2$1", m8638f = "FaceDetectVM.kt", m8637i = {}, m8636l = {45}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.face.FaceDetectVM$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5859c extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21020a;

        /* renamed from: b */
        final /* synthetic */ String f21021b;

        /* renamed from: c */
        final /* synthetic */ String f21022c;

        /* renamed from: d */
        final /* synthetic */ String f21023d;

        /* renamed from: e */
        final /* synthetic */ File f21024e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15269a<Unit> f21025f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5859c(String str, String str2, String str3, File file, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5859c> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21021b = str;
            this.f21022c = str2;
            this.f21023d = str3;
            this.f21024e = file;
            this.f21025f = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5859c(this.f21021b, this.f21022c, this.f21023d, this.f21024e, this.f21025f, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5859c) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21020a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                FaceDetectRepository faceDetectRepository = new FaceDetectRepository();
                String str = this.f21021b;
                String str2 = this.f21022c;
                String str3 = this.f21023d;
                String path = this.f21024e.getPath();
                C14342f0.m8185o(path, "faceFile.path");
                this.f21020a = 1;
                if (FaceDetectRepository.m38990c(faceDetectRepository, str, str2, str3, path, 0, this, 16, null) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            this.f21025f.invoke();
            return Unit.f41048a;
        }
    }

    /* compiled from: FaceDetectVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, m12616d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3_2$2", m8638f = "FaceDetectVM.kt", m8637i = {}, m8636l = {57}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.face.FaceDetectVM$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5860d extends SuspendLambda implements InterfaceC15284p<Exception, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        int f21026a;

        /* renamed from: b */
        /* synthetic */ Object f21027b;

        /* renamed from: c */
        final /* synthetic */ String f21028c;

        /* renamed from: d */
        final /* synthetic */ String f21029d;

        /* renamed from: e */
        final /* synthetic */ File f21030e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15269a<Unit> f21031f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5860d(String str, String str2, File file, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5860d> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f21028c = str;
            this.f21029d = str2;
            this.f21030e = file;
            this.f21031f = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C5860d c5860d = new C5860d(this.f21028c, this.f21029d, this.f21030e, this.f21031f, interfaceC14268c);
            c5860d.f21027b = obj;
            return c5860d;
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C5860d) create(exc, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21026a;
            boolean z = false;
            if (i == 0) {
                C14294d0.m8596n(obj);
                if (ExceptionExt.m43845a((Exception) this.f21027b)) {
                    C11792j.m20469d("离线跑步人脸识别,将中途人脸识别的照片存储本地！", new Object[0]);
                    String str = this.f21028c;
                    String str2 = this.f21029d;
                    String path = this.f21030e.getPath();
                    C14342f0.m8185o(path, "faceFile.path");
                    FaceDb faceDb = new FaceDb(0L, str, str2, path, 1, null);
                    FaceDao mo39227j = AppDatabase.f19934a.m39228a().mo39227j();
                    if (mo39227j != null) {
                        this.f21026a = 1;
                        if (mo39227j.insert(faceDb, this) == m8642h) {
                            return m8642h;
                        }
                    }
                }
                return boxing.m8631a(z);
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            this.f21031f.invoke();
            z = true;
            return boxing.m8631a(z);
        }
    }

    /* renamed from: t */
    public final void m38114t(@NotNull String identify, @NotNull String type, @NotNull File faceFile, @NotNull InterfaceC15269a<Unit> result, @NotNull InterfaceC15280l<? super Exception, Unit> failure) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(type, "type");
        C14342f0.m8184p(faceFile, "faceFile");
        C14342f0.m8184p(result, "result");
        C14342f0.m8184p(failure, "failure");
        BaseViewModel.m43949j(this, new C5857a(identify, type, faceFile, result, null), null, null, null, null, new C5858b(failure, null), null, null, 222, null);
    }

    /* renamed from: u */
    public final void m38113u(@NotNull String identify, @NotNull String type, @NotNull String runType, @NotNull File faceFile, @NotNull InterfaceC15269a<Unit> result) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(type, "type");
        C14342f0.m8184p(runType, "runType");
        C14342f0.m8184p(faceFile, "faceFile");
        C14342f0.m8184p(result, "result");
        BaseViewModel.m43949j(this, new C5859c(identify, type, runType, faceFile, result, null), null, new C5860d(identify, type, faceFile, result, null), null, null, null, null, null, 250, null);
    }
}
