package com.yc.util;

public class AlipayConfig {

public static String app_id = "2016101000653954";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDVcX+4kQ0GdVVwYlTCMgNu5ue/H0XluvV0FBssFzrnKjXnzxhCneVyiIpRGPRrphC/lVpJVbBSgtApq9uh8mUfD7Y7vRf6MV0QekqF510Q14ZguC4XqosSMjSei+dStV4sqW8iYwF+Duhm/PFqhnWhfEvI9fCz045Vh8y97rNSKSJRBrcP3MhGTtM5DZ6UkTST70efjnHbeaiw3Z9RZMWG4E7ptCDPrEzdWrSdTx2qzOdWtoDO4ORBlhawS/BXFOBFNrnQH0W/Fc2+dRyqLG5cn/KzSvRmY5kozwv5ypitFG00pYlTaq5pNTC4RlCTA54YPnpNOLgz22YoxukuuU13AgMBAAECggEBAIiwgOy/56mFJswsDL+4q74wHaWl72tpyZsm7SfVUKGNxKvJUm4HFFO+4WWCJ7VwyjUG/qUMPTj6ETk+mA8kXmH/++JR/LL7PfA5gNQ0EMOiYqo6CTqauylSAaSvT9sFz2Omtkc9RE1oWqjpv+lKZraeFSKDbjybdQGNUC8qWKh6B3OEZMGKa02Bl+fXqshN5h7aoJtJmyzn0PPQtE0z9lqjE/2RKUvZ6Q+OfEksqp4E5YGjLwMEypnfyjkhLAQNUzIHjdD3HvbLGJVSG9VFRtU5YNw81XB9dSPqgzZwSfIRGewRG3UyugO8dzVEzLcafbQ1cJBi6ydp1W/0UWUSKxECgYEA9kZZnkLEcIXM8wH/eS1jMTOYmk743VLg61BghY8y7gXph2V4/nizUmW4Rpeb8+m2ArGCQrT0i/ESvAtgLzVMDG3RHUjbL8knCaFuqZMiyRIPLXK6M3EepJqCSiraUkn2s9iGV5KwD2enmJStPe0INNZosxOCF5o989oAZYzpmvsCgYEA3d8/fEkz1akH1rcf/V2QB/Voeppv2GUBa/+UlVZBMOuQYCL79iLKDgOAP6Sc5p4wxUDpCvYFr10mKfOfH9OqNk4UCVFNoEBPjukA7bIVJhyV4ad964/Qv4FiDMp9KTqbwQOJiZ8q+v9RVjQ80ppsDbXOSIBWcIVh+4NnfIkvDrUCgYEAgv8wtEn3i5LgTXKGncJSvN0hExNmtPNcyE5cyS4+fPWQHoEPNuylFfMdbg8+2SM7uXsKOsleOwHkYTn706CZ7xKK5PTYAjcRGMJRxsmI+0Mr55TbDnnhPtUg8KqSrqrBGzDVZMeV9tu//h03eXUXpGNYFckOrddRlOAkzd+CcvkCgYAEYzXOL2RnBUCybkyjpgYDIkc+pW8wyE6O5C78BQik/wOL4yU4aNe2DzuqBodTyC0OuYniPZs/LIhkq/yplHX5PPIIfSMb2Cm6mcD68lqYtlgAbl9/GQj3wIc/2YFAH3iVCIzfu9YNwJ7LJZ1OTN92JfI+XMtYzkpxvtd9DvlvQQKBgQCFwJ+Z/0D8RaKC0byf5f++DjbBavJDSkk7pHJgBU0sr5X8lv7ZnCHU29TpwdnbG0VXFlleGHe0buDqyMA//vtlm4bY5cUkNPxtwPdx4uVh+rCjDsjuq3Bruj46+mE4rJeZLDsB92nTnIoNTaRGK6KjHKrpxYtY1xh3nK8TVFqqpw==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhSyTZg6z9k7vT5mOFfhpJfTlPR/qssS9zWwe0wFCSVOqk2/vq4+b667FniKsKs//Q3vEOcRCQ5yZhO/fTgKY85r6vsSgSaNdfmNdKc5CkkylHM/KtM1LXpZm3EpIK620h622gf/+PGV4jHgAC3lGLWVLLiZE3825ZpPmdaeQ443uXoLQB3sTu/2AQF8jub40dxtxo+hoqaP1hLV8VHm2CN4RBmQbg+Zcr2GESrKPuCEw/O5A/5k8ZNRr9JaJpEqwhjOxv1tfjxm387xYSGGgnUQMuWO30ATVaUJzpmGn/GMqQwIFclaq8+1Inw4kggu65cYW/aKxbAtdRFVT9pv9DQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://127.0.0.1:8080/shopping/order/buyNow.html";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:8080/shopping/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";
}
