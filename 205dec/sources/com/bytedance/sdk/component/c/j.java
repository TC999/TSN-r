package com.bytedance.sdk.component.c;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j {

    /* renamed from: c  reason: collision with root package name */
    private final Collection<String> f29674c;
    private final Set<c> sr;

    /* renamed from: w  reason: collision with root package name */
    private final Map<String, q> f29675w;
    private final k xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q c(String str) {
        if (!this.f29674c.contains(str) && !TextUtils.equals(str, "host")) {
            throw new IllegalArgumentException("Namespace: " + str + " not registered.");
        }
        return c(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(c cVar) {
        this.sr.remove(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(c cVar) {
        this.sr.add(cVar);
    }

    private q c(String str, JSONObject jSONObject) {
        q qVar = this.f29675w.get(str);
        if (qVar == null) {
            q qVar2 = new q(str, this.xv.xv(), this.xv.c(), this.xv.w(), jSONObject);
            this.f29675w.put(str, qVar2);
            return qVar2;
        } else if (jSONObject != null) {
            qVar.update(jSONObject);
            return qVar;
        } else {
            return qVar;
        }
    }
}
