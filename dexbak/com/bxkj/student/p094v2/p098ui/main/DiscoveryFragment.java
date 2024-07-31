package com.bxkj.student.p094v2.p098ui.main;

import android.os.Build;
import android.view.View;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.p085v2.p086h5.H5BaseWebViewClient;
import com.bxkj.student.databinding.V2MainTabDiscoveryFragmentBinding;
import com.bxkj.student.p094v2.p098ui.p099h5.p100js.C5652JS;
import com.bxkj.student.p094v2.p103vm.MainViewModel;
import com.mbridge.msdk.MBridgeConstans;
import com.orhanobut.logger.C11792j;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.Nullable;
import p638r0.RefreshLayout;
import p642s0.OnRefreshListener;

/* compiled from: DiscoveryFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/main/DiscoveryFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabDiscoveryFragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "k", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.main.DiscoveryFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class DiscoveryFragment extends BaseFragment<V2MainTabDiscoveryFragmentBinding, MainViewModel> {

    /* compiled from: DiscoveryFragment.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/main/DiscoveryFragment$a", "Lcom/bxkj/base/v2/h5/d;", "Landroid/webkit/WebView;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "url", "Lkotlin/f1;", "onPageFinished", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.main.DiscoveryFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5671a extends H5BaseWebViewClient {

        /* renamed from: e */
        final /* synthetic */ SmartWebView f20495e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5671a(SmartWebView smartWebView) {
            super(smartWebView);
            this.f20495e = smartWebView;
            C14342f0.m8185o(smartWebView, "this");
        }

        @Override // com.bxkj.base.p085v2.p086h5.H5BaseWebViewClient, cn.bluemobi.dylan.smartwebview.SmartWebView.C1225c, android.webkit.WebViewClient
        public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
            super.onPageFinished(webView, str);
            DiscoveryFragment.this.mo43920M().srl.mo2078B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static final void m38693h(DiscoveryFragment this$0, String it) {
        String m6568k2;
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8185o(it, "it");
        m6568k2 = StringsJVM.m6568k2(it, "${school}", LoggedInUser.f15182b.m43634a().m43646p(), false, 4, null);
        C11792j.m20469d(C14342f0.m8216C("发现页地址：", m6568k2), new Object[0]);
        this$0.mo43920M().smartWebView.m57493j(m6568k2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static final void m38692i(DiscoveryFragment this$0, View view, int i, int i2, int i3, int i4) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.mo43920M().srl.setEnabled(i2 == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final void m38691j(DiscoveryFragment this$0, RefreshLayout refreshLayout) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38690k();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        m43975d(mo43912w());
    }

    /* renamed from: k */
    public final void m38690k() {
        DiscoveryFragment discoveryFragment = m43977b() ? this : null;
        if (discoveryFragment == null) {
            return;
        }
        if ((LoggedInUser.f15182b.m43634a().m43637y() ? discoveryFragment : null) == null) {
            return;
        }
        mo43920M().smartWebView.getWebView().reload();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        SmartWebView smartWebView = mo43920M().smartWebView;
        smartWebView.setWebViewClient(new C5671a(smartWebView));
        smartWebView.getWebView().addJavascriptInterface(new C5652JS(mo43912w(), mo43920M().smartWebView.getWebView()), "tsn");
        mo43911x().m38173M().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DiscoveryFragment.m38693h(DiscoveryFragment.this, (String) obj);
            }
        });
        if (Build.VERSION.SDK_INT >= 23) {
            mo43920M().smartWebView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bxkj.student.v2.ui.main.e
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    DiscoveryFragment.m38692i(DiscoveryFragment.this, view, i, i2, i3, i4);
                }
            });
        }
        mo43920M().srl.mo2035j(new OnRefreshListener() { // from class: com.bxkj.student.v2.ui.main.g
            @Override // p642s0.OnRefreshListener
            /* renamed from: q */
            public final void mo322q(RefreshLayout refreshLayout) {
                DiscoveryFragment.m38691j(DiscoveryFragment.this, refreshLayout);
            }
        });
    }
}
