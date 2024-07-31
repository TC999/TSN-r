package com.p521ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12302n;
import com.p521ss.android.socialbase.downloader.constants.EnqueueType;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12469rh;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12475td;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12483y;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12496h;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12509p;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12523zz;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.notification.AbstractC12645ok;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12312kf {

    /* renamed from: a */
    private Context f34674a;

    /* renamed from: ah */
    private InterfaceC12483y f34675ah;

    /* renamed from: bl */
    private String f34676bl;

    /* renamed from: cf */
    private long f34677cf;

    /* renamed from: cs */
    private JSONObject f34678cs;

    /* renamed from: dn */
    private String f34680dn;

    /* renamed from: dx */
    private int f34681dx;

    /* renamed from: e */
    private boolean f34682e;

    /* renamed from: ej */
    private boolean f34683ej;

    /* renamed from: ep */
    private long f34685ep;

    /* renamed from: er */
    private int f34686er;

    /* renamed from: ew */
    private int f34687ew;

    /* renamed from: fb */
    private boolean f34688fb;

    /* renamed from: fd */
    private boolean f34689fd;

    /* renamed from: fl */
    private boolean f34690fl;

    /* renamed from: g */
    private String f34691g;

    /* renamed from: h */
    private String f34692h;

    /* renamed from: io */
    private AbstractC12645ok f34694io;

    /* renamed from: ju */
    private int[] f34696ju;

    /* renamed from: kf */
    private String f34698kf;

    /* renamed from: l */
    private InterfaceC12469rh f34700l;

    /* renamed from: ld */
    private String f34701ld;

    /* renamed from: m */
    private String f34702m;

    /* renamed from: n */
    private String f34703n;

    /* renamed from: o */
    private boolean f34704o;

    /* renamed from: ok */
    private Activity f34705ok;

    /* renamed from: p */
    private List<C12601bl> f34706p;

    /* renamed from: qu */
    private int f34708qu;

    /* renamed from: qx */
    private InterfaceC12480v f34709qx;

    /* renamed from: rh */
    private IDownloadListener f34711rh;

    /* renamed from: ry */
    private boolean f34712ry;

    /* renamed from: s */
    private List<String> f34713s;

    /* renamed from: t */
    private String f34715t;

    /* renamed from: td */
    private InterfaceC12496h f34716td;

    /* renamed from: tr */
    private boolean f34719tr;

    /* renamed from: u */
    private InterfaceC12523zz f34720u;

    /* renamed from: ul */
    private boolean f34721ul;

    /* renamed from: vk */
    private IDownloadFileUriProvider f34723vk;

    /* renamed from: vz */
    private boolean f34724vz;

    /* renamed from: w */
    private String f34725w;

    /* renamed from: wv */
    private InterfaceC12302n f34726wv;

    /* renamed from: x */
    private boolean f34727x;

    /* renamed from: y */
    private String f34729y;

    /* renamed from: yt */
    private InterfaceC12475td f34730yt;

    /* renamed from: z */
    private IDownloadListener f34731z;

    /* renamed from: zz */
    private InterfaceC12509p f34732zz;

    /* renamed from: q */
    private boolean f34707q = true;

    /* renamed from: k */
    private boolean f34697k = false;

    /* renamed from: r */
    private boolean f34710r = true;

    /* renamed from: j */
    private boolean f34695j = false;

    /* renamed from: i */
    private String f34693i = "application/vnd.android.package-archive";

    /* renamed from: kz */
    private int f34699kz = 5;

    /* renamed from: v */
    private boolean f34722v = true;

    /* renamed from: em */
    private EnqueueType f34684em = EnqueueType.ENQUEUE_NONE;

    /* renamed from: sg */
    private int f34714sg = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;

    /* renamed from: xy */
    private boolean f34728xy = true;

    /* renamed from: tg */
    private List<InterfaceC12484z> f34717tg = new ArrayList();

    /* renamed from: de */
    private boolean f34679de = true;

    /* renamed from: to */
    private boolean f34718to = true;

    public C12312kf(@NonNull Context context, @NonNull String str) {
        this.f34674a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f34676bl = str;
    }

    /* renamed from: a */
    public String m18362a() {
        return this.f34703n;
    }

    /* renamed from: ah */
    public InterfaceC12469rh m18357ah() {
        return this.f34700l;
    }

    /* renamed from: bl */
    public String m18356bl() {
        return this.f34692h;
    }

    /* renamed from: cf */
    public boolean m18352cf() {
        return this.f34712ry;
    }

    /* renamed from: cs */
    public long m18351cs() {
        return this.f34677cf;
    }

    /* renamed from: de */
    public List<String> m18350de() {
        return this.f34713s;
    }

    /* renamed from: dn */
    public InterfaceC12475td m18349dn() {
        return this.f34730yt;
    }

    /* renamed from: dx */
    public int[] m18348dx() {
        return this.f34696ju;
    }

    /* renamed from: e */
    public boolean m18347e() {
        return this.f34728xy;
    }

    /* renamed from: ej */
    public String m18346ej() {
        return this.f34680dn;
    }

    /* renamed from: em */
    public EnqueueType m18345em() {
        return this.f34684em;
    }

    /* renamed from: ep */
    public String m18344ep() {
        return this.f34691g;
    }

    /* renamed from: er */
    public InterfaceC12523zz m18343er() {
        return this.f34720u;
    }

    /* renamed from: ew */
    public boolean m18342ew() {
        return this.f34679de;
    }

    /* renamed from: fb */
    public int m18341fb() {
        return this.f34714sg;
    }

    /* renamed from: fd */
    public boolean m18340fd() {
        return this.f34683ej;
    }

    /* renamed from: fl */
    public boolean m18339fl() {
        return this.f34689fd;
    }

    /* renamed from: g */
    public int m18338g() {
        return this.f34708qu;
    }

    public Activity getActivity() {
        return this.f34705ok;
    }

    public Context getContext() {
        return this.f34674a;
    }

    /* renamed from: h */
    public boolean m18337h() {
        return this.f34710r;
    }

    /* renamed from: i */
    public InterfaceC12496h m18334i() {
        return this.f34716td;
    }

    /* renamed from: io */
    public String m18332io() {
        return this.f34702m;
    }

    /* renamed from: j */
    public String m18331j() {
        return this.f34693i;
    }

    /* renamed from: k */
    public IDownloadListener m18329k() {
        return this.f34711rh;
    }

    /* renamed from: kf */
    public boolean m18326kf() {
        return this.f34697k;
    }

    /* renamed from: kz */
    public boolean m18322kz() {
        return this.f34690fl;
    }

    /* renamed from: l */
    public InterfaceC12302n m18321l() {
        return this.f34726wv;
    }

    /* renamed from: m */
    public boolean m18320m() {
        return this.f34688fb;
    }

    /* renamed from: n */
    public boolean m18319n() {
        return this.f34707q;
    }

    /* renamed from: o */
    public int m18315o() {
        return this.f34699kz;
    }

    /* renamed from: ok */
    public String m18314ok() {
        return this.f34676bl;
    }

    /* renamed from: p */
    public boolean m18302p() {
        return this.f34695j;
    }

    /* renamed from: q */
    public IDownloadListener m18299q() {
        return this.f34731z;
    }

    /* renamed from: qu */
    public String m18296qu() {
        return this.f34698kf;
    }

    /* renamed from: qx */
    public boolean m18295qx() {
        return this.f34719tr;
    }

    /* renamed from: r */
    public String m18294r() {
        return this.f34715t;
    }

    /* renamed from: rh */
    public AbstractC12645ok m18291rh() {
        return this.f34694io;
    }

    /* renamed from: ry */
    public String m18289ry() {
        return this.f34725w;
    }

    /* renamed from: s */
    public List<C12601bl> m18288s() {
        return this.f34706p;
    }

    /* renamed from: sg */
    public boolean m18284sg() {
        return this.f34724vz;
    }

    /* renamed from: t */
    public InterfaceC12509p m18283t() {
        return this.f34732zz;
    }

    /* renamed from: td */
    public boolean m18281td() {
        return this.f34704o;
    }

    /* renamed from: tg */
    public String m18280tg() {
        return this.f34701ld;
    }

    /* renamed from: to */
    public JSONObject m18279to() {
        return this.f34678cs;
    }

    /* renamed from: tr */
    public int m18278tr() {
        return this.f34681dx;
    }

    /* renamed from: u */
    public String m18277u() {
        return this.f34729y;
    }

    /* renamed from: ul */
    public long m18276ul() {
        return this.f34685ep;
    }

    /* renamed from: v */
    public boolean m18275v() {
        return this.f34682e;
    }

    /* renamed from: vk */
    public InterfaceC12480v m18274vk() {
        return this.f34709qx;
    }

    /* renamed from: vz */
    public boolean m18273vz() {
        return this.f34722v;
    }

    /* renamed from: w */
    public boolean m18272w() {
        return this.f34718to;
    }

    /* renamed from: wv */
    public IDownloadFileUriProvider m18271wv() {
        return this.f34723vk;
    }

    /* renamed from: x */
    public boolean m18270x() {
        return this.f34721ul;
    }

    /* renamed from: xy */
    public InterfaceC12483y m18269xy() {
        return this.f34675ah;
    }

    /* renamed from: y */
    public int m18268y() {
        return this.f34686er;
    }

    /* renamed from: yt */
    public List<InterfaceC12484z> m18267yt() {
        return this.f34717tg;
    }

    /* renamed from: z */
    public boolean m18266z() {
        return this.f34727x;
    }

    /* renamed from: zz */
    public int m18264zz() {
        return this.f34687ew;
    }

    /* renamed from: a */
    public C12312kf m18360a(String str) {
        this.f34698kf = str;
        return this;
    }

    /* renamed from: bl */
    public C12312kf m18354bl(@NonNull String str) {
        this.f34692h = str;
        return this;
    }

    /* renamed from: h */
    public C12312kf m18336h(String str) {
        this.f34729y = str;
        return this;
    }

    /* renamed from: i */
    public C12312kf m18333i(boolean z) {
        this.f34679de = z;
        return this;
    }

    /* renamed from: j */
    public C12312kf m18330j(boolean z) {
        this.f34689fd = z;
        return this;
    }

    /* renamed from: k */
    public C12312kf m18327k(boolean z) {
        this.f34690fl = z;
        return this;
    }

    /* renamed from: kf */
    public C12312kf m18324kf(String str) {
        this.f34693i = str;
        return this;
    }

    /* renamed from: n */
    public C12312kf m18317n(String str) {
        this.f34715t = str;
        return this;
    }

    /* renamed from: ok */
    public void m18313ok(int i) {
        this.f34687ew = i;
    }

    /* renamed from: p */
    public C12312kf m18301p(String str) {
        this.f34702m = str;
        return this;
    }

    /* renamed from: q */
    public C12312kf m18298q(String str) {
        this.f34691g = str;
        return this;
    }

    /* renamed from: r */
    public C12312kf m18292r(boolean z) {
        this.f34682e = z;
        return this;
    }

    /* renamed from: rh */
    public C12312kf m18290rh(boolean z) {
        this.f34724vz = z;
        return this;
    }

    /* renamed from: s */
    public C12312kf m18286s(String str) {
        this.f34680dn = str;
        return this;
    }

    /* renamed from: t */
    public C12312kf m18282t(boolean z) {
        this.f34712ry = z;
        return this;
    }

    /* renamed from: z */
    public C12312kf m18265z(boolean z) {
        this.f34728xy = z;
        return this;
    }

    /* renamed from: a */
    public C12312kf m18358a(boolean z) {
        this.f34697k = z;
        return this;
    }

    /* renamed from: bl */
    public C12312kf m18353bl(boolean z) {
        this.f34695j = z;
        return this;
    }

    /* renamed from: h */
    public C12312kf m18335h(boolean z) {
        this.f34688fb = z;
        return this;
    }

    /* renamed from: k */
    public C12312kf m18328k(String str) {
        this.f34701ld = str;
        return this;
    }

    /* renamed from: kf */
    public C12312kf m18323kf(boolean z) {
        this.f34704o = z;
        return this;
    }

    /* renamed from: n */
    public C12312kf m18316n(boolean z) {
        this.f34721ul = z;
        return this;
    }

    /* renamed from: ok */
    public C12312kf m18306ok(String str) {
        this.f34703n = str;
        return this;
    }

    /* renamed from: p */
    public C12312kf m18300p(boolean z) {
        this.f34683ej = z;
        return this;
    }

    /* renamed from: q */
    public C12312kf m18297q(boolean z) {
        this.f34722v = z;
        return this;
    }

    /* renamed from: r */
    public C12312kf m18293r(String str) {
        this.f34725w = str;
        return this;
    }

    /* renamed from: s */
    public C12312kf m18285s(boolean z) {
        this.f34727x = z;
        return this;
    }

    /* renamed from: a */
    public C12312kf m18361a(int i) {
        this.f34699kz = i;
        return this;
    }

    /* renamed from: bl */
    public C12312kf m18355bl(int i) {
        this.f34686er = i;
        return this;
    }

    /* renamed from: kf */
    public C12312kf m18325kf(int i) {
        this.f34681dx = i;
        return this;
    }

    /* renamed from: n */
    public C12312kf m18318n(int i) {
        this.f34708qu = i;
        return this;
    }

    /* renamed from: ok */
    public C12312kf m18305ok(List<C12601bl> list) {
        this.f34706p = list;
        return this;
    }

    /* renamed from: s */
    public C12312kf m18287s(int i) {
        this.f34714sg = i;
        return this;
    }

    /* renamed from: a */
    public C12312kf m18359a(List<String> list) {
        this.f34713s = list;
        return this;
    }

    /* renamed from: ok */
    public C12312kf m18303ok(boolean z) {
        this.f34707q = z;
        return this;
    }

    /* renamed from: ok */
    public C12312kf m18309ok(IDownloadListener iDownloadListener) {
        this.f34731z = iDownloadListener;
        return this;
    }

    /* renamed from: ok */
    public C12312kf m18312ok(long j) {
        this.f34685ep = j;
        return this;
    }

    /* renamed from: ok */
    public C12312kf m18311ok(EnqueueType enqueueType) {
        this.f34684em = enqueueType;
        return this;
    }

    /* renamed from: ok */
    public C12312kf m18310ok(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.f34723vk = iDownloadFileUriProvider;
        return this;
    }

    /* renamed from: ok */
    public C12312kf m18308ok(InterfaceC12475td interfaceC12475td) {
        this.f34730yt = interfaceC12475td;
        return this;
    }

    /* renamed from: ok */
    public C12312kf m18304ok(JSONObject jSONObject) {
        this.f34678cs = jSONObject;
        return this;
    }

    /* renamed from: ok */
    public C12312kf m18307ok(InterfaceC12484z interfaceC12484z) {
        synchronized (this.f34717tg) {
            if (interfaceC12484z != null) {
                if (!this.f34717tg.contains(interfaceC12484z)) {
                    this.f34717tg.add(interfaceC12484z);
                    return this;
                }
            }
            return this;
        }
    }
}
