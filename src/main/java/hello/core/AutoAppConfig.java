package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 설정 정보인 것을 알려줌
@ComponentScan(
        basePackages = "hello.core", // 탐색을 시작할 패키지, defulat AutoAppConfig가 위치하는 클래스 부터
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // AppConfig 클래스 등록을 막음
)
public class AutoAppConfig {
}
