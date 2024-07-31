package com.bxkj.student.run.app.p093vm;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.List;
import kotlin.C14294d0;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p012a0.RunRepository;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: RunVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\u0007\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002J$\u0010\b\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002J,\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u001c\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002J\u001c\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u001c\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J,\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u001c\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0004R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, m12616d2 = {"Lcom/bxkj/student/run/app/vm/RunVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/Function1;", "", "Lcom/bxkj/student/run/app/offline/table/RunDb;", "Lkotlin/f1;", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, UMCommonContent.f37777aG, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "runType", "x", "runDb", "Lkotlin/Function0;", "C", "B", "", "identify", "u", "v", "y", "La0/a;", "h", "Lkotlin/o;", IAdInterListener.AdReqParam.WIDTH, "()La0/a;", "runStartRepository", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.run.app.vm.RunVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RunVM extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private final InterfaceC14378o f19732h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$deleteExceptionRecord$1", m8638f = "RunVM.kt", m8637i = {}, m8636l = {82}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5414a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f19733a;

        /* renamed from: b */
        final /* synthetic */ String f19734b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5414a(String str, InterfaceC14268c<? super C5414a> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19734b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5414a(this.f19734b, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5414a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f19733a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                RunRepository runRepository = new RunRepository();
                String str = this.f19734b;
                this.f19733a = 1;
                if (runRepository.m60054a(str, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$getLocalRecordById$1", m8638f = "RunVM.kt", m8637i = {}, m8636l = {89}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5415b extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f19735a;

        /* renamed from: b */
        int f19736b;

        /* renamed from: c */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f19737c;

        /* renamed from: d */
        final /* synthetic */ String f19738d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5415b(Ref.ObjectRef<List<RunDb>> objectRef, String str, InterfaceC14268c<? super C5415b> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19737c = objectRef;
            this.f19738d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5415b(this.f19737c, this.f19738d, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5415b) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t;
            m8642h = C14287b.m8642h();
            int i = this.f19736b;
            if (i == 0) {
                C14294d0.m8596n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f19737c;
                RunRepository runRepository = new RunRepository();
                String str = this.f19738d;
                this.f19735a = objectRef2;
                this.f19736b = 1;
                Object m60052c = runRepository.m60052c(str, this);
                if (m60052c == m8642h) {
                    return m8642h;
                }
                objectRef = objectRef2;
                t = m60052c;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                objectRef = (Ref.ObjectRef) this.f19735a;
                C14294d0.m8596n(obj);
                t = obj;
            }
            objectRef.element = t;
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$getLocalRecordById$2", m8638f = "RunVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5416c extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f19739a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l<List<RunDb>, Unit> f19740b;

        /* renamed from: c */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f19741c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5416c(InterfaceC15280l<? super List<RunDb>, Unit> interfaceC15280l, Ref.ObjectRef<List<RunDb>> objectRef, InterfaceC14268c<? super C5416c> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19740b = interfaceC15280l;
            this.f19741c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5416c(this.f19740b, this.f19741c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5416c) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f19739a == 0) {
                C14294d0.m8596n(obj);
                this.f19740b.invoke(this.f19741c.element);
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$getUploadFailSportsByType$1", m8638f = "RunVM.kt", m8637i = {}, m8636l = {40}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5417d extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f19742a;

        /* renamed from: b */
        int f19743b;

        /* renamed from: c */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f19744c;

        /* renamed from: d */
        final /* synthetic */ RunVM f19745d;

        /* renamed from: e */
        final /* synthetic */ int f19746e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5417d(Ref.ObjectRef<List<RunDb>> objectRef, RunVM runVM, int i, InterfaceC14268c<? super C5417d> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19744c = objectRef;
            this.f19745d = runVM;
            this.f19746e = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5417d(this.f19744c, this.f19745d, this.f19746e, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5417d) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t;
            m8642h = C14287b.m8642h();
            int i = this.f19743b;
            if (i == 0) {
                C14294d0.m8596n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f19744c;
                RunRepository m39502w = this.f19745d.m39502w();
                String account = LoginUser.getLoginUser().getAccount();
                C14342f0.m8185o(account, "getLoginUser().account");
                int i2 = this.f19746e;
                this.f19742a = objectRef2;
                this.f19743b = 1;
                Object m60050e = m39502w.m60050e(account, i2, this);
                if (m60050e == m8642h) {
                    return m8642h;
                }
                objectRef = objectRef2;
                t = m60050e;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                objectRef = (Ref.ObjectRef) this.f19742a;
                C14294d0.m8596n(obj);
                t = obj;
            }
            objectRef.element = t;
            return Unit.f41048a;
        }
    }

    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$getUploadFailSportsByType$2", m8638f = "RunVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5418e extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f19747a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l<List<RunDb>, Unit> f19748b;

        /* renamed from: c */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f19749c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5418e(InterfaceC15280l<? super List<RunDb>, Unit> interfaceC15280l, Ref.ObjectRef<List<RunDb>> objectRef, InterfaceC14268c<? super C5418e> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19748b = interfaceC15280l;
            this.f19749c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5418e(this.f19748b, this.f19749c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5418e) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f19747a == 0) {
                C14294d0.m8596n(obj);
                this.f19748b.invoke(this.f19749c.element);
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$insertRun$1", m8638f = "RunVM.kt", m8637i = {}, m8636l = {97}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5419f extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f19750a;

        /* renamed from: b */
        final /* synthetic */ RunDb f19751b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5419f(RunDb runDb, InterfaceC14268c<? super C5419f> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19751b = runDb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5419f(this.f19751b, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5419f) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f19750a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                RunRepository runRepository = new RunRepository();
                RunDb runDb = this.f19751b;
                this.f19750a = 1;
                if (runRepository.m60049f(runDb, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$queryExceptionSports$1", m8638f = "RunVM.kt", m8637i = {}, m8636l = {21}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5420g extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f19752a;

        /* renamed from: b */
        int f19753b;

        /* renamed from: c */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f19754c;

        /* renamed from: d */
        final /* synthetic */ RunVM f19755d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5420g(Ref.ObjectRef<List<RunDb>> objectRef, RunVM runVM, InterfaceC14268c<? super C5420g> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19754c = objectRef;
            this.f19755d = runVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5420g(this.f19754c, this.f19755d, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5420g) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t;
            m8642h = C14287b.m8642h();
            int i = this.f19753b;
            if (i == 0) {
                C14294d0.m8596n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f19754c;
                RunRepository m39502w = this.f19755d.m39502w();
                String account = LoginUser.getLoginUser().getAccount();
                C14342f0.m8185o(account, "getLoginUser().account");
                this.f19752a = objectRef2;
                this.f19753b = 1;
                Object m60053b = m39502w.m60053b(account, this);
                if (m60053b == m8642h) {
                    return m8642h;
                }
                objectRef = objectRef2;
                t = m60053b;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                objectRef = (Ref.ObjectRef) this.f19752a;
                C14294d0.m8596n(obj);
                t = obj;
            }
            objectRef.element = t;
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$queryExceptionSports$2", m8638f = "RunVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5421h extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f19756a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l<List<RunDb>, Unit> f19757b;

        /* renamed from: c */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f19758c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5421h(InterfaceC15280l<? super List<RunDb>, Unit> interfaceC15280l, Ref.ObjectRef<List<RunDb>> objectRef, InterfaceC14268c<? super C5421h> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19757b = interfaceC15280l;
            this.f19758c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5421h(this.f19757b, this.f19758c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5421h) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f19756a == 0) {
                C14294d0.m8596n(obj);
                this.f19757b.invoke(this.f19758c.element);
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$queryFailRecord$1", m8638f = "RunVM.kt", m8637i = {}, m8636l = {30}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5422i extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f19759a;

        /* renamed from: b */
        int f19760b;

        /* renamed from: c */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f19761c;

        /* renamed from: d */
        final /* synthetic */ RunVM f19762d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5422i(Ref.ObjectRef<List<RunDb>> objectRef, RunVM runVM, InterfaceC14268c<? super C5422i> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19761c = objectRef;
            this.f19762d = runVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5422i(this.f19761c, this.f19762d, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5422i) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t;
            m8642h = C14287b.m8642h();
            int i = this.f19760b;
            if (i == 0) {
                C14294d0.m8596n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f19761c;
                RunRepository m39502w = this.f19762d.m39502w();
                String account = LoginUser.getLoginUser().getAccount();
                C14342f0.m8185o(account, "getLoginUser().account");
                this.f19759a = objectRef2;
                this.f19760b = 1;
                Object m60051d = m39502w.m60051d(account, this);
                if (m60051d == m8642h) {
                    return m8642h;
                }
                objectRef = objectRef2;
                t = m60051d;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                objectRef = (Ref.ObjectRef) this.f19759a;
                C14294d0.m8596n(obj);
                t = obj;
            }
            objectRef.element = t;
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$queryFailRecord$2", m8638f = "RunVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5423j extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f19763a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l<List<RunDb>, Unit> f19764b;

        /* renamed from: c */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f19765c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5423j(InterfaceC15280l<? super List<RunDb>, Unit> interfaceC15280l, Ref.ObjectRef<List<RunDb>> objectRef, InterfaceC14268c<? super C5423j> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19764b = interfaceC15280l;
            this.f19765c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5423j(this.f19764b, this.f19765c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5423j) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f19763a == 0) {
                C14294d0.m8596n(obj);
                this.f19764b.invoke(this.f19765c.element);
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"La0/a;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5424k extends Lambda implements InterfaceC15269a<RunRepository> {

        /* renamed from: a */
        public static final C5424k f19766a = new C5424k();

        C5424k() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final RunRepository invoke() {
            return new RunRepository();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionStatus$1", m8638f = "RunVM.kt", m8637i = {}, m8636l = {69}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5425l extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f19767a;

        /* renamed from: b */
        final /* synthetic */ RunDb f19768b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5425l(RunDb runDb, InterfaceC14268c<? super C5425l> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19768b = runDb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5425l(this.f19768b, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5425l) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f19767a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                this.f19768b.setEndTime(String.valueOf(System.currentTimeMillis()));
                RunRepository runRepository = new RunRepository();
                String endTime = this.f19768b.getEndTime();
                String uploadType = this.f19768b.getUploadType();
                String identify = this.f19768b.getIdentify();
                this.f19767a = 1;
                if (runRepository.m60048g(endTime, uploadType, identify, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionStatus$2", m8638f = "RunVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5426m extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f19769a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15269a<Unit> f19770b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5426m(InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5426m> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19770b = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5426m(this.f19770b, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5426m) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f19769a == 0) {
                C14294d0.m8596n(obj);
                this.f19770b.invoke();
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionToFail$1", m8638f = "RunVM.kt", m8637i = {}, m8636l = {54}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$n */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5427n extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f19771a;

        /* renamed from: b */
        final /* synthetic */ RunDb f19772b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5427n(RunDb runDb, InterfaceC14268c<? super C5427n> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19772b = runDb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5427n(this.f19772b, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5427n) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f19771a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                this.f19772b.setEndTime(String.valueOf(System.currentTimeMillis()));
                this.f19772b.setUploadType("2");
                RunRepository runRepository = new RunRepository();
                String endTime = this.f19772b.getEndTime();
                String uploadType = this.f19772b.getUploadType();
                String identify = this.f19772b.getIdentify();
                this.f19771a = 1;
                if (runRepository.m60048g(endTime, uploadType, identify, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RunVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionToFail$2", m8638f = "RunVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.run.app.vm.RunVM$o */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5428o extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f19773a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15269a<Unit> f19774b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5428o(InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5428o> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f19774b = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5428o(this.f19774b, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5428o) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f19773a == 0) {
                C14294d0.m8596n(obj);
                this.f19774b.invoke();
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RunVM() {
        InterfaceC14378o m7719c;
        m7719c = C14389r.m7719c(C5424k.f19766a);
        this.f19732h = m7719c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public final RunRepository m39502w() {
        return (RunRepository) this.f19732h.getValue();
    }

    /* renamed from: A */
    public final void m39508A(@NotNull InterfaceC15280l<? super List<RunDb>, Unit> complete) {
        C14342f0.m8184p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.m43949j(this, new C5422i(objectRef, this, null), null, null, null, new C5423j(complete, objectRef, null), null, null, null, 238, null);
    }

    /* renamed from: B */
    public final void m39507B(@NotNull RunDb runDb, @NotNull InterfaceC15269a<Unit> complete) {
        C14342f0.m8184p(runDb, "runDb");
        C14342f0.m8184p(complete, "complete");
        if (TextUtils.isEmpty(runDb.getEndTime())) {
            BaseViewModel.m43949j(this, new C5425l(runDb, null), null, null, null, new C5426m(complete, null), null, null, null, 238, null);
        }
    }

    /* renamed from: C */
    public final void m39506C(@NotNull RunDb runDb, @NotNull InterfaceC15269a<Unit> complete) {
        C14342f0.m8184p(runDb, "runDb");
        C14342f0.m8184p(complete, "complete");
        if (TextUtils.isEmpty(runDb.getEndTime())) {
            BaseViewModel.m43949j(this, new C5427n(runDb, null), null, null, null, new C5428o(complete, null), null, null, null, 238, null);
        }
    }

    /* renamed from: u */
    public final void m39504u(@NotNull String identify) {
        C14342f0.m8184p(identify, "identify");
        BaseViewModel.m43949j(this, new C5414a(identify, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: v */
    public final void m39503v(@NotNull String identify, @NotNull InterfaceC15280l<? super List<RunDb>, Unit> complete) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.m43949j(this, new C5415b(objectRef, identify, null), null, null, null, new C5416c(complete, objectRef, null), null, null, null, 238, null);
    }

    /* renamed from: x */
    public final void m39501x(int i, @NotNull InterfaceC15280l<? super List<RunDb>, Unit> complete) {
        C14342f0.m8184p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.m43949j(this, new C5417d(objectRef, this, i, null), null, null, null, new C5418e(complete, objectRef, null), null, null, null, 238, null);
    }

    /* renamed from: y */
    public final void m39500y(@NotNull RunDb runDb) {
        C14342f0.m8184p(runDb, "runDb");
        BaseViewModel.m43949j(this, new C5419f(runDb, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: z */
    public final void m39499z(@NotNull InterfaceC15280l<? super List<RunDb>, Unit> complete) {
        C14342f0.m8184p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.m43949j(this, new C5420g(objectRef, this, null), null, null, null, new C5421h(complete, objectRef, null), null, null, null, 238, null);
    }
}
