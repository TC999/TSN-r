package com.qq.e.comm.plugin.fs.f.e;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.n1;
import com.qq.e.comm.plugin.util.z;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.comm.plugin.rewardvideo.a {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f43387c;

        a(c cVar) {
            this.f43387c = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f43387c.b();
            b.this.cancel();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.fs.f.e.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class View$OnClickListenerC0831b implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f43389c;

        View$OnClickListenerC0831b(c cVar) {
            this.f43389c = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f43389c.a();
            b.this.cancel();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface c {
        void a();

        void b();
    }

    public b(Context context) {
        super(context);
        setCancelable(false);
    }

    public void a(Activity activity, e eVar, com.qq.e.comm.plugin.fs.d.d.a aVar, String str, String str2, String str3, c cVar) {
        if (!isShowing()) {
            boolean a4 = z.a(eVar);
            z.d(activity, a4);
            show();
            z.b(activity, a4, false);
            z.a(activity, a4);
        }
        LinearLayout a5 = a(activity, aVar.i(), str, str2, str3);
        setContentView(a5);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            a5.measure(0, 0);
            attributes.width = a5.getMeasuredWidth();
            attributes.height = a5.getMeasuredHeight();
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setBackgroundDrawable(n1.a(f1.a((Context) activity, 10), -1, 255));
        }
        a().setOnClickListener(new a(cVar));
        b().setOnClickListener(new View$OnClickListenerC0831b(cVar));
    }
}
