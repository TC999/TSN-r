package com.bytedance.sdk.openadsdk.core.dislike;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.a.c;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.gd;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.wv;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.core.z.ux;
import com.bytedance.sdk.openadsdk.n.f;
import com.bytedance.sdk.openadsdk.n.sr;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements com.bytedance.sdk.openadsdk.core.dislike.w.c {

    /* renamed from: c  reason: collision with root package name */
    private final me f33170c;
    private String sr;

    /* renamed from: w  reason: collision with root package name */
    private final WeakReference<Context> f33171w;
    private final w xv;

    public xv(me meVar, Context context, w wVar) {
        this.f33170c = meVar;
        this.f33171w = new WeakReference<>(context);
        this.xv = wVar;
    }

    private String xv(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("app_name", k.sr().gd());
            jSONObject.putOpt("app_id", k.sr().ev());
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("os_version", Build.VERSION.RELEASE);
            jSONObject.putOpt("manufacturer", Build.MANUFACTURER);
            jSONObject.putOpt("did", r.c().w());
            jSONObject.putOpt("sdk_version", 6106);
            jSONObject.putOpt("sdk_api_version", Integer.valueOf(eq.f33190w));
            jSONObject.putOpt("live_sdk_version", TTLiveCommerceHelper.getInstance().getLivePluginVersion());
            jSONObject.putOpt("msg", str);
            jSONObject.putOpt("recordId", str2);
            jSONObject.putOpt("os", "Android");
            jSONObject.putOpt("ad_info", this.f33170c.py());
            com.bytedance.sdk.openadsdk.ys.w.xv.w oo = this.f33170c.oo();
            if (oo != null) {
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(oo.q()));
                jSONObject.putOpt("rit", oo.i());
            }
            return com.bytedance.sdk.component.utils.c.c(jSONObject).toString();
        } catch (Exception e4) {
            a.xv("#oncall#", e4);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, String str2) {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.w.w(ls.getContext()), str);
        file.mkdirs();
        z zVar = (z) ls.c();
        com.bytedance.sdk.openadsdk.ys.w.xv.w oo = this.f33170c.oo();
        JSONObject c4 = zVar.c(oo, new wv(), oo.q(), false, 6);
        if (c4 == null) {
            return;
        }
        sr.c(com.bytedance.sdk.openadsdk.core.xv.r.c().w(c4.toString()).sr().toString(), new File(file, "request.info"));
        sr.c(com.bytedance.sdk.component.utils.c.c(gd.sr(ls.getContext())).toString(), new File(file, "device.info"));
        sr.c(com.bytedance.sdk.component.utils.c.c(ux.c((com.bytedance.sdk.openadsdk.core.z.sr) null).f()).toString(), new File(file, "setting.info"));
        sr.c(com.bytedance.sdk.component.utils.c.c(this.f33170c.mo()).toString(), new File(file, "meta.info"));
        File c5 = sr.c(file, str + ".zip");
        new com.bytedance.sdk.openadsdk.a.c().c(this.xv.w(), c5, xv(str2, str), new c.InterfaceC0465c() { // from class: com.bytedance.sdk.openadsdk.core.dislike.xv.5
            @Override // com.bytedance.sdk.openadsdk.a.c.InterfaceC0465c
            public void c(String str3) {
                xv.this.c("\u53cd\u9988\u4e0a\u4f20\u6210\u529f\uff01");
            }

            @Override // com.bytedance.sdk.openadsdk.a.c.InterfaceC0465c
            public void c(int i4, String str3) {
                xv.this.c("\u53cd\u9988\u5931\u8d25\uff01");
            }
        });
        c5.delete();
        sr.c(file);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.w.c
    public boolean c(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || this.f33171w.get() == null || !str.startsWith("#oncall#")) {
            return false;
        }
        return c(this.f33171w.get(), str, dialog);
    }

    private boolean c(Context context, final String str, Dialog dialog) {
        try {
            if (this.sr == null) {
                this.sr = UUID.randomUUID().toString();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            AlertDialog.Builder negativeButton = new AlertDialog.Builder(context).setPositiveButton("\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.xv.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    xv xvVar = xv.this;
                    xvVar.c(xvVar.sr, str);
                }
            }).setNegativeButton("\u53d6\u6d88", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.xv.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                }
            });
            negativeButton.setMessage(this.xv.xv() + "\n\n\u60a8\u6b64\u6b21\u53cd\u9988\u7684id\u4e3a\uff1a" + this.sr).setCancelable(true).create().show();
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str) {
        f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.xv.3
            @Override // java.lang.Runnable
            public void run() {
                if (xv.this.f33171w.get() != null) {
                    Toast.makeText((Context) xv.this.f33171w.get(), str, 1).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str, final String str2) {
        c("\u53cd\u9988\u4e0a\u4f20\u4e2d\uff0c\u8bf7\u60a8\u7a0d\u7b49\uff01");
        ev.w(new p("upload_oncall") { // from class: com.bytedance.sdk.openadsdk.core.dislike.xv.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xv.this.w(str, str2);
                } catch (Throwable th) {
                    a.xv("#oncall#", th);
                }
            }
        });
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar, me meVar) {
        w h4;
        if (cVar == null || meVar == null || (h4 = ls.w().h()) == null || !h4.c() || TextUtils.isEmpty(h4.w())) {
            return;
        }
        cVar.c(new xv(meVar, context, h4));
    }
}
