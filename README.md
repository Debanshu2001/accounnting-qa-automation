# accounnting-qa-automation
**Application under test:** http://webapp.qedgetech.com/login.php  
**Type:** Stock Inventory Management (demo app used by QEdge Technologies)

This repository contains **Manual Testing** and **Automation Testing** deliverables.

---

## Folder Structure

```
StockAccounting_Testing/
│
├── Manual_Testing/
│   └── Manual_Test_Cases.xlsx          ← Manual test cases (Excel)
│
├── Automation_Testing/                 ← Selenium + Java + TestNG + Cucumber
│   ├── pom.xml
│   ├── testng.xml
│   ├── src/test/java/
│   │   ├── runners/TestRunner.java
│   │   ├── stepDefinitions/LoginSteps.java
│   │   ├── pages/LoginPage.java
│   │   └── utilities/
│   │       ├── BaseClass.java
│   │       └── ConfigReader.java
│   └── src/test/resources/
│       ├── config.properties
│       └── features/Login.feature
│
└── README.md
```

---

## 1. Manual Testing

**File:** `Manual_Testing/Manual_Test_Cases.xlsx`

| Sheet              | Content                                      |
|--------------------|----------------------------------------------|
| Manual Test Cases  | 20 detailed test cases (Login, Home, Suppliers, Customers, Stock, UI) |
| Summary            | Priority count & status legend               |
| How to Use         | Instructions for execution                   |

**How to use:**
1. Open the Excel file.
2. Execute test cases one by one.
3. Update **Status** column (`Pass` / `Fail` / `Blocked` / `Not Executed`).
4. Fill **Actual Result / Comments**.

**Note on credentials:**  
Common demo credentials are often `admin` / `master`.  
If they do not work, use the **Register** link on the login page and update the Test Data column.

---

## 2. Automation Testing (Selenium + Java + TestNG + Cucumber)

### Prerequisites
- JDK 11 or higher
- Maven 3.8+
- Eclipse / IntelliJ IDEA
- Chrome / Firefox / Edge browser

### How to run in Eclipse

1. **Import as Maven Project**
   - File → Import → Existing Maven Projects
   - Select the `Automation_Testing` folder

2. **Update credentials** (if needed)  
   Open: `src/test/resources/config.properties`

3. **Run**
   - Right-click `TestRunner.java` → Run As → TestNG Test  
   **OR**
   - Right-click `testng.xml` → Run As → TestNG Suite

4. **Reports**  
   Generated at: `target/cucumber-reports/cucumber.html`

### Run from command line

```bash
cd Automation_Testing
mvn clean test
```

### Framework highlights
- **Page Object Model** (LoginPage)
- **Cucumber BDD** feature files
- **TestNG** runner
- **WebDriverManager** (auto driver download)
- Configurable browser & credentials via `config.properties`
- Tags: `@Smoke`, `@Positive`, `@Negative`

---

## 3. Create GitHub Repository

```bash
# From the root folder StockAccounting_Testing
git init
git add .
git commit -m "Initial commit: Manual + Automation Testing for Stock Accounting (QEdge)"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/StockAccounting_Testing.git
git push -u origin main
```

Replace `YOUR_USERNAME` with your GitHub username.

---

## 4. Next Steps (optional enhancements)

- Add more Cucumber features (Suppliers, Customers, Stock)
- Integrate Extent Reports / Allure
- Add data-driven tests with Excel
- Cross-browser parallel execution
- CI/CD with GitHub Actions

---

**Created for QEdge-style Stock Accounting practice project.**
