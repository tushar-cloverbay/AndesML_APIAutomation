package net.andesml.base;

public class Constants extends Base{

	public static String ENV = "dev";
	public static double START_VERSION = 1.0;
	public static double END_VERSION = 1.0;
	
	public static String campaign_manager_domain = "https://dev.campaign.api.andesml.com";
	public static String ADSE_domain = "https://dev.adserv.api.andesml.com";
	public static String tenant_id = "629886dcc2311500bd86854a";
	public static String advertiser_id = "629885bdc2311500bd868549";
	public static String seller_id = "629885bdc2311500bd868549";
	public static String tenant_name = "MontenBaik";
	public static String advertiser_name = "CrossMountain";
	public static String seller_name = "CrossMountain";
	public static String user = "admin@crossmountain.com";
	public static String password = "Qazwsx@1";
	public static String client_id = "next-web-app";
	public static String client_secret = "Avahk6aRa7sS9At9eFzNMCcb22ZULHj6";
	public static String trace_id = "123-abc-456";
	public static String access_token_url = "https://dev.auth.andesml.com/auth/realms/andesml/protocol/openid-connect/token";
	
	public static String access_token_url_client_cred ="https://dev.auth.andesml.com/auth/realms/andesml/protocol/openid-connect/token";
	public static String client_id_client_cred = "9eb2b827-5049-4dc8-a581-098c67213eaf";
	public static String client_secret_client_cred = "3FZrVXMFb7D8PKy3WGKXELYXJubptoas";
	public static String trace_id_client_cred = "tx_123";
	
	public static void loadEnv() {
		String env = System.getProperty("env");
			ENV = env;
	}
	public static String loadAccountURL(String version) {
		String URI="";
		return URI;
	}
	public static void loadVersions() {
		String Sversion = System.getProperty("StartVersion");
		String Eversion = System.getProperty("EndVersion");
		START_VERSION = Double.parseDouble(Sversion);
		END_VERSION = Double.parseDouble(Eversion);
		if(campaignId==null) {
			campaignId = "62c1c8dc4af0193b7dd3fb13";
		}
		if(campaignName==null) {
			campaignName = "Test_22";
		}
	}
}
