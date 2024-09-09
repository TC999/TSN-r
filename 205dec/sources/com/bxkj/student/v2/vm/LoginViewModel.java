package com.bxkj.student.v2.vm;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.data.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.q;
import l1.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LoginViewModel.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0006J$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R6\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/bxkj/student/v2/vm/LoginViewModel;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "", "", "resultDataMap", "Lkotlin/f1;", "B", "v", "A", "openId", "type", "Lkotlin/Function0;", "success", "D", "C", "Landroidx/databinding/ObservableField;", "h", "Landroidx/databinding/ObservableField;", "z", "()Landroidx/databinding/ObservableField;", "G", "(Landroidx/databinding/ObservableField;)V", "username", "i", "y", "F", "password", "Landroidx/lifecycle/MutableLiveData;", "j", "Landroidx/lifecycle/MutableLiveData;", "w", "()Landroidx/lifecycle/MutableLiveData;", "E", "(Landroidx/lifecycle/MutableLiveData;)V", "loginData", "Lcom/bxkj/student/v2/repository/a;", "k", "Lkotlin/o;", "x", "()Lcom/bxkj/student/v2/repository/a;", "mLoginRepository", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class LoginViewModel extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private ObservableField<String> f24321h = new ObservableField<>();
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private ObservableField<String> f24322i = new ObservableField<>();
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24323j = new MutableLiveData<>();
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final o f24324k = q.c(new e());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LoginViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$autoLogin$1", f = "LoginViewModel.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24325a;

        a(kotlin.coroutines.c<? super a> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new a(cVar);
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
            int i4 = this.f24325a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.splash.b bVar = new com.bxkj.student.v2.repository.splash.b();
                String o4 = com.bxkj.base.v2.data.a.b.a().o();
                this.f24325a = 1;
                obj = bVar.a(o4, this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            Map<String, Object> map = (Map) obj;
            a.b bVar2 = com.bxkj.base.v2.data.a.b;
            com.bxkj.base.v2.data.a a4 = bVar2.a();
            Object obj2 = map.get("access_token");
            if (obj2 == null) {
                obj2 = "";
            }
            a4.C(String.valueOf(obj2));
            com.bxkj.base.v2.data.a a5 = bVar2.a();
            Object obj3 = map.get("refresh_token");
            a5.T(String.valueOf(obj3 != null ? obj3 : ""));
            LoginViewModel.this.w().postValue(map);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LoginViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$login$1", f = "LoginViewModel.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24327a;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new b(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24327a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.a x3 = LoginViewModel.this.x();
                this.f24327a = 1;
                obj = x3.b(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            LoginViewModel.this.B((Map) obj);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LoginViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$loginThird$1", f = "LoginViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24329a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24331c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24332d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, kotlin.coroutines.c<? super c> cVar) {
            super(1, cVar);
            this.f24331c = str;
            this.f24332d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new c(this.f24331c, this.f24332d, cVar);
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
            int i4 = this.f24329a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.a x3 = LoginViewModel.this.x();
                String str = this.f24331c;
                String str2 = this.f24332d;
                this.f24329a = 1;
                obj = x3.c(str, str2, this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            LoginViewModel.this.B((Map) obj);
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LoginViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$loginThirdCheck$1", f = "LoginViewModel.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class d extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24333a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24335c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24336d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24337e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, l1.a<f1> aVar, kotlin.coroutines.c<? super d> cVar) {
            super(1, cVar);
            this.f24335c = str;
            this.f24336d = str2;
            this.f24337e = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new d(this.f24335c, this.f24336d, this.f24337e, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((d) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24333a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.a x3 = LoginViewModel.this.x();
                String str = this.f24335c;
                String str2 = this.f24336d;
                this.f24333a = 1;
                if (x3.d(str, str2, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24337e.invoke();
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LoginViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class e extends Lambda implements l1.a<com.bxkj.student.v2.repository.a> {
        e() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.a invoke() {
            return new com.bxkj.student.v2.repository.a(LoginViewModel.this);
        }
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class f extends Lambda implements d2.a<com.bxkj.student.v2.repository.b> {
        f() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.b invoke() {
            return new com.bxkj.student.v2.repository.b(LoginViewModel.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(Map<String, ? extends Object> map) {
        a.b bVar = com.bxkj.base.v2.data.a.b;
        com.bxkj.base.v2.data.a a4 = bVar.a();
        Object obj = map.get("user_id");
        if (obj == null) {
            obj = "";
        }
        a4.Y(String.valueOf(obj));
        if (bVar.a().t().length() > 0) {
            com.bxkj.base.v2.data.a a5 = bVar.a();
            Object obj2 = map.get("username");
            if (obj2 == null) {
                obj2 = "";
            }
            a5.Z(String.valueOf(obj2));
            com.bxkj.base.v2.data.a a6 = bVar.a();
            Object obj3 = map.get("access_token");
            if (obj3 == null) {
                obj3 = "";
            }
            a6.C(String.valueOf(obj3));
            com.bxkj.base.v2.data.a a7 = bVar.a();
            Object obj4 = map.get("refresh_token");
            if (obj4 == null) {
                obj4 = "";
            }
            a7.T(String.valueOf(obj4));
            com.bxkj.base.v2.data.a a8 = bVar.a();
            Object obj5 = map.get("refresh_token");
            if (obj5 == null) {
                obj5 = "";
            }
            a8.T(String.valueOf(obj5));
            com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
            bVar.a().a0("");
            bVar.a().G(String.valueOf((int) Double.parseDouble(lVar.t(map, "dept_id"))));
            bVar.a().t();
            if (((int) Double.parseDouble(lVar.t(map, "dept_id"))) == 2) {
                e().postValue("\u5bf9\u4e0d\u8d77\uff0c\u60a8\u662f\u6559\u5e08\uff01\u8bf7\u4f7f\u7528\u4f53\u9002\u80fd\u6559\u5e08\u7aefApp\u767b\u5f55");
                return;
            }
            bVar.a().M(true);
            v();
            return;
        }
        Object obj6 = map.get("code");
        String str = obj6 != null ? obj6 : "";
        Object obj7 = map.get("msg");
        if (obj7 == null) {
            obj7 = "\u672a\u77e5\u9519\u8bef";
        }
        if (f0.g(str, 1)) {
            e().postValue(f0.C("\u767b\u5f55\u5931\u8d25,", obj7));
        }
    }

    private final void v() {
        BaseViewModel.j(this, new a(null), null, null, null, null, null, null, null, 254, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.a x() {
        return (com.bxkj.student.v2.repository.a) this.f24324k.getValue();
    }

    public final void A() {
        d().setValue("\u6b63\u5728\u767b\u5f55...");
        BaseViewModel.j(this, new b(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void C(@NotNull String openId, @NotNull String type) {
        f0.p(openId, "openId");
        f0.p(type, "type");
        BaseViewModel.j(this, new c(openId, type, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void D(@NotNull String openId, @NotNull String type, @NotNull l1.a<f1> success) {
        f0.p(openId, "openId");
        f0.p(type, "type");
        f0.p(success, "success");
        BaseViewModel.j(this, new d(openId, type, success, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void E(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24323j = mutableLiveData;
    }

    public final void F(@NotNull ObservableField<String> observableField) {
        f0.p(observableField, "<set-?>");
        this.f24322i = observableField;
    }

    public final void G(@NotNull ObservableField<String> observableField) {
        f0.p(observableField, "<set-?>");
        this.f24321h = observableField;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> w() {
        return this.f24323j;
    }

    @NotNull
    public final ObservableField<String> y() {
        return this.f24322i;
    }

    @NotNull
    public final ObservableField<String> z() {
        return this.f24321h;
    }
}
