package com.demo.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092100559076";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCyiSxk/yUe5h/+9TK0YsNMA657yxLvbttArqDC5FDxpbPevD2kEMYtlBJ0K+Is5EvkyXCoxdC7KzGoA1x7aMrlwFj9/E6QukYU8XksjUwGmBMEDapO6eL1MqHWQsVxBPvFiUy3fceF5cW5+4Yfxs9WTDxMQ2pPj0/veejRVan4a8OW93vWWjVXnTxbwpiqXd9YlNw1f/wlbSB0o3UJstldNC9OZ1EESF7iI09HzCrBBnUoQcbaUVWPnWx3ho8xWmLgxxGZ4TMfqcUHP8aJKSyzH83+0HRSfkrT87iNyjwYr428iO5o8kjQrf6DQ1fekln6gVDV5PBcwKcay00DNq8nAgMBAAECggEAZVUAEo7SNdhtfpsS3VlU+Xb5eJ/JLoagAPVcn2FRI+Zl0dzLq6wtnz70vmUN6WbmQIOo4tHr59/bPj4yJoVS69YhbH7g5Lok/swTd5r29KMp39oVuNZ9D6hePKsHP1+RuwtztI26SiAg+q9s7+o6UgPREYQN+fwgZY6u+umBIFKuSSP3mTbQNVLZzzNGbAjB0oz9Lis1S5E9LWntiH5p/larSMOxmJL9a8w/8hXKwfmjOIGLvjlx2TwSaOX6J+4aalmbFrbQZTOQ5nIwEnZztTERYLKkQ5Mt8jNoJU8yeSDAuu8IsPROgkSw63QfoYCEdF4whI0rMDQE6jiDX8Z0oQKBgQDpDnfp+soe8fNkmOmN1+iKo3xhDq3xTTMGQ12XEzWVTDWHtxb0Mh5kjb+Ppiwmglb4grEVsWzQxe1SjJ7/06AOxFjh4C4+Fh4362s7unEtpPVqyxddVRql+SJ/Je+8pKjdKgAB3l73z2D+9LpvvNy6DmBO/0yketA1ajhgT8vysQKBgQDEHKpDJpVs27NxUzIyp5LZlpg9FE3ymZSwRtISuC83r9cJNpHmZxXjdhgrTyLLbuuvUCTdnu3kUOeN3tEMN9bRnPTudWSknGR61hBjDQ4GCVJuehENbATNeKjrVAX3wpJtrciNnv0BHJZuTGja/TY04FJHNqAd0SNfQ6UsHLXFVwKBgQDYbLM2+cpRSma4eLgLHQG6HXAXwcYOW56SpmR3M0ODTa44RfJu+0v2HRxTjgFaEZgqV1OTzZw7lFJ7YlMVR7VPgU75E3Jd/bQ6QcjnQpBvzsyJS+h6p9mDYASFBvnGuTKHj8VJ9vNCNbbhjOrFcSGZNliBg9vsspA/ylBoQDIpQQKBgQCjDVY+mKDaLlyml06AMTV2dbBD8FLSpwCqA2f8KmkPusJmJZnu37yiLvjvYU+DpsiMLW1JWi9eiinLmftjVjXkd8RpUu+HsYQVYU+kmyESwcNomVL+PtZLY8vGRUjk80A9sqSxowOmXfdw41S25pqgIfYmwXMk91KajSqSX5h95wKBgQC54ZiyaWtgrQRkcjPVO3z3Yn+BVGa83sKnWQrNEZsGoUES+mR+zV1GevCbNDRjXtCMXL8qVy2yYEYBadPwdhrkGA8Wnqx9BityNlIUqs/+Stwvok+EWx1ifDnQ1bmCpdk0vju0GUDGSbk3TxetOrwS1mEUr7qWiAK0o43vZUsvWQ==";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
	// 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5b/b7BjQmz1N1m2EET8wbUsw2GJfrkZOGdzG0zDEARphfSaL3Qa+ZSEzSrTwHpEdkhVEQ4+mHPChl796DT1QTRxg8eOzM7BQlzctaga3x2HYDGy0Xeu162Ec+b4ohymQQji4eCT6A52sPL0zEnqBZG7fs178cfWfZ9b3OA+yP9o8nG6zFNpgs066ftq+9vc9Q0x1TZuI8MRExyMDXEA4isBbQF2P7dc7fVsueEorinTfuAiU2UGQU+npE5QFsom5UXxqkrTr6muMQQr+mRcHaBZB0ywbOQh7iX/rbzKgwQnO6uCEuAvG65S3TJsmZOCnUt0XcO9ilF7iFUuwVamnCwIDAQAB";

	// 这里的notify_url和return_url改成自己项目要返回页面的地址，由于是沙箱环境，所以支付宝网关也有修改。
	// return_url是指付款成功之后返回给用户查看的界面，如付款成功之后返回到商品详情或者网站首页等等
	// notify_url则是支付包与服务器交互的页面，用户看不到，支付成功以notify_url返回的参数或者查询订单返回的参数为准
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/Success.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/success.jsp";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord
	 *            要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
