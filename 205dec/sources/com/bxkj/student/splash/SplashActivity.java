package com.bxkj.student.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.beizi.fusion.AdListener;
import com.beizi.fusion.SplashAd;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.z;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.common.utils.n;
import com.bxkj.student.databinding.AcSplashBinding;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.v2.ui.MainActivity;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.bxkj.student.v2.vm.splash.SplashVM;
import com.orhanobut.logger.j;
import com.stub.StubApp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SplashActivity.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/bxkj/student/splash/SplashActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcSplashBinding;", "Lcom/bxkj/student/v2/vm/splash/SplashVM;", "Lkotlin/f1;", "R", "Q", "O", "N", "E", "p", "onResume", "onPause", "onDestroy", "onBackPressed", "Landroid/os/CountDownTimer;", "i", "Landroid/os/CountDownTimer;", "countDownTimer", "", "j", "Z", "onlyOpenAd", "k", "canJumpImmediately", "Lcom/beizi/fusion/SplashAd;", "l", "Lcom/beizi/fusion/SplashAd;", "splashAd", "", "m", "I", "mTotalTime", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SplashActivity extends BaseActivity<AcSplashBinding, SplashVM> {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private CountDownTimer f23082i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f23083j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23084k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private SplashAd f23085l;

    /* renamed from: m  reason: collision with root package name */
    private final int f23086m = 5000;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SplashActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/bxkj/student/splash/SplashActivity$a", "Lcom/beizi/fusion/AdListener;", "Lkotlin/f1;", "onAdLoaded", "onAdShown", "", "errorCode", "onAdFailedToLoad", "onAdClosed", "", "millisUnitFinished", "onAdTick", "onAdClicked", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements AdListener {
        a() {
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdClicked() {
            j.g("BeiZisDemo->onAdClick", new Object[0]);
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdClosed() {
            j.g("BeiZisDemo->onAdClosed", new Object[0]);
            SplashActivity.this.R();
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdFailedToLoad(int i4) {
            j.g(f0.C("BeiZisDemo->onAdFailedToLoad:", Integer.valueOf(i4)), new Object[0]);
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdLoaded() {
            j.g("BeiZisDemo->onAdLoaded", new Object[0]);
            SplashAd splashAd = SplashActivity.this.f23085l;
            if (splashAd != null) {
                splashAd.show(SplashActivity.this.M().adsFl);
            }
            CountDownTimer countDownTimer = SplashActivity.this.f23082i;
            if (countDownTimer == null) {
                return;
            }
            countDownTimer.cancel();
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdShown() {
            CountDownTimer countDownTimer = SplashActivity.this.f23082i;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            j.g("BeiZisDemo->onAdShown", new Object[0]);
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdTick(long j4) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SplashActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/splash/SplashActivity$b", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            f0.p(data, "data");
            try {
                l lVar = l.f18624a;
                String t3 = lVar.t(data, "schName");
                LoginUser.getLoginUser().setSysType(lVar.k(data, "sysType"));
                a.b bVar = com.bxkj.base.v2.data.a.b;
                bVar.a().Q(lVar.k(data, "isOpenLive"));
                bVar.a().R(lVar.l(data, "isOpenSQZS", 1));
                bVar.a().P(lVar.l(data, "isOpenGGLBT", 1));
                if (LoginUser.getLoginUser().getSysType() == 2) {
                    bVar.a().V(t3);
                    bVar.a().U(lVar.t(data, "schoolCode"));
                    bVar.a().W(lVar.u(data, "lan_url", "http://a.sxstczx.com/"));
                    com.bxkj.student.v2.retrofit.b.f23700a.a();
                    bVar.a().I(lVar.t(data, "urlSite"));
                } else {
                    LoginUser.getLoginUser().setSchoolName(t3);
                    LoginUser.getLoginUser().setIsOpenKeep(lVar.k(data, "isOpenKeep"));
                    LoginUser.getLoginUser().setIsOpenEncry(lVar.t(data, "isOpenEncry"));
                    LoginUser.getLoginUser().setAppId(lVar.t(data, "openId"));
                    LoginUser.getLoginUser().setServerUrl(lVar.t(data, "school_url"));
                    Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
                }
            } catch (Exception e4) {
                j.c(e4.getMessage());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SplashActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/bxkj/student/splash/SplashActivity$c", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "Lkotlin/f1;", "onTick", "onFinish", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends CountDownTimer {
        c(long j4) {
            super(j4, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SplashActivity.this.R();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j4) {
            SplashActivity.this.M().tvTime.setText(f0.C("\u8df3\u8fc7", Long.valueOf(j4 / 1000)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SplashActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends Lambda implements l1.a<f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f23089a = new d();

        d() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m60invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m60invoke() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SplashActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "dept_id", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e extends Lambda implements l1.l<Integer, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f23090a = new e();

        e() {
            super(1);
        }

        public final void a(int i4) {
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(Integer num) {
            a(num.intValue());
            return f1.f55527a;
        }
    }

    private final void N() {
        j.g("BeiZisDemo->\u5f00\u59cb----------------", new Object[0]);
        SplashAd splashAd = new SplashAd(this, null, "105558", new a(), this.f23086m);
        this.f23085l = splashAd;
        splashAd.loadAd((int) n.d(this), (int) (n.b(this) - 100));
    }

    private final void O() {
        Http.with(C()).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((q.f) Http.getApiService(q.f.class)).k(LoginUser.getLoginUser().getSchoolId())).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(SplashActivity this$0, View view) {
        f0.p(this$0, "this$0");
        CountDownTimer countDownTimer = this$0.f23082i;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.onFinish();
    }

    private final void Q() {
        O();
        if ((LoginUser.getLoginUser().getSysType() == 2 ? this : null) == null) {
            return;
        }
        x().v(d.f23089a);
        if (com.bxkj.base.v2.data.a.b.a().y()) {
            x().u(e.f23090a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        if (this.f23084k) {
            if (!this.f23083j) {
                if (LoginUser.getLoginUser().getSysType() == 2) {
                    startActivity(new Intent(C(), MainActivity.class));
                } else {
                    startActivity(new Intent(C(), com.bxkj.student.MainActivity.class));
                }
            }
            finish();
            return;
        }
        this.f23084k = true;
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        if (!isTaskRoot()) {
            String action = getIntent().getAction();
            if (getIntent().hasCategory("android.intent.category.LAUNCHER") && f0.g("android.intent.action.MAIN", action)) {
                finish();
            }
        }
        if (getIntent().hasExtra("onlyOpenAd")) {
            this.f23083j = getIntent().getBooleanExtra("onlyOpenAd", false);
        }
        if (!this.f23083j) {
            cn.bluemobi.dylan.base.utils.a.n().i(com.bxkj.student.MainActivity.class);
            cn.bluemobi.dylan.base.utils.a.n().i(LoginActivity.class);
            cn.bluemobi.dylan.base.utils.a.n().i(H5AppActivity.class);
            cn.bluemobi.dylan.base.utils.a.n().i(MainActivity.class);
            cn.bluemobi.dylan.base.utils.a.n().i(com.bxkj.student.v2.ui.LoginActivity.class);
        }
        if (!LoginUser.getLoginUser().isAgreement()) {
            startActivity(new Intent(C(), OpenPrivacyAgreementActivity.class));
            finish();
        } else if (z.g(C()) != LoginUser.getLoginUser().getLastVersionCode()) {
            startActivity(new Intent(C(), WelcomeActivity.class));
            finish();
        } else if (u.b0(LoginUser.getLoginUser().getSchoolId())) {
            startActivity(new Intent(C(), SelectSchoolV2Activity.class));
            finish();
        } else {
            try {
                Q();
                c cVar = new c(5000L);
                this.f23082i = cVar;
                cVar.cancel();
                CountDownTimer countDownTimer = this.f23082i;
                if (countDownTimer != null) {
                    countDownTimer.start();
                }
                M().tvTime.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SplashActivity.P(SplashActivity.this, view);
                    }
                });
                if (com.bxkj.base.v2.data.a.b.a().A() == 1) {
                    N();
                } else {
                    j.d("\u672a\u5f00\u542f\u5e7f\u544a", new Object[0]);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        CountDownTimer countDownTimer = this.f23082i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        SplashAd splashAd = this.f23085l;
        if (splashAd != null) {
            splashAd.cancel(this);
        }
        super.onBackPressed();
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        StubApp.mark();
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CountDownTimer countDownTimer = this.f23082i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        SplashAd splashAd = this.f23085l;
        if (splashAd != null) {
            splashAd.cancel(this);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        j.d(f0.C("BeiZisDemo->onPause canJumpImmediately== ", Boolean.valueOf(this.f23084k)), new Object[0]);
        this.f23084k = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        j.d(f0.C("BeiZisDemo->onResume canJumpImmediately== ", Boolean.valueOf(this.f23084k)), new Object[0]);
        if (this.f23084k) {
            R();
        }
        this.f23084k = true;
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
