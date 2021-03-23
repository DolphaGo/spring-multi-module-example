# spring-multi-module-example


### Version
- Java : 11
- SpringBoot: 2.4.4
- build : gradle



```
├── README.md
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── module-api
│   ├── build.gradle
│   ├── out
│   │   └── production
│   │       └── classes
│   │           ├── generated
│   │           └── me
│   │               ├── ModuleApiApplication.class
│   │               └── service
│   │                   └── MemberService.class
│   └── src
│       ├── main
│       │   ├── generated
│       │   ├── java
│       │   │   └── me
│       │   │       ├── ModuleApiApplication.java
│       │   │       └── service
│       │   │           └── MemberService.java
│       │   └── resources
│       └── test
│           ├── java
│           └── resources
├── module-common
│   ├── build.gradle
│   ├── out
│   │   └── production
│   │       ├── classes
│   │       │   ├── generated
│   │       │   └── me
│   │       │       ├── ModuleCommonApplication.class
│   │       │       ├── domain
│   │       │       │   └── Member.class
│   │       │       └── repository
│   │       │           └── MemberRepository.class
│   │       └── resources
│   │           └── application.yml
│   └── src
│       ├── main
│       │   ├── generated
│       │   ├── java
│       │   │   └── me
│       │   │       ├── ModuleCommonApplication.java
│       │   │       ├── domain
│       │   │       │   └── Member.java
│       │   │       └── repository
│       │   │           └── MemberRepository.java
│       │   └── resources
│       │       └── application.yml
│       └── test
│           ├── java
│           │   └── me
│           │       ├── ModuleCommonApplicationTests.java
│           │       └── repository
│           │           └── MemberRepositoryTest.java
│           └── resources
├── module-web
│   ├── build.gradle
│   ├── out
│   │   └── production
│   │       ├── classes
│   │       │   ├── generated
│   │       │   └── me
│   │       │       ├── ModuleWebApplication.class
│   │       │       └── controller
│   │       │           ├── MemberController.class
│   │       │           └── dto
│   │       │               ├── MemberRequestDto$MemberRequestDtoBuilder.class
│   │       │               └── MemberRequestDto.class
│   │       └── resources
│   │           └── application.yml
│   └── src
│       ├── main
│       │   ├── generated
│       │   ├── java
│       │   │   └── me
│       │   │       ├── ModuleWebApplication.java
│       │   │       └── controller
│       │   │           ├── MemberController.java
│       │   │           └── dto
│       │   │               └── MemberRequestDto.java
│       │   └── resources
│       │       └── application.yml
│       └── test
│           ├── java
│           └── resources
└── settings.gradle

```