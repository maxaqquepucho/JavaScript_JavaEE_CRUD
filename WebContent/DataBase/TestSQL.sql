
INSERT INTO `personas` (`codigo`, `nombre`, `apellido`, `correo`, `celular`,
                        `tipoUsusario`, `sexo`, `contrasenia`)
VALUES (NULL, 'Juan', 'Dante Umac', 'juan@gmail.com', '96655632', 'admin', 'M', '123456');


INSERT INTO personas (nombre, apellido, correo, celular,
            tipoUsusario, sexo, contrasenia)
            VALUES ( ?, ?, ?, ?, ?, ?, ?);

UPDATE personas SET nombre = ?, apellido = ?, correo = ?, celular = ?,
                    tipoUsusario = ?, sexo = ?, contrasenia = ?
                    WHERE codigo = ?
