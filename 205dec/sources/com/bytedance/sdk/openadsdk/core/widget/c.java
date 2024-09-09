package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends AlertDialog {

    /* renamed from: c  reason: collision with root package name */
    private Context f35394c;

    /* renamed from: w  reason: collision with root package name */
    private String f35395w;

    public c(Context context, String str) {
        super(context, i.ux(context, "tt_custom_dialog"));
        this.f35394c = context == null ? ls.getContext() : context;
        this.f35395w = str;
    }

    private void c() {
        ((TextView) findViewById(2114387698)).setText(this.f35395w);
        findViewById(2114387757).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.ux.m(getContext()));
        c();
    }
}
