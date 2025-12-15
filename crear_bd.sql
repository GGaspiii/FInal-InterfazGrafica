
CREATE DATABASE IF NOT EXISTS juego_batallas;
USE juego_batallas;

CREATE TABLE IF NOT EXISTS personajes (
    id_personaje INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apodo VARCHAR(50) NOT NULL UNIQUE,
    tipo ENUM('Heroe', 'Villano') NOT NULL,
    vida_final INT DEFAULT 0,
    ataque INT DEFAULT 0,
    defensa INT DEFAULT 0,
    victorias INT DEFAULT 0,
    derrotas INT DEFAULT 0,
    supremos_usados INT DEFAULT 0,
    armas_invocadas INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS batallas (
    id_batalla INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    heroe_id INT NOT NULL,
    villano_id INT NOT NULL,
    ganador_id INT NULL,
    turnos INT DEFAULT 0,
    FOREIGN KEY (heroe_id) REFERENCES personajes(id_personaje)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (villano_id) REFERENCES personajes(id_personaje)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ganador_id) REFERENCES personajes(id_personaje)
        ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS estado_partida (
    id_estado INT AUTO_INCREMENT PRIMARY KEY,
    id_batalla INT,
    fecha_guardado DATETIME DEFAULT CURRENT_TIMESTAMP,
    heroe_id INT NOT NULL,
    villano_id INT NOT NULL,
    vida_heroe INT DEFAULT 0,
    vida_villano INT DEFAULT 0,
    bendicion_heroe INT DEFAULT 0,
    bendicion_villano INT DEFAULT 0,
    ataque_heroe INT DEFAULT 0,
    defensa_heroe INT DEFAULT 0,
    ataque_villano INT DEFAULT 0,
    defensa_villano INT DEFAULT 0,
    turno_actual INT DEFAULT 1,
    finalizada BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_batalla) REFERENCES batallas(id_batalla)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (heroe_id) REFERENCES personajes(id_personaje)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (villano_id) REFERENCES personajes(id_personaje)
        ON DELETE CASCADE ON UPDATE CASCADE
);

