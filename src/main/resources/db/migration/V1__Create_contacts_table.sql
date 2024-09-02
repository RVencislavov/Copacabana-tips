CREATE TABLE contacts (
                          id BIGINT IDENTITY PRIMARY KEY,
                          name NVARCHAR(255) NOT NULL,
                          phone_number NVARCHAR(255) NOT NULL UNIQUE,
                          created_date DATETIME2(6),
                          deleted BIT NOT NULL DEFAULT 0
);
