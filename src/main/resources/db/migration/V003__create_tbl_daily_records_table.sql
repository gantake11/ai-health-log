create table if not exists tbl_daily_records (
    `daily_records_id` int auto_increment primary key,
    `user_id` int not null,
    `date` date not null,
    `meal_time` time not null,
    `weight` decimal(4, 1) not null,
    `steps` INT UNSIGNED default 0,
    `notes` text,
    `gemini_message` text not null,
    `created_at` datetime default current_timestamp,
    `updated_at` datetime default current_timestamp on update current_timestamp,
    `delete_flg` bool default 0,
    FOREIGN KEY (user_id) REFERENCES mst_users(user_id)
);