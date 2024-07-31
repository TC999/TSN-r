package com.kwad.sdk.core.response.p408a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p389b.p390a.C10070ft;
import com.kwad.sdk.core.p397e.C10331c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.response.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10482a implements InterfaceC9914b {
    private static final List<String> WHITE_LIST;
    private List<InterfaceC10273d<C10482a>> mHolders;

    static {
        ArrayList arrayList = new ArrayList();
        WHITE_LIST = arrayList;
        arrayList.add("com.kwad.sdk.core.report.BaseReportAction");
    }

    private InterfaceC10273d<C10482a> getHolder(Class<? extends C10482a> cls) {
        if (C10482a.class.equals(cls) || WHITE_LIST.contains(cls.getName())) {
            return null;
        }
        return C10070ft.getHolder(cls);
    }

    private synchronized List<InterfaceC10273d<C10482a>> getHolders() {
        if (this.mHolders == null) {
            this.mHolders = new ArrayList();
            for (Class<?> cls = getClass(); cls != null && C10482a.class.isAssignableFrom(cls); cls = cls.getSuperclass()) {
                InterfaceC10273d<C10482a> holder = getHolder(cls);
                if (holder != null) {
                    this.mHolders.add(0, holder);
                }
            }
        }
        List<InterfaceC10273d<C10482a>> list = this.mHolders;
        if (list == null || list.isEmpty()) {
            C10331c.printStackTrace(new IllegalStateException("no holders for class: " + getClass()));
        }
        return this.mHolders;
    }

    public void afterParseJson(@Nullable JSONObject jSONObject) {
    }

    public void afterToJson(JSONObject jSONObject) {
    }

    public void beforeToJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        List<InterfaceC10273d<C10482a>> holders = getHolders();
        for (int size = holders.size() - 1; size >= 0; size--) {
            holders.get(size).mo26477a(this, jSONObject);
        }
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        List<InterfaceC10273d<C10482a>> holders = getHolders();
        JSONObject jSONObject = new JSONObject();
        beforeToJson(jSONObject);
        if (holders == null) {
            return jSONObject;
        }
        for (int size = holders.size() - 1; size >= 0; size--) {
            InterfaceC10273d<C10482a> interfaceC10273d = holders.get(size);
            if (interfaceC10273d != null) {
                interfaceC10273d.mo26476b(this, jSONObject);
            }
        }
        afterToJson(jSONObject);
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }
}
