
CREATE TABLE car (id text UNIQUE ,car_brand VARCHAR(50) NOT NULL, car_model VARCHAR(50) NOT NULL, the_cost_of_a_car INT NOT NULL);

CREATE TABLE people (id_people INT UNIQUE ,name_People VARCHAR(50) NOT NULL PRIMARY KEY, age_People INT NOT NULL, auto_right BOOLEAN NOT NULL,id_car text REFERENCES car (id) );


