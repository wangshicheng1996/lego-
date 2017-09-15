package lego;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("lego.mapper")//扫描Mapper包，为其创建代理对象
@EnableTransactionManagement //默认开启事务控制
public class LeGo {
	public static void main(String[] args) {
		SpringApplication.run(LeGo.class,args);
	}
}
