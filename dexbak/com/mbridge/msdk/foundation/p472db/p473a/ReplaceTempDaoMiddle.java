package com.mbridge.msdk.foundation.p472db.p473a;

import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.ReplaceTempDao;
import com.mbridge.msdk.foundation.same.p474a.LruReplaceTempCache;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.db.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ReplaceTempDaoMiddle {

    /* renamed from: a */
    private ReplaceTempDao f30318a;

    /* renamed from: b */
    private LruReplaceTempCache f30319b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReplaceTempDaoMiddle.java */
    /* renamed from: com.mbridge.msdk.foundation.db.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11274a {

        /* renamed from: a */
        private static ReplaceTempDaoMiddle f30323a = new ReplaceTempDaoMiddle();
    }

    private ReplaceTempDaoMiddle() {
        this.f30319b = new LruReplaceTempCache(1000);
        try {
            ReplaceTempDao m22692a = ReplaceTempDao.m22692a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
            this.f30318a = m22692a;
            m22811a(m22692a.m22693a(), false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static ReplaceTempDaoMiddle m22814a() {
        return C11274a.f30323a;
    }

    /* renamed from: b */
    public final JSONArray m22810b() {
        return new JSONArray((Collection) this.f30319b.mo22381a());
    }

    /* renamed from: a */
    public final JSONObject m22812a(String str) {
        ReplaceTempDao replaceTempDao;
        JSONObject mo22377b = this.f30319b.mo22377b(str);
        if (mo22377b == null && (replaceTempDao = this.f30318a) != null) {
            JSONObject m22691a = replaceTempDao.m22691a(str);
            if (m22691a != null) {
                this.f30319b.mo22379a(str, m22691a);
            }
            return m22691a;
        }
        return mo22377b;
    }

    /* renamed from: a */
    public final void m22811a(JSONObject jSONObject, final boolean z) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            final LruReplaceTempCache lruReplaceTempCache = new LruReplaceTempCache(100);
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                this.f30319b.mo22379a(next, optJSONObject);
                lruReplaceTempCache.mo22379a(next, optJSONObject);
            }
            ThreadPoolUtils.m22309a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.db.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (!z || ReplaceTempDaoMiddle.this.f30318a == null) {
                        return;
                    }
                    for (String str : lruReplaceTempCache.mo22381a()) {
                        ReplaceTempDaoMiddle.this.f30318a.m22690a(str, ReplaceTempDaoMiddle.this.f30319b.mo22377b(str));
                    }
                }
            });
        }
    }
}
