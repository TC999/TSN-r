package cn.jpush.android.n;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d extends JPushResponse {

    /* renamed from: a  reason: collision with root package name */
    private int f4254a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f4255b;

    /* renamed from: c  reason: collision with root package name */
    private JSONArray f4256c;

    public d(int i4, long j4, long j5, ByteBuffer byteBuffer) {
        super(i4, j4, j5, byteBuffer);
        this.f4254a = -1;
        parseBody();
    }

    public d(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public JSONObject a() {
        return this.f4255b;
    }

    public JSONArray b() {
        return this.f4256c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            ByteBuffer byteBuffer = this.body;
            if (byteBuffer == null) {
                Logger.ww("GeoPullResponse", "geo pull response empty");
                return;
            }
            short s3 = byteBuffer.getShort();
            this.f4254a = s3;
            if (s3 != 0) {
                Logger.ww("GeoPullResponse", "geo pull response error code :" + this.f4254a);
                return;
            }
            byte[] bArr = new byte[this.body.getShort()];
            this.body.get(bArr);
            String str = new String(bArr, "UTF-8");
            Logger.d("GeoPullResponse", "receive content\uff1a" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f4256c = jSONObject.getJSONArray("geofence");
            jSONObject.remove("geofence");
            this.f4255b = jSONObject;
        } catch (Throwable unused) {
            Logger.ww("GeoPullResponse", "parse geo pull response failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[GeoPullResponse] - limit:" + this.f4255b + " - geoArray:" + this.f4256c + " - " + super.toString();
    }
}
