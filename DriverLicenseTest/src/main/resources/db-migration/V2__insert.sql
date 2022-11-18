insert into roles (id, descriptions, role_name)
values (1,'Contestant','ROLE_CONTTESTANT'),
       (2,'Admin','ROLE_ADMIN');

insert into users (id, username, first_name, is_enabled, last_name, password, role_id)
values  (1, 'john', 'John', true, 'Mitch', '$2a$12$o6sEeP6t3o5pX..zjVy34OZ1vETJZck2e.xQKt/baJ0JPzZXnFQp.', 1),
        (2, 'rachael', 'Rachael', true, 'Alex', '$2a$12$o6sEeP6t3o5pX..zjVy34OZ1vETJZck2e.xQKt/baJ0JPzZXnFQp.', 1),
        (3, 'can', 'Can', true, ' Win', '$2a$12$o6sEeP6t3o5pX..zjVy34OZ1vETJZck2e.xQKt/baJ0JPzZXnFQp.', 2);

insert into levels(id, level_name, descriptions)
values (1, 'A1', 'Hạng A1'),
		(2, 'A2', 'Hạng A2');

insert into questions (id, question_name, level_id, type)
values (1, 'Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?', 1, false),
       (2, '“Làn đường” là gì?', 1, true),
       (3, 'Trong các khái niệm dưới đây, “dải phân cách” được hiểu như thế nào là đúng?', 1, false),
       (4, '“Dải phân cách” trên đường bộ gồm những loại nào?', 1, true),
       (5, 'Người lái xe được hiểu như thế nào trong các khái niệm dưới đây?', 1, false),
       (6, 'Đường mà trên đó phương tiện tham gia giao thông được các phương tiện giao thông đến từ các hướng khác nhường đường khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên là loại đường gì?', 1, false),
       (7, 'Khái niệm “phương tiện giao thông cơ giới đường bộ” được hiểu như thế nào là đúng?', 1, true),
       (8, 'Khái niệm “phương tiện giao thông thô sơ đường bộ” được hiểu như thế nào là đúng?', 1, false),
       (9, '“Phương tiện tham gia giao thông đường bộ” gồm những loại nào?', 1, true),
       (10, '“Người tham gia giao thông đường bộ” gồm những đối tượng nào?', 1, false),
       (11, '“Người điều khiển phương tiện tham gia giao thông đường bộ” gồm những đối tượng nào dưới đây?', 1, true);

insert into answers (id, question_id, name)
values (1, 1, 'Phần mặt đường và lề đường.'),
		(2, 1, 'Phần đường xe chạy.'),
        (3, 1, 'Phần đường xe cơ giới.'),
        (4, 2, 'Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.'),
        (5, 2, 'Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.'),
        (6, 2, 'Là đường cho xe ô tô chạy, dừng, đỗ an toàn.'),
        (7, 3, 'Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép.'),
        (8, 3, 'Là bộ phận của đường để phân tách phần đường xe chạy và hành lang an toàn giao thông.'),
        (9, 3, 'Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.'),
        (10, 4, 'Dải phân cách gồm loại cố định và loại di động.'),
        (11, 4, 'Dải phân cách gồm tường chống ồn, hộ lan cứng và hộ lan mềm.'),
        (12, 4, 'Dải phân cách gồm giá long môn và biển báo hiệu đường bộ.'),
        (13, 5, 'Là người điều khiển xe cơ giới.'),
        (14, 5, 'Là người điều khiển xe thô sơ.'),
        (15, 5, 'Là người điều khiển xe có súc vật kéo.'),
        (16, 6, 'Đường không ưu tiên.'),
        (17, 6, 'Đường tỉnh lộ.'),
        (18, 6, 'Đường quốc lộ.'),
        (19, 6, 'Đường ưu tiên.'),
        (20, 7, 'Gồm xe ô tô; máy kéo; xe mô tô hai bánh; xe mô tô ba bánh; xe gắn máy; xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng.'),
        (21, 7, 'Gồm ô tô; máy kéo; rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo; xe mô tô hai bánh; xe mô tô ba bánh, xe gắn máy (kể cả xe máy điện) và các loại xe tương tự.'),
        (22, 8, 'Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe xích lô, xe lăn dùng cho người khuyết tật, xe súc vật kéo và các loại xe tương tự.'),
        (23, 8, 'Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe gắn máy, xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng.'),
        (24, 8, 'Gồm xe ô tô, máy kéo, rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo.'),
        (25, 9, 'Phương tiện giao thông cơ giới đường bộ.'),
        (26, 9, 'Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.'),
        (27, 9, 'Cả ý 1 và ý 2.'),
        (28, 10, 'Người điều khiển, người sử dụng phương tiện tham gia giao thông đường bộ.'),
        (29, 10, 'Người điều khiển, dẫn dắt súc vật; người đi bộ trên đường bộ.'),
        (30, 10, 'Cả ý 1 và ý 2.'),
        (31, 11, 'Người điều khiển xe cơ giới, người điều khiển xe thô sơ.'),
        (32, 11, 'Người điều khiển xe máy chuyên dùng tham gia giao thông đường bộ.'),
        (33, 11, 'Cả ý 1 và ý 2.');