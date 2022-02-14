-- USERS
DROP TABLE IF EXISTS `user_bsierra1`;
CREATE TABLE `user_bsierra1` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(50) NOT NULL,
    `email` varchar(100) NOT NULL UNIQUE,
    `password_hash` varchar(64) NOT NULL,
    `created_at` timestamp,
    PRIMARY KEY (`id`)
);

create UNIQUE INDEX `user_email_unique` on user_bsierra1(email);

-- SECTION
DROP TABLE IF EXISTS `section_bsierra1`;
CREATE TABLE `section_bsierra1` (
                                    `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                    `section_name` varchar(50) NOT NULL,
                                    `color` varchar(50) NOT NULL ,
                                    `modified_at` timestamp,
                                    `created_at` timestamp,
                                    PRIMARY KEY (`id`)
);

create UNIQUE INDEX `section_name_unique` on section_bsierra1(section_name);


-- NOTE

DROP TABLE IF EXISTS `note_bsierra1`;
CREATE TABLE `note_bsierra1` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `section_id` bigint(20) NOT NULL,
                                 `first_name` varchar(50) NOT NULL,
                                 `title` varchar(100) NOT NULL,
                                 `content` text,
                                 `archived` int,
                                 `modified_at` timestamp,
                                 `created_at` timestamp,
                                 PRIMARY KEY (`id`),
                                 FOREIGN KEY (`section_id`) REFERENCES section_bsierra1(id)
);

create UNIQUE INDEX `note_title_unique` on note_bsierra1(title);

-- ROLE

DROP TABLE IF EXISTS `role_bsierra1`;
CREATE TABLE `role_bsierra1` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `role_name` varchar(50) NOT NULL,
                                 PRIMARY KEY (`id`)
);

create UNIQUE INDEX `role_name_unique` on role_bsierra1(role_name);

-- SHARED NOTE

DROP TABLE IF EXISTS `sharednote_bsierra1`;
CREATE TABLE `sharednote_bsierra1` (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                       `user_id` bigint(20) NOT NULL,
                                       `note_id` bigint(20) NOT NULL,
                                       `role_id` varchar(50) NOT NULL,
                                       `modified_at` timestamp,
                                       `created_at` timestamp,
                                       PRIMARY KEY (`id`),
                                       FOREIGN KEY (`user_id`) REFERENCES user_bsierra1(id),
                                       FOREIGN KEY (`note_id`) REFERENCES section_bsierra1(id),
                                       FOREIGN KEY (`role_id`) REFERENCES role_bsierra1(id)
);

create UNIQUE INDEX `shared_note_id_unique` on sharednote_bsierra1(id);
