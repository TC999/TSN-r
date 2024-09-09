package com.bxkj.student.v2.ui.face;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.baidu.idl.face.platform.ui.BaseFaceDetectActivity;
import com.bxkj.base.v2.base.ProgressDialogFragment;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.h;
import com.bxkj.base.v2.http.exception.ApiException;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.face.FaceCheckVM;
import com.stub.StubApp;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.x;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: FaceCheckV2Activity.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 92\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0014\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lcom/bxkj/student/v2/ui/face/FaceCheckV2Activity;", "Lcom/baidu/idl/face/platform/ui/BaseFaceDetectActivity;", "Lkotlin/f1;", "R", "", "base64ImageMap", "P", "S", "Landroid/app/Activity;", "activity", "", "brightness", "U", "y", "message", "V", "F", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "bmpStr", "onFace", "onDestroy", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "Lcom/bxkj/student/v2/vm/face/FaceCheckVM;", "b", "Lcom/bxkj/student/v2/vm/face/FaceCheckVM;", "mViewModel", "Landroidx/lifecycle/LifecycleOwner;", "c", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "d", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", "z", "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "e", "Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "Q", "()Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "T", "(Lcom/bxkj/base/v2/base/ProgressDialogFragment;)V", "mDialogFragment", "<init>", "()V", "f", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class FaceCheckV2Activity extends BaseFaceDetectActivity {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final a f23741f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f23742g = 170;

    /* renamed from: a  reason: collision with root package name */
    private Context f23743a;

    /* renamed from: b  reason: collision with root package name */
    private FaceCheckVM f23744b;

    /* renamed from: c  reason: collision with root package name */
    public LifecycleOwner f23745c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentManager f23746d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ProgressDialogFragment f23747e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceCheckV2Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/bxkj/student/v2/ui/face/FaceCheckV2Activity$a;", "", "", "RESULT_FAILD", "I", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceCheckV2Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends Lambda implements d2.l<iOSOneButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23748a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FaceCheckV2Activity f23749b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, FaceCheckV2Activity faceCheckV2Activity) {
            super(1);
            this.f23748a = str;
            this.f23749b = faceCheckV2Activity;
        }

        public final void a(@NotNull iOSOneButtonDialog it) {
            boolean V2;
            f0.p(it, "it");
            String msg = this.f23748a;
            f0.o(msg, "msg");
            Context context = null;
            V2 = x.V2(msg, "\u767b\u5f55\u5931\u6548", false, 2, null);
            if (V2) {
                Context context2 = this.f23749b.f23743a;
                if (context2 == null) {
                    f0.S("mContext");
                    context2 = null;
                }
                Context context3 = this.f23749b.f23743a;
                if (context3 == null) {
                    f0.S("mContext");
                } else {
                    context = context3;
                }
                context2.startActivity(new Intent(context, LoginActivity.class).setFlags(268468224));
                return;
            }
            this.f23749b.S();
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSOneButtonDialog iosonebuttondialog) {
            a(iosonebuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceCheckV2Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/base/v2/http/exception/ApiException;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class c extends Lambda implements d2.l<ApiException, f1> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* compiled from: FaceCheckV2Activity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class a extends Lambda implements d2.l<iOSOneButtonDialog, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Integer f23751a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FaceCheckV2Activity f23752b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Integer num, FaceCheckV2Activity faceCheckV2Activity) {
                super(1);
                this.f23751a = num;
                this.f23752b = faceCheckV2Activity;
            }

            public final void a(@NotNull iOSOneButtonDialog it) {
                f0.p(it, "it");
                Intent intent = new Intent();
                intent.putExtra("code", this.f23751a);
                this.f23752b.setResult(-1, intent);
                this.f23752b.finish();
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ f1 invoke(iOSOneButtonDialog iosonebuttondialog) {
                a(iosonebuttondialog);
                return f1.f55527a;
            }
        }

        c() {
            super(1);
        }

        public final void a(@NotNull ApiException it) {
            f0.p(it, "it");
            Integer code = it.getCode();
            Integer code2 = it.getCode();
            if (code2 != null && code2.intValue() == 0) {
                ContextExtKt.q(FaceCheckV2Activity.this, String.valueOf(it.getMessage()));
                Intent intent = new Intent();
                intent.putExtra("code", code);
                FaceCheckV2Activity.this.setResult(-1, intent);
                FaceCheckV2Activity.this.finish();
                return;
            }
            ContextExtKt.n(FaceCheckV2Activity.this, String.valueOf(it.getMessage()), new a(code, FaceCheckV2Activity.this));
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(ApiException apiException) {
            a(apiException);
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceCheckV2Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/bxkj/student/v2/ui/face/FaceCheckV2Activity$d", "Lcom/baidu/idl/face/platform/listener/IInitCallback;", "Lkotlin/f1;", "initSuccess", "", "i", "", "s", "initFailure", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class d implements IInitCallback {
        d() {
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initFailure(int i4, @NotNull String s3) {
            f0.p(s3, "s");
            com.orhanobut.logger.j.e("FaceSDKManager\u521d\u59cb\u5316\u5931\u8d25i=" + i4 + "s=" + s3, new Object[0]);
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initSuccess() {
            com.orhanobut.logger.j.d("FaceSDKManager\u521d\u59cb\u5316\u6210\u529f", new Object[0]);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceCheckV2Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/student/v2/ui/face/FaceCheckV2Activity$e", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(@Nullable DialogInterface dialogInterface, int i4, @Nullable KeyEvent keyEvent) {
            if (i4 == 4) {
                ProgressDialogFragment Q = FaceCheckV2Activity.this.Q();
                if (Q != null) {
                    Q.dismiss();
                }
                FaceCheckVM faceCheckVM = FaceCheckV2Activity.this.f23744b;
                if (faceCheckVM == null) {
                    f0.S("mViewModel");
                    faceCheckVM = null;
                }
                e2 b4 = faceCheckVM.b();
                if (b4 == null) {
                    return true;
                }
                b4.b(new CancellationException());
                return true;
            }
            return false;
        }
    }

    static {
        StubApp.interface11(6331);
        f23741f = new a(null);
    }

    private final void F() {
        ProgressDialogFragment progressDialogFragment = this.f23747e;
        if (progressDialogFragment == null) {
            return;
        }
        if (!progressDialogFragment.isAdded()) {
            progressDialogFragment = null;
        }
        if (progressDialogFragment == null) {
            return;
        }
        progressDialogFragment.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(FaceCheckV2Activity this$0, String str) {
        f0.p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f23743a;
        if (context == null) {
            f0.S("mContext");
            context = null;
        }
        ContextExtKt.m(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(FaceCheckV2Activity this$0, String str) {
        f0.p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f23743a;
        if (context == null) {
            f0.S("mContext");
            context = null;
        }
        ContextExtKt.q(context, str);
    }

    private final void P(String str) {
        File file;
        FaceCheckVM faceCheckVM = null;
        if (f0.g("mounted", Environment.getExternalStorageState())) {
            Context context = this.f23743a;
            if (context == null) {
                f0.S("mContext");
                context = null;
            }
            file = context.getExternalCacheDir();
        } else {
            file = null;
        }
        if (file == null || !file.exists()) {
            Context context2 = this.f23743a;
            if (context2 == null) {
                f0.S("mContext");
                context2 = null;
            }
            file = context2.getCacheDir();
        }
        File file2 = new File(file, "avatar");
        boolean exists = file2.exists();
        if (!exists) {
            exists = file2.mkdirs();
        }
        if (exists) {
            File file3 = new File(file2, "avatar_face.png");
            h.a aVar = com.bxkj.base.v2.common.utils.h.a;
            String path = file3.getPath();
            f0.o(path, "avatar.path");
            File a4 = aVar.a(str, path);
            FaceCheckVM faceCheckVM2 = this.f23744b;
            if (faceCheckVM2 == null) {
                f0.S("mViewModel");
            } else {
                faceCheckVM = faceCheckVM2;
            }
            faceCheckVM.t(a4, new c());
        }
    }

    private final void R() {
        if (FaceSDKManager.getInstance().getInitFlag()) {
            return;
        }
        FaceSDKManager.getInstance().initialize(this, com.bxkj.student.run.app.face.a.f22358a, com.bxkj.student.run.app.face.a.f22359b, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        setResult(170, getIntent());
        finish();
    }

    private final void U(Activity activity, float f4) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f4;
        window.setAttributes(attributes);
    }

    private final void V(String str) {
        if (this.f23747e == null) {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment(str);
            this.f23747e = progressDialogFragment;
            progressDialogFragment.c(new e());
        }
        ProgressDialogFragment progressDialogFragment2 = this.f23747e;
        if (progressDialogFragment2 == null) {
            return;
        }
        progressDialogFragment2.e(J(), str, true);
    }

    static /* synthetic */ void W(FaceCheckV2Activity faceCheckV2Activity, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "loading...";
        }
        faceCheckV2Activity.V(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FaceCheckV2Activity this$0, String str) {
        f0.p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f23743a;
        if (context == null) {
            f0.S("mContext");
            context = null;
        }
        ContextExtKt.p(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(FaceCheckV2Activity this$0, Integer it) {
        f0.p(this$0, "this$0");
        f0.o(it, "it");
        if (it.intValue() <= 0) {
            this$0.F();
            return;
        }
        FaceCheckVM faceCheckVM = this$0.f23744b;
        if (faceCheckVM == null) {
            f0.S("mViewModel");
            faceCheckVM = null;
        }
        this$0.V(faceCheckVM.d().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(FaceCheckV2Activity this$0, String msg) {
        f0.p(this$0, "this$0");
        if (msg == null) {
            return;
        }
        Context context = this$0.f23743a;
        if (context == null) {
            f0.S("mContext");
            context = null;
        }
        f0.o(msg, "msg");
        ContextExtKt.n(context, msg, new b(msg, this$0)).setCancelable(false);
    }

    private final void y() {
        FaceCheckVM faceCheckVM = this.f23744b;
        if (faceCheckVM == null) {
            f0.S("mViewModel");
            faceCheckVM = null;
        }
        faceCheckVM.c().observe(B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCheckV2Activity.l(FaceCheckV2Activity.this, (Integer) obj);
            }
        });
        faceCheckVM.e().observe(B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCheckV2Activity.m(FaceCheckV2Activity.this, (String) obj);
            }
        });
        faceCheckVM.f().observe(B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCheckV2Activity.N(FaceCheckV2Activity.this, (String) obj);
            }
        });
        faceCheckVM.h().observe(B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCheckV2Activity.O(FaceCheckV2Activity.this, (String) obj);
            }
        });
        faceCheckVM.g().observe(B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCheckV2Activity.k(FaceCheckV2Activity.this, (String) obj);
            }
        });
    }

    @NotNull
    public final LifecycleOwner B() {
        LifecycleOwner lifecycleOwner = this.f23745c;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        f0.S("lifecycleOwner");
        return null;
    }

    @NotNull
    public final FragmentManager J() {
        FragmentManager fragmentManager = this.f23746d;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        f0.S("dialogFagmentManager");
        return null;
    }

    @Nullable
    public final ProgressDialogFragment Q() {
        return this.f23747e;
    }

    public final void T(@Nullable ProgressDialogFragment progressDialogFragment) {
        this.f23747e = progressDialogFragment;
    }

    @Override // com.baidu.idl.face.platform.ui.FaceDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        F();
        U(this, -1.0f);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.idl.face.platform.ui.BaseFaceDetectActivity
    public void onFace(@Nullable String str) {
        super.onFace(str);
        if (str == null) {
            return;
        }
        if (!(str.length() > 0)) {
            str = null;
        }
        if (str == null) {
            return;
        }
        P(str);
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        f0.p(lifecycleOwner, "<set-?>");
        this.f23745c = lifecycleOwner;
    }

    public final void z(@NotNull FragmentManager fragmentManager) {
        f0.p(fragmentManager, "<set-?>");
        this.f23746d = fragmentManager;
    }
}
