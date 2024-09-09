package com.bxkj.student.v2.ui.h5.js;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.common.ext.g;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.v2.ui.face.FaceCheckV2Activity;
import com.bxkj.student.v2.ui.face.FaceCollectActivity;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: FaceJS.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007R\"\u0010\u000f\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/bxkj/student/v2/ui/h5/js/f;", "Lcom/bxkj/student/v2/ui/h5/js/a;", "", "token", "schoolCode", "Lkotlin/f1;", "addUserFace", "faceTest", "Landroidx/fragment/app/FragmentActivity;", "h", "Landroidx/fragment/app/FragmentActivity;", "c", "()Landroidx/fragment/app/FragmentActivity;", "e", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroid/webkit/WebView;", "mWebView", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/webkit/WebView;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f extends com.bxkj.student.v2.ui.h5.js.a {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private FragmentActivity f23872h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceJS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends Lambda implements d2.a<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23873a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23874b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f23875c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, f fVar) {
            super(0);
            this.f23873a = str;
            this.f23874b = str2;
            this.f23875c = fVar;
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            a.b bVar = com.bxkj.base.v2.data.a.f18673h;
            bVar.a().Y(true);
            String str = this.f23873a;
            if (str != null) {
                bVar.a().M(str);
            }
            String str2 = this.f23874b;
            if (str2 != null) {
                bVar.a().k0(str2);
            }
            com.bxkj.student.v2.retrofit.c.f23705a.a();
            this.f23875c.c().startActivity(new Intent(this.f23875c.c(), FaceCollectActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceJS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends Lambda implements d2.a<f1> {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* compiled from: FaceJS.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/h5/js/f$b$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f23877a;

            a(f fVar) {
                this.f23877a = fVar;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                if (intent == null) {
                    return;
                }
                if (!(i4 == -1)) {
                    intent = null;
                }
                if (intent == null) {
                    return;
                }
                Intent intent2 = intent.hasExtra("code") ? intent : null;
                if (intent2 == null) {
                    return;
                }
                f fVar = this.f23877a;
                int intExtra = intent2.getIntExtra("code", 1);
                fVar.d().loadUrl("javascript:faceTestResult('" + intExtra + "')");
            }
        }

        b() {
            super(0);
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            m.b bVar = new m.b(f.this.c());
            Intent intent = new Intent().setClass(f.this.c(), FaceCheckV2Activity.class);
            f0.o(intent, "Intent().setClass(mActiv\u2026ckV2Activity::class.java)");
            bVar.startActivityForResult(intent).c(new a(f.this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        super(mActivity, mWebView);
        f0.p(mActivity, "mActivity");
        f0.p(mWebView, "mWebView");
        this.f23872h = mActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(f this$0, String str, String str2) {
        f0.p(this$0, "this$0");
        g.c(this$0.c(), "\u4eba\u8138\u91c7\u96c6", new a(str, str2, this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(f this$0) {
        f0.p(this$0, "this$0");
        g.c(this$0.c(), "\u4eba\u8138\u9a8c\u8bc1", new b());
    }

    @JavascriptInterface
    public final void addUserFace(@Nullable final String str, @Nullable final String str2) {
        c().runOnUiThread(new Runnable() { // from class: com.bxkj.student.v2.ui.h5.js.e
            @Override // java.lang.Runnable
            public final void run() {
                f.q(f.this, str, str2);
            }
        });
    }

    @Override // com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.c
    @NotNull
    public FragmentActivity c() {
        return this.f23872h;
    }

    @Override // com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.c
    public void e(@NotNull FragmentActivity fragmentActivity) {
        f0.p(fragmentActivity, "<set-?>");
        this.f23872h = fragmentActivity;
    }

    @JavascriptInterface
    public final void faceTest(@Nullable String str, @Nullable String str2) {
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        bVar.a().Y(true);
        if (str != null) {
            bVar.a().M(str);
        }
        if (str2 != null) {
            bVar.a().k0(str2);
        }
        com.bxkj.student.v2.retrofit.c.f23705a.a();
        c().runOnUiThread(new Runnable() { // from class: com.bxkj.student.v2.ui.h5.js.d
            @Override // java.lang.Runnable
            public final void run() {
                f.r(f.this);
            }
        });
    }
}
