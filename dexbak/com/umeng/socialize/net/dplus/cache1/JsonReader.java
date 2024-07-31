package com.umeng.socialize.net.dplus.cache1;

import com.umeng.socialize.utils.SLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class JsonReader extends IReader<JSONObject> {
    public JsonReader(String str) {
        super(str);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [org.json.JSONObject, T] */
    @Override // com.umeng.socialize.net.dplus.cache1.IReader
    public void create(String str) {
        try {
            this.result = new JSONObject(str);
        } catch (JSONException e) {
            SLog.error(e);
        }
    }
}
