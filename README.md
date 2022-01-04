# 1 객체 지향 설계와 스프링
## 1.1 객체 지향 프로그래밍
- 컴퓨터 프로그램을 여러개의 독립된 단위 "객체"들의 모임으로 파악하고자 하는 것
- 객체는 메시지를 주고 받고 데이터를 처리
- 프로그램을 유연하고 변경이 용이하게 만듦

## 1.2 다형성
- 역할(인터페이스)과 구현(구현 클래스 OR 객체)으로 세상을 구분
  - ex) 정렬 알고리즘: 정렬 알고리즘은 "정렬"의 역할은 동일하지만, 버블 정렬, 퀵 정렬 등 다양한 방법으로 구현이 가능하다.
- 단순해지고 유연해지며 수정이 용이

### 1.2.1 장점
- 대상의 역할(인터페이스)만 알아도 됨
- 내부 구조를 몰라도 됨
- 대상의 구조나 대상 자체가 변경되어도 영향을 받지 않음
- 같은 인터페이스를 구현한 객체라면 실행 시점에 유연하게 변경 가능

### 1.2.2 한계
- 역할(인터페이스) 자체가 변경되면 전체적으로 큰 변경이 발생
- 인터페이스를 잘 설계하는 것이 중요

## 1.3 SOLID
> 로버트 마틴이 정리한 좋은 객체 지향 설계의 5가지 원칙

### 1.3.1 SRP (단일 책임 원칙, Single Responsibility Principle)
- 한 클래스는 하나의 책임만 가져야 한다
- 변경이 있을 때 파급 효과가 적으면 SRP을 잘 지킨 설계이다

### 1.3.2 OCP (개방-폐쇄 원칙, Open Closed Principle)
- 소프트웨어 요소는 확장에는 열러 있고 변경에는 닫혀 있어야 한다
- 다형성을 활용하여 새로운 클래스를 만들어 새로운 기능을 구현한다
- 구현 객체를 변경할 때, 코드의 변경이 발생할 수 있다 => 연관 관계를 맺어주는 별도의 설정자를 사용하여 해결

### 1.3.3 LSP (리스코프 치환 원칙, Liskov Substitution Principle)
- 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다
- 다형성을 위해서 하위 클래스들은 인터페이스 규약을 다 지켜야지만, 믿고 사용할 수 있다
- 컴파일 성공을 넘어서는 원칙이다
  - 메서드 명이 add인데 값이 감소한다면 LSP 위반이다

### 1.3.4 ISP (인터페이스 분리 원칙, Interface Segregation Principle)
- 구체적인 클래스에 대해 모든 규칙이 다 있는 인터페이스 하나보다는 여러 개의 인터페이스가 낫다
- 인터페이스가 명확해지고 대체 가능성이 높아진다

### 1.3.5 DIP (의존관계 역전 원칙, Dependency Inversion Principle)
- 추상화에 의존해야지, 구체화에 의존하면 안 된다
- 구현 클래스에 의존하는 것이 아닌, 인터페이스에 의존하는 것이다
- 역할에 의존하는 것이다
- 의존성 주입은 DIP를 위한 하나의 방법이다

## 1.4 스프링과 객체 지향
- 스프링은 다형성을 극대화하여 이용할 수 있게 도와준다
- 스프링은 DI와 DI 컨테이너를 제공하여 다형성과 OCP, DIP를 가능하게 지원한다
- 코드의 변경 없이 기능을 확장할 수 있다

### 1.4.1 무조건 인터페이스를 사용해야 할까?
- 인터페이스를 도입하면 추상화라는 비용이 발생한다
  - 확장할 가능성이 없다면, 구체 클래스를 직접 사용한다
  - 필요할 때 리팩토링을 사용하여 인터페이스를 도입한다

<br /><br />

# 2 IoC & DI & 컨테이너

## 2.1 IoC (제어의 역전, Inversion of Control)
- 프로그램의 제어 흐름을 직접 제어하는 것이 아닌 외부에서 관리하는 것
- 구현 객체는 자신의 로직을 실행하는 역할만 담당

## 2.2 프레임워크 VS 라이브러리
- 프레임워크는 내가 작성한 코드를 제어하고 대신 실행
- 직접 제어의 흐름을 개발자가 담당한다면 라이브러리

## 2.3 DI (의존 관계 주입, Dependency Injection)
- 인터페이스에 의존하여 실제로는 어떤 구현 객체가 사용될지는 모른다
- 애플리케이션 실행 시점(런타임)에 외부에서 실제 구현 객체를 생성하고 전달하여 의존 관계를 연결
- 정적인 클래스 의존 관계를 변경하지 않으면서 동적인 객체 인스턴스 의존 관계를 쉽게 변경 가능

### 2.3.1 정적인 클래스 의존 관계
- `import`만 보고 판단 가능

### 2.3.2 동적인 클래스 의존 관계
- 애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결

## 2.4 IoC 컨테이너 & DI 컨테이너
- 객체를 생성, 관리, 의존 관계 연결해주는 컨테이너
- 어샘블러, 오브젝트 팩토리 등으로도 불림

<br /><br />

# 3 스프링 컨테이너 & 스프링 빈

## 3.1스프링 컨테이너
- `ApplicationContext`를 스프링 컨테이너라고 한다
    - `ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);`와 같이 등록한다
    - `applicationContext.getBean()`메서드를 사용하여 스프링 빈을 찾을 수 있다
``` java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
```
- `@Configuration`이 붙은 클래스를 설정 정보로, `@Bean`이라 적힌 메서드를 모두 호출하여 반환된 객체를 스프링 컨테이너에 등록한다
- 스프링 컨테이너에 등록된 객체를 `스프링 빈`이라고 한다
- 스프링 빈은 `@Bean`이 붙은 메서드 명을 스프링 빈의 이름으로 사용한다
    - 위의 예제에서는 memberReponsitory이다

## 3.2 스프링 컨테이너 생성 과정
### 3.2.1 스프링 컨테이너 설정
``` java
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
```
- `ApplicationContext`를 스프링 컨테이너라 한다
- `ApplicationContext`는 인터페이스이다
- 스프링 컨테이너는 XML 혹은 annotation이 있는 자바 설정 클래스로 만들수 있다
- `ApplicationContext`는 `BeanFactory`를 구현하고 있다
    - `BeanFacotry`는 빈을 생성하고 의존성을 주입하는 IoC의 기본 기능에 초점을 맞춘 것이다
    - `ApplicationContext`는 별도의 정보를 참고해서 빈 생성 및 의존성 주입 등의 제어에 초점을 맞춘 것이다
![image](https://user-images.githubusercontent.com/86591021/147638642-f3a47706-3dac-4dc4-841c-e574eff35196.png)
- 스프링 컨테이너를 생성할 때는 구성 정보를 지정해 주어야 한다
- 위의 코드에서는 `AppConfig.class`가 구성 정보로 지정되었다

### 3.2.2 스프링 빈 등록
- 스프링 컨테이너는 파라미터로 넘어온 설정 클래스 정보를 사용하여 스프링 빈을 등록한다

#### 빈 이름을 결정하는 방법
- 메서드 이름
- 직접 부여
    - `@Bean(name="beanName")`

> 빈 이름은 **중복이 되어서는 안 된다.** 같은 이름을 부여하면 *다른 빈이 무시*되거나 *기존 빈을 덮어*버리거나와 같은 오류가 발생한다

### 3.2.3 스프링 빈 의존 관계 설정
- 스프링 컨테이너는 설정 정보를 참고해서 의존 관계를 주입한다
- 스프링 빈을 생성하고, 의존 관계를 주입하는 단계가 나누어져 있다

## 3.3 컨테이너에 등록된 빈 조회

### 3.3.1 모든 빈 조회
``` java
// 스프링 빈 설정 정보 등록
AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

// 스프링 빈 모든 이름 조회
String[] beanDefinitionNames = ac.getBeanDefinitionNames();

// 등록된 빈 이름으로 빈 가져옴
for (String beanDefinitionName : beanDefinitionNames) {
    Object bean = ac.getBean(beanDefinitionName);
}

// 빈 Definition 출력
for (String beanDefinitionName : beanDefinitionNames) {
    BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
    
    // 직접 등록한 애플리케이션 빈을 가져옴
    BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
    if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
        Object bean = ac.getBean(beanDefinitionName);
    }
}
```
- `getBeanDefinitionNames()`: 스프링에 등록된 모든 빈 이름을 조회한다
- `getBean()`: 빈 이름으로 빈 객체를 조회한다
    - `getBean()`사용 방법
        - `getBean(빈이름, 타입)`: Object가 아닌 타입에 해당하는 객체로 리턴
        - `getBean(타입)`
    - 조건에 해당되는 빈이 없다면 예외 발생
        - `NoSuchBeanDefinitionException`
- `getRole()`: 빈의 역할을 알 수 있다
    - `ROLE_APPLICATION`: 사용자가 정의한 빈
    - `ROLE_INFRASTRUCTURE`: 스프링이 내부에서 사용하는 빈

### 3.3.2 타입이 중복되는 빈 조회
- `getBean(타입)`으로 조회할 때, 같은 타입의 스프링 빈이 둘 이상이면 `NoUniqueBeanDefinitionException` 오류가 발생한다
- `getBeansOfType()`을 사용하면 해당 타입의 모든 빈을 조회할 수 있다
``` java
Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

for (String key : beansOfType.keySet()) {
    System.out.println("key = " + key + " value = " + beansOfType.get(key));
}
```

### 3.3.3 상속 관계의 빈 조회
- 부모 타입으로 빈을 조회하면, 자식 타입도 같이 조회한다
- 자바 객체의 최상단에 위치한 `Object` 타입으로 조회하면, 모든 스프링 빈을 조회한다


## 3.4 BeanFactory & ApplicationContext
![image](https://user-images.githubusercontent.com/86591021/147641450-32dd2b6d-9c07-4e9d-85df-5904787ef461.png)
- BeanFactory와 ApplicationContext 모두 스프링 컨테이너에 해당된다

### 3.4.1 BeanFactory
- 스프링 컨테이너의 최상위 인터페이스
- 스프링 빈을 관리하고 조회
- `getBean()` 제공

### 3.4.2 ApplicationContext
![image](https://user-images.githubusercontent.com/86591021/147641673-44e360eb-0fd3-4d2e-bf6b-5d3dc05c391d.png)
- BeanFactory 기능을 상속받아서 제공
- BeanFactory 인터페이스 외에도 다른 인터페이스들을 상속 받음
- ApplicationContext의 기능
    - 빈을 관리하고 조회
    - 메시지소스를 활용한 국제화 기능
        -  국가마다 웹 페이지가 제공하는 언어가 다름
    - 환경 변수
        - 로컬, 개발, 운영 등을 구분하여 처리
    - 애플리케이션 이벤트
        - 이벤트를 발행하고 구독하는 모델 지원
    - 편리한 리소스 조회
        - 파일, 클래스패스 등 리소스를 편리하게 지원

## 3.5 다양한 설정 형식
![image](https://user-images.githubusercontent.com/86591021/147641947-b8c8a9b7-543d-4056-a987-fd057c6085ca.png)
- 스프링 컨테이너는 다양한 형식으로 설정 정보를 받아들일 수 있다

### 3.5.1 Annotation 기반의 설정
- 자바 파일로 Appconfig 클래스를 작성하여 `new AnnotationConfigApplicationContext(AppConfig.class)`와 같이 설정 정볼르 넘김

### 3.5.2 XML 설정
- `GenericXmlApplicationContext`를 사용하여 xml 설정 파일을 넘김
- XML을 사용하면 컴파일 없이 빈 설정 정보를 변경할 수 있다
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <bean id="memberService" class="hello.core.member.MemberServiceImpl">
        <constructor-arg name="memberRepository" ref="memberRepository" />
    </bean>
    
    <bean id="memberRepository" class="hello.core.member.MemoryMemberRepository" />
    
    <bean id="orderService" class="hello.core.order.OrderServiceImpl">
            <constructor-arg name="memberRepository" ref="memberRepository" />
            <constructor-arg name="discountPolicy" ref="discountPolicy" />
    </bean>
    
    <bean id="discountPolicy" class="hello.core.discount.RateDiscountPolicy" />
</beans>
```

## 3.6 스프링 빈 설정 메타 정보 - BeanDefinition
![image](https://user-images.githubusercontent.com/86591021/147643292-15043a71-f3d7-4b32-9161-d8f5e6eddb1b.png)
- 스프링은 `BeanDefinition`으로 설정 정보를 추상화 하여 사용한다
- XML, 자바 코드를 읽어서 `BeanDefinition`을 생성한다
    - ~BeanDefinitionReader을 만들어서 `BeanDefinition`을 생성한다
- 스프링 컨테이너는 `BeanDefinition`을 가지고 스프링 빈을 생성한다
- `BeanDefinition`은 설정 메타 정보라고 한다
    - `@Bean`, `<bean>`당 하나씩 메타 정보가 생성된다

### 3.6.1 BeanDefinition 정보
- BeanClassName: 생성할 빈의 클래스 명
- factoryBeanName: 팩토리 역할의 빈을 사용할 경우 이름
- factoryMethodName: 빈을 생성할 팩토리 메서드 지정
- Scope: 싱글톤(기본값)
- lazyInit: 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때 까지 최대한 생성을 지연처리 하는지 여부
- InitMethodName: 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드 명
- DestroyMethodName: 빈의 생명주기가 끝나서 제거하기 직전에 호출되는 메서드 명
- Constructor arguments, Properties: 의존관계 주입에서 사용한다. (자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)

<br /><br />

# 4 싱글톤 컨테이너

## 4.1 싱글톤 패턴
- 클래스의 인스턴스가 1개만 생성되는 디자인 패턴
- 객체가 1개만 생성되고 공유
- private 생성자를 사용하여 외부에서 new 키워드를 사용하지 못하도록 막음
- 메모리 낭비를 방지

``` java
public class SingletonService {
    
    // 인스턴스 생성
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }
    
    // private 생성자
    private SingletonService() {
    }
}
```
- getInstance() 메서드를 사용하여 객체를 사용할 수 있음

### 4.1.1 싱글톤 패턴의 문제점
- 코드가 길어짐
- DIP & OCP 위반: 클라이언트가 구체 클래스에 의존
- 테스트가 어려움
- 내부 속성 변경 및 초기화가 어려움
- private 생성자 => 상속 불가능
- 유연성이 떨어짐
- 안티패턴

## 4.2 싱글톤 컨테이너
- 스프링 컨테이너는 객체 인스턴스를 싱글톤으로 관리
- 스프링 컨테이너는 싱클톤 역할을 함
  - 싱글톤 레지스트리: 싱글톤 객체를 생성하고 관리하는 기능
- 스프링 빈은 싱글톤으로 관리되는 빈
- 만들어진 객체를 공유하여 효율적으로 재사용

## 4.3 싱글톤 패턴을 사용할 때 주의할 점
- 싱글톤 방식은 상태를 유지하게 설계하면 안 됨
- stateless하게 설계하는 방법
  - 클라이언트 의존적인 필드가 있으면 안 됨
  - 클라이언트가 값을 변경할 수 있으면 안 됨
  - 되도록 읽기만 가능
  - 필드 대신 지역변수, 파라미터, ThreadLocal 사용

## 4.4 @Configuration
- CGLIB 기술을 적용하여 @Bean이 싱글톤 객체가 되는 것을 보장
- 스프링 빈이 존재하면 존재하는 빈을 반환
- 빈이 없다면 생성하여 스프링 빈을 등록하고 반환
- @Configuration 없이 @Bean만 사용하면 스프링 빈으로 등록 되지만 싱글톤을 보장하지 않음

<br /><br />

# 5 컴포넌트 스캔
## 5.1 컴포넌트 스캔과 의존관계 자동 주업
- 스프링은 설정 정보가 없어도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔 기능 제공
- `@Autowired`를 통한 의존관계 자동 주입 기능 제공

### 5.1.1 `@ConponentScan`
- `@ConponentScan`을 설정 정보에 추가하여 사용
- `@Component` 어노테이션이 붙은 클래스를 스캔하여 스프링빈으로 등록

### 5.1.2 컴포넌트 스캔과 자동 주입 방식
1. `@ComponentScan`
- `@ComponentScan`은 `@Component`가 붙은 클래스를 스프링 빈으로 등록
- 스프링 빈의 등록 이름
  - 클래스명에서 맨 앞글자만 소문자로 변경하여 이름으로 사용: SpringBean -> springBean
  - @Component("원하는이름")으로 빈의 이름을 지정할 수도 있음

2. `@Autowired` - 의존 관계 자동 주입
- `@Autowired`가 붙은 대상에 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입
- 타입이 같은 빈을 찾아서 주입

## 5.2 컴포넌트 스캔의 대상
### 5.2.1 컴포넌트 스캔 대상 패키지
- `@ComponentScan`이 붙은 클래스가 위치한 패키지가 기본 시작 위치
- `basePackage`로 탐색할 패키지의 시작 위치 지정 가능
  - 경로가 한 개: `@ComponentScan(basePackages="base.pkg")`
  - 경로가 여러 개: `@ComponentScan(basePackages={"base.pkg1", "base,pkg2"})` 방식으로 시작 위치 지정 가능

### 5.2.2 컴포넌트 스캔 대상 클래스
- `@Component`: 컴포넌트 스캔에 사용
- `@Contoroller`: 스프링 MVC 컨트롤러에서 사용
- `@Service`: 스프링 비즈니스 로직에서 사용
- `@Repository`: 스프링 데이터 접근 계층에서 사용
- `@Configuration`: 스프링 설정 정보에서 사용

![image](https://user-images.githubusercontent.com/86591021/147912173-7383c71d-5438-4a07-9888-81b85ee59586.png)
- 위의 이미지를 보면 `@Component`, `@Repository`, `@Service`, `@Controller`라고 어노테이션이 붙어 있는 클래스들이 대상되어 있음
- 위의 기능을 false로 하면 기본 스캔 대상에서 제외
![image](https://user-images.githubusercontent.com/86591021/147912409-e520baa0-14f0-4274-b2a9-91ef7d0452e6.png)
- `@Configuration`은 `@Component` 어노테이션이 붙어 있음

## 5.3 컴포넌트 스캔 필터
- `includeFilters`: 컴포넌트 스캔 대상을 추가로 지정
- `excludeFilters`: 컴포넌트 스캔에서 제외할 대상을 지정

### 5.3.1 Annotation을 사용한 스캔 대상 지정
1. 스캔 대상인지 아닌지 표현할 어노테이션 생성
``` java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
```
2. 생성한 어노테이션을 클래스 위에 붙임
3. `@ComponentScan`에 추가하여 표헌
``` java
@ComponentScan(
  includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
  excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
)
```

### 5.3.2 FilterType 옵션
- ANNOTATION: 기본 값. 어노테이션으로 판단.
- ASSIGNABLE_TYPE: 지정한 타입과 자식 타입
- ASPECTJ: AspectJ 패턴
- REGEX: 정규표현식
- CUSTOM: `TypeFilter` 인터페이스 구현하여 사용

## 5.4 중복과 충돌
### 5.4.1 자동 빈 등록 VS 자동 빈 등록
- 컴포넌트 스캔에의해 자동으로 빈을 등록할 때 스프링 빈의 이름이 같다면 `ConflictingBeanDefinitionException` 예외 발생

### 5.4.2 수동 빈 등록 VS 자동 빈 등록
- 수동 빈 등록이 우선권
- 수동 빈이 자동 빈을 오버라이딩
- 스프링 부트에서는 수동 빈 등록과 자동 빈 등록 충돌에서는 오류가 자동으로 발생하는 것이 기본 값
  - properties에 `spring.main.allow-bean-definition-overriding=true`을 추가하면 오버라이딩이 됨

<br /><br />

# 6 의존 관계 

## 6.1 의존 관계 주입 방법
- 생성자 주입
- setter 주입
- 필드 주입
- 일반 메서드 주입


### 6.1.1 생성자 주입
- 생성자를 통해서 의존 관계를 주입
- 생성자 호출 시점에 1번만 호출
- **불변, 필수** 의존 관계에 사용
- **생성자가 1개** 있으면 `@Autowired`을 생략 해도 **자동으로 주입** 됨

### 6.1.2 setter 주입
- setter 메서드를 통해서 주입
- **선택, 변경** 가능성이 있는 의존 관계에 사용

### 6.1.3 필드 주입
- 필드에 바로 주입
- 코드가 간결
- 외부에서 변경이 불가능하여 테스트하기 어려움
- DI 프레임 워크가 없으면 아무것도 할 수 없음

> `@Autowired`를 통한 자동 주입은 스프링 컨테이너가 관리하는 스프링 빈에만 해당

## 6.2 옵션 처리
- `@Autowired`만 사용하면 `required` 옵션의 기본값이 true로 되어 있어 자동 주입 대상이 없으면 오류 발생
- 주입할 스프링 빈이 없을 때는 다른 옵션을 주어서 처리

### 6.2.1 자동 주입 대상을 옵션으로 처리
- `@Autowired(required = false)`: 자동 주업할 대상이 없을 때 호출이 안 됨.
- `@Nuallable`: 파라미터 앞에 삽입. 자동 주입할 대상이 없을 때 `null` 입력.
- `Optional<>`: 자동 주입할 대상이 없을 때 `Optional.empty` 입력.

> `@Autowired(required = false)`는 대상이 없다면 호출이 되지 않지만 나머지는 대상이 없어도 호출된다. 대신 다른 값을 입력한다.

## 6.3 생성자 주입 권장
- 대부분의 의존 관계는 애플리케이션 종료 전가지 변하면 안 됨
- 수정자 주입은 setter 메서드를 public으로 열어야 함 -> 변경하면 안 되는 메서드를 열어두는 것은 좋은 설계가 아님
- 생성자 주입은 객체 생성시 1번만 호출되어 불변

### 6.3.1 생성자 주입과 final
- 생성자 주입을 사용하면 필드에 `final` 키워드 사용 가능
- 값이 설정되지 않는 에러를 방지
- 기본으로 생성자 주입을 사용하고, 필수 값이 아닌 경우에는 setter 주입을 사용하여 부여 하면 됨

> 생성자 주입을 제외한 나머지 주입 방식은 생성자 이후에 호출되어, final 키워드를 사용할 수 없음

## 6.3.2 롬복
- 생성자가 1개만 있으면 `@Autowired`생략 가능
- `@RequiredArgsConstructor`은 final이 붙은 필드에 대해서 생성자를 만듦

## 6.4 조회된 빈이 2개 이상
- `@Autowired`는 타입으로 빈을 조회
- 상위 타입에 해당하는 하위 타입의 빈이 2개 이상일 때 문제가 발생
- 하위 타입으로 지정을 하면 DIP를 위배

### 6.4.1 조회된 빈이 2개 이상일 때 해결 방법
- @Autowired + 필드명
- @Qualifier
- @Primary

#### @Autowired + 필드명
1. 타입 매칭을 시도
2. 매칭 결과가 2개 이상이면 필드 이름, 파라미터 이름으로 매칭
``` java
private People people;
```
``` java
private People student;
```

#### @Qualifer
- 추가 구분자를 붙여주는 방법
1. 빈 등록시 `@Qualifier`와 이름을 지정
2. 주입시 파라미터 앞에 `@Qualifier`와 이름 지정
3. 매칭되는 `@Qualifier`이 없으면 빈 이름으로 매칭
4. 2와 3에서 찾을 수 없다면 `NoSuchBeanDefinitionException` 발생 
 
#### @Primary
- 우선순위를 정하는 방법
- `@Primary`가 붙은 빈이 우선권을 가짐
- 
> `@Primay`와 `@Qulifier`이 있다면 `@Qualifier`이 더 높은 우선순위를 가진다. 넓은 범위의 선택권 보다는 좁은 범위의 선택권이 우선 순위가 높다.

## 6.5 어노테이션 만들기
- `@Qualifier`은 오타가 발생했을 때 컴파일 시 체크가 안 됨
- 어노테이션을 만들어 `@Qualifier`을 상속받아 해결 가능

1. Annotation 생성
``` java
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier("mainBean")
public @interface MainBean {
}
```

2. Annotation을 @Qualifier 자리에 추가
``` java
@Component
@MainDiscountPolicy
public class ChildClass implements ParentClass {}
```

```
//생성자 자동 주입
@Autowired
public DIClass(@MainBean ParentClass parentClass) {
  this.parentClass = parentClass;
}

//수정자 자동 주입
@Autowired
public ParentClass setParentClass(@MainBean ParentClass parentClass) {
  return parentClass;
}
```

## 6.6 여러개 빈을 조회 - List, Map
- `Map<String, ParentClass>`: 키로 스프링 빈의 이름으로 빈을 조회할 수 있음

> 스프링 컨테이너 생성자는 파라미터로 클래스 정보를 받는다. 받은 클래스 정보의 해당 클래스가 스프링 빈으로 자동 등록된다.
> `new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class)`: AutoAppConfig class와 DiscountService 클래스 등록

<br /><br />

