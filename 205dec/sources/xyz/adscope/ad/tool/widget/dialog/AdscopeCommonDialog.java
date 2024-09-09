package xyz.adscope.ad.tool.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import xyz.adscope.ad.R;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdscopeCommonDialog extends Dialog {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {
        private TextView cancelTv;
        private TextView confirmTv;
        private TextView contentTv;
        private CustomDialogCallBack mCustomDialogCallBack;
        private AdscopeCommonDialog mDialog;
        private View mLayout;
        private TextView titleTv;

        public Builder(Context context) {
            this.mDialog = new AdscopeCommonDialog(context, R.style.adscope_custom_dialog);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.adscope_custom_dialog, (ViewGroup) null, false);
            this.mLayout = inflate;
            this.mDialog.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            this.titleTv = (TextView) this.mLayout.findViewById(R.id.adscope_custom_dialog_title_tv);
            this.contentTv = (TextView) this.mLayout.findViewById(R.id.adscope_custom_dialog_content_tv);
            this.cancelTv = (TextView) this.mLayout.findViewById(R.id.adscope_custom_dialog_cancel_tv);
            this.confirmTv = (TextView) this.mLayout.findViewById(R.id.adscope_custom_dialog_confirm_tv);
        }

        public AdscopeCommonDialog create() {
            this.cancelTv.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.AdscopeCommonDialog.Builder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.this.mDialog.dismiss();
                    Builder.this.mCustomDialogCallBack.onCancel();
                }
            });
            this.confirmTv.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.AdscopeCommonDialog.Builder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.this.mDialog.dismiss();
                    Builder.this.mCustomDialogCallBack.onConfirm();
                }
            });
            this.mDialog.setContentView(this.mLayout);
            this.mDialog.setCancelable(true);
            this.mDialog.setCanceledOnTouchOutside(false);
            return this.mDialog;
        }

        public Builder setCancel(String str) {
            this.cancelTv.setText(str);
            return this;
        }

        public Builder setConfirm(String str) {
            this.confirmTv.setText(str);
            return this;
        }

        public Builder setContent(String str) {
            this.contentTv.setText(str);
            return this;
        }

        public Builder setCustomDialogCallBack(CustomDialogCallBack customDialogCallBack) {
            this.mCustomDialogCallBack = customDialogCallBack;
            return this;
        }

        public Builder setTitle(String str) {
            this.titleTv.setText(str);
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface CustomDialogCallBack {
        void onCancel();

        void onConfirm();
    }

    public AdscopeCommonDialog(@NonNull Context context) {
        super(context);
    }

    public AdscopeCommonDialog(@NonNull Context context, int i4) {
        super(context, i4);
    }

    public AdscopeCommonDialog(@NonNull Context context, boolean z3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z3, onCancelListener);
    }
}
