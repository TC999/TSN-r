package com.beizi.ad.internal.network;

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
import com.beizi.ad.AdActivity;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.R;
import com.beizi.ad.c.b;
import com.beizi.ad.c.e;
import com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.ad.internal.i;
import com.beizi.ad.internal.j;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.utilities.HTTPResponse;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.JsonUtil;
import com.beizi.ad.internal.utilities.ReportEventUtil;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.internal.utilities.UrlUtil;
import com.beizi.ad.internal.utilities.WebviewUtil;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.h;
import com.beizi.ad.lance.a.l;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.control.track.AdScopeTrackerTool;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ServerResponse {
    public static final String EXTRAS_KEY_MRAID = "MRAID";
    public static final String EXTRAS_KEY_ORIENTATION = "ORIENTATION";
    public static final String EXTRAS_KEY_REWARD_ITEM = "REWARD_ITEM";
    public static final String EXTRAS_KEY_SCALE = "SCALE";
    private int A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;

    /* renamed from: L  reason: collision with root package name */
    private String f13955L;
    private b.C0119b.a M;
    private boolean N;
    private boolean O;
    private int P;
    private b.C0119b Q;
    private List<b.h> R;
    private String S;
    private String T;
    private List<Pair<j, String>> U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private LinkedList<String> Z;

    /* renamed from: a  reason: collision with root package name */
    private String f13956a;
    private LinkedList<com.beizi.ad.internal.a.a> aa;
    private HashMap<String, Object> ab;
    private boolean ac;
    private boolean ad;
    private String ae;
    private String af;
    private String ag;
    private String ah;
    private String ai;
    private com.beizi.ad.internal.nativead.a aj;

    /* renamed from: b  reason: collision with root package name */
    private String f13957b;

    /* renamed from: c  reason: collision with root package name */
    private e.a f13958c;

    /* renamed from: d  reason: collision with root package name */
    private int f13959d;

    /* renamed from: e  reason: collision with root package name */
    private int f13960e;

    /* renamed from: f  reason: collision with root package name */
    private int f13961f;

    /* renamed from: g  reason: collision with root package name */
    private int f13962g;

    /* renamed from: h  reason: collision with root package name */
    private int f13963h;

    /* renamed from: i  reason: collision with root package name */
    private int f13964i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13965j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13966k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13967l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f13968m;
    public String mDetectClickUrl;
    public String mDetectViewUrl;
    public k mMediaType;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13969n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f13970o;

    /* renamed from: p  reason: collision with root package name */
    private int f13971p;

    /* renamed from: q  reason: collision with root package name */
    private int f13972q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f13973r;

    /* renamed from: s  reason: collision with root package name */
    private int f13974s;

    /* renamed from: t  reason: collision with root package name */
    private AdLogoInfo f13975t;

    /* renamed from: u  reason: collision with root package name */
    private AdLogoInfo f13976u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f13977v;

    /* renamed from: w  reason: collision with root package name */
    private String f13978w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f13979x;

    /* renamed from: y  reason: collision with root package name */
    private b.C0119b.c f13980y;

    /* renamed from: z  reason: collision with root package name */
    private b.C0119b.C0120b f13981z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
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
        public void setType(int i4) {
            this.type = i4;
        }

        public String getAdurl() {
            return this.adurl;
        }

        public int getType() {
            return this.type;
        }
    }

    public ServerResponse(HTTPResponse hTTPResponse, k kVar) {
        this.f13959d = 0;
        this.f13960e = 1;
        this.f13961f = 0;
        this.f13962g = 0;
        this.f13963h = 0;
        this.f13964i = 0;
        this.f13965j = false;
        this.f13966k = true;
        this.f13967l = false;
        this.f13968m = false;
        this.f13969n = false;
        this.f13970o = false;
        this.f13971p = 0;
        this.f13972q = 0;
        this.f13973r = false;
        this.f13974s = 0;
        this.f13975t = new AdLogoInfo();
        this.f13976u = new AdLogoInfo();
        this.f13977v = false;
        this.f13979x = false;
        this.P = -1;
        this.U = new LinkedList();
        this.Z = new LinkedList<>();
        this.aa = new LinkedList<>();
        this.ab = new HashMap<>();
        this.ac = false;
        this.ad = false;
        this.mMediaType = kVar;
        a(hTTPResponse.getHeaders());
        try {
            a(b.i.a(hTTPResponse.getResponseBinaryBody().toByteArray()));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private boolean c(b.i iVar) {
        if (iVar.a() > 0) {
            b.j jVar = iVar.e().get(0);
            this.f13956a = jVar.a();
            this.f13957b = jVar.b();
            this.f13958c = jVar.c();
            this.f13959d = jVar.d();
            this.f13960e = jVar.e() == e.h.PORTRAIT ? 1 : 2;
            this.f13964i = Integer.parseInt(jVar.f());
            this.f13963h = Integer.parseInt(jVar.g());
            if (jVar.h() != null && (getAdType() == e.a.ADP_TABLE || getAdType() == e.a.ADP_CUSTOMER)) {
                b.g h4 = jVar.h();
                this.f13961f = Integer.parseInt(h4.a());
                this.f13962g = Integer.parseInt(h4.b());
            } else if (!StringUtil.isEmpty(jVar.b()) && getAdType() == e.a.ADP_IVIDEO) {
                addToExtras("REWARD_ITEM", jVar.b());
            }
            this.f13965j = jVar.o();
            this.f13966k = jVar.m();
            this.f13967l = jVar.q();
            this.f13968m = jVar.n();
            this.f13969n = jVar.i();
            this.f13970o = jVar.k();
            this.f13971p = jVar.l();
            this.f13972q = jVar.j();
            this.f13973r = jVar.p();
            List<b.d> r3 = jVar.r();
            if (r3 != null && r3.size() > 0) {
                this.f13978w = r3.get(0).i();
                this.T = r3.get(0).b();
            }
            if (this.f13965j && this.f13964i == 0 && this.f13963h == 0) {
                this.f13964i = 720;
                this.f13963h = 1280;
            }
            if (jVar.s() > 0) {
                int i4 = 0;
                for (b.d dVar : jVar.r()) {
                    if (i4 == 0) {
                        this.T = dVar.b();
                        l.a("BeiZisAd", "mAdid = " + this.T);
                    }
                    if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                        this.S = dVar.a();
                        b.c e4 = dVar.e();
                        if (e4 != null) {
                            if (e4.a() != null) {
                                this.f13975t.setAdurl(e4.a());
                                this.f13975t.setType(AdLogoInfo.TYPE_PIC);
                            } else {
                                this.f13975t.setAdurl(e4.b());
                                this.f13975t.setType(AdLogoInfo.TYPE_TEXT);
                            }
                            if (e4.c() != null) {
                                this.f13976u.setAdurl(e4.c());
                                this.f13976u.setType(AdLogoInfo.TYPE_PIC);
                            } else {
                                this.f13976u.setAdurl(e4.d());
                                this.f13976u.setType(AdLogoInfo.TYPE_TEXT);
                            }
                        }
                        if (dVar.d() > 0) {
                            for (b.a aVar : dVar.f()) {
                                if (this.f13966k) {
                                    for (int i5 = 0; i5 < aVar.d(); i5++) {
                                        if (!StringUtil.isEmpty(aVar.c().get(i5).a())) {
                                            this.Z.add(aVar.c().get(i5).b());
                                        }
                                    }
                                }
                                a(aVar.b());
                                if ((aVar.a() == e.f.RENDER_VIDEO || aVar.a() == e.f.RENDER_VAST_VIDEO) && aVar.d() > 0) {
                                    this.U.add(Pair.create(j.VIDEO, aVar.c().get(0).b()));
                                } else {
                                    String a4 = a(aVar);
                                    this.U.add(Pair.create(j.HTML, a4));
                                    if (a4.contains("mraid.js")) {
                                        addToExtras("MRAID", Boolean.TRUE);
                                    }
                                }
                            }
                        }
                        if (dVar.c() != null) {
                            b.C0119b c4 = dVar.c();
                            a(c4);
                            this.W = c4.a();
                            this.Y = c4.h();
                            this.X = c4.b();
                            b.h i6 = c4.i();
                            if (i6 != null && !TextUtils.isEmpty(i6.a())) {
                                this.mDetectViewUrl = i6.a();
                            }
                            if (i6 != null && !TextUtils.isEmpty(i6.b())) {
                                this.mDetectClickUrl = i6.b();
                            }
                            if (i6 != null && !TextUtils.isEmpty(i6.c())) {
                                this.V = i6.c();
                            }
                        }
                    }
                    i4++;
                    if (!this.U.isEmpty()) {
                        break;
                    }
                }
            }
        } else {
            HaoboLog.e(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.blank_ad));
        }
        if (this.U.isEmpty()) {
            return false;
        }
        this.ac = true;
        return true;
    }

    private boolean d(b.i iVar) {
        if (iVar.a() > 0) {
            for (b.j jVar : iVar.e()) {
                this.f13966k = jVar.m();
                if (jVar.s() > 0) {
                    for (b.d dVar : jVar.r()) {
                        if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                            if (dVar.d() > 0) {
                                for (b.a aVar : dVar.f()) {
                                    if (this.f13966k) {
                                        for (int i4 = 0; i4 < aVar.d(); i4++) {
                                            if (!StringUtil.isEmpty(aVar.c().get(i4).a())) {
                                                this.Z.add(aVar.c().get(i4).b());
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
        if (this.Z.isEmpty()) {
            return false;
        }
        this.ac = true;
        return true;
    }

    private boolean e(b.i iVar) {
        if (iVar.a() > 0) {
            b.j jVar = iVar.e().get(0);
            this.f13956a = jVar.a();
            this.f13957b = jVar.b();
            this.f13958c = jVar.c();
            this.f13959d = jVar.d();
            this.f13960e = jVar.e() == e.h.PORTRAIT ? 1 : 2;
            this.f13964i = Integer.parseInt(jVar.f());
            this.f13963h = Integer.parseInt(jVar.g());
            List<b.d> r3 = jVar.r();
            if (r3 != null && r3.size() > 0) {
                this.f13978w = r3.get(0).i();
                this.T = r3.get(0).b();
            }
            this.f13965j = jVar.o();
            this.f13966k = jVar.m();
            this.f13967l = jVar.q();
            this.f13968m = jVar.n();
            this.f13969n = jVar.i();
            this.f13970o = jVar.k();
            this.f13971p = jVar.l();
            this.f13972q = jVar.j();
            this.f13973r = jVar.p();
            if (this.f13965j && this.f13964i == 0 && this.f13963h == 0) {
                this.f13964i = 720;
                this.f13963h = 1280;
            }
            if (jVar.s() > 0) {
                for (b.d dVar : jVar.r()) {
                    if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                        this.S = dVar.a();
                        if (dVar.d() >= 0) {
                            for (b.a aVar : dVar.f()) {
                                if (this.f13966k) {
                                    for (int i4 = 0; i4 < aVar.d(); i4++) {
                                        if (!StringUtil.isEmpty(aVar.c().get(i4).a())) {
                                            this.Z.add(aVar.c().get(i4).b());
                                        }
                                    }
                                }
                                if (aVar.a() == e.f.RENDER_JSON && aVar.d() > 0) {
                                    try {
                                        b.c e4 = dVar.e();
                                        if (e4 != null) {
                                            if (e4.a() != null) {
                                                this.f13975t.setAdurl(e4.a());
                                                this.f13975t.setType(AdLogoInfo.TYPE_PIC);
                                            } else {
                                                this.f13975t.setAdurl(e4.b());
                                                this.f13975t.setType(AdLogoInfo.TYPE_TEXT);
                                            }
                                            if (e4.c() != null) {
                                                this.f13976u.setAdurl(e4.c());
                                                this.f13976u.setType(AdLogoInfo.TYPE_PIC);
                                            } else {
                                                this.f13976u.setAdurl(e4.d());
                                                this.f13976u.setType(AdLogoInfo.TYPE_TEXT);
                                            }
                                        }
                                        com.beizi.ad.internal.nativead.a a4 = com.beizi.ad.internal.nativead.a.a(new JSONObject(aVar.b()));
                                        this.aj = a4;
                                        a4.b(getLogoUrl());
                                        this.aj.a(getAdUrl());
                                        if (dVar.c() != null) {
                                            a(dVar.c());
                                            b.C0119b c4 = dVar.c();
                                            this.W = c4.a();
                                            this.X = c4.b();
                                            this.Y = c4.h();
                                            this.aj.b(!StringUtil.isEmpty(this.W) ? this.W : this.Y);
                                            this.aj.c(this.X);
                                            this.aj.a(dVar.c());
                                            b.h i5 = c4.i();
                                            if (i5 != null && !TextUtils.isEmpty(i5.a())) {
                                                this.aj.d(i5.a());
                                            }
                                            if (i5 != null && !TextUtils.isEmpty(i5.b())) {
                                                this.aj.e(i5.b());
                                            }
                                            List<b.h> l4 = c4.l();
                                            if (l4 != null && l4.size() > 0) {
                                                for (int i6 = 0; i6 < l4.size(); i6++) {
                                                    String b4 = l4.get(i6).b();
                                                    if (!TextUtils.isEmpty(b4)) {
                                                        this.aj.e(b4);
                                                    }
                                                    String a5 = l4.get(i6).a();
                                                    if (!TextUtils.isEmpty(a5)) {
                                                        this.aj.d(a5);
                                                    }
                                                }
                                            }
                                        }
                                    } catch (JSONException unused) {
                                    }
                                    if (this.aj != null) {
                                        this.ac = true;
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
            HaoboLog.e(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.blank_ad));
        }
        if (this.U.isEmpty()) {
            return false;
        }
        this.ac = true;
        return true;
    }

    private boolean f(b.i iVar) {
        if (iVar.a() > 0) {
            b.j jVar = iVar.e().get(0);
            List<b.d> r3 = jVar.r();
            if (r3 != null && r3.size() > 0) {
                b.d dVar = r3.get(0);
                if (dVar.c() != null) {
                    b.C0119b c4 = dVar.c();
                    a(c4);
                    this.W = c4.a();
                    this.Y = c4.h();
                    b.h i4 = c4.i();
                    if (i4 != null && !TextUtils.isEmpty(i4.a())) {
                        this.mDetectViewUrl = i4.a();
                    }
                    if (i4 != null && !TextUtils.isEmpty(i4.b())) {
                        this.mDetectClickUrl = i4.b();
                    }
                    if (i4 != null && !TextUtils.isEmpty(i4.c())) {
                        this.V = i4.c();
                    }
                }
            }
            this.f13956a = jVar.a();
            this.f13957b = jVar.b();
            this.f13958c = jVar.c();
            this.f13959d = jVar.d();
            this.f13960e = jVar.e() == e.h.PORTRAIT ? 1 : 2;
            this.f13963h = Integer.parseInt(jVar.f());
            this.f13964i = Integer.parseInt(jVar.g());
            List<b.d> r4 = jVar.r();
            if (r4 != null && r4.size() > 0) {
                this.f13978w = r4.get(0).i();
                this.T = r4.get(0).b();
            }
            this.f13961f = 0;
            this.f13962g = 0;
            if (jVar.h() != null && getAdType() == e.a.ADP_TABLE) {
                b.g h4 = jVar.h();
                this.f13961f = Integer.parseInt(h4.a());
                this.f13962g = Integer.parseInt(h4.b());
            }
            if (jVar.s() > 0) {
                for (b.d dVar2 : jVar.r()) {
                    if (dVar2.h() > 0 && dVar2.g().get(0) != null) {
                        b.f fVar = dVar2.g().get(0);
                        this.aa.add(new com.beizi.ad.internal.a.a(fVar.a(), fVar.c(), this.f13964i, this.f13963h, fVar.b(), ""));
                    }
                }
            }
        }
        if (this.aa.isEmpty()) {
            return false;
        }
        this.ac = true;
        return true;
    }

    public void addToExtras(String str, Object obj) {
        this.ab.put(str, obj);
    }

    public boolean containsAds() {
        return this.ac;
    }

    public String getAdExtInfo() {
        return this.S;
    }

    public String getAdId() {
        return this.T;
    }

    public b.C0119b getAdInteractInfo() {
        return this.Q;
    }

    public int getAdOrientation() {
        return this.f13960e;
    }

    public e.a getAdType() {
        return this.f13958c;
    }

    public AdLogoInfo getAdUrl() {
        return this.f13975t;
    }

    public String getApkName() {
        return this.B;
    }

    public String getAppDesc() {
        return this.D;
    }

    public String getAppDeveloper() {
        return this.G;
    }

    public String getAppDownloadURL() {
        return this.E;
    }

    public String getAppIcon() {
        return this.ai;
    }

    public String getAppIconURL() {
        return this.K;
    }

    public String getAppPermissionsDesc() {
        return this.H;
    }

    public String getAppPermissionsUrl() {
        return this.I;
    }

    public String getAppPrivacyUrl() {
        return this.J;
    }

    public String getAppVersion() {
        return this.F;
    }

    public String getAppintro() {
        return this.f13955L;
    }

    public List<Pair<j, String>> getCreatives() {
        return this.U;
    }

    public HashMap<String, Object> getExtras() {
        return this.ab;
    }

    public b.C0119b.C0120b getFollowTrackExt() {
        return this.f13981z;
    }

    public int getHeight() {
        return this.f13963h;
    }

    public String getImageUrl() {
        return this.ah;
    }

    public int getInteractType() {
        return this.A;
    }

    public int getLeft() {
        return this.f13961f;
    }

    public AdLogoInfo getLogoUrl() {
        return this.f13976u;
    }

    public int getMaxTimer() {
        return this.f13972q;
    }

    public LinkedList<com.beizi.ad.internal.a.a> getMediationAds() {
        return this.aa;
    }

    public int getMinTimer() {
        return this.f13971p;
    }

    public NativeAdResponse getNativeAdResponse() {
        return this.aj;
    }

    public String getPackageName() {
        return this.C;
    }

    public LinkedList<String> getPrefetchResources() {
        return this.Z;
    }

    public String getPrice() {
        return this.f13978w;
    }

    public int getRefreshInterval() {
        return this.f13959d;
    }

    public String getSubTitle() {
        return this.af;
    }

    public String getTitle() {
        return this.ae;
    }

    public int getTop() {
        return this.f13962g;
    }

    public b.C0119b.c getVideoTrackExt() {
        return this.f13980y;
    }

    public String getVideoUrl() {
        return this.ag;
    }

    public int getWidth() {
        return this.f13964i;
    }

    public void handleClick(View view, String str, String str2, String str3, String str4, String str5, String str6, boolean z3, String str7) {
        String replaceToTouchEventUrl;
        l.a("BeiZisAd", "handleClick========" + z3);
        if (!z3) {
            if (!StringUtil.isEmpty(this.mDetectClickUrl)) {
                this.mDetectClickUrl = UrlUtil.replaceToTouchEventUrl(this.mDetectClickUrl, str, str2, str3, str4, str5, str6, "");
                new i(this.mDetectClickUrl).execute(new Void[0]);
                this.mDetectClickUrl = "";
            }
            if (this.Q != null && this.R != null) {
                for (int i4 = 0; i4 < this.R.size(); i4++) {
                    b.h hVar = this.R.get(i4);
                    if (hVar != null && !TextUtils.isEmpty(hVar.b())) {
                        if (!TextUtils.isEmpty(str7)) {
                            replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl(hVar.b(), str, str2, str3, str4, str5, str6, "").replace(AdScopeTrackerTool.requestUUID, str7);
                        } else {
                            replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl(hVar.b(), str, str2, str3, str4, str5, str6, "");
                        }
                        new i(StringUtil.replaceClick(view, replaceToTouchEventUrl)).executeOnExecutor(com.beizi.ad.lance.a.c.b().d(), new Void[0]);
                    }
                }
                this.R = null;
            }
        }
        l.a("BeiZisAd", "mDeepLinkUrl:" + this.X + ",appDownloadURL = " + this.E + ",mLandingPageUrl = " + this.W);
        Context context = view != null ? view.getContext() : null;
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.X)) {
            try {
                if (!com.beizi.ad.lance.a.j.a(context, Uri.decode(this.X)) && !h.a(context, this.C) && !Uri.decode(this.X).startsWith("hwpps://landingpage") && !Uri.decode(this.X).startsWith("intent") && !Uri.decode(this.X).startsWith("hap://")) {
                    b.C0119b.C0120b c0120b = this.f13981z;
                    if (c0120b != null) {
                        ReportEventUtil.report(c0120b.j());
                    }
                    a(context);
                    return;
                }
                b.C0119b.C0120b c0120b2 = this.f13981z;
                if (c0120b2 != null) {
                    ReportEventUtil.report(c0120b2.i());
                }
                b(context);
                b.C0119b.C0120b c0120b3 = this.f13981z;
                if (c0120b3 != null) {
                    ReportEventUtil.report(c0120b3.f());
                    return;
                }
                return;
            } catch (Exception unused) {
                b.C0119b.C0120b c0120b4 = this.f13981z;
                if (c0120b4 != null) {
                    ReportEventUtil.report(c0120b4.h());
                }
                a(context);
                return;
            }
        }
        a(context);
    }

    public void handleConvert(View view) {
        String str = HaoboLog.baseLogTag;
        HaoboLog.e(str, "handleClick called with convertUrl = " + this.V);
        if (StringUtil.isEmpty(this.V)) {
            return;
        }
        new i(this.V).execute(new Void[0]);
    }

    public void handleOnCompletion() {
        List<b.h> l4;
        b.C0119b c0119b = this.Q;
        if (c0119b == null || (l4 = c0119b.l()) == null) {
            return;
        }
        for (int i4 = 0; i4 < l4.size(); i4++) {
            UrlUtil.sendOnCompletionInfoToServer(l4.get(i4));
        }
    }

    public void handleOnPause(View view) {
        List<b.h> l4;
        b.C0119b c0119b = this.Q;
        if (c0119b == null || (l4 = c0119b.l()) == null) {
            return;
        }
        for (int i4 = 0; i4 < l4.size(); i4++) {
            UrlUtil.sendOnPauseInfoToServer(l4.get(i4));
        }
    }

    public void handleOnStart(View view, int i4) {
        List<b.h> l4;
        b.C0119b c0119b = this.Q;
        if (c0119b == null || (l4 = c0119b.l()) == null) {
            return;
        }
        for (int i5 = 0; i5 < l4.size(); i5++) {
            UrlUtil.sendOnStartInfoToServer(l4.get(i5));
        }
    }

    public void handleView(View view, String str) {
        List<b.h> l4;
        String a4;
        int i4 = this.f13974s;
        if (i4 <= 0) {
            this.f13974s = i4 + 1;
            if (!StringUtil.isEmpty(this.mDetectViewUrl)) {
                this.mDetectViewUrl = UrlUtil.replaceToTouchEventUrl(this.mDetectViewUrl, "", "", "", "", "", "", "");
                new i(this.mDetectViewUrl).execute(new Void[0]);
                this.mDetectViewUrl = "";
            }
            b.C0119b c0119b = this.Q;
            if (c0119b == null || (l4 = c0119b.l()) == null) {
                return;
            }
            for (int i5 = 0; i5 < l4.size(); i5++) {
                b.h hVar = l4.get(i5);
                if (hVar != null && !TextUtils.isEmpty(hVar.a()) && view != null) {
                    if (!TextUtils.isEmpty(str)) {
                        a4 = hVar.a().replace(AdScopeTrackerTool.requestUUID, str);
                    } else {
                        a4 = hVar.a();
                    }
                    new i(StringUtil.replaceView(0, view, a4)).executeOnExecutor(com.beizi.ad.lance.a.c.b().d(), new Void[0]);
                }
            }
        }
    }

    public boolean isAutoClose() {
        return this.f13969n;
    }

    public boolean isAutoPlay() {
        return this.f13973r;
    }

    public boolean isDownloadApp() {
        return TextUtils.isEmpty(this.X) && c() && d();
    }

    public boolean isFullScreen() {
        return this.f13965j;
    }

    public boolean isManualClose() {
        return this.f13970o;
    }

    public boolean isMuted() {
        return this.f13968m;
    }

    public boolean isVideo() {
        return !TextUtils.isEmpty(this.ag);
    }

    public boolean isWifiOnly() {
        return this.f13967l;
    }

    public boolean isWifiPreload() {
        return this.f13966k;
    }

    public void setAdOrientation(int i4) {
        this.f13960e = i4;
    }

    public void setCloseMarketDialog(boolean z3) {
        this.f13979x = z3;
    }

    public void setOpenInNativeBrowser(boolean z3) {
        this.f13977v = z3;
    }

    private void a(b.C0119b c0119b) {
        this.Q = c0119b;
        this.R = c0119b.l();
        this.f13980y = c0119b.k();
        this.f13981z = c0119b.j();
        this.A = c0119b.c();
        this.B = c0119b.d();
        this.C = c0119b.e();
        this.D = c0119b.f();
        this.E = c0119b.g();
        if (TextUtils.isEmpty(this.C)) {
            this.C = "lance";
        }
        if (TextUtils.isEmpty(this.B)) {
            this.B = "BeiZi";
        }
        if (TextUtils.isEmpty(this.D)) {
            this.D = "Ad Download";
        }
        this.F = c0119b.m();
        this.G = c0119b.n();
        this.H = c0119b.o();
        this.I = c0119b.p();
        this.J = c0119b.q();
        this.K = c0119b.r();
        this.f13955L = c0119b.s();
        b.C0119b.a t3 = c0119b.t();
        this.M = t3;
        if (t3 != null) {
            if (t3.a() == 1) {
                this.N = true;
            }
            if (this.M.b() == 1) {
                this.O = true;
            }
        }
    }

    private void b() {
        if (this.Z.isEmpty()) {
            return;
        }
        final com.beizi.ad.internal.h a4 = com.beizi.ad.internal.h.a();
        a4.c().post(new Runnable() { // from class: com.beizi.ad.internal.network.ServerResponse.1
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                Iterator it = ServerResponse.this.Z.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    try {
                        InputStream openStream = new URL(a4.b().a(str)).openStream();
                        byte[] bArr = new byte[1024];
                        while (i4 > 0) {
                            int read = openStream.read(bArr);
                            i4 = read != -1 ? i4 - read : 1024000;
                        }
                    } catch (IOException unused) {
                        String str2 = HaoboLog.baseLogTag;
                        HaoboLog.v(str2, "Ignored request: " + str);
                    }
                }
            }
        });
    }

    private boolean b(b.i iVar) {
        if (iVar.b() != 0) {
            HaoboLog.e(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.response_error, iVar.c(), iVar.d()));
            return false;
        }
        return true;
    }

    private void b(Context context) {
        if (context == null) {
            return;
        }
        com.beizi.ad.internal.h.a().a(new com.beizi.ad.internal.b() { // from class: com.beizi.ad.internal.network.ServerResponse.2
            @Override // com.beizi.ad.internal.b
            public void onReport() {
                try {
                    if (ServerResponse.this.f13981z != null) {
                        ReportEventUtil.report(ServerResponse.this.f13981z.g());
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
        Uri parse = Uri.parse(Uri.decode(this.X));
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
                } catch (Exception e4) {
                    e4.printStackTrace();
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
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            context.startActivity(intent);
            return;
        }
        String decode = Uri.decode(this.X);
        if (decode.startsWith("hwpps://landingpage")) {
            Intent intent2 = new Intent();
            intent2.setData(parse);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        } else if (decode.startsWith("intent")) {
            Intent intent3 = null;
            try {
                intent3 = Intent.parseUri(decode, 1);
                intent3.addFlags(268435456);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            context.startActivity(intent3);
        } else {
            Intent intent4 = new Intent("android.intent.action.VIEW", parse);
            intent4.addFlags(805339136);
            context.startActivity(intent4);
        }
    }

    private boolean d() {
        int i4 = this.A;
        return i4 == 2 ? !TextUtils.isEmpty(this.E) && this.E.startsWith("http") : i4 == 5 && !TextUtils.isEmpty(this.E) && this.E.contains("market://");
    }

    private void a(Map<String, List<String>> map) {
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    for (String str : entry.getValue()) {
                        if (!TextUtils.isEmpty(str)) {
                            HaoboLog.v(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.response_header, entry.getKey(), str));
                        }
                    }
                }
            }
        }
    }

    public ServerResponse(b.i iVar, Map<String, List<String>> map, k kVar) {
        this.f13959d = 0;
        this.f13960e = 1;
        this.f13961f = 0;
        this.f13962g = 0;
        this.f13963h = 0;
        this.f13964i = 0;
        this.f13965j = false;
        this.f13966k = true;
        this.f13967l = false;
        this.f13968m = false;
        this.f13969n = false;
        this.f13970o = false;
        this.f13971p = 0;
        this.f13972q = 0;
        this.f13973r = false;
        this.f13974s = 0;
        this.f13975t = new AdLogoInfo();
        this.f13976u = new AdLogoInfo();
        this.f13977v = false;
        this.f13979x = false;
        this.P = -1;
        this.U = new LinkedList();
        this.Z = new LinkedList<>();
        this.aa = new LinkedList<>();
        this.ab = new HashMap<>();
        this.ac = false;
        this.ad = false;
        if (iVar == null) {
            HaoboLog.clearLastResponse();
            return;
        }
        HaoboLog.setLastResponse(iVar.toString());
        HaoboLog.d(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.response_body, HaoboLog.getLastResponse()));
        this.mMediaType = kVar;
        a(map);
        a(iVar);
        b();
    }

    private void a(b.i iVar) {
        if (b(iVar)) {
            k kVar = this.mMediaType;
            if (kVar == k.PREFETCH) {
                if (d(iVar)) {
                    return;
                }
            } else if (kVar != k.NATIVE) {
                if (c(iVar)) {
                    return;
                }
            } else if (e(iVar)) {
                return;
            }
            f(iVar);
        }
    }

    public void handleClick(View view, com.beizi.ad.c.c cVar, String str, String str2, boolean z3, String str3, int i4) {
        String replaceToTouchEventUrl;
        l.a("BeiZisAd", "handleClick========" + z3);
        this.P = i4;
        if (!z3) {
            if (!StringUtil.isEmpty(this.mDetectClickUrl)) {
                this.mDetectClickUrl = UrlUtil.replaceToTouchEventUrl(this.mDetectClickUrl, cVar, str, str2, "", i4);
                new i(this.mDetectClickUrl).execute(new Void[0]);
                this.mDetectClickUrl = "";
            }
            if (this.Q != null && this.R != null) {
                for (int i5 = 0; i5 < this.R.size(); i5++) {
                    b.h hVar = this.R.get(i5);
                    if (hVar != null && !TextUtils.isEmpty(hVar.b())) {
                        if (!TextUtils.isEmpty(str3)) {
                            replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl(hVar.b(), cVar, str, str2, "", i4).replace(AdScopeTrackerTool.requestUUID, str3);
                        } else {
                            replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl(hVar.b(), cVar, str, str2, "", i4);
                        }
                        new i(StringUtil.replaceClick(view, replaceToTouchEventUrl)).executeOnExecutor(com.beizi.ad.lance.a.c.b().d(), new Void[0]);
                    }
                }
                this.R = null;
            }
        }
        l.a("BeiZisAd", "mDeepLinkUrl:" + this.X + ",appDownloadURL = " + this.E + ",mLandingPageUrl = " + this.W);
        Context context = view != null ? view.getContext() : null;
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.X)) {
            try {
                if (!com.beizi.ad.lance.a.j.a(context, Uri.decode(this.X)) && !h.a(context, this.C) && !Uri.decode(this.X).startsWith("hwpps://landingpage") && !Uri.decode(this.X).startsWith("intent") && !Uri.decode(this.X).startsWith("hap://")) {
                    b.C0119b.C0120b c0120b = this.f13981z;
                    if (c0120b != null) {
                        ReportEventUtil.report(c0120b.j());
                    }
                    a(context);
                    return;
                }
                b.C0119b.C0120b c0120b2 = this.f13981z;
                if (c0120b2 != null) {
                    ReportEventUtil.report(c0120b2.i());
                }
                b(context);
                b.C0119b.C0120b c0120b3 = this.f13981z;
                if (c0120b3 != null) {
                    ReportEventUtil.report(c0120b3.f());
                    return;
                }
                return;
            } catch (Exception unused) {
                b.C0119b.C0120b c0120b4 = this.f13981z;
                if (c0120b4 != null) {
                    ReportEventUtil.report(c0120b4.h());
                }
                a(context);
                return;
            }
        }
        a(context);
    }

    private String a(b.a aVar) {
        if (aVar.a() == e.f.RENDER_H5 || aVar.a() == e.f.RENDER_PIC) {
            if (aVar.a() == e.f.RENDER_PIC && aVar.d() > 0) {
                return "<!DOCTYPE html>\n<html lang=\"en\" style=\"width: 100%; height: 100%;\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" id=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1\">\n    <title>Document</title>\n</head>\n<body style=\"width: 100%; height: 100%; padding: 0; margin: 0;\">\n<img style=\"width: 100%; height: 100%\" src=\"__IMAGE_SRC_PATH__\" alt=\"\"/>\n</body>\n</html><!DOCTYPE html>".replace("__IMAGE_SRC_PATH__", aVar.c().get(0).b());
            }
            Matcher matcher = Pattern.compile("\\{(\\d+)\\.value\\}").matcher(aVar.b());
            HashMap hashMap = new HashMap();
            for (int i4 = 0; i4 < aVar.d(); i4++) {
                hashMap.put(Integer.valueOf(i4), aVar.c().get(i4).b());
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                Integer valueOf = Integer.valueOf(Integer.parseInt(matcher.group(1)));
                if (hashMap.get(valueOf) != null) {
                    matcher.appendReplacement(stringBuffer, (String) hashMap.get(valueOf));
                } else {
                    matcher.appendReplacement(stringBuffer, "");
                    HaoboLog.e(HaoboLog.pbLogTag, HaoboLog.getString(R.string.invalid_string_placeholder, matcher.group(0)));
                }
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.ad;
    }

    private void a(Context context) {
        try {
            if (c() && d()) {
                int i4 = this.A;
                if (i4 == 2) {
                    if (h.a(context, this.C)) {
                        h.b(context, this.C);
                        b.C0119b.C0120b c0120b = this.f13981z;
                        if (c0120b != null) {
                            ReportEventUtil.report(c0120b.a());
                            return;
                        }
                        return;
                    }
                    a(context, 1);
                    return;
                } else if (i4 == 5) {
                    if (com.beizi.ad.lance.a.j.a(context, this.E)) {
                        if (!this.O && this.P != 0) {
                            a(context, 2);
                            return;
                        }
                        a(this.E, context);
                        b.C0119b.C0120b c0120b2 = this.f13981z;
                        if (c0120b2 != null) {
                            ReportEventUtil.report(c0120b2.a());
                            return;
                        }
                        return;
                    }
                    c(context);
                    return;
                } else {
                    return;
                }
            }
            c(context);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public ServerResponse(boolean z3) {
        this.f13959d = 0;
        this.f13960e = 1;
        this.f13961f = 0;
        this.f13962g = 0;
        this.f13963h = 0;
        this.f13964i = 0;
        this.f13965j = false;
        this.f13966k = true;
        this.f13967l = false;
        this.f13968m = false;
        this.f13969n = false;
        this.f13970o = false;
        this.f13971p = 0;
        this.f13972q = 0;
        this.f13973r = false;
        this.f13974s = 0;
        this.f13975t = new AdLogoInfo();
        this.f13976u = new AdLogoInfo();
        this.f13977v = false;
        this.f13979x = false;
        this.P = -1;
        this.U = new LinkedList();
        this.Z = new LinkedList<>();
        this.aa = new LinkedList<>();
        this.ab = new HashMap<>();
        this.ac = false;
        this.ad = z3;
    }

    private void a(Context context, int i4) {
        try {
            File a4 = h.a(context);
            String absolutePath = a4 != null ? a4.getAbsolutePath() : "";
            ApkBean apkBean = new ApkBean(this.E, this.C + ".apk", this.C, absolutePath, this.B, this.D, context.getPackageName() + ".fileprovider", this.f13981z, this.F, this.G, this.H, this.I, this.J, this.K, this.f13955L);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i4);
            bundle.putBoolean("isCanJump", this.N);
            bundle.putBoolean("isDownload", c());
            if (i4 == 2) {
                b.C0119b.C0120b c0120b = this.f13981z;
                if (c0120b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c0120b.a());
                }
                bundle.putString("landingPageUrl", this.W);
            }
            Intent intent = new Intent(context, BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean c() {
        if (TextUtils.isEmpty(this.E) || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.G) || TextUtils.isEmpty(this.F) || TextUtils.isEmpty(this.J) || TextUtils.isEmpty(this.f13955L)) {
            return false;
        }
        if (TextUtils.isEmpty(this.I) && TextUtils.isEmpty(this.H)) {
            return false;
        }
        int i4 = this.A;
        return i4 == 2 || i4 == 5;
    }

    private void c(Context context) {
        if (context == null || TextUtils.isEmpty(this.W) || !this.W.startsWith("http")) {
            return;
        }
        if (this.f13977v) {
            Class a4 = AdActivity.a();
            try {
                WebView webView = new WebView(new MutableContextWrapper(context));
                WebviewUtil.setWebViewSettings(webView);
                webView.loadUrl(this.W, com.beizi.ad.lance.a.i.a());
                com.beizi.ad.internal.activity.a.f13657a.add(webView);
                Intent intent = new Intent(com.beizi.ad.internal.h.a().e(), a4);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                intent.putExtra("ACTIVITY_CAN_JUMP", this.N);
                intent.putExtra("ACTIVITY_CAN_DOWNLOAD", c());
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException unused) {
                l.a(HaoboLog.baseLogTag, HaoboLog.getString(R.string.adactivity_missing, a4.getName()));
                com.beizi.ad.internal.activity.a.f13657a.remove();
                return;
            } catch (Exception e4) {
                String str = HaoboLog.baseLogTag;
                l.a(str, "Exception initializing the redirect webview: " + e4.getMessage());
                return;
            }
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(this.W))));
        } catch (Exception unused2) {
        }
    }

    private void a(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(R.string.opening_url_failed, str));
        }
    }

    private void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.ae = JsonUtil.getJSONString(jSONObject, "Headline");
            this.af = JsonUtil.getJSONString(jSONObject, "Body");
            this.ai = JsonUtil.getJSONString(jSONObject, "AppIcon");
            JSONArray jSONArray = JsonUtil.getJSONArray(jSONObject, "Images");
            JSONArray jSONArray2 = JsonUtil.getJSONArray(jSONObject, "Videos");
            if (jSONArray != null && jSONArray.length() > 0) {
                this.ah = (String) jSONArray.get(0);
            }
            if (jSONArray2 == null || jSONArray2.length() <= 0) {
                return;
            }
            this.ag = (String) jSONArray2.get(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
