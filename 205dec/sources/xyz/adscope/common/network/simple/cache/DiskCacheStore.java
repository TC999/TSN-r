package xyz.adscope.common.network.simple.cache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.secure.Encryption;
import xyz.adscope.common.network.secure.Secret;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DiskCacheStore implements CacheStore {

    /* renamed from: a  reason: collision with root package name */
    public Secret f65024a;

    /* renamed from: b  reason: collision with root package name */
    public String f65025b;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f65026a;

        /* renamed from: b  reason: collision with root package name */
        public String f65027b;

        public Builder(String str) {
            this.f65026a = str;
        }

        public DiskCacheStore build() {
            return new DiskCacheStore(this);
        }

        public Builder password(String str) {
            this.f65027b = str;
            return this;
        }
    }

    public DiskCacheStore(Builder builder) {
        this.f65025b = builder.f65026a;
        this.f65024a = Encryption.createSecret(TextUtils.isEmpty(builder.f65027b) ? this.f65025b : builder.f65027b);
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public final String a(String str) {
        return this.f65024a.decrypt(str);
    }

    public final String b(String str) {
        return this.f65024a.encrypt(str);
    }

    public final String c(String str) {
        return Encryption.getMD5ForString(this.f65025b + str);
    }

    @Override // xyz.adscope.common.network.simple.cache.CacheStore
    public boolean clear() {
        return IOUtils.delFileOrFolder(this.f65025b);
    }

    @Override // xyz.adscope.common.network.simple.cache.CacheStore
    public Cache get(String str) {
        BufferedReader bufferedReader;
        String c4 = c(str);
        BufferedReader bufferedReader2 = null;
        try {
            File file = new File(this.f65025b, c4);
            if (file.exists() && !file.isDirectory()) {
                Cache cache = new Cache();
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    cache.setCode(Integer.parseInt(a(bufferedReader.readLine())));
                    cache.setHeaders(Headers.fromJSONString(a(bufferedReader.readLine())));
                    cache.setBody(Encryption.hexToByteArray(a(bufferedReader.readLine())));
                    cache.setExpires(Long.parseLong(a(bufferedReader.readLine())));
                    IOUtils.closeQuietly(bufferedReader);
                    return cache;
                } catch (Exception unused) {
                    try {
                        IOUtils.delFileOrFolder(new File(this.f65025b, c4));
                        IOUtils.closeQuietly(bufferedReader);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        bufferedReader = bufferedReader2;
                        IOUtils.closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly(bufferedReader);
                    throw th;
                }
            }
            IOUtils.closeQuietly(null);
            return null;
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = bufferedReader2;
            IOUtils.closeQuietly(bufferedReader);
            throw th;
        }
    }

    @Override // xyz.adscope.common.network.simple.cache.CacheStore
    public boolean remove(String str) {
        return IOUtils.delFileOrFolder(new File(this.f65025b, c(str)));
    }

    @Override // xyz.adscope.common.network.simple.cache.CacheStore
    public boolean replace(String str, Cache cache) {
        String c4 = c(str);
        BufferedWriter bufferedWriter = null;
        try {
            if (!TextUtils.isEmpty(c4) && cache != null) {
                if (IOUtils.createFolder(this.f65025b)) {
                    File file = new File(this.f65025b, c4);
                    if (IOUtils.createNewFile(file)) {
                        bufferedWriter = IOUtils.toBufferedWriter(new FileWriter(file));
                        bufferedWriter.write(b(Integer.toString(cache.getCode())));
                        bufferedWriter.newLine();
                        bufferedWriter.write(b(Headers.toJSONString(cache.getHeaders())));
                        bufferedWriter.newLine();
                        bufferedWriter.write(b(Encryption.byteArrayToHex(cache.getBody())));
                        bufferedWriter.newLine();
                        bufferedWriter.write(b(Long.toString(cache.getExpires())));
                        bufferedWriter.flush();
                        IOUtils.closeQuietly(bufferedWriter);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            IOUtils.delFileOrFolder(new File(this.f65025b, c4));
            return false;
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
        }
    }
}
