Below is the **updated and restructured schema**, incorporating your revised `ResourceMappings` and `Tags` tables with corrected and clarified relationships across all relevant tables:

---



### 📘 Table: `Grades`

| Column Name  | Type         | Key    | Nullable | Constraints / Description    |
| ------------ | ------------ | ------ | -------- | ---------------------------- |
| `id`         | INT          | PK     | No       | Auto-increment primary key   |
| `name`       | VARCHAR(255) |        | No       | Display name of the grade    |
| `code`       | VARCHAR(100) | UNIQUE | No       | Machine-readable unique code |
| `sort`       | INT          |        | Yes      | For ordering grades in UI    |
| `updated_at` | TIMESTAMP    |        | No       | Last update timestamp        |
| `created_at` | TIMESTAMP    |        | No       | Record creation timestamp    |

#### 🔗 Relationships

* One-to-Many: `Grades (1)` → `ResourceMappings (many)` via `grade_id`

--- 
<br><br>

### 📘 Table: `Subjects`

| Column Name  | Type         | Key    | Nullable | Constraints / Description   |
| ------------ | ------------ | ------ | -------- | --------------------------- |
| `id`         | INT          | PK     | No       | Auto-increment primary key  |
| `name`       | VARCHAR(255) |        | No       | Subject name                |
| `code`       | VARCHAR(100) | UNIQUE | No       | Subject code                |
| `sort`       | INT          |        | Yes      | Ordering within grade/level |
| `updated_at` | TIMESTAMP    |        | No       | Last update timestamp       |
| `created_at` | TIMESTAMP    |        | No       | Record creation timestamp   |

#### 🔗 Relationships

* One-to-Many: `Subjects (1)` → `ResourceMappings (many)` via `subject_id`

---
<br><br>

### 📘 Table: `Topics`

| Column Name  | Type         | Key | Nullable | Constraints / Description     |
| ------------ | ------------ | --- | -------- | ----------------------------- |
| `id`         | INT          | PK  | No       | Auto-increment primary key    |
| `name`       | VARCHAR(255) |     | No       | Topic title                   |
| `sort`       | INT          |     | Yes      | Ordering within subject/grade |
| `updated_at` | TIMESTAMP    |     | No       | Last update timestamp         |
| `created_at` | TIMESTAMP    |     | No       | Record creation timestamp     |

#### 🔗 Relationships

* One-to-Many: `Topics (1)` → `ResourceMappings (many)` via `topic_id`

---
<br><br>

### 📘 Table: `Questions`

| Column Name  | Type               | Key | Nullable | Constraints / Description         |
| ------------ | ------------------ | --- | -------- | --------------------------------- |
| `id`         | INT                | PK  | No       | Unique identifier                 |
| `question`   | TEXT               |     | No       | Question content                  |
| `type`       | ENUM(QuestionType) |     | No       | Single-choice, Multi-choice, etc. |
| `updated_at` | TIMESTAMP          |     | No       | Last updated                      |
| `created_at` | TIMESTAMP          |     | No       | Created timestamp                 |

#### 🔗 Relationships

* One-to-Many: `Questions (1)` → `Options (many)` via `question_id`
* One-to-Many: `Questions (1)` → `ResourceMappings` (via `resource_id` and `resource_type='QUESTION'`)
* One-to-Many: `Questions (1)` → `Tags` (via `resource_id` and `resource_type='QUESTION'`)

---
<br><br>

### 📘 Table: `Options`

| Column Name   | Type             | Key | Nullable | Constraints / Description          |
| ------------- | ---------------- | --- | -------- | ---------------------------------- |
| `id`          | INT              | PK  | No       | Auto-increment primary key         |
| `option_text` | TEXT             |     | Yes      | Answer choice text (if any)        |
| `media_link`  | VARCHAR(255)     |     | Yes      | Image/audio URL (if media option)  |
| `type`        | ENUM(OptionType) |     | No       | Text/Image/etc.                    |
| `is_correct`  | BOOLEAN          |     | No       | Whether this is the correct option |
| `question_id` | INT              | FK  | No       | Linked to `Questions.id`           |
| `updated_at`  | TIMESTAMP        |     | No       |                                    |
| `created_at`  | TIMESTAMP        |     | No       |                                    |

#### 🔗 Relationships

* Many-to-One: `Options` → `Questions` via `question_id`

---
<br><br>

### 📘 Table: `ResourceMappings`

| Column Name     | Type               | Key | Nullable | Description                               |
| --------------- | ------------------ | --- | -------- | ----------------------------------------- |
| `id`            | INT                | PK  | No       | Auto-increment primary key                |
| `resource_type` | ENUM(ResourceType) |     | No       | e.g., "QUESTION", "QUIZ"                  |
| `resource_id`   | INT                |     | No       | Refers to entity like Question/Quiz by ID |
| `grade_id`      | INT                | FK  | No       | Foreign key to `Grades.id`                |
| `subject_id`    | INT                | FK  | No       | Foreign key to `Subjects.id`              |
| `topic_id`      | INT                | FK  | No       | Foreign key to `Topics.id`                |
| `updated_at`    | TIMESTAMP          |     | No       |                                           |
| `created_at`    | TIMESTAMP          |     | No       |                                           |

#### 🔗 Relationships

* Many-to-One: Linked to `Grades`, `Subjects`, `Topics`
* Used for categorizing `Questions`, `Quiz` by domain-specific hierarchy

---
<br><br>

### 📘 Table: `Tags`

| Column Name     | Type          | Key | Nullable | Description                               |
| --------------- | ------------- | --- | -------- | ----------------------------------------- |
| `id`            | INT           | PK  | No       | Auto-increment primary key                |
| `resource_type` | VARCHAR(50)   |     | No       | e.g., "QUESTION", "QUIZ"                  |
| `resource_id`   | INT           |     | No       | Refers to entity like Question/Quiz by ID |
| `type`          | ENUM(TagType) |     | No       | e.g., "DIFFICULTY", "STANDARD\_CODE"      |
| `value`         | TEXT          |     | No       | Tag value (e.g., "Easy", "5.2(A)")        |
| `updated_at`    | TIMESTAMP     |     | No       |                                           |
| `created_at`    | TIMESTAMP     |     | No       |                                           |

#### 🔗 Relationships

* Logical tags on any resource type (e.g., difficulty, concept code)

---
<br><br>

### 📘 Table: `User`

| Column Name  | Type           | Key    | Nullable | Constraints / Description             |
| ------------ | -------------- | ------ | -------- | ------------------------------------- |
| `id`         | UUID           | PK     | No       | Auto-generated primary key            |
| `email`      | VARCHAR(255)   | UNIQUE | No       | User's email, must be unique          |
| `password`   | VARCHAR(255)   |        | No       | Encrypted (hashed) password for login |
| `role`       | ENUM(UserRole) |        | No       | One of `STUDENT`, `ADMIN`             |
| `created_at` | TIMESTAMP      |        | No       | Default: now()                        |

#### 🔗 Relationships

* One-to-Many: `User (1)` → `UserQuiz (many)`

---
<br><br>

### 📘 Table: `Quiz`

| Column Name  | Type         | Key | Nullable | Description                     |
| ------------ | ------------ | --- | -------- | ------------------------------- |
| `uuid`       | UUID         | PK  | No       | Unique quiz identifier          |
| `questions`  | JSONB / TEXT |     | No       | List of question IDs or objects |
| `updated_at` | TIMESTAMP    |     | No       |                                 |
| `created_at` | TIMESTAMP    |     | No       |                                 |

#### 🔗 Relationships

* One-to-Many: `Quiz (1)` → `UserQuiz (many)` via `quiz_id`
* One-to-Many: `Quiz (1)` → `ResourceMappings` (via `resource_id` and `resource_type='QUIZ'`)
* One-to-Many: `Quiz (1)` → `Tags` (via `resource_id` and `resource_type='QUIZ'`)

---
<br><br>


### 📘 Table: `UserQuiz`

| Column Name  | Type            | Key | Nullable | Description                      |
| ------------ | --------------- | --- | -------- | -------------------------------- |
| `id`         | INT             | PK  | No       | Auto-incremented                 |
| `user_id`    | UUID            | FK  | No       | References `User.id`             |
| `quiz_id`    | UUID            | FK  | No       | References `Quiz.uuid`           |
| `score`      | INT             |     | Yes      | Final score                      |
| `state`      | ENUM(QuizState) |     | No       | Status: PENDING, COMPLETED, etc. |
| `updated_at` | TIMESTAMP       |     | No       |                                  |
| `created_at` | TIMESTAMP       |     | No       |                                  |

#### 🔗 Relationships

* Many-to-One: `UserQuiz` → `User`, `Quiz`
* One-to-Many: `UserQuiz (1)` → `UserQuizResponse (many)`

---
<br><br>

### 📘 Table: `UserQuizResponse`

| Column Name    | Type      | Key | Nullable | Description                                |
| -------------- | --------- | --- | -------- | ------------------------------------------ |
| `id`           | INT       | PK  | No       | Auto-increment primary key                 |
| `user_quiz_id` | INT       | FK  | No       | Links to `UserQuiz.id`                     |
| `response`     | JSONB     |     | No       | Selected answers in question-response form |
| `updated_at`   | TIMESTAMP |     | No       |                                            |
| `created_at`   | TIMESTAMP |     | No       |                                            |

---
<br><br>

### 🧾 Enum Definitions

#### `UserRole`

* `STUDENT`
* `TEACHER`
* `ADMIN`

#### `QuestionType`

* `SINGLE_CHOICE`
* `MULTI_CHOICE`
* `TRUE_FALSE`
* `TEXT_INPUT`

#### `OptionType`

* `TEXT`
* `IMAGE`
* `AUDIO`

#### `TagType`

* `DIFFICULTY`
* `STANDARD_CODE`

#### `ResourceType`

* `QUESTION`
* `QUIZ`

#### `QuizState`

* `PENDING`
* `COMPLETED`
* `REVIEWED`
