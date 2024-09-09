package com.beizi.ad.internal.nativead;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.beizi.ad.AdActivity;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.R;
import com.beizi.ad.c.b;
import com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.ad.internal.i;
import com.beizi.ad.internal.network.ServerResponse;
import com.beizi.ad.internal.p;
import com.beizi.ad.internal.r;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.JsonUtil;
import com.beizi.ad.internal.utilities.ReportEventUtil;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.internal.utilities.UrlUtil;
import com.beizi.ad.internal.utilities.WebviewUtil;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.f;
import com.beizi.ad.lance.a.h;
import com.beizi.ad.lance.a.j;
import com.beizi.ad.lance.a.l;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.control.track.AdScopeTrackerTool;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiNativeAdResponse.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a implements NativeAdResponse {
    private ServerResponse.AdLogoInfo A;
    private List<? extends View> B;
    private View D;
    private List<View> E;
    private NativeAdEventListener F;
    private View.OnClickListener G;
    private r H;
    private ArrayList<Object> I;
    private long K;

    /* renamed from: L  reason: collision with root package name */
    private int f13870L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private b.C0119b.C0120b X;
    private b.C0119b.a Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    private NativeAdResponse.b f13871a;
    private boolean aa;

    /* renamed from: b  reason: collision with root package name */
    private String f13872b;

    /* renamed from: c  reason: collision with root package name */
    private String f13873c;

    /* renamed from: d  reason: collision with root package name */
    private String f13874d;

    /* renamed from: f  reason: collision with root package name */
    private String f13876f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f13877g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f13878h;

    /* renamed from: i  reason: collision with root package name */
    private String f13879i;

    /* renamed from: j  reason: collision with root package name */
    private String f13880j;

    /* renamed from: k  reason: collision with root package name */
    private b.C0119b f13881k;

    /* renamed from: l  reason: collision with root package name */
    private String f13882l;

    /* renamed from: m  reason: collision with root package name */
    private double f13883m;

    /* renamed from: n  reason: collision with root package name */
    private String f13884n;

    /* renamed from: o  reason: collision with root package name */
    private String f13885o;

    /* renamed from: p  reason: collision with root package name */
    private String f13886p;

    /* renamed from: q  reason: collision with root package name */
    private HashMap<String, Object> f13887q;

    /* renamed from: z  reason: collision with root package name */
    private ServerResponse.AdLogoInfo f13896z;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Bitmap> f13875e = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private boolean f13888r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13889s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f13890t = false;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<String> f13891u = new ArrayList<>();

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<String> f13892v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private ArrayList<String> f13893w = new ArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private ArrayList<String> f13894x = new ArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    private ArrayList<String> f13895y = new ArrayList<>();
    private Runnable C = new Runnable() { // from class: com.beizi.ad.internal.nativead.a.1
        @Override // java.lang.Runnable
        public void run() {
            Log.e("expireRunnable", "expireRunnable");
            a.this.f13888r = true;
            a.this.D = null;
            a.this.E = null;
            if (a.this.H != null) {
                a.this.H.a();
                a.this.H = null;
            }
            a.this.I = null;
            a.this.F = null;
            if (a.this.f13878h != null) {
                a.this.f13878h.recycle();
                a.this.f13878h = null;
            }
            if (a.this.f13877g != null) {
                a.this.f13877g.recycle();
                a.this.f13877g = null;
            }
        }
    };
    private String J = "";
    private int ab = 0;
    private boolean ac = false;
    private boolean ad = false;

    a() {
    }

    @Override // com.beizi.ad.NativeAdResponse
    public void destroy() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.C);
        handler.post(this.C);
    }

    @Override // com.beizi.ad.NativeAdResponse
    public ServerResponse.AdLogoInfo getAdUrl() {
        return this.f13896z;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public String getAdvertiser() {
        return this.f13886p;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public ApkBean getApkInfo() {
        int i4 = this.f13870L;
        if (i4 == 2 || i4 == 5) {
            ApkBean apkBean = new ApkBean();
            apkBean.setApkName(this.M);
            apkBean.setAppVersion(this.Q);
            apkBean.setAppDeveloper(this.R);
            apkBean.setAppPermissionsDesc(this.S);
            apkBean.setAppPermissionsUrl(this.T);
            apkBean.setAppPrivacyUrl(this.U);
            apkBean.setAppintro(this.W);
            return apkBean;
        }
        return null;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public String getBody() {
        return this.f13873c;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public String getCallToAction() {
        return this.f13882l;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public ArrayList<String> getClickTrackers() {
        return this.f13895y;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public String getHeadline() {
        return this.f13872b;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public Bitmap getIcon() {
        return this.f13878h;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public String getIconUrl() {
        return this.f13876f;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public Bitmap getImage() {
        return this.f13877g;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public String getImageUrl() {
        return this.f13874d;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public ArrayList<String> getImageUrls() {
        return this.f13891u;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public ArrayList<String> getImpTrackers() {
        return this.f13894x;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public String getLandingPageUrl() {
        return this.f13879i;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public NativeAdResponse.b getNativeAdType() {
        return this.f13871a;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public HashMap<String, Object> getNativeElements() {
        return this.f13887q;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public List<? extends View> getNativeInfoListView() {
        return this.B;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public NativeAdResponse.a getNetworkIdentifier() {
        return NativeAdResponse.a.BeiZi;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public String getPrice() {
        return this.f13885o;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public double getStarRating() {
        return this.f13883m;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public String getStore() {
        return this.f13884n;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public ArrayList<String> getTexts() {
        return this.f13893w;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public ArrayList<String> getVedioUrls() {
        return this.f13892v;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public ServerResponse.AdLogoInfo getlogoUrl() {
        return this.A;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public void handleClick(Context context) {
        if (context == null) {
            Log.d("lance", "handleClick  context is null");
            return;
        }
        if (!this.f13890t) {
            Iterator<String> it = this.f13895y.iterator();
            while (it.hasNext()) {
                new i(it.next()).executeOnExecutor(com.beizi.ad.lance.a.c.b().d(), new Void[0]);
            }
            this.f13895y.clear();
            this.f13890t = true;
        }
        this.ab = 0;
        if (a(this.f13880j, this.f13879i, context)) {
            return;
        }
        Log.d("lance", "Unable to handle click.");
    }

    @Override // com.beizi.ad.NativeAdResponse
    public boolean hasExpired() {
        return this.f13888r;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public void regesterClickListener(View view, final NativeAdEventListener nativeAdEventListener) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.nativead.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    if (a.this.f13895y != null) {
                        Iterator it = a.this.f13895y.iterator();
                        while (it.hasNext()) {
                            new i((String) it.next()).execute(new Void[0]);
                        }
                    }
                    nativeAdEventListener.onAdWasClicked();
                    Context context = view2.getContext();
                    View rootView = view2.getRootView();
                    if (rootView != null) {
                        context = rootView.getContext();
                    }
                    a.this.ab = 0;
                    a aVar = a.this;
                    if (!aVar.a(aVar.f13880j, a.this.f13879i, context)) {
                        HaoboLog.d(HaoboLog.nativeLogTag, "Unable to handle click.");
                    }
                    a.this.f13895y = null;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    @Override // com.beizi.ad.NativeAdResponse
    public boolean regesterShow(View view) {
        if (this.f13888r || view == null) {
            return false;
        }
        this.D = view;
        new Handler(Looper.getMainLooper()).removeCallbacks(this.C);
        return true;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public boolean registerView(final View view, NativeAdEventListener nativeAdEventListener) {
        if (this.f13888r || view == null) {
            return false;
        }
        this.F = nativeAdEventListener;
        this.D = view;
        final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.beizi.ad.internal.nativead.a.4
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                a.this.K = System.currentTimeMillis();
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (a.this.f13895y != null) {
                    float x3 = motionEvent.getX();
                    float y3 = motionEvent.getY();
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    Iterator it = a.this.f13895y.iterator();
                    while (it.hasNext()) {
                        String replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl((String) it.next(), x3 + "", y3 + "", rawX + "", rawY + "", String.valueOf(a.this.K), String.valueOf(System.currentTimeMillis()), "", 0);
                        if (!TextUtils.isEmpty(a.this.J)) {
                            replaceToTouchEventUrl = replaceToTouchEventUrl.replace(AdScopeTrackerTool.requestUUID, a.this.J);
                        }
                        new i(StringUtil.replaceClick(view, replaceToTouchEventUrl)).execute(new Void[0]);
                    }
                }
                a.this.f13895y = null;
                return false;
            }
        });
        a();
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.nativead.a.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
        view.setOnClickListener(this.G);
        new Handler(Looper.getMainLooper()).removeCallbacks(this.C);
        return true;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public boolean registerViewList(final View view, List<View> list, NativeAdEventListener nativeAdEventListener) {
        if (registerView(view, nativeAdEventListener)) {
            if (list == null || list.size() <= 0) {
                return true;
            }
            view.setOnClickListener(null);
            for (View view2 : list) {
                final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.beizi.ad.internal.nativead.a.6
                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onDown(MotionEvent motionEvent) {
                        a.this.K = System.currentTimeMillis();
                        return false;
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
                        return false;
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public void onLongPress(MotionEvent motionEvent) {
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
                        return false;
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public void onShowPress(MotionEvent motionEvent) {
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onSingleTapUp(MotionEvent motionEvent) {
                        if (a.this.f13895y != null) {
                            float x3 = motionEvent.getX();
                            float y3 = motionEvent.getY();
                            float rawX = motionEvent.getRawX();
                            float rawY = motionEvent.getRawY();
                            Iterator it = a.this.f13895y.iterator();
                            while (it.hasNext()) {
                                String replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl((String) it.next(), x3 + "", y3 + "", rawX + "", rawY + "", String.valueOf(a.this.K), String.valueOf(System.currentTimeMillis()), "", 0);
                                if (!TextUtils.isEmpty(a.this.J)) {
                                    replaceToTouchEventUrl = replaceToTouchEventUrl.replace(AdScopeTrackerTool.requestUUID, a.this.J);
                                }
                                new i(StringUtil.replaceClick(view, replaceToTouchEventUrl)).execute(new Void[0]);
                            }
                        }
                        a.this.f13895y = null;
                        return false;
                    }
                });
                view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.nativead.a.7
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view3, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
                view2.setOnClickListener(this.G);
            }
            this.E = list;
            return true;
        }
        return false;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public void sendClickLog() {
        if (this.f13890t) {
            return;
        }
        Iterator<String> it = this.f13895y.iterator();
        while (it.hasNext()) {
            new i(it.next()).executeOnExecutor(com.beizi.ad.lance.a.c.b().d(), new Void[0]);
        }
        this.f13895y.clear();
        this.f13890t = true;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public void sendImpLog() {
        if (this.f13889s) {
            return;
        }
        Iterator<String> it = this.f13894x.iterator();
        while (it.hasNext()) {
            new i(it.next()).executeOnExecutor(com.beizi.ad.lance.a.c.b().d(), new Void[0]);
        }
        this.f13894x.clear();
        this.f13889s = true;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public void setIcon(Bitmap bitmap) {
        this.f13878h = bitmap;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public void setImage(Bitmap bitmap) {
        this.f13877g = bitmap;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public void setNativeInfoListView(List<? extends View> list) {
        this.B = list;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public void unregisterViews() {
        View view = this.D;
        if (view != null) {
            view.setOnClickListener(null);
        }
        List<View> list = this.E;
        if (list != null && !list.isEmpty()) {
            for (View view2 : this.E) {
                view2.setOnClickListener(null);
            }
        }
        destroy();
    }

    public void d(String str) {
        this.f13894x.add(str);
    }

    public void e(String str) {
        this.f13895y.add(str);
    }

    public void c(String str) {
        this.f13880j = str;
    }

    private boolean c() {
        int i4 = this.f13870L;
        return i4 == 2 ? !TextUtils.isEmpty(this.P) && this.P.startsWith("http") : i4 == 5 && !TextUtils.isEmpty(this.P) && this.P.contains("market://");
    }

    public void b(ServerResponse.AdLogoInfo adLogoInfo) {
        this.A = adLogoInfo;
    }

    public void b(String str) {
        this.f13879i = str;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public boolean regesterShow(final View view, NativeAdShownListener nativeAdShownListener) {
        if (!this.f13888r && view != null) {
            f.a(view, nativeAdShownListener, new d() { // from class: com.beizi.ad.internal.nativead.a.3
                @Override // com.beizi.ad.internal.nativead.d
                public void a() {
                    if (a.this.f13894x == null || a.this.f13894x.size() == 0) {
                        return;
                    }
                    Iterator it = a.this.f13894x.iterator();
                    while (it.hasNext()) {
                        new p(a.this.a((String) it.next(), view)).a();
                    }
                    a.this.f13894x = null;
                }
            });
            this.D = view;
            new Handler(Looper.getMainLooper()).removeCallbacks(this.C);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z3) {
        this.ad = z3;
    }

    private boolean b() {
        if (TextUtils.isEmpty(this.P) || TextUtils.isEmpty(this.M) || TextUtils.isEmpty(this.R) || TextUtils.isEmpty(this.Q) || TextUtils.isEmpty(this.U) || TextUtils.isEmpty(this.W)) {
            return false;
        }
        if (TextUtils.isEmpty(this.T) && TextUtils.isEmpty(this.S)) {
            return false;
        }
        int i4 = this.f13870L;
        return i4 == 2 || i4 == 5;
    }

    @Override // com.beizi.ad.NativeAdResponse
    public void handleClick(Context context, View view, String str, String str2, String str3, String str4, int i4) {
        this.ab = i4;
        ArrayList<String> arrayList = this.f13895y;
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl(it.next(), str + "", str2 + "", str3 + "", str4 + "", String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()), "", i4);
                if (!TextUtils.isEmpty(this.J)) {
                    replaceToTouchEventUrl = replaceToTouchEventUrl.replace(AdScopeTrackerTool.requestUUID, this.J);
                }
                new i(StringUtil.replaceClick(view, replaceToTouchEventUrl)).execute(new Void[0]);
            }
        }
        this.f13895y = null;
        if (!a(this.f13880j, this.f13879i, context)) {
            Log.d("lance", "Unable to handle click.");
        }
        NativeAdEventListener nativeAdEventListener = this.F;
        if (nativeAdEventListener != null) {
            nativeAdEventListener.onAdWasClicked();
        }
    }

    public void a(ServerResponse.AdLogoInfo adLogoInfo) {
        this.f13896z = adLogoInfo;
    }

    public void a(String str) {
        this.J = str;
    }

    public static a a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        ArrayList<String> stringArrayList = JsonUtil.getStringArrayList(JsonUtil.getJSONArray(jSONObject, "ImpressionTrackers"));
        a aVar = new a();
        if (stringArrayList != null) {
            aVar.f13894x = stringArrayList;
        }
        aVar.f13872b = JsonUtil.getJSONString(jSONObject, "Headline");
        aVar.f13873c = JsonUtil.getJSONString(jSONObject, "Body");
        aVar.f13874d = JsonUtil.getJSONString(jSONObject, "Image");
        JSONArray jSONArray = JsonUtil.getJSONArray(jSONObject, "Images");
        JSONArray jSONArray2 = JsonUtil.getJSONArray(jSONObject, "Videos");
        JSONArray jSONArray3 = JsonUtil.getJSONArray(jSONObject, "Texts");
        if (jSONArray != null) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                aVar.f13891u.add((String) jSONArray.get(i4));
            }
        }
        if (jSONArray2 != null) {
            for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                aVar.f13892v.add((String) jSONArray2.get(i5));
            }
        }
        if (jSONArray3 != null) {
            for (int i6 = 0; i6 < jSONArray3.length(); i6++) {
                aVar.f13893w.add((String) jSONArray3.get(i6));
            }
        }
        if (jSONObject.has("AppIcon")) {
            aVar.f13871a = NativeAdResponse.b.APP_INSTALL;
            aVar.f13876f = JsonUtil.getJSONString(jSONObject, "AppIcon");
            aVar.f13882l = JsonUtil.getJSONString(jSONObject, "Action");
            aVar.f13883m = JsonUtil.getJSONDouble(jSONObject, "Star");
            aVar.f13884n = JsonUtil.getJSONString(jSONObject, "Store");
            aVar.f13885o = JsonUtil.getJSONString(jSONObject, "Price");
        } else {
            aVar.f13871a = NativeAdResponse.b.CONTENT;
            aVar.f13876f = JsonUtil.getJSONString(jSONObject, "Logo");
            aVar.f13882l = JsonUtil.getJSONString(jSONObject, "Action");
            aVar.f13886p = JsonUtil.getJSONString(jSONObject, "Advertiser");
        }
        ArrayList<String> stringArrayList2 = JsonUtil.getStringArrayList(JsonUtil.getJSONArray(jSONObject, "ClickTrackers"));
        if (stringArrayList2 != null) {
            aVar.f13895y = stringArrayList2;
        }
        aVar.f13887q = JsonUtil.getStringObjectHashMap(JsonUtil.getJSONObject(jSONObject, "Custom"));
        new Handler(Looper.getMainLooper()).postDelayed(aVar.C, 3600000L);
        return aVar;
    }

    private boolean b(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(R.string.opening_url_failed, str));
            return false;
        }
    }

    public String a(String str, View view) {
        if (view != null) {
            if (!TextUtils.isEmpty(this.J)) {
                str = str.replace(AdScopeTrackerTool.requestUUID, this.J);
            }
            return StringUtil.replaceView(0, view, str);
        }
        return UrlUtil.replaceToTouchEventUrl(str, "", "", "", "", "", "", "");
    }

    public void a(b.C0119b c0119b) {
        this.f13881k = c0119b;
        this.X = c0119b.j();
        this.f13870L = c0119b.c();
        this.M = c0119b.d();
        this.N = c0119b.e();
        this.O = c0119b.f();
        this.P = c0119b.g();
        if (TextUtils.isEmpty(this.N)) {
            this.N = "lance";
        }
        if (TextUtils.isEmpty(this.M)) {
            this.M = "BeiZi";
        }
        if (TextUtils.isEmpty(this.O)) {
            this.O = "Ad Download";
        }
        this.Q = c0119b.m();
        this.R = c0119b.n();
        this.S = c0119b.o();
        this.T = c0119b.p();
        this.U = c0119b.q();
        this.V = c0119b.r();
        this.W = c0119b.s();
        b.C0119b.a t3 = c0119b.t();
        this.Y = t3;
        if (t3 != null) {
            if (t3.a() == 1) {
                this.Z = true;
            }
            if (this.Y.b() == 1) {
                this.aa = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z3) {
        this.ac = z3;
    }

    private void a() {
        this.G = new View.OnClickListener() { // from class: com.beizi.ad.internal.nativead.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (a.this.f13895y != null) {
                        Iterator it = a.this.f13895y.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            l.a("lance", "setClickListener:" + str);
                            new i(str).execute(new Void[0]);
                        }
                    }
                    Context context = view.getContext();
                    View rootView = view.getRootView();
                    if (rootView != null) {
                        context = rootView.getContext();
                    }
                    a.this.ab = 0;
                    a aVar = a.this;
                    if (!aVar.a(aVar.f13880j, a.this.f13879i, context)) {
                        HaoboLog.d(HaoboLog.nativeLogTag, "Unable to handle click.");
                    }
                    if (a.this.F != null) {
                        a.this.F.onAdWasClicked();
                    }
                    a.this.f13895y = null;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2, Context context) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (!j.a(context, str) && !h.a(context, this.N) && !str.startsWith("hwpps://landingpage") && !str.startsWith("intent") && !str.startsWith("hap://")) {
                    b.C0119b.C0120b c0120b = this.X;
                    if (c0120b != null) {
                        ReportEventUtil.report(c0120b.j());
                    }
                    a(context, str2);
                    return true;
                }
                b.C0119b.C0120b c0120b2 = this.X;
                if (c0120b2 != null) {
                    ReportEventUtil.report(c0120b2.i());
                }
                a(context);
                b.C0119b.C0120b c0120b3 = this.X;
                if (c0120b3 != null) {
                    ReportEventUtil.report(c0120b3.f());
                }
                return true;
            } catch (Exception unused) {
                b.C0119b.C0120b c0120b4 = this.X;
                if (c0120b4 != null) {
                    ReportEventUtil.report(c0120b4.h());
                }
                a(context, str2);
                return true;
            }
        }
        a(context, str2);
        return true;
    }

    private void a(Context context, String str) {
        try {
            if (b() && c()) {
                int i4 = this.f13870L;
                if (i4 == 2) {
                    if (h.a(context, this.N)) {
                        h.b(context, this.N);
                        b.C0119b.C0120b c0120b = this.X;
                        if (c0120b != null) {
                            ReportEventUtil.report(c0120b.a());
                            return;
                        }
                        return;
                    }
                    a(context, 1);
                    return;
                } else if (i4 == 5) {
                    if (j.a(context, this.P)) {
                        if (!this.aa && this.ab != 0) {
                            a(context, 2);
                            return;
                        }
                        b(this.P, context);
                        b.C0119b.C0120b c0120b2 = this.X;
                        if (c0120b2 != null) {
                            ReportEventUtil.report(c0120b2.a());
                            return;
                        }
                        return;
                    }
                    a(str, context);
                    return;
                } else {
                    return;
                }
            }
            a(str, context);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(Context context, int i4) {
        try {
            File a4 = h.a(context);
            String absolutePath = a4 != null ? a4.getAbsolutePath() : "";
            ApkBean apkBean = new ApkBean(this.P, this.N + ".apk", this.N, absolutePath, this.M, this.O, context.getPackageName() + ".fileprovider", this.X, this.Q, this.R, this.S, this.T, this.U, this.V, this.W);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i4);
            bundle.putBoolean("isCanJump", this.Z);
            bundle.putBoolean("isDownload", b());
            if (i4 == 2) {
                b.C0119b.C0120b c0120b = this.X;
                if (c0120b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c0120b.a());
                }
                bundle.putString("landingPageUrl", this.f13879i);
            }
            Intent intent = new Intent(context, BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(Context context) {
        com.beizi.ad.internal.h.a().a(new com.beizi.ad.internal.b() { // from class: com.beizi.ad.internal.nativead.a.9
            @Override // com.beizi.ad.internal.b
            public void onReport() {
                try {
                    if (a.this.X != null) {
                        ReportEventUtil.report(a.this.X.g());
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
        Uri parse = Uri.parse(this.f13880j);
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
            if (context != null) {
                context.startActivity(intent);
            }
        } else if (this.f13880j.startsWith("hwpps://landingpage")) {
            Intent intent2 = new Intent();
            intent2.setData(parse);
            intent2.addFlags(268435456);
            if (context != null) {
                context.startActivity(intent2);
            }
        } else if (this.f13880j.startsWith("intent")) {
            Intent intent3 = null;
            try {
                intent3 = Intent.parseUri(this.f13880j, 1);
                intent3.addFlags(268435456);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            if (context != null) {
                context.startActivity(intent3);
            }
        } else {
            Intent intent4 = new Intent("android.intent.action.VIEW", parse);
            intent4.addFlags(805339136);
            if (context != null) {
                context.startActivity(intent4);
            }
        }
    }

    private boolean a(String str, Context context) {
        if (str != null && !str.isEmpty()) {
            if (!this.ac) {
                if (b(str, context)) {
                    NativeAdEventListener nativeAdEventListener = this.F;
                    if (nativeAdEventListener != null) {
                        nativeAdEventListener.onAdWillLeaveApplication();
                    }
                    return true;
                }
                return false;
            }
            Class a4 = AdActivity.a();
            try {
                WebView webView = new WebView(new MutableContextWrapper(context));
                WebviewUtil.setWebViewSettings(webView);
                webView.loadUrl(str, com.beizi.ad.lance.a.i.a());
                com.beizi.ad.internal.activity.a.f13657a.add(webView);
                Intent intent = new Intent(context, a4);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                intent.putExtra("ACTIVITY_CAN_JUMP", this.Z);
                intent.putExtra("ACTIVITY_CAN_DOWNLOAD", b());
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                HaoboLog.w(HaoboLog.baseLogTag, HaoboLog.getString(R.string.adactivity_missing, a4.getName()));
                com.beizi.ad.internal.activity.a.f13657a.remove();
            } catch (Exception e4) {
                String str2 = HaoboLog.baseLogTag;
                HaoboLog.e(str2, "Exception initializing the redirect webview: " + e4.getMessage());
                return false;
            }
        }
        return false;
    }
}
