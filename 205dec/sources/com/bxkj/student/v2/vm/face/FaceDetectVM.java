package com.bxkj.student.v2.vm.face;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.ext.e;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.orhanobut.logger.j;
import java.io.File;
import kotlin.Metadata;
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
/* compiled from: FaceDetectVM.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015JS\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\u0010\u0010\u001a!\u0012\u0017\u0012\u00150\u000bj\u0002`\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\nJ4\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/bxkj/student/v2/vm/face/FaceDetectVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "identify", "type", "Ljava/io/File;", "faceFile", "Lkotlin/Function0;", "Lkotlin/f1;", "result", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "failure", "t", "runType", "u", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class FaceDetectVM extends BaseViewModel {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FaceDetectVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3$1", f = "FaceDetectVM.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24432a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24433b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24434c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ File f24435d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24436e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, File file, l1.a<f1> aVar, kotlin.coroutines.c<? super a> cVar) {
            super(1, cVar);
            this.f24433b = str;
            this.f24434c = str2;
            this.f24435d = file;
            this.f24436e = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f24433b, this.f24434c, this.f24435d, this.f24436e, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24432a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.face.c cVar = new com.bxkj.student.v2.repository.face.c();
                RequestBody.Companion companion = RequestBody.Companion;
                MediaType.Companion companion2 = MediaType.Companion;
                RequestBody create = companion.create(companion2.parse("multipart/form-data"), this.f24433b);
                RequestBody create2 = companion.create(companion2.parse("multipart/form-data"), this.f24434c);
                RequestBody create3 = companion.create(companion2.parse("image/png"), this.f24435d);
                this.f24432a = 1;
                if (cVar.a(create, create2, create3, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24436e.invoke();
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FaceDetectVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a\u00020\u00062\u0019\u0010\u0005\u001a\u00150\u0000j\u0011`\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3$2", f = "FaceDetectVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class b extends SuspendLambda implements p<Exception, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24437a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24438b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<Exception, f1> f24439c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(l<? super Exception, f1> lVar, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f24439c = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            b bVar = new b(this.f24439c, cVar);
            bVar.f24438b = obj;
            return bVar;
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(exc, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24437a == 0) {
                d0.n(obj);
                this.f24439c.invoke((Exception) this.f24438b);
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FaceDetectVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3_2$1", f = "FaceDetectVM.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class c extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24440a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24441b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24442c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24443d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ File f24444e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24445f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, String str3, File file, l1.a<f1> aVar, kotlin.coroutines.c<? super c> cVar) {
            super(1, cVar);
            this.f24441b = str;
            this.f24442c = str2;
            this.f24443d = str3;
            this.f24444e = file;
            this.f24445f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new c(this.f24441b, this.f24442c, this.f24443d, this.f24444e, this.f24445f, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24440a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.face.c cVar = new com.bxkj.student.v2.repository.face.c();
                String str = this.f24441b;
                String str2 = this.f24442c;
                String str3 = this.f24443d;
                String path = this.f24444e.getPath();
                f0.o(path, "faceFile.path");
                this.f24440a = 1;
                if (com.bxkj.student.v2.repository.face.c.c(cVar, str, str2, str3, path, 0, this, 16, null) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24445f.invoke();
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FaceDetectVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.face.FaceDetectVM$faceDetectV3_2$2", f = "FaceDetectVM.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class d extends SuspendLambda implements p<Exception, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24446a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24447b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24448c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24449d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ File f24450e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24451f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, File file, l1.a<f1> aVar, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f24448c = str;
            this.f24449d = str2;
            this.f24450e = file;
            this.f24451f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            d dVar = new d(this.f24448c, this.f24449d, this.f24450e, this.f24451f, cVar);
            dVar.f24447b = obj;
            return dVar;
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((d) create(exc, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24446a;
            boolean z3 = false;
            if (i4 == 0) {
                d0.n(obj);
                if (e.a((Exception) this.f24447b)) {
                    j.d("\u79bb\u7ebf\u8dd1\u6b65\u4eba\u8138\u8bc6\u522b,\u5c06\u4e2d\u9014\u4eba\u8138\u8bc6\u522b\u7684\u7167\u7247\u5b58\u50a8\u672c\u5730\uff01", new Object[0]);
                    String str = this.f24448c;
                    String str2 = this.f24449d;
                    String path = this.f24450e.getPath();
                    f0.o(path, "faceFile.path");
                    c0.a aVar = new c0.a(0L, str, str2, path, 1, null);
                    AppDatabase.f23168a.a();
                    com.bxkj.student.v2.common.db.dao.a aVar2 = AppDatabase.f23179l;
                    if (aVar2 != null) {
                        this.f24446a = 1;
                        if (aVar2.insert(aVar, this) == h4) {
                            return h4;
                        }
                    }
                }
                return kotlin.coroutines.jvm.internal.a.a(z3);
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24451f.invoke();
            z3 = true;
            return kotlin.coroutines.jvm.internal.a.a(z3);
        }
    }

    public final void t(@NotNull String identify, @NotNull String type, @NotNull File faceFile, @NotNull l1.a<f1> result, @NotNull l<? super Exception, f1> failure) {
        f0.p(identify, "identify");
        f0.p(type, "type");
        f0.p(faceFile, "faceFile");
        f0.p(result, "result");
        f0.p(failure, "failure");
        BaseViewModel.j(this, new a(identify, type, faceFile, result, null), null, null, null, null, new b(failure, null), null, null, 222, null);
    }

    public final void u(@NotNull String identify, @NotNull String type, @NotNull String runType, @NotNull File faceFile, @NotNull l1.a<f1> result) {
        f0.p(identify, "identify");
        f0.p(type, "type");
        f0.p(runType, "runType");
        f0.p(faceFile, "faceFile");
        f0.p(result, "result");
        BaseViewModel.j(this, new c(identify, type, runType, faceFile, result, null), null, new d(identify, type, faceFile, result, null), null, null, null, null, null, 250, null);
    }
}
