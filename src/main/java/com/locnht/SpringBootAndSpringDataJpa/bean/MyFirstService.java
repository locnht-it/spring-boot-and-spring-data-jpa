//package com.locnht.SpringBootAndSpringDataJpa.bean;
//
//import com.locnht.SpringBootAndSpringDataJpa.bean.MyFirstClass;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
////@PropertySource("classpath:custom.properties")
////@PropertySources({
////        @PropertySource("classpath:custom-file-2.properties"),
////        @PropertySource("classpath:custom.properties")
////})
//public class MyFirstService {
////    private Environment environment;
//
////    @Value("Locnht")
////    private String customProperty;
//
////    @Value("123")
////    private Integer customPropertyInt;
////
////    @Value("${my.prop}")
////    private String customPropertyFromAnotherFile;
////
////    @Value("${my.prop.2}")
////    private String customPropertyFromAnotherFile2;
//
//    @Value("${my.custom.property}")
//    private String customProperty;
//
//    @Value("${my.custom.property.int}")
//    private Integer customPropertyInt;
//
////  Constructor Injection
//    private final MyFirstClass myFirstClass;
//
//
//    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }
//
//// Field Injection
////    @Autowired
////    @Qualifier("bean1")
////    private MyFirstClass myFirstClass;
//
//// Method Injection
////    private MyFirstClass myFirstClass;
////    @Autowired
////    public void injectDependencies(@Qualifier("mySecondBean") MyFirstClass myFirstClass) {
////        this.myFirstClass = myFirstClass;
////    }
//
//    public String tellAStory() {
//        return "the dependency is saving: " + myFirstClass.sayHello();
//    }
//
//    public String getCustomProperty() {
//        return customProperty;
//    }
//
//    public Integer getCustomPropertyInt() {
//        return customPropertyInt;
//    }
//
////    public String getCustomPropertyFromAnotherFile() {
////        return customPropertyFromAnotherFile;
////    }
////
////    public Integer getCustomPropertyInt() {
////        return customPropertyInt;
////    }
////
////    public String getCustomProperty() {
////        return customProperty;
////    }
////
////    public String getCustomPropertyFromAnotherFile2() {
////        return customPropertyFromAnotherFile2;
////    }
//
////    public String getJavaVersion() {
////        return environment.getProperty("java.version");
////    }
////
////    public String getOsName() {
////        return environment.getProperty("os.name");
////    }
////
////    public String readProperties() {
////        return environment.getProperty("my.custom.property");
////    }
////
////    @Autowired
////    public void setEnvironment(Environment environment) {
////        this.environment = environment;
////    }
//}
