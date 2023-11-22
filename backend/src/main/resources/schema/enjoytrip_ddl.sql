CREATE DATABASE IF NOT EXISTS `enjoy_trip`
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci;

use enjoy_trip;

-- attraction_info 괄호 파싱
UPDATE attraction_info
SET title = REGEXP_REPLACE(title, '\\[.*\\]', '');
UPDATE attraction_info
SET title = REGEXP_REPLACE(title, '\\(.*\\)', '');

-- content_type
CREATE TABLE IF NOT EXISTS `content_type` (
    `content_type_id`   int         not null primary key,
    `content_type_name` varchar(10) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO content_type
VALUES (12, "관광지"),(32, "숙박"),(39, "음식점"),(14, "문화 시설"),(15, "공연"),(38, "쇼핑");

-- member
CREATE TABLE IF NOT EXISTS `member` (
    `member_id`     int      not null primary key auto_increment,
    `role`          varchar(10) not null default 'user',
    `id`            varchar(20) not null UNIQUE,
    `password`            varchar(20) not null,
    `name`          varchar(20) ,
    `phone_number`  varchar(11) ,
    `gender`        varchar(1)  not null,
    `age`           int  not null,
    `reg_date`    timestamp   not null default current_timestamp,
    `mod_date`   timestamp   not null default current_timestamp
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- post
CREATE TABLE IF NOT EXISTS `post` (
    `post_id`   int           not null primary key auto_increment,
	`author_id` int           not null,
    `title`     varchar(100)  not null,
    `content`   varchar(1000) ,
    `hit`       int           not null default 0,
    `reg_date`  timestamp     not null default current_timestamp,
    `mod_date`  timestamp     not null default current_timestamp,
    foreign key (`author_id`) references MEMBER (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- notice
CREATE TABLE IF NOT EXISTS `notice` (
    `notice_id`     int           not null primary key auto_increment,
    `author_id`        int           not null,
    `title`         varchar(100)  not null,
    `content`       varchar(1000) ,
    `hit`           int           not null default 0,
    `reg_date`    timestamp     not null default current_timestamp,
    `mod_date`    timestamp     not null default current_timestamp,
    foreign key (`author_id`) references MEMBER (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- hot place
CREATE TABLE IF NOT EXISTS `hot_place` (
    `hot_place_id` int not null primary key auto_increment,
    `member_id` int not null,
    `content_id` int not null,
    `title` varchar(50) not null,
    `desc` varchar(500) not null,
    `hit` int not null default 0,
    `visited_date` varchar(10) not null,
    `upload_file_name` varchar(255) not null,
    `store_file_name` varchar(255) not null,
    `reg_date` timestamp not null default current_timestamp,
    `mod_date` timestamp not null default current_timestamp,
    foreign key (`member_id`) references MEMBER (`member_id`),
    foreign key (`content_id`) references ATTRACTION_INFO (`content_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 좋아요
CREATE TABLE IF NOT EXISTS `like` (
    `like_id` int primary key auto_increment,
    `member_id` int not null,
    `hot_place_id` int not null,
    foreign key (`member_id`) references MEMBER (`member_id`),
    foreign key (`hot_place_id`) references hot_place (`hot_place_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 여행 계획
CREATE TABLE IF NOT EXISTS `plan` (
    `plan_id` int primary key auto_increment,
    `member_id` int not null,
    `title` varchar(100) not null,
    `reg_date` timestamp default current_timestamp,
    `mod_date` timestamp default current_timestamp,
    foreign key (`member_id`) references MEMBER (`member_id`)
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 여행 세부 계획
CREATE TABLE IF NOT EXISTS `plan_detail` (
    `plan_detail_id` int primary key auto_increment,
    `plan_id` int not null,
    `content_id` int not null,
    foreign key (`plan_id`) references PLAN (`plan_id`)
    ON DELETE CASCADE,
    foreign key (`content_id`) references ATTRACTION_INFO (`content_id`)
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
CREATE TABLE IF NOT EXISTS `LOGIN` (
    `authentication_key` varchar(100) primary key,
    `member_id` int not null,
    foreign key (`member_id`) references MEMBER (`member_id`)
);

--attraction_info trigger 설정
DELIMITER //
CREATE TRIGGER clean_title_update
    BEFORE INSERT ON attraction_info
    FOR EACH ROW
BEGIN
    SET NEW.title = REGEXP_REPLACE(NEW.title, '\\(.*\\)', '');
    SET NEW.title = REGEXP_REPLACE(NEW.title, '\\[.*\\]', '');
END;//
DELIMITER ;