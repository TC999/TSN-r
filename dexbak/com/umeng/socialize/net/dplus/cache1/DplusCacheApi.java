package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.p574db.DBConfig;
import com.umeng.socialize.net.dplus.p574db.DBManager;
import com.umeng.socialize.p571c.p573b.CacheUtil;
import com.umeng.socialize.utils.ContextUtil;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DplusCacheApi {

    /* renamed from: a */
    private static final String f39551a = "DplusCacheApi";

    /* renamed from: b */
    private HandlerThread f39552b;

    /* renamed from: c */
    private Handler f39553c;

    /* renamed from: d */
    private final int f39554d;

    /* renamed from: e */
    private ArrayList<Integer> f39555e;

    /* renamed from: f */
    private ArrayList<Integer> f39556f;

    /* renamed from: g */
    private ArrayList<Integer> f39557g;

    /* renamed from: h */
    private ArrayList<Integer> f39558h;

    /* renamed from: i */
    private ArrayList<Integer> f39559i;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class SingletonHolder {

        /* renamed from: a */
        private static final DplusCacheApi f39576a = new DplusCacheApi();

        private SingletonHolder() {
        }
    }

    public static double checkFile() {
        File dataFile = ContextUtil.getDataFile(DBConfig.DB_NAME);
        return (dataFile == null || !dataFile.exists()) ? Utils.DOUBLE_EPSILON : dataFile.length();
    }

    public static final DplusCacheApi getInstance() {
        return SingletonHolder.f39576a;
    }

    public void cleanCache(final Context context) {
        this.f39553c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.2
            @Override // java.lang.Runnable
            public void run() {
                CacheUtil.m13298a(context);
            }
        });
    }

    public void closeDBConnection(final Context context) {
        this.f39553c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.1
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(context).closeDatabase();
            }
        });
    }

    public void deleteAll(Context context) {
        this.f39553c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.6
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(ContextUtil.getContext()).deleteTable("stats");
            }
        });
    }

    public void deleteAllAsnc(Context context) {
        DBManager.get(ContextUtil.getContext()).deleteTable("stats");
    }

    public void deleteFile(final Context context) {
        this.f39553c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.5
            @Override // java.lang.Runnable
            public void run() {
                if (DplusCacheApi.this.f39555e.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f39555e, "s_e");
                    DplusCacheApi.this.f39555e.clear();
                }
                if (DplusCacheApi.this.f39556f.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f39556f, "auth");
                    DplusCacheApi.this.f39556f.clear();
                }
                if (DplusCacheApi.this.f39558h.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f39558h, "dau");
                    DplusCacheApi.this.f39558h.clear();
                }
                if (DplusCacheApi.this.f39557g.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f39557g, "userinfo");
                    DplusCacheApi.this.f39557g.clear();
                }
                if (DplusCacheApi.this.f39559i.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f39559i, "stats");
                    DplusCacheApi.this.f39559i.clear();
                }
            }
        });
    }

    public void deleteFileAsnc(Context context) {
        if (this.f39555e.size() > 0) {
            DBManager.get(context).delete(this.f39555e, "s_e");
            this.f39555e.clear();
        }
        if (this.f39556f.size() > 0) {
            DBManager.get(context).delete(this.f39556f, "auth");
            this.f39556f.clear();
        }
        if (this.f39558h.size() > 0) {
            DBManager.get(context).delete(this.f39558h, "dau");
            this.f39558h.clear();
        }
        if (this.f39557g.size() > 0) {
            DBManager.get(context).delete(this.f39557g, "userinfo");
            this.f39557g.clear();
        }
        if (this.f39559i.size() > 0) {
            DBManager.get(context).delete(this.f39559i, "stats");
            this.f39559i.clear();
        }
    }

    public void readFile(final Context context, final int i, final DplusCacheListener dplusCacheListener) {
        this.f39553c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.4
            /* JADX WARN: Removed duplicated region for block: B:53:0x016a  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 398
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.RunnableC134304.run():void");
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readFileAsnc(android.content.Context r21, int r22) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.readFileAsnc(android.content.Context, int):org.json.JSONObject");
    }

    public void saveFile(final Context context, final JSONObject jSONObject, final int i, final DplusCacheListener dplusCacheListener) {
        this.f39553c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.3
            @Override // java.lang.Runnable
            public void run() {
                switch (i) {
                    case SocializeConstants.DAU_EVENT /* 24577 */:
                        DBManager.get(context).insertDau(jSONObject);
                        break;
                    case SocializeConstants.SHARE_EVENT /* 24578 */:
                        DBManager.get(context).insertS_E(jSONObject);
                        break;
                    case SocializeConstants.AUTH_EVENT /* 24579 */:
                        DBManager.get(context).insertAuth(jSONObject);
                        break;
                    case SocializeConstants.GET_EVENT /* 24580 */:
                        DBManager.get(context).insertUserInfo(jSONObject);
                        break;
                    case SocializeConstants.SAVE_STATS_EVENT /* 24581 */:
                    case SocializeConstants.SEND_DAU_STATS_EVENT /* 24583 */:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                    case SocializeConstants.CHECK_STATS_EVENT /* 24582 */:
                    default:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                }
                dplusCacheListener.onResult(null);
            }
        });
    }

    private DplusCacheApi() {
        this.f39554d = 1048576;
        this.f39555e = new ArrayList<>();
        this.f39556f = new ArrayList<>();
        this.f39557g = new ArrayList<>();
        this.f39558h = new ArrayList<>();
        this.f39559i = new ArrayList<>();
        HandlerThread handlerThread = new HandlerThread(f39551a, 10);
        this.f39552b = handlerThread;
        handlerThread.start();
        this.f39553c = new Handler(this.f39552b.getLooper());
    }

    /* renamed from: a */
    private static JSONObject m13240a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("s_sdk_v", "7.3.2");
        jSONObject.put(CommonNetImpl.PCV, SocializeConstants.PROTOCOL_VERSON);
        return jSONObject;
    }
}
