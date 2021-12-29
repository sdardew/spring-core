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
