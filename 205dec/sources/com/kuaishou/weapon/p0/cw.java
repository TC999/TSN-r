package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f38241a;

    public cw(Context context) {
        this.f38241a = context;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:47:0x03d1
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private com.kuaishou.weapon.p0.y b(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.cw.b(java.lang.String):com.kuaishou.weapon.p0.y");
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                String a4 = new bn(this.f38241a).a(jSONObject.getString("antispamPluginRsp"));
                if (TextUtils.isEmpty(a4)) {
                    return;
                }
                y b4 = b(a4);
                if (b4 != null) {
                    df.a(this.f38241a).a(str, b4);
                } else {
                    df.a(this.f38241a).b(System.currentTimeMillis());
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = cu.f38226a + cu.f38229d;
            String a4 = cv.a(this.f38241a);
            if (!TextUtils.isEmpty(a4)) {
                str = str + "?" + a4;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject b4 = cv.b(this.f38241a);
            if (b4 != null) {
                jSONObject.put("data", new bn(this.f38241a).c(b4.toString()));
            }
            l a5 = l.a(this.f38241a);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a5.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cw.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str2) {
                    try {
                        cw.this.a(str2);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str2) {
                }
            });
        } catch (Exception unused) {
        }
    }
}
