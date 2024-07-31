package com.bxkj.base.p085v2.common.ext;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.BaseApp;
import com.bxkj.base.C3801R;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a&\u0010\r\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b\u001a.\u0010\u0011\u001a\u00020\t*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b\u001ab\u0010\u0018\u001a\u00020\u0013*\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u000b2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0001\"\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, m12616d2 = {"Landroid/content/Context;", "", "message", "Lkotlin/f1;", "r", "msg", CampaignEx.JSON_KEY_AD_Q, MediationConstant.KEY_ERROR_MSG, "p", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "m", "Lkotlin/Function1;", CampaignEx.JSON_NATIVE_VIDEO_CLICK, "n", "title", "", "layoutId", "k", "", "Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "confirm", CommonNetImpl.CANCEL, "leftButtonText", "rightButtonText", "g", "Landroid/widget/Toast;", "a", "Landroid/widget/Toast;", "toast", "base_release"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.ext.ContextExtKt */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ContextExt {
    @Nullable

    /* renamed from: a */
    private static Toast f15045a;

    @NotNull
    /* renamed from: g */
    public static final iOSTwoButtonDialog m43857g(@NotNull Context context, @Nullable String str, @NotNull CharSequence message, @NotNull final InterfaceC15280l<? super iOSTwoButtonDialog, Unit> confirm, @Nullable final InterfaceC15280l<? super iOSTwoButtonDialog, Unit> interfaceC15280l, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        C14342f0.m8184p(context, "<this>");
        C14342f0.m8184p(message, "message");
        C14342f0.m8184p(confirm, "confirm");
        final iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iostwobuttondialog.setTitle(str);
                iostwobuttondialog.setMessage(message);
                iostwobuttondialog.setLeftButtonText(charSequence);
                iostwobuttondialog.setRightButtonText(charSequence2);
                iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.base.v2.common.ext.c
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                    public final void buttonLeftOnClick() {
                        ContextExt.m43855i(InterfaceC15280l.this, iostwobuttondialog);
                    }
                });
                iostwobuttondialog.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.base.v2.common.ext.d
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        ContextExt.m43854j(InterfaceC15280l.this, iostwobuttondialog);
                    }
                });
                iostwobuttondialog.show();
                if (context instanceof ComponentActivity) {
                    ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showAlertConfirmDialog$2
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            iOSTwoButtonDialog.this.dismiss();
                        }
                    });
                }
            }
        }
        return iostwobuttondialog;
    }

    /* renamed from: h */
    public static /* synthetic */ iOSTwoButtonDialog m43856h(Context context, String str, CharSequence charSequence, InterfaceC15280l interfaceC15280l, InterfaceC15280l interfaceC15280l2, CharSequence charSequence2, CharSequence charSequence3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "提示";
        }
        String str2 = str;
        if ((i & 8) != 0) {
            interfaceC15280l2 = null;
        }
        InterfaceC15280l interfaceC15280l3 = interfaceC15280l2;
        if ((i & 16) != 0) {
            charSequence2 = "取消";
        }
        CharSequence charSequence4 = charSequence2;
        if ((i & 32) != 0) {
            charSequence3 = "确定";
        }
        return m43857g(context, str2, charSequence, interfaceC15280l, interfaceC15280l3, charSequence4, charSequence3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static final void m43855i(InterfaceC15280l interfaceC15280l, iOSTwoButtonDialog iOSTwoButtonDialog) {
        C14342f0.m8184p(iOSTwoButtonDialog, "$iOSTwoButtonDialog");
        if (interfaceC15280l == null) {
            return;
        }
        interfaceC15280l.invoke(iOSTwoButtonDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final void m43854j(InterfaceC15280l confirm, iOSTwoButtonDialog iOSTwoButtonDialog) {
        C14342f0.m8184p(confirm, "$confirm");
        C14342f0.m8184p(iOSTwoButtonDialog, "$iOSTwoButtonDialog");
        confirm.invoke(iOSTwoButtonDialog);
    }

    @NotNull
    /* renamed from: k */
    public static final iOSOneButtonDialog m43853k(@NotNull Context context, @NotNull CharSequence title, int i, @NotNull final InterfaceC15280l<? super iOSOneButtonDialog, Unit> click) {
        C14342f0.m8184p(context, "<this>");
        C14342f0.m8184p(title, "title");
        C14342f0.m8184p(click, "click");
        final iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iosonebuttondialog.setCenterCustomView(i).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.ext.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContextExt.m43852l(InterfaceC15280l.this, iosonebuttondialog, view);
                    }
                });
                iosonebuttondialog.setTitle(title);
                iosonebuttondialog.show();
                if (context instanceof ComponentActivity) {
                    ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showAlertCustomDialog$2
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            iOSOneButtonDialog.this.dismiss();
                        }
                    });
                }
            }
        }
        return iosonebuttondialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static final void m43852l(InterfaceC15280l click, iOSOneButtonDialog this_apply, View view) {
        C14342f0.m8184p(click, "$click");
        C14342f0.m8184p(this_apply, "$this_apply");
        click.invoke(this_apply);
    }

    @NotNull
    /* renamed from: m */
    public static final iOSOneButtonDialog m43851m(@NotNull Context context, @NotNull CharSequence message) {
        C14342f0.m8184p(context, "<this>");
        C14342f0.m8184p(message, "message");
        final iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iosonebuttondialog.setMessage(message);
                iosonebuttondialog.show();
                if (context instanceof ComponentActivity) {
                    ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showAlertDialog$2
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            iOSOneButtonDialog.this.dismiss();
                        }
                    });
                }
            }
        }
        return iosonebuttondialog;
    }

    @NotNull
    /* renamed from: n */
    public static final iOSOneButtonDialog m43850n(@NotNull Context context, @NotNull CharSequence message, @NotNull final InterfaceC15280l<? super iOSOneButtonDialog, Unit> click) {
        C14342f0.m8184p(context, "<this>");
        C14342f0.m8184p(message, "message");
        C14342f0.m8184p(click, "click");
        final iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iosonebuttondialog.setMessage(message).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.ext.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContextExt.m43849o(InterfaceC15280l.this, iosonebuttondialog, view);
                    }
                }).show();
                if (context instanceof ComponentActivity) {
                    ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showAlertDialog$5
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            iOSOneButtonDialog.this.dismiss();
                        }
                    });
                }
            }
        }
        return iosonebuttondialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static final void m43849o(InterfaceC15280l click, iOSOneButtonDialog iOSOneButtonDialog, View view) {
        C14342f0.m8184p(click, "$click");
        C14342f0.m8184p(iOSOneButtonDialog, "$iOSOneButtonDialog");
        click.invoke(iOSOneButtonDialog);
    }

    /* renamed from: p */
    public static final void m43848p(@NotNull Context context, @NotNull CharSequence errorMsg) {
        C14342f0.m8184p(context, "<this>");
        C14342f0.m8184p(errorMsg, "errorMsg");
        Toast toast = new Toast(BaseApp.m44341b());
        View inflate = View.inflate(context, C3801R.C3807layout.toast_ok, null);
        ((ImageView) inflate.findViewById(C3801R.C3805id.iv_hint)).setImageResource(C3801R.mipmap.toast_n);
        ((TextView) inflate.findViewById(C3801R.C3805id.tv_msg)).setText(errorMsg);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.show();
    }

    /* renamed from: q */
    public static final void m43847q(@NotNull Context context, @NotNull CharSequence msg) {
        C14342f0.m8184p(context, "<this>");
        C14342f0.m8184p(msg, "msg");
        Toast toast = new Toast(BaseApp.m44341b());
        boolean z = false;
        toast.setGravity(17, 0, 0);
        View inflate = View.inflate(context, C3801R.C3807layout.toast_ok, null);
        toast.setView(inflate);
        TextView textView = inflate == null ? null : (TextView) inflate.findViewById(C3801R.C3805id.tv_msg);
        if (textView != null) {
            textView.setText(msg);
        }
        toast.setDuration(1);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                z = true;
            }
        }
        if (!z) {
            context = null;
        }
        if (context == null) {
            return;
        }
        toast.show();
    }

    /* renamed from: r */
    public static final void m43846r(@NotNull Context context, @NotNull CharSequence message) {
        C14342f0.m8184p(context, "<this>");
        C14342f0.m8184p(message, "message");
        Toast toast = f15045a;
        boolean z = false;
        if (toast == null) {
            toast = Toast.makeText(BaseApp.m44341b(), message, 0);
            toast.setGravity(17, 0, 0);
            if ((context instanceof ComponentActivity ? toast : null) != null) {
                ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showToast$1$2$1
                    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
                    public final void onStop() {
                        Toast toast2;
                        toast2 = ContextExt.f15045a;
                        if (toast2 != null) {
                            toast2.cancel();
                        }
                        ContextExt.f15045a = null;
                    }
                });
            }
        }
        f15045a = toast;
        toast.setText(message);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                z = true;
            }
        }
        Toast toast2 = z ? toast : null;
        if (toast2 == null) {
            return;
        }
        toast2.show();
    }
}
