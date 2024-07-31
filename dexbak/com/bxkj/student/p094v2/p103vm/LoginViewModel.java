package com.bxkj.student.p094v2.p103vm;

import androidx.databinding.ObservableField;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.amap.api.services.core.AMapException;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.p094v2.repository.LoginRepository;
import com.bxkj.student.p094v2.repository.splash.SplashRepository;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.common.SocializeConstants;
import io.netty.handler.codec.dns.DnsRecord;
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

/* compiled from: LoginViewModel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0006J$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R6\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006,"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/LoginViewModel;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "", "", "resultDataMap", "Lkotlin/f1;", "B", "v", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "openId", "type", "Lkotlin/Function0;", "success", "D", "C", "Landroidx/databinding/ObservableField;", "h", "Landroidx/databinding/ObservableField;", UMCommonContent.f37777aG, "()Landroidx/databinding/ObservableField;", "G", "(Landroidx/databinding/ObservableField;)V", "username", "i", "y", "F", "password", "Landroidx/lifecycle/MutableLiveData;", "j", "Landroidx/lifecycle/MutableLiveData;", IAdInterListener.AdReqParam.WIDTH, "()Landroidx/lifecycle/MutableLiveData;", ExifInterface.LONGITUDE_EAST, "(Landroidx/lifecycle/MutableLiveData;)V", "loginData", "Lcom/bxkj/student/v2/repository/a;", "k", "Lkotlin/o;", "x", "()Lcom/bxkj/student/v2/repository/a;", "mLoginRepository", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.LoginViewModel */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class LoginViewModel extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private ObservableField<String> f20902h = new ObservableField<>();
    @NotNull

    /* renamed from: i */
    private ObservableField<String> f20903i = new ObservableField<>();
    @NotNull

    /* renamed from: j */
    private MutableLiveData<Map<String, Object>> f20904j = new MutableLiveData<>();
    @NotNull

    /* renamed from: k */
    private final InterfaceC14378o f20905k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.LoginViewModel$autoLogin$1", m8638f = "LoginViewModel.kt", m8637i = {}, m8636l = {75}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.LoginViewModel$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5834a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20906a;

        C5834a(InterfaceC14268c<? super C5834a> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5834a(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5834a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20906a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SplashRepository splashRepository = new SplashRepository();
                String m43647o = LoggedInUser.f15182b.m43634a().m43647o();
                this.f20906a = 1;
                obj = splashRepository.m38986a(m43647o, this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            Map<String, Object> map = (Map) obj;
            LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
            LoggedInUser m43634a = c3984b.m43634a();
            Object obj2 = map.get("access_token");
            if (obj2 == null) {
                obj2 = "";
            }
            m43634a.m43688C(String.valueOf(obj2));
            LoggedInUser m43634a2 = c3984b.m43634a();
            Object obj3 = map.get("refresh_token");
            m43634a2.m43671T(String.valueOf(obj3 != null ? obj3 : ""));
            LoginViewModel.this.m38194w().postValue(map);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.LoginViewModel$login$1", m8638f = "LoginViewModel.kt", m8637i = {}, m8636l = {22}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.LoginViewModel$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5835b extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20908a;

        C5835b(InterfaceC14268c<? super C5835b> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5835b(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5835b) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20908a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                LoginRepository m38193x = LoginViewModel.this.m38193x();
                this.f20908a = 1;
                obj = m38193x.m39008b(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            LoginViewModel.this.m38203B((Map) obj);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.LoginViewModel$loginThird$1", m8638f = "LoginViewModel.kt", m8637i = {}, m8636l = {68}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.LoginViewModel$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5836c extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20910a;

        /* renamed from: c */
        final /* synthetic */ String f20912c;

        /* renamed from: d */
        final /* synthetic */ String f20913d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5836c(String str, String str2, InterfaceC14268c<? super C5836c> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f20912c = str;
            this.f20913d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5836c(this.f20912c, this.f20913d, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5836c) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20910a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                LoginRepository m38193x = LoginViewModel.this.m38193x();
                String str = this.f20912c;
                String str2 = this.f20913d;
                this.f20910a = 1;
                obj = m38193x.m39007c(str, str2, this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            LoginViewModel.this.m38203B((Map) obj);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.LoginViewModel$loginThirdCheck$1", m8638f = "LoginViewModel.kt", m8637i = {}, m8636l = {62}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.LoginViewModel$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5837d extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20914a;

        /* renamed from: c */
        final /* synthetic */ String f20916c;

        /* renamed from: d */
        final /* synthetic */ String f20917d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC15269a<Unit> f20918e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5837d(String str, String str2, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5837d> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f20916c = str;
            this.f20917d = str2;
            this.f20918e = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5837d(this.f20916c, this.f20917d, this.f20918e, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5837d) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20914a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                LoginRepository m38193x = LoginViewModel.this.m38193x();
                String str = this.f20916c;
                String str2 = this.f20917d;
                this.f20914a = 1;
                if (m38193x.m39006d(str, str2, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            this.f20918e.invoke();
            return Unit.f41048a;
        }
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/a;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.LoginViewModel$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5838e extends Lambda implements InterfaceC15269a<LoginRepository> {
        C5838e() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final LoginRepository invoke() {
            return new LoginRepository(LoginViewModel.this);
        }
    }

    public LoginViewModel() {
        InterfaceC14378o m7719c;
        m7719c = C14389r.m7719c(new C5838e());
        this.f20905k = m7719c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public final void m38203B(Map<String, ? extends Object> map) {
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        LoggedInUser m43634a = c3984b.m43634a();
        Object obj = map.get(SocializeConstants.TENCENT_UID);
        if (obj == null) {
            obj = "";
        }
        m43634a.m43666Y(String.valueOf(obj));
        if (c3984b.m43634a().m43642t().length() > 0) {
            LoggedInUser m43634a2 = c3984b.m43634a();
            Object obj2 = map.get("username");
            if (obj2 == null) {
                obj2 = "";
            }
            m43634a2.m43665Z(String.valueOf(obj2));
            LoggedInUser m43634a3 = c3984b.m43634a();
            Object obj3 = map.get("access_token");
            if (obj3 == null) {
                obj3 = "";
            }
            m43634a3.m43688C(String.valueOf(obj3));
            LoggedInUser m43634a4 = c3984b.m43634a();
            Object obj4 = map.get("refresh_token");
            if (obj4 == null) {
                obj4 = "";
            }
            m43634a4.m43671T(String.valueOf(obj4));
            LoggedInUser m43634a5 = c3984b.m43634a();
            Object obj5 = map.get("refresh_token");
            if (obj5 == null) {
                obj5 = "";
            }
            m43634a5.m43671T(String.valueOf(obj5));
            JsonGet jsonGet = JsonGet.f15134a;
            c3984b.m43634a().m43663a0("");
            c3984b.m43634a().m43684G(String.valueOf((int) Double.parseDouble(jsonGet.m43760t(map, "dept_id"))));
            c3984b.m43634a().m43642t();
            if (((int) Double.parseDouble(jsonGet.m43760t(map, "dept_id"))) == 2) {
                m43954e().postValue("对不起，您是教师！请使用体适能教师端App登录");
                return;
            }
            c3984b.m43634a().m43678M(true);
            m38195v();
            return;
        }
        Object obj6 = map.get("code");
        String str = obj6 != null ? obj6 : "";
        Object obj7 = map.get("msg");
        if (obj7 == null) {
            obj7 = AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
        }
        if (C14342f0.m8193g(str, 1)) {
            m43954e().postValue(C14342f0.m8216C("登录失败,", obj7));
        }
    }

    /* renamed from: v */
    private final void m38195v() {
        BaseViewModel.m43949j(this, new C5834a(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public final LoginRepository m38193x() {
        return (LoginRepository) this.f20905k.getValue();
    }

    /* renamed from: A */
    public final void m38204A() {
        m43955d().setValue("正在登录...");
        BaseViewModel.m43949j(this, new C5835b(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: C */
    public final void m38202C(@NotNull String openId, @NotNull String type) {
        C14342f0.m8184p(openId, "openId");
        C14342f0.m8184p(type, "type");
        BaseViewModel.m43949j(this, new C5836c(openId, type, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: D */
    public final void m38201D(@NotNull String openId, @NotNull String type, @NotNull InterfaceC15269a<Unit> success) {
        C14342f0.m8184p(openId, "openId");
        C14342f0.m8184p(type, "type");
        C14342f0.m8184p(success, "success");
        BaseViewModel.m43949j(this, new C5837d(openId, type, success, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: E */
    public final void m38200E(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f20904j = mutableLiveData;
    }

    /* renamed from: F */
    public final void m38199F(@NotNull ObservableField<String> observableField) {
        C14342f0.m8184p(observableField, "<set-?>");
        this.f20903i = observableField;
    }

    /* renamed from: G */
    public final void m38198G(@NotNull ObservableField<String> observableField) {
        C14342f0.m8184p(observableField, "<set-?>");
        this.f20902h = observableField;
    }

    @NotNull
    /* renamed from: w */
    public final MutableLiveData<Map<String, Object>> m38194w() {
        return this.f20904j;
    }

    @NotNull
    /* renamed from: y */
    public final ObservableField<String> m38192y() {
        return this.f20903i;
    }

    @NotNull
    /* renamed from: z */
    public final ObservableField<String> m38191z() {
        return this.f20902h;
    }
}
