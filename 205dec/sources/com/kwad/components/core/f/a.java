package com.kwad.components.core.f;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.g;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.y;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends d implements g {
    private String Lw;
    private long Lx;
    private String Ly;
    private Context mContext;

    private void X(Context context) {
        c.i("EncryptComponentsImpl", "initGId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("64", 0);
            if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asT)) {
                jSONObject.put("64_level", 1);
            }
            KWEGIDDFP.handlePolicy(jSONObject);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.components.core.f.a.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i4, String str) {
                c.e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i4 + "errorMessage :" + str);
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                c.d("initGId onSuccess", "deviceInfo\uff1a" + str2);
                a.this.ov();
                a.this.aj(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(String str) {
        if (this.mContext == null || bg.isNullString(str) || bg.isEquals(oA(), str)) {
            return;
        }
        this.Ly = str;
        y.af(this.mContext, str);
    }

    private String oA() {
        if (TextUtils.isEmpty(this.Ly)) {
            this.Ly = y.cf(this.mContext);
        }
        return this.Ly;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov() {
        String cc = y.cc(this.mContext);
        String MW = bi.MW();
        if (TextUtils.isEmpty(cc)) {
            y.X(this.mContext, MW);
        } else if (TextUtils.equals(cc, MW)) {
        } else {
            this.Lw = "";
            this.Lx = 0L;
            this.Ly = "";
            y.W(this.mContext, "");
            y.d(this.mContext, this.Lx);
            y.af(this.mContext, this.Ly);
            y.X(this.mContext, MW);
        }
    }

    private String oy() {
        if (TextUtils.isEmpty(this.Lw)) {
            this.Lw = y.bZ(this.mContext);
        }
        return this.Lw;
    }

    private long oz() {
        if (this.Lx == 0) {
            this.Lx = y.ca(this.mContext);
        }
        return this.Lx;
    }

    @Override // com.kwad.sdk.components.g
    public final void ak(String str) {
        if (this.mContext == null || bg.isNullString(str) || bg.isEquals(oy(), str)) {
            return;
        }
        try {
            this.Lw = str;
            y.W(this.mContext, str);
            KWEGIDDFP.instance().setEgid(this.mContext, str);
        } catch (Throwable th) {
            c.e("EncryptComponentsImpl", "setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return g.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
        try {
            this.mContext = context;
            X(context);
        } catch (Throwable th) {
            c.e("EncryptComponentsImpl", "initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.g
    public final String ow() {
        return (com.kwad.sdk.core.config.d.BW() || System.currentTimeMillis() >= oz() || TextUtils.isEmpty(oy())) ? oA() : "";
    }

    @Override // com.kwad.sdk.components.g
    public final com.kwad.sdk.core.a.g ox() {
        return new com.kwad.sdk.core.a.a();
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public final int priority() {
        return -200;
    }

    @Override // com.kwad.sdk.components.g
    public final void x(long j4) {
        if (this.mContext == null || j4 <= 0 || j4 == oz()) {
            return;
        }
        this.Lx = j4;
        y.d(this.mContext, j4);
    }
}
