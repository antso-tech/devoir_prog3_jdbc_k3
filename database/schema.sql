CREATE TYPE marque AS ENUM ('KIA', 'HYUNDAI', 'DAEWOO');
CREATE TYPE modele AS ENUM ('SPORTAGE', 'SORENTO', 'WINDSTORM');

CREATE TABLE Modele_voiture (
    id serial PRIMARY KEY,
    marque marque not null,
    modele modele not null
);

CREATE TABLE Piece_auto (
    id SERIAL PRIMARY KEY,
    id_modele_voiture int,
    numero_serie VARCHAR(255) UNIQUE NOT NULL,
    CONSTRAINT fk_piece_auto FOREIGN KEY (id_modele_voiture) REFERENCES Modele_voiture(id)
);

CREATE TABLE Vente(
    id SERIAL PRIMARY KEY,
    id_piece_auto int,
    quantite NUMERIC(5,2),
    date DATE NOT NULL,
    CONSTRAINT fk_piece_auto FOREIGN KEY (id_piece_auto) REFERENCES Piece_auto(id)
);


