INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO users (username, password) VALUES ('user1', '$2a$12$vK4ov/EaSPSem7rQrCYgyuTM/iZj.DV1HGiw0hcpvbiciNPsUtEQK'); -- Use hashed passwords in production
INSERT INTO users (username, password) VALUES ('admin', '$2a$12$q72YSDHr4uRU.Z0G5Au9muf3s.r7NAaxRFzAVxIxipWtePER.XKYO'); --  Use hashed passwords in production
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- Assuming user1 has id 1, and ROLE_USER has id 1
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- Assuming admin has id 2, and ROLE_ADMIN has id 2


INSERT INTO usuario (nombrecompleto, correo, telefono, edad) VALUES ('Juan García', 'jgarcia@example.com', '987654321', 28);
INSERT INTO usuario (nombrecompleto, correo, telefono, edad) VALUES ('María Luna', 'mluna@example.com', '912345678', 31);
INSERT INTO usuario (nombrecompleto, correo, telefono, edad) VALUES ('Carlos Paredes', 'cparedes@example.com', '998877665', 25);
INSERT INTO usuario (nombrecompleto, correo, telefono, edad) VALUES ('Ana del Rey', 'arey@example.com', '934567890', 30);
INSERT INTO usuario (nombrecompleto, correo, telefono, edad) VALUES ('Diego Pérez', 'dperez@example.com', '911122233', 27);


INSERT INTO ranking (puntos, id_usuario) VALUES (150, 1);
INSERT INTO ranking (puntos, id_usuario) VALUES (200, 2);
INSERT INTO ranking (puntos, id_usuario) VALUES (120, 3);
INSERT INTO ranking (puntos, id_usuario) VALUES (180, 4);
INSERT INTO ranking (puntos, id_usuario) VALUES (220, 5);