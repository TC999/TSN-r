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
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.widget.custom.DownloadMessageDialog;
import java.util.Locale;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBAlertDialog extends Dialog {

    /* renamed from: a */
    private MBAlertDialogListener f32605a;

    /* renamed from: b */
    private TextView f32606b;

    /* renamed from: c */
    private TextView f32607c;

    /* renamed from: d */
    private Button f32608d;

    /* renamed from: e */
    private Button f32609e;

    /* renamed from: f */
    private int f32610f;

    /* renamed from: g */
    private int f32611g;

    public MBAlertDialog(Context context, final MBAlertDialogListener mBAlertDialogListener) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(ResourceUtil.m21814a(context, "mbridge_cm_alertview", "layout"), (ViewGroup) null);
        this.f32605a = mBAlertDialogListener;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.f32606b = (TextView) inflate.findViewById(ResourceUtil.m21814a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e) {
                SameLogTool.m21738a("MBAlertDialog", e.getMessage());
            }
            try {
                this.f32607c = (TextView) inflate.findViewById(ResourceUtil.m21814a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f32608d = (Button) inflate.findViewById(ResourceUtil.m21814a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f32609e = (Button) inflate.findViewById(ResourceUtil.m21814a(context, "mbridge_video_common_alertview_cancel_button", "id"));
            } catch (Exception e2) {
                SameLogTool.m21738a("MBAlertDialog", e2.getMessage());
            }
        }
        Button button = this.f32609e;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBAlertDialog.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBAlertDialogListener mBAlertDialogListener2 = mBAlertDialogListener;
                    if (mBAlertDialogListener2 != null) {
                        mBAlertDialogListener2.mo20509a();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        Button button2 = this.f32608d;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBAlertDialog.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBAlertDialogListener mBAlertDialogListener2 = mBAlertDialogListener;
                    if (mBAlertDialogListener2 != null) {
                        mBAlertDialogListener2.mo20508b();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    /* renamed from: a */
    private void m20511a(String str, String str2, String str3, String str4) {
        setTitle(str);
        setContent(str2);
        setConfirmText(str3);
        setCancelText(str4);
    }

    public void clear() {
        if (this.f32605a != null) {
            this.f32605a = null;
        }
    }

    public MBAlertDialogListener getListener() {
        return this.f32605a;
    }

    public void hideNavigationBar(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                window.addFlags(67108864);
                window.getDecorView().setSystemUiVisibility(4098);
            } else {
                window.getDecorView().setSystemUiVisibility(2);
            }
            if (i >= 28) {
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
            setTitle("提示");
            if (TextUtils.isEmpty(str)) {
                setContent("确认下载吗？");
            } else {
                setContent("确认下载\"" + str + "\"吗？");
            }
            setConfirmText("取消");
            setCancelText("确认下载");
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

    public void makeIVAlertView(int i, String str) {
        try {
            Context context = getContext();
            String obj = C11400ae.m21961b(context, "MBridge_ConfirmTitle" + str, "").toString();
            Context context2 = getContext();
            String obj2 = C11400ae.m21961b(context2, "MBridge_ConfirmContent" + str, "").toString();
            Context context3 = getContext();
            String obj3 = C11400ae.m21961b(context3, "MBridge_CancelText" + str, "").toString();
            Context context4 = getContext();
            String obj4 = C11400ae.m21961b(context4, "MBridge_ConfirmText" + str, "").toString();
            if (TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj3) && TextUtils.isEmpty(obj4)) {
                String language = Locale.getDefault().getLanguage();
                if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                    setTitle(i == CommonConst.f30599v ? "确认关闭？" : "提示");
                    setContent(i == CommonConst.f30599v ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？");
                    setConfirmText(i == CommonConst.f30599v ? "确认关闭" : "取消");
                    setCancelText("继续");
                } else {
                    setTitle(i == CommonConst.f30599v ? "Confirm" : "Tips");
                    setContent(i == CommonConst.f30599v ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
                    setConfirmText(i == CommonConst.f30599v ? "Close" : "Cancel");
                    setCancelText("Continue");
                }
            } else {
                m20511a(obj, obj2, obj3, obj4);
            }
        } catch (Exception e) {
            SameLogTool.m21738a("MBAlertDialog", e.getMessage());
        }
    }

    public void makeInstallAlert(String str) {
        setCancelable(false);
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.equals("zh")) {
            setTitle("提示");
            if (TextUtils.isEmpty(str)) {
                setContent("应用已经安装完成，是否现在打开？");
            } else {
                setContent(str + " 已完成安装，是否现在打开？");
            }
            setConfirmText("取消");
            setCancelText("打开");
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
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b != null) {
            m20511a(m23252b.m23354ar(), m23252b.m23353as(), m23252b.m23352at(), m23252b.m23350av());
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.equals("zh")) {
            setTitle("确认关闭？");
            setContent("关闭后您将不会获得任何奖励噢~ ");
            setConfirmText("确认关闭");
            setCancelText("继续试玩");
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
            String obj = C11400ae.m21961b(context, "MBridge_ConfirmTitle" + str, "").toString();
            Context context2 = getContext();
            String obj2 = C11400ae.m21961b(context2, "MBridge_ConfirmContent" + str, "").toString();
            Context context3 = getContext();
            String obj3 = C11400ae.m21961b(context3, "MBridge_CancelText" + str, "").toString();
            Context context4 = getContext();
            String obj4 = C11400ae.m21961b(context4, "MBridge_ConfirmText" + str, "").toString();
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj3) && TextUtils.isEmpty(obj4)) {
                if (m23252b != null) {
                    m20511a(m23252b.m23354ar(), m23252b.m23353as(), m23252b.m23352at(), m23252b.m23351au());
                    return;
                }
                String language = Locale.getDefault().getLanguage();
                if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                    setTitle("确认关闭？");
                    setContent("关闭后您将不会获得任何奖励噢~ ");
                    setConfirmText("确认关闭");
                    setCancelText("继续观看");
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
                if (m23252b != null) {
                    obj = m23252b.m23354ar();
                } else if (!TextUtils.isEmpty(language2) && language2.equals("zh")) {
                    setTitle("确认关闭？");
                } else {
                    setTitle("Confirm to close? ");
                }
            }
            if (TextUtils.isEmpty(obj2)) {
                if (m23252b != null) {
                    obj2 = m23252b.m23353as();
                } else if (!TextUtils.isEmpty(language2) && language2.equals("zh")) {
                    setContent("关闭后您将不会获得任何奖励噢~ ");
                } else {
                    setContent("You will not be rewarded after closing the window");
                }
            }
            if (TextUtils.isEmpty(obj4)) {
                if (m23252b != null) {
                    obj4 = m23252b.m23352at();
                } else if (!TextUtils.isEmpty(language2) && language2.equals("zh")) {
                    setConfirmText("确认关闭");
                } else {
                    setConfirmText("Close it");
                }
            }
            if (TextUtils.isEmpty(obj3)) {
                if (m23252b != null) {
                    obj3 = m23252b.m23351au();
                } else if (!TextUtils.isEmpty(language2) && language2.equals("zh")) {
                    setCancelText("继续观看");
                } else {
                    setCancelText("Continue");
                }
            }
            m20511a(obj, obj2, obj4, obj3);
        } catch (Exception e) {
            SameLogTool.m21738a("MBAlertDialog", e.getMessage());
        }
    }

    public void onlyShow() {
        super.show();
    }

    public void setCancelText(String str) {
        Button button = this.f32609e;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
        Button button = this.f32608d;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setContent(String str) {
        TextView textView = this.f32607c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setDialogWidthAndHeight(float f, float f2) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (DownloadMessageDialog.isScreenOrientationPortrait(getContext())) {
            this.f32611g = displayMetrics.widthPixels;
            this.f32610f = displayMetrics.heightPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = (int) (this.f32610f * f2);
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
            return;
        }
        this.f32611g = displayMetrics.heightPixels;
        this.f32610f = displayMetrics.widthPixels;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.width = (int) (this.f32610f * f);
        attributes2.height = -1;
        attributes2.gravity = 17;
        getWindow().setAttributes(attributes2);
    }

    public void setTitle(String str) {
        TextView textView = this.f32606b;
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
        } catch (Exception e) {
            SameLogTool.m21733d("MBAlertDialog", e.getMessage());
            super.show();
        }
    }
}
