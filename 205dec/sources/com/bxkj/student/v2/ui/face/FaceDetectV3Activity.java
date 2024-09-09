package com.bxkj.student.v2.ui.face;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.base.ProgressDialogFragment;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.h;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.face.FaceDetectVM;
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
/* compiled from: FaceDetectV3Activity.kt */
@Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 F2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0014\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010C\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006G"}, d2 = {"Lcom/bxkj/student/v2/ui/face/FaceDetectV3Activity;", "Lcom/baidu/idl/face/platform/ui/BaseFaceDetectActivity;", "Lkotlin/f1;", "R", "", "base64ImageMap", "P", "S", "Landroid/app/Activity;", "activity", "", "brightness", "U", "y", "message", "V", "F", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "bmpStr", "onFace", "onDestroy", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "b", "Ljava/lang/String;", "identify", "c", "type", "", "d", "I", "runType", "", "e", "Z", "isShowSuccessMessage", "Lcom/bxkj/student/v2/vm/face/FaceDetectVM;", "f", "Lcom/bxkj/student/v2/vm/face/FaceDetectVM;", "mViewModel", "Landroidx/lifecycle/LifecycleOwner;", "g", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "h", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", "z", "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "i", "Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "Q", "()Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "T", "(Lcom/bxkj/base/v2/base/ProgressDialogFragment;)V", "mDialogFragment", "<init>", "()V", "j", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class FaceDetectV3Activity extends BaseFaceDetectActivity {
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public static final a f23765j;

    /* renamed from: k  reason: collision with root package name */
    public static final int f23766k = 170;

    /* renamed from: a  reason: collision with root package name */
    private Context f23767a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private String f23768b = "";
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private String f23769c = "";

    /* renamed from: d  reason: collision with root package name */
    private int f23770d = 1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f23771e = true;

    /* renamed from: f  reason: collision with root package name */
    private FaceDetectVM f23772f;

    /* renamed from: g  reason: collision with root package name */
    public LifecycleOwner f23773g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentManager f23774h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private ProgressDialogFragment f23775i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceDetectV3Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/bxkj/student/v2/ui/face/FaceDetectV3Activity$a;", "", "", "RESULT_FAILD", "I", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
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
    /* compiled from: FaceDetectV3Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends Lambda implements d2.l<iOSOneButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23776a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FaceDetectV3Activity f23777b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, FaceDetectV3Activity faceDetectV3Activity) {
            super(1);
            this.f23776a = str;
            this.f23777b = faceDetectV3Activity;
        }

        public final void a(@NotNull iOSOneButtonDialog it) {
            boolean V2;
            f0.p(it, "it");
            String msg = this.f23776a;
            f0.o(msg, "msg");
            Context context = null;
            V2 = x.V2(msg, "\u767b\u5f55\u5931\u6548", false, 2, null);
            if (V2) {
                Context context2 = this.f23777b.f23767a;
                if (context2 == null) {
                    f0.S("mContext");
                    context2 = null;
                }
                Context context3 = this.f23777b.f23767a;
                if (context3 == null) {
                    f0.S("mContext");
                } else {
                    context = context3;
                }
                context2.startActivity(new Intent(context, LoginActivity.class).setFlags(268468224));
                return;
            }
            this.f23777b.S();
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
    /* compiled from: FaceDetectV3Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class c extends Lambda implements d2.a<f1> {
        c() {
            super(0);
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ContextExtKt.q(FaceDetectV3Activity.this, "\u4eba\u8138\u8bc6\u522b\u6210\u529f");
            FaceDetectV3Activity.this.setResult(-1);
            FaceDetectV3Activity.this.finish();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: FaceDetectV3Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/bxkj/student/v2/ui/face/FaceDetectV3Activity$d", "Lcom/baidu/idl/face/platform/listener/IInitCallback;", "Lkotlin/f1;", "initSuccess", "", "i", "", "s", "initFailure", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
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
    /* compiled from: FaceDetectV3Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/student/v2/ui/face/FaceDetectV3Activity$e", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(@Nullable DialogInterface dialogInterface, int i4, @Nullable KeyEvent keyEvent) {
            if (i4 == 4) {
                ProgressDialogFragment Q = FaceDetectV3Activity.this.Q();
                if (Q != null) {
                    Q.dismiss();
                }
                FaceDetectVM faceDetectVM = FaceDetectV3Activity.this.f23772f;
                if (faceDetectVM == null) {
                    f0.S("mViewModel");
                    faceDetectVM = null;
                }
                e2 b4 = faceDetectVM.b();
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
        StubApp.interface11(6344);
        f23765j = new a(null);
    }

    private final void F() {
        ProgressDialogFragment progressDialogFragment = this.f23775i;
        if (progressDialogFragment == null || progressDialogFragment == null) {
            return;
        }
        progressDialogFragment.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(FaceDetectV3Activity this$0, String str) {
        f0.p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f23767a;
        if (context == null) {
            f0.S("mContext");
            context = null;
        }
        ContextExtKt.m(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(FaceDetectV3Activity this$0, String str) {
        f0.p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f23767a;
        if (context == null) {
            f0.S("mContext");
            context = null;
        }
        ContextExtKt.q(context, str);
    }

    private final void P(String str) {
        File file = new File(BaseApp.b().getFilesDir().getPath(), "face");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "avatar_face_" + this.f23769c + '_' + System.currentTimeMillis() + ".png");
        h.a aVar = com.bxkj.base.v2.common.utils.h.a;
        String path = file2.getPath();
        f0.o(path, "avatar.path");
        File a4 = aVar.a(str, path);
        com.orhanobut.logger.j.d(f0.C("avatar.path=", a4.getPath()), new Object[0]);
        FaceDetectVM faceDetectVM = this.f23772f;
        if (faceDetectVM == null) {
            f0.S("mViewModel");
            faceDetectVM = null;
        }
        faceDetectVM.u(this.f23768b, this.f23769c, String.valueOf(this.f23770d), a4, new c());
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
        if (this.f23775i == null) {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment(str);
            this.f23775i = progressDialogFragment;
            progressDialogFragment.c(new e());
        }
        ProgressDialogFragment progressDialogFragment2 = this.f23775i;
        if (progressDialogFragment2 == null) {
            return;
        }
        progressDialogFragment2.e(J(), str, true);
    }

    static /* synthetic */ void W(FaceDetectV3Activity faceDetectV3Activity, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "loading...";
        }
        faceDetectV3Activity.V(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FaceDetectV3Activity this$0, String str) {
        f0.p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f23767a;
        if (context == null) {
            f0.S("mContext");
            context = null;
        }
        ContextExtKt.p(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(FaceDetectV3Activity this$0, Integer it) {
        f0.p(this$0, "this$0");
        f0.o(it, "it");
        if (it.intValue() <= 0) {
            this$0.F();
            return;
        }
        FaceDetectVM faceDetectVM = this$0.f23772f;
        if (faceDetectVM == null) {
            f0.S("mViewModel");
            faceDetectVM = null;
        }
        this$0.V(faceDetectVM.d().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(FaceDetectV3Activity this$0, String msg) {
        f0.p(this$0, "this$0");
        if (msg == null) {
            return;
        }
        Context context = this$0.f23767a;
        if (context == null) {
            f0.S("mContext");
            context = null;
        }
        f0.o(msg, "msg");
        ContextExtKt.n(context, msg, new b(msg, this$0)).setCancelable(false);
    }

    private final void y() {
        FaceDetectVM faceDetectVM = this.f23772f;
        if (faceDetectVM == null) {
            f0.S("mViewModel");
            faceDetectVM = null;
        }
        faceDetectVM.c().observe(B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceDetectV3Activity.l(FaceDetectV3Activity.this, (Integer) obj);
            }
        });
        faceDetectVM.e().observe(B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceDetectV3Activity.m(FaceDetectV3Activity.this, (String) obj);
            }
        });
        faceDetectVM.f().observe(B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceDetectV3Activity.N(FaceDetectV3Activity.this, (String) obj);
            }
        });
        faceDetectVM.h().observe(B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceDetectV3Activity.O(FaceDetectV3Activity.this, (String) obj);
            }
        });
        faceDetectVM.g().observe(B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceDetectV3Activity.k(FaceDetectV3Activity.this, (String) obj);
            }
        });
    }

    @NotNull
    public final LifecycleOwner B() {
        LifecycleOwner lifecycleOwner = this.f23773g;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        f0.S("lifecycleOwner");
        return null;
    }

    @NotNull
    public final FragmentManager J() {
        FragmentManager fragmentManager = this.f23774h;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        f0.S("dialogFagmentManager");
        return null;
    }

    @Nullable
    public final ProgressDialogFragment Q() {
        return this.f23775i;
    }

    public final void T(@Nullable ProgressDialogFragment progressDialogFragment) {
        this.f23775i = progressDialogFragment;
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
        this.f23773g = lifecycleOwner;
    }

    public final void z(@NotNull FragmentManager fragmentManager) {
        f0.p(fragmentManager, "<set-?>");
        this.f23774h = fragmentManager;
    }
}
