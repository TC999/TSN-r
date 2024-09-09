package com.bxkj.student.v2.ui;

import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.databinding.V2AcLoginBinding;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.bxkj.student.v2.common.utils.ThirdLogin;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.bxkj.student.v2.vm.LoginViewModel;
import com.umeng.socialize.UMShareAPI;
import d2.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: LoginActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0004H\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/bxkj/student/v2/ui/LoginActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2AcLoginBinding;", "Lcom/bxkj/student/v2/vm/LoginViewModel;", "Lkotlin/f1;", "P", "E", "p", "Q", "S", "R", "U", "N", "O", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "onDestroy", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class LoginActivity extends BaseActivity<V2AcLoginBinding, LoginViewModel> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: LoginActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/bxkj/student/v2/ui/LoginActivity$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "widget", "Lkotlin/f1;", "onClick", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            f0.p(widget, "widget");
            iOSOneButtonDialog centerCustomView = new iOSOneButtonDialog(LoginActivity.this.C()).setTitle("\u9690\u79c1\u653f\u7b56").setCenterCustomView(2131427408);
            ((SmartWebView) centerCustomView.findViewById(2131232715)).j("https://www.boxkj.com/resources/user_agreement.html");
            centerCustomView.show();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: LoginActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/bxkj/student/v2/ui/LoginActivity$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "widget", "Lkotlin/f1;", "onClick", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            f0.p(widget, "widget");
            iOSOneButtonDialog centerCustomView = new iOSOneButtonDialog(LoginActivity.this.C()).setTitle("\u7528\u6237\u534f\u8bae").setCenterCustomView(2131427408);
            ((SmartWebView) centerCustomView.findViewById(2131232715)).j("https://www.boxkj.com/resources/user_agreement_info.html");
            centerCustomView.show();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: LoginActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class c extends Lambda implements l<Map<String, ? extends String>, f1> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* compiled from: LoginActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class a extends Lambda implements d2.a<f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LoginActivity f23712a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f23713b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LoginActivity loginActivity, String str) {
                super(0);
                this.f23712a = loginActivity;
                this.f23713b = str;
            }

            @Override // d2.a
            public /* bridge */ /* synthetic */ f1 invoke() {
                invoke2();
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.f23712a.x().C(this.f23713b, "qqlogin ");
            }
        }

        c() {
            super(1);
        }

        public final void a(@NotNull Map<String, String> it) {
            f0.p(it, "it");
            String t3 = m.a.t(it, "uid");
            LoginActivity.this.x().D(t3, "2", new a(LoginActivity.this, t3));
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Map<String, ? extends String> map) {
            a(map);
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: LoginActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class d extends Lambda implements l<Map<String, ? extends String>, f1> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* compiled from: LoginActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class a extends Lambda implements d2.a<f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LoginActivity f23715a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f23716b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LoginActivity loginActivity, String str) {
                super(0);
                this.f23715a = loginActivity;
                this.f23716b = str;
            }

            @Override // d2.a
            public /* bridge */ /* synthetic */ f1 invoke() {
                invoke2();
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.f23715a.x().C(this.f23716b, "wechatlogin");
            }
        }

        d() {
            super(1);
        }

        public final void a(@NotNull Map<String, String> it) {
            f0.p(it, "it");
            String t3 = m.a.t(it, "uid");
            LoginActivity.this.x().D(t3, "1", new a(LoginActivity.this, t3));
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Map<String, ? extends String> map) {
            a(map);
            return f1.f55527a;
        }
    }

    private final void P() {
        SpannableString spannableString = new SpannableString("\u9605\u8bfb\u5e76\u63a5\u53d7\u300a\u7528\u6237\u9690\u79c1\u653f\u7b56\u300b\u548c\u300a\u8f6f\u4ef6\u8bb8\u53ef\u534f\u8bae\u300b");
        spannableString.setSpan(new a(), 5, 13, 33);
        spannableString.setSpan(new b(), 14, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(-16776961), 5, 13, 33);
        spannableString.setSpan(new ForegroundColorSpan(-16776961), 14, spannableString.length(), 33);
        M().tvAgree.setHighlightColor(0);
        M().tvAgree.setMovementMethod(LinkMovementMethod.getInstance());
        M().tvAgree.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(LoginActivity this$0, Map map) {
        f0.p(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.C(), MainActivity.class));
        this$0.finish();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        bVar.a().Y(false);
        M().setLoginViewModel(x());
        M().setActivity(this);
        M().setLoginInUser(bVar.a());
        x().z().set(bVar.a().C());
        bVar.a().Y(false);
        P();
    }

    public final void N() {
        startActivity(new Intent(C(), H5AppActivity.class).putExtra("title", "\u5fd8\u8bb0\u5bc6\u7801").putExtra("url", com.bxkj.student.v2.retrofit.a.f23692a.a()));
    }

    public final void O() {
        startActivity(new Intent(C(), H5AppActivity.class).putExtra("title", "\u5e2e\u52a9\u4e2d\u5fc3").putExtra("url", com.bxkj.student.v2.retrofit.a.f23692a.b()));
    }

    public final void Q() {
        String str = x().z().get();
        if (str == null) {
            str = "";
        }
        String str2 = x().y().get();
        String str3 = str2 != null ? str2 : "";
        if (str.length() == 0) {
            new iOSOneButtonDialog(C()).setMessage("\u8bf7\u8f93\u5165\u8d26\u53f7").show();
            return;
        }
        if (str3.length() == 0) {
            new iOSOneButtonDialog(C()).setMessage("\u8bf7\u8f93\u5165\u5bc6\u7801").show();
        } else if (!M().cbAgree.isChecked()) {
            new iOSOneButtonDialog(C()).setMessage("\u8bf7\u9605\u8bfb\u5e76\u540c\u610f\u300a\u7528\u6237\u9690\u79c1\u653f\u7b56\u300b\u548c\u300a\u8f6f\u4ef6\u8bb8\u53ef\u534f\u8bae\u300b").show();
        } else {
            x().A();
        }
    }

    public final void R() {
        if (M().cbAgree.isChecked()) {
            new ThirdLogin(w()).b(new c());
        } else {
            new iOSOneButtonDialog(C()).setMessage("\u8bf7\u9605\u8bfb\u5e76\u540c\u610f\u300a\u7528\u6237\u9690\u79c1\u653f\u7b56\u300b\u548c\u300a\u8f6f\u4ef6\u8bb8\u53ef\u534f\u8bae\u300b").show();
        }
    }

    public final void S() {
        if (M().cbAgree.isChecked()) {
            new ThirdLogin(w()).c(new d());
        } else {
            new iOSOneButtonDialog(C()).setMessage("\u8bf7\u9605\u8bfb\u5e76\u540c\u610f\u300a\u7528\u6237\u9690\u79c1\u653f\u7b56\u300b\u548c\u300a\u8f6f\u4ef6\u8bb8\u53ef\u534f\u8bae\u300b").show();
        }
    }

    public final void U() {
        startActivity(new Intent(C(), SelectSchoolV2Activity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        UMShareAPI.get(this).onActivityResult(i4, i5, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (M().tvAgree.getText() instanceof SpannableString) {
            CharSequence text = M().tvAgree.getText();
            if (text != null) {
                SpannableString spannableString = (SpannableString) text;
                int i4 = 0;
                ClickableSpan[] spans = (ClickableSpan[]) spannableString.getSpans(0, spannableString.length(), ClickableSpan.class);
                f0.o(spans, "spans");
                int length = spans.length;
                while (i4 < length) {
                    ClickableSpan clickableSpan = spans[i4];
                    i4++;
                    spannableString.removeSpan(clickableSpan);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.text.SpannableString");
            }
        }
        M().tvAgree.setText((CharSequence) null);
        M().tvAgree.setMovementMethod(null);
        super.onDestroy();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        x().w().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginActivity.T(LoginActivity.this, (Map) obj);
            }
        });
    }
}
