package com.fun.config;


import org.apache.http.Header;

import java.util.Arrays;
import java.util.List;

import static com.fun.config.Constant.DEFAULT_CHARSET;
import static com.fun.frame.httpclient.FanLibrary.getHeader;

/**
 *
 */
public class HttpClientConstant {

    static PropertyUtils.Property propertyUtils = PropertyUtils.getProperties("http");

    static String getProperty(String name) {
        return propertyUtils.getProperty(name);
    }

    /**
     * 默认user_agent
     */
    public static Header USER_AGENT = getHeader("User-Agent", getProperty("User-Agent"));

    /**
     * 从连接池中获取可用连接最大超时时间 单位：毫秒
     */
    public static int CONNECT_REQUEST_TIMEOUT = 5 * 1000;

    /**
     * 连接目标url最大超时 单位：毫秒
     */
    public static int CONNECT_TIMEOUT = 5 * 1000;

    /**
     * 等待响应（读数据）最大超时 单位：毫秒
     */
    public static int SOCKET_TIMEOUT = 15 * 1000;

    /**
     * 连接池最大连接数
     */
    public static int MAX_TOTAL_CONNECTION = 2000;

    /**
     * 每个路由最大连接数
     */
    public static int MAX_PER_ROUTE_CONNECTION = 500;

    /**
     * 最大header数
     */
    public static int MAX_HEADER_COUNT = 100;

    /**
     * 消息最大长度
     */
    public static int MAX_LINE_LENGTH = 10000;

    /**
     * 设置的本机ip
     */
    public static String IP = SysInit.getRandomIP();

    /**
     * 连接header设置
     */
    public static Header CONNECTION = getHeader("Connection", getProperty("Connection"));

    public static Header CLIENT_IP = getHeader("Client-Ip", IP);

    public static Header HTTP_X_FORWARDED_FOR = getHeader("HTTP_X_FORWARDED_FOR", IP);

    public static Header WL_Proxy_Client_IP = getHeader("WL-Proxy-Client-IP", IP);

    public static Header Proxy_Client_IP = getHeader("Proxy-Client-IP", IP);

    public static Header X_FORWARDED_FOR = getHeader("X-FORWARDED-FOR", IP);

    public static Header ContentType_JSON = getHeader("Content-Type", "application/json");

    public static Header ContentType_FORM = getHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET.toString());

    public static Header ContentType_TEXT = getHeader("Content-Type", "text/plain");

    public static Header X_Requested_KWith = getHeader("X-Requested-With", "XMLHttpRequest");

    /**
     * 重试次数
     */
    public static int TRY_TIMES = 3;

    /**
     * 关闭超时的链接
     */
    public static int IDLE_TIMEOUT = 100;

    /**
     * 在设置请求contenttype参数，表示请求以io流发送数据
     */
    public static String CONTENTTYPE_MULTIPART_FORM = "multipart/form-data";

    /**
     * 在设置请求contenttype参数，表示请求以文本发送数据
     */
    public static String CONTENTTYPE_TEXT = "text/plain";

    /**
     * 请求头，cookie
     */
    public static String COOKIE = "cookie";

    /**
     * SSL版本
     */
    public static String SSL_VERSION = getProperty("ssl_v");

    public static List<String> BLACK_HOSTS = Arrays.asList(getProperty("black_host").split(","));

    /**
     * 公共的header集合
     */
    public static List<Header> COMMON_HEADER = Arrays.asList(X_FORWARDED_FOR, Proxy_Client_IP, WL_Proxy_Client_IP, USER_AGENT, CONNECTION, CLIENT_IP, HTTP_X_FORWARDED_FOR);
}