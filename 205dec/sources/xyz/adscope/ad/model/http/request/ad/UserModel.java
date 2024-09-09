package xyz.adscope.ad.model.http.request.ad;

import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UserModel {
    private List<JSONObject> data;
    private Object ext;
    private String id;

    public List<JSONObject> getData() {
        return this.data;
    }

    public Object getExt() {
        return this.ext;
    }

    public String getId() {
        return this.id;
    }

    public void setData(List<JSONObject> list) {
        this.data = list;
    }

    public void setExt(Object obj) {
        this.ext = obj;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return "{\"id\":\"" + this.id + "\", \"data\":" + this.data + ", \"ext\":" + this.ext + '}';
    }
}
