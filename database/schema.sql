CREATE TYPE marque AS ENUM ('KIA', 'DAEWOO');
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


SELECT m.marque, m.modele, COUNT(p.id) as total_piece_auto FROM modele_voiture m left join piece_auto p on p.id_modele_voiture = m.id GROUP BY m.marque, m.modele;

SELECT 
COUNT(CASE WHEN m.marque = 'KIA' THEN p.id END) AS nbre_piece_kia, 
COUNT(CASE WHEN m.marque = 'DAEWOO' THEN p.id END) AS nbre_piece_daewoo 
FROM modele_voiture m 
LEFT JOIN piece_auto p 
on p.id_modele_voiture = m.id;

SELECT
m.marque, 
(SUM(v.id) * 100 / (SELECT SUM(id) from vente)) as pourcentage FROM modele_voiture m left join piece_auto p on m.id = p.id_modele_voiture left join vente v on v.id_piece_auto = p.id GROUP BY m.marque;


