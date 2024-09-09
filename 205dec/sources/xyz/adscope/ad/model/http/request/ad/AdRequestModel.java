package xyz.adscope.ad.model.http.request.ad;

import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.BaseModel;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdRequestModel extends BaseModel {
    private int at;
    private ContextModel context;
    private int country_CN;
    private List<String> cur;
    private JSONObject ext;
    private String id;
    private List<ItemModel> item;
    private int test;
    private int tmax;

    public int getAt() {
        return this.at;
    }

    public ContextModel getContext() {
        return this.context;
    }

    public int getCountry_CN() {
        return this.country_CN;
    }

    public List<String> getCur() {
        return this.cur;
    }

    public JSONObject getExt() {
        return this.ext;
    }

    public String getId() {
        return this.id;
    }

    public List<ItemModel> getItem() {
        return this.item;
    }

    public int getTest() {
        return this.test;
    }

    public int getTmax() {
        return this.tmax;
    }

    public void setAt(int i4) {
        this.at = i4;
    }

    public void setContext(ContextModel contextModel) {
        this.context = contextModel;
    }

    public void setCountry_CN(int i4) {
        this.country_CN = i4;
    }

    public void setCur(List<String> list) {
        this.cur = list;
    }

    public void setExt(JSONObject jSONObject) {
        this.ext = jSONObject;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setItem(List<ItemModel> list) {
        this.item = list;
    }

    public void setTest(int i4) {
        this.test = i4;
    }

    public void setTmax(int i4) {
        this.tmax = i4;
    }

    public String toString() {
        return "{\"id\":\"" + this.id + "\", \"test\":" + this.test + ", \"tmax\":" + this.tmax + ", \"country_CN\":" + this.country_CN + ", \"item\":" + this.item + ", \"context\":" + this.context + ", \"cur\":" + StringUtil.ListToString(this.cur) + ", \"at\":" + this.at + ", \"ext\":" + this.ext + '}';
    }
}
