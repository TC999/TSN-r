package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonObjectRequest.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d extends e<JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f39534c = d.class.getSimpleName();

    public d(int i4, String str, String str2, com.mbridge.msdk.foundation.same.net.e<JSONObject> eVar) {
        super(i4, str, str2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.foundation.same.net.i
    public final k<JSONObject> a(com.mbridge.msdk.foundation.same.net.e.c cVar) {
        try {
            String str = new String(cVar.f39546b, com.mbridge.msdk.foundation.same.net.f.b.a(cVar.f39548d));
            if (cVar.f39545a == 204) {
                return k.a(new JSONObject(), cVar);
            }
            return k.a(new JSONObject(str), cVar);
        } catch (UnsupportedEncodingException e4) {
            x.d(f39534c, e4.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(8, cVar));
        } catch (JSONException e5) {
            x.d(f39534c, e5.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(8, cVar));
        }
    }
}
