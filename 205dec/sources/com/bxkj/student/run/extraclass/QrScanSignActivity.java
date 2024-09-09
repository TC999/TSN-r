package com.bxkj.student.run.extraclass;

import android.os.Handler;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.ext.g;
import com.bxkj.student.common.utils.SoundUtils;
import com.bxkj.student.databinding.AcQrcodeScanBinding;
import com.bxkj.student.run.extraclass.QrScanSignActivity;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.orhanobut.logger.j;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: QrScanSignActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/bxkj/student/run/extraclass/QrScanSignActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcQrcodeScanBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "N", "O", "E", "p", "onResume", "onStop", "onDestroy", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class QrScanSignActivity extends BaseActivity<AcQrcodeScanBinding, BaseViewModel> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: QrScanSignActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/student/run/extraclass/QrScanSignActivity$a", "Lcn/bingoogolapple/qrcode/core/QRCodeView$f;", "", "result", "Lkotlin/f1;", "H", "", "isDark", "b", "D", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements QRCodeView.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SoundUtils f23010a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ QrScanSignActivity f23011b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: QrScanSignActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J$\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/bxkj/student/run/extraclass/QrScanSignActivity$a$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "msg", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.run.extraclass.QrScanSignActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class C0284a extends HttpCallBack {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ QrScanSignActivity f23012a;

            C0284a(QrScanSignActivity qrScanSignActivity) {
                this.f23012a = qrScanSignActivity;
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
                f0.p(data, "data");
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(@NotNull Map<String, ? extends Object> data, @NotNull String msg) {
                f0.p(data, "data");
                f0.p(msg, "msg");
                this.f23012a.O();
                ContextExtKt.q(this.f23012a, msg);
                this.f23012a.finish();
            }
        }

        a(SoundUtils soundUtils, QrScanSignActivity qrScanSignActivity) {
            this.f23010a = soundUtils;
            this.f23011b = qrScanSignActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(QrScanSignActivity this$0) {
            f0.p(this$0, "this$0");
            this$0.M().zbarview.C();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(QrScanSignActivity this$0) {
            f0.p(this$0, "this$0");
            this$0.M().zbarview.C();
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
        public void D() {
            ContextExtKt.p(this.f23011b, "\u6253\u5f00\u76f8\u673a\u51fa\u9519");
            j.e("\u6253\u5f00\u76f8\u673a\u51fa\u9519", new Object[0]);
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
        public void H(@Nullable String str) {
            boolean V2;
            List T4;
            j.d(f0.C("result:", str), new Object[0]);
            this.f23010a.g(2131755010);
            if (str == null) {
                return;
            }
            final QrScanSignActivity qrScanSignActivity = this.f23011b;
            String qRCodeKey = TsnSecret.f16433a.getQRCodeKey(qrScanSignActivity.C());
            if (qRCodeKey != null) {
                String substring = qRCodeKey.substring(0, 16);
                f0.o(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                String a4 = com.bxkj.base.util.a.a(str, substring);
                if (a4 != null) {
                    V2 = x.V2(a4, "#", false, 2, null);
                    if (V2) {
                        T4 = x.T4(a4, new String[]{"#"}, false, 0, 6, null);
                        String str2 = (String) T4.get(0);
                        if (System.currentTimeMillis() - Long.parseLong((String) T4.get(1)) > PolicyConfig.mServerBusyRetryBaseInternal) {
                            ContextExtKt.p(qrScanSignActivity, "\u4e8c\u7ef4\u7801\u5df2\u8fc7\u671f");
                            new Handler().postDelayed(new Runnable() { // from class: com.bxkj.student.run.extraclass.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    QrScanSignActivity.a.d(QrScanSignActivity.this);
                                }
                            }, 1000L);
                            return;
                        }
                        Http.with(qrScanSignActivity.C()).hideSuccessMessage().setObservable(((w.a) Http.getApiService(w.a.class)).l(str2, LoginUser.getLoginUser().getAccount(), qrScanSignActivity.getIntent().getStringExtra("signType"))).setDataListener(new C0284a(qrScanSignActivity));
                        return;
                    }
                }
                new Handler().postDelayed(new Runnable() { // from class: com.bxkj.student.run.extraclass.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        QrScanSignActivity.a.e(QrScanSignActivity.this);
                    }
                }, 1000L);
                ContextExtKt.p(qrScanSignActivity, "\u65e0\u6548\u7801");
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
        public void b(boolean z3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: QrScanSignActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l1.a<f1> {
        b() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m59invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m59invoke() {
            QrScanSignActivity.this.M().zbarview.z();
            QrScanSignActivity.this.M().zbarview.x();
            QrScanSignActivity.this.M().zbarview.C();
        }
    }

    private final void N() {
        g.c(this, "\u626b\u7801", new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        M().zbarview.E();
        M().zbarview.G();
        M().zbarview.F();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setQrScanActivity(this);
        SoundUtils soundUtils = new SoundUtils(C());
        soundUtils.m(2131755010);
        M().zbarview.setDelegate(new a(soundUtils, this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        M().zbarview.E();
        M().zbarview.G();
        M().zbarview.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        O();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
