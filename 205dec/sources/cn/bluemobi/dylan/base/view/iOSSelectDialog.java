package cn.bluemobi.dylan.base.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.bluemobi.dylan.base.R;
import cn.bluemobi.dylan.base.utils.u;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class iOSSelectDialog extends Dialog {
    private final Button btn_one;
    private final LinearLayout ll_content;
    private MenuClick menuClick;
    private View.OnClickListener onClickListener;
    private final TextView tv_title;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface MenuClick {
        void onMenuClick(String str);
    }

    public iOSSelectDialog(@NonNull Context context) {
        super(context, R.style.ios_dialog_theme);
        requestWindowFeature(1);
        setContentView(R.layout.ios_dialog_select);
        getWindow().setGravity(17);
        this.ll_content = (LinearLayout) findViewById(R.id.ll_content);
        this.tv_title = (TextView) findViewById(R.id.tv_title);
        Button button = (Button) findViewById(R.id.btn_one);
        this.btn_one = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSSelectDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                iOSSelectDialog.this.dismiss();
                if (iOSSelectDialog.this.onClickListener != null) {
                    iOSSelectDialog.this.onClickListener.onClick(view);
                }
            }
        });
    }

    public iOSSelectDialog addMenuText(final String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#2C7AD7"));
        textView.setTextSize(2, 18.0f);
        textView.setGravity(17);
        textView.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.iOSSelectDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                iOSSelectDialog.this.dismiss();
                if (iOSSelectDialog.this.menuClick != null) {
                    iOSSelectDialog.this.menuClick.onMenuClick(str);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, u.a(40.0f, getContext()));
        textView.setLayoutParams(layoutParams);
        this.ll_content.addView(textView, layoutParams);
        return this;
    }

    public iOSSelectDialog addMenuTexts(List<String> list) {
        if (list != null) {
            for (String str : list) {
                addMenuText(str);
            }
        }
        return this;
    }

    public iOSSelectDialog setButtonOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    public iOSSelectDialog setCenterCustomView(int i4) {
        LayoutInflater.from(getContext()).inflate(i4, this.ll_content);
        return this;
    }

    public iOSSelectDialog setMenuClickLisentner(MenuClick menuClick) {
        this.menuClick = menuClick;
        return this;
    }

    public iOSSelectDialog setOneButtonText(CharSequence charSequence) {
        this.btn_one.setText(charSequence);
        return this;
    }

    public iOSSelectDialog setTitle(String str) {
        this.tv_title.setText(str);
        return this;
    }
}
