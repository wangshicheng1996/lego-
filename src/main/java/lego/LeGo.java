package lego;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("lego.mapper")//扫描Mapper包，为其创建代理对象
public class LeGo {
	public static void main(String[] args) {
		SpringApplication.run(LeGo.class,args);
	}
}
