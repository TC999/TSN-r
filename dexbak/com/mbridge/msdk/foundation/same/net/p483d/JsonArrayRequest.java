package com.mbridge.msdk.foundation.same.net.p483d;

import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.IListener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.p485f.HttpUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.mbridge.msdk.foundation.same.net.d.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class JsonArrayRequest extends JsonRequest<JSONArray> {

    /* renamed from: c */
    private static final String f30739c = JsonArrayRequest.class.getSimpleName();

    public JsonArrayRequest(int i, String str, String str2, IListener<JSONArray> iListener) {
        super(i, str, str2, iListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.foundation.same.net.AbstractC11354i
    /* renamed from: a */
    public final C11356k<JSONArray> mo22205a(NetworkResponse networkResponse) {
        try {
            return C11356k.m22175a(new JSONArray(new String(networkResponse.f30752b, HttpUtils.m22257a(networkResponse.f30754d))), networkResponse);
        } catch (UnsupportedEncodingException e) {
            SameLogTool.m21733d(f30739c, e.getMessage());
            return C11356k.m22176a(new CommonError(8, networkResponse));
        } catch (JSONException e2) {
            SameLogTool.m21733d(f30739c, e2.getMessage());
            return C11356k.m22176a(new CommonError(8, networkResponse));
        }
    }
}
