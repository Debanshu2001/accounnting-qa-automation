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



