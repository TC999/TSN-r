package com.bxkj.student.p094v2.p098ui.face;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.baidu.idl.face.platform.p049ui.BaseFaceDetectActivity;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.base.ProgressDialogFragment;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.FileUtils;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.bxkj.student.p094v2.p103vm.face.FaceDetectVM;
import com.bxkj.student.run.app.face.C5232a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import com.umeng.analytics.pro.UMCommonContent;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: FaceDetectV3Activity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 F2\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0014\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010C\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006G"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/face/FaceDetectV3Activity;", "Lcom/baidu/idl/face/platform/ui/BaseFaceDetectActivity;", "Lkotlin/f1;", "Q", "", "base64ImageMap", "O", "R", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "", "brightness", ExifInterface.GPS_DIRECTION_TRUE, "y", "message", "U", "F", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "bmpStr", "onFace", "onDestroy", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "b", "Ljava/lang/String;", "identify", "c", "type", "", "d", "I", "runType", "", "e", "Z", "isShowSuccessMessage", "Lcom/bxkj/student/v2/vm/face/FaceDetectVM;", "f", "Lcom/bxkj/student/v2/vm/face/FaceDetectVM;", "mViewModel", "Landroidx/lifecycle/LifecycleOwner;", "g", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "h", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", UMCommonContent.f37777aG, "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "i", "Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "P", "()Lcom/bxkj/base/v2/base/ProgressDialogFragment;", ExifInterface.LATITUDE_SOUTH, "(Lcom/bxkj/base/v2/base/ProgressDialogFragment;)V", "mDialogFragment", "<init>", "()V", "j", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.face.FaceDetectV3Activity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FaceDetectV3Activity extends BaseFaceDetectActivity {
    @NotNull

    /* renamed from: j */
    public static final C5617a f20390j;

    /* renamed from: k */
    public static final int f20391k = 170;

    /* renamed from: a */
    private Context f20392a;
    @NotNull

    /* renamed from: b */
    private String f20393b = "";
    @NotNull

    /* renamed from: c */
    private String f20394c = "";

    /* renamed from: d */
    private int f20395d = 1;

    /* renamed from: e */
    private boolean f20396e = true;

    /* renamed from: f */
    private FaceDetectVM f20397f;

    /* renamed from: g */
    public LifecycleOwner f20398g;

    /* renamed from: h */
    public FragmentManager f20399h;
    @Nullable

    /* renamed from: i */
    private ProgressDialogFragment f20400i;

    /* compiled from: FaceDetectV3Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/face/FaceDetectV3Activity$a;", "", "", "RESULT_FAILD", "I", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceDetectV3Activity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5617a {
        private C5617a() {
        }

        public /* synthetic */ C5617a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FaceDetectV3Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceDetectV3Activity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5618b extends Lambda implements InterfaceC15280l<iOSOneButtonDialog, Unit> {
        C5618b() {
            super(1);
        }

        /* renamed from: a */
        public final void m38770a(@NotNull iOSOneButtonDialog it) {
            C14342f0.m8184p(it, "it");
            FaceDetectV3Activity.this.m38788R();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSOneButtonDialog iosonebuttondialog) {
            m38770a(iosonebuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FaceDetectV3Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceDetectV3Activity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5619c extends Lambda implements InterfaceC15269a<Unit> {
        C5619c() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ContextExt.m43847q(FaceDetectV3Activity.this, "人脸识别成功");
            FaceDetectV3Activity.this.setResult(-1);
            FaceDetectV3Activity.this.finish();
        }
    }

    /* compiled from: FaceDetectV3Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, m12616d2 = {"com/bxkj/student/v2/ui/face/FaceDetectV3Activity$d", "Lcom/baidu/idl/face/platform/listener/IInitCallback;", "Lkotlin/f1;", "initSuccess", "", "i", "", "s", "initFailure", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceDetectV3Activity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5620d implements IInitCallback {
        C5620d() {
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initFailure(int i, @NotNull String s) {
            C14342f0.m8184p(s, "s");
            C11792j.m20468e("FaceSDKManager初始化失败i=" + i + "s=" + s, new Object[0]);
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initSuccess() {
            C11792j.m20469d("FaceSDKManager初始化成功", new Object[0]);
        }
    }

    /* compiled from: FaceDetectV3Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/student/v2/ui/face/FaceDetectV3Activity$e", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceDetectV3Activity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class DialogInterface$OnKeyListenerC5621e implements DialogInterface.OnKeyListener {
        DialogInterface$OnKeyListenerC5621e() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(@Nullable DialogInterface dialogInterface, int i, @Nullable KeyEvent keyEvent) {
            if (i == 4) {
                ProgressDialogFragment m38790P = FaceDetectV3Activity.this.m38790P();
                if (m38790P != null) {
                    m38790P.dismiss();
                }
                FaceDetectVM faceDetectVM = FaceDetectV3Activity.this.f20397f;
                if (faceDetectVM == null) {
                    C14342f0.m8200S("mViewModel");
                    faceDetectVM = null;
                }
                Job m43957b = faceDetectVM.m43957b();
                if (m43957b == null) {
                    return true;
                }
                m43957b.mo3827b(new CancellationException());
                return true;
            }
            return false;
        }
    }

    static {
        StubApp.interface11(12476);
        f20390j = new C5617a(null);
    }

    /* renamed from: F */
    private final void m38794F() {
        ProgressDialogFragment progressDialogFragment = this.f20400i;
        if (progressDialogFragment == null || progressDialogFragment == null) {
            return;
        }
        progressDialogFragment.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public static final void m38792N(FaceDetectV3Activity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20392a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43847q(context, str);
    }

    /* renamed from: O */
    private final void m38791O(String str) {
        File file = new File(BaseApp.m44341b().getFilesDir().getPath(), "face");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "avatar_face_" + this.f20394c + '_' + System.currentTimeMillis() + PhotoBitmapUtils.f15141c);
        FileUtils.C3962a c3962a = FileUtils.f15115a;
        String path = file2.getPath();
        C14342f0.m8185o(path, "avatar.path");
        File m43802a = c3962a.m43802a(str, path);
        C11792j.m20469d(C14342f0.m8216C("avatar.path=", m43802a.getPath()), new Object[0]);
        FaceDetectVM faceDetectVM = this.f20397f;
        if (faceDetectVM == null) {
            C14342f0.m8200S("mViewModel");
            faceDetectVM = null;
        }
        faceDetectVM.m38113u(this.f20393b, this.f20394c, String.valueOf(this.f20395d), m43802a, new C5619c());
    }

    /* renamed from: Q */
    private final void m38789Q() {
        if (FaceSDKManager.getInstance().getInitFlag()) {
            return;
        }
        FaceSDKManager.getInstance().initialize(this, C5232a.f19112a, C5232a.f19113b, new C5620d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public final void m38788R() {
        setResult(170, getIntent());
        finish();
    }

    /* renamed from: T */
    private final void m38786T(Activity activity, float f) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f;
        window.setAttributes(attributes);
    }

    /* renamed from: U */
    private final void m38785U(String str) {
        if (this.f20400i == null) {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment(str);
            this.f20400i = progressDialogFragment;
            progressDialogFragment.m43938c(new DialogInterface$OnKeyListenerC5621e());
        }
        ProgressDialogFragment progressDialogFragment2 = this.f20400i;
        if (progressDialogFragment2 == null) {
            return;
        }
        progressDialogFragment2.m43936e(m38793J(), str, true);
    }

    /* renamed from: V */
    static /* synthetic */ void m38784V(FaceDetectV3Activity faceDetectV3Activity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "loading...";
        }
        faceDetectV3Activity.m38785U(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final void m38776j(FaceDetectV3Activity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20392a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43848p(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static final void m38775k(FaceDetectV3Activity this$0, Integer it) {
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8185o(it, "it");
        if (it.intValue() <= 0) {
            this$0.m38794F();
            return;
        }
        FaceDetectVM faceDetectVM = this$0.f20397f;
        if (faceDetectVM == null) {
            C14342f0.m8200S("mViewModel");
            faceDetectVM = null;
        }
        this$0.m38785U(faceDetectVM.m43955d().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static final void m38774l(FaceDetectV3Activity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20392a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43850n(context, str, new C5618b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static final void m38773m(FaceDetectV3Activity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20392a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43851m(context, str);
    }

    /* renamed from: y */
    private final void m38772y() {
        FaceDetectVM faceDetectVM = this.f20397f;
        if (faceDetectVM == null) {
            C14342f0.m8200S("mViewModel");
            faceDetectVM = null;
        }
        faceDetectVM.m43956c().observe(m38795B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceDetectV3Activity.m38775k(FaceDetectV3Activity.this, (Integer) obj);
            }
        });
        faceDetectVM.m43954e().observe(m38795B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceDetectV3Activity.m38774l(FaceDetectV3Activity.this, (String) obj);
            }
        });
        faceDetectVM.m43953f().observe(m38795B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceDetectV3Activity.m38773m(FaceDetectV3Activity.this, (String) obj);
            }
        });
        faceDetectVM.m43951h().observe(m38795B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceDetectV3Activity.m38792N(FaceDetectV3Activity.this, (String) obj);
            }
        });
        faceDetectVM.m43952g().observe(m38795B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceDetectV3Activity.m38776j(FaceDetectV3Activity.this, (String) obj);
            }
        });
    }

    @NotNull
    /* renamed from: B */
    public final LifecycleOwner m38795B() {
        LifecycleOwner lifecycleOwner = this.f20398g;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        C14342f0.m8200S("lifecycleOwner");
        return null;
    }

    @NotNull
    /* renamed from: J */
    public final FragmentManager m38793J() {
        FragmentManager fragmentManager = this.f20399h;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        C14342f0.m8200S("dialogFagmentManager");
        return null;
    }

    @Nullable
    /* renamed from: P */
    public final ProgressDialogFragment m38790P() {
        return this.f20400i;
    }

    /* renamed from: S */
    public final void m38787S(@Nullable ProgressDialogFragment progressDialogFragment) {
        this.f20400i = progressDialogFragment;
    }

    @Override // com.baidu.idl.face.platform.p049ui.FaceDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m38794F();
        m38786T(this, -1.0f);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.idl.face.platform.p049ui.BaseFaceDetectActivity
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
        m38791O(str);
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        C14342f0.m8184p(lifecycleOwner, "<set-?>");
        this.f20398g = lifecycleOwner;
    }

    /* renamed from: z */
    public final void m38771z(@NotNull FragmentManager fragmentManager) {
        C14342f0.m8184p(fragmentManager, "<set-?>");
        this.f20399h = fragmentManager;
    }
}
