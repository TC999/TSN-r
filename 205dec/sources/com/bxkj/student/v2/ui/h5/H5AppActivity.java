package com.bxkj.student.v2.ui.h5;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.h5.d;
import com.bxkj.student.databinding.AcV2H5AppBinding;
import com.bxkj.student.v2.ui.h5.js.JS;
import com.bxkj.student.v2.vm.h5.H5AppVM;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.j;
import com.stub.StubApp;
import com.umeng.socialize.UMShareAPI;
import d2.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.p;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: H5AppActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003CDEB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0003J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u001a\u0010\"\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R$\u0010.\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0,\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010*R\u0018\u00100\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010%R\u001a\u00106\u001a\u0002018\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010>\u00a8\u0006F"}, d2 = {"Lcom/bxkj/student/v2/ui/h5/H5AppActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2H5AppBinding;", "Lcom/bxkj/student/v2/vm/h5/H5AppVM;", "Lkotlin/f1;", "Q", "", "requestCode", "resultCode", "Landroid/content/Intent;", "intent", "P", "Landroid/webkit/WebView;", "webView", "S", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/webkit/WebChromeClient$CustomViewCallback;", "callback", "U", "O", "", "visible", "T", "onNewIntent", "E", "R", "p", "data", "onActivityResult", "onBackPressed", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyUp", "", "i", "Ljava/lang/String;", "needUpdatePasswordStatus", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "j", "Landroid/webkit/ValueCallback;", "uploadMessage", "", "k", "uploadMessageAboveL", "l", "intentUrl", "Landroid/widget/FrameLayout$LayoutParams;", "m", "Landroid/widget/FrameLayout$LayoutParams;", "N", "()Landroid/widget/FrameLayout$LayoutParams;", "COVER_SCREEN_PARAMS", "n", "Landroid/view/View;", "customView", "Landroid/widget/FrameLayout;", "o", "Landroid/widget/FrameLayout;", "fullscreenContainer", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "customViewCallback", "<init>", "()V", CampaignEx.JSON_KEY_AD_Q, "a", "b", "FullscreenHolder", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class H5AppActivity extends BaseActivity<AcV2H5AppBinding, H5AppVM> {
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    public static final a f23817q;

    /* renamed from: r  reason: collision with root package name */
    private static final int f23818r = 10000;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ValueCallback<Uri> f23820j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ValueCallback<Uri[]> f23821k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private String f23822l;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private View f23824n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private FrameLayout f23825o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private WebChromeClient.CustomViewCallback f23826p;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private String f23819i = "";
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final FrameLayout.LayoutParams f23823m = new FrameLayout.LayoutParams(-1, -1);

    /* compiled from: H5AppActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/student/v2/ui/h5/H5AppActivity$FullscreenHolder;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onTouchEvent", "", "evt", "Landroid/view/MotionEvent;", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class FullscreenHolder extends FrameLayout {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FullscreenHolder(@NotNull Context ctx) {
            super(ctx);
            f0.p(ctx, "ctx");
            setBackgroundColor(ctx.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(@NotNull MotionEvent evt) {
            f0.p(evt, "evt");
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: H5AppActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/bxkj/student/v2/ui/h5/H5AppActivity$a;", "", "", "FILE_CHOOSER_RESULT_CODE", "I", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: H5AppActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "updateStatus", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class c extends Lambda implements l<String, f1> {
        c() {
            super(1);
        }

        public final void a(@NotNull String updateStatus) {
            f0.p(updateStatus, "updateStatus");
            H5AppActivity h5AppActivity = H5AppActivity.this;
            if (!(!f0.g(updateStatus, "1"))) {
                h5AppActivity = null;
            }
            if (h5AppActivity == null) {
                return;
            }
            H5AppActivity.super.onBackPressed();
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(String str) {
            a(str);
            return f1.f55527a;
        }
    }

    static {
        StubApp.interface11(6376);
        f23817q = new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        if (this.f23824n == null) {
            return;
        }
        T(true);
        ((FrameLayout) getWindow().getDecorView()).removeView(this.f23825o);
        this.f23825o = null;
        this.f23824n = null;
        WebChromeClient.CustomViewCallback customViewCallback = this.f23826p;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        M().smartWebView.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(21)
    private final void P(int i4, int i5, Intent intent) {
        int itemCount;
        if (i4 != 10000 || this.f23821k == null) {
            return;
        }
        List arrayList = new ArrayList();
        if (i5 == -1 && intent != null) {
            String dataString = intent.getDataString();
            ClipData clipData = intent.getClipData();
            if (clipData != null && clipData.getItemCount() > 0 && arrayList.size() >= clipData.getItemCount() && (itemCount = clipData.getItemCount()) > 0) {
                int i6 = 0;
                while (true) {
                    int i7 = i6 + 1;
                    Uri uri = clipData.getItemAt(i6).getUri();
                    f0.o(uri, "item.uri");
                    arrayList.set(i6, uri);
                    if (i7 >= itemCount) {
                        break;
                    }
                    i6 = i7;
                }
            }
            if (dataString != null) {
                arrayList = p.oy(new Uri[]{Uri.parse(dataString)});
            }
        }
        ValueCallback<Uri[]> valueCallback = this.f23821k;
        if (valueCallback != 0) {
            Object[] array = arrayList.toArray(new Uri[0]);
            if (array != null) {
                valueCallback.onReceiveValue(array);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        this.f23821k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "\u9009\u62e9\u6587\u4ef6"), 10000);
    }

    private final void S(WebView webView) {
        Object systemService = C().getSystemService("window");
        if (systemService != null) {
            int width = ((WindowManager) systemService).getDefaultDisplay().getWidth();
            if (width > 650) {
                webView.setInitialScale(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME);
                return;
            } else if (width > 520) {
                webView.setInitialScale(160);
                return;
            } else if (width > 450) {
                webView.setInitialScale(140);
                return;
            } else if (width > 300) {
                webView.setInitialScale(120);
                return;
            } else {
                webView.setInitialScale(100);
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    private final void T(boolean z3) {
        getWindow().setFlags(z3 ? 0 : 1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.f23824n != null) {
            if (customViewCallback == null) {
                return;
            }
            customViewCallback.onCustomViewHidden();
            return;
        }
        w().getWindow().getDecorView();
        FullscreenHolder fullscreenHolder = new FullscreenHolder(w());
        this.f23825o = fullscreenHolder;
        fullscreenHolder.addView(view, this.f23823m);
        ((FrameLayout) getWindow().getDecorView()).addView(this.f23825o, this.f23823m);
        this.f23824n = view;
        T(false);
        this.f23826p = customViewCallback;
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setMActivity(this);
        String stringExtra = getIntent().hasExtra("title") ? getIntent().getStringExtra("title") : "\u9996\u9875";
        if (getIntent().hasExtra("url")) {
            String stringExtra2 = getIntent().getStringExtra("url");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.f23822l = stringExtra2;
        }
        if ((getIntent().hasExtra("needUpdatePasswordStatus") ? this : null) != null) {
            String stringExtra3 = getIntent().getStringExtra("needUpdatePasswordStatus");
            this.f23819i = stringExtra3 != null ? stringExtra3 : "";
        }
        j.d(f0.C("smartWebView.intentUrl=", this.f23822l), new Object[0]);
        M().setTitle(stringExtra);
        SmartWebView smartWebView = M().smartWebView;
        f0.o(smartWebView, "this");
        smartWebView.setWebViewClient(new d(smartWebView));
        smartWebView.setWebChromeClient(new b(this));
        WebView webView = smartWebView.getWebView();
        S(webView);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(0);
        }
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setDomStorageEnabled(true);
        webView.addJavascriptInterface(new JS(w(), M().smartWebView.getWebView()), "tsn");
        String str = this.f23822l;
        if (str == null) {
            return;
        }
        M().smartWebView.j(str);
    }

    @NotNull
    protected final FrameLayout.LayoutParams N() {
        return this.f23823m;
    }

    public final void R() {
        M().smartWebView.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        UMShareAPI.get(this).onActivityResult(i4, i5, intent);
        if (i4 == 10000) {
            if (this.f23820j == null && this.f23821k == null) {
                return;
            }
            Uri data = (intent == null || i5 != -1) ? null : intent.getData();
            if (this.f23821k != null) {
                P(i4, i5, intent);
                return;
            }
            ValueCallback<Uri> valueCallback = this.f23820j;
            if (valueCallback != null) {
                f0.m(valueCallback);
                valueCallback.onReceiveValue(data);
                this.f23820j = null;
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (M().smartWebView.getWebView().canGoBack()) {
            M().smartWebView.getWebView().goBack();
        } else if (f0.g(this.f23819i, "1")) {
            x().v(new c());
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i4, @Nullable KeyEvent keyEvent) {
        if (i4 == 4) {
            if (this.f23824n != null) {
                O();
                return true;
            } else if (M().smartWebView.getWebView().canGoBack()) {
                M().smartWebView.getWebView().goBack();
                return true;
            } else {
                finish();
                return true;
            }
        }
        return super.onKeyUp(i4, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        E();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: H5AppActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0014\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001e\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J(\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J0\u0010\u0019\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00140\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/bxkj/student/v2/ui/h5/H5AppActivity$b;", "Lcn/bluemobi/dylan/smartwebview/SmartWebView$b;", "Landroid/webkit/WebView;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "title", "Lkotlin/f1;", "onReceivedTitle", "Landroid/view/View;", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "callback", "onShowCustomView", "onHideCustomView", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "valueCallback", "openFileChooser", "acceptType", "capture", "webView", "", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "", "onShowFileChooser", "<init>", "(Lcom/bxkj/student/v2/ui/h5/H5AppActivity;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b extends SmartWebView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ H5AppActivity f23827a;

        public b(H5AppActivity this$0) {
            f0.p(this$0, "this$0");
            this.f23827a = this$0;
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            this.f23827a.O();
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(@NotNull WebView view, @NotNull String title) {
            boolean u22;
            f0.p(view, "view");
            f0.p(title, "title");
            if (TextUtils.isEmpty(title)) {
                return;
            }
            u22 = w.u2(title, "http", false, 2, null);
            if (u22 || f0.g(title, "\u7f51\u9875\u65e0\u6cd5\u6253\u5f00")) {
                return;
            }
            this.f23827a.M().setTitle(title);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(@Nullable View view, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
            this.f23827a.U(view, customViewCallback);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(@Nullable WebView webView, @NotNull ValueCallback<Uri[]> filePathCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
            Intent createIntent;
            f0.p(filePathCallback, "filePathCallback");
            this.f23827a.f23821k = filePathCallback;
            if (Build.VERSION.SDK_INT >= 21) {
                if (fileChooserParams == null) {
                    createIntent = null;
                } else {
                    try {
                        createIntent = fileChooserParams.createIntent();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        Intent createIntent2 = fileChooserParams != null ? fileChooserParams.createIntent() : null;
                        if (createIntent2 != null) {
                            createIntent2.setType("file/*");
                        }
                        this.f23827a.startActivityForResult(createIntent2, 10000);
                        return true;
                    }
                }
                if (createIntent != null) {
                    createIntent.setType("application/pdf");
                }
                this.f23827a.startActivityForResult(createIntent, 10000);
                return true;
            }
            this.f23827a.Q();
            return true;
        }

        public final void openFileChooser(@NotNull ValueCallback<Uri> valueCallback) {
            f0.p(valueCallback, "valueCallback");
            this.f23827a.f23820j = valueCallback;
            this.f23827a.Q();
        }

        public final void openFileChooser(@NotNull ValueCallback<Uri> valueCallback, @Nullable String str) {
            f0.p(valueCallback, "valueCallback");
            this.f23827a.f23820j = valueCallback;
            this.f23827a.Q();
        }

        public final void openFileChooser(@NotNull ValueCallback<Uri> valueCallback, @Nullable String str, @Nullable String str2) {
            f0.p(valueCallback, "valueCallback");
            this.f23827a.f23820j = valueCallback;
            this.f23827a.Q();
        }
    }
}
