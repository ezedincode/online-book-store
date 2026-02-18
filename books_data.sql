-- PostgreSQL INSERT queries for Books and BookDetails

-- Inserting BookDetails first, then Books to maintain relationships

-- 1-10: Fiction
INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (1, 5, 'The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it.', 0.9, 1200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (1, 'To Kill a Mockingbird', 'Harper Lee', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1553383690i/2657.jpg', '1960-07-11', 'Fiction', 1);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (2, 5, 'A dystopian social science fiction novel and cautionary tale about the dangers of totalitarianism.', 0.85, 950);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (2, '1984', 'George Orwell', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1532714506i/40961427.jpg', '1949-06-08', 'Fiction', 2);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (3, 4, 'The story of the fabulously wealthy Jay Gatsby and his love for the beautiful Daisy Buchanan.', 0.75, 800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (3, 'The Great Gatsby', 'F. Scott Fitzgerald', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1490528560i/4671.jpg', '1925-04-10', 'Fiction', 3);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (4, 4, 'Follows the turbulent relationship between Elizabeth Bennet and Fitzwilliam Darcy.', 0.78, 850);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (4, 'Pride and Prejudice', 'Jane Austen', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1320399351i/1885.jpg', '1813-01-28', 'Fiction', 4);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (5, 5, 'An epic high-fantasy novel by J.R.R. Tolkien.', 0.95, 2500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (5, 'The Lord of the Rings', 'J.R.R. Tolkien', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1566425108i/34.jpg', '1954-07-29', 'Fiction', 5);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (6, 5, 'The first novel in the Harry Potter series.', 0.98, 5000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (6, 'Harry Potter and the Philosopher''s Stone', 'J.K. Rowling', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1170803558i/3.jpg', '1997-06-26', 'Fiction', 6);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (7, 4, 'A young woman finds herself caught between her cold husband and her passionate lover.', 0.65, 450);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (7, 'Anna Karenina', 'Leo Tolstoy', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1546091617i/15823480.jpg', '1877-01-01', 'Fiction', 7);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (8, 4, 'The adventures of a young man on the high seas.', 0.60, 400);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (8, 'Moby-Dick', 'Herman Melville', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1327934484i/153.jpg', '1851-11-14', 'Fiction', 8);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (9, 5, 'A philosophical exploration of existence and morality.', 0.82, 700);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (9, 'The Alchemist', 'Paulo Coelho', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1654371463i/1125.jpg', '1988-01-01', 'Fiction', 9);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (10, 4, 'A satirical look at the American military during World War II.', 0.70, 500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (10, 'Catch-22', 'Joseph Heller', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1355087493i/168668.jpg', '1961-11-10', 'Fiction', 10);

-- 11-20: Technology
INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (11, 5, 'A handbook of agile software craftsmanship.', 0.88, 1500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (11, 'Clean Code', 'Robert C. Martin', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1436202607i/3735293.jpg', '2008-08-01', 'Technology', 11);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (12, 5, 'The mythical man-month and other essays on software engineering.', 0.85, 1100);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (12, 'The Mythical Man-Month', 'Frederick P. Brooks Jr.', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1348430512i/13629.jpg', '1975-01-01', 'Technology', 12);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (13, 5, 'A groundbreaking guide to design patterns.', 0.87, 1300);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (13, 'Design Patterns: Elements of Reusable Object-Oriented Software', 'Erich Gamma et al.', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1348027904i/50269.jpg', '1994-10-31', 'Technology', 13);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (14, 4, 'Effective Java programming language guide.', 0.84, 1200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (14, 'Effective Java', 'Joshua Bloch', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1433511045i/10540354.jpg', '2001-01-01', 'Technology', 14);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (15, 5, 'The Pragmatic Programmer: Your Journey to Mastery.', 0.90, 1800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (15, 'The Pragmatic Programmer', 'Andrew Hunt and David Thomas', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1403180132i/4099.jpg', '1999-10-30', 'Technology', 15);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (16, 4, 'Introduction to Algorithms.', 0.82, 900);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (16, 'Introduction to Algorithms', 'Thomas H. Cormen et al.', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1387741681i/10818853.jpg', '1990-01-01', 'Technology', 16);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (17, 5, 'Refactoring: Improving the Design of Existing Code.', 0.86, 1400);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (17, 'Refactoring', 'Martin Fowler', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1386925632i/44936.jpg', '1999-07-08', 'Technology', 17);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (18, 4, 'Compilers: Principles, Techniques, and Tools.', 0.75, 600);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (18, 'Compilers', 'Alfred V. Aho et al.', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1347648316i/703102.jpg', '1986-01-01', 'Technology', 18);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (19, 5, 'Structure and Interpretation of Computer Programs.', 0.83, 800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (19, 'SICP', 'Harold Abelson et al.', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1347713838i/43713.jpg', '1984-01-01', 'Technology', 19);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (20, 4, 'JavaScript: The Good Parts.', 0.80, 1000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (20, 'JavaScript: The Good Parts', 'Douglas Crockford', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1328834793i/2998152.jpg', '2008-05-01', 'Technology', 20);

-- 21-30: NonFiction
INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (21, 5, 'A brief history of humankind.', 0.92, 3000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (21, 'Sapiens', 'Yuval Noah Harari', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1590553447i/23692271.jpg', '2011-01-01', 'NonFiction', 21);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (22, 5, 'A look at how we think.', 0.89, 2000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (22, 'Thinking, Fast and Slow', 'Daniel Kahneman', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1317793965i/11468377.jpg', '2011-10-25', 'NonFiction', 22);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (23, 4, 'The power of habit and why we do what we do.', 0.83, 1500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (23, 'The Power of Habit', 'Charles Duhigg', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1545854312i/12609433.jpg', '2012-02-28', 'NonFiction', 23);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (24, 4, 'A book about grit, passion, and perseverance.', 0.81, 1200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (24, 'Grit', 'Angela Duckworth', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1453406560i/27213329.jpg', '2016-05-03', 'NonFiction', 24);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (25, 5, 'An investigation into the biology of cancer.', 0.87, 800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (25, 'The Emperor of All Maladies', 'Siddhartha Mukherjee', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1280771074i/7170627.jpg', '2010-11-16', 'NonFiction', 25);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (26, 4, 'A memoirs of a journey in search of oneself.', 0.78, 1000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (26, 'Educated', 'Tara Westover', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1506026635i/35133922.jpg', '2018-02-20', 'NonFiction', 26);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (27, 4, 'How to win friends and influence people.', 0.85, 2500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (27, 'How to Win Friends and Influence People', 'Dale Carnegie', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1442726934i/4865.jpg', '1936-10-01', 'NonFiction', 27);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (28, 5, 'Man''s Search for Meaning.', 0.94, 3500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (28, 'Man''s Search for Meaning', 'Viktor E. Frankl', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1535419333i/4069.jpg', '1946-01-01', 'NonFiction', 28);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (29, 4, 'The Immortal Life of Henrietta Lacks.', 0.82, 900);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (29, 'The Immortal Life of Henrietta Lacks', 'Rebecca Skloot', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1327878144i/6493208.jpg', '2010-02-02', 'NonFiction', 29);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (30, 4, 'Quiet: The Power of Introverts.', 0.84, 1800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (30, 'Quiet', 'Susan Cain', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1328562861i/11735983.jpg', '2012-01-24', 'NonFiction', 30);

-- 31-40: Academic
INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (31, 5, 'Principles of Mathematical Analysis.', 0.70, 300);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (31, 'Baby Rudin', 'Walter Rudin', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1429074060i/157201.jpg', '1953-01-01', 'Academic', 31);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (32, 5, 'Linear Algebra Done Right.', 0.85, 700);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (32, 'Linear Algebra Done Right', 'Sheldon Axler', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1344265416i/129737.jpg', '1995-12-01', 'Academic', 32);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (33, 4, 'Mathematical Methods for Physicists.', 0.72, 400);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (33, 'Mathematical Methods for Physicists', 'George Arfken', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1347648316i/703102.jpg', '1966-01-01', 'Academic', 33);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (34, 4, 'Microeconomic Theory.', 0.74, 350);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (34, 'Microeconomic Theory', 'Andreu Mas-Colell', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1429074060i/157201.jpg', '1995-01-01', 'Academic', 34);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (35, 5, 'Introduction to the Theory of Computation.', 0.88, 600);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (35, 'Theory of Computation', 'Michael Sipser', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1348123281i/11339.jpg', '1996-01-01', 'Academic', 35);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (36, 4, 'Computer Networking: A Top-Down Approach.', 0.86, 1200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (36, 'Computer Networking', 'James Kurose', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1347648316i/703102.jpg', '2000-01-01', 'Academic', 36);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (37, 5, 'Artificial Intelligence: A Modern Approach.', 0.91, 1500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (37, 'Artificial Intelligence', 'Stuart Russell', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1429074060i/157201.jpg', '1995-01-01', 'Academic', 37);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (38, 4, 'Deep Learning.', 0.83, 900);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (38, 'Deep Learning', 'Ian Goodfellow', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1429074060i/157201.jpg', '2016-11-18', 'Academic', 38);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (39, 4, 'Probability and Statistics.', 0.78, 550);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (39, 'Probability and Statistics', 'Morris DeGroot', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1429074060i/157201.jpg', '1975-01-01', 'Academic', 39);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (40, 5, 'Calculus.', 0.82, 1000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (40, 'Calculus', 'James Stewart', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1429074060i/157201.jpg', '1987-01-01', 'Academic', 40);

-- ... and so on for 100 entries ...
-- (I will provide the rest in a similar pattern, generating high-quality real book titles)

-- 41-50: Biography
INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (41, 5, 'The biography of Steve Jobs.', 0.90, 2200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (41, 'Steve Jobs', 'Walter Isaacson', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1511288482i/11084145.jpg', '2011-10-24', 'Biography', 41);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (42, 5, 'The autobiography of Malcolm X.', 0.88, 1400);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (42, 'The Autobiography of Malcolm X', 'Malcolm X', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1434681430i/9206.jpg', '1965-10-29', 'Biography', 42);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (43, 5, 'The diary of a young girl.', 0.95, 4000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (43, 'The Diary of a Young Girl', 'Anne Frank', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1560816565i/48855.jpg', '1947-06-25', 'Biography', 43);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (44, 4, 'Long Walk to Freedom.', 0.87, 1800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (44, 'Long Walk to Freedom', 'Nelson Mandela', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1327993430i/318.jpg', '1994-11-01', 'Biography', 44);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (45, 5, 'Einstein: His Life and Universe.', 0.85, 1100);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (45, 'Einstein', 'Walter Isaacson', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1328011405i/10848.jpg', '2007-04-10', 'Biography', 45);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (46, 4, 'A Promised Land.', 0.86, 2500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (46, 'A Promised Land', 'Barack Obama', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1600350155i/55361205.jpg', '2020-11-17', 'Biography', 46);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (47, 5, 'Becoming.', 0.89, 3200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (47, 'Becoming', 'Michelle Obama', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1528206992i/38746485.jpg', '2018-11-13', 'Biography', 47);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (48, 5, 'Leonardo da Vinci.', 0.84, 950);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (48, 'Leonardo da Vinci', 'Walter Isaacson', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1523543501i/34684622.jpg', '2017-10-17', 'Biography', 48);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (49, 4, 'Elon Musk.', 0.82, 1300);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (49, 'Elon Musk', 'Ashlee Vance', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1518291452i/25546272.jpg', '2015-05-19', 'Biography', 49);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (50, 4, 'The Wright Brothers.', 0.80, 750);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (50, 'The Wright Brothers', 'David McCullough', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1421697207i/22609391.jpg', '2015-05-05', 'Biography', 50);

-- 51-60: Children
INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (51, 5, 'The Hobbit, or There and Back Again.', 0.93, 3000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (51, 'The Hobbit', 'J.R.R. Tolkien', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1546071216i/5907.jpg', '1937-09-21', 'Children', 51);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (52, 5, 'Where the Wild Things Are.', 0.88, 1500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (52, 'Where the Wild Things Are', 'Maurice Sendak', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1384434560i/19543.jpg', '1963-10-29', 'Children', 52);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (53, 5, 'Alice''s Adventures in Wonderland.', 0.85, 1200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (53, 'Alice in Wonderland', 'Lewis Carroll', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1391204048i/24213.jpg', '1865-11-26', 'Children', 53);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (54, 4, 'Charlotte''s Web.', 0.82, 1100);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (54, 'Charlotte''s Web', 'E.B. White', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1628142481i/24178.jpg', '1952-10-15', 'Children', 54);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (55, 4, 'The Very Hungry Caterpillar.', 0.80, 2000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (55, 'The Very Hungry Caterpillar', 'Eric Carle', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1524108154i/4948.jpg', '1969-06-03', 'Children', 55);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (56, 5, 'The Lion, the Witch and the Wardrobe.', 0.91, 2800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (56, 'The Chronicles of Narnia', 'C.S. Lewis', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1353029077i/100915.jpg', '1950-10-16', 'Children', 56);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (57, 4, 'Matilda.', 0.86, 1400);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (57, 'Matilda', 'Roald Dahl', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1388793265i/39988.jpg', '1988-10-01', 'Children', 57);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (58, 4, 'Green Eggs and Ham.', 0.78, 1800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (58, 'Green Eggs and Ham', 'Dr. Seuss', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1427218525i/23772.jpg', '1960-08-12', 'Children', 58);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (59, 5, 'The Giving Tree.', 0.84, 1300);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (59, 'The Giving Tree', 'Shel Silverstein', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1174210642i/370493.jpg', '1964-10-07', 'Children', 59);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (60, 4, 'Bridge to Terabithia.', 0.75, 900);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (60, 'Bridge to Terabithia', 'Katherine Paterson', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1327880940i/2839.jpg', '1977-10-21', 'Children', 60);

-- 61-70: Art
INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (61, 5, 'Ways of Seeing.', 0.88, 1200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (61, 'Ways of Seeing', 'John Berger', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1388182744i/2784.jpg', '1972-01-01', 'Art', 61);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (62, 5, 'The Story of Art.', 0.90, 1500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (62, 'The Story of Art', 'E.H. Gombrich', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1348270547i/22205.jpg', '1950-01-01', 'Art', 62);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (63, 4, 'Concerning the Spiritual in Art.', 0.75, 500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (63, 'Concerning the Spiritual in Art', 'Wassily Kandinsky', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1327883210i/234958.jpg', '1911-01-01', 'Art', 63);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (64, 4, 'Vision and Design.', 0.72, 400);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (64, 'Vision and Design', 'Roger Fry', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1347648316i/703102.jpg', '1920-01-01', 'Art', 64);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (65, 5, 'Interaction of Color.', 0.85, 800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (65, 'Interaction of Color', 'Josef Albers', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1348824368i/111113.jpg', '1963-01-01', 'Art', 65);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (66, 4, 'The Art of Color.', 0.82, 700);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (66, 'The Art of Color', 'Johannes Itten', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1347648316i/703102.jpg', '1961-01-01', 'Art', 66);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (67, 5, 'The New Typography.', 0.78, 600);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (67, 'The New Typography', 'Jan Tschichold', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1347648316i/703102.jpg', '1928-01-01', 'Art', 67);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (68, 4, 'Thinking with Type.', 0.84, 1300);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (68, 'Thinking with Type', 'Ellen Lupton', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1320436066i/123456.jpg', '2004-01-01', 'Art', 68);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (69, 5, 'Grid Systems in Graphic Design.', 0.80, 900);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (69, 'Grid Systems', 'Josef Müller-Brockmann', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1347648316i/703102.jpg', '1981-01-01', 'Art', 69);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (70, 4, 'The Elements of Typographic Style.', 0.83, 1100);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (70, 'Typographic Style', 'Robert Bringhurst', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1348424177i/446.jpg', '1992-01-01', 'Art', 70);

-- 71-80: Academic & Science
INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (71, 5, 'The Structure of Scientific Revolutions.', 0.86, 1200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (71, 'Scientific Revolutions', 'Thomas S. Kuhn', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1348123281i/11339.jpg', '1962-01-01', 'Academic', 71);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (72, 5, 'The Selfish Gene.', 0.88, 2500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (72, 'The Selfish Gene', 'Richard Dawkins', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1366758096i/61535.jpg', '1976-01-01', 'NonFiction', 72);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (73, 5, 'Cosmos.', 0.92, 3500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (73, 'Cosmos', 'Carl Sagan', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1388620668i/55030.jpg', '1980-01-01', 'NonFiction', 73);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (74, 4, 'A Brief History of Time.', 0.90, 4000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (74, 'A Brief History of Time', 'Stephen Hawking', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1333574090i/3869.jpg', '1988-04-01', 'NonFiction', 74);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (75, 5, 'The Origin of Species.', 0.85, 1800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (75, 'The Origin of Species', 'Charles Darwin', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1298417570i/22463.jpg', '1859-11-24', 'Academic', 75);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (76, 4, 'Relativity: The Special and General Theory.', 0.83, 1100);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (76, 'Relativity', 'Albert Einstein', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1328011405i/10848.jpg', '1916-01-01', 'Academic', 76);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (77, 4, 'Guns, Germs, and Steel.', 0.87, 2200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (77, 'Guns, Germs, and Steel', 'Jared Diamond', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1453215833i/1842.jpg', '1997-01-01', 'NonFiction', 77);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (78, 5, 'The Double Helix.', 0.81, 900);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (78, 'The Double Helix', 'James D. Watson', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1388182744i/2784.jpg', '1968-01-01', 'Academic', 78);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (79, 4, 'Silent Spring.', 0.84, 1300);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (79, 'Silent Spring', 'Rachel Carson', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1442152207i/27333.jpg', '1962-09-27', 'NonFiction', 79);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (80, 5, 'The Feynman Lectures on Physics.', 0.89, 1500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (80, 'Feynman Lectures', 'Richard Feynman', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1347648316i/703102.jpg', '1964-01-01', 'Academic', 80);

-- 81-90: Fiction & Modern Classics
INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (81, 5, 'The Catcher in the Rye.', 0.85, 2800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (81, 'The Catcher in the Rye', 'J.D. Salinger', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1398034300i/5107.jpg', '1951-07-16', 'Fiction', 81);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (82, 5, 'Brave New World.', 0.83, 2400);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (82, 'Brave New World', 'Aldous Huxley', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1523020344i/5129.jpg', '1932-01-01', 'Fiction', 82);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (83, 4, 'Fahrenheit 451.', 0.82, 2100);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (83, 'Fahrenheit 451', 'Ray Bradbury', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1383718290i/13079982.jpg', '1953-10-19', 'Fiction', 83);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (84, 4, 'Animal Farm.', 0.88, 3000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (84, 'Animal Farm', 'George Orwell', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1325861570i/170448.jpg', '1945-08-17', 'Fiction', 84);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (85, 5, 'The Grapes of Wrath.', 0.81, 1400);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (85, 'The Grapes of Wrath', 'John Steinbeck', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1375670575i/18114322.jpg', '1939-04-14', 'Fiction', 85);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (86, 5, 'One Hundred Years of Solitude.', 0.89, 2600);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (86, 'One Hundred Years of Solitude', 'Gabriel García Márquez', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1327881361i/33.jpg', '1967-05-30', 'Fiction', 86);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (87, 4, 'The Old Man and the Sea.', 0.79, 1800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (87, 'The Old Man and the Sea', 'Ernest Hemingway', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1329189133i/2165.jpg', '1952-09-01', 'Fiction', 87);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (88, 5, 'Lolita.', 0.76, 1500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (88, 'Lolita', 'Vladimir Nabokov', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1377756377i/7604.jpg', '1955-09-15', 'Fiction', 88);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (89, 4, 'Great Expectations.', 0.78, 1700);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (89, 'Great Expectations', 'Charles Dickens', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1327920211i/2623.jpg', '1861-01-01', 'Fiction', 89);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (90, 5, 'Ulysses.', 0.74, 1200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (90, 'Ulysses', 'James Joyce', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1428891345i/338798.jpg', '1922-02-02', 'Fiction', 90);

-- 91-100: Miscellaneous & New Releases
INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (91, 5, 'The Midnight Library.', 0.88, 3500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (91, 'The Midnight Library', 'Matt Haig', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1602193730i/52578297.jpg', '2020-08-13', 'Fiction', 91);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (92, 5, 'Where the Crawdads Sing.', 0.89, 4500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (92, 'Where the Crawdads Sing', 'Delia Owens', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1524021396i/36809135.jpg', '2018-08-14', 'Fiction', 92);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (93, 4, 'The Seven Husbands of Evelyn Hugo.', 0.86, 3200);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (93, 'Evelyn Hugo', 'Taylor Jenkins Reid', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1495440789i/32620332.jpg', '2017-06-13', 'Fiction', 93);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (94, 4, 'Atomic Habits.', 0.94, 6000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (94, 'Atomic Habits', 'James Clear', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1655988385i/33124137.jpg', '2018-10-16', 'NonFiction', 94);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (95, 5, 'The Song of Achilles.', 0.87, 2800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (95, 'The Song of Achilles', 'Madeline Miller', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1331154677i/11250317.jpg', '2011-09-20', 'Fiction', 95);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (96, 5, 'Circe.', 0.85, 2500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (96, 'Circe', 'Madeline Miller', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1508879575i/35959740.jpg', '2018-04-10', 'Fiction', 96);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (97, 4, 'Normals People.', 0.82, 1800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (97, 'Normal People', 'Sally Rooney', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1571423714i/41057294.jpg', '2018-08-28', 'Fiction', 97);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (98, 4, 'Project Hail Mary.', 0.91, 3000);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (98, 'Project Hail Mary', 'Andy Weir', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1597695864i/54493401.jpg', '2021-05-04', 'Fiction', 98);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (99, 5, 'Anxious People.', 0.84, 1500);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (99, 'Anxious People', 'Fredrik Backman', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1591574340i/49127718.jpg', '2019-04-25', 'Fiction', 99);

INSERT INTO book_detail (id, rating, description, priority, download_count) VALUES (100, 4, 'The Silent Patient.', 0.86, 3800);
INSERT INTO book (id, title, author, image, published_date, type, book_detail_id) VALUES (100, 'The Silent Patient', 'Alex Michaelides', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1668782119i/40097951.jpg', '2019-02-05', 'Fiction', 100);
