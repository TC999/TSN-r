package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class CampaignUnit implements NoProGuard, Serializable {
    public static final String JSON_KEY_ADS = "ads";
    public static final String JSON_KEY_AD_HTML = "cam_html";
    public static final String JSON_KEY_AD_TYPE = "ad_type";
    public static final String JSON_KEY_AD_ZIP = "cam_tpl_url";
    public static final String JSON_KEY_BANNER_HTML = "cam_html";
    public static final String JSON_KEY_BANNER_URL = "cam_tpl_url";
    public static final String JSON_KEY_CSP = "csp";
    public static final String JSON_KEY_DO = "do";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_END_SCREEN_URL = "end_screen_url";
    public static final String JSON_KEY_FRAME_ADS = "frames";
    public static final String JSON_KEY_HTML_URL = "html_url";
    public static final String JSON_KEY_IA_EXT1 = "ia_all_ext1";
    public static final String JSON_KEY_IA_EXT2 = "ia_all_ext2";
    public static final String JSON_KEY_IA_ICON = "ia_icon";
    public static final String JSON_KEY_IA_ORI = "ia_ori";
    public static final String JSON_KEY_IA_RST = "ia_rst";
    public static final String JSON_KEY_IA_URL = "ia_url";
    public static final String JSON_KEY_JM_DO = "jm_do";
    public static final String JSON_KEY_MOF_TEMPLATE_URL = "mof_template_url";
    public static final String JSON_KEY_MOF_TPLID = "mof_tplid";
    public static final String JSON_KEY_NSCPT = "nscpt";
    public static final String JSON_KEY_ONLY_IMPRESSION_URL = "only_impression_url";
    public static final String JSON_KEY_PARENT_SESSION_ID = "parent_session_id";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_REPLACE_TMP = "replace_tmp";
    public static final String JSON_KEY_REQ_EXT_DATA = "req_ext_data";
    public static final String JSON_KEY_RKS = "rks";
    public static final String JSON_KEY_SESSION_ID = "a";
    public static final String JSON_KEY_SH = "sh";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_UNIT_SIZE = "unit_size";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String KEY_IRLFA = "irlfa";
    private static final String TAG = CampaignUnit.class.getSimpleName();
    private static final long serialVersionUID = 1;
    private String adHtml;
    private int adType;
    private String adZip;
    public ArrayList<CampaignEx> ads;
    private String bannerHtml;
    private String bannerUrl;
    private String csp;
    private String domain;
    private HashMap<String, String> epMap;
    private String htmlUrl;
    private String ia_all_ext1;
    private String ia_all_ext2;
    private String ia_icon;
    private int ia_ori;
    private int ia_rst;
    private String ia_url;
    private int jmDo;
    private List<Frame> listFrames;
    private String onlyImpressionUrl;
    private String parentSessionId;
    private String requestId;
    private HashMap<String, String> rks;
    private String sessionId;
    private String sh;
    private int template;
    private int tokenRule;
    private String unitSize;
    private int vcn;
    private String msg = "";
    private StringBuffer cParams = new StringBuffer();
    private String encryptPrice = "";

    private static void getSysIDAndBKUPID(JSONObject jSONObject) {
        FastKV fastKV = null;
        if (com.mbridge.msdk.foundation.controller.b.a().d()) {
            try {
                fastKV = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), s.b("H+tU+FeXHM==")).build();
            } catch (Exception unused) {
            }
        }
        if (fastKV != null) {
            try {
                Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                if (jSONObject == null || j4 == null) {
                    return;
                }
                String optString = jSONObject.optString("b");
                if (!TextUtils.isEmpty(optString) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.f39391s, optString)) {
                    com.mbridge.msdk.foundation.same.a.f39391s = optString;
                    com.mbridge.msdk.foundation.a.a.a.a().a("b", com.mbridge.msdk.foundation.same.a.f39391s);
                    try {
                        fastKV.putString(s.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.f39391s);
                    } catch (Exception unused2) {
                    }
                }
                String optString2 = jSONObject.optString("c");
                if (TextUtils.isEmpty(optString2) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.f39392t, optString2)) {
                    return;
                }
                com.mbridge.msdk.foundation.same.a.f39392t = optString2;
                com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f39392t);
                try {
                    fastKV.putString(s.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f39392t);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        try {
            Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (jSONObject == null || j5 == null) {
                return;
            }
            String optString3 = jSONObject.optString("b");
            if (!TextUtils.isEmpty(optString3) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.f39391s, optString3)) {
                com.mbridge.msdk.foundation.same.a.f39391s = optString3;
                com.mbridge.msdk.foundation.a.a.a.a().a("b", com.mbridge.msdk.foundation.same.a.f39391s);
                SharedPreferences sharedPreferences = j5.getSharedPreferences(s.b("H+tU+FeXHM=="), 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(s.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.f39391s);
                    edit.apply();
                }
            }
            String optString4 = jSONObject.optString("c");
            if (TextUtils.isEmpty(optString4) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.f39392t, optString4)) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.f39392t = optString4;
            com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f39392t);
            SharedPreferences sharedPreferences2 = j5.getSharedPreferences(s.b("H+tU+FeXHM=="), 0);
            if (sharedPreferences2 != null) {
                SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                edit2.putString(s.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f39392t);
                edit2.apply();
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private Object nullToEmpty(Object obj) {
        return obj == null ? "" : obj;
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject) {
        return parseCampaignUnit(jSONObject, "");
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject) {
        return parseV5CampaignUnit(jSONObject, "");
    }

    public String assembCParams() {
        String str;
        String str2;
        StringBuffer stringBuffer = this.cParams;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            return this.cParams.toString();
        }
        try {
            String E = t.E();
            String e4 = com.mbridge.msdk.foundation.tools.e.e(com.mbridge.msdk.foundation.controller.a.f().j());
            String d4 = com.mbridge.msdk.foundation.tools.e.d(com.mbridge.msdk.foundation.controller.a.f().j());
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                str = String.valueOf(t.D(com.mbridge.msdk.foundation.controller.a.f().j()));
                str2 = t.x(com.mbridge.msdk.foundation.controller.a.f().j()) + "x" + t.y(com.mbridge.msdk.foundation.controller.a.f().j());
            } else {
                str = "";
                str2 = str;
            }
            StringBuffer stringBuffer2 = this.cParams;
            stringBuffer2.append(getAdType());
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty("1"));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(Build.VERSION.RELEASE));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(MBConfiguration.SDK_VERSION));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(t.x()));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(str2));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(Integer.valueOf(t.t(com.mbridge.msdk.foundation.controller.a.f().j()))));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(t.s(com.mbridge.msdk.foundation.controller.a.f().j())));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(str));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(d4));
            stringBuffer2.append(nullToEmpty(e4));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(com.mbridge.msdk.foundation.tools.e.b(com.mbridge.msdk.foundation.controller.a.f().j())));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(com.mbridge.msdk.foundation.tools.e.i(com.mbridge.msdk.foundation.controller.a.f().j())));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(com.mbridge.msdk.foundation.tools.e.g(com.mbridge.msdk.foundation.controller.a.f().j())));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(E));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(""));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(t.z()));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(""));
            stringBuffer2.append("|");
            stringBuffer2.append("");
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(""));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(com.mbridge.msdk.foundation.same.a.f39391s + "," + com.mbridge.msdk.foundation.same.a.f39392t));
            stringBuffer2.append("|");
            this.cParams = stringBuffer2;
        } catch (Throwable th) {
            x.b(TAG, th.getMessage(), th);
        }
        return this.cParams.toString();
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public ArrayList<CampaignEx> getAds() {
        return this.ads;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getCsp() {
        return this.csp;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public HashMap<String, String> getEpMap() {
        return this.epMap;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getIa_all_ext1() {
        return this.ia_all_ext1;
    }

    public String getIa_all_ext2() {
        return this.ia_all_ext2;
    }

    public String getIa_icon() {
        return this.ia_icon;
    }

    public int getIa_ori() {
        return this.ia_ori;
    }

    public int getIa_rst() {
        return this.ia_rst;
    }

    public String getIa_url() {
        return this.ia_url;
    }

    public int getJmDo() {
        return this.jmDo;
    }

    public List<Frame> getListFrames() {
        return this.listFrames;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getOnlyImpressionUrl() {
        return this.onlyImpressionUrl;
    }

    public String getParentSessionId() {
        return this.parentSessionId;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionUrl)) {
                return "";
            }
            Uri parse = Uri.parse(this.onlyImpressionUrl);
            if (parse != null) {
                this.requestId = parse.getQueryParameter("k");
            }
            return this.requestId;
        } catch (Exception unused) {
            return "";
        }
    }

    public HashMap<String, String> getRks() {
        return this.rks;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSh() {
        return this.sh;
    }

    public int getTemplate() {
        return this.template;
    }

    public int getTokenRule() {
        int i4 = this.tokenRule;
        if (i4 == 1) {
            return i4;
        }
        return 0;
    }

    public String getUnitSize() {
        return this.unitSize;
    }

    public int getVcn() {
        int i4 = this.vcn;
        if (i4 > 1) {
            return i4;
        }
        return 1;
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public void setAdType(int i4) {
        this.adType = i4;
    }

    public void setAdZip(String str) {
        this.adZip = str;
    }

    public void setAds(ArrayList<CampaignEx> arrayList) {
        this.ads = arrayList;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setCsp(String str) {
        this.csp = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public void setEpMap(HashMap<String, String> hashMap) {
        this.epMap = hashMap;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setIa_all_ext1(String str) {
        this.ia_all_ext1 = str;
    }

    public void setIa_all_ext2(String str) {
        this.ia_all_ext2 = str;
    }

    public void setIa_icon(String str) {
        this.ia_icon = str;
    }

    public void setIa_ori(int i4) {
        this.ia_ori = i4;
    }

    public void setIa_rst(int i4) {
        this.ia_rst = i4;
    }

    public void setIa_url(String str) {
        this.ia_url = str;
    }

    public void setJmDo(int i4) {
        this.jmDo = i4;
    }

    public void setListFrames(List<Frame> list) {
        this.listFrames = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setOnlyImpressionUrl(String str) {
        this.onlyImpressionUrl = str;
    }

    public void setParentSessionId(String str) {
        this.parentSessionId = str;
    }

    public void setRks(HashMap<String, String> hashMap) {
        this.rks = hashMap;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSh(String str) {
        this.sh = str;
    }

    public void setTemplate(int i4) {
        this.template = i4;
    }

    public void setTokenRule(int i4) {
        this.tokenRule = i4;
    }

    public void setUnitSize(String str) {
        this.unitSize = str;
    }

    public void setVcn(int i4) {
        this.vcn = i4;
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject, String str) {
        CampaignUnit campaignUnit;
        CampaignUnit campaignUnit2;
        String str2;
        String str3;
        ArrayList arrayList;
        CampaignUnit campaignUnit3;
        int i4;
        String str4;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject2 = jSONObject;
        String str8 = JSON_KEY_ADS;
        String str9 = "template";
        String str10 = "only_impression_url";
        String str11 = "html_url";
        if (jSONObject2 == null) {
            return null;
        }
        try {
            CampaignUnit campaignUnit4 = new CampaignUnit();
            try {
                String optString = jSONObject2.optString(JSON_KEY_RKS);
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(optString);
                        Iterator<String> keys = jSONObject3.keys();
                        HashMap<String, String> hashMap = new HashMap<>();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject3.optString(next));
                        }
                        campaignUnit4.setRks(hashMap);
                    } catch (Exception unused) {
                        campaignUnit = campaignUnit4;
                        x.d(TAG, "parse campaign unit exception");
                        return campaignUnit;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put("encrypt_p", "");
                    hashMap2.put(KEY_IRLFA, "");
                    campaignUnit4.setEpMap(hashMap2);
                }
                JSONObject optJSONObject = jSONObject2.optJSONObject(JSON_KEY_REQ_EXT_DATA);
                int optInt = jSONObject2.optInt(JSON_KEY_NSCPT, 1);
                String optString2 = jSONObject2.optString(JSON_KEY_MOF_TEMPLATE_URL, "");
                int optInt2 = jSONObject2.optInt(JSON_KEY_MOF_TPLID, 0);
                String jSONObject4 = optJSONObject != null ? optJSONObject.toString() : "";
                new JSONArray();
                JSONArray optJSONArray = jSONObject2.optJSONArray("pv_urls");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    str2 = jSONObject4;
                    str3 = optString2;
                    arrayList = null;
                } else {
                    str2 = jSONObject4;
                    arrayList = new ArrayList(optJSONArray.length());
                    str3 = optString2;
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        arrayList.add(optJSONArray.getString(i5));
                    }
                }
                com.mbridge.msdk.foundation.db.a.a.a().a(jSONObject2.optJSONObject(JSON_KEY_REPLACE_TMP), true);
                getSysIDAndBKUPID(jSONObject);
                campaignUnit4.setSessionId(jSONObject2.optString("a"));
                campaignUnit4.setParentSessionId(jSONObject2.optString("parent_session_id"));
                campaignUnit4.setAdType(jSONObject2.optInt("ad_type"));
                campaignUnit4.setUnitSize(jSONObject2.optString("unit_size"));
                campaignUnit4.setHtmlUrl(jSONObject2.optString("html_url"));
                campaignUnit4.setOnlyImpressionUrl(jSONObject2.optString("only_impression_url"));
                campaignUnit4.setTemplate(jSONObject2.optInt("template"));
                campaignUnit4.setJmDo(jSONObject2.optInt(JSON_KEY_JM_DO));
                campaignUnit4.setIa_icon(jSONObject2.optString("ia_icon"));
                campaignUnit4.setIa_rst(jSONObject2.optInt("ia_rst"));
                campaignUnit4.setIa_url(jSONObject2.optString("ia_url"));
                campaignUnit4.setIa_ori(jSONObject2.optInt("ia_ori"));
                campaignUnit4.setIa_all_ext1(jSONObject2.optString(JSON_KEY_IA_EXT1));
                campaignUnit4.setIa_all_ext2(jSONObject2.optString(JSON_KEY_IA_EXT2));
                campaignUnit4.setVcn(jSONObject2.optInt("vcn"));
                campaignUnit4.setTokenRule(jSONObject2.optInt("token_r"));
                campaignUnit4.setEncryptPrice(jSONObject2.optString("encrypt_p"));
                JSONArray optJSONArray2 = jSONObject2.optJSONArray(JSON_KEY_ADS);
                JSONArray optJSONArray3 = jSONObject2.optJSONArray("frames");
                String str12 = "end_screen_url";
                if (optJSONArray3 != null) {
                    try {
                        if (optJSONArray3.length() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            String str13 = "parse campaign error ,campaign is null";
                            ArrayList arrayList3 = arrayList;
                            int i6 = 0;
                            while (i6 < optJSONArray3.length()) {
                                JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i6);
                                int i7 = i6;
                                JSONArray jSONArray = optJSONObject2.getJSONArray(str8);
                                String str14 = str8;
                                ArrayList arrayList4 = new ArrayList();
                                String str15 = str9;
                                JSONObject jSONObject5 = optJSONObject2;
                                int i8 = 0;
                                while (i8 < jSONArray.length()) {
                                    JSONObject optJSONObject3 = jSONArray.optJSONObject(i8);
                                    String optString3 = jSONObject2.optString(str10);
                                    String optString4 = jSONObject2.optString(str11);
                                    String str16 = str12;
                                    String str17 = str13;
                                    JSONObject jSONObject6 = jSONObject5;
                                    JSONArray jSONArray2 = optJSONArray3;
                                    String str18 = str2;
                                    String str19 = str11;
                                    String str20 = str3;
                                    String str21 = str10;
                                    ArrayList arrayList5 = arrayList2;
                                    ArrayList arrayList6 = arrayList3;
                                    int i9 = i7;
                                    JSONArray jSONArray3 = jSONArray;
                                    int i10 = optInt;
                                    CampaignUnit campaignUnit5 = campaignUnit4;
                                    try {
                                        CampaignEx parseCampaign = CampaignEx.parseCampaign(optJSONObject3, optString3, optString4, jSONObject2.optString(str12), false, campaignUnit4, str);
                                        if (parseCampaign != null) {
                                            try {
                                                parseCampaign.setKeyIaUrl(campaignUnit5.getIa_url());
                                                parseCampaign.setKeyIaOri(campaignUnit5.getIa_ori());
                                                parseCampaign.setKeyIaRst(campaignUnit5.getIa_rst());
                                                parseCampaign.setKeyIaIcon(campaignUnit5.getIa_icon());
                                                parseCampaign.setAdType(jSONObject2.optInt("ad_type"));
                                                parseCampaign.setIa_ext1(jSONObject2.optString(CampaignEx.KEY_IA_EXT1));
                                                parseCampaign.setIa_ext2(jSONObject2.optString(CampaignEx.KEY_IA_EXT2));
                                                parseCampaign.setVcn(campaignUnit5.getVcn());
                                                parseCampaign.setTokenRule(campaignUnit5.getTokenRule());
                                                parseCampaign.setEncryptPrice(campaignUnit5.getEncryptPrice());
                                                parseCampaign.setMof_tplid(optInt2);
                                                parseCampaign.setMof_template_url(str20);
                                                i4 = i10;
                                                parseCampaign.setNscpt(i4);
                                                parseCampaign.setPv_urls(arrayList6);
                                                str4 = str18;
                                                parseCampaign.setReq_ext_data(str4);
                                                arrayList4.add(parseCampaign);
                                                campaignUnit3 = campaignUnit5;
                                                str5 = str17;
                                            } catch (Exception unused2) {
                                                campaignUnit = campaignUnit5;
                                                x.d(TAG, "parse campaign unit exception");
                                                return campaignUnit;
                                            }
                                        } else {
                                            str4 = str18;
                                            i4 = i10;
                                            campaignUnit3 = campaignUnit5;
                                            str5 = str17;
                                            try {
                                                campaignUnit3.setMsg(str5);
                                            } catch (Exception unused3) {
                                                campaignUnit = campaignUnit3;
                                                x.d(TAG, "parse campaign unit exception");
                                                return campaignUnit;
                                            }
                                        }
                                        i8++;
                                        arrayList3 = arrayList6;
                                        str10 = str21;
                                        arrayList2 = arrayList5;
                                        str12 = str16;
                                        jSONObject5 = jSONObject6;
                                        str3 = str20;
                                        str11 = str19;
                                        str2 = str4;
                                        optInt = i4;
                                        campaignUnit4 = campaignUnit3;
                                        jSONArray = jSONArray3;
                                        i7 = i9;
                                        str13 = str5;
                                        optJSONArray3 = jSONArray2;
                                    } catch (Exception unused4) {
                                        campaignUnit3 = campaignUnit5;
                                        campaignUnit = campaignUnit3;
                                        x.d(TAG, "parse campaign unit exception");
                                        return campaignUnit;
                                    }
                                }
                                CampaignUnit campaignUnit6 = campaignUnit4;
                                JSONObject jSONObject7 = jSONObject5;
                                ArrayList arrayList7 = arrayList2;
                                int i11 = optInt;
                                String str22 = str2;
                                String str23 = str11;
                                Frame frame = new Frame();
                                frame.setParentSessionId(jSONObject2.optString("parent_session_id"));
                                frame.setSessionId(jSONObject2.optString("a"));
                                frame.setCampaigns(arrayList4);
                                frame.setTemplate(jSONObject7.optInt(str15));
                                arrayList7.add(frame);
                                arrayList2 = arrayList7;
                                arrayList3 = arrayList3;
                                str10 = str10;
                                str8 = str14;
                                str3 = str3;
                                str11 = str23;
                                str2 = str22;
                                optInt = i11;
                                campaignUnit4 = campaignUnit6;
                                i6 = i7 + 1;
                                str9 = str15;
                                str12 = str12;
                                str13 = str13;
                                optJSONArray3 = optJSONArray3;
                            }
                            campaignUnit3 = campaignUnit4;
                            campaignUnit3.setListFrames(arrayList2);
                            campaignUnit2 = campaignUnit3;
                            return campaignUnit2;
                        }
                    } catch (Exception unused5) {
                        campaignUnit3 = campaignUnit4;
                    }
                }
                String str24 = "end_screen_url";
                String str25 = "parse campaign error ,campaign is null";
                String str26 = str3;
                String str27 = "only_impression_url";
                ArrayList arrayList8 = arrayList;
                campaignUnit3 = campaignUnit4;
                int i12 = optInt;
                String str28 = str2;
                String str29 = "html_url";
                if (optJSONArray2 != null) {
                    try {
                        if (optJSONArray2.length() > 0) {
                            ArrayList<CampaignEx> arrayList9 = new ArrayList<>();
                            int i13 = 0;
                            while (i13 < optJSONArray2.length()) {
                                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i13);
                                String str30 = str27;
                                String optString5 = jSONObject2.optString(str30);
                                String str31 = str29;
                                String optString6 = jSONObject2.optString(str31);
                                CampaignUnit campaignUnit7 = campaignUnit3;
                                String str32 = str24;
                                try {
                                    String optString7 = jSONObject2.optString(str32);
                                    String str33 = str25;
                                    JSONArray jSONArray4 = optJSONArray2;
                                    String str34 = str28;
                                    int i14 = i12;
                                    try {
                                        CampaignEx parseCampaign2 = CampaignEx.parseCampaign(optJSONObject4, optString5, optString6, optString7, false, campaignUnit7, str);
                                        if (parseCampaign2 != null) {
                                            try {
                                                parseCampaign2.setMof_tplid(optInt2);
                                                parseCampaign2.setMof_template_url(str26);
                                                parseCampaign2.setNscpt(i14);
                                                parseCampaign2.setPv_urls(arrayList8);
                                                str6 = str34;
                                                parseCampaign2.setReq_ext_data(str6);
                                                parseCampaign2.setVcn(campaignUnit7.getVcn());
                                                parseCampaign2.setTokenRule(campaignUnit7.getTokenRule());
                                                parseCampaign2.setEncryptPrice(campaignUnit7.getEncryptPrice());
                                                arrayList9.add(parseCampaign2);
                                                campaignUnit2 = campaignUnit7;
                                                str7 = str33;
                                            } catch (Exception unused6) {
                                                campaignUnit = campaignUnit7;
                                                x.d(TAG, "parse campaign unit exception");
                                                return campaignUnit;
                                            }
                                        } else {
                                            str6 = str34;
                                            campaignUnit2 = campaignUnit7;
                                            str7 = str33;
                                            try {
                                                campaignUnit2.setMsg(str7);
                                            } catch (Exception unused7) {
                                                campaignUnit = campaignUnit2;
                                                x.d(TAG, "parse campaign unit exception");
                                                return campaignUnit;
                                            }
                                        }
                                        i13++;
                                        i12 = i14;
                                        str27 = str30;
                                        str29 = str31;
                                        optJSONArray2 = jSONArray4;
                                        campaignUnit3 = campaignUnit2;
                                        str28 = str6;
                                        str24 = str32;
                                        jSONObject2 = jSONObject;
                                        str25 = str7;
                                    } catch (Exception unused8) {
                                        campaignUnit2 = campaignUnit7;
                                        campaignUnit = campaignUnit2;
                                        x.d(TAG, "parse campaign unit exception");
                                        return campaignUnit;
                                    }
                                } catch (Exception unused9) {
                                    campaignUnit2 = campaignUnit7;
                                }
                            }
                            campaignUnit2 = campaignUnit3;
                            campaignUnit2.setAds(arrayList9);
                            return campaignUnit2;
                        }
                    } catch (Exception unused10) {
                        campaignUnit2 = campaignUnit3;
                    }
                }
                campaignUnit2 = campaignUnit3;
                return campaignUnit2;
            } catch (Exception unused11) {
                campaignUnit2 = campaignUnit4;
            }
        } catch (Exception unused12) {
            campaignUnit = null;
        }
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject, String str) {
        return parseCampaignUnit(jSONObject, str);
    }
}
