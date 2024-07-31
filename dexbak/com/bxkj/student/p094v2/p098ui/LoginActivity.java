package com.bxkj.student.p094v2.p098ui;

import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.databinding.V2AcLoginBinding;
import com.bxkj.student.p094v2.common.utils.ThirdLogin;
import com.bxkj.student.p094v2.p098ui.p099h5.H5AppActivity;
import com.bxkj.student.p094v2.p103vm.LoginViewModel;
import com.bxkj.student.p094v2.retrofit.ApiService;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.umeng.socialize.UMShareAPI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: LoginActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0004H\u0014¨\u0006\u0017"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/LoginActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2AcLoginBinding;", "Lcom/bxkj/student/v2/vm/LoginViewModel;", "Lkotlin/f1;", "P", ExifInterface.LONGITUDE_EAST, "p", "Q", ExifInterface.LATITUDE_SOUTH, "R", "U", "N", "O", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "onDestroy", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.LoginActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class LoginActivity extends BaseActivity<V2AcLoginBinding, LoginViewModel> {

    /* compiled from: LoginActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, m12616d2 = {"com/bxkj/student/v2/ui/LoginActivity$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "widget", "Lkotlin/f1;", "onClick", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.LoginActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5593a extends ClickableSpan {
        C5593a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            C14342f0.m8184p(widget, "widget");
            iOSOneButtonDialog centerCustomView = new iOSOneButtonDialog(LoginActivity.this.mo43926C()).setTitle("隐私政策").setCenterCustomView(2131427408);
            ((SmartWebView) centerCustomView.findViewById(2131232631)).m57493j("https://www.boxkj.com/resources/user_agreement.html");
            centerCustomView.show();
        }
    }

    /* compiled from: LoginActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, m12616d2 = {"com/bxkj/student/v2/ui/LoginActivity$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "widget", "Lkotlin/f1;", "onClick", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.LoginActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5594b extends ClickableSpan {
        C5594b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            C14342f0.m8184p(widget, "widget");
            iOSOneButtonDialog centerCustomView = new iOSOneButtonDialog(LoginActivity.this.mo43926C()).setTitle("用户协议").setCenterCustomView(2131427408);
            ((SmartWebView) centerCustomView.findViewById(2131232631)).m57493j("https://www.boxkj.com/resources/user_agreement_info.html");
            centerCustomView.show();
        }
    }

    /* compiled from: LoginActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.LoginActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5595c extends Lambda implements InterfaceC15280l<Map<String, ? extends String>, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LoginActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.LoginActivity$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5596a extends Lambda implements InterfaceC15269a<Unit> {

            /* renamed from: a */
            final /* synthetic */ LoginActivity f20344a;

            /* renamed from: b */
            final /* synthetic */ String f20345b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5596a(LoginActivity loginActivity, String str) {
                super(0);
                this.f20344a = loginActivity;
                this.f20345b = str;
            }

            @Override // p617l1.InterfaceC15269a
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.f20344a.mo43911x().m38202C(this.f20345b, "qqlogin ");
            }
        }

        C5595c() {
            super(1);
        }

        /* renamed from: a */
        public final void m38877a(@NotNull Map<String, String> it) {
            C14342f0.m8184p(it, "it");
            String m43760t = JsonGet.f15134a.m43760t(it, "uid");
            LoginActivity.this.mo43911x().m38201D(m43760t, "2", new C5596a(LoginActivity.this, m43760t));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
            m38877a(map);
            return Unit.f41048a;
        }
    }

    /* compiled from: LoginActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, m12616d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.LoginActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5597d extends Lambda implements InterfaceC15280l<Map<String, ? extends String>, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LoginActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.LoginActivity$d$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5598a extends Lambda implements InterfaceC15269a<Unit> {

            /* renamed from: a */
            final /* synthetic */ LoginActivity f20347a;

            /* renamed from: b */
            final /* synthetic */ String f20348b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5598a(LoginActivity loginActivity, String str) {
                super(0);
                this.f20347a = loginActivity;
                this.f20348b = str;
            }

            @Override // p617l1.InterfaceC15269a
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.f20347a.mo43911x().m38202C(this.f20348b, "wechatlogin");
            }
        }

        C5597d() {
            super(1);
        }

        /* renamed from: a */
        public final void m38876a(@NotNull Map<String, String> it) {
            C14342f0.m8184p(it, "it");
            String m43760t = JsonGet.f15134a.m43760t(it, "uid");
            LoginActivity.this.mo43911x().m38201D(m43760t, "1", new C5598a(LoginActivity.this, m43760t));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
            m38876a(map);
            return Unit.f41048a;
        }
    }

    /* renamed from: P */
    private final void m38884P() {
        SpannableString spannableString = new SpannableString("阅读并接受《用户隐私政策》和《软件许可协议》");
        spannableString.setSpan(new C5593a(), 5, 13, 33);
        spannableString.setSpan(new C5594b(), 14, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(-16776961), 5, 13, 33);
        spannableString.setSpan(new ForegroundColorSpan(-16776961), 14, spannableString.length(), 33);
        mo43920M().tvAgree.setHighlightColor(0);
        mo43920M().tvAgree.setMovementMethod(LinkMovementMethod.getInstance());
        mo43920M().tvAgree.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public static final void m38880T(LoginActivity this$0, Map map) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.mo43926C(), MainActivity.class));
        this$0.finish();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        c3984b.m43634a().m43678M(false);
        mo43920M().setLoginViewModel(mo43911x());
        mo43920M().setActivity(this);
        mo43920M().setLoginInUser(c3984b.m43634a());
        mo43911x().m38191z().set(c3984b.m43634a().m43641u());
        c3984b.m43634a().m43678M(false);
        m38884P();
    }

    /* renamed from: N */
    public final void m38886N() {
        startActivity(new Intent(mo43926C(), H5AppActivity.class).putExtra("title", "忘记密码").putExtra("url", ApiService.f20329a.m38904a()));
    }

    /* renamed from: O */
    public final void m38885O() {
        startActivity(new Intent(mo43926C(), H5AppActivity.class).putExtra("title", "帮助中心").putExtra("url", ApiService.f20329a.m38903b()));
    }

    /* renamed from: Q */
    public final void m38883Q() {
        String str = mo43911x().m38191z().get();
        if (str == null) {
            str = "";
        }
        String str2 = mo43911x().m38192y().get();
        String str3 = str2 != null ? str2 : "";
        if (str.length() == 0) {
            new iOSOneButtonDialog(mo43926C()).setMessage("请输入账号").show();
            return;
        }
        if (str3.length() == 0) {
            new iOSOneButtonDialog(mo43926C()).setMessage("请输入密码").show();
        } else if (!mo43920M().cbAgree.isChecked()) {
            new iOSOneButtonDialog(mo43926C()).setMessage("请阅读并同意《用户隐私政策》和《软件许可协议》").show();
        } else {
            mo43911x().m38204A();
        }
    }

    /* renamed from: R */
    public final void m38882R() {
        if (mo43920M().cbAgree.isChecked()) {
            new ThirdLogin(mo43912w()).m39153b(new C5595c());
        } else {
            new iOSOneButtonDialog(mo43926C()).setMessage("请阅读并同意《用户隐私政策》和《软件许可协议》").show();
        }
    }

    /* renamed from: S */
    public final void m38881S() {
        if (mo43920M().cbAgree.isChecked()) {
            new ThirdLogin(mo43912w()).m39152c(new C5597d());
        } else {
            new iOSOneButtonDialog(mo43926C()).setMessage("请阅读并同意《用户隐私政策》和《软件许可协议》").show();
        }
    }

    /* renamed from: U */
    public final void m38879U() {
        startActivity(new Intent(mo43926C(), SelectSchoolV2Activity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        UMShareAPI.get(this).onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (mo43920M().tvAgree.getText() instanceof SpannableString) {
            CharSequence text = mo43920M().tvAgree.getText();
            if (text != null) {
                SpannableString spannableString = (SpannableString) text;
                int i = 0;
                ClickableSpan[] spans = (ClickableSpan[]) spannableString.getSpans(0, spannableString.length(), ClickableSpan.class);
                C14342f0.m8185o(spans, "spans");
                int length = spans.length;
                while (i < length) {
                    ClickableSpan clickableSpan = spans[i];
                    i++;
                    spannableString.removeSpan(clickableSpan);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.text.SpannableString");
            }
        }
        mo43920M().tvAgree.setText((CharSequence) null);
        mo43920M().tvAgree.setMovementMethod(null);
        super.onDestroy();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43911x().m38194w().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginActivity.m38880T(LoginActivity.this, (Map) obj);
            }
        });
    }
}
