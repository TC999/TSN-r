package com.bxkj.student.run.extraclass;

import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.AESUtils;
import com.bxkj.student.common.utils.SoundUtils;
import com.bxkj.student.databinding.AcQrcodeScanBinding;
import com.bxkj.student.run.extraclass.QrScanSignActivity;
import com.orhanobut.logger.C11792j;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.C14579x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p653w.InterfaceC16236a;

/* compiled from: QrScanSignActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014¨\u0006\u000e"}, m12616d2 = {"Lcom/bxkj/student/run/extraclass/QrScanSignActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcQrcodeScanBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "N", "O", ExifInterface.LONGITUDE_EAST, "p", "onResume", "onStop", "onDestroy", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class QrScanSignActivity extends BaseActivity<AcQrcodeScanBinding, BaseViewModel> {

    /* compiled from: QrScanSignActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/student/run/extraclass/QrScanSignActivity$a", "Lcn/bingoogolapple/qrcode/core/QRCodeView$f;", "", CommonNetImpl.RESULT, "Lkotlin/f1;", "H", "", "isDark", "b", "D", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.extraclass.QrScanSignActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5433a implements QRCodeView.InterfaceC1099f {

        /* renamed from: a */
        final /* synthetic */ SoundUtils f19780a;

        /* renamed from: b */
        final /* synthetic */ QrScanSignActivity f19781b;

        /* compiled from: QrScanSignActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J$\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, m12616d2 = {"com/bxkj/student/run/extraclass/QrScanSignActivity$a$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "msg", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.run.extraclass.QrScanSignActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5434a extends HttpCallBack {

            /* renamed from: a */
            final /* synthetic */ QrScanSignActivity f19782a;

            C5434a(QrScanSignActivity qrScanSignActivity) {
                this.f19782a = qrScanSignActivity;
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
                C14342f0.m8184p(data, "data");
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(@NotNull Map<String, ? extends Object> data, @NotNull String msg) {
                C14342f0.m8184p(data, "data");
                C14342f0.m8184p(msg, "msg");
                this.f19782a.m39482O();
                ContextExt.m43847q(this.f19782a, msg);
                this.f19782a.finish();
            }
        }

        C5433a(SoundUtils soundUtils, QrScanSignActivity qrScanSignActivity) {
            this.f19780a = soundUtils;
            this.f19781b = qrScanSignActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static final void m39478d(QrScanSignActivity this$0) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.mo43920M().zbarview.m58028C();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public static final void m39477e(QrScanSignActivity this$0) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.mo43920M().zbarview.m58028C();
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
        /* renamed from: D */
        public void mo38629D() {
            ContextExt.m43848p(this.f19781b, "打开相机出错");
            C11792j.m20468e("打开相机出错", new Object[0]);
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
        /* renamed from: H */
        public void mo38628H(@Nullable String str) {
            boolean m6465V2;
            List m6471T4;
            C11792j.m20469d(C14342f0.m8216C("result:", str), new Object[0]);
            this.f19780a.m42883g(2131755010);
            if (str == null) {
                return;
            }
            final QrScanSignActivity qrScanSignActivity = this.f19781b;
            String qRCodeKey = TsnSecret.f13210a.getQRCodeKey(qrScanSignActivity.mo43926C());
            if (qRCodeKey != null) {
                String substring = qRCodeKey.substring(0, 16);
                C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String m44140a = AESUtils.m44140a(str, substring);
                if (m44140a != null) {
                    m6465V2 = C14579x.m6465V2(m44140a, "#", false, 2, null);
                    if (m6465V2) {
                        m6471T4 = C14579x.m6471T4(m44140a, new String[]{"#"}, false, 0, 6, null);
                        String str2 = (String) m6471T4.get(0);
                        if (System.currentTimeMillis() - Long.parseLong((String) m6471T4.get(1)) > 30000) {
                            ContextExt.m43848p(qrScanSignActivity, "二维码已过期");
                            new Handler().postDelayed(new Runnable() { // from class: com.bxkj.student.run.extraclass.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    QrScanSignActivity.C5433a.m39478d(QrScanSignActivity.this);
                                }
                            }, 1000L);
                            return;
                        }
                        Http.with(qrScanSignActivity.mo43926C()).hideSuccessMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m96l(str2, LoginUser.getLoginUser().getAccount(), qrScanSignActivity.getIntent().getStringExtra("signType"))).setDataListener(new C5434a(qrScanSignActivity));
                        return;
                    }
                }
                new Handler().postDelayed(new Runnable() { // from class: com.bxkj.student.run.extraclass.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        QrScanSignActivity.C5433a.m39477e(QrScanSignActivity.this);
                    }
                }, 1000L);
                ContextExt.m43848p(qrScanSignActivity, "无效码");
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
        /* renamed from: b */
        public void mo38627b(boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QrScanSignActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.extraclass.QrScanSignActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5435b extends Lambda implements InterfaceC15269a<Unit> {
        C5435b() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            QrScanSignActivity.this.mo43920M().zbarview.m57999z();
            QrScanSignActivity.this.mo43920M().zbarview.m58001x();
            QrScanSignActivity.this.mo43920M().zbarview.m58028C();
        }
    }

    /* renamed from: N */
    private final void m39483N() {
        PermissionExt.m43841c(this, "扫码", new C5435b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public final void m39482O() {
        mo43920M().zbarview.m58026E();
        mo43920M().zbarview.m58024G();
        mo43920M().zbarview.m58025F();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setQrScanActivity(this);
        SoundUtils soundUtils = new SoundUtils(mo43926C());
        soundUtils.m42877m(2131755010);
        mo43920M().zbarview.setDelegate(new C5433a(soundUtils, this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        mo43920M().zbarview.m58026E();
        mo43920M().zbarview.m58024G();
        mo43920M().zbarview.m58007o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m39483N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        m39482O();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
