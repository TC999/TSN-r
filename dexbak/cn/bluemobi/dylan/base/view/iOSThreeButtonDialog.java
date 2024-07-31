package cn.bluemobi.dylan.base.view;

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
public class iOSThreeButtonDialog extends Dialog {
    private final Button btn_one;
    private final Button btn_three;
    private final Button btn_two;
    private CenterButtonOnClick centerButtonOnClick;
    private boolean isClickAutoCancel;
    private LeftButtonOnClick lefttButtonOnClick;
    private final View line_title;
    private final LinearLayout ll_content;
    private RightButtonOnClick rightButtonOnClick;
    private final TextView textView;
    private final TextView tv_title;

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface CenterButtonOnClick {
        void buttonCenterOnClick();
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface LeftButtonOnClick {
        void buttonLeftOnClick();
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface RightButtonOnClick {
        void buttonRightOnClick();
    }

    public iOSThreeButtonDialog(@NonNull Context context) {
        super(context, C1108R.C1116style.ios_dialog_theme);
        this.isClickAutoCancel = true;
        requestWindowFeature(1);
        setContentView(C1108R.C1113layout.ios_dialog_three_bt);
        getWindow().setGravity(17);
        this.ll_content = (LinearLayout) findViewById(C1108R.C1112id.ll_content);
        this.textView = (TextView) findViewById(C1108R.C1112id.text_message);
        this.tv_title = (TextView) findViewById(C1108R.C1112id.tv_title);
        Button button = (Button) findViewById(C1108R.C1112id.btn_one);
        this.btn_one = button;
        Button button2 = (Button) findViewById(C1108R.C1112id.btn_two);
        this.btn_two = button2;
        Button button3 = (Button) findViewById(C1108R.C1112id.btn_three);
        this.btn_three = button3;
        this.line_title = findViewById(C1108R.C1112id.line_title);
        button.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSThreeButtonDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (iOSThreeButtonDialog.this.isClickAutoCancel) {
                    iOSThreeButtonDialog.this.dismiss();
                }
                if (iOSThreeButtonDialog.this.lefttButtonOnClick != null) {
                    iOSThreeButtonDialog.this.lefttButtonOnClick.buttonLeftOnClick();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSThreeButtonDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (iOSThreeButtonDialog.this.isClickAutoCancel) {
                    iOSThreeButtonDialog.this.dismiss();
                }
                if (iOSThreeButtonDialog.this.centerButtonOnClick != null) {
                    iOSThreeButtonDialog.this.centerButtonOnClick.buttonCenterOnClick();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSThreeButtonDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (iOSThreeButtonDialog.this.isClickAutoCancel) {
                    iOSThreeButtonDialog.this.dismiss();
                }
                if (iOSThreeButtonDialog.this.rightButtonOnClick != null) {
                    iOSThreeButtonDialog.this.rightButtonOnClick.buttonRightOnClick();
                }
            }
        });
    }

    public iOSThreeButtonDialog setCenterButtonOnClick(CenterButtonOnClick centerButtonOnClick) {
        this.centerButtonOnClick = centerButtonOnClick;
        return this;
    }

    public iOSThreeButtonDialog setCenterButtonText(CharSequence charSequence) {
        this.btn_two.setText(charSequence);
        return this;
    }

    public iOSThreeButtonDialog setCenterCustomView(int i) {
        LayoutInflater.from(getContext()).inflate(i, this.ll_content);
        return this;
    }

    public iOSThreeButtonDialog setClickAutoCancel(boolean z) {
        this.isClickAutoCancel = z;
        return this;
    }

    public iOSThreeButtonDialog setLeftButtonOnClickListener(LeftButtonOnClick leftButtonOnClick) {
        this.lefttButtonOnClick = leftButtonOnClick;
        return this;
    }

    public iOSThreeButtonDialog setLeftButtonText(CharSequence charSequence) {
        this.btn_one.setText(charSequence);
        return this;
    }

    public iOSThreeButtonDialog setMessage(CharSequence charSequence) {
        this.textView.setVisibility(TextUtils.isEmpty(charSequence.toString()) ? 8 : 0);
        this.textView.setText(charSequence);
        return this;
    }

    public iOSThreeButtonDialog setMessageGrivity(int i) {
        this.textView.setGravity(i);
        return this;
    }

    public iOSThreeButtonDialog setRightButtonOnClickListener(RightButtonOnClick rightButtonOnClick) {
        this.rightButtonOnClick = rightButtonOnClick;
        return this;
    }

    public iOSThreeButtonDialog setRightButtonText(CharSequence charSequence) {
        this.btn_three.setText(charSequence);
        return this;
    }

    public iOSThreeButtonDialog setTitle(String str) {
        this.tv_title.setText(str);
        return this;
    }

    public iOSThreeButtonDialog setTitleLineVisiBility(int i) {
        this.line_title.setVisibility(i);
        return this;
    }
}
