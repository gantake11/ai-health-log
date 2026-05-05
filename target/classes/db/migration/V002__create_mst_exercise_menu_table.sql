create table if not exists mst_users (
    `exercise_menu_id` int auto_increment primary key,
    `exercise_menu_name` varchar(30) not null,
    `created_at` datetime default current_timestamp,
    `updated_at` datetime default current_timestamp on update current_timestamp,
    `delete_flg` bool default 0
)