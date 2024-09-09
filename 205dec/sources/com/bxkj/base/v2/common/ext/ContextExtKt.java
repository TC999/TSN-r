package com.bxkj.base.v2.common.ext;

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
import com.bxkj.base.R;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import l1.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContextExt.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a&\u0010\r\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b\u001a.\u0010\u0011\u001a\u00020\t*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b\u001ab\u0010\u0018\u001a\u00020\u0013*\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u000b2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0001\"\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Landroid/content/Context;", "", "message", "Lkotlin/f1;", "r", "msg", CampaignEx.JSON_KEY_AD_Q, "errorMsg", "p", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "m", "Lkotlin/Function1;", "click", "n", "title", "", "layoutId", "k", "", "Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "confirm", "cancel", "leftButtonText", "rightButtonText", "g", "Landroid/widget/Toast;", "a", "Landroid/widget/Toast;", "toast", "base_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class ContextExtKt {
    @Nullable

    /* renamed from: a */
    private static Toast f18533a;

    @NotNull
    public static final iOSTwoButtonDialog g(@NotNull Context context, @Nullable String str, @NotNull CharSequence message, @NotNull final l<? super iOSTwoButtonDialog, f1> confirm, @Nullable final l<? super iOSTwoButtonDialog, f1> lVar, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        f0.p(context, "<this>");
        f0.p(message, "message");
        f0.p(confirm, "confirm");
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
                        ContextExtKt.i(l.this, iostwobuttondialog);
                    }
                });
                iostwobuttondialog.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.base.v2.common.ext.d
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        ContextExtKt.j(l.this, iostwobuttondialog);
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

    public static /* synthetic */ iOSTwoButtonDialog h(Context context, String str, CharSequence charSequence, l lVar, l lVar2, CharSequence charSequence2, CharSequence charSequence3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "\u63d0\u793a";
        }
        String str2 = str;
        if ((i4 & 8) != 0) {
            lVar2 = null;
        }
        l lVar3 = lVar2;
        if ((i4 & 16) != 0) {
            charSequence2 = "\u53d6\u6d88";
        }
        CharSequence charSequence4 = charSequence2;
        if ((i4 & 32) != 0) {
            charSequence3 = "\u786e\u5b9a";
        }
        return g(context, str2, charSequence, lVar, lVar3, charSequence4, charSequence3);
    }

    public static final void i(l lVar, iOSTwoButtonDialog iOSTwoButtonDialog) {
        f0.p(iOSTwoButtonDialog, "$iOSTwoButtonDialog");
        if (lVar == null) {
            return;
        }
        lVar.invoke(iOSTwoButtonDialog);
    }

    public static final void j(l confirm, iOSTwoButtonDialog iOSTwoButtonDialog) {
        f0.p(confirm, "$confirm");
        f0.p(iOSTwoButtonDialog, "$iOSTwoButtonDialog");
        confirm.invoke(iOSTwoButtonDialog);
    }

    @NotNull
    public static final iOSOneButtonDialog k(@NotNull Context context, @NotNull CharSequence title, int i4, @NotNull final l<? super iOSOneButtonDialog, f1> click) {
        f0.p(context, "<this>");
        f0.p(title, "title");
        f0.p(click, "click");
        final iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iosonebuttondialog.setCenterCustomView(i4).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.ext.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContextExtKt.l(l.this, iosonebuttondialog, view);
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

    public static final void l(l click, iOSOneButtonDialog this_apply, View view) {
        f0.p(click, "$click");
        f0.p(this_apply, "$this_apply");
        click.invoke(this_apply);
    }

    @NotNull
    public static final iOSOneButtonDialog m(@NotNull Context context, @NotNull CharSequence message) {
        f0.p(context, "<this>");
        f0.p(message, "message");
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
    public static final iOSOneButtonDialog n(@NotNull Context context, @NotNull CharSequence message, @NotNull final l<? super iOSOneButtonDialog, f1> click) {
        f0.p(context, "<this>");
        f0.p(message, "message");
        f0.p(click, "click");
        final iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iosonebuttondialog.setMessage(message).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.ext.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContextExtKt.o(l.this, iosonebuttondialog, view);
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

    public static final void o(l click, iOSOneButtonDialog iOSOneButtonDialog, View view) {
        f0.p(click, "$click");
        f0.p(iOSOneButtonDialog, "$iOSOneButtonDialog");
        click.invoke(iOSOneButtonDialog);
    }

    public static final void p(@NotNull Context context, @NotNull CharSequence errorMsg) {
        f0.p(context, "<this>");
        f0.p(errorMsg, "errorMsg");
        Toast toast = new Toast(BaseApp.b());
        View inflate = View.inflate(context, R.layout.toast_ok, null);
        ((ImageView) inflate.findViewById(R.id.iv_hint)).setImageResource(R.mipmap.toast_n);
        ((TextView) inflate.findViewById(R.id.tv_msg)).setText(errorMsg);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.show();
    }

    public static final void q(@NotNull Context context, @NotNull CharSequence msg) {
        f0.p(context, "<this>");
        f0.p(msg, "msg");
        Toast toast = new Toast(BaseApp.b());
        boolean z3 = false;
        toast.setGravity(17, 0, 0);
        View inflate = View.inflate(context, R.layout.toast_ok, null);
        toast.setView(inflate);
        TextView textView = inflate == null ? null : (TextView) inflate.findViewById(R.id.tv_msg);
        if (textView != null) {
            textView.setText(msg);
        }
        toast.setDuration(1);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                z3 = true;
            }
        }
        if (!z3) {
            context = null;
        }
        if (context == null) {
            return;
        }
        toast.show();
    }

    public static final void r(@NotNull Context context, @NotNull CharSequence message) {
        f0.p(context, "<this>");
        f0.p(message, "message");
        Toast toast = f18533a;
        boolean z3 = false;
        if (toast == null) {
            toast = Toast.makeText(BaseApp.b(), message, 0);
            toast.setGravity(17, 0, 0);
            if ((context instanceof ComponentActivity ? toast : null) != null) {
                ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showToast$1$2$1
                    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
                    public final void onStop() {
                        Toast toast2;
                        toast2 = ContextExtKt.f18533a;
                        if (toast2 != null) {
                            toast2.cancel();
                        }
                        ContextExtKt.f18533a = null;
                    }
                });
            }
        }
        f18533a = toast;
        toast.setText(message);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                z3 = true;
            }
        }
        Toast toast2 = z3 ? toast : null;
        if (toast2 == null) {
            return;
        }
        toast2.show();
    }
}
