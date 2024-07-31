package cn.bluemobi.dylan.base.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.bluemobi.dylan.base.C1108R;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class iOSOneButtonDialog extends Dialog {
    private final Button btn_one;
    private boolean isClickAutoCancel;
    private final View line_title;
    private final LinearLayout ll_content;
    private final Context mContext;
    private View.OnClickListener onClickListener;
    private final TextView textView;
    private final TextView tv_title;

    public iOSOneButtonDialog(@NonNull Context context) {
        super(context, C1108R.C1116style.ios_dialog_theme);
        this.isClickAutoCancel = true;
        this.mContext = context;
        requestWindowFeature(1);
        setContentView(C1108R.C1113layout.ios_dialog_one_bt);
        getWindow().setGravity(17);
        this.ll_content = (LinearLayout) findViewById(C1108R.C1112id.ll_content);
        this.textView = (TextView) findViewById(C1108R.C1112id.text_message);
        this.tv_title = (TextView) findViewById(C1108R.C1112id.tv_title);
        Button button = (Button) findViewById(C1108R.C1112id.btn_one);
        this.btn_one = button;
        this.line_title = findViewById(C1108R.C1112id.line_title);
        button.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSOneButtonDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (iOSOneButtonDialog.this.isClickAutoCancel) {
                    iOSOneButtonDialog.this.dismiss();
                }
                if (iOSOneButtonDialog.this.onClickListener != null) {
                    iOSOneButtonDialog.this.onClickListener.onClick(view);
                }
            }
        });
    }

    public iOSOneButtonDialog setButtonOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    public iOSOneButtonDialog setCenterCustomView(int i) {
        LayoutInflater.from(getContext()).inflate(i, this.ll_content);
        return this;
    }

    public iOSOneButtonDialog setClickAutoCancel(boolean z) {
        this.isClickAutoCancel = z;
        return this;
    }

    public iOSOneButtonDialog setMessage(CharSequence charSequence) {
        this.textView.setVisibility(TextUtils.isEmpty(charSequence.toString()) ? 8 : 0);
        this.textView.setText(charSequence);
        return this;
    }

    public iOSOneButtonDialog setMessageGrivity(int i) {
        this.textView.setGravity(i);
        return this;
    }

    public iOSOneButtonDialog setOneButtonText(CharSequence charSequence) {
        this.btn_one.setText(charSequence);
        return this;
    }

    public iOSOneButtonDialog setTitle(String str) {
        this.tv_title.setText(str);
        return this;
    }

    public iOSOneButtonDialog setTitleLineVisiBility(int i) {
        this.line_title.setVisibility(i);
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            super.show();
        }
    }
}
