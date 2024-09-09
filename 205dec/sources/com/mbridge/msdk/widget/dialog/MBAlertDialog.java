package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.widget.custom.DownloadMessageDialog;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBAlertDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private a f41292a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f41293b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f41294c;

    /* renamed from: d  reason: collision with root package name */
    private Button f41295d;

    /* renamed from: e  reason: collision with root package name */
    private Button f41296e;

    /* renamed from: f  reason: collision with root package name */
    private int f41297f;

    /* renamed from: g  reason: collision with root package name */
    private int f41298g;

    public MBAlertDialog(Context context, final a aVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(r.a(context, "mbridge_cm_alertview", "layout"), (ViewGroup) null);
        this.f41292a = aVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.f41293b = (TextView) inflate.findViewById(r.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e4) {
                x.a("MBAlertDialog", e4.getMessage());
            }
            try {
                this.f41294c = (TextView) inflate.findViewById(r.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f41295d = (Button) inflate.findViewById(r.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f41296e = (Button) inflate.findViewById(r.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
            } catch (Exception e5) {
                x.a("MBAlertDialog", e5.getMessage());
            }
        }
        Button button = this.f41296e;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBAlertDialog.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        Button button2 = this.f41295d;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBAlertDialog.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void a(String str, String str2, String str3, String str4) {
        setTitle(str);
        setContent(str2);
        setConfirmText(str3);
        setCancelText(str4);
    }

    public void clear() {
        if (this.f41292a != null) {
            this.f41292a = null;
        }
    }

    public a getListener() {
        return this.f41292a;
    }

    public void hideNavigationBar(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 19) {
                window.addFlags(TTAdConstant.KEY_CLICK_AREA);
                window.getDecorView().setSystemUiVisibility(4098);
            } else {
                window.getDecorView().setSystemUiVisibility(2);
            }
            if (i4 >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    public void makeDownloadAlert(String str) {
        setCancelable(true);
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.equals("zh")) {
            setTitle("\u63d0\u793a");
            if (TextUtils.isEmpty(str)) {
                setContent("\u786e\u8ba4\u4e0b\u8f7d\u5417\uff1f");
            } else {
                setContent("\u786e\u8ba4\u4e0b\u8f7d\"" + str + "\"\u5417\uff1f");
            }
            setConfirmText("\u53d6\u6d88");
            setCancelText("\u786e\u8ba4\u4e0b\u8f7d");
            return;
        }
        setTitle("Notification");
        if (TextUtils.isEmpty(str)) {
            setContent("Confirm to download?");
        } else {
            setContent("Confirm to download\"" + str + "\"?");
        }
        setConfirmText("Cancel");
        setCancelText("Confirm");
    }

    public void makeIVAlertView(int i4, String str) {
        try {
            Context context = getContext();
            String obj = ae.b(context, "MBridge_ConfirmTitle" + str, "").toString();
            Context context2 = getContext();
            String obj2 = ae.b(context2, "MBridge_ConfirmContent" + str, "").toString();
            Context context3 = getContext();
            String obj3 = ae.b(context3, "MBridge_CancelText" + str, "").toString();
            Context context4 = getContext();
            String obj4 = ae.b(context4, "MBridge_ConfirmText" + str, "").toString();
            if (TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj3) && TextUtils.isEmpty(obj4)) {
                String language = Locale.getDefault().getLanguage();
                if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                    setTitle(i4 == com.mbridge.msdk.foundation.same.a.f39394v ? "\u786e\u8ba4\u5173\u95ed\uff1f" : "\u63d0\u793a");
                    setContent(i4 == com.mbridge.msdk.foundation.same.a.f39394v ? "\u5982\u679c\u4f60\u9009\u62e9\u7ee7\u7eed\uff0c\u7ed3\u675f\u540e\u5c06\u4f1a\u83b7\u5f97\u5956\u52b1\u3002\u786e\u8ba4\u5173\u95ed\u5417\uff1f" : "\u5982\u679c\u4f60\u9009\u62e9\u7ee7\u7eed\uff0c\u7ed3\u675f\u540e\u5c06\u4f1a\u83b7\u5f97\u5956\u52b1\u3002\u662f\u5426\u7ee7\u7eed\uff1f");
                    setConfirmText(i4 == com.mbridge.msdk.foundation.same.a.f39394v ? "\u786e\u8ba4\u5173\u95ed" : "\u53d6\u6d88");
                    setCancelText("\u7ee7\u7eed");
                } else {
                    setTitle(i4 == com.mbridge.msdk.foundation.same.a.f39394v ? "Confirm" : "Tips");
                    setContent(i4 == com.mbridge.msdk.foundation.same.a.f39394v ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
                    setConfirmText(i4 == com.mbridge.msdk.foundation.same.a.f39394v ? "Close" : "Cancel");
                    setCancelText("Continue");
                }
            } else {
                a(obj, obj2, obj3, obj4);
            }
        } catch (Exception e4) {
            x.a("MBAlertDialog", e4.getMessage());
        }
    }

    public void makeInstallAlert(String str) {
        setCancelable(false);
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.equals("zh")) {
            setTitle("\u63d0\u793a");
            if (TextUtils.isEmpty(str)) {
                setContent("\u5e94\u7528\u5df2\u7ecf\u5b89\u88c5\u5b8c\u6210\uff0c\u662f\u5426\u73b0\u5728\u6253\u5f00\uff1f");
            } else {
                setContent(str + " \u5df2\u5b8c\u6210\u5b89\u88c5\uff0c\u662f\u5426\u73b0\u5728\u6253\u5f00\uff1f");
            }
            setConfirmText("\u53d6\u6d88");
            setCancelText("\u6253\u5f00");
            return;
        }
        setTitle("Notification");
        if (TextUtils.isEmpty(str)) {
            setContent("app has been installed. Open it right now?");
        } else {
            setContent(str + " has been installed. Open it right now?");
        }
        setConfirmText("Cancel");
        setCancelText("Open");
    }

    public void makePlayableAlertView() {
        com.mbridge.msdk.c.a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 != null) {
            a(b4.ar(), b4.as(), b4.at(), b4.av());
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.equals("zh")) {
            setTitle("\u786e\u8ba4\u5173\u95ed\uff1f");
            setContent("\u5173\u95ed\u540e\u60a8\u5c06\u4e0d\u4f1a\u83b7\u5f97\u4efb\u4f55\u5956\u52b1\u5662~ ");
            setConfirmText("\u786e\u8ba4\u5173\u95ed");
            setCancelText("\u7ee7\u7eed\u8bd5\u73a9");
            return;
        }
        setTitle("Confirm to close? ");
        setContent("You will not be rewarded after closing the window");
        setConfirmText("Close it");
        setCancelText("Continue");
    }

    public void makeRVAlertView(String str) {
        try {
            Context context = getContext();
            String obj = ae.b(context, "MBridge_ConfirmTitle" + str, "").toString();
            Context context2 = getContext();
            String obj2 = ae.b(context2, "MBridge_ConfirmContent" + str, "").toString();
            Context context3 = getContext();
            String obj3 = ae.b(context3, "MBridge_CancelText" + str, "").toString();
            Context context4 = getContext();
            String obj4 = ae.b(context4, "MBridge_ConfirmText" + str, "").toString();
            com.mbridge.msdk.c.a b4 = b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj3) && TextUtils.isEmpty(obj4)) {
                if (b4 != null) {
                    a(b4.ar(), b4.as(), b4.at(), b4.au());
                    return;
                }
                String language = Locale.getDefault().getLanguage();
                if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                    setTitle("\u786e\u8ba4\u5173\u95ed\uff1f");
                    setContent("\u5173\u95ed\u540e\u60a8\u5c06\u4e0d\u4f1a\u83b7\u5f97\u4efb\u4f55\u5956\u52b1\u5662~ ");
                    setConfirmText("\u786e\u8ba4\u5173\u95ed");
                    setCancelText("\u7ee7\u7eed\u89c2\u770b");
                    return;
                }
                setTitle("Confirm to close? ");
                setContent("You will not be rewarded after closing the window");
                setConfirmText("Close it");
                setCancelText("Continue");
                return;
            }
            String language2 = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(obj)) {
                if (b4 != null) {
                    obj = b4.ar();
                } else if (!TextUtils.isEmpty(language2) && language2.equals("zh")) {
                    setTitle("\u786e\u8ba4\u5173\u95ed\uff1f");
                } else {
                    setTitle("Confirm to close? ");
                }
            }
            if (TextUtils.isEmpty(obj2)) {
                if (b4 != null) {
                    obj2 = b4.as();
                } else if (!TextUtils.isEmpty(language2) && language2.equals("zh")) {
                    setContent("\u5173\u95ed\u540e\u60a8\u5c06\u4e0d\u4f1a\u83b7\u5f97\u4efb\u4f55\u5956\u52b1\u5662~ ");
                } else {
                    setContent("You will not be rewarded after closing the window");
                }
            }
            if (TextUtils.isEmpty(obj4)) {
                if (b4 != null) {
                    obj4 = b4.at();
                } else if (!TextUtils.isEmpty(language2) && language2.equals("zh")) {
                    setConfirmText("\u786e\u8ba4\u5173\u95ed");
                } else {
                    setConfirmText("Close it");
                }
            }
            if (TextUtils.isEmpty(obj3)) {
                if (b4 != null) {
                    obj3 = b4.au();
                } else if (!TextUtils.isEmpty(language2) && language2.equals("zh")) {
                    setCancelText("\u7ee7\u7eed\u89c2\u770b");
                } else {
                    setCancelText("Continue");
                }
            }
            a(obj, obj2, obj4, obj3);
        } catch (Exception e4) {
            x.a("MBAlertDialog", e4.getMessage());
        }
    }

    public void onlyShow() {
        super.show();
    }

    public void setCancelText(String str) {
        Button button = this.f41296e;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
        Button button = this.f41295d;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setContent(String str) {
        TextView textView = this.f41294c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setDialogWidthAndHeight(float f4, float f5) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (DownloadMessageDialog.isScreenOrientationPortrait(getContext())) {
            this.f41298g = displayMetrics.widthPixels;
            this.f41297f = displayMetrics.heightPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = (int) (this.f41297f * f5);
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
            return;
        }
        this.f41298g = displayMetrics.heightPixels;
        this.f41297f = displayMetrics.widthPixels;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.width = (int) (this.f41297f * f4);
        attributes2.height = -1;
        attributes2.gravity = 17;
        getWindow().setAttributes(attributes2);
    }

    public void setTitle(String str) {
        TextView textView = this.f41293b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            hideNavigationBar(getWindow());
            getWindow().clearFlags(8);
        } catch (Exception e4) {
            x.d("MBAlertDialog", e4.getMessage());
            super.show();
        }
    }
}
