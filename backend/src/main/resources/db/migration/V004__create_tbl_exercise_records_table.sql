create table if not exists tbl_exercise_records (
    `exercise_records_id` int auto_increment primary key,
    `daily_records_id` int not null,
    `exercise_menu_id` int not null,
    `details` text not null,
    `start_time` time not null,
    `end_time` time not null,
    `created_at` datetime default current_timestamp,
    `updated_at` datetime default current_timestamp on update current_timestamp,
    `delete_flg` bool default 0,
    FOREIGN KEY (daily_records_id) REFERENCES tbl_daily_records(daily_records_id),
    FOREIGN KEY (exercise_menu_id) REFERENCES mst_exercise_menu(exercise_menu_id)
);