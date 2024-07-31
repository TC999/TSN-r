package com.baidu.idl.face.platform.p049ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.annotation.NonNull;
import com.baidu.idl.face.platform.p049ui.C2505R;
import com.baidu.idl.face.platform.utils.DensityUtils;

/* renamed from: com.baidu.idl.face.platform.ui.widget.TimeoutDialog */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TimeoutDialog extends Dialog implements View.OnClickListener {
    private Context mContext;
    private OnTimeoutDialogClickListener mOnTimeoutDialogClickListener;

    /* renamed from: com.baidu.idl.face.platform.ui.widget.TimeoutDialog$OnTimeoutDialogClickListener */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnTimeoutDialogClickListener {
        void onRecollect();

        void onReturn();
    }

    public TimeoutDialog(@NonNull Context context) {
        super(context, C2505R.C2512style.DefaultDialog);
        this.mContext = context;
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(C2505R.C2510layout.dialog_time_out, (ViewGroup) null);
        setContentView(inflate);
        Window window = getWindow();
        window.setGravity(1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = DensityUtils.dip2px(getContext(), DensityUtils.px2dip(getContext(), DensityUtils.getDisplayWidth(getContext())) - 40);
        attributes.height = -2;
        window.setAttributes(attributes);
        ((Button) inflate.findViewById(C2505R.C2508id.btn_dialog_recollect)).setOnClickListener(this);
        ((Button) inflate.findViewById(C2505R.C2508id.btn_dialog_return)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnTimeoutDialogClickListener onTimeoutDialogClickListener;
        int id = view.getId();
        if (id == C2505R.C2508id.btn_dialog_recollect) {
            OnTimeoutDialogClickListener onTimeoutDialogClickListener2 = this.mOnTimeoutDialogClickListener;
            if (onTimeoutDialogClickListener2 != null) {
                onTimeoutDialogClickListener2.onRecollect();
            }
        } else if (id != C2505R.C2508id.btn_dialog_return || (onTimeoutDialogClickListener = this.mOnTimeoutDialogClickListener) == null) {
        } else {
            onTimeoutDialogClickListener.onReturn();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void setDialogListener(OnTimeoutDialogClickListener onTimeoutDialogClickListener) {
        this.mOnTimeoutDialogClickListener = onTimeoutDialogClickListener;
    }
}
