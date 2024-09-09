package com.bxkj.student.v2.ui.main;

import android.os.Build;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.student.databinding.V2MainTabH5FragmentBinding;
import com.bxkj.student.v2.ui.h5.js.JS;
import com.bxkj.student.v2.vm.MainViewModel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: H5Fragment.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/bxkj/student/v2/ui/main/H5Fragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabH5FragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", "e", "E", "p", "f", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class H5Fragment extends BaseFragment<V2MainTabH5FragmentBinding, MainViewModel> {

    /* compiled from: H5Fragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017\u00a8\u0006\u0004"}, d2 = {"com/bxkj/student/v2/ui/main/H5Fragment$a", "Lcom/bxkj/student/v2/ui/h5/js/JS;", "Lkotlin/f1;", "finish", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends JS {

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ SmartWebView f23889l;

        /* compiled from: H5Fragment.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.bxkj.student.v2.ui.main.H5Fragment$initWebView$1$1$1$finish$1", f = "H5Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bxkj.student.v2.ui.main.H5Fragment$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        static final class C0311a extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a  reason: collision with root package name */
            int f23890a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ SmartWebView f23891b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0311a(SmartWebView smartWebView, kotlin.coroutines.c<? super C0311a> cVar) {
                super(2, cVar);
                this.f23891b = smartWebView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                return new C0311a(this.f23891b, cVar);
            }

            @Override // d2.p
            @Nullable
            public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
                return ((C0311a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.b.h();
                if (this.f23890a == 0) {
                    d0.n(obj);
                    this.f23891b.l();
                    return f1.f55527a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SmartWebView smartWebView, FragmentActivity fragmentActivity, WebView webView) {
            super(fragmentActivity, webView);
            this.f23889l = smartWebView;
        }

        @Override // com.bxkj.student.v2.ui.h5.js.JS
        @JavascriptInterface
        public void finish() {
            kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(H5Fragment.this), kotlinx.coroutines.f1.e(), null, new C0311a(this.f23889l, null), 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [a, cn.bluemobi.dylan.smartwebview.SmartWebView$b] */
    private final void e() {
        SmartWebView smartWebView = M().smartWebView;
        f0.o(smartWebView, "this");
        smartWebView.setWebViewClient(new com.bxkj.base.v2.h5.d(smartWebView));
        smartWebView.setWebChromeClient(new C1339a(s()));
        WebView webView = smartWebView.getWebView();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(0);
        }
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setDomStorageEnabled(true);
        webView.addJavascriptInterface(new a(smartWebView, w(), M().smartWebView.getWebView()), "tsn");
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        String string;
        String k22;
        String string2;
        String string3;
        e();
        d(w());
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (!arguments.containsKey("title")) {
                arguments = null;
            }
            if (arguments != null && (string3 = arguments.getString("title")) != null) {
                M().tvTitle.setText(string3);
            }
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            if (!arguments2.containsKey("isShowH5Title")) {
                arguments2 = null;
            }
            if (arguments2 != null && (string2 = arguments2.getString("isShowH5Title")) != null) {
                if (!f0.g(string2, "0")) {
                    string2 = null;
                }
                if (string2 != null) {
                    M().tvTitle.setVisibility(8);
                }
            }
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            return;
        }
        Bundle bundle = arguments3.containsKey("url") ? arguments3 : null;
        if (bundle == null || (string = bundle.getString("url")) == null) {
            return;
        }
        com.orhanobut.logger.j.d(f0.C("H5Fragment\uff1aurl=", string), new Object[0]);
        k22 = w.k2(string, "${school}", com.bxkj.base.v2.data.a.f18673h.a().w(), false, 4, null);
        M().smartWebView.j(k22);
    }

    public final void f() {
        H5Fragment h5Fragment = b() ? this : null;
        if (h5Fragment == null) {
            return;
        }
        if ((com.bxkj.base.v2.data.a.f18673h.a().G() ? h5Fragment : null) == null) {
            return;
        }
        M().smartWebView.getWebView().reload();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
