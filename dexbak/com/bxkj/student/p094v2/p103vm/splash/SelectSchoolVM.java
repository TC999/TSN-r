package com.bxkj.student.p094v2.p103vm.splash;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.student.p094v2.repository.splash.SelectSchoolRepository;
import java.util.List;
import java.util.Map;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: SelectSchoolVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J6\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\t\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005\u0012\u0004\u0012\u00020\b0\u0004R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/splash/SelectSchoolVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "name", "Lkotlin/Function1;", "", "", "", "Lkotlin/f1;", ConstantHelper.LOG_FINISH, "v", "Lcom/bxkj/student/v2/repository/splash/a;", "h", "Lkotlin/o;", "u", "()Lcom/bxkj/student/v2/repository/splash/a;", "selectSchoolRepository", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.splash.SelectSchoolVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SelectSchoolVM extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private final InterfaceC14378o f21042h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectSchoolVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.splash.SelectSchoolVM$searchSchool$1", m8638f = "SelectSchoolVM.kt", m8637i = {}, m8636l = {17}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.splash.SelectSchoolVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5865a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21043a;

        /* renamed from: c */
        final /* synthetic */ String f21045c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC15280l<List<Map<String, Object>>, Unit> f21046d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5865a(String str, InterfaceC15280l<? super List<Map<String, Object>>, Unit> interfaceC15280l, InterfaceC14268c<? super C5865a> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21045c = str;
            this.f21046d = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5865a(this.f21045c, this.f21046d, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5865a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21043a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SelectSchoolRepository m38097u = SelectSchoolVM.this.m38097u();
                String str = this.f21045c;
                this.f21043a = 1;
                obj = m38097u.m38987a(str, this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            List<Map<String, Object>> list = (List) obj;
            if (list != null) {
                this.f21046d.invoke(list);
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: SelectSchoolVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/splash/a;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.splash.SelectSchoolVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5866b extends Lambda implements InterfaceC15269a<SelectSchoolRepository> {

        /* renamed from: a */
        public static final C5866b f21047a = new C5866b();

        C5866b() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final SelectSchoolRepository invoke() {
            return new SelectSchoolRepository();
        }
    }

    public SelectSchoolVM() {
        InterfaceC14378o m7719c;
        m7719c = C14389r.m7719c(C5866b.f21047a);
        this.f21042h = m7719c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public final SelectSchoolRepository m38097u() {
        return (SelectSchoolRepository) this.f21042h.getValue();
    }

    /* renamed from: v */
    public final void m38096v(@NotNull String name, @NotNull InterfaceC15280l<? super List<Map<String, Object>>, Unit> finish) {
        C14342f0.m8184p(name, "name");
        C14342f0.m8184p(finish, "finish");
        BaseViewModel.m43947l(this, new C5865a(name, finish, null), null, null, null, null, null, 62, null);
    }
}
