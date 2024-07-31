package com.iab.omid.library.mmadbridge.walking;

import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.mmadbridge.adsession.C7081h;
import com.iab.omid.library.mmadbridge.p202b.C7085a;
import com.iab.omid.library.mmadbridge.p202b.C7088c;
import com.iab.omid.library.mmadbridge.p204d.C7101b;
import com.iab.omid.library.mmadbridge.p204d.C7106f;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.walking.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7119b {

    /* renamed from: a */
    private final HashMap<View, String> f24296a = new HashMap<>();

    /* renamed from: b */
    private final HashMap<View, C7120a> f24297b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, View> f24298c = new HashMap<>();

    /* renamed from: d */
    private final HashSet<View> f24299d = new HashSet<>();

    /* renamed from: e */
    private final HashSet<String> f24300e = new HashSet<>();

    /* renamed from: f */
    private final HashSet<String> f24301f = new HashSet<>();

    /* renamed from: g */
    private final HashMap<String, String> f24302g = new HashMap<>();

    /* renamed from: h */
    private final Map<View, Boolean> f24303h = new WeakHashMap();

    /* renamed from: i */
    private boolean f24304i;

    /* renamed from: com.iab.omid.library.mmadbridge.walking.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7120a {

        /* renamed from: a */
        private final C7088c f24305a;

        /* renamed from: b */
        private final ArrayList<String> f24306b = new ArrayList<>();

        public C7120a(C7088c c7088c, String str) {
            this.f24305a = c7088c;
            m34583b(str);
        }

        /* renamed from: a */
        public C7088c m34584a() {
            return this.f24305a;
        }

        /* renamed from: b */
        public void m34583b(String str) {
            this.f24306b.add(str);
        }

        /* renamed from: c */
        public ArrayList<String> m34582c() {
            return this.f24306b;
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public abstract class AbstractAsyncTaskC7121b extends AbstractAsyncTaskC7122c {

        /* renamed from: c */
        protected final HashSet<String> f24307c;

        /* renamed from: d */
        protected final JSONObject f24308d;

        /* renamed from: e */
        protected final long f24309e;

        public AbstractAsyncTaskC7121b(AbstractAsyncTaskC7122c.InterfaceC7124b interfaceC7124b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
            super(interfaceC7124b);
            this.f24307c = new HashSet<>(hashSet);
            this.f24308d = jSONObject;
            this.f24309e = j;
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.b$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public abstract class AbstractAsyncTaskC7122c extends AsyncTask<Object, Void, String> {

        /* renamed from: a */
        private InterfaceC7123a f24310a;

        /* renamed from: b */
        protected final InterfaceC7124b f24311b;

        /* renamed from: com.iab.omid.library.mmadbridge.walking.b$c$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public interface InterfaceC7123a {
            /* renamed from: a */
            void mo34579a(AbstractAsyncTaskC7122c abstractAsyncTaskC7122c);
        }

        /* renamed from: com.iab.omid.library.mmadbridge.walking.b$c$b */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public interface InterfaceC7124b {
            /* renamed from: a */
            void mo34569a(JSONObject jSONObject);

            /* renamed from: b */
            JSONObject mo34568b();
        }

        public AbstractAsyncTaskC7122c(InterfaceC7124b interfaceC7124b) {
            this.f24311b = interfaceC7124b;
        }

        /* renamed from: a */
        public void m34581a(InterfaceC7123a interfaceC7123a) {
            this.f24310a = interfaceC7123a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            InterfaceC7123a interfaceC7123a = this.f24310a;
            if (interfaceC7123a != null) {
                interfaceC7123a.mo34579a(this);
            }
        }

        /* renamed from: c */
        public void m34580c(ThreadPoolExecutor threadPoolExecutor) {
            executeOnExecutor(threadPoolExecutor, new Object[0]);
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.b$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C7125d implements AbstractAsyncTaskC7122c.InterfaceC7123a {

        /* renamed from: a */
        private final BlockingQueue<Runnable> f24312a;

        /* renamed from: b */
        private final ThreadPoolExecutor f24313b;

        /* renamed from: c */
        private final ArrayDeque<AbstractAsyncTaskC7122c> f24314c = new ArrayDeque<>();

        /* renamed from: d */
        private AbstractAsyncTaskC7122c f24315d = null;

        public C7125d() {
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            this.f24312a = linkedBlockingQueue;
            this.f24313b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
        }

        /* renamed from: b */
        private void m34578b() {
            AbstractAsyncTaskC7122c poll = this.f24314c.poll();
            this.f24315d = poll;
            if (poll != null) {
                poll.m34580c(this.f24313b);
            }
        }

        @Override // com.iab.omid.library.mmadbridge.walking.C7119b.AbstractAsyncTaskC7122c.InterfaceC7123a
        /* renamed from: a */
        public void mo34579a(AbstractAsyncTaskC7122c abstractAsyncTaskC7122c) {
            this.f24315d = null;
            m34578b();
        }

        /* renamed from: c */
        public void m34577c(AbstractAsyncTaskC7122c abstractAsyncTaskC7122c) {
            abstractAsyncTaskC7122c.m34581a(this);
            this.f24314c.add(abstractAsyncTaskC7122c);
            if (this.f24315d == null) {
                m34578b();
            }
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.b$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class AsyncTaskC7126e extends AbstractAsyncTaskC7122c {
        public AsyncTaskC7126e(AbstractAsyncTaskC7122c.InterfaceC7124b interfaceC7124b) {
            super(interfaceC7124b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public String doInBackground(Object... objArr) {
            this.f24311b.mo34569a(null);
            return null;
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.b$f */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class AsyncTaskC7127f extends AbstractAsyncTaskC7121b {
        public AsyncTaskC7127f(AbstractAsyncTaskC7122c.InterfaceC7124b interfaceC7124b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
            super(interfaceC7124b, hashSet, jSONObject, j);
        }

        /* renamed from: e */
        private void m34574e(String str) {
            C7085a m34757a = C7085a.m34757a();
            if (m34757a != null) {
                for (C7081h c7081h : m34757a.m34755c()) {
                    if (this.f24307c.contains(c7081h.mo34803e())) {
                        c7081h.mo34802f().m34638p(str, this.f24309e);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.iab.omid.library.mmadbridge.walking.C7119b.AbstractAsyncTaskC7122c, android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            m34574e(str);
            super.onPostExecute(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public String doInBackground(Object... objArr) {
            return this.f24308d.toString();
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.b$g */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class AsyncTaskC7128g extends AbstractAsyncTaskC7121b {
        public AsyncTaskC7128g(AbstractAsyncTaskC7122c.InterfaceC7124b interfaceC7124b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
            super(interfaceC7124b, hashSet, jSONObject, j);
        }

        /* renamed from: e */
        private void m34571e(String str) {
            C7085a m34757a = C7085a.m34757a();
            if (m34757a != null) {
                for (C7081h c7081h : m34757a.m34755c()) {
                    if (this.f24307c.contains(c7081h.mo34803e())) {
                        c7081h.mo34802f().m34642k(str, this.f24309e);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.iab.omid.library.mmadbridge.walking.C7119b.AbstractAsyncTaskC7122c, android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            if (!TextUtils.isEmpty(str)) {
                m34571e(str);
            }
            super.onPostExecute(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public String doInBackground(Object... objArr) {
            if (C7101b.m34683m(this.f24308d, this.f24311b.mo34568b())) {
                return null;
            }
            this.f24311b.mo34569a(this.f24308d);
            return this.f24308d.toString();
        }
    }

    /* renamed from: d */
    private void m34596d(C7081h c7081h) {
        for (C7088c c7088c : c7081h.m34795m()) {
            m34595e(c7088c, c7081h);
        }
    }

    /* renamed from: e */
    private void m34595e(C7088c c7088c, C7081h c7081h) {
        View view = c7088c.m34742a().get();
        if (view == null) {
            return;
        }
        C7120a c7120a = this.f24297b.get(view);
        if (c7120a != null) {
            c7120a.m34583b(c7081h.mo34803e());
        } else {
            this.f24297b.put(view, new C7120a(c7088c, c7081h.mo34803e()));
        }
    }

    /* renamed from: m */
    private String m34587m(View view) {
        if (Build.VERSION.SDK_INT < 19 || view.isAttachedToWindow()) {
            if (m34585o(view).booleanValue()) {
                return "noWindowFocus";
            }
            HashSet hashSet = new HashSet();
            while (view != null) {
                String m34657e = C7106f.m34657e(view);
                if (m34657e != null) {
                    return m34657e;
                }
                hashSet.add(view);
                ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            this.f24299d.addAll(hashSet);
            return null;
        }
        return "notAttached";
    }

    /* renamed from: o */
    private Boolean m34585o(View view) {
        if (view.hasWindowFocus()) {
            this.f24303h.remove(view);
            return Boolean.FALSE;
        } else if (this.f24303h.containsKey(view)) {
            return this.f24303h.get(view);
        } else {
            Map<View, Boolean> map = this.f24303h;
            Boolean bool = Boolean.FALSE;
            map.put(view, bool);
            return bool;
        }
    }

    /* renamed from: a */
    public String m34599a(View view) {
        if (this.f24296a.size() == 0) {
            return null;
        }
        String str = this.f24296a.get(view);
        if (str != null) {
            this.f24296a.remove(view);
        }
        return str;
    }

    /* renamed from: b */
    public String m34598b(String str) {
        return this.f24302g.get(str);
    }

    /* renamed from: c */
    public HashSet<String> m34597c() {
        return this.f24300e;
    }

    /* renamed from: f */
    public View m34594f(String str) {
        return this.f24298c.get(str);
    }

    /* renamed from: g */
    public C7120a m34593g(View view) {
        C7120a c7120a = this.f24297b.get(view);
        if (c7120a != null) {
            this.f24297b.remove(view);
        }
        return c7120a;
    }

    /* renamed from: h */
    public HashSet<String> m34592h() {
        return this.f24301f;
    }

    /* renamed from: i */
    public EnumC7129c m34591i(View view) {
        return this.f24299d.contains(view) ? EnumC7129c.PARENT_VIEW : this.f24304i ? EnumC7129c.OBSTRUCTION_VIEW : EnumC7129c.UNDERLYING_VIEW;
    }

    /* renamed from: j */
    public void m34590j() {
        C7085a m34757a = C7085a.m34757a();
        if (m34757a != null) {
            for (C7081h c7081h : m34757a.m34753e()) {
                View m34785w = c7081h.m34785w();
                if (c7081h.m34784x()) {
                    String mo34803e = c7081h.mo34803e();
                    if (m34785w != null) {
                        String m34587m = m34587m(m34785w);
                        if (m34587m == null) {
                            this.f24300e.add(mo34803e);
                            this.f24296a.put(m34785w, mo34803e);
                            m34596d(c7081h);
                        } else if (m34587m != "noWindowFocus") {
                            this.f24301f.add(mo34803e);
                            this.f24298c.put(mo34803e, m34785w);
                            this.f24302g.put(mo34803e, m34587m);
                        }
                    } else {
                        this.f24301f.add(mo34803e);
                        this.f24302g.put(mo34803e, "noAdView");
                    }
                }
            }
        }
    }

    /* renamed from: k */
    public void m34589k() {
        this.f24296a.clear();
        this.f24297b.clear();
        this.f24298c.clear();
        this.f24299d.clear();
        this.f24300e.clear();
        this.f24301f.clear();
        this.f24302g.clear();
        this.f24304i = false;
    }

    /* renamed from: l */
    public boolean m34588l(View view) {
        if (this.f24303h.containsKey(view)) {
            this.f24303h.put(view, Boolean.TRUE);
            return false;
        }
        return true;
    }

    /* renamed from: n */
    public void m34586n() {
        this.f24304i = true;
    }
}
