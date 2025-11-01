# Automation Testing Framework

A robust **Selenium + Appium Test Automation Framework** for Web and Mobile applications, supporting execution on **Local Devices, Cloud (BrowserStack)**, and integration with **Jenkins, Jira, and Zephyr**.

---

## 📌 Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Running Tests Locally](#running-tests-locally)
- [Running Tests on BrowserStack](#running-tests-on-browserstack)
- [Maven Commands](#maven-commands)
- [Environment Setup](#environment-setup)
- [Jenkins CI/CD Setup](#jenkins-cicd-setup)
- [ADB Commands](#adb-commands)
- [Git & GitHub Setup](#git--github-setup)
- [Jira & Zephyr Integration](#jira--zephyr-integration)

---

## ✅ Features
- 🌐 **Web Automation** (Local & Cloud)
- 📱 **Mobile Automation (Android/iOS)** (Local & Cloud) using Appium
- ⚡ **Parallel execution** using TestNG
- 🧪 **Cucumber BDD with TestNG runners**
- ☁️ **Cloud Execution** support (BrowserStack)
- ✅ **Integrations:**
  - **Jenkins** (CI/CD)
  - **Jira & Zephyr Squad Cloud** (Test Management)
- 📊 **Reporting Support** (Extent Reports / Cucumber HTML)

---

## 📁 Project Structure (Example)
```
src
├── main
│   ├── java
│   └── resources
└── test
    ├── java
    │   └── cucumber
    │       └── testRunners
    └── resources
        └── testng
pom.xml
README.md
```

---

## 💻 Prerequisites
| Tool | Version |
|------|---------|
| Java | 17 (OpenJDK) |
| Maven | 3.6+ |
| Appium | 3.1.0 |
| Android Studio | Latest |
| IntelliJ IDEA | Recommended |
| Git | Latest |

---

## ▶ Running Tests Locally

### ✅ Start Appium Server
```bash
appium
```

### ✅ Execute Tests
| Command | Description |
|---------|-------------|
| `mvn clean test -Plocal` | Run tests locally |
| `mvn clean test -PandroidLocal` | Run tests on connected Android device |
| `mvn clean test -PwebLocal` | Run Selenium Web tests on local |

### ✅ Update Cucumber Test Runner
- Modify tags in `src/test/java/cucumber/testRunners/*Runner.java`
- Update thread count in TestNG XML (`testng/local.xml`)

---

## ☁ Running Tests on BrowserStack

### ✅ BrowserStack Execution Flow:
1. Upload your app using REST API or Web UI  
2. Add BrowserStack credentials in `config.properties` *(Do not commit credentials!)*  
3. Run using:
```bash
mvn clean test -Pbrowserstack
```

---

## ⚙ Maven Commands
| Description | Command |
|-------------|---------|
| Clean & test | `mvn clean test` |
| Run with profile | `mvn clean test -P<profile>` |
| Run specific test class | `mvn -Dtest=ClassName test` |

---

## ⚙ Environment Setup

### 🖥 System Variables (Windows)
| Variable | Value |
|----------|-------|
| JAVA_HOME | `C:\Program Files\Java\jdk-17.0.2` |
| ANDROID_HOME | `C:\Users\<user>\AppData\Local\Android\Sdk` |
| Path | `%JAVA_HOME%\bin`, `%ANDROID_HOME%\platform-tools` |

---

## 🚀 Jenkins CI/CD Setup

### Step 1: Configure Tools
Set these in **Manage Jenkins → Global Tool Configuration**:
| Tool | Path |
|------|------|
| JDK | `C:\Program Files\Java\jdk-17.0.2` |
| Maven | `C:\Program Files\apache-maven-3.6.1\bin` |

### Step 2: Install Plugins
- Maven Integration Plugin  
- Pipeline Plugin  

### Step 3: Create Pipeline Job
Example Jenkinsfile:
```groovy
pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }
    stages {
        stage('Checkout') {
            steps { git 'https://github.com/user/repo.git' }
        }
        stage('Test') {
            steps { sh 'mvn clean test -Pbrowserstack' }
        }
    }
}
```

---

## 🔌 ADB Commands
| Command | Description |
|---------|-------------|
| `adb devices` | List connected devices |
| `adb install <apk>` | Install APK on device |
| `adb uninstall <package>` | Uninstall app |

---

## 🐙 Git & GitHub Setup

### Generate SSH Key
```bash
ssh-keygen -t rsa
```

### Push Project
```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/<username>/<repo>.git
git push -u origin main
```

---

## 🛠 Jira & Zephyr Integration
- Generate API Key from Jira Account Settings  
- Create Base64 token: `"email:api_key"`  
- Use header:  
  ```
  Authorization: Basic <base64-string>
  ```

---

## ✅ Best Practices
✔ Do not push credentials to GitHub  
✔ Use `.gitignore` to exclude logs, apk, target/, credentials  
✔ Maintain separate `config.properties` per environment  
✔ Use Maven profiles for `dev`, `qa`, `androidLocal`, `browserstack`  

---

Feel free to contribute or raise issues!

---

**Author:** Hari Babu Maila  
**GitHub:** https://github.com/harigithub1  
