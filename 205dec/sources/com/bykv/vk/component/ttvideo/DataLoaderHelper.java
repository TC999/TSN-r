package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLStartCompleteListener;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class DataLoaderHelper implements AVMDLDataLoaderListener, AVMDLStartCompleteListener {
    public static final int DATALOADER_KEY_ENABLE_ALOG = 512;
    public static final int DATALOADER_KEY_INT_MAXCACHESIZE = 1;
    public static final int DATALOADER_KEY_INT_OPENTIMEOUT = 3;
    public static final int DATALOADER_KEY_INT_PARALLEL_NUM = 11;
    public static final int DATALOADER_KEY_INT_RWTIMEOUT = 2;
    public static final int DATALOADER_KEY_INT_TRYCOUNT = 4;
    public static final int DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE = 1005;
    public static final int DATALOADER_KEY_STRING_CACHEDIR = 0;
    public static final int IsClose = 1;
    public static final int IsPlayTask = 1;
    public static final int IsPreloadTask = 2;
    public static final int IsStart = 0;
    public static final int IsUnknown = 0;
    public static final String MDL_PREFIX = "mdl://";

    /* renamed from: p  reason: collision with root package name */
    private static final DataLoaderHelper f24762p = new DataLoaderHelper();

    /* renamed from: q  reason: collision with root package name */
    private static int f24763q = 0;

    /* renamed from: r  reason: collision with root package name */
    private static int f24764r = 0;

    /* renamed from: s  reason: collision with root package name */
    private static int f24765s = 0;

    /* renamed from: i  reason: collision with root package name */
    private AVMDLDataLoader f24774i;

    /* renamed from: k  reason: collision with root package name */
    private VideoEventEngineUploader f24776k;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24778m;

    /* renamed from: b  reason: collision with root package name */
    private final d f24767b = new d();

    /* renamed from: c  reason: collision with root package name */
    private final d f24768c = new d();

    /* renamed from: d  reason: collision with root package name */
    private final d f24769d = new d();

    /* renamed from: e  reason: collision with root package name */
    private final d f24770e = new d();

    /* renamed from: f  reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f24771f = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, ArrayList<TTVideoEngine>> f24772g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final ReentrantLock f24773h = new ReentrantLock();

    /* renamed from: l  reason: collision with root package name */
    private boolean f24777l = true;

    /* renamed from: n  reason: collision with root package name */
    private int f24779n = 0;

    /* renamed from: o  reason: collision with root package name */
    private final ReentrantLock f24780o = new ReentrantLock();

    /* renamed from: a  reason: collision with root package name */
    private volatile int f24766a = 1;

    /* renamed from: j  reason: collision with root package name */
    private AVMDLDataLoaderConfigure f24775j = AVMDLDataLoaderConfigure.getDefaultonfigure();

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class DataLoaderCacheInfo {
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public String mLocalFilePath = null;

        public DataLoaderCacheInfo(DataLoaderHelper dataLoaderHelper) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static class DataLoaderTaskProgressInfo {
        public String mKey = null;
        public String mVideoId = null;
        public String mLocalFilePath = null;
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public int mTaskType = 0;
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f24781a = null;

        /* renamed from: b  reason: collision with root package name */
        public long f24782b = 0;

        /* renamed from: c  reason: collision with root package name */
        public PreloaderURLItem f24783c = null;

        /* renamed from: d  reason: collision with root package name */
        public boolean f24784d = false;

        /* renamed from: e  reason: collision with root package name */
        public List<a> f24785e = new CopyOnWriteArrayList();

        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public String f24786a = null;

            /* renamed from: b  reason: collision with root package name */
            public String f24787b = null;

            /* renamed from: c  reason: collision with root package name */
            public String[] f24788c = null;

            /* renamed from: d  reason: collision with root package name */
            public String f24789d = null;

            /* renamed from: e  reason: collision with root package name */
            public long f24790e = 0;

            /* renamed from: f  reason: collision with root package name */
            public long f24791f = 0;

            /* renamed from: g  reason: collision with root package name */
            public long f24792g = 0;

            /* renamed from: h  reason: collision with root package name */
            public long f24793h = 0;

            /* renamed from: i  reason: collision with root package name */
            public long f24794i = 0;

            public a(b bVar) {
            }
        }

        public b(DataLoaderHelper dataLoaderHelper) {
        }

        public a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a b4 = b(str);
            if (b4 == null) {
                a aVar = new a(this);
                aVar.f24786a = str;
                this.f24785e.add(aVar);
                return aVar;
            }
            return b4;
        }

        public IPreLoaderItemCallBackListener a() {
            PreloaderURLItem preloaderURLItem = this.f24783c;
            if (preloaderURLItem == null || preloaderURLItem.getCallBackListener() == null) {
                return null;
            }
            return this.f24783c.getCallBackListener();
        }

        public void a(int i4) {
            TTVideoEngineLog.d("DataLoaderHelper", "startMDLPreloadTask _notifyError " + i4);
            if (a() != null) {
                DataLoaderHelper.c();
                TTVideoEngineLog.d("DataLoaderHelper", "preloadCount engine callback " + DataLoaderHelper.f24765s + ", KEY_IS_PRELOAD_END_FAIL");
                PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                preLoaderItemCallBackInfo.preloadError = new Error(Error.DataLoaderPreload, i4);
                a().preloadItemInfo(preLoaderItemCallBackInfo);
            }
        }

        public void a(String str, long j4) {
            if (this.f24785e.size() == 0) {
                a aVar = new a(this);
                aVar.f24786a = str;
                aVar.f24792g = j4;
                this.f24785e.add(aVar);
            } else {
                TTVideoEngineLog.e("DataLoaderHelper", "[preload] DataLoaderTaskItem setup fail");
            }
            this.f24782b = j4;
        }

        public a b(String str) {
            if (this.f24785e.size() > 0) {
                for (int i4 = 0; i4 < this.f24785e.size(); i4++) {
                    a aVar = this.f24785e.get(i4);
                    if (aVar.f24786a.equals(str)) {
                        return aVar;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f24795a;

        /* renamed from: b  reason: collision with root package name */
        public int f24796b = 0;

        /* renamed from: c  reason: collision with root package name */
        public List<a> f24797c = null;

        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        public class a {

            /* renamed from: e  reason: collision with root package name */
            public String f24802e;

            /* renamed from: a  reason: collision with root package name */
            public String f24798a = null;

            /* renamed from: b  reason: collision with root package name */
            public long f24799b = 0;

            /* renamed from: c  reason: collision with root package name */
            public long f24800c = 0;

            /* renamed from: d  reason: collision with root package name */
            public List<C0331a> f24801d = null;

            /* renamed from: f  reason: collision with root package name */
            public Error f24803f = null;

            /* renamed from: com.bykv.vk.component.ttvideo.DataLoaderHelper$c$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\4499832.dex */
            public class C0331a {

                /* renamed from: a  reason: collision with root package name */
                public long f24804a = 0;

                /* renamed from: b  reason: collision with root package name */
                public long f24805b = 0;

                public C0331a(a aVar) {
                }
            }

            public a(c cVar) {
            }

            void a(long j4) {
                if (this.f24801d == null) {
                    this.f24801d = new ArrayList();
                }
                if (this.f24801d.size() == 0) {
                    this.f24801d.add(new C0331a(this));
                }
                this.f24801d.get(0).f24804a = 0L;
                this.f24801d.get(0).f24805b = j4;
            }

            public boolean a() {
                long j4 = this.f24800c;
                long min = j4 > 0 ? Math.min(j4, this.f24799b) : this.f24799b;
                List<C0331a> list = this.f24801d;
                C0331a c0331a = list != null ? list.get(list.size() - 1) : null;
                if (this.f24803f == null) {
                    return c0331a != null && this.f24799b > 0 && c0331a.f24804a + c0331a.f24805b >= min;
                }
                return true;
            }

            public long b() {
                List<C0331a> list = this.f24801d;
                if (list == null || list.size() <= 0) {
                    return 0L;
                }
                List<C0331a> list2 = this.f24801d;
                return list2.get(list2.size() - 1).f24805b;
            }
        }

        public c(DataLoaderHelper dataLoaderHelper) {
        }

        private a a(String str) {
            List<a> list;
            if (!TextUtils.isEmpty(str) && (list = this.f24797c) != null) {
                for (a aVar : list) {
                    if (aVar.f24798a.equals(str)) {
                        return aVar;
                    }
                }
            }
            return null;
        }

        public long a() {
            long j4 = 0;
            if (this.f24797c != null) {
                for (int i4 = 0; i4 < this.f24797c.size(); i4++) {
                    j4 += this.f24797c.get(i4).b();
                }
            }
            return j4;
        }

        public void a(b bVar) {
            String str = bVar.f24781a;
            if (this.f24797c == null) {
                this.f24797c = new ArrayList();
            }
            for (b.a aVar : bVar.f24785e) {
                boolean z3 = true;
                a a4 = a(aVar.f24786a);
                if (a4 == null) {
                    a4 = new a(this);
                    z3 = false;
                }
                a4.f24798a = aVar.f24786a;
                a4.f24799b = aVar.f24793h;
                a4.a(aVar.f24794i);
                a4.f24800c = aVar.f24792g;
                a4.f24802e = aVar.f24789d;
                if (!z3) {
                    this.f24797c.add(a4);
                }
            }
        }

        public void a(String str, Error error) {
            a a4 = a(str);
            if (a4 != null) {
                a4.f24803f = error;
            }
        }

        public boolean b() {
            boolean z3;
            int i4;
            if (this.f24797c != null) {
                z3 = true;
                i4 = 0;
                for (int i5 = 0; i5 < this.f24797c.size(); i5++) {
                    a aVar = this.f24797c.get(i5);
                    if (aVar == null || aVar.a()) {
                        i4++;
                    } else {
                        z3 = false;
                    }
                }
            } else {
                z3 = true;
                i4 = 0;
            }
            return z3 || (i4 >= 2 && this.f24796b == 1);
        }

        public boolean c() {
            if (this.f24796b != 2) {
                TTVideoEngineLog.d("DataLoaderHelper", "task is not a preload task");
                return false;
            }
            if (this.f24797c != null) {
                for (int i4 = 0; i4 < this.f24797c.size(); i4++) {
                    a aVar = this.f24797c.get(i4);
                    if (aVar != null && !aVar.a()) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        private final ReentrantLock f24806a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<b> f24807b;

        /* renamed from: c  reason: collision with root package name */
        private long f24808c;

        private d(DataLoaderHelper dataLoaderHelper) {
            this.f24806a = new ReentrantLock();
            this.f24807b = new ArrayList<>();
            this.f24808c = 0L;
        }

        private Boolean e() {
            if (this.f24808c >= 1) {
                return Boolean.valueOf(((long) this.f24807b.size()) >= this.f24808c);
            }
            return Boolean.FALSE;
        }

        public b a() {
            this.f24806a.lock();
            if (this.f24807b.size() == 0) {
                this.f24806a.unlock();
                return null;
            }
            ArrayList<b> arrayList = this.f24807b;
            b bVar = arrayList.get(arrayList.size() - 1);
            this.f24806a.unlock();
            return bVar;
        }

        public void a(long j4) {
            this.f24808c = j4;
        }

        boolean a(b bVar) {
            Boolean bool;
            if (bVar == null || bVar.f24785e.size() == 0) {
                return false;
            }
            this.f24806a.lock();
            if (e().booleanValue()) {
                bool = Boolean.FALSE;
            } else {
                this.f24807b.add(bVar);
                bool = Boolean.TRUE;
            }
            this.f24806a.unlock();
            return bool.booleanValue();
        }

        public boolean a(String str) {
            int i4 = 0;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Boolean bool = Boolean.FALSE;
            this.f24806a.lock();
            while (true) {
                if (i4 >= this.f24807b.size()) {
                    break;
                } else if (this.f24807b.get(i4).b(str) != null) {
                    bool = Boolean.TRUE;
                    break;
                } else {
                    i4++;
                }
            }
            this.f24806a.unlock();
            return bool.booleanValue();
        }

        public long b() {
            this.f24806a.lock();
            long size = this.f24807b.size();
            this.f24806a.unlock();
            return size;
        }

        public b b(b bVar) {
            b bVar2;
            if (TextUtils.isEmpty(bVar.f24781a)) {
                bVar2 = null;
            } else {
                bVar2 = d(bVar.f24781a);
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            Iterator<b.a> it = bVar.f24785e.iterator();
            while (it.hasNext() && (bVar2 = c(it.next().f24786a)) == null) {
            }
            return bVar2;
        }

        public b b(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f24806a.lock();
            int i4 = 0;
            while (true) {
                if (i4 >= this.f24807b.size()) {
                    break;
                }
                b bVar2 = this.f24807b.get(i4);
                if (bVar2.b(str) != null) {
                    bVar = bVar2;
                    break;
                }
                i4++;
            }
            this.f24806a.unlock();
            return bVar;
        }

        public b c() {
            this.f24806a.lock();
            if (this.f24807b.size() == 0) {
                this.f24806a.unlock();
                return null;
            }
            ArrayList<b> arrayList = this.f24807b;
            b bVar = arrayList.get(arrayList.size() - 1);
            this.f24807b.remove(bVar);
            this.f24806a.unlock();
            return bVar;
        }

        public b c(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f24806a.lock();
            int i4 = 0;
            while (true) {
                if (i4 >= this.f24807b.size()) {
                    break;
                }
                b bVar2 = this.f24807b.get(i4);
                if (bVar2.b(str) != null) {
                    bVar = bVar2;
                    break;
                }
                i4++;
            }
            if (bVar != null) {
                TTVideoEngineLog.d("DataLoaderHelper", "popItem remove this " + this + ", item " + bVar);
                this.f24807b.remove(bVar);
            }
            this.f24806a.unlock();
            return bVar;
        }

        public b d(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f24806a.lock();
            int i4 = 0;
            while (true) {
                if (i4 >= this.f24807b.size()) {
                    break;
                }
                b bVar2 = this.f24807b.get(i4);
                if (!TextUtils.isEmpty(bVar2.f24781a) && bVar2.f24781a.equals(str)) {
                    bVar = bVar2;
                    break;
                }
                i4++;
            }
            if (bVar != null) {
                this.f24807b.remove(bVar);
            }
            this.f24806a.unlock();
            return bVar;
        }

        public ArrayList<b> d() {
            try {
                this.f24806a.lock();
                return new ArrayList<>(this.f24807b);
            } finally {
                this.f24806a.unlock();
            }
        }
    }

    private DataLoaderHelper() {
    }

    private String a(String str, String str2, long j4, long j5, String[] strArr, String str3) {
        String str4;
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length < 1) {
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        long j6 = j5 > 0 ? j5 : 0L;
        for (String str5 : strArr2) {
            if (!c(str5)) {
                return null;
            }
        }
        String[] a4 = a(strArr2);
        String encodeUrl = encodeUrl(str);
        if (TextUtils.isEmpty(encodeUrl)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("preloadProxyQuery: key = ");
        String str6 = str;
        sb.append(str);
        sb.append(", rawKey = ");
        sb.append(str2);
        TTVideoEngineLog.i("DataLoaderHelper", sb.toString());
        if (!TextUtils.isEmpty(str2)) {
            str6 = str2;
        }
        String encodeUrl2 = encodeUrl(str6);
        if (TextUtils.isEmpty(encodeUrl2)) {
            encodeUrl2 = "videoId";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?rk=");
        stringBuffer.append(encodeUrl2);
        stringBuffer.append("&k=");
        stringBuffer.append(encodeUrl);
        if (j6 > 0) {
            stringBuffer.append("&s=");
            stringBuffer.append(j4 + j6);
        }
        if (!TextUtils.isEmpty(str3)) {
            try {
                str4 = URLEncoder.encode(str3, "UTF-8");
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                str4 = null;
            }
            if (!TextUtils.isEmpty(str4)) {
                stringBuffer.append("&p=");
                stringBuffer.append(str4);
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i4 = 0; i4 < a4.length; i4++) {
            String encodeUrlByQuery = encodeUrlByQuery(a4[i4]);
            StringBuffer stringBuffer3 = new StringBuffer();
            if (!TextUtils.isEmpty(encodeUrlByQuery)) {
                stringBuffer3.append("&u");
                stringBuffer3.append(i4);
                stringBuffer3.append("=");
                stringBuffer3.append(encodeUrlByQuery);
            }
            if (stringBuffer.length() + stringBuffer2.length() + stringBuffer3.length() + 32 > 3096) {
                break;
            }
            stringBuffer2.append(stringBuffer3);
        }
        if (stringBuffer2.length() < 1) {
            return null;
        }
        stringBuffer.append(stringBuffer2);
        return stringBuffer.toString();
    }

    private ArrayList<TTVideoEngine> a(String str) {
        ArrayList<TTVideoEngine> arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            this.f24773h.lock();
            ArrayList<TTVideoEngine> arrayList2 = this.f24772g.get(str);
            if (arrayList2 != null) {
                arrayList = new ArrayList<>(arrayList2);
                TTVideoEngineLog.i("DataLoaderHelper", "get engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
            }
            return arrayList;
        } finally {
            this.f24773h.unlock();
        }
    }

    private void a() {
        if (this.f24774i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            return;
        }
        b a4 = this.f24767b.a();
        if (a4 != null && this.f24768c.a(a4)) {
            this.f24767b.c();
            if (a4.f24783c != null) {
                b(a4);
            }
        }
    }

    private void a(b bVar) {
        boolean z3;
        ArrayList<TTVideoEngine> a4;
        ArrayList<b> d4 = this.f24770e.d();
        int i4 = 0;
        while (true) {
            if (i4 >= d4.size()) {
                z3 = true;
                break;
            }
            b bVar2 = d4.get(i4);
            if (!TextUtils.isEmpty(bVar2.f24781a) && !TextUtils.isEmpty(bVar.f24781a) && bVar2.f24781a.equals(bVar.f24781a)) {
                z3 = false;
                break;
            }
            i4++;
        }
        if (!z3 || (a4 = a(bVar.f24781a)) == null || a4.size() == 0) {
            return;
        }
        for (int i5 = 0; i5 < a4.size(); i5++) {
            a4.get(i5).a();
        }
    }

    private void a(b bVar, b.a aVar) {
        if (bVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] start mdl preload task fail. item is null");
        } else if (aVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] start mdl preload task fail. track is null");
            notifyPreloadError(bVar.f24783c, -100004);
        } else {
            TTVideoEngineLog.i("DataLoaderHelper", "[preload] start mdl preload task.  key = " + aVar.f24786a);
            String str = aVar.f24786a;
            String[] strArr = aVar.f24788c;
            if (strArr != null) {
                String a4 = a(str, bVar.f24781a, aVar.f24791f, 0L, strArr, aVar.f24789d);
                aVar.f24787b = a4;
                if (!TextUtils.isEmpty(a4)) {
                    TTVideoEngineLog.d("DataLoaderHelper", "allPreloadTasks enqueueItem " + this.f24769d + ", item " + bVar);
                    this.f24769d.a(bVar);
                    if (aVar.f24791f > 0) {
                        long j4 = aVar.f24790e;
                        if (j4 > 0) {
                            this.f24774i.preloadResource(aVar.f24787b, (int) j4);
                        }
                        this.f24774i.preloadResource(aVar.f24787b, (int) aVar.f24791f, (int) aVar.f24792g);
                    } else {
                        this.f24774i.preloadResource(aVar.f24787b, (int) aVar.f24792g);
                    }
                    TTVideoEngineLog.i("DataLoaderHelper", String.format("[preload] exect preload task ,key is %s; videoId = %s", aVar.f24786a, bVar.f24781a));
                    return;
                }
            }
            bVar.a(-100001);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0 A[Catch: Exception -> 0x0182, TryCatch #0 {Exception -> 0x0182, blocks: (B:13:0x0037, B:16:0x0054, B:18:0x006b, B:22:0x0076, B:24:0x007e, B:26:0x0095, B:32:0x00ba, B:34:0x00c0, B:35:0x00c6, B:39:0x00d2, B:41:0x00d8, B:42:0x00dd, B:46:0x00e6, B:50:0x00f8, B:51:0x00fb, B:53:0x0100, B:54:0x0103, B:57:0x010b, B:58:0x016d, B:38:0x00d0, B:27:0x0098, B:29:0x00a0, B:31:0x00b7), top: B:64:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0 A[Catch: Exception -> 0x0182, TryCatch #0 {Exception -> 0x0182, blocks: (B:13:0x0037, B:16:0x0054, B:18:0x006b, B:22:0x0076, B:24:0x007e, B:26:0x0095, B:32:0x00ba, B:34:0x00c0, B:35:0x00c6, B:39:0x00d2, B:41:0x00d8, B:42:0x00dd, B:46:0x00e6, B:50:0x00f8, B:51:0x00fb, B:53:0x0100, B:54:0x0103, B:57:0x010b, B:58:0x016d, B:38:0x00d0, B:27:0x0098, B:29:0x00a0, B:31:0x00b7), top: B:64:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8 A[Catch: Exception -> 0x0182, TryCatch #0 {Exception -> 0x0182, blocks: (B:13:0x0037, B:16:0x0054, B:18:0x006b, B:22:0x0076, B:24:0x007e, B:26:0x0095, B:32:0x00ba, B:34:0x00c0, B:35:0x00c6, B:39:0x00d2, B:41:0x00d8, B:42:0x00dd, B:46:0x00e6, B:50:0x00f8, B:51:0x00fb, B:53:0x0100, B:54:0x0103, B:57:0x010b, B:58:0x016d, B:38:0x00d0, B:27:0x0098, B:29:0x00a0, B:31:0x00b7), top: B:64:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8 A[Catch: Exception -> 0x0182, TryCatch #0 {Exception -> 0x0182, blocks: (B:13:0x0037, B:16:0x0054, B:18:0x006b, B:22:0x0076, B:24:0x007e, B:26:0x0095, B:32:0x00ba, B:34:0x00c0, B:35:0x00c6, B:39:0x00d2, B:41:0x00d8, B:42:0x00dd, B:46:0x00e6, B:50:0x00f8, B:51:0x00fb, B:53:0x0100, B:54:0x0103, B:57:0x010b, B:58:0x016d, B:38:0x00d0, B:27:0x0098, B:29:0x00a0, B:31:0x00b7), top: B:64:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0100 A[Catch: Exception -> 0x0182, TryCatch #0 {Exception -> 0x0182, blocks: (B:13:0x0037, B:16:0x0054, B:18:0x006b, B:22:0x0076, B:24:0x007e, B:26:0x0095, B:32:0x00ba, B:34:0x00c0, B:35:0x00c6, B:39:0x00d2, B:41:0x00d8, B:42:0x00dd, B:46:0x00e6, B:50:0x00f8, B:51:0x00fb, B:53:0x0100, B:54:0x0103, B:57:0x010b, B:58:0x016d, B:38:0x00d0, B:27:0x0098, B:29:0x00a0, B:31:0x00b7), top: B:64:0x0037 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.DataLoaderHelper.a(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo, boolean, boolean):void");
    }

    private void a(String str, String str2, long j4, PreloaderURLItem preloaderURLItem) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] key invalid.");
            notifyPreloadError(preloaderURLItem, -100001);
        } else if (this.f24774i == null || this.f24766a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            notifyPreloadError(preloaderURLItem, -100002);
        } else if (this.f24768c.a(str) || this.f24767b.a(str)) {
            TTVideoEngineLog.d("DataLoaderHelper", "[preload] add the same key task.");
            notifyPreloadError(preloaderURLItem, -100003);
        } else {
            b bVar = new b(this);
            bVar.a(str, j4);
            bVar.f24781a = str2;
            bVar.f24783c = preloaderURLItem;
            this.f24767b.a(bVar);
            a();
        }
    }

    private boolean a(d dVar) {
        TTVideoEngineLog.d("DataLoaderHelper", "cancelTasks");
        boolean z3 = false;
        if (dVar.b() > 0) {
            while (true) {
                b c4 = dVar.c();
                if (c4 == null) {
                    break;
                }
                z3 = true;
                c(c4);
            }
        }
        return z3;
    }

    private String[] a(String[] strArr) {
        if (strArr == null || strArr.length <= 1) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr[0]);
        for (int i4 = 1; i4 < strArr.length; i4++) {
            String str = strArr[i4];
            Boolean bool = Boolean.TRUE;
            int size = arrayList.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                } else if (((String) arrayList.get(size)).equals(str)) {
                    bool = Boolean.FALSE;
                    break;
                } else {
                    size--;
                }
            }
            if (bool.booleanValue()) {
                arrayList.add(str);
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        return strArr2;
    }

    private DataLoaderCacheInfo b(String str) {
        DataLoaderCacheInfo dataLoaderCacheInfo = null;
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length >= 4) {
            dataLoaderCacheInfo = new DataLoaderCacheInfo(this);
            dataLoaderCacheInfo.mLocalFilePath = split[3];
            if (!TextUtils.isEmpty(split[0])) {
                dataLoaderCacheInfo.mCacheSizeFromZero = Long.parseLong(split[0]);
            }
            if (!TextUtils.isEmpty(split[1])) {
                dataLoaderCacheInfo.mMediaSize = Long.parseLong(split[1]);
            }
            TTVideoEngineLog.d("DataLoaderHelper", "get cache info.");
        }
        return dataLoaderCacheInfo;
    }

    private void b(b bVar) {
        if (bVar == null) {
            a();
        } else if (this.f24774i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
        } else {
            this.f24768c.b(bVar);
            long j4 = bVar.f24782b;
            PreloaderURLItem preloaderURLItem = bVar.f24783c;
            if (preloaderURLItem != null && preloaderURLItem.getUrls() != null && bVar.f24783c.getUrls().length > 0) {
                b.a aVar = bVar.f24785e.get(0);
                aVar.f24788c = bVar.f24783c.getUrls();
                aVar.f24792g = bVar.f24782b;
                aVar.f24789d = bVar.f24783c.getFilePath();
                a(bVar, aVar);
            }
            if (bVar.a() != null) {
                PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(6);
                preLoaderItemCallBackInfo.preloadType = 0;
                preLoaderItemCallBackInfo.videoPreloadSize = j4;
                preLoaderItemCallBackInfo.audioPreloadSize = 0L;
                bVar.a().preloadItemInfo(preLoaderItemCallBackInfo);
                TTVideoEngineLog.i("DataLoaderHelper", "[preload] notify info. type = 0");
            }
            a();
        }
    }

    static /* synthetic */ int c() {
        int i4 = f24765s;
        f24765s = i4 + 1;
        return i4;
    }

    private void c(b bVar) {
        String str;
        if (bVar == null) {
            str = "_notifyPreloadCancel taskItem is null";
        } else if (!bVar.f24784d) {
            bVar.f24784d = true;
            if (bVar.a() == null) {
                TTVideoEngineLog.d("DataLoaderHelper", "_notifyPreloadCancel getCallBackListener is null");
                return;
            }
            f24765s++;
            TTVideoEngineLog.d("DataLoaderHelper", "preloadCount engine callback " + f24765s + ", KEY_IS_PRELOAD_END_CANCEL");
            bVar.a().preloadItemInfo(new PreLoaderItemCallBackInfo(5));
            return;
        } else {
            str = "_notifyPreloadCancel didCanceled";
        }
        TTVideoEngineLog.d("DataLoaderHelper", str);
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.startsWith("http://127.0.0.1") || lowerCase.startsWith("http://localhost") || lowerCase.startsWith(MDL_PREFIX) || lowerCase.startsWith("file://") || lowerCase.startsWith(TTPathConst.sSeparator) || lowerCase.endsWith(".mpd") || lowerCase.contains(".mpd?")) ? false : true;
    }

    private boolean d() {
        if (this.f24774i != null) {
            return true;
        }
        if (AVMDLDataLoader.init(false, false) != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "library has not been loaded");
            return false;
        }
        try {
            AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
            this.f24774i = aVMDLDataLoader;
            aVMDLDataLoader.setConfigure(this.f24775j);
            this.f24774i.setListener(this);
            this.f24774i.setStartCompleteListener(this);
            return true;
        } catch (Exception e4) {
            TTVideoEngineLog.d(e4);
            return false;
        }
    }

    public static String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String encodeUrlByQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        TTVideoEngineLog.d("TTHelperEncode", "before encode:" + str);
        try {
            String queryComponentEncode = AVMDLDataLoader.queryComponentEncode(str);
            if (TextUtils.isEmpty(queryComponentEncode)) {
                TTVideoEngineLog.d("TTHelperEncode", "call native encode fail,try java");
                queryComponentEncode = URLEncoder.encode(str, "UTF-8");
            }
            TTVideoEngineLog.d("TTHelperEncode", "after encode:" + queryComponentEncode);
            return queryComponentEncode;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static DataLoaderHelper getDataLoader() {
        return f24762p;
    }

    public void _addEngine(TTVideoEngine tTVideoEngine, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f24773h.lock();
            ArrayList<TTVideoEngine> arrayList = this.f24772g.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f24772g.put(str, arrayList);
            }
            if (!arrayList.contains(tTVideoEngine)) {
                arrayList.add(tTVideoEngine);
                TTVideoEngineLog.i("DataLoaderHelper", "add engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
            }
        } finally {
            this.f24773h.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00e5 A[Catch: all -> 0x0133, TryCatch #0 {all -> 0x0133, blocks: (B:24:0x004b, B:26:0x0057, B:30:0x0071, B:34:0x0081, B:37:0x00ad, B:40:0x00b2, B:42:0x00d3, B:44:0x00e5, B:45:0x00f1, B:41:0x00c3), top: B:57:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String _proxyUrl(java.lang.String r18, java.lang.String r19, long r20, java.lang.String[] r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.DataLoaderHelper._proxyUrl(java.lang.String, java.lang.String, long, java.lang.String[], java.lang.String):java.lang.String");
    }

    public void _removeEngine(TTVideoEngine tTVideoEngine, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f24773h.lock();
            ArrayList<TTVideoEngine> arrayList = this.f24772g.get(str);
            if (arrayList != null) {
                arrayList.remove(tTVideoEngine);
                TTVideoEngineLog.i("DataLoaderHelper", "remove engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
                if (arrayList.size() == 0) {
                    this.f24772g.remove(str);
                }
            }
        } finally {
            this.f24773h.unlock();
        }
    }

    public void _removePlayTask(String str) {
        this.f24770e.c(str);
    }

    public void addTask(PreloaderURLItem preloaderURLItem) {
        f24763q++;
        TTVideoEngineLog.d("DataLoaderHelper", "preloadCount addTask " + f24763q);
        if (preloaderURLItem == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] url item invalid");
            return;
        }
        this.f24780o.lock();
        try {
            a(preloaderURLItem.getKey(), preloaderURLItem.getVideoId(), preloaderURLItem.getPreloadSize(), preloaderURLItem);
        } finally {
            this.f24780o.unlock();
        }
    }

    public void cancelAllTasks() {
        if (this.f24774i == null || this.f24766a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.f24780o.lock();
        try {
            cancelAllTasksInternal();
        } finally {
            try {
            } finally {
            }
        }
    }

    public void cancelAllTasksInternal() {
        TTVideoEngineLog.d("DataLoaderHelper", "cancelAllTasksInternal");
        a(this.f24768c);
        a(this.f24767b);
        if (a(this.f24769d)) {
            this.f24774i.cancelAll();
        }
    }

    public void cancelTask(String str) {
        b c4;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f24774i == null || this.f24766a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.f24780o.lock();
        try {
            c4 = this.f24767b.c(str);
        } finally {
            try {
            } finally {
            }
        }
        if (c4 == null && (c4 = this.f24768c.c(str)) == null) {
            c4 = this.f24769d.c(str);
            if (c4 != null) {
                this.f24774i.cancel(str);
            }
            TTVideoEngineLog.i("DataLoaderHelper", "[preload] cancel preload task. key = " + str);
        }
        c(c4);
        TTVideoEngineLog.i("DataLoaderHelper", "[preload] cancel preload task. key = " + str);
    }

    public void clearAllCaches() {
        AVMDLDataLoader aVMDLDataLoader;
        if (this.f24766a != 0) {
            return;
        }
        this.f24780o.lock();
        try {
            aVMDLDataLoader = this.f24774i;
        } finally {
            try {
            } finally {
            }
        }
        if (aVMDLDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
        } else {
            aVMDLDataLoader.clearAllCaches();
        }
    }

    public void close() {
        this.f24780o.lock();
        try {
            if (this.f24766a == 1) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader not started, not need close");
            } else {
                this.f24774i.close();
                cancelAllTasksInternal();
                this.f24766a = 1;
            }
        } finally {
            this.f24780o.unlock();
        }
    }

    public DataLoaderCacheInfo getCacheInfoByFilePath(String str, String str2) {
        this.f24780o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.f24774i;
            if (aVMDLDataLoader != null) {
                return b(aVMDLDataLoader.getStringCacheInfo(str, str2));
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    public long getCacheSize(String str) {
        long j4 = 0;
        if (this.f24766a != 0) {
            return 0L;
        }
        this.f24780o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.f24774i;
            if (aVMDLDataLoader != null) {
                long cacheSize = aVMDLDataLoader.getCacheSize(str);
                if (cacheSize > 0) {
                    j4 = cacheSize;
                }
            }
        } finally {
            try {
                return j4;
            } finally {
            }
        }
        return j4;
    }

    public long getCacheSizeByFilePath(String str, String str2) {
        TTVideoEngineLog.d("DataLoaderHelper", "getCacheSizeByFilePath key:" + str + ", filePath:" + str2);
        this.f24780o.lock();
        try {
            DataLoaderCacheInfo cacheInfoByFilePath = getCacheInfoByFilePath(str, str2);
            long j4 = cacheInfoByFilePath != null ? cacheInfoByFilePath.mCacheSizeFromZero : 0L;
            TTVideoEngineLog.d("DataLoaderHelper", "getCacheSizeByFilePath result:" + j4);
            return j4;
        } catch (Throwable th) {
            try {
                TTVideoEngineLog.d(th);
                return 0L;
            } finally {
                this.f24780o.unlock();
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getCheckSumInfo(String str) {
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public long getInt64Value(int i4, long j4) {
        return 0L;
    }

    public c getLoadProgressByRawKey(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] get, param is invalid key is null");
            return null;
        }
        return this.f24771f.get(str);
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getStringValue(int i4, long j4, String str) {
        return null;
    }

    public void notifyPreloadError(PreloaderURLItem preloaderURLItem, int i4) {
        TTVideoEngineLog.d("DataLoaderHelper", "notifyPreloadError " + i4);
        IPreLoaderItemCallBackListener callBackListener = preloaderURLItem.getCallBackListener();
        if (callBackListener != null) {
            f24765s++;
            TTVideoEngineLog.d("DataLoaderHelper", "preloadCount engine callback " + f24765s + ", KEY_IS_PRELOAD_END_FAIL");
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
            preLoaderItemCallBackInfo.preloadError = new Error(Error.DataLoaderPreload, i4);
            callBackListener.preloadItemInfo(preLoaderItemCallBackInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02c4  */
    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onNotify(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo r17) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.DataLoaderHelper.onNotify(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo):void");
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLStartCompleteListener
    public void onStartComplete() {
        TTVideoEngineLog.d("DataLoaderHelper", "MediaDataLoader start complete");
    }

    public void putByRawKey(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] param is invalid");
        } else {
            this.f24771f.put(str, cVar);
        }
    }

    public void removeCacheFile(String str, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f24780o.lock();
        try {
            if (this.f24774i == null) {
                TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            } else {
                TTVideoEngineLog.i("DataLoaderHelper", "remove mdl file. key " + str);
                if (z3) {
                    this.f24774i.forceRemoveFileCache(str);
                } else {
                    this.f24774i.removeFileCache(str);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void removeLoadProgressByRawKey(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] remove, param is invalid key is null");
        } else {
            this.f24771f.remove(str);
        }
    }

    public void setCacheInfoLists(String[] strArr, long[] jArr) {
        TTVideoEngineLog.d("DataLoaderHelper", "setCacheInfoLists dirs:" + Arrays.toString(strArr) + ", maxCaches " + Arrays.toString(jArr));
        this.f24780o.lock();
        try {
            this.f24775j.setCacheInfoList(strArr, jArr);
        } finally {
            this.f24780o.unlock();
        }
    }

    public void setContext(Context context) {
        this.f24780o.lock();
        this.f24780o.unlock();
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader videoEventEngineUploader) {
        TTVideoEngineLog.d("DataLoaderHelper", "setEngineUploader " + videoEventEngineUploader);
        this.f24776k = videoEventEngineUploader;
    }

    public void setIntValue(int i4, int i5) {
        this.f24780o.lock();
        TTVideoEngineLog.d("DataLoaderHelper", "setIntValue key = " + i4 + ", value = " + i5);
        try {
            try {
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (i4 == 11) {
                this.f24775j.mPreloadParallelNum = i5;
                AVMDLDataLoader aVMDLDataLoader = this.f24774i;
                if (aVMDLDataLoader != null) {
                    aVMDLDataLoader.setIntValue(102, i5);
                }
            } else if (i4 != 512) {
                boolean z3 = true;
                if (i4 == 1005) {
                    if (i5 != 1) {
                        z3 = false;
                    }
                    this.f24778m = z3;
                    TTVideoEngineLog.i("DataLoaderHelper", "config DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE: " + this.f24778m);
                } else if (i4 == 1) {
                    this.f24775j.mMaxCacheSize = i5;
                } else if (i4 == 2) {
                    this.f24775j.mRWTimeOut = i5;
                } else if (i4 != 3) {
                    if (i4 == 4) {
                        this.f24775j.mTryCount = i5;
                    }
                } else {
                    this.f24775j.mOpenTimeOut = i5;
                }
            } else {
                this.f24775j.mAlogEnable = i5;
                AVMDLDataLoader aVMDLDataLoader2 = this.f24774i;
                if (aVMDLDataLoader2 != null) {
                    aVMDLDataLoader2.setIntValue(AVMDLDataLoader.KeyIsAlogEnable, i5);
                }
            }
        } finally {
            this.f24780o.unlock();
        }
    }

    public void setStringValue(int i4, String str) {
        TTVideoEngineLog.d("DataLoaderHelper", "setStringValue key = " + i4 + ", value = " + str);
        this.f24780o.lock();
        if (i4 == 0) {
            try {
                try {
                    this.f24775j.mCacheDir = str;
                } catch (Exception e4) {
                    TTVideoEngineLog.d(e4);
                }
            } finally {
                this.f24780o.unlock();
            }
        }
    }

    public void start() {
        TTVideoEngineLog.d("DataLoaderHelper", CampaignEx.JSON_NATIVE_VIDEO_START);
        this.f24780o.lock();
        try {
            if (this.f24766a == 0) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader has started not need start");
            } else if (!d()) {
                throw new Exception("init data loader fail");
            } else {
                this.f24768c.a(4L);
                if (this.f24775j == null) {
                    this.f24775j = AVMDLDataLoaderConfigure.getDefaultonfigure();
                }
                if (this.f24776k != null) {
                    this.f24775j.mEnableReportTaskLog = 1;
                }
                this.f24774i.setConfigure(this.f24775j);
                if (this.f24774i.start() < 0) {
                    throw new Exception("start data loader fail");
                }
                long longValue = this.f24774i.getLongValue(AVMDLDataLoader.KeyIsGetMdlProtocolHandle);
                if (longValue == -1) {
                    this.f24777l = true;
                }
                this.f24766a = 0;
                TTVideoEngineLog.d("DataLoaderHelper", "DataLoader start mdlProtocolHandle:" + longValue);
            }
        } finally {
            this.f24780o.unlock();
        }
    }
}
