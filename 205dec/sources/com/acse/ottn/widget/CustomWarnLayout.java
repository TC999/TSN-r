package com.acse.ottn.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.activity.AcseHelpManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CustomWarnLayout extends LinearLayout {
    private RelativeLayout sncakbar_relativeLayout;
    private TextView textView;
    private TextView tv_look;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6959a;

        public a(Activity activity) {
            this.f6959a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f6959a, 10010);
        }
    }

    public CustomWarnLayout(Context context) {
        super(context);
    }

    private void initView() {
        if (AcseHelpManager.isOPenPermission()) {
            this.sncakbar_relativeLayout.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        this.sncakbar_relativeLayout.setBackgroundResource(i4);
    }

    public void setButtonBackgroundResource(int i4) {
        this.tv_look.setBackgroundResource(i4);
    }

    public void setButtonPadding(int i4, int i5, int i6, int i7) {
        this.tv_look.setPadding(i4, i5, i6, i7);
    }

    public void setButtonText(String str) {
        this.tv_look.setText(str);
    }

    public void setButtonTextSize(float f4) {
        this.tv_look.setTextSize(f4);
    }

    public void setContentText(String str) {
        this.textView.setText(str);
    }

    public void setContentTextSize(float f4) {
        this.textView.setTextSize(f4);
    }

    public void setOnClickListener(Activity activity) {
        this.sncakbar_relativeLayout.setOnClickListener(new a(activity));
        invalidate();
    }

    public CustomWarnLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.my_seeding_snackbar, (ViewGroup) this, true);
        this.textView = (TextView) findViewById(R.id.tv_content);
        this.sncakbar_relativeLayout = (RelativeLayout) findViewById(R.id.sncakbar_relativeLayout);
        this.tv_look = (TextView) findViewById(R.id.tv_look);
        initView();
        invalidate();
    }

    public CustomWarnLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
