-- ========================
-- 📌 Create Schemas
-- ========================
CREATE SCHEMA IF NOT EXISTS sp_content;
CREATE SCHEMA IF NOT EXISTS sp_skillpulse;

-- ========================
-- 🧱 Schema (No ENUMs)
-- ========================

CREATE TABLE sp_content.grades (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(100) UNIQUE NOT NULL,
    sort INT,
    updated_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE sp_content.subjects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(100) UNIQUE NOT NULL,
    sort INT,
    updated_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE sp_content.topics (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sort INT,
    updated_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE sp_content.questions (
    id SERIAL PRIMARY KEY,
    question TEXT NOT NULL,
    type VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE sp_content.options (
    id BIGSERIAL PRIMARY KEY,
    option_text TEXT,
    media_link VARCHAR(255),
    type VARCHAR(50) NOT NULL,
    is_correct BOOLEAN NOT NULL,
    question_id INT NOT NULL REFERENCES sp_content.questions(id),
    updated_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE sp_skillpulse.quiz (
    uuid UUID PRIMARY KEY,
    questions TEXT NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE sp_content.resource_mappings (
    id SERIAL PRIMARY KEY,
    resource_type VARCHAR(50) NOT NULL,
    resource_id INT NOT NULL,
    grade_id INT NOT NULL REFERENCES sp_content.grades(id),
    subject_id INT NOT NULL REFERENCES sp_content.subjects(id),
    topic_id INT NOT NULL REFERENCES sp_content.topics(id),
    updated_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE sp_content.tags (
    id SERIAL PRIMARY KEY,
    resource_type VARCHAR(50) NOT NULL,
    resource_id INT NOT NULL,
    type VARCHAR(50) NOT NULL,
    value TEXT NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE sp_skillpulse.users (
    id UUID PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE sp_skillpulse.user_quiz (
    id SERIAL PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES sp_skillpulse.users(id),
    quiz_id UUID NOT NULL REFERENCES sp_skillpulse.quiz(uuid),
    score INT,
    state VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE sp_skillpulse.user_quiz_response (
    id SERIAL PRIMARY KEY,
    user_quiz_id INT NOT NULL REFERENCES sp_skillpulse.user_quiz(id),
    response JSON NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

-- ========================
-- 🌱 Seed Data
-- ========================

-- Grades
INSERT INTO sp_content.grades (name, code, sort, updated_at, created_at) VALUES
('Grade 4', 'GRADE_4', 1, now(), now()),
('Grade 5', 'GRADE_5', 2, now(), now()),
('Grade 6', 'GRADE_6', 3, now(), now()),
('Grade 7', 'GRADE_7', 4, now(), now()),
('Grade 8', 'GRADE_8', 5, now(), now());

-- Subjects
INSERT INTO sp_content.subjects (name, code, sort, updated_at, created_at) VALUES
('Mathematics', 'MATH', 1, now(), now()),
('Science', 'SCI', 2, now(), now()),
('English', 'ENG', 3, now(), now()),
('Social Studies', 'SOC', 4, now(), now()),
('Computer Science', 'CS', 5, now(), now());

-- Topics
INSERT INTO sp_content.topics (name, sort, updated_at, created_at) VALUES
('Fractions', 1, now(), now()),
('Photosynthesis', 2, now(), now()),
('Grammar - Verbs', 3, now(), now()),
('Indian Geography', 4, now(), now()),
('Algorithms', 5, now(), now());

-- Questions
INSERT INTO sp_content.questions (question, type, updated_at, created_at) VALUES
('What is 1/2 + 1/4?', 'SINGLE_CHOICE', now(), now()),                   -- Q1
('Which of these are prime numbers?', 'MULTI_CHOICE', now(), now()),     -- Q2
('Which sentence uses a verb correctly?', 'SINGLE_CHOICE', now(), now()),-- Q3
('Which are green plants?', 'MULTI_CHOICE', now(), now()),               -- Q4
('What is the capital of India?', 'SINGLE_CHOICE', now(), now());        -- Q5

-- Options for Q1 (SC)
INSERT INTO sp_content.options (option_text, type, is_correct, question_id, updated_at, created_at) VALUES
('3/4', 'TEXT', true, 1, now(), now()),
('1/2', 'TEXT', false, 1, now(), now()),
('2/3', 'TEXT', false, 1, now(), now());

-- Options for Q2 (MC)
INSERT INTO sp_content.options (option_text, type, is_correct, question_id, updated_at, created_at) VALUES
('2', 'TEXT', true, 2, now(), now()),
('3', 'TEXT', true, 2, now(), now()),
('4', 'TEXT', false, 2, now(), now()),
('5', 'TEXT', true, 2, now(), now());

-- Options for Q3 (SC)
INSERT INTO sp_content.options (option_text, type, is_correct, question_id, updated_at, created_at) VALUES
('She run fast.', 'TEXT', false, 3, now(), now()),
('She runs fast.', 'TEXT', true, 3, now(), now()),
('She running fast.', 'TEXT', false, 3, now(), now());

-- Options for Q4 (MC)
INSERT INTO sp_content.options (option_text, type, is_correct, question_id, updated_at, created_at) VALUES
('Mango tree', 'TEXT', true, 4, now(), now()),
('Cactus', 'TEXT', true, 4, now(), now()),
('Stone', 'TEXT', false, 4, now(), now());

-- Options for Q5 (SC)
INSERT INTO sp_content.options (option_text, type, is_correct, question_id, updated_at, created_at) VALUES
('Mumbai', 'TEXT', false, 5, now(), now()),
('New Delhi', 'TEXT', true, 5, now(), now()),
('Kolkata', 'TEXT', false, 5, now(), now());

-- Resource Mappings
INSERT INTO sp_content.resource_mappings (resource_type, resource_id, grade_id, subject_id, topic_id, updated_at, created_at) VALUES
('QUESTION', 1, 2, 1, 1, now(), now()),
('QUESTION', 2, 2, 1, 1, now(), now()),
('QUESTION', 3, 2, 3, 3, now(), now()),
('QUESTION', 4, 2, 2, 2, now(), now()),
('QUESTION', 5, 2, 4, 4, now(), now());

-- Tags
INSERT INTO sp_content.tags (resource_type, resource_id, type, value, updated_at, created_at) VALUES
('QUESTION', 1, 'DIFFICULTY', 'Easy', now(), now()),
('QUESTION', 2, 'DIFFICULTY', 'Medium', now(), now()),
('QUESTION', 3, 'DIFFICULTY', 'Easy', now(), now()),
('QUESTION', 4, 'DIFFICULTY', 'Hard', now(), now()),
('QUESTION', 5, 'DIFFICULTY', 'Medium', now(), now());
