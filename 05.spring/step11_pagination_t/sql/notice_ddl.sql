DROP TABLE notice;

CREATE TABLE notice (
	no BIGINT AUTO_INCREMENT,
    user_id VARCHAR(20) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255),
    hit INT,
    PRIMARY KEY(no)
);