package com.bxkj.student.v2.ui.h5.js;

import android.content.Intent;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.bxkj.student.v2.common.utils.ThirdLogin;
import com.bxkj.student.v2.common.utils.i;
import com.bxkj.student.v2.common.utils.t;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.ui.MainActivity;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.bxkj.student.v2.ui.my.ScanQrCodeActivity;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.bxkj.student.v2.ui.sports.v3.appeal.V3AppealActivity;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.orhanobut.logger.j;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import d2.l;
import d2.p;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.q0;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: JS.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010#\u001a\u00020\u001c\u0012\u0006\u0010+\u001a\u00020$\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0007J&\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\r\u001a\u00020\u0002H\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0007J:\u0010\u0013\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0017J\b\u0010\u0017\u001a\u00020\u0002H\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0007J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0007R\"\u0010#\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/bxkj/student/v2/ui/h5/js/JS;", "Lcom/bxkj/student/v2/ui/h5/js/f;", "Lkotlin/f1;", "selectSchool", "", "token", "schoolCode", "username", "startExercise", "title", "url", "goDetails", "goPublish", "publishSuccess", "getCircleImage", "loginTimeout", "type", "content", RewardPlus.ICON, "share", "exerciseRecordId", "exerciseFeedBack", "finish", "openWechat", "openQq", "path", "openApplet", "openScanQR", "Landroidx/fragment/app/FragmentActivity;", "i", "Landroidx/fragment/app/FragmentActivity;", "c", "()Landroidx/fragment/app/FragmentActivity;", "e", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroid/webkit/WebView;", "j", "Landroid/webkit/WebView;", "d", "()Landroid/webkit/WebView;", "f", "(Landroid/webkit/WebView;)V", "mWebView", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/webkit/WebView;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class JS extends f {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private FragmentActivity f23829i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private WebView f23830j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: JS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.JS$getCircleImage$2$1", f = "JS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class a extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23831a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23833c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f23833c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f23833c, cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f23831a == 0) {
                d0.n(obj);
                if (Build.VERSION.SDK_INT >= 19) {
                    WebView d4 = JS.this.d();
                    d4.evaluateJavascript("sendImageBase64('" + ((Object) this.f23833c) + "')", null);
                } else {
                    WebView d5 = JS.this.d();
                    d5.loadUrl("javascript:sendImageBase64('" + ((Object) this.f23833c) + "')");
                }
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: JS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.JS$goPublish$1", f = "JS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class b extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23834a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23836c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f23837d;

        /* compiled from: JS.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/h5/js/JS$b$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JS f23838a;

            a(JS js) {
                this.f23838a = js;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                if (i4 == -1) {
                    this.f23838a.d().loadUrl("javascript:refresh()");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f23836c = str;
            this.f23837d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new b(this.f23836c, this.f23837d, cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f23834a == 0) {
                d0.n(obj);
                i iVar = i.f23368a;
                FragmentActivity c4 = JS.this.c();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.f23836c;
                String str2 = this.f23837d;
                linkedHashMap.put("name", str);
                linkedHashMap.put("linkUrl", str2);
                f1 f1Var = f1.f55527a;
                iVar.c(c4, linkedHashMap, new a(JS.this));
                return f1Var;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: JS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class c extends Lambda implements l<Map<String, ? extends String>, f1> {
        c() {
            super(1);
        }

        public final void a(@NotNull Map<String, String> it) {
            f0.p(it, "it");
            WebView d4 = JS.this.d();
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:bindQq('");
            m mVar = m.a;
            sb.append(mVar.t(it, "uid"));
            sb.append("','");
            sb.append(mVar.t(it, "name"));
            sb.append("','");
            sb.append(mVar.t(it, "iconurl"));
            sb.append("')");
            d4.loadUrl(sb.toString());
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Map<String, ? extends String> map) {
            a(map);
            return f1.f55527a;
        }
    }

    /* compiled from: JS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.JS$openScanQR$1", f = "JS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class d extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23840a;

        /* compiled from: JS.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/h5/js/JS$d$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ JS f23842a;

            a(JS js) {
                this.f23842a = js;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                if (intent == null) {
                    return;
                }
                Intent intent2 = i4 == -1 ? intent : null;
                if (intent2 == null) {
                    return;
                }
                if ((intent.hasExtra("result") ? intent2 : null) == null) {
                    return;
                }
                JS js = this.f23842a;
                String stringExtra = intent.getStringExtra("result");
                String str = "javascript:getScanInfo('" + ((Object) stringExtra) + "')";
                js.d().loadUrl(str);
                j.d("result=" + ((Object) stringExtra) + " js=" + str, new Object[0]);
            }
        }

        d(kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new d(cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((d) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f23840a == 0) {
                d0.n(obj);
                new m.b(JS.this.c()).startActivityForResult(new Intent(JS.this.c(), ScanQrCodeActivity.class)).c(new a(JS.this));
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: JS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class e extends Lambda implements l<Map<String, ? extends String>, f1> {
        e() {
            super(1);
        }

        public final void a(@NotNull Map<String, String> it) {
            f0.p(it, "it");
            WebView d4 = JS.this.d();
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:bindWechat('");
            m mVar = m.a;
            sb.append(mVar.t(it, "uid"));
            sb.append("','");
            sb.append(mVar.t(it, "name"));
            sb.append("','");
            sb.append(mVar.t(it, "iconurl"));
            sb.append("')");
            d4.loadUrl(sb.toString());
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Map<String, ? extends String> map) {
            a(map);
            return f1.f55527a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JS(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        super(mActivity, mWebView);
        f0.p(mActivity, "mActivity");
        f0.p(mWebView, "mWebView");
        this.f23829i = mActivity;
        this.f23830j = mWebView;
    }

    @Override // com.bxkj.student.v2.ui.h5.js.f, com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.c
    @NotNull
    public FragmentActivity c() {
        return this.f23829i;
    }

    @Override // com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.c
    @NotNull
    public WebView d() {
        return this.f23830j;
    }

    @Override // com.bxkj.student.v2.ui.h5.js.f, com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.c
    public void e(@NotNull FragmentActivity fragmentActivity) {
        f0.p(fragmentActivity, "<set-?>");
        this.f23829i = fragmentActivity;
    }

    @JavascriptInterface
    public final void exerciseFeedBack(@Nullable String str, @NotNull String exerciseRecordId) {
        f0.p(exerciseRecordId, "exerciseRecordId");
        c().startActivity(new Intent(c(), V3AppealActivity.class).putExtra("exerciseRecordId", exerciseRecordId));
    }

    @Override // com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.c
    public void f(@NotNull WebView webView) {
        f0.p(webView, "<set-?>");
        this.f23830j = webView;
    }

    @JavascriptInterface
    public void finish() {
        c().finish();
    }

    @JavascriptInterface
    public final void getCircleImage() {
        j.d("\u5708\u5b50\u83b7\u53d6\u56fe\u7247", new Object[0]);
        if ((c().getIntent().hasExtra("imagePath") ? this : null) == null) {
            return;
        }
        String stringExtra = c().getIntent().getStringExtra("imagePath");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String b4 = com.bxkj.base.util.j.b(stringExtra);
        j.d(f0.C("imagePath=", stringExtra), new Object[0]);
        kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(c()), kotlinx.coroutines.f1.e(), null, new a(b4, null), 2, null);
    }

    @JavascriptInterface
    public final void goDetails(@Nullable String str, @Nullable String str2) {
        i iVar = i.f23368a;
        FragmentActivity c4 = c();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name", str);
        linkedHashMap.put("linkUrl", str2);
        f1 f1Var = f1.f55527a;
        iVar.b(c4, linkedHashMap);
    }

    @JavascriptInterface
    public final void goPublish(@Nullable String str, @Nullable String str2) {
        j.d("\u5708\u5b50->goPublish", new Object[0]);
        kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(c()), kotlinx.coroutines.f1.e(), null, new b(str, str2, null), 2, null);
    }

    @JavascriptInterface
    public final void loginTimeout() {
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        bVar.a().n0(1);
        bVar.a().Y(false);
        bVar.a().p0("");
        bVar.a().s0("");
        bVar.a().M("");
        bVar.a().i0("");
        bVar.a().d0(false);
        bVar.a().U("");
        c().startActivity(new Intent(c(), LoginActivity.class));
        cn.bluemobi.dylan.base.utils.a.n().i(H5AppActivity.class);
        MainActivity mainActivity = (MainActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MainActivity.class);
        if (mainActivity != null) {
            mainActivity.x().V().postValue(Boolean.TRUE);
        }
        c().finish();
    }

    @JavascriptInterface
    public final void openApplet(@NotNull String username, @Nullable String str) {
        f0.p(username, "username");
        j.d("username=" + username + " path=" + ((Object) str), new Object[0]);
        t.f23404a.a(c(), username, str);
    }

    @JavascriptInterface
    public final void openQq() {
        new ThirdLogin(c()).b(new c());
    }

    @JavascriptInterface
    public final void openScanQR() {
        kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(c()), kotlinx.coroutines.f1.e(), null, new d(null), 2, null);
    }

    @JavascriptInterface
    public final void openWechat() {
        new ThirdLogin(c()).c(new e());
    }

    @JavascriptInterface
    public final void publishSuccess() {
        j.d("\u5708\u5b50\u53d1\u5e03\u6210\u529f", new Object[0]);
        c().setResult(-1);
        c().finish();
    }

    @JavascriptInterface
    public final void selectSchool() {
        c().startActivity(new Intent(c(), SelectSchoolV2Activity.class));
    }

    @JavascriptInterface
    public final void share(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        SHARE_MEDIA share_media;
        UMWeb uMWeb = new UMWeb(str5);
        uMWeb.setTitle(str2);
        uMWeb.setThumb(new UMImage(c(), str4));
        uMWeb.setDescription(str3);
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1779587763) {
                if (hashCode != 2592) {
                    if (hashCode == 77564797 && str.equals("QZONE")) {
                        share_media = SHARE_MEDIA.QZONE;
                    }
                } else if (str.equals("QQ")) {
                    share_media = SHARE_MEDIA.QQ;
                }
            } else if (str.equals("WEIXIN_CIRCLE")) {
                share_media = SHARE_MEDIA.WEIXIN_CIRCLE;
            }
            new ShareAction(c()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.h5.js.JS$share$1
                @Override // com.umeng.socialize.UMShareListener
                public void onCancel(@NotNull SHARE_MEDIA platform) {
                    f0.p(platform, "platform");
                    ContextExtKt.r(JS.this.c(), "\u5206\u4eab\u53d6\u6d88\u4e86");
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onError(@NotNull SHARE_MEDIA platform, @NotNull Throwable t3) {
                    f0.p(platform, "platform");
                    f0.p(t3, "t");
                    t3.printStackTrace();
                    ContextExtKt.r(JS.this.c(), "\u5206\u4eab\u5931\u8d25\u5566");
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onResult(@NotNull SHARE_MEDIA platform) {
                    f0.p(platform, "platform");
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onStart(@NotNull SHARE_MEDIA share_media2) {
                    f0.p(share_media2, "share_media");
                }
            }).withMedia(uMWeb).share();
        }
        share_media = SHARE_MEDIA.WEIXIN;
        new ShareAction(c()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.h5.js.JS$share$1
            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(@NotNull SHARE_MEDIA platform) {
                f0.p(platform, "platform");
                ContextExtKt.r(JS.this.c(), "\u5206\u4eab\u53d6\u6d88\u4e86");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(@NotNull SHARE_MEDIA platform, @NotNull Throwable t3) {
                f0.p(platform, "platform");
                f0.p(t3, "t");
                t3.printStackTrace();
                ContextExtKt.r(JS.this.c(), "\u5206\u4eab\u5931\u8d25\u5566");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(@NotNull SHARE_MEDIA platform) {
                f0.p(platform, "platform");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(@NotNull SHARE_MEDIA share_media2) {
                f0.p(share_media2, "share_media");
            }
        }).withMedia(uMWeb).share();
    }

    @JavascriptInterface
    public final void startExercise(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        bVar.a().Y(true);
        if (str != null) {
            bVar.a().M(str);
        }
        if (str2 != null) {
            bVar.a().k0(str2);
        }
        if (str3 != null) {
            bVar.a().r0(str3);
        }
        com.bxkj.student.v2.retrofit.c.f23705a.a();
        c().startActivity(new Intent(c(), V3SportsHomeActivity.class));
    }
}
