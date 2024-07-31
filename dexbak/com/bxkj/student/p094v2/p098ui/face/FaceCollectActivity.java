package com.bxkj.student.p094v2.p098ui.face;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.utils.AppManager;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.baidu.idl.face.platform.p049ui.BaseFaceLivenessActivity;
import com.bxkj.base.p085v2.base.ProgressDialogFragment;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.FileUtils;
import com.bxkj.student.p094v2.p103vm.face.FaceCollectVM;
import com.bxkj.student.run.app.face.C5232a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import com.umeng.analytics.pro.UMCommonContent;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FaceCollectActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 92\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0014\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0015\u001a\u00020\u0002H\u0014J\u0006\u0010\u0016\u001a\u00020\u0002R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006:"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/face/FaceCollectActivity;", "Lcom/baidu/idl/face/platform/ui/BaseFaceLivenessActivity;", "Lkotlin/f1;", "P", "", "base64ImageMap", "N", "Q", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "", "brightness", ExifInterface.LATITUDE_SOUTH, "y", "message", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "bmpStr", "onFace", "onDestroy", "F", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "Lcom/bxkj/student/v2/vm/face/FaceCollectVM;", "b", "Lcom/bxkj/student/v2/vm/face/FaceCollectVM;", "mViewModel", "Landroidx/lifecycle/LifecycleOwner;", "c", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "d", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", UMCommonContent.f37777aG, "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "e", "Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "O", "()Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "R", "(Lcom/bxkj/base/v2/base/ProgressDialogFragment;)V", "mDialogFragment", "<init>", "()V", "f", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.face.FaceCollectActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FaceCollectActivity extends BaseFaceLivenessActivity {
    @NotNull

    /* renamed from: f */
    public static final C5613a f20381f;

    /* renamed from: g */
    public static final int f20382g = 170;

    /* renamed from: a */
    private Context f20383a;

    /* renamed from: b */
    private FaceCollectVM f20384b;

    /* renamed from: c */
    public LifecycleOwner f20385c;

    /* renamed from: d */
    public FragmentManager f20386d;
    @Nullable

    /* renamed from: e */
    private ProgressDialogFragment f20387e;

    /* compiled from: FaceCollectActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/face/FaceCollectActivity$a;", "", "", "RESULT_FAILD", "I", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceCollectActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5613a {
        private C5613a() {
        }

        public /* synthetic */ C5613a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FaceCollectActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, m12616d2 = {"com/bxkj/student/v2/ui/face/FaceCollectActivity$b", "Lcom/baidu/idl/face/platform/listener/IInitCallback;", "Lkotlin/f1;", "initSuccess", "", "i", "", "s", "initFailure", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceCollectActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5614b implements IInitCallback {
        C5614b() {
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

    /* compiled from: FaceCollectActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/student/v2/ui/face/FaceCollectActivity$c", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceCollectActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class DialogInterface$OnKeyListenerC5615c implements DialogInterface.OnKeyListener {
        DialogInterface$OnKeyListenerC5615c() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(@Nullable DialogInterface dialogInterface, int i, @Nullable KeyEvent keyEvent) {
            if (i == 4) {
                ProgressDialogFragment m38816O = FaceCollectActivity.this.m38816O();
                if (m38816O != null) {
                    m38816O.dismiss();
                }
                FaceCollectVM faceCollectVM = FaceCollectActivity.this.f20384b;
                if (faceCollectVM == null) {
                    C14342f0.m8200S("mViewModel");
                    faceCollectVM = null;
                }
                Job m43957b = faceCollectVM.m43957b();
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
        StubApp.interface11(12468);
        f20381f = new C5613a(null);
    }

    /* renamed from: N */
    private final void m38817N(String str) {
        File file;
        Context context = null;
        if (C14342f0.m8193g("mounted", Environment.getExternalStorageState())) {
            Context context2 = this.f20383a;
            if (context2 == null) {
                C14342f0.m8200S("mContext");
                context2 = null;
            }
            file = context2.getExternalCacheDir();
        } else {
            file = null;
        }
        if (file == null || !file.exists()) {
            Context context3 = this.f20383a;
            if (context3 == null) {
                C14342f0.m8200S("mContext");
                context3 = null;
            }
            file = context3.getCacheDir();
        }
        File file2 = new File(file, "avatar");
        boolean exists = file2.exists();
        if (!exists) {
            exists = file2.mkdirs();
        }
        if (exists) {
            File file3 = new File(file2, "avatar_face.png");
            C11792j.m20469d(C14342f0.m8216C("avatar=", file3.getPath()), new Object[0]);
            FileUtils.C3962a c3962a = FileUtils.f15115a;
            String path = file3.getPath();
            C14342f0.m8185o(path, "avatar.path");
            File m43802a = c3962a.m43802a(str, path);
            Intent intent = getIntent();
            Context context4 = this.f20383a;
            if (context4 == null) {
                C14342f0.m8200S("mContext");
            } else {
                context = context4;
            }
            startActivity(intent.setClass(context, FaceCollectConfirmActivity.class).putExtra("avatar", m43802a.getPath()));
        }
    }

    /* renamed from: P */
    private final void m38815P() {
        if (FaceSDKManager.getInstance().getInitFlag()) {
            return;
        }
        FaceSDKManager.getInstance().initialize(this, C5232a.f19112a, C5232a.f19113b, new C5614b());
    }

    /* renamed from: Q */
    private final void m38814Q() {
        setResult(170, getIntent());
        finish();
    }

    /* renamed from: S */
    private final void m38812S(Activity activity, float f) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f;
        window.setAttributes(attributes);
    }

    /* renamed from: T */
    private final void m38811T(String str) {
        if (this.f20387e == null) {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment(str);
            this.f20387e = progressDialogFragment;
            progressDialogFragment.m43938c(new DialogInterface$OnKeyListenerC5615c());
        }
        ProgressDialogFragment progressDialogFragment2 = this.f20387e;
        if (progressDialogFragment2 == null) {
            return;
        }
        progressDialogFragment2.m43936e(m38818J(), str, true);
    }

    /* renamed from: U */
    static /* synthetic */ void m38810U(FaceCollectActivity faceCollectActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "loading...";
        }
        faceCollectActivity.m38811T(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static final void m38803i(FaceCollectActivity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20383a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43848p(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final void m38802j(FaceCollectActivity this$0, Integer it) {
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8185o(it, "it");
        if (it.intValue() <= 0) {
            this$0.m38819F();
            return;
        }
        FaceCollectVM faceCollectVM = this$0.f20384b;
        if (faceCollectVM == null) {
            C14342f0.m8200S("mViewModel");
            faceCollectVM = null;
        }
        this$0.m38811T(faceCollectVM.m43955d().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static final void m38801k(FaceCollectActivity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20383a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43851m(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static final void m38800l(FaceCollectActivity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20383a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43851m(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static final void m38799m(FaceCollectActivity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20383a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43847q(context, str);
    }

    /* renamed from: y */
    private final void m38798y() {
        FaceCollectVM faceCollectVM = this.f20384b;
        if (faceCollectVM == null) {
            C14342f0.m8200S("mViewModel");
            faceCollectVM = null;
        }
        faceCollectVM.m43956c().observe(m38820B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCollectActivity.m38802j(FaceCollectActivity.this, (Integer) obj);
            }
        });
        faceCollectVM.m43954e().observe(m38820B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCollectActivity.m38801k(FaceCollectActivity.this, (String) obj);
            }
        });
        faceCollectVM.m43953f().observe(m38820B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCollectActivity.m38800l(FaceCollectActivity.this, (String) obj);
            }
        });
        faceCollectVM.m43951h().observe(m38820B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCollectActivity.m38799m(FaceCollectActivity.this, (String) obj);
            }
        });
        faceCollectVM.m43952g().observe(m38820B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCollectActivity.m38803i(FaceCollectActivity.this, (String) obj);
            }
        });
    }

    @NotNull
    /* renamed from: B */
    public final LifecycleOwner m38820B() {
        LifecycleOwner lifecycleOwner = this.f20385c;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        C14342f0.m8200S("lifecycleOwner");
        return null;
    }

    /* renamed from: F */
    public final void m38819F() {
        ProgressDialogFragment progressDialogFragment = this.f20387e;
        if (progressDialogFragment == null || progressDialogFragment == null) {
            return;
        }
        progressDialogFragment.dismiss();
    }

    @NotNull
    /* renamed from: J */
    public final FragmentManager m38818J() {
        FragmentManager fragmentManager = this.f20386d;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        C14342f0.m8200S("dialogFagmentManager");
        return null;
    }

    @Nullable
    /* renamed from: O */
    public final ProgressDialogFragment m38816O() {
        return this.f20387e;
    }

    /* renamed from: R */
    public final void m38813R(@Nullable ProgressDialogFragment progressDialogFragment) {
        this.f20387e = progressDialogFragment;
    }

    @Override // com.baidu.idl.face.platform.p049ui.FaceLivenessActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m38819F();
        m38812S(this, -1.0f);
        AppManager.m57776n().m57771s(this);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.idl.face.platform.p049ui.BaseFaceLivenessActivity
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
        m38817N(str);
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        C14342f0.m8184p(lifecycleOwner, "<set-?>");
        this.f20385c = lifecycleOwner;
    }

    /* renamed from: z */
    public final void m38797z(@NotNull FragmentManager fragmentManager) {
        C14342f0.m8184p(fragmentManager, "<set-?>");
        this.f20386d = fragmentManager;
    }
}
