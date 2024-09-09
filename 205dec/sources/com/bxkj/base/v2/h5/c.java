package com.bxkj.base.v2.h5;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bxkj.base.v2.base.ProgressDialogFragment;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.m;
import com.orhanobut.logger.j;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import l.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GPSJS.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\u000b\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/bxkj/base/v2/h5/c;", "", "Lkotlin/f1;", "getLocation", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "c", "()Landroidx/fragment/app/FragmentActivity;", "e", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroid/webkit/WebView;", "b", "Landroid/webkit/WebView;", "d", "()Landroid/webkit/WebView;", "f", "(Landroid/webkit/WebView;)V", "mWebView", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/webkit/WebView;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private FragmentActivity f18721a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private WebView f18722b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GPSJS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/base/v2/h5/c$a", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements b.a {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: GPSJS.kt */
        @Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J#\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"com/bxkj/base/v2/h5/c$a$a", "Lcom/bxkj/base/v2/common/utils/m;", "", "latitude", "longitude", "Lkotlin/f1;", "a", "", "errorCode", "", "errorMessage", "b", "(Ljava/lang/Integer;Ljava/lang/String;)V", "base_release"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.h5.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class C0205a implements m {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f18724a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ProgressDialogFragment f18725b;

            C0205a(c cVar, ProgressDialogFragment progressDialogFragment) {
                this.f18724a = cVar;
                this.f18725b = progressDialogFragment;
            }

            @Override // com.bxkj.base.v2.common.utils.m
            public void a(double d4, double d5) {
                j.d("getLocationCallBack('" + d4 + "','" + d5 + "')", new Object[0]);
                WebView d6 = this.f18724a.d();
                d6.loadUrl("javascript:stuSignStatus('" + d4 + "','" + d5 + "')");
                WebView d7 = this.f18724a.d();
                d7.loadUrl("javascript:getLocationCallBack('" + d4 + "','" + d5 + "')");
                this.f18725b.dismiss();
            }

            @Override // com.bxkj.base.v2.common.utils.m
            public void b(@Nullable Integer num, @Nullable String str) {
                this.f18725b.dismiss();
                FragmentActivity c4 = this.f18724a.c();
                ContextExtKt.p(c4, "\u83b7\u53d6\u5b9a\u4f4d\u5931\u8d25\uff0c\u9519\u8bef\u7801\u3010" + num + "\u3011\u9519\u8bef\u4fe1\u606f\u3010" + ((Object) str) + '\u3011');
            }
        }

        a() {
        }

        @Override // l.b.a
        public void a(@NotNull String[] permission) {
            f0.p(permission, "permission");
            ContextExtKt.m(c.this.c(), "\u4f60\u62d2\u7edd\u4e86\u5b9a\u4f4d\u6743\u9650\u65e0\u6cd5\u5b9a\u4f4d");
        }

        @Override // l.b.a
        public void b() {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment(null, 1, null);
            FragmentManager supportFragmentManager = c.this.c().getSupportFragmentManager();
            f0.o(supportFragmentManager, "mActivity.supportFragmentManager");
            progressDialogFragment.e(supportFragmentManager, "\u6b63\u5728\u83b7\u53d6\u5b9a\u4f4d", true);
            com.bxkj.base.v2.common.utils.c.f18599a.b(new C0205a(c.this, progressDialogFragment));
        }

        @Override // l.b.a
        public void c(@NotNull String[] permission) {
            f0.p(permission, "permission");
            ContextExtKt.m(c.this.c(), "\u4f60\u62d2\u7edd\u4e86\u5b9a\u4f4d\u6743\u9650\u65e0\u6cd5\u5b9a\u4f4d");
        }
    }

    public c(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        f0.p(mActivity, "mActivity");
        f0.p(mWebView, "mWebView");
        this.f18721a = mActivity;
        this.f18722b = mWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(c this$0) {
        f0.p(this$0, "this$0");
        new l.b(this$0.c()).c("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION").d(new a());
    }

    @NotNull
    public FragmentActivity c() {
        return this.f18721a;
    }

    @NotNull
    public WebView d() {
        return this.f18722b;
    }

    public void e(@NotNull FragmentActivity fragmentActivity) {
        f0.p(fragmentActivity, "<set-?>");
        this.f18721a = fragmentActivity;
    }

    public void f(@NotNull WebView webView) {
        f0.p(webView, "<set-?>");
        this.f18722b = webView;
    }

    @JavascriptInterface
    public final void getLocation() {
        j.d("\u5f00\u59cb\u83b7\u53d6GPS\u70b9\u540d\u4f4d\u7f6e", new Object[0]);
        c().runOnUiThread(new Runnable() { // from class: com.bxkj.base.v2.h5.b
            @Override // java.lang.Runnable
            public final void run() {
                c.b(c.this);
            }
        });
    }
}
