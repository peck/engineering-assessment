package com.moon.constant;

import org.apache.commons.lang3.time.FastDateFormat;

public interface Constant {

    /**
     * 常用符号
     */
    interface CommonlySymbols {

        /**
         * 百分号
         */
        String PERCENT = "%";

        /**
         * 斜杠
         */
        String SLASH = "/";

        /**
         * 连接信息
         */
        String C = "-c ";

        /**
         * 用户名
         */
        String U = " -u ";

        /**
         * 密码
         */
        String P = " -p ";

        /**
         * 表名
         */
        String T = " -t ";

        /**
         * 输入路径
         */
        String E = " -e ";

        /***
         * 分割符
         */
        String F = " -f ";

        /**
         * 逗号
         */
        String COMMA = ",";

        /**
         * 下划线
         */
        String UNDERLINE = "_";

        /**
         * 标识符
         */
        String TAG = "@";

        /**
         * 左中括号
         */
        String LEFT_PARENTHESIS = "[";

        /**
         * 右中括号
         */
        String RIGHT_PARENTHESIS = "]";
        /**
         * 点
         */
        String DOT = ".";

        /**
         * 是
         */
        String Y = "y";

        /**
         * 是
         */
        String N = "n";

        /**
         * 问号
         */
        String INTERROGATION_MARK = "?";

        /**
         * 左括号
         */
        String LEFT_BRACKET = "(";

        /**
         * 右括号
         */
        String RIGHT_BRACKET = ")";
        /**
         * 冒号
         */
        String COLON = ":";

        /**
         * 分号
         */
        String SEMICOLON = ";";

        /**
         * 双斜杠
         */
        String DOUBLE_SLASH = "//";

        /***
         * 换行
         */
        String LINE_FEED = "\n";

        /**
         * 转义点
         */
        String ESCAPE_DOT = "\\.";

        /**
         * 回车换行
         */
        String LINE_BREAK_FEED = "\r\n";

        /**
         * 连接标识
         */
        String CONNECTION = "&";

        /**
         * +号
         */
        String JIA = "\\+";

        /**
         * 中划线
         */
        String STRIKETHROUGH = "-";

        /**
         * 空
         */
        String EMPTY = "";

        /**
         * 空格
         */
        String EMPTY_BLANK = " ";

        /**
         * 两个空格
         */
        String DOUBLE_EMPTY_BLANK = "   ";

        /**
         * 竖划线
         */
        String VERTICAL_LINE = "\\|";

        /**
         * 单引号
         */
        String SINGLE_QUOTE = "'";

        /**
         * 顿号
         */
        String PAUSE_MARK = "、";

        /**
         * 左中括号中文
         */
        String LEFT_PARENTHESIS_ZH = "【";

        /**
         * 右中括号中文
         */
        String RIGHT_PARENTHESIS_ZH = "】";

        /**
         * 制表符
         */
        String TAB = "\t";


    }


    /**
     * 动作类型
     */
    interface ActionType {

        /**
         * 查询
         */
        String QUERY_ZH = "查询";

        /**
         * 编辑
         */
        String EDIT_ZH = "编辑";

        /**
         * 更新
         */
        String UPDATE_ZH = "更新";

        /**
         * 新增
         */
        String ADD_ZH = "新增";

        /**
         * 删除
         */
        String DELETE_ZH = "删除";

        /**
         * 导出
         */
        String EXPORT_ZH = "导出";

        /**
         * 导入
         */
        String INPUT_ZH = "导入";

        /**
         * 审核
         */
        String EXAMINE_ZH = "审核";

        /**
         *
         * 无
         */
        String NOTHING = "无";

        /**
         *
         * 保存
         */
        String SAVE_ZH = "保存";


        /**
         * 查询
         */
        String QUERY = "QUERY";

        /**
         * 编辑
         */
        String EDIT = "EDIT";

        /**
         * 更新
         */
        String UPDATE = "UPDATE";

        /**
         * 新增
         */
        String ADD = "ADD";

        /**
         * 删除
         */
        String DELETE = "DELETE";

        /**
         * 导出
         */
        String EXPORT = "EXPORT";

        /**
         * 导入
         */
        String IMPORT = "IMPORT";

        /**
         * 审核
         */
        String EXAMINE = "EXAMINE";

        /**
         * 保存
         */
        String SAVE = "SAVE";

        /**
         * 插入
         */
        String INSERT = "INSERT";

    }


    /**
     * 状态类型
     */
    interface StatusType {

        /**
         * OK
         */
        String OK = "OK";

        /**
         * 继续
         */
        String CONTINUE = "CONTINUE";


    }



    /**
     * 常用数字
     */
    interface Digital {

        int ZERO = 0;

        int ONE = 1;

        int TWO = 2;

        int THREE = 3;

        int FOUR = 4;

        int FIVE = 5;

        int SIX = 6;

        int SEVEN = 7;

        int EIGHT = 8;

        int NINE = 9;

        int TEN = 10;

        int SEVENTEEN = 17;

        int NINETEEN = 19;

        int TWENTY = 20;

        int SEVENTY_TWO = 72;


        /**
         * 一百
         */
        int ONE_HUNDRED = 100;

        int TWO_HUNDRED = 200;

        int THREE_HUNDRED = 300;

        /**
         * 五百
         */
        int FIVE_HUNDRED = 500;

        /**
         * 八百
         */
        int EIGHT_HUNDRED = 800;

        /**
         * 一千
         */
        int ONE_THOUSAND = 1000;

        int TWO_THOUSAND = 2000;

        int THREE_THOUSAND = 3000;

        /**
         * 五千
         */
        int FIVE_THOUSAND = 5000;

        /**
         * 百万
         */
        int MILLION = 1000000;


        String STRING_ZERO = "0";

        String STRING_ONE = "1";

        String STRING_TWO = "2";

        String STRING_THREE = "3";

        String STRING_FOUR = "4";

        String STRING_FIVE = "5";

        String STRING_SIX = "6";

        String STRING_SEVEN = "7";

        String STRING_EIGHT = "8";

        String STRING_NINE = "9";

        String STRING_TEN = "10";

        String STRING_TWENTY = "20";

    }


    /**
     * 日期时间格式
     */
    interface DatePattern {

        /**
         * 时间分区标识
         */
        String DT = "dt";

        /***
         * 小时
         */
        String HOURS = "hours";


        String NORM_DATE_PATTERN = "yyyy-MM-dd";

        String NORM_TIME_PATTERN = "HH:mm:ss";

        String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";

        String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

        String NORM_DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

        String CHINESE_DATE_PATTERN = "yyyy年MM月dd日";

        String PURE_DATE_PATTERN = "yyyyMMdd";

        String PURE_TIME_PATTERN = "HHmmss";

        String PURE_DATETIME_PATTERN = "yyyyMMddHHmmss";

        String PURE_DATETIME_MS_PATTERN = "yyyyMMddHHmmssSSS";

        String HTTP_DATETIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
        String JDK_DATETIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";
        String UTC_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";

        String SLASH_NORM_DATE_PATTERN = "yyyy/MM/dd";
        FastDateFormat SLASH_NORM_DATE_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd");

        String SLASH_NORM_DATETIME_PATTERN = "yyyy/MM/dd HH:mm:ss";
        FastDateFormat SLASH_NORM_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");

        String START_TIME = "00:00:00";
        String BLANK_START_TIME = " 00:00:00";

        String END_TIME = "23:59:59";
        String BLANK_END_TIME = " 23:59:59";

        String BLANK_PURE_DATETIME_PATTERN = "yyyyMMdd HH:mm:ss";

    }


    /**
     * boolean类型值
     */
    interface BooleanFlag {

        Boolean FALSE = false;  // 错误

        Boolean TRUE = true;  // 正确
    }


    /**
     * Excel文件常用属性
     */
    interface ExcelProperty {

        /**
         * WPS版本Excel
         */
        String XLS_SUFFIX = ".xls";

        /**
         * Office版本Excel
         */
        String XLSX_SUFFIX = ".xlsx";

    }


    /**
     * 网络协议常用值
     */
    interface HttpMessage {

        /**
         * http
         */
        String HTTP = "http";

        /**
         * https
         */
        String HTTPS = "https";

        int HTTP_200_CODE = 200;

        String HTTP_200_MESSAGE = "success";

        String HTTP_200_MESSAGE_CN = "请求成功";

        int HTTP_301_CODE = 301;

        String HTTP_301_MESSAGE = "HTTP 301 Moved Permanently Moved Permanently";

        String HTTP_301_MESSAGE_CN = "永久重定向";

        int HTTP_302_CODE = 302;

        String HTTP_302_MESSAGE = "HTTP 302 Found";

        String HTTP_302_MESSAGE_CN = "临时重定向";

        int HTTP_400_CODE  = 400;

        String HTTP_400_MESSAGE = "HTTP 400 Bad Request";

        String HTTP_400_MESSAGE_CN = "请求错误";

        int HTTP_403_CODE  = 403;

        String HTTP_403_MESSAGE = "HTTP 403 Forbidden";

        String HTTP_403_MESSAGE_CN = "禁止访问";

        int HTTP_404_CODE  = 404;

        String HTTP_404_MESSAGE = "HTTP 404 Not Found";

        String HTTP_404_MESSAGE_CN = "请求的内容未找到或已删除";

        int HTTP_500_CODE  = 500;

        String HTTP_500_MESSAGE = "HTTP 500 Internal Server Error";

        String HTTP_500_MESSAGE_CN = "服务器端程序错误";

        int HTTP_502_CODE  = 502;

        String HTTP_502_MESSAGE = "HTTP 502 Bad Gateway";

        String HTTP_502_MESSAGE_CN = "网关无响应";

        int HTTP_503_CODE  = 503;

        String HTTP_503_MESSAGE = "HTTP 503 Service Unavailable";

        String HTTP_503_MESSAGE_CN = "服务器端临时错误";

        int HTTP_504_CODE  = 504;

        String HTTP_504_MESSAGE = "HTTP 504 Gateway Timeout";

        String HTTP_504_MESSAGE_CN = "网关超时";

        String UTF_UPPER = "UTF-8";

        String UTF_LOWER = "utf-8";

        String CONTENT_DISPOSITION = "Content-Disposition";

        String ATTACHMENT_FILENAME = "attachment;filename=";

        String HTTP_SERVLET_RESPONSE_EXCEL_CONTENT_TYPE = "application/vnd.ms-excel;charset=utf-8";

    }


}
