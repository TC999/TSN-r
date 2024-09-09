package xyz.adscope.ad.tool.widget.dialog.base;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CustomDialog extends Dialog {
    private OnDialogDismissListener onDialogDismissListener;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface OnDialogDismissListener {
        void onDialogDismissed(boolean z3);
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    private boolean isOutOfBounds(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        View decorView = getWindow().getDecorView();
        decorView.getLocationOnScreen(iArr);
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        return rawX < iArr[0] || rawX >= iArr[0] + decorView.getWidth() || rawY < iArr[1] || rawY >= iArr[1] + decorView.getHeight();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && isOutOfBounds(motionEvent)) {
            OnDialogDismissListener onDialogDismissListener = this.onDialogDismissListener;
            if (onDialogDismissListener != null) {
                onDialogDismissListener.onDialogDismissed(true);
            }
            dismiss();
        }
        LogUtil.i(Constants.TAG, "dispatchTouchEvent");
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnDialogDismissListener(OnDialogDismissListener onDialogDismissListener) {
        this.onDialogDismissListener = onDialogDismissListener;
    }

    public CustomDialog(@NonNull Context context, int i4) {
        super(context, i4);
    }
}
