package com.bxkj.base.p085v2.p086h5;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bxkj.base.p085v2.base.ProgressDialogFragment;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.AMapLocationClient;
import com.bxkj.base.p085v2.common.utils.LocationObserver;
import com.kuaishou.weapon.p205p0.C7282g;
import com.orhanobut.logger.C11792j;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p615l.RequestPermission;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\u000b\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m12616d2 = {"Lcom/bxkj/base/v2/h5/c;", "", "Lkotlin/f1;", "getLocation", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "c", "()Landroidx/fragment/app/FragmentActivity;", "e", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroid/webkit/WebView;", "b", "Landroid/webkit/WebView;", "d", "()Landroid/webkit/WebView;", "f", "(Landroid/webkit/WebView;)V", "mWebView", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/webkit/WebView;)V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.h5.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GPSJS {
    @NotNull

    /* renamed from: a */
    private FragmentActivity f15224a;
    @NotNull

    /* renamed from: b */
    private WebView f15225b;

    /* compiled from: GPSJS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/base/v2/h5/c$a", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.h5.c$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3992a implements RequestPermission.InterfaceC15268a {

        /* compiled from: GPSJS.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J#\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m12616d2 = {"com/bxkj/base/v2/h5/c$a$a", "Lcom/bxkj/base/v2/common/utils/m;", "", "latitude", "longitude", "Lkotlin/f1;", "a", "", "errorCode", "", "errorMessage", "b", "(Ljava/lang/Integer;Ljava/lang/String;)V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.h5.c$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C3993a implements LocationObserver {

            /* renamed from: a */
            final /* synthetic */ GPSJS f15227a;

            /* renamed from: b */
            final /* synthetic */ ProgressDialogFragment f15228b;

            C3993a(GPSJS gpsjs, ProgressDialogFragment progressDialogFragment) {
                this.f15227a = gpsjs;
                this.f15228b = progressDialogFragment;
            }

            @Override // com.bxkj.base.p085v2.common.utils.LocationObserver
            /* renamed from: a */
            public void mo43544a(double d, double d2) {
                C11792j.m20469d("getLocationCallBack('" + d + "','" + d2 + "')", new Object[0]);
                WebView mo38732d = this.f15227a.mo38732d();
                mo38732d.loadUrl("javascript:stuSignStatus('" + d + "','" + d2 + "')");
                WebView mo38732d2 = this.f15227a.mo38732d();
                mo38732d2.loadUrl("javascript:getLocationCallBack('" + d + "','" + d2 + "')");
                this.f15228b.dismiss();
            }

            @Override // com.bxkj.base.p085v2.common.utils.LocationObserver
            /* renamed from: b */
            public void mo43543b(@Nullable Integer num, @Nullable String str) {
                this.f15228b.dismiss();
                FragmentActivity mo38718c = this.f15227a.mo38718c();
                ContextExt.m43848p(mo38718c, "获取定位失败，错误码【" + num + "】错误信息【" + ((Object) str) + (char) 12305);
            }
        }

        C3992a() {
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: a */
        public void mo3478a(@NotNull String[] permission) {
            C14342f0.m8184p(permission, "permission");
            ContextExt.m43851m(GPSJS.this.mo38718c(), "你拒绝了定位权限无法定位");
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: b */
        public void mo3477b() {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment(null, 1, null);
            FragmentManager supportFragmentManager = GPSJS.this.mo38718c().getSupportFragmentManager();
            C14342f0.m8185o(supportFragmentManager, "mActivity.supportFragmentManager");
            progressDialogFragment.m43936e(supportFragmentManager, "正在获取定位", true);
            AMapLocationClient.f15111a.m43810b(new C3993a(GPSJS.this, progressDialogFragment));
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: c */
        public void mo3476c(@NotNull String[] permission) {
            C14342f0.m8184p(permission, "permission");
            ContextExt.m43851m(GPSJS.this.mo38718c(), "你拒绝了定位权限无法定位");
        }
    }

    public GPSJS(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        C14342f0.m8184p(mActivity, "mActivity");
        C14342f0.m8184p(mWebView, "mWebView");
        this.f15224a = mActivity;
        this.f15225b = mWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final void m43545b(GPSJS this$0) {
        C14342f0.m8184p(this$0, "this$0");
        new RequestPermission(this$0.mo38718c()).m3480c(C7282g.f24950h, C7282g.f24949g).m3479d(new C3992a());
    }

    @NotNull
    /* renamed from: c */
    public FragmentActivity mo38718c() {
        return this.f15224a;
    }

    @NotNull
    /* renamed from: d */
    public WebView mo38732d() {
        return this.f15225b;
    }

    /* renamed from: e */
    public void mo38717e(@NotNull FragmentActivity fragmentActivity) {
        C14342f0.m8184p(fragmentActivity, "<set-?>");
        this.f15224a = fragmentActivity;
    }

    /* renamed from: f */
    public void mo38731f(@NotNull WebView webView) {
        C14342f0.m8184p(webView, "<set-?>");
        this.f15225b = webView;
    }

    @JavascriptInterface
    public final void getLocation() {
        C11792j.m20469d("开始获取GPS点名位置", new Object[0]);
        mo38718c().runOnUiThread(new Runnable() { // from class: com.bxkj.base.v2.h5.b
            @Override // java.lang.Runnable
            public final void run() {
                GPSJS.m43545b(GPSJS.this);
            }
        });
    }
}
