package com.mbridge.msdk.foundation.download.resource;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.core.ExecutorManager;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.download.resource.stream.FileDownloadRandomAccessDownloadFile;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.UnzipUtility;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MBResourceManager {
    private static volatile MBResourceManager MBResourceManager;

    private MBResourceManager() {
    }

    public static MBResourceManager getInstance() {
        if (MBResourceManager == null) {
            synchronized (MBResourceManager.class) {
                if (MBResourceManager == null) {
                    MBResourceManager = new MBResourceManager();
                }
            }
        }
        return MBResourceManager;
    }

    public void deleteFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        for (File file2 : file.listFiles()) {
            deleteFile(new File(file2.getAbsolutePath()));
        }
        file.delete();
    }

    public void executeResourceStrategy(final ResourceConfig resourceConfig) {
        final Queue<ResourceStrategy> resourceStrategyQueue;
        if (resourceConfig == null || resourceConfig.getResourceStrategyQueue() == null || resourceConfig.getResourceStrategyQueue().isEmpty() || (resourceStrategyQueue = resourceConfig.getResourceStrategyQueue()) == null || resourceStrategyQueue.isEmpty()) {
            return;
        }
        ILogger logger = GlobalComponent.getInstance().getLogger();
        logger.log("ResourceStrategy", "\u914d\u7f6e\u7684\u8d44\u6e90\u7ba1\u7406\u7b56\u7565\u6570\u91cf\uff1a " + resourceStrategyQueue.size());
        ExecutorManager.getInstance().getExecutorSupplier().getLruCacheThreadTasks().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.download.resource.MBResourceManager.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    ResourceStrategy resourceStrategy = (ResourceStrategy) resourceStrategyQueue.poll();
                    if (resourceStrategy == null) {
                        return;
                    }
                    ResourceStrategyExecutor resourceStrategyExecutor = new ResourceStrategyExecutor(resourceStrategy);
                    ILogger logger2 = GlobalComponent.getInstance().getLogger();
                    logger2.log("ResourceStrategy", "\u6267\u884c\u7b56\u7565\uff1a " + resourceStrategyExecutor.getResourceStrategyName());
                    MBResourceManager unused = MBResourceManager.MBResourceManager;
                    resourceStrategyExecutor.processResource(MBResourceManager.getInstance(), GlobalComponent.getInstance().getDatabaseHelper(), resourceConfig);
                }
            }
        });
    }

    public DownloadFileOutputStream getDownloadFileOutputStream(File file) throws IOException {
        if (file != null) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            return new FileDownloadRandomAccessDownloadFile(file);
        }
        throw new IOException("file is null");
    }

    public String getDownloadId(String str) {
        try {
            try {
                new URL(str);
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
                return "";
            }
        } catch (MalformedURLException unused2) {
            str = null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes("UTF-8"));
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }

    public long getFileSize(File file, String str, String str2) {
        if (Objects.exists(file, str, str2)) {
            try {
                return file.length();
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    public void unZip(String str, String str2) throws IOException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            new UnzipUtility().unzip(str, str2);
            return;
        }
        throw new IOException("zipFilePath or destDirectory is null");
    }

    public void deleteFile(String str) {
        deleteFile(new File(str));
    }
}
