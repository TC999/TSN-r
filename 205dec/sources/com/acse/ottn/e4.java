package com.acse.ottn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e4 {

    /* renamed from: a  reason: collision with root package name */
    public static e4 f5640a;

    public static e4 a() {
        if (f5640a == null) {
            synchronized (e4.class) {
                if (f5640a == null) {
                    f5640a = new e4();
                }
            }
        }
        return f5640a;
    }

    public final Object b() throws ObjectStreamException {
        return f5640a;
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
