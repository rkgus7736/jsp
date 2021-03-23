package config;
public interface DBConfig {
	public String DB_DRIVER = "oracle.jdbc.OracleDriver";
	public String DB_URL = "jdbc:oracle:thin:@localhost:32769:xe";
	public String DB_USER = "hyun";
	public String DB_PASS= "123456";
}
