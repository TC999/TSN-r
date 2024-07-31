package com.bxkj.student.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.beizi.fusion.AdListener;
import com.beizi.fusion.SplashAd;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.SystemUtils;
import com.bxkj.student.common.utils.UiUtil;
import com.bxkj.student.databinding.AcSplashBinding;
import com.bxkj.student.p094v2.p098ui.MainActivity;
import com.bxkj.student.p094v2.p098ui.p099h5.H5AppActivity;
import com.bxkj.student.p094v2.p103vm.splash.SplashVM;
import com.bxkj.student.p094v2.retrofit.RetrofitClient;
import com.bxkj.student.personal.login.LoginActivity;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p635q.MainApiService;

/* compiled from: SplashActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, m12616d2 = {"Lcom/bxkj/student/splash/SplashActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcSplashBinding;", "Lcom/bxkj/student/v2/vm/splash/SplashVM;", "Lkotlin/f1;", "R", "Q", "O", "N", ExifInterface.LONGITUDE_EAST, "p", "onResume", "onPause", "onDestroy", "onBackPressed", "Landroid/os/CountDownTimer;", "i", "Landroid/os/CountDownTimer;", "countDownTimer", "", "j", "Z", "onlyOpenAd", "k", "canJumpImmediately", "Lcom/beizi/fusion/SplashAd;", C7304t.f25048d, "Lcom/beizi/fusion/SplashAd;", "splashAd", "", "m", "I", "mTotalTime", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SplashActivity extends BaseActivity<AcSplashBinding, SplashVM> {
    @Nullable

    /* renamed from: i */
    private CountDownTimer f19852i;

    /* renamed from: j */
    private boolean f19853j;

    /* renamed from: k */
    private boolean f19854k;
    @Nullable

    /* renamed from: l */
    private SplashAd f19855l;

    /* renamed from: m */
    private final int f19856m = 5000;

    /* compiled from: SplashActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\r"}, m12616d2 = {"com/bxkj/student/splash/SplashActivity$a", "Lcom/beizi/fusion/AdListener;", "Lkotlin/f1;", "onAdLoaded", "onAdShown", "", "errorCode", "onAdFailedToLoad", "onAdClosed", "", "millisUnitFinished", "onAdTick", "onAdClicked", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.splash.SplashActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5459a implements AdListener {
        C5459a() {
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdClicked() {
            C11792j.m20466g("BeiZisDemo->onAdClick", new Object[0]);
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdClosed() {
            C11792j.m20466g("BeiZisDemo->onAdClosed", new Object[0]);
            SplashActivity.this.m39387R();
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdFailedToLoad(int i) {
            C11792j.m20466g(C14342f0.m8216C("BeiZisDemo->onAdFailedToLoad:", Integer.valueOf(i)), new Object[0]);
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdLoaded() {
            C11792j.m20466g("BeiZisDemo->onAdLoaded", new Object[0]);
            SplashAd splashAd = SplashActivity.this.f19855l;
            if (splashAd != null) {
                splashAd.show(SplashActivity.this.mo43920M().adsFl);
            }
            CountDownTimer countDownTimer = SplashActivity.this.f19852i;
            if (countDownTimer == null) {
                return;
            }
            countDownTimer.cancel();
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdShown() {
            CountDownTimer countDownTimer = SplashActivity.this.f19852i;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            C11792j.m20466g("BeiZisDemo->onAdShown", new Object[0]);
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdTick(long j) {
        }
    }

    /* compiled from: SplashActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/splash/SplashActivity$b", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.splash.SplashActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5460b extends HttpCallBack {
        C5460b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            C14342f0.m8184p(data, "data");
            try {
                JsonGet jsonGet = JsonGet.f15134a;
                String m43760t = jsonGet.m43760t(data, "schName");
                LoginUser.getLoginUser().setSysType(jsonGet.m43769k(data, "sysType"));
                LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
                c3984b.m43634a().m43674Q(jsonGet.m43769k(data, "isOpenLive"));
                c3984b.m43634a().m43673R(jsonGet.m43768l(data, "isOpenSQZS", 1));
                c3984b.m43634a().m43675P(jsonGet.m43768l(data, "isOpenGGLBT", 1));
                if (LoginUser.getLoginUser().getSysType() == 2) {
                    c3984b.m43634a().m43669V(m43760t);
                    c3984b.m43634a().m43670U(jsonGet.m43760t(data, "schoolCode"));
                    c3984b.m43634a().m43668W(jsonGet.m43759u(data, "lan_url", "http://a.sxstczx.com/"));
                    RetrofitClient.f20337a.m38889a();
                    c3984b.m43634a().m43682I(jsonGet.m43760t(data, "urlSite"));
                } else {
                    LoginUser.getLoginUser().setSchoolName(m43760t);
                    LoginUser.getLoginUser().setIsOpenKeep(jsonGet.m43769k(data, "isOpenKeep"));
                    LoginUser.getLoginUser().setIsOpenEncry(jsonGet.m43760t(data, "isOpenEncry"));
                    LoginUser.getLoginUser().setAppId(jsonGet.m43760t(data, "openId"));
                    LoginUser.getLoginUser().setServerUrl(jsonGet.m43760t(data, "school_url"));
                    Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
                }
            } catch (Exception e) {
                C11792j.m20470c(e.getMessage());
            }
        }
    }

    /* compiled from: SplashActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, m12616d2 = {"com/bxkj/student/splash/SplashActivity$c", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "Lkotlin/f1;", "onTick", "onFinish", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.splash.SplashActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class CountDownTimerC5461c extends CountDownTimer {
        CountDownTimerC5461c(long j) {
            super(j, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SplashActivity.this.m39387R();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            SplashActivity.this.mo43920M().tvTime.setText(C14342f0.m8216C("跳过", Long.valueOf(j / 1000)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.splash.SplashActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5462d extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: a */
        public static final C5462d f19859a = new C5462d();

        C5462d() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"", "dept_id", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.splash.SplashActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5463e extends Lambda implements InterfaceC15280l<Integer, Unit> {

        /* renamed from: a */
        public static final C5463e f19860a = new C5463e();

        C5463e() {
            super(1);
        }

        /* renamed from: a */
        public final void m39382a(int i) {
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            m39382a(num.intValue());
            return Unit.f41048a;
        }
    }

    /* renamed from: N */
    private final void m39391N() {
        C11792j.m20466g("BeiZisDemo->开始----------------", new Object[0]);
        SplashAd splashAd = new SplashAd(this, null, "105558", new C5459a(), this.f19856m);
        this.f19855l = splashAd;
        splashAd.loadAd((int) UiUtil.m42793d(this), (int) (UiUtil.m42795b(this) - 100));
    }

    /* renamed from: O */
    private final void m39390O() {
        Http.with(mo43926C()).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2266k(LoginUser.getLoginUser().getSchoolId())).setDataListener(new C5460b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public static final void m39389P(SplashActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        CountDownTimer countDownTimer = this$0.f19852i;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.onFinish();
    }

    /* renamed from: Q */
    private final void m39388Q() {
        m39390O();
        if ((LoginUser.getLoginUser().getSysType() == 2 ? this : null) == null) {
            return;
        }
        mo43911x().m38091v(C5462d.f19859a);
        if (LoggedInUser.f15182b.m43634a().m43637y()) {
            mo43911x().m38092u(C5463e.f19860a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public final void m39387R() {
        if (this.f19854k) {
            if (!this.f19853j) {
                if (LoginUser.getLoginUser().getSysType() == 2) {
                    startActivity(new Intent(mo43926C(), MainActivity.class));
                } else {
                    startActivity(new Intent(mo43926C(), com.bxkj.student.MainActivity.class));
                }
            }
            finish();
            return;
        }
        this.f19854k = true;
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        if (!isTaskRoot()) {
            String action = getIntent().getAction();
            if (getIntent().hasCategory("android.intent.category.LAUNCHER") && C14342f0.m8193g("android.intent.action.MAIN", action)) {
                finish();
            }
        }
        if (getIntent().hasExtra("onlyOpenAd")) {
            this.f19853j = getIntent().getBooleanExtra("onlyOpenAd", false);
        }
        if (!this.f19853j) {
            AppManager.m57776n().m57781i(com.bxkj.student.MainActivity.class);
            AppManager.m57776n().m57781i(LoginActivity.class);
            AppManager.m57776n().m57781i(H5AppActivity.class);
            AppManager.m57776n().m57781i(MainActivity.class);
            AppManager.m57776n().m57781i(com.bxkj.student.p094v2.p098ui.LoginActivity.class);
        }
        if (!LoginUser.getLoginUser().isAgreement()) {
            startActivity(new Intent(mo43926C(), OpenPrivacyAgreementActivity.class));
            finish();
        } else if (SystemUtils.m43999g(mo43926C()) != LoginUser.getLoginUser().getLastVersionCode()) {
            startActivity(new Intent(mo43926C(), WelcomeActivity.class));
            finish();
        } else if (Tools.m57617b0(LoginUser.getLoginUser().getSchoolId())) {
            startActivity(new Intent(mo43926C(), SelectSchoolV2Activity.class));
            finish();
        } else {
            try {
                m39388Q();
                CountDownTimerC5461c countDownTimerC5461c = new CountDownTimerC5461c(5000L);
                this.f19852i = countDownTimerC5461c;
                countDownTimerC5461c.cancel();
                CountDownTimer countDownTimer = this.f19852i;
                if (countDownTimer != null) {
                    countDownTimer.start();
                }
                mo43920M().tvTime.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.splash.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SplashActivity.m39389P(SplashActivity.this, view);
                    }
                });
                if (LoggedInUser.f15182b.m43634a().m43690A() == 1) {
                    m39391N();
                } else {
                    C11792j.m20469d("未开启广告", new Object[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        CountDownTimer countDownTimer = this.f19852i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        SplashAd splashAd = this.f19855l;
        if (splashAd != null) {
            splashAd.cancel(this);
        }
        super.onBackPressed();
    }

    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        StubApp.mark();
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CountDownTimer countDownTimer = this.f19852i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        SplashAd splashAd = this.f19855l;
        if (splashAd != null) {
            splashAd.cancel(this);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        C11792j.m20469d(C14342f0.m8216C("BeiZisDemo->onPause canJumpImmediately== ", Boolean.valueOf(this.f19854k)), new Object[0]);
        this.f19854k = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C11792j.m20469d(C14342f0.m8216C("BeiZisDemo->onResume canJumpImmediately== ", Boolean.valueOf(this.f19854k)), new Object[0]);
        if (this.f19854k) {
            m39387R();
        }
        this.f19854k = true;
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
