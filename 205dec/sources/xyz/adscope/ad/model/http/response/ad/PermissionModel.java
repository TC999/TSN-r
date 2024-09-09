package xyz.adscope.ad.model.http.response.ad;

import java.io.Serializable;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class PermissionModel implements Serializable {
    @JsonNode(key = "describe")
    private String describe;
    @JsonNode(key = "permissionType")
    private String permissionType;
    @JsonNode(key = "title")
    private String title;

    public String getDescribe() {
        return this.describe;
    }

    public String getPermissionType() {
        return this.permissionType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void setPermissionType(String str) {
        this.permissionType = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
