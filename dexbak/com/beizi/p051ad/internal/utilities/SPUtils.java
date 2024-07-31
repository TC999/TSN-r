package com.beizi.p051ad.internal.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* renamed from: com.beizi.ad.internal.utilities.SPUtils */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SPUtils {
    private static final String FILE_NAME = "beizisdk_config";
    private static final String FILE_NAME_FUSION_SDK = "fusion_config";

    public static void clear(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.apply();
        }
    }

    public static boolean contains(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public static Object get(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Set) {
            return sharedPreferences.getStringSet(str, (Set) obj);
        }
        return null;
    }

    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return null;
    }

    public static Object getFromFusionSdk(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(FILE_NAME_FUSION_SDK, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sharedPreferences == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Set) {
            return sharedPreferences.getStringSet(str, (Set) obj);
        }
        return null;
    }

    public static int getInt(Context context, String str, int i) {
        return context.getSharedPreferences(FILE_NAME, 0).getInt(str, i);
    }

    public static String getString(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences(FILE_NAME, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, null);
    }

    public static String getStringFromFusionSdk(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences(FILE_NAME_FUSION_SDK, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, null);
    }

    public static String getUpdated(Context context, String str) {
        return context.getSharedPreferences(FILE_NAME, 0).getString(str, String.valueOf(System.currentTimeMillis() / 1000));
    }

    public static void put(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (obj instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                edit.remove(str);
                edit.putStringSet(str, (Set) obj);
            }
            edit.apply();
        }
    }

    public static void putInt(Context context, String str, int i) {
        context.getSharedPreferences(FILE_NAME, 0).edit().putInt(str, i).commit();
    }

    public static void putToFusionSdk(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME_FUSION_SDK, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (obj instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                edit.remove(str);
                edit.putStringSet(str, (Set) obj);
            }
            edit.apply();
        }
    }

    public static void remove(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(str);
            edit.apply();
        }
    }

    public static void saveUpdated(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(FILE_NAME, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
