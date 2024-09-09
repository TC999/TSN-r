package com.kwad.sdk.core.imageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.FlushedInputStream;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecoder;
import com.kwad.sdk.core.imageloader.core.download.ConnectionConfig;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.core.process.BitmapProcessor;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.core.imageloader.utils.MemoryCacheUtils;
import com.stub.StubApp;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ImageLoaderConfiguration {
    final boolean customExecutor;
    final boolean customExecutorForCachedImages;
    final ImageDecoder decoder;
    final DisplayImageOptions defaultDisplayImageOptions;
    final DiskCache diskCache;
    final ImageDownloader downloader;
    final int maxImageHeightForDiskCache;
    final int maxImageHeightForMemoryCache;
    final int maxImageWidthForDiskCache;
    final int maxImageWidthForMemoryCache;
    final MemoryCache memoryCache;
    final ImageDownloader networkDeniedDownloader;
    final BitmapProcessor processorForDiskCache;
    final Resources resources;
    final ImageDownloader slowNetworkDownloader;
    final Executor taskDistributor;
    final Executor taskExecutor;
    final Executor taskExecutorForCachedImages;
    final QueueProcessingType tasksProcessingType;
    final int threadPoolSize;
    final int threadPriority;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class Builder {
        public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
        public static final int DEFAULT_THREAD_POOL_SIZE = 3;
        public static final int DEFAULT_THREAD_PRIORITY = 3;
        private static final String WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
        private static final String WARNING_OVERLAP_DISK_CACHE_PARAMS = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
        private static final String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
        private static final String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
        private String cacheParentDir;
        private ConnectionConfig connectionConfig;
        private Context context;
        private ImageDecoder decoder;
        private int maxImageWidthForMemoryCache = 0;
        private int maxImageHeightForMemoryCache = 0;
        private int maxImageWidthForDiskCache = 0;
        private int maxImageHeightForDiskCache = 0;
        private BitmapProcessor processorForDiskCache = null;
        private Executor taskExecutor = null;
        private Executor taskExecutorForCachedImages = null;
        private Executor taskDistributor = null;
        private boolean customExecutor = false;
        private boolean customExecutorForCachedImages = false;
        private int threadPoolSize = 3;
        private int threadPriority = 3;
        private boolean denyCacheImageMultipleSizesInMemory = false;
        private QueueProcessingType tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
        private int memoryCacheSize = 0;
        private long diskCacheSize = 0;
        private int diskCacheFileCount = 0;
        private MemoryCache memoryCache = null;
        private DiskCache diskCache = null;
        private FileNameGenerator diskCacheFileNameGenerator = null;
        private ImageDownloader downloader = null;
        private DisplayImageOptions defaultDisplayImageOptions = null;
        private boolean writeLogs = false;

        public Builder(Context context) {
            this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }

        private void initEmptyFieldsWithDefaultValues() {
            if (this.taskExecutor == null) {
                this.taskExecutor = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutor = true;
            }
            if (this.taskExecutorForCachedImages == null) {
                this.taskExecutorForCachedImages = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutorForCachedImages = true;
            }
            if (this.taskDistributor == null) {
                this.taskDistributor = DefaultConfigurationFactory.createTaskDistributor();
            }
            if (this.diskCache == null) {
                if (this.diskCacheFileNameGenerator == null) {
                    this.diskCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
                }
                if (this.cacheParentDir == null) {
                    this.cacheParentDir = this.context.getExternalCacheDir().getPath();
                }
                this.diskCache = DefaultConfigurationFactory.createDiskCache(this.context, this.diskCacheFileNameGenerator, this.diskCacheSize, this.diskCacheFileCount, this.cacheParentDir);
            }
            if (this.memoryCache == null) {
                this.memoryCache = DefaultConfigurationFactory.createMemoryCache(this.context, this.memoryCacheSize);
            }
            if (this.denyCacheImageMultipleSizesInMemory) {
                this.memoryCache = new FuzzyKeyMemoryCache(this.memoryCache, MemoryCacheUtils.createFuzzyKeyComparator());
            }
            if (this.downloader == null) {
                this.downloader = DefaultConfigurationFactory.createImageDownloader(this.context);
            }
            if (this.decoder == null) {
                this.decoder = DefaultConfigurationFactory.createImageDecoder(this.writeLogs);
            }
            if (this.defaultDisplayImageOptions == null) {
                this.defaultDisplayImageOptions = DisplayImageOptions.createSimple();
            }
        }

        public ImageLoaderConfiguration build() {
            initEmptyFieldsWithDefaultValues();
            return new ImageLoaderConfiguration(this, null);
        }

        public Builder cacheParentDir(String str) {
            this.cacheParentDir = str;
            return this;
        }

        public Builder connectionConfig(ConnectionConfig connectionConfig) {
            this.connectionConfig = connectionConfig;
            return this;
        }

        public Builder defaultDisplayImageOptions(DisplayImageOptions displayImageOptions) {
            this.defaultDisplayImageOptions = displayImageOptions;
            return this;
        }

        public Builder denyCacheImageMultipleSizesInMemory() {
            this.denyCacheImageMultipleSizesInMemory = true;
            return this;
        }

        @Deprecated
        public Builder discCache(DiskCache diskCache) {
            return diskCache(diskCache);
        }

        @Deprecated
        public Builder discCacheExtraOptions(int i4, int i5, BitmapProcessor bitmapProcessor) {
            return diskCacheExtraOptions(i4, i5, bitmapProcessor);
        }

        @Deprecated
        public Builder discCacheFileCount(int i4) {
            return diskCacheFileCount(i4);
        }

        @Deprecated
        public Builder discCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            return diskCacheFileNameGenerator(fileNameGenerator);
        }

        @Deprecated
        public Builder discCacheSize(int i4) {
            return diskCacheSize(i4);
        }

        public Builder diskCache(DiskCache diskCache) {
            if (this.diskCacheSize > 0 || this.diskCacheFileCount > 0) {
                L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
            }
            if (this.diskCacheFileNameGenerator != null) {
                L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            this.diskCache = diskCache;
            return this;
        }

        public Builder diskCacheExtraOptions(int i4, int i5, BitmapProcessor bitmapProcessor) {
            this.maxImageWidthForDiskCache = i4;
            this.maxImageHeightForDiskCache = i5;
            this.processorForDiskCache = bitmapProcessor;
            return this;
        }

        public Builder diskCacheFileCount(int i4) {
            if (i4 > 0) {
                if (this.diskCache != null) {
                    L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
                }
                this.diskCacheFileCount = i4;
                return this;
            }
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }

        public Builder diskCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            if (this.diskCache != null) {
                L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            this.diskCacheFileNameGenerator = fileNameGenerator;
            return this;
        }

        public Builder diskCacheSize(int i4) {
            if (i4 > 0) {
                if (this.diskCache != null) {
                    L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
                }
                this.diskCacheSize = i4;
                return this;
            }
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }

        public Builder imageDecoder(ImageDecoder imageDecoder) {
            this.decoder = imageDecoder;
            return this;
        }

        public Builder imageDownloader(ImageDownloader imageDownloader) {
            this.downloader = imageDownloader;
            return this;
        }

        public Builder memoryCache(MemoryCache memoryCache) {
            if (this.memoryCacheSize != 0) {
                L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
            }
            this.memoryCache = memoryCache;
            return this;
        }

        public Builder memoryCacheExtraOptions(int i4, int i5) {
            this.maxImageWidthForMemoryCache = i4;
            this.maxImageHeightForMemoryCache = i5;
            return this;
        }

        public Builder memoryCacheSize(int i4) {
            if (i4 > 0) {
                if (this.memoryCache != null) {
                    L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
                }
                this.memoryCacheSize = i4;
                return this;
            }
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }

        public Builder memoryCacheSizePercentage(int i4) {
            if (i4 > 0 && i4 < 100) {
                if (this.memoryCache != null) {
                    L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
                }
                this.memoryCacheSize = (int) (((float) Runtime.getRuntime().maxMemory()) * (i4 / 100.0f));
                return this;
            }
            throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
        }

        public Builder setTaskDistributor(Executor executor) {
            this.taskDistributor = executor;
            return this;
        }

        public Builder taskExecutor(Executor executor) {
            if (this.threadPoolSize != 3 || this.threadPriority != 3 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.taskExecutor = executor;
            return this;
        }

        public Builder taskExecutorForCachedImages(Executor executor) {
            if (this.threadPoolSize != 3 || this.threadPriority != 3 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.taskExecutorForCachedImages = executor;
            return this;
        }

        public Builder tasksProcessingOrder(QueueProcessingType queueProcessingType) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.tasksProcessingType = queueProcessingType;
            return this;
        }

        public Builder threadPoolSize(int i4) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.threadPoolSize = i4;
            return this;
        }

        public Builder threadPriority(int i4) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            if (i4 <= 0) {
                this.threadPriority = 1;
            } else if (i4 > 10) {
                this.threadPriority = 10;
            } else {
                this.threadPriority = i4;
            }
            return this;
        }

        public Builder writeDebugLogs() {
            this.writeLogs = true;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class NetworkDeniedImageDownloader implements ImageDownloader {
        private final ImageDownloader wrappedDownloader;

        public NetworkDeniedImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        @Override // com.kwad.sdk.core.imageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) {
            int i4 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i4 != 1 && i4 != 2) {
                return this.wrappedDownloader.getStream(str, obj);
            }
            throw new IllegalStateException();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class SlowNetworkImageDownloader implements ImageDownloader {
        private final ImageDownloader wrappedDownloader;

        public SlowNetworkImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        @Override // com.kwad.sdk.core.imageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) {
            InputStream stream = this.wrappedDownloader.getStream(str, obj);
            int i4 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()];
            return (i4 == 1 || i4 == 2) ? new FlushedInputStream(stream) : stream;
        }
    }

    /* synthetic */ ImageLoaderConfiguration(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static ImageLoaderConfiguration createDefault(Context context) {
        return new Builder(context).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImageSize getMaxImageSize() {
        DisplayMetrics displayMetrics = this.resources.getDisplayMetrics();
        int i4 = this.maxImageWidthForMemoryCache;
        if (i4 <= 0) {
            i4 = displayMetrics.widthPixels;
        }
        int i5 = this.maxImageHeightForMemoryCache;
        if (i5 <= 0) {
            i5 = displayMetrics.heightPixels;
        }
        return new ImageSize(i4, i5);
    }

    private ImageLoaderConfiguration(Builder builder) {
        this.resources = builder.context.getResources();
        this.maxImageWidthForMemoryCache = builder.maxImageWidthForMemoryCache;
        this.maxImageHeightForMemoryCache = builder.maxImageHeightForMemoryCache;
        this.maxImageWidthForDiskCache = builder.maxImageWidthForDiskCache;
        this.maxImageHeightForDiskCache = builder.maxImageHeightForDiskCache;
        this.processorForDiskCache = builder.processorForDiskCache;
        this.taskExecutor = builder.taskExecutor;
        this.taskExecutorForCachedImages = builder.taskExecutorForCachedImages;
        this.taskDistributor = builder.taskDistributor;
        this.threadPoolSize = builder.threadPoolSize;
        this.threadPriority = builder.threadPriority;
        this.tasksProcessingType = builder.tasksProcessingType;
        this.diskCache = builder.diskCache;
        this.memoryCache = builder.memoryCache;
        this.defaultDisplayImageOptions = builder.defaultDisplayImageOptions;
        ImageDownloader imageDownloader = builder.downloader;
        this.downloader = imageDownloader;
        this.decoder = builder.decoder;
        this.customExecutor = builder.customExecutor;
        this.customExecutorForCachedImages = builder.customExecutorForCachedImages;
        this.networkDeniedDownloader = new NetworkDeniedImageDownloader(imageDownloader);
        this.slowNetworkDownloader = new SlowNetworkImageDownloader(imageDownloader);
        L.writeDebugLogs(builder.writeLogs);
    }
}
