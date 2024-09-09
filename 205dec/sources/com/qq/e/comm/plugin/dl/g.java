package com.qq.e.comm.plugin.dl;

import android.text.TextUtils;
import com.qq.e.comm.plugin.util.b1;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f42437a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a extends com.qq.e.comm.plugin.dl.a {
        a(File file, String str, boolean z3) {
            super(file, str, z3);
        }

        @Override // com.qq.e.comm.plugin.dl.a
        void a(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                for (String str : next.split(",")) {
                    g.f42437a.put(str, optString);
                }
            }
        }
    }

    static {
        b();
    }

    private static void b() {
        new a(b1.i(), com.qq.e.comm.plugin.d0.a.d().f().b("mdtplida", ""), true).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        String[] split = (!com.qq.e.comm.plugin.j.c.a.a() ? "1001,1002" : "1003,1004").split(",");
        if (i4 == 1) {
            return split[0];
        }
        return split[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String a(String str) {
        char c4;
        switch (str.hashCode()) {
            case 1507424:
                if (str.equals("1001")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1507425:
                if (str.equals("1002")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1507426:
                if (str.equals("1003")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1507427:
                if (str.equals("1004")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        return c4 != 0 ? c4 != 1 ? c4 != 2 ? c4 != 3 ? "" : "{\"id\":1004,\"data\":\"W8IBAnHm3a9917tsT5IUEkQq2H3yThfmIWnVQmd9Gy40hKNzpSRDRo3lyMBet4csY8RtyrZb6QJ3Q8Gk459D1Gepwd8nQFbvDGVDRQHA9XGl9TWOvkb3GLE4v1ZBIQQWkm4XDw5-Q5_ANGv1rcCVRCEzOzyA-OPtw6VFoBzPJHyD94XZhn0HJra1FQF4E6i2DR4JxOXlFtfILUYUZp1PPLVNqPf9MohTADh9ahxDBEj_gfR2t-fgKJ5CfsKRz6c38lo2sLa7l89iJ7R-vValB2ZH5KOgPf6KaZ4rMWhITw9JrfZJn7IFB4YHYq61bWEvxuisKld9HB0P4RcCi9WWhJtMyJW-33wS9-xx6ZcD2Kog64RUe2qUBoVEzAcVxWlAxXgpC5Inp74CD4XD6cJqNNfodsYRxXmDSXxrOSi3O5W3z8PnMIQCNAeduzhLcEVWo43AiRAkatGP3W3qgwZsFv8P-a8UF4R4OAp-anLJByioO8WFMLdRDO_8GgTp5hI45KgVvzhwMniVcBXFwkXkhF9apyJYGewMop1D98-eZDN-fx-vjiucgDtWmay40XxFyKPR9HL3Kz1dct4YDf0szM_WyfWGMnd0RhF4dM_JuMeLSutHmLG6CFTiImCpU1MQpiNwWTOVa5SvTQaU62IM69P_dGBBC8yEUI65nPP-Q7e2Cc7V-iLp9dFM_07NanvaQ6A8QvGw7wJEe9PizZY-qn-LPolteNdIdqc5P8EhT3W4S4FMiM4n1FICvnp-x5gRXPLNC_Zr3Ni0s9k6WmunqTlZMT-vMCcSYOlgRW8g46_CVg2i6RIkIGtyPtJfsEedKJFkhe8KbWSkiTLMrzmP5jQJfvOmVULpsmsfLExtq4cOmfG-RPE5oHDUw2H4iYrrqjVY6SdwS2XSGd9fS_3YHTJJYmu6oihkWMsJEyhSM6Tj_CdFSUBx0XffrgseX8h5MCpQAHGDTjLUIPWs8MrSyq5hrNQmW4NbE-0gXsMDfIir3MEe3nNE4L3nER02SiWFaCysgmYwaPQAeA4p2vFy9B_pyHUwfZOrVAXqgcJaGUEEPrVfM0nuZvYP27DuH4_G9HhlXkQHfdyb__AM9idzNRAG_lYjo9RQ-Aupfpi0g9nCif2ZYI-bE33CFqESa78OGklPAqZLD2hnul1HNsiN4vqVGoPYOwuxhBDTPh4R2vHbsiitNVV1viIG-IK7QVaboyL8MHg4jg2BAGoLb5TrCDXhc0zJG2Ws0mXsN8xmnX5QYdTTTnVkI5rBEqVi73e_sR0eqgNGKvSiWTKv1hErjpJYBvblRJT0GTeD8Vq7jsOB1_GW_6Uq5_98mi9T-537C4b3RIdWI7oXpZmhxMjB3xkgdTjoyjLyZm2DK727elT7Vf0QJM94CX2hpZKqDVNCx79V_4ZQxoDgT9fxApV4D9lnwvFn0a0m4GD9JZDrPZV1INcfhPcDvKWvO87O2392zXgvRFrk5PBP0k4aTh4xD9GTZPGlUDRKdfteE3-8h5OEynxMxETqUW81Gv5b-BOcJBrFzCfgLYrzM8yuTnzo1one4wqToE-6A1efJxYwuS5Y8FX6wvHJKTFDZau2O0PdpWJ77wVVhL5YKcpm81xWN0jIRrGM52WqRiJS9WicqtkNcRsi3mYoxhOGsLH6_avWODvE7oQRR-UQqUDwTb02EbTwv5VhmZOLFqvFL4sWE8qGuGjnN6gV84q2Ctw_M5RjZ7t7pJQaIcmK6GG-Gk1CrvFoElTIAWKT-nWiiXh-pLQUAda7AVqNs7aJDMPpAgKs9YftxjIuiW3U1_fNLWPowJaQs5dY868PbHLNySLPPhhOUTq_m30iwanSAIjhw7ONz2Xd9xROB0toKjxBJ4aF6QzEYaSenxs4olstHxulQU1iFKmEeT3vCns0bx-z-8ey_mlxgR6DYeYshXiEcw8cVeIQ3lid86bXf3kcavYHWipwGaiX4GV-XtMu7hOT8YzvYgDDQvpGpLsriL27NjagL_eAk_lbrOJiumEQzMpupXEKOhbsnvwDkTviRIXubtTt-W22RfXXhDTMbPlglEagzlO2wyggrYOZQXQ6p7B_uw1IXPDL6li5vBmDcGXXJcwe5i296P2Dxbw8CEQq3HZKhuURQb0M8hdrfLQ2hvjZQZLl-fKAXcZZiCaODWq-oPiMJHO8Hn9g9dW4oUWJgjANd31YeOpzgOIHjWiN3BxrjSBLRIeqBuVI-WchBLb1I1-3Gnlrzs7Bja_z0UwLsK7Bn9jfVNHWChoKm2Z0IhOcxtd2R6CdRTBsVI2czV-rzeqRKkRToHpzD-D-maM-umZDtZBtWG3FXuCd8HobUYzfPiDdzNU25H75Oobvt993iQx3XjFvfPuAgcQzDsvOXCZPo2ayrAslAAikxDr2SEzY9cq6xl1WcT_EguTR4QdVFzDz6MXkIXbTbpxfgTAYHYnqLkc3s7a0TsugPKAYIHd0dBHOYYvxz460GEsxfjv-PVqv3YRwyahH-3JMoyaui6U7VIcGOQ6D1QXXsHhdhex0nhvWOwu-y9Ul2NEKt2Qz9ByFAQx4NZRpsxzw-SBQqgSzHvmc4FBLqdwfRDQAYoBxu1XE7BYA6GaLCpec_UcbBQ1RaCHw1_JsPPO7NPUelAo-YyPseXHqAOEi9SwrqVocuZP_KpyLDjW9I4eIoVWfZ2KIVT-PZWgCONfXOr3okrNf1k1oyYfcGTN09KbiW_8dnch3QUoiO60Zc0FoYT4hx4dXcXIkVN35AmW8VwtKeYI2E2xUX27lVG6WEUySxVU7t8Ao9_cR63IBget5y5mm-6fao3B742DR66O71ulP2zQOxztRI_U4XcMWdSx1YWL5qKcSBKc2QphoFqZ6j3qZ49KmUysRFNYj3B8jr5sqEdTLluA0_NiRmZXQbpJ9vVfFRqr1ZbqDt0BACQmWYcywmLIaCxuQDgyuitHZtP92UWTAIhov4eVe0qBzDtMNay5hVgSWe8pWaZumyUjunmYInWrIXjnKBpmohV0uKcuXAzPggd--9FLxhWZ49tEBHly-Sj-gS6bC-JZ7o_t2yambhPEQRxfiMIF9H9bgLROrLu-cTnh5ZmrgnWBxlYauDb7qQUVBShR0GCFSFZNdkAbWCTzr_fUV4ZtdcmaGZFk7zAecZidFCjou8LOyGRLrWyhVWe0kfaVDi3tPwBTc185z2OEgpGZm1D_0kXDm0Vh8ZE4QMGcFkNhaDAfpQG16oDUK8Slsf1AbUtFkwoUfEqRfoXg5nKUA7ewsH95n8uK4dWRRrtuWa0kxZT5ZkS6rH7C0v8F9fA-IBmDXoIDTten1G94-Hqz6Lf2IYldCiBdzJXs4HxUyACrfyLfk0kv5GP2Ime_EwHlPlBFgCJgvFKnSCzdf4ExsJN14PAVKhK3-WCiNVOzP4rPzJfUZ5ly4Lr0v_aSD2IXIDb8eNwdBXeUjpih3YZEG8eHQUyRhmFYH9ePCsy-qIPSuoUQSmQqXTbdChNRVchdF\"}" : "{\"id\":1003,\"data\":\"W8IBAmV8e4UQVovrssiQkiwNA_x7KMq1byEC9whn_IeAIpAylA1XQDmBGKNoEv8I0D63YlZiDOR-JBz9ioAm_HS_PSj4fQj7SrEm7GJeCdW4B9GNW3zusVs7zgdQsZmsLP9dALi2-XjiNJAXrv95aiA6pLzxEv8Gpu1i0TPf9btDs2oXWiE3tMvd9wX3LWUetrPjfvUC1A15ka0UvYkGVuV_mJvgWl91lEX0LwDpucw7CGlQ9hRE8pa8jG0FKu-aYu_sBcf5ql0FEfm8RuPTTm7E4kOplB0D3r9Gs2xLlLDeiVAE8JP1TbZ4KEpbNO8ByNTHKQcH8cdoTNKreFnkFP9B8x0JeBifjHKJUsy70PGqG2D45pVWkAW1k5baZXhxszedCNSLg5mky673QXc2CH7yFdP_rYIYZOYWLkJ23X7JWONBRugdlSVRB7a7jaPy16klYW6LAj_Mve1tEzSBfHbf5yhwQq9YqWGHcXQZGUUNhjpd7NiTU3Un18pgS-I7PkZrbghB9L56DbWARlt0yrz2cgw8h_lUnynoHxBJfYL3F0XyDI-2TzCAdxaYvntPeICVytQPUf2e2uzY2wI3sqhFbieaUuBsxdBzk24up1ztzH1yZnJpNfu6XJ9eiy11Tp5SlsLNJqUETs2kFTkX4x6QruGDrRX1JsbKb8ok0yXELpQMsRv7DSFolJ45YmU1TlOlwix21QgvpBju51WSbrPLragduSpi5ISkwltNvPR8AB5CjIA6MBg8hTmhHrxOJBmOhwwvW3dCIGObtiqbdu4m8fy3psX_kY2NNNBcvQIJ5cG7kd6GuSt6GYWyB5L9qHU0_d6AvJ_OZJwP5-200IYMszjnilSNlI4RVidwF4E_qZU3qqrRfC_yvl4Lh5HtBm3wlWtTEjFDOhdbMdTc2iYkjn51EoFEgRfsx2rfz-DFGQfb0GIHt8pMohRYnfXIv3WPg2DIarxDjRvS0S9WoaO25whXoqqkb7OGekFliYXIz9cxPQtwRFsUV4hLhEYi9OiU-f-1s5TARBQCcRWOjPFTEm3850rDgtxt8SX_tPi4pUIip2AUjdWbBALvNdorofdhar26vhUfIkunm1cAYIBI6oG2sps6xw3UdjGuru-9XghkSOtz6z1oQFvYNNtnZaa57Lp9O582vBm4kYw__536lYN8PmVJNzfTJfu3Ysz-Wlzsi_MAiGzKAM78tKdvYQjNuVommknNZo7ZLQeSd8iNEZA6Gt0gKtx73zhvB-FBN-1ST3Eg1hBjuexYCojOjnkL7gWKD8lluH4Nr-qtMki2KweXysqVHPsNpiiBNzT8xbh4hOWCpeW7KRxCB-JOcuq6ET7LarW__uFNi_aMSd951QvLV-fRqHZwzDfOumbgJVTUDRCWZiNSX3-kfs0FkUwoifcq--1UvYM8_UQm5xZRFleMQTkp8ObpOrd1GAisUcqX_FyxQH5gzR21drc5NWDbS0E3txzwHKwsxUwM7BoKM_aSaq8ewonYCVzi0dyldze38XTKXR7co0AGmPhlggYwViEoD_4MCOjXmBVxts70P_o6oTEL8OF-iF0eWu9vUrifMnbG5i9BhpbIUmXhXWKPz489dh6p9PWLNe144X89tdE9duPcsAOwke-8ep2v9MWBIiMxAJgwpWtJD-f7VqR7m8cmtkstoZmt3V2TK3PXiGIRTuHFkMwwuuE0oVeVrDYcQ8PXowQk3lC_YqcSnP35TQgXZdk1zj6NK7GzY5C89MjbrI6ws1zTV3gGgU8v_YRQJOT4p9jDWWhnWOTuzDOJGEUyB7yNLXlgS3HYNd7BiCR7o3m0FoGi3wWL0B5OckCbRycxHMwqIBBYGSdKP15-zKztpkjemfB7pt_T_SOhWfSosn09bWobOrMSC6uUZwKnPTSs64CSKkneK2kvQFViK5rxIg6nAFVNU-pEBT9xdxP8u1wEw11hUqeHd9fIZkVjkWX2rG0F711CHP38m4PJe1ot50iypqDOLvj3n_aPBIqk4_6I-ExEkGNVTNGonQugThEsh4BpOfUVahay_S6jR7Jtx3TF__q2e_PxxjjmL3RMI9BZ7_cQGWBf2uSdNgqEMIC1D4-x9lO-bl5oAvQfHKZ1xAXtNtAphy7Fsf3D48KTrsNnbi_Qdl8FP8lpajIeSj9yQf0eJdozWTpPc66mEvz5hD9vSnQfsPK8Q6w6bxhQs0p0mhNMxST_0xfcH9I_1T_TwucRoUIY4zoYwqSCk0DmPaYm3ObA-ubbjxVMfWGLGH4l5bMeG4d68mpDTCXx9ubf_wUBothySojOSaxCkS3UEcuxi9Pkn6P3sFAX0JOg3-2VvcNn8wxa0xZ_pbaJygCix7sHqZWrMVq5X8QMRMur43aMN_vf2omPvPdqmr26_9y7OtwvXLFrPRsLksN5vOIkkPuZ2-UyXp7IogH_t47-wd6h2eqxElL0lyJOrc-MkUAq34V8DAS3l4l-FHqRKu9rwQLUfZ0hpBbTWhHdyfuASczznFqmiYqAcXsL2DdzuDZ2irwtmvwBmt8kb7mixhV12eExtqroX9oDjHOPQQdmQgVGagDtNPSVBUEGKm4eYLv7YgN1sfjLVnoZEOrK3QPYlkOFd7Oco2T0xFtYL31L0tEyhMJTP8kqp7wJM36_VhbPnz14keS-8nUA7qdkKq_QZKi9yEn6MWItvp91raoPjAJ2dXE0QJM1XatALHJn4I22_4ruNjelGRJ0uW53GfYwOF9iEehtHLUIayhWz5F2OwaZ_2aqhZhpLasZtDY5H7TH0cDPXqCFSrTetXVF8Bf0bdeQvBPdySYL62zYgomVC4L7jO3GDZ_q58EKhnrI7-DVoMfykBMyJItIyhp10WRkwj7L4__A2rRjNjf8AC0HS_nUZyl_djz3BYG7rdjCKdofLPvPAiW3vqcve9anikUWay3ubXJZSAC_qWigLXpLK1DpKqd9reBvYOd07Ow9OsRT9hoQf5PDqlf0xHNTRVfIvsHHHqnYnlg0aT4QciA9MROKKKgVS6EWBdhWoa42rayKtWRHU6QOP627qFwAtiXOnpFhLgvpZkA99FPMKBUXgOfXKQodpxlslnx8K6bpmnbXEbEdjhEQEuYyKsR5pkuEtj0_Ys7rR_tAourWka9x1pipyyfbI_UrEwqzb4VR1Shveqifmc2qxU26tohkmWlQlhBJ78V2WmDQS_kqIswxP8GAFAyOsE9KxjWkHYRJ8G8UYGR9dmhBU0fesL1EWFd8vlDUZgfoGguHMfZA_DLahVy_7Dg8Cv8vikO0qFJO-3QG4mg4JYgbAajT3ro-Jcb6UWj_bZB8LpgwTJqTcV82eLBwDS-o6rHTW9lHCGmeUtZtTF3QYuH5-yutxJpxdpkyTdgW5U8cFfOFkjoRlu0PsjwXUOoUXhY-TjmtlZNeyGuSReOO-RF1xyeY9rpRDy9mhCcjbylgsh7cbkudDDWj3miAMfTA2f9K7sdVwnOTiBOk6K2rqVzEqmfXXzyTUrIXrDdrQJhFhePOHgDoAnmDX6jE2jgppEqCNTbBu3CCK962WzLHTYP95qUNA7jY6wkAfDtH4Xo_eArQJzxbXw\"}" : "{\"id\":1002,\"data\":\"W8IBAivSIe_Z2Xo6P1g8xdetBcKnCYN91ByDWWssQYFjelzPdrJqvx6rac--uogpe7rcWshTht-XYMbRV5F9KmzSFGTLUbZDVQ1RjR-5oYHLvRRNJtbUJauFmnJwYcJLKs5J4soQKeWgN9fXfMEyWiktUi5FfXWF2YLz-j3hc0k3Dpn0f0yy1l-ZL-kubnolAyN6IaHzI6VNUJGB4IAOcNCXDfj87AE6m5MUuIx16e1UBomG4cxPcD6p47Em7S5w2HBCbjd-zHH617_PvQU4PE1aUJqvgnJSEcK4ck4IA6ztcZOa6DcgaodhtTsroqIE2qraoWdI1xDNUcG0zVzGrV6-BYarpoJjIrlTRcbnG2ky3D6Nm3dh0qO7eDU7wGaSu7_g4HBWtruP6ysQfnlYIdNeHuBpzdh0IuRROHWt7KAMrBvOLjvpj3NQY-7XTPH4ZczVJzxC75Sqf_ldPh_kD-FJXcFme36P7i725SlkbBvOeTMtF5b0WHm7pWPzTm2Gqtu1rs11-V6xtk_PgoWcsLQOtHdWJweIgZ1IFFfXk58FBqCoHfUXJAcJB20COXi-Zb0Hwmvj9NCXTEGi1jJiZ2tvpVacEEwwzJoTXVPmi-O8k5EKhn6AbZszfavWh1pc_xLGFR6DVlWX8eF_ZuD84Y0K6RixjLKCGUnIENf_ch6T9xtmBRGnACMCqzPamSSjYFa95NRYGE5pproGZfhpRYDFSPqF9KEHQ5THdbl6hxpvxmdy7E_BiLQpQ1pCftZMypwOOiJG9LP39CrpIrKx2tZwuc40y5LPGl_AFtdOKXMlBF0NVCGf4UsHoHzRNMq1jQWakY3XvlRCzZ2SSWfN9QO-RygqqE7jZ1kwwhBO6iHCma4hThlu4v8LSyMc1c_-BpEzaLl0YDYEwbAv1O2-Kny4mRltRmj7j1Vo4ODc6_nZz5iR3vHJt6XhvL7EqUxFcQRzeaNW24lkpRge9COXv-n0Cfud6EXtdVmHVhGnvfviaJ7PFsmyzow7HIfnkRr34YKpA24vFBTvHVnHbqlp9VQnARQMoa3SKqY6f-4dwSi134ALY6QG-LX2sqQb1s5PQ_nSb32ZJIXY67O5Azso1CX8f5v_lbAyuMmRrQMVV_kH2oeUUWGtjZGA2WGcadMzQfUzhYVJ2GQ66n4UvDubi_XOMmTWs_qZVlk7aAeoJ1EXQvL7XiW7LaS2ZdtINH04ZUVuE-KdUXQy7LDBz0BwQvL6d9JstaMqOsueXKRdIB4DEyn4n_DC81N_OBv_JqHlSeODZuV1qqzgwItxB6rIB53RMJkkDoNT7oBkoro72cyYT5NXJ3wp9Ku7bX3Rfbu-2MH5ouKxse9zOm484NDh2q0ssR8au0ErUJeXodH5kVueMpBcBXv_LySAAFWJIkaQdRtu6ihjlxSY5x-ugcpu-GoxrAMUzXehD4T72ZW8mWP79vxlGPgJ9vx2Vli0HtBkSVydnC9gTA00-nmGtcbRHEesiCUoajP3SeF_Ar6FSX_ZOIrmCqnRtX5NNqBYqxFrRAHrPExj60wj32p1MR_sWKJuJKlbkyXjUXhWAcXMs9pT_DScfYJEMCJuVboJ-nI_1C3C7jR6Lnswb3yeSzbqSfOce-G4mNoQ5NUrjK5PgsoxmhQI1Y-2gDrIvXVTRzQ_Vpm0h32C3gce80Zj-bBZpTvzo_flqjEMZhF6rSMigMtOxc7UxrosYOcZuwvg6AZfl5n8a8KQTMTCZrwGc7SLIIm9dxswHOVhWCDIRn196skDrLbuCsH7aa5LuJn_-s_2kvX8PNe5ESUfMM4z4PcfpDGXdtKrbVrMxD6LFI0Z-Qzd1Uz_72FjUKbsDs-3IZsGYAGb3f60SkkOsDB3xzN_3lOWLzTaKoGqSdikyfeh0B59EIo9RxjnbiVCl8sxjApqZRKXkvNr5X3ibXa165xaA7JZI_kQitN0VyXV4KVsbc32hMbuBWz-4STdo3nQzOYSHICgWtSduSQZSbvJllk9bV8WlYSIL2-V0iJ0ecccQKAiZie305J0SpTKKaVVEiPx9pJRe3ijPMzrST4YlsXHodZE_vzrCFFqGlLDqWebKf36vHtJbeje0GwbQcOuvfJlkkA8Ji7noWoadDHbtQVHATNBEABtOuSI2YkijqvLP1tPUHQH-7Yi-mWdcG7eAfzU5X49pAJTIPm-PdRA8DOIOuxIdFVvlQQOtGPzjoEcaOYm0CsecYpq82sibZOQJNol7lmrpOpWqqc4dkFwDIHvtTi55OwjEZ_x1EFNQw_Cp4bJNUpBXDsY7Tayy10ev4TQRJrqQxqQU7sbW9SbKLpQDx4x4W8BqsaH3wE0mwKry4UlQw-k9Ki92oJ74izvm2O760_HrHDIpob8t6QUv3ovufFSe73q00hcPlTqbXnfZCXmK1oE1oCLFMSy446xx48i5CJge5uvElT9EyOXIdEEmYSstnk9iZFSBZQMU6hA5daco8embQKple0S5_KJX1nleUPGj0kAa6YSLMrRFdDNUmytImU3lKscT8Y9K7G_KeKcIVUwNd0iP98H277yxBBlnWVJEiLs8nZpPHzhNF1GpmVs1rQGBfQ6oF2JDvI-vMiYbaxXelkCUiUHA-7ksXCNY1KbgzxwUFM3PBU2WweYm-nVKvKEsJKuzySS-jvi9zzS0yN6uBS2t7SQQfpZ_p6l5RAeA8mX_5SLm0hAL1FwuhTVTT2BIgdx_EOkzhN9aabeZyp06p2MQoHHV_7fAhS-0fTLRDcqok0yNXMOUZx6DjbqKuYqgt1wYNqReO7yAkgiXko9eM1OeSWgAP2J7qHFfSBY-H6T9EPEA60-5eAhRSdW5qD9164GAnb55YeIhrCpDvA1H_oqo4FhFrwNQmVkapTEaCtFHx7piXKDDn4M_I5FFMXNRjCHG-Uq3EyUwmJfwWMeBkYar7XOg0pcBgLwVe0xFdFvhDPzlQj5OZmnYhtMqz0WHZS4bobeKDHpRd6gS-4gwV4nNBD7CPlw54ebyzQi_m6LJY_ZJEQ-t_gK1cXNYWqVc-kznjTtmGnq049dBAIj7Ok2-JhxGadK_T5H1k4Zg2B_ZAejqrYjTyEkbYtG-73kJEeWtWaPNQtA2IJOZ3Om9pZQqbkco4TpYwUGX-oW63qk3515u7UU2QeK4L4y4EK0EIWvwprJ71akBTPza6demS-YnQrEEEqc3Os264sGx11FFsIuKIbTY5WepmQyQhK2DEtPR8fdMm_-Q8g0gpRAZL8Sn-gNVCWS8mIgKX5NmKBg8Z17Mbq9Vvb7SUQeUb4gzD85sVCcrmK6kkRxssv-foK2TB4F9PuY0d-XPRfN48ftLewzKaIQMwUJDt2z9_fVxfb0xvPEtLIjApRmtJMkEdKsAyw2iYiiwYKyRhm87m4odoiedgSa_40WWXDLWJ53IsOh-cmqsa22FmH5JMds_x_HRNMG1Us80ZB4BzVESDL5GowV6LBkgsWfcSKTBkULEDVXkOoUwh5MZ3MfWsTHWC_BJUw1W90HYsvKHvjCYg\"}" : "{\"id\":1001,\"data\":\"W8IBAtNWtpPojhklLpybvKmIGHZlu_6dKjOvDjRNkjo-kSEaftsz2tw6REpIHH7-aNK9uOa0HKtVe24OoREWyb7N-EFXv3ipe5Zv8Efv5weEFBGmUvYMbQlGicly3OxHYIeUNgLDtXzLL4Cv-0mC1c1lCOYKCGDVNxY5JYLR_A8r82uuDQaFxEXEdyAqgCYZPiyQjN7lAM1Zbf1d9-cRz5G84aSkvgMYgIyztvrrG3rRAXd3R_cNvA_LtnjKHK0jRPjnUErQFcY94-2GrYBm2aw1XZsMqpn8LlVV7wN_Hh4dIfFoZHoh4N7RG0Gc_zJG92q0rIz2EIQszYsPY1OFtiJGgbZW5FHNLQvZAVxnJMa6p5Xp-M2pqrky2-N6tvUzrHRepQLN2BSDKkrAyqqrN5EK3cKO43shyRAV_EHX52l7gEqaT7bOD-dsDhb15u2uFcEL4G38rPOXqeScI_dMMNmBSmurhJC_VWFuXapp4qWv6p8ZgGUL_54RKMM7DBAUcz1sHWKef22sjKmg_Rbh-FYJtTBFl71xTzchqbJkhN6YDhDVed4d2Xm5ZghwsVFZh4sPF5LVyevxSWDF4RcbSnvfdLpj5fTHSwydJS76H7J8qDn_pIGNLlL1l4lA7JhOUb8DanjYcfbP-imMzB8fynwXilaVKQRJF_0Q6Se-F-mKCSVPq0cm0XyKgWevCyN4dmRl7XuHXiMjcIVTEnYQ2qgHvq2pHSM1LVA3gecGQd2A_g6eOl8Q61TqftPKsgYXIfbGV5tuUvceXBpLRg8hdZNdGkpuvLTR0S_wgcCmRUyanEG-uhdlG8Risqs_apKCppvugP83hT-W7zcvAu39o7AFtWzbnbfOotyjuxwd7pCp1nmOSOA42GRwVYgsOdhBYLHjW7QKRkIvM2qr_bkbgadQmvzMomGtyP8LEVY-TRpKvemeRuW_EOkThMeD-GfsJUXZf6ThkEdfZZ5vOurBiBKwQ4QkLxrJZ-yRyKTY_KxAqQbmmqvIn6gr9P4_VvpsYUhPw2P3vbmuALFR4UcKDWPA-HvK4_cAjmZKM8-PuMoUQBkdy8f49bT4vrfm5UrnyTYDCGQnFTi2ty7kdrwDgHBHxVNhdsOFOM3Yebtv05MX5iIUYXBEHyW2yoWf73kAFBvCShicD3-tAKoZa8OChf8_zmMuJz5IRj4phSWk8U3dvRLU_SHU63h4j4J_Q-OkZUFcWx5AHyg2JbVZzNJUSVjQudynaYILGWdsQYbb8gtj3Zx4vpuD9HHSO838jceSTU_tSvTfRv36epxW6IqU3NCOmSZ9QqBSsJfphzjrlATYPpgs2ClZlkzHWXEMe1xZiG8C3UgRqY6os2j2uikrhI-g83OCwT5CK8ctttEnW5u0oOVI-9HPxky-3jf432G1XXtmRyHzUQetteag-EpBM7hr4OaNoxNPK3L0pRORzoA5nVi6imbZtuOX4-AkNbTop1MMlWsxOYolYgSAhHCkhlXzWXjN51UuptjPw56rw4ItRbZNLSK4ecUBY9_tHSdX02W2SSITbDCngjKGZb8V0_RwNl1x-rwNSnmoa3iaQChCQzkKjKruycSXsZJaw_dvFdjHbSqp6ssLDDce3xtiNAPyrXmAzI0QQ2tqJLjqRsLfoF8o-JfKP6D57FtJSy8TqdkXviGXll10hq73HTNhF3gXT4l6nKb_Vbr11RFw3W8tJvGqQz06Et5rafkkXA_OA1Nu5zbf6-o-X4DPKKMTwsOxcVDqrpLWH5NSnzCFsqu08ijqexHyA6S19v57uKb0tlj7QT73n3_cZl4h0yi3MCGrE9PeQYpZY-pik5M4QwzMZUCJbI4ehRg7cBev9OWdGo1qSDkWQtHlBtu0kcZFyL-Fncrf9QPJPJix-GsgDLu9JBETEig-U9lOHQs5ZvUh1mA7LN613q7CVGOJXh_E39M9qI0A8jOplItDECXXjOk14JLy8CqeWhKRxi6A5UeIea353wkC3D_mLKza4SGg_iMQOsmHGYmxTayp0ii-8JXNdrVlzANMOuRif1AgHgTEhIRQGIAysaRoBn3gxz-ZVRgJrEzZINQATh2laUfUca9-VMbarrURqLwAooY3Un6c1NYYrVGfk6m5oEVYQ-z1OkFJpjG4ue_A6g60VCgneipJZ_uWb2PJb-BO2gncPuOzVOMXgdXSc3wtAlBEeeyQEoViXjoxrlv3DE8RTnBB5Dx1HGfSQdWDbxvjXahI2zS1aAVpAxVP0sNiclSwS5AV1yuga-Jrbr18OCt7PP1j9k6rZpnaA3Tu8Tq3uKJjr27Swhv1CNtDQV8WKz1rm-zP5c7Vo-TkDrb1zhRRGhWPDq0JK3daG9F0l-U8nKeootTZcVw7EV6e6JrQjJvPpq2J7nJwYQ4Zu_OSusREAQgPGe-G94MVaEvOSADL7argbKOHtexNPvvFxmiLQVrnsHrybtxYdK5Q5I2phSS7t7NassOkSGVP8mj1-UjyV4c4K41nnvRIBADm7SInDcIFye-0pau2Q2DGwZM6opFF5KVELiAmpWQbeGb2mf_7fQ0KxqaiqoEpUeWOzhNNrFnngZmoip9-O2PXrbrgWNpRJIHWHonbk_QBclzbKnTwgM2wyK4U9LWOkdTlkmlb1WEffna0g4ah5mltm8sR2kuVIM1QXoHMkE0nP7Csqkexg10ACVlXw2TTjPaEM00WBANhKPI7JYeJwUpQovnWLfqfNpwBv5LFrUAUUHlLiUxgF9e2jdhrHuj2hjCsB06ysYKwh_e6hTE0nby3QUnmVeq2_oeM_gn6gM5IY13QOCaS_sNwc3EZM-_Zxh5uVzn0LAKrobxWjVijcvGuRMq0iaXDaibCSasCRi9zu9U0uaC5AEkZIqDgsU9i-kqCfytuQpUKtzFGBBLzS8F0z_gP4eOMLqwRAG1hjg0xMjMZzU_coiaFJ7MTcsMsjRzZR5hV5o7mn2d00c69UHfbFYXcDIxKJjP3ENb67N0RZLB8BmCOSXJbXQb67945oyrSMTYZlCtoqp1v6W-nxZ3vvz1rLMioUeFlwnIQ44YUNSWT965L9Ff3hvAZgO1US2ALYTrcboLv1zBDufwgQelqMMPT3MCSJyn5c1uLjegvRWENmL-6weWaSCVezyIGqnDs9nG8WXa65-zOXrOc8oNLJ89MfrKoSpwkqaIMRH-Bf51Uw-1aAUOHap7UQUL1d2hTUF0pkUqlvJCzOW5lAp2A89qJGJ6jvwoquYc-ujs01--bzwF5--zF6a5tsfvzRJDsv4YyMwDjEiOEjIu88hJgeC7EwLHGJVSQ6Y5sEiAD_86qSlBnHrjKJYPB5-c4TDzYirbiQ7BjUmUesOCoCS-_boqMS9Q6HhErwmLwfW0Vk3i0lrprJ8vlCRHiq4orAACo2WXV5Lz8V8r5_Gh2LcoIMG6DpahPsvdDd7PY3ymaFiNBHHHpGCel7OK5LiC2dGUbB5mXdf5kyk7xj91P-dbRDiLFtzlPsxcTUWCLz0rZwAqL4DGsArJFsQKioLGPFrzHnstZY9jTY7vgkeBjz5IEIkeTEQmM-lTkiioDQYjA4Tz0Eov41oAcjmUmlQqBaqVAZMt4Ka_7mMQdd1XRhz8\"}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        String a4;
        if (com.qq.e.comm.plugin.j.c.a.a()) {
            String str = f42437a.get(eVar.k());
            if (TextUtils.isEmpty(str) || str.split(",").length != 2) {
                str = com.qq.e.comm.plugin.t.c.a("mdtplide", eVar.q0(), "", eVar.p0());
            }
            a4 = (TextUtils.isEmpty(str) || str.split(",").length != 2) ? com.qq.e.comm.plugin.d0.a.d().f().a("mdtplid", eVar.q0(), "") : str;
            if (TextUtils.isEmpty(a4) || a4.split(",").length != 2) {
                a4 = "1003,1004";
            }
        } else {
            a4 = "1001,1002";
        }
        String[] split = a4.split(",");
        if (i4 == 1) {
            return split[0];
        }
        return split[1];
    }
}
