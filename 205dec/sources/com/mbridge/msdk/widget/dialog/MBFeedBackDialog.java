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
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.x;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBFeedBackDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private a f41303a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f41304b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f41305c;

    /* renamed from: d  reason: collision with root package name */
    private Button f41306d;

    /* renamed from: e  reason: collision with root package name */
    private Button f41307e;

    /* renamed from: f  reason: collision with root package name */
    private int f41308f;

    /* renamed from: g  reason: collision with root package name */
    private int f41309g;

    public MBFeedBackDialog(Context context, a aVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(r.a(context, "mbridge_cm_feedbackview", "layout"), (ViewGroup) null);
        setDialogWidthAndHeight(0.5f, 0.8f);
        this.f41303a = aVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.f41304b = (TextView) inflate.findViewById(r.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e4) {
                x.a("MBAlertDialog", e4.getMessage());
            }
            try {
                this.f41305c = (LinearLayout) inflate.findViewById(r.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f41306d = (Button) inflate.findViewById(r.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f41307e = (Button) inflate.findViewById(r.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
            } catch (Exception e5) {
                x.a("MBAlertDialog", e5.getMessage());
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Button button = this.f41307e;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBFeedBackDialog.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.f41303a != null) {
                        MBFeedBackDialog.this.f41303a.a();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        Button button2 = this.f41306d;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBFeedBackDialog.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.f41303a != null) {
                        MBFeedBackDialog.this.f41303a.b();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.mbridge.msdk.widget.dialog.MBFeedBackDialog.3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                if (MBFeedBackDialog.this.f41303a != null) {
                    MBFeedBackDialog.this.f41303a.b();
                }
            }
        });
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public void clear() {
        if (this.f41303a != null) {
            this.f41303a = null;
        }
    }

    public a getListener() {
        return this.f41303a;
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

    public void setCancelButtonClickable(boolean z3) {
        Button button = this.f41307e;
        if (button != null) {
            button.setClickable(z3);
        }
    }

    public void setCancelText(String str) {
        Button button = this.f41307e;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
        Button button = this.f41306d;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setContent(ViewGroup viewGroup) {
        LinearLayout linearLayout = this.f41305c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), 38.0f);
            layoutParams.rightMargin = ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), 38.0f);
            layoutParams.topMargin = ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), 20.0f);
            layoutParams.bottomMargin = ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), 24.0f);
            this.f41305c.addView(viewGroup, layoutParams);
        }
    }

    public void setDialogWidthAndHeight(float f4, float f5) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (isScreenOrientationPortrait(getContext())) {
            this.f41309g = displayMetrics.widthPixels;
            this.f41308f = displayMetrics.heightPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = (int) (this.f41308f * f5);
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
            return;
        }
        this.f41309g = displayMetrics.heightPixels;
        this.f41308f = displayMetrics.widthPixels;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.width = (int) (this.f41308f * f4);
        attributes2.height = -1;
        attributes2.gravity = 17;
        getWindow().setAttributes(attributes2);
    }

    public void setListener(a aVar) {
        this.f41303a = aVar;
    }

    public void setTitle(String str) {
        TextView textView = this.f41304b;
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
