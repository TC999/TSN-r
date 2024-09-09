package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: JsonArrayRequest.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c extends e<JSONArray> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f39533c = c.class.getSimpleName();

    public c(int i4, String str, String str2, com.mbridge.msdk.foundation.same.net.e<JSONArray> eVar) {
        super(i4, str, str2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.foundation.same.net.i
    public final k<JSONArray> a(com.mbridge.msdk.foundation.same.net.e.c cVar) {
        try {
            return k.a(new JSONArray(new String(cVar.f39546b, com.mbridge.msdk.foundation.same.net.f.b.a(cVar.f39548d))), cVar);
        } catch (UnsupportedEncodingException e4) {
            x.d(f39533c, e4.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(8, cVar));
        } catch (JSONException e5) {
            x.d(f39533c, e5.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(8, cVar));
        }
    }
}
