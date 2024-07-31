package com.kwad.components.core.p295f;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.components.AbstractC9863d;
import com.kwad.sdk.components.InterfaceC9866g;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p385a.C9884a;
import com.kwad.sdk.core.p385a.InterfaceC9892g;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.utils.C11137y;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8644a extends AbstractC9863d implements InterfaceC9866g {

    /* renamed from: Lw */
    private String f28287Lw;

    /* renamed from: Lx */
    private long f28288Lx;

    /* renamed from: Ly */
    private String f28289Ly;
    private Context mContext;

    /* renamed from: X */
    private void m30086X(Context context) {
        C10331c.m26248i("EncryptComponentsImpl", "initGId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("64", 0);
            if (C10251d.m26527a(C10250c.asT)) {
                jSONObject.put("64_level", 1);
            }
            KWEGIDDFP.handlePolicy(jSONObject);
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.components.core.f.a.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i, String str) {
                C10331c.m26250e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                C10331c.m26254d("initGId onSuccess", "deviceInfo：" + str2);
                C8644a.this.m30081ov();
                C8644a.this.m30083aj(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aj */
    public void m30083aj(String str) {
        if (this.mContext == null || C11053bg.isNullString(str) || C11053bg.isEquals(m30082oA(), str)) {
            return;
        }
        this.f28289Ly = str;
        C11137y.m23602af(this.mContext, str);
    }

    /* renamed from: oA */
    private String m30082oA() {
        if (TextUtils.isEmpty(this.f28289Ly)) {
            this.f28289Ly = C11137y.m23581cf(this.mContext);
        }
        return this.f28289Ly;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ov */
    public void m30081ov() {
        String m23584cc = C11137y.m23584cc(this.mContext);
        String m23911MW = C11059bi.m23911MW();
        if (TextUtils.isEmpty(m23584cc)) {
            C11137y.m23619X(this.mContext, m23911MW);
        } else if (TextUtils.equals(m23584cc, m23911MW)) {
        } else {
            this.f28287Lw = "";
            this.f28288Lx = 0L;
            this.f28289Ly = "";
            C11137y.m23620W(this.mContext, "");
            C11137y.m23578d(this.mContext, this.f28288Lx);
            C11137y.m23602af(this.mContext, this.f28289Ly);
            C11137y.m23619X(this.mContext, m23911MW);
        }
    }

    /* renamed from: oy */
    private String m30080oy() {
        if (TextUtils.isEmpty(this.f28287Lw)) {
            this.f28287Lw = C11137y.m23588bZ(this.mContext);
        }
        return this.f28287Lw;
    }

    /* renamed from: oz */
    private long m30079oz() {
        if (this.f28288Lx == 0) {
            this.f28288Lx = C11137y.m23586ca(this.mContext);
        }
        return this.f28288Lx;
    }

    @Override // com.kwad.sdk.components.InterfaceC9866g
    /* renamed from: ak */
    public final void mo27497ak(String str) {
        if (this.mContext == null || C11053bg.isNullString(str) || C11053bg.isEquals(m30080oy(), str)) {
            return;
        }
        try {
            this.f28287Lw = str;
            C11137y.m23620W(this.mContext, str);
            KWEGIDDFP.instance().setEgid(this.mContext, str);
        } catch (Throwable th) {
            C10331c.m26250e("EncryptComponentsImpl", "setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return InterfaceC9866g.class;
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
        try {
            this.mContext = context;
            m30086X(context);
        } catch (Throwable th) {
            C10331c.m26250e("EncryptComponentsImpl", "initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.InterfaceC9866g
    /* renamed from: ow */
    public final String mo27496ow() {
        return (C10251d.m26571BW() || System.currentTimeMillis() >= m30079oz() || TextUtils.isEmpty(m30080oy())) ? m30082oA() : "";
    }

    @Override // com.kwad.sdk.components.InterfaceC9866g
    /* renamed from: ox */
    public final InterfaceC9892g mo27495ox() {
        return new C9884a();
    }

    @Override // com.kwad.sdk.components.AbstractC9863d, com.kwad.sdk.components.InterfaceC9848a
    public final int priority() {
        return IOfflineCompo.Priority.HIGHEST;
    }

    @Override // com.kwad.sdk.components.InterfaceC9866g
    /* renamed from: x */
    public final void mo27494x(long j) {
        if (this.mContext == null || j <= 0 || j == m30079oz()) {
            return;
        }
        this.f28288Lx = j;
        C11137y.m23578d(this.mContext, j);
    }
}
