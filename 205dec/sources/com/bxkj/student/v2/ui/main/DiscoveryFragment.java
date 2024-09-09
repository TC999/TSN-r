package com.bxkj.student.v2.ui.main;

import android.os.Build;
import android.view.View;
import android.webkit.WebView;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.student.databinding.V2MainTabDiscoveryFragmentBinding;
import com.bxkj.student.v2.ui.h5.js.JS;
import com.bxkj.student.v2.vm.MainViewModel;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: DiscoveryFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/bxkj/student/v2/ui/main/DiscoveryFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabDiscoveryFragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", "E", "p", "k", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class DiscoveryFragment extends BaseFragment<V2MainTabDiscoveryFragmentBinding, MainViewModel> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: DiscoveryFragment.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/main/DiscoveryFragment$a", "Lcom/bxkj/base/v2/h5/d;", "Landroid/webkit/WebView;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "url", "Lkotlin/f1;", "onPageFinished", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends com.bxkj.base.v2.h5.d {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ SmartWebView f23887e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SmartWebView smartWebView) {
            super(smartWebView);
            this.f23887e = smartWebView;
            f0.o(smartWebView, "this");
        }

        @Override // com.bxkj.base.v2.h5.d, cn.bluemobi.dylan.smartwebview.SmartWebView.c, android.webkit.WebViewClient
        public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
            super.onPageFinished(webView, str);
            DiscoveryFragment.this.M().srl.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DiscoveryFragment this$0, String it) {
        String k22;
        f0.p(this$0, "this$0");
        f0.o(it, "it");
        k22 = w.k2(it, "${school}", com.bxkj.base.v2.data.a.f18673h.a().w(), false, 4, null);
        com.orhanobut.logger.j.d(f0.C("\u53d1\u73b0\u9875\u5730\u5740\uff1a", k22), new Object[0]);
        this$0.M().smartWebView.j(k22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(DiscoveryFragment this$0, View view, int i4, int i5, int i6, int i7) {
        f0.p(this$0, "this$0");
        this$0.M().srl.setEnabled(i5 == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DiscoveryFragment this$0, j1.h hVar) {
        f0.p(this$0, "this$0");
        this$0.k();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        d(w());
    }

    public final void k() {
        DiscoveryFragment discoveryFragment = b() ? this : null;
        if (discoveryFragment == null) {
            return;
        }
        if ((com.bxkj.base.v2.data.a.f18673h.a().G() ? discoveryFragment : null) == null) {
            return;
        }
        M().smartWebView.getWebView().reload();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        SmartWebView smartWebView = M().smartWebView;
        smartWebView.setWebViewClient(new a(smartWebView));
        smartWebView.getWebView().addJavascriptInterface(new JS(w(), M().smartWebView.getWebView()), "tsn");
        x().M().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DiscoveryFragment.h(DiscoveryFragment.this, (String) obj);
            }
        });
        if (Build.VERSION.SDK_INT >= 23) {
            M().smartWebView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bxkj.student.v2.ui.main.e
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i4, int i5, int i6, int i7) {
                    DiscoveryFragment.i(DiscoveryFragment.this, view, i4, i5, i6, i7);
                }
            });
        }
        M().srl.H(new k1.d() { // from class: com.bxkj.student.v2.ui.main.g
            @Override // k1.d
            public final void b(j1.h hVar) {
                DiscoveryFragment.j(DiscoveryFragment.this, hVar);
            }
        });
    }
}
