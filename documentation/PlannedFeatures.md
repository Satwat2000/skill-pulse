# 📚 Quiz Application: Features Overview

This document outlines the key features of the **Quiz Application**, designed to provide a comprehensive self-assessment platform for users, along with robust administrative capabilities.

---

## 🚀 Core Features

### 🧠 Quiz Attempting Methods

The application supports two distinct ways for users to attempt quizzes:

#### ✅ Way 1: Standard Question Sets
- **Navigation:** Users select **Grade**, **Subject**, **Topic** and **Difficulty** levels.
- **Selection:** Users choose specific, **pre-defined question sets** to attempt.
- **Attempting:** Quiz begins with the selected set.
- **Completion & Results:** 
  - Answers and attempts are **automatically stored**.
  - Quiz results are displayed to the user.

#### 🔄 Way 2: Random Question Sets
- **Navigation:** Users select **Grade**, **Subject**, **Topic** and **Difficulty** levels.
- **Selection:** Choose the **"Random question"** option to generate a dynamic quiz.
- **Attempting:** Users attempt randomly generated questions.
- **Real-time Feedback:**
  - Responses are sent to the backend **in real-time**.
  - Frontend shows **immediate correctness** of answers.
- **Completion & API Call:**
  - Displays results on completion.
  - Triggers API call to mark quiz as completed.

---

## 👤 Features for Logged-In Users

### 📌 Completion Status Display
- Each question set shows a status:
  - `Completed`
  - `In Progress`
  - `Not Started`

### 🔍 Quiz Review Option
- Review submitted quizzes.
- View:
  - All questions
  - User answers
  - Correct answers
  - Attempt score

### 🔁 Restart Quiz Option
- Restart any completed question set.
- System tracks **each attempt** made by the user.
- Default view shows the **latest attempt's results**.

### 📈 Progress Tab
- **Recent Attempts:** Last _n_ attempted quizzes with status.
- **Section-wise Progress:** Breakdown by `Grade > Subject > Section`.
- **Activity Heat Map:** Day-wise visual map of quiz activity.

### 🧑‍💼 Profile Options
- **Reset Password**
- **Update User Details**
- **Modify Avatar**
- **Purchase Plans:** Access to time-based premium plans.
- **Modify Grade Selection:** Customize visible grades (all visible by default).

---

## 🔒 Administrative Features

### 🛠️ Admin Profile Features
- **Content Mapping Management:** 
  - Manage hierarchical mappings: `Grade > Subject > Topic`.
- **Question Tagging:**
  - Organize using robust tagging system.
- **Question Creation:**
  - Create questions with:
    - Type: multiple choice / single choice
    - Format: text / image
- **Question Set Creation:**
  - Define and create sets using existing questions.

---

## 👑 Super Admin Card Features

### 🧑‍💻 User Management
- List all users
- Modify user details
- Update user profiles

---

## 🚪 Login Flow

### 🔓 Login Without Verification
- No email verification required
- System ensures temporary **session IDs**

### 🔐 Login With Verification
- Requires **email verification**
- Provides enhanced account security
- track user performance

---
