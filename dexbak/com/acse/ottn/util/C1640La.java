package com.acse.ottn.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.acse.ottn.C1239R;
import java.io.ObjectStreamException;

/* renamed from: com.acse.ottn.util.La */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1640La {

    /* renamed from: a */
    private static C1640La f3256a;

    private C1640La() {
    }

    /* renamed from: a */
    public static C1640La m56173a() {
        if (f3256a == null) {
            synchronized (C1640La.class) {
                if (f3256a == null) {
                    f3256a = new C1640La();
                }
            }
        }
        return f3256a;
    }

    /* renamed from: b */
    private Object m56171b() throws ObjectStreamException {
        return f3256a;
    }

    /* renamed from: a */
    public void m56172a(Context context, String str) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1239R.C1244layout.toast_layout, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(C1239R.C1242id.toast_layout)).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ((TextView) inflate.findViewById(C1239R.C1242id.toast_text)).setText(str);
        Toast toast = new Toast(context);
        toast.setGravity(119, 0, 0);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }
}
