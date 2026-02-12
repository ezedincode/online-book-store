-- Drop existing tables
DROP TABLE IF EXISTS confirmation_token;
DROP TABLE IF EXISTS downloads;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS book_detail;
DROP TABLE IF EXISTS app_user;

-- Create app_user table
CREATE TABLE app_user (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(50),
    email VARCHAR(255) UNIQUE,
    status VARCHAR(50),
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create book_detail table
CREATE TABLE book_detail (
    id SERIAL PRIMARY KEY,
    rating INTEGER,
    description TEXT,
    priority DOUBLE PRECISION,
    download_count INTEGER DEFAULT 0
);

-- Create book table
CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    -- description removed from book table
    author VARCHAR(255),
    image TEXT,
    published_date VARCHAR(255),
    type VARCHAR(50),
    book_Detail_id INTEGER UNIQUE,
    CONSTRAINT fk_book_detail FOREIGN KEY (book_Detail_id) REFERENCES book_detail(id) ON DELETE CASCADE
);

-- Create downloads table
CREATE TABLE downloads (
    id SERIAL PRIMARY KEY,
    date DATE,
    download_count INTEGER,
    user_id INTEGER,
    book_id INTEGER,
    CONSTRAINT fk_downloads_user FOREIGN KEY (user_id) REFERENCES app_user(id),
    CONSTRAINT fk_downloads_book FOREIGN KEY (book_id) REFERENCES book(id)
);

-- Create confirmation_token table
CREATE TABLE confirmation_token (
    id SERIAL PRIMARY KEY,
    token VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    expires_at TIMESTAMP NOT NULL,
    confirmed_at TIMESTAMP,
    user_id INTEGER NOT NULL,
    CONSTRAINT fk_confirmation_token_user FOREIGN KEY (user_id) REFERENCES app_user(id)
);

-- Insert Sample Data

-- Users
INSERT INTO app_user (username, password, role, email, status, created) VALUES 
('admin', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'Admin', 'admin@example.com', 'Active', NOW()),
('user1', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'User', 'user1@example.com', 'Active', NOW());

-- Book Details
INSERT INTO book_detail (rating, description, priority, download_count) VALUES 
(5, 'Comprehensive guide to Spring Boot.', 4.5, 100),
(4, 'Introduction to SQL.', 3.0, 50);

-- Books
-- Removed description from INSERT
INSERT INTO book (title, author, image, published_date, type, book_Detail_id) VALUES 
('Spring Boot in Action', 'Craig Walls', 'https://example.com/spring.jpg', '2023-01-01', 'Technology', 1),
('SQL for Dummies', 'Allen G. Taylor', 'https://example.com/sql.jpg', '2022-05-15', 'Academic', 2);

-- Downloads
INSERT INTO downloads (date, download_count, user_id, book_id) VALUES 
('2023-10-01', 1, 2, 1);
