package com.bxkj.student.v2.ui.my;

import android.content.Context;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import com.bxkj.base.BaseApp;
import com.bxkj.base.util.z;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.ext.g;
import com.bxkj.student.common.utils.SoundUtils;
import com.bxkj.student.databinding.V2AcScanQrcodeBinding;
import com.bxkj.student.v2.common.utils.i;
import com.orhanobut.logger.j;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.q0;
import l1.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ScanQrCodeActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/bxkj/student/v2/ui/my/ScanQrCodeActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/V2AcScanQrcodeBinding;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "N", "E", "onResume", "onStop", "onDestroy", "p", "", "i", "Z", "isRefuse", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class ScanQrCodeActivity extends BaseActivity<V2AcScanQrcodeBinding, BaseViewModel> {

    /* renamed from: i  reason: collision with root package name */
    private boolean f23932i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ScanQrCodeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/student/v2/ui/my/ScanQrCodeActivity$a", "Lcn/bingoogolapple/qrcode/core/QRCodeView$f;", "", "result", "Lkotlin/f1;", "H", "", "isDark", "b", "D", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements QRCodeView.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SoundUtils f23933a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ScanQrCodeActivity f23934b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: ScanQrCodeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.bxkj.student.v2.ui.my.ScanQrCodeActivity$initUiData$1$onScanQRCodeSuccess$2", f = "ScanQrCodeActivity.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bxkj.student.v2.ui.my.ScanQrCodeActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        static final class C0313a extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a  reason: collision with root package name */
            int f23935a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ScanQrCodeActivity f23936b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0313a(ScanQrCodeActivity scanQrCodeActivity, kotlin.coroutines.c<? super C0313a> cVar) {
                super(2, cVar);
                this.f23936b = scanQrCodeActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                return new C0313a(this.f23936b, cVar);
            }

            @Override // l1.p
            @Nullable
            public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
                return ((C0313a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4;
                h4 = kotlin.coroutines.intrinsics.b.h();
                int i4 = this.f23935a;
                if (i4 == 0) {
                    d0.n(obj);
                    this.f23935a = 1;
                    if (a1.b(3000L, this) == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    d0.n(obj);
                }
                this.f23936b.N();
                return f1.f55527a;
            }
        }

        a(SoundUtils soundUtils, ScanQrCodeActivity scanQrCodeActivity) {
            this.f23933a = soundUtils;
            this.f23934b = scanQrCodeActivity;
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
        public void D() {
            Toast.makeText(this.f23934b.C(), "\u6253\u5f00\u76f8\u673a\u51fa\u9519", 0).show();
            j.e("\u6253\u5f00\u76f8\u673a\u51fa\u9519", new Object[0]);
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
        public void H(@Nullable String str) {
            boolean u22;
            boolean z3 = false;
            j.d(f0.C("result:", str), new Object[0]);
            this.f23933a.g(2131755010);
            if (str != null) {
                u22 = w.u2(str, "http", false, 2, null);
                if (u22) {
                    z3 = true;
                }
            }
            if (z3) {
                i iVar = i.f23368a;
                Context C = this.f23934b.C();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("name", "\u626b\u4e00\u626b");
                linkedHashMap.put("linkUrl", str);
                f1 f1Var = f1.f55527a;
                iVar.b(C, linkedHashMap);
                this.f23934b.finish();
                return;
            }
            ContextExtKt.q(this.f23934b, f0.C("\u626b\u7801\u7ed3\u679c:", str));
            h.f(LifecycleOwnerKt.getLifecycleScope(this.f23934b), kotlinx.coroutines.f1.c(), (CoroutineStart) null, new C0313a(this.f23934b, null), 2, (Object) null);
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
        public void b(boolean z3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ScanQrCodeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l1.a<f1> {
        b() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m64invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m64invoke() {
            j.d("\u5f00\u59cb\u626b\u7801", new Object[0]);
            ScanQrCodeActivity.this.f23932i = false;
            ScanQrCodeActivity.this.M().zbarview.z();
            ScanQrCodeActivity.this.M().zbarview.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ScanQrCodeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends Lambda implements l1.a<f1> {
        c() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m65invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m65invoke() {
            ScanQrCodeActivity.this.f23932i = true;
            j.d("\u7528\u6237\u62d2\u7edd\u6444\u50cf\u5934\u6743\u9650\u626b\u7801", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        j.d(f0.C("isRefuse=", Boolean.valueOf(this.f23932i)), new Object[0]);
        String str = "\u60a8\u62d2\u7edd\u4e86\u6444\u50cf\u5934\u6743\u9650,\u65e0\u6cd5\u8fdb\u884c\u626b\u7801,\u8bf7\u53bb\u624b\u673a\u3010\u8bbe\u7f6e\u3011->\u3010\u5e94\u7528\u7ba1\u7406\u3011->\u3010" + ((Object) z.b(BaseApp.b())) + "\u3011\u4e2d\u6253\u5f00\u6444\u50cf\u5934\u6743\u9650";
        ScanQrCodeActivity scanQrCodeActivity = this.f23932i ? this : null;
        if (scanQrCodeActivity == null) {
            g.d(this, "\u626b\u4e00\u626b", new b(), new c());
        } else {
            ContextExtKt.m(scanQrCodeActivity.C(), str);
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setBackEvent(this);
        SoundUtils soundUtils = new SoundUtils(w());
        soundUtils.m(2131755010);
        M().zbarview.setDelegate(new a(soundUtils, this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        M().zbarview.E();
        M().zbarview.G();
        M().zbarview.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        M().zbarview.E();
        M().zbarview.G();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
