package com.acse.ottn.util;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import java.util.List;

/* renamed from: com.acse.ottn.util.Ga */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1630Ga {

    /* renamed from: a */
    private static C1630Ga f3152a;

    private C1630Ga() {
    }

    /* renamed from: a */
    public static C1630Ga m56267a() {
        if (f3152a == null) {
            synchronized (C1630Ga.class) {
                if (f3152a == null) {
                    f3152a = new C1630Ga();
                }
            }
        }
        return f3152a;
    }

    /* renamed from: a */
    public void m56266a(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    /* renamed from: a */
    public void m56265a(Context context, String str) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
            if (CommonUtil.isShwoToast) {
                Toast.makeText(context, "复制成功", 1).show();
            }
        } catch (Exception e) {
            C1694ra.m55917a("SoftKeyboardUtil", e.getMessage());
        }
    }

    /* renamed from: a */
    public void m56264a(Context context, List<View> list) {
        if (list == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        for (View view : list) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    /* renamed from: b */
    public String m56263b() {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) HelpShopAppUtil.getContext().getSystemService("clipboard");
            return clipboardManager.getText() != null ? clipboardManager.getText().toString().trim() : "";
        } catch (Exception e) {
            C1694ra.m55917a("SoftKeyboardUtil", e.getMessage());
            return "";
        }
    }
}
