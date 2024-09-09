package com.umeng.socialize.net.dplus.cache1;

import com.umeng.socialize.utils.SLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class JsonReader extends IReader<JSONObject> {
    public JsonReader(String str) {
        super(str);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [org.json.JSONObject, T] */
    @Override // com.umeng.socialize.net.dplus.cache1.IReader
    public void create(String str) {
        try {
            this.result = new JSONObject(str);
        } catch (JSONException e4) {
            SLog.error(e4);
        }
    }
}
