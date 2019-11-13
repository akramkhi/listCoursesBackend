-- Création des structures de données

CREATE TABLE liste_de_course(
	id uuid default random_uuid() PRIMARY KEY,
	label VARCHAR(255) NOT NULL,
	status VARCHAR(50) NOT NULL,
	creation_Date TIMESTAMP NOT NULL
);

CREATE TABLE article(
	id UUID PRIMARY KEY,
	liste_De_Course_Id UUID NOT NULL,
	label VARCHAR(255) NOT NULL,
	status VARCHAR(20) NOT NULL,
	nb_Items INT DEFAULT '1' NOT NULL ,
	update_Timestamp TIMESTAMP NOT NULL,
	FOREIGN KEY (liste_De_Course_Id) REFERENCES liste_de_course(id)
);

