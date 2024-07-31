package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.col.p0463l.FileCopy;
import com.amap.api.col.p0463l.IDownloadListener;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;

/* renamed from: com.amap.api.col.3l.ax */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CityObject extends OfflineMapCity implements TaskItem, IDownloadItem {
    public static final Parcelable.Creator<CityObject> CREATOR = new C1741b();

    /* renamed from: f */
    public final AbstractCityStateImp f3573f;

    /* renamed from: g */
    public final AbstractCityStateImp f3574g;

    /* renamed from: h */
    public final AbstractCityStateImp f3575h;

    /* renamed from: i */
    public final AbstractCityStateImp f3576i;

    /* renamed from: j */
    public final AbstractCityStateImp f3577j;

    /* renamed from: k */
    public final AbstractCityStateImp f3578k;

    /* renamed from: l */
    public final AbstractCityStateImp f3579l;

    /* renamed from: m */
    public final AbstractCityStateImp f3580m;

    /* renamed from: n */
    public final AbstractCityStateImp f3581n;

    /* renamed from: o */
    public final AbstractCityStateImp f3582o;

    /* renamed from: p */
    public final AbstractCityStateImp f3583p;

    /* renamed from: q */
    AbstractCityStateImp f3584q;

    /* renamed from: r */
    Context f3585r;

    /* renamed from: s */
    private String f3586s;

    /* renamed from: t */
    private String f3587t;

    /* renamed from: u */
    boolean f3588u;

    /* renamed from: v */
    private long f3589v;

    /* compiled from: CityObject.java */
    /* renamed from: com.amap.api.col.3l.ax$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1741b implements Parcelable.Creator<CityObject> {
        C1741b() {
        }

        /* renamed from: a */
        private static CityObject m55615a(Parcel parcel) {
            return new CityObject(parcel);
        }

        /* renamed from: b */
        private static CityObject[] m55614b(int i) {
            return new CityObject[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CityObject createFromParcel(Parcel parcel) {
            return m55615a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CityObject[] newArray(int i) {
            return m55614b(i);
        }
    }

    /* compiled from: CityObject.java */
    /* renamed from: com.amap.api.col.3l.ax$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static /* synthetic */ class C1742c {

        /* renamed from: a */
        static final /* synthetic */ int[] f3593a;

        static {
            int[] iArr = new int[IDownloadListener.EnumC1754a.values().length];
            f3593a = iArr;
            try {
                iArr[IDownloadListener.EnumC1754a.amap_exception.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3593a[IDownloadListener.EnumC1754a.file_io_exception.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3593a[IDownloadListener.EnumC1754a.network_exception.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CityObject(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        m55632H();
    }

    /* renamed from: J */
    private void m55630J() {
        OfflineDownloadManager m55594b = OfflineDownloadManager.m55594b(this.f3585r);
        if (m55594b != null) {
            m55594b.m55591e(this);
        }
    }

    /* renamed from: c */
    private String m55629c() {
        if (TextUtils.isEmpty(this.f3586s)) {
            return null;
        }
        String str = this.f3586s;
        return str.substring(0, str.lastIndexOf("."));
    }

    /* renamed from: d */
    private String m55628d() {
        if (TextUtils.isEmpty(this.f3586s)) {
            return null;
        }
        String m55629c = m55629c();
        return m55629c.substring(0, m55629c.lastIndexOf(46));
    }

    /* renamed from: e */
    private boolean m55627e() {
        Utility.m53353a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    /* renamed from: k */
    private void m55621k(File file, File file2, String str) {
        new FileCopy().m53897b(file, file2, -1L, Utility.m53352b(file), new C1740a(str, file));
    }

    /* renamed from: A */
    public final void m55639A() {
        m55618s().m55089d();
        if (this.f3584q.equals(this.f3576i)) {
            this.f3584q.mo54531g();
        } else if (this.f3584q.equals(this.f3575h)) {
            this.f3584q.mo54412i();
        } else if (!this.f3584q.equals(this.f3579l) && !this.f3584q.equals(this.f3580m)) {
            if (!this.f3584q.equals(this.f3582o) && !this.f3584q.equals(this.f3581n) && !this.f3584q.m55090c(this.f3583p)) {
                m55618s().mo54413h();
            } else {
                this.f3584q.mo54414f();
            }
        } else {
            m55630J();
            this.f3588u = true;
        }
    }

    /* renamed from: B */
    public final void m55638B() {
        this.f3584q.mo54412i();
    }

    /* renamed from: C */
    public final void m55637C() {
        this.f3584q.mo54415b(this.f3583p.m55089d());
    }

    /* renamed from: D */
    public final void m55636D() {
        this.f3584q.mo55091a();
        if (this.f3588u) {
            this.f3584q.mo54413h();
        }
        this.f3588u = false;
    }

    /* renamed from: E */
    public final void m55635E() {
        this.f3584q.equals(this.f3578k);
        this.f3584q.mo54941j();
    }

    /* renamed from: F */
    public final void m55634F() {
        OfflineDownloadManager m55594b = OfflineDownloadManager.m55594b(this.f3585r);
        if (m55594b != null) {
            m55594b.m55585k(this);
        }
    }

    /* renamed from: G */
    public final void m55633G() {
        OfflineDownloadManager m55594b = OfflineDownloadManager.m55594b(this.f3585r);
        if (m55594b != null) {
            m55594b.m55575u(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: H */
    public final void m55632H() {
        String str = OfflineDownloadManager.f3613o;
        String m53345i = Utility.m53345i(getUrl());
        if (m53345i != null) {
            this.f3586s = str + m53345i + ".zip.tmp";
            return;
        }
        this.f3586s = str + getPinyin() + ".zip.tmp";
    }

    /* renamed from: I */
    public final UpdateItem m55631I() {
        setState(this.f3584q.m55089d());
        UpdateItem updateItem = new UpdateItem(this, this.f3585r);
        updateItem.m54535m(m55624h());
        m55624h();
        return updateItem;
    }

    @Override // com.amap.api.col.p0463l.IDownloadListener
    /* renamed from: a */
    public final void mo55528a(long j, long j2) {
        int i = (int) ((j2 * 100) / j);
        if (i != getcompleteCode()) {
            setCompleteCode(i);
            m55617t();
        }
    }

    @Override // com.amap.api.col.p0463l.TaskItem
    /* renamed from: b */
    public final String mo54643b() {
        return getUrl();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: h */
    public final String m55624h() {
        return this.f3587t;
    }

    /* renamed from: i */
    public final void m55623i(int i) {
        if (i == -1) {
            this.f3584q = this.f3580m;
        } else if (i == 0) {
            this.f3584q = this.f3575h;
        } else if (i == 1) {
            this.f3584q = this.f3577j;
        } else if (i == 2) {
            this.f3584q = this.f3574g;
        } else if (i == 3) {
            this.f3584q = this.f3576i;
        } else if (i == 4) {
            this.f3584q = this.f3578k;
        } else if (i == 6) {
            this.f3584q = this.f3573f;
        } else if (i != 7) {
            switch (i) {
                case 101:
                    this.f3584q = this.f3581n;
                    break;
                case 102:
                    this.f3584q = this.f3582o;
                    break;
                case 103:
                    this.f3584q = this.f3583p;
                    break;
                default:
                    if (i < 0) {
                        this.f3584q = this.f3580m;
                        break;
                    }
                    break;
            }
        } else {
            this.f3584q = this.f3579l;
        }
        setState(i);
    }

    /* renamed from: j */
    public final void m55622j(AbstractCityStateImp abstractCityStateImp) {
        this.f3584q = abstractCityStateImp;
        setState(abstractCityStateImp.m55089d());
    }

    /* renamed from: l */
    public final void m55620l(String str) {
        this.f3587t = str;
    }

    @Override // com.amap.api.col.p0463l.IDownloadListener
    /* renamed from: m */
    public final void mo55526m() {
        this.f3589v = 0L;
        this.f3584q.equals(this.f3574g);
        this.f3584q.mo54414f();
    }

    @Override // com.amap.api.col.p0463l.IDownloadListener
    /* renamed from: n */
    public final void mo55525n() {
        this.f3584q.equals(this.f3575h);
        this.f3584q.mo54451k();
    }

    @Override // com.amap.api.col.p0463l.IDownloadListener
    /* renamed from: o */
    public final void mo55524o() {
        m55616z();
    }

    @Override // com.amap.api.col.p0463l.IUnZipListener
    /* renamed from: p */
    public final void mo53810p() {
        this.f3589v = 0L;
        setCompleteCode(0);
        this.f3584q.equals(this.f3577j);
        this.f3584q.mo54414f();
    }

    @Override // com.amap.api.col.p0463l.IUnZipListener
    /* renamed from: q */
    public final void mo53809q() {
        this.f3584q.equals(this.f3577j);
        this.f3584q.mo54415b(this.f3580m.m55089d());
    }

    @Override // com.amap.api.col.p0463l.IUnZipListener
    /* renamed from: r */
    public final void mo53808r() {
        m55616z();
    }

    /* renamed from: s */
    public final AbstractCityStateImp m55618s() {
        return this.f3584q;
    }

    /* renamed from: t */
    public final void m55617t() {
        OfflineDownloadManager m55594b = OfflineDownloadManager.m55594b(this.f3585r);
        if (m55594b != null) {
            m55594b.m55579q(this);
        }
    }

    @Override // com.amap.api.col.p0463l.IDownloadItem
    /* renamed from: u */
    public final boolean mo55569u() {
        return m55627e();
    }

    @Override // com.amap.api.col.p0463l.IDownloadItem
    /* renamed from: v */
    public final String mo55568v() {
        StringBuffer stringBuffer = new StringBuffer();
        String m53345i = Utility.m53345i(getUrl());
        if (m53345i != null) {
            stringBuffer.append(m53345i);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0463l.IDownloadItem
    /* renamed from: w */
    public final String mo55567w() {
        return getAdcode();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f3587t);
    }

    @Override // com.amap.api.col.p0463l.IUnzipItem
    /* renamed from: x */
    public final String mo53672x() {
        return m55629c();
    }

    @Override // com.amap.api.col.p0463l.IUnzipItem
    /* renamed from: y */
    public final String mo53671y() {
        return m55628d();
    }

    /* renamed from: z */
    public final void m55616z() {
        OfflineDownloadManager m55594b = OfflineDownloadManager.m55594b(this.f3585r);
        if (m55594b != null) {
            m55594b.m55572x(this);
            m55617t();
        }
    }

    @Override // com.amap.api.col.p0463l.IUnZipListener
    /* renamed from: b */
    public final void mo53811b(String str) {
        this.f3584q.equals(this.f3577j);
        this.f3587t = str;
        String m55629c = m55629c();
        String m55628d = m55628d();
        if (!TextUtils.isEmpty(m55629c) && !TextUtils.isEmpty(m55628d)) {
            File file = new File(m55628d + "/");
            File file2 = new File(C1732a3.m55688v(this.f3585r) + File.separator + "map/");
            File file3 = new File(C1732a3.m55688v(this.f3585r));
            if (file3.exists() || file3.mkdir()) {
                if (file2.exists() || file2.mkdir()) {
                    m55621k(file, file2, m55629c);
                    return;
                }
                return;
            }
            return;
        }
        mo53809q();
    }

    /* renamed from: m */
    public final AbstractCityStateImp m55619m(int i) {
        switch (i) {
            case 101:
                return this.f3581n;
            case 102:
                return this.f3582o;
            case 103:
                return this.f3583p;
            default:
                return this.f3580m;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CityObject.java */
    /* renamed from: com.amap.api.col.3l.ax$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1740a implements FileCopy.InterfaceC1944a {

        /* renamed from: a */
        final /* synthetic */ String f3590a;

        /* renamed from: b */
        final /* synthetic */ File f3591b;

        C1740a(String str, File file) {
            this.f3590a = str;
            this.f3591b = file;
        }

        @Override // com.amap.api.col.p0463l.FileCopy.InterfaceC1944a
        /* renamed from: a */
        public final void mo53895a(float f) {
            int i = CityObject.this.getcompleteCode();
            double d = f;
            Double.isNaN(d);
            int i2 = (int) ((d * 0.39d) + 60.0d);
            if (i2 - i <= 0 || System.currentTimeMillis() - CityObject.this.f3589v <= 1000) {
                return;
            }
            CityObject.this.setCompleteCode(i2);
            CityObject.this.f3589v = System.currentTimeMillis();
        }

        @Override // com.amap.api.col.p0463l.FileCopy.InterfaceC1944a
        /* renamed from: b */
        public final void mo53894b() {
            CityObject cityObject = CityObject.this;
            cityObject.f3584q.mo54415b(cityObject.f3583p.m55089d());
        }

        @Override // com.amap.api.col.p0463l.FileCopy.InterfaceC1944a
        /* renamed from: a */
        public final void mo53896a() {
            try {
                if (new File(this.f3590a).delete()) {
                    Utility.m53342l(this.f3591b);
                    CityObject.this.setCompleteCode(100);
                    CityObject.this.f3584q.mo54451k();
                }
            } catch (Exception unused) {
                CityObject cityObject = CityObject.this;
                cityObject.f3584q.mo54415b(cityObject.f3583p.m55089d());
            }
        }
    }

    @Override // com.amap.api.col.p0463l.IDownloadListener
    /* renamed from: a */
    public final void mo55527a(IDownloadListener.EnumC1754a enumC1754a) {
        int m55089d;
        int i = C1742c.f3593a[enumC1754a.ordinal()];
        if (i == 1) {
            m55089d = this.f3582o.m55089d();
        } else if (i != 2) {
            m55089d = i != 3 ? 6 : this.f3581n.m55089d();
        } else {
            m55089d = this.f3583p.m55089d();
        }
        if (this.f3584q.equals(this.f3575h) || this.f3584q.equals(this.f3574g)) {
            this.f3584q.mo54415b(m55089d);
        }
    }

    @Override // com.amap.api.col.p0463l.IUnZipListener
    /* renamed from: a */
    public final void mo53812a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f3589v > 500) {
            int i = (int) j;
            if (i > getcompleteCode()) {
                setCompleteCode(i);
                m55617t();
            }
            this.f3589v = currentTimeMillis;
        }
    }

    private CityObject(Context context, int i) {
        this.f3573f = new DefaultStateAbstract(this);
        this.f3574g = new WaitingStateAbstractAbstract(this);
        this.f3575h = new LoadingStateAbstractAbstract(this);
        this.f3576i = new PauseStateAbstractAbstract(this);
        this.f3577j = new UnzipStateAbstract(this);
        this.f3578k = new CompleteStateAbstractAbstract(this);
        this.f3579l = new NewVersionStateAbstractAbstract(this);
        this.f3580m = new ErrorStateAbstractAbstract(-1, this);
        this.f3581n = new ErrorStateAbstractAbstract(101, this);
        this.f3582o = new ErrorStateAbstractAbstract(102, this);
        this.f3583p = new ErrorStateAbstractAbstract(103, this);
        this.f3586s = null;
        this.f3587t = "";
        this.f3588u = false;
        this.f3589v = 0L;
        this.f3585r = context;
        m55623i(i);
    }

    public CityObject(Parcel parcel) {
        super(parcel);
        this.f3573f = new DefaultStateAbstract(this);
        this.f3574g = new WaitingStateAbstractAbstract(this);
        this.f3575h = new LoadingStateAbstractAbstract(this);
        this.f3576i = new PauseStateAbstractAbstract(this);
        this.f3577j = new UnzipStateAbstract(this);
        this.f3578k = new CompleteStateAbstractAbstract(this);
        this.f3579l = new NewVersionStateAbstractAbstract(this);
        this.f3580m = new ErrorStateAbstractAbstract(-1, this);
        this.f3581n = new ErrorStateAbstractAbstract(101, this);
        this.f3582o = new ErrorStateAbstractAbstract(102, this);
        this.f3583p = new ErrorStateAbstractAbstract(103, this);
        this.f3586s = null;
        this.f3587t = "";
        this.f3588u = false;
        this.f3589v = 0L;
        this.f3587t = parcel.readString();
    }
}
