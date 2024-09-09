package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected String f61369a = "";

    /* renamed from: b  reason: collision with root package name */
    protected String f61370b = "";

    /* renamed from: c  reason: collision with root package name */
    protected String f61371c = "";

    /* renamed from: d  reason: collision with root package name */
    protected String f61372d = "";

    /* renamed from: e  reason: collision with root package name */
    protected String f61373e = "";

    /* renamed from: f  reason: collision with root package name */
    protected String f61374f = "";

    /* renamed from: g  reason: collision with root package name */
    protected String f61375g = "";

    /* renamed from: h  reason: collision with root package name */
    protected String f61376h = "";

    /* renamed from: i  reason: collision with root package name */
    protected String f61377i = "";

    /* renamed from: j  reason: collision with root package name */
    protected int f61378j = -1;

    /* renamed from: k  reason: collision with root package name */
    protected int f61379k = -1;

    /* renamed from: l  reason: collision with root package name */
    protected int f61380l = 99999;

    /* renamed from: m  reason: collision with root package name */
    protected Map<String, String> f61381m = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    protected Map<String, String> f61382n = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    protected Set<PglITokenObserver> f61383o = new HashSet();

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface pblb {
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class pgla<T extends pblb> extends a implements pblb {
        public pgla(String str, String str2, String str3, int i4) {
            this.f61375g = str;
            this.f61376h = str2;
            this.f61377i = str3;
            this.f61380l = i4;
            if (TextUtils.isEmpty(str) || "0".equals(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("sdkID or license must be set.");
            }
        }

        public T b(PglITokenObserver pglITokenObserver) {
            if (pglITokenObserver != null) {
                this.f61383o.add(pglITokenObserver);
            }
            return this;
        }

        public T c(int i4) {
            this.f61378j = i4;
            return this;
        }

        public T d(String str) {
            this.f61371c = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public a e() {
            this.f61378j = 1;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(Object obj) {
        return (obj == null || !(obj instanceof String)) ? "" : ((String) obj).trim();
    }
}
