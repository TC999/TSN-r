package com.qq.e.comm.plugin.f0;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.e2;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g extends TextView {

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f43109c;

    /* renamed from: d  reason: collision with root package name */
    private final b f43110d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.a f43111c;

        a(com.qq.e.comm.plugin.g0.a aVar) {
            this.f43111c = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.getVisibility() != 0) {
                d1.a("miit view\u4e0d\u53ef\u89c1\uff0c\u5ffd\u7565\u70b9\u51fb\u4e8b\u4ef6", new Object[0]);
            }
            if (this.f43111c != null) {
                f.a(g.this.f43109c, g.this.f43110d);
                return;
            }
            e2.d("\u83b7\u53d6\u4e0d\u5230\u5e94\u7528\u4fe1\u606f\uff0c\u65e0\u6cd5\u663e\u793a");
            d1.a("miit channelInfo null\uff0c\u5ffd\u7565\u70b9\u51fb\u4e8b\u4ef6", new Object[0]);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final Map<String, WeakReference<b>> f43113a = new HashMap();

        void c();

        void h();
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends com.qq.e.comm.plugin.q0.u.i {

        /* renamed from: a  reason: collision with root package name */
        private com.qq.e.comm.plugin.g0.e f43114a;

        public c(com.qq.e.comm.plugin.g0.e eVar) {
            this.f43114a = eVar;
        }

        @Override // com.qq.e.comm.plugin.q0.u.i
        public String a() {
            return "clickMIITInfo";
        }

        @Override // com.qq.e.comm.plugin.q0.u.i
        public void a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
            com.qq.e.comm.plugin.g0.e eVar = this.f43114a;
            if (eVar == null || eVar.q() == null || this.f43114a.q().b() == null) {
                return;
            }
            f.a(this.f43114a, null);
        }
    }

    public g(Context context, com.qq.e.comm.plugin.g0.e eVar, b bVar) {
        super(context);
        this.f43109c = eVar;
        this.f43110d = bVar;
        a();
    }

    private void a() {
        setTextSize(2, 9.0f);
        setEllipsize(TextUtils.TruncateAt.END);
        com.qq.e.comm.plugin.g0.b q3 = this.f43109c.q();
        com.qq.e.comm.plugin.g0.a b4 = q3 == null ? null : q3.b();
        if (b4 == null) {
            v.a(9130070, com.qq.e.comm.plugin.n0.c.a(this.f43109c), 1);
            return;
        }
        setBackgroundColor(0);
        setTextColor(-1);
        setText(f.a(this.f43109c));
        setOnClickListener(new a(b4));
    }

    public static View a(Context context) {
        View view = new View(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setColors(new int[]{0, 2130706432});
        } else {
            gradientDrawable.setColor(2130706432);
        }
        view.setBackgroundDrawable(gradientDrawable);
        return view;
    }
}
