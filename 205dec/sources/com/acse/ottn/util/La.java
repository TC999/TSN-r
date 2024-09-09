package com.acse.ottn.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.acse.ottn.R;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class La {

    /* renamed from: a  reason: collision with root package name */
    private static La f6766a;

    private La() {
    }

    public static La a() {
        if (f6766a == null) {
            synchronized (La.class) {
                if (f6766a == null) {
                    f6766a = new La();
                }
            }
        }
        return f6766a;
    }

    private Object b() throws ObjectStreamException {
        return f6766a;
    }

    public void a(Context context, String str) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R.id.toast_layout)).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ((TextView) inflate.findViewById(R.id.toast_text)).setText(str);
        Toast toast = new Toast(context);
        toast.setGravity(119, 0, 0);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }
}
