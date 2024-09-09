package com.bytedance.sdk.component.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.bytedance.sdk.component.c.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class q {
    private final String sr;

    /* renamed from: w  reason: collision with root package name */
    private final LruCache<String, xv> f29690w;
    private final k.c xv;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<w>> f29689c = new ConcurrentHashMap();
    private volatile boolean ux = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends IllegalStateException {
        c(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class w {

        /* renamed from: c  reason: collision with root package name */
        Pattern f29693c;
        List<String> sr;

        /* renamed from: w  reason: collision with root package name */
        ls f29694w;
        List<String> xv;

        private w() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class xv {

        /* renamed from: c  reason: collision with root package name */
        ls f29695c = ls.PUBLIC;

        /* renamed from: w  reason: collision with root package name */
        Set<String> f29696w = new HashSet();
        Set<String> xv = new HashSet();

        xv() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public q(String str, int i4, k.c cVar, final Executor executor, JSONObject jSONObject) {
        this.sr = str;
        if (i4 <= 0) {
            this.f29690w = new LruCache<>(16);
        } else {
            this.f29690w = new LruCache<>(i4);
        }
        this.xv = cVar;
        if (jSONObject == null) {
            cVar.c(sr(str), new k.c.InterfaceC0444c() { // from class: com.bytedance.sdk.component.c.q.1
            });
        } else {
            update(jSONObject);
        }
    }

    private static String sr(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig." + str;
    }

    private static String w(String str) {
        String[] split;
        int length;
        if (str != null && (length = (split = str.split("[.]")).length) >= 2) {
            if (length == 2) {
                return str;
            }
            return split[length - 2] + "." + split[length - 1];
        }
        return null;
    }

    private List<w> xv(String str) throws c {
        if (this.ux) {
            return this.f29689c.get(str);
        }
        throw new c("Permission config is outdated!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xv c(String str, Set<String> set) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String builder = new Uri.Builder().scheme(scheme).authority(authority).path(parse.getPath()).toString();
        xv xvVar = new xv();
        if (authority != null && !authority.isEmpty()) {
            for (String str2 : set) {
                if (!authority.equals(str2)) {
                    if (authority.endsWith("." + str2)) {
                    }
                }
                xvVar.f29695c = ls.PRIVATE;
                return xvVar;
            }
            xv xvVar2 = this.f29690w.get(builder);
            return xvVar2 != null ? xvVar2 : c(builder);
        }
        xvVar.f29695c = ls.PUBLIC;
        return xvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(JSONObject jSONObject) {
        c(jSONObject);
        this.xv.c(sr(this.sr), jSONObject.toString());
    }

    @WorkerThread
    private static w w(JSONObject jSONObject) throws JSONException {
        w wVar = new w();
        wVar.f29693c = Pattern.compile(jSONObject.getString("pattern"));
        wVar.f29694w = ls.c(jSONObject.getString("group"));
        wVar.xv = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("included_methods");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                wVar.xv.add(optJSONArray.getString(i4));
            }
        }
        wVar.sr = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (optJSONArray2 != null) {
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                wVar.sr.add(optJSONArray2.getString(i5));
            }
        }
        return wVar;
    }

    @WorkerThread
    private void c(JSONObject jSONObject) {
        this.f29689c.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.f29689c.put(next, linkedList);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    linkedList.add(w(jSONArray.getJSONObject(i4)));
                }
            }
        } catch (JSONException e4) {
            gd.w("Parse configurations failed, response: " + jSONObject.toString(), e4);
        }
        this.ux = true;
    }

    private xv c(String str) throws c {
        xv xvVar = new xv();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String w3 = w(authority);
        if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority) && w3 != null) {
            List<w> xv2 = xv(w3);
            if (xv2 == null) {
                return xvVar;
            }
            for (w wVar : xv2) {
                if (wVar.f29693c.matcher(str).find()) {
                    if (wVar.f29694w.compareTo(xvVar.f29695c) >= 0) {
                        xvVar.f29695c = wVar.f29694w;
                    }
                    xvVar.f29696w.addAll(wVar.xv);
                    xvVar.xv.addAll(wVar.sr);
                }
            }
            this.f29690w.put(str, xvVar);
            return xvVar;
        }
        xvVar.f29695c = ls.PUBLIC;
        return xvVar;
    }
}
