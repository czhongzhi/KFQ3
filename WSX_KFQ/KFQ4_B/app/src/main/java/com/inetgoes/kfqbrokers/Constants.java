package com.inetgoes.kfqbrokers;


import java.util.ArrayList;
import java.util.List;

/**
 * app常量类
 */
public final class Constants {


    public static final String brokerUserId = "userid";//经纪人id
    public static final String brokername = "username";//经纪人姓名
    public static final String brokerphone = "phoneno";//经纪人手机号

    public static final String baseURL = "http://115.28.208.92:8077"; //http://192.168.1.26:8077  //http://115.28.208.92:8077
    //public static final String baseURL = "http://192.168.1.36:8077";

    public static final String registerUrl = baseURL + "/v4/brokeruserinfo/action_register.json";//经纪人注册
    public static final String resetPwdUrl = baseURL + "/v4/brokeruserinfo/reset_pwd.json"; //经纪人端的用户重置密码
    public static final String loginUrl = baseURL + "/v4/brokeruserinfo/action_login.json";//经纪人登陆接口
    public static final String updateUrl = baseURL + "/v4/brokeruserinfo/action_update.json";//经纪人端的用户更新接口
    public static final String userinfoUrl = baseURL + "/v4/brokeruserinfo/view_userdata.json";//获取经纪人信息

    public static final String initializeUrl = baseURL + "/v4/brokeruserinfo/get_homepageinfo.json";//获取初始值
    public static final String switchRunUrl = baseURL + "/v4/brokeropt/switch_runtime_info.json";//经纪人运行模式切换接口
    public static final String showGrabInterfUrl = baseURL + "/v4/brokeropt/display_qiandan.json";//经纪人端的显示抢单界面
    public static final String clickGrabButtonUrl = baseURL + "/v4/brokeropt/click_qiandan.json";//经纪人端的点击抢单按钮
    public static final String showCellInterfUrl = baseURL + "/v4/brokeropt/display_callphone.json";//显示打电话界面接口 (被用户选择通知)
    public static final String clickCellButtonUrl = baseURL + "/v4/brokeropt/click_callphone.json";//打电话接口  (预约确认页面,点击打电话)
    public static final String showFailInterfUrl = baseURL + "/v4/brokeropt/display_qiandan_fail.json";//显示抢单失败,即用户选择了别人
    public static final String showKFandBrokerInterfUrl = baseURL + "/v4/brokeropt/display_kanfang_man_req.json";//看房订单和预约同时请求的通知
    public static final String showKFreqInterfUrl = baseURL + "/v4/brokeropt/display_kanfang_req.json";//显示看房订单页面接口  (收到用户看房需求事件)

    public static final String showHouseSourceUrl = baseURL + "/v4/brokeropt/display_myfangdata.json";//显示经纪人的推荐房源(我的房源)
    public static final String houseinfoHuxingTypeUrl = baseURL + "/v4/brokeropt/houseinfo_huxingtypes.json";//经纪人端的点击"推荐房源"时获取户型类型---数据
    public static final String selectHouseSourceUrl = baseURL + "/v4/brokeropt/recomm_myfangdata.json";//点击"推荐房源"按钮

    public static final String kanfangListStateUrl = baseURL + "/v4/kanrec/kanfang_liststate.json";//看房订单列表
    public static final String deleteKanfangDanUrl = baseURL + "/v4/kanrec/user_delete.json";//用户删除看房订单
    public static final String concelKanfangDanUrl = baseURL + "/v4/kanrec/user_cancel.json";//用户取消看房订单
    public static final String confirmKanfangDanUrl = baseURL + "/v4/kanrec/user_confirm.json";//看房订单,点击确认看房
    public static final String writeCommentKanUrl = baseURL + "/v4/kanrec/user_writecomment.json";//看房订单,用户评论

    public static final String myYuyueListUrl = baseURL + "/v4/brokerinfo/display_mytraninfo.json";// get 显示我的预约列表
    public static final String myYuyueDelUrl = baseURL + "/v4/newhouse/delete_mytran.json";//购房者或经纪人端的删除预约接口

    public static final String myKanFangListUrl = baseURL + "/v4/brokerinfo/kanfang_liststate.json";//post 经纪人的看房订单列表
    //public static final String myCustsListUrl = baseURL + "/v4/custinfo/display_mycusts.json";//显示我的客户列表
    public static final String myCustsListUrl = baseURL + "/v4/custinfo/display_mycusts_ex.json";//显示我的客户列表

    //public static final String backupInfoUrl = baseURL + "/v4/custmark/view_markdata.json";//经纪人端的读取客户的备注信息
    public static final String backupInfoUrl = baseURL + "/v4/custmark/view_markdata_ex.json";//经纪人端的读取客户的备注信息
    //public static final String setBackupInfoUrl = baseURL + "/v4/custmark/instupdate_markdata.json";//经纪人对客户的新增或更新统一接口
    public static final String setBackupInfoUrl = baseURL + "/v4/custmark/instupdate_markdata_ex.json";//经纪人对客户的新增或更新统一接口
    public static final String seePlanUrl = baseURL + "/v4/custinfo/display_custorder_detail.json";//查看客户的交易状态接口

    public static final String complainBrokerUrl = baseURL + "/v4/kanrec/user_writebad_advice.json";//用户投诉接口
    public static final String cancelOrConfirmKFUrl = baseURL + "/v4/kanfang/broker_cancel_or_confirm.json";//经纪人端取消看房订单 或 确认看房



    /**
     * 上面是经纪人端常量
     */


    // public static final String registerUrl = baseURL + "/v4/userinfo/action_register.json";//用户注册
    public static final String getUserInfoUrl = baseURL + "/v2/userinfo/view_userdata.json";//获取用户信息
    public static final String setUserInfoUrl = baseURL + "/v4/userinfo/action_update.json";//更新用户信息

    public static final String MainNewHouseNumUrl = baseURL + "/v4/statistics/newhouse_getnum.json";//主页新房经纪人和楼盘数量
    public static final String reqMateBrokerUrl = baseURL + "/v4/newhouse/request_broker.json"; //需求匹配请求

    public static final String reqDisplayBrokerUrl = baseURL + "/v4/newhouse/display_broker.json";//显示已抢单的新房经纪人
    public static final String cancelBrokerUrl = baseURL + "/v4/newhouse/cancel_broker.json";//取消新房经纪人请求接口

    public static final String newHouseBrokerInfoUrl = baseURL + "/v4/brokerinfo/newhouse_brokerinfo.json";//获取经纪人基本信息
    public static final String bHuouseMoreUrl = baseURL + "/v4/newhouse/broker_house_more.json"; //新房经纪人主页: 查看更多楼盘列表
    public static final String bTalkMoreUrl = baseURL + "/v4/newhouse/broker_talk_more.json";//新房经纪人主页: 查看更多评论列表
    public static final String bFindGuanzhuUrl = baseURL + "/v4/allcollect/action_findrecord.json";//新房经纪人主页: 查看是否关注该经纪人接口
    public static final String bGuanzhuUrl = baseURL + "/v4/allcollect/action_insert_or_update.json";//新房经纪人主页: 关注经纪人接口 （注意: 通用的关注接口）
    public static final String bCancelGuanzhuUrl = baseURL + "/v4/allcollect/action_cancel.json";//新房经纪人主页: 取消关注经纪人接口
    public static final String selectBrokerUrl = baseURL + "/v4/newhouse/select_broker.json";//选择 预约 新房经纪人

    public static final String allBuidingUrl = baseURL + "/v4/newhouse/broker_allhouse_more.json";//新房经纪人主页: 查看经纪人所有房源信息
    public static final String buidingMainUrl = baseURL + "/v4/houseinfo/basedata.json";//房屋信息主页

    public static final String readNewSessMsgsUrl = baseURL + "/v4/message/newhousebroker_msgs_view.json"; //会话读取最新消息
    public static final String sendNesSessMsgUrl = baseURL + "/v4/message/newhousebroker_msgs_send.json";  //先发送信息到数据库，在发送openfrie;
    public static final String updataNewMsgHintUrl = baseURL + "/v4/message/newhousebroker_msgs_hasupdate.json";//get 主页左菜单我的消息未读提示
    public static final String readMyMsgListUrl = baseURL + "/v4/message/newhousebroker_msgs_liststate.json";//post 我的消息读取接口

    //public static final String DATABASE_Url = NDKString.getStringFromNative() + "?user="+ NDKString.getStringToResu() + "&password=" + NDKString.getStringTopaw() + "&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false";

    public static final int REQUEST_BASE_VALUE = 1000;
    public static final int BATCH_QUERY_DATA = 5;  //批量值,指每次从DB获取的行数
    public static final String DEFAULT_TOUXIANG_URL = "http://www.inetgoes.cn:8080/apk/touxiang.png";
    public static final String FIND_AREA_PROMPT = "请选择区域";
    public static final String FIND_HUXING_PROMPT = "请选择户型";
    public static final String FIND_BUILDTYPE_PROMPT = "物业类型";
    public static final String FIND_PRICE_PROMPT = "请选价格(万)";
    public static final String FIND_SORT_PROMPT = "排序";
    public static final String FIND_LOUPAN_PROMPT = "请选择楼盘";
    public static final String DEFAULT_LAT_VAL = "22.606195";   //当用户本地无法定位时,取此lat值,"龙华白石龙地块"
    public static final String DEFAULT_LNG_VAL = "114.048263";   //当用户本地无法定位时,取此lng值, "龙华白石龙地块"

    //非深圳的用户打开软件自动定位到坐标
    public static final String SZ_LAT_VAL = "22.548554";   //深圳市政府大楼,大鹏展翅
    public static final String SZ_LNG_VAL = "114.065944";   //深圳市政府

    public static final Integer DEFAULT_MAX_LINE_COUNT = 3;

    public static final Integer DOCTYPE_NORMAL_EVAL = 1;  //标准评测
    public static final Integer DOCTYPE_PERSON_EVAL = 2;  //个性化评测
    public static final Integer DOCTYPE_KANFANG_DIARY = 3;  //看房日记
    public static final Integer DOCTYPE_SUBJECT = 4;  //专题
    public static final Integer DOCTYPE_BROKER = 5;  //经记人

    public static final String PinTai_CallPhone = "4000887580";

    //顾问最大响应数 (求评测)
    public static final Integer MAX_RESPONSE_NUMBER_EVALREQ = 2;

    //顾问最大响应数 (预看房)
    public static final Integer MAX_RESPONSE_NUMBER_KANFANGREQ = 1;

    //顾问接单的最大限时天数
    public static final Integer MAX_RESPONSE_TIMEOUT_DAYS = 3;  //最多允许3天


    public static final Integer STEP_SCOPE_HOUSE = 1000;  //5000 for test only, 1000 for release


    public static final String[] IMAGES = new String[]{
            // Heavy images
            "http://www.ioncannon.net/wp-content/uploads/2011/06/test9.webp", // WebP image
            "http://4.bp.blogspot.com/-LEvwF87bbyU/Uicaskm-g6I/AAAAAAAAZ2c/V-WZZAvFg5I/s800/Pesto+Guacamole+500w+0268.jpg", // Image with "Mark has been invalidated" problem
            "file:///sdcard/Universal Image Loader @#&=+-_.,!()~'%20.png", // Image from SD card with encoded symbols
            "assets://Living Things @#&=+-_.,!()~'%20.jpg", // Image from assets
            "drawable://" + R.drawable.ic_launcher, // Image from drawables
            "https://www.eff.org/sites/default/files/chrome150_0.jpg", // Image from HTTPS
            "http://bit.ly/soBiXr", // Redirect link
            "http://img001.us.expono.com/100001/100001-1bc30-2d736f_m.jpg", // EXIF
            "", // Empty link
            "http://wrong.site.com/corruptedLink", // Wrong link
    };

    /**
     * 存放已选中的区域
     */
    public static List<Integer> mSelectAreas = new ArrayList<>();

    public static String mSelectArea_str;  //选中的区域字符串,多个用;隔开

    /**
     * 存放已选中的户型
     */
    public static List<Integer> mSelectHuxings = new ArrayList<>();

    public static String mSelectHuxing_str;  //选中的户型字符串,多个用;隔开


    /**
     * 存放已选中的配套
     */
    public static List<Integer> mSelectSupports = new ArrayList<>();

    public static String mSelectSupport_str;   //选中的配套字符串,多个用;隔开

    //是否第一次登入
    public static boolean isFirstLogin = false;


    private Constants() {
    }

    public static class Config {
        public static final boolean DEVELOPER_MODE = false;
    }

    public static class Extra {
        public static final String FRAGMENT_INDEX = "LOUPAN_PHOTO_FRAGMENT_INDEX";
        public static final String IMAGE_POSITION = "LOUPAN_PHOTO_IMAGE_POSITION";
    }

    //appid
    //请同时修改  androidmanifest.xml里面，.PayActivityd里的属性<data android:scheme="wx05f1a67e6deb49dc"/>为新设置的appid
    public static final String APP_ID = "wx05f1a67e6deb49dc";


    //商户号: 看房去
    public static final String MCH_ID = "1274890301";


    //  API密钥，在商户平台设置
    public static final String API_KEY = "kanfang761110qukanfang761110qu76";

    //added by czz
    public static String AppPayTransaction;          //订单号
    public static String AppPayLoupan_name;          //楼盘名称（评测名称）
    public static long AppPayTime;                 //交易时间
    public static float AppPayMoney;                //交易金额
    public static String AppPayWay = "APP微信支付";    //交易方式  //支付方式: APP微信支付，网页微信支付,APP支付宝
    public static String AppPayUserId;              //打赏人id
    public static String AppPayGuwenId;             //顾问id
    public static String AppPayLoupan_id;           //楼盘id（评测id）
    public static String AppPayDoctype;             //文档类型


    //4.0添加的intent 常量
    public static final String TRANID = "tranid_"; //事务id , 预约id

}
