package com.bxkj.student.p094v2.p098ui.p099h5;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.p086h5.H5BaseWebViewClient;
import com.bxkj.student.databinding.AcV2H5AppBinding;
import com.bxkj.student.p094v2.p098ui.p099h5.p100js.C5652JS;
import com.bxkj.student.p094v2.p103vm.p104h5.H5AppVM;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.MBridgeConstans;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import com.umeng.socialize.UMShareAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections._Arrays;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsJVM;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: H5AppActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002'(B\u0007¢\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0003J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001f\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0018\u0010#\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0018¨\u0006)"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/h5/H5AppActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2H5AppBinding;", "Lcom/bxkj/student/v2/vm/h5/H5AppVM;", "Lkotlin/f1;", "N", "", "requestCode", "resultCode", "Landroid/content/Intent;", "intent", "g", "Landroid/webkit/WebView;", "webView", "P", "onNewIntent", ExifInterface.LONGITUDE_EAST, "O", "p", "data", "onActivityResult", "onBackPressed", "", "i", "Ljava/lang/String;", "needUpdatePasswordStatus", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "j", "Landroid/webkit/ValueCallback;", "uploadMessage", "", "k", "uploadMessageAboveL", C7304t.f25048d, "intentUrl", "<init>", "()V", "m", "a", "b", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.h5.H5AppActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class H5AppActivity extends BaseActivity<AcV2H5AppBinding, H5AppVM> {
    @NotNull

    /* renamed from: m */
    public static final C5649a f20440m;

    /* renamed from: n */
    private static final int f20441n = 10000;
    @NotNull

    /* renamed from: i */
    private String f20442i = "";
    @Nullable

    /* renamed from: j */
    private ValueCallback<Uri> f20443j;
    @Nullable

    /* renamed from: k */
    private ValueCallback<Uri[]> f20444k;
    @Nullable

    /* renamed from: l */
    private String f20445l;

    /* compiled from: H5AppActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/h5/H5AppActivity$a;", "", "", "FILE_CHOOSER_RESULT_CODE", "I", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.H5AppActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5649a {
        private C5649a() {
        }

        public /* synthetic */ C5649a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: H5AppActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"", "updateStatus", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.H5AppActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5651c extends Lambda implements InterfaceC15280l<String, Unit> {
        C5651c() {
            super(1);
        }

        /* renamed from: a */
        public final void m38735a(@NotNull String updateStatus) {
            C14342f0.m8184p(updateStatus, "updateStatus");
            H5AppActivity h5AppActivity = H5AppActivity.this;
            if (!(!C14342f0.m8193g(updateStatus, "1"))) {
                h5AppActivity = null;
            }
            if (h5AppActivity == null) {
                return;
            }
            H5AppActivity.super.onBackPressed();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            m38735a(str);
            return Unit.f41048a;
        }
    }

    static {
        StubApp.interface11(12507);
        f20440m = new C5649a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public final void m38743N() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "选择文件"), 10000);
    }

    /* renamed from: P */
    private final void m38741P(WebView webView) {
        Object systemService = mo43926C().getSystemService("window");
        if (systemService != null) {
            int width = ((WindowManager) systemService).getDefaultDisplay().getWidth();
            if (width > 650) {
                webView.setInitialScale(190);
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

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(21)
    /* renamed from: g */
    private final void m38736g(int i, int i2, Intent intent) {
        int itemCount;
        if (i != 10000 || this.f20444k == null) {
            return;
        }
        List arrayList = new ArrayList();
        if (i2 == -1 && intent != null) {
            String dataString = intent.getDataString();
            ClipData clipData = intent.getClipData();
            if (clipData != null && clipData.getItemCount() > 0 && arrayList.size() >= clipData.getItemCount() && (itemCount = clipData.getItemCount()) > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    Uri uri = clipData.getItemAt(i3).getUri();
                    C14342f0.m8185o(uri, "item.uri");
                    arrayList.set(i3, uri);
                    if (i4 >= itemCount) {
                        break;
                    }
                    i3 = i4;
                }
            }
            if (dataString != null) {
                arrayList = _Arrays.m10171oy(new Uri[]{Uri.parse(dataString)});
            }
        }
        ValueCallback<Uri[]> valueCallback = this.f20444k;
        if (valueCallback != 0) {
            Object[] array = arrayList.toArray(new Uri[0]);
            if (array != null) {
                valueCallback.onReceiveValue(array);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        this.f20444k = null;
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setMActivity(this);
        String stringExtra = getIntent().hasExtra("title") ? getIntent().getStringExtra("title") : "首页";
        if (getIntent().hasExtra("url")) {
            String stringExtra2 = getIntent().getStringExtra("url");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.f20445l = stringExtra2;
        }
        if ((getIntent().hasExtra("needUpdatePasswordStatus") ? this : null) != null) {
            String stringExtra3 = getIntent().getStringExtra("needUpdatePasswordStatus");
            this.f20442i = stringExtra3 != null ? stringExtra3 : "";
        }
        C11792j.m20469d(C14342f0.m8216C("smartWebView.intentUrl=", this.f20445l), new Object[0]);
        mo43920M().setTitle(stringExtra);
        SmartWebView smartWebView = mo43920M().smartWebView;
        C14342f0.m8185o(smartWebView, "this");
        smartWebView.setWebViewClient(new H5BaseWebViewClient(smartWebView));
        smartWebView.setWebChromeClient(new C5650b(this));
        WebView webView = smartWebView.getWebView();
        m38741P(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(0);
        }
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setDomStorageEnabled(true);
        webView.addJavascriptInterface(new C5652JS(mo43912w(), mo43920M().smartWebView.getWebView()), "tsn");
        String str = this.f20445l;
        if (str == null) {
            return;
        }
        mo43920M().smartWebView.m57493j(str);
    }

    /* renamed from: O */
    public final void m38742O() {
        mo43920M().smartWebView.m57491l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        UMShareAPI.get(this).onActivityResult(i, i2, intent);
        if (i == 10000) {
            if (this.f20443j == null && this.f20444k == null) {
                return;
            }
            Uri data = (intent == null || i2 != -1) ? null : intent.getData();
            if (this.f20444k != null) {
                m38736g(i, i2, intent);
                return;
            }
            ValueCallback<Uri> valueCallback = this.f20443j;
            if (valueCallback != null) {
                C14342f0.m8187m(valueCallback);
                valueCallback.onReceiveValue(data);
                this.f20443j = null;
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (mo43920M().smartWebView.getWebView().canGoBack()) {
            mo43920M().smartWebView.getWebView().goBack();
        } else if (C14342f0.m8193g(this.f20442i, "1")) {
            mo43911x().m38106v(new C5651c());
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        mo38206E();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }

    /* compiled from: H5AppActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001e\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004J(\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004J0\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0017"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/h5/H5AppActivity$b;", "Lcn/bluemobi/dylan/smartwebview/SmartWebView$b;", "Landroid/webkit/WebView;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "title", "Lkotlin/f1;", "onReceivedTitle", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "valueCallback", "openFileChooser", "acceptType", "capture", "webView", "", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "", "onShowFileChooser", "<init>", "(Lcom/bxkj/student/v2/ui/h5/H5AppActivity;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.H5AppActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public final class C5650b extends SmartWebView.C1221b {

        /* renamed from: a */
        final /* synthetic */ H5AppActivity f20446a;

        public C5650b(H5AppActivity this$0) {
            C14342f0.m8184p(this$0, "this$0");
            this.f20446a = this$0;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(@NotNull WebView view, @NotNull String title) {
            boolean m6548u2;
            C14342f0.m8184p(view, "view");
            C14342f0.m8184p(title, "title");
            if (TextUtils.isEmpty(title)) {
                return;
            }
            m6548u2 = StringsJVM.m6548u2(title, IDataSource.f43971a, false, 2, null);
            if (m6548u2 || C14342f0.m8193g(title, "网页无法打开")) {
                return;
            }
            this.f20446a.mo43920M().setTitle(title);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(@Nullable WebView webView, @NotNull ValueCallback<Uri[]> filePathCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
            C14342f0.m8184p(filePathCallback, "filePathCallback");
            this.f20446a.f20444k = filePathCallback;
            this.f20446a.m38743N();
            return true;
        }

        public final void openFileChooser(@NotNull ValueCallback<Uri> valueCallback) {
            C14342f0.m8184p(valueCallback, "valueCallback");
            this.f20446a.f20443j = valueCallback;
            this.f20446a.m38743N();
        }

        public final void openFileChooser(@NotNull ValueCallback<Uri> valueCallback, @Nullable String str) {
            C14342f0.m8184p(valueCallback, "valueCallback");
            this.f20446a.f20443j = valueCallback;
            this.f20446a.m38743N();
        }

        public final void openFileChooser(@NotNull ValueCallback<Uri> valueCallback, @Nullable String str, @Nullable String str2) {
            C14342f0.m8184p(valueCallback, "valueCallback");
            this.f20446a.f20443j = valueCallback;
            this.f20446a.m38743N();
        }
    }
}
