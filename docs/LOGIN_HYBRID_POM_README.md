# Eclipse-style Hybrid POM package mapping

```text
src/main/java
├── base/TestBase.java
├── driver/DriverManager.java
├── pages/PageBase.java
├── pages/LoginPage.java
├── pages/AccountsOverviewPage.java
├── pages/RegisterPage.java
└── utils/Constants.java
    utils/ScreenshotUtil.java

src/test/java
└── testCase/TC001_LoginUser.java

src/test/resources
├── Myapp.properties
└── testng.xml
```

The login cases converted from the ParaBank suite are:

- `TC-LOGIN-001`: valid login — `verifyValidLogin()`
- `TC-LOGIN-002`: invalid password — `verifyInvalidPasswordLogin()`
- `TC-LOGIN-003`: invalid username — `verifyInvalidUsernameLogin()`
- `TC-LOGIN-004`: blank credentials — `verifyBlankLoginFields()`
- `TC-LOGOUT-001`: successful logout — `verifySuccessfulLogout()`

Run with `mvn clean test`. Override browser or credentials without editing the properties file:

```bash
mvn clean test -Dbrowser=firefox -Dusername=john -Dpassword=demo
```
