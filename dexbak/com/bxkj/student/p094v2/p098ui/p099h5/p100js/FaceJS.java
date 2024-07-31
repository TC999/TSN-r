package com.bxkj.student.p094v2.p098ui.p099h5.p100js;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.p094v2.p098ui.face.FaceCheckV2Activity;
import com.bxkj.student.p094v2.p098ui.face.FaceCollectActivity;
import com.bxkj.student.p094v2.retrofit.RetrofitClient;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p618m.StartActivityForResult;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007R\"\u0010\u000f\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/h5/js/f;", "Lcom/bxkj/student/v2/ui/h5/js/a;", "", BidResponsed.KEY_TOKEN, "schoolCode", "Lkotlin/f1;", "addUserFace", "faceTest", "Landroidx/fragment/app/FragmentActivity;", "h", "Landroidx/fragment/app/FragmentActivity;", "c", "()Landroidx/fragment/app/FragmentActivity;", "e", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroid/webkit/WebView;", "mWebView", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/webkit/WebView;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.h5.js.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FaceJS extends BlueToothJS {
    @NotNull

    /* renamed from: h */
    private FragmentActivity f20480h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FaceJS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.f$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5667a extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: a */
        final /* synthetic */ String f20481a;

        /* renamed from: b */
        final /* synthetic */ String f20482b;

        /* renamed from: c */
        final /* synthetic */ FaceJS f20483c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5667a(String str, String str2, FaceJS faceJS) {
            super(0);
            this.f20481a = str;
            this.f20482b = str2;
            this.f20483c = faceJS;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
            c3984b.m43634a().m43678M(true);
            String str = this.f20481a;
            if (str != null) {
                c3984b.m43634a().m43688C(str);
            }
            String str2 = this.f20482b;
            if (str2 != null) {
                c3984b.m43634a().m43670U(str2);
            }
            RetrofitClient.f20337a.m38889a();
            this.f20483c.mo38718c().startActivity(new Intent(this.f20483c.mo38718c(), FaceCollectActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FaceJS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.f$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5668b extends Lambda implements InterfaceC15269a<Unit> {

        /* compiled from: FaceJS.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/h5/js/f$b$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.h5.js.f$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5669a implements StartActivityForResult.InterfaceC15293a {

            /* renamed from: a */
            final /* synthetic */ FaceJS f20485a;

            C5669a(FaceJS faceJS) {
                this.f20485a = faceJS;
            }

            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public void mo3459a(int i, @Nullable Intent intent) {
                if (intent == null) {
                    return;
                }
                if (!(i == -1)) {
                    intent = null;
                }
                if (intent == null) {
                    return;
                }
                Intent intent2 = intent.hasExtra("code") ? intent : null;
                if (intent2 == null) {
                    return;
                }
                FaceJS faceJS = this.f20485a;
                int intExtra = intent2.getIntExtra("code", 1);
                faceJS.mo38732d().loadUrl("javascript:faceTestResult('" + intExtra + "')");
            }
        }

        C5668b() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StartActivityForResult startActivityForResult = new StartActivityForResult(FaceJS.this.mo38718c());
            Intent intent = new Intent().setClass(FaceJS.this.mo38718c(), FaceCheckV2Activity.class);
            C14342f0.m8185o(intent, "Intent().setClass(mActiv…ckV2Activity::class.java)");
            startActivityForResult.startActivityForResult(intent).m3460c(new C5669a(FaceJS.this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceJS(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        super(mActivity, mWebView);
        C14342f0.m8184p(mActivity, "mActivity");
        C14342f0.m8184p(mWebView, "mWebView");
        this.f20480h = mActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public static final void m38714q(FaceJS this$0, String str, String str2) {
        C14342f0.m8184p(this$0, "this$0");
        PermissionExt.m43841c(this$0.mo38718c(), "人脸采集", new C5667a(str, str2, this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public static final void m38713r(FaceJS this$0) {
        C14342f0.m8184p(this$0, "this$0");
        PermissionExt.m43841c(this$0.mo38718c(), "人脸验证", new C5668b());
    }

    @JavascriptInterface
    public final void addUserFace(@Nullable final String str, @Nullable final String str2) {
        mo38718c().runOnUiThread(new Runnable() { // from class: com.bxkj.student.v2.ui.h5.js.e
            @Override // java.lang.Runnable
            public final void run() {
                FaceJS.m38714q(FaceJS.this, str, str2);
            }
        });
    }

    @Override // com.bxkj.student.p094v2.p098ui.p099h5.p100js.BlueToothJS, com.bxkj.base.p085v2.p086h5.GPSJS
    @NotNull
    /* renamed from: c */
    public FragmentActivity mo38718c() {
        return this.f20480h;
    }

    @Override // com.bxkj.student.p094v2.p098ui.p099h5.p100js.BlueToothJS, com.bxkj.base.p085v2.p086h5.GPSJS
    /* renamed from: e */
    public void mo38717e(@NotNull FragmentActivity fragmentActivity) {
        C14342f0.m8184p(fragmentActivity, "<set-?>");
        this.f20480h = fragmentActivity;
    }

    @JavascriptInterface
    public final void faceTest(@Nullable String str, @Nullable String str2) {
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        c3984b.m43634a().m43678M(true);
        if (str != null) {
            c3984b.m43634a().m43688C(str);
        }
        if (str2 != null) {
            c3984b.m43634a().m43670U(str2);
        }
        RetrofitClient.f20337a.m38889a();
        mo38718c().runOnUiThread(new Runnable() { // from class: com.bxkj.student.v2.ui.h5.js.d
            @Override // java.lang.Runnable
            public final void run() {
                FaceJS.m38713r(FaceJS.this);
            }
        });
    }
}
