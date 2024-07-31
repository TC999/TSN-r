package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBFeedBackDialog extends Dialog {

    /* renamed from: a */
    private MBAlertDialogListener f32616a;

    /* renamed from: b */
    private TextView f32617b;

    /* renamed from: c */
    private LinearLayout f32618c;

    /* renamed from: d */
    private Button f32619d;

    /* renamed from: e */
    private Button f32620e;

    /* renamed from: f */
    private int f32621f;

    /* renamed from: g */
    private int f32622g;

    public MBFeedBackDialog(Context context, MBAlertDialogListener mBAlertDialogListener) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(ResourceUtil.m21814a(context, "mbridge_cm_feedbackview", "layout"), (ViewGroup) null);
        setDialogWidthAndHeight(0.5f, 0.8f);
        this.f32616a = mBAlertDialogListener;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.f32617b = (TextView) inflate.findViewById(ResourceUtil.m21814a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e) {
                SameLogTool.m21738a("MBAlertDialog", e.getMessage());
            }
            try {
                this.f32618c = (LinearLayout) inflate.findViewById(ResourceUtil.m21814a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f32619d = (Button) inflate.findViewById(ResourceUtil.m21814a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f32620e = (Button) inflate.findViewById(ResourceUtil.m21814a(context, "mbridge_video_common_alertview_cancel_button", "id"));
            } catch (Exception e2) {
                SameLogTool.m21738a("MBAlertDialog", e2.getMessage());
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Button button = this.f32620e;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBFeedBackDialog.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.f32616a != null) {
                        MBFeedBackDialog.this.f32616a.mo20509a();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        Button button2 = this.f32619d;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBFeedBackDialog.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.f32616a != null) {
                        MBFeedBackDialog.this.f32616a.mo20508b();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.mbridge.msdk.widget.dialog.MBFeedBackDialog.3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                if (MBFeedBackDialog.this.f32616a != null) {
                    MBFeedBackDialog.this.f32616a.mo20508b();
                }
            }
        });
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public void clear() {
        if (this.f32616a != null) {
            this.f32616a = null;
        }
    }

    public MBAlertDialogListener getListener() {
        return this.f32616a;
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

    public void setCancelButtonClickable(boolean z) {
        Button button = this.f32620e;
        if (button != null) {
            button.setClickable(z);
        }
    }

    public void setCancelText(String str) {
        Button button = this.f32620e;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
        Button button = this.f32619d;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setContent(ViewGroup viewGroup) {
        LinearLayout linearLayout = this.f32618c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = SameTool.m22001b(MBSDKContext.m22865f().m22861j(), 38.0f);
            layoutParams.rightMargin = SameTool.m22001b(MBSDKContext.m22865f().m22861j(), 38.0f);
            layoutParams.topMargin = SameTool.m22001b(MBSDKContext.m22865f().m22861j(), 20.0f);
            layoutParams.bottomMargin = SameTool.m22001b(MBSDKContext.m22865f().m22861j(), 24.0f);
            this.f32618c.addView(viewGroup, layoutParams);
        }
    }

    public void setDialogWidthAndHeight(float f, float f2) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (isScreenOrientationPortrait(getContext())) {
            this.f32622g = displayMetrics.widthPixels;
            this.f32621f = displayMetrics.heightPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = (int) (this.f32621f * f2);
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
            return;
        }
        this.f32622g = displayMetrics.heightPixels;
        this.f32621f = displayMetrics.widthPixels;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.width = (int) (this.f32621f * f);
        attributes2.height = -1;
        attributes2.gravity = 17;
        getWindow().setAttributes(attributes2);
    }

    public void setListener(MBAlertDialogListener mBAlertDialogListener) {
        this.f32616a = mBAlertDialogListener;
    }

    public void setTitle(String str) {
        TextView textView = this.f32617b;
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
