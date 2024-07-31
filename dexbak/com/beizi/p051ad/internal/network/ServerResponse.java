package com.beizi.p051ad.internal.network;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.AdClickReportListener;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.ClickTracker;
import com.beizi.p051ad.internal.CreativeType;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.p051ad.internal.activity.BrowserAdActivity;
import com.beizi.p051ad.internal.nativead.BeiZiNativeAdResponse;
import com.beizi.p051ad.internal.p057a.MediationAd;
import com.beizi.p051ad.internal.utilities.HTTPResponse;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.JsonUtil;
import com.beizi.p051ad.internal.utilities.ReportEventUtil;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.utilities.UrlUtil;
import com.beizi.p051ad.internal.utilities.WebviewUtil;
import com.beizi.p051ad.lance.ApkBean;
import com.beizi.p051ad.lance.p062a.BeiZiExecutor;
import com.beizi.p051ad.lance.p062a.FileUtil;
import com.beizi.p051ad.lance.p062a.HeaderUtil;
import com.beizi.p051ad.lance.p062a.JumpTool;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.p056c.AdResponseOuterClass;
import com.beizi.p051ad.p056c.ClickPositionModel;
import com.beizi.p051ad.p056c.EnumType;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* renamed from: com.beizi.ad.internal.network.ServerResponse */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ServerResponse {
    public static final String EXTRAS_KEY_MRAID = "MRAID";
    public static final String EXTRAS_KEY_ORIENTATION = "ORIENTATION";
    public static final String EXTRAS_KEY_REWARD_ITEM = "REWARD_ITEM";
    public static final String EXTRAS_KEY_SCALE = "SCALE";

    /* renamed from: A */
    private int f10313A;

    /* renamed from: B */
    private String f10314B;

    /* renamed from: C */
    private String f10315C;

    /* renamed from: D */
    private String f10316D;

    /* renamed from: E */
    private String f10317E;

    /* renamed from: F */
    private String f10318F;

    /* renamed from: G */
    private String f10319G;

    /* renamed from: H */
    private String f10320H;

    /* renamed from: I */
    private String f10321I;

    /* renamed from: J */
    private String f10322J;

    /* renamed from: K */
    private String f10323K;

    /* renamed from: L */
    private String f10324L;

    /* renamed from: M */
    private AdResponseOuterClass.C2793b.C2794a f10325M;

    /* renamed from: N */
    private boolean f10326N;

    /* renamed from: O */
    private AdResponseOuterClass.C2793b f10327O;

    /* renamed from: P */
    private List<AdResponseOuterClass.C2803h> f10328P;

    /* renamed from: Q */
    private String f10329Q;

    /* renamed from: R */
    private String f10330R;

    /* renamed from: S */
    private List<Pair<CreativeType, String>> f10331S;

    /* renamed from: T */
    private String f10332T;

    /* renamed from: U */
    private String f10333U;

    /* renamed from: V */
    private String f10334V;

    /* renamed from: W */
    private String f10335W;

    /* renamed from: X */
    private LinkedList<String> f10336X;

    /* renamed from: Y */
    private LinkedList<MediationAd> f10337Y;

    /* renamed from: Z */
    private HashMap<String, Object> f10338Z;

    /* renamed from: a */
    private String f10339a;

    /* renamed from: aa */
    private boolean f10340aa;

    /* renamed from: ab */
    private boolean f10341ab;

    /* renamed from: ac */
    private String f10342ac;

    /* renamed from: ad */
    private String f10343ad;

    /* renamed from: ae */
    private String f10344ae;

    /* renamed from: af */
    private String f10345af;

    /* renamed from: ag */
    private String f10346ag;

    /* renamed from: ah */
    private BeiZiNativeAdResponse f10347ah;

    /* renamed from: b */
    private String f10348b;

    /* renamed from: c */
    private EnumType.EnumC2812a f10349c;

    /* renamed from: d */
    private int f10350d;

    /* renamed from: e */
    private int f10351e;

    /* renamed from: f */
    private int f10352f;

    /* renamed from: g */
    private int f10353g;

    /* renamed from: h */
    private int f10354h;

    /* renamed from: i */
    private int f10355i;

    /* renamed from: j */
    private boolean f10356j;

    /* renamed from: k */
    private boolean f10357k;

    /* renamed from: l */
    private boolean f10358l;

    /* renamed from: m */
    private boolean f10359m;
    public String mDetectClickUrl;
    public String mDetectViewUrl;
    public EnumC2888k mMediaType;

    /* renamed from: n */
    private boolean f10360n;

    /* renamed from: o */
    private boolean f10361o;

    /* renamed from: p */
    private int f10362p;

    /* renamed from: q */
    private int f10363q;

    /* renamed from: r */
    private boolean f10364r;

    /* renamed from: s */
    private int f10365s;

    /* renamed from: t */
    private AdLogoInfo f10366t;

    /* renamed from: u */
    private AdLogoInfo f10367u;

    /* renamed from: v */
    private boolean f10368v;

    /* renamed from: w */
    private String f10369w;

    /* renamed from: x */
    private boolean f10370x;

    /* renamed from: y */
    private AdResponseOuterClass.C2793b.C2796c f10371y;

    /* renamed from: z */
    private AdResponseOuterClass.C2793b.C2795b f10372z;

    /* renamed from: com.beizi.ad.internal.network.ServerResponse$AdLogoInfo */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class AdLogoInfo {
        public static int TYPE_PIC = 0;
        public static int TYPE_TEXT = 1;
        String adurl;
        int type = 0;

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdurl(String str) {
            this.adurl = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i) {
            this.type = i;
        }

        public String getAdurl() {
            return this.adurl;
        }

        public int getType() {
            return this.type;
        }
    }

    public ServerResponse(HTTPResponse hTTPResponse, EnumC2888k enumC2888k) {
        this.f10350d = 0;
        this.f10351e = 1;
        this.f10352f = 0;
        this.f10353g = 0;
        this.f10354h = 0;
        this.f10355i = 0;
        this.f10356j = false;
        this.f10357k = true;
        this.f10358l = false;
        this.f10359m = false;
        this.f10360n = false;
        this.f10361o = false;
        this.f10362p = 0;
        this.f10363q = 0;
        this.f10364r = false;
        this.f10365s = 0;
        this.f10366t = new AdLogoInfo();
        this.f10367u = new AdLogoInfo();
        this.f10368v = false;
        this.f10370x = false;
        this.f10331S = new LinkedList();
        this.f10336X = new LinkedList<>();
        this.f10337Y = new LinkedList<>();
        this.f10338Z = new HashMap<>();
        this.f10340aa = false;
        this.f10341ab = false;
        this.mMediaType = enumC2888k;
        m49357a(hTTPResponse.getHeaders());
        try {
            m49361a(AdResponseOuterClass.C2804i.m49911a(hTTPResponse.getResponseBinaryBody().toByteArray()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private boolean m49350c(AdResponseOuterClass.C2804i c2804i) {
        if (c2804i.m49918a() > 0) {
            AdResponseOuterClass.C2805j c2805j = c2804i.m49903e().get(0);
            this.f10339a = c2805j.m49902a();
            this.f10348b = c2805j.m49894b();
            this.f10349c = c2805j.m49890c();
            this.f10350d = c2805j.m49886d();
            this.f10351e = c2805j.m49882e() == EnumType.EnumC2819h.PORTRAIT ? 1 : 2;
            this.f10355i = Integer.parseInt(c2805j.m49878f());
            this.f10354h = Integer.parseInt(c2805j.m49876g());
            if (c2805j.m49875h() != null && (getAdType() == EnumType.EnumC2812a.ADP_TABLE || getAdType() == EnumType.EnumC2812a.ADP_CUSTOMER)) {
                AdResponseOuterClass.C2802g m49875h = c2805j.m49875h();
                this.f10352f = Integer.parseInt(m49875h.m49935a());
                this.f10353g = Integer.parseInt(m49875h.m49933b());
            } else if (!StringUtil.isEmpty(c2805j.m49894b()) && getAdType() == EnumType.EnumC2812a.ADP_IVIDEO) {
                addToExtras(EXTRAS_KEY_REWARD_ITEM, c2805j.m49894b());
            }
            this.f10356j = c2805j.m49868o();
            this.f10357k = c2805j.m49870m();
            this.f10358l = c2805j.m49866q();
            this.f10359m = c2805j.m49869n();
            this.f10360n = c2805j.m49874i();
            this.f10361o = c2805j.m49872k();
            this.f10362p = c2805j.m49871l();
            this.f10363q = c2805j.m49873j();
            this.f10364r = c2805j.m49867p();
            List<AdResponseOuterClass.C2799d> m49865r = c2805j.m49865r();
            if (m49865r != null && m49865r.size() > 0) {
                this.f10369w = m49865r.get(0).m49943i();
                this.f10330R = m49865r.get(0).m49952b();
            }
            if (this.f10356j && this.f10355i == 0 && this.f10354h == 0) {
                this.f10355i = PredefinedCaptureConfigurations.f24404n;
                this.f10354h = PredefinedCaptureConfigurations.f24405o;
            }
            if (c2805j.m49864s() > 0) {
                int i = 0;
                for (AdResponseOuterClass.C2799d c2799d : c2805j.m49865r()) {
                    if (i == 0) {
                        this.f10330R = c2799d.m49952b();
                        LogUtil.m49046a("BeiZisAd", "mAdid = " + this.f10330R);
                    }
                    if (c2799d.m49944h() <= 0 || c2799d.m49945g().get(0) == null) {
                        this.f10329Q = c2799d.m49957a();
                        AdResponseOuterClass.C2798c m49947e = c2799d.m49947e();
                        if (m49947e != null) {
                            if (m49947e.m49965a() != null) {
                                this.f10366t.setAdurl(m49947e.m49965a());
                                this.f10366t.setType(AdLogoInfo.TYPE_PIC);
                            } else {
                                this.f10366t.setAdurl(m49947e.m49963b());
                                this.f10366t.setType(AdLogoInfo.TYPE_TEXT);
                            }
                            if (m49947e.m49961c() != null) {
                                this.f10367u.setAdurl(m49947e.m49961c());
                                this.f10367u.setType(AdLogoInfo.TYPE_PIC);
                            } else {
                                this.f10367u.setAdurl(m49947e.m49959d());
                                this.f10367u.setType(AdLogoInfo.TYPE_TEXT);
                            }
                        }
                        if (c2799d.m49948d() > 0) {
                            for (AdResponseOuterClass.C2792a c2792a : c2799d.m49946f()) {
                                if (this.f10357k) {
                                    for (int i2 = 0; i2 < c2792a.m50043d(); i2++) {
                                        if (!StringUtil.isEmpty(c2792a.m50044c().get(i2).m49942a())) {
                                            this.f10336X.add(c2792a.m50044c().get(i2).m49940b());
                                        }
                                    }
                                }
                                m49359a(c2792a.m50045b());
                                if ((c2792a.m50049a() == EnumType.EnumC2817f.RENDER_VIDEO || c2792a.m50049a() == EnumType.EnumC2817f.RENDER_VAST_VIDEO) && c2792a.m50043d() > 0) {
                                    this.f10331S.add(Pair.create(CreativeType.VIDEO, c2792a.m50044c().get(0).m49940b()));
                                } else {
                                    String m49363a = m49363a(c2792a);
                                    this.f10331S.add(Pair.create(CreativeType.HTML, m49363a));
                                    if (m49363a.contains("mraid.js")) {
                                        addToExtras(EXTRAS_KEY_MRAID, Boolean.TRUE);
                                    }
                                }
                            }
                        }
                        if (c2799d.m49950c() != null) {
                            AdResponseOuterClass.C2793b m49950c = c2799d.m49950c();
                            m49362a(m49950c);
                            this.f10333U = m49950c.m50042a();
                            this.f10335W = m49950c.m50021h();
                            this.f10334V = m49950c.m50034b();
                            AdResponseOuterClass.C2803h m50019i = m49950c.m50019i();
                            if (m50019i != null && !TextUtils.isEmpty(m50019i.m49931a())) {
                                this.mDetectViewUrl = m50019i.m49931a();
                            }
                            if (m50019i != null && !TextUtils.isEmpty(m50019i.m49929b())) {
                                this.mDetectClickUrl = m50019i.m49929b();
                            }
                            if (m50019i != null && !TextUtils.isEmpty(m50019i.m49927c())) {
                                this.f10332T = m50019i.m49927c();
                            }
                        }
                    }
                    i++;
                    if (!this.f10331S.isEmpty()) {
                        break;
                    }
                }
            }
        } else {
            HaoboLog.m49290e(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.blank_ad));
        }
        if (this.f10331S.isEmpty()) {
            return false;
        }
        this.f10340aa = true;
        return true;
    }

    /* renamed from: d */
    private boolean m49349d(AdResponseOuterClass.C2804i c2804i) {
        if (c2804i.m49918a() > 0) {
            for (AdResponseOuterClass.C2805j c2805j : c2804i.m49903e()) {
                this.f10357k = c2805j.m49870m();
                if (c2805j.m49864s() > 0) {
                    for (AdResponseOuterClass.C2799d c2799d : c2805j.m49865r()) {
                        if (c2799d.m49944h() <= 0 || c2799d.m49945g().get(0) == null) {
                            if (c2799d.m49948d() > 0) {
                                for (AdResponseOuterClass.C2792a c2792a : c2799d.m49946f()) {
                                    if (this.f10357k) {
                                        for (int i = 0; i < c2792a.m50043d(); i++) {
                                            if (!StringUtil.isEmpty(c2792a.m50044c().get(i).m49942a())) {
                                                this.f10336X.add(c2792a.m50044c().get(i).m49940b());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (this.f10336X.isEmpty()) {
            return false;
        }
        this.f10340aa = true;
        return true;
    }

    /* renamed from: e */
    private boolean m49348e(AdResponseOuterClass.C2804i c2804i) {
        if (c2804i.m49918a() > 0) {
            AdResponseOuterClass.C2805j c2805j = c2804i.m49903e().get(0);
            this.f10339a = c2805j.m49902a();
            this.f10348b = c2805j.m49894b();
            this.f10349c = c2805j.m49890c();
            this.f10350d = c2805j.m49886d();
            this.f10351e = c2805j.m49882e() == EnumType.EnumC2819h.PORTRAIT ? 1 : 2;
            this.f10355i = Integer.parseInt(c2805j.m49878f());
            this.f10354h = Integer.parseInt(c2805j.m49876g());
            List<AdResponseOuterClass.C2799d> m49865r = c2805j.m49865r();
            if (m49865r != null && m49865r.size() > 0) {
                this.f10369w = m49865r.get(0).m49943i();
                this.f10330R = m49865r.get(0).m49952b();
            }
            this.f10356j = c2805j.m49868o();
            this.f10357k = c2805j.m49870m();
            this.f10358l = c2805j.m49866q();
            this.f10359m = c2805j.m49869n();
            this.f10360n = c2805j.m49874i();
            this.f10361o = c2805j.m49872k();
            this.f10362p = c2805j.m49871l();
            this.f10363q = c2805j.m49873j();
            this.f10364r = c2805j.m49867p();
            if (this.f10356j && this.f10355i == 0 && this.f10354h == 0) {
                this.f10355i = PredefinedCaptureConfigurations.f24404n;
                this.f10354h = PredefinedCaptureConfigurations.f24405o;
            }
            if (c2805j.m49864s() > 0) {
                for (AdResponseOuterClass.C2799d c2799d : c2805j.m49865r()) {
                    if (c2799d.m49944h() <= 0 || c2799d.m49945g().get(0) == null) {
                        this.f10329Q = c2799d.m49957a();
                        if (c2799d.m49948d() >= 0) {
                            for (AdResponseOuterClass.C2792a c2792a : c2799d.m49946f()) {
                                if (this.f10357k) {
                                    for (int i = 0; i < c2792a.m50043d(); i++) {
                                        if (!StringUtil.isEmpty(c2792a.m50044c().get(i).m49942a())) {
                                            this.f10336X.add(c2792a.m50044c().get(i).m49940b());
                                        }
                                    }
                                }
                                if (c2792a.m50049a() == EnumType.EnumC2817f.RENDER_JSON && c2792a.m50043d() > 0) {
                                    try {
                                        AdResponseOuterClass.C2798c m49947e = c2799d.m49947e();
                                        if (m49947e != null) {
                                            if (m49947e.m49965a() != null) {
                                                this.f10366t.setAdurl(m49947e.m49965a());
                                                this.f10366t.setType(AdLogoInfo.TYPE_PIC);
                                            } else {
                                                this.f10366t.setAdurl(m49947e.m49963b());
                                                this.f10366t.setType(AdLogoInfo.TYPE_TEXT);
                                            }
                                            if (m49947e.m49961c() != null) {
                                                this.f10367u.setAdurl(m49947e.m49961c());
                                                this.f10367u.setType(AdLogoInfo.TYPE_PIC);
                                            } else {
                                                this.f10367u.setAdurl(m49947e.m49959d());
                                                this.f10367u.setType(AdLogoInfo.TYPE_TEXT);
                                            }
                                        }
                                        BeiZiNativeAdResponse m49433a = BeiZiNativeAdResponse.m49433a(new JSONObject(c2792a.m50045b()));
                                        this.f10347ah = m49433a;
                                        m49433a.m49427b(getLogoUrl());
                                        this.f10347ah.m49438a(getAdUrl());
                                        if (c2799d.m49950c() != null) {
                                            m49362a(c2799d.m49950c());
                                            AdResponseOuterClass.C2793b m49950c = c2799d.m49950c();
                                            this.f10333U = m49950c.m50042a();
                                            this.f10334V = m49950c.m50034b();
                                            this.f10335W = m49950c.m50021h();
                                            this.f10347ah.m49426b(!StringUtil.isEmpty(this.f10333U) ? this.f10333U : this.f10335W);
                                            this.f10347ah.m49421c(this.f10334V);
                                            this.f10347ah.m49449a(c2799d.m49950c());
                                            AdResponseOuterClass.C2803h m50019i = m49950c.m50019i();
                                            if (m50019i != null && !TextUtils.isEmpty(m50019i.m49931a())) {
                                                this.f10347ah.m49419d(m50019i.m49931a());
                                            }
                                            if (m50019i != null && !TextUtils.isEmpty(m50019i.m49929b())) {
                                                this.f10347ah.m49417e(m50019i.m49929b());
                                            }
                                            List<AdResponseOuterClass.C2803h> m50013l = m49950c.m50013l();
                                            if (m50013l != null && m50013l.size() > 0) {
                                                for (int i2 = 0; i2 < m50013l.size(); i2++) {
                                                    String m49929b = m50013l.get(i2).m49929b();
                                                    if (!TextUtils.isEmpty(m49929b)) {
                                                        this.f10347ah.m49417e(m49929b);
                                                    }
                                                    String m49931a = m50013l.get(i2).m49931a();
                                                    if (!TextUtils.isEmpty(m49931a)) {
                                                        this.f10347ah.m49419d(m49931a);
                                                    }
                                                }
                                            }
                                        }
                                    } catch (JSONException unused) {
                                    }
                                    if (this.f10347ah != null) {
                                        this.f10340aa = true;
                                        return true;
                                    }
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            }
        } else {
            HaoboLog.m49290e(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.blank_ad));
        }
        if (this.f10331S.isEmpty()) {
            return false;
        }
        this.f10340aa = true;
        return true;
    }

    /* renamed from: f */
    private boolean m49347f(AdResponseOuterClass.C2804i c2804i) {
        if (c2804i.m49918a() > 0) {
            AdResponseOuterClass.C2805j c2805j = c2804i.m49903e().get(0);
            List<AdResponseOuterClass.C2799d> m49865r = c2805j.m49865r();
            if (m49865r != null && m49865r.size() > 0) {
                AdResponseOuterClass.C2799d c2799d = m49865r.get(0);
                if (c2799d.m49950c() != null) {
                    AdResponseOuterClass.C2793b m49950c = c2799d.m49950c();
                    m49362a(m49950c);
                    this.f10333U = m49950c.m50042a();
                    this.f10335W = m49950c.m50021h();
                    AdResponseOuterClass.C2803h m50019i = m49950c.m50019i();
                    if (m50019i != null && !TextUtils.isEmpty(m50019i.m49931a())) {
                        this.mDetectViewUrl = m50019i.m49931a();
                    }
                    if (m50019i != null && !TextUtils.isEmpty(m50019i.m49929b())) {
                        this.mDetectClickUrl = m50019i.m49929b();
                    }
                    if (m50019i != null && !TextUtils.isEmpty(m50019i.m49927c())) {
                        this.f10332T = m50019i.m49927c();
                    }
                }
            }
            this.f10339a = c2805j.m49902a();
            this.f10348b = c2805j.m49894b();
            this.f10349c = c2805j.m49890c();
            this.f10350d = c2805j.m49886d();
            this.f10351e = c2805j.m49882e() == EnumType.EnumC2819h.PORTRAIT ? 1 : 2;
            this.f10354h = Integer.parseInt(c2805j.m49878f());
            this.f10355i = Integer.parseInt(c2805j.m49876g());
            List<AdResponseOuterClass.C2799d> m49865r2 = c2805j.m49865r();
            if (m49865r2 != null && m49865r2.size() > 0) {
                this.f10369w = m49865r2.get(0).m49943i();
                this.f10330R = m49865r2.get(0).m49952b();
            }
            this.f10352f = 0;
            this.f10353g = 0;
            if (c2805j.m49875h() != null && getAdType() == EnumType.EnumC2812a.ADP_TABLE) {
                AdResponseOuterClass.C2802g m49875h = c2805j.m49875h();
                this.f10352f = Integer.parseInt(m49875h.m49935a());
                this.f10353g = Integer.parseInt(m49875h.m49933b());
            }
            if (c2805j.m49864s() > 0) {
                for (AdResponseOuterClass.C2799d c2799d2 : c2805j.m49865r()) {
                    if (c2799d2.m49944h() > 0 && c2799d2.m49945g().get(0) != null) {
                        AdResponseOuterClass.C2801f c2801f = c2799d2.m49945g().get(0);
                        this.f10337Y.add(new MediationAd(c2801f.m49938a(), c2801f.m49936c(), this.f10355i, this.f10354h, c2801f.m49937b(), ""));
                    }
                }
            }
        }
        if (this.f10337Y.isEmpty()) {
            return false;
        }
        this.f10340aa = true;
        return true;
    }

    public void addToExtras(String str, Object obj) {
        this.f10338Z.put(str, obj);
    }

    public boolean containsAds() {
        return this.f10340aa;
    }

    public String getAdExtInfo() {
        return this.f10329Q;
    }

    public String getAdId() {
        return this.f10330R;
    }

    public AdResponseOuterClass.C2793b getAdInteractInfo() {
        return this.f10327O;
    }

    public int getAdOrientation() {
        return this.f10351e;
    }

    public EnumType.EnumC2812a getAdType() {
        return this.f10349c;
    }

    public AdLogoInfo getAdUrl() {
        return this.f10366t;
    }

    public String getApkName() {
        return this.f10314B;
    }

    public String getAppDesc() {
        return this.f10316D;
    }

    public String getAppDeveloper() {
        return this.f10319G;
    }

    public String getAppDownloadURL() {
        return this.f10317E;
    }

    public String getAppIcon() {
        return this.f10346ag;
    }

    public String getAppIconURL() {
        return this.f10323K;
    }

    public String getAppPermissionsDesc() {
        return this.f10320H;
    }

    public String getAppPermissionsUrl() {
        return this.f10321I;
    }

    public String getAppPrivacyUrl() {
        return this.f10322J;
    }

    public String getAppVersion() {
        return this.f10318F;
    }

    public String getAppintro() {
        return this.f10324L;
    }

    public List<Pair<CreativeType, String>> getCreatives() {
        return this.f10331S;
    }

    public HashMap<String, Object> getExtras() {
        return this.f10338Z;
    }

    public AdResponseOuterClass.C2793b.C2795b getFollowTrackExt() {
        return this.f10372z;
    }

    public int getHeight() {
        return this.f10354h;
    }

    public String getImageUrl() {
        return this.f10345af;
    }

    public int getInteractType() {
        return this.f10313A;
    }

    public int getLeft() {
        return this.f10352f;
    }

    public AdLogoInfo getLogoUrl() {
        return this.f10367u;
    }

    public int getMaxTimer() {
        return this.f10363q;
    }

    public LinkedList<MediationAd> getMediationAds() {
        return this.f10337Y;
    }

    public int getMinTimer() {
        return this.f10362p;
    }

    public NativeAdResponse getNativeAdResponse() {
        return this.f10347ah;
    }

    public String getPackageName() {
        return this.f10315C;
    }

    public LinkedList<String> getPrefetchResources() {
        return this.f10336X;
    }

    public String getPrice() {
        return this.f10369w;
    }

    public int getRefreshInterval() {
        return this.f10350d;
    }

    public String getSubTitle() {
        return this.f10343ad;
    }

    public String getTitle() {
        return this.f10342ac;
    }

    public int getTop() {
        return this.f10353g;
    }

    public AdResponseOuterClass.C2793b.C2796c getVideoTrackExt() {
        return this.f10371y;
    }

    public String getVideoUrl() {
        return this.f10344ae;
    }

    public int getWidth() {
        return this.f10355i;
    }

    public void handleClick(View view, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        String replaceToTouchEventUrl;
        LogUtil.m49046a("BeiZisAd", "handleClick========" + z);
        if (!z) {
            if (!StringUtil.isEmpty(this.mDetectClickUrl)) {
                this.mDetectClickUrl = UrlUtil.replaceToTouchEventUrl(this.mDetectClickUrl, str, str2, str3, str4, str5, str6, "");
                new ClickTracker(this.mDetectClickUrl).execute(new Void[0]);
                this.mDetectClickUrl = "";
            }
            if (this.f10327O != null && this.f10328P != null) {
                for (int i = 0; i < this.f10328P.size(); i++) {
                    AdResponseOuterClass.C2803h c2803h = this.f10328P.get(i);
                    if (c2803h != null && !TextUtils.isEmpty(c2803h.m49929b())) {
                        if (!TextUtils.isEmpty(str7)) {
                            replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl(c2803h.m49929b(), str, str2, str3, str4, str5, str6, "").replace("__REQUESTUUID__", str7);
                        } else {
                            replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl(c2803h.m49929b(), str, str2, str3, str4, str5, str6, "");
                        }
                        new ClickTracker(StringUtil.replaceClick(view, replaceToTouchEventUrl)).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
                    }
                }
                this.f10328P = null;
            }
        }
        LogUtil.m49046a("BeiZisAd", "mDeepLinkUrl:" + this.f10334V + ",appDownloadURL = " + this.f10317E + ",mLandingPageUrl = " + this.f10333U);
        Context context = view != null ? view.getContext() : null;
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f10334V)) {
            try {
                if (!JumpTool.m49050a(context, Uri.decode(this.f10334V)) && !FileUtil.m49059a(context, this.f10315C)) {
                    AdResponseOuterClass.C2793b.C2795b c2795b = this.f10372z;
                    if (c2795b != null) {
                        ReportEventUtil.report(c2795b.m49981j());
                    }
                    m49365a(context);
                    return;
                }
                AdResponseOuterClass.C2793b.C2795b c2795b2 = this.f10372z;
                if (c2795b2 != null) {
                    ReportEventUtil.report(c2795b2.m49983i());
                }
                m49355b(context);
                AdResponseOuterClass.C2793b.C2795b c2795b3 = this.f10372z;
                if (c2795b3 != null) {
                    ReportEventUtil.report(c2795b3.m49989f());
                    return;
                }
                return;
            } catch (Exception unused) {
                AdResponseOuterClass.C2793b.C2795b c2795b4 = this.f10372z;
                if (c2795b4 != null) {
                    ReportEventUtil.report(c2795b4.m49985h());
                }
                m49365a(context);
                return;
            }
        }
        m49365a(context);
    }

    public void handleConvert(View view) {
        String str = HaoboLog.baseLogTag;
        HaoboLog.m49290e(str, "handleClick called with convertUrl = " + this.f10332T);
        if (StringUtil.isEmpty(this.f10332T)) {
            return;
        }
        new ClickTracker(this.f10332T).execute(new Void[0]);
    }

    public void handleOnCompletion() {
        List<AdResponseOuterClass.C2803h> m50013l;
        AdResponseOuterClass.C2793b c2793b = this.f10327O;
        if (c2793b == null || (m50013l = c2793b.m50013l()) == null) {
            return;
        }
        for (int i = 0; i < m50013l.size(); i++) {
            UrlUtil.sendOnCompletionInfoToServer(m50013l.get(i));
        }
    }

    public void handleOnPause(View view) {
        List<AdResponseOuterClass.C2803h> m50013l;
        AdResponseOuterClass.C2793b c2793b = this.f10327O;
        if (c2793b == null || (m50013l = c2793b.m50013l()) == null) {
            return;
        }
        for (int i = 0; i < m50013l.size(); i++) {
            UrlUtil.sendOnPauseInfoToServer(m50013l.get(i));
        }
    }

    public void handleOnStart(View view, int i) {
        List<AdResponseOuterClass.C2803h> m50013l;
        AdResponseOuterClass.C2793b c2793b = this.f10327O;
        if (c2793b == null || (m50013l = c2793b.m50013l()) == null) {
            return;
        }
        for (int i2 = 0; i2 < m50013l.size(); i2++) {
            UrlUtil.sendOnStartInfoToServer(m50013l.get(i2));
        }
    }

    public void handleView(View view, String str) {
        List<AdResponseOuterClass.C2803h> m50013l;
        String m49931a;
        int i = this.f10365s;
        if (i <= 0) {
            this.f10365s = i + 1;
            if (!StringUtil.isEmpty(this.mDetectViewUrl)) {
                this.mDetectViewUrl = UrlUtil.replaceToTouchEventUrl(this.mDetectViewUrl, "", "", "", "", "", "", "");
                new ClickTracker(this.mDetectViewUrl).execute(new Void[0]);
                this.mDetectViewUrl = "";
            }
            AdResponseOuterClass.C2793b c2793b = this.f10327O;
            if (c2793b == null || (m50013l = c2793b.m50013l()) == null) {
                return;
            }
            for (int i2 = 0; i2 < m50013l.size(); i2++) {
                AdResponseOuterClass.C2803h c2803h = m50013l.get(i2);
                if (c2803h != null && !TextUtils.isEmpty(c2803h.m49931a()) && view != null) {
                    if (!TextUtils.isEmpty(str)) {
                        m49931a = c2803h.m49931a().replace("__REQUESTUUID__", str);
                    } else {
                        m49931a = c2803h.m49931a();
                    }
                    new ClickTracker(StringUtil.replaceView(0, view, m49931a)).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
                }
            }
        }
    }

    public boolean isAutoClose() {
        return this.f10360n;
    }

    public boolean isAutoPlay() {
        return this.f10364r;
    }

    public boolean isFullScreen() {
        return this.f10356j;
    }

    public boolean isManualClose() {
        return this.f10361o;
    }

    public boolean isMuted() {
        return this.f10359m;
    }

    public boolean isVideo() {
        return !TextUtils.isEmpty(this.f10344ae);
    }

    public boolean isWifiOnly() {
        return this.f10358l;
    }

    public boolean isWifiPreload() {
        return this.f10357k;
    }

    public void setAdOrientation(int i) {
        this.f10351e = i;
    }

    public void setCloseMarketDialog(boolean z) {
        this.f10370x = z;
    }

    public void setOpenInNativeBrowser(boolean z) {
        this.f10368v = z;
    }

    /* renamed from: a */
    private void m49362a(AdResponseOuterClass.C2793b c2793b) {
        this.f10327O = c2793b;
        this.f10328P = c2793b.m50013l();
        this.f10371y = c2793b.m50015k();
        this.f10372z = c2793b.m50017j();
        this.f10313A = c2793b.m50031c();
        this.f10314B = c2793b.m50029d();
        this.f10315C = c2793b.m50027e();
        this.f10316D = c2793b.m50025f();
        this.f10317E = c2793b.m50023g();
        if (TextUtils.isEmpty(this.f10315C)) {
            this.f10315C = "lance";
        }
        if (TextUtils.isEmpty(this.f10314B)) {
            this.f10314B = "BeiZi";
        }
        if (TextUtils.isEmpty(this.f10316D)) {
            this.f10316D = "Ad Download";
        }
        this.f10318F = c2793b.m50011m();
        this.f10319G = c2793b.m50009n();
        this.f10320H = c2793b.m50007o();
        this.f10321I = c2793b.m50006p();
        this.f10322J = c2793b.m50005q();
        this.f10323K = c2793b.m50004r();
        this.f10324L = c2793b.m50003s();
        AdResponseOuterClass.C2793b.C2794a m50002t = c2793b.m50002t();
        this.f10325M = m50002t;
        if (m50002t == null || m50002t.m50001a() != 1) {
            return;
        }
        this.f10326N = true;
    }

    /* renamed from: b */
    private void m49356b() {
        if (this.f10336X.isEmpty()) {
            return;
        }
        final BeiZiImpl m49492a = BeiZiImpl.m49492a();
        m49492a.m49477c().post(new Runnable() { // from class: com.beizi.ad.internal.network.ServerResponse.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                Iterator it = ServerResponse.this.f10336X.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    try {
                        InputStream openStream = new URL(m49492a.m49480b().m49607a(str)).openStream();
                        byte[] bArr = new byte[1024];
                        while (i > 0) {
                            int read = openStream.read(bArr);
                            i = read != -1 ? i - read : 1024000;
                        }
                    } catch (IOException unused) {
                        String str2 = HaoboLog.baseLogTag;
                        HaoboLog.m49286v(str2, "Ignored request: " + str);
                    }
                }
            }
        });
    }

    /* renamed from: b */
    private boolean m49354b(AdResponseOuterClass.C2804i c2804i) {
        if (c2804i.m49910b() != 0) {
            HaoboLog.m49290e(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.response_error, c2804i.m49906c(), c2804i.m49904d()));
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private void m49355b(Context context) {
        if (context == null) {
            return;
        }
        BeiZiImpl.m49492a().m49488a(new AdClickReportListener() { // from class: com.beizi.ad.internal.network.ServerResponse.2
            @Override // com.beizi.p051ad.internal.AdClickReportListener
            public void onReport() {
                try {
                    if (ServerResponse.this.f10372z != null) {
                        ReportEventUtil.report(ServerResponse.this.f10372z.m49987g());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Uri parse = Uri.parse(Uri.decode(this.f10334V));
        if (parse.getScheme() != null && parse.getScheme().equals("bzopen") && !TextUtils.isEmpty(parse.getHost()) && parse.getPathSegments().size() > 0) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            String queryParameter = parse.getQueryParameter("flags");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                        intent.setFlags(Integer.parseInt(queryParameter));
                    }
                    intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            intent.setComponent(new ComponentName(parse.getHost(), parse.getPathSegments().get(0)));
            String queryParameter2 = parse.getQueryParameter("rect");
            if (!TextUtils.isEmpty(queryParameter2)) {
                try {
                    String[] split = queryParameter2.split(":");
                    if (split.length == 4) {
                        Rect rect = new Rect();
                        rect.set(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                        intent.setSourceBounds(rect);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", parse);
        intent2.setFlags(805339136);
        context.startActivity(intent2);
    }

    /* renamed from: a */
    private void m49357a(Map<String, List<String>> map) {
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    for (String str : entry.getValue()) {
                        if (!TextUtils.isEmpty(str)) {
                            HaoboLog.m49286v(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.response_header, entry.getKey(), str));
                        }
                    }
                }
            }
        }
    }

    public ServerResponse(AdResponseOuterClass.C2804i c2804i, Map<String, List<String>> map, EnumC2888k enumC2888k) {
        this.f10350d = 0;
        this.f10351e = 1;
        this.f10352f = 0;
        this.f10353g = 0;
        this.f10354h = 0;
        this.f10355i = 0;
        this.f10356j = false;
        this.f10357k = true;
        this.f10358l = false;
        this.f10359m = false;
        this.f10360n = false;
        this.f10361o = false;
        this.f10362p = 0;
        this.f10363q = 0;
        this.f10364r = false;
        this.f10365s = 0;
        this.f10366t = new AdLogoInfo();
        this.f10367u = new AdLogoInfo();
        this.f10368v = false;
        this.f10370x = false;
        this.f10331S = new LinkedList();
        this.f10336X = new LinkedList<>();
        this.f10337Y = new LinkedList<>();
        this.f10338Z = new HashMap<>();
        this.f10340aa = false;
        this.f10341ab = false;
        if (c2804i == null) {
            HaoboLog.clearLastResponse();
            return;
        }
        HaoboLog.setLastResponse(c2804i.toString());
        HaoboLog.m49292d(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.response_body, HaoboLog.getLastResponse()));
        this.mMediaType = enumC2888k;
        m49357a(map);
        m49361a(c2804i);
        m49356b();
    }

    /* renamed from: a */
    private void m49361a(AdResponseOuterClass.C2804i c2804i) {
        if (m49354b(c2804i)) {
            EnumC2888k enumC2888k = this.mMediaType;
            if (enumC2888k == EnumC2888k.PREFETCH) {
                if (m49349d(c2804i)) {
                    return;
                }
            } else if (enumC2888k != EnumC2888k.NATIVE) {
                if (m49350c(c2804i)) {
                    return;
                }
            } else if (m49348e(c2804i)) {
                return;
            }
            m49347f(c2804i);
        }
    }

    public void handleClick(View view, ClickPositionModel clickPositionModel, String str, String str2, boolean z, String str3, int i) {
        String replaceToTouchEventUrl;
        LogUtil.m49046a("BeiZisAd", "handleClick========" + z);
        if (!z) {
            if (!StringUtil.isEmpty(this.mDetectClickUrl)) {
                this.mDetectClickUrl = UrlUtil.replaceToTouchEventUrl(this.mDetectClickUrl, clickPositionModel, str, str2, "", i);
                new ClickTracker(this.mDetectClickUrl).execute(new Void[0]);
                this.mDetectClickUrl = "";
            }
            if (this.f10327O != null && this.f10328P != null) {
                for (int i2 = 0; i2 < this.f10328P.size(); i2++) {
                    AdResponseOuterClass.C2803h c2803h = this.f10328P.get(i2);
                    if (c2803h != null && !TextUtils.isEmpty(c2803h.m49929b())) {
                        if (!TextUtils.isEmpty(str3)) {
                            replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl(c2803h.m49929b(), clickPositionModel, str, str2, "", i).replace("__REQUESTUUID__", str3);
                        } else {
                            replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl(c2803h.m49929b(), clickPositionModel, str, str2, "", i);
                        }
                        new ClickTracker(StringUtil.replaceClick(view, replaceToTouchEventUrl)).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
                    }
                }
                this.f10328P = null;
            }
        }
        LogUtil.m49046a("BeiZisAd", "mDeepLinkUrl:" + this.f10334V + ",appDownloadURL = " + this.f10317E + ",mLandingPageUrl = " + this.f10333U);
        Context context = view != null ? view.getContext() : null;
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f10334V)) {
            try {
                if (!JumpTool.m49050a(context, Uri.decode(this.f10334V)) && !FileUtil.m49059a(context, this.f10315C)) {
                    AdResponseOuterClass.C2793b.C2795b c2795b = this.f10372z;
                    if (c2795b != null) {
                        ReportEventUtil.report(c2795b.m49981j());
                    }
                    m49365a(context);
                    return;
                }
                AdResponseOuterClass.C2793b.C2795b c2795b2 = this.f10372z;
                if (c2795b2 != null) {
                    ReportEventUtil.report(c2795b2.m49983i());
                }
                m49355b(context);
                AdResponseOuterClass.C2793b.C2795b c2795b3 = this.f10372z;
                if (c2795b3 != null) {
                    ReportEventUtil.report(c2795b3.m49989f());
                    return;
                }
                return;
            } catch (Exception unused) {
                AdResponseOuterClass.C2793b.C2795b c2795b4 = this.f10372z;
                if (c2795b4 != null) {
                    ReportEventUtil.report(c2795b4.m49985h());
                }
                m49365a(context);
                return;
            }
        }
        m49365a(context);
    }

    /* renamed from: a */
    private String m49363a(AdResponseOuterClass.C2792a c2792a) {
        if (c2792a.m50049a() == EnumType.EnumC2817f.RENDER_H5 || c2792a.m50049a() == EnumType.EnumC2817f.RENDER_PIC) {
            if (c2792a.m50049a() == EnumType.EnumC2817f.RENDER_PIC && c2792a.m50043d() > 0) {
                return "<!DOCTYPE html>\n<html lang=\"en\" style=\"width: 100%; height: 100%;\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" id=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1\">\n    <title>Document</title>\n</head>\n<body style=\"width: 100%; height: 100%; padding: 0; margin: 0;\">\n<img style=\"width: 100%; height: 100%\" src=\"__IMAGE_SRC_PATH__\" alt=\"\"/>\n</body>\n</html><!DOCTYPE html>".replace("__IMAGE_SRC_PATH__", c2792a.m50044c().get(0).m49940b());
            }
            Matcher matcher = Pattern.compile("\\{(\\d+)\\.value\\}").matcher(c2792a.m50045b());
            HashMap hashMap = new HashMap();
            for (int i = 0; i < c2792a.m50043d(); i++) {
                hashMap.put(Integer.valueOf(i), c2792a.m50044c().get(i).m49940b());
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                Integer valueOf = Integer.valueOf(Integer.parseInt(matcher.group(1)));
                if (hashMap.get(valueOf) != null) {
                    matcher.appendReplacement(stringBuffer, (String) hashMap.get(valueOf));
                } else {
                    matcher.appendReplacement(stringBuffer, "");
                    HaoboLog.m49290e(HaoboLog.pbLogTag, HaoboLog.getString(C2750R.C2755string.invalid_string_placeholder, matcher.group(0)));
                }
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m49366a() {
        return this.f10341ab;
    }

    /* renamed from: a */
    private void m49365a(Context context) {
        try {
            if (!m49352c()) {
                m49351c(context);
                return;
            }
            int i = this.f10313A;
            if (i == 2) {
                if (FileUtil.m49059a(context, this.f10315C)) {
                    FileUtil.m49056b(context, this.f10315C);
                    AdResponseOuterClass.C2793b.C2795b c2795b = this.f10372z;
                    if (c2795b != null) {
                        ReportEventUtil.report(c2795b.m49999a());
                        return;
                    }
                    return;
                }
                m49364a(context, 1);
            } else if (i == 5) {
                if (!JumpTool.m49050a(context, this.f10317E) && !this.f10317E.contains("market://")) {
                    m49351c(context);
                    return;
                }
                if (this.f10370x) {
                    m49358a(this.f10317E, context);
                    AdResponseOuterClass.C2793b.C2795b c2795b2 = this.f10372z;
                    if (c2795b2 != null) {
                        ReportEventUtil.report(c2795b2.m49999a());
                        return;
                    }
                    return;
                }
                m49364a(context, 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ServerResponse(boolean z) {
        this.f10350d = 0;
        this.f10351e = 1;
        this.f10352f = 0;
        this.f10353g = 0;
        this.f10354h = 0;
        this.f10355i = 0;
        this.f10356j = false;
        this.f10357k = true;
        this.f10358l = false;
        this.f10359m = false;
        this.f10360n = false;
        this.f10361o = false;
        this.f10362p = 0;
        this.f10363q = 0;
        this.f10364r = false;
        this.f10365s = 0;
        this.f10366t = new AdLogoInfo();
        this.f10367u = new AdLogoInfo();
        this.f10368v = false;
        this.f10370x = false;
        this.f10331S = new LinkedList();
        this.f10336X = new LinkedList<>();
        this.f10337Y = new LinkedList<>();
        this.f10338Z = new HashMap<>();
        this.f10340aa = false;
        this.f10341ab = z;
    }

    /* renamed from: a */
    private void m49364a(Context context, int i) {
        try {
            File m49060a = FileUtil.m49060a(context);
            String absolutePath = m49060a != null ? m49060a.getAbsolutePath() : "";
            ApkBean apkBean = new ApkBean(this.f10317E, this.f10315C + ".apk", this.f10315C, absolutePath, this.f10314B, this.f10316D, context.getPackageName() + ".fileprovider", this.f10372z, this.f10318F, this.f10319G, this.f10320H, this.f10321I, this.f10322J, this.f10323K, this.f10324L);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i);
            bundle.putBoolean("isCanJump", this.f10326N);
            if (i == 2) {
                AdResponseOuterClass.C2793b.C2795b c2795b = this.f10372z;
                if (c2795b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c2795b.m49999a());
                }
                bundle.putString("landingPageUrl", this.f10333U);
            }
            Intent intent = new Intent(context, BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private boolean m49352c() {
        if (TextUtils.isEmpty(this.f10317E) || TextUtils.isEmpty(this.f10314B) || TextUtils.isEmpty(this.f10319G) || TextUtils.isEmpty(this.f10318F) || TextUtils.isEmpty(this.f10322J) || TextUtils.isEmpty(this.f10324L)) {
            return false;
        }
        if (TextUtils.isEmpty(this.f10321I) && TextUtils.isEmpty(this.f10320H)) {
            return false;
        }
        int i = this.f10313A;
        return i == 2 || i == 5;
    }

    /* renamed from: c */
    private void m49351c(Context context) {
        if (context == null || TextUtils.isEmpty(this.f10333U) || !this.f10333U.startsWith(IDataSource.f43971a)) {
            return;
        }
        if (this.f10368v) {
            Class m50215a = AdActivity.m50215a();
            try {
                WebView webView = new WebView(new MutableContextWrapper(context));
                WebviewUtil.setWebViewSettings(webView);
                webView.loadUrl(this.f10333U, HeaderUtil.m49052a());
                BrowserAdActivity.f9980a.add(webView);
                Intent intent = new Intent(BeiZiImpl.m49492a().m49473e(), m50215a);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                intent.putExtra("ACTIVITY_CAN_JUMP", this.f10326N);
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException unused) {
                LogUtil.m49046a(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.adactivity_missing, m50215a.getName()));
                BrowserAdActivity.f9980a.remove();
                return;
            } catch (Exception e) {
                String str = HaoboLog.baseLogTag;
                LogUtil.m49046a(str, "Exception initializing the redirect webview: " + e.getMessage());
                return;
            }
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(this.f10333U))));
        } catch (Exception unused2) {
        }
    }

    /* renamed from: a */
    private void m49358a(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.opening_url_failed, str));
        }
    }

    /* renamed from: a */
    private void m49359a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f10342ac = JsonUtil.getJSONString(jSONObject, "Headline");
            this.f10343ad = JsonUtil.getJSONString(jSONObject, "Body");
            this.f10346ag = JsonUtil.getJSONString(jSONObject, "AppIcon");
            JSONArray jSONArray = JsonUtil.getJSONArray(jSONObject, "Images");
            JSONArray jSONArray2 = JsonUtil.getJSONArray(jSONObject, "Videos");
            if (jSONArray != null && jSONArray.length() > 0) {
                this.f10345af = (String) jSONArray.get(0);
            }
            if (jSONArray2 == null || jSONArray2.length() <= 0) {
                return;
            }
            this.f10344ae = (String) jSONArray2.get(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
