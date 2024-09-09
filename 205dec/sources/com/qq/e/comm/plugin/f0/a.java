package com.qq.e.comm.plugin.f0;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qq.e.comm.plugin.util.d1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    private static final String f43054f = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    protected ImageView f43055c;

    /* renamed from: d  reason: collision with root package name */
    protected Button f43056d;

    /* renamed from: e  reason: collision with root package name */
    protected final c f43057e;

    public a(Context context, c cVar) {
        super(context);
        this.f43057e = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View.OnClickListener onClickListener) {
        this.f43055c.setOnClickListener(onClickListener);
        this.f43056d.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b() {
        return this.f43055c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d() {
        return this.f43056d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d1.a(f43054f, "onConfigurationChanged");
        this.f43057e.onClick(this.f43055c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        this.f43056d.setText(str);
    }
}
