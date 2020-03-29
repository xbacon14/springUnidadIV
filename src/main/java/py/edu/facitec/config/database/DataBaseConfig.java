package py.edu.facitec.config.database;

import javax.activation.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DataBaseConfig {

	@Bean
	public DataSource getDatasource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		// dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
		dataSourceBuilder.url(
				"jdbc:mysql://localhost:3306/suscrito_db?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("84125497");
		return (DataSource) dataSourceBuilder.build();
	}

}
