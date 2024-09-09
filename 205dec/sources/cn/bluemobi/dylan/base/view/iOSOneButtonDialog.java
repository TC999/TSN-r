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
import cn.bluemobi.dylan.base.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
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
        super(context, R.style.ios_dialog_theme);
        this.isClickAutoCancel = true;
        this.mContext = context;
        requestWindowFeature(1);
        setContentView(R.layout.ios_dialog_one_bt);
        getWindow().setGravity(17);
        this.ll_content = (LinearLayout) findViewById(R.id.ll_content);
        this.textView = (TextView) findViewById(R.id.text_message);
        this.tv_title = (TextView) findViewById(R.id.tv_title);
        Button button = (Button) findViewById(R.id.btn_one);
        this.btn_one = button;
        this.line_title = findViewById(R.id.line_title);
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

    public iOSOneButtonDialog setCenterCustomView(int i4) {
        LayoutInflater.from(getContext()).inflate(i4, this.ll_content);
        return this;
    }

    public iOSOneButtonDialog setClickAutoCancel(boolean z3) {
        this.isClickAutoCancel = z3;
        return this;
    }

    public iOSOneButtonDialog setMessage(CharSequence charSequence) {
        this.textView.setVisibility(TextUtils.isEmpty(charSequence.toString()) ? 8 : 0);
        this.textView.setText(charSequence);
        return this;
    }

    public iOSOneButtonDialog setMessageGrivity(int i4) {
        this.textView.setGravity(i4);
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

    public iOSOneButtonDialog setTitleLineVisiBility(int i4) {
        this.line_title.setVisibility(i4);
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
