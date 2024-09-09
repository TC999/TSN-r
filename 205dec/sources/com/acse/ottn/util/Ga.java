package com.acse.ottn.util;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Ga {

    /* renamed from: a  reason: collision with root package name */
    private static Ga f6725a;

    private Ga() {
    }

    public static Ga a() {
        if (f6725a == null) {
            synchronized (Ga.class) {
                if (f6725a == null) {
                    f6725a = new Ga();
                }
            }
        }
        return f6725a;
    }

    public void a(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public void a(Context context, String str) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
            if (CommonUtil.isShwoToast) {
                Toast.makeText(context, "\u590d\u5236\u6210\u529f", 1).show();
            }
        } catch (Exception e4) {
            ra.a("SoftKeyboardUtil", e4.getMessage());
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

    public String b() {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) HelpShopAppUtil.getContext().getSystemService("clipboard");
            return clipboardManager.getText() != null ? clipboardManager.getText().toString().trim() : "";
        } catch (Exception e4) {
            ra.a("SoftKeyboardUtil", e4.getMessage());
            return "";
        }
    }
}
