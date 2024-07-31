package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.z */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTUIUtils {
    /* renamed from: a */
    public static int m59088a(@NonNull Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    public static void m59087a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
