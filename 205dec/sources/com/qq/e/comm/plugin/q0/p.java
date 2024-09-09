package com.qq.e.comm.plugin.q0;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;
import com.qq.e.comm.plugin.util.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class p extends RelativeLayout implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private int f45509c;

    /* renamed from: d  reason: collision with root package name */
    private final i f45510d;

    /* renamed from: e  reason: collision with root package name */
    private ViewGroup f45511e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f45512f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f45513g;

    /* renamed from: h  reason: collision with root package name */
    private b f45514h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f45515i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f45516j;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.f45515i) {
                if (p.this.f45514h != null) {
                    p.this.f45514h.onDismiss();
                }
                p.this.b();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void a();

        void b();

        void d();

        void onDismiss();
    }

    public p(Context context, i iVar) {
        super(context);
        this.f45509c = 3000;
        this.f45516j = new a();
        this.f45510d = iVar;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
        setVisibility(8);
        c();
    }

    private void c() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f45511e = frameLayout;
        frameLayout.setBackgroundColor(-1);
        this.f45511e.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, f1.a(getContext(), 44));
        layoutParams.addRule(12, -1);
        this.f45511e.setLayoutParams(layoutParams);
        addView(this.f45511e, layoutParams);
        View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor("#D5D5D6"));
        this.f45511e.addView(view, new FrameLayout.LayoutParams(-1, 1));
        int a4 = f1.a(getContext(), 4);
        ImageView imageView = new ImageView(getContext());
        this.f45512f = imageView;
        imageView.setImageBitmap(m1.a("iVBORw0KGgoAAAANSUhEUgAAACQAAAA+CAYAAABDTbllAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAJKADAAQAAAABAAAAPgAAAAAAXmzfAAACf0lEQVRoBc3ZT2sTQRQA8JlGD9sqaME2tceexKSN9g8oHoroJ/AbSKkofgDxlG8hFM+9WL3mkB4CbfBiBVn1A4itGAUPCq00m+ebhSlZs5Pd7Lw3k4HJLLOT9347ySFvIsSYNenDU6mt3u5F8FhKMSkAXn8KD7a1o6QvXI3XF5c3oAdvMN8S9mvYH8yW508734/2lGFCvbhqMQbEFuZL5AUBz+v1ejyXuMEJ68MMfE0AxFSz2ZxS+Z2AhmEUQgr5tt1u/1bX59QLZ8vCoObnxHl4qA0D26dvUIx5MCUQd8PwINT52EBFMArFAiqKYQHZYMhBthhSEAWGDESFIQFRYqxB1BgrEAemMIgLUwjEiRkZxI0ZCeQCkxvkCpML5BKTCXKNGQrygTGCfGFSQT4xAyDfmARoHDBnoOqNtVtRN9rHifQ6DUuV/6sD9WaOFgOibu8JBveOUQ8YI6SAuIxNe2IJ4lCI4GvaPY45vSs7puCApxSRPN6tVu9cNq2hnI+PY350voUz5avzGHjZEHwOZPd+eWbhVafz5cSwhmRa75D4+OHdIzxAemmMCuKmi51KVK4AICtLK1t4PLJhhEnxvgTBvTDc/2VcY3EjAVJxfKMGQL5RqSCfKCPIF2ooyAcqE+QalQvkEpUb5Ao1EsgFamQQN6oQiBNVGMSFsgJxoKxB1CgSECWKDESFIgVRoMhBtigWkA3q7Ee+CkLZpJSAhcNmnsKhVlu/pHOzgVSCvKjT3p8XGsT2kekEaswqHBDevTJ94WKr1Tph3SGNyrNTQRBgkWw6YNCRCMcM1Haj0fir0rH/K93/TAqFbbOyuPoZ559in8S+UxLTz/rXjdX1PzhESMVXt6s7AAAAAElFTkSuQmCC"));
        this.f45512f.setPadding(a4, a4, a4, a4);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(f1.a(getContext(), 24), f1.a(getContext(), 24));
        layoutParams2.gravity = 17;
        layoutParams2.rightMargin = f1.a(getContext(), 48);
        this.f45511e.addView(this.f45512f, layoutParams2);
        this.f45512f.setOnClickListener(this);
        ImageView imageView2 = new ImageView(getContext());
        this.f45513g = imageView2;
        imageView2.setImageBitmap(m1.a("iVBORw0KGgoAAAANSUhEUgAAACQAAAA+CAYAAABDTbllAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAJKADAAQAAAABAAAAPgAAAAAAXmzfAAACY0lEQVRoBeXZvW/TQBQA8Hd2hEjFAkIpatWNrbhIhLFDxMLE1I0RVa3UP6ELWdgZUIe2Mxv/AWJFAgIqbrdsoUKoVZdW/SC1j3tuazmpnfjjvXeVeJIl31m+9/PdWfJLAG5YqKRn1mu+BKUWtIZjt+as+T++fE5elziPQY/mnq6GWr9JJA2VguWdn53NRB/7qYMZ2u22o0GvDmVzzEytz841F4f6WZsujt7v9++cnJ2/TsmEM/ii8WBqd+/P7+8p18m7IlCv1/vbmJx+bkafSckgioqWDBHOLf0KFOyngLBLSS1fvKkxq+c1vUDBJ9BwH9spoc1GX+Lc6AMgBNhGXQPZRqWCbKIyQbZQI0E2UGNB0qhcIElUbpAUqhBIAlUYxI0qBeJElQZxoSqBOFCVQdQoEhAligxEhSIFUaDIQVVRLKAqKDZQWRQrqAyKHZQTFbo1dx5/S4jrMryRK3y/47sano2o+5zgPFzB/CKgiwet/1IadrMe2tR7E2Igz5u/G6iTjxrgcRYItP4gArrCmGr4SRbGzM7Gjt95zw7Kidnc3vq2fIVle8sKYJaUMrvrMlhAZTFoIgdVwZCDqmJIQRQYMhAVhgREiakMosZUAnFgSoO4MKVAnJjCIG5MIZAEJjdICpMLJIkZC5LGjATZwGSCbGFSQTYx10C2MQOgm4BBUFwohup0bUypgtXBwAc5DkAd0Td1q9W6vXdwdKi1rqUlMHWTCAZzRzNUr9fjMmQYJInB3NG/0t1uN2hMTj007YFSVxqDoHiJXLi3EjgHhxDCguk/Nse77a2vb5NFHN7w38U/+VL4Ter/OVkAAAAASUVORK5CYII="));
        this.f45513g.setPadding(a4, a4, a4, a4);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(f1.a(getContext(), 24), f1.a(getContext(), 24));
        layoutParams3.gravity = 17;
        layoutParams3.leftMargin = f1.a(getContext(), 48);
        this.f45511e.addView(this.f45513g, layoutParams3);
        this.f45513g.setOnClickListener(this);
    }

    public void d() {
        a();
        if (this.f45515i) {
            return;
        }
        i iVar = this.f45510d;
        if (iVar == null || iVar.canGoBack() || this.f45510d.canGoForward()) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f45511e, "translationY", f1.a(getContext(), 44), 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.start();
            b bVar = this.f45514h;
            if (bVar != null) {
                bVar.d();
            }
            this.f45515i = true;
            e();
        }
    }

    public void e() {
        i iVar = this.f45510d;
        if (iVar == null) {
            return;
        }
        this.f45512f.setAlpha(iVar.canGoBack() ? 1.0f : 0.5f);
        this.f45513g.setAlpha(this.f45510d.canGoForward() ? 1.0f : 0.5f);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f45512f) {
            b bVar = this.f45514h;
            if (bVar != null) {
                bVar.b();
            }
            i iVar = this.f45510d;
            if (iVar != null && iVar.canGoBack()) {
                this.f45510d.goBack();
            }
        } else if (view == this.f45513g) {
            b bVar2 = this.f45514h;
            if (bVar2 != null) {
                bVar2.a();
            }
            i iVar2 = this.f45510d;
            if (iVar2 != null && iVar2.canGoForward()) {
                this.f45510d.goForward();
            }
        }
        e();
    }

    public void a(b bVar) {
        this.f45514h = bVar;
    }

    public void b() {
        if (this.f45515i) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f45511e, "translationY", 0.0f, f1.a(getContext(), 44));
            ofFloat.setDuration(200L);
            ofFloat.start();
            b bVar = this.f45514h;
            if (bVar != null) {
                bVar.onDismiss();
            }
            this.f45515i = false;
        }
    }

    private void a() {
        p0.e(this.f45516j);
        p0.a(this.f45516j, this.f45509c);
    }
}
