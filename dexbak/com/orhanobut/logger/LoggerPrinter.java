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

/* renamed from: com.orhanobut.logger.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class LoggerPrinter implements Printer {

    /* renamed from: c */
    private static final int f32693c = 2;

    /* renamed from: a */
    private final ThreadLocal<String> f32694a = new ThreadLocal<>();

    /* renamed from: b */
    private final List<LogAdapter> f32695b = new ArrayList();

    @NonNull
    /* renamed from: n */
    private String m20457n(@NonNull String str, @Nullable Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    @Nullable
    /* renamed from: o */
    private String m20456o() {
        String str = this.f32694a.get();
        if (str != null) {
            this.f32694a.remove();
            return str;
        }
        return null;
    }

    /* renamed from: p */
    private synchronized void m20455p(int i, @Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        C11795n.m20423a(str);
        mo20435c(i, m20456o(), m20457n(str, objArr), th);
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: a */
    public void mo20437a(@NonNull String str, @Nullable Object... objArr) {
        m20455p(7, null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: b */
    public void mo20436b(@Nullable String str) {
        if (C11795n.m20420d(str)) {
            mo20433d("Empty/Null json content");
            return;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith("{")) {
                mo20433d(new JSONObject(trim).toString(2));
            } else if (trim.startsWith("[")) {
                mo20433d(new JSONArray(trim).toString(2));
            } else {
                mo20428i("Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            mo20428i("Invalid Json", new Object[0]);
        }
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: c */
    public synchronized void mo20435c(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        if (th != null && str2 != null) {
            str2 = str2 + " : " + C11795n.m20421c(th);
        }
        if (th != null && str2 == null) {
            str2 = C11795n.m20421c(th);
        }
        if (C11795n.m20420d(str2)) {
            str2 = "Empty/NULL log message";
        }
        for (LogAdapter logAdapter : this.f32695b) {
            if (logAdapter.mo20474b(i, str)) {
                logAdapter.mo20475a(i, str, str2);
            }
        }
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: d */
    public void mo20433d(@Nullable Object obj) {
        m20455p(3, null, C11795n.m20418f(obj), new Object[0]);
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: e */
    public void mo20432e(@NonNull String str, @Nullable Object... objArr) {
        m20455p(4, null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: f */
    public void mo20431f(@NonNull String str, @Nullable Object... objArr) {
        m20455p(3, null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: g */
    public Printer mo20430g(String str) {
        if (str != null) {
            this.f32694a.set(str);
        }
        return this;
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: h */
    public void mo20429h(@NonNull String str, @Nullable Object... objArr) {
        m20455p(2, null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: i */
    public void mo20428i(@NonNull String str, @Nullable Object... objArr) {
        mo20424m(null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: j */
    public void mo20427j(@Nullable String str) {
        if (C11795n.m20420d(str)) {
            mo20433d("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            mo20433d(streamResult.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (TransformerException unused) {
            mo20428i("Invalid xml", new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.orhanobut.logger.Printer
    /* renamed from: k */
    public void mo20426k(@NonNull LogAdapter logAdapter) {
        this.f32695b.add(C11795n.m20423a(logAdapter));
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: l */
    public void mo20425l(@NonNull String str, @Nullable Object... objArr) {
        m20455p(5, null, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: m */
    public void mo20424m(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        m20455p(6, th, str, objArr);
    }

    @Override // com.orhanobut.logger.Printer
    /* renamed from: d */
    public void mo20434d() {
        this.f32695b.clear();
    }
}
