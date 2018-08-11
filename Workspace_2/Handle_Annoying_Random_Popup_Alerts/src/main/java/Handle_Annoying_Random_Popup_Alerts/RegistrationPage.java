package Handle_Annoying_Random_Popup_Alerts;
public class RegistrationPage {

    private final WebDriver driver;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name = "register")
    private WebElement submit;

    public RegistrationPage(WebDriver driver) throws Exception {
        this.driver = driver;
        MyPageFactory.initElements(driver, this);
    }

    public RegistrationPage launch() {
        driver.get("http://newtours.demoaut.com/mercuryregister.php");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public RegistrationPage setUserName(String userName) {
        this.userName.sendKeys(userName);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public RegistrationPage setConfirmPassword(String confirmPassword) {
        this.confirmPassword.sendKeys(confirmPassword);
        return this;
    }

    public void submit() {
        this.submit.click();
    }
    RegistrationPage r = new RegistrationPage(driver);

    r.launch()
     .setFirstName("fn")
     .setLastName("ln")
     .setUserName("un")
     .setPassword("password")
     .setConfirmPassword("password");

}