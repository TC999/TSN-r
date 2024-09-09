package xyz.adscope.common.network.simple;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.Callable;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.exception.NoCacheError;
import xyz.adscope.common.network.exception.ParseError;
import xyz.adscope.common.network.simple.SimpleRequest;
import xyz.adscope.common.network.simple.cache.Cache;
import xyz.adscope.common.network.simple.cache.CacheMode;
import xyz.adscope.common.network.simple.cache.CacheStore;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
abstract class BasicWorker<T extends SimpleRequest, Succeed, Failed> implements Callable<SimpleResponse<Succeed, Failed>> {

    /* renamed from: f  reason: collision with root package name */
    public static final long f64967f = System.currentTimeMillis() + 3153600000000L;

    /* renamed from: a  reason: collision with root package name */
    public final T f64968a;

    /* renamed from: b  reason: collision with root package name */
    public final CacheStore f64969b = Kalle.getConfig().getCacheStore();

    /* renamed from: c  reason: collision with root package name */
    public final Converter f64970c;

    /* renamed from: d  reason: collision with root package name */
    public final Type f64971d;

    /* renamed from: e  reason: collision with root package name */
    public final Type f64972e;

    /* renamed from: xyz.adscope.common.network.simple.BasicWorker$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64973a;

        static {
            int[] iArr = new int[CacheMode.values().length];
            f64973a = iArr;
            try {
                iArr[CacheMode.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64973a[CacheMode.HTTP_YES_THEN_WRITE_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f64973a[CacheMode.NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f64973a[CacheMode.NETWORK_YES_THEN_HTTP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f64973a[CacheMode.NETWORK_YES_THEN_WRITE_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f64973a[CacheMode.NETWORK_NO_THEN_READ_CACHE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f64973a[CacheMode.READ_CACHE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f64973a[CacheMode.READ_CACHE_NO_THEN_NETWORK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f64973a[CacheMode.READ_CACHE_NO_THEN_HTTP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public BasicWorker(T t3, Type type, Type type2) {
        this.f64968a = t3;
        this.f64971d = type;
        this.f64972e = type2;
        this.f64970c = t3.converter() == null ? Kalle.getConfig().getConverter() : t3.converter();
    }

    public final Response a(int i4) {
        Cache cache;
        Cache cache2;
        int i5 = AnonymousClass1.f64973a[this.f64968a.cacheMode().ordinal()];
        if (i5 == 1 || i5 == 2) {
            if (i4 != 304 || (cache = this.f64969b.get(this.f64968a.cacheKey())) == null) {
                return null;
            }
            return a(cache.getCode(), cache.getHeaders(), cache.getBody());
        } else if (i5 == 6) {
            Cache cache3 = this.f64969b.get(this.f64968a.cacheKey());
            if (cache3 != null) {
                return a(cache3.getCode(), cache3.getHeaders(), cache3.getBody());
            }
            return null;
        } else if (i5 == 9 && i4 == 304 && (cache2 = this.f64969b.get(this.f64968a.cacheKey())) != null) {
            return a(cache2.getCode(), cache2.getHeaders(), cache2.getBody());
        } else {
            return null;
        }
    }

    public final Response a(int i4, Headers headers, byte[] bArr) {
        return Response.newBuilder().code(i4).headers(headers).body(new ByteArrayBody(headers.getContentType(), bArr)).build();
    }

    public final Response a(int i4, Headers headers, byte[] bArr, String str) {
        return Response.newBuilder().code(i4).headers(headers).body(new ByteArrayBody(headers.getContentType(), bArr)).locationUrl(str).build();
    }

    public abstract Response a(T t3);

    public final SimpleResponse<Succeed, Failed> a(Response response, boolean z3) {
        try {
            return this.f64970c.convert(this.f64971d, this.f64972e, response, z3);
        } catch (IOException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new ParseError("An exception occurred while parsing the data.", e5);
        }
    }

    public final void a() {
        Cache cache;
        int i4 = AnonymousClass1.f64973a[this.f64968a.cacheMode().ordinal()];
        if ((i4 == 1 || i4 == 2) && (cache = this.f64969b.get(this.f64968a.cacheKey())) != null) {
            a(cache.getHeaders());
        }
    }

    public final void a(int i4, Headers headers, byte[] bArr, long j4) {
        String cacheKey = this.f64968a.cacheKey();
        Cache cache = new Cache();
        cache.setKey(cacheKey);
        cache.setCode(i4);
        cache.setHeaders(headers);
        cache.setBody(bArr);
        cache.setExpires(j4);
        this.f64969b.replace(cacheKey, cache);
    }

    public final void a(Headers headers) {
        Headers headers2 = this.f64968a.headers();
        String eTag = headers.getETag();
        if (eTag != null) {
            headers2.set("If-None-Match", eTag);
        }
        long lastModified = headers.getLastModified();
        if (lastModified > 0) {
            headers2.set("If-Modified-Since", Headers.formatMillisToGMT(lastModified));
        }
    }

    public final Response b() {
        Cache cache;
        int i4 = AnonymousClass1.f64973a[this.f64968a.cacheMode().ordinal()];
        if (i4 == 1) {
            Cache cache2 = this.f64969b.get(this.f64968a.cacheKey());
            if (cache2 != null && cache2.getExpires() > System.currentTimeMillis()) {
                return a(cache2.getCode(), cache2.getHeaders(), cache2.getBody());
            }
        } else if (i4 == 7) {
            Cache cache3 = this.f64969b.get(this.f64968a.cacheKey());
            if (cache3 != null) {
                return a(cache3.getCode(), cache3.getHeaders(), cache3.getBody());
            }
            throw new NoCacheError("No cache found.");
        } else if ((i4 == 8 || i4 == 9) && (cache = this.f64969b.get(this.f64968a.cacheKey())) != null) {
            return a(cache.getCode(), cache.getHeaders(), cache.getBody());
        }
        return null;
    }

    public final void b(int i4, Headers headers, byte[] bArr) {
        int i5 = AnonymousClass1.f64973a[this.f64968a.cacheMode().ordinal()];
        if (i5 == 1) {
            long analysisCacheExpires = Headers.analysisCacheExpires(headers);
            if (analysisCacheExpires > 0 || headers.getLastModified() > 0) {
                a(i4, headers, bArr, analysisCacheExpires);
            }
        } else if (i5 == 2) {
            a(i4, headers, bArr, f64967f);
        } else if (i5 == 4) {
            long analysisCacheExpires2 = Headers.analysisCacheExpires(headers);
            if (analysisCacheExpires2 > 0 || headers.getLastModified() > 0) {
                a(i4, headers, bArr, analysisCacheExpires2);
            }
        } else if (i5 == 5) {
            a(i4, headers, bArr, f64967f);
        } else if (i5 != 9) {
        } else {
            long analysisCacheExpires3 = Headers.analysisCacheExpires(headers);
            if (analysisCacheExpires3 > 0 || headers.getLastModified() > 0) {
                a(i4, headers, bArr, analysisCacheExpires3);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public final SimpleResponse<Succeed, Failed> call() {
        Response b4 = b();
        if (b4 != null) {
            return a(b4, true);
        }
        a();
        try {
            try {
                Response a4 = a((BasicWorker<T, Succeed, Failed>) this.f64968a);
                int code = a4.code();
                if (code == 304) {
                    Response a5 = a(-1);
                    if (a5 != null) {
                        SimpleResponse<Succeed, Failed> a6 = a(a5, true);
                        IOUtils.closeQuietly(a4);
                        return a6;
                    }
                    SimpleResponse<Succeed, Failed> a7 = a(a4, false);
                    IOUtils.closeQuietly(a4);
                    return a7;
                }
                Headers headers = a4.headers();
                byte[] bArr = new byte[0];
                if (code != 204 && code != 302) {
                    bArr = a4.body().byteArray();
                }
                String locationUrl = a4.locationUrl();
                IOUtils.closeQuietly(a4);
                b(code, headers, bArr);
                Response a8 = a(code, headers, bArr, locationUrl);
                SimpleResponse<Succeed, Failed> a9 = a(a8, false);
                IOUtils.closeQuietly(a8);
                return a9;
            } catch (IOException e4) {
                Response a10 = a(-1);
                if (a10 != null) {
                    SimpleResponse<Succeed, Failed> a11 = a(a10, true);
                    IOUtils.closeQuietly(b4);
                    return a11;
                }
                throw e4;
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(b4);
            throw th;
        }
    }

    public abstract void cancel();
}
