INSERT INTO mst_users (
    user_name,
    email,
    password,
    created_at,
    updated_at,
    delete_flg
) VALUES (
     '岩田長晃',
     'gantake11@gmail.com',
     'password', -- ※実際にはハッシュ化したパスワードを保存します
     CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP,
     0
);