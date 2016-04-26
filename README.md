![](http://therealdanvega.com/wp-content/uploads/2016/01/spring-logo.png)
# Spring-Boot
	- Starter POMs
	- YAML 파일 데이터 객체에 매핑하여 로드하기
	- Remote Shell
	- 서버 재시작 없이 개발하기

### 1. Starter POMs
spring-boot는 classpath에 jar들을 추가하기 쉽도록 다양한 'Starter POMs'를 제공한다.
spring에서 미리 설정하여 제공되는 'Starter POMs'들을 사용하여 애플리케이션 개발에 필요한 의존성 설정을 간소화 할 수 있다.

일반적인 log4j 설정 방법
```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>jcl-over-slf4j</artifactId>
    <version>1.7.21</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>jul-to-slf4j</artifactId>
    <version>1.7.21</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.21</version>
</dependency>
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>2.4.1</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>4.2.5.RELEASE</version>
    <exclusions>
        <exclusion>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

Spring Boot log4j 설정
```xml
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-log4j</artifactId>
	</dependency>
```

참고링크:  
- [using-boot-maven](http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-build-systems.html#using-boot-maven)
- [using-boot-starter-poms](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#using-boot-starter-poms)
- [appendix-dependency-versions](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#appendix-dependency-versions)

### 2. YAML 파일 데이터 객체에 매핑하여 로드하기
YAML은 JSON에 포함되며 계층적인 설정 데이터를 정의하는데 매우 편리한 문법을 가지고 있다. 
spring-boot-starter에 이미 SnakeYAML 라이브러리가 포함되어 별도로 추가하지 않아도 YAML을 사용할 수 있다. 

참고링크:
- [boot-features-external-config-yaml](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-external-config-yaml)

### 3. Remote Shell
스프링부트는 'CRaSH'라고 불리는 자바 쉘을 제공한다. 
CRaSH를 이용해서 애플리케이션 안에서 ssh 혹은 telnet 을 사용할 수 있다. 

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-remote-shell</artifactId>
</dependency>
```

```bash
$ ssh -p 2000 user@localhost
login as: user
SSH server: Password authentication
Using keyboard-interactive authentication.
Password:
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::  (v1.3.3.RELEASE) on AD01123665
> help
Try one of these commands with the -h or --help switch:

NAME       DESCRIPTION
autoconfig Display auto configuration report from ApplicationContext
beans      Display beans in ApplicationContext
cron       manages the cron plugin
dashboard  a monitoring dashboard
egrep      search file(s) for lines that match a pattern
endpoint   Invoke actuator endpoints
env        display the term env
filter     a filter for a stream of map
java       various java language commands
jmx        Java Management Extensions
jul        java.util.logging commands
jvm        JVM informations
less       opposite of more
mail       interact with emails
man        format and display the on-line manual pages
metrics    Display metrics provided by Spring Boot
shell      shell related command
sleep      sleep for some time
sort       sort a map
system     vm system properties commands
thread     JVM thread commands
help       provides basic help
repl       list the repl or change the current repl
```

참고링크:  
- [production-ready-remote-shell](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready-remote-shell)
- [crash-reference](http://www.crashub.org/1.3/reference.html)

### 4. 서버 재시작 없이 개발하기
spring-loaded는 개발환경에서 java클래스를 수정했을 때 변경된 클래스 파일만을 재로딩해준다.
local 개발 환경에서 일어나는 잦은 was 재시작을 줄여준다.  

1. Spring-Loaded
    - [spring-projects/spring-loaded](https://github.com/spring-projects/spring-loaded)
    - [howto-hotswapping](http://docs.spring.io/spring-boot/docs/current/reference/html/howto-hotswapping.html)
2. 재기동 없이 반영 가능한 범위
    - Reload Java Classes
    - Reload Freemarker Templates
    - Reload Thymeleaf
    - Reload Groovy Templates
    - Reload Static Resources

maven build
```bash
spring-boot:run
```

shutdown
```yml
# application.yml
endpoints:
  shutdown:
    enabled: true
```
```bash
$ curl -X POST localhost:8080/shutdown
```

pom.xml
```xml
<plugin>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
	<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>springloaded</artifactId>
			<version>1.2.6.RELEASE</version>
		</dependency>
	</dependencies>
</plugin>
```

참고링크:  
- [howto-reload-java-classes-without-restarting](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#howto-reload-java-classes-without-restarting)
