package com.kwad.sdk.core.imageloader.utils;

import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MemoryCacheUtils {
    private static final String URI_AND_SIZE_SEPARATOR = "_";
    private static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";

    private MemoryCacheUtils() {
    }

    public static Comparator<String> createFuzzyKeyComparator() {
        return new Comparator<String>() { // from class: com.kwad.sdk.core.imageloader.utils.MemoryCacheUtils.1
            @Override // java.util.Comparator
            public final int compare(String str, String str2) {
                return str.substring(0, str.lastIndexOf(MemoryCacheUtils.URI_AND_SIZE_SEPARATOR)).compareTo(str2.substring(0, str2.lastIndexOf(MemoryCacheUtils.URI_AND_SIZE_SEPARATOR)));
            }
        };
    }

    public static List<String> findCacheKeysForImageUri(String str, MemoryCache memoryCache) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static List<DecodedResult> findCachedBitmapsForImageUri(String str, MemoryCache memoryCache) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(memoryCache.get(str2));
            }
        }
        return arrayList;
    }

    public static String generateKey(String str, ImageSize imageSize) {
        return str + URI_AND_SIZE_SEPARATOR + imageSize.getWidth() + WIDTH_AND_HEIGHT_SEPARATOR + imageSize.getHeight();
    }

    public static void removeFromCache(String str, MemoryCache memoryCache) {
        ArrayList<String> arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        for (String str3 : arrayList) {
            memoryCache.remove(str3);
        }
    }
}
