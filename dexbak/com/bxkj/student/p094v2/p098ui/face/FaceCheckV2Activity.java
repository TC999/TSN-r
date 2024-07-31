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
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.baidu.idl.face.platform.p049ui.BaseFaceDetectActivity;
import com.bxkj.base.p085v2.base.ProgressDialogFragment;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.FileUtils;
import com.bxkj.base.p085v2.http.exception.ApiException;
import com.bxkj.student.p094v2.p103vm.face.FaceCheckVM;
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
import p617l1.InterfaceC15280l;

/* compiled from: FaceCheckV2Activity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 92\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0014\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006:"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/face/FaceCheckV2Activity;", "Lcom/baidu/idl/face/platform/ui/BaseFaceDetectActivity;", "Lkotlin/f1;", "Q", "", "base64ImageMap", "O", "R", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "", "brightness", ExifInterface.GPS_DIRECTION_TRUE, "y", "message", "U", "F", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "bmpStr", "onFace", "onDestroy", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "Lcom/bxkj/student/v2/vm/face/FaceCheckVM;", "b", "Lcom/bxkj/student/v2/vm/face/FaceCheckVM;", "mViewModel", "Landroidx/lifecycle/LifecycleOwner;", "c", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "d", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", UMCommonContent.f37777aG, "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "e", "Lcom/bxkj/base/v2/base/ProgressDialogFragment;", "P", "()Lcom/bxkj/base/v2/base/ProgressDialogFragment;", ExifInterface.LATITUDE_SOUTH, "(Lcom/bxkj/base/v2/base/ProgressDialogFragment;)V", "mDialogFragment", "<init>", "()V", "f", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.face.FaceCheckV2Activity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FaceCheckV2Activity extends BaseFaceDetectActivity {
    @NotNull

    /* renamed from: f */
    public static final C5607a f20369f;

    /* renamed from: g */
    public static final int f20370g = 170;

    /* renamed from: a */
    private Context f20371a;

    /* renamed from: b */
    private FaceCheckVM f20372b;

    /* renamed from: c */
    public LifecycleOwner f20373c;

    /* renamed from: d */
    public FragmentManager f20374d;
    @Nullable

    /* renamed from: e */
    private ProgressDialogFragment f20375e;

    /* compiled from: FaceCheckV2Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/face/FaceCheckV2Activity$a;", "", "", "RESULT_FAILD", "I", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceCheckV2Activity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5607a {
        private C5607a() {
        }

        public /* synthetic */ C5607a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FaceCheckV2Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceCheckV2Activity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5608b extends Lambda implements InterfaceC15280l<iOSOneButtonDialog, Unit> {
        C5608b() {
            super(1);
        }

        /* renamed from: a */
        public final void m38823a(@NotNull iOSOneButtonDialog it) {
            C14342f0.m8184p(it, "it");
            FaceCheckV2Activity.this.m38841R();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSOneButtonDialog iosonebuttondialog) {
            m38823a(iosonebuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FaceCheckV2Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/base/v2/http/exception/ApiException;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceCheckV2Activity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5609c extends Lambda implements InterfaceC15280l<ApiException, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FaceCheckV2Activity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.face.FaceCheckV2Activity$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5610a extends Lambda implements InterfaceC15280l<iOSOneButtonDialog, Unit> {

            /* renamed from: a */
            final /* synthetic */ Integer f20378a;

            /* renamed from: b */
            final /* synthetic */ FaceCheckV2Activity f20379b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5610a(Integer num, FaceCheckV2Activity faceCheckV2Activity) {
                super(1);
                this.f20378a = num;
                this.f20379b = faceCheckV2Activity;
            }

            /* renamed from: a */
            public final void m38821a(@NotNull iOSOneButtonDialog it) {
                C14342f0.m8184p(it, "it");
                Intent intent = new Intent();
                intent.putExtra("code", this.f20378a);
                this.f20379b.setResult(-1, intent);
                this.f20379b.finish();
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(iOSOneButtonDialog iosonebuttondialog) {
                m38821a(iosonebuttondialog);
                return Unit.f41048a;
            }
        }

        C5609c() {
            super(1);
        }

        /* renamed from: a */
        public final void m38822a(@NotNull ApiException it) {
            C14342f0.m8184p(it, "it");
            Integer code = it.getCode();
            Integer code2 = it.getCode();
            if (code2 != null && code2.intValue() == 0) {
                ContextExt.m43847q(FaceCheckV2Activity.this, String.valueOf(it.getMessage()));
                Intent intent = new Intent();
                intent.putExtra("code", code);
                FaceCheckV2Activity.this.setResult(-1, intent);
                FaceCheckV2Activity.this.finish();
                return;
            }
            ContextExt.m43850n(FaceCheckV2Activity.this, String.valueOf(it.getMessage()), new C5610a(code, FaceCheckV2Activity.this));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(ApiException apiException) {
            m38822a(apiException);
            return Unit.f41048a;
        }
    }

    /* compiled from: FaceCheckV2Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, m12616d2 = {"com/bxkj/student/v2/ui/face/FaceCheckV2Activity$d", "Lcom/baidu/idl/face/platform/listener/IInitCallback;", "Lkotlin/f1;", "initSuccess", "", "i", "", "s", "initFailure", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceCheckV2Activity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5611d implements IInitCallback {
        C5611d() {
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

    /* compiled from: FaceCheckV2Activity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/student/v2/ui/face/FaceCheckV2Activity$e", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.face.FaceCheckV2Activity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class DialogInterface$OnKeyListenerC5612e implements DialogInterface.OnKeyListener {
        DialogInterface$OnKeyListenerC5612e() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(@Nullable DialogInterface dialogInterface, int i, @Nullable KeyEvent keyEvent) {
            if (i == 4) {
                ProgressDialogFragment m38843P = FaceCheckV2Activity.this.m38843P();
                if (m38843P != null) {
                    m38843P.dismiss();
                }
                FaceCheckVM faceCheckVM = FaceCheckV2Activity.this.f20372b;
                if (faceCheckVM == null) {
                    C14342f0.m8200S("mViewModel");
                    faceCheckVM = null;
                }
                Job m43957b = faceCheckVM.m43957b();
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
        StubApp.interface11(12464);
        f20369f = new C5607a(null);
    }

    /* renamed from: F */
    private final void m38847F() {
        ProgressDialogFragment progressDialogFragment = this.f20375e;
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
    /* renamed from: N */
    public static final void m38845N(FaceCheckV2Activity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20371a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43847q(context, str);
    }

    /* renamed from: O */
    private final void m38844O(String str) {
        File file;
        FaceCheckVM faceCheckVM = null;
        if (C14342f0.m8193g("mounted", Environment.getExternalStorageState())) {
            Context context = this.f20371a;
            if (context == null) {
                C14342f0.m8200S("mContext");
                context = null;
            }
            file = context.getExternalCacheDir();
        } else {
            file = null;
        }
        if (file == null || !file.exists()) {
            Context context2 = this.f20371a;
            if (context2 == null) {
                C14342f0.m8200S("mContext");
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
            FileUtils.C3962a c3962a = FileUtils.f15115a;
            String path = file3.getPath();
            C14342f0.m8185o(path, "avatar.path");
            File m43802a = c3962a.m43802a(str, path);
            FaceCheckVM faceCheckVM2 = this.f20372b;
            if (faceCheckVM2 == null) {
                C14342f0.m8200S("mViewModel");
            } else {
                faceCheckVM = faceCheckVM2;
            }
            faceCheckVM.m38119t(m43802a, new C5609c());
        }
    }

    /* renamed from: Q */
    private final void m38842Q() {
        if (FaceSDKManager.getInstance().getInitFlag()) {
            return;
        }
        FaceSDKManager.getInstance().initialize(this, C5232a.f19112a, C5232a.f19113b, new C5611d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public final void m38841R() {
        setResult(170, getIntent());
        finish();
    }

    /* renamed from: T */
    private final void m38839T(Activity activity, float f) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f;
        window.setAttributes(attributes);
    }

    /* renamed from: U */
    private final void m38838U(String str) {
        if (this.f20375e == null) {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment(str);
            this.f20375e = progressDialogFragment;
            progressDialogFragment.m43938c(new DialogInterface$OnKeyListenerC5612e());
        }
        ProgressDialogFragment progressDialogFragment2 = this.f20375e;
        if (progressDialogFragment2 == null) {
            return;
        }
        progressDialogFragment2.m43936e(m38846J(), str, true);
    }

    /* renamed from: V */
    static /* synthetic */ void m38837V(FaceCheckV2Activity faceCheckV2Activity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "loading...";
        }
        faceCheckV2Activity.m38838U(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final void m38829j(FaceCheckV2Activity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20371a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43848p(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static final void m38828k(FaceCheckV2Activity this$0, Integer it) {
        C14342f0.m8184p(this$0, "this$0");
        C14342f0.m8185o(it, "it");
        if (it.intValue() <= 0) {
            this$0.m38847F();
            return;
        }
        FaceCheckVM faceCheckVM = this$0.f20372b;
        if (faceCheckVM == null) {
            C14342f0.m8200S("mViewModel");
            faceCheckVM = null;
        }
        this$0.m38838U(faceCheckVM.m43955d().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static final void m38827l(FaceCheckV2Activity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20371a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43850n(context, str, new C5608b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static final void m38826m(FaceCheckV2Activity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        Context context = this$0.f20371a;
        if (context == null) {
            C14342f0.m8200S("mContext");
            context = null;
        }
        ContextExt.m43851m(context, str);
    }

    /* renamed from: y */
    private final void m38825y() {
        FaceCheckVM faceCheckVM = this.f20372b;
        if (faceCheckVM == null) {
            C14342f0.m8200S("mViewModel");
            faceCheckVM = null;
        }
        faceCheckVM.m43956c().observe(m38848B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCheckV2Activity.m38828k(FaceCheckV2Activity.this, (Integer) obj);
            }
        });
        faceCheckVM.m43954e().observe(m38848B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCheckV2Activity.m38827l(FaceCheckV2Activity.this, (String) obj);
            }
        });
        faceCheckVM.m43953f().observe(m38848B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCheckV2Activity.m38826m(FaceCheckV2Activity.this, (String) obj);
            }
        });
        faceCheckVM.m43951h().observe(m38848B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCheckV2Activity.m38845N(FaceCheckV2Activity.this, (String) obj);
            }
        });
        faceCheckVM.m43952g().observe(m38848B(), new Observer() { // from class: com.bxkj.student.v2.ui.face.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FaceCheckV2Activity.m38829j(FaceCheckV2Activity.this, (String) obj);
            }
        });
    }

    @NotNull
    /* renamed from: B */
    public final LifecycleOwner m38848B() {
        LifecycleOwner lifecycleOwner = this.f20373c;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        C14342f0.m8200S("lifecycleOwner");
        return null;
    }

    @NotNull
    /* renamed from: J */
    public final FragmentManager m38846J() {
        FragmentManager fragmentManager = this.f20374d;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        C14342f0.m8200S("dialogFagmentManager");
        return null;
    }

    @Nullable
    /* renamed from: P */
    public final ProgressDialogFragment m38843P() {
        return this.f20375e;
    }

    /* renamed from: S */
    public final void m38840S(@Nullable ProgressDialogFragment progressDialogFragment) {
        this.f20375e = progressDialogFragment;
    }

    @Override // com.baidu.idl.face.platform.p049ui.FaceDetectActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m38847F();
        m38839T(this, -1.0f);
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
        m38844O(str);
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        C14342f0.m8184p(lifecycleOwner, "<set-?>");
        this.f20373c = lifecycleOwner;
    }

    /* renamed from: z */
    public final void m38824z(@NotNull FragmentManager fragmentManager) {
        C14342f0.m8184p(fragmentManager, "<set-?>");
        this.f20374d = fragmentManager;
    }
}
