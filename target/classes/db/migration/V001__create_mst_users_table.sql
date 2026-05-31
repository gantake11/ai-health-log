create table if not exists mst_users (
    `user_id` int auto_increment primary key,
    `user_name` varchar(30) not null,
    `email` varchar(255) not null,
    `password` varchar(255) not null,
    `created_at` datetime default current_timestamp,
    `updated_at` datetime default current_timestamp on update current_timestamp,
    `delete_flg` bool default 0
);