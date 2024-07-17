CREATE TABLE `roles` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `nombre` varchar(45) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `autos` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `nombre` varchar(45) NOT NULL,
                         `img_url` varchar(256) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuarios` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `correo` varchar(100) NOT NULL,
                            `created_at` datetime NOT NULL,
                            `nick` varchar(100) NOT NULL,
                            `nombre` varchar(100) NOT NULL,
                            `password` varchar(45) NOT NULL,
                            `peso` int NOT NULL,
                            `updated_at` datetime NOT NULL,
                            `id_auto` int DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `correo_UNIQUE` (`correo`),
                            KEY `auto_id_idx` (`id_auto`),
                            CONSTRAINT `auto_id` FOREIGN KEY (`id_auto`) REFERENCES `autos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `direcciones` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `nombre` varchar(100) DEFAULT NULL,
                               `numeracion` varchar(45) DEFAULT NULL,
                               `usuario_id` int DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               KEY `user_id_idx` (`usuario_id`),
                               CONSTRAINT `user_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `roles_usuarios` (
                                  `usuario_id` int NOT NULL,
                                  `rol_id` int NOT NULL,
                                  PRIMARY KEY (`usuario_id`),
                                  KEY `role_id_idx` (`rol_id`),
                                  CONSTRAINT `role_id` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
                                  CONSTRAINT `usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO autos (nombre,img_url)
VALUES
    ('Sin Automovil', ''),
    ('Hyundai Sonata', 'https://www.kimballstock.com/pix/car/p/05/aut-50-iz0450-01p.jpg'),
    ('Audi S7', 'https://www.kimballstock.com/pix/car/p/06/aut-51-iz0181-01p.jpg');


INSERT INTO roles (nombre)
VALUES
    ('admin'),
    ('user');

INSERT INTO usuarios (correo, created_at, nick, nombre, password, peso, updated_at,id_auto)
VALUES
    ('admin@mail.com', '2022-01-01 00:00:00', 'admin', 'admin', '1234', 30, '2022-01-01 00:00:00',1),
    ('user@mail.com', '2022-01-01 00:00:00', 'user', 'user', '1234', 42, '2022-01-01 00:00:00',1),
    ('test@mail.com', '2022-01-01 00:00:00', 'test', 'test', '1234', 50, '2022-01-01 00:00:00',1);

INSERT INTO direcciones(nombre, numeracion, usuario_id)
VALUES
    ('Calle 1', '12', 1),
    ('Calle 2', '2050', 2),
    ('Calle 3', '30A', 3);

INSERT INTO roles_usuarios (usuario_id,rol_id)
VALUES
    (1,1),
    (2,2),
    (3,2);



