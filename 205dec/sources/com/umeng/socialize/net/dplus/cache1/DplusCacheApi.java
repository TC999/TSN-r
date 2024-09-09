package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.umeng.socialize.c.b.a;
import com.umeng.socialize.net.dplus.db.DBManager;
import com.umeng.socialize.utils.ContextUtil;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DplusCacheApi {

    /* renamed from: a  reason: collision with root package name */
    private static final String f54126a = "DplusCacheApi";

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f54127b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f54128c;

    /* renamed from: d  reason: collision with root package name */
    private final int f54129d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Integer> f54130e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Integer> f54131f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Integer> f54132g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Integer> f54133h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Integer> f54134i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class SingletonHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DplusCacheApi f54151a = new DplusCacheApi();

        private SingletonHolder() {
        }
    }

    public static double checkFile() {
        File dataFile = ContextUtil.getDataFile("share.db");
        if (dataFile == null || !dataFile.exists()) {
            return 0.0d;
        }
        return dataFile.length();
    }

    public static final DplusCacheApi getInstance() {
        return SingletonHolder.f54151a;
    }

    public void cleanCache(final Context context) {
        this.f54128c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.2
            @Override // java.lang.Runnable
            public void run() {
                a.a(context);
            }
        });
    }

    public void closeDBConnection(final Context context) {
        this.f54128c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.1
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(context).closeDatabase();
            }
        });
    }

    public void deleteAll(Context context) {
        this.f54128c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.6
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
        this.f54128c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.5
            @Override // java.lang.Runnable
            public void run() {
                if (DplusCacheApi.this.f54130e.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f54130e, "s_e");
                    DplusCacheApi.this.f54130e.clear();
                }
                if (DplusCacheApi.this.f54131f.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f54131f, "auth");
                    DplusCacheApi.this.f54131f.clear();
                }
                if (DplusCacheApi.this.f54133h.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f54133h, "dau");
                    DplusCacheApi.this.f54133h.clear();
                }
                if (DplusCacheApi.this.f54132g.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f54132g, "userinfo");
                    DplusCacheApi.this.f54132g.clear();
                }
                if (DplusCacheApi.this.f54134i.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f54134i, "stats");
                    DplusCacheApi.this.f54134i.clear();
                }
            }
        });
    }

    public void deleteFileAsnc(Context context) {
        if (this.f54130e.size() > 0) {
            DBManager.get(context).delete(this.f54130e, "s_e");
            this.f54130e.clear();
        }
        if (this.f54131f.size() > 0) {
            DBManager.get(context).delete(this.f54131f, "auth");
            this.f54131f.clear();
        }
        if (this.f54133h.size() > 0) {
            DBManager.get(context).delete(this.f54133h, "dau");
            this.f54133h.clear();
        }
        if (this.f54132g.size() > 0) {
            DBManager.get(context).delete(this.f54132g, "userinfo");
            this.f54132g.clear();
        }
        if (this.f54134i.size() > 0) {
            DBManager.get(context).delete(this.f54134i, "stats");
            this.f54134i.clear();
        }
    }

    public void readFile(final Context context, final int i4, final DplusCacheListener dplusCacheListener) {
        this.f54128c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.4
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
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.AnonymousClass4.run():void");
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

    public void saveFile(final Context context, final JSONObject jSONObject, final int i4, final DplusCacheListener dplusCacheListener) {
        this.f54128c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.3
            @Override // java.lang.Runnable
            public void run() {
                switch (i4) {
                    case 24577:
                        DBManager.get(context).insertDau(jSONObject);
                        break;
                    case 24578:
                        DBManager.get(context).insertS_E(jSONObject);
                        break;
                    case 24579:
                        DBManager.get(context).insertAuth(jSONObject);
                        break;
                    case 24580:
                        DBManager.get(context).insertUserInfo(jSONObject);
                        break;
                    case 24581:
                    case 24583:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                    case 24582:
                    default:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                }
                dplusCacheListener.onResult(null);
            }
        });
    }

    private DplusCacheApi() {
        this.f54129d = 1048576;
        this.f54130e = new ArrayList<>();
        this.f54131f = new ArrayList<>();
        this.f54132g = new ArrayList<>();
        this.f54133h = new ArrayList<>();
        this.f54134i = new ArrayList<>();
        HandlerThread handlerThread = new HandlerThread("DplusCacheApi", 10);
        this.f54127b = handlerThread;
        handlerThread.start();
        this.f54128c = new Handler(this.f54127b.getLooper());
    }

    private static JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("s_sdk_v", "7.3.2");
        jSONObject.put("s_pcv", "3.0");
        return jSONObject;
    }
}
