# 🧩 Quiz Application APIs

This document defines the core APIs used in the Quiz Application for data fetching and result storage.

---

## 📘 1. Fetch Grade-Subject Mapping Data

* **Endpoint:** `/api/grades`
* **Method:** `GET`
* **Description:** Fetches the list of grades and associated subjects and topics.

---

## 📘 2. Fetch List of Question Sets for the Selection

* **Endpoint:** `/api/question-sets`
* **Method:** `GET`
* **Query Parameters:**
  - `grade`
  - `subject`
  - `topic`
  - `difficulty`
  - `page`
  - `pageSize`

* **Response Data:**
  * Question Set Identifier Details
    - `id`
    - `title`
    - `code`
  
  * Question Set Metadata
    - `description`
    - `total_questions`
    - `created_at`

  * Question Set Difficulty Tags
    - `easy`
    - `medium`
    - `hard`
  
  * User Attempt Details (if user is signed in)
    - `status`: `Completed` / `In Progress` / `Not Started`
    - `last_attempted_on`
    - `latest_score`
    - `attempt_count`

---

## 📘 3. Fetch Questions from a Selected Question Set

* **Endpoint:** `/api/question-sets/:setId/questions`
* **Method:** `GET`

* **Response Data:**
  * Question List with Metadata
    - Question Type
      - `fib` (Fill in the Blank)
      - `mcq` (Multiple Choice)
      - `scq` (Single Choice)
      - `multi-part` (Composite question with sub-questions)

    - Question Text
      - Text content (markdown or HTML supported)

    - Question Options
      - Array of options (if applicable)

    - Question Full Marks
      - `marks`: numeric value

    - Marking Type
      - `partial`
      - `full`

---

## 📘 4. Store Result on Each Submit

* **Endpoint:** `/api/quiz/submit`
* **Method:** `POST`

* **Request Payload:**
  * Store Aggregated Result
    - `user_id` (optional - present only if the user is logged in)
    - `session_id`
    - `quiz_id`
    - `score`
    - `submitted_at`
    - `status`: completed / in-progress

  * Store User Response for a Session
    - `questions`: array of objects
      - `question_id`
      - `selected_options`
      - `marks_obtained`
      - `is_correct`
      - `time_spent`

* **Response:**
  - `status`: success or failure
  - `next_steps`: link to result review or dashboard

---
