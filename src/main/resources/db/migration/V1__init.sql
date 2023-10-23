CREATE TABLE IF NOT EXISTS juegos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    plataforma VARCHAR(50) NOT NULL,
    ano_lanzamiento INT,
    puntuacion_media FLOAT
);

CREATE TABLE IF NOT EXISTS jugadores (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    genero VARCHAR(20) NOT NULL,
    edad INT NOT NULL,
    juegos_id INT,
    FOREIGN KEY (juegos_id) REFERENCES juegos(id)
);

