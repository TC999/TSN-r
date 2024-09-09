package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: LoggerPrinter.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class k implements m {

    /* renamed from: c  reason: collision with root package name */
    private static final int f41380c = 2;

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<String> f41381a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<g> f41382b = new ArrayList();

    @NonNull
    private String n(@NonNull String str, @Nullable Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    @Nullable
    private String o() {
        String str = this.f41381a.get();
        if (str != null) {
            this.f41381a.remove();
            return str;
        }
        return null;
    }

    private synchronized void p(int i4, @Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        n.a(str);
        c(i4, o(), n(str, objArr), th);
    }

    @Override // com.orhanobut.logger.m
    public void a(@NonNull String str, @Nullable Object... objArr) {
        p(7, null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public void b(@Nullable String str) {
        if (n.d(str)) {
            d("Empty/Null json content");
            return;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith("{")) {
                d(new JSONObject(trim).toString(2));
            } else if (trim.startsWith("[")) {
                d(new JSONArray(trim).toString(2));
            } else {
                i("Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            i("Invalid Json", new Object[0]);
        }
    }

    @Override // com.orhanobut.logger.m
    public synchronized void c(int i4, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        if (th != null && str2 != null) {
            str2 = str2 + " : " + n.c(th);
        }
        if (th != null && str2 == null) {
            str2 = n.c(th);
        }
        if (n.d(str2)) {
            str2 = "Empty/NULL log message";
        }
        for (g gVar : this.f41382b) {
            if (gVar.b(i4, str)) {
                gVar.a(i4, str, str2);
            }
        }
    }

    @Override // com.orhanobut.logger.m
    public void d(@Nullable Object obj) {
        p(3, null, n.f(obj), new Object[0]);
    }

    @Override // com.orhanobut.logger.m
    public void e(@NonNull String str, @Nullable Object... objArr) {
        p(4, null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public void f(@NonNull String str, @Nullable Object... objArr) {
        p(3, null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public m g(String str) {
        if (str != null) {
            this.f41381a.set(str);
        }
        return this;
    }

    @Override // com.orhanobut.logger.m
    public void h(@NonNull String str, @Nullable Object... objArr) {
        p(2, null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public void i(@NonNull String str, @Nullable Object... objArr) {
        m(null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public void j(@Nullable String str) {
        if (n.d(str)) {
            d("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            d(streamResult.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (TransformerException unused) {
            i("Invalid xml", new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.orhanobut.logger.m
    public void k(@NonNull g gVar) {
        this.f41382b.add(n.a(gVar));
    }

    @Override // com.orhanobut.logger.m
    public void l(@NonNull String str, @Nullable Object... objArr) {
        p(5, null, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public void m(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        p(6, th, str, objArr);
    }

    @Override // com.orhanobut.logger.m
    public void d() {
        this.f41382b.clear();
    }
}
