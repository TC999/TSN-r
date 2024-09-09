package com.bytedance.sdk.openadsdk.core.ugeno.c.w;

import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.sdk.openadsdk.core.ugeno.c.c {
    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.c
    protected String c(me meVar, int i4, int i5) {
        return "{\n  \"template_info\": {\n    \"sdk_version\": \"2.0.0\"\n  },\n  \"main_template\": {\n    \"id\": \"flex_layout\",\n    \"name\": \"FlexLayout\",\n    \"width\": \"wrap_content\",\n    \"height\": \"wrap_content\",\n    \"flexDirection\": \"column\",\n    \"background\": \"#00ffffff\",\n    \"children\": [\n      {\n        \"id\": \"close\",\n        \"name\": \"Image\",\n        \"width\": \"20\",\n        \"height\": \"20\",\n        \"alignSelf\": \"flex_end\",\n        \"marginRight\": \"8\",\n        \"padding\": \"4\",\n        \"src\": \"https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/resources/ugen_icon_close.png\",\n        \"onTap\": {\n          \"type\": \"close\"\n        }\n      },\n      {\n        \"id\": \"icon\",\n        \"name\": \"Image\",\n        \"marginTop\": \"1\",\n        \"background\": \"#00ffffff\",\n        \"width\": \"50\",\n        \"height\": \"50\",\n        \"marginRight\": \"4\",\n        \"marginLeft\": \"4\",\n        \"onTap\": {\n          \"type\": \"clickEvent\",\n          \"uchain\": true\n        },\n        \"src\": \"${icon.url}\"\n      },\n      {\n        \"id\": \"logo_icon\",\n        \"name\": \"Image\",\n        \"width\": \"32\",\n        \"height\": \"12\",\n        \"marginTop\": \"5\",\n        \"scaleType\": \"fitXY\",\n        \"alignSelf\": \"flex_end\",\n        \"marginRight\": \"4\",\n        \"src\": \"http://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/resources/bu_logoAd.png\",\n        \"onTap\": {\n          \"type\": \"openPolicy\",\n          \"uchain\": true\n        }\n      }\n    ]\n  },\n  \"event_template\": {\n    \"clickEvent\": {\n      \"version\": \"1.0.0\",\n      \"main\": \"open_sass_live\",\n      \"lazyLoad\": \"0\",\n      \"events\": [\n        {\n          \"name\": \"open_sass_live\",\n          \"scheme\": \"uchain://open_sass_live?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&coupon=${coupon}&ec_schema=${ec_schema}&ecom_live_params=${ecom_live_params}&live_interaction_type=${live_interaction_type}&live_room_id=${live_room_id}\",\n          \"params\": {},\n          \"next\": {},\n          \"callback\": {\n            \"success\": [],\n            \"fail\": [\n              {\n                \"name\": \"open_miniapp\"\n              }\n            ]\n          }\n        },\n        {\n          \"name\": \"open_miniapp\",\n          \"scheme\": \"uchain://open_miniapp?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&wc_miniapp_info=${wc_miniapp_info}&target_url=${target_url}\",\n          \"params\": {},\n          \"next\": {},\n          \"callback\": {\n            \"success\": [],\n            \"fail\": [\n              {\n                \"condition\": \"${playable_common != null && playable_common.is_playable_top_priority == true}\",\n                \"name\": \"open_landing_page\"\n              },\n              {\n                \"condition\": \"${playable_common == null || playable_common.is_playable_top_priority == false}\",\n                \"name\": \"open_scheme\"\n              }\n            ]\n          }\n        },\n        {\n          \"name\": \"open_landing_page\",\n          \"scheme\": \"uchain://open_landing_page?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&title=${title != null?title :'\u5e7f\u544a'}&url=${deep_link != null && deep_link.fallback_type == 1 ? deep_link.fallback_url : target_url}&button_text=${button_text!=null?button_text:'\u7acb\u5373\u4e0b\u8f7d'}&gecko_id=${gecko_id}&block_auto_open=${block_auto_open}\",\n          \"params\": {},\n          \"next\": {},\n          \"callback\": {\n            \"success\": [],\n            \"fail\": [\n              {\n                \"condition\": \"${playable_common != null && playable_common.is_playable_top_priority == true}\",\n                \"name\": \"open_scheme\"\n              }\n            ]\n          }\n        },\n        {\n          \"name\": \"open_scheme\",\n          \"scheme\": \"uchain://open_scheme?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&deep_link=${deep_link}&ulink=${ulink}&ulink_priority=${ulink_priority}&sub_convert_link=${sub_convert_link}&app_info=${app}\",\n          \"params\": {},\n          \"next\": {\n            \"condition\": \"${if_both_open==1}\",\n            \"name\": \"open_landing_page\"\n          },\n          \"callback\": {\n            \"success\": [],\n            \"fail\": [\n              {\n                \"condition\": \"${interaction_type == 3}\",\n                \"name\": \"open_landing_page\"\n              },\n              {\n                \"condition\": \"${interaction_type == 4}\",\n                \"name\": \"download\"\n              }\n            ]\n          }\n        },\n        {\n          \"name\": \"download\",\n          \"scheme\": \"uchain://download?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&app_info=${app}&download_conf=${download_conf}&appstore_jump_type=${appstore_jump_type}&market_url=${market_url}&download_sdk_conf=${download_sdk_conf}&icon=${icon}\",\n          \"params\": {},\n          \"next\": {\n            \"name\": \"open_landing_page\",\n            \"condition\": \"${if_both_open==1}\"\n          },\n          \"callback\": {\n            \"success\": [],\n            \"fail\": [\n              {\n                \"name\": \"open_landing_page\"\n              }\n            ]\n          }\n        }\n      ]\n    },\n    \"openPolicy\": {\n      \"version\": \"1.0.0\",\n      \"main\": \"open_policy\",\n      \"lazyLoad\": \"0\",\n      \"events\": [\n        {\n          \"name\": \"open_policy\",\n          \"scheme\": \"uchain://open_policy?ad_info=${ad_info}&adx_name=${adx_name}\",\n          \"params\": {},\n          \"next\": {},\n          \"callback\": {\n            \"success\": [],\n            \"fail\": []\n          }\n        }\n      ]\n    }\n  }\n}";
    }
}
