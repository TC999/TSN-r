package com.mbridge.msdk.foundation.same.net.p483d;

import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.IListener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.same.net.p485f.HttpUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.same.net.d.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class JsonObjectRequest extends JsonRequest<JSONObject> {

    /* renamed from: c */
    private static final String f30740c = JsonObjectRequest.class.getSimpleName();

    public JsonObjectRequest(int i, String str, String str2, IListener<JSONObject> iListener) {
        super(i, str, str2, iListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.foundation.same.net.AbstractC11354i
    /* renamed from: a */
    public final C11356k<JSONObject> mo22205a(NetworkResponse networkResponse) {
        try {
            String str = new String(networkResponse.f30752b, HttpUtils.m22257a(networkResponse.f30754d));
            if (networkResponse.f30751a == 204) {
                return C11356k.m22175a(new JSONObject(), networkResponse);
            }
            return C11356k.m22175a(new JSONObject(str), networkResponse);
        } catch (UnsupportedEncodingException e) {
            SameLogTool.m21733d(f30740c, e.getMessage());
            return C11356k.m22176a(new CommonError(8, networkResponse));
        } catch (JSONException e2) {
            SameLogTool.m21733d(f30740c, e2.getMessage());
            return C11356k.m22176a(new CommonError(8, networkResponse));
        }
    }
}
