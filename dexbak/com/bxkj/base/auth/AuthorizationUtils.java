package com.bxkj.base.auth;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.AuthorizationDialog;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4229c;
import java.util.Map;
import p635q.DonationApiService;
import p635q.JobApiService;
import p635q.LostApiService;
import p635q.MallApiService;
import p635q.RunnerApiService;
import p635q.SecondHandApiService;

/* renamed from: com.bxkj.base.auth.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AuthorizationUtils {

    /* renamed from: a */
    private Context f14648a;

    /* renamed from: b */
    private InterfaceC3827g f14649b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthorizationUtils.java */
    /* renamed from: com.bxkj.base.auth.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3815a extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ FragmentManager f14650a;

        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3816a implements AuthorizationDialog.InterfaceC3814c {
            C3816a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.InterfaceC3814c
            /* renamed from: a */
            public void mo44321a() {
                LoginUser.getLoginUser().setAuthorizationInMall(true);
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                }
            }
        }

        C3815a(FragmentManager fragmentManager) {
            this.f14650a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInMall(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInMall()) {
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().m44331f(new C3816a()).m44332e(0).show(this.f14650a, "mall");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthorizationUtils.java */
    /* renamed from: com.bxkj.base.auth.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3817b extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ FragmentManager f14653a;

        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3818a implements AuthorizationDialog.InterfaceC3814c {
            C3818a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.InterfaceC3814c
            /* renamed from: a */
            public void mo44321a() {
                LoginUser.getLoginUser().setAuthorizationInLost(true);
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                }
            }
        }

        C3817b(FragmentManager fragmentManager) {
            this.f14653a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInLost(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInLost()) {
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().m44331f(new C3818a()).m44332e(1).show(this.f14653a, "mall");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthorizationUtils.java */
    /* renamed from: com.bxkj.base.auth.a$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3819c extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ FragmentManager f14656a;

        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$c$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3820a implements AuthorizationDialog.InterfaceC3814c {
            C3820a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.InterfaceC3814c
            /* renamed from: a */
            public void mo44321a() {
                LoginUser.getLoginUser().setAuthorizationInSecondHand(true);
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                }
            }
        }

        C3819c(FragmentManager fragmentManager) {
            this.f14656a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInSecondHand(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInSecondHand()) {
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().m44331f(new C3820a()).m44332e(2).show(this.f14656a, "secondHand");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthorizationUtils.java */
    /* renamed from: com.bxkj.base.auth.a$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3821d extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ FragmentManager f14659a;

        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$d$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3822a implements AuthorizationDialog.InterfaceC3814c {
            C3822a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.InterfaceC3814c
            /* renamed from: a */
            public void mo44321a() {
                LoginUser.getLoginUser().setAuthorizationInJob(true);
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                }
            }
        }

        C3821d(FragmentManager fragmentManager) {
            this.f14659a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInJob(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInJob()) {
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().m44331f(new C3822a()).m44332e(3).show(this.f14659a, "job");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthorizationUtils.java */
    /* renamed from: com.bxkj.base.auth.a$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3823e extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ FragmentManager f14662a;

        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$e$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3824a implements AuthorizationDialog.InterfaceC3814c {
            C3824a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.InterfaceC3814c
            /* renamed from: a */
            public void mo44321a() {
                LoginUser.getLoginUser().setAuthorizationInRuner(true);
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                }
            }
        }

        C3823e(FragmentManager fragmentManager) {
            this.f14662a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInRuner(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInRuner()) {
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().m44331f(new C3824a()).m44332e(4).show(this.f14662a, "job");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AuthorizationUtils.java */
    /* renamed from: com.bxkj.base.auth.a$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3825f extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ FragmentManager f14665a;

        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$f$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3826a implements AuthorizationDialog.InterfaceC3814c {
            C3826a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.InterfaceC3814c
            /* renamed from: a */
            public void mo44321a() {
                LoginUser.getLoginUser().setAuthorizationDonation(true);
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                }
            }
        }

        C3825f(FragmentManager fragmentManager) {
            this.f14665a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationDonation(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationDonation()) {
                if (AuthorizationUtils.this.f14649b != null) {
                    AuthorizationUtils.this.f14649b.mo40697a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().m44331f(new C3826a()).m44332e(5).show(this.f14665a, "donation");
        }
    }

    /* compiled from: AuthorizationUtils.java */
    /* renamed from: com.bxkj.base.auth.a$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3827g {
        /* renamed from: a */
        void mo40697a();
    }

    public AuthorizationUtils(Context context) {
        this.f14648a = context;
    }

    /* renamed from: c */
    private void m44328c(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationDonation()) {
            InterfaceC3827g interfaceC3827g = this.f14649b;
            if (interfaceC3827g != null) {
                interfaceC3827g.mo40697a();
                return;
            }
            return;
        }
        Http.with(this.f14648a).setObservable(((DonationApiService) Http.getApiService(DonationApiService.class)).m2307f(LoginUser.getLoginUser().getOpenId())).setDataListener(new C3825f(fragmentManager));
    }

    /* renamed from: d */
    private void m44327d(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInJob()) {
            InterfaceC3827g interfaceC3827g = this.f14649b;
            if (interfaceC3827g != null) {
                interfaceC3827g.mo40697a();
                return;
            }
            return;
        }
        Http.with(this.f14648a).setObservable(((JobApiService) Http.getApiService(JobApiService.class)).m2292h(LoginUser.getLoginUser().getOpenId())).setDataListener(new C3821d(fragmentManager));
    }

    /* renamed from: e */
    private void m44326e(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInLost()) {
            InterfaceC3827g interfaceC3827g = this.f14649b;
            if (interfaceC3827g != null) {
                interfaceC3827g.mo40697a();
                return;
            }
            return;
        }
        Http.with(this.f14648a).setObservable(((LostApiService) Http.getApiService(LostApiService.class)).m2279i(LoginUser.getLoginUser().getOpenId())).setDataListener(new C3817b(fragmentManager));
    }

    /* renamed from: f */
    private void m44325f(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInMall()) {
            InterfaceC3827g interfaceC3827g = this.f14649b;
            if (interfaceC3827g != null) {
                interfaceC3827g.mo40697a();
                return;
            }
            return;
        }
        Http.with(this.f14648a).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2228t(LoginUser.getLoginUser().getOpenId())).setDataListener(new C3815a(fragmentManager));
    }

    /* renamed from: g */
    private void m44324g(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInRuner()) {
            InterfaceC3827g interfaceC3827g = this.f14649b;
            if (interfaceC3827g != null) {
                interfaceC3827g.mo40697a();
                return;
            }
            return;
        }
        Http.with(this.f14648a).setObservable(((RunnerApiService) Http.getApiService(RunnerApiService.class)).m2216f(LoginUser.getLoginUser().getOpenId())).setDataListener(new C3823e(fragmentManager));
    }

    /* renamed from: h */
    private void m44323h(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInSecondHand()) {
            InterfaceC3827g interfaceC3827g = this.f14649b;
            if (interfaceC3827g != null) {
                interfaceC3827g.mo40697a();
                return;
            }
            return;
        }
        Http.with(this.f14648a).setObservable(((SecondHandApiService) Http.getApiService(SecondHandApiService.class)).m2194f(LoginUser.getLoginUser().getOpenId())).setDataListener(new C3819c(fragmentManager));
    }

    /* renamed from: b */
    public AuthorizationUtils m44329b(FragmentManager fragmentManager, int i) {
        if (!LoginUser.getLoginUser().isLogin()) {
            this.f14648a.startActivity(new Intent().setClassName(C4229c.f16086b, "com.bxkj.student.personal.login.LoginActivity"));
            return this;
        }
        if (i == 0) {
            m44325f(fragmentManager);
        } else if (i == 1) {
            m44326e(fragmentManager);
        } else if (i == 2) {
            m44323h(fragmentManager);
        } else if (i == 3) {
            m44327d(fragmentManager);
        } else if (i == 4) {
            m44324g(fragmentManager);
        } else if (i == 5) {
            m44328c(fragmentManager);
        }
        return this;
    }

    /* renamed from: i */
    public AuthorizationUtils m44322i(InterfaceC3827g interfaceC3827g) {
        this.f14649b = interfaceC3827g;
        return this;
    }
}
