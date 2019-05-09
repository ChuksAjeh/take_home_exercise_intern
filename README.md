Response:
Assumptions: I assumed there was no need for validation as only a basic response was required. therefore any submissions to the form page
            must work under said assumption.
Commands: Whilst there are no specific commands per se, I did edit the build gradle file and therefore to ensure that the code submitted works
         please erase the current contents and of said file and replace with the following:
 --------------------------------------------------------------------------------------------
 apply plugin: 'java'
 apply plugin: 'org.springframework.boot'
 apply plugin: 'io.spring.dependency-management'
 apply plugin: 'idea'

 repositories {
     mavenCentral()
     maven { url 'http://repo.spring.io/milestone' }
 }

 buildscript {
     repositories {
         mavenCentral()
     }
     dependencies {
         classpath('io.spring.gradle:dependency-management-plugin:0.6.1.RELEASE')
         classpath('org.springframework.boot:spring-boot-gradle-plugin:2.0.5.RELEASE')
     }
 }

 configurations {
     runtimeLibs
 }

 dependencies {
     compile 'org.springframework.boot:spring-boot-starter-web'
     compile 'org.springframework.boot:spring-boot-starter-test'
     compile 'org.springframework.boot:spring-boot-starter-thymeleaf'
 }

 ------------------------------------------------------------------------------------------------

 thoughts: all code is commented where necessary or vague otherwise the code should be fairly self explanatory
            Lastly for part 1: the quote method in the Quote controller class was edited to support the webpage request.
            if using an application such as postman, please comment out the @Controller tag and the two methods above and then
            uncomment the @RestController tag and the commented method below said two. Thank you.



