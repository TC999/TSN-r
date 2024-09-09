package xyz.adscope.ad.model.http.response.ad;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.json.inter.JsonNode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DisplayModel {
    @JsonNode(key = CampaignEx.JSON_KEY_BTY)
    private int ctype;
    @JsonNode(key = "event")
    private List<EventModel> eventNode;
    @JsonNode(key = "ext")
    private String ext;
    @JsonNode(key = "h")

    /* renamed from: h  reason: collision with root package name */
    private int f64525h;
    @JsonNode(key = "id")
    private String id;
    @JsonNode(key = "mime")
    private String mime;
    @JsonNode(key = AMPSConstants.AdType.AD_TYPE_NATIVE)
    private NativeModel nativeModel;
    @JsonNode(key = "report")
    private ReportModel report;
    @JsonNode(key = "w")

    /* renamed from: w  reason: collision with root package name */
    private int f64526w;

    public int getCtype() {
        return this.ctype;
    }

    public List<EventModel> getEvent() {
        return this.eventNode;
    }

    public String getExt() {
        return this.ext;
    }

    public int getH() {
        return this.f64525h;
    }

    public String getId() {
        return this.id;
    }

    public String getMime() {
        return this.mime;
    }

    public NativeModel getNativeModel() {
        return this.nativeModel;
    }

    public ReportModel getReport() {
        return this.report;
    }

    public int getW() {
        return this.f64526w;
    }

    public void setCtype(int i4) {
        this.ctype = i4;
    }

    public void setEvent(List<EventModel> list) {
        this.eventNode = list;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setH(int i4) {
        this.f64525h = i4;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMime(String str) {
        this.mime = str;
    }

    public void setNativeModel(NativeModel nativeModel) {
        this.nativeModel = nativeModel;
    }

    public void setReport(ReportModel reportModel) {
        this.report = reportModel;
    }

    public void setW(int i4) {
        this.f64526w = i4;
    }
}
