package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RunnableC7241cw implements Runnable {

    /* renamed from: a */
    private Context f24745a;

    public RunnableC7241cw(Context context) {
        this.f24745a = context;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:47:0x03d1
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: b */
    private com.kuaishou.weapon.p205p0.C7311y m34022b(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.RunnableC7241cw.m34022b(java.lang.String):com.kuaishou.weapon.p0.y");
    }

    /* renamed from: a */
    public void m34023a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(CommonNetImpl.RESULT, 0) == 1) {
                String m34157a = new C7198bn(this.f24745a).m34157a(jSONObject.getString("antispamPluginRsp"));
                if (TextUtils.isEmpty(m34157a)) {
                    return;
                }
                C7311y m34022b = m34022b(m34157a);
                if (m34022b != null) {
                    C7262df.m33986a(this.f24745a).m33983a(str, m34022b);
                } else {
                    C7262df.m33986a(this.f24745a).m33981b(System.currentTimeMillis());
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = C7239cu.f24730a + C7239cu.f24733d;
            String m34030a = C7240cv.m34030a(this.f24745a);
            if (!TextUtils.isEmpty(m34030a)) {
                str = str + "?" + m34030a;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject m34027b = C7240cv.m34027b(this.f24745a);
            if (m34027b != null) {
                jSONObject.put("data", new C7198bn(this.f24745a).m34153c(m34027b.toString()));
            }
            C7289l m33849a = C7289l.m33849a(this.f24745a);
            C7291m c7291m = new C7291m(str, jSONObject);
            c7291m.m33834a(WeaponHI.cookieData);
            c7291m.m33832b(WeaponHI.encryENV);
            m33849a.m33837b(c7291m, new InterfaceC7285j() { // from class: com.kuaishou.weapon.p0.cw.1
                @Override // com.kuaishou.weapon.p205p0.InterfaceC7285j
                /* renamed from: a */
                public void mo33851a(String str2) {
                    try {
                        RunnableC7241cw.this.m34023a(str2);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p205p0.InterfaceC7285j
                /* renamed from: b */
                public void mo33850b(String str2) {
                }
            });
        } catch (Exception unused) {
        }
    }
}
