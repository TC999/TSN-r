package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwai.adclient.kscommerciallogger.C11155a;
import com.kwai.adclient.kscommerciallogger.C11159b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwai.adclient.kscommerciallogger.model.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11162c {
    private final C11164d aof;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11163a {
        private final String aUh;
        private BusinessType aUi;
        private SubBusinessType aUj;
        private C11164d aUk;
        private JSONObject aUl;
        private String aUm;
        private String mTag;
        private JSONObject msg;

        private C11163a(@NonNull String str) {
            this.aUh = str;
        }

        /* renamed from: On */
        public static C11163a m23508On() {
            return new C11163a(ILoggerReporter.Category.ERROR_LOG);
        }

        /* renamed from: Oo */
        public static C11163a m23507Oo() {
            return new C11163a(ILoggerReporter.Category.APM_LOG);
        }

        /* renamed from: A */
        public final C11163a m23509A(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        /* renamed from: Op */
        public final C11162c m23506Op() {
            if (C11155a.m23525Oe().isDebug()) {
                if (!TextUtils.isEmpty(this.aUh) && !TextUtils.isEmpty(this.mTag) && !TextUtils.isEmpty(this.aUm)) {
                    if (C11155a.m23525Oe().m23523Og() && !C11159b.m23517hk(this.aUm)) {
                        throw new IllegalArgumentException("event_id format error, please check it");
                    }
                } else {
                    throw new IllegalArgumentException("param is error, please check it");
                }
            } else if (TextUtils.isEmpty(this.aUh) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.aUm)) {
                return null;
            } else {
                if (C11155a.m23525Oe().m23523Og() && !C11159b.m23517hk(this.aUm)) {
                    return null;
                }
            }
            if (C11155a.m23525Oe().m23524Of() != null) {
                this.aUl = C11155a.m23525Oe().m23524Of();
            }
            return new C11162c(this, (byte) 0);
        }

        /* renamed from: hl */
        public final C11163a m23494hl(@NonNull String str) {
            this.mTag = str;
            return this;
        }

        /* renamed from: hm */
        public final C11163a m23493hm(@NonNull String str) {
            this.aUm = str;
            return this;
        }

        /* renamed from: b */
        public final C11163a m23504b(BusinessType businessType) {
            this.aUi = businessType;
            return this;
        }

        /* renamed from: b */
        public final C11163a m23503b(SubBusinessType subBusinessType) {
            this.aUj = subBusinessType;
            return this;
        }

        /* renamed from: b */
        public final C11163a m23501b(C11164d c11164d) {
            this.aUk = c11164d;
            return this;
        }
    }

    /* synthetic */ C11162c(C11163a c11163a, byte b) {
        this(c11163a);
    }

    /* renamed from: Oh */
    public final String m23515Oh() {
        return this.category;
    }

    /* renamed from: Oi */
    public final SubBusinessType m23514Oi() {
        return this.subBiz;
    }

    /* renamed from: Oj */
    public final C11164d m23513Oj() {
        return this.aof;
    }

    /* renamed from: Ok */
    public final JSONObject m23512Ok() {
        return this.msg;
    }

    /* renamed from: Ol */
    public final JSONObject m23511Ol() {
        return this.extraParam;
    }

    /* renamed from: Om */
    public final String m23510Om() {
        return this.eventId;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            BusinessType businessType = this.biz;
            if (businessType != null) {
                jSONObject.put("biz", businessType.value);
            }
            SubBusinessType subBusinessType = this.subBiz;
            if (subBusinessType != null) {
                jSONObject.put("sub_biz", subBusinessType.value);
            }
            jSONObject.put("tag", this.tag);
            C11164d c11164d = this.aof;
            if (c11164d != null) {
                jSONObject.put("type", c11164d.getValue());
            }
            JSONObject jSONObject2 = this.msg;
            if (jSONObject2 != null) {
                jSONObject.put("msg", jSONObject2);
            }
            JSONObject jSONObject3 = this.extraParam;
            if (jSONObject3 != null) {
                jSONObject.put("extra_param", jSONObject3);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private C11162c(C11163a c11163a) {
        this.category = c11163a.aUh;
        this.biz = c11163a.aUi;
        this.subBiz = c11163a.aUj;
        this.tag = c11163a.mTag;
        this.aof = c11163a.aUk;
        this.extraParam = c11163a.aUl;
        this.eventId = c11163a.aUm;
        this.msg = c11163a.msg == null ? new JSONObject() : c11163a.msg;
    }
}
