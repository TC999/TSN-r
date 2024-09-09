package xyz.adscope.amps.report.model.response;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSReportResponseModel {
    private int code;
    private int dlvy;
    private String ext;
    private String msg;
    private SpecModel spec;

    public int getCode() {
        return this.code;
    }

    public int getDlvy() {
        return this.dlvy;
    }

    public String getExt() {
        return this.ext;
    }

    public String getMsg() {
        return this.msg;
    }

    public SpecModel getSpec() {
        return this.spec;
    }

    public void setCode(int i4) {
        this.code = i4;
    }

    public void setDlvy(int i4) {
        this.dlvy = i4;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSpec(SpecModel specModel) {
        this.spec = specModel;
    }
}
