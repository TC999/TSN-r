package com.acse.ottn;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.acse.ottn.util.HelpShopAppUtil;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class z3 {

    /* renamed from: a  reason: collision with root package name */
    public static z3 f7025a;

    public static z3 a() {
        if (f7025a == null) {
            synchronized (z3.class) {
                if (f7025a == null) {
                    f7025a = new z3();
                }
            }
        }
        return f7025a;
    }

    public String b() {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) HelpShopAppUtil.getContext().getSystemService("clipboard");
            return clipboardManager.getText() != null ? clipboardManager.getText().toString().trim() : "";
        } catch (Exception e4) {
            Log.d("SoftKeyboardUtil", e4.getMessage());
            return "";
        }
    }

    public void a(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public void a(Context context, List<View> list) {
        if (list == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        for (View view : list) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public void a(Context context, String str) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
            if (j0.f5762d) {
                Toast.makeText(context, "\u590d\u5236\u6210\u529f", 1).show();
            }
        } catch (Exception e4) {
            Log.d("SoftKeyboardUtil", e4.getMessage());
        }
    }
}
