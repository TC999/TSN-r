package com.beizi.p051ad.internal.nativead;

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
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.AdClickReportListener;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.ClickTracker;
import com.beizi.p051ad.internal.ShowMonitorTracker;
import com.beizi.p051ad.internal.VisibilityDetector;
import com.beizi.p051ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.p051ad.internal.activity.BrowserAdActivity;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.JsonUtil;
import com.beizi.p051ad.internal.utilities.ReportEventUtil;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.utilities.UrlUtil;
import com.beizi.p051ad.internal.utilities.WebviewUtil;
import com.beizi.p051ad.lance.ApkBean;
import com.beizi.p051ad.lance.p062a.BeiZiExecutor;
import com.beizi.p051ad.lance.p062a.CheckViewVisibilityUtil;
import com.beizi.p051ad.lance.p062a.FileUtil;
import com.beizi.p051ad.lance.p062a.HeaderUtil;
import com.beizi.p051ad.lance.p062a.JumpTool;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.p056c.AdResponseOuterClass;
import com.kuaishou.weapon.p205p0.C7193bi;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.beizi.ad.internal.nativead.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiNativeAdResponse implements NativeAdResponse {

    /* renamed from: A */
    private ServerResponse.AdLogoInfo f10202A;

    /* renamed from: B */
    private List<? extends View> f10203B;

    /* renamed from: D */
    private View f10205D;

    /* renamed from: E */
    private List<View> f10206E;

    /* renamed from: F */
    private NativeAdEventListener f10207F;

    /* renamed from: G */
    private View.OnClickListener f10208G;

    /* renamed from: H */
    private VisibilityDetector f10209H;

    /* renamed from: I */
    private ArrayList<Object> f10210I;

    /* renamed from: K */
    private long f10212K;

    /* renamed from: L */
    private int f10213L;

    /* renamed from: M */
    private String f10214M;

    /* renamed from: N */
    private String f10215N;

    /* renamed from: O */
    private String f10216O;

    /* renamed from: P */
    private String f10217P;

    /* renamed from: Q */
    private String f10218Q;

    /* renamed from: R */
    private String f10219R;

    /* renamed from: S */
    private String f10220S;

    /* renamed from: T */
    private String f10221T;

    /* renamed from: U */
    private String f10222U;

    /* renamed from: V */
    private String f10223V;

    /* renamed from: W */
    private String f10224W;

    /* renamed from: X */
    private AdResponseOuterClass.C2793b.C2795b f10225X;

    /* renamed from: Y */
    private AdResponseOuterClass.C2793b.C2794a f10226Y;

    /* renamed from: Z */
    private boolean f10227Z;

    /* renamed from: a */
    private NativeAdResponse.EnumC2749b f10228a;

    /* renamed from: b */
    private String f10231b;

    /* renamed from: c */
    private String f10232c;

    /* renamed from: d */
    private String f10233d;

    /* renamed from: f */
    private String f10235f;

    /* renamed from: g */
    private Bitmap f10236g;

    /* renamed from: h */
    private Bitmap f10237h;

    /* renamed from: i */
    private String f10238i;

    /* renamed from: j */
    private String f10239j;

    /* renamed from: k */
    private AdResponseOuterClass.C2793b f10240k;

    /* renamed from: l */
    private String f10241l;

    /* renamed from: m */
    private double f10242m;

    /* renamed from: n */
    private String f10243n;

    /* renamed from: o */
    private String f10244o;

    /* renamed from: p */
    private String f10245p;

    /* renamed from: q */
    private HashMap<String, Object> f10246q;

    /* renamed from: z */
    private ServerResponse.AdLogoInfo f10255z;

    /* renamed from: e */
    private ArrayList<Bitmap> f10234e = new ArrayList<>();

    /* renamed from: r */
    private boolean f10247r = false;

    /* renamed from: s */
    private boolean f10248s = false;

    /* renamed from: t */
    private boolean f10249t = false;

    /* renamed from: u */
    private ArrayList<String> f10250u = new ArrayList<>();

    /* renamed from: v */
    private ArrayList<String> f10251v = new ArrayList<>();

    /* renamed from: w */
    private ArrayList<String> f10252w = new ArrayList<>();

    /* renamed from: x */
    private ArrayList<String> f10253x = new ArrayList<>();

    /* renamed from: y */
    private ArrayList<String> f10254y = new ArrayList<>();

    /* renamed from: C */
    private Runnable f10204C = new Runnable() { // from class: com.beizi.ad.internal.nativead.a.1
        @Override // java.lang.Runnable
        public void run() {
            Log.e("expireRunnable", "expireRunnable");
            BeiZiNativeAdResponse.this.f10247r = true;
            BeiZiNativeAdResponse.this.f10205D = null;
            BeiZiNativeAdResponse.this.f10206E = null;
            if (BeiZiNativeAdResponse.this.f10209H != null) {
                BeiZiNativeAdResponse.this.f10209H.m49293a();
                BeiZiNativeAdResponse.this.f10209H = null;
            }
            BeiZiNativeAdResponse.this.f10210I = null;
            BeiZiNativeAdResponse.this.f10207F = null;
            if (BeiZiNativeAdResponse.this.f10237h != null) {
                BeiZiNativeAdResponse.this.f10237h.recycle();
                BeiZiNativeAdResponse.this.f10237h = null;
            }
            if (BeiZiNativeAdResponse.this.f10236g != null) {
                BeiZiNativeAdResponse.this.f10236g.recycle();
                BeiZiNativeAdResponse.this.f10236g = null;
            }
        }
    };

    /* renamed from: J */
    private String f10211J = "";

    /* renamed from: aa */
    private boolean f10229aa = false;

    /* renamed from: ab */
    private boolean f10230ab = false;

    BeiZiNativeAdResponse() {
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public void destroy() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.f10204C);
        handler.post(this.f10204C);
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public ServerResponse.AdLogoInfo getAdUrl() {
        return this.f10255z;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public String getAdvertiser() {
        return this.f10245p;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public ApkBean getApkInfo() {
        int i = this.f10213L;
        if (i == 2 || i == 5) {
            ApkBean apkBean = new ApkBean();
            apkBean.setApkName(this.f10214M);
            apkBean.setAppVersion(this.f10218Q);
            apkBean.setAppDeveloper(this.f10219R);
            apkBean.setAppPermissionsDesc(this.f10220S);
            apkBean.setAppPermissionsUrl(this.f10221T);
            apkBean.setAppPrivacyUrl(this.f10222U);
            apkBean.setAppintro(this.f10224W);
            return apkBean;
        }
        return null;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public String getBody() {
        return this.f10232c;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public String getCallToAction() {
        return this.f10241l;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public ArrayList<String> getClickTrackers() {
        return this.f10254y;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public String getHeadline() {
        return this.f10231b;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public Bitmap getIcon() {
        return this.f10237h;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public String getIconUrl() {
        return this.f10235f;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public Bitmap getImage() {
        return this.f10236g;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public String getImageUrl() {
        return this.f10233d;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public ArrayList<String> getImageUrls() {
        return this.f10250u;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public ArrayList<String> getImpTrackers() {
        return this.f10253x;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public String getLandingPageUrl() {
        return this.f10238i;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public NativeAdResponse.EnumC2749b getNativeAdType() {
        return this.f10228a;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public HashMap<String, Object> getNativeElements() {
        return this.f10246q;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public List<? extends View> getNativeInfoListView() {
        return this.f10203B;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public NativeAdResponse.EnumC2748a getNetworkIdentifier() {
        return NativeAdResponse.EnumC2748a.BeiZi;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public String getPrice() {
        return this.f10244o;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public double getStarRating() {
        return this.f10242m;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public String getStore() {
        return this.f10243n;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public ArrayList<String> getTexts() {
        return this.f10252w;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public ArrayList<String> getVedioUrls() {
        return this.f10251v;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public ServerResponse.AdLogoInfo getlogoUrl() {
        return this.f10202A;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public void handleClick(Context context) {
        if (context == null) {
            Log.d("lance", "handleClick  context is null");
            return;
        }
        if (!this.f10249t) {
            Iterator<String> it = this.f10254y.iterator();
            while (it.hasNext()) {
                new ClickTracker(it.next()).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
            }
            this.f10254y.clear();
            this.f10249t = true;
        }
        if (m49434a(this.f10239j, this.f10238i, context)) {
            return;
        }
        Log.d("lance", "Unable to handle click.");
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public boolean hasExpired() {
        return this.f10247r;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public void regesterClickListener(View view, final NativeAdEventListener nativeAdEventListener) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.nativead.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    if (BeiZiNativeAdResponse.this.f10254y != null) {
                        Iterator it = BeiZiNativeAdResponse.this.f10254y.iterator();
                        while (it.hasNext()) {
                            new ClickTracker((String) it.next()).execute(new Void[0]);
                        }
                    }
                    nativeAdEventListener.onAdWasClicked();
                    Context context = view2.getContext();
                    View rootView = view2.getRootView();
                    if (rootView != null) {
                        context = rootView.getContext();
                    }
                    BeiZiNativeAdResponse beiZiNativeAdResponse = BeiZiNativeAdResponse.this;
                    if (!beiZiNativeAdResponse.m49434a(beiZiNativeAdResponse.f10239j, BeiZiNativeAdResponse.this.f10238i, context)) {
                        HaoboLog.m49292d(HaoboLog.nativeLogTag, "Unable to handle click.");
                    }
                    BeiZiNativeAdResponse.this.f10254y = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public boolean regesterShow(View view) {
        if (this.f10247r || view == null) {
            return false;
        }
        this.f10205D = view;
        new Handler(Looper.getMainLooper()).removeCallbacks(this.f10204C);
        return true;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public boolean registerView(final View view, NativeAdEventListener nativeAdEventListener) {
        if (this.f10247r || view == null) {
            return false;
        }
        this.f10207F = nativeAdEventListener;
        this.f10205D = view;
        final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.beizi.ad.internal.nativead.a.4
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                BeiZiNativeAdResponse.this.f10212K = System.currentTimeMillis();
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (BeiZiNativeAdResponse.this.f10254y != null) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    Iterator it = BeiZiNativeAdResponse.this.f10254y.iterator();
                    while (it.hasNext()) {
                        String replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl((String) it.next(), x + "", y + "", rawX + "", rawY + "", String.valueOf(BeiZiNativeAdResponse.this.f10212K), String.valueOf(System.currentTimeMillis()), "", 0);
                        if (!TextUtils.isEmpty(BeiZiNativeAdResponse.this.f10211J)) {
                            replaceToTouchEventUrl = replaceToTouchEventUrl.replace("__REQUESTUUID__", BeiZiNativeAdResponse.this.f10211J);
                        }
                        new ClickTracker(StringUtil.replaceClick(view, replaceToTouchEventUrl)).execute(new Void[0]);
                    }
                }
                BeiZiNativeAdResponse.this.f10254y = null;
                return false;
            }
        });
        m49453a();
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.nativead.a.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
        view.setOnClickListener(this.f10208G);
        new Handler(Looper.getMainLooper()).removeCallbacks(this.f10204C);
        return true;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
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
                        BeiZiNativeAdResponse.this.f10212K = System.currentTimeMillis();
                        return false;
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                        return false;
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public void onLongPress(MotionEvent motionEvent) {
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                        return false;
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public void onShowPress(MotionEvent motionEvent) {
                    }

                    @Override // android.view.GestureDetector.OnGestureListener
                    public boolean onSingleTapUp(MotionEvent motionEvent) {
                        if (BeiZiNativeAdResponse.this.f10254y != null) {
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            float rawX = motionEvent.getRawX();
                            float rawY = motionEvent.getRawY();
                            Iterator it = BeiZiNativeAdResponse.this.f10254y.iterator();
                            while (it.hasNext()) {
                                String replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl((String) it.next(), x + "", y + "", rawX + "", rawY + "", String.valueOf(BeiZiNativeAdResponse.this.f10212K), String.valueOf(System.currentTimeMillis()), "", 0);
                                if (!TextUtils.isEmpty(BeiZiNativeAdResponse.this.f10211J)) {
                                    replaceToTouchEventUrl = replaceToTouchEventUrl.replace("__REQUESTUUID__", BeiZiNativeAdResponse.this.f10211J);
                                }
                                new ClickTracker(StringUtil.replaceClick(view, replaceToTouchEventUrl)).execute(new Void[0]);
                            }
                        }
                        BeiZiNativeAdResponse.this.f10254y = null;
                        return false;
                    }
                });
                view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.nativead.a.7
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view3, MotionEvent motionEvent) {
                        return gestureDetector.onTouchEvent(motionEvent);
                    }
                });
                view2.setOnClickListener(this.f10208G);
            }
            this.f10206E = list;
            return true;
        }
        return false;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public void sendClickLog() {
        if (this.f10249t) {
            return;
        }
        Iterator<String> it = this.f10254y.iterator();
        while (it.hasNext()) {
            new ClickTracker(it.next()).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
        }
        this.f10254y.clear();
        this.f10249t = true;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public void sendImpLog() {
        if (this.f10248s) {
            return;
        }
        Iterator<String> it = this.f10253x.iterator();
        while (it.hasNext()) {
            new ClickTracker(it.next()).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
        }
        this.f10253x.clear();
        this.f10248s = true;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public void setIcon(Bitmap bitmap) {
        this.f10237h = bitmap;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public void setImage(Bitmap bitmap) {
        this.f10236g = bitmap;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public void setNativeInfoListView(List<? extends View> list) {
        this.f10203B = list;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public void unregisterViews() {
        View view = this.f10205D;
        if (view != null) {
            view.setOnClickListener(null);
        }
        List<View> list = this.f10206E;
        if (list != null && !list.isEmpty()) {
            for (View view2 : this.f10206E) {
                view2.setOnClickListener(null);
            }
        }
        destroy();
    }

    /* renamed from: d */
    public void m49419d(String str) {
        this.f10253x.add(str);
    }

    /* renamed from: e */
    public void m49417e(String str) {
        this.f10254y.add(str);
    }

    /* renamed from: c */
    public void m49421c(String str) {
        this.f10239j = str;
    }

    /* renamed from: b */
    public void m49427b(ServerResponse.AdLogoInfo adLogoInfo) {
        this.f10202A = adLogoInfo;
    }

    /* renamed from: b */
    public void m49426b(String str) {
        this.f10238i = str;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public boolean regesterShow(final View view, NativeAdShownListener nativeAdShownListener) {
        if (!this.f10247r && view != null) {
            CheckViewVisibilityUtil.m49078a(view, nativeAdShownListener, new ShowMonitorListener() { // from class: com.beizi.ad.internal.nativead.a.3
                @Override // com.beizi.p051ad.internal.nativead.ShowMonitorListener
                /* renamed from: a */
                public void mo49367a() {
                    if (BeiZiNativeAdResponse.this.f10253x == null || BeiZiNativeAdResponse.this.f10253x.size() == 0) {
                        return;
                    }
                    Iterator it = BeiZiNativeAdResponse.this.f10253x.iterator();
                    while (it.hasNext()) {
                        new ShowMonitorTracker(BeiZiNativeAdResponse.this.m49435a((String) it.next(), view)).m49298a();
                    }
                    BeiZiNativeAdResponse.this.f10253x = null;
                }
            });
            this.f10205D = view;
            new Handler(Looper.getMainLooper()).removeCallbacks(this.f10204C);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m49424b(boolean z) {
        this.f10230ab = z;
    }

    /* renamed from: b */
    private boolean m49431b() {
        if (TextUtils.isEmpty(this.f10217P) || TextUtils.isEmpty(this.f10214M) || TextUtils.isEmpty(this.f10219R) || TextUtils.isEmpty(this.f10218Q) || TextUtils.isEmpty(this.f10222U) || TextUtils.isEmpty(this.f10224W)) {
            return false;
        }
        if (TextUtils.isEmpty(this.f10221T) && TextUtils.isEmpty(this.f10220S)) {
            return false;
        }
        int i = this.f10213L;
        return i == 2 || i == 5;
    }

    @Override // com.beizi.p051ad.NativeAdResponse
    public void handleClick(Context context, View view, String str, String str2, String str3, String str4, int i) {
        ArrayList<String> arrayList = this.f10254y;
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String replaceToTouchEventUrl = UrlUtil.replaceToTouchEventUrl(it.next(), str + "", str2 + "", str3 + "", str4 + "", String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()), "", i);
                if (!TextUtils.isEmpty(this.f10211J)) {
                    replaceToTouchEventUrl = replaceToTouchEventUrl.replace("__REQUESTUUID__", this.f10211J);
                }
                new ClickTracker(StringUtil.replaceClick(view, replaceToTouchEventUrl)).execute(new Void[0]);
            }
        }
        this.f10254y = null;
        if (!m49434a(this.f10239j, this.f10238i, context)) {
            Log.d("lance", "Unable to handle click.");
        }
        NativeAdEventListener nativeAdEventListener = this.f10207F;
        if (nativeAdEventListener != null) {
            nativeAdEventListener.onAdWasClicked();
        }
    }

    /* renamed from: a */
    public void m49438a(ServerResponse.AdLogoInfo adLogoInfo) {
        this.f10255z = adLogoInfo;
    }

    /* renamed from: a */
    public void m49437a(String str) {
        this.f10211J = str;
    }

    /* renamed from: a */
    public static BeiZiNativeAdResponse m49433a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        ArrayList<String> stringArrayList = JsonUtil.getStringArrayList(JsonUtil.getJSONArray(jSONObject, "ImpressionTrackers"));
        BeiZiNativeAdResponse beiZiNativeAdResponse = new BeiZiNativeAdResponse();
        if (stringArrayList != null) {
            beiZiNativeAdResponse.f10253x = stringArrayList;
        }
        beiZiNativeAdResponse.f10231b = JsonUtil.getJSONString(jSONObject, "Headline");
        beiZiNativeAdResponse.f10232c = JsonUtil.getJSONString(jSONObject, "Body");
        beiZiNativeAdResponse.f10233d = JsonUtil.getJSONString(jSONObject, "Image");
        JSONArray jSONArray = JsonUtil.getJSONArray(jSONObject, "Images");
        JSONArray jSONArray2 = JsonUtil.getJSONArray(jSONObject, "Videos");
        JSONArray jSONArray3 = JsonUtil.getJSONArray(jSONObject, "Texts");
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                beiZiNativeAdResponse.f10250u.add((String) jSONArray.get(i));
            }
        }
        if (jSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                beiZiNativeAdResponse.f10251v.add((String) jSONArray2.get(i2));
            }
        }
        if (jSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                beiZiNativeAdResponse.f10252w.add((String) jSONArray3.get(i3));
            }
        }
        if (jSONObject.has("AppIcon")) {
            beiZiNativeAdResponse.f10228a = NativeAdResponse.EnumC2749b.APP_INSTALL;
            beiZiNativeAdResponse.f10235f = JsonUtil.getJSONString(jSONObject, "AppIcon");
            beiZiNativeAdResponse.f10241l = JsonUtil.getJSONString(jSONObject, "Action");
            beiZiNativeAdResponse.f10242m = JsonUtil.getJSONDouble(jSONObject, "Star");
            beiZiNativeAdResponse.f10243n = JsonUtil.getJSONString(jSONObject, "Store");
            beiZiNativeAdResponse.f10244o = JsonUtil.getJSONString(jSONObject, "Price");
        } else {
            beiZiNativeAdResponse.f10228a = NativeAdResponse.EnumC2749b.CONTENT;
            beiZiNativeAdResponse.f10235f = JsonUtil.getJSONString(jSONObject, "Logo");
            beiZiNativeAdResponse.f10241l = JsonUtil.getJSONString(jSONObject, "Action");
            beiZiNativeAdResponse.f10245p = JsonUtil.getJSONString(jSONObject, "Advertiser");
        }
        ArrayList<String> stringArrayList2 = JsonUtil.getStringArrayList(JsonUtil.getJSONArray(jSONObject, "ClickTrackers"));
        if (stringArrayList2 != null) {
            beiZiNativeAdResponse.f10254y = stringArrayList2;
        }
        beiZiNativeAdResponse.f10246q = JsonUtil.getStringObjectHashMap(JsonUtil.getJSONObject(jSONObject, "Custom"));
        new Handler(Looper.getMainLooper()).postDelayed(beiZiNativeAdResponse.f10204C, C7193bi.f24584s);
        return beiZiNativeAdResponse;
    }

    /* renamed from: b */
    private boolean m49425b(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.opening_url_failed, str));
            return false;
        }
    }

    /* renamed from: a */
    public String m49435a(String str, View view) {
        if (view != null) {
            if (!TextUtils.isEmpty(this.f10211J)) {
                str = str.replace("__REQUESTUUID__", this.f10211J);
            }
            return StringUtil.replaceView(0, view, str);
        }
        return UrlUtil.replaceToTouchEventUrl(str, "", "", "", "", "", "", "");
    }

    /* renamed from: a */
    public void m49449a(AdResponseOuterClass.C2793b c2793b) {
        this.f10240k = c2793b;
        this.f10225X = c2793b.m50017j();
        this.f10213L = c2793b.m50031c();
        this.f10214M = c2793b.m50029d();
        this.f10215N = c2793b.m50027e();
        this.f10216O = c2793b.m50025f();
        this.f10217P = c2793b.m50023g();
        if (TextUtils.isEmpty(this.f10215N)) {
            this.f10215N = "lance";
        }
        if (TextUtils.isEmpty(this.f10214M)) {
            this.f10214M = "BeiZi";
        }
        if (TextUtils.isEmpty(this.f10216O)) {
            this.f10216O = "Ad Download";
        }
        this.f10218Q = c2793b.m50011m();
        this.f10219R = c2793b.m50009n();
        this.f10220S = c2793b.m50007o();
        this.f10221T = c2793b.m50006p();
        this.f10222U = c2793b.m50005q();
        this.f10223V = c2793b.m50004r();
        this.f10224W = c2793b.m50003s();
        AdResponseOuterClass.C2793b.C2794a m50002t = c2793b.m50002t();
        this.f10226Y = m50002t;
        if (m50002t == null || m50002t.m50001a() != 1) {
            return;
        }
        this.f10227Z = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49432a(boolean z) {
        this.f10229aa = z;
    }

    /* renamed from: a */
    private void m49453a() {
        this.f10208G = new View.OnClickListener() { // from class: com.beizi.ad.internal.nativead.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (BeiZiNativeAdResponse.this.f10254y != null) {
                        Iterator it = BeiZiNativeAdResponse.this.f10254y.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            LogUtil.m49046a("lance", "setClickListener:" + str);
                            new ClickTracker(str).execute(new Void[0]);
                        }
                    }
                    Context context = view.getContext();
                    View rootView = view.getRootView();
                    if (rootView != null) {
                        context = rootView.getContext();
                    }
                    BeiZiNativeAdResponse beiZiNativeAdResponse = BeiZiNativeAdResponse.this;
                    if (!beiZiNativeAdResponse.m49434a(beiZiNativeAdResponse.f10239j, BeiZiNativeAdResponse.this.f10238i, context)) {
                        HaoboLog.m49292d(HaoboLog.nativeLogTag, "Unable to handle click.");
                    }
                    if (BeiZiNativeAdResponse.this.f10207F != null) {
                        BeiZiNativeAdResponse.this.f10207F.onAdWasClicked();
                    }
                    BeiZiNativeAdResponse.this.f10254y = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m49434a(String str, String str2, Context context) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (!JumpTool.m49050a(context, str) && !FileUtil.m49059a(context, this.f10215N)) {
                    AdResponseOuterClass.C2793b.C2795b c2795b = this.f10225X;
                    if (c2795b != null) {
                        ReportEventUtil.report(c2795b.m49981j());
                    }
                    m49450a(context, str2);
                    return true;
                }
                AdResponseOuterClass.C2793b.C2795b c2795b2 = this.f10225X;
                if (c2795b2 != null) {
                    ReportEventUtil.report(c2795b2.m49983i());
                }
                m49452a(context);
                AdResponseOuterClass.C2793b.C2795b c2795b3 = this.f10225X;
                if (c2795b3 != null) {
                    ReportEventUtil.report(c2795b3.m49989f());
                }
                return true;
            } catch (Exception unused) {
                AdResponseOuterClass.C2793b.C2795b c2795b4 = this.f10225X;
                if (c2795b4 != null) {
                    ReportEventUtil.report(c2795b4.m49985h());
                }
                m49450a(context, str2);
                return true;
            }
        }
        m49450a(context, str2);
        return true;
    }

    /* renamed from: a */
    private void m49450a(Context context, String str) {
        try {
            if (!m49431b()) {
                m49436a(str, context);
                return;
            }
            int i = this.f10213L;
            if (i == 2) {
                if (FileUtil.m49059a(context, this.f10215N)) {
                    FileUtil.m49056b(context, this.f10215N);
                    AdResponseOuterClass.C2793b.C2795b c2795b = this.f10225X;
                    if (c2795b != null) {
                        ReportEventUtil.report(c2795b.m49999a());
                        return;
                    }
                    return;
                }
                m49451a(context, 1);
            } else if (i == 5) {
                if (!JumpTool.m49050a(context, this.f10217P) && !this.f10217P.contains("market://")) {
                    m49436a(str, context);
                    return;
                }
                if (this.f10230ab) {
                    m49425b(this.f10217P, context);
                    AdResponseOuterClass.C2793b.C2795b c2795b2 = this.f10225X;
                    if (c2795b2 != null) {
                        ReportEventUtil.report(c2795b2.m49999a());
                        return;
                    }
                    return;
                }
                m49451a(context, 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m49451a(Context context, int i) {
        try {
            File m49060a = FileUtil.m49060a(context);
            String absolutePath = m49060a != null ? m49060a.getAbsolutePath() : "";
            ApkBean apkBean = new ApkBean(this.f10217P, this.f10215N + ".apk", this.f10215N, absolutePath, this.f10214M, this.f10216O, context.getPackageName() + ".fileprovider", this.f10225X, this.f10218Q, this.f10219R, this.f10220S, this.f10221T, this.f10222U, this.f10223V, this.f10224W);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i);
            bundle.putBoolean("isCanJump", this.f10227Z);
            if (i == 2) {
                AdResponseOuterClass.C2793b.C2795b c2795b = this.f10225X;
                if (c2795b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c2795b.m49999a());
                }
                bundle.putString("landingPageUrl", this.f10238i);
            }
            Intent intent = new Intent(context, BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m49452a(Context context) {
        BeiZiImpl.m49492a().m49488a(new AdClickReportListener() { // from class: com.beizi.ad.internal.nativead.a.9
            @Override // com.beizi.p051ad.internal.AdClickReportListener
            public void onReport() {
                try {
                    if (BeiZiNativeAdResponse.this.f10225X != null) {
                        ReportEventUtil.report(BeiZiNativeAdResponse.this.f10225X.m49987g());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Uri parse = Uri.parse(this.f10239j);
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
            if (context != null) {
                context.startActivity(intent);
                return;
            }
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", parse);
        intent2.setFlags(805339136);
        if (context != null) {
            context.startActivity(intent2);
        }
    }

    /* renamed from: a */
    private boolean m49436a(String str, Context context) {
        if (str != null && !str.isEmpty()) {
            if (!this.f10229aa) {
                if (m49425b(str, context)) {
                    NativeAdEventListener nativeAdEventListener = this.f10207F;
                    if (nativeAdEventListener != null) {
                        nativeAdEventListener.onAdWillLeaveApplication();
                    }
                    return true;
                }
                return false;
            }
            Class m50215a = AdActivity.m50215a();
            try {
                WebView webView = new WebView(new MutableContextWrapper(context));
                WebviewUtil.setWebViewSettings(webView);
                webView.loadUrl(str, HeaderUtil.m49052a());
                BrowserAdActivity.f9980a.add(webView);
                Intent intent = new Intent(context, m50215a);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                intent.putExtra("ACTIVITY_CAN_JUMP", this.f10227Z);
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.adactivity_missing, m50215a.getName()));
                BrowserAdActivity.f9980a.remove();
            } catch (Exception e) {
                String str2 = HaoboLog.baseLogTag;
                HaoboLog.m49290e(str2, "Exception initializing the redirect webview: " + e.getMessage());
                return false;
            }
        }
        return false;
    }
}
