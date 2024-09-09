package com.bxkj.base.auth;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.AuthorizationDialog;
import com.bxkj.base.user.LoginUser;
import java.util.Map;
import q.h;
import q.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AuthorizationUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f18137a;

    /* renamed from: b  reason: collision with root package name */
    private g f18138b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AuthorizationUtils.java */
    /* renamed from: com.bxkj.base.auth.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class C0188a extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentManager f18139a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0189a implements AuthorizationDialog.c {
            C0189a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationInMall(true);
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                }
            }
        }

        C0188a(FragmentManager fragmentManager) {
            this.f18139a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInMall(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInMall()) {
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0189a()).e(0).show(this.f18139a, "mall");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AuthorizationUtils.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentManager f18142a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0190a implements AuthorizationDialog.c {
            C0190a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationInLost(true);
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                }
            }
        }

        b(FragmentManager fragmentManager) {
            this.f18142a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInLost(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInLost()) {
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0190a()).e(1).show(this.f18142a, "mall");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AuthorizationUtils.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class c extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentManager f18145a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$c$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0191a implements AuthorizationDialog.c {
            C0191a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationInSecondHand(true);
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                }
            }
        }

        c(FragmentManager fragmentManager) {
            this.f18145a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInSecondHand(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInSecondHand()) {
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0191a()).e(2).show(this.f18145a, "secondHand");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AuthorizationUtils.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class d extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentManager f18148a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$d$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0192a implements AuthorizationDialog.c {
            C0192a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationInJob(true);
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                }
            }
        }

        d(FragmentManager fragmentManager) {
            this.f18148a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInJob(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInJob()) {
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0192a()).e(3).show(this.f18148a, "job");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AuthorizationUtils.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class e extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentManager f18151a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$e$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0193a implements AuthorizationDialog.c {
            C0193a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationInRuner(true);
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                }
            }
        }

        e(FragmentManager fragmentManager) {
            this.f18151a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInRuner(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInRuner()) {
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0193a()).e(4).show(this.f18151a, "job");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AuthorizationUtils.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class f extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentManager f18154a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: AuthorizationUtils.java */
        /* renamed from: com.bxkj.base.auth.a$f$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class C0194a implements AuthorizationDialog.c {
            C0194a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationDonation(true);
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                }
            }
        }

        f(FragmentManager fragmentManager) {
            this.f18154a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationDonation(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationDonation()) {
                if (a.this.f18138b != null) {
                    a.this.f18138b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0194a()).e(5).show(this.f18154a, "donation");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AuthorizationUtils.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface g {
        void a();
    }

    public a(Context context) {
        this.f18137a = context;
    }

    private void c(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationDonation()) {
            g gVar = this.f18138b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f18137a).setObservable(((q.b) Http.getApiService(q.b.class)).f(LoginUser.getLoginUser().getOpenId())).setDataListener(new f(fragmentManager));
    }

    private void d(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInJob()) {
            g gVar = this.f18138b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f18137a).setObservable(((q.d) Http.getApiService(q.d.class)).h(LoginUser.getLoginUser().getOpenId())).setDataListener(new d(fragmentManager));
    }

    private void e(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInLost()) {
            g gVar = this.f18138b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f18137a).setObservable(((q.e) Http.getApiService(q.e.class)).i(LoginUser.getLoginUser().getOpenId())).setDataListener(new b(fragmentManager));
    }

    private void f(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInMall()) {
            g gVar = this.f18138b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f18137a).setObservable(((q.g) Http.getApiService(q.g.class)).t(LoginUser.getLoginUser().getOpenId())).setDataListener(new C0188a(fragmentManager));
    }

    private void g(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInRuner()) {
            g gVar = this.f18138b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f18137a).setObservable(((h) Http.getApiService(h.class)).f(LoginUser.getLoginUser().getOpenId())).setDataListener(new e(fragmentManager));
    }

    private void h(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInSecondHand()) {
            g gVar = this.f18138b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f18137a).setObservable(((i) Http.getApiService(i.class)).f(LoginUser.getLoginUser().getOpenId())).setDataListener(new c(fragmentManager));
    }

    public a b(FragmentManager fragmentManager, int i4) {
        if (!LoginUser.getLoginUser().isLogin()) {
            this.f18137a.startActivity(new Intent().setClassName("com.bxkj.student", "com.bxkj.student.personal.login.LoginActivity"));
            return this;
        }
        if (i4 == 0) {
            f(fragmentManager);
        } else if (i4 == 1) {
            e(fragmentManager);
        } else if (i4 == 2) {
            h(fragmentManager);
        } else if (i4 == 3) {
            d(fragmentManager);
        } else if (i4 == 4) {
            g(fragmentManager);
        } else if (i4 == 5) {
            c(fragmentManager);
        }
        return this;
    }

    public a i(g gVar) {
        this.f18138b = gVar;
        return this;
    }
}
