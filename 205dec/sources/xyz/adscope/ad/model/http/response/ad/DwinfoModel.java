package xyz.adscope.ad.model.http.response.ad;

import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DwinfoModel implements Serializable {
    @JsonNode(key = "appintro")
    private String appintro;
    @JsonNode(key = "bundle")
    private String bundle;
    @JsonNode(key = "developer")
    private String developer;
    @JsonNode(key = "ext")
    private JSONObject ext;
    @JsonNode(key = "iconUrl")
    private String iconUrl;
    @JsonNode(key = "name")
    private String name;
    @JsonNode(key = "permission")
    private List<PermissionModel> permission;
    @JsonNode(key = "permissionUrl")
    private String permissionUrl;
    @JsonNode(key = "policy")
    private String policy;
    @JsonNode(key = "policyUrl")
    private String policyUrl;
    @JsonNode(key = "size")
    private String size;
    @JsonNode(key = "storeId")
    private String storeId;
    @JsonNode(key = "version")
    private String version;

    public String getAppintro() {
        return this.appintro;
    }

    public String getBundle() {
        return this.bundle;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public JSONObject getExt() {
        return this.ext;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getName() {
        return this.name;
    }

    public List<PermissionModel> getPermission() {
        return this.permission;
    }

    public String getPermissionUrl() {
        return this.permissionUrl;
    }

    public String getPolicy() {
        return this.policy;
    }

    public String getPolicyUrl() {
        return this.policyUrl;
    }

    public String getSize() {
        return this.size;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppintro(String str) {
        this.appintro = str;
    }

    public void setBundle(String str) {
        this.bundle = str;
    }

    public void setDeveloper(String str) {
        this.developer = str;
    }

    public void setExt(JSONObject jSONObject) {
        this.ext = jSONObject;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPermission(List<PermissionModel> list) {
        this.permission = list;
    }

    public void setPermissionUrl(String str) {
        this.permissionUrl = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setPolicyUrl(String str) {
        this.policyUrl = str;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setStoreId(String str) {
        this.storeId = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
