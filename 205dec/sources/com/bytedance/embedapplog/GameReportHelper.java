package com.bytedance.embedapplog;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class GameReportHelper {
    public static final String ACCESS_ACCOUNT = "access_account";
    public static final String ACCESS_PAYMENT_CHANNEL = "access_payment_channel";
    public static final String ADD_CART = "add_cart";
    public static final String ADD_TO_FAVORITE = "add_to_favourite";
    public static final String CHECK_OUT = "check_out";
    public static final String CREATE_GAMEROLE = "create_gamerole";
    public static final String LOG_IN = "log_in";
    public static final String PURCHASE = "purchase";
    public static final String QUEST = "quest";
    public static final String REGISTER = "register";
    public static final String UPDATE_LEVEL = "update_level";
    public static final String VIEW_CONTENT = "view_content";

    public static void onEventAccessAccount(String str, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("account_type", str);
            jSONObject.put("is_success", g.c(z3));
            c.c(ACCESS_ACCOUNT, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventAccessPaymentChannel(String str, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("payment_channel", str);
            jSONObject.put("is_success", g.c(z3));
            c.c(ACCESS_PAYMENT_CHANNEL, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventAddCart(String str, String str2, String str3, int i4, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i4);
            jSONObject.put("is_success", g.c(z3));
            c.c(ADD_CART, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventAddToFavorite(String str, String str2, String str3, int i4, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i4);
            jSONObject.put("is_success", g.c(z3));
            c.c(ADD_TO_FAVORITE, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventCheckOut(String str, String str2, String str3, int i4, boolean z3, String str4, String str5, boolean z4, int i5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i4);
            jSONObject.put("is_virtual_currency", g.c(z3));
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, str4);
            jSONObject.put("currency", str5);
            jSONObject.put("is_success", g.c(z4));
            jSONObject.put("currency_amount", i5);
            c.c(CHECK_OUT, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventCreateGameRole(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gamerole_id", str);
            c.c(CREATE_GAMEROLE, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventLogin(String str, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", str);
            jSONObject.put("is_success", g.c(z3));
            c.c(LOG_IN, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventPurchase(String str, String str2, String str3, int i4, String str4, String str5, boolean z3, int i5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i4);
            jSONObject.put("payment_channel", str4);
            jSONObject.put("currency", str5);
            jSONObject.put("is_success", g.c(z3));
            jSONObject.put("currency_amount", i5);
            c.c(PURCHASE, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventQuest(String str, String str2, String str3, int i4, boolean z3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("quest_id", str);
            jSONObject.put("quest_type", str2);
            jSONObject.put("quest_name", str3);
            jSONObject.put("quest_no", i4);
            jSONObject.put("is_success", g.c(z3));
            jSONObject.put("description", str4);
            c.c(QUEST, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventRegister(String str, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", str);
            jSONObject.put("is_success", g.c(z3));
            c.c(REGISTER, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventUpdateLevel(int i4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("level", i4);
            c.c(UPDATE_LEVEL, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }

    public static void onEventViewContent(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            c.c(VIEW_CONTENT, jSONObject);
        } catch (JSONException e4) {
            be.w(e4);
        }
    }
}
