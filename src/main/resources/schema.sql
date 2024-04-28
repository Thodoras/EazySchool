CREATE TABLE IF NOT EXISTS `contacts` (
    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `mobile_num` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `subject` VARCHAR(100) NOT NULL,
    `message` VARCHAR(500) NOT NULL,
    `status` VARCHAR(10) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS `holidays` (
    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `day` VARCHAR(20) NOT NULL,
    `reason` VARCHAR(100) NOT NULL,
    `type` VARCHAR(20) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NOT NULL
);